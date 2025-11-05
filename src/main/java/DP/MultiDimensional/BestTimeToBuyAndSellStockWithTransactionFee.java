package DP.MultiDimensional;

/**
 * LeetCode 714: Best Time to Buy and Sell Stock with Transaction Fee
 * 
 * <p>Find the maximum profit you can achieve from buying and selling stocks.
 * You may complete as many transactions as you like, but you need to pay a 
 * transaction fee for each transaction (buy + sell).</p>
 * 
 * <p>Time Complexity: O(n) where n is the length of prices array</p>
 * <p>Space Complexity: O(1)</p>
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * Calculates maximum profit using state machine DP approach.
     * 
     * We maintain two states:
     * - hold: maximum profit when holding a stock
     * - sold: maximum profit when not holding a stock
     * 
     * @param prices array of stock prices for each day
     * @param fee transaction fee for each buy-sell transaction
     * @return maximum profit achievable
     */
    public int maxProfit(int[] prices, int fee) {
        // hold: max profit when holding a stock
        // sold: max profit when not holding a stock
        int hold = -prices[0]; // Start by buying on day 0
        int sold = 0; // Start with no stock
        
        for (int i = 1; i < prices.length; i++) {
            // On day i:
            // - To hold: either keep holding or buy today (from sold state)
            // - To sold: either keep not holding or sell today (from hold state, minus fee)
            int prevHold = hold;
            hold = Math.max(hold, sold - prices[i]);
            sold = Math.max(sold, prevHold + prices[i] - fee);
        }
        
        // At the end, we want to be in sold state (no stock held)
        return sold;
    }

    /**
     * Test cases for maxProfit solution.
     */
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee solution = new BestTimeToBuyAndSellStockWithTransactionFee();
        
        // Example 1: prices = [1,3,2,8,4,9], fee = 2
        int[] prices1 = {1, 3, 2, 8, 4, 9};
        System.out.println("Example 1: " + solution.maxProfit(prices1, 2)); // Expected: 8
        
        // Example 2: prices = [1,3,7,5,10,3], fee = 3
        int[] prices2 = {1, 3, 7, 5, 10, 3};
        System.out.println("Example 2: " + solution.maxProfit(prices2, 3)); // Expected: 6
    }
}
