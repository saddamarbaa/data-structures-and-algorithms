/**
 * 231. Power of Two
 * Easy
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two if there exists an integer x such that n == 2^x.
 *
 * Example 1:
 * Input: n = 1
 * Output: true
 * Explanation: 2^0 = 1
 *
 * Example 2:
 * Input: n = 16
 * Output: true
 * Explanation: 2^4 = 16
 *
 * Example 3:
 * Input: n = 3
 * Output: false
 *
 * Constraints:
 * -231 <= n <= 231 - 1
 */

public class PowerOfTwo {

    public static void main(String[] args) {
        // Test cases for checking Power of Two
        testPowerOfTwo(1, true);
        testPowerOfTwo(16, true);
        testPowerOfTwo(3, false);
        testPowerOfTwo(4, true);
        testPowerOfTwo(0, false);
        testPowerOfTwo(-16, false);
    }

    /**
     * Method to test the Power of Two function.
     *
     * @param n        The number to be tested.
     * @param expected The expected boolean result.
     */
    public static void testPowerOfTwo(int n, boolean expected) {
        boolean result = isPowerOfTwo(n);
        System.out.println("Input: " + n);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        System.out.println("Test passed: " + (result == expected));
        System.out.println();
    }


    public static boolean isPowerOfTwo(int n) {
        // Base case: if n is 1, it is a power of two (2^0 = 1)
        if (n == 1) {
            return true;
        }
        // Base case: if n is less than or equal to 0, or n is not divisible by 2, it's not a power of two
        if (n <= 0 || n % 2 != 0) {
            return false;
        }
        // Recursive case: check if n / 2 is a power of two
        return isPowerOfTwo(n / 2);
    }


    public static boolean isPowerOfTwo1(int n) {
        if (n <= 0) {
            return false;
        }

        // Loop until n becomes 1, continuously dividing by 2
        while (n > 1) {
            if (n % 2 != 0) {
                return false; // If n is not divisible by 2, it's not a power of two
            }
            n /= 2; // Divide n by 2
        }

        return true; // If we exit the loop with n = 1, it's a power of two
    }

    public static boolean isPowerOfTwo2(int n) {
        // A power of two will have only one bit set in its binary representation
        // Example: 16 -> 10000 (binary), n & (n - 1) would be 0 if it's a power of two
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
