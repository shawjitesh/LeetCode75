package BitManipulation;

/**
 * Computes the unique element in an array where every other value appears exactly twice.
 */
public class SingleNumber {

    /**
     * Returns the integer that appears exactly once by XOR'ing all numbers.
     *
     * @param nums input array containing one unique number and pairs of duplicates
     * @return the value that does not have a duplicate
     */
    public int singleNumber(int[] nums) {
        int unique = 0;
        for (int num : nums) {
            unique ^= num;
        }
        return unique;
    }
   
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[] {2, 2, 1}));
    }
}
