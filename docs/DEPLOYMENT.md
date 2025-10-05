# Deployment Guide

## 🚀 Enterprise Deployment Guide

### Overview

This guide provides comprehensive instructions for deploying the LeetCode75 repository in enterprise environments with production-ready standards.

### Prerequisites

#### System Requirements

- **Java**: OpenJDK 17 or higher
- **Memory**: 4GB RAM minimum, 8GB recommended
- **Storage**: 10GB free space
- **Network**: Internet connectivity for dependency resolution
- **OS**: Linux, macOS, or Windows

#### Software Dependencies

- **Git**: 2.30+ for version control
- **Gradle**: 8.5+ (included via wrapper)
- **Docker**: 20.10+ (optional, for containerized deployment)
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code

### Deployment Strategies

#### 1. Local Development Deployment

**Quick Start**

```bash
# Clone repository
git clone https://github.com/shawjitesh/LeetCode75.git
cd LeetCode75

# Make gradlew executable
chmod +x gradlew

# Build project
./gradlew build

# Run tests
./gradlew test

# Generate documentation
./gradlew javadoc
```

**Environment Setup**

```bash
# Set Java environment
export JAVA_HOME=/path/to/java17
export PATH=$JAVA_HOME/bin:$PATH

# Verify installation
java -version
./gradlew --version
```

#### 2. CI/CD Pipeline Deployment

**GitHub Actions Configuration**

The repository includes enterprise-grade CI/CD pipelines:

- **Quality Gates**: Automated code quality checks
- **Security Scanning**: Vulnerability and secret detection
- **Testing**: Comprehensive test execution
- **Documentation**: Automated documentation generation

**Pipeline Triggers**

- **Push Events**: Automatic on main/develop branches
- **Pull Requests**: Quality and security validation
- **Scheduled**: Daily security and health checks
- **Manual**: On-demand deployment triggers

#### 3. Containerized Deployment

**Docker Configuration**

```dockerfile
# Dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app
COPY . .

# Install dependencies
RUN ./gradlew build -x test

# Expose port
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8080/health || exit 1

# Run application
CMD ["./gradlew", "run"]
```

**Docker Compose**

```yaml
# docker-compose.yml
version: '3.8'

services:
  leetcode75:
    build: .
    ports:
      - "8080:8080"
    environment:
      - JAVA_OPTS=-Xmx2g -Xms1g
    volumes:
      - ./logs:/app/logs
    restart: unless-stopped
    
  monitoring:
    image: prom/prometheus
    ports:
      - "9090:9090"
    volumes:
      - ./monitoring/prometheus.yml:/etc/prometheus/prometheus.yml
```

#### 4. Enterprise Server Deployment

**Production Environment Setup**

```bash
# Create application user
sudo useradd -m -s /bin/bash leetcode75
sudo usermod -aG docker leetcode75

# Create application directory
sudo mkdir -p /opt/leetcode75
sudo chown leetcode75:leetcode75 /opt/leetcode75

# Deploy application
cd /opt/leetcode75
git clone https://github.com/shawjitesh/LeetCode75.git .
chmod +x gradlew
./gradlew build
```

**Systemd Service Configuration**

```ini
# /etc/systemd/system/leetcode75.service
[Unit]
Description=LeetCode75 Enterprise Application
After=network.target

[Service]
Type=simple
User=leetcode75
Group=leetcode75
WorkingDirectory=/opt/leetcode75
ExecStart=/opt/leetcode75/gradlew run
ExecReload=/bin/kill -HUP $MAINPID
Restart=always
RestartSec=10

[Install]
WantedBy=multi-user.target
```

### Environment Configuration

#### Development Environment

```properties
# application-dev.properties
spring.profiles.active=dev
logging.level.com.shawjitesh=DEBUG
management.endpoints.web.exposure.include=*
```

#### Staging Environment

```properties
# application-staging.properties
spring.profiles.active=staging
logging.level.com.shawjitesh=INFO
management.endpoints.web.exposure.include=health,info,metrics
```

#### Production Environment

```properties
# application-prod.properties
spring.profiles.active=prod
logging.level.com.shawjitesh=WARN
management.endpoints.web.exposure.include=health
security.require-ssl=true
```

### Security Configuration

#### SSL/TLS Setup

```yaml
# security.yml
server:
  ssl:
    enabled: true
    key-store: classpath:keystore.p12
    key-store-password: ${SSL_KEYSTORE_PASSWORD}
    key-store-type: PKCS12
    key-alias: leetcode75
```

#### Authentication Configuration

```yaml
# auth.yml
security:
  oauth2:
    client:
      registration:
        github:
          client-id: ${GITHUB_CLIENT_ID}
          client-secret: ${GITHUB_CLIENT_SECRET}
          scope: read:user,user:email
```

### Monitoring and Observability

#### Health Checks

```java
@Component
public class HealthIndicator implements HealthIndicator {
    
    @Override
    public Health health() {
        // Custom health check logic
        return Health.up()
            .withDetail("database", "UP")
            .withDetail("cache", "UP")
            .build();
    }
}
```

#### Metrics Configuration

```yaml
# metrics.yml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
  metrics:
    export:
      prometheus:
        enabled: true
```

### Database Configuration

#### H2 Database (Development)

```yaml
# application-dev.yml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password: 
  h2:
    console:
      enabled: true
```

#### PostgreSQL (Production)

```yaml
# application-prod.yml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/leetcode75
    driver-class-name: org.postgresql.Driver
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```

### Backup and Recovery

#### Database Backup

```bash
#!/bin/bash
# backup.sh
DATE=$(date +%Y%m%d_%H%M%S)
BACKUP_DIR="/opt/backups/leetcode75"
DB_NAME="leetcode75"

mkdir -p $BACKUP_DIR

# Database backup
pg_dump -h localhost -U $DB_USERNAME $DB_NAME > $BACKUP_DIR/db_backup_$DATE.sql

# Application backup
tar -czf $BACKUP_DIR/app_backup_$DATE.tar.gz /opt/leetcode75

# Cleanup old backups (keep last 30 days)
find $BACKUP_DIR -name "*.sql" -mtime +30 -delete
find $BACKUP_DIR -name "*.tar.gz" -mtime +30 -delete
```

#### Recovery Procedures

```bash
#!/bin/bash
# recovery.sh
BACKUP_FILE=$1
DB_NAME="leetcode75"

if [ -z "$BACKUP_FILE" ]; then
    echo "Usage: $0 <backup_file>"
    exit 1
fi

# Stop application
systemctl stop leetcode75

# Restore database
psql -h localhost -U $DB_USERNAME $DB_NAME < $BACKUP_FILE

# Restore application
tar -xzf $BACKUP_FILE -C /

# Start application
systemctl start leetcode75
```

### Performance Optimization

#### JVM Tuning

```bash
# JVM options for production
export JAVA_OPTS="-Xms2g -Xmx4g -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:+UseStringDeduplication"
```

#### Application Tuning

```yaml
# application.yml
server:
  tomcat:
    threads:
      max: 200
      min-spare: 10
    connection-timeout: 20000
    max-connections: 8192
```

### Troubleshooting

#### Common Issues

1. **Build Failures**
   ```bash
   # Clean and rebuild
   ./gradlew clean build
   
   # Check Java version
   java -version
   ./gradlew --version
   ```

2. **Memory Issues**
   ```bash
   # Increase heap size
   export GRADLE_OPTS="-Xmx4g"
   ./gradlew build
   ```

3. **Network Issues**
   ```bash
   # Check connectivity
   curl -I https://github.com
   ping maven.org
   ```

#### Log Analysis

```bash
# Application logs
tail -f /opt/leetcode75/logs/application.log

# System logs
journalctl -u leetcode75 -f

# Error analysis
grep -i error /opt/leetcode75/logs/application.log | tail -20
```

### Maintenance Procedures

#### Regular Maintenance

1. **Daily Tasks**
   - Monitor system health
   - Check log files
   - Verify backups

2. **Weekly Tasks**
   - Update dependencies
   - Review security alerts
   - Performance analysis

3. **Monthly Tasks**
   - Security audit
   - Capacity planning
   - Documentation review

#### Update Procedures

```bash
# Update application
cd /opt/leetcode75
git pull origin main
./gradlew build
systemctl restart leetcode75

# Rollback procedure
git checkout <previous-commit>
./gradlew build
systemctl restart leetcode75
```

### Disaster Recovery

#### Recovery Time Objectives

- **RTO (Recovery Time Objective)**: 4 hours
- **RPO (Recovery Point Objective)**: 1 hour
- **Availability Target**: 99.9%

#### Recovery Procedures

1. **Data Recovery**
   - Restore from latest backup
   - Verify data integrity
   - Test application functionality

2. **Infrastructure Recovery**
   - Provision new environment
   - Deploy application
   - Restore configuration

3. **Service Recovery**
   - Update DNS records
   - Verify service health
   - Monitor for issues

---

*This deployment guide is part of the enterprise-grade documentation and should be reviewed regularly for updates.*
