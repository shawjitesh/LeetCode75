package SlidingWindow;

/**
 * Solution for LeetCode 75 - Longest Subarray of 1's After Deleting One Element
 * Find the size of the longest subarray containing only 1's after deleting exactly one element.
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {
    /**
     * Finds the longest subarray of 1's after deleting exactly one element.
     * Uses sliding window technique to maintain a window with at most one 0.
     * 
     * @param nums binary array of 0s and 1s
     * @return length of longest subarray of 1's after deleting one element
     */
    private int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int maxLength = 0, zeroCount = 0;
        
        // Sliding window: expand right pointer through the array
        while (right < nums.length) {
            // Expand window by including current element
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // Shrink window from left if we have more than one zero
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            // Update maximum length
            // We subtract 1 because we must delete exactly one element
            maxLength = Math.max(maxLength, right - left + 1 - 1);
            right++;
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        LongestSubarrayOf1sAfterDeletingOneElement solution = new LongestSubarrayOf1sAfterDeletingOneElement();
        System.out.println(solution.longestSubarray(nums));
    }
}
