import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2873. Maximum Value of an Ordered Triplet I
 *
 * You are given a 0-indexed integer array nums.
 * Return the maximum value of (nums[i] - nums[j]) * nums[k] for any triplet of indices (i, j, k)
 * where i < j < k. If no such triplet exists, return 0.
 *
 * Example:
 * Input: nums = [12,6,1,2,7]
 * Output: 77
 * Explanation: The triplet (0, 2, 4) gives the value (12 - 1) * 7 = 77.
 *
 * Input: nums = [1,10,3,4,19]
 * Output: 133
 * Explanation: The triplet (1, 3, 4) gives the value (10 - 4) * 19 = 133.
 *
 * Constraints:
 * 3 <= nums.length <= 100
 * 1 <= nums[i] <= 10^6
 */
public class MaximumValueOfOrderedTripletI {
    public static void main(String[] args) {
        // Test Cases
        runTestCase(new int[]{12, 6, 1, 2, 7}, 77);
        runTestCase(new int[]{1, 10, 3, 4, 19}, 133);
        runTestCase(new int[]{8, 6, 3, 1}, 0);
        runTestCase(new int[]{5, 5, 5, 5, 5}, 0);
        runTestCase(new int[]{10, 2, 5, 3, 1, 8, 4}, 56);
    }

    // Method to run each test case
    public static void runTestCase(int[] nums, long expected) {
        long startTime1 = System.nanoTime();
        long result1 = maximumTripletValueBasic(nums);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        long startTime2 = System.nanoTime();
        long result2 = maximumTripletValueOptimized(nums);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        System.out.println("Test Case - Input: nums = " + Arrays.toString(nums));
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Basic Approach): " + result1 + " (Time: " + duration1 + " ns)");
        System.out.println("Result (Optimized Approach): " + result2 + " (Time: " + duration2 + " ns)");
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected));
        System.out.println();
    }

    /**
     * Approach 1: Basic Triple Loop Approach
     *
     * Algorithm Steps:
     * 1. Iterate through all possible triplets (i, j, k) where i < j < k.
     * 2. For each triplet, calculate (nums[i] - nums[j]) * nums[k].
     * 3. Keep track of the maximum value found.
     *
     * Time Complexity: O(n^3), where n is the length of nums.
     * Space Complexity: O(1), using constant extra space.
     */
    public static long maximumTripletValueBasic(int[] nums) {
        long maxValue = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long current = (long)(nums[i] - nums[j]) * nums[k];
                    if (current > maxValue) {
                        maxValue = current;
                    }
                }
            }
        }

        return maxValue;
    }

    /**
     * Approach 2: Optimized Approach using Prefix and Suffix Arrays
     *
     * Algorithm Steps:
     * 1. Create prefix array to store maximum nums[i] up to each index.
     * 2. Create suffix array to store maximum nums[k] from each index to end.
     * 3. For each j, calculate (prefix[j-1] - nums[j]) * suffix[j+1] and track maximum.
     *
     * Time Complexity: O(n), where n is the length of nums.
     * Space Complexity: O(n), for the prefix and suffix arrays.
     */
    public static long maximumTripletValueOptimized(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        // Create prefix max array
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], nums[i]);
        }

        // Create suffix max array
        int[] suffixMax = new int[n];
        suffixMax[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], nums[i]);
        }

        long maxValue = 0;
        for (int j = 1; j < n-1; j++) {
            long current = (long)(prefixMax[j-1] - nums[j]) * suffixMax[j+1];
            if (current > maxValue) {
                maxValue = current;
            }
        }

        return maxValue;
    }
}