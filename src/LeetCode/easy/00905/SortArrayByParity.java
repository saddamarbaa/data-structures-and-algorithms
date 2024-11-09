import java.util.Arrays;

/**
 * 905. Sort Array By Parity
 * 
 * Given an integer array nums, move all the even integers to the beginning of the array followed by all the odd integers. 
 * Return any array that satisfies this condition.
 * 
 * Example 1:
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * 
 * Constraints:
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 */
public class SortArrayByParity {
    public static void main(String[] args) {

        // Test case 1 - Mixed even and odd numbers
        int[] nums1 = {3, 1, 2, 4};
        int[] expected1 = {2, 4, 3, 1}; // Order of even and odd elements can vary
        int[] result1 = sortArrayByParity(nums1);
        System.out.println("Test Case 1 - Expected: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual: " + Arrays.toString(result1));

        // Test case 2 - Single element (even)
        int[] nums2 = {0};
        int[] expected2 = {0};
        int[] result2 = sortArrayByParity(nums2);
        System.out.println("Test Case 2 - Expected: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual: " + Arrays.toString(result2));

        // Test case 3 - All odd numbers
        int[] nums3 = {1, 3, 5, 7};
        int[] expected3 = {1, 3, 5, 7};
        int[] result3 = sortArrayByParity(nums3);
        System.out.println("Test Case 3 - Expected: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Actual: " + Arrays.toString(result3));
    }

    /**
     * Returns an array sorted by parity, with all even numbers first, followed by odd numbers.
     *
     * @param nums The integer array to sort.
     * @return The sorted array by parity.
     */
    public static int[] sortArrayByParity(int[] nums) {
        // Two-pointer approach
        int left = 0;
        int right = nums.length - 1;

        // While left pointer is less than right
        while (left < right) {
            // If left points to an even number, move the left pointer
            if (nums[left] % 2 == 0) {
                left++;
            } 
            // If right points to an odd number, move the right pointer
            else if (nums[right] % 2 != 0) {
                right--;
            } 
            // Otherwise, swap the even and odd numbers
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        return nums;
    }


    public static int[] sortArrayByParity2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // If left is even and right is odd, move both pointers inward
            if (nums[left] % 2 == 0 && nums[right] % 2 == 1) {
                left++;
                right--;
            }
            // If left is odd and right is even, swap and move both inward
            else if (nums[left] % 2 == 1 && nums[right] % 2 == 0) {
                swap(nums, left, right);
                left++;
                right--;
            }
            // If both are even, just move the left pointer
            else if (nums[left] % 2 == 0) {
                left++;
            }
            // If both are odd, just move the right pointer
            else {
                right--;
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
