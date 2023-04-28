/*
1295. Find Numbers with Even Number of Digits
Easy
Given an array nums of integers, return how many of them contain an even number of digits.
Example 1:
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore only 12 and 7896 contain an even number of digits.
Example 2:

Input: nums = [555,901,482,1771]
Output: 1
Explanation:
Only 1771 contains an even number of digits.

Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 105
 */


import java.util.Arrays;

public class FindNumbers {
    public static void main(String[] args) {
        // Test case 1 -  input contains both odd and even digits
        int[] input1 = {12, 345, 2, 6, 7896};
        int expected1 = 2;
        int result1 = findNumbers(input1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (expected1 == result1));


        // Test case 2 - input contains only odd digits
        int[] input2 = {1, 3, 5, 7, 9};
        int expected2 = 0;
        int result2 = findNumbers(input2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (expected2 == result2));
    }


    /**
     * Given an array of integers, counts the number of integers in the array that have an even number of digits.
     *
     * @param numbers the array of integers to count
     * @return the number of integers in the array with an even number of digits
     * Algorithm Steps:
     * Initialize a count variable to 0.
     * Loop through each number in the input array.
     * For each number, count the number of digits using the getDigitCount method.
     * If the number of digits is even, increment the count variable.
     * Return the final count.
     * Time Complexity: O(n * log10(max(nums))), where n is the length of the input array and max(nums) is the
     * maximum value in the input array. This is because we need to count the number of digits for each number, which
     * takes log10 of the number of digits. The worst-case maximum value for a 32-bit integer is 2,147,483,647, which
     * has 10 digits, so the time complexity is O(n * log10(10)) = O(n).
     * Space Complexity: O(1), as we use only constant amount of additional space.
     */
    private static int findNumbers(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            int digitCount = getDigitCount(number);
            if (digitCount % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Given an integer, counts the number of digits in the integer.
     *
     * @param number the integer to count digits in
     * @return the number of digits in the integer
     * Algorithm Steps:
     * If the input number is 0, return 1.
     * Initialize a count variable to 0.
     * Loop through each digit of the number.
     * For each digit, increment the count variable.
     * Divide the number by 10 to remove the last digit.
     * Continue looping until the number is 0.
     * Return the final count.
     * Time Complexity: O(log10(number)), where number is the input number. This is because we need to loop through
     * each digit of the number, and the number of digits is equal to log10 of the number.
     * Space Complexity: O(1), as we use only constant amount of additional space.
     */
    private static int getDigitCount(int number) {
        if (number == 0) {
            return 1;
        }

//        int count = 0;
//        while (number != 0) {
//            count++;
//            number /= 10;
//        }
//        return count;


        // optimal version
        return (int) Math.log10(Math.abs(number)) + 1;
    }
}

