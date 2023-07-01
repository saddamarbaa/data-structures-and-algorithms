/*
81. Search in Rotated Sorted Array II
Medium
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that
the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is
not in nums.

You must decrease the overall operation steps as much as possible.


Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 */


import java.util.*;

public class Search {
    public static void main(String[] args) {
        // Test case 1 - target present in the rotated part of the array
        int[] input1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        boolean expected1 = true;
        boolean result1 = search(input1, target1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1) + ", Target: " + target1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2 - target not present in the array
        int[] input2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        boolean expected2 = false;
        boolean result2 = search(input2, target2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2) + ", Target: " + target2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3 - target present at the start of the array
        int[] input3 = {2, 5, 6, 0, 0, 1, 2};
        int target3 = 2;
        boolean expected3 = true;
        boolean result3 = search(input3, target3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(input3) + ", Target: " + target3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));
    }


    /**
     * Algorithm Steps:
     * 1. Check if the target is equal to the middle element.
     * - If the target is equal to the middle element (nums[mid] == target), return true.
     * 2. If the left half is sorted (nums[left] <= nums[mid]), check if the target is within the left half.
     * - If the target is within the left half (nums[left] <= target < nums[mid]),
     * update the right pointer to mid - 1 and continue searching in the left half.
     * - Otherwise, update the left pointer to mid + 1 and continue searching in the right half.
     * 3. If the right half is sorted (nums[mid] < nums[right]), check if the target is within the right half.
     * - If the target is within the right half (nums[mid] < target <= nums[right]),
     * update the left pointer to mid + 1 and continue searching in the right half.
     * - Otherwise, update the right pointer to mid - 1 and continue searching in the left half.
     * 4. Repeat steps 1-3 until the target is found or the search range is exhausted.
     * 5. If the target is not found, return false.
     * <p>
     * Time Complexity: O(log n) - Binary search reduces the search range by half at each step, resulting in
     * logarithmic time complexity.
     * Space Complexity: O(1) - The algorithm uses a constant amount of extra space for variables to keep track of
     * indices.
     */

    public static boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // If the left half is sorted
            if (nums[left] <= nums[mid]) {

                // edg case
                if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                    left = left + 1;
                    right = right - 1;
                    continue;
                }
                // Check if the target is within the left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1; // Search in the right half
                }
            }
            // If the right half is sorted
            else {
                // Check if the target is within the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }

        return false;
    }
}