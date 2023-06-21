/*
2154. Keep Multiplying Found Values by Two
Easy
You are given an array of integers nums. You are also given an integer original which is the first number that needs
to be searched for in nums.

You then do the following steps:

If original is found in nums, multiply it by two (i.e., set original = 2 * original).
Otherwise, stop the process.
Repeat this process with the new number as long as you keep finding the number.
Return the final value of original.

Example 1:

Input: nums = [5,3,6,1,12], original = 3
Output: 24
Explanation:
- 3 is found in nums. 3 is multiplied by 2 to obtain 6.
- 6 is found in nums. 6 is multiplied by 2 to obtain 12.
- 12 is found in nums. 12 is multiplied by 2 to obtain 24.
- 24 is not found in nums. Thus, 24 is returned.
Example 2:

Input: nums = [2,7,9], original = 4
Output: 4
Explanation:
- 4 is not found in nums. Thus, 4 is returned.
 */


import java.util.*;

public class FindFinalValue {
    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {5, 3, 6, 1, 12};
        int original1 = 3;
        int expected1 = 24;
        int result1 = findFinalValue(nums1, original1);
        System.out.println("Test Case 1 - nums1: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - original1: " + original1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test Case 2
        int[] nums2 = {2, 7, 9};
        int original2 = 4;
        int expected2 = 4;
        int result2 = findFinalValue(nums2, original2);
        System.out.println("Test Case 2 - nums2: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - original2: " + original2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));
    }

    /*
   Algorithm:
   1. Iterate through each element num in the nums array.
   2. Check if num is equal to original.
   3. If num is equal to original, multiply original by 2.
   4. Recursively call the findFinalValue function with the updated original value.
   5. If num is not equal to original, return the final value of original.

   Time Complexity: O(n), where n is the length of the nums array. In the worst case, we need to iterate through all
   elements in the array.
   Space Complexity: O(1). The space used by the algorithm is constant as we are not using any additional data
   structures that scale with the input size.
   */
    public static int findFinalValue(int[] nums, int original) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == original) {
                original *= 2;
                return findFinalValue(nums, original);
            }
        }

        return original;
    }
}