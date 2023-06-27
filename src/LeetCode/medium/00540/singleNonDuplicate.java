/*
540. Single Element in a Sorted Array
Medium

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
 */


import java.util.*;

public class SingleNonDuplicate {
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int expected1 = 2;
        int result1 = singleNonDuplicate(nums1);
        System.out.println("Test Case 1 - nums1: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test Case 2
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        int expected2 = 10;
        int result2 = singleNonDuplicate(nums2);
        System.out.println("Test Case 2 - nums2: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test Case 3
        int[] nums3 = {1, 1, 2};
        int expected3 = 2;
        int result3 = singleNonDuplicate(nums3);
        System.out.println("Test Case 3 - nums3: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test Case 4
        int[] nums4 = {1, 2, 2};
        int expected4 = 1;
        int result4 = singleNonDuplicate(nums4);
        System.out.println("Test Case 4 - nums4: " + Arrays.toString(nums4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));
    }


    /**
     * Algorithm:
     * 1. Check if the array has only one element. If yes, return that element.
     * 2. Check if the single element is at the beginning. If yes, return the first element.
     * 3. Check if the single element is at the end. If yes, return the last element.
     * 4. Perform binary search to find the single element.
     * 5. Initialize left as 1 and right as n - 2.
     * 6. While left is less than or equal to right:
     * a. Calculate the middle index as mid = left + (right - left) / 2.
     * b. If the middle element is the single element, return it.
     * c. If the middle element is at an even index:
     * - If the middle element is equal to its previous element, the single element is on the right side. Update
     * left = mid + 1.
     * - Otherwise, the single element is on the left side. Update right = mid - 1.
     * d. If the middle element is at an odd index:
     * - If the middle element is equal to its next element, the single element is on the right side. Update left =
     * mid + 2.
     * - Otherwise, the single element is on the left side. Update right = mid.
     * 7. If no single element is found, return -1.
     * <p>
     * Time complexity: O(log n), where n is the number of elements in the array.
     * Space complexity: O(1).
     */
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        int left = 1;
        int right = n - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            } else if (mid % 2 == 0 && nums[mid] == nums[mid - 1] || mid % 2 == 1 && nums[mid] == nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    /**
     * Algorithm:
     * 1. Get the length of the array and store it in the variable 'n'.
     * 2. Iterate through the array from the end to the beginning in steps of 2, starting from index 'n-1'.
     * 3. Inside the loop:
     * a. Get the current element at index 'i' and store it in the variable 'current'.
     * b. Get the previous element at index 'i-1' and store it in the variable 'previous'.
     * c. If the 'current' element is not equal to the 'previous' element, return the 'current' element as it is the
     * single element.
     * 4. If no single element is found, return the first element in the sorted array, which is nums[0].
     * <p>
     * Time complexity: O(n log n), where 'n' is the number of elements in the array. This is due to the sorting
     * operation performed using Arrays.sort().
     * Space complexity: O(1). The algorithm uses a constant amount of extra space.
     * <p>
     * Note: Sorting the entire array using Arrays.sort() is not necessary to find the single element. The requirement
     * of the problem states that the array is already sorted, so sorting it again adds an unnecessary overhead. A more
     * efficient approach can be implemented by leveraging the fact that the single element occurs exactly once in
     * the array.
     */

    public int singleNonDuplicate2(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i -= 2) { // iterate through the array from the end to the beginning in steps of 2
            int current = nums[i];
            int previous = nums[i - 1];
            if (current != previous) { // if the current element and the previous element are not equal, return the
                // current element
                return current;
            }
        }
        return nums[0];
    }
}