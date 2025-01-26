
/***
 1005. Maximize Sum Of Array After K Negations

Easy
Given an integer array nums and an integer k, modify the array in the following way:

choose an index i and replace nums[i] with -nums[i].
You should apply this process exactly k times. You may choose the same index i multiple times.

Return the largest possible sum of the array after modifying it in this way.

 

Example 1:

Input: nums = [4,2,3], k = 1
Output: 5
Explanation: Choose index 1 and nums becomes [4,-2,3].
Example 2:

Input: nums = [3,-1,0,2], k = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
Example 3:

Input: nums = [2,-3,-1,5,-4], k = 2
Output: 13
Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
 

Constraints:

1 <= nums.length <= 104
-100 <= nums[i] <= 100
1 <= k <= 104
 */

import java.util.Arrays;

public class MaximizeSumAfterKNegations {
    public static void main(String[] args) {
        // Test case 1:
        int[] arr1 = {-2, 9, 3, -1};
        int K1 = 2;
        int result1 = maximizeSumAfterKNegations(arr1, K1);
        System.out.println("Test Case 1 - Input array: " + arrayToString(arr1));
        System.out.println("Test Case 1 - K: " + K1);
        System.out.println("Test Case 1 - Maximized Sum: " + result1);

        // Test case 2: single negative number, with more negations
        int[] arr2 = {-8, 3, 5, -3};
        int K2 = 3;
        int result2 = maximizeSumAfterKNegations(arr2, K2);
        System.out.println("Test Case 2 - Input array: " + arrayToString(arr2));
        System.out.println("Test Case 2 - K: " + K2);
        System.out.println("Test Case 2 - Maximized Sum: " + result2);

        // Test case 3: no negative numbers
        int[] arr3 = {4, 2, 3};
        int K3 = 1;
        int result3 = maximizeSumAfterKNegations(arr3, K3);
        System.out.println("Test Case 3 - Input array: " + arrayToString(arr3));
        System.out.println("Test Case 3 - K: " + K3);
        System.out.println("Test Case 3 - Maximized Sum: " + result3);
    }

    /**
     * Maximize Sum of Array After K Negations
     * Given an array of integers, negate up to K elements to maximize the sum of the array.
     * Algorithm Steps:
     * 1. Sort the array to handle negative numbers first.
     * 2. Negate as many negative numbers as possible.
     * 3. If any negations are left, apply them to the smallest absolute number.
     * 4. Return the sum of the array after all negations.
     * Time Complexity: O(n log n) for sorting, where n is the size of the array.
     * Space Complexity: O(1) since we only use constant extra space.
     */

    public static int maximizeSumAfterKNegations(int[] nums, int K) {
        // Step 1: Sort the array so we can handle negatives first
        Arrays.sort(nums);

        // Step 2: Negate negative numbers until K is exhausted
        for (int i = 0; i < nums.length && K > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];  // Negate the negative number
                K--;  // Decrease K as we've used one negation
            }
        }

        // Step 3: Sort again to bring the smallest number to the front
        Arrays.sort(nums);

        // Step 4: If K is still odd, negate the smallest number
        if (K % 2 == 1) {
            nums[0] = -nums[0];
        }

        // Step 5: Calculate the sum of the array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }

    // Helper method to convert an array to a string for easy display
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
