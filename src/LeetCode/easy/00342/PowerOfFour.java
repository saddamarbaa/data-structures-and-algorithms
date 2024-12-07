/**
 * 342. Power of Four
 * Easy
 *
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * An integer n is a power of four if there exists an integer x such that n == 4^x.
 *
 * Example 1:
 * Input: n = 16
 * Output: true
 * Explanation: 4^2 = 16
 *
 * Example 2:
 * Input: n = 5
 * Output: false
 *
 * Example 3:
 * Input: n = 1
 * Output: true
 * Explanation: 4^0 = 1
 *
 * Constraints:
 * -2^31 <= n <= 2^31 - 1
 */

public class PowerOfFour {

    public static void main(String[] args) {
        // Test cases for checking Power of Four
        testPowerOfFour(16, true);
        testPowerOfFour(5, false);
        testPowerOfFour(1, true);
        testPowerOfFour(64, true);
        testPowerOfFour(0, false);
        testPowerOfFour(-16, false);
    }

    /**
     * Method to test the Power of Four function.
     *
     * @param n        The number to be tested.
     * @param expected The expected boolean result.
     */
    public static void testPowerOfFour(int n, boolean expected) {
        boolean result = isPowerOfFour(n);
        System.out.println("Input: " + n);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        System.out.println("Test passed: " + (result == expected));
        System.out.println();
    }

    /**
     * Recursive solution to check if a number is a power of four.
     *
     * @param n The number to be tested.
     * @return True if n is a power of four, otherwise false.
     */
    public static boolean isPowerOfFour(int n) {
        // Base case: if n is 1, it's a power of four (4^0 = 1)
        if (n == 1) {
            return true;
        }
        // Base case: if n is less than or equal to 0, or n is not divisible by 4, it's not a power of four
        if (n <= 0 || n % 4 != 0) {
            return false;
        }
        // Recursive case: check if n / 4 is a power of four
        return isPowerOfFour(n / 4);
    }

    /**
     * Iterative solution using a loop to check if a number is a power of four.
     *
     * @param n The number to be tested.
     * @return True if n is a power of four, otherwise false.
     */
    public static boolean isPowerOfFour1(int n) {
        if (n <= 0) {
            return false;
        }

        // Loop until n becomes 1, continuously dividing by 4
        while (n > 1) {
            if (n % 4 != 0) {
                return false; // If n is not divisible by 4, it's not a power of four
            }
            n /= 4; // Divide n by 4
        }

        return true; // If we exit the loop with n = 1, it's a power of four
    }

    /**
     * Mathematical approach to check if a number is a power of four.
     * The largest power of 4 that fits within the integer range is 4^15 = 1073741824.
     *
     * @param n The number to be tested.
     * @return True if n is a power of four, otherwise false.
     */
    public static boolean isPowerOfFour2(int n) {
        // 1073741824 is the largest power of 4 that fits in an integer (4^15)
        return n > 0 && 1073741824 % n == 0;
    }

    /**
     * Bitwise approach to check if a number is a power of four.
     * A number is a power of four if:
     * - It's a power of two: (n & (n - 1)) == 0
     * - The only '1' bit is at an even position (in binary).
     *
     * @param n The number to be tested.
     * @return True if n is a power of four, otherwise false.
     */
    public static boolean isPowerOfFour3(int n) {
        // Check if n is a power of two and the only set bit is at an even position
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
    }
}
