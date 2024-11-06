/**
 2404. Most Frequent Even Element

 Easy

 Given an integer array nums, return the most frequent even element.

 If there is a tie, return the smallest one. If there is no such element, return -1.

 Example 1:

 Input: nums = [0,1,2,2,4,4,1]
 Output: 2
 Explanation:
 The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
 We return the smallest one, which is 2.
 Example 2:

 Input: nums = [4,4,4,9,2,4]
 Output: 4
 Explanation: 4 is the even element appears the most.
 Example 3:

 Input: nums = [29,47,21,41,13,37,25,7]
 Output: -1
 Explanation: There is no even element.
 */


import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {
    public static void main(String[] args) {
        // Test case 1 - Even number 4 is the most frequent
        int[] nums1 = {0, 1, 2, 2, 4, 4, 4};
        int expected1 = 4;
        int result1 = mostFrequentEven(nums1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2 - Single even element
        int[] nums2 = {1, 3, 5, 2};
        int expected2 = 2;
        int result2 = mostFrequentEven(nums2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);

        // Test case 3 - No even numbers
        int[] nums3 = {1, 3, 5, 7};
        int expected3 = -1;
        int result3 = mostFrequentEven(nums3);
        System.out.println("Test Case 3 - Expected: " + expected3);
        System.out.println("Test Case 3 - Actual: " + result3);

        // Test case 4 - Multiple even numbers with the same frequency
        int[] nums4 = {4, 2, 2, 4};
        int expected4 = 2; // Both 2 and 4 have the same frequency, so return the smaller one
        int result4 = mostFrequentEven(nums4);
        System.out.println("Test Case 4 - Expected: " + expected4);
        System.out.println("Test Case 4 - Actual: " + result4);
    }

    /**
     * Find the most frequent even element in the array.
     * If multiple elements have the same frequency, return the smallest.
     * If no even numbers are present, return -1.
     *
     * @param nums The input array of integers.
     * @return The most frequent even number, or -1 if none exist.
     */
    public static int mostFrequentEven(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count the frequency of each even element
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int mostFrequentKey = -1;
        int maxFrequency = 0;

        // Find the most frequent even element
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            // Update the most frequent key or choose the smaller key if frequencies are the same
            if (value > maxFrequency || (value == maxFrequency && key < mostFrequentKey)) {
                maxFrequency = value;
                mostFrequentKey = key;
            }
        }

        return mostFrequentKey;
    }
}
