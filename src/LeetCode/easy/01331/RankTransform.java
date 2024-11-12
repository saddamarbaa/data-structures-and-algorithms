/***
 1331. Rank Transform of an Array

 Easy
 Given an array of integers arr, replace each element with its rank.

 The rank represents how large the element is. The rank has the following rules:

 Rank is an integer starting from 1.
 The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 Rank should be as small as possible.


 Example 1:

 Input: arr = [40,10,20,30]
 Output: [4,1,2,3]
 Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
 Example 2:

 Input: arr = [100,100,100]
 Output: [1,1,1]
 Explanation: Same elements share the same rank.
 Example 3:

 Input: arr = [37,12,28,9,100,56,80,5,12]
 Output: [5,3,4,2,8,6,7,1,3]


 Constraints:

 0 <= arr.length <= 105
 -109 <= arr[i] <= 109
 */

import java.util.*;

public class RankTransform {
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {40, 10, 20, 30};
        System.out.println("Test Case 1 - Output: " + Arrays.toString(arrayRankTransform(arr1)));

        // Test case 2
        int[] arr2 = {100, 100, 100};
        System.out.println("Test Case 2 - Output: " + Arrays.toString(arrayRankTransform(arr2)));

        // Test case 3
        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println("Test Case 3 - Output: " + Arrays.toString(arrayRankTransform(arr3)));
    }

    /**
     * Replaces each element in the array with its rank.
     *
     * @param arr The input array.
     * @return The array with ranks replacing the original elements.
     */
    public static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        
        // Step 1: Create a sorted version of the array
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        // Step 2: Create a map to store the rank of each unique element
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        
        for (int num : sortedArr) {
            // Only assign rank to unique elements
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        
        // Step 3: Replace elements in the original array with their rank
        for (int i = 0; i < n; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        
        return arr;
    }
}
