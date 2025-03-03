/***
 2363. Merge Similar Items

 Easy

 You are given two 2D integer arrays, items1 and items2, representing two sets of items. Each array items has the following properties:

 items[i] = [valuei, weighti] where valuei represents the value and weighti represents the weight of the ith item.
 The value of each item in items is unique.
 Return a 2D integer array ret where ret[i] = [valuei, weighti], with weighti being the sum of weights of all items with value valuei.

 Note: ret should be returned in ascending order by value.

 Example 1:

 Input: items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
 Output: [[1,6],[3,9],[4,5]]
 Explanation:
 The item with value = 1 occurs in items1 with weight = 1 and in items2 with weight = 5, total weight = 1 + 5 = 6.
 The item with value = 3 occurs in items1 with weight = 8 and in items2 with weight = 1, total weight = 8 + 1 = 9.
 The item with value = 4 occurs in items1 with weight = 5, total weight = 5.
 Therefore, we return [[1,6],[3,9],[4,5]].
 Example 2:

 Input: items1 = [[1,1],[3,2],[2,3]], items2 = [[2,1],[3,2],[1,3]]
 Output: [[1,4],[2,4],[3,4]]
 Explanation:
 The item with value = 1 occurs in items1 with weight = 1 and in items2 with weight = 3, total weight = 1 + 3 = 4.
 The item with value = 2 occurs in items1 with weight = 3 and in items2 with weight = 1, total weight = 3 + 1 = 4.
 The item with value = 3 occurs in items1 with weight = 2 and in items2 with weight = 2, total weight = 2 + 2 = 4.
 Therefore, we return [[1,4],[2,4],[3,4]].
 Example 3:

 Input: items1 = [[1,3],[2,2]], items2 = [[7,1],[2,2],[1,4]]
 Output: [[1,7],[2,4],[7,1]]
 Explanation:
 The item with value = 1 occurs in items1 with weight = 3 and in items2 with weight = 4, total weight = 3 + 4 = 7.
 The item with value = 2 occurs in items1 with weight = 2 and in items2 with weight = 2, total weight = 2 + 2 = 4.
 The item with value = 7 occurs in items2 with weight = 1, total weight = 1.
 Therefore, we return [[1,7],[2,4],[7,1]].


 Constraints:

 1 <= items1.length, items2.length <= 1000
 items1[i].length == items2[i].length == 2
 1 <= valuei, weighti <= 1000
 Each valuei in items1 is unique.
 Each valuei in items2 is unique.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class MergeSimilarItems {
    public static void main(String[] args) {
        int[][] items1 = {{1, 3}, {2, 2}};
        int[][] items2 = {{2, 3}, {3, 1}};
        int[][] expected1 = {{1, 3}, {2, 5}, {3, 1}};
        int[][] result1 = mergeSimilarItems(items1, items2);
        System.out.println("Test Case 1 - Input 1: " + Arrays.deepToString(items1));
        System.out.println("Test Case 1 - Input 2: " + Arrays.deepToString(items2));
        System.out.println("Test Case 1 - Expected result: " + Arrays.deepToString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.deepToString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.deepToString(result1).equals(Arrays.deepToString(expected1)));
    }

    /**
     * Merges two 2D arrays of items by summing up the weights of items with the same value.
     * Returns the merged items sorted by value in ascending order.
     *
     * @param items1 - The first array of items.
     * @param items2 - The second array of items.
     * @return A merged array of items sorted by value.
     */
    public static int[][] mergeSimilarItems(int[][] items1, int[][] items2) {
        // Step 1: Create a map to store the sum of weights for each value
        Map<Integer, Integer> valueWeightMap = new HashMap<>();

        // Step 2: Iterate through items1 and add value-weight pairs to the map
        for (int[] item : items1) {
            int value = item[0];
            int weight = item[1];
            valueWeightMap.put(value, valueWeightMap.getOrDefault(value, 0) + weight);
        }

        // Step 3: Iterate through items2 and sum up the weights in the map
        for (int[] item : items2) {
            int value = item[0];
            int weight = item[1];
            valueWeightMap.put(value, valueWeightMap.getOrDefault(value, 0) + weight);
        }

        // Step 4: Create a list to store the merged items
        List<int[]> mergedItemsList = new ArrayList<>();

        // Step 5: Add the merged value-weight pairs to the list
        for (Map.Entry<Integer, Integer> entry : valueWeightMap.entrySet()) {
            mergedItemsList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        // Step 6: Sort the list by the value (first element of the pair)
        mergedItemsList.sort((a, b) -> a[0] - b[0]);

        // Step 7: Convert the list to a 2D array and return
        return mergedItemsList.toArray(new int[mergedItemsList.size()][]);
    }
}
