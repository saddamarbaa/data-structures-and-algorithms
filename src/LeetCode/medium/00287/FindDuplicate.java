/*
287. Find the Duplicate Number
Medium

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.


Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        int expected1 = 2;
        int result1 = findDuplicate(nums1);
        printResult(nums1, expected1, result1, 1);

        int[] nums2 = {3, 1, 3, 4, 2};
        int expected2 = 3;
        int result2 = findDuplicate(nums2);
        printResult(nums2, expected2, result2, 2);
    }



    /**
     * Algorithm:
     * 1. Iterate through the input array using cycle sort to place each element at its correct position.
     * 2. During the cycle sort, if a duplicate is encountered, return that duplicate as it's the first one found.
     *
     * Time Complexity: O(n)
     * - The cycle sort step takes O(n) time in the worst case.
     * - Overall, the time complexity is O(n).
     *
     * Space Complexity: O(1)
     * - The algorithm uses a constant amount of space for variables.
     * - The space complexity is O(1).
     *
     * @param array The input array of integers.
     * @return The first duplicate number found, or -1 if no duplicate is present.
     */
    public static int findDuplicate(int[] array) {
        int size = array.length;
        int currentIndex = 0;

        while (currentIndex < size) {
            // Find the correct index for the current element in the sorted array
            int correctIndex = array[currentIndex] - 1;

            // Perform cyclic swapping until the current element is at its correct position
            if (array[currentIndex] != currentIndex + 1) {
                if (array[currentIndex] != array[correctIndex]) {
                    swap(array, currentIndex, correctIndex);
                } else {
                    // Duplicate found, return it
                    return array[currentIndex];
                }
            } else {
                currentIndex++;
            }
        }

        // No duplicate found
        return -1;
    }




    /**
     * Marking visited value within the array
     * Since all values of the array are between [1 - n] and the array size is n+1, while
     * scanning the array from left to right, we set the nums[n] to its negative value.
     * With extra O(1) space, with modifying the input.
     * Time Complexity: O(n).
     * Space Complexity: O(n).
     */
    public static int findDuplicate2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                return index;
            }
            nums[index] = -nums[index];
        }
        return length;
    }

    /**
     * Using a HashSet to record the occurrence of each number .With extra O(n)  space, without
     * modifying the input.
     * Time Complexity: O(n).
     * Space Complexity: O(n).
     */
    public static int findDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }

        return len;
    }

    /**
     * Count the frequency of the num in the array.With extra O(n)  space, without modifying the input.
     * Time Complexity: O(n).
     * Space Complexity: O(n).
     */
    public static int findDuplicate4(int[] nums) {
        int len = nums.length;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) {
                return nums[i];
            }
        }

        return len;
    }


    /**
     * Sorting the array first, then use a loop from 111 to n With extra O(nlogn) space, modifying the input.
     * Time Complexity: O(nlogn).
     * Space Complexity: O(n2).
     */
    public static int findDuplicate5(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return len;
    }

    /**
     * Brute Force (2 Loops)
     * Since solve the problem without modifying the array nums and uses only constant extra space, we can use Brute
     * Force to solve it.
     * It's easy to use 2 loops to do it, but the time complexity is O(n2), so it wouldn't accepted as timeout.
     * Time Complexity: O(n2).
     * Space Complexity: O(1)
     */
    public static int findDuplicate6(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return len;
    }



    /**
     * Print the result of a test case.
     *
     * @param input    The input array for the test case.
     * @param expected The expected result for the test case.
     * @param result   The actual result obtained from the function.
     * @param testCaseNumber The number of the test case.
     */
    private static void printResult(int[] input, int expected, int result, int testCaseNumber) {
        System.out.println("Test Case " + testCaseNumber + " - Input: " + Arrays.toString(input));
        System.out.println("Test Case " + testCaseNumber + " - Expected result: " + expected);
        System.out.println("Test Case " + testCaseNumber + " - Actual result: " + result);
        System.out.println("Test Case " + testCaseNumber + " - Result matches expected: " + (result == expected));
        System.out.println();
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