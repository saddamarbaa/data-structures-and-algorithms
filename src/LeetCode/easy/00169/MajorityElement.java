/**
 169. Majority Element

 Easy
 Given an array nums of size n, return the majority element.

 The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 Example 1:

 Input: nums = [3,2,3]
 Output: 3
 Example 2:

 Input: nums = [2,2,1,1,1,2,2]
 Output: 2


 Constraints:

 n == nums.length
 1 <= n <= 5 * 104
 -109 <= nums[i] <= 109


 Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {

        // Test case 1 - Majority element appears more than half
        int[] nums1 = {3, 2, 3};
        int expected1 = 3;
        int result1 = majorityElement(nums1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2 - Single element array
        int[] nums2 = {1};
        int expected2 = 1;
        int result2 = majorityElement(nums2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);

        // Test case 3 - Majority element appears multiple times
        int[] nums3 = {2, 2, 1, 1, 1, 2, 2};
        int expected3 = 2;
        int result3 = majorityElement(nums3);
        System.out.println("Test Case 3 - Expected: " + expected3);
        System.out.println("Test Case 3 - Actual: " + result3);

        // Test case 4 - Large input with repeated majority element
        int[] nums4 = {1, 1, 1, 2, 2, 1, 1};
        int expected4 = 1;
        int result4 = majorityElement(nums4);
        System.out.println("Test Case 4 - Expected: " + expected4);
        System.out.println("Test Case 4 - Actual: " + result4);
    }

    /**
     * Find the majority element in the array (element appears more than n/2 times).
     *
     * @param nums The input array of integers.
     * @return The majority element.
     */
    /**
     Algorithm Steps:
     1. Use Boyer-Moore Voting Algorithm:
        - We initialize two variables: one for the majority candidate and one for the count.
        - Traverse through the array:
          a. If the current count is zero, set the current element as the candidate.
          b. Increment the count if the current element is the candidate; otherwise, decrement it.
     2. By the end of the array, the candidate will be the majority element.
    
     Time Complexity: O(n)
     We traverse the array once, so the time complexity is linear.
    
     Space Complexity: O(1)
     We use only constant space for variables to store the candidate and count.
     *
     */

    public static int majorityElement(int[] num) {
        int majority = num[0], votes = 1;

        for (int i = 1; i < num.length; i++) {

            if (votes == 0) {
                votes++;
                majority = num[i];
            } else if (majority == num[i]) {
                votes++;
            } else
                votes--;

        }
        return majority;
    }


    /**
     * Find the majority element by sorting the array and returning the middle element.
     *
     * @param nums The input array of integers.
     * @return The majority element.
     */
    public static int majorityElement2(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        // Return the element at the middle index
        return nums[nums.length / 2];
    }
}
