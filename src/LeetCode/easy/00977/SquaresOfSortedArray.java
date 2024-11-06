/**
 * 977. Squares of a Sorted Array
 * Easy
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted
 * in non-decreasing order.
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *
 *
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using
 * a different approach?
 */

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {

        // Test case 1 - Array with both positive and negative numbers
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] expected1 = {0, 1, 9, 16, 100};
        int[] result1 = sortedSquares(nums1);
        System.out.println("Test Case 1 - Expected: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual: " + Arrays.toString(result1));

        // Test case 2 - Array with all negative numbers
        int[] nums2 = {-7, -3, -2, -1};
        int[] expected2 = {1, 4, 9, 49};
        int[] result2 = sortedSquares(nums2);
        System.out.println("Test Case 2 - Expected: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual: " + Arrays.toString(result2));

        // Test case 3 - Array with all positive numbers
        int[] nums3 = {1, 2, 3, 5};
        int[] expected3 = {1, 4, 9, 25};
        int[] result3 = sortedSquares(nums3);
        System.out.println("Test Case 3 - Expected: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Actual: " + Arrays.toString(result3));

        // Test case 4 - Single element array
        int[] nums4 = {-5};
        int[] expected4 = {25};
        int[] result4 = sortedSquares(nums4);
        System.out.println("Test Case 4 - Expected: " + Arrays.toString(expected4));
        System.out.println("Test Case 4 - Actual: " + Arrays.toString(result4));

        // Test case 5 - Zeroes in the array
        int[] nums5 = {0, 0, 0};
        int[] expected5 = {0, 0, 0};
        int[] result5 = sortedSquares(nums5);
        System.out.println("Test Case 5 - Expected: " + Arrays.toString(expected5));
        System.out.println("Test Case 5 - Actual: " + Arrays.toString(result5));
    }

    /**
     * Sort the squares of the elements in the given array in non-decreasing order.
     *
     * @param nums The input sorted array.
     * @return A new array with the squares of each element in non-decreasing order.
     */
    /**
     Algorithm Steps:
     1. Use two pointers, one starting at the beginning (left) and one at the end (right) of the array.
     2. Compare the absolute values of the numbers at these two pointers.
     3. The larger absolute value's square is placed in the current position (from the end) of the result array.
     4. Move the pointer accordingly:
        - If the left element is larger, increment the left pointer.
        - If the right element is larger, decrement the right pointer.
     5. Repeat until all elements are processed.
    
     Time Complexity: O(n)
     We process each element of the array exactly once.
    
     Space Complexity: O(n)
     We use a separate array to store the result, which takes O(n) extra space.
     *
     */

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0; // Pointer for the left side
        int right = n - 1; // Pointer for the right side
        int k = n - 1; // Position to fill in the result array

        // Merge from both ends of the array
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[k--] = leftSquare;
                left++;
            } else {
                result[k--] = rightSquare;
                right--;
            }
        }

        return result;
    }
}
