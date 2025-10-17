package BinarySearch;

/**
 * LeetCode 374: Guess Number Higher or Lower
 * Uses binary search to find the picked number efficiently.
 */
public class GuessNumberHigherOrLower {

    // Pre-defined API method (simulated)
    private int pick; // The number to be guessed
    
    private GuessNumberHigherOrLower() {
        this.pick = 6; // Default pick value
    }
    
    private GuessNumberHigherOrLower(int pick) {
        this.pick = pick;
    }
    
    private int guess(int num) {
        // This is a simulation - in the actual LeetCode problem, this API is provided
        if (num > pick) {
            return -1; // Your guess is higher
        } else if (num < pick) {
            return 1;  // Your guess is lower
        } else {
            return 0;  // Your guess is correct
        }
    }

    /**
     * Find the picked number using binary search.
     * @param n the upper bound of the number range [1, n]
     * @return the picked number
     */
    private int guessNumber(int n) {
        int left = 1;
        int right = n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            int result = guess(mid);
            
            if (result == 0) {
                return mid; // Found the number
            } else if (result == -1) {
                // Our guess is too high, search in left half
                right = mid - 1;
            } else {
                // Our guess is too low, search in right half
                left = mid + 1;
            }
        }
        
        return -1; // Should never reach here given the problem constraints
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower solution = new GuessNumberHigherOrLower(6);
        System.out.println(solution.guessNumber(10));
    }
    
}
