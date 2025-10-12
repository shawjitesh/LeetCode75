package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for LeetCode 216: Combination Sum III
 * 
 * Finds all valid combinations of k numbers that sum up to n such that:
 * - Only numbers 1 through 9 are used
 * - Each number is used at most once
 * 
 * Time Complexity: O(C(9,k) × k)
 * Space Complexity: O(k) for recursion + O(C(9,k) × k) for results
 */
public class CombinationSumIII {

    /**
     * Find all combinations of k numbers from 1-9 that sum to n
     * 
     * @param k number of elements in each combination
     * @param n target sum
     * @return list of all valid combinations
     */
    private List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, k, n, 1);
        return result;
    }

    /**
     * Backtracking helper method to find valid combinations
     * 
     * @param result list to store valid combinations
     * @param current current combination being built
     * @param k number of elements needed
     * @param target remaining sum needed
     * @param start starting number for this recursive call
     */
    private void backtrack(List<List<Integer>> result, List<Integer> current, int k, int target, int start) {
        // Found valid combination
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Invalid path - stop exploring
        if (current.size() == k || target <= 0) {
            return;
        }
        
        // Try each number from start to 9
        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(result, current, k, target - i, i + 1);
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        CombinationSumIII solution = new CombinationSumIII();
        
        // Test cases
        System.out.println("k=3, n=7: " + solution.combinationSum3(3, 7));
        System.out.println("k=3, n=9: " + solution.combinationSum3(3, 9));
        System.out.println("k=4, n=1: " + solution.combinationSum3(4, 1));
    }
}
