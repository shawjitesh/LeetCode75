package PrefixSum;

/**
 * Solution for LeetCode 75 - Find Pivot Index
 * Find the pivot index where the sum of elements on the left equals the sum on the right.
 */
public class FindPivotIndex {
    /**
     * Finds the pivot index where left sum equals right sum.
     * Uses prefix sum technique with total sum calculation.
     * 
     * @param nums array of integers
     * @return the leftmost pivot index, or -1 if no pivot exists
     */
    private int pivotIndex(int[] nums) {
        int totalSum = 0;  // Total sum of all elements
        int leftSum = 0;   // Running sum of elements to the left
        
        // Calculate total sum of all elements
        for (int num : nums) {
            totalSum += num;
        }

        // Find pivot index where leftSum == rightSum
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];  // Include current element in left sum
            // Check if left sum equals right sum
            // rightSum = totalSum - leftSum + nums[i] (since we included nums[i] in leftSum)
            if (leftSum == totalSum - leftSum + nums[i]) {
                return i;
            }
        }

        return -1;  // No pivot index found
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        FindPivotIndex solution = new FindPivotIndex();
        System.out.println(solution.pivotIndex(nums));
    }
}
