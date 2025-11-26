package Intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Solution for Non-overlapping Intervals problem.
 * Finds the minimum number of intervals to remove to make the rest non-overlapping.
 */
public class NonOverlappingIntervals {

    /**
     * Returns the minimum number of intervals to remove.
     *
     * @param intervals array of intervals where each interval is [start, end]
     * @return minimum number of intervals to remove
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int k = Integer.MIN_VALUE, overlappingIntervals = 0;
        int intervalsLength = intervals.length;

        for (int i = 0; i < intervalsLength; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= k) {
                k = end;
            } else {
                overlappingIntervals++;
            }
        }
        
        return overlappingIntervals;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(new int[][] {{1,2},{2,3},{3,4},{1,3}}));
    }
    
}
