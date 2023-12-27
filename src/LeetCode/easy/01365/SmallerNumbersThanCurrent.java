/**
 1365. How Many Numbers Are Smaller Than the Current Number
 Easy
 Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

 Return the answer in an array.


 Example 1:

 Input: nums = [8,1,2,2,3]
 Output: [4,0,1,1,3]
 Explanation:
 For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 For nums[1]=1 does not exist any smaller number than it.
 For nums[2]=2 there exist one smaller number than it (1).
 For nums[3]=2 there exist one smaller number than it (1).
 For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 Example 2:

 Input: nums = [6,5,4,8]
 Output: [2,1,0,3]
 Example 3:

 Input: nums = [7,7,7,7]
 Output: [0,0,0,0]


 Constraints:

 2 <= nums.length <= 500
 0 <= nums[i] <= 100
 */

import java.util.Arrays;

public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {8, 1, 2, 2, 3};
        int[] expected1 = {4, 0, 1, 1, 3};
        int[] result1 = smallerNumbersThanCurrent(nums1);
        printResult(nums1, expected1, result1);

        // Test case 2
        int[] nums2 = {6, 5, 4, 8};
        int[] expected2 = {2, 1, 0, 3};
        int[] result2 = smallerNumbersThanCurrent(nums2);
        printResult(nums2, expected2, result2);

        // Test case 3
        int[] nums3 = {7, 7, 7, 7};
        int[] expected3 = {0, 0, 0, 0};
        int[] result3 = smallerNumbersThanCurrent(nums3);
        printResult(nums3, expected3, result3);
    }

    /**
     * Algorithm Steps:
     * 1. Create an array 'result' of the same length as 'nums' to store the answer.
     * 2. Iterate through each element in 'nums'.
     *    a. For each element 'nums[i]', call the 'countSmallerNumbers' function to find
     *       the count of numbers smaller than 'nums[i]'.
     *    b. Store the count in the corresponding index of 'result'.
     * 3. Return the 'result' array.
     * Time Complexity: O(n^2) - The algorithm has a nested loop.
     * Space Complexity: O(n) - Additional space is used for the 'result' array.
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = countSmallerNumbers(nums, nums[i]);
        }

        return result;
    }

    public static int countSmallerNumbers(int[] nums, int currentNum) {
        int n = nums.length;
        int count = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] < currentNum) {
                count++;
            }
        }

        return count;
    }


    public static void printResult(int[] nums, int[] expected, int[] result) {
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(result));
        System.out.println("Result matches expected: " + Arrays.equals(result, expected));
        System.out.println();
    }
}
