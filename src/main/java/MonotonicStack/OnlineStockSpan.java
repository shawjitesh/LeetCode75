package MonotonicStack;

import java.util.Stack;

/**
 * Solution for Online Stock Span problem.
 * Calculates the span of stock's price for the current day.
 */
public class OnlineStockSpan {

    private Stack<int[]> prices;
    // private Deque<Integer> prices;

    /**
     * Initializes the stock span calculator.
     */
    public OnlineStockSpan() {
        prices = new Stack<>();
        // prices = new ArrayDeque<>();
    }
    
    /**
     * Returns the span of the stock's price for the current day.
     * The span is defined as the maximum number of consecutive days (including today)
     * for which the stock price was less than or equal to today's price.
     *
     * @param price the stock price for the current day
     * @return the span of the stock's price
     */
    public int next(int price) {

        int span = 1;
        while (!prices.isEmpty() && prices.peek()[0] <= price) {
            span += prices.pop()[1];
        }
        
        prices.push(new int[] {price, span});

        // // Add current price to the front (most recent)
        // prices.offerFirst(price);
        
        // int span = 0;
        // // Iterate from most recent to oldest (LIFO behavior)
        // for (int currentPrice : prices) {
        //     if (currentPrice <= price) {
        //         span++;
        //     } else {
        //         // Stop counting when we find a price greater than current
        //         // (not consecutive anymore)
        //         break;
        //     }
        // }
        
        return span;
    }

    public static void main(String[] args) {
        OnlineStockSpan onlineStockSpan = new OnlineStockSpan();
        System.out.println(onlineStockSpan.next(100));
        System.out.println(onlineStockSpan.next(80));
        System.out.println(onlineStockSpan.next(60));
        System.out.println(onlineStockSpan.next(70));
        System.out.println(onlineStockSpan.next(60));
        System.out.println(onlineStockSpan.next(75));
        System.out.println(onlineStockSpan.next(85));
    }
    
}
