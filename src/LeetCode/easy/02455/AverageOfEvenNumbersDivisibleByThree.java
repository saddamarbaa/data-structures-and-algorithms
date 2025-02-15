import java.util.*;

/**
 * 2455. Average Value of Even Numbers That Are Divisible by Three
 *
 * Easy
 *
 * Given an integer array nums of positive integers, return the average value of all even numbers that are divisible by three.
 *
 * Example 1:
 * Input: nums = [1,3,6,10,12,15]
 * Output: 9
 * Explanation: 6 and 12 are even numbers divisible by three. Their average is (6 + 12) / 2 = 9.
 *
 * Example 2:
 * Input: nums = [1,2,4,7,10]
 * Output: 0
 * Explanation: There is no even number divisible by three, so the average is 0.
 *
 * Constraints:
 * - 1 <= nums.length <= 1000
 * - 1 <= nums[i] <= 1000
 */

public class AverageOfEvenNumbersDivisibleByThree {

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 3, 6, 10, 12, 15};
        int result1 = averageValue(nums1);
        System.out.println("Test Case 1 - Output: " + result1);  // Expected output: 9

        // Test Case 2
        int[] nums2 = {1, 2, 4, 7, 10};
        int result2 = averageValue(nums2);
        System.out.println("Test Case 2 - Output: " + result2);  // Expected output: 0

        // Test Case 3
        int[] nums3 = {6, 18, 24, 5, 9, 2};
        int result3 = averageValue(nums3);
        System.out.println("Test Case 3 - Output: " + result3);  // Expected output: 16
    }

    /**
     * Finds the average value of even numbers that are divisible by three in the array.
     *
     * Algorithm:
     * 1. Loop through the array to check for even numbers divisible by three.
     * 2. Calculate the sum of those numbers.
     * 3. Track the count of such numbers.
     * 4. Return the average, or return 0 if no numbers meet the criteria.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1), constant space.
     *
     * @param nums - The input array of integers.
     * @return The average value of even numbers divisible by three, or 0 if none found.
     */
    public static int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                sum += num;
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }
}
