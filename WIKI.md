# LeetCode 75 Solutions Wiki

Welcome to the comprehensive wiki for the LeetCode 75 Solutions repository! This wiki serves as a detailed guide to understanding, implementing, and mastering the essential coding problems in the LeetCode 75 study plan.

## 📚 Table of Contents

1. [Getting Started](#getting-started)
2. [Problem Categories](#problem-categories)
3. [Solution Patterns](#solution-patterns)
4. [Complexity Analysis](#complexity-analysis)
5. [Best Practices](#best-practices)
6. [Troubleshooting](#troubleshooting)
7. [Contributing Guidelines](#contributing-guidelines)

## 🚀 Getting Started

### What is LeetCode 75?

The LeetCode 75 study plan is a curated collection of 75 essential coding problems designed to help developers master fundamental algorithms and data structures. These problems are carefully selected to cover the most important concepts needed for technical interviews and competitive programming.

### Why This Repository?

This repository provides:
- ✅ **Clean, well-commented Java solutions**
- ✅ **Multiple approaches** where applicable
- ✅ **Detailed complexity analysis**
- ✅ **Modern Java features** and best practices
- ✅ **Comprehensive test cases**
- ✅ **Step-by-step explanations**

### Prerequisites

- **Java 8 or higher**
- **Basic understanding** of data structures
- **Familiarity** with algorithm concepts
- **IDE** (IntelliJ IDEA, Eclipse, VS Code)

## 🗂️ Problem Categories

### Array & String Problems

| Problem | Difficulty | Key Concepts | Time Complexity |
|---------|------------|--------------|-----------------|
| [Merge Strings Alternately](Array/String/MergeStringsAlternately.java) | Easy | Two Pointers, String Building | O(n + m) |
| [Greatest Common Divisor of Strings](Array/String/GreatestCommonDivisorOfStrings.java) | Easy | GCD Algorithm, String Validation | O(n + m) |
| [Kids With the Greatest Number of Candies](Array/String/KidsWithTheGreatestNumberOfCandies.java) | Easy | Array Processing, Streams | O(n) |
| [Can Place Flowers](Array/String/CanPlaceFlowers.java) | Easy | Greedy Algorithm, Boundary Handling | O(n) |
| [Reverse Vowels of a String](Array/String/ReverseVowelsOfAString.java) | Easy | Two Pointers, Character Swapping | O(n) |
| [Reverse Words in a String](Array/String/ReverseWordsInAString.java) | Medium | String Manipulation, StringBuilder | O(n) |
| [Product of Array Except Self](Array/String/ProductOfArrayExceptSelf.java) | Medium | Prefix/Postfix Products | O(n) |
| [Increasing Triplet Subsequence](Array/String/IncreasingTripletSubsequence.java) | Medium | Greedy Algorithm, Two Variables | O(n) |
| [String Compression](Array/String/StringCompression.java) | Medium | Two Pointers, In-place Compression | O(n) |

### Two Pointers Problems

| Problem | Difficulty | Key Concepts | Time Complexity |
|---------|------------|--------------|-----------------|
| [Move Zeroes](TwoPointers/MoveZeroes.java) | Easy | In-place Swapping, Two Pointers | O(n) |
| [Is Subsequence](TwoPointers/IsSubsequence.java) | Easy | Character Matching, Two Pointers | O(n + m) |
| [Container With Most Water](TwoPointers/ContainerWithMostWater.java) | Medium | Two Pointers, Area Maximization | O(n) |
| [Max Number of K-Sum Pairs](TwoPointers/MaxNumberOfKSumPairs.java) | Medium | HashMap/Two Pointers | O(n) |

### Sliding Window Problems

| Problem | Difficulty | Key Concepts | Time Complexity |
|---------|------------|--------------|-----------------|
| [Maximum Average Subarray I](SlidingWindow/MaximumAverageSubarrayI.java) | Easy | Sliding Window, Sum Optimization | O(n) |
| [Maximum Number of Vowels in a Substring](SlidingWindow/MaximumNumberOfVowelsInASubstringOfGivenLength.java) | Medium | Sliding Window, Vowel Counting | O(n) |
| [Max Consecutive Ones III](SlidingWindow/MaxConsecutiveOnesIII.java) | Medium | Sliding Window, Zero Counting | O(n) |
| [Longest Subarray of 1's After Deleting One Element](SlidingWindow/LongestSubarrayOf1sAfterDeletingOneElement.java) | Medium | Sliding Window, One Zero Constraint | O(n) |

### Binary Tree DFS Problems

| Problem | Difficulty | Key Concepts | Time Complexity |
|---------|------------|--------------|-----------------|
| [Maximum Depth of Binary Tree](BinaryTreeDFS/MaximumDepthOfBinaryTree.java) | Easy | DFS, Stack-based Iteration | O(n) |
| [Leaf-Similar Trees](BinaryTreeDFS/LeafSimilarTrees.java) | Easy | DFS, Leaf Collection | O(n + m) |
| [Count Good Nodes in Binary Tree](BinaryTreeDFS/CountGoodNodesInBinaryTree.java) | Medium | DFS, Path Tracking | O(n) |

## 🎯 Solution Patterns

### 1. Two Pointers Technique

**When to use:** Array/string problems requiring comparison or manipulation from both ends.

**Pattern:**
```java
int left = 0, right = array.length - 1;
while (left < right) {
    // Process elements at left and right
    if (condition) {
        left++;
    } else {
        right--;
    }
}
```

**Examples:** Container With Most Water, Move Zeroes, Is Subsequence

### 2. Sliding Window Technique

**When to use:** Problems involving subarrays/substrings with specific constraints.

**Pattern:**
```java
int left = 0;
for (int right = 0; right < array.length; right++) {
    // Expand window
    while (window_invalid) {
        // Shrink window
        left++;
    }
    // Update result
}
```

**Examples:** Maximum Average Subarray, Max Consecutive Ones III

### 3. DFS (Depth-First Search)

**When to use:** Tree traversal, path finding, backtracking.

**Pattern:**
```java
private void dfs(TreeNode node, parameters) {
    if (node == null) return;
    
    // Process current node
    process(node);
    
    // Recursively visit children
    dfs(node.left, updated_parameters);
    dfs(node.right, updated_parameters);
}
```

**Examples:** Maximum Depth, Leaf Similar Trees, Count Good Nodes

### 4. HashMap/Set Usage

**When to use:** Frequency counting, duplicate detection, fast lookups.

**Pattern:**
```java
Map<Integer, Integer> frequency = new HashMap<>();
for (int num : array) {
    frequency.put(num, frequency.getOrDefault(num, 0) + 1);
}
```

**Examples:** Find Difference of Arrays, Unique Occurrences

## 📊 Complexity Analysis

### Time Complexity Guidelines

| Complexity | Description | Examples |
|------------|-------------|----------|
| O(1) | Constant time | Array access, HashMap lookup |
| O(log n) | Logarithmic | Binary search, balanced tree operations |
| O(n) | Linear | Single pass through array |
| O(n log n) | Linearithmic | Sorting, heap operations |
| O(n²) | Quadratic | Nested loops, bubble sort |
| O(2ⁿ) | Exponential | Recursive Fibonacci, backtracking |

### Space Complexity Guidelines

| Complexity | Description | Examples |
|------------|-------------|----------|
| O(1) | Constant space | In-place algorithms |
| O(n) | Linear space | Array storage, recursion stack |
| O(n²) | Quadratic space | 2D arrays, adjacency matrices |

### Common Patterns and Their Complexities

| Pattern | Time | Space | Use Cases |
|---------|------|-------|-----------|
| Two Pointers | O(n) | O(1) | Sorted arrays, palindromes |
| Sliding Window | O(n) | O(1) | Subarray problems |
| DFS | O(n) | O(h) | Tree traversal |
| BFS | O(n) | O(w) | Level-order traversal |
| HashMap | O(1) avg | O(n) | Frequency counting |

## 🏆 Best Practices

### Code Quality

1. **Meaningful Variable Names**
   ```java
   // Good
   int maxDepth = 0;
   TreeNode currentNode = root;
   
   // Bad
   int x = 0;
   TreeNode n = root;
   ```

2. **Consistent Formatting**
   ```java
   // Use consistent indentation and spacing
   if (condition) {
       // Process
   } else {
       // Alternative
   }
   ```

3. **Clear Comments**
   ```java
   // Two-pointer approach: move the pointer with smaller height
   if (height[left] < height[right]) {
       left++;
   } else {
       right--;
   }
   ```

### Algorithm Design

1. **Start with Brute Force**
   - Understand the problem completely
   - Implement the obvious solution first
   - Then optimize

2. **Think About Edge Cases**
   - Empty inputs
   - Single elements
   - Boundary conditions

3. **Consider Multiple Approaches**
   - Time vs. space trade-offs
   - Readability vs. performance
   - Different data structures

### Testing

1. **Test with Examples**
   ```java
   public static void main(String[] args) {
       Solution solution = new Solution();
       
       // Test case 1
       int[] input1 = {1, 2, 3};
       int expected1 = 6;
       int result1 = solution.someMethod(input1);
       System.out.println("Test 1: " + (result1 == expected1));
       
       // Test case 2
       // ... more test cases
   }
   ```

2. **Edge Case Testing**
   - Empty arrays/strings
   - Single elements
   - Maximum constraints
   - Negative numbers

## 🔧 Troubleshooting

### Common Issues

#### 1. Array Index Out of Bounds
```java
// Problem: Accessing array[i] without checking bounds
// Solution: Always check bounds
if (i >= 0 && i < array.length) {
    // Safe to access array[i]
}
```

#### 2. Null Pointer Exceptions
```java
// Problem: Accessing node.left without null check
// Solution: Always check for null
if (node != null && node.left != null) {
    // Safe to access node.left
}
```

#### 3. Infinite Loops
```java
// Problem: Not updating loop variables
// Solution: Ensure loop variables change
while (left < right) {
    // Make sure left or right changes
    left++; // or right--, or break condition
}
```

#### 4. Stack Overflow (Recursion)
```java
// Problem: Deep recursion causing stack overflow
// Solution: Use iterative approach or increase stack size
// Convert recursive to iterative:
// Instead of: dfs(node.left)
// Use: stack.push(node.left)
```

### Performance Optimization

1. **Avoid Unnecessary Operations**
   ```java
   // Bad: Multiple passes
   for (int i = 0; i < array.length; i++) {
       if (array[i] > 0) count++;
   }
   for (int i = 0; i < array.length; i++) {
       if (array[i] > 0) sum += array[i];
   }
   
   // Good: Single pass
   for (int i = 0; i < array.length; i++) {
       if (array[i] > 0) {
           count++;
           sum += array[i];
       }
   }
   ```

2. **Use Appropriate Data Structures**
   ```java
   // For O(1) lookups: HashMap
   Map<Integer, Integer> map = new HashMap<>();
   
   // For sorted operations: TreeSet
   Set<Integer> set = new TreeSet<>();
   
   // For LIFO: Stack
   Stack<Integer> stack = new Stack<>();
   ```

## 🤝 Contributing Guidelines

### How to Contribute

1. **Fork the Repository**
   ```bash
   git clone https://github.com/your-username/LeetCode75.git
   cd LeetCode75
   ```

2. **Create a Feature Branch**
   ```bash
   git checkout -b feature/new-solution
   ```

3. **Add Your Solution**
   - Follow the existing code style
   - Add comprehensive comments
   - Include test cases
   - Update documentation

4. **Submit a Pull Request**
   - Clear description of changes
   - Reference any related issues
   - Ensure all tests pass

### Code Standards

1. **Java Style Guide**
   - Use camelCase for variables and methods
   - Use PascalCase for classes
   - Use UPPER_CASE for constants

2. **Documentation Requirements**
   - Javadoc for all public methods
   - Inline comments for complex logic
   - README updates for new problems

3. **Testing Requirements**
   - Include main method with test cases
   - Test edge cases
   - Verify expected outputs

## 📈 Learning Path

### Beginner (Easy Problems)
1. Array/String manipulation
2. Basic two-pointer techniques
3. Simple tree traversals

### Intermediate (Medium Problems)
1. Sliding window techniques
2. Advanced tree algorithms
3. Dynamic programming basics

### Advanced (Hard Problems)
1. Complex graph algorithms
2. Advanced DP patterns
3. Optimization techniques

### Recommended Study Order

1. **Week 1-2:** Array & String problems
2. **Week 3-4:** Two Pointers & Sliding Window
3. **Week 5-6:** Tree & Graph problems
4. **Week 7-8:** Dynamic Programming
5. **Week 9-10:** Advanced algorithms

## 🎯 Interview Preparation

### Common Interview Topics

1. **Data Structures**
   - Arrays and Strings
   - Linked Lists
   - Trees and Graphs
   - Stacks and Queues
   - Hash Tables

2. **Algorithms**
   - Sorting and Searching
   - Dynamic Programming
   - Greedy Algorithms
   - Graph Algorithms
   - Backtracking

3. **Problem-Solving Skills**
   - Pattern Recognition
   - Optimization Techniques
   - Edge Case Handling
   - Code Quality

### Interview Tips

1. **Before Coding**
   - Understand the problem completely
   - Ask clarifying questions
   - Think out loud
   - Consider edge cases

2. **While Coding**
   - Start with brute force if needed
   - Explain your approach
   - Write clean, readable code
   - Test with examples

3. **After Coding**
   - Walk through your solution
   - Discuss time/space complexity
   - Consider optimizations
   - Handle edge cases

## 📚 Additional Resources

### Books
- "Cracking the Coding Interview" by Gayle Laakmann McDowell
- "Elements of Programming Interviews" by Aziz, Lee, and Prakash
- "Introduction to Algorithms" by Cormen, Leiserson, Rivest, and Stein

### Online Resources
- [LeetCode Official](https://leetcode.com/)
- [GeeksforGeeks](https://www.geeksforgeeks.org/)
- [HackerRank](https://www.hackerrank.com/)
- [CodeSignal](https://codesignal.com/)

### Practice Platforms
- [LeetCode](https://leetcode.com/)
- [HackerRank](https://www.hackerrank.com/)
- [CodeForces](https://codeforces.com/)
- [AtCoder](https://atcoder.jp/)

---

## 🎉 Conclusion

This wiki provides a comprehensive guide to mastering the LeetCode 75 problems. Remember that consistent practice and understanding the underlying patterns are key to success in technical interviews and competitive programming.

Happy coding! 🚀

---

*Last updated: [Current Date]*
*Repository: [LeetCode75](https://github.com/shawjitesh/LeetCode75)*
