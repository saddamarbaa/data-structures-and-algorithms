
/**
 * 2401. Longest Nice Subarray
 * Medium
 *
 * You are given an array nums consisting of positive integers.
 * We call a subarray of nums nice if the bitwise AND of every pair of elements
 * that are in different positions in the subarray is equal to 0.
 *
 * Return the length of the longest nice subarray.
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 * Input: nums = [1,3,8,48,10]
 * Output: 3
 * Explanation: The longest nice subarray is [3,8,48]. The subarray satisfies:
 * - 3 AND 8 = 0.
 * - 3 AND 48 = 0.
 * - 8 AND 48 = 0.
 * It can be proven that no longer nice subarray can be obtained, so we return 3.
 *
 * Example 2:
 * Input: nums = [3,1,5,11,13]
 * Output: 1
 * Explanation: The longest nice subarray is any subarray containing one element.
 * There are no subarrays with a size greater than 1 that satisfy the condition.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 */
public class LongestNiceSubarray {
    public static void main(String[] args) {
        // Test Cases
        runTestCase(new int[]{1, 3, 8, 48, 10}, 3);
        runTestCase(new int[]{3, 1, 5, 11, 13}, 1);
        runTestCase(new int[]{2, 4, 8, 16}, 4);
        runTestCase(new int[]{6, 2, 7, 11}, 2);
        runTestCase(new int[]{12, 15, 7, 3}, 2);
        runTestCase(new int[]{14, 15, 16, 17}, 1);
    }

    // Method to run each test case
    public static void runTestCase(int[] nums, int expected) {
        int result = longestNiceSubarray(nums);

        System.out.println("Test Case - Input: nums = " + java.util.Arrays.toString(nums));
        System.out.println("Expected result: " + expected);
        System.out.println("Result: " + result);
        System.out.println("Result matches expected: " + (result == expected));
        System.out.println();
    }

    /**
     * Approach: Sliding Window + Bitwise AND
     *
     * Algorithm Steps:
     * 1. Use a sliding window approach, extending the right end of the window.
     * 2. Keep track of the bitwise OR of all numbers in the current window.
     * 3. If a number violates the condition (i.e., the AND result is not 0),
     *    slide the left end of the window to the right.
     * 4. Return the maximum window size.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int longestNiceSubarray(int[] nums) {
        int maxLen = 0;
        int left = 0;
        int bitwiseAnd = 0;

        for (int right = 0; right < nums.length; right++) {
            while ((bitwiseAnd & nums[right]) != 0) {
                bitwiseAnd ^= nums[left];
                left++;
            }
            bitwiseAnd |= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
