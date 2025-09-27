package Array.String;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
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
