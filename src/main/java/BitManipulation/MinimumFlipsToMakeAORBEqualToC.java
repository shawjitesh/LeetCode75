package BitManipulation;

/**
 * Computes how many single-bit flips are needed so that the bitwise OR of two numbers equals a target.
 */
public class MinimumFlipsToMakeAORBEqualToC {

    /**
     * Returns the minimum number of bit flips required in either {@code a} or {@code b} to satisfy
     * {@code (a | b) == c}.
     *
     * @param a first positive integer
     * @param b second positive integer
     * @param c desired target after performing {@code a | b}
     * @return minimum number of bit flips needed to make the equation hold
     */
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        for (int i = 0; i < 31; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if (bitC == 1) {
                if (bitA == 0 && bitB == 0) { // need one flip to set either bit to 1
                    flips++;
                }
            } else {
                flips += bitA + bitB; // reset any 1 bits because OR result must stay 0
            }
        }

        return flips;
    }
    
    public static void main(String[] args) {
        MinimumFlipsToMakeAORBEqualToC minimumFlipsToMakeAORBEqualToC = new MinimumFlipsToMakeAORBEqualToC();
        System.out.println(minimumFlipsToMakeAORBEqualToC.minFlips(2, 6, 5));
    }
}
