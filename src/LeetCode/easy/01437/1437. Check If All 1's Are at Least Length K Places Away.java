/*
1437. Check If All 1's Are at Least Length K Places Away
Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other,
otherwise return false.
Example 1:

Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.
Example 2:

Input: nums = [1,0,0,1,0,1], k = 2
Output: false
Explanation: The second 1 and third 1 are only one apart from each other.

Constraints:
1 <= nums.length <= 105
0 <= k <= nums.length
nums[i] is 0 or 1
 */

import java.util.Arrays;

public class KLengthApart {
    public static void main(String[] args) {
        // Test case 1:
        int[] nums1 = {1, 0, 0, 0, 1, 0, 0, 1};
        int k1 = 2;
        boolean result1 = kLengthApart(nums1, k1);
        System.out.println("Test case 1 result: " + result1); // expected output: true

        // Test case 2:
        int[] nums2 = {0, 1, 0, 1};
        int k2 = 1;
        boolean result2 = kLengthApart(nums2, k2);
        System.out.println("Test case 2 result: " + result2); // expected output: true

        // Test case 3:
        int[] nums3 = {1, 0, 0, 1, 0, 1};
        int k3 = 2;
        boolean result3 = kLengthApart(nums3, k3);
        System.out.println("Test case 3 result: " + result3); // expected output: false

        // Test case 4:
        int[] nums4 = {0, 0, 0, 1, 0, 0, 0, 0, 1};
        int k4 = 2;
        boolean result4 = kLengthApart(nums4, k4);
        System.out.println("Test case 4 result: " + result4); // expected output: true

        // Test case 5:
        int[] nums5 = {1, 1, 0, 0, 0, 1, 0, 1};
        int k5 = 3;
        boolean result5 = kLengthApart(nums5, k5);
        System.out.println("Test case 5 result: " + result5); // expected output: false
    }


    /**
     * Check If All 1's Are at Least Length K Places Away
     * <p>
     * Given a binary array `nums` and an integer `k`, return `true` if all 1's are at least `k` places away from each
     * other, otherwise return `false`.
     * <p>
     * Algorithm steps:
     * Iterate over the elements of the input array `nums`.
     * If the current element is 1:
     * If `isFirstFound` is not 0 and `count` is less than `k`, return `false`.
     * Reset `count` to 0.
     * Increment `isFirstFound`.
     * Otherwise, if `isFirstFound` is not 0:
     * Increment `count`.
     * <p>
     * Time complexity:
     * The method iterates over all the elements of the input array once. Therefore, the time complexity is O(n),
     * where n is the length of the input array.
     * <p>
     * Space complexity:
     * The method uses a constant amount of extra space. Therefore, the space complexity is O(1).
     */
    public static boolean kLengthApart(int[] nums, int k) {
        int count = 0;
        int firstOneIndex = 0;
        int rest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (firstOneIndex != 0 && count < k) {
                    return false;
                }
                rest = 0;
                firstOneIndex++;
                count = 0;
            }


            if (firstOneIndex != 0 && rest != 0) {
                count++;
            }
            rest++;
        }

        return true;
    }
}