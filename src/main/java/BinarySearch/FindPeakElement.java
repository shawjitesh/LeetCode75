package BinarySearch;

/**
 * Solution for finding a peak element in an array.
 * A peak element is an element that is strictly greater than its neighbors.
 */
public class FindPeakElement {

    /**
     * Finds a peak element in the given array using binary search.
     * 
     * @param nums the input array
     * @return the index of a peak element
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Compare with right neighbor
            if (nums[mid] > nums[mid + 1]) {
                // Peak is in left half (including mid)
                right = mid;
            } else {
                // Peak is in right half
                left = mid + 1;
            }
        }
        
        return left;
    }

    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();
        
        // Test case 1: [1,2,3,1] -> should return 2
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test 1: [1,2,3,1] -> " + solution.findPeakElement(nums1));
        
        // Test case 2: [1,2,1,3,5,6,4] -> should return 1 or 5
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Test 2: [1,2,1,3,5,6,4] -> " + solution.findPeakElement(nums2));
        
        // Test case 3: Single element
        int[] nums3 = {5};
        System.out.println("Test 3: [5] -> " + solution.findPeakElement(nums3));
        
        // Test case 4: Two elements
        int[] nums4 = {1, 2};
        System.out.println("Test 4: [1,2] -> " + solution.findPeakElement(nums4));
    }
    
}
