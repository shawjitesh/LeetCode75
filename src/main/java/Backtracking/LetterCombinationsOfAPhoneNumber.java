package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * 
 * Given a string containing digits from 2-9, return all possible letter combinations
 * that the number could represent on a telephone keypad.
 */
public class LetterCombinationsOfAPhoneNumber {

    /** Phone keypad mapping: digit to letters */
    private static final String[] PHONE_MAP = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    /**
     * Returns all possible letter combinations for the given digits.
     * 
     * @param digits String containing digits 2-9
     * @return List of all possible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    
    /**
     * Recursive backtracking helper to generate all combinations.
     * 
     * @param digits Input digit string
     * @param index Current position in digits
     * @param current Current combination being built
     * @param result List to store all combinations
     */
    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        char digit = digits.charAt(index);
        String letters = PHONE_MAP[digit - '0'];
        
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();
        System.out.println(solution.letterCombinations("23"));
    }
}
