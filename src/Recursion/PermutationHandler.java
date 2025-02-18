import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationHandler {

    public static void main(String[] args) {
        // Example with a string
        String str = "ABC";
        System.out.println("Permutations of " + str + ":");
        printStringPermutations("", str);

        // Example with an array of integers
        int[] arr = {1, 2, 3};
        System.out.println("\n=== Permutations (without duplicates) ===");
        List<List<Integer>> allPermutations = permute(arr);
        for (List<Integer> perm : allPermutations) {
            System.out.println(perm);
        }

        System.out.println("\n=== Next Lexicographical Permutation ===");
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        int[] numsWithDuplicates = {1, 1, 2};
        System.out.println("\n=== Permutations (with duplicates) ===");
        List<List<Integer>> uniquePermutations = permuteUnique(numsWithDuplicates);
        for (List<Integer> perm : uniquePermutations) {
            System.out.println(perm);
        }
    }

    /**
     * Function to print all permutations of a string.
     * This method uses recursion to generate permutations.
     *
     * @param unprocessed: The part of the string that has already been processed (initially empty).
     * @param processed: The part of the string that is yet to be processed (initially the full string).
     */
    public static void printStringPermutations(String unprocessed, String processed) {
        // Base case: if the processed string is empty, we have a complete permutation
        if (processed.isEmpty()) {
            System.out.println(unprocessed); // Print the permutation
            return;
        }

        // Loop through each character in the processed string
        for (int i = 0; i < processed.length(); i++) {
            // Take the character at index i
            char ch = processed.charAt(i);
            // Form the remaining string by excluding the character at index i
            String remaining = processed.substring(0, i) + processed.substring(i + 1);
            // Recursive call to form the permutation with the remaining string
            printStringPermutations(unprocessed + ch, remaining);
        }
    }

    /**
     * Function to generate all permutations of an integer array.
     * This method uses backtracking to generate permutations.
     *
     * @param nums: The array of integers for which permutations are to be generated.
     * @return A list of lists containing all permutations.
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the recursion with an empty list and the input array
        backtrackPermute(nums, new ArrayList<>(), result);
        return result;
    }

    /**
     * Helper function for generating permutations of an integer array.
     * This method uses recursion and backtracking to generate permutations.
     *
     * @param nums: The array of integers.
     * @param tempList: The current permutation being constructed.
     * @param result: The list to store all completed permutations.
     */
    private static void backtrackPermute(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        // Base case: if the current permutation is complete (i.e., it has the same length as the input array)
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Add a copy of the current permutation to the result
            return;
        }

        // Loop through each number in the array
        for (int num : nums) {
            // If the number is not already in the current permutation, add it
            if (!tempList.contains(num)) {
                tempList.add(num); // Choose the number
                // Recursive call to continue forming the permutation
                backtrackPermute(nums, tempList, result);
                // Backtrack: remove the last added number to explore other possibilities
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * Function to find the next lexicographical permutation of an array.
     * This method modifies the array in-place to the next permutation.
     *
     * @param nums: The array of integers.
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // Find first decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            // Find element just larger than nums[i]
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        // Reverse the rest to get the next smallest lexicographical sequence
        reverse(nums, i + 1);
    }

    /**
     * Helper function to reverse a portion of an array.
     *
     * @param nums: The array of integers.
     * @param start: The starting index of the portion to be reversed.
     */
    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    /**
     * Helper function to swap two elements in an array.
     *
     * @param nums: The array of integers.
     * @param i: The index of the first element.
     * @param j: The index of the second element.
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Function to generate all unique permutations of an integer array with duplicates.
     * This method uses backtracking to generate permutations.
     *
     * @param nums: The array of integers for which permutations are to be generated.
     * @return A list of lists containing all unique permutations.
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sorting helps in skipping duplicates
        backtrackPermuteUnique(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    /**
     * Helper function for generating unique permutations of an integer array with duplicates.
     * This method uses recursion and backtracking to generate permutations.
     *
     * @param nums: The array of integers.
     * @param used: An array to keep track of used elements.
     * @param tempList: The current permutation being constructed.
     * @param result: The list to store all completed permutations.
     */
    private static void backtrackPermuteUnique(int[] nums, boolean[] used, List<Integer> tempList, List<List<Integer>> result) {
        // Base case: if the current permutation is complete (i.e., it has the same length as the input array)
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Add a copy of the current permutation to the result
            return;
        }

        // Loop through each number in the array
        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already used or if it's a duplicate that has already been processed
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            tempList.add(nums[i]);
            // Recursive call to continue forming the permutation
            backtrackPermuteUnique(nums, used, tempList, result);
            // Backtrack: remove the last added number to explore other possibilities
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}