package TwoPointers;

/**
 * Solution for LeetCode 75 - Is Subsequence
 * Determines if string s is a subsequence of string t.
 */
public class IsSubsequence {

    /**
     * Determines if string s is a subsequence of string t.
     * A subsequence is a sequence that can be derived from another sequence by deleting
     * some or no elements without changing the order of the remaining elements.
     * 
     * @param s the subsequence string to check
     * @param t the target string to check against
     * @return true if s is a subsequence of t, false otherwise
     */
    private boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
    }
    
}
