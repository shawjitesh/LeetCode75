package Stack;

import java.util.Stack;

/**
 * Decodes a string containing encoded patterns like "3[a]2[bc]" into "aaabcbc".
 * Uses stack-based approach to handle nested patterns efficiently.
 */
public class DecodeString {

    /**
     * Decodes the input string by expanding encoded patterns.
     * 
     * @param s the encoded string containing patterns like "k[encoded_string]"
     * @return the decoded string
     */
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current number and string to stacks
                numStack.push(num);
                stringStack.push(currentString.toString());
                // Reset for the new string inside brackets
                num = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                // Pop the number and previous string
                int repeat = numStack.pop();
                String prevString = stringStack.pop();
                
                // Build the repeated string
                StringBuilder temp = new StringBuilder(prevString);
                for (int i = 0; i < repeat; i++) {
                    temp.append(currentString);
                }
                currentString = temp;
            } else {
                // Regular character
                currentString.append(c);
            }
        }
        
        return currentString.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        System.out.println(solution.decodeString("2[3[4[a]]]"));
    }
    
}
