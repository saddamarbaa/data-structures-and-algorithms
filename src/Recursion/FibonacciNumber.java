/*
509. Fibonacci Number
Easy
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is
 the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

Constraints:
0 <= n <= 30
 */

public class FibonacciNumber {
    public static void main(String[] args) {
        // Test Case 1 - n = 0
        int n1 = 0;
        int expected1 = 0;
        int result1 = fib(n1);
        runTestCase(n1, expected1, result1);

        // Test Case 2 - n = 1
        int n2 = 1;
        int expected2 = 1;
        int result2 = fib(n2);
        runTestCase(n2, expected2, result2);

        // Test Case 3 - n = 5
        int n3 = 5;
        int expected3 = 5;
        int result3 = fib(n3);
        runTestCase(n3, expected3, result3);

        // Test Case 4 - n = 10
        int n4 = 10;
        int expected4 = 55;
        int result4 = fib(n4);
        runTestCase(n4, expected4, result4);

        // Test Case 5 - n = negative number
        int n5 = -3;
        int expected5 = -1;
        int result5 = fib(n5);
        runTestCase(n5, expected5, result5);




        int n6 = 6;
        int expected6 = 8;
        int result6 = fib(n6);
        runTestCase(n6, expected6, result6);
    }

    public static void runTestCase(int n, int expected, int result) {
        System.out.println("Test Case - Input: " + n);
        System.out.println("Test Case - Expected result: " + expected);
        System.out.println("Test Case - Actual result: " + result);
        System.out.println("Test Case - Result matches expected: " + (result == expected));
        System.out.println();
    }


    /**
     * Given an array nums and an integer numRotations, rotate the array to the right by numRotations.
     * Function signature: public static void rotateArray(int[] nums, int numRotations)
     * Algorithm Steps:
     * Check if the input n is negative. If it is, return -1.
     * Create an array memo with length n+1 to store the Fibonacci sequence values.
     * Call the helper function fibHelper passing in n and memo.
     * In the fibHelper function:
     * a. Check if the value of n is less than or equal to 1. If it is, return n.
     * b. Check if the value of memo[n] is not 0. If it is not 0, return memo[n].
     * c. Calculate the value of fibHelper(n - 1, memo) + fibHelper(n - 2, memo) and store it in memo[n].
     * d. Return memo[n].
     * Time Complexity: The time complexity of this function is O(n), where n is the input n. This is because each
     * value of n is computed only once and stored in the memo array. Therefore, subsequent calculations of fib(n)
     * take O(1) time.
     * Space Complexity: The space complexity of this function is O(n), where n is the input n. This is because we
     * use an array of size n+1 to store the Fibonacci sequence values in memo.
     */
    public static int fib(int n) {
        if (n < 0) {
            return -1; // Invalid input, return -1
        }
        int[] memo = new int[n + 1]; // memoization array
        return fibHelper(n, memo);
    }

    public static int fibHelper(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n]; // if value already computed, return it
        memo[n] = fibHelper(n - 1, memo) + fibHelper(n - 2, memo); // compute and memoize value
        return memo[n];
    }


    public static int fib2(int n) {
        if (n <= 1) return n;
        int num1 = 0, num2 = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return sum;
    }


    public static int fib3(int n) {
        if (n <= 1) return n;
      return  fib(n - 1) + fib(n - 2);
    }
}
