# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Project Overview

This is a Java-based LeetCode 75 solutions repository containing well-structured implementations of the LeetCode 75 study plan problems. The codebase emphasizes clean code, modern Java features (especially Streams), and comprehensive documentation with time/space complexity analysis.

## Architecture & Structure

### Package Organization
- **Array.String/**: Array and string manipulation problems (9 solutions)
- **TwoPointers/**: Two-pointer technique problems (4 solutions)
- **SlidingWindow/**: Sliding window problems (4 solutions)
- **PrefixSum/**: Prefix sum problems (2 solutions)
- **HashMap.Set/**: Hash map and set problems (4 solutions)
- **Stack/**: Stack-based problems (3 solutions)
- **Queue/**: Queue-based problems (2 solutions)
- **LinkedList/**: Linked list problems (4 solutions)
- **BinarySearchTree/**: BST problems (2 solutions)
- **BinaryTree.DFS/**: Binary tree DFS problems (6 solutions)
- **BinaryTree.BFS/**: Binary tree BFS problems (2 solutions)
- **Graphs.DFS/**: Graph DFS problems (4 solutions)
- **Graphs.BFS/**: Graph BFS problems (2 solutions)
- **BinarySearch/**: Binary search problems (4 solutions)
- **Heap.PriorityQueue/**: Heap/priority queue problems (4 solutions)
- **Backtracking/**: Backtracking problems (2 solutions)
- **DP.OneDimensional/**: One-dimensional DP problems (4 solutions)
- **DP.MultiDimensional/**: Multi-dimensional DP problems (1 solution)

### Code Patterns
- Each solution is a standalone class with package declaration
- Main method included for testing with example inputs
- Extensive Javadoc comments with problem description, approach, and complexity analysis
- Modern Java features preferred (Streams, functional programming where applicable)
- Helper methods extracted for readability (e.g., `swap()` method)

## Common Development Commands

### Running Individual Solutions
```bash
# Using Maven (recommended)
# From the project root directory
mvn exec:java -Dexec.mainClass="Array.String.MergeStringsAlternately"

# Or compile and run directly (from root directory)
javac Array/String/MergeStringsAlternately.java && java -cp . Array.String.MergeStringsAlternately

# Or navigate to specific directory first
cd Array/String/
javac MergeStringsAlternately.java && java MergeStringsAlternately
```

### Running Multiple Solutions
```bash
# Using Maven (recommended) - Compile all solutions
mvn clean compile

# Run specific solutions using Maven
mvn exec:java -Dexec.mainClass="Array.String.GreatestCommonDivisorOfStrings"
mvn exec:java -Dexec.mainClass="TwoPointers.MoveZeroes"
mvn exec:java -Dexec.mainClass="DP.MultiDimensional.UniquePaths"

# Or compile and run using Java compiler
javac Array/String/*.java
javac TwoPointers/*.java

# Run specific solution from root
java -cp . Array.String.GreatestCommonDivisorOfStrings
java -cp . TwoPointers.MoveZeroes
```

### Development Workflow
```bash
# Check Java version (requires Java 8+)
java -version
javac -version

# Quick compile and test pattern
cd [CategoryDirectory]
javac [ClassName].java && java [ClassName]
```

## IDE Integration

### VS Code
- The project includes pre-configured launch configurations for all existing solutions
- Each solution can be run directly from VS Code with F5
- "Current File" configuration allows running any Java file
- Maven integration available via the Maven extension

### IntelliJ IDEA
- Open the project and Maven will automatically configure the build path
- Run any solution by right-clicking the class file and selecting "Run 'ClassName.main()'"
- Maven tool window provides easy access to compile and run commands

## Solution Implementation Guidelines

### Code Structure
- Package declaration matching directory structure
- Class name matches filename
- Public method containing the actual algorithm
- Main method with test cases
- Helper methods as private when appropriate

### Documentation Standards
- Comprehensive Javadoc for all public methods
- Include problem description, approach explanation
- Document time and space complexity
- Note any special optimizations or modern Java features used

### Java Feature Usage
- Prefer Java Streams for functional programming approach where appropriate
- Use modern collection operations
- Implement efficient algorithms (greedy, two-pointer, etc.)
- Maintain clean, readable code with meaningful variable names

## Problem Categories & Techniques

The repository is organized by algorithmic technique:
- **Array/String**: Linear scanning, two-pass algorithms, stream processing (9 solutions)
- **Two Pointers**: In-place manipulation, efficient array processing (4 solutions)
- **Sliding Window**: Subarray/substring optimization with dynamic window sizing (4 solutions)
- **Prefix Sum**: Cumulative sum techniques for range queries (2 solutions)
- **HashMap/Set**: Frequency counting, duplicate detection, fast lookups (4 solutions)
- **Stack/Queue**: LIFO and FIFO data structures for problem solving (5 solutions)
- **LinkedList**: Node manipulation and traversal techniques (4 solutions)
- **Trees**: Binary tree DFS/BFS traversals and tree manipulation (10 solutions)
- **Graphs**: DFS/BFS graph algorithms for connectivity and path finding (6 solutions)
- **Binary Search**: Efficient search algorithms with logarithmic complexity (4 solutions)
- **Heap/PriorityQueue**: Priority-based problem solving with heap operations (4 solutions)
- **Backtracking**: Recursive exploration with constraint satisfaction (2 solutions)
- **Dynamic Programming**: One-dimensional and multi-dimensional DP solutions (5 solutions)

Each category focuses on specific algorithmic patterns and optimization techniques relevant to that problem type.
