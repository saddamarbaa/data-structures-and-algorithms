/*
 2595. Number of Even and Odd Bits
Easy
You are given a positive integer n.
Let even denote the number of even indices in the binary representation of n (0-indexed) with value 1.
Let odd denote the number of odd indices in the binary representation of n (0-indexed) with value 1.
Return an integer array answer where answer = [even, odd].

Example 1:

Input: n = 17
Output: [2,0]
Explanation: The binary representation of 17 is 10001.
It contains 1 on the 0th and 4th indices.
There are 2 even and 0 odd indices.
Example 2:

Input: n = 2
Output: [0,1]
Explanation: The binary representation of 2 is 10.
It contains 1 on the 1st index.
There are 0 even and 1 odd indices.


Constraints:

1 <= n <= 1000
 */


import java.util.Arrays;

public class EvenOddBit {
    public static void main(String[] args) {
        // Test case 1 - input is 0
        int input1 = 0;
        int[] expected1 = {0, 0};
        int[] result1 = evenOddBit(input1);
        System.out.println("Test Case 1 - Input: " + input1);
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.toString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.equals(expected1, result1));

        // Test case 2 - input is 1
        int input2 = 1;
        int[] expected2 = {0, 1};
        int[] result2 = evenOddBit(input2);
        System.out.println("Test Case 2 - Input: " + input2);
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.toString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.equals(expected2, result2));

        // Test case 3 - input is a power of 2
        int input3 = 64;
        int[] expected3 = {1, 0};
        int[] result3 = evenOddBit(input3);
        System.out.println("Test Case 3 - Input: " + input3);
        System.out.println("Test Case 3 - Expected result: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Actual result: " + Arrays.toString(result3));
        System.out.println("Test Case 3 - Result matches expected: " + Arrays.equals(expected3, result3));

        // Test case 4 - input is an odd number
        int input4 = 25;
        int[] expected4 = {3, 0};
        int[] result4 = evenOddBit(input4);
        System.out.println("Test Case 4 - Input: " + input4);
        System.out.println("Test Case 4 - Expected result: " + Arrays.toString(expected4));
        System.out.println("Test Case 4 - Actual result: " + Arrays.toString(result4));
        System.out.println("Test Case 4 - Result matches expected: " + Arrays.equals(expected4, result4));

        // Test case 5 - input is an even number
        int input5 = 42;
        int[] expected5 = {1, 2};
        int[] result5 = evenOddBit(input5);
        System.out.println("Test Case 5 - Input: " + input5);
        System.out.println("Test Case 5 - Expected result: " + Arrays.toString(expected5));
        System.out.println("Test Case 5 - Actual result: " + Arrays.toString(result5));
        System.out.println("Test Case 5 - Result matches expected: " + Arrays.equals(expected5, result5));

    }


    /**
     * Algorithm Steps:
     * Convert the given integer to a binary string.
     * Initialize two counters to 0, one for the number of odd bits and one for the number of even bits.
     * Reverse the binary string.
     * Iterate through each character in the reversed binary string.
     * If the current character is '1', check if the index is even or odd.
     * If the index is even, increment the counter for even bits.
     * If the index is odd, increment the counter for odd bits.
     * Return the array of two counters, representing the number of even and odd bits respectively.
     * Time Complexity:O(log n), where n is the input integer. This is because the number of iterations in the for
     * loop is proportional to the number of bits in the binary representation of the input, which is log(n).
     * Space complexity: O(log n), where n is the input integer. This is because the binary string takes log(n) bits
     * to represent, and the StringBuilder object used to reverse the string also takes log(n) bits of space. The two
     * counters and the output array take constant space
     */

    public static int[] evenOddBit(int number) {
        String binaryString = Integer.toBinaryString(number);
        int numberOfOddBits = 0, numberOfEvenBits = 0;
        StringBuilder reversedBinaryStringBuilder = new StringBuilder(binaryString).reverse();
        String reversedBinaryString = reversedBinaryStringBuilder.toString();

        for (int i = 0; i < reversedBinaryString.length(); i++) {
            char binaryDigit = reversedBinaryString.charAt(i);

            if (binaryDigit == '1') {
                if (i % 2 == 0) {
                    numberOfEvenBits++;
                } else {
                    numberOfOddBits++;
                }
            }
        }

        return new int[]{numberOfEvenBits, numberOfOddBits};
    }
}