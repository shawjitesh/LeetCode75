package DP.MultiDimensional;

/**
 * LeetCode 62: Unique Paths
 * 
 * <p>Count the number of unique paths from top-left (0,0) to bottom-right (m-1,n-1) 
 * in an m×n grid, moving only right or down.</p>
 * 
 * <p>Time Complexity: O(m × n)</p>
 * <p>Space Complexity: O(n)</p>
 */
public class UniquePaths {

    /**
     * Calculates unique paths using dynamic programming with space optimization.
     * 
     * @param m number of rows
     * @param n number of columns
     * @return number of unique paths
     */
    public int uniquePaths(int m, int n) {
        // 1D DP array: dp[j] = paths to column j in current row
        int[] dp = new int[n];
        
        // Initialize first row: only one path (all right moves)
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }
        
        // Calculate paths for subsequent rows
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // paths = paths from top + paths from left
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }

    /**
     * Test cases for uniquePaths solution.
     */
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println("Example 1: m=3, n=7 -> " + uniquePaths.uniquePaths(3, 7));
    }
}
