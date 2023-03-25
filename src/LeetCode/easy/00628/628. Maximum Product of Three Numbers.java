/*
628. Maximum Product of Three Numbers
Easy
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
 

Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000
*/


import java.util.Arrays;
public class MaximumProduct {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int sumWithNegativeNumber = nums[0] * nums[1] * nums[n - 1];
        int positiveNumSum = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int overAllSum = Math.max(sumWithNegativeNumber, positiveNumSum);
        return overAllSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int maxProduct1 = maximumProduct(nums1);
        System.out.println("The maximum product of Three Numbers in " + Arrays.toString(nums1) + " is " + maxProduct1); //
        // Expected result is 6

        int[] nums2 = {2, 3, 0, 4};
        int maxProduct2 = maximumProduct(nums2);
        System.out.println("The maximum product of Three Numbers in " + Arrays.toString(nums2) + " is " + maxProduct2); //
        // Expected result is 24

        int[] nums3 = {-100, -98, -1, 2, 3, 4};
        int maxProduct3 = maximumProduct(nums3);
        System.out.println("The maximum product of Three Numbers in " + Arrays.toString(nums3) + " is " + maxProduct3); //
        // Expected result is 39200


        int[] nums4 = {-1, -2, -3};
        int maxProduct4 = maximumProduct(nums4);
        System.out.println("The maximum product of Three Numbers in " + Arrays.toString(nums4) + " is " + maxProduct4); //
        // Expected result is -6
    }
}
