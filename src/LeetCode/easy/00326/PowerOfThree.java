/**
 * 326. Power of Three
 * Easy
 *
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * An integer n is a power of three if there exists an integer x such that n == 3^x.
 *
 * Example 1:
 * Input: n = 27
 * Output: true
 * Explanation: 3^3 = 27
 *
 * Example 2:
 * Input: n = 0
 * Output: false
 * Explanation: There is no x where 3^x = 0.
 *
 * Example 3:
 * Input: n = 9
 * Output: true
 * Explanation: 3^2 = 9
 *
 * Example 4:
 * Input: n = 45
 * Output: false
 *
 * Constraints:
 * -2^31 <= n <= 2^31 - 1
 */

public class PowerOfThree {

    public static void main(String[] args) {
        // Test cases for checking Power of Three
        testPowerOfThree(27, true);
        testPowerOfThree(9, true);
        testPowerOfThree(0, false);
        testPowerOfThree(45, false);
        testPowerOfThree(1, true);
    }

    /**
     * Method to test the Power of Three function.
     *
     * @param n        The number to be tested.
     * @param expected The expected boolean result.
     */
    public static void testPowerOfThree(int n, boolean expected) {
        boolean result = isPowerOfThree(n);
        System.out.println("Input: " + n);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        System.out.println("Test passed: " + (result == expected));
        System.out.println();
    }

    /**
     * Recursive solution to check if a number is a power of three.
     *
     * @param n The number to be tested.
     * @return True if n is a power of three, otherwise false.
     */
    public static boolean isPowerOfThree(int n) {
        // Base case: if n is 1, it's a power of three (3^0 = 1)
        if (n == 1) {
            return true;
        }
        // Base case: if n is less than or equal to 0 or n is not divisible by 3, it's not a power of three
        if (n <= 0 || n % 3 != 0) {
            return false;
        }
        // Recursive case: check if n / 3 is a power of three
        return isPowerOfThree(n / 3);
    }

    /**
     * Iterative solution using a loop to check if a number is a power of three.
     *
     * @param n The number to be tested.
     * @return True if n is a power of three, otherwise false.
     */
    public static boolean isPowerOfThree1(int n) {
        if (n <= 0) {
            return false;
        }

        // Loop until n becomes 1, continuously dividing by 3
        while (n > 1) {
            if (n % 3 != 0) {
                return false; // If n is not divisible by 3, it's not a power of three
            }
            n /= 3; // Divide n by 3
        }

        return true; // If we exit the loop with n = 1, it's a power of three
    }

    /**
     * Mathematical approach to check if a number is a power of three.
     * The maximum power of 3 that fits within the integer range is 3^19 = 1162261467.
     *
     * @param n The number to be tested.
     * @return True if n is a power of three, otherwise false.
     */
    public static boolean isPowerOfThree2(int n) {
        // 1162261467 is the largest power of 3 that fits in an integer (3^19)
        return n > 0 && 1162261467 % n == 0;
    }
}
