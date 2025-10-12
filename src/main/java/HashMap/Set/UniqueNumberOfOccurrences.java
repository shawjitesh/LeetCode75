package HashMap.Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution for LeetCode 75 - Unique Number of Occurrences
 * Determine if the number of occurrences of each value in the array is unique.
 */
public class UniqueNumberOfOccurrences {
    /**
     * Checks if the number of occurrences of each value in the array is unique.
     * Uses HashMap to count frequencies and HashSet to check for unique occurrences.
     * 
     * @param arr array of integers to check for unique occurrence counts
     * @return true if all occurrence counts are unique, false otherwise
     */
    private boolean uniqueOccurrences(int[] arr) {
        // Count frequency of each number using HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Use HashSet to check if all frequency values are unique
        Set<Integer> occurrences = new HashSet<>(frequencyMap.values());
        
        // If HashSet size equals HashMap size, all frequencies are unique
        return occurrences.size() == frequencyMap.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        UniqueNumberOfOccurrences solution = new UniqueNumberOfOccurrences();
        System.out.println(solution.uniqueOccurrences(arr));
    }
}
