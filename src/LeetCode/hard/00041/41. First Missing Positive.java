/*
41. First Missing Positive
Hard
Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
 */


import java.util.Arrays;
import java.util.HashMap;

public class Arra {
    public static void main(String[] args) {
        int[] input1 = {7, 8, 9, 11, 12};
        int expected1 = 1;
        int result1 = firstMissingPositive(input1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        int[] input2 = {1, 2, 0};
        int expected2 = 3;
        int result2 = firstMissingPositive(input2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        int[] input3 = {2, 1};
        int expected3 = 3;
        int result3 = firstMissingPositive(input3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(input3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));
    }


    /**
     * Given an unsorted integer array nums, return the smallest missing positive integer.
     * Algorithm Steps:
     * Handle the edge case when the input array is null or empty. Return 1 in this case.
     * Set a variable n to the length of the input array.
     * First loop: change all non-positive numbers to n+1.
     * Second loop: mark present elements in the array by changing the sign of the element at index num-1 (where num
     * is the absolute value of the current element in the array), if the element at index num-1 is positive and num
     * is less than or equal to n.
     * Third loop: find the first missing positive element by iterating over the array. If the element at index i is
     * positive, then i+1 is the first missing positive element. Return i+1.
     * If we haven't found the first missing positive element in step 5, then the answer is n+1.
     * Time Complexity: O(n), where n is the size of the given array. We iterate over the array three times, which
     * has a time complexity of O(n).
     * Space Complexity: O(1), as we are not using any additional data structure to store the frequency or anything
     * else.
     */
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int n = nums.length;

        // First loop: change all non-positive numbers to n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // Second loop: mark present elements in the array
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n && nums[num - 1] > 0) {
                nums[num - 1] = -1 * nums[num - 1];
            }
        }

        // Third loop: find the first missing positive element
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    /**
     * Given an unsorted integer array nums, return the smallest missing positive integer.
     * Algorithm Steps:
     * 1: Create a HashMap to store the frequency of positive integers in the given array.
     * 2. Iterate over the array and for each positive integer, update its frequency in the HashMap.
     * 3. Set a variable "smallestPositive" to 1, which represents the smallest positive integer we need to find.
     * 4. While the HashMap contains "smallest", increment "smallest" to the next smallest positive integer.
     * 5. Return "smallest", which represents the smallest missing positive integer in the array
     * Time Complexity:
     * Time Complexity: O(n), where n is the size of the given array. We only need to iterate over the array once to
     * update the frequency of positive integers in the HashMap and find the smallest missing positive integer.
     * Space Complexity:
     * the Space Complexity: O(n), where n is the size of the given array. We need to create a HashMap to store the
     * frequency of positive integers.
     */
    public static int firstMissingPositive2(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int smallestPositive = 1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) { // Ignore negative numbers and zero
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1); // Update the frequency of the number
            }
        }

        while (frequencyMap.containsKey(smallestPositive)) { // Find the smallest missing positive number
            smallestPositive++;
        }

        return smallestPositive;
    }

    /**
     * Given an unsorted integer array nums, return the smallest missing positive integer.
     * Algorithm Steps:
     * 1: sort the array
     * 2. Iterate over the given array and move all non-positive integers to the left of the array.
     * 3. Set a variable "next" to 1, which represents the smallest positive integer we need to find.
     * 4. Iterate over the remaining positive integers in the array.
     * a. If the current number is equal to "next", increment "next" to the next smallest positive integer.
     * b. If the current number is greater than "next", we have found our answer. Return "next".
     * 5. If we have not found any missing positive integer in step 3, then the answer is "next".
     * 6. Return "next"
     * Time Complexity:
     * Time Complexity: O(n log n), where n is the size of the given array. This is because we need to sort the array
     * first, which has a time complexity of O(n log n), and then iterate over the array to find the smallest
     * positive integer.
     * Space Complexity:
     * the Space Complexity: O(1), as we are not using any additional data structure to store the frequency or
     * anything else.
     */
    public static int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int smallest = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == smallest) {
                smallest++;
            }
        }

        return smallest;
    }
}





