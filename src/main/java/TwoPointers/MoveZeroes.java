package TwoPointers;

/**
 * Solution for LeetCode 75 - Move Zeroes
 * Moves all 0's to the end of the array while maintaining the relative order of non-zero elements.
 */
public class MoveZeroes {

    /**
     * Moves all zeros to the end of the array while maintaining relative order of non-zero elements.
     * 
     * @param nums the input array to modify in-place
     */
    private void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        
        while (right < n) {
            if (nums[right] != 0) {
                if (left != right) {
                    swap(nums, left, right);
                }
                left++;
            }
            right++;
        }
    }

    /**
     * Swaps two elements in an array.
     * 
     * @param nums the array containing elements to swap
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        moveZeroes.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
