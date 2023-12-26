/**
 2778. Sum of Squares of Special Elements
 Easy
 You are given a 1-indexed integer array nums of length n.

 An element nums[i] of nums is called special if i divides n, i.e. n % i == 0.

 Return the sum of the squares of all special elements of nums.

 Example 1:

 Input: nums = [1,2,3,4]
 Output: 21
 Explanation: There are exactly 3 special elements in nums: nums[1] since 1 divides 4, nums[2] since 2 divides 4, and nums[4] since 4 divides 4.
 Hence, the sum of the squares of all special elements of nums is nums[1] * nums[1] + nums[2] * nums[2] + nums[4] * nums[4] = 1 * 1 + 2 * 2 + 4 * 4 = 21.
 Example 2:

 Input: nums = [2,7,1,19,18,3]
 Output: 63
 Explanation: There are exactly 4 special elements in nums: nums[1] since 1 divides 6, nums[2] since 2 divides 6, nums[3] since 3 divides 6, and nums[6] since 6 divides 6.
 Hence, the sum of the squares of all special elements of nums is nums[1] * nums[1] + nums[2] * nums[2] + nums[3] * nums[3] + nums[6] * nums[6] = 2 * 2 + 7 * 7 + 1 * 1 + 3 * 3 = 63.


 Constraints:

 1 <= nums.length == n <= 50
 1 <= nums[i] <= 50
 */

import java.util.Arrays;

public class SumOfSquares {
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        int expected1 = 21;
        int result1 = sumOfSquares(nums1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(nums1));
        System.out.println("Expected result: " + expected1);
        System.out.println("Actual result: " + result1);
        System.out.println("Result matches expected: " + (result1 == expected1));
        System.out.println();

        // Test Case 2
        int[] nums2 = {2, 7, 1, 19, 18, 3};
        int expected2 = 63;
        int result2 = sumOfSquares(nums2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(nums2));
        System.out.println("Expected result: " + expected2);
        System.out.println("Actual result: " + result2);
        System.out.println("Result matches expected: " + (result2 == expected2));
        System.out.println();

        // Test Case 3
        int[] nums3 = {5, 10, 15};
        int expected3 = 350;
        int result3 = sumOfSquares(nums3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(nums3));
        System.out.println("Expected result: " + expected3);
        System.out.println("Actual result: " + result3);
        System.out.println("Result matches expected: " + (result3 == expected3));
    }

    /**
     * Algorithm Steps:
     * 1. Initialize a variable `sum` to store the sum of squares of special elements.
     * 2. Iterate over the array `nums` from index 1 to n (inclusive).
     *    - If n is divisible by the current index i (n % i == 0), add the square of nums[i] to the sum.
     * 3. Return the final sum.
     *
     * Time Complexity: O(n) - The algorithm iterates over the array once.
     * Space Complexity: O(1) - Constant space is used.
     */
    public static int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += nums[i - 1] * nums[i - 1];
            }
        }

        return sum;
    }
}
