package SlidingWindow;

/**
 * Solution for LeetCode 75 - Max Consecutive Ones III
 * Find the maximum number of consecutive 1's in a binary array if you can flip at most k 0's.
 */
public class MaxConsecutiveOnesIII {
    /**
     * Finds the maximum number of consecutive 1's in a binary array when at most k zeros can be flipped.
     * Uses sliding window technique to maintain a valid window with at most k zeros.
     * 
     * @param nums binary array of 0s and 1s
     * @param k maximum number of zeros that can be flipped
     * @return maximum length of consecutive 1's after flipping at most k zeros
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;  // Sliding window pointers
        int maxOnesLength = 0, zeroesCount = 0;  // Track max length and zeros in current window
        
        // Sliding window: expand right pointer through the array
        while (right < nums.length) {
            // Expand window by including current element
            if (nums[right] == 0) {
                zeroesCount++;
            }
            
            // Shrink window from left if we have more than k zeros
            while (zeroesCount > k) {
                if (nums[left] == 0) {
                    zeroesCount--;
                }
                left++;
            }

            // Update maximum length of valid window
            maxOnesLength = Math.max(maxOnesLength, right - left + 1);
            right++;
        }

        return maxOnesLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        MaxConsecutiveOnesIII solution = new MaxConsecutiveOnesIII();
        System.out.println(solution.longestOnes(nums, k));
    }
    
}
