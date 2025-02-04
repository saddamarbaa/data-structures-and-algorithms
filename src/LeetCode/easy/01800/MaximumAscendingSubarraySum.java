/***
 * 1800. Maximum Ascending Subarray Sum
 *
 * Easy
 *
 * Given an array of positive integers `nums`, return the maximum possible sum of an ascending subarray in `nums`.
 * A subarray is defined as a contiguous sequence of elements in the array.
 * A subarray [nums_l, nums_l+1, ..., nums_r-1, nums_r] is ascending if for all i where l <= i < r, nums[i] < nums[i + 1].
 *
 * Example:
 * Input: nums = [10,20,30,5,10,50]
 * Output: 65
 * Explanation: The ascending subarray [10,20,30] has the maximum sum 60, while [5,10,50] has the maximum sum 65.
 *
 * Constraints:
 * - 1 <= nums.length <= 100
 * - 1 <= nums[i] <= 1000
 */

public class MaximumAscendingSubarraySum {

    // ==================================================
    // Solution 1: Iterative Approach
    // ==================================================
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i]; // continue summing ascending subarray
            } else {
                currentSum = nums[i];  // reset sum when the ascending condition breaks
            }
            maxSum = Math.max(maxSum, currentSum); // keep track of maximum sum
        }

        return maxSum;
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        MaximumAscendingSubarraySum solution = new MaximumAscendingSubarraySum();

        // Test case 1:
        int[] nums1 = {10, 20, 30, 5, 10, 50};
        System.out.println("Test case 1: " + solution.maxAscendingSum(nums1)); // Output: 65

        // Test case 2:
        int[] nums2 = {12, 17, 15, 13, 10, 11, 12};
        System.out.println("Test case 2: " + solution.maxAscendingSum(nums2)); // Output: 33

        // Test case 3:
        int[] nums3 = {100, 10, 1};
        System.out.println("Test case 3: " + solution.maxAscendingSum(nums3)); // Output: 100
    }
}
