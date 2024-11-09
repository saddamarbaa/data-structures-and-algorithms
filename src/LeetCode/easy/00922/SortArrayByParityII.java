import java.util.Arrays;

/**
 * 922. Sort Array By Parity II
 *
 * Given an array of integers `nums` with half even and half odd numbers,
 * rearrange the array so that every even index has an even number and every
 * odd index has an odd number.
 *
 * Example 1:
 * Input: nums = [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4, 5, 2, 7] is a valid answer. Other valid answers include [2, 7, 4, 5], [2, 5, 4, 7], etc.
 *
 * Example 2:
 * Input: nums = [2,3]
 * Output: [2,3]
 *
 * Constraints:
 * - 2 <= nums.length <= 2 * 10^4
 * - nums.length is even.
 * - Half of the integers in nums are even.
 * - 0 <= nums[i] <= 1000
 */
public class SortArrayByParityII {
    public static void main(String[] args) {

        // Test case 1 - Typical case with even and odd numbers
        int[] nums1 = {4, 2, 5, 7};
        int[] expected1 = {4, 5, 2, 7}; // Other valid outputs possible
        int[] result1 = sortArrayByParityII(nums1);
        System.out.println("Test Case 1 - Expected: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual: " + Arrays.toString(result1));

        // Test case 2 - Small input case
        int[] nums2 = {2, 3};
        int[] expected2 = {2, 3};
        int[] result2 = sortArrayByParityII(nums2);
        System.out.println("Test Case 2 - Expected: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual: " + Arrays.toString(result2));
    }

    /**
     * Returns an array where even indices hold even numbers and odd indices hold odd numbers.
     *
     * @param nums The integer array to sort by parity.
     * @return The sorted array with even and odd numbers at the correct indices.
     */
    public static int[] sortArrayByParityII(int[] nums) {
        int evenIndex = 0;
        int oddIndex = 1;
        int n = nums.length;

        // Iterate through the array, sorting even and odd numbers into the correct places
        while (evenIndex < n && oddIndex < n) {
            // If nums[evenIndex] is odd and nums[oddIndex] is even, swap them
            if (nums[evenIndex] % 2 != 0 && nums[oddIndex] % 2 == 0) {
                swap(nums, evenIndex, oddIndex);
            }

            // If nums[evenIndex] is correct (even), move to the next even index
            if (nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }

            // If nums[oddIndex] is correct (odd), move to the next odd index
            if (nums[oddIndex] % 2 != 0) {
                oddIndex += 2;
            }
        }

        return nums;
    }

    // Swap helper function
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
