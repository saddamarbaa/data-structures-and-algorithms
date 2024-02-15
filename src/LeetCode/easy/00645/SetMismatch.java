/**
 * 645. Set Mismatch
 * Easy
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some
 * error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one
 * number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */

import java.util.Arrays;

public class SetMismatch{

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 2, 4};
        int[] result1 = findErrorNums(nums1);
        printResult(nums1, result1, 1);

         // Test Case 2
        int[] nums2 = {1, 1};
        int[] result2 = findErrorNums(nums2);
        printResult(nums2, result2, 2);
    }

    /**
     * Function to print the result of a test case.
     * @param nums The input array.
     * @param result The result array.
     * @param testCaseNumber The test case number.
     */
    private static void printResult(int[] nums, int[] result, int testCaseNumber) {
        System.out.println("Test Case " + testCaseNumber + " - Input: " + Arrays.toString(nums));
        System.out.println("Test Case " + testCaseNumber + " - Expected result: " + Arrays.toString(result));
        System.out.println("Test Case " + testCaseNumber + " - Actual result: " + Arrays.toString(findErrorNums(nums)));
        System.out.println("Test Case " + testCaseNumber + " - Result matches expected: " + Arrays.equals(findErrorNums(nums), result));
        System.out.println();
    }

    /**
     * Function to find the number that occurs twice and the number that is missing using cycle sort.
     * @param nums The input array representing the data status.
     * @return An array containing the duplicate and missing numbers.
     */
    public static int[] findErrorNums(int[] nums) {

        cycleSort(nums);

        int n = nums.length;
        cycleSort(nums);

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return  new int[] {nums[i], i + 1};
            }
        }

        return  new int[] {-1,-1};
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
    public static void cycleSort(int[] array, boolean... ascending) {
        int size = array.length;
        int currentIndex = 0;

        while (currentIndex < size) {
            // Find the correct index for the current element in the sorted array
            int correctIndex = array[currentIndex] - 1;

            // Perform cyclic swapping until the current element is at its correct position
            if (currentIndex !=  correctIndex) {
                if(array[currentIndex] ==array[correctIndex]){currentIndex++;}else {
                    swap(array, currentIndex, correctIndex);
                }
            } else {
                currentIndex++;
            }
        }
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



