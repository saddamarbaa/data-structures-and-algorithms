/*
13. House Robber II
Medium
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed
. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two
adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
can rob tonight without alerting the police.

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */

import java.util.Arrays;

public class Arra {
    public static void main(String[] args) {

        // Test Case 1 - Empty array
        int[] nums1 = {};
        int expected1 = 0;
        int result1 = rob(nums1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test Case 2 - Single element array
        int[] nums2 = {5};
        int expected2 = 5;
        int result2 = rob(nums2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test Case 3 - Two element array
        int[] nums3 = {2, 3};
        int expected3 = 3;
        int result3 = rob(nums3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test Case 4 - Array with repeating elements
        int[] nums4 = {2, 2, 3, 3, 3, 4};
        int expected4 = 9;
        int result4 = rob(nums4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(nums4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));

        // Test Case 5 - Array with negative elements
        int[] nums5 = {-2, 3, -4, 0, 1};
        int expected5 = 4;
        int result5 = rob(nums5);
        System.out.println("Test Case 5 - Input: " + Arrays.toString(nums5));
        System.out.println("Test Case 5 - Expected result: " + expected5);
        System.out.println("Test Case 5 - Actual result: " + result5);
        System.out.println("Test Case 5 - Result matches expected: " + (result5 == expected5));

        // Test Case 6 - Given test case
        int[] nums6 = {2, 3, 140, 20, 10};
        int expected6 = 150;
        int result6 = rob(nums6);
        System.out.println("Test Case 6 - Input: " + Arrays.toString(nums6));
        System.out.println("Test Case 6 - Expected result: " + expected6);
        System.out.println("Test Case 6 - Actual result: " + result6);
        System.out.println("Test Case 6 - Result matches expected: " + (result6 == expected6));
    }


    /**
     * Given an array nums representing the amount of money in each house of a circle, find the maximum amount of
     * money that can be robbed without robbing adjacent houses.
     * Function signature: public static int rob(int[] nums)
     * Algorithm Steps:
     * Check if the input array is null or empty. If it is, return 0.
     * Calculate the length of the input array.
     * If the length of the input array is 1, return the first element.
     * If the length of the input array is 2, return the maximum of the two elements.
     * If the length of the input array is 3, return the maximum of the three elements.
     * Calculate the maximum loot that can be robbed without robbing adjacent houses in two scenarios:
     * Rob the first house but not the last house.
     * Rob the last house but not the first house.
     * Return the maximum loot between the two scenarios.
     * Time Complexity: The time complexity of this algorithm is O(n), where n is the length of the input array. This
     * is because we loop through each house i once and perform a constant amount of work for each house. The loop
     * runs twice over a subset of the input array of size n-2, so the time complexity is O(2*(n-2)) which simplifies
     * to O(n).
     * Space Complexity: The space complexity of this algorithm is O(1), which is constant space. We only use a
     * constant amount of space to store the maximum loot before the first 2 houses, the maximum loot before the
     * current house, and the maximum loot at the current house. We don't use any additional space that depends on
     * the size of the input array..
     */
    public static int rob(int[] nums) {
        // Check edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (n == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }

        // Memoize the maximum loot before first 2 houses
        int maxLootBeforeLastHouse = nums[0];
        int maxLootBeforeCurrentHouse = Math.max(nums[0], nums[1]);

        // Iterate over the houses from the third house to the second-to-last house
        for (int i = 2; i < n - 1; i++) {
            // Calculate the maximum amount of money that can be robbed up to the current house
            int maxLootAtCurrentHouse = Math.max(maxLootBeforeLastHouse + nums[i], maxLootBeforeCurrentHouse);

            // Update the maximum loot before last house and current house
            maxLootBeforeLastHouse = maxLootBeforeCurrentHouse;
            maxLootBeforeCurrentHouse = maxLootAtCurrentHouse;
        }

        // Calculate the maximum loot if the last house is robbed
        int maxLootIfLastHouseIsRobbed = maxLootBeforeCurrentHouse;

        // Memoize the maximum loot before first 2 houses
        maxLootBeforeLastHouse = nums[1];
        maxLootBeforeCurrentHouse = Math.max(nums[1], nums[2]);

        // Iterate over the houses from the fourth house to the last house
        for (int i = 3; i < n; i++) {
            // Calculate the maximum amount of money that can be robbed up to the current house
            int maxLootAtCurrentHouse = Math.max(maxLootBeforeLastHouse + nums[i], maxLootBeforeCurrentHouse);

            // Update the maximum loot before last house and current house
            maxLootBeforeLastHouse = maxLootBeforeCurrentHouse;
            maxLootBeforeCurrentHouse = maxLootAtCurrentHouse;
        }

        // Calculate the maximum loot if the first house is robbed
        int maxLootIfFirstHouseIsRobbed = maxLootBeforeCurrentHouse;

        // Return the maximum loot that can be robbed
        return Math.max(maxLootIfFirstHouseIsRobbed, maxLootIfLastHouseIsRobbed);
    }


    /**
     * Given an array nums representing the amount of money in each house of a circle, find the maximum amount of
     * money that can be robbed without robbing adjacent houses.
     * Function signature: public static int rob(int[] nums)
     * Algorithm Steps:
     * Check if the input array is null or empty. If it is, return 0.
     * Calculate the length of the input array.
     * If the length of the input array is 1, return the first element.
     * If the length of the input array is 2, return the maximum of the two elements.
     * If the length of the input array is 3, return the maximum of the three elements.
     * Create two arrays, dp1 and dp2, with length n to store the maximum amount of money that can be robbed up to
     * each house in two scenarios:
     * dp1: the first house is robbed but the last house is not robbed
     * dp2: the last house is robbed but the first house is not robbed
     * Initialize dp1[0] to nums[0], dp1[1] to the maximum of nums[0] and nums[1], dp2[1] to nums[1], and dp2[2] to
     * the maximum of nums[1] and nums[2].
     * Use a loop to fill in the remaining elements of dp1 and dp2:
     * For dp1, start from index 2 and calculate the maximum amount of money that can be robbed up to the current house:
     * dp1[i] = max(dp1[i-2] + nums[i], dp1[i-1])
     * For dp2, start from index 3 and calculate the maximum amount of money that can be robbed up to the current house:
     * dp2[i] = max(dp2[i-2] + nums[i], dp2[i-1])
     * Return the maximum of dp1[n-2] and dp2[n-1], which represents the maximum amount of money that can be robbed
     * without robbing adjacent houses.
     * Time Complexity: The time complexity of this function is O(n), where n is the length of the input array nums.
     * This is because we loop through each house i once and perform a constant amount of work for each house.
     * Space Complexity: The space complexity of this function is O(n), where n is the length of the input array nums
     * . This is because we use two arrays dp1 and dp2 of length n to store the maximum amount of money that can be
     * robbed up to
     * each house in two different scenarios.
     */
    public static int rob2(int[] nums) {
        // Edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        if (n == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }

        // Create array to store maximum loot before last house and maximum loot before current house
        int[] maxLootBeforeLastHouse = new int[n - 1];
        int[] maxLootBeforeCurrentHouse = new int[n];

        // Memoize the maximum loot before first 2 houses
        maxLootBeforeLastHouse[0] = nums[0];
        maxLootBeforeLastHouse[1] = Math.max(nums[0], nums[1]);

        maxLootBeforeCurrentHouse[1] = nums[1];
        maxLootBeforeCurrentHouse[2] = Math.max(nums[2], nums[1]);

        for (int i = 3; i < n; i++) {
            // Core logic
            // Calculate the maximum amount of money that can be robbed up to the current house
            int maxLootAtCurrentHouse = Math.max(maxLootBeforeCurrentHouse[i - 2] + nums[i],
                    maxLootBeforeCurrentHouse[i - 1]);
            maxLootBeforeCurrentHouse[i] = maxLootAtCurrentHouse;
        }

        // Use them to fill the complete empty array
        for (int i = 2; i < n - 1; i++) {
            // Core logic
            // Calculate the maximum amount of money that can be robbed up to the current house
            int maxLootAtCurrentHouse = Math.max(maxLootBeforeLastHouse[i - 2] + nums[i],
                    maxLootBeforeLastHouse[i - 1]);
            maxLootBeforeLastHouse[i] = maxLootAtCurrentHouse;
        }

        // Return the maximum loot that can be robbed
        return Math.max(maxLootBeforeLastHouse[n - 2], maxLootBeforeCurrentHouse[n - 1]);
    }
}

