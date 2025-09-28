# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Project Overview

This is a Java-based LeetCode 75 solutions repository containing well-structured implementations of the LeetCode 75 study plan problems. The codebase emphasizes clean code, modern Java features (especially Streams), and comprehensive documentation with time/space complexity analysis.

## Architecture & Structure

### Package Organization
- **Array.String/**: Array and string manipulation problems (9 solutions)
- **TwoPointers/**: Two-pointer technique problems (2 solutions)
- Additional categories prepared: SlidingWindow/, Stack/, Queue/, LinkedList/, Tree/, Graph/, DynamicProgramming/, BinarySearch/, Backtracking/

### Code Patterns
- Each solution is a standalone class with package declaration
- Main method included for testing with example inputs
- Extensive Javadoc comments with problem description, approach, and complexity analysis
- Modern Java features preferred (Streams, functional programming where applicable)
- Helper methods extracted for readability (e.g., `swap()` method)

## Common Development Commands

### Running Individual Solutions
```bash
# Compile and run any solution (from root directory)
javac Array/String/MergeStringsAlternately.java && java -cp . Array.String.MergeStringsAlternately

# Or navigate to specific directory first
cd Array/String/
javac MergeStringsAlternately.java && java MergeStringsAlternately
```

### Running Multiple Solutions
```bash
# Compile all Java files in a category
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

## VS Code Integration

The project includes pre-configured launch configurations for all existing solutions:
- Each solution can be run directly from VS Code with F5
- "Current File" configuration allows running any Java file
- Project name: `LeetCode75_defa0e88`

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
- **Array/String**: Linear scanning, two-pass algorithms, stream processing
- **Two Pointers**: In-place manipulation, efficient array processing
- **Future categories**: Sliding window, stack/queue operations, tree traversals, graph algorithms, dynamic programming, binary search, backtracking

Each category focuses on specific algorithmic patterns and optimization techniques relevant to that problem type.