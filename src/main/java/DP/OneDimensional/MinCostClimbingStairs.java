package DP.OneDimensional;

/**
 * Solution for LeetCode 746: Min Cost Climbing Stairs
 * 
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinCostClimbingStairs {

    /**
     * Finds the minimum cost to reach the top of the staircase.
     * 
     * @param cost array where cost[i] is the cost of the ith step
     * @return minimum cost to reach the top
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        // Base cases: if there are 0 or 1 steps, cost is 0
        if (n <= 1) return 0;
        
        // Space-optimized DP: only track previous two values
        int prev2 = 0; // minimum cost to reach step i-2
        int prev1 = 0; // minimum cost to reach step i-1
        
        for (int i = 2; i <= n; i++) {
            // Choose minimum: climb 1 step from i-1 or 2 steps from i-2
            int current = Math.min(prev1 + cost[i-1], prev2 + cost[i-2]);
            
            // Shift values for next iteration
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(new int[] {10, 15, 20}));
    }
    
}
