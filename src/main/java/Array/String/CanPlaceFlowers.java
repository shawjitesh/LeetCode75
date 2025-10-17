package Array.String;

/**
 * Solution for LeetCode 75 - Can Place Flowers
 * Determines if n new flowers can be planted in a flowerbed without violating the no-adjacent-flowers rule.
 */
public class CanPlaceFlowers {

    /**
     * Determines if n new flowers can be planted in a flowerbed.
     * 
     * @param flowerbed array representing the flowerbed (0 = empty, 1 = planted)
     * @param n the number of new flowers to plant
     * @return true if n flowers can be planted, false otherwise
     */
    private boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[] {0,0,0,0,1}, 2));
    }
    
}
