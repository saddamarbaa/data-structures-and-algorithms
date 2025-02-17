import java.util.*;

/**
 * 128. Longest Consecutive Sequence
 *
 * Hard
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *
 * Input: nums = [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Constraints:
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 */

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test Case 1 - Longest Consecutive Sequence: " + longestConsecutive(nums1)); // Expected: 4

        // Test Case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Test Case 2 - Longest Consecutive Sequence: " + longestConsecutive(nums2)); // Expected: 9

        // Test Case 3
        int[] nums3 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println("Test Case 3 - Longest Consecutive Sequence: " + longestConsecutive(nums3)); // Expected: 7

        // Test Case 4
        int[] nums4 = {};
        System.out.println("Test Case 4 - Longest Consecutive Sequence: " + longestConsecutive(nums4)); // Expected: 0
    }

    /**
     * Finds the length of the longest consecutive sequence in an unsorted array.
     *
     * Algorithm:
     * 1. Use a HashSet to store the unique elements of the array.
     * 2. Iterate through the array, and for each element, check if it's the start of a sequence.
     * 3. If it is the start (i.e., num - 1 is not in the set), count the length of the sequence.
     * 4. Track the maximum sequence length.
     *
     * Time Complexity: O(n), where n is the number of elements in the array.
     * Space Complexity: O(n), for storing the elements in the HashSet.
     *
     * @param nums - The input array of integers.
     * @return The length of the longest consecutive sequence.
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


    /**
     * Brute Force Approach (O(n^3) time complexity)
     * For each number, checks if all consecutive numbers exist in the array.
     */
    public static int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int longestStreak = 0;

        for (int num : nums) {
            int currentNum = num;
            int currentStreak = 1;

            // Keep checking if the next consecutive number exists
            while (contains(nums, currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }

    // Helper function for brute force approach to check if the array contains a number
    private static boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * Approach using Sorting (O(n log n) time complexity)
     * Sorts the array and then finds the longest consecutive sequence.
     */
    public static int longestConsecutive3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak++;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}
