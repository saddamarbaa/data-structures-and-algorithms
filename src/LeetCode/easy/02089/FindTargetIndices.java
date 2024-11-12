/***
 2089. Find Target Indices After Sorting Array

 Easy

 You are given a 0-indexed integer array nums and a target element target.

 A target index is an index i such that nums[i] == target.

 Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.



 Example 1:

 Input: nums = [1,2,5,2,3], target = 2
 Output: [1,2]
 Explanation: After sorting, nums is [1,2,2,3,5].
 The indices where nums[i] == 2 are 1 and 2.
 Example 2:

 Input: nums = [1,2,5,2,3], target = 3
 Output: [3]
 Explanation: After sorting, nums is [1,2,2,3,5].
 The index where nums[i] == 3 is 3.
 Example 3:

 Input: nums = [1,2,5,2,3], target = 5
 Output: [4]
 Explanation: After sorting, nums is [1,2,2,3,5].
 The index where nums[i] == 5 is 4.


 Constraints:

 1 <= nums.length <= 100
 1 <= nums[i], target <= 100
 */

import java.util.*;

public class FindTargetIndices {
    public static void main(String[] args) {

        // Test case 1
        int[] nums1 = {1, 2, 5, 2, 3};
        int target1 = 2;
        List<Integer> expected1 = Arrays.asList(1, 2);
        List<Integer> result1 = targetIndices(nums1, target1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        int target2 = 5;
        List<Integer> expected2 = new ArrayList<>();
        List<Integer> result2 = targetIndices(nums2, target2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);
    }

    /**
     * Finds the indices of the target element in a sorted array.
     *
     * @param nums   The array of integers.
     * @param target The target integer to find.
     * @return The indices of the target in the sorted array.
     */
    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        // Find indices where target exists, and break early if the current element is greater than the target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i); // Add the index of target
            } else if (nums[i] > target) {
                break; // No need to check further elements as the array is sorted
            }
        }

        return result;
    }
}
