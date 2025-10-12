package HashMap.Set;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for LeetCode 2352: Equal Row and Column Pairs
 * 
 * Given an n x n integer matrix grid, return the number of pairs (ri, cj) such that 
 * row ri and column cj are equal. A row and column pair is considered equal if they 
 * contain the same elements in the same order.
 * 
 * Time Complexity: O(n²) where n is the grid size
 * Space Complexity: O(n²)
 */
public class EqualRowAndColumnPairs {

    /**
     * Counts the number of equal row and column pairs using HashMap counting approach.
     * 
     * @param grid n x n integer matrix
     * @return number of pairs (ri, cj) where row ri equals column cj
     */
    private int equalPairs(int[][] grid) {
        Map<String, Integer> rowCount = new HashMap<>();
        Map<String, Integer> colCount = new HashMap<>();

        // Count frequency of each row pattern
        for (int[] row : grid) {
            String rowStr = Arrays.toString(row);
            rowCount.put(rowStr, rowCount.getOrDefault(rowStr, 0) + 1);
        }

        // Count frequency of each column pattern
        for (int i = 0; i < grid.length; i++) {
            int[] column = new int[grid.length];
            for(int j = 0; j < grid.length; j++) {
                column[j] = grid[j][i];
            }
            String colStr = Arrays.toString(column);
            colCount.put(colStr, colCount.getOrDefault(colStr, 0) + 1);
        }

        // Calculate total pairs by multiplying matching pattern counts
        int count = 0;
        for (String rowPattern : rowCount.keySet()) {
            if (colCount.containsKey(rowPattern)) {
                count += rowCount.get(rowPattern) * colCount.get(rowPattern);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        EqualRowAndColumnPairs solution = new EqualRowAndColumnPairs();
        System.out.println(solution.equalPairs(grid));
    }
    
}
