/**
 1518. Water Bottles

 Easy

 You have n water bottles, and each time you drink one bottle of water, you can exchange k empty bottles for one full bottle.

 The operation continues until you no longer have enough empty bottles to exchange for a full bottle.

 Given the two integers n and k, return the maximum number of bottles you can drink.

 Example 1:
 Input: n = 9, k = 3
 Output: 13
 Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
 Number of water bottles you can drink initially: 9
 Number of water bottles after exchanging: 9 / 3 = 3
 Number of water bottles after next exchange: 3 / 3 = 1
 In total, you can drink 9 + 3 + 1 = 13 bottles.

 Example 2:
 Input: n = 15, k = 4
 Output: 19
 Explanation: You can exchange 4 empty bottles to get 1 full water bottle.
 Number of water bottles you can drink initially: 15
 Number of water bottles after exchanging: 15 / 4 = 3
 Number of water bottles after next exchange: 3 / 4 = 0
 In total, you can drink 15 + 3 + 1 = 19 bottles.

 Constraints:
 1 <= n <= 100
 2 <= k <= 100
 */

public class WaterBottles {

    // ==================================================
    // Solution 1: Recursive approach to calculate water bottles
    // ==================================================
    public int numWaterBottles(int numBottles, int numExchange) {
        // Base case: if there are not enough empty bottles to exchange
        if (numBottles < numExchange) {
            return numBottles;
        }

        // Calculate the number of full bottles after exchanging
        int exchanged = numBottles / numExchange;
        int remainder = numBottles % numExchange;

        // Total is the current number of bottles and recursively add the bottles after exchange
        return numBottles + numWaterBottles(exchanged + remainder, numExchange);
    }

    // ==================================================
    // Solution 2: Iterative approach to calculate water bottles
    // ==================================================
    public int numWaterBottlesIterative(int numBottles, int numExchange) {
        int totalBottlesDrank = numBottles;
        int emptyBottles = numBottles;

        // Loop until there are not enough empty bottles to exchange
        while (emptyBottles >= numExchange) {
            int exchanged = emptyBottles / numExchange;
            int remainder = emptyBottles % numExchange;
            totalBottlesDrank += exchanged;
            emptyBottles = exchanged + remainder;
        }

        return totalBottlesDrank;
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        WaterBottles solution = new WaterBottles();

        // Test case 1:
        int numBottles1 = 9;
        int numExchange1 = 3;
        int result1 = solution.numWaterBottles(numBottles1, numExchange1);
        System.out.println("Test case 1 (Recursive): " + result1); // Output: 13

        // Test case 2:
        int numBottles2 = 15;
        int numExchange2 = 4;
        int result2 = solution.numWaterBottlesIterative(numBottles2, numExchange2);
        System.out.println("Test case 2 (Iterative): " + result2); // Output: 19
    }
}
