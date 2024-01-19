/*
34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */


import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {

        // Test case 1 - target present in the middle of the array
        int[] input1 = {1, 2, 3, 4, 5};
        int target1 = 3;
        int[] expected1 = {2, 2};
        int[] result1 = searchRange(input1, target1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1) + ", Target: " + target1);
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.toString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.equals(expected1, result1));

        // Test case 2 - target present at the beginning of the array
        int[] input2 = {1, 2, 2, 2, 3, 4, 5};
        int target2 = 1;
        int[] expected2 = {0, 0};
        int[] result2 = searchRange(input2, target2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2) + ", Target: " + target2);
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.toString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.equals(expected2, result2));

        // Test case 3 - target present at the end of the array
        int[] input3 = {1, 2, 2, 2, 3, 4, 5};
        int target3 = 5;
        int[] expected3 = {6, 6};
        int[] result3 = searchRange(input3, target3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(input3) + ", Target: " + target3);
        System.out.println("Test Case 3 - Expected result: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Actual result: " + Arrays.toString(result3));
        System.out.println("Test Case 3 - Result matches expected: " + Arrays.equals(expected3, result3));

        // Test case 4 - target not present in the array
        int[] input4 = {1, 2, 2, 2, 3, 4, 5};
        int target4 = 6;
        int[] expected4 = {-1, -1};
        int[] result4 = searchRange(input4, target4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(input4) + ", Target: " + target4);
        System.out.println("Test Case 4 - Expected result: " + Arrays.toString(expected4));
        System.out.println("Test Case 4 - Actual result: " + Arrays.toString(result4));
        System.out.println("Test Case 4 - Result matches expected: " + Arrays.equals(expected4, result4));


        // Test case 5 - array with length 10, no occurrence of target
        int[] input5 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target5 = 2;
        int[] expected5 = {-1, -1};
        int[] result5 = searchRange(input5, target5);
        System.out.println("Test Case 5 - Input: " + Arrays.toString(input5) + ", target: " + target5);
        System.out.println("Test Case 5 - Expected result: " + Arrays.toString(expected5));
        System.out.println("Test Case 5 - Actual result: " + Arrays.toString(result5));
        System.out.println("Test Case 5 - Result matches expected: " + Arrays.equals(expected5, result5));

        // Test case 5 - array with length 15, multiple occurrences of target
        int[] input6 = {2, 3, 5, 7, 7, 7, 8, 10, 12, 12, 12, 15, 17, 18, 20};
        int target6 = 12;
        int[] expected6 = {8, 10};
        int[] result6 = searchRange(input6, target6);
        System.out.println("Test Case 6 - Input: " + Arrays.toString(input6) + ", target: " + target6);
        System.out.println("Test Case 6 - Expected result: " + Arrays.toString(expected6));
        System.out.println("Test Case 6 - Actual result: " + Arrays.toString(result6));
        System.out.println("Test Case 6 - Result matches expected: " + Arrays.equals(expected6, result6));
    }


    public static int[] searchRange(int[] nums, int target) {

        int firstOccurrenceIndex = binarySearch(nums, target, -1);
        int lastOccurrenceIndex = binarySearch(nums, target, 1);
        return new int[]{firstOccurrenceIndex, lastOccurrenceIndex};
    }

    public static int binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0);
    }

    /**
     * Write a function that implements the binary search algorithm to search for a given key in a sorted array of
     * integers. The function should return the index of the key if it is present in the array, otherwise it should
     * return -1.
     * The function should take three arguments:
     * nums: A sorted array of integers.
     * target: An integer value to search for in the array.
     * occurrence: An integer value indicating which occurrence of the target to find. A value of -1 indicates the first
     * occurrence, a value of 0 indicates any occurrence, and a value of 1 indicates the last occurrence.
     * <p>
     * Algorithm Steps:
     * 1. Initialize the result variable to -1.
     * 2. Initialize the startIndex and endIndex variables to the first and last indices of the array, respectively.
     * 3. While the startIndex is less than or equal to the endIndex:
     * a. Calculate the midIndex as the average of the startIndex and endIndex (to avoid integer overflow, use the
     * expression midIndex = startIndex + (endIndex - startIndex) / 2 instead of midIndex = (startIndex + endIndex) /
     * 2).
     * b. If the value at the midIndex is equal to the target:
     * i. Set the result to the midIndex.
     * ii. If occurrence is less than or equal to 0, set the endIndex to midIndex - 1 to find the first occurrence
     * of the target. If occurrence is greater than or equal to 1, set the startIndex to midIndex + 1 to find the
     * last occurrence of the target.
     * iii. If occurrence is equal to 0 and result is not -1, return the result immediately.
     * c. If the value at the midIndex is less than the target, set the startIndex to midIndex + 1.
     * d. If the value at the midIndex is greater than the target, set the endIndex to midIndex - 1.
     * 4. Return the result.
     * <p>
     * Time Complexity:
     * The algorithm visits each element in the search space (i.e., the portion of the array between the startIndex and
     * endIndex indices) at most three times.
     * Therefore, the time complexity is O(log n), where n is the length of the input array.
     * <p>
     * Space Complexity:
     * The algorithm uses a constant amount of additional space.
     * Therefore, the space complexity is O(1).
     */
    public static int binarySearch(int[] nums, int target, int occurrence) {
        int result = -1;
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (nums[midIndex] == target) {
                result = midIndex;
                // Find the first occurrence of the target
                if (occurrence <= 0) {
                    endIndex = midIndex - 1;
                } else {
                    // Find the last occurrence of the target
                    startIndex = midIndex + 1;
                }
                // If not looking for first or last occurrence, return immediately when target found
                if (occurrence == 0 && result != -1) {
                    return result;
                }
            } else if (nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return result;
    }


    /**
     * Write a function that implements the binary search algorithm to search for a given key in a sorted array of
     * integers. The function should return the index of the key if it is present in the array, otherwise it should
     * return -1.
     * The function should take two arguments:
     * nums: A sorted array of integers.
     * key: An integer value to search for in the array.
     * Algorithm Steps:
     * Initialize the low and high variables to the first and last indices of the array respectively.
     * While the low index is less than or equal to the high index:
     * Calculate the mid index as the average of the low and high indices (to avoid integer overflow, use the
     * expression mid = low + (high - low) / 2 instead of mid = (low + high) / 2).
     * If the value at the mid index is equal to the key, return the mid index.
     * If the value at the mid index is greater than the key, update the high index to be the index immediately to
     * the left of the mid index.
     * If the value at the mid index is less than the key, update the low index to be the index immediately to the
     * right of the mid index.
     * If the key is not found in the array, return -1.
     * Time Complexity:
     * The algorithm visits each element in the search space (i.e., the portion of the array between the low and high
     * indices) at most three times.
     * Therefore, the time complexity is O(log n), where n is the length of the input array.
     * Space Complexity:
     * The algorithm uses a constant amount of additional space.
     * Therefore, the space complexity is O(1).
     */
    public static int binarySearchPure(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            // mid = (low + high)/2; //(low + high) may lead to overflow condition

            // to avoid integer overflow is better to use on of this conditions flowing blow
            int mid = low + (high - low) / 2;
            //mid = high - (high - low)/2;


             /*
           Check if the key is present at mid if so then key is found
           just return the index in which the key is been found and
           we are done */
            // base case also
            if (key == nums[mid]) {
                return mid;
            }
            /*
            if reach this line mean is not found  at mid let
          check if the key smaller or bigger than mind
           */
            // if key is smaller than mid then discard all elements
            // in the right search space including the mid element
            else if (key < nums[mid]) {
                // search in left
                high = mid - 1;
            }// if key is bigger than mid then discard all elements
            //  in the left search space including the mid element
            else {
                //search in right
                low = mid + 1;
            }
        }
        return -1;
    }
}

