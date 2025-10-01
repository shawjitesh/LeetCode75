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
- **Prefix Sum** techniques
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
│   ├── MoveZeroes.java
│   ├── IsSubsequence.java
│   ├── ContainerWithMostWater.java
│   └── MaxNumberOfKSumPairs.java
├── SlidingWindow/
│   ├── MaximumAverageSubarrayI.java
│   ├── MaximumNumberOfVowelsInASubstringOfGivenLength.java
│   ├── MaxConsecutiveOnesIII.java
│   └── LongestSubarrayOf1sAfterDeletingOneElement.java
├── PrefixSum/
│   ├── FindTheHighestAltitude.java
│   └── FindPivotIndex.java
├── Stack/
├── Queue/
├── LinkedList/
├── Tree/
├── Graph/
├── DynamicProgramming/
├── BinarySearch/
├── Backtracking/
├── README.md
└── WARP.md
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

## 🚀 Run Solutions

### Array & String Solutions
```bash
# Navigate to Array/String directory
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

### Two Pointers Solutions
```bash
# Navigate to TwoPointers directory
cd TwoPointers/

# Compile and run examples
javac MoveZeroes.java && java MoveZeroes
javac IsSubsequence.java && java IsSubsequence
javac ContainerWithMostWater.java && java ContainerWithMostWater
javac MaxNumberOfKSumPairs.java && java MaxNumberOfKSumPairs
```

### Sliding Window Solutions
```bash
# Navigate to SlidingWindow directory
cd SlidingWindow/

# Compile and run examples
javac MaximumAverageSubarrayI.java && java MaximumAverageSubarrayI
javac MaximumNumberOfVowelsInASubstringOfGivenLength.java && java MaximumNumberOfVowelsInASubstringOfGivenLength
javac MaxConsecutiveOnesIII.java && java MaxConsecutiveOnesIII
javac LongestSubarrayOf1sAfterDeletingOneElement.java && java LongestSubarrayOf1sAfterDeletingOneElement
```

### Prefix Sum Solutions
```bash
# Navigate to PrefixSum directory
cd PrefixSum/

# Compile and run examples
javac FindTheHighestAltitude.java && java FindTheHighestAltitude
javac FindPivotIndex.java && java FindPivotIndex
```

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

### Sliding Window Problems

#### 1. Maximum Average Subarray I
- **Problem**: Find a contiguous subarray whose length is equal to k that has the maximum average value
- **Approach**: Sliding window technique with sum optimization
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Easy
- **Note**: Efficient single-pass solution using sliding window to avoid recalculating sums

#### 2. Maximum Number of Vowels in a Substring of Given Length
- **Problem**: Find the maximum number of vowel letters in any substring of length k
- **Approach**: Sliding window technique with vowel counting optimization
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Medium
- **Note**: Efficient sliding window solution that maintains vowel count while moving the window, avoiding recounting for each position

#### 3. Max Consecutive Ones III
- **Problem**: Find the maximum number of consecutive 1's in a binary array if you can flip at most k 0's
- **Approach**: Sliding window technique with zero counting and window shrinking
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Medium
- **Note**: Optimal sliding window solution that maintains a valid window with at most k zeros, efficiently expanding and shrinking the window

#### 4. Longest Subarray of 1's After Deleting One Element
- **Problem**: Find the size of the longest subarray containing only 1's after deleting exactly one element
- **Approach**: Sliding window technique maintaining at most one 0 in the window
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Medium
- **Note**: Efficient sliding window solution that finds the longest subarray with at most one zero, then subtracts 1 since we must delete exactly one element

### Prefix Sum Problems

#### 1. Find the Highest Altitude
- **Problem**: Find the highest altitude reached during a journey given altitude gains
- **Approach**: Prefix sum technique to track cumulative altitude changes
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Easy
- **Note**: Simple prefix sum solution that maintains running total of altitude changes and tracks the maximum altitude reached

#### 2. Find Pivot Index
- **Problem**: Find the pivot index where the sum of elements on the left equals the sum on the right
- **Approach**: Prefix sum technique with total sum calculation and left sum tracking
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Easy
- **Note**: Efficient two-pass solution that first calculates total sum, then finds pivot by comparing left and right sums

### Two Pointers Problems

#### 1. Move Zeroes
- **Problem**: Move all 0's to the end of the array while maintaining the relative order of non-zero elements
- **Approach**: Two-pointer technique with in-place swapping
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Easy
- **Note**: Efficient single-pass solution using left and right pointers to swap non-zero elements with zeros

#### 2. Is Subsequence
- **Problem**: Determine if string s is a subsequence of string t
- **Approach**: Two-pointer technique with character matching
- **Time Complexity**: O(n + m)
- **Space Complexity**: O(1)
- **Difficulty**: Easy
- **Note**: Simple and efficient solution using two pointers to traverse both strings simultaneously

#### 3. Container With Most Water
- **Problem**: Find two lines that together with the x-axis form a container that holds the most water
- **Approach**: Two-pointer technique starting from both ends and moving inward
- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Difficulty**: Medium
- **Note**: Optimal solution using two pointers to maximize area by moving the pointer with smaller height

#### 4. Max Number of K-Sum Pairs
- **Problem**: Find the maximum number of operations to remove pairs of numbers that sum to k
- **Approach**: HashMap for frequency counting or two-pointer technique after sorting
- **Time Complexity**: O(n) for HashMap approach, O(n log n) for two-pointer approach
- **Space Complexity**: O(n) for HashMap approach, O(1) for two-pointer approach
- **Difficulty**: Medium
- **Note**: Two solutions provided - HashMap approach for better time complexity and two-pointer approach for better space complexity

## 🎯 Key Features

- ✅ **Clean, well-commented code** with detailed explanations
- ✅ **Multiple solution approaches** where applicable
- ✅ **Time and space complexity analysis** for each solution
- ✅ **Modern Java features** including Streams and functional programming
- ✅ **Comprehensive test cases** with main methods
- ✅ **Consistent coding style** and best practices
- ✅ **WARP.md integration** for enhanced terminal development experience

## 🚀 Recent Updates

- **Added Find Pivot Index** solution with efficient prefix sum technique for finding balance point in array
- **Added Find the Highest Altitude** solution with efficient prefix sum technique for tracking cumulative altitude changes
- **Added Longest Subarray of 1's After Deleting One Element** solution with efficient sliding window technique for finding longest subarray after mandatory deletion
- **Added Max Consecutive Ones III** solution with efficient sliding window technique for binary array optimization with zero flipping constraint
- **Added Maximum Number of Vowels in a Substring of Given Length** solution with efficient sliding window technique for vowel counting optimization
- **Added Max Number of K-Sum Pairs** solution with both HashMap and two-pointer approaches for maximum flexibility
- **Added Container With Most Water** solution with optimal two-pointer technique for maximum area calculation
- **Added Maximum Average Subarray I** solution with efficient sliding window technique for subarray optimization
- **Added WARP.md** configuration file for Warp terminal integration and development guidance
- **Added Is Subsequence** solution with efficient two-pointer technique for string subsequence checking
- **Added Move Zeroes** solution with efficient two-pointer technique for in-place array manipulation
- **Added String Compression** solution with efficient in-place two-pointer approach
- **Added Increasing Triplet Subsequence** solution with greedy algorithm approach
- **Added Product of Array Except Self** solution with optimized two-pass algorithm
- **Added Kids With the Greatest Number of Candies** solution with stream-based implementation
- **Refactored Greatest Common Divisor of Strings** to use Java Streams
- **Enhanced README** with better structure and comprehensive documentation

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