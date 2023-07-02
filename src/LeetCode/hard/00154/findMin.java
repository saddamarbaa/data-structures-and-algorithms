/*
154. Find Minimum in Rotated Sorted Array II
Hard

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums
= [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2],
..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.

Example 1:

Input: nums = [1,3,5]
Output: 1
Example 2:

Input: nums = [2,2,2,0,1]
Output: 0


Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
nums is sorted and rotated between 1 and n times.


Follow up: This problem is similar to Find Minimum in Rotated Sorted Array, but nums may contain duplicates. Would
this affect the runtime complexity? How and why?
 */


import java.util.Arrays;

public class FindMin {
    public static void main(String[] args) {
        // Test case 1 - Array rotated multiple times
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int expected1 = 0;
        int result1 = findMin(nums1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2 - Array rotated to original order
        int[] nums2 = {0, 1, 2, 4, 5, 6, 7};
        int expected2 = 0;
        int result2 = findMin(nums2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3 - Array with a single element
        int[] nums3 = {1};
        int expected3 = 1;
        int result3 = findMin(nums3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case 4 - Array with repeated elements
        int[] nums4 = {10, 1, 10, 10, 10};
        int expected4 = 0;
        int result4 = findMin(nums4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(nums4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));

    }


    /**
     * Algorithm Steps:
     * 1. Initialize the low and high pointers to the start and end of the array, respectively.
     * 2. Initialize the minimum variable to the maximum possible integer value.
     * 3. Enter a while loop that continues until the low pointer is less than or equal to the high pointer.
     * 4. Calculate the mid index as the average of low and high.
     * 5. Check if the search space is already sorted by comparing the elements at low and high indices:
     * - If arr[low] is less than or equal to arr[high], it means the search space is sorted, and arr[low] is the
     * minimum.
     * Set min to the minimum value and break out of the loop.
     * 6. Check if the left part is sorted by comparing arr[low] with arr[mid]:
     * - If arr[low] is less than or equal to arr[mid], it means the left part is sorted.
     * - Update the minimum if necessary by comparing min with arr[low].
     * - Eliminate the left half by updating the low pointer to mid + 1.
     * 7. If the left part is not sorted, it means the right part is sorted.
     * - Update the minimum if necessary by comparing min with arr[mid].
     * - Eliminate the right half by updating the high pointer to mid - 1.
     * 8. Return the minimum value found.
     * <p>
     * Time Complexity: O(log n) - The algorithm performs binary search, reducing the search space in half at each
     * iteration.
     * Space Complexity: O(1) - The algorithm uses a constant amount of extra space to store variables.
     */

    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[mid]) {

                // edg case
                if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                    // Left part is sorted
                    // Update the minimum if necessary
                    min = Math.min(min, arr[low]);

                    low = low + 1;
                    high = high - 1;
                    continue;
                }

                // Left part is sorted
                // Update the minimum if necessary
                min = Math.min(min, arr[low]);

                // Eliminate the left half
                low = mid + 1;
            } else {
                // Right part is sorted
                // Update the minimum if necessary
                min = Math.min(min, arr[mid]);

                // Eliminate the right half
                high = mid - 1;
            }
        }

        return min;
    }
}