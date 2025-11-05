package DP.MultiDimensional;

/**
 * LeetCode 1143: Longest Common Subsequence
 * 
 * <p>Given two strings text1 and text2, return the length of their longest common subsequence.
 * A subsequence of a string is a new string generated from the original string with some 
 * characters (can be none) deleted without changing the relative order of the remaining characters.</p>
 * 
 * <p>Time Complexity: O(m × n) where m and n are lengths of text1 and text2</p>
 * <p>Space Complexity: O(min(m, n))</p>
 */
public class LongestCommonSubsequence {

    /**
     * Calculates the length of the longest common subsequence using dynamic programming.
     * Uses space optimization to reduce space complexity from O(m × n) to O(min(m, n)).
     * 
     * @param text1 first string
     * @param text2 second string
     * @return length of the longest common subsequence
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // Use the shorter string for the DP array to optimize space
        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }
        
        // dp[j] represents LCS length of text1[0...i-1] and text2[0...j-1]
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // Characters match: extend LCS
                    curr[j] = prev[j - 1] + 1;
                } else {
                    // Characters don't match: take max of skipping one character
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Swap arrays for next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("abcde", "ace"));
    }
}
