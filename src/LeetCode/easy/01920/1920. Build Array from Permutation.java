/**
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same length
 * where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
 *
 * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 *
 * Example:
 * Input: nums = [0,2,1,5,3,4]
 * Output: [0,1,2,4,5,3]
 * Explanation: The array ans is built as follows:
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 *      = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
 *      = [0,1,2,4,5,3]
 *
 * Constraints:
 * - 1 <= nums.length <= 1000
 * - 0 <= nums[i] < nums.length
 * - The elements in nums are distinct.
 *
 * Follow-up: Can you solve it without using an extra space (i.e., O(1) memory)?
 */


import java.util.Arrays;

public class BuildArrayFromPermutation {

    public static void main(String[] args) {
        // Test Case 1
        int[] input1 = {0, 2, 1, 5, 3, 4};
        int[] expected1 = {0, 1, 2, 4, 5, 3};
        int[] result1 = buildArray(input1);

        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1));
        System.out.println("Expected result: " + Arrays.toString(expected1));
        System.out.println("Actual result: " + Arrays.toString(result1));
        System.out.println("Result matches expected: " + Arrays.equals(result1, expected1));
        System.out.println();

        // Test Case 2
        int[] input2 = {5, 0, 1, 2, 3, 4};
        int[] expected2 = {4, 5, 0, 1, 2, 3};
        int[] result2 = buildArray(input2);

        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2));
        System.out.println("Expected result: " + Arrays.toString(expected2));
        System.out.println("Actual result: " + Arrays.toString(result2));
        System.out.println("Result matches expected: " + Arrays.equals(result2, expected2));
        System.out.println();

        // Test Case 3
        int[] input3 = {1, 2, 3, 4, 0};
        int[] expected3 = {2, 3, 4, 0, 1};
        int[] result3 = buildArray(input3);

        System.out.println("Test Case 3 - Input: " + Arrays.toString(input3));
        System.out.println("Expected result: " + Arrays.toString(expected3));
        System.out.println("Actual result: " + Arrays.toString(result3));
        System.out.println("Result matches expected: " + Arrays.equals(result3, expected3));
    }

    /**
     * Algorithm Steps:
     * 1. Create an array ans of the same length as nums to store the result.
     * 2. Iterate over each index i from 0 to n-1.
     *    - Set ans[i] to nums[nums[i]].
     * 3. Return the built array ans.
     *
     * Time Complexity: O(n) - The algorithm iterates over each element of the input array once.
     * Space Complexity: O(n) - Additional space is used to store the result array ans.
     */
    public static int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}
