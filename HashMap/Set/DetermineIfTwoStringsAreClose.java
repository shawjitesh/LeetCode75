package HashMap.Set;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Solution for LeetCode 1657: Determine if Two Strings Are Close
 * 
 * Two strings are considered close if you can attain one from the other using:
 * 1. Swap any two existing characters
 * 2. Transform every occurrence of one existing character into another existing character
 * 
 * Time Complexity: O(n + k) where n is string length, k is unique characters
 * Space Complexity: O(k)
 */
public class DetermineIfTwoStringsAreClose {

    /**
     * Determines if two strings are close based on the given operations.
     * 
     * @param word1 First string
     * @param word2 Second string
     * @return true if strings are close, false otherwise
     */
    public boolean closeStrings(String word1, String word2) {
        // Different lengths cannot be made equal
        if (word1.length() != word2.length()) return false;

        // Build frequency maps for both strings
        Map<Character, Long> word1FrequencyMap = getFrequency(word1);
        Map<Character, Long> word2FrequencyMap = getFrequency(word2);

        // Check if both strings have the same set of characters
        if (!word1FrequencyMap.keySet().equals(word2FrequencyMap.keySet())) return false;

        // Count frequency of frequencies (how many times each frequency appears)
        Map<Long, Long> word1FrequencyCountMap = getFrequencyCount(word1FrequencyMap.values());
        Map<Long, Long> word2FrequencyCountMap = getFrequencyCount(word2FrequencyMap.values());

        // Compare frequency distributions
        return word1FrequencyCountMap.equals(word2FrequencyCountMap);
    }

    /**
     * Counts how many times each frequency value appears.
     * 
     * @param wordFrequencies Collection of frequency values
     * @return Map of frequency value to its count
     */
    private Map<Long, Long> getFrequencyCount(Collection<Long> wordFrequencies) {
        return wordFrequencies.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Builds frequency map for a given string.
     * 
     * @param word Input string
     * @return Map of character to its frequency
     */
    private Map<Character, Long> getFrequency(String word) {
       return word.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> (Character)c, Collectors.counting()));
    }

    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        DetermineIfTwoStringsAreClose solution = new DetermineIfTwoStringsAreClose();
        System.out.println(solution.closeStrings(word1, word2));
    }
}
