package Array.String;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
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
