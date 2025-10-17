package PrefixSum;

/**
 * Solution for LeetCode 75 - Find the Highest Altitude
 * Find the highest altitude reached during a journey given altitude gains.
 */
public class FindTheHighestAltitude {
    /**
     * Finds the highest altitude reached during a journey.
     * Uses prefix sum technique to track cumulative altitude changes.
     * 
     * @param gain array of altitude gains/losses at each point
     * @return the highest altitude reached during the journey
     */
    private int largestAltitude(int[] gain) {
        int maxAltitude = 0;  // Track the highest altitude seen so far
        int currentAltitude = 0;  // Current altitude (starts at 0)

        // Process each altitude gain/loss
        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];  // Update current altitude
            maxAltitude = Math.max(maxAltitude, currentAltitude);  // Update max if needed
        }

        return maxAltitude;
    }

    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        FindTheHighestAltitude solution = new FindTheHighestAltitude();
        System.out.println(solution.largestAltitude(gain));
    }
}
