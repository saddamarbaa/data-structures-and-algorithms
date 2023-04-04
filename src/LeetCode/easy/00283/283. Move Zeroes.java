/*
283. Move Zeroes
Easy
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero
elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 */


import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        //Test Case 1:Normal
        int[] nums1 = {
                0, 1, 0, 3, 12
        };
        moveZeroes(nums1);
        System.out.println("After moving zeroes: " + Arrays.toString(nums1)); // Output: [1, 3, 12, 0, 0]

        // Test Case 2: All zeroes
        int[] nums2 = {0, 0, 0, 0, 0};
        moveZeroes(nums2);
        System.out.println("After moving zeroes: " + Arrays.toString(nums2)); // Output: [0, 0, 0, 0, 0]

        // Test Case 3: No zeroes
        int[] nums3 = {1, 2, 3, 4, 5};
        moveZeroes(nums3);
        System.out.println("After moving zeroes: " + Arrays.toString(nums3)); // Output: [1, 2, 3, 4, 5]

        // Test Case 4: Single element array
        int[] nums4 = {0};
        moveZeroes(nums4);
        System.out.println("After moving zeroes: " + Arrays.toString(nums4)); // Output: [0]

        // Test Case 5: Large input
        int[] nums5 = {0, 1, 0, 3, 12, 0, 0, 5, 6, 0, 7, 8, 0, 9, 0};
        moveZeroes(nums5);
        System.out.println("After moving zeroes: " + Arrays.toString(nums5)); // Output: [1, 3, 12, 5, 6, 7, 8, 9, 0,
        // 0, 0, 0, 0, 0, 0]

        // Test Case 6: Array with all elements already in correct position
        int[] nums6 = {1, 2, 3, 0, 0, 0};
        moveZeroes(nums6);
        System.out.println("After moving zeroes: " + Arrays.toString(nums6)); // Output: [1, 2, 3, 0, 0, 0]

        // Test Case 7: Array with alternating zeroes and non-zeroes
        int[] nums7 = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5};
        moveZeroes(nums7);
        System.out.println("After moving zeroes: " + Arrays.toString(nums7)); // Output: [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]

        // Test Case 8: Array with only one non-zero element
        int[] nums8 = {0, 0, 0, 0, 1};
        moveZeroes(nums8);
        System.out.println("After moving zeroes: " + Arrays.toString(nums8)); // Output: [1, 0, 0, 0, 0]

        // Test Case 9: Array with only one zero element
        int[] nums9 = {1, 2, 3, 4, 0};
        moveZeroes(nums9);
        System.out.println("After moving zeroes: " + Arrays.toString(nums9)); // Output: [1, 2, 3, 4, 0]
    }

    /**
     * Move Zeroes to the End of Array
     * Given an integer array nums, move all the zeros to the end of the array while maintaining the relative order
     * of the non-zero elements. Then return the modified array.
     * Algorithm steps:
     * - Initialize leftPointer to 0 and rightPointer to 1.
     * - Iterate over the elements of the input array nums from rightPointer to n.
     * - If the current element at rightPointer is not zero and the current element at leftPointer is zero,
     * swap the elements at leftPointer and rightPointer and increment leftPointer by 1.
     * - If the current element at leftPointer is not zero, increment leftPointer by 1.
     * - Otherwise, skip to the next iteration.
     * - After the loop, return the modified array nums.
     * To ensure the solution is correct, we will use a custom judge to test it.
     * Time complexity:
     * The method iterates over all the elements of the input array once. Therefore, the time complexity is O(n),
     * where n is the length of the input array.
     * Space complexity:
     * The method only uses constant extra space, therefore the space complexity is O(1).
     */
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int leftPointer = 0;
        int rightPointer = 1;
        while (rightPointer < n) {
            if (nums[rightPointer] != nums[leftPointer] & nums[leftPointer] == 0) {
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = 0;
                leftPointer++;

            } else if (nums[leftPointer] != 0) {
                leftPointer++;
            }

            rightPointer++;
        }
    }
}

