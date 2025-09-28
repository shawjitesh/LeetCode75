package Array.String;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return IntStream.range(0, Math.max(word1.length(), word2.length()))
            .mapToObj(i -> 
                (i < word1.length() ? String.valueOf(word1.charAt(i)) : "") +
                (i < word2.length() ? String.valueOf(word2.charAt(i)) : ""))
            .collect(Collectors.joining());
    }
    
    public static void main(String[] args) {
        MergeStringsAlternately mergeStringsAlternately = new MergeStringsAlternately();
        System.out.println(mergeStringsAlternately.mergeAlternately("abcd", "pq"));
    }

}
