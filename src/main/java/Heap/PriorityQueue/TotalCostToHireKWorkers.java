package Heap.PriorityQueue;

import java.util.PriorityQueue;

/**
 * LeetCode 2462: Total Cost to Hire K Workers
 * 
 * Find the total cost to hire k workers by selecting candidates from either end,
 * choosing the worker with minimum cost each time.
 * 
 * Approach:
 * - Use two min heaps to maintain smallest candidates from left and right ends
 * - Pre-fill both heaps with candidates from each end
 * - For each of k rounds, pick minimum from either heap and refill that side
 * 
 * Time Complexity: O(n log candidates) - heap operations
 * Space Complexity: O(candidates) - heap space
 */
public class TotalCostToHireKWorkers {

    /**
     * Calculate total cost to hire k workers
     * @param costs Array of costs for each worker
     * @param k Number of workers to hire
     * @param candidates Number of candidates to consider from each end
     * @return Total cost to hire k workers
     */
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int left = 0, right = n - 1;
        long total = 0;

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        // Pre-fill both heaps
        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.offer(costs[left++]);
        }
        for (int i = 0; i < candidates && left <= right; i++) {
            rightHeap.offer(costs[right--]);
        }

        for (int i = 0; i < k; i++) {
            int leftMin = leftHeap.isEmpty() ? Integer.MAX_VALUE : leftHeap.peek();
            int rightMin = rightHeap.isEmpty() ? Integer.MAX_VALUE : rightHeap.peek();

            if (leftMin <= rightMin) {
                total += leftHeap.poll();
                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }
            } else {
                total += rightHeap.poll();
                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        TotalCostToHireKWorkers solution = new TotalCostToHireKWorkers();
        System.out.println(solution.totalCost(new int[] {1,2,4,1}, 3, 3));
    }
    
}
