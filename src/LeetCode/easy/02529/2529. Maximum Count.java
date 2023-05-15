/*
2529. Maximum Count of Positive Integer and Negative Integer
Easy
Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and
the number of negative integers.

In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then
return the maximum of pos and neg.
Note that 0 is neither positive nor negative.


Example 1:

Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
Example 2:

Input: nums = [-3,-2,-1,0,0,1,2]
Output: 3
Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.
Example 3:

Input: nums = [5,20,66,1314]
Output: 4
Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.


Constraints:

1 <= nums.length <= 2000
-2000 <= nums[i] <= 2000
nums is sorted in a non-decreasing order.


Follow up: Can you solve the problem in O(log(n)) time complexity?
 */


import java.util.Arrays;

public class MaximumCount{
    public static void main(String[] args) {
        // Test case 1 - negative, zero and positive numbers
        int[] input1 = {-10, -9, -8, -7, -6, -5, -4, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
        int expected1 = 8;
        int result1 = maximumCount(input1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));


        // Test case with all negative integers:
        int[] input2 = {-10, -8, -6, -4, -2};
        int expected2 = 5;
        int result2 = maximumCount(input2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case with all positive integers:
        int[] input3 = {2, 4, 6, 8, 10};
        int expected3 = 5;
        int result3 = maximumCount(input3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(input3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case with alternating negative and positive integers:
        int[] input4 = {-9, 5, -7, 2, -5, 8, -4, 3, -2, 1};
        int expected4 = 7;
        int result4 = maximumCount(input4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(input4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));
    }


    /**
     * 1. Check if the first element of the input array is 0. If it is, return 0.
     * 2. Initialize left to 0, right to the last index of the input array, and mid to -1.
     * 3. Use binary search to find the index of the last negative number in the input array by repeatedly dividing the
     * search space in half and comparing the middle element with 0 until the index of the last negative number is
     * found.
     * 4. Calculate the number of negative integers in the input array by adding 1 to the index of the last negative
     * number.
     * 5. Use binary search to find the index of the first positive number in the input array by repeatedly dividing the
     * search space in half and comparing the middle element with 0 until the index of the first positive number is
     * found.
     * 6. Calculate the number of positive integers in the input array by subtracting the index of the first positive
     * number from the length of the input array.
     * 7. Return the maximum between the number of positive integers and the number of negative integers.
     * Time Complexity: The algorithm uses two binary searches to find the indices of the last negative number and
     * the first positive number, each with a time complexity of O(log n), where n is the length of the input array.
     * Therefore, the overall time complexity is O(log n).
     * Space Complexity: The algorithm uses a constant amount of additional space. Therefore, the space complexity is
     * O(1).
     */

    public static int maximumCount(int[] nums) {
        int n = nums.length - 1;

        // Check if all numbers in the array are zero
        if (nums[0] == 0 && nums[n - 1] == 0) {
            return 0;
        }


        int left = 0;
        int right = nums.length - 1;
        int mid = -1;

        // Find the index of the last negative number
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                right = mid - 1;
            } else {
                if (mid == n || nums[mid + 1] >= 0) {
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }

        int negativeCount = mid + 1;


        // Find the index of the first positive number
        left = 0;
        right = n;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= 0) {
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] <= 0) {
                    break;
                } else {
                    right = mid - 1;
                }
            }
        }

        int positiveCount = nums.length - mid;

        return Math.max(negativeCount, positiveCount);
    }

    /**
     * Calculates the maximum count of either positive or negative integers in an integer array.
     *
     * @param nums the input array of integers
     * @return the maximum count of either positive or negative integers
     */
    public static int maximumCount2(int[] nums) {
        int countPositive = 0;
        int countNegative = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                countPositive++;
            } else if (nums[i] < 0) {
                countNegative++;
            }
        }

        return countPositive > countNegative ? countPositive : countNegative;
    }
}