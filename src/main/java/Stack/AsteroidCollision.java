package Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Solution for LeetCode 735: Asteroid Collision
 * 
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size, and the sign represents 
 * its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * 
 * Find out the state of the asteroids after all collisions. If two asteroids meet, 
 * the smaller one will explode. If both are the same size, both will explode.
 * 
 * Time Complexity: O(n) where n is the number of asteroids
 * Space Complexity: O(n) for the stack
 */
public class AsteroidCollision {

    /**
     * Simulates asteroid collisions and returns the final state of surviving asteroids.
     * 
     * @param asteroids array representing asteroids with positive/negative values for direction
     * @return array of surviving asteroids after all collisions
     */
    private int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            // Handle collision between positive (right-moving) and negative (left-moving) asteroids
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();
                
                if (Math.abs(top) > Math.abs(asteroid)) {
                    // Current asteroid is destroyed
                    asteroid = 0;
                    break;
                } else if (Math.abs(top) < Math.abs(asteroid)) {
                    // Top asteroid is destroyed
                    stack.pop();
                } else {
                    // Both asteroids are destroyed
                    stack.pop();
                    asteroid = 0;
                    break;
                }
            }
            
            // Push surviving asteroid
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }
        
        // Convert stack to array efficiently
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision solution = new AsteroidCollision();
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {-2, -2, 1, -2})));
    }
}
