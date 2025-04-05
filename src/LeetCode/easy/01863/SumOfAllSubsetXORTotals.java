import java.util.Arrays;

/**
 * 1863. Sum of All Subset XOR Totals
 *
 * The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
 * For example, the XOR total of the array [2, 5, 6] is 2 XOR 5 XOR 6 = 1.
 *
 * Given an array nums, return the sum of all XOR totals for every subset of nums.
 * Note: Subsets with the same elements should be counted multiple times.
 *
 * Example:
 * Input: nums = [1, 3]
 * Output: 6
 * Explanation:
 * The 4 subsets of [1, 3] are:
 * - []: XOR total is 0.
 * - [1]: XOR total is 1.
 * - [3]: XOR total is 3.
 * - [1, 3]: XOR total is 1 XOR 3 = 2.
 * Sum of all XOR totals: 0 + 1 + 3 + 2 = 6.
 *
 * Constraints:
 * 1 <= nums.length <= 12
 * 1 <= nums[i] <= 20
 */
public class SumOfAllSubsetXORTotals {
    public static void main(String[] args) {
        // Test Cases
        runTestCase(new int[]{1, 3}, 6);
        runTestCase(new int[]{5, 1, 6}, 28);
        runTestCase(new int[]{1}, 1);
        runTestCase(new int[]{2, 4, 6}, 28);
        runTestCase(new int[]{3, 4, 5, 6, 7, 8}, 480);
    }

    // Method to run each test case
    public static void runTestCase(int[] nums, int expected) {
        int result1 = subsetXORSumBruteForce(nums);
        int result2 = subsetXORSumBitmask(nums);
        int result3 = subsetXORSumBacktracking(nums);
        int result4 = subsetXORSumOptimized(nums);

        System.out.println("Test Case - Input: nums = " + Arrays.toString(nums));
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Brute Force): " + result1);
        System.out.println("Result (Bitmask): " + result2);
        System.out.println("Result (Backtracking): " + result3);
        System.out.println("Result (Optimized): " + result4);
        System.out.println("All results match expected: " +
                (result1 == expected && result2 == expected && result3 == expected && result4 == expected));
        System.out.println();
    }

    /**
     * Approach 1: Brute Force (Generate All Subsets)
     *
     * Algorithm Steps:
     * 1. Generate all possible subsets of the array.
     * 2. For each subset, compute its XOR total.
     * 3. Sum all the XOR totals.
     *
     * Time Complexity: O(n * 2^n), where n is the length of the array.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int subsetXORSumBruteForce(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        // Iterate over all possible subsets
        for (int mask = 0; mask < (1 << n); mask++) {
            int subsetXOR = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subsetXOR ^= nums[i];
                }
            }
            totalSum += subsetXOR;
        }

        return totalSum;
    }

    /**
     * Approach 2: Bitmask (Optimized Subset Generation)
     *
     * Algorithm Steps:
     * 1. Use bitmask to represent subsets.
     * 2. For each bitmask, compute the XOR of the subset it represents.
     * 3. Sum all the XOR totals.
     *
     * Time Complexity: O(n * 2^n), where n is the length of the array.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int subsetXORSumBitmask(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        // Total number of subsets is 2^n
        for (int mask = 0; mask < (1 << n); mask++) {
            int currentXOR = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentXOR ^= nums[i];
                }
            }
            totalSum += currentXOR;
        }

        return totalSum;
    }

    /**
     * Approach 3: Backtracking (DFS)
     *
     * Algorithm Steps:
     * 1. Use backtracking to explore all subsets.
     * 2. For each element, choose to include or exclude it.
     * 3. Compute the XOR for each subset and accumulate the sum.
     *
     * Time Complexity: O(2^n), where n is the length of the array.
     * Space Complexity: O(n), due to the recursion stack.
     */
    public static int subsetXORSumBacktracking(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private static int backtrack(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }
        // Include the current number
        int include = backtrack(nums, index + 1, currentXOR ^ nums[index]);
        // Exclude the current number
        int exclude = backtrack(nums, index + 1, currentXOR);
        return include + exclude;
    }

    /**
     * Approach 4: Optimized (Bitwise Property)
     *
     * Algorithm Steps:
     * 1. Observe that each bit's contribution to the total sum is independent.
     * 2. For each bit position, determine how many subsets have an odd number of elements with that bit set.
     * 3. The total sum is the sum of (bit_value * 2^(n-1)) for each bit set in any number.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int subsetXORSumOptimized(int[] nums) {
        int totalOR = 0;
        for (int num : nums) {
            totalOR |= num;
        }
        return totalOR * (1 << (nums.length - 1));
    }
}