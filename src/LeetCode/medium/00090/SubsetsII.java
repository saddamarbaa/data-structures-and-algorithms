/**
 * 90. Subsets II
 * Medium
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Constraints:
 * - 1 <= nums.length <= 10
 * - -10 <= nums[i] <= 10
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        // Test cases for checking Subsets II
        testSubsetsWithDup(new int[]{1, 2, 2});
        testSubsetsWithDup(new int[]{0});
        testSubsetsWithDup(new int[]{1, 2, 3});
        testSubsetsWithDup(new int[]{1, 1, 2, 2});
        testSubsetsWithDup(new int[]{4, 4, 4, 1, 4});
    }

    /**
     * Method to test the Subsets II function.
     *
     * @param nums The input array.
     */
    public static void testSubsetsWithDup(int[] nums) {
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Subsets: " + result);
        System.out.println();
    }

    /**
     * Method to generate all possible subsets of the given array, ensuring no duplicates.
     *
     * @param nums The input array, which may contain duplicates.
     * @return A list of lists where each inner list is a unique subset.
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to easily handle duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    /**
     * Helper method to perform backtracking to generate subsets.
     *
     * @param result   The list to store all unique subsets.
     * @param tempList The current subset being formed.
     * @param nums     The input array.
     * @param start    The starting index for the current backtracking step.
     */
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Add the current subset to the result
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]); // Include the current number in the subset
            backtrack(result, tempList, nums, i + 1); // Recurse with the next number
            tempList.remove(tempList.size() - 1); // Remove last element (backtrack)
        }
    }



    public List<List<Integer>> subsetsWithDup2(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, res);

        return res;
    }

    private static void helper(int[] arr, int index, List<Integer> subset,List<List<Integer>> res) {
        // Base case: If index equals the length of the array, we've reached the end and can print the subset
        if (index == arr.length) {

            if(res.contains(subset)){
                return;
            }
            // System.out.println(subset);
            res.add(new ArrayList<>(subset));
            return;
        }

        // Recursive case 1: Include the current element in the subset and move to the next index
        subset.add(arr[index]);
        helper(arr, index + 1, subset,res);

        // Recursive case 2: Exclude the current element from the subset and move to the next index
        subset.remove(subset.size() - 1);
        helper(arr, index + 1, subset,res);
    }
}
