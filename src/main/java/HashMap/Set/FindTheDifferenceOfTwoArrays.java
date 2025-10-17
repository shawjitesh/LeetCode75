package HashMap.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution for LeetCode 75 - Find the Difference of Two Arrays
 * Find distinct integers that are present in one array but not in the other.
 */
public class FindTheDifferenceOfTwoArrays {
    /**
     * Finds the difference between two arrays using HashSet for efficient lookups.
     * Returns two lists: elements in nums1 but not in nums2, and elements in nums2 but not in nums1.
     * 
     * @param nums1 first array of integers
     * @param nums2 second array of integers
     * @return list containing two lists - [elements unique to nums1, elements unique to nums2]
     */
    private List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();  // Unique elements from nums1
        Set<Integer> set2 = new HashSet<>();  // Unique elements from nums2
        List<List<Integer>> result = new ArrayList<>();
        
        // Convert arrays to sets to remove duplicates
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }

        List<Integer> list1 = new ArrayList<>();  // Elements in nums1 but not in nums2
        List<Integer> list2 = new ArrayList<>();  // Elements in nums2 but not in nums1

        // Find elements in set1 but not in set2
        for (int num : set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }

        // Find elements in set2 but not in set1
        for (int num : set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }

        result.add(list1);
        result.add(list2);

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 1, 2, 2};
        FindTheDifferenceOfTwoArrays solution = new FindTheDifferenceOfTwoArrays();
        System.out.println(solution.findDifference(nums1, nums2));
    }
    
}
