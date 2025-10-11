package Graphs.BFS;

import java.util.*;

/**
 * Solution for the "Rotting Oranges" problem using BFS.
 * Simulates the rotting process minute by minute until all oranges are rotten.
 */
public class RottingOranges {

    /**
     * Returns the minimum number of minutes until no fresh oranges remain.
     * Uses BFS to simulate the rotting process where fresh oranges adjacent to rotten ones become rotten.
     * 
     * @param grid 2D array where 0=empty, 1=fresh orange, 2=rotten orange
     * @return minimum minutes to rot all oranges, or -1 if impossible
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        // Find all rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        // If no fresh oranges, return 0
        if (freshOranges == 0) {
            return 0;
        }
        
        int minutes = 0;
        
        // BFS to simulate rotting process
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotted = false;
            
            // Process all oranges that will rot in this minute
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                
                // Check all 4 directions
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    // Check if the new position is valid and has a fresh orange
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                        grid[newRow][newCol] == 1) {
                        
                        // Make the orange rotten
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshOranges--;
                        hasRotted = true;
                    }
                }
            }
            
            // If any orange rotted in this minute, increment time
            if (hasRotted) {
                minutes++;
            }
        }
        
        // If there are still fresh oranges left, it's impossible to rot all
        return freshOranges == 0 ? minutes : -1;
    }

    /**
     * Main method to test the solution with sample inputs.
     */
    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(solution.orangesRotting(grid));
    }
    
}
