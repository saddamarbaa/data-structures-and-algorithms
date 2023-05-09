/*
69. Sqrt(x)
Easy
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer
 should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */

public class Sqrt {
    public static void main(String[] args) {
        // Test Case 1: Input is a perfect square
        int x1 = 16;
        int expected1 = 4;
        int result1 = mySqrt(x1);
        System.out.println("Test Case 1 - Input: " + x1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test Case 2: Input is not a perfect square
        int x2 = 7;
        int expected2 = 2;
        int result2 = mySqrt(x2);
        System.out.println("Test Case 2 - Input: " + x2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test Case 3: Input is 0
        int x3 = 0;
        int expected3 = 0;
        int result3 = mySqrt(x3);
        System.out.println("Test Case 3 - Input: " + x3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test Case 4: Input is 1
        int x4 = 1;
        int expected4 = 1;
        int result4 = mySqrt(x4);
        System.out.println("Test Case 4 - Input: " + x4);
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));


        // Test Case 5: Input is a very large number
        int x5 = 2147395600;
        int expected5 = 46340;
        int result5 = mySqrt(x5);
        System.out.println("Test Case 5 - Input: " + x5);
        System.out.println("Test Case 5 - Expected result: " + expected5);
        System.out.println("Test Case 5 - Actual result: " + result5);
        System.out.println("Test Case 5 - Result matches expected: " + (result5 == expected5));
    }


    /**
     * Write a function that Given a non-negative integer x, return the square root of x rounded down to the nearest
     * integer. The returned integer should be non-negative as well..
     * Algorithm Steps:
     * Initialize the low and high variables to the first and last indices of the array respectively.
     * While the low index is less than or equal to the high index:
     * Calculate the mid index as the average of the low and high indices (to avoid integer overflow, use the
     * expression mid = low + (high - low) / 2 instead of mid = (low + high) / 2).
     * If the value at the mid index is equal to the key, return the mid index.
     * If the value at the mid index is greater than the key, update the high index to be the index immediately to
     * the left of the mid index.
     * If the value at the mid index is less than the key, update the low index to be the index immediately to the
     * right of the mid index.
     * If the key is not found in the array, return -1.
     * Time Complexity:
     * The algorithm visits each element in the search space (i.e., the portion of the array between the low and high
     * indices) at most three times.
     * Therefore, the time complexity is O(log n), where n is the length of the input array.
     * Space Complexity:
     * The algorithm uses a constant amount of additional space.
     * Therefore, the space complexity is O(1).
     */
    public static int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int low = 1;
        int high = x / 2;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long num = (long) mid * mid;

            if (num == x) {
                return mid;
            } else if (num < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}





