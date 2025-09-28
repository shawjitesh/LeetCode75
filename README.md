# 🚀 LeetCode 75 Solutions

<div align="center">

![LeetCode](https://img.shields.io/badge/LeetCode-000000?style=for-the-badge&logo=LeetCode&logoColor=#d16c06)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)

**A comprehensive collection of solutions to the popular LeetCode 75 coding problems study plan**

[![GitHub stars](https://img.shields.io/github/stars/shawjitesh/LeetCode75?style=social)](https://github.com/shawjitesh/LeetCode75)
[![GitHub forks](https://img.shields.io/github/forks/shawjitesh/LeetCode75?style=social)](https://github.com/shawjitesh/LeetCode75)

</div>

---

## 📖 About This Repository

This repository contains my solutions to the **LeetCode 75** study plan, a curated collection of essential coding problems designed to help developers master fundamental algorithms and data structures. The LeetCode 75 study plan is widely recognized as one of the most effective ways to prepare for technical interviews and strengthen coding skills.

### 🎯 What is LeetCode 75?

The LeetCode 75 study plan is a carefully selected set of 75 coding problems that cover:
- **Array & String** manipulation
- **Two Pointers** technique
- **Sliding Window** problems
- **Stack** and **Queue** operations
- **Linked List** algorithms
- **Tree** traversals and manipulations
- **Graph** algorithms
- **Dynamic Programming** concepts
- **Binary Search** techniques
- **Backtracking** algorithms

## 🗂️ Repository Structure

```
LeetCode75/
├── Array/
│   └── String/
│       ├── MergeStringsAlternately.java
│       ├── GreatestCommonDivisorOfStrings.java
│       ├── KidsWithTheGreatestNumberOfCandies.java
│       ├── CanPlaceFlowers.java
│       ├── ReverseVowelsOfAString.java
│       ├── ReverseWordsInAString.java
│       ├── ProductOfArrayExceptSelf.java
│       ├── IncreasingTripletSubsequence.java
│       └── StringCompression.java
├── TwoPointers/
│   └── MoveZeroes.java
├── SlidingWindow/
├── Stack/
├── Queue/
├── LinkedList/
├── Tree/
├── Graph/
├── DynamicProgramming/
├── BinarySearch/
└── Backtracking/
```

## 🚀 Quick Start

### Prerequisites
- **Java 8 or higher** installed on your system
- **Git** for cloning the repository
- **IDE** of your choice (IntelliJ IDEA, Eclipse, VS Code, etc.)

### 📋 Setup Instructions

#### 1. Clone the Repository
```bash
git clone https://github.com/shawjitesh/LeetCode75.git
cd LeetCode75
```

#### 2. Verify Java Installation
```bash
java -version
javac -version
```

#### 3. Run Solutions
```bash
# Navigate to any solution directory
cd Array/String/

# Compile and run examples
javac MergeStringsAlternately.java && java MergeStringsAlternately
javac GreatestCommonDivisorOfStrings.java && java GreatestCommonDivisorOfStrings
javac KidsWithTheGreatestNumberOfCandies.java && java KidsWithTheGreatestNumberOfCandies
javac CanPlaceFlowers.java && java CanPlaceFlowers
javac ReverseVowelsOfAString.java && java ReverseVowelsOfAString
javac ReverseWordsInAString.java && java ReverseWordsInAString
javac ProductOfArrayExceptSelf.java && java ProductOfArrayExceptSelf
javac IncreasingTripletSubsequence.java && java IncreasingTripletSubsequence
javac StringCompression.java && java StringCompression
```

#### TwoPointers Solutions
```bash
# Navigate to TwoPointers directory
cd TwoPointers/

# Compile and run examples
javac MoveZeroes.java && java MoveZeroes
```

### 🛠️ IDE Setup

#### IntelliJ IDEA
1. Open IntelliJ IDEA
2. Select "Open" and navigate to the cloned repository
3. IntelliJ will automatically detect the Java project structure
4. Configure JDK if prompted

#### VS Code
1. Install the "Extension Pack for Java" by Microsoft
2. Open the repository folder in VS Code
3. VS Code will automatically configure the Java environment

## 💡 Solutions Overview

### Array & String Problems

#### 1. Merge Strings Alternately
- **Problem**: Merge two strings by adding letters in alternating order
- **Approach**: Two-pointer technique with string building
- **Time Complexity**: O(n + m)
- **Space Complexity**: O(n + m)
- **Difficulty**: Easy

#### 2. Greatest Common Divisor of Strings
- **Problem**: Find the largest string that divides both input strings
- **Approach**: Mathematical GCD with string validation
- **Time Complexity**: O(n + m)
- **Space Complexity**: O(n + m)
- **Difficulty**: Easy
- **Note**: Refactored to use Java Streams for modern functional programming approach

#### 3. Kids With the Greatest Number of Candies
- **Problem**: Determine which kids can have the greatest number of candies
- **Approach**: Stream-based functional programming with max finding
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Difficulty**: Easy
- **Note**: Uses Java Streams for elegant functional programming solution

#### 4. Can Place Flowers
- **Problem**: Determine if n new flowers can be planted in a flowerbed without violating the no-adjacent-flowers rule
- **Approach**: Greedy algorithm with boundary condition handling
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Easy
- **Note**: Uses short-circuit evaluation to safely handle array boundaries

#### 5. Reverse Vowels of a String
- **Problem**: Reverse only the vowels in a string while keeping consonants in their original positions
- **Approach**: Two-pointer technique with in-place vowel swapping
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Easy
- **Note**: Optimized solution using direct character comparison and single-pass algorithm

#### 6. Reverse Words in a String
- **Problem**: Reverse the order of words in a string while maintaining single spaces between words
- **Approach**: String splitting and reverse iteration with StringBuilder
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Difficulty**: Medium
- **Note**: Handles multiple spaces and empty words efficiently using split() and trim()

#### 7. Product of Array Except Self
- **Problem**: Return an array where each element is the product of all elements except the element at that index
- **Approach**: Two-pass algorithm using left and right product arrays
- **Time Complexity**: O(n)
- **Space Complexity**: O(1) excluding output array
- **Difficulty**: Medium
- **Note**: Optimized solution using constant extra space by reusing the result array

#### 8. Increasing Triplet Subsequence
- **Problem**: Determine if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]
- **Approach**: Greedy algorithm tracking two minimum values
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Medium
- **Note**: Elegant solution using two variables to track the smallest and second smallest elements

#### 9. String Compression
- **Problem**: Compress a string by replacing consecutive duplicate characters with the character followed by its count
- **Approach**: Two-pointer technique with in-place compression
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Medium
- **Note**: Efficient in-place solution using read and write pointers to compress the string without extra space

### Two Pointers Problems

#### 1. Move Zeroes
- **Problem**: Move all 0's to the end of the array while maintaining the relative order of non-zero elements
- **Approach**: Two-pointer technique with in-place swapping
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Easy
- **Note**: Efficient single-pass solution using left and right pointers to swap non-zero elements with zeros

## 🎯 Key Features

- ✅ **Clean, well-commented code** with detailed explanations
- ✅ **Multiple solution approaches** where applicable
- ✅ **Time and space complexity analysis** for each solution
- ✅ **Modern Java features** including Streams and functional programming
- ✅ **Comprehensive test cases** with main methods
- ✅ **Consistent coding style** and best practices

## 🚀 Recent Updates

- **Added Move Zeroes** solution with efficient two-pointer technique for in-place array manipulation
- **Added String Compression** solution with efficient in-place two-pointer approach
- **Added Increasing Triplet Subsequence** solution with greedy algorithm approach
- **Added Product of Array Except Self** solution with optimized two-pass algorithm
- **Added Kids With the Greatest Number of Candies** solution with stream-based implementation
- **Refactored Greatest Common Divisor of Strings** to use Java Streams
- **Enhanced README** with better structure and comprehensive documentation
- **Added progress tracking** with visual indicators

## 🤝 Contributing

While this is a personal learning repository, suggestions and improvements are welcome! Feel free to:

- 🐛 Open issues for bugs or improvements
- 💡 Suggest better solutions or optimizations
- 🔄 Share your own approaches to these problems
- 📚 Contribute to documentation improvements

## 📊 Learning Resources

- [LeetCode 75 Study Plan](https://leetcode.com/studyplan/leetcode-75/)
- [LeetCode Official Website](https://leetcode.com/)
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Java Streams Tutorial](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)

## 🏆 Goals

- ✅ Complete all 75 problems in the study plan
- ✅ Provide clean, well-commented solutions
- ✅ Include time and space complexity analysis
- ✅ Document different approaches and optimizations
- ✅ Use modern Java features and best practices
- ✅ Create comprehensive documentation

---

<div align="center">

**Happy Coding! 🎉**

Made with ❤️ by [@shawjitesh](https://github.com/shawjitesh)

[![GitHub followers](https://img.shields.io/github/followers/shawjitesh?style=social)](https://github.com/shawjitesh)

</div>