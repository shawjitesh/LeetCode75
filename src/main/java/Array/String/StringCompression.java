package Array.String;

/**
 * Solution for LeetCode 75 - String Compression
 * Compresses a string by replacing consecutive duplicate characters with the character followed by its count.
 */
public class StringCompression {

    /**
     * Compresses a string in-place by replacing consecutive duplicate characters.
     * 
     * @param chars the character array to compress
     * @return the new length of the compressed array
     */
    private int compress(char[] chars) {
        int writeIndex = 0; 
        int readIndex = 0;  
        
        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 1;
            
            while (readIndex + count < chars.length && chars[readIndex + count] == currentChar) {
                count++;
            }
            
            chars[writeIndex++] = currentChar;
            
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char digit : countStr.toCharArray()) {
                    chars[writeIndex++] = digit;
                }
            }
            
            readIndex += count;
        }
        
        return writeIndex;
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
