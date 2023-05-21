/*
448. Find All Numbers Disappeared in an Array
Easy
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the
range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n


Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count
as extra space.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DisappearedNumbers {
    public static void main(String[] args) {
        // Test Case 1 - No duplicates
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> expected1 = Arrays.asList(5, 6);
        List<Integer> result1 = findDisappearedNumbers(nums1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + result1.equals(expected1));

        // Test Case 2 - Empty array
        int[] nums2 = {};
        List<Integer> expected2 = new ArrayList<>();
        List<Integer> result2 = findDisappearedNumbers(nums2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + result2.equals(expected2));

        // Test Case 3 - All duplicates
        int[] nums3 = {3, 3, 3, 3};
        List<Integer> expected3 = Arrays.asList(1, 2, 4);
        List<Integer> result3 = findDisappearedNumbers(nums3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + result3.equals(expected3));

        // Test Case 4 - Single element
        int[] nums4 = {1};
        List<Integer> expected4 = new ArrayList<>();
        List<Integer> result4 = findDisappearedNumbers(nums4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(nums4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + result4.equals(expected4));

        // Test Case 5 - Random elements with duplicates
        int[] nums5 = {2, 2, 4, 4, 5, 5, 6, 8};
        List<Integer> expected5 = Arrays.asList(1, 3, 7);
        List<Integer> result5 = findDisappearedNumbers(nums5);
        System.out.println("Test Case 5 - Input: " + Arrays.toString(nums5));
        System.out.println("Test Case 5 - Expected result: " + expected5);
        System.out.println("Test Case 5 - Actual result: " + result5);
        System.out.println("Test Case 5 - Result matches expected: " + result5.equals(expected5));
    }


    /*
     * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in
     * the range [1, n] that do not appear in nums.
     *
     * Algorithm:
     * 1. Iterate through the array:
     *    a. Get the absolute value of the current element.
     *    b. Mark the element as visited by making the element at its corresponding index negative.
     * 2. Find the indices of the positive elements in the array. These indices correspond to the missing numbers.
     * 3. Return the missing numbers.
     *
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(1), excluding the space required to store the output list.
     */
    
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();
        int length = nums.length;

        // Mark the elements as visited by making the element at its corresponding index negative
        for (int i = 0; i < length; i++) {
            int currentNumber = Math.abs(nums[i]);
            int correspondingIndex = currentNumber - 1;
            if (nums[correspondingIndex] > 0) {
                nums[correspondingIndex] *= -1;
            }
        }

        // Find the indices of the positive elements in the array (missing numbers)
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                disappearedNumbers.add(i + 1);
            }
        }

        return disappearedNumbers;
    }

    /*
     * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in
     * the range [1, n] that do not appear in nums.
     *
     * Algorithm:
     * 1. Create an empty list to store the disappeared numbers.
     * 2. Calculate the length of the input array.
     * 3. Initialize a HashMap to mark visited elements, with numbers from 1 to length as keys and false as initial
     * values.
     * 4. Iterate through the input array:
     *    a. Get the absolute value of the current element.
     *    b. Check if the current element at its corresponding index is negative:
     *       - If true, add the absolute value of the current element to the list of disappeared numbers.
     *       - If false, mark the element as visited by setting its corresponding value in the HashMap to true.
     * 5. Find the numbers that are not marked as true in the HashMap (disappeared numbers) and add them to the list.
     * 6. Return the list of disappeared numbers.
     *
     * Time Complexity: O(n), where n is the length of the input array.
     * Space Complexity: O(n), where n is the length of the input array, due to the HashMap.
     */

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();
        HashMap<Integer, Boolean> numberMap = new HashMap<>();
        int length = nums.length;

        // Initialize the HashMap with all numbers from 1 to length as keys
        for (int i = 1; i <= length; i++) {
            numberMap.put(i, false);
        }

        // Mark the numbers present in the array as true in the HashMap
        for (int i = 0; i < length; i++) {
            int currentNumber = Math.abs(nums[i]);
            numberMap.put(currentNumber, true);
        }

        // Find the numbers that are not marked as true (disappeared numbers)
        for (int i = 1; i <= length; i++) {
            if (!numberMap.get(i)) {
                disappearedNumbers.add(i);
            }
        }

        return disappearedNumbers;
    }
}