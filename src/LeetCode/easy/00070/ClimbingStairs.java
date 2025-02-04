/***
 * 70. Climbing Stairs
 *
 * Easy
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example:
 * Input: n = 3
 * Output: 3
 * Explanation:
 * There are three ways to climb to the top:
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 * - 1 <= n <= 45
 */

public class ClimbingStairs {

    // ==================================================
    // Solution 1: Recursive Approach (inefficient)
    // ==================================================
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // ==================================================
    // Solution 2: Iterative Approach (efficient)
    // ==================================================
    public int climbStairsIterative(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();

        // Test case 1:
        int n = 3;
        System.out.println("Test case 1: " + solution.climbStairs(n)); // Output: 3
        System.out.println("Test case 1 (iterative): " + solution.climbStairsIterative(n)); // Output: 3

        // Test case 2:
        n = 5;
        System.out.println("Test case 2: " + solution.climbStairs(n)); // Output: 8
        System.out.println("Test case 2 (iterative): " + solution.climbStairsIterative(n)); // Output: 8
    }
}
