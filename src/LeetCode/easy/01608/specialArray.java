/*
1608. Special Array With X Elements Greater Than or Equal X
Easy

You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that
 there are exactly x numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is
unique.

Example 1:

Input: nums = [3,5]
Output: 2
Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.
Example 2:

Input: nums = [0,0]
Output: -1
Explanation: No numbers fit the criteria for x.
If x = 0, there should be 0 numbers >= x, but there are 2.
If x = 1, there should be 1 number >= x, but there are 0.
If x = 2, there should be 2 numbers >= x, but there are 0.
x cannot be greater since there are only 2 numbers in nums.
Example 3:

Input: nums = [0,4,3,0,4]
Output: 3
Explanation: There are 3 values that are greater than or equal to 3.


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */


import java.util.*;

public class SpecialArray {
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 2, 1};
        int expected1 = 2;
        int result1 = specialArray(nums1);
        System.out.println("Test Case 1 - nums1: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test Case 2
        int[] nums2 = {4, 9, 5};
        int expected2 = -1;
        int result2 = specialArray(nums2);
        System.out.println("Test Case 2 - nums2: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test Case 3
        int[] nums3 = {0, 0};
        int expected3 = 2;
        int result3 = specialArray(nums3);
        System.out.println("Test Case 3 - nums3: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test Case 4
        int[] nums4 = {0, 4, 3, 0, 4};
        int expected4 = 3;
        int result4 = specialArray(nums4);
        System.out.println("Test Case 4 - nums4: " + Arrays.toString(nums4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));
    }


    /**
     * Algorithm:
     * 1. Sort the given array `nums` in ascending order.
     * 2. Initialize `left` as 0 and `right` as `nums.length - 1` to define the search range.
     * 3. Perform binary search within the defined range.
     * 4. While `left` is less than or equal to `right`, do the following:
     * - Calculate the middle index `mid` as the average of `left` and `right`.
     * - Calculate the remaining length as `nums.length - mid`.
     * - Check if the value at `nums[mid]` is greater than or equal to the remaining length:
     * - If true, check if the value at `nums[mid-1]` is less than the remaining length:
     * - If true, return the remaining length as the special number.
     * - If false, update `right` to `mid - 1` and continue the binary search.
     * - If false, update `left` to `mid + 1` and continue the binary search.
     * 5. If the binary search ends without finding a special number, return -1 as the result.
     * <p>
     * Time Complexity: O(log n), where n is the length of the input array `nums`. This is because binary search has a
     * logarithmic time complexity.
     * Space Complexity: O(1), as the algorithm uses a constant amount of additional space for variables.
     */

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int numGreaterThanOrEqual = countGreaterThanOrEqual(nums, nums[mid]);
            if (numGreaterThanOrEqual == nums[mid]) {
                return nums[mid];
            } else if (numGreaterThanOrEqual < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }


    public static int specialArray2(int[] nums) {
        Arrays.sort(nums);

        int maxNumber = nums[nums.length - 1];

        for (int i = 0; i < maxNumber; i++) {
            int numGreaterThanOrEqual = countGreaterThanOrEqual(nums, i + 1);
            if (numGreaterThanOrEqual == i + 1) {
                return i + 1;
            }
        }

        return -1;
    }


    public static int countGreaterThanOrEqual(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num >= target) {
                count++;
            }
        }
        return count;
    }
}