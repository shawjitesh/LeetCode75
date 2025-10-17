package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Predicts the winner of the Dota2 Senate voting process.
 * Uses queue-based simulation to track active senators and their voting rights.
 */
public class Dota2Senate {

    /**
     * Predicts which party will win the senate voting process.
     * Each senator can ban the next opposing senator or announce victory.
     * 
     * @param senate string containing 'R' (Radiant) and 'D' (Dire) senators
     * @return "Radiant" or "Dire" based on which party wins
     */
    private String predictPartyVictory(String senate) {
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();
        
        // Initialize queues with senator indices
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }
        
        // Simulate the voting process
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiantIndex = radiantQueue.poll();
            int direIndex = direQueue.poll();
            
            // Senator with smaller index (goes first) bans the other
            if (radiantIndex < direIndex) {
                // Radiant senator bans Dire senator and gets to vote again
                radiantQueue.offer(radiantIndex + senate.length());
            } else {
                // Dire senator bans Radiant senator and gets to vote again
                direQueue.offer(direIndex + senate.length());
            }
        }
        
        // Return the party with remaining senators
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }
    
    public static void main(String[] args) {
        Dota2Senate dota2Senate = new Dota2Senate();
        System.out.println(dota2Senate.predictPartyVictory("RD"));
    }
}
