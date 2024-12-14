/**
 * 46. Permutations
 * Medium
 *
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints:
 * - 1 <= nums.length <= 6
 * - -10 <= nums[i] <= 10
 * - All the integers of nums are unique.
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        // Test cases for checking Permutations
        testPermutations(new int[]{1, 2, 3});
        testPermutations(new int[]{0, 1});
        testPermutations(new int[]{1});
        testPermutations(new int[]{1, 2, 3, 4});
        testPermutations(new int[]{-1, 0, 1});
    }

    /**
     * Method to test the Permutations function.
     *
     * @param nums The input array.
     */
    public static void testPermutations(int[] nums) {
        List<List<Integer>> result = permute(nums);
        System.out.println("Input: " + java.util.Arrays.toString(nums));
        System.out.println("Permutations: " + result);
        System.out.println();
    }

    /**
     * Method to generate all permutations of the given array.
     *
     * @param nums The input array.
     * @return A list of lists where each inner list is a permutation.
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    /**
     * Helper method to perform backtracking to generate permutations.
     *
     * @param result   The list to store all the permutations.
     * @param tempList The current permutation being formed.
     * @param nums     The input array.
     */
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // If the current list is the same length as the input array, we found a valid permutation
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Add a copy of the current list to the result
        } else {
            // Explore all possibilities
            for (int num : nums) {
                if (tempList.contains(num)) continue; // Skip if num is already in the current list
                tempList.add(num); // Add the current num
                backtrack(result, tempList, nums); // Recurse
                tempList.remove(tempList.size() - 1); // Remove last element (backtrack)
            }
        }
    }
}
