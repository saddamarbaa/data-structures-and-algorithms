
/* 442. Find All Duplicates in an Array
Medium
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer
appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {
    public static void main(String[] args) {
        // Test Case 1 - No duplicates
        int[] nums1 = {1, 2, 3, 4, 5};
        List<Integer> expected1 = new ArrayList<>();
        List<Integer> result1 = findDuplicates(nums1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1); // No duplicates in the array
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + result1.equals(expected1));

        // Test Case 2 - Single duplicate
        int[] nums2 = {1, 2, 2, 3, 4, 5};
        List<Integer> expected2 = Arrays.asList(2);
        List<Integer> result2 = findDuplicates(nums2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2); // The duplicate element is 2
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + result2.equals(expected2));

        // Test Case 3 - Multiple duplicates
        int[] nums3 = {1, 2, 2, 3, 4, 4, 5};
        List<Integer> expected3 = Arrays.asList(2, 4);
        List<Integer> result3 = findDuplicates(nums3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);   // The duplicate elements are 2 and 4
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + result3.equals(expected3));

    }

    /*
     * This method finds and returns a list of duplicate numbers in the given array.
     *
     * Algorithm:
     * 1. Create an empty list to store the duplicate numbers.
     * 2. Calculate the length of the input array.
     * 3. Initialize a variable to mark visited elements.
     * 4. Iterate through the array:
     *    a. Get the absolute value of the current element.
     *    b. Check if the current element at its corresponding index is negative:
     *       - If true, add the absolute value of the current element to the list.
     *       - If false, mark the element as visited by multiplying it with 'visited'.
     * 5. Return the list of duplicate numbers.
     *
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), excluding the space required to store the output list.
     */

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int currentNumber = Math.abs(nums[i]);
            int correspondingIndex = currentNumber - 1;

            if (nums[correspondingIndex] < 0) {
                duplicates.add(currentNumber);
            } else {
                nums[correspondingIndex] = -nums[correspondingIndex];
            }
        }

        return duplicates;
    }
}