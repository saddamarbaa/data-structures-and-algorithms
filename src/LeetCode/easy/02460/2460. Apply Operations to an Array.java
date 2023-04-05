/*
2460. Apply Operations to an Array
Easy
You are given a 0-indexed array nums of size n consisting of non-negative integers.

You need to apply n - 1 operations to this array where, in the ith operation (0-indexed), you will apply the
following on the ith element of nums:

If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0. Otherwise, you skip this operation.
After performing all the operations, shift all the 0's to the end of the array.

For example, the array [1,0,2,0,0,1] after shifting all its 0's to the end, is [1,2,1,0,0,0].
Return the resulting array.

Note that the operations are applied sequentially, not all at once.

Example 1:

Input: nums = [1,2,2,1,1,0]
Output: [1,4,2,0,0,0]
Explanation: We do the following operations:
- i = 0: nums[0] and nums[1] are not equal, so we skip this operation.
- i = 1: nums[1] and nums[2] are equal, we multiply nums[1] by 2 and change nums[2] to 0. The array becomes [1,4,0,1,
1,0].
- i = 2: nums[2] and nums[3] are not equal, so we skip this operation.
- i = 3: nums[3] and nums[4] are equal, we multiply nums[3] by 2 and change nums[4] to 0. The array becomes [1,4,0,2,
0,0].
- i = 4: nums[4] and nums[5] are equal, we multiply nums[4] by 2 and change nums[5] to 0. The array becomes [1,4,0,2,
0,0].
After that, we shift the 0's to the end, which gives the array [1,4,2,0,0,0].
Example 2:

Input: nums = [0,1]
Output: [1,0]
Explanation: No operation can be applied, we just shift the 0 to the end.


Constraints:

2 <= nums.length <= 2000
0 <= nums[i] <= 1000
 */


import java.util.Arrays;

public class  ApplyOperations {
    public static void main(String[] args) {
        // Test Case 1: Normal, zeros in middle
        int[] nums1 = {0, 1, 0, 3, 12};
         applyOperations(nums1);
        System.out.println("Test Case 1 - After moving zeroes: " + Arrays.toString(nums1)); // Output: [1, 3, 12, 0, 0]

        // Test Case 2: Normal, zeros at beginning
        int[] nums2 = {0, 0, 1, 0, 3, 12};
         applyOperations(nums2);
        System.out.println("Test Case 2 - After moving zeroes: " + Arrays.toString(nums2)); // Output: [1, 3, 12, 0,
        // 0, 0]

        // Test Case 3: Normal, no zeros
        int[] nums3 = {1, 3, 12};
        applyOperations(nums3);
        System.out.println("Test Case 3 - After moving zeroes: " + Arrays.toString(nums3)); // Output: [1, 3, 12]

        // Test Case 4: Empty array
        int[] nums4 = {};
         applyOperations(nums4);
        System.out.println("Test Case 4 - After moving zeroes: " + Arrays.toString(nums4)); // Output: []

        // Test Case 5: Array with one element
        int[] nums5 = {0};
         applyOperations(nums5);
        System.out.println("Test Case 5 - After moving zeroes: " + Arrays.toString(nums5)); // Output: [0]

        // Test Case 6: Array with only zeros
        int[] nums6 = {0, 0, 0};
         applyOperations(nums6);
        System.out.println("Test Case 6 - After moving zeroes: " + Arrays.toString(nums6)); // Output: [0, 0, 0]

        // Test Case 7: Normal, zeros at end
        int[] nums7 = {1, 3, 12, 0, 0};
         applyOperations(nums7);
        System.out.println("Test Case 7 - After moving zeroes: " + Arrays.toString(nums7)); // Output: [1, 3, 12, 0, 0]

        // Test Case 8: Normal, repeated values
        int[] nums8 = {0, 1, 0, 1, 0, 1};
         applyOperations(nums8);
        System.out.println("Test Case 8 - After moving zeroes: " + Arrays.toString(nums8)); // Output: [1, 1, 1, 0,
        // 0, 0]

        // Test Case 9: Normal, mixed values
        int[] nums9 = {0, 2, 3, 0, 0, 7, 0, 8, 0};
         applyOperations(nums9);
        System.out.println("Test Case 9 - After moving zeroes: " + Arrays.toString(nums9)); // Output: [2, 3, 7, 8,
        // 0, 0, 0, 0, 0]

        // Test Case 10: Normal, already sorted
        int[] nums10 = {1, 2, 3, 4, 5};
         applyOperations(nums10);
        System.out.println("Test Case 10 - After moving zeroes: " + Arrays.toString(nums10)); // Output: [1, 2, 3, 4, 5]


        // Test Case 11: Large array
        int[] nums11 = {1, 0, 0, 0, 2, 0, 3, 0, 0, 4, 0, 5, 0, 0, 6, 7, 0, 8, 9, 0};
         applyOperations(nums11);
        System.out.println("Test Case 11 - After moving zeroes: " + Arrays.toString(nums11)); // Output: [1, 2, 3, 4,
        // 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]


    }

    /**
     * Apply Operations to an Array
     * Given an integer array nums of size n consisting of non-negative integers.
     * Apply n - 1 operations to this array where, in the ith operation (0-indexed),
     * you will apply the following on the ith element of nums:
     * If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0.
     * Otherwise, you skip this operation.
     * After performing all the operations, shift all the 0's to the end of the array.
     * Return the resulting array.
     * Algorithm steps:
     * Iterate over the elements of the input array nums from 0 to n-1.
     * If the current element nums[i] is equal to the next element nums[i+1], multiply nums[i] by 2 and set nums[i+1]
     * to 0.
     * After the loop, iterate over the elements of the input array nums from leftPointer = 0 to rightPointer = 1.
     * If the current element nums[rightPointer] is not equal to the current element nums[leftPointer] and
     * nums[leftPointer] is 0,
     * swap the elements at leftPointer and rightPointer and increment leftPointer by 1.
     * If the current element at leftPointer is not zero, increment leftPointer by 1.
     * Otherwise, skip to the next iteration.
     * After the loop, return the modified array nums.
     * To ensure the solution is correct, we will use a custom judge to test it.
     * Time complexity:
     * The method iterates over all the elements of the input array twice. Therefore, the time complexity is O(n),
     * where n is the length of the input array.
     * Space complexity:
     * The method only uses constant extra space, therefore the space complexity is O(1).
     */

    public static void  applyOperations(int[] nums) {
        int n = nums.length;
        int leftPointer = 0;
        int rightPointer = 1;


        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }

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

