package Graphs.DFS;

import java.util.Stack;

/**
 * Solution for LeetCode 547: Number of Provinces
 * 
 * Finds the number of connected components in an undirected graph represented by an adjacency matrix.
 * Uses iterative DFS with explicit stack to avoid recursion stack overflow.
 */
public class NumberOfProvinces {
    
    /**
     * Finds the number of provinces (connected components) using iterative DFS.
     * 
     * @param isConnected n x n matrix where isConnected[i][j] = 1 if cities i and j are connected
     * @return number of provinces (connected components)
     */
    private int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        
        // For each city, if it hasn't been visited, start DFS from it
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsWithStack(isConnected, i, visited);
                provinces++; // Found a new province
            }
        }
        
        return provinces;
    }
    
    /**
     * DFS helper method using explicit stack to explore all cities connected to the current city.
     * 
     * @param isConnected adjacency matrix
     * @param startCity starting city index
     * @param visited array to track visited cities
     */
    private void dfsWithStack(int[][] isConnected, int startCity, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startCity);
        visited[startCity] = true;
        
        while (!stack.isEmpty()) {
            int currentCity = stack.pop();
            
            // Check all other cities to see if they're connected to current city
            // Note: We iterate in reverse order to maintain the same traversal order as recursive DFS
            for (int neighbor = isConnected.length - 1; neighbor >= 0; neighbor--) {
                // If cities are connected and neighbor hasn't been visited yet
                if (isConnected[currentCity][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces solution = new NumberOfProvinces();
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println(solution.findCircleNum(isConnected));
    }
    
}
