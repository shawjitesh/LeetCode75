package Array.String;

/**
 * Solution for LeetCode 75 - Merge Strings Alternately
 * Merges two strings by adding letters in alternating order.
 */
public class MergeStringsAlternately {

    /**
     * Merges two strings by adding letters in alternating order.
     * 
     * @param word1 the first string to merge
     * @param word2 the second string to merge
     * @return the merged string with alternating characters
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int maxLength = Math.max(word1.length(), word2.length());
        
        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        MergeStringsAlternately mergeStringsAlternately = new MergeStringsAlternately();
        System.out.println(mergeStringsAlternately.mergeAlternately("abcd", "pq"));
    }

}
