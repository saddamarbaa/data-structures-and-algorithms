/*
747. Largest Number At Least Twice of Others
Easy

You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If
it is, return the index of the largest element, or return -1 otherwise.

Example 1:

Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.
Example 2:

Input: nums = [1,2,3,4]
Output: -1
Explanation: 4 is less than twice the value of 3, so we return -1.


Constraints:

2 <= nums.length <= 50
0 <= nums[i] <= 100
The largest element in nums is unique.
 */


import java.util.*;

public class DominantIndex {
    public static void main(String[] args) {
        int[] nums1 = {5, 3, 6, 1, 12};
        int expected1 = 4;
        int result1 = dominantIndex(nums1);
        System.out.println("Test Case 1 - nums1: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));


        int[] nums2 = {1, 2, 3, 4};
        int expected2 = -1;
        int result2 = dominantIndex(nums2);
        System.out.println("Test Case 2 - nums2: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));


        int[] nums3 = {0, 0, 0, 1};
        int expected3 = 3;
        int result3 = dominantIndex(nums3);
        System.out.println("Test Case 3 - nums3: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        int[] nums4 = {5, 5, 5, 5};
        int expected4 = 0;
        int result4 = dominantIndex(nums4);
        System.out.println("Test Case 4 - nums4: " + Arrays.toString(nums4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
    }


    /**
     * Algorithm Steps:
     * 1. Initialize variables:
     * - Set largest to -1 to store the largest element in the array.
     * - Set secondLargest to -1 to store the second-largest element in the array.
     * - Set largestIndex to -1 to store the index of the largest element.
     * <p>
     * 2. Iterate through the array:
     * - For each element nums[i] in the array:
     * - If nums[i] is greater than the current largest element:
     * - Update secondLargest to the current value of largest.
     * - Update largest to nums[i].
     * - Update largestIndex to i.
     * - Else if nums[i] is greater than the current secondLargest element:
     * - Update secondLargest to nums[i].
     * <p>
     * 3. Check the dominance condition:
     * - If largest is at least twice as large as secondLargest:
     * - Return largestIndex.
     * - Else:
     * - Return -1 to indicate that there is no dominant index.
     * <p>
     * Space Complexity: O(1)
     * - The algorithm uses a constant amount of extra space to store the largest, secondLargest, and largestIndex
     * variables. Thus, the space complexity is O(1).
     * <p>
     * Time Complexity: O(n)
     * - The algorithm iterates through the array once to find the largest and second-largest elements. This requires n
     * comparisons.
     * - Therefore, the time complexity of the algorithm is O(n), where n is the size of the input array.
     */
    public static int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return -1; // Handle the case when the array is empty
        }

        int largest = -1;
        int secondLargest = -1;
        int largestIndex = -1;

        // Find the largest and second-largest elements
        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
                largestIndex = i;
            } else if (nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }

        // Check the dominance condition
        if (largest >= 2 * secondLargest) {
            return largestIndex;
        } else {
            return -1;
        }
    }


    /**
     * Algorithm:
     * 1. Initialize the variable 'largest' to store the largest element in the array, and 'largestIndex' to -1.
     * 2. Iterate through the array to find the largest element and its index:
     * - Update 'largest' and 'largestIndex' if the current element is larger than 'largest'.
     * 3. Set 'largestIndex' to 0 if it is still -1 (no larger element found) to handle edge cases.
     * 4. Iterate through the array again to check if any pair of elements has a sum greater than the largest element:
     * - If such a pair is found, return -1 as the condition is not satisfied.
     * 5. Return 'largestIndex' as the index of the largest element in the array.
     * Time Complexity: O(n) - We iterate through the array twice, where n is the length of the array.
     * Space Complexity: O(1) - We use a constant amount of extra space for storing variables.
     */
    public static int dominantIndex2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }

        int largest = nums[0];
        int largestIndex = -1;

        // Find the largest element and its index
        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
                largestIndex = i;
            }
        }

        largestIndex = largestIndex == -1 ? 0 : largestIndex;

        // Check if any pair of elements has a sum greater than the largest element
        for (int i = 0; i < n; i++) {
            if (largest != nums[i] && nums[i] + nums[i] > largest) {
                // Debugging statement, can be removed in the final implementation
                System.out.print("Found pair with sum greater than largest: " + nums[i] + ", " + nums[i]);
                return -1;
            }
        }

        return largestIndex;
    }
}