package Heap.PriorityQueue;

import java.util.PriorityQueue;

/**
 * Solution for LeetCode 75 - Kth Largest Element in an Array
 * Finds the kth largest element in an unsorted array using a min heap.
 */
public class KthLargestElementInAnArray {

    /**
     * Finds the kth largest element in an unsorted array.
     * 
     * @param nums the input array
     * @param k the position of the largest element to find
     * @return the kth largest element
     */
    public int findKthLargest(int[] nums, int k) {
        // Use a min heap to keep track of the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            
            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The root of the min heap is the kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums, k));
    }
}
