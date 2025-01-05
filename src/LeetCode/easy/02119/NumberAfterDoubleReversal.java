/**
 2119. A Number After a Double Reversal
 Easy
 Reversing an integer means to reverse all its digits.

 For example, reversing 2021 gives 1202. Reversing 12300 gives 321 as the leading zeros are not retained.
 Given an integer num, reverse num to get reversed1, then reverse reversed1 to get reversed2. Return true if reversed2 equals num. Otherwise return false.

 Example 1:

 Input: num = 526
 Output: true
 Explanation: Reverse num to get 625, then reverse 625 to get 526, which equals num.
 Example 2:

 Input: num = 1800
 Output: false
 Explanation: Reverse num to get 81, then reverse 81 to get 18, which does not equal num.
 Example 3:

 Input: num = 0
 Output: true
 Explanation: Reverse num to get 0, then reverse 0 to get 0, which equals num.

 */
public class NumberAfterDoubleReversal {

    public static void main(String[] args) {
        testDoubleReversalFunction();
    }

    public static void testDoubleReversalFunction() {
        // Test case 1: Number with no trailing zeros
        int num1 = 123;
        boolean expected1 = true;
        boolean result1 = isSameAfterReversals(num1);
        System.out.println("Test Case 1 - Input: " + num1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2: Number with trailing zeros
        int num2 = 120;
        boolean expected2 = false;
        boolean result2 = isSameAfterReversals(num2);
        System.out.println("Test Case 2 - Input: " + num2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3: Zero as input
        int num3 = 0;
        boolean expected3 = true;
        boolean result3 = isSameAfterReversals(num3);
        System.out.println("Test Case 3 - Input: " + num3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case 4: Large number
        int num4 = 1000;
        boolean expected4 = false;
        boolean result4 = isSameAfterReversals(num4);
        System.out.println("Test Case 4 - Input: " + num4);
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));
    }

    public static boolean isSameAfterReversals(int num) {
        int temp = num;
        if (num < 0) return false;  // Negative numbers are not handled by the problem statement.
        if (num == 0) return true;  // Edge case: 0 stays the same after double reversal.

        int reversedOnce = reverse(num);
        int reversedTwice = reverse(reversedOnce);
        System.out.println("First Reversal: " + reversedOnce + " | Second Reversal: " + reversedTwice);
        return temp == reversedTwice;
    }

    // Function to reverse the digits of a number
    public static int reverse(int num) {
        int res = 0;
        while (num > 0) {
            int rem = num % 10;
            res = res * 10 + rem;
            num = num / 10;
        }
        return res;
    }
    public static boolean isSameAfterReversals2(int num) {
        // If num is 0, it's always the same after double reversal.
        // If num doesn't have any trailing zeros, it will be the same after double reversal.
        // Numbers with trailing zeros won't be the same after double reversal.
        return num == 0 || num % 10 != 0;
    }
}
