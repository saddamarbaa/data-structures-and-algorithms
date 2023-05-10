/*
704. Binary Search
Easy
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search
 target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
 */


import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        // Test case 1 - target present in the middle of the array
        int[] input1 = {1, 2, 3, 4, 5};
        int target1 = 3;
        int expected1 = 2;
        int result1 = search(input1, target1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1) + ", Target: " + target1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2 - target present at the beginning of the array
        int[] input2 = {5, 4, 3, 2, 1};
        int target2 = 5;
        int expected2 = 0;
        int result2 = search(input2, target2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2) + ", Target: " + target2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3 - target not present in the array
        int[] input3 = {5, 4, 3, 2, 1};
        int target3 = 6;
        int expected3 = -1;
        int result3 = search(input3, target3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(input3) + ", Target: " + target3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case 4 - array contains only one element which is the target
        int[] input4 = {3};
        int target4 = 3;
        int expected4 = 0;
        int result4 = search(input4, target4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(input4) + ", Target: " + target4);
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));

        // Test case 5 - array contains only one element which is not the target
        int[] input5 = {3};
        int target5 = 4;
        int expected5 = -1;
        int result5 = search(input5, target5);
        System.out.println("Test Case 5 - Input: " + Arrays.toString(input5) + ", Target: " + target5);
        System.out.println("Test Case 5 - Expected result: " + expected5);
        System.out.println("Test Case 5 - Actual result: " + result5);
        System.out.println("Test Case 5 - Result matches expected: " + (result5 == expected5));
    }


    /**
     * Write a function that implements an order-agnostic binary search algorithm to search for a given key in a sorted
     * array of integers. The function should return the index of the key if it is present in the array, otherwise it
     * should return -1.
     * The function should take two arguments:
     * nums: A sorted (in non-decreasing order) array of integers.
     * key: An integer value to search for in the array.
     * Algorithm Steps:
     * 1. Initialize the low and high variables to the first and last indices of the array respectively.
     * 2. Determine whether the array is sorted in ascending or descending order by comparing the first and last
     * elements.
     * 3. While the low index is less than or equal to the high index:
     * - Calculate the mid index as the average of the low and high indices (to avoid integer overflow, use the
     * expression mid = low + (high - low) / 2 instead of mid = (low + high) / 2).
     * - If the value at the mid index is equal to the key, return the mid index.
     * - If the array is sorted in ascending order and the value at the mid index is greater than the key, update the
     * high index to be the index immediately to the left of the mid index.
     * - If the array is sorted in ascending order and the value at the mid index is less than the key, update the low
     * index to be the index immediately to the right of the mid index.
     * - If the array is sorted in descending order and the value at the mid index is greater than the key, update the
     * low index to be the index immediately to the right of the mid index.
     * - If the array is sorted in descending order and the value at the mid index is less than the key, update the
     * high index to be the index immediately to the left of the mid index.
     * 4. If the key is not found in the array, return -1.
     * Time Complexity:
     * The algorithm visits each element in the search space (i.e., the portion of the array between the low and high
     * indices) at most three times.
     * Therefore, the time complexity is O(log n), where n is the length of the input array.
     * Space Complexity:
     * The algorithm uses a constant amount of additional space.
     * Therefore, the space complexity is O(1).
     */
    public static int search(int[] nums, int key) {

        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }


        int low = 0;
        int high = nums.length - 1;

        // Determine whether the array is sorted in ascending or descending order
        boolean isAscending = nums[low] < nums[high];

        while (low <= high) {
            // mid = (low + high)/2; //(low + high) may lead to overflow condition

            // to avoid integer overflow is better to use on of this conditions flowing blow
            int mid = low + (high - low) / 2;
            // mid = high - (high - low)/2;

            if (nums[mid] == key) {
                return mid;
            } else if (isAscending) {
                if (nums[mid] > key) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] > key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}