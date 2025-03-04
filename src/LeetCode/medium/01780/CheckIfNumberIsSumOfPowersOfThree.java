/*
1780. Check if Number is a Sum of Powers of Three
Medium

Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.

An integer y is a power of three if there exists an integer x such that y == 3^x.

Example 1:

Input: n = 12
Output: true
Explanation: 12 = 3^1 + 3^2

Example 2:

Input: n = 91
Output: true
Explanation: 91 = 3^0 + 3^2 + 3^3 + 3^4

Example 3:

Input: n = 21
Output: false

Constraints:

1 <= n <= 10^7
*/

import java.util.ArrayList;
import java.util.List;

public class CheckIfNumberIsSumOfPowersOfThree {
    public static void main(String[] args) {
        int input1 = 12;
        boolean expected1 = true;
        boolean result1 = checkPowersOfThree(input1);
        System.out.println("Test Case 1 - Input: " + input1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        int input2 = 91;
        boolean expected2 = true;
        boolean result2 = checkPowersOfThree(input2);
        System.out.println("Test Case 2 - Input: " + input2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        int input3 = 21;
        boolean expected3 = false;
        boolean result3 = checkPowersOfThree(input3);
        System.out.println("Test Case 3 - Input: " + input3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));
    }

    /**
     * Solution 1: Using Ternary Representation
     *
     * Algorithm Steps:
     * 1. Convert the number to its ternary (base-3) representation.
     * 2. Check if the ternary representation contains the digit '2'.
     *    - If it does, the number cannot be represented as the sum of distinct powers of three.
     *    - If it doesn't, the number can be represented as the sum of distinct powers of three.
     *
     * Time Complexity: O(log n), where n is the input number.
     * Space Complexity: O(1), as we are using constant space.
     */
    public static boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    /**
     * Solution 2: Using Recursion (Backtracking)
     *
     * Algorithm Steps:
     * 1. Start with the largest power of three less than or equal to n.
     * 2. Recursively check if the remaining number can be represented as the sum of distinct powers of three.
     * 3. If at any point the remaining number is zero, return true.
     * 4. If no valid combination is found, return false.
     *
     * Time Complexity: O(log n), where n is the input number.
     * Space Complexity: O(log n), due to the recursion stack.
     */
    public static boolean checkPowersOfThree2(int n) {
        return backtrack(n, 1);
    }

    private static boolean backtrack(int n, int power) {
        if (n == 0) {
            return true;
        }
        if (power > n) {
            return false;
        }
        // Try including the current power of three
        if (backtrack(n - power, power * 3)) {
            return true;
        }
        // Try excluding the current power of three
        return backtrack(n, power * 3);
    }

    /**
     * Solution 3: Using Iterative Approach
     *
     * Algorithm Steps:
     * 1. Iterate through the powers of three in ascending order.
     * 2. Subtract the current power of three from n if it is less than or equal to n.
     * 3. If n becomes zero, return true.
     * 4. If the current power of three exceeds n, return false.
     *
     * Time Complexity: O(log n), where n is the input number.
     * Space Complexity: O(1), as we are using constant space.
     */
    public static boolean checkPowersOfThree3(int n) {
        int power = 1;
        while (power <= n) {
            if (n >= power) {
                n -= power;
            }
            if (n == 0) {
                return true;
            }
            power *= 3;
        }
        return false;
    }
}