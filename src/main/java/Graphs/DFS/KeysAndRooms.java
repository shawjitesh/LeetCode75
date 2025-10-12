package Graphs.DFS;

import java.util.*;

/**
 * Solution for LeetCode 841: Keys and Rooms
 * 
 * Determines if all rooms can be visited starting from room 0.
 * Each room contains keys to other rooms. Room 0 is initially unlocked.
 * 
 * Uses iterative DFS with a stack to traverse all accessible rooms.
 * 
 * @author LeetCode75
 */
public class KeysAndRooms {
    
    /**
     * Determines if all rooms can be visited starting from room 0.
     * 
     * @param rooms List of rooms, where each room contains a list of keys (room numbers)
     * @return true if all rooms can be visited, false otherwise
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n]; // Track visited rooms
        Stack<Integer> stack = new Stack<>(); // Stack for iterative DFS
        
        // Start DFS from room 0 (unlocked)
        stack.push(0);
        
        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();
            
            // Skip if already visited (prevents cycles)
            if (visited[currentRoom]) {
                continue;
            }
            
            visited[currentRoom] = true; // Mark as visited
            
            // Add all accessible rooms to stack for future processing
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    stack.push(key);
                }
            }
        }
        
        // Check if all rooms were visited
        for (boolean room : visited) {
            if (!room) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        KeysAndRooms solution = new KeysAndRooms();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());
        System.out.println(solution.canVisitAllRooms(rooms));
    }
    
}
