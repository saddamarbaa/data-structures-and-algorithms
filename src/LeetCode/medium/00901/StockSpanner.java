/**
 * 901. Online Stock Span
 *
 * Medium
 *
 * Write a class `StockSpanner` that collects daily price quotes for some stock,
 * and returns the span of that stock's price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of
 * consecutive days (starting from today and going backward) for which the price
 * of the stock was less than or equal to today's price.
 *
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85],
 * then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 *
 * Example 1:
 * Input
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * Output
 * [null, 1, 1, 1, 2, 1, 4, 6]
 *
 * Example 2:
 * Input
 * ["StockSpanner", "next", "next", "next", "next", "next"]
 * [[], [31], [41], [48], [59], [79]]
 * Output
 * [null, 1, 2, 3, 4, 5]
 *
 * Constraints:
 * - 1 <= price <= 105
 * - At most 104 calls will be made to `next`.
 */

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanner {

    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    /**
     * Returns the stock span for the current day's price.
     * Algorithm:
     * 1. Maintain a stack to keep track of the prices and their spans.
     * 2. While the stack's top element has a price less than or equal to the current price,
     *    pop the stack and accumulate the span.
     * 3. Push the current price and span onto the stack.
     *
     * Time Complexity: O(n) for each call to `next`, since each price is pushed and popped at most once.
     * Space Complexity: O(n) where n is the number of calls to `next`.
     *
     * @param price - The current price of the stock.
     * @return The span of the stock for the current day.
     */
    public int next(int price) {
        int span = 1;
        // While the stack is not empty and the current price is greater than or equal to the price on top of the stack
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];  // Add the span of the popped element to the current span
        }
        stack.push(new int[]{price, span});  // Push the current price and its span onto the stack
        return span;
    }

    public static void main(String[] args) {
        // Test case 1
        StockSpanner stockSpanner1 = new StockSpanner();
        System.out.println("Test Case 1 - Input: [100, 80, 60, 70, 60, 75, 85]");
        System.out.println("Test Case 1 - Expected result: [1, 1, 1, 2, 1, 4, 6]");
        int[] prices1 = {100, 80, 60, 70, 60, 75, 85};
        int[] expected1 = {1, 1, 1, 2, 1, 4, 6};
        for (int i = 0; i < prices1.length; i++) {
            int result = stockSpanner1.next(prices1[i]);
            System.out.println("Price: " + prices1[i] + " | Span: " + result + " | Expected: " + expected1[i]);
        }

        // Test case 2
        StockSpanner stockSpanner2 = new StockSpanner();
        System.out.println("Test Case 2 - Input: [31, 41, 48, 59, 79]");
        System.out.println("Test Case 2 - Expected result: [1, 2, 3, 4, 5]");
        int[] prices2 = {31, 41, 48, 59, 79};
        int[] expected2 = {1, 2, 3, 4, 5};
        for (int i = 0; i < prices2.length; i++) {
            int result = stockSpanner2.next(prices2[i]);
            System.out.println("Price: " + prices2[i] + " | Span: " + result + " | Expected: " + expected2[i]);
        }
    }
}



//  Brute force approach

 class StockSpanner2 {

    private ArrayList<Integer> prices;

    public StockSpanner2() {
        prices = new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);
        int span = 1;

        // Brute force approach: Compare the current price with all previous prices
        for (int i = prices.size() - 2; i >= 0; i--) {
            if (prices.get(i) <= price) {
                span++;
            } else {
                break;  // Stop when a previous price is greater than the current price
            }
        }
        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
    }
}
