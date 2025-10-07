package SlidingWindow;

/**
 * Solution for LeetCode 75 - Maximum Number of Vowels in a Substring of Given Length
 * Find the maximum number of vowel letters in any substring of length k using sliding window technique.
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public int maxVowels(String s, int k) {
        // Count vowels in the first window of size k
        int currentVowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }
        
        int maxVowels = currentVowels;
        
        // Slide the window: remove the leftmost character and add the new rightmost character
        for (int i = k; i < s.length(); i++) {
            // Remove the character going out of the window
            if (isVowel(s.charAt(i - k))) {
                currentVowels--;
            }
            // Add the new character coming into the window
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
            // Update the maximum
            maxVowels = Math.max(maxVowels, currentVowels);
        }
        
        return maxVowels;
    }

    // Helper method to check if a character is a vowel
    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        MaximumNumberOfVowelsInASubstringOfGivenLength solution = new MaximumNumberOfVowelsInASubstringOfGivenLength();
        System.out.println(solution.maxVowels(s, k));
    }
}
