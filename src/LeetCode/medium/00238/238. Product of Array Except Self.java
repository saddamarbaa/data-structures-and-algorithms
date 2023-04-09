/*
238. Product of Array Except Self
Medium
Companies
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space
for space complexity analysis.)
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProductExceptSelf {
    public static void main(String[] args) {

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] expected1 = {24, 12, 8, 6};
        int[] result1 = productExceptSelf(nums1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.toString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.equals(expected1, result1));


        // Test case 2
        int[] nums2 = {0, 0};
        int[] expected2 = {0, 0};
        int[] result2 = productExceptSelf(nums2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.toString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.equals(expected2, result2));

        // Test case 3
        int[] nums3 = {1, 2, 3, 0};
        int[] expected3 = {0, 0, 0, 6};
        int[] result3 = productExceptSelf(nums3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Actual result: " + Arrays.toString(result3));
        System.out.println("Test Case 3 - Result matches expected: " + Arrays.equals(expected3, result3));

        // Test case 4
        int[] nums4 = {1, 1};
        int[] expected4 = {1, 1};
        int[] result4 = productExceptSelf(nums4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(nums4));
        System.out.println("Test Case 4 - Expected result: " + Arrays.toString(expected4));
        System.out.println("Test Case 4 - Actual result: " + Arrays.toString(result4));
        System.out.println("Test Case 4 - Result matches expected: " + Arrays.equals(expected4, result4));


        // Test case 5
        int[] nums5 = {2, 4, 6, 8, 10};
        int[] expected5 = {1920, 960, 640, 480, 384};
        int[] result5 = productExceptSelf(nums5);
        System.out.println("Test Case 5 - Input: " + Arrays.toString(nums5));
        System.out.println("Test Case 5 - Expected result: " + Arrays.toString(expected5));
        System.out.println("Test Case 5 - Actual result: " + Arrays.toString(result5));
        System.out.println("Test Case 5 - Result matches expected: " + Arrays.equals(expected5, result5));

        // Test case 6
        int[] nums6 = {1, 2, 3, 4, 5, 6};
        int[] expected6 = {720, 360, 240, 180, 144, 120};
        int[] result6 = productExceptSelf(nums6);
        System.out.println("Test Case 6 - Input: " + Arrays.toString(nums6));
        System.out.println("Test Case 6 - Expected result: " + Arrays.toString(expected6));
        System.out.println("Test Case 6 - Actual result: " + Arrays.toString(result6));
        System.out.println("Test Case 6 - Result matches expected: " + Arrays.equals(expected6, result6));

        // Test case 7
        int[] nums7 = {3, 7, 2, 8, 5, 9, 1};
        int[] expected7 = {5040, 2160, 7560, 1890, 3024, 1680, 9072};
        int[] result7 = productExceptSelf(nums7);
        System.out.println("Test Case 7 - Input: " + Arrays.toString(nums7));
        System.out.println("Test Case 7 - Expected result: " + Arrays.toString(expected7));
        System.out.println("Test Case 7 - Actual result: " + Arrays.toString(result7));
        System.out.println("Test Case 7 - Result matches expected: " + Arrays.equals(expected7, result7));
    }


    /**
     * Product of Array Except Self
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
     * elements of nums except nums[i].
     * Algorithm Steps:
     * Calculate prefix products of nums by iterating through nums from left to right and storing the product up to each
     * element in prefixProduct.
     * Calculate suffix products of nums by iterating through nums from right to left and storing the product up to each
     * element in suffixProduct.
     * Calculate the result array by iterating through nums and computing the product of prefixProduct[i] and
     * suffixProduct[i].
     * Return the result array.
     * Time Complexity:
     * The algorithm visits each element in the input array three times.
     * Therefore, the time complexity is O(n), where n is the length of the input array.
     * Space Complexity:
     * The algorithm uses two additional variables for prefix and suffix products.
     * Therefore, the space complexity is O(1).
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Calculate prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Calculate suffix products and result array
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffixProduct;
            suffixProduct = suffixProduct * nums[i];
        }

        return result;
    }


    /**
     * Product of Array Except Self
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
     * elements of
     * nums except nums[i].
     * Algorithm Steps:
     * Create two arrays, prefixProducts and suffixProducts, of the same length as nums.
     * Calculate prefix products of nums by iterating through nums from left to right and storing the product up to
     * each element in prefixProducts.
     * Calculate suffix products of nums by iterating through nums from right to left and storing the product up to
     * each element in suffixProducts.
     * Calculate the result array by iterating through nums and computing the product of prefixProducts[i] and
     * suffixProducts[i].
     * Return the result array.
     * Time Complexity:
     * The algorithm visits each element in the input array three times.
     * Therefore, the time complexity is O(n), where n is the length of the input array.
     * Space Complexity:
     * The algorithm uses two arrays of the same length as the input array.
     * Therefore, the space complexity is O(n), where n is the length of the input array.
     */
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] prefixProducts = new int[n];
        int[] suffixProducts = new int[n];
        int[] result = new int[n];

        // Calculate prefix products
        prefixProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        // Calculate suffix products
        suffixProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixProducts[i] = suffixProducts[i + 1] * nums[i + 1];
        }

        // Calculate result
        for (int i = 0; i < n; i++) {
            result[i] = prefixProducts[i] * suffixProducts[i];
        }

        return result;
    }

    /**
     * Product of Array Except Self
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
     * elements of nums except nums[i].
     * Algorithm Steps:
     * Count the number of zeros in the input array and find the product of all non-zero elements.
     * Traverse the input array and calculate the result for each element in the output array.
     * If there are multiple zeros in the input array, set the result to zero.
     * If there is only one zero in the input array, set the result to the non-zero product.
     * Otherwise, divide the non-zero product by the current element to get the result.
     * Return the resulting array.
     * Time Complexity: O(n), where n is the length of the input array, since the algorithm visits each element in
     * the input array twice.
     * Space Complexity: O(1), since the algorithm only uses a few integer variables to store the counts and products.
     */
    public static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        // Count the number of zeros and find the product of all non-zero elements
        int zeroCount = nums[0] == 0 ? 1 : 0;
        int nonZeroProduct = nums[0] == 0 ? 1 : nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                nonZeroProduct *= nums[i];
            }
        }

        // Calculate the result for each element in the output array
        for (int i = 0; i < n; i++) {
            if (zeroCount > 1) {
                // If there are multiple zeros, set the result to 0
                nums[i] = 0;
            } else if (nums[i] == 0 && zeroCount == 1) {
                // If this element is a zero and there is only one zero, set the result to the non-zero product
                nums[i] = nonZeroProduct;
            } else if (nums[i] != 0 && zeroCount == 1) {
                // If this element is not a zero and there is only one zero, set the result to 0
                nums[i] = 0;
            } else {
                // Otherwise, divide the non-zero product by the current element to get the result
                nums[i] = nonZeroProduct / nums[i];
            }
        }

        return nums;

    }
}

