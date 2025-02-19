import java.util.*;

/**
 * 47. Permutations II
 *
 * Medium
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations.
 *
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: [[1,1,2], [1,2,1], [2,1,1]]
 *
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 *
 * Constraints:
 * - 1 <= nums.length <= 8
 * - -10 <= nums[i] <= 10
 */

public class PermutationsII {

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 1, 2};
        List<List<Integer>> result1 = permuteUnique(nums1);
        System.out.println("Test Case 1 - Output: " + result1);

        // Test Case 2
        int[] nums2 = {1, 2, 3};
        List<List<Integer>> result2 = permuteUnique(nums2);
        System.out.println("Test Case 2 - Output: " + result2);
    }

    /**
     * Returns all unique permutations of the given array.
     *
     * Algorithm:
     * 1. Sort the input array to help identify duplicate elements.
     * 2. Use backtracking to generate all permutations.
     * 3. Skip duplicates by checking if the current element is the same as the previous element.
     * 4. Add the current permutation to the result list once it's completed.
     *
     * Time Complexity: O(n! * n), where n is the length of the input array. The factorial term comes from the
     *                 number of permutations, and the linear term comes from copying the current permutation into the result list.
     * Space Complexity: O(n), where n is the length of the input array. We use additional space for storing the current permutation.
     *
     * @param nums - The input array.
     * @return The list of unique permutations.
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);  // Sort the array to handle duplicates
        backtrack(nums, used, currentPermutation, result);
        return result;
    }

    private static void backtrack(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result) {
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));  // Add the current permutation to the result
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;  // Skip if already used

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            currentPermutation.add(nums[i]);
            backtrack(nums, used, currentPermutation, result);
            currentPermutation.remove(currentPermutation.size() - 1);  // Backtrack
            used[i] = false;
        }
    }



    private void backtrack2(List<List<Integer>> resultList,
                           ArrayList<Integer> tempList, int[] nums, boolean[] used) {
        // If we match the length, it is a permutation
        if (tempList.size() == nums.length
                && !resultList.contains(tempList)) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if we get same element
            if (used[i]) continue;

            // Add the new element and mark it as used
            used[i] = true;
            tempList.add(nums[i]);

            // Go back to try other element
            backtrack(resultList, tempList, nums, used);

            // Remove the element and mark it as unused
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
