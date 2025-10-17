package BinarySearch;

import java.util.Arrays;

/**
 * Solution for finding successful pairs of spells and potions using binary search.
 * Efficiently counts how many potions can form successful pairs with each spell.
 */
public class SuccessfulPairsOfSpellsAndPotions {

    /**
     * Finds the number of successful pairs for each spell.
     * A pair is successful if spell * potion >= success.
     * 
     * @param spells array of spell strengths
     * @param potions array of potion strengths
     * @param success minimum product value for a successful pair
     * @return array where each element is the count of successful pairs for the corresponding spell
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions); // Sort potions for binary search

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            // Calculate minimum potion strength needed for success
            int successThreshold = (int) Math.ceil((double) success / spell);
            int left = 0;
            int right = potions.length - 1;

            // Binary search for first potion >= threshold
            while (left <= right) {
                int mid = (left + right) / 2;
                if (potions[mid] >= successThreshold) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Count successful pairs: all potions from 'left' index onwards
            pairs[i] = potions.length - left;
        }
        
        return pairs;
    }

    public static void main(String[] args) {
        SuccessfulPairsOfSpellsAndPotions solution = new SuccessfulPairsOfSpellsAndPotions();
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 7;
        System.out.println(Arrays.toString(solution.successfulPairs(spells, potions, success)));
    }
    
}
