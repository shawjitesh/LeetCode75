package Array.String;

/**
 * Solution for LeetCode 75 - Reverse Words in a String
 * Reverses the order of words in a string while maintaining single spaces between words.
 */
public class ReverseWordsInAString {

    /**
     * Reverses the order of words in a string.
     * 
     * @param s the input string
     * @return string with words in reversed order
     */
    private String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                result.append(words[i]).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.println(reverseWordsInAString.reverseWords("a good   example"));
    }
    
}
