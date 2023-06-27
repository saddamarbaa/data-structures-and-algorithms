
/**
137. Single Number II
Medium
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find
the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99


Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
 */


import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8, 1, 8, 4};
        int expected1 = 2;
        int result1 = singleNumber(nums1);
        System.out.println("Test Case 1 - nums1: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        int[] nums2 = {3, 3, 7, 7, 10, 11, 11, 10, 7, 3};
        int expected2 = 11;
        int result2 = singleNumber(nums2);
        System.out.println("Test Case 2 - nums2: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        int[] nums3 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7};
        int expected3 = 6;
        int result3 = singleNumber(nums3);
        System.out.println("Test Case 3 - nums3: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));
    }


    /**
     * Algorithm Steps:
     * 1. Sort the input array in ascending order.
     * 2. Iterate through the array from the end, comparing three elements at a time.
     * 3. Check if the current number is not equal to either of the previous two numbers.
     * 4. If a number is found that is not equal to the previous two, return it as the single element.
     * 5. If no single element is found, return the first element of the sorted array.
     * <p>
     * Time Complexity: The time complexity of this solution is dominated by the sorting step, which takes O(n log n)
     * time, where n is the size of the input array. The loop that iterates through the array takes O(n/3) time,
     * which can be simplified to O(n). Therefore, the overall time complexity is O(n log n).
     * <p>
     * Space Complexity: The space complexity of this solution is O(1) since it uses a constant amount of extra space
     * for variables. The sorting operation does not require additional space as it operates in-place.
     */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i > 0; i -= 3) {
            int current = nums[i];
            int previous = nums[i - 1];
            if (current != previous) {
                return current;
            }
        }
        return nums[0];
    }
}