package DP.MultiDimensional;

/**
 * LeetCode 72: Edit Distance
 * 
 * <p>Given two strings word1 and word2, return the minimum number of operations 
 * required to convert word1 to word2. You have the following three operations 
 * permitted on a word: Insert a character, Delete a character, Replace a character.</p>
 * 
 * <p>Time Complexity: O(m × n) where m and n are lengths of word1 and word2</p>
 * <p>Space Complexity: O(min(m, n))</p>
 */
public class EditDistance {

    /**
     * Calculates the minimum number of operations to convert word1 to word2
     * using dynamic programming with space optimization.
     * 
     * @param word1 source string
     * @param word2 target string
     * @return minimum number of operations required
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Use the shorter string for the DP array to optimize space
        if (m < n) {
            return minDistance(word2, word1);
        }
        
        // dp[j] represents minimum operations to convert word1[0...i-1] to word2[0...j-1]
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        // Base case: converting empty string to word2[0...j-1] requires j insertions
        for (int j = 0; j <= n; j++) {
            prev[j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            // Base case: converting word1[0...i-1] to empty string requires i deletions
            curr[0] = i;
            
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match: no operation needed
                    curr[j] = prev[j - 1];
                } else {
                    // Characters don't match: take minimum of three operations
                    // 1. Delete from word1: prev[j]
                    // 2. Insert into word1: curr[j - 1]
                    // 3. Replace in word1: prev[j - 1]
                    curr[j] = 1 + Math.min(prev[j], Math.min(curr[j - 1], prev[j - 1]));
                }
            }
            
            // Swap arrays for next iteration
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[n];
    }

    /**
     * Test cases for minDistance solution.
     */
    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("horse", "ros"));
    }
}
