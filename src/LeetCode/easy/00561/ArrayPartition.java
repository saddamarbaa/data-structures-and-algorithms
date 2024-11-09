import java.util.Arrays;

/**
 * 561. Array Partition
 * 
 * Given an integer array nums of 2n integers, your task is to group these integers into n pairs 
 * (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. 
 * Return the maximized sum.
 *
 * Example 1:
 * Input: nums = [1,4,3,2]
 * Output: 4
 * Explanation: All possible pairings (ignoring the order of elements) are:
 * 1. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * So the maximum possible sum is 4.
 *
 * Example 2:
 * Input: nums = [6,2,6,5,1,2]
 * Output: 9
 * Explanation: The optimal pairing is (1, 2), (2, 5), (6, 6). The sum of min values is 1 + 2 + 6 = 9.
 */
public class ArrayPartition {
    public static void main(String[] args) {

        // Test case 1
        int[] nums1 = {1, 4, 3, 2};
        int expected1 = 4;
        int result1 = arrayPairSum(nums1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2
        int[] nums2 = {6, 2, 6, 5, 1, 2};
        int expected2 = 9;
        int result2 = arrayPairSum(nums2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);
    }

    /**
     * Returns the maximum sum of the min value of pairs.
     *
     * @param nums The integer array.
     * @return The maximum sum of min(ai, bi) for all pairs.
     */
    public static int arrayPairSum(int[] nums) {
        // Sort the array to pair up the smallest numbers
        Arrays.sort(nums);
        int sum = 0;

        // Sum every second element (which will be the smaller element of each pair)
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
