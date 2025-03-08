/***
 2379. Minimum Recolors to Get K Consecutive Black Blocks
 Easy
 Hint
 You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.

 You are also given an integer k, which is the desired number of consecutive black blocks.

 In one operation, you can recolor a white block such that it becomes a black block.

 Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.



 Example 1:

 Input: blocks = "WBBWWBBWBW", k = 7
 Output: 3
 Explanation:
 One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
 so that blocks = "BBBBBBBWBW".
 It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
 Therefore, we return 3.
 Example 2:

 Input: blocks = "WBWBBBW", k = 2
 Output: 0
 Explanation:
 No changes need to be made, since 2 consecutive black blocks already exist.
 Therefore, we return 0.


 Constraints:

 n == blocks.length
 1 <= n <= 100
 blocks[i] is either 'W' or 'B'.
 1 <= k <= n
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static void main(String[] args) {
        // Test Case 1
        String blocks1 = "WBBWWBBWBW";
        int k1 = 7;
        int expected1 = 3;
        int result1 = minimumRecolors(blocks1, k1);
        int result2 = minimumRecolors2(blocks1, k1);
        int result3 = minimumRecolors3(blocks1, k1);
        System.out.println("Test Case 1 - Input: blocks = \"" + blocks1 + "\", k = " + k1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Result (Sliding Window): " + result1);
        System.out.println("Test Case 1 - Result (Prefix Sum): " + result2);
        System.out.println("Test Case 1 - Result (Brute Force): " + result3);
        System.out.println("Test Case 1 - All results match expected: " +
                (result1 == expected1 && result2 == expected1 && result3 == expected1));

        // Test Case 2
        String blocks2 = "WBWBBBW";
        int k2 = 2;
        int expected2 = 0;
        int result4 = minimumRecolors(blocks2, k2);
        int result5 = minimumRecolors2(blocks2, k2);
        int result6 = minimumRecolors3(blocks2, k2);
        System.out.println("Test Case 2 - Input: blocks = \"" + blocks2 + "\", k = " + k2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Result (Sliding Window): " + result4);
        System.out.println("Test Case 2 - Result (Prefix Sum): " + result5);
        System.out.println("Test Case 2 - Result (Brute Force): " + result6);
        System.out.println("Test Case 2 - All results match expected: " +
                (result4 == expected2 && result5 == expected2 && result6 == expected2));
    }

    /**
     * Approach 1: Sliding Window (Optimized)
     *
     * Algorithm Steps:
     * 1. Initialize `minRecolors` to track the minimum number of white blocks in any window.
     * 2. Use a sliding window of size `k` to traverse the string.
     * 3. For each window, count the number of white blocks (`'W'`).
     * 4. Update `minRecolors` with the minimum count of white blocks.
     * 5. Slide the window by removing the leftmost block and adding the next block.
     * 6. Return the result.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minRecolors = Integer.MAX_VALUE;
        int whiteCount = 0;

        for (int i = 0; i < n; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }

            if (i >= k - 1) {
                minRecolors = Math.min(minRecolors, whiteCount);
                if (blocks.charAt(i - (k - 1)) == 'W') {
                    whiteCount--;
                }
            }
        }

        return minRecolors == Integer.MAX_VALUE ? 0 : minRecolors;
    }

    /**
     * Approach 2: Prefix Sum
     *
     * Algorithm Steps:
     * 1. Create a prefix sum array to store the cumulative count of white blocks up to each index.
     * 2. Traverse the string and populate the prefix sum array.
     * 3. Use the prefix sum array to calculate the number of white blocks in any window of size `k`.
     * 4. Track the minimum number of white blocks across all windows.
     * 5. Return the result.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(n), for the prefix sum array.
     */
    public static int minimumRecolors2(String blocks, int k) {
        int n = blocks.length();
        int[] prefixSum = new int[n + 1];
        int minRecolors = Integer.MAX_VALUE;

        // Compute prefix sum of white blocks
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (blocks.charAt(i) == 'W' ? 1 : 0);
        }

        // Find the minimum white blocks in any window of size k
        for (int i = k; i <= n; i++) {
            minRecolors = Math.min(minRecolors, prefixSum[i] - prefixSum[i - k]);
        }

        return minRecolors == Integer.MAX_VALUE ? 0 : minRecolors;
    }

    /**
     * Approach 3: Brute Force
     *
     * Algorithm Steps:
     * 1. Traverse the string and consider every possible window of size `k`.
     * 2. For each window, count the number of white blocks (`'W'`).
     * 3. Track the minimum number of white blocks across all windows.
     * 4. Return the result.
     *
     * Time Complexity: O(n * k), where n is the length of the string and k is the window size.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int minimumRecolors3(String blocks, int k) {
        int n = blocks.length();
        int minRecolors = Integer.MAX_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int whiteCount = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    whiteCount++;
                }
            }
            minRecolors = Math.min(minRecolors, whiteCount);
        }

        return minRecolors == Integer.MAX_VALUE ? 0 : minRecolors;
    }
}