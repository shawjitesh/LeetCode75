package Heap.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LeetCode 2542: Maximum Subsequence Score
 * 
 * Find the maximum score from selecting k indices where:
 * Score = (sum of selected nums1 values) * (minimum of selected nums2 values)
 * 
 * Approach:
 * - Sort pairs by nums2 descending - ensures current element can be minimum
 * - Use min heap to track k largest nums1 values
 * - Calculate score when heap reaches size k
 * 
 * Time Complexity: O(n log n) - sorting
 * Space Complexity: O(k) - heap space
 */
public class MaximumSubsequenceScore {

    /**
     * Calculate the maximum score from selecting k indices
     * @param nums1 Array of values to sum
     * @param nums2 Array of values for minimum calculation
     * @param k Number of indices to select
     * @return Maximum possible score
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        
        // Create pairs of (nums1[i], nums2[i])
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] {nums1[i], nums2[i]};
        }
        
        // Sort by nums2 in descending order
        // This ensures that when we consider pairs[i][1] as the minimum,
        // all previous pairs have nums2 >= pairs[i][1]
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        
        // Min heap to keep track of k largest nums1 values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;
        
        for (int i = 0; i < n; i++) {
            int num1 = pairs[i][0];
            int num2 = pairs[i][1];
            
            sum += num1;
            minHeap.offer(num1);
            
            // If we have k elements, calculate the score
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * num2);
            }
            
            // If we have more than k elements, remove the smallest
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
                // Update maxScore again since we removed the smallest
                if (minHeap.size() == k) {
                    maxScore = Math.max(maxScore, sum * num2);
                }
            }
        }
        
        return maxScore;
    }

    public static void main(String[] args) {
        MaximumSubsequenceScore maximumSubsequenceScore = new MaximumSubsequenceScore();
        System.out.println(maximumSubsequenceScore.maxScore(new int[] {1,3,5,2,1,3,1}, new int[] {1,2,3,4,5,6,7}, 3));
    }
    
}
