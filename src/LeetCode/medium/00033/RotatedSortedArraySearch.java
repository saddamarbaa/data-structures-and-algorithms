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

public class  RotatedSortedArraySearch {
    public static void main(String[] args) {
        // Test case 1 - target present in the middle of the array
        int[] input1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        int expected1 = 4;
        int result1 = search(input1, target1);
        printTestCaseDetails(input1, target1, expected1, result1);

        // Test case 2 - target present at the beginning of the array
        int[] input2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 4;
        int expected2 = 0;
        int result2 = search(input2, target2);
        printTestCaseDetails(input2, target2, expected2, result2);

        // Test case 3 - target present at the end of the array
        int[] input3 = {4, 5, 6, 7, 0, 1, 2};
        int target3 = 2;
        int expected3 = 6;
        int result3 = search(input3, target3);
        printTestCaseDetails(input3, target3, expected3, result3);

        // Test case 4 - target not present in the array
        int[] input4 = {4, 5, 6, 7, 0, 1, 2};
        int target4 = 3;
        int expected4 = -1;
        int result4 = search(input4, target4);
        printTestCaseDetails(input4, target4, expected4, result4);
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

    public static int search1(int[] nums, int target) {

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



    /**
     * Searches for the target in a rotated sorted array.
     *
     * Algorithm Steps:
     * 1. If the array has only one element, return 0 if it's the target, otherwise return -1.
     * 2. Find the pivot index using binary search.
     * 3. Perform binary search on the left side of the pivot.
     * 4. If found, return the result.
     * 5. If the pivot index is at the end, return -1.
     * 6. Perform binary search on the right side of the pivot.
     * 7. Return the result.
     *
     * Time Complexity: O(log n) - Binary search
     * Space Complexity: O(1) - Constant space
     *
     * @param nums   The rotated sorted array.
     * @param target The target element to search.
     * @return The index of the target, or -1 if not found.
     */
   public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return (target == nums[0]) ? 0 : -1;
        }

        int pivotIndex = findPivotIndex(nums);

        int leftResult =binarySearch(nums, target, 0, pivotIndex);
        if (leftResult != -1) {
            return leftResult;
        }

        if (pivotIndex == nums.length - 1) {
            return -1;
        }

        return binarySearch(nums, target, pivotIndex + 1, nums.length - 1);
    }


    /**
     * Finds the pivot index in a rotated sorted array.
     *
     * @param nums The rotated sorted array.
     * @return The index of the pivot, or -1 if no pivot is found.
     */
    private static int findPivotIndex(int[] nums) {
        // Step 1: Initialize pointers for binary search.
        int left = 0;
        int right = nums.length - 1;

        // Step 2: Binary search to find the pivot index.
        while (left <= right) {
            // Calculate mid index.
            int mid = left + (right - left) / 2;

            // Step 3: Check if mid is the pivot.
            if (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            // Step 4: Check if mid is the pivot at the boundary.
            else if (mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            // Step 5: Adjust search pointers based on array properties.
            else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Step 6: If no pivot is found, return -1.
        return -1;
    }


    /**
     * Performs binary search in a sorted array.
     *
     * Algorithm Steps:
     * 1. Initialize left and right pointers.
     * 2. While left <= right, calculate mid.
     * 3. If mid is the target, return mid.
     * 4. Adjust search pointers based on array properties.
     * 5. If target is not found, return -1.
     *
     * Time Complexity: O(log n) - Binary search
     * Space Complexity: O(1) - Constant space
     *
     * @param nums   The sorted array.
     * @param target The target element to search.
     * @param left   The left index for binary search.
     * @param right  The right index for binary search.
     * @return The index of the target, or -1 if not found.
     */
    private static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }



    /**
     * Print the details of a test case.
     *
     * @param input    The input array.
     * @param target   The target element to search.
     * @param expected The expected result.
     * @param actual   The actual result.
     */
    private static void printTestCaseDetails(int[] input, int target, int expected, int actual) {
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Target: " + target);
        System.out.println("Expected Result: " + expected);
        System.out.println("Actual Result: " + actual);
        System.out.println("Result Matches Expected: " + (actual == expected));
        System.out.println();
    }
}
