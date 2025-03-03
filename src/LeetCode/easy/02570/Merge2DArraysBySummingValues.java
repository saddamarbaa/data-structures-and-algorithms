/**
 2570. Merge Two 2D Arrays by Summing Values

 Easy

 You are given two 2D integer arrays nums1 and nums2.

 nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
 nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
 Each array contains unique ids and is sorted in ascending order by id.

 Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

 Only ids that appear in at least one of the two arrays should be included in the resulting array.
 Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
 Return the resulting array. The returned array must be sorted in ascending order by id.


 Example 1:

 Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
 Output: [[1,6],[2,3],[3,2],[4,6]]
 Explanation: The resulting array contains the following:
 - id = 1, the value of this id is 2 + 4 = 6.
 - id = 2, the value of this id is 3.
 - id = 3, the value of this id is 2.
 - id = 4, the value of this id is 5 + 1 = 6.
 Example 2:

 Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
 Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
 Explanation: There are no common ids, so we just include each id with its value in the resulting list.


 Constraints:

 1 <= nums1.length, nums2.length <= 200
 nums1[i].length == nums2[j].length == 2
 1 <= idi, vali <= 1000
 Both arrays contain unique ids.
 Both arrays are in strictly ascending order by id.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Merge2DArraysBySummingValues {

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] arr2 = {{2, 4}, {3, 2}, {4, 1}};

        int[][] expected1 = {{1, 2}, {2, 7}, {3, 2}, {4, 6}};
        int[][] result1 = mergeArrays(arr1, arr2);

        System.out.println("Test Case 1 - Input: arr1 = " + Arrays.deepToString(arr1) + ", arr2 = " + Arrays.deepToString(arr2));
        System.out.println("Test Case 1 - Expected result: " + Arrays.deepToString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.deepToString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.deepEquals(result1, expected1));

        int[][] arr3 = {{1, 5}, {3, 3}};
        int[][] arr4 = {{3, 7}, {4, 6}};

        int[][] expected2 = {{1, 5}, {3, 10}, {4, 6}};
        int[][] result2 = mergeArrays(arr3, arr4);

        System.out.println("Test Case 2 - Input: arr3 = " + Arrays.deepToString(arr3) + ", arr4 = " + Arrays.deepToString(arr4));
        System.out.println("Test Case 2 - Expected result: " + Arrays.deepToString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.deepToString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.deepEquals(result2, expected2));
    }

    /**
     * Merges two 2D arrays by summing values of matching ids.
     *
     * Algorithm Steps:
     * 1. Create a HashMap to store the sum of values by id.
     * 2. Iterate through both arrays and update the map by adding the values for matching ids.
     * 3. Convert the map entries back to a 2D array and sort by id.
     *
     * @param arr1 - First 2D array of id-value pairs.
     * @param arr2 - Second 2D array of id-value pairs.
     * @return A sorted 2D array with ids and their summed values.
     */
    public static int[][] mergeArrays(int[][] arr1, int[][] arr2) {
        Map<Integer, Integer> idToValueMap = new HashMap<>();

        // Process the first array
        for (int[] pair : arr1) {
            idToValueMap.put(pair[0], idToValueMap.getOrDefault(pair[0], 0) + pair[1]);
        }

        // Process the second array
        for (int[] pair : arr2) {
            idToValueMap.put(pair[0], idToValueMap.getOrDefault(pair[0], 0) + pair[1]);
        }

        // Prepare the result list
        List<int[]> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : idToValueMap.entrySet()) {
            resultList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        // Sort the result by id (first element of each pair)
        resultList.sort((a, b) -> Integer.compare(a[0], b[0]));

        // Convert the list back to a 2D array
        return resultList.toArray(new int[resultList.size()][]);
    }

    public int[][] mergeArrays2(int[][] nums1, int[][] nums2) {
        // Initialize a map to store key-value pairs (key -> sum of values)
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse through nums1 and put key-value pairs into the map
        for (int i = 0; i < nums1.length; i++) {
            int[] arr = nums1[i];
            int k = arr[0];
            int v = arr[1];
            map.put(k, v);
        }

        // Traverse through nums2 and add values to existing keys in the map
        for (int i = 0; i < nums2.length; i++) {
            int[] arr = nums2[i];
            int k = arr[0];
            int v = arr[1];
            // Sum the values if the key already exists, or insert the new key-value pair
            int updatedValue = map.getOrDefault(k, 0) + v;
            map.put(k, updatedValue);
        }

        // Convert the map entries back into a 2D array
        int[][] result = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index][0] = entry.getKey();  // Set key
            result[index][1] = entry.getValue();  // Set summed value
            index++;
        }

        // Sort the 2D array by the first column (key)
        Arrays.sort(result, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        return result;
    }
}
