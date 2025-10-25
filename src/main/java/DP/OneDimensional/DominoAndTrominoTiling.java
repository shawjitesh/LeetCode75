package DP.OneDimensional;

/**
 * Problem 790: Domino and Tromino Tiling
 * 
 * Given a 2×n board, count the number of ways to tile it using 2×1 dominoes and L-shaped trominoes.
 * Each piece can be rotated. Return the answer modulo 10^9 + 7.
 * 
 * Approach: Dynamic Programming with optimized recurrence
 * - Base cases: dp[0]=1, dp[1]=1, dp[2]=2, dp[3]=5
 * - Recurrence: dp[i] = 2*dp[i-1] + dp[i-3]
 * - Time complexity: O(n)
 * - Space complexity: O(n)
 * 
 * @see <a href="https://leetcode.com/problems/domino-and-tromino-tiling/">LeetCode 790</a>
 */
public class DominoAndTrominoTiling {

    private static final int mod = 1_000_000_007;

    /**
     * Counts the number of ways to tile a 2×n board with dominoes and trominoes.
     * 
     * @param n the width of the board
     * @return the number of tilings modulo 10^9 + 7
     */
    public int numTilings(int n) {
        // Base cases for small boards
        if (n <= 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        
        // DP array to store number of tilings for each board width
        int[] dp = new int[n + 1];
        
        // Initialize base cases
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        
        // Build DP array using recurrence relation
        // Each tiling can be formed by:
        // - Placing a vertical domino (contributes dp[i-1] ways)
        // - Placing two horizontal dominos (contributes dp[i-2] ways)
        // - Various tromino placements (contributes dp[i-1] more ways)
        // Combined: dp[i] = 2*dp[i-1] + dp[i-3]
        for (int i = 4; i <= n; i++) {
            dp[i] = (int)((2L * dp[i - 1] + dp[i - 3]) % mod);
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        DominoAndTrominoTiling dominoAndTrominoTiling = new DominoAndTrominoTiling();
        System.out.println(dominoAndTrominoTiling.numTilings(3));
    }
    
}
