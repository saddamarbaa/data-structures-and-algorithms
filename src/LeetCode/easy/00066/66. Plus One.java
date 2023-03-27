/*
66. Plus One
Easy
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the
integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer
does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
 */

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        // Test case 1: Regular increment
        int[] digits1 = {1, 2, 3};
        int[] expected1 = {1, 2, 4};
        int[] result1 = plusOne(digits1);
        System.out.println("Test case 1: " + Arrays.equals(result1, expected1)); // prints true

        // Test case 2: Increment with carry over
        int[] digits2 = {4, 3, 2, 1};
        int[] expected2 = {4, 3, 2, 2};
        int[] result2 = plusOne(digits2);
        System.out.println("Test case 2: " + Arrays.equals(result2, expected2)); // prints true

        // Test case 3: Increment with multiple carry overs
        int[] digits3 = {9, 9, 9};
        int[] expected3 = {1, 0, 0, 0};
        int[] result3 = plusOne(digits3);
        System.out.println("Test case 3: " + Arrays.equals(result3, expected3)); // prints true

        // Test case 4: Single digit increment
        int[] digits4 = {5};
        int[] expected4 = {6};
        int[] result4 = plusOne(digits4);
        System.out.println("Test case 4: " + Arrays.equals(result4, expected4)); // prints true

        // Test case 5: Increment with leading zero
        int[] digits5 = {0, 1, 2};
        int[] expected5 = {0, 1, 3};
        int[] result5 = plusOne(digits5);
        System.out.println("Test case 5: " + Arrays.equals(result5, expected5)); // prints true

        // Test case 6: All digits are 9s
        int[] digits6 = {9, 9, 9};
        int[] expected6 = {1, 0, 0, 0};
        int[] result6 = plusOne(digits6);
        System.out.println("Test case 6: " + Arrays.equals(result6, expected6)); // prints true

        // Test case 7: Large number increment
        int[] digits7 = {2, 5, 9, 9, 9, 9, 9, 9, 9};
        int[] expected7 = {2, 6, 0, 0, 0, 0, 0, 0, 0};
        int[] result7 = plusOne(digits7);
        System.out.println("Test case 7: " + Arrays.equals(result7, expected7)); // prints true

        // Test case 8: Empty array input
        int[] digits8 = {};
        int[] expected8 = {1};
        int[] result8 = plusOne(digits8);
        System.out.println("Test case 8: " + Arrays.equals(result8, expected8)); // prints true


        // Test case 9
        int[] digits9 = {5, 6, 2, 0, 0, 4, 6, 2, 4, 9};
        int[] expected9 = {5, 6, 2, 0, 0, 4, 6, 2, 5, 0};
        int[] result9 = plusOne(digits9);
        System.out.println("Test case 9: " + Arrays.equals(result9, expected9)); // prints true
    }


    /*
     * Plus One
     * <p>
     * Inputs:
     * digits: an array of non-negative integers representing a non-negative integer
     * <p>
     * Outputs:
     * an array of integers representing the input integer plus one
     * <p>
     * Algorithm steps:
     * Iterate over the digits of the input array in reverse order.
     * If the current digit is less than 9, add one to the digit and return the updated array.
     * If the current digit is equal to 9, set the current digit to 0 and continue iterating to the next digit.
     * If all digits have been iterated and the first digit is 9, set the first digit to 0 and add a new digit of 1 to
     * the beginning of the array.
     * <p>
     * Time complexity:
     * The method iterates over all the digits of the input array once. Therefore, the time complexity is O(n),
     * where n is the number of digits in the input array.
     * <p>
     * Space complexity:
     * The method creates a new array to hold the updated digits if a new digit is added to the beginning of the array.
     * Therefore, the space complexity is O(n), where n is the number of digits in the input arra
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate backwards over the digits array and add one to the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If we reach here, all digits were 9s, so we need to create a new array with a leading 1
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}