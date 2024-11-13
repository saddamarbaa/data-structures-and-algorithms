/**
 1630. Arithmetic Subarrays
 Solved
 Medium
 Topics
 Companies
 Hint
 A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.

 For example, these are arithmetic sequences:

 1, 3, 5, 7, 9
 7, 7, 7, 7
 3, -1, -5, -9
 The following sequence is not arithmetic:

 1, 1, 2, 5, 7
 You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.

 Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.

 Example 1:

 Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
 Output: [true,false,true]
 Explanation:
 In the 0th query, the subarray is [4,6,5]. This can be rearranged as [6,5,4], which is an arithmetic sequence.
 In the 1st query, the subarray is [4,6,5,9]. This cannot be rearranged as an arithmetic sequence.
 In the 2nd query, the subarray is [5,9,3,7]. This can be rearranged as [3,5,7,9], which is an arithmetic sequence.
 Example 2:

 Input: nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
 Output: [false,true,false,false,true,true]
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ArithmeticSubarrays {

    public static void main(String[] args) {
        // Test cases for checking Arithmetic Subarrays
        testArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}, new boolean[]{true, false, true});
        testArithmeticSubarrays(new int[]{1, 2, 4, 6, 8}, new int[]{0, 1, 2}, new int[]{2, 3, 4}, new boolean[]{true, false, true});
        testArithmeticSubarrays(new int[]{10, 20, 30, 40, 50}, new int[]{0, 1, 2}, new int[]{2, 3, 4}, new boolean[]{true, true, true});
        testArithmeticSubarrays(new int[]{7, 7, 7, 7}, new int[]{0, 1, 2}, new int[]{3, 3, 3}, new boolean[]{true, true, true});
        testArithmeticSubarrays(new int[]{-5, -3, -1, 1, 3}, new int[]{0, 1, 2}, new int[]{2, 3, 4}, new boolean[]{true, true, true});
        testArithmeticSubarrays(new int[]{10, 9, 8, 7, 6}, new int[]{0, 1, 2}, new int[]{2, 3, 4}, new boolean[]{true, true, true});
        testArithmeticSubarrays(new int[]{100, 50, 75, 25}, new int[]{0, 1}, new int[]{2, 3}, new boolean[]{false, false});
        testArithmeticSubarrays(new int[]{15, 30, 45, 60}, new int[]{0, 0, 1}, new int[]{2, 3, 2}, new boolean[]{true, true, true});
    }

    /**
     * Method to test arithmetic subarrays.
     * @param nums The array of numbers.
     * @param l Array of start indices for subarrays.
     * @param r Array of end indices for subarrays.
     * @param expected Expected boolean results for each subarray.
     */
    public static void testArithmeticSubarrays(int[] nums, int[] l, int[] r, boolean[] expected) {
        List<Boolean> result = checkArithmeticSubarrays(nums, l, r);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("l: " + Arrays.toString(l));
        System.out.println("r: " + Arrays.toString(r));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Result: " + result);

        // Compare the actual and expected results
        boolean passed = true;
        for (int i = 0; i < expected.length; i++) {
            if (result.get(i) != expected[i]) {
                passed = false;
                break;
            }
        }
        System.out.println("Test passed: " + passed);
        System.out.println();
    }

    /**
     * Method to check if the subarrays form an arithmetic progression.
     * @param nums The array of numbers.
     * @param l Array of start indices for subarrays.
     * @param r Array of end indices for subarrays.
     * @return List of boolean values indicating whether each subarray forms an arithmetic progression.
     */
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int left = l[i], right = r[i];
            int[] subarray = Arrays.copyOfRange(nums, left, right + 1);
            result.add(isArithmeticProgression(subarray));
        }

        return result;
    }

    /**
     * Helper method to check if an array forms an arithmetic progression.
     * @param subarray The subarray to check.
     * @return true if the subarray forms an arithmetic progression, false otherwise.
     */
    private static boolean isArithmeticProgression(int[] subarray) {
        if (subarray.length < 2) {
            return true; // Single element or empty subarray is trivially an arithmetic progression.
        }

        Arrays.sort(subarray); // Sort the subarray to check differences between consecutive elements.
        int diff = subarray[1] - subarray[0]; // Calculate the common difference

        for (int i = 2; i < subarray.length; i++) {
            if (subarray[i] - subarray[i - 1] != diff) {
                return false; // If any difference does not match the common difference, it's not an arithmetic progression.
            }
        }

        return true;
    }
}
