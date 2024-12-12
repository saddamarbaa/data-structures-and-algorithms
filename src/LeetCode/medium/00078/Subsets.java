/**
 78. Subsets

 Medium

 Given an integer array nums of unique elements, return all possible
 subsets
 (the power set).

 The solution set must not contain duplicate subsets. Return the solution in any order.

 Example 1:

 Input: nums = [1,2,3]
 Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 Example 2:

 Input: nums = [0]
 Output: [[],[0]]


 Constraints:

 1 <= nums.length <= 10
 -10 <= nums[i] <= 10
 All the numbers of nums are unique.
 * @param nums
 * @return
 */


import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        // Test case 1:
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = subsets(nums1);
        System.out.println("Subsets for nums1: " + result1);

        // Test case 2:
        int[] nums2 = {0};
        List<List<Integer>> result2 = subsets(nums2);
        System.out.println("Subsets for nums2: " + result2);

        // Test case 3:
        int[] nums3 = {-1, 0, 1};
        List<List<Integer>> result3 = subsets(nums3);
        System.out.println("Subsets for nums3: " + result3);

        // Test case 4:
        int[] nums4 = {4, 5, 6, 7};
        List<List<Integer>> result4 = subsets2(nums4);
        System.out.println("Subsets for nums4: " + result4);
    }



    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, res);
        return res;
    }

    private static void helper(int[] arr, int index, List<Integer> subset, List<List<Integer>> res) {
        // Base case: If index equals the length of the array, we've reached the end and add the subset to the result
        if (index == arr.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // Recursive case 1: Include the current element in the subset and move to the next index
        subset.add(arr[index]);
        helper(arr, index + 1, subset, res);

        // Recursive case 2: Exclude the current element from the subset and move to the next index
        subset.remove(subset.size() - 1);
        helper(arr, index + 1, subset, res);
    }

    /**
     * Returns all possible subsets (the power set) of the given array.
     * The subsets must not contain duplicate subsets.
     *
     * @param nums An array of unique integers.
     * @return A list of lists, where each inner list is a subset of the given array.
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    /**
     * Helper method to generate subsets using backtracking.
     *
     * @param result The list of all subsets found so far.
     * @param current The current subset being constructed.
     * @param nums The original array of unique integers.
     * @param start The index to start adding elements to the current subset.
     */
    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current)); // Add the current subset to the result list

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // Include the current element in the subset
            backtrack(result, current, nums, i + 1); // Recurse to add the next elements
            current.remove(current.size() - 1); // Backtrack to explore other subsets
        }
    }
}
