/*
136. Single Number
Easy
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */


import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 3, 4, 4};
        int expected1 = 1;
        int result1 = singleNumber(nums1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        int[] nums2 = {5, 5, 3, 3, 4, 4, 2};
        int expected2 = 2;
        int result2 = singleNumber(nums2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        int[] nums3 = {1};
        int expected3 = 1;
        int result3 = singleNumber(nums3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

    }


    public static int singleNumber(int[] nums) {
        Arrays.sort(nums); // sort the array of integers
        int n = nums.length;
        for (int i = n - 1; i > 0; i -= 2) { // iterate through the array from the end to the beginning in steps of 2
            int current = nums[i];
            int previous = nums[i - 1];
            if (current != previous) { // if the current element and the previous element are not equal, return the
                // current element
                return current;
            }
        }
        return nums[0];
    }
}





