/*
350. Intersection of Two Arrays II
Easy
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 */


import java.util.*;

public class Intersect {
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] expected1 = {2, 2};
        int[] result1 = intersect(nums1, nums2);
        System.out.println("Test Case 1 - nums1: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - nums2: " + Arrays.toString(nums2));
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.toString(result1));
        System.out.println("Test Case 1 - Result matches expected: " +
                Arrays.equals(result1, expected1));

        // Test Case 2
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] expected2 = {4, 9};
        int[] result2 = intersect(nums3, nums4);
        System.out.println("Test Case 2 - nums3: " + Arrays.toString(nums3));
        System.out.println("Test Case 2 - nums4: " + Arrays.toString(nums4));
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.toString(result2));
        System.out.println("Test Case 2 - Result matches expected: " +
                Arrays.equals(result2, expected2));

        // Test Case 3
        int[] nums5 = {1, 2, 3, 4, 5};
        int[] nums6 = {6, 7, 8, 9, 10};
        int[] expected3 = {};
        int[] result3 = intersect(nums5, nums6);
        System.out.println("Test Case 3 - nums5: " + Arrays.toString(nums5));
        System.out.println("Test Case 3 - nums6: " + Arrays.toString(nums6));
        System.out.println("Test Case 3 - Expected result: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Actual result: " + Arrays.toString(result3));
        System.out.println("Test Case 3 - Result matches expected: " +
                Arrays.equals(result3, expected3));

    }


    /*
       Algorithm Steps:
       1. Sort both nums1 and nums2 arrays.
       2. Create an ArrayList to store the common elements.
       3. Initialize two pointers, pointer1 for nums1 and pointer2 for nums2, both starting at index 0.
       4. Iterate while both pointers are within the bounds of their respective arrays:
           a. Get the current elements num1 = nums1[pointer1] and num2 = nums2[pointer2].
           b. If num1 is equal to num2, add the element to the intersection list, increment both pointers.
           c. If num1 is less than num2, increment pointer1.
           d. If num1 is greater than num2, increment pointer2.
       5. Convert the intersection list to an array.
       6. Return the array.

       Time Complexity: O(n log n + m log m), where n and m are the lengths of nums1 and nums2 respectively
                       (due to sorting the arrays).
       Space Complexity: O(min(n, m)), where n and m are the lengths of nums1 and nums2 respectively
                         (to store the intersection list).
   */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> intersection = new ArrayList<>();

        int pointer1 = 0;  // Pointer for nums1
        int pointer2 = 0;  // Pointer for nums2

        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            int num1 = nums1[pointer1];
            int num2 = nums2[pointer2];

            if (num1 == num2) {
                intersection.add(num1);  // Add common element to the intersection list
                pointer1++;  // Move both pointers forward
                pointer2++;
            } else if (num1 < num2) {
                pointer1++;  // Move pointer for nums1 forward
            } else {
                pointer2++;  // Move pointer for nums2 forward
            }
        }

        // Convert the intersection list to an array
        int[] result = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            result[index] = num;
            index++;
        }

        return result;
    }


    /*
        Algorithm Steps:
        1. Create a map to store the frequency of elements in nums1.
        2. Store the frequency of each element in nums1 in the map.
        3. Create a list to store the intersection elements.
        4. Iterate through each element in nums2.
            a. Check if the element exists in the map and has a frequency greater than 0.
            b. If yes, add the element to the intersection list and decrement its frequency in the map.
        5. Convert the intersection list to an array.
        6. Return the array.

        Time Complexity: O(n + m), where n is the length of nums1 and m is the length of nums2.
        Space Complexity: O(k), where k is the number of common elements between nums1 and nums2.
    */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        // Create a map to store the frequency of elements in nums1
        Map<Integer, Integer> map = new HashMap<>();

        // Store the frequency of each element in nums1
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create a list to store the intersection elements
        List<Integer> intersection = new ArrayList<>();

        // Iterate through each element in nums2
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            // Check if the element exists in the map and has a frequency greater than 0
            if (map.containsKey(num) && map.get(num) > 0) {
                intersection.add(num);  // Add the element to the intersection list
                map.put(num, map.get(num) - 1);  // Decrement the frequency
            }
        }

        // Convert the intersection list to an array
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }
}