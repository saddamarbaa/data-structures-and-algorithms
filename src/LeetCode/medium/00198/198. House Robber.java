/*
198. House Robber
Medium
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems
connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

import java.util.Arrays;

public class Arra {
    public static void main(String[] args) {

        int[] nums1 = {1, 3, 1, 3, 100};
        int expected1 = 103;
        int result1 = rob(nums1);
        System.out.println("Test Case 1 - Expected: " + expected1 + ", Actual: " + result1);

        int[] nums2 = {2, 7, 9, 3, 1};
        int expected2 = 12;
        int result2 = rob(nums2);
        System.out.println("Test Case 2 - Expected: " + expected2 + ", Actual: " + result2);

        int[] nums3 = {2, 1, 1, 2};
        int expected3 = 4;
        int result3 = rob(nums3);
        System.out.println("Test Case 3 - Expected: " + expected3 + ", Actual: " + result3);

        int[] nums4 = {5, 2, 6, 3, 1, 7, 10, 2, 8};
        int expected4 = 29;
        int result4 = rob(nums4);
        System.out.println("Test Case 4 - Expected: " + expected4 + ", Actual: " + result4);

        // Test case with array of length 1
        int[] nums5 = {5};
        int expected5 = 5;
        int result5 = rob(nums5);
        System.out.println("Test Case 5 - Input: " + Arrays.toString(nums5));
        System.out.println("Test Case 5 - Expected result: " + expected5);
        System.out.println("Test Case 5 - Actual result: " + result5);
        System.out.println("Test Case 5 - Result matches expected: " + (result5 == expected5));

        // Test case with array of length 2
        int[] nums6 = {2, 7};
        int expected6 = 7;
        int result6 = rob(nums6);
        System.out.println("Test Case 6 - Input: " + Arrays.toString(nums6));
        System.out.println("Test Case 6 - Expected result: " + expected6);
        System.out.println("Test Case 6 - Actual result: " + result6);
        System.out.println("Test Case 6 - Result matches expected: " + (result6 == expected6));
    }


    /**
     * Given an array nums, find the maximum amount of money that can be robbed without robbing adjacent houses.
     * Function signature: public static int rob(int[] nums)
     * Algorithm Steps:
     * Check if the input array is null or empty. If it is, return 0.
     * Calculate the length of the input array.
     * If the length of the input array is 1, return the first element.
     * Create an array dp with length n to store the maximum amount of money that can be robbed up to each house.
     * Initialize dp[0] to nums[0] and dp[1] to the maximum of nums[0] and nums[1].
     * Use a loop to fill in the remaining elements of dp:
     * For each house i starting at 2, calculate the maximum amount of money that can be robbed up to the current house:
     * dp[i] = max(dp[i-2] + nums[i], dp[i-1])
     * Return dp[n-1], which represents the maximum amount of money that can be robbed without robbing adjacent houses.
     * Time Complexity: The time complexity of this function is O(n), where n is the length of the input array nums.
     * This is because we loop through each house i once and perform a constant amount of work for each house.
     * Space Complexity: The space complexity of this function is O(n), where n is the length of the input array nums
     * . This is because we use an array dp of length n to store the maximum amount of money that can be robbed up to
     * each house.
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;


        // If only one element just returned
        if (n == 1) return nums[0];


        // Create array to store maximum loot at each index
        int[] dp = new int[n];


        // Memoize the maximum loot at first 2 indexes
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        // Use them to fill the complete empty array
        for (int i = 2; i < n; i++) {
            // Core logic
            // Calculate the maximum amount of money that can be robbed up to the current house
            int maxLootAtCurrentHouse = Math.max(dp[i - 2] + nums[i], dp[i - 1]);

            dp[i] = maxLootAtCurrentHouse;
        }

        return dp[n - 1];
    }
}

