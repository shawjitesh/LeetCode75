package Graphs.DFS;

import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    /**
     * Reorder Routes to Make All Paths Lead to the City Zero
     * 
     * The key insight is that we need to build a bidirectional graph and use DFS/BFS
     * starting from city 0. For each edge in the original connections, if it points
     * away from city 0 during our traversal, we need to reverse it.
     * 
     * @param n number of cities
     * @param connections array of directed edges [from, to]
     * @return minimum number of edge reversals needed
     * 
     * Time Complexity: O(n) where n is the number of cities
     * Space Complexity: O(n) for the adjacency list and visited array
     */
    private int minReorder(int n, int[][] connections) {
        // Build adjacency list with bidirectional edges
        // For each original edge [a, b], we add both a->b and b->a
        // but mark the original direction to count reversals needed
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            
            // Add bidirectional edges
            // [neighbor, isOriginalDirection] where 1 means original direction, 0 means reverse
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, 1});
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[]{from, 0});
        }
        
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }
    
    /**
     * DFS helper method to count edge reversals needed
     * 
     * @param city current city being visited
     * @param graph adjacency list with bidirectional edges
     * @param visited array to track visited cities
     * @return number of reversals needed from this city
     */
    private int dfs(int city, Map<Integer, List<int[]>> graph, boolean[] visited) {
        visited[city] = true;
        int reversals = 0;
        
        List<int[]> neighbors = graph.getOrDefault(city, new ArrayList<>());
        for (int[] neighbor : neighbors) {
            int nextCity = neighbor[0];
            int isOriginalDirection = neighbor[1];
            
            if (!visited[nextCity]) {
                // If the edge is in original direction (pointing away from city 0),
                // we need to reverse it
                if (isOriginalDirection == 1) {
                    reversals++;
                }
                reversals += dfs(nextCity, graph, visited);
            }
        }
        
        return reversals;
    }

    public static void main(String[] args) {
        ReorderRoutesToMakeAllPathsLeadToTheCityZero solution = new ReorderRoutesToMakeAllPathsLeadToTheCityZero();
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(solution.minReorder(6, connections));
    }
    
}
