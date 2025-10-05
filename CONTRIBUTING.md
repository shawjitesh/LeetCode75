# Contributing to LeetCode 75 Solutions

Thank you for your interest in contributing to this LeetCode 75 solutions repository! 🎉

This repository contains solutions to the popular LeetCode 75 study plan problems, implemented in Java with comprehensive documentation and analysis.

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [How to Contribute](#how-to-contribute)
- [Contribution Guidelines](#contribution-guidelines)
- [Solution Standards](#solution-standards)
- [Testing Guidelines](#testing-guidelines)
- [Documentation Standards](#documentation-standards)
- [Pull Request Process](#pull-request-process)
- [Issue Guidelines](#issue-guidelines)

## 📜 Code of Conduct

This project and everyone participating in it is governed by our [Code of Conduct](CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code. Please report unacceptable behavior to [your-email@example.com].

## 🚀 Getting Started

### Prerequisites

- **Java 8 or higher** installed on your system
- **Git** for version control
- **IDE** of your choice (IntelliJ IDEA, Eclipse, VS Code, etc.)
- Basic understanding of Java programming
- Familiarity with data structures and algorithms

### Setting Up Your Development Environment

1. **Fork the Repository**
   ```bash
   # Click the "Fork" button on GitHub, then clone your fork
   git clone https://github.com/YOUR_USERNAME/LeetCode75.git
   cd LeetCode75
   ```

2. **Add Upstream Remote**
   ```bash
   git remote add upstream https://github.com/shawjitesh/LeetCode75.git
   ```

3. **Create a Feature Branch**
   ```bash
   git checkout -b feature/your-feature-name
   # or
   git checkout -b fix/your-bug-fix
   ```

## 🤝 How to Contribute

### Types of Contributions

We welcome several types of contributions:

1. **New Solutions** - Add solutions to problems not yet covered
2. **Solution Improvements** - Optimize existing solutions or add alternative approaches
3. **Documentation** - Improve README, add comments, or enhance explanations
4. **Bug Fixes** - Fix errors in existing solutions
5. **Code Quality** - Refactor code, improve style, or add better error handling
6. **Testing** - Add test cases or improve existing ones

### Contribution Areas

#### 🎯 Priority Areas

- **Tree Problems** - Binary Tree DFS, Tree traversals
- **Graph Algorithms** - DFS, BFS, shortest path algorithms
- **Dynamic Programming** - Memoization, tabulation approaches
- **Binary Search** - Search algorithms and variations
- **Backtracking** - Recursive problem-solving approaches

#### 📚 Current Coverage

✅ **Array & String** - Complete  
✅ **Two Pointers** - Complete  
✅ **Sliding Window** - Complete  
✅ **Prefix Sum** - Complete  
✅ **HashMap/Set** - Complete  
✅ **Stack** - Complete  
✅ **Queue** - Complete  
✅ **LinkedList** - Complete  
🔄 **Binary Tree DFS** - In Progress  
❌ **Tree** - Needed  
❌ **Graph** - Needed  
❌ **Dynamic Programming** - Needed  
❌ **Binary Search** - Needed  
❌ **Backtracking** - Needed  

## 📝 Contribution Guidelines

### Solution Standards

#### 1. **File Organization**
```
Category/
├── ProblemName.java
├── AlternativeApproach.java (if applicable)
└── SharedClasses/
    ├── ListNode.java (for LinkedList problems)
    └── TreeNode.java (for Tree problems)
```

#### 2. **Class Structure**
```java
/**
 * Problem: [Problem Title]
 * Difficulty: Easy/Medium/Hard
 * 
 * Description:
 * [Brief problem description]
 * 
 * Approach:
 * [Algorithm approach explanation]
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * @author Your Name
 * @version 1.0
 */
public class ProblemName {
    
    /**
     * Main solution method
     * 
     * @param input Description of input parameter
     * @return Description of return value
     */
    public ReturnType solutionMethod(InputType input) {
        // Implementation here
    }
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        // Test cases here
    }
}
```

#### 3. **Code Quality Standards**

**✅ Required:**
- Clean, readable code with meaningful variable names
- Comprehensive Javadoc comments for all public methods
- Time and space complexity analysis
- Multiple test cases in main method
- Proper error handling and input validation
- Consistent indentation (4 spaces)

**✅ Preferred:**
- Multiple solution approaches when applicable
- Modern Java features (Streams, Optional, etc.)
- Functional programming approaches where appropriate
- Detailed algorithm explanations in comments

**❌ Avoid:**
- Hardcoded test values without explanation
- Unnecessary complexity or over-engineering
- Poor variable naming (a, b, temp, etc.)
- Missing or inadequate documentation
- Debugging code left in final solution

#### 4. **Example Solution Template**

```java
/**
 * Problem: Two Sum
 * Difficulty: Easy
 * 
 * Description:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * 
 * Approach:
 * Use HashMap to store number-to-index mappings. For each number, check if complement exists.
 * 
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - HashMap storage
 * 
 * @author Your Name
 * @version 1.0
 */
public class TwoSum {
    
    /**
     * Find two numbers that add up to target
     * 
     * @param nums Array of integers
     * @param target Target sum
     * @return Array containing indices of the two numbers
     * @throws IllegalArgumentException if no solution exists
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Input array must have at least 2 elements");
        }
        
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }
            
            numToIndex.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No solution found");
    }
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        
        // Test Case 1: Basic example
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Test 1: " + Arrays.toString(result1)); // Expected: [0, 1]
        
        // Test Case 2: Edge case with duplicate numbers
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Test 2: " + Arrays.toString(result2)); // Expected: [1, 2]
        
        // Test Case 3: Edge case with negative numbers
        int[] nums3 = {-1, -2, -3, -4, -5};
        int target3 = -8;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Test 3: " + Arrays.toString(result3)); // Expected: [2, 4]
    }
}
```

### Testing Guidelines

#### 1. **Test Case Requirements**
- **At least 3 test cases** per solution
- **Edge cases** (empty arrays, single elements, etc.)
- **Boundary conditions** (maximum values, minimum values)
- **Normal cases** (typical inputs)
- **Clear expected outputs** with comments

#### 2. **Test Case Format**
```java
// Test Case 1: Basic functionality
// Input: [description]
// Expected: [expected output]
// Actual: [actual output]

// Test Case 2: Edge case
// Input: [description]
// Expected: [expected output]
// Actual: [actual output]
```

### Documentation Standards

#### 1. **README Updates**
When adding new solutions, update the README.md:
- Add solution to appropriate category
- Update solution count
- Add brief description
- Update compilation instructions if needed

#### 2. **Comment Standards**
```java
/**
 * Brief description of what the method does
 * 
 * @param paramName Description of parameter
 * @return Description of return value
 * @throws ExceptionType When this exception is thrown
 */
```

#### 3. **Algorithm Explanations**
Include detailed explanations for:
- Algorithm approach and reasoning
- Why this approach is optimal
- Alternative approaches considered
- Trade-offs between time and space complexity

## 🔄 Pull Request Process

### Before Submitting

1. **Check Existing Issues**
   - Look for existing issues or PRs for the same problem
   - Comment on existing issues if you're working on them

2. **Ensure Code Quality**
   - Run your solution locally to ensure it compiles and runs
   - Test all edge cases
   - Verify time/space complexity analysis
   - Check code style consistency

3. **Update Documentation**
   - Update README.md if adding new solutions
   - Add/update Javadoc comments
   - Ensure all test cases are documented

### PR Submission

1. **Create Pull Request**
   ```bash
   git push origin feature/your-feature-name
   ```
   Then create a PR on GitHub with the provided template.

2. **PR Title Format**
   ```
   Add [Problem Name] solution with [approach] approach
   Fix [Issue Description] in [Problem Name]
   Update [Component] for [Reason]
   ```

3. **PR Description**
   - Use the provided PR template
   - Describe what changes were made
   - Explain the approach used
   - Include test results
   - Reference related issues

### Review Process

1. **Automated Checks**
   - Code compilation
   - Test case execution
   - Documentation completeness

2. **Manual Review**
   - Code quality and style
   - Algorithm correctness
   - Documentation quality
   - Test case coverage

3. **Feedback**
   - Address review comments promptly
   - Make requested changes
   - Respond to questions

## 🐛 Issue Guidelines

### Creating Issues

#### Bug Reports
```
**Bug Description:**
[Clear description of the bug]

**Steps to Reproduce:**
1. [Step 1]
2. [Step 2]
3. [Step 3]

**Expected Behavior:**
[What should happen]

**Actual Behavior:**
[What actually happens]

**Environment:**
- Java Version: [version]
- OS: [operating system]
- IDE: [if applicable]
```

#### Feature Requests
```
**Feature Description:**
[Clear description of the requested feature]

**Problem it Solves:**
[Why this feature is needed]

**Proposed Solution:**
[How you think this should be implemented]

**Alternatives Considered:**
[Other approaches you've considered]
```

#### Solution Requests
```
**Problem Title:**
[LeetCode problem title]

**Problem Link:**
[Link to LeetCode problem]

**Difficulty:**
[Easy/Medium/Hard]

**Category:**
[Array, Tree, Graph, etc.]

**Approach Preference:**
[Any specific approach you'd like to see]
```

### Issue Labels

- `bug` - Something isn't working
- `enhancement` - New feature or request
- `documentation` - Improvements to documentation
- `good first issue` - Good for newcomers
- `help wanted` - Extra attention is needed
- `question` - Further information is requested

## 🏆 Recognition

### Contributors

We recognize all contributors in several ways:

1. **GitHub Contributors** - Listed in the repository contributors
2. **README Credits** - Notable contributions mentioned in README
3. **Commit History** - Preserved in git history
4. **Pull Request Recognition** - Acknowledged in merged PRs

### Contribution Levels

- **🥉 Bronze** - 1-2 solutions or significant documentation improvements
- **🥈 Silver** - 3-5 solutions or major feature additions
- **🥇 Gold** - 6+ solutions or substantial project contributions
- **💎 Diamond** - Major architectural improvements or new categories

## 📚 Resources

### Learning Materials

- [LeetCode 75 Study Plan](https://leetcode.com/studyplan/leetcode-75/)
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Algorithm Visualization](https://visualgo.net/)
- [Big O Cheat Sheet](https://www.bigocheatsheet.com/)

### Development Tools

- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [VS Code](https://code.visualstudio.com/)
- [Eclipse](https://www.eclipse.org/)
- [Git](https://git-scm.com/)

### Code Style

- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [Oracle Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)

## ❓ Questions?

### Getting Help

1. **Check Existing Issues** - Your question might already be answered
2. **Create an Issue** - Use the "question" label for help requests
3. **Join Discussions** - Use GitHub Discussions for general questions
4. **Email** - Contact maintainers directly for urgent issues

### Common Questions

**Q: Can I contribute solutions in languages other than Java?**  
A: Currently, we focus on Java solutions. However, we welcome documentation improvements and may consider other languages in the future.

**Q: How do I know if a problem is already solved?**  
A: Check the README.md file and browse the repository structure. Each category lists the problems that have been solved.

**Q: What if my solution is different from the existing one?**  
A: We welcome alternative approaches! Create a new file with a descriptive name (e.g., `ProblemName_Alternative.java`) and explain the differences.

**Q: How detailed should my algorithm explanation be?**  
A: Aim for clarity that helps other developers understand your approach. Include the key insights and reasoning behind your solution.

## 🎯 Getting Started Checklist

- [ ] Read and understand this contributing guide
- [ ] Read the [Code of Conduct](CODE_OF_CONDUCT.md)
- [ ] Fork the repository
- [ ] Set up your development environment
- [ ] Look for issues labeled "good first issue"
- [ ] Choose a problem to solve or improvement to make
- [ ] Create a feature branch
- [ ] Implement your solution following the guidelines
- [ ] Test your solution thoroughly
- [ ] Update documentation as needed
- [ ] Create a pull request
- [ ] Respond to review feedback

## 🙏 Thank You

Thank you for contributing to this project! Your contributions help make this repository a valuable resource for developers learning algorithms and data structures.

Every contribution, no matter how small, makes a difference. Whether you're fixing a typo, adding a new solution, or improving documentation, your efforts are appreciated.

---

**Happy Coding! 🚀**

*Last Updated: December 2024*  
*Version: 1.0*
