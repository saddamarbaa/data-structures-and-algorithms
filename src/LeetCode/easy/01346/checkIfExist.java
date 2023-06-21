/*
1346. Check If N and Its Double Exist
Easy
Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]


Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
Example 2:

Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.


Constraints:

2 <= arr.length <= 500
-103 <= arr[i] <= 103
 */


import java.util.*;

public class CheckIfExist {
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 2, 1};
        boolean expected1 = true;
        boolean result1 = checkIfExist(nums1);
        System.out.println("Test Case 1 - nums1: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test Case 2
        int[] nums2 = {4, 9, 5};
        boolean expected2 = false;
        boolean result2 = checkIfExist(nums2);
        System.out.println("Test Case 2 - nums2: " + Arrays.toString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test Case 3
        int[] nums3 = {0, 0};
        boolean expected3 = true;
        boolean result3 = checkIfExist(nums3);
        System.out.println("Test Case 3 - nums3: " + Arrays.toString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

    }


    /**
     * Algorithm Steps:
     * 1. Create a HashMap to store the occurrences of each number.
     * 2. Initialize a variable to count the number of zeros encountered.
     * 3. Iterate over the input array:
     * - Update the occurrences in the HashMap for each number.
     * - Increment the zero count if the number is zero.
     * 4. Iterate over the array again:
     * - For each number, calculate its double.
     * - Check if the double exists in the HashMap (excluding the current number itself).
     * - If the double exists, return true indicating a number and its double have been found.
     * 5. If no number and its double have been found, check if there are more than one zero in the array.
     * - If so, return true since zero can be considered its own double.
     * 6. Return false if no number and its double exist in the array.
     * <p>
     * Time Complexity: O(N), where N is the length of the input array.
     * - The algorithm iterates over the array twice, resulting in linear time complexity.
     * <p>
     * Space Complexity: O(N), where N is the length of the input array.
     * - The space complexity is determined by the HashMap used to store the occurrences of numbers,
     * which can potentially store all unique numbers from the array.
     * - In the worst case, if all numbers in the array are unique, the HashMap would have N entries.
     * - Thus, the space complexity is linear to the input size.
     */
    public static boolean checkIfExist(int[] nums) {
        HashMap<Integer, Integer> numOccurrences = new HashMap<>();
        int zeroCount = 0;

        // Count the occurrences of each number and track the number of zeros
        for (int num : nums) {
            numOccurrences.put(num, numOccurrences.getOrDefault(num, 0) + 1);
            if (num == 0) {
                zeroCount++;
            }
        }

        // Check if the double of a number exists in the map (excluding the current number itself)
        for (int num : nums) {
            int doubleNum = num * 2;

            // Special case: if the current number is 0, there should be at least 2 occurrences of 0
            if (num == 0 && zeroCount > 1) {
                return true;
            }

            // Check if the doubleNum exists and it is not the same as the current number
            if (numOccurrences.containsKey(doubleNum) && doubleNum != num) {
                return true;
            }
        }

        return false;
    }
}