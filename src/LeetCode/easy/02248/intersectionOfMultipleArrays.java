/**
 2248. Intersection of Multiple Arrays
 Easy
 Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers, return the list of integers that are present in each array of nums sorted in ascending order.


 Example 1:

 Input: nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
 Output: [3,4]
 Explanation:
 The only integers present in each of nums[0] = [3,1,2,4,5], nums[1] = [1,2,3,4], and nums[2] = [3,4,5,6] are 3 and 4, so we return [3,4].
 Example 2:

 Input: nums = [[1,2,3],[4,5,6]]
 Output: []
 Explanation:
 There does not exist any integer present both in nums[0] and nums[1], so we return an empty list [].


 Constraints:

 1 <= nums.length <= 1000
 1 <= sum(nums[i].length) <= 1000
 1 <= nums[i][j] <= 1000
 All the values of nums[i] are unique.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntersectionOfMultipleArrays {

    public static void main(String[] args) {

        // Test Case 1
        int[][] nums1 = {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};
        List<Integer> expected1 = Arrays.asList(3, 4);
        List<Integer> result1 = intersection(nums1);
        System.out.println("Test Case 1 - Input: " + Arrays.deepToString(nums1));
        System.out.println("Expected result: " + expected1);
        System.out.println("Actual result: " + result1);
        System.out.println("Result matches expected: " + result1.equals(expected1));
        System.out.println();

        // Test Case 2
        int[][] nums2 = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> expected2 = Collections.emptyList();
        List<Integer> result2 = intersection(nums2);
        System.out.println("Test Case 2 - Input: " + Arrays.deepToString(nums2));
        System.out.println("Expected result: " + expected2);
        System.out.println("Actual result: " + result2);
        System.out.println("Result matches expected: " + result2.equals(expected2));
        System.out.println();

        // Test Case 3
        int[][] nums3 = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        List<Integer> expected3 = Collections.singletonList(3);
        List<Integer> result3 = intersection(nums3);
        System.out.println("Test Case 3 - Input: " + Arrays.deepToString(nums3));
        System.out.println("Expected result: " + expected3);
        System.out.println("Actual result: " + result3);
        System.out.println("Result matches expected: " + result3.equals(expected3));
    }


    /**
     * Algorithm Steps:
     * 1. Create an ArrayList finalList to store the final result.
     * 2. Iterate over each array in nums.
     *    a. For each element num in the current array, check if it is present in all other arrays.
     *    b. If num is present in all arrays and is not already added to finalList, add it to finalList.
     * 3. Sort the finalList in ascending order.
     * 4. Return the sorted finalList as the result.
     *
     * Time Complexity: O(N*M*log(M)), where N is the number of arrays, M is the average length of arrays.
     *   - The nested loop iterates over each element in each array (O(N*M)).
     *   - Sorting the finalList takes O(M*log(M)) time.
     * Space Complexity: O(M), where M is the average length of arrays.
     *   - The space used by the finalList.
     */
    public static List<Integer> intersection(int[][] nums) {
        List<Integer> finalList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int num = nums[i][j];

                if (!finalList.contains(num) &&isContainInAll(nums, num) ) {
                    finalList.add(num);
                }
            }
        }

        // Sort the ArrayList in ascending order
        Collections.sort(finalList);
        return finalList;
    }

    public static boolean isContainInAll(int[][] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            boolean containInCurrentArray = false;

            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == num) {
                    containInCurrentArray = true;
                    break;
                }
            }

            if (!containInCurrentArray) {
                return false;
            }
        }

        return true;
    }
}