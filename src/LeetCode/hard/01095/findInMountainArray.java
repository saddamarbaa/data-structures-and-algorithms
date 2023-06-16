/*
1095. Find in Mountain Array
Hard
(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an
index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that
attempt to circumvent the judge will result in disqualification.

Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.

Constraints:

3 <= mountain_arr.length() <= 104
0 <= target <= 109
0 <= mountain_arr.get(index) <= 109
 */


import java.util.*;

public class FindInMountainArray {
    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        int expected1 = 2;
        int result1 = findInMountainArray(target, arr1);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(arr1));
        System.out.println("Test Case 3 - Expected result: " + expected1);
        System.out.println("Test Case 3 - Actual result: " + result1);
        System.out.println("Test Case 3 - Result matches expected: " + (result1 == expected1));


        // Test Case 2
        int[] arr2 = {0, 1, 2, 4, 2, 1};
        int target2 = 3;
        int expected2 = -1;
        int result2 = binarySearch(arr2, target2, 0, arr2.length - 1);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(arr2));
        System.out.println("Test Case 2 - Target: " + target2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test Case 3
        int[] arr3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target3 = 6;
        int expected3 = 6;
        int result3 = binarySearch(arr3, target3, 0, arr3.length - 1);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(arr3));
        System.out.println("Test Case 3 - Target: " + target3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));


        // Test Case 4
        int[] arr4 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target4 = 25;
        int expected4 = -1;
        int result4 = binarySearch(arr4, target4, 0, arr4.length - 1);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(arr4));
        System.out.println("Test Case 4 - Target: " + target4);
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));
    }


    /**
     * Algorithm Steps:
     * Find peek element index
     * search in the first have array  (0 - peek index)
     * if not found search in the other have of the array   (peek index - to end)
     * 3. Return left (peak not found).
     * <p>
     * Space Complexity: O(1) - The algorithm uses a constant amount of extra space.
     * Time Complexity: O(log n) - The algorithm performs binary search on the array, reducing the search space by
     * half in
     * each iteration. Hence, it has a logarithmic time complexity.
     */
    public static int findInMountainArray(int target, int[] mountainArr) {

        int peekIndex = peakIndexInMountainArray(mountainArr);

        int firstTry = binarySearch(mountainArr, target, 0, peekIndex);

        if (firstTry != -1) {
            return firstTry;
        }

        // Try to search in the second half
        int sendondTry = binarySearch(mountainArr, target, peekIndex, mountainArr.length - 1);
        return sendondTry;
    }


    public static int binarySearch(int[] nums, int target, int startIndex, int endIndex) {
        return orderAgnosticBinarySearch(nums, target, startIndex, endIndex, 0);
    }

    /**
     * Algorithm Steps:
     * 1. Initialize left = 0 and right = length - 1, where length is the length of the input array.
     * 2. Iterate while left <= right:
     * a. Calculate mid as the average of left and right: mid = left + (right - left) / 2.
     * b. Retrieve the elements at mid, mid-1, and mid+1 positions: midNumber = arr[mid],
     * previousNumber = arr[mid - 1], nextNumber = arr[mid + 1].
     * c. If midNumber is greater than both previousNumber and nextNumber, return mid (peak found).
     * d. If midNumber is less than previousNumber, update right = mid, as the peak might be on the left side.
     * e. Otherwise, update left = mid + 1, as the peak might be on the right side.
     * 3. Return left (peak not found).
     * <p>
     * Space Complexity: O(1) - The algorithm uses a constant amount of extra space.
     * Time Complexity: O(log n) - The algorithm performs binary search on the array, reducing the search space by
     * half in
     * each iteration. Hence, it has a logarithmic time complexity.
     */
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                /*
                 * If arr[mid] is greater than arr[mid+1],
                 * we are in the descending part of the array.
                 * This means that the peak, if it exists, is in the range from start to mid.
                 * Therefore, we update the end index to mid.
                 */
                end = mid;
            } else {
                /*
                 * If arr[mid] is less than or equal to arr[mid+1],
                 * we are in the ascending part of the array.
                 * Since we know that arr[mid+1] is greater than arr[mid],
                 * the peak index, if it exists, must be in the range from mid+1 to end.
                 * Therefore, we update the start index to mid+1.
                 */
                start = mid + 1;
            }
        }

        /*
         * At this point, start (or end) will be pointing to the peak index in the mountain array.
         * This is because the algorithm always keeps the range that contains the peak index based on the comparisons
         *  made above.
         * Since start and end converge to the same index, it represents the peak index.
         * Thus, we can return start (or end) as the peak index.
         */
        return start; // or return end, as both are equal
    }


    /**
     * Implement the Order Agnostic Binary Search algorithm to search for a given key in a sorted array of integers.
     * The function returns the index of the key if it is present in the array, otherwise -1.
     *
     * @param nums       A sorted array of integers.
     * @param target     An integer value to search for in the array.
     * @param occurrence An integer value indicating the occurrence of the target to find.
     *                   -1 for the first occurrence, 0 for any occurrence, and 1 for the last occurrence.
     * @return The index of the target if found, otherwise -1.
     * <p>
     * Algorithm Steps:
     * 1. Initialize the result variable to -1.
     * 2. Initialize the startIndex and endIndex variables to the first and last indices of the array, respectively.
     * 3. Determine the order (ascending or descending) of the array by comparing the first and last elements.
     * 4. While the startIndex is less than or equal to the endIndex:
     * - Calculate the midIndex as the average of the startIndex and endIndex.
     * (To avoid integer overflow, use the expression midIndex = startIndex + (endIndex - startIndex) / 2
     * instead of midIndex = (startIndex + endIndex) / 2).
     * - If the value at the midIndex is equal to the target:
     * - Set the result to the midIndex.
     * - If occurrence is less than or equal to 0, set the endIndex to midIndex - 1 to find the first occurrence
     * of the target. If occurrence is greater than or equal to 1, set the startIndex to midIndex + 1 to find the
     * last occurrence of the target.
     * - If occurrence is equal to 0 and result is not -1, return the result immediately.
     * - If the value at the midIndex is less than the target:
     * - Set the startIndex to midIndex + 1.
     * - If the value at the midIndex is greater than the target:
     * - Set the endIndex to midIndex - 1.
     * 5. Return the result.
     * <p>
     * Time Complexity: O(log n) - where n is the length of the input array.
     * Space Complexity: O(1) - the algorithm uses a constant amount of additional space.
     */
    public static int orderAgnosticBinarySearch(int[] nums, int target, int startIndex, int endIndex, int occurrence) {
        int result = -1;


        // Determine the order of the array (ascending or descending)
        boolean isAscending = nums[startIndex] <= nums[endIndex];

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if (nums[midIndex] == target) {
                result = midIndex;

                if (occurrence <= 0) {
                    // Find the first occurrence of the target
                    endIndex = midIndex - 1;
                } else {
                    // Find the last occurrence of the target
                    startIndex = midIndex + 1;
                }

                if (occurrence == 0 && result != -1) {
                    // If not looking for first or last occurrence, return immediately when target found
                    return result;
                }
            } else if ((isAscending && nums[midIndex] < target) || (!isAscending && nums[midIndex] > target)) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        return result;
    }
}