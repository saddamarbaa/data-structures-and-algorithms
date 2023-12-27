
/**
 1512. Number of Good Pairs
Easy
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
 
Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

*/

import java.util.Arrays;

public class GoodPairs {
    public static void main(String[] args) {
        // Example usage
        int[] nums1 = {1, 2, 3, 1, 1, 3};
        int result1 = numIdenticalPairs(nums1);
        int expected1 = 4;
        printResult(nums1, result1, expected1);

        int[] nums2 = {1, 1, 1, 1};
        int result2 = numIdenticalPairs(nums2);
        int expected2 = 6;
        printResult(nums2, result2, expected2);

        int[] nums3 = {1, 2, 3};
        int result3 = numIdenticalPairs(nums3);
        int expected3 = 0;
        printResult(nums3, result3, expected3);
    }

    /**
     * Algorithm Steps:
     * 1. Initialize a variable `numPairs` to 0.
     * 2. Iterate through each element in the array using a loop with index `i` from 0 to `n - 2`.
     *    a. Initialize a counter variable `count` to 0.
     *    b. Iterate through the remaining elements using a loop with index `j` from `i + 1` to `n - 1`.
     *    c. If the element at index `i` is equal to the element at index `j`, increment the `count`.
     *    d. After the inner loop, add the value of `count` to `numPairs`.
     * 3. After completing the outer loop, return the final value of `numPairs`.
     *
     * Time Complexity: O(n^2) - Two nested loops iterate over the array.
     * Space Complexity: O(1) - Constant space is used (no extra data structures).
     */
    public static int numIdenticalPairs(int[] nums) {
        int numPairs = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && i < j) {
                    numPairs++;
                }
            }
        }

        return numPairs;
    }

    /**
     * Print the result of a test case.
     */
    public static void printResult(int[] nums, int result, int expected) {
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        System.out.println("Result matches expected: " + (result == expected));
        System.out.println();
    }
}
