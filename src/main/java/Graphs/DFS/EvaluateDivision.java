package Graphs.DFS;

import java.util.*;

/**
 * Solution for LeetCode 399: Evaluate Division
 * Uses graph DFS to solve division equations and queries.
 */
public class EvaluateDivision {
    
    /**
     * Evaluates division queries using graph-based approach.
     * @param equations List of equation pairs [Ai, Bi]
     * @param values Corresponding values for equations
     * @param queries List of query pairs [Cj, Dj] to evaluate
     * @return Array of division results, -1.0 if cannot be determined
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph: variable -> (neighbor, weight)
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        // Add edges for each equation
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            
            // Add edge a -> b with weight value
            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, value);
            // Add edge b -> a with weight 1/value
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / value);
        }
        
        // Process each query
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            result[i] = dfs(graph, c, d, new HashSet<>());
        }
        
        return result;
    }
    
    /**
     * DFS helper to find division path between variables.
     * @param graph Weighted graph representation
     * @param start Source variable
     * @param end Target variable
     * @param visited Set of visited variables
     * @return Division result or -1.0 if no path exists
     */
    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        // If either variable doesn't exist in the graph, return -1.0
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        
        // If we've reached the destination
        if (start.equals(end)) {
            return 1.0;
        }
        
        // Mark current node as visited
        visited.add(start);
        
        // Explore all neighbors
        Map<String, Double> neighbors = graph.get(start);
        for (String neighbor : neighbors.keySet()) {
            if (!visited.contains(neighbor)) {
                double result = dfs(graph, neighbor, end, visited);
                if (result != -1.0) {
                    // Multiply by the edge weight
                    return neighbors.get(neighbor) * result;
                }
            }
        }
        
        // Remove from visited set for backtracking
        visited.remove(start);
        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        double[] result = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }
    
}
