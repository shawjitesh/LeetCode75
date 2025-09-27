package Array.String;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

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
