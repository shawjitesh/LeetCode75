package Array.String;

/**
 * Solution for LeetCode 75 - Reverse Vowels of a String
 * Reverses only the vowels in a string while keeping consonants in their original positions.
 */
public class ReverseVowelsOfAString {

    /**
     * Reverses only the vowels in a string.
     * 
     * @param s the input string
     * @return string with vowels reversed and consonants in original positions
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {

            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            
            while (left < right && !isVowel(chars[right])) {
                right--;
            }

            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(chars);
    }
    
    /**
     * Checks if a character is a vowel (case-insensitive).
     * 
     * @param c the character to check
     * @return true if the character is a vowel, false otherwise
     */
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString solution = new ReverseVowelsOfAString();
        System.out.println(solution.reverseVowels("leetcode"));
    }
}
