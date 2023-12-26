/**
2215. Find the Difference of Two Arrays
Easy

Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.


Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
Example 2:

Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].


Constraints:

1 <= nums1.length, nums2.length <= 1000
-1000 <= nums1[i], nums2[i] <= 1000
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDifferenceOfTwoArrays {

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> result1 = findDifference(nums1, nums2);
        System.out.println("Test Case 1 - nums1: " + Arrays.toString(nums1) + ", nums2: " + Arrays.toString(nums2));
        System.out.println("Expected result: [[1, 3], [4, 6]]");
        System.out.println("Actual result: " + result1);
        System.out.println("Result matches expected: " + result1.equals(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(4, 6))));
        System.out.println();

        // Test Case 2
        int[] nums3 = {1, 2, 3, 3};
        int[] nums4 = {1, 1, 2, 2};
        List<List<Integer>> result2 = findDifference(nums3, nums4);
        System.out.println("Test Case 2 - nums1: " + Arrays.toString(nums3) + ", nums2: " + Arrays.toString(nums4));
        System.out.println("Expected result: [[3], []]");
        System.out.println("Actual result: " + result2);
        System.out.println("Result matches expected: " + result2.equals(Arrays.asList(Arrays.asList(3), new ArrayList<>())));
    }

    /**
     * Algorithm Steps:
     * 1. Create two lists, differencesInNums1 and differencesInNums2, to store the differences in nums1 and nums2.
     * 2. Iterate over each element num in nums1.
     *    - Check if num is not present in nums2 and is not already in differencesInNums1.
     *    - If true, add num to differencesInNums1.
     * 3. Iterate over each element num in nums2.
     *    - Check if num is not present in nums1 and is not already in differencesInNums2.
     *    - If true, add num to differencesInNums2.
     * 4. Create a list of lists, listOfLists, and add differencesInNums1 as the first element and
     *    differencesInNums2 as the second element.
     * 5. Return listOfLists as the final result.
     *
     * Time Complexity: O(m + n), where m and n are the lengths of nums1 and nums2, respectively.
     *    - The algorithm iterates over each element of nums1 and nums2 once.
     * Space Complexity: O(m + n), where m and n are the lengths of nums1 and nums2, respectively.
     *    - Additional space is used to store the lists differencesInNums1 and differencesInNums2.
     */
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        List<Integer> differencesInNums1 = new ArrayList<>();
        List<Integer> differencesInNums2 = new ArrayList<>();

        for (int num : nums1) {
            if (!isContain(nums2, num) && !differencesInNums1.contains(num)) {
                differencesInNums1.add(num);
            }
        }

        for (int num : nums2) {
            if (!isContain(nums1, num) && !differencesInNums2.contains(num)) {
                differencesInNums2.add(num);
            }
        }

        listOfLists.add(differencesInNums1);
        listOfLists.add(differencesInNums2);

        return listOfLists;
    }

    /**
     * Helper method to check if an array contains a specific element.
     *
     * @param arr   The array to search.
     * @param value The value to check for.
     * @return True if the array contains the value, false otherwise.
     */
    private static boolean isContain(int[] arr, int value) {
        for (int num : arr) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}
