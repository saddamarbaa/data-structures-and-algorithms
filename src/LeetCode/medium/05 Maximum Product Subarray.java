/*
152. Maximum Product Subarray
Medium
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.


Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/

import java.util.Arrays;

public class MaxProduct{
    /**
     * Computes the maximum product of a contiguous subarray within the input array.
     * Optimal solution
     * Kadane's Algorithm for Maximum Subarray problem
     *
     * @param nums an integer array
     * @return the maximum product of a contiguous subarray within the input array
     * @throws IllegalArgumentException if the input array is null
     *                                  Time Complexity: O(n), where n is the length of the array.
     */
    public static int maxProduct(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];

        for (int i = 1; i < n; i++) {
            // Update maxEndingHere and minEndingHere
            int currentNumber = nums[i];
            int tempMax = maxEndingHere;
            maxEndingHere = Math.max(Math.max(currentNumber, currentNumber * maxEndingHere),
                    currentNumber * minEndingHere);
            minEndingHere = Math.min(Math.min(currentNumber, currentNumber * tempMax), currentNumber * minEndingHere);


            // Update maxSoFar
            maxSoFar = Math.max(maxSoFar, maxEndingHere);

        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        int maxProduct1 = maxProduct(nums1);
        System.out.println("The maximum product subarray of " + Arrays.toString(nums1) + " is " + maxProduct1); //
        // Expected result is 6

        int[] nums2 = {2, 3, 0, 4};
        int maxProduct2 = maxProduct(nums2);
        System.out.println("The maximum product subarray of " + Arrays.toString(nums2) + " is " + maxProduct2); //
        // Expected result is 6

        int[] nums3 = {-2, -3, -4, -5, -1};
        int maxProduct3 = maxProduct(nums3);
        System.out.println("The maximum product subarray of " + Arrays.toString(nums3) + " is " + maxProduct3); //
        // Expected result is 120

        int[] nums4 = {-2, 0, -1};
        int maxProduct4 = maxProduct(nums4);
        System.out.println("The maximum product subarray of " + Arrays.toString(nums4) + " is " + maxProduct4); //
        // Expected result is 0

        int[] nums5 = {5, -1, -2, -3, -4};
        int maxProduct5 = maxProduct(nums5);
        System.out.println("The maximum product subarray of " + Arrays.toString(nums5) + " is " + maxProduct5); //
        // Expected result is 120

        int[] nums6 = {1, 2, 3, 4, 5};
        int maxProduct6 = maxProduct(nums6);
        System.out.println("The maximum product subarray of " + Arrays.toString(nums6) + " is " + maxProduct6); //
        // Expected result is 120

        int[] nums7 = {-2, 3, -4};
        int maxProduct7 = maxProduct(nums7);
        System.out.println("The maximum product subarray of " + Arrays.toString(nums7) + " is " + maxProduct7); //
        // Expected result is 24

        int[] nums8 = {0, 2};
        int maxProduct8 = maxProduct(nums8);
        System.out.println("The maximum product subarray of " + Arrays.toString(nums8) + " is " + maxProduct8); //
        // Expected result is 2

        int[] nums9 = {2, -5, -2, -4, 3};
        int maxProduct9 = maxProduct(nums9);
        System.out.println("The maximum product subarray of " + Arrays.toString(nums9) + " is " + maxProduct9); //
        // Expected result is 24
    }
}
