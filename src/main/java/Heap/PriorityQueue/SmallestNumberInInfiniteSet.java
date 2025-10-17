package Heap.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

/**
 * Implementation of SmallestInfiniteSet that efficiently manages an infinite set of positive integers.
 * Uses a priority queue to handle numbers that were removed and added back.
 */
public class SmallestNumberInInfiniteSet {

    private int currentSmallest;
    private PriorityQueue<Integer> addedBack;
    private Set<Integer> addedBackSet;

    /**
     * Initializes the SmallestInfiniteSet with all positive integers.
     */
    public SmallestNumberInInfiniteSet() {
        currentSmallest = 1;
        addedBack = new PriorityQueue<>();
        addedBackSet = new HashSet<>();
    }
    
    /**
     * Removes and returns the smallest integer from the set.
     * @return the smallest integer that was in the set
     */
    public int popSmallest() {
        // If there are numbers that were added back, return the smallest one
        if (!addedBack.isEmpty()) {
            int smallest = addedBack.poll();
            addedBackSet.remove(smallest);
            return smallest;
        }
        
        // Otherwise, return the current smallest from the infinite set
        return currentSmallest++;
    }
    
    /**
     * Adds a positive integer back to the set if it was previously removed.
     * @param num the positive integer to add back
     */
    public void addBack(int num) {
        // Only add back if the number is less than currentSmallest (meaning it was removed)
        // and it's not already in the addedBack set
        if (num < currentSmallest && !addedBackSet.contains(num)) {
            addedBack.offer(num);
            addedBackSet.add(num);
        }
    }

    public static void main(String[] args) {
        SmallestNumberInInfiniteSet solution = new SmallestNumberInInfiniteSet();
        solution.addBack(2);
        System.out.println(solution.popSmallest());
        System.out.println(solution.popSmallest());
        System.out.println(solution.popSmallest());
        solution.addBack(1);
        System.out.println(solution.popSmallest());
        System.out.println(solution.popSmallest());
    }
    
}
