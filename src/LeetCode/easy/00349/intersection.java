/*
349. Intersection of Two Arrays
Easy
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be
unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */


import java.util.*;

public class Arra {
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] expected1 = {2};
        int[] result1 = intersection(nums1, nums2);
        System.out.println("Test Case 1 - nums1: " + Arrays.toString(nums1));
        System.out.println("Test Case 1 - nums2: " + Arrays.toString(nums2));
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.toString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.equals(result1, expected1));

        // Test Case 2
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        int[] expected2 = {4, 9};
        int[] result2 = intersection(nums3, nums4);
        System.out.println("Test Case 2 - nums1: " + Arrays.toString(nums3));
        System.out.println("Test Case 2 - nums2: " + Arrays.toString(nums4));
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.toString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.equals(result2, expected2));
    }


 /*
    Algorithm Steps:
    1. Create a HashSet called `set1` to store unique elements from the first array, `arr1`.
    2. Create a HashSet called `commonElements` to store the common elements found in both arrays.
    3. Iterate through the elements of the second array, `arr2`:
       - Check if the current element exists in `set1`.
       - If it does, add it to the `commonElements` HashSet.
    4. Create an array `res` with the size of `commonElements`.
    5. Iterate through the `commonElements` set and populate the `res` array.
    6. Return the `res` array.

    Time Complexity: O(n + m), where n is the length of the first array and m is the length of the second array.
    Space Complexity: O(k), where k is the number of common elements.
*/

    public static int[] intersection(int[] arr1, int[] arr2) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            uniqueElements.add(arr1[i]);
        }

        Set<Integer> commonElements = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            if (uniqueElements.contains(arr2[i])) {
                commonElements.add(arr2[i]);
            }
        }

        int[] result = new int[commonElements.size()];
        int idx = 0;
        for (int element : commonElements) {
            result[idx++] = element;
        }

        return result;
    }


    /*
        Algorithm Steps:
        1. Create an ArrayList to store the common elements.
        2. Iterate through the elements of the first array:
           a. For each element, iterate through the elements of the second array.
           b. If a common element is found, add it to the ArrayList and break the inner loop.
        3. Convert the ArrayList to an array.
        4. Return the array.

        Time Complexity: O(n*m) - where n is the length of the first array and m is the length of the second array.
        Space Complexity: O(k) - where k is the number of common elements.
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        ArrayList<Integer> commonElements = new ArrayList<>();

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    commonElements.add(num1);
                    break;
                }
            }
        }

        int[] result = new int[commonElements.size()];
        for (int i = 0; i < commonElements.size(); i++) {
            result[i] = commonElements.get(i);
        }

        return result;
    }
}