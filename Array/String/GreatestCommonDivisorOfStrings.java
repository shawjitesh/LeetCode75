package Array.String;

/**
 * Solution for LeetCode 75 - Greatest Common Divisor of Strings
 * Finds the largest string that divides both input strings.
 */
public class GreatestCommonDivisorOfStrings {

    /**
     * Finds the greatest common divisor of two strings.
     * 
     * @param str1 the first string
     * @param str2 the second string
     * @return the largest string that divides both input strings, or empty string if none exists
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    /**
     * Calculates the greatest common divisor of two integers using Euclidean algorithm.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor of a and b
     */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings greatestCommonDivisorOfStrings = new GreatestCommonDivisorOfStrings();
        System.out.println(greatestCommonDivisorOfStrings.gcdOfStrings("LEET", "CODE"));
    }
    
}
