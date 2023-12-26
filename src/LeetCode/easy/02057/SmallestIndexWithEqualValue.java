/**
 2057. Smallest Index With Equal Value
 Easy
 Given a 0-indexed integer array nums, return the smallest index i of nums such that i mod 10 == nums[i], or -1 if such index does not exist.

 x mod y denotes the remainder when x is divided by y.

 Example 1:

 Input: nums = [0,1,2]
 Output: 0
 Explanation:
 i=0: 0 mod 10 = 0 == nums[0].
 i=1: 1 mod 10 = 1 == nums[1].
 i=2: 2 mod 10 = 2 == nums[2].
 All indices have i mod 10 == nums[i], so we return the smallest index 0.
 Example 2:

 Input: nums = [4,3,2,1]
 Output: 2
 Explanation:
 i=0: 0 mod 10 = 0 != nums[0].
 i=1: 1 mod 10 = 1 != nums[1].
 i=2: 2 mod 10 = 2 == nums[2].
 i=3: 3 mod 10 = 3 != nums[3].
 2 is the only index which has i mod 10 == nums[i].
 Example 3:

 Input: nums = [1,2,3,4,5,6,7,8,9,0]
 Output: -1
 Explanation: No index satisfies i mod 10 == nums[i].


 Constraints:

 1 <= nums.length <= 100
 0 <= nums[i] <= 9
 */

import java.util.Arrays;

public class SmallestIndexWithEqualValue {

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {0, 1, 2};
        int expected1 = 0;
        int result1 = smallestEqual(nums1);
        printResult(nums1, expected1, result1);

        // Test Case 2
        int[] nums2 = {4, 3, 2, 1};
        int expected2 = 2;
        int result2 = smallestEqual(nums2);
        printResult(nums2, expected2, result2);

        // Test Case 3
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int expected3 = -1;
        int result3 = smallestEqual(nums3);
        printResult(nums3, expected3, result3);
    }

    /**
     * Find the smallest index i of nums such that i mod 10 == nums[i].
     * If no such index exists, return -1.
     */
    public static int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Print the result of a test case.
     */
    public static void printResult(int[] nums, int expected, int result) {
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        System.out.println("Result matches expected: " + (result == expected));
        System.out.println();
    }
}
