/***
 1464. Maximum Product of Two Elements in an Array
 Easy
 Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).

 Example 1:

 Input: nums = [3,4,5,2]
 Output: 12
 Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 Example 2:

 Input: nums = [1,5,4,5]
 Output: 16
 Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
 Example 3:

 Input: nums = [3,7]
 Output: 12

 Constraints:

 2 <= nums.length <= 500
 1 <= nums[i] <= 10^3
 */

import java.util.*;

public class MaximumProductOfTwoElements {
    public static void main(String[] args) {

        // Test case 1
        int[] nums1 = {3, 4, 5, 2};
        int expected1 = 12; // (4 - 1) * (5 - 1) = 12
        int result1 = maxProduct(nums1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2
        int[] nums2 = {1, 5, 4, 5};
        int expected2 = 16; // (5 - 1) * (5 - 1) = 16
        int result2 = maxProduct(nums2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);

        // Test case 3
        int[] nums3 = {10, 2, 5, 2};
        int expected3 = 36; // (10 - 1) * (5 - 1) = 36
        int result3 = maxProduct(nums3);
        System.out.println("Test Case 3 - Expected: " + expected3);
        System.out.println("Test Case 3 - Actual: " + result3);
    }



    public static int maxProduct(int[] nums) {
        int largest =Integer.MIN_VALUE;
        int secondLargest =Integer.MIN_VALUE;

        for(int i  = 0; i < nums.length; i++){
            int n = nums[i];
            if(n >= largest){
                secondLargest =largest;
                largest = n;
            }

            if(n > secondLargest && n != largest)
                secondLargest = n;
        }



        // System.out.println(num1 + "  " + num2);
        return (secondLargest - 1)* (largest - 1);
    }

    /**
     * Finds the maximum product of (nums[i] - 1) * (nums[j] - 1) where 0 <= i, j < nums.length.
     *
     * @param nums The array of integers.
     * @return The maximum product of two elements minus 1.
     */
    public static int maxProduct2(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        // Take the last two elements and apply the formula (nums[i] - 1) * (nums[j] - 1)
        int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}
