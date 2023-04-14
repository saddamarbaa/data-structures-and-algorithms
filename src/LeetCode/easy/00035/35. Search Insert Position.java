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

public class  SearchInsert {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        int expected1 = 2;
        int result1 = searchInsert(nums1, target1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        int expected2 = 1;
        int result2 = searchInsert(nums2, target2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        int expected3 = 4;
        int result3 = searchInsert(nums3, target3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        int expected4 = 0;
        int result4 = searchInsert(nums4, target4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(nums4) + ", Target: " + target4);
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 3 - Result matches expected: " + (result4 == expected4));


        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target5 = 5;
        int expected5 = 4;
        int result5 = searchInsert(nums5, target5);
        System.out.println("Test Case 5 - Input: " + Arrays.toString(nums5) + ", Target: " + target5);
        System.out.println("Test Case 5 - Expected result: " + expected5);
        System.out.println("Test Case 5 - Actual result: " + result5);
        System.out.println("Test Case 5 - Result matches expected: " + (result5 == expected5));

        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target6 = 11;
        int expected6 = 10;
        int result6 = searchInsert(nums6, target6);
        System.out.println("Test Case 6 - Input: " + Arrays.toString(nums6) + ", Target: " + target6);
        System.out.println("Test Case 6 - Expected result: " + expected6);
        System.out.println("Test Case 6 - Actual result: " + result6);
        System.out.println("Test Case 6 - Result matches expected: " + (result6 == expected6));

        int[] nums7 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target7 = 0;
        int expected7 = 0;
        int result7 = searchInsert(nums7, target7);
        System.out.println("Test Case 7 - Input: " + Arrays.toString(nums7) + ", Target: " + target7);
        System.out.println("Test Case 7 - Expected result: " + expected7);
        System.out.println("Test Case 7 - Actual result: " + result7);
        System.out.println("Test Case 7 - Result matches expected: " + (result7 == expected7));

        int[] nums8 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target8 = 14;
        int expected8 = 6;
        int result8 = searchInsert(nums8, target8);
        System.out.println("Test Case 8 - Input: " + Arrays.toString(nums8) + ", Target: " + target8);
        System.out.println("Test Case 8 - Expected result: " + expected8);
        System.out.println("Test Case 8 - Actual result: " + result8);
        System.out.println("Test Case 8 - Result matches expected: " + (result8 == expected8));

        int[] nums9 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target9 = 20;
        int expected9 = 10;
        int result9 = searchInsert(nums9, target9);
        System.out.println("Test Case 9 - Input: " + Arrays.toString(nums9) + ", Target: " + target9);
        System.out.println("Test Case 9 - Expected result: " + expected9);
        System.out.println("Test Case 9 - Actual result: " + result9);
        System.out.println("Test Case 9 - Result matches expected: " + (result9 == expected9));
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

