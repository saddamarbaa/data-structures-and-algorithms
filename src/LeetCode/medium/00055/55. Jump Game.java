/*
55. Jump Game
Medium
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the
 array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it
impossible to reach the last index.

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105
 */

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums1 = {2, 5, 0, 0};
        boolean expected1 = true;
        boolean result1 = canJump(nums1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        int[] nums2 = {3, 2, 1, 0, 4};
        boolean expected2 = false;
        boolean result2 = canJump(nums2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        int[] nums3 = {0};
        boolean expected3 = true;
        boolean result3 = canJump(nums3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        int[] nums4 = {2, 3, 1, 1, 4};
        boolean expected4 = true;
        boolean result4 = canJump(nums4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(nums4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));

        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean expected5 = true;
        boolean result5 = canJump(nums5);
        System.out.println("Test Case 5 - Input: " + Arrays.toString(nums5));
        System.out.println("Test Case 5 - Expected result: " + expected5);
        System.out.println("Test Case 5 - Actual result: " + result5);
        System.out.println("Test Case 5 - Result matches expected: " + (result5 == expected5));

        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        boolean expected6 = false;
        boolean result6 = canJump(nums6);
        System.out.println("Test Case 6 - Input: " + Arrays.toString(nums6));
        System.out.println("Test Case 6 - Expected result: " + expected6);
        System.out.println("Test Case 6 - Actual result: " + result6);
        System.out.println("Test Case 6 - Result matches expected: " + (result6 == expected6));


        int[] nums7 = {2, 0, 2, 0, 1, 1, 4, 0, 4, 0, 1, 1, 1};
        boolean expected7 = false;
        boolean result7 = canJump(nums7);
        System.out.println("Test Case 7 - Input: " + Arrays.toString(nums7));
        System.out.println("Test Case 7 - Expected result: " + expected7);
        System.out.println("Test Case 7 - Actual result: " + result7);
        System.out.println("Test Case 7 - Result matches expected: " + (result7 == expected7));
    }

    /**
     * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position. Determine if you are able to
     * reach the last index.
     * Function signature: public boolean canJump(int[] nums)
     * Algorithm Steps:
     * Initialize the variable lastPosition as the last index of the array.
     * Initialize the variable maxJump as 0.
     * Loop through the array from the first index to the second last index:
     * a. Calculate the maximum position that can be reached from the current index i using i + nums[i].
     * b. If the calculated maximum position is greater than the current maxJump, update maxJump to the new maximum
     * position.
     * c. If the current index i is equal to maxJump, return false as we cannot go any further.
     * Return true if maxJump is greater than or equal to lastPosition.
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), as we use only constant amount of additional space.
     */
    public static boolean canJump(int[] nums) {
        int lastPosition = nums.length - 1;
        int maxJump = 0;

        for (int i = 0; i < lastPosition; i++) {
            int maxPosition = i + nums[i];
            if (maxPosition > maxJump) {
                maxJump = maxPosition;
            }
            if (maxJump == i) {
                return false;
            }
        }

        return maxJump >= lastPosition;
    }
}
