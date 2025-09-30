package TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {

    /**
     * Finds the maximum number of operations to remove pairs that sum to k.
     * Uses HashMap to track frequency of numbers for O(n) time complexity.
     * 
     * @param nums the input integer array
     * @param k the target sum
     * @return maximum number of operations possible
     */
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int operations = 0;
        
        // Count frequency of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Find pairs that sum to k
        for (int num : frequencyMap.keySet()) {
            int complement = k - num;
            
            if (frequencyMap.containsKey(complement)) {
                if (num == complement) {
                    // Special case: when num + num = k (e.g., k=6, num=3)
                    // We can form pairs only with even frequency
                    operations += frequencyMap.get(num) / 2;
                } else if (num < complement) {
                    // To avoid counting the same pair twice, only count when num < complement
                    operations += Math.min(frequencyMap.get(num), frequencyMap.get(complement));
                }
            }
        }
        
        return operations;
    }

    /**
     * Alternative solution using two-pointer technique after sorting.
     * Time complexity: O(n log n) due to sorting
     * Space complexity: O(1) excluding input array
     */
    public int maxOperationsTwoPointers(int[] nums, int k) {
        // First sort the array
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        int operations = 0;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == k) {
                // Found a pair
                operations++;
                left++;
                right--;
            } else if (sum < k) {
                // Sum is too small, move left pointer to increase sum
                left++;
            } else {
                // Sum is too large, move right pointer to decrease sum
                right--;
            }
        }
        
        return operations;
    }
    
    public static void main(String[] args) {
        MaxNumberOfKSumPairs solution = new MaxNumberOfKSumPairs();
        int[] nums = {1,2,3,4};
        int k = 5;
        System.out.println(solution.maxOperations(nums, k));
        System.out.println(solution.maxOperationsTwoPointers(nums, k)); 
    }
}
