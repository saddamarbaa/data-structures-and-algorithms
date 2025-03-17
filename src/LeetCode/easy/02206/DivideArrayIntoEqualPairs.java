import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 2206. Divide Array Into Equal Pairs
 * Easy
 *
 * You are given an integer array nums consisting of 2 * n integers.
 * You need to divide nums into n pairs such that:
 * - Each element belongs to exactly one pair.
 * - The elements present in a pair are equal.
 *
 * Return true if nums can be divided into such pairs, otherwise return false.
 *
 * Example 1:
 * Input: nums = [3,2,3,2,2,2]
 * Output: true
 * Explanation:
 * There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
 * If nums is divided into the pairs (2, 2), (2, 2), and (3, 3), it satisfies all the conditions.
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation:
 * There is no way to divide nums into pairs such that the elements in each pair are equal.
 *
 * Constraints:
 * nums.length == 2 * n
 * 1 <= n <= 500
 * 1 <= nums[i] <= 500
 */
public class DivideArrayIntoEqualPairs {
    public static void main(String[] args) {
        // Test Cases
        runTestCase(new int[]{3, 2, 3, 2, 2, 2}, true);
        runTestCase(new int[]{1, 2, 3, 4}, false);
        runTestCase(new int[]{1, 1, 2, 2}, true);
        runTestCase(new int[]{5, 5, 5, 5, 5, 5}, true);
        runTestCase(new int[]{10, 10, 10, 10, 20, 20}, true);
        runTestCase(new int[]{10, 10, 10, 20, 20, 30}, false);
    }

    // Method to run each test case
    public static void runTestCase(int[] nums, boolean expected) {
        boolean result1 = divideArray(nums);
        boolean result2 = divideArray2(nums);
        boolean result3 = divideArray3(nums);

        System.out.println("Test Case - Input: nums = " + java.util.Arrays.toString(nums));
        System.out.println("Expected result: " + expected);
        System.out.println("Result (HashMap): " + result1);
        System.out.println("Result (HashSet): " + result2);
        System.out.println("Result (Brute Force): " + result3);
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected && result3 == expected));
        System.out.println();
    }

    /**
     * Approach 1: HashMap (Count Frequencies)
     *
     * Algorithm Steps:
     * 1. Use a HashMap to count the frequency of each number in the array.
     * 2. Check if all frequencies are even.
     * 3. If all frequencies are even, return true; otherwise, return false.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(n), for the HashMap storing frequencies.
     */
    public static boolean divideArray(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (int count : frequencyMap.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 2: HashSet (Track Pairs)
     *
     * Algorithm Steps:
     * 1. Use a HashSet to track numbers that have been seen an odd number of times.
     * 2. Iterate through the array, and for each number, toggle its presence in the HashSet.
     * 3. If the HashSet is empty at the end, all numbers can be paired; otherwise, they cannot.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(n), for the HashSet storing numbers.
     */
    public static boolean divideArray2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.isEmpty();
    }

    /**
     * Approach 3: Brute Force (Check All Pairs)
     *
     * Algorithm Steps:
     * 1. Sort the array.
     * 2. Iterate through the array in steps of 2 and check if adjacent elements are equal.
     * 3. If all adjacent pairs are equal, return true; otherwise, return false.
     *
     * Time Complexity: O(n log n), due to sorting.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static boolean divideArray3(int[] nums) {
        java.util.Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}