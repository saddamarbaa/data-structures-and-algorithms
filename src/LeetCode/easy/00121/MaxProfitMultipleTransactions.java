/**
 121. Best Time to Buy and Sell Stock
 Easy

 You are given an array prices where prices[i] is the price of a given stock on the ith day.

 You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

 Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 Example 1:

 Input: prices = [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 Example 2:

 Input: prices = [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transactions are done and the max profit = 0.

 Constraints:

 1 <= prices.length <= 105
 0 <= prices[i] <= 104
 */
public class MaxProfitMultipleTransactions {
    public static void main(String[] args) {
        // Example 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1));  // Output: 7

        // Example 2
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices2));  // Output: 4

        // Example 3
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices3));  // Output: 0
    }


    /**
     * Algorithm:
     * 1. Initialize variables minPrice and maxProfit to track the minimum price and maximum profit.
     * 2. Iterate through the prices array from the second element.
     *    a. Update maxProfit by comparing it with the difference between the current price and minPrice.
     *    b. Update minPrice by comparing it with the current price.
     * 3. Return maxProfit.
     *
     * Time Complexity: O(n) - We iterate through the prices array once.
     * Space Complexity: O(1) - We use constant extra space.
     */
    public static int maxProfit(int[] prices) {
        // Check if the array is null or has fewer than two elements
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // Initialize variables to track minimum price and maximum profit
        int minPrice = prices[0];
        int maxProfit = 0;

        // Iterate through the prices array starting from the second element
        for (int i = 1; i < prices.length; i++) {
            // Update maxProfit by comparing with the difference between current price and minPrice
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            // Update minPrice by comparing with the current price
            minPrice = Math.min(minPrice, prices[i]);
        }

        // Return the maximum profit
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {

        int maxProfit = 0;

        // Outer loop: Consider each day as the buy day
        for (int buyDay = 0; buyDay < prices.length - 1; buyDay++) {
            // Inner loop: Consider each day after the buy day as the sell day
            for (int sellDay = buyDay + 1; sellDay < prices.length; sellDay++) {
                // Calculate the profit for the current buy-sell combination
                int currentProfit = prices[sellDay] - prices[buyDay];

                // Update maxProfit if the current combination yields a higher profit
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }

        return maxProfit;
    }
}
