package Intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution for Minimum Number of Arrows to Burst Balloons problem.
 * Finds the minimum number of arrows needed to burst all balloons.
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    /**
     * Returns the minimum number of arrows needed to burst all balloons.
     *
     * @param points array of balloon intervals where each interval is [start, end]
     * @return minimum number of arrows needed
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrows = 1, balloons = points.length;
        int firstEnd = points[0][1];
        for (int i = 1; i < balloons; i++) {
            if (points[i][0] > firstEnd) {
                arrows++;
                firstEnd = points[i][1];
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons minimumNumberOfArrowsToBurstBalloons = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(minimumNumberOfArrowsToBurstBalloons.findMinArrowShots(new int[][] {{1,2},{3,4},{5,6},{7,8}}));
    }
    
}
