/***
 746. Min Cost Climbing Stairs

 Easy

 You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

 You can either start from the step with index 0, or the step with index 1.

 Return the minimum cost to reach the top of the floor.

 Example 1:

 Input: cost = [10,15,20]
 Output: 15
 Explanation: You will start at index 1.
 - Pay 15 and climb two steps to reach the top.
 The total cost is 15.
 Example 2:

 Input: cost = [1,100,1,1,1,100,1,1,100,1]
 Output: 6
 Explanation: You will start at index 0.
 - Pay 1 and climb two steps to reach index 2.
 - Pay 1 and climb two steps to reach index 4.
 - Pay 1 and climb two steps to reach index 6.
 - Pay 1 and climb one step to reach index 7.
 - Pay 1 and climb two steps to reach index 9.
 - Pay 1 and climb one step to reach the top.
 The total cost is 6.


 Constraints:

 2 <= cost.length <= 1000
 0 <= cost[i] <= 999
 */
public class MinCostClimbingStairs {

    // ==================================================
    // Solution 1: Dynamic Programming with Tabulation
    // ==================================================
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1]; // dp[i] represents the minimum cost to reach step i

        // Base cases:
        dp[0] = cost[0]; // Cost to reach step 0
        dp[1] = cost[1]; // Cost to reach step 1

        // Fill the dp array
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]); // Choose the minimum cost path
        }

        // The top floor can be reached from either the last step or the second last step
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // ==================================================
    // Solution 2: Space-Optimized Dynamic Programming
    // ==================================================
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0]; // Cost to reach step 0
        int prev1 = cost[1]; // Cost to reach step 1

        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(prev1, prev2); // Choose the minimum cost path
            prev2 = prev1;
            prev1 = current;
        }

        // The top floor can be reached from either the last step or the second last step
        return Math.min(prev1, prev2);
    }

    // ==================================================
    // Solution 3: Recursive Approach with Memoization
    // ==================================================
    public int minCostClimbingStairs3(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n]; // Memoization array to store computed results
        return Math.min(helper(cost, 0, memo), helper(cost, 1, memo)); // Start from step 0 or step 1
    }

    private int helper(int[] cost, int index, int[] memo) {
        if (index >= cost.length) {
            return 0; // Reached the top, no more cost
        }
        if (memo[index] != 0) {
            return memo[index]; // Return the precomputed result
        }

        // Compute the cost for the current step and recursively for the next steps
        int currentCost = cost[index] + Math.min(helper(cost, index + 1, memo), helper(cost, index + 2, memo));
        memo[index] = currentCost; // Store the result in the memoization array
        return currentCost;
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        MinCostClimbingStairs solution = new MinCostClimbingStairs();

        // Test case 1:
        int[] cost1 = {10, 15, 20};
        System.out.println("Test case 1: " + solution.minCostClimbingStairs(cost1)); // Output: 15

        // Test case 2:
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Test case 2: " + solution.minCostClimbingStairs(cost2)); // Output: 6

        // Test case 3:
        int[] cost3 = {0, 0, 0, 1};
        System.out.println("Test case 3: " + solution.minCostClimbingStairs(cost3)); // Output: 0
    }
}