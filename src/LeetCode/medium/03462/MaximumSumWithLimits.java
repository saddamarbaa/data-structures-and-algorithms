import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 3462. Maximum Sum With at Most K Elements
 * Medium
 * You are given a 2D integer matrix grid of size n x m, an integer array limits of length n, and an integer k. The task is to find the maximum sum of at most k elements from the matrix grid such that:
 * The number of elements taken from the ith row of grid does not exceed limits[i].
 * Return the maximum sum.
 *
 * Example 1:
 * Input: grid = [[1,2],[3,4]], limits = [1,2], k = 2
 * Output: 7
 * Explanation:
 * From the second row, we can take at most 2 elements. The elements taken are 4 and 3.
 * The maximum possible sum of at most 2 selected elements is 4 + 3 = 7.
 *
 * Example 2:
 * Input: grid = [[5,3,7],[8,2,6]], limits = [2,2], k = 3
 * Output: 21
 * Explanation:
 * From the first row, we can take at most 2 elements. The element taken is 7.
 * From the second row, we can take at most 2 elements. The elements taken are 8 and 6.
 * The maximum possible sum of at most 3 selected elements is 7 + 8 + 6 = 21.
 *
 * Constraints:
 * n == grid.length == limits.length
 * m == grid[i].length
 * 1 <= n, m <= 500
 * 0 <= grid[i][j] <= 10^5
 * 0 <= limits[i] <= m
 * 0 <= k <= min(n * m, sum(limits))
 */
public class MaximumSumWithLimits {
    public static void main(String[] args) {
        // Test Case 1
        int[][] grid1 = {{1, 2}, {3, 4}};
        int[] limits1 = {1, 2};
        int k1 = 2;
        int expected1 = 7;
        runTestCase(grid1, limits1, k1, expected1);

        // Test Case 2
        int[][] grid2 = {{5, 3, 7}, {8, 2, 6}};
        int[] limits2 = {2, 2};
        int k2 = 3;
        int expected2 = 21;
        runTestCase(grid2, limits2, k2, expected2);
    }

    private static void runTestCase(int[][] grid, int[] limits, int k, int expected) {
        int result1 = maximumSumWithLimits(grid, limits, k);
        int result2 = maximumSumWithLimits2(grid, limits, k);
        int result3 = maximumSumWithLimits3(grid, limits, k);
        System.out.println("Input: grid = " + Arrays.deepToString(grid) + ", limits = " + Arrays.toString(limits) + ", k = " + k);
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Greedy Approach): " + result1);
        System.out.println("Result (Dynamic Programming): " + result2);
        System.out.println("Result (Brute Force): " + result3);
        System.out.println("All results match expected: " +
                (result1 == expected && result2 == expected && result3 == expected));
        System.out.println();
    }


    public long maximumSumWithLimits4(int[][] grid, int[] limits, int k) {
        long sum = 0;  // Use 'long' instead of 'int'
        ArrayList<Integer> possibleNumbers = new ArrayList<>();

        // Step 1: Traverse each row in the grid
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];

            // Step 2: Find the 'limits[i]' largest elements from the row
            // Sort the row in ascending order
            Arrays.sort(row);

            // Add only the largest 'limits[i]' elements from the row to the list
            int n = row.length;
            for (int j = n - 1; j >= n - limits[i]; j--) {
                possibleNumbers.add(row[j]);
            }
        }

        // Step 3: Sort all collected numbers in descending order
        Collections.sort(possibleNumbers, Collections.reverseOrder());

        // Step 4: Take the top 'k' elements and calculate their sum
        for (int i = 0; i < Math.min(k, possibleNumbers.size()); i++) {
            sum += possibleNumbers.get(i);  // Sum up the top 'k' elements
        }

        return sum;  // Return the sum as a long
    }

    /**
     * Approach 1: Greedy Approach (Optimized)
     *
     * Algorithm Steps:
     * 1. Sort each row in descending order.
     * 2. Use a priority queue (max-heap) to keep track of the top k elements across all rows.
     * 3. For each row, add up to `limits[i]` elements to the priority queue.
     * 4. Sum the top k elements from the priority queue.
     * 5. Return the result.
     *
     * Time Complexity: O(n * m log m + k log k), where n is the number of rows, m is the number of columns.
     * Space Complexity: O(k), for the priority queue.
     */
    public static int maximumSumWithLimits(int[][] grid, int[] limits, int k) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            Arrays.sort(grid[i]);
            for (int j = m - 1; j >= m - limits[i] && j >= 0; j--) {
                maxHeap.offer(grid[i][j]);
            }
        }

        int sum = 0;
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            sum += maxHeap.poll();
        }

        return sum;
    }

    /**
     * Approach 2: Dynamic Programming
     *
     * Algorithm Steps:
     * 1. Sort each row in descending order.
     * 2. Use a DP array to store the maximum sum for each possible number of elements (up to k).
     * 3. For each row, update the DP array by considering the top `limits[i]` elements.
     * 4. Return the maximum sum from the DP array.
     *
     * Time Complexity: O(n * m log m + n * k), where n is the number of rows, m is the number of columns.
     * Space Complexity: O(k), for the DP array.
     */
    public static int maximumSumWithLimits2(int[][] grid, int[] limits, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.sort(grid[i]);
            int[] currentRow = new int[limits[i] + 1];
            for (int j = 0; j < limits[i]; j++) {
                currentRow[j + 1] = currentRow[j] + grid[i][m - 1 - j];
            }

            for (int j = k; j >= 0; j--) {
                for (int l = 0; l <= limits[i] && j + l <= k; l++) {
                    dp[j + l] = Math.max(dp[j + l], dp[j] + currentRow[l]);
                }
            }
        }

        return dp[k];
    }

    /**
     * Approach 3: Brute Force
     *
     * Algorithm Steps:
     * 1. Sort each row in descending order.
     * 2. Use backtracking to explore all possible combinations of elements from each row, respecting the limits.
     * 3. Track the maximum sum of at most k elements.
     * 4. Return the result.
     *
     * Time Complexity: O(n * m log m + n^k), where n is the number of rows, m is the number of columns.
     * Space Complexity: O(k), for the recursion stack.
     */
    public static int maximumSumWithLimits3(int[][] grid, int[] limits, int k) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            Arrays.sort(grid[i]);
        }
        return backtrack(grid, limits, k, 0, 0);
    }

    private static int backtrack(int[][] grid, int[] limits, int k, int row, int count) {
        if (row == grid.length || count == k) {
            return 0;
        }

        int maxSum = 0;
        for (int i = 0; i <= limits[row] && i <= k - count; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += grid[row][grid[row].length - 1 - j];
            }
            maxSum = Math.max(maxSum, sum + backtrack(grid, limits, k, row + 1, count + i));
        }

        return maxSum;
    }
}