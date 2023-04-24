/*
75. Sort Colors
Medium
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color
are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.


Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] input1 = {2, 0, 2, 1, 1, 0};
        int[] expected1 = {0, 0, 1, 1, 2, 2};
        sortColors(input1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1));
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.equals(expected1, input1));

        int[] input2 = {1, 0, 0, 1, 1, 2, 2, 0};
        int[] expected2 = {0, 0, 0, 1, 1, 1, 2, 2};
        sortColors(input2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2));
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.equals(expected2, input2));

        int[] input3 = {2, 2, 2, 2, 2, 2, 0, 0, 0, 0};
        int[] expected3 = {0, 0, 0, 0, 2, 2, 2, 2, 2, 2};
        sortColors(input3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(input3));
        System.out.println("Test Case 3 - Expected result: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Result matches expected: " + Arrays.equals(expected3, input3));


        int[] input4 = {2, 0, 2, 1, 1, 0, 0, 1, 2, 1, 0, 1, 2, 0, 2};
        int[] expected4 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2};
        sortColors(input4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(input4));
        System.out.println("Test Case 4 - Expected result: " + Arrays.toString(expected4));
        int[] actual4 = Arrays.copyOfRange(input4, 0, expected4.length);
        System.out.println("Test Case 4 - Result matches expected: " + Arrays.equals(expected4, actual4));

    }


    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
     * color
     * are adjacent, with the colors in the order red, white, and blue.
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     * You must solve this problem without using the library's sort function.
     * Algorithm: Dutch National Flag Algorithm
     * Steps:
     * 1. Initialize three pointers low, mid and high representing the current position for 0, 1 and 2 respectively.
     * 2. Loop through the array using mid pointer, and perform the following operations:
     * a. If nums[mid] is 0, swap it with nums[low], increment both low and mid pointers.
     * b. If nums[mid] is 1, increment mid pointer.
     * c. If nums[mid] is 2, swap it with nums[high], decrement high pointer.
     * 3. Continue until mid pointer crosses over high pointer.
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), as we use only constant amount of additional space.
     */
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            int current = nums[mid];
            if (current == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (current == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }


    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
     * color
     * are adjacent, with the colors in the order red, white, and blue.
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     * You must solve this problem without using the library's sort function.
     * Algorithm Steps:
     * 1. Count the number of red (0), white (1), and blue (2) elements in the array.
     * 2. Overwrite the original array with the sorted elements.
     * - Write redCount 0's at the beginning of the array.
     * - Write whiteCount 1's after the redCount 0's.
     * - Write blueCount 2's at the end of the array.
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), as we use only constant amount of additional space.
     */
    public static void sortColors2(int[] nums) {
        // Step 1: Count the number of red (0), white (1), and blue (2) elements in the array.
        int n = nums.length;
        int redCount = 0, whiteCount = 0, blueCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                redCount++;
            } else if (nums[i] == 1) {
                whiteCount++;
            } else {
                blueCount++;
            }
        }

        // Step 2: Overwrite the original array with the sorted elements.
        for (int i = 0; i < redCount; i++) {
            nums[i] = 0;
        }
        for (int i = redCount; i < whiteCount + redCount; i++) {
            nums[i] = 1;
        }
        for (int i = whiteCount + redCount; i < n; i++) {
            nums[i] = 2;
        }
    }

    public static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[secondIndex];
        arr[secondIndex] = arr[firstIndex];
        arr[firstIndex] = temp;
    }
}

