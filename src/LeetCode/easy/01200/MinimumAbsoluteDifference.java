/**
 1200. Minimum Absolute Difference

 Easy
 Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

 Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

 a, b are from arr
 a < b
 b - a equals to the minimum absolute difference of any two elements in arr

 Example 1:

 Input: arr = [4,2,1,3]
 Output: [[1,2],[2,3],[3,4]]
 Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 Example 2:

 Input: arr = [1,3,6,10,15]
 Output: [[1,3]]
 Example 3:

 Input: arr = [3,8,-10,23,19,-4,-14,27]
 Output: [[-14,-10],[19,23],[23,27]]

 */

import java.util.*;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {

        // Test case 1
        int[] arr1 = {4, 2, 1, 3};
        List<List<Integer>> expected1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 4));
        List<List<Integer>> result1 = minimumAbsDifference(arr1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2
        int[] arr2 = {1, 3, 6, 10, 15};
        List<List<Integer>> expected2 = Arrays.asList(Arrays.asList(1, 3));
        List<List<Integer>> result2 =minimumAbsDifference(arr2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);
    }

    /**
     * Finds all pairs with the minimum absolute difference.
     *
     * @param arr The array of distinct integers.
     * @return A list of pairs with the minimum absolute difference.
     */
    public  static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList();
        int min = Integer.MAX_VALUE;

        for(int i = 1; i < arr.length; i++){
            min = Math.min(min, arr[i] - arr[i - 1]);
        }


        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i - 1] == min){
                List<Integer> temp = new ArrayList();
                temp.add(arr[i - 1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
