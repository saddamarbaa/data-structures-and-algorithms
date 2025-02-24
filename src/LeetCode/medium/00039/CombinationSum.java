import java.util.*;

/**
 * 39. Combination Sum
 *
 * Medium
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique
 * combinations of candidates where the chosen numbers sum to target.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Constraints:
 * - 1 <= candidates.length <= 30
 * - 2 <= candidates[i] <= 40
 * - All elements of candidates are distinct.
 * - 1 <= target <= 500
 */

public class CombinationSum {

    public static void main(String[] args) {
        // Test Case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> result1 = combinationSum(candidates1, target1);
        System.out.println("Test Case 1 - Output: " + result1);

        // Test Case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> result2 = combinationSum(candidates2, target2);
        System.out.println("Test Case 2 - Output: " + result2);
    }

    /**
     * Returns all unique combinations where the numbers sum to the target.
     *
     * Algorithm:
     * 1. Use backtracking to find all possible combinations.
     * 2. At each step, try to include the current candidate and continue exploring.
     * 3. Allow the same candidate to be chosen multiple times by not moving to the next candidate.
     * 4. Skip the candidate if it causes the sum to exceed the target.
     *
     * Time Complexity: O(2^t * k), where t is the target and k is the average length of each combination.
     * Space Complexity: O(t), where t is the target.
     *
     * @param candidates - The input array of candidates.
     * @param target - The target sum.
     * @return The list of unique combinations.
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));  // Found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue;  // Skip if the candidate exceeds the remaining target

            currentCombination.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, currentCombination, result);  // Same element can be used
            currentCombination.remove(currentCombination.size() - 1);  // Backtrack
        }
    }
}
