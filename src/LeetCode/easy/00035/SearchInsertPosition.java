/*
35. Search Insert Position
Easy
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return
 the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */


import java.util.Arrays;

public class  SearchInsertPosition {
    public static void main(String[] args) {
         printTestCaseResult(new int[]{1, 3, 5, 6}, 5, 2);
        printTestCaseResult(new int[]{1, 3, 5, 6}, 2, 1);
        printTestCaseResult(new int[]{1, 3, 5, 6}, 7, 4);
        printTestCaseResult(new int[]{1, 3, 5, 6}, 0, 0);
        printTestCaseResult(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5, 4);
        printTestCaseResult(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 11, 10);
        printTestCaseResult(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 0, 0);
        printTestCaseResult(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, 14, 6);
        printTestCaseResult(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19}, 20, 10);
    }

    public static void printTestCaseResult(int[] nums, int target, int expected) {
        int result = searchInsert(nums, target);
        System.out.println("Input: " + Arrays.toString(nums) + ", Target: " + target);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        System.out.println("Result matches expected: " + (result == expected));
        System.out.println();
    }
    

    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    /**
     * Write a function that implements the binary search algorithm to search for a given key in a sorted array of
     * integers. The function should return the index of the key if it is present in the array, otherwise it should
     * return the index where it would be if it were inserted in order.
     * The function should take two arguments:
     * nums: A sorted array of integers.
     * target: An integer value to search for in the array.
     * Algorithm Steps:
     * Initialize the left and right variables to the first and last indices of the array, respectively.
     * While the left index is less than or equal to the right index:
     * a. Calculate the midIndex as the average of the left and right indices (to avoid integer overflow, use the
     * expression midIndex = left + (right - left) / 2 instead of midIndex = (left + right) / 2).
     * b. If the value at the midIndex is equal to the target, return midIndex.
     * c. If the value at the midIndex is less than the target, set the left index to midIndex + 1.
     * d. If the value at the midIndex is greater than the target, set the right index to midIndex - 1.
     * If the target is not found in the array, return the left index, which is the index where the target would be
     * if it were inserted in order.
     * Time Complexity:
     * The algorithm visits each element in the search space (i.e., the portion of the array between the left and
     * right indices) at most three times. Therefore, the time complexity is O(log n), where n is the length of the
     * input array.
     * Space Complexity:
     * The algorithm uses a constant amount of additional space. Therefore, the space complexity is O(1).
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
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
        return left;
    }
}

