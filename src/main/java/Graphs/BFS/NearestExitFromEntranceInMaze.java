package Graphs.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution for finding the nearest exit from entrance in a maze using BFS.
 * Time Complexity: O(m * n), Space Complexity: O(m * n)
 */
public class NearestExitFromEntranceInMaze {

    /**
     * Finds the shortest path from entrance to nearest border cell (exit).
     * @param maze 2D character array with '.' for empty cells and '+' for walls
     * @param entrance Starting position [row, col]
     * @return minimum steps to nearest exit, or -1 if no exit exists
     */
    private int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        
        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Queue for BFS: stores [row, col, steps]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        
        // Mark entrance as visited
        maze[entrance[0]][entrance[1]] = '+';
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];
            
            // Check if current position is an exit (border cell, but not entrance)
            if ((row == 0 || row == m - 1 || col == 0 || col == n - 1) && 
                !(row == entrance[0] && col == entrance[1])) {
                return steps;
            }
            
            // Explore all four directions
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // Check if new position is valid and not visited
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                    maze[newRow][newCol] == '.') {
                    
                    // Mark as visited and add to queue
                    maze[newRow][newCol] = '+';
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                }
            }
        }
        
        return -1; // No exit found
    }

    public static void main(String[] args) {
        NearestExitFromEntranceInMaze solution = new NearestExitFromEntranceInMaze();
        char[][] maze = {
            {'+', '+', '.', '+'},
            {'.', '.', '.', '+'},
            {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 2};
        System.out.println(solution.nearestExit(maze, entrance));
    }
    
}
