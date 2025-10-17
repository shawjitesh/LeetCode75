package Stack;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Solution for LeetCode 2390: Removing Stars From a String
 * 
 * Given a string s, which contains stars '*', apply the following operation:
 * - In one operation, you can choose a star and remove the closest non-star character to its left
 * - Remove all stars from the string
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) for the stack
 */
public class RemovingStarsFromAString {

    /**
     * Removes all stars from the string by simulating the removal operation.
     * 
     * @param s input string containing stars and characters
     * @return string with all stars removed and characters popped as per operation rules
     */
    private String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Process each character in the string
        for (char c : s.toCharArray()) {
            if (c == '*' && !stack.isEmpty()) {
                // Remove the closest non-star character to the left
                stack.pop();
            } else {
                // Push non-star characters onto the stack
                stack.push(c);
            }
        }
        
        // Convert stack to string
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        RemovingStarsFromAString solution = new RemovingStarsFromAString();
        System.out.println(solution.removeStars("leet**cod*e"));
    }
    
}
