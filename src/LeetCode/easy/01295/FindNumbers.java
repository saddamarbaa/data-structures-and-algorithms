/**
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
        int[] nums1 = {12, 345, 2, 6, 7896};
        int[] nums2 = {555, 901, 482, 1771};

        // Test cases
        int result1 = findNumbers(nums1);
        printResult(nums1, result1, 2);

        int result2 = findNumbers(nums2);
        printResult(nums2, result2, 1);
    }

    public static int findNumbers(int[] nums) {
        int count = 0;

        // Iterate through each number in the array
        for (int num : nums) {
            // Check if the number has an even number of digits
            if (hasEvenDigits(num)) {
                count++;
            }
        }

        // Return the count of numbers with an even number of digits
        return count;
    }

    private static boolean hasEvenDigits(int num) {
        // Convert the number to a string and check the length
        return Integer.toString(num).length() % 2 == 0;
    }

    private static void printResult(int[] nums, int result, int expected) {
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        System.out.println("Result matches expected: " + (result == expected));
        System.out.println();
    }
}