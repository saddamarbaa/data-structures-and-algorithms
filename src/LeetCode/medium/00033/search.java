/**
33. Search in Rotated Sorted Array
Medium
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */


import java.util.*;

public class Search {
    public static void main(String[] args) {
        // Test case 1 - target present in the middle of the array
        int[] input1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        int expected1 = 4;
        int result1 = search(input1, target1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1) + ", Target: " + target1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2 - target present at the beginning of the array
        int[] input2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 4;
        int expected2 = 0;
        int result2 = search(input2, target2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2) + ", Target: " + target2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3 - target present at the end of the array
        int[] input3 = {4, 5, 6, 7, 0, 1, 2};
        int target3 = 2;
        int expected3 = 6;
        int result3 = search(input3, target3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(input3) + ", Target: " + target3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case 4 - target not present in the array
        int[] input4 = {4, 5, 6, 7, 0, 1, 2};
        int target4 = 3;
        int expected4 = -1;
        int result4 = search(input4, target4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(input4) + ", Target: " + target4);
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));

    }


    /**
     * Algorithm Steps:
     * 1. Check if the target is equal to the middle element.
     * - If the target is equal to the middle element (nums[mid] == target), return the index of the middle element
     * (mid).
     * 2. If the left half is sorted (nums[left] <= nums[mid]), check if the target is within the left half.
     * - If the target is within the left half (nums[left] <= target < nums[mid]),
     * update the right pointer to mid - 1 and continue searching in the left half.
     * - Otherwise, update the left pointer to mid + 1 and continue searching in the right half.
     * 3. If the right half is sorted (nums[mid] < nums[right]), check if the target is within the right half.
     * - If the target is within the right half (nums[mid] < target <= nums[right]),
     * update the left pointer to mid + 1 and continue searching in the right half.
     * - Otherwise, update the right pointer to mid - 1 and continue searching in the left half.
     * 4. Repeat steps 1-3 until the target is found or the search range is exhausted.
     * 5. If the target is not found, return -1.
     * Time Complexity: O(log n) - Binary search reduces the search range by half at each step, resulting in
     * logarithmic time complexity.
     * Space Complexity: O(1) - The algorithm uses a constant amount of extra space for variables to keep track of
     * indices.
     */

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // If the left half is sorted
            if (nums[left] <= nums[mid]) {
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

        return -1; // Target not found
    }
}