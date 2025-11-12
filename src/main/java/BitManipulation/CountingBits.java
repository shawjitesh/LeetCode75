package BitManipulation;

import java.util.Arrays;

/**
 * Bit manipulation helper for counting set bits across a range of integers.
 */
public class CountingBits {

    /**
     * Builds an array containing the number of set bits for each integer from 0 to n.
     *
     * @param n inclusive upper bound
     * @return array with bit counts where index equals the integer value
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // reuse the count of i >> 1 and add the least significant bit
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        System.out.println(Arrays.toString(countingBits.countBits(5)));
    }
    
}
