package DP.OneDimensional;

/**
 * Solution for the House Robber problem.
 * 
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed. The only constraint 
 * stopping you from robbing each of them is that adjacent houses have 
 * security systems connected and will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * 
 * @author LeetCode75 Solutions
 */
public class HouseRobber {

    /**
     * Returns the maximum amount of money you can rob tonight without alerting the police.
     * 
     * @param nums array representing the amount of money in each house
     * @return maximum amount of money that can be robbed
     */
    public int rob(int[] nums) {
        // Handle edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        // DP array: dp[i] = max money from first i houses
        int[] dp = new int[nums.length];
        dp[0] = nums[0];  // Base case: only first house
        dp[1] = Math.max(nums[0], nums[1]);  // Base case: max of first two houses
        
        // For each house, choose: rob current + best from i-2, or skip current
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[] {1,2,3,1}));
    }
    
}
