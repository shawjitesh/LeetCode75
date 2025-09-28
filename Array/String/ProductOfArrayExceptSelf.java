package Array.String;

import java.util.Arrays;

/**
 * Solution for LeetCode 75 - Product of Array Except Self
 * Returns an array where each element is the product of all elements except the element at that index.
 */
public class ProductOfArrayExceptSelf {

    /**
     * Returns an array where each element is the product of all elements except the element at that index.
     * 
     * @param nums the input array
     * @return array where each element is the product of all other elements
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int left = 1;
        int right = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = left;
            left *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[] {1, 2, 3, 4})));
    }
    
}
