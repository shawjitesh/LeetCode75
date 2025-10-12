package Array.String;

/**
 * Solution for LeetCode 75 - Increasing Triplet Subsequence
 * Determines if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k].
 */
public class IncreasingTripletSubsequence {

    /**
     * Determines if there exists an increasing triplet subsequence.
     * 
     * @param nums the input array
     * @return true if there exists an increasing triplet subsequence, false otherwise
     */
    private boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        System.out.println(increasingTripletSubsequence.increasingTriplet(new int[] {2,1,5,0,4,6}));
    }
    
}
