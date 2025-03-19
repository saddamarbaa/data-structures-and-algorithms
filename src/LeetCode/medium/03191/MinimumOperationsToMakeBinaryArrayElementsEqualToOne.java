import java.util.Arrays;

/**
 * 3191. Minimum Operations to Make Binary Array Elements Equal to One I
 *
 * You are given a binary array nums (consisting of 0s and 1s).
 * In one operation, you can choose any subarray and flip all its elements (0s become 1s and 1s become 0s).
 * Return the minimum number of operations required to make all elements of the array equal to 1.
 *
 * Example:
 * Input: nums = [0, 1, 0]
 * Output: 2
 * Explanation:
 * - Flip the subarray [0, 1] to get [1, 0, 0].
 * - Flip the subarray [0, 0] to get [1, 1, 1].
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * nums[i] is either 0 or 1.
 */
public class MinimumOperationsToMakeBinaryArrayElementsEqualToOne {
    public static void main(String[] args) {
        // Test Cases
        runTestCase(new int[]{0, 1, 0}, 2);
        runTestCase(new int[]{1, 1, 1}, 0);
        runTestCase(new int[]{0, 0, 0}, 1);
        runTestCase(new int[]{0, 1, 1, 0}, 2);
        runTestCase(new int[]{1, 0, 1, 0, 1}, 3);
    }

    // Method to run each test case
    public static void runTestCase(int[] nums, int expected) {
        int result1 = minOperations(nums);
        int result2 = minOperations2(nums);

        System.out.println("Test Case - Input: nums = " + Arrays.toString(nums));
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Greedy Approach): " + result1);
        System.out.println("Result (Alternative Approach): " + result2);
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected));
        System.out.println();
    }

    /**
     * Approach 1: Greedy Approach
     *
     * Algorithm Steps:
     * 1. Iterate through the array and count the number of times a `0` is encountered.
     * 2. Each group of consecutive `0`s can be flipped in one operation.
     * 3. The total number of operations is equal to the number of such groups.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int minOperations(int[] nums) {
        int operations = 0;
        boolean inZeroGroup = false;

        for (int num : nums) {
            if (num == 0) {
                if (!inZeroGroup) {
                    operations++;
                    inZeroGroup = true;
                }
            } else {
                inZeroGroup = false;
            }
        }

        return operations;
    }

    /**
     * Approach 2: Alternative Approach (Using Flipping State)
     *
     * Algorithm Steps:
     * 1. Use a boolean variable to track whether we are in a flipped state.
     * 2. Iterate through the array and flip the state whenever a `0` is encountered.
     * 3. Count the number of flips required.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int minOperations2(int[] nums) {
        int operations = 0;
        boolean flip = false;

        for (int num : nums) {
            if ((num == 0 && !flip) || (num == 1 && flip)) {
                operations++;
                flip = !flip;
            }
        }

        return operations;
    }
}