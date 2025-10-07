package SlidingWindow;

/**
 * Solution for LeetCode 75 - Maximum Average Subarray I
 * Find a contiguous subarray whose length is equal to k that has the maximum average value.
 */
public class MaximumAverageSubarrayI {

    /**
     * Finds the maximum average of any contiguous subarray of length k.
     * 
     * @param nums the input integer array
     * @param k the length of the subarray
     * @return the maximum average value
     */
    public double findMaxAverage(int[] nums, int k) {
        // Calculate sum of first window
        long currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        long maxSum = currentSum;
        
        // Slide the window and update maximum sum
        for (int i = k; i < nums.length; i++) {
            // Remove leftmost element, add rightmost element
            currentSum = currentSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // Return average as double
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        System.out.println(maximumAverageSubarrayI.findMaxAverage(nums, k));
    }
    
}
