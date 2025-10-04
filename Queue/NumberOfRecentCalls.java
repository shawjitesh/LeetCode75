package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Tracks recent requests within the last 3000 milliseconds.
 * Uses a queue to efficiently maintain only recent requests.
 */
class RecentCounter {

    private Queue<Integer> requests; // Queue to store request timestamps
    
    /**
     * Initializes the RecentCounter with an empty queue.
     */
    public RecentCounter() {
        this.requests = new LinkedList<>();
    }
    
    /**
     * Records a new request at time t and returns the number of requests
     * in the last 3000 milliseconds (including the current request).
     * 
     * @param t the timestamp of the new request
     * @return the number of recent requests in the last 3000ms
     */
    public int ping(int t) {
        // Add the new request timestamp
        this.requests.add(t);
        
        // Remove requests older than 3000ms from the front of queue
        while (this.requests.peek() < t - 3000) {
            this.requests.poll();
        }
        
        // Return count of recent requests
        return this.requests.size();
    }
    
    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }
}
