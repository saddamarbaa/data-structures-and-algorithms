/**
 1122. Relative Sort Array
 Solved
 Easy
 Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

 Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

 Example 1:

 Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 Output: [2,2,2,1,4,3,3,9,6,7,19]
 Example 2:

 Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 Output: [22,28,8,6,17,44]


 Constraints:

 1 <= arr1.length, arr2.length <= 1000
 0 <= arr1[i], arr2[i] <= 1000
 All the elements of arr2 are distinct.
 Each arr2[i] is in arr1.
 */

import java.util.*;

public class RelativeSortArray {
    public static void main(String[] args) {

        // Test case 1
        int[] arr1_1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2_1 = {2, 1, 4, 3, 9, 6};
        int[] expected1 = {2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19};
        int[] result1 = relativeSortArray(arr1_1, arr2_1);
        System.out.println("Test Case 1 - Expected: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual: " + Arrays.toString(result1));

        // Test case 2
        int[] arr1_2 = {28, 6, 22, 8, 44, 17};
        int[] arr2_2 = {22, 28, 8, 6};
        int[] expected2 = {22, 28, 8, 6, 17, 44};
        int[] result2 = relativeSortArray(arr1_2, arr2_2);
        System.out.println("Test Case 2 - Expected: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual: " + Arrays.toString(result2));
    }

    /**
     * Sorts arr1 based on the relative order of elements in arr2.
     * Elements of arr1 not present in arr2 are sorted in ascending order
     * and placed at the end.
     *
     * @param arr1 The array to be sorted.
     * @param arr2 The array representing the order to sort by.
     * @return The sorted arr1.
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] ans = new int[n];
        ArrayList<Integer> temp = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        // Add elements of arr2 into the set for quick lookup
        for (int num : arr2) {
            set.add(num);
        }

        // Fill map with counts of each element in arr1 and collect non-arr2 elements
        for (int num : arr1) {
            if (!set.contains(num)) {
                temp.add(num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Fill ans array with elements from arr2 in their order, according to their count in arr1
        int k = 0;
        for (int num : arr2) {
            while (map.containsKey(num) && map.get(num) > 0) {
                ans[k++] = num;
                map.put(num, map.get(num) - 1);
            }
        }

        // Add the remaining elements (not in arr2) to the ans array in sorted order
        Collections.sort(temp);
        for (int num : temp) {
            ans[k++] = num;
        }

        return ans;
    }
}
