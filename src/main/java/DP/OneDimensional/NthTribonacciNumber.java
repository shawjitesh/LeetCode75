package DP.OneDimensional;

/**
 * Solution for Nth Tribonacci Number problem.
 * Calculates the nth tribonacci number using dynamic programming.
 */
public class NthTribonacciNumber {

    /**
     * Calculates the nth tribonacci number.
     * @param n the index of the tribonacci number to calculate
     * @return the nth tribonacci number
     */
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NthTribonacciNumber nthTribonacciNumber = new NthTribonacciNumber();
        System.out.println(nthTribonacciNumber.tribonacci(4));
    }
    
}
