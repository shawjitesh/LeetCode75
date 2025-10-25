package BinarySearch;

/**
 * Solution for LeetCode 875: Koko Eating Bananas
 * Uses binary search to find minimum eating speed to finish all bananas within time limit.
 */
public class KokoEatingBananas {

    /**
     * Finds the minimum integer k such that Koko can eat all bananas within h hours.
     * 
     * @param piles array of banana pile sizes
     * @param h maximum hours available
     * @return minimum eating speed k
     */
    public int minEatingSpeed(int[] piles, int h) {
        // Binary search on the eating speed
        int left = 1; // minimum possible speed
        int right = getMaxPile(piles); // maximum possible speed (eating the largest pile in 1 hour)
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canEatAllBananas(piles, h, mid)) {
                // If we can eat all bananas with speed 'mid', try a smaller speed
                right = mid;
            } else {
                // If we can't eat all bananas with speed 'mid', we need a larger speed
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    /**
     * Checks if all bananas can be eaten with given speed within time limit.
     * 
     * @param piles array of banana pile sizes
     * @param h maximum hours available
     * @param speed eating speed to test
     * @return true if all bananas can be eaten within time limit
     */
    private boolean canEatAllBananas(int[] piles, int h, int speed) {
        int totalTime = 0;
        
        for (int pile : piles) {
            // Time to eat a pile = ceiling(pile / speed)
            // We can calculate this as (pile + speed - 1) / speed
            totalTime += (pile + speed - 1) / speed;
            
            // Early termination if we exceed time limit
            if (totalTime > h) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Finds the maximum pile size in the array.
     * 
     * @param piles array of banana pile sizes
     * @return maximum pile size
     */
    private int getMaxPile(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(solution.minEatingSpeed(piles, h));
    }
    
}
