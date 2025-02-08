/**
 322. Coin Change

 Medium

 You are given an integer array `coins` representing coins of different denominations and an integer `amount` representing a total amount of money.

 Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 You may assume that you have an infinite number of each kind of coin.

 Example 1:
 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1

 Example 2:
 Input: coins = [2], amount = 3
 Output: -1

 Example 3:
 Input: coins = [1], amount = 0
 Output: 0

 Constraints:
 - 1 <= coins.length <= 12
 - 1 <= coins[i] <= 231 - 1
 - 0 <= amount <= 104
 */

import java.util.Arrays;

public class CoinChange {

    // ==================================================
    // Solution: Dynamic Programming approach to find the minimum number of coins
    // ==================================================
    public int coinChange(int[] coins, int amount) {
        // Create an array to store the minimum coins needed for each amount
        int[] dp = new int[amount + 1];

        // Fill dp array with a large number (greater than the possible max)
        Arrays.fill(dp, amount + 1);

        // Base case: The minimum coins needed to make amount 0 is 0
        dp[0] = 0;

        // Iterate through each coin and for each coin, update the dp array
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] is still greater than amount, it means it's not possible to make the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        CoinChange solution = new CoinChange();

        // Test case 1: coins = [1, 2, 5], amount = 11
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Test case 1: " + solution.coinChange(coins1, amount1)); // Output: 3 (11 = 5 + 5 + 1)

        // Test case 2: coins = [2], amount = 3
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Test case 2: " + solution.coinChange(coins2, amount2)); // Output: -1

        // Test case 3: coins = [1], amount = 0
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Test case 3: " + solution.coinChange(coins3, amount3)); // Output: 0
    }
}
