/*
1394. Find Lucky Integer in an Array
Easy

Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.

Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
Example 3:

Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.


Constraints:

1 <= arr.length <= 500
1 <= arr[i] <= 500
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLucky {
    public static void main(String[] args) {
        // Test case 1 - input is an empty array
        int[] input1 = {};
        int expected1 = -1;
        int result1 = findLucky(input1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2 - input array has no lucky numbers
        int[] input2 = {1, 2, 3, 4, 5};
        int expected2 = -1;
        int result2 = findLucky(input2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3 - input array has one lucky number
        int[] input3 = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int expected3 = 4;
        int result3 = findLucky(input3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(input3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case 4 - input array has multiple lucky numbers
        int[] input4 = {2, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int expected4 = 4;
        int result4 = findLucky(input4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(input4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));


        // Test case 5 - input contains multiple lucky numbers
        int[] input5 = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6};
        int expected5 = 4;
        int result5 = findLucky(input5);
        System.out.println("Test Case 5 - Input: " + Arrays.toString(input5));
        System.out.println("Test Case 5 - Expected result: " + expected5);
        System.out.println("Test Case 5 - Actual result: " + result5);
        System.out.println("Test Case 5 - Result matches expected: " + (result5 == expected5));
    }


    /**
     * Algorithm Steps:
     * 1. Create an integer array of size 501 to store the frequency of each number in the given array.
     * 2. Iterate over the array and update the frequency array with the count of each number.
     * 3. Initialize a variable maxLuckyNumber to -1.
     * 4. Iterate over the frequency array from index 1 to 500.
     * a. If the current index is equal to its value, it's a lucky number.
     * b.  If the current index is a lucky number, check if it's greater than the current maxLuckyNumber. If yes, update
     * maxLuckyNumber.
     * 5. Return the maxLuckyNumber.
     * Time Complexity: O(n), where n is the size of the given array. This is because we need to iterate over the
     * array to update the frequency map and also to find the lucky number.
     * Space Complexity: O(1), since the size of the frequency array is fixed.
     */
    public static int findLucky(int[] arr) {
        int[] frequency = new int[501];
        int maxLucky = -1;
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            int num = arr[i];
            if (num < 501) {
                frequency[num]++;
            }
        }

        for (int i = 1; i < 501; i++) {
            if (i == frequency[i] && i > maxLucky) {
                maxLucky = i;
            }
        }

        return maxLucky;
    }

    /**
     * Algorithm Steps:
     * 1. Create a HashMap to store the frequency of each number in the given array.
     * 2. Iterate over the array and update the frequency map with the count of each number.
     * 3. Initialize a variable maxLuckyNumber to -1.
     * 4. Iterate over the entries in the frequency map.
     * a. If the key is equal to the value, it's a lucky number.
     * b. If the key is a lucky number, check if it's greater than the current maxLuckyNumber. If yes, update
     * maxLuckyNumber.
     * 5. Return the maxLuckyNumber.
     * Time Complexity: O(n), where n is the size of the given array. This is because we need to iterate over the
     * array to update the frequency map and also to find the lucky number.
     * Space Complexity: O(n), where n is the size of the given array. This is because we need to store the frequency
     * of each number in the HashMap.```
     */

    public static int findLucky2(int[] numbers) {
        // create a hash map to store the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int frequency = frequencyMap.getOrDefault(number, 0);
            frequencyMap.put(number, frequency + 1);
        }

        // loop over the entries in the map to find the maximum lucky number
        int maxLuckyNumber = -1;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            if (number == frequency) {
                maxLuckyNumber = Math.max(maxLuckyNumber, number);
            }
        }

        return maxLuckyNumber;
    }
}