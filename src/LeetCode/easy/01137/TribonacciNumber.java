/***
 * 1137. N-th Tribonacci Number
 *
 * Easy
 *
 * The Tribonacci sequence T(n) is defined as follows:
 *
 * T(0) = 0, T(1) = 1, T(2) = 1, and T(n+3) = T(n) + T(n+1) + T(n+2) for n >= 0.
 *
 * Given `n`, return the value of T(n).
 *
 * Example:
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T(3) = T(2) + T(1) + T(0) = 1 + 1 + 0 = 2
 * T(4) = T(3) + T(2) + T(1) = 2 + 1 + 1 = 4
 *
 * Constraints:
 * - 0 <= n <= 37
 * - The answer is guaranteed to fit within a 32-bit integer, i.e., return value will be <= 2^31 - 1.
 */

public class TribonacciNumber {

    // ==================================================
    // Solution 1: Recursive Approach (inefficient)
    // ==================================================
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    // ==================================================
    // Solution 2: Iterative Approach (efficient)
    // ==================================================
    public int tribonacciIterative(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        TribonacciNumber solution = new TribonacciNumber();

        // Test case 1:
        int n = 4;
        System.out.println("Test case 1: " + solution.tribonacci(n)); // Output: 4
        System.out.println("Test case 1 (iterative): " + solution.tribonacciIterative(n)); // Output: 4

        // Test case 2:
        n = 25;
        System.out.println("Test case 2: " + solution.tribonacci(n)); // Output: 1389537
        System.out.println("Test case 2 (iterative): " + solution.tribonacciIterative(n)); // Output: 1389537
    }
}
