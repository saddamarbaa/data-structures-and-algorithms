/*
189. Rotate Array
Medium
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 */

import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        // Test Case 1 - Rotate array by 3 positions
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] expected1 = {3, 4, 5, 1, 2};
        rotate(nums1, 3);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.equals(nums1, expected1));

        // Test Case 2 - Rotate array by 1 position
        int[] nums2 = {9, 8, 7, 6};
        int[] expected2 = {6, 9, 8, 7};
        rotate(nums2, 1);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.equals(nums2, expected2));

        // Test Case 3 - Rotate array by 4 position
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] expected3 = {3, 4, 5, 1, 2};
        rotate(nums3, 3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Actual result: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Result matches expected: " + Arrays.equals(nums3, expected3));


        // Test Case 4 - Rotate array by 2 position
        int[] nums4 = {1, 2, 3, 4, 5, 6};
        int[] expected4 = {5, 6, 1, 2, 3, 4};
        rotate(nums4, 2);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(nums4));
        System.out.println("Test Case 4 - Expected result: " + Arrays.toString(expected4));
        System.out.println("Test Case 4 - Actual result: " + Arrays.toString(nums4));
        System.out.println("Test Case 4 - Result matches expected: " + Arrays.equals(nums4, expected4));


        // Test Case 5 - Rotate array by 7 position
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] expected5 = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        rotate(nums5, 7);
        System.out.println("Test Case 5 - Input: " + Arrays.toString(nums5));
        System.out.println("Test Case 5 - Expected result: " + Arrays.toString(expected5));
        System.out.println("Test Case 5 - Actual result: " + Arrays.toString(nums5));
        System.out.println("Test Case 5 - Result matches expected: " + Arrays.equals(nums5, expected5));


        // Test Case 6 - Rotate array by 10 position
        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] expected6 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        rotate(nums6, 10);
        System.out.println("Test Case 6 - Input: " + Arrays.toString(nums6));
        System.out.println("Test Case 6 - Expected result: " + Arrays.toString(expected6));
        System.out.println("Test Case 6 - Actual result: " + Arrays.toString(nums6));
        System.out.println("Test Case 6 - Result matches expected: " + Arrays.equals(nums6, expected6));
    }


    /**
     * Given an array nums and an integer numRotations, rotate the array to the right by numRotations.
     * Algorithm Steps:
     * 1. Ensure k is within array bounds.
     * 2. Reverse the entire array.
     * 3. Reverse the first k elements.
     * 4. Reverse the remaining elements.
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), as we use only constant amount of additional space.
     */
    public static void rotate(int[] nums, int numRotations) {
        int n = nums.length;
        // Ensure numRotations is within array bounds
        numRotations %= n;
        // Reverse entire array
        reverse(nums, 0, n - 1);
        // Reverse first k elements
        reverse(nums, 0, numRotations - 1);
        // Reverse remaining elements
        reverse(nums, numRotations, n - 1);


        // Updated code for right rotation

        // Reverse entire array
        // reverse(nums, 0, nums.length - 1);
        // Reverse last k elements
        // reverse(nums, 0, nums.length - numRotations - 1);
        // Reverse remaining elements
        //  reverse(nums, nums.length - numRotations, nums.length - 1);
    }

    /**
     * Given an array of integers 'nums', reverse the elements of the array in place.
     * Algorithm Steps:
     * 1. Initialize two pointers 'start' and 'end' to point to the beginning and end of the array, respectively.
     * 2. While 'start' is less than 'end':
     * a. Swap the elements at 'start' and 'end'.
     * b. Increment 'start' by 1 and decrement 'end' by 1.
     * 3. The array is now reversed in place.
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), as we use only constant extra space for the 'start' and 'end' pointers.
     */
    public static void reverse(int nums[], int start, int end) {
        // While start index is less than end index
        while (start < end) {
            // Swap elements at start and end indices
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            // Increment start index and decrement end index
            start++;
            end--;
        }
    }


    /**
     * Given an array nums and an integer numRotations, rotate the array to the right by numRotations.
     * Function signature: public static void rotateArray(int[] nums, int numRotations)
     * Algorithm Steps:
     * 1. Initialize a variable 'n' to store the length of the array.
     * 2. Create an auxiliary array of size 'numRotations'.
     * 3. Store the first 'numRotations' elements of the original array in the auxiliary array.
     * 4. Shift the remaining elements of the original array to the left by 'numRotations' positions.
     * 5. Copy the elements from the auxiliary array to the end of the original array.
     * Time Complexity: O(n * numRotations), where n is the length of the input array.
     * Space Complexity: O(numRotations), as we use an auxiliary array of size 'numRotations'
     */
    public static void rotate2(int[] nums, int numRotations) {
        int n = nums.length;
        int[] temp = new int[numRotations];

        // Store the first 'numRotations' elements in the auxiliary array
        for (int i = 0; i < numRotations; i++) {
            temp[i] = nums[i];
        }

        // Shift the remaining elements of the original array to the left by 'numRotations' positions
        for (int i = numRotations; i < n; i++) {
            nums[i - numRotations] = nums[i];
        }

        // Copy the auxiliary array elements to the end of the original array
        for (int i = 0; i < numRotations; i++) {
            nums[n - numRotations + i] = temp[i];
        }
    }


    /**
     * Given an array nums and an integer numRotations, rotate the array to the right by numRotations.
     * Function signature: public static void rotateArray(int[] nums, int numRotations)
     * Algorithm Steps:
     * 1. Initialize a variable 'n' to store the length of the array.
     * 2. Loop through the array 'numRotations' times:
     * a. Store the last element of the array in a temporary variable 'temp'.
     * b. Shift all the elements of the array one position to the right.
     * c. Set the first element of the array to 'temp'.
     * Time Complexity: O(n * numRotations), where n is the length of the input array.
     * Space Complexity: O(1), as we use only constant amount of additional space.
     */
    public static void rotate3(int[] nums, int numRotations) {
        int n = nums.length;

        // handle cases where numRotations > n
        numRotations = numRotations % n;

        // handle case where numRotations is negative
        if (numRotations < 0) {
            numRotations = numRotations + n;
        }

        for (int i = 0; i < numRotations; i++) {
            rotateOnce(nums, numRotations, true);
        }
    }


    public static void rotateOnce(int[] nums, int numRotations, boolean isLeftRotate) {
        int n = nums.length;

        if (isLeftRotate) {
            int temp = nums[n - 1];
            // Shift all elements one position to the right
            for (int j = n - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }

            // Insert the last element at the beginning of the array
            nums[0] = temp;
        } else {
            // right rotation

            // Store the first element of the array
            int temp = nums[0];

            // Shift all elements one position to the right
            for (int j = 1; j < n; j++) {
                nums[j - 1] = nums[j];
            }

            // Insert the first element at the end of the array
            nums[n - 1] = temp;
        }
    }
}

