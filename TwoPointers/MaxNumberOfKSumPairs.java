package TwoPointers;

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
        java.util.Arrays.sort(nums);
        
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
        
        // Test case 1: nums = [1,2,3,4], k = 5
        int[] nums1 = {1, 2, 3, 4};
        int k1 = 5;
        System.out.println("Example 1:");
        System.out.println("Input: nums = [1,2,3,4], k = 5");
        System.out.println("HashMap approach: " + solution.maxOperations(nums1, k1));
        System.out.println("Two-pointer approach: " + solution.maxOperationsTwoPointers(nums1.clone(), k1));
        System.out.println("Expected: 2");
        System.out.println();
        
        // Test case 2: nums = [3,1,3,4,3], k = 6
        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;
        System.out.println("Example 2:");
        System.out.println("Input: nums = [3,1,3,4,3], k = 6");
        System.out.println("HashMap approach: " + solution.maxOperations(nums2, k2));
        System.out.println("Two-pointer approach: " + solution.maxOperationsTwoPointers(nums2.clone(), k2));
        System.out.println("Expected: 1");
        System.out.println();
        
        // Additional test case: nums = [2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2], k = 3
        int[] nums3 = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k3 = 3;
        System.out.println("Example 3:");
        System.out.println("Input: nums = [2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2], k = 3");
        System.out.println("HashMap approach: " + solution.maxOperations(nums3, k3));
        System.out.println("Two-pointer approach: " + solution.maxOperationsTwoPointers(nums3.clone(), k3));
        System.out.println("Expected: 4");
        System.out.println();
        
        // Edge case: nums = [4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4], k = 2
        int[] nums4 = {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
        int k4 = 2;
        System.out.println("Example 4:");
        System.out.println("Input: nums = [4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4], k = 2");
        System.out.println("HashMap approach: " + solution.maxOperations(nums4, k4));
        System.out.println("Two-pointer approach: " + solution.maxOperationsTwoPointers(nums4.clone(), k4));
        System.out.println("Expected: 2");
    }
}
