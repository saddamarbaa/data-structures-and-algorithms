/**
 16. 3Sum Closest
 Medium
 Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

 Return the sum of the three integers.

 You may assume that each input would have exactly one solution.

 Example 1:

 Input: nums = [-1,2,1,-4], target = 1
 Output: 2
 Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 Example 2:

 Input: nums = [0,0,0], target = 1
 Output: 0
 Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).


 Constraints:

 3 <= nums.length <= 500
 -1000 <= nums[i] <= 1000
 -104 <= target <= 104
 */

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        // Test cases for checking 3Sum Closest
        testThreeSumClosest(new int[]{-1, 2, 1, -4}, 1, 2);
        testThreeSumClosest(new int[]{0, 0, 0}, 1, 0);
        testThreeSumClosest(new int[]{1, 1, 1, 1}, 3, 3);
        testThreeSumClosest(new int[]{1, 1, -1, -1, 3}, -1, -1);
        testThreeSumClosest(new int[]{1, 2, 3, 4, 5}, 10, 10);
        testThreeSumClosest(new int[]{-1, 0, 1, 1}, 2, 2);
    }

    /**
     * Method to test the 3Sum Closest function.
     *
     * @param nums     The array of numbers.
     * @param target   The target sum.
     * @param expected The expected closest sum to the target.
     */
    public static void testThreeSumClosest(int[] nums, int target, int expected) {
        int result = threeSumClosest(nums, target);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        System.out.println("Test passed: " + (result == expected));
        System.out.println();
    }

    /**
     * Method to find the sum of three integers in nums such that the sum is closest to the target.
     *
     * @param nums   The array of numbers.
     * @param target The target sum.
     * @return The sum closest to the target.
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with the first possible sum

        // Iterate through the array, fixing one element
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If the current sum is closer to the target, update the closest sum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers based on comparison with target
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    return currentSum; // Exact match found, return immediately
                }
            }
        }

        return closestSum; // Return the closest sum found
    }
}
