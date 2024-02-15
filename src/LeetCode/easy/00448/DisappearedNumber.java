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

public class DisappearedNumber {


    public static void main(String[] args) {

        int[] input1 = {4, 3, 2, 7, 8, 2, 3, 1};
        Integer[] expected1 = {5, 6}; // Using Integer array for expected values
        List<Integer> expectedList1 = Arrays.asList(expected1);

        List<Integer> result1 = findDisappearedNumbers(input1);
        printResult(input1, expectedList1, result1, 1);


        // Test Case 2
        int[] input2 = {1, 2, 3, 4, 5};
        Integer[] expected2 = {}; // Using Integer array for expected values
        List<Integer> expectedList2 = Arrays.asList(expected2);
        List<Integer> result2 = findDisappearedNumbers(input2);
        printResult(input2, expectedList2, result2, 2);

        // Test Case 3
        int[] input3 = {1, 1, 2, 2, 3, 3, 4, 4};
        Integer[] expected3 = {5, 6}; // Using Integer array for expected values
        List<Integer> expectedList3 = Arrays.asList(expected3);
        List<Integer> result3 = findDisappearedNumbers(input3);
        printResult(input3, expectedList3, result3, 3);
    }


    /**
     * Algorithm:
     * 1. Perform cycle sort on the input array.
     * 2. Traverse the sorted array and find the indices of the positive elements that do not match their positions.
     * 3. Add the corresponding missing numbers to the result list.
     * 4. Return the list of disappeared numbers.
     *
     * Time Complexity: O(n)
     * - The cycle sort step takes O(n) time.
     * - The traversal to find missing numbers takes O(n) time.
     * - Overall, the time complexity is O(n).
     *
     * Space Complexity: O(1)
     * - The algorithm uses a constant amount of space for variables and the result list.
     * - The space complexity is O(1).
     *
     * @param nums The input array of integers.
     * @return A list containing the disappeared numbers.
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();
        int length = nums.length;

        // Step 1: Perform cycle sort
        cycleSort(nums);

        // Step 2 and 3: Find missing numbers
        for (int index = 0; index < length; index++) {
            if (nums[index] != index + 1) {
                disappearedNumbers.add(index + 1);
            }
        }

        // Step 4: Return the list of disappeared numbers
        return disappearedNumbers;
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

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
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

    public static List<Integer> findDisappearedNumbers3(int[] nums) {
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


    /**
     * Cycle Sort Algorithm
     * Algorithm Steps:
     * 1. Traverse the array from the start.
     * 2. For each element, find its correct position (index) in the sorted array.
     * 3. Swap the current element with the element at its correct position.
     * 4. Continue this process until the entire array is sorted.
     *
     * Time Complexity:
     * - Worst Case Time Complexity: O(n).
     * - Best Case Time Complexity: O(n).
     * - Average Case Time Complexity: O(n).
     *
     * Space Complexity:
     * - Space Complexity: O(1) - constant space is used for variables.
     *
     * @param array The array to be sorted.
     */
    public static void cycleSort(int[] array) {
        int size = array.length;
        int currentIndex = 0;

        while (currentIndex < size) {
            // Find the correct index for the current element in the sorted array
            int correctIndex = array[currentIndex] - 1;

            // Perform cyclic swapping until the current element is at its correct position
            if (currentIndex !=  correctIndex &&array[currentIndex] != array[correctIndex]) {
                swap(array, currentIndex, correctIndex);
            } else {
                currentIndex++;
            }
        }
    }




    public static void printResult(int[] input, List<Integer> expected, List<Integer> result, int testCaseNumber) {
        System.out.println("Test Case " + testCaseNumber + " - Input: " + Arrays.toString(input));
        System.out.println("Test Case " + testCaseNumber + " - Expected result: " + expected);
        System.out.println("Test Case " + testCaseNumber + " - Actual result: " + result);
        System.out.println("Test Case " + testCaseNumber + " - Result matches expected: " + result.equals(expected));
        System.out.println();
    }

    /**
     * Function to swap values of two variables (user should pass the array and
     * indices as parameters)
     */
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

