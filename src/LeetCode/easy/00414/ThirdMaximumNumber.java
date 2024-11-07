/**
 414. Third Maximum Number
 Easy
 Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

 Example 1:

 Input: nums = [3,2,1]
 Output: 1
 Explanation:
 The first distinct maximum is 3.
 The second distinct maximum is 2.
 The third distinct maximum is 1.
 Example 2:

 Input: nums = [1,2]
 Output: 2
 Explanation:
 The first distinct maximum is 2.
 The second distinct maximum is 1.
 The third distinct maximum does not exist, so the maximum (2) is returned instead.
 Example 3:

 Input: nums = [2,2,3,1]
 Output: 1
 Explanation:
 The first distinct maximum is 3.
 The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 The third distinct maximum is 1.


 Constraints:

 1 <= nums.length <= 104
 -231 <= nums[i] <= 231 - 1

 */


import java.util.Arrays;

public class ThirdMaximumNumber {
    public static void main(String[] args) {

        // Test case 1 - Third maximum number exists
        int[] nums1 = {3, 2, 1};
        int expected1 = 1;
        int result1 = thirdMax(nums1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2 - Only two distinct numbers, return the max
        int[] nums2 = {1, 2};
        int expected2 = 2;
        int result2 = thirdMax(nums2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);

        // Test case 3 - Third maximum number doesn't exist, return the max
        int[] nums3 = {2, 2, 3, 1};
        int expected3 = 1;
        int result3 = thirdMax(nums3);
        System.out.println("Test Case 3 - Expected: " + expected3);
        System.out.println("Test Case 3 - Actual: " + result3);
    }

    /**
     * Returns the third maximum number in the array, or the maximum if third does not exist.
     *
     * @param nums The integer array to check.
     * @return The third maximum number or the maximum number.
     */
    public static int thirdMax(int[] nums) {
        int n = nums.length;
        
        // Sort the array
        Arrays.sort(nums);
        
        // Count distinct numbers
        int count = 1;

        // Iterate from the second last element
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                count++;
            }
            
            // If we have found 3 distinct numbers, return the third largest
            if (count == 3) {
                return nums[i - 1];
            }
        }

        // If there are less than 3 distinct numbers, return the largest
        return nums[n - 1];
    }
}
