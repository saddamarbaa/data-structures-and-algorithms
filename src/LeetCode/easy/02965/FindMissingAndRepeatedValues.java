/*
2965. Find Missing and Repeated Values
Easy

You are given a 2D integer array grid of size n x n where each value grid[i][j] represents the value at cell (i, j) in the grid. The grid contains all integers from 1 to n^2 except for one missing number and one repeated number. Your task is to find the repeated number and the missing number.

Example 1:

Input: grid = [[1,3,2],[2,3,1],[3,1,2]]
Output: [3, 4]
Explanation: The repeated number is 3 and the missing number is 4.

Example 2:

Input: grid = [[1,2,2],[3,4,4],[5,6,6]]
Output: [2, 7]
Explanation: The repeated number is 2 and the missing number is 7.

Constraints:

- n == grid.length
- n == grid[i].length
- 1 <= n <= 100
- 1 <= grid[i][j] <= n^2
*/

import java.util.HashSet;
import java.util.Set;

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 3, 2}, {2, 3, 1}, {3, 1, 2}};
        int[] expected1 = {3, 4};
        int[] result1 = findMissingAndRepeatedValues(grid1);
        System.out.println("Test Case 1 - Input: " + java.util.Arrays.deepToString(grid1));
        System.out.println("Test Case 1 - Expected result: " + java.util.Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual result: " + java.util.Arrays.toString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + java.util.Arrays.equals(result1, expected1));

        int[][] grid2 = {{1, 2, 2}, {3, 4, 4}, {5, 6, 6}};
        int[] expected2 = {2, 7};
        int[] result2 = findMissingAndRepeatedValues(grid2);
        System.out.println("Test Case 2 - Input: " + java.util.Arrays.deepToString(grid2));
        System.out.println("Test Case 2 - Expected result: " + java.util.Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual result: " + java.util.Arrays.toString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + java.util.Arrays.equals(result2, expected2));
    }


    public int[] findMissingAndRepeatedValues5(int[][] grid)
    {
        // Step 1: Initialize the map array
        int n = grid.length;
        int[] map = new int[n * n + 1];
        int[] ans = new int[2];

        // Step 2: Traverse the grid to fill the map with occurrences of each number.
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                map[grid[i][j]]++;
            }
        }

        // Step 3: Check the map for the repeated and missing numbers.
        for(int i = 0; i < map.length; i++)
        {
            if(map[i] == 2)
            {
                ans[0] = i;  // Repeated number.
            }

            if(map[i] == 0)
            {
                ans[1] = i;  // Missing number.
            }
        }

        // Step 4: Return the result.
        return ans;
    }

    /**
     * Solution 1: Using HashSet to Track Repeated and Missing Numbers
     *
     * Algorithm Steps:
     * 1. Initialize a HashSet to keep track of seen numbers.
     * 2. Iterate through the grid and add each number to the HashSet.
     * 3. If a number is already in the HashSet, it is the repeated number.
     * 4. After processing the grid, iterate through the range [1, n^2] to find the missing number.
     *
     * Time Complexity: O(n^2), where n is the size of the grid.
     * Space Complexity: O(n^2), due to the HashSet.
     */
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Set<Integer> seen = new HashSet<>();
        int repeated = -1;
        int missing = -1;

        // Find the repeated number
        for (int[] row : grid) {
            for (int num : row) {
                if (seen.contains(num)) {
                    repeated = num;
                }
                seen.add(num);
            }
        }

        // Find the missing number
        for (int i = 1; i <= n * n; i++) {
            if (!seen.contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[]{repeated, missing};
    }

    /**
     * Solution 2: Using Array Counting
     *
     * Algorithm Steps:
     * 1. Initialize an array of size n^2 + 1 to count occurrences of each number.
     * 2. Iterate through the grid and count the occurrences of each number.
     * 3. The number with a count of 2 is the repeated number.
     * 4. The number with a count of 0 is the missing number.
     *
     * Time Complexity: O(n^2), where n is the size of the grid.
     * Space Complexity: O(n^2), due to the counting array.
     */
    public static int[] findMissingAndRepeatedValues2(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1];
        int repeated = -1;
        int missing = -1;

        // Count occurrences of each number
        for (int[] row : grid) {
            for (int num : row) {
                count[num]++;
            }
        }

        // Find the repeated and missing numbers
        for (int i = 1; i <= n * n; i++) {
            if (count[i] == 2) {
                repeated = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeated, missing};
    }

    /**
     * Solution 3: Using Mathematical Approach (Sum and Sum of Squares)
     *
     * Algorithm Steps:
     * 1. Calculate the sum and sum of squares of all numbers in the grid.
     * 2. Calculate the expected sum and sum of squares for the range [1, n^2].
     * 3. Use the difference between the actual and expected sums to find the repeated and missing numbers.
     *
     * Time Complexity: O(n^2), where n is the size of the grid.
     * Space Complexity: O(1), as we are using constant space.
     */
    public static int[] findMissingAndRepeatedValues3(int[][] grid) {
        int n = grid.length;
        long sum = 0;
        long sumSquares = 0;
        long expectedSum = (long) n * n * (n * n + 1) / 2;
        long expectedSumSquares = (long) n * n * (n * n + 1) * (2 * n * n + 1) / 6;

        // Calculate the actual sum and sum of squares
        for (int[] row : grid) {
            for (int num : row) {
                sum += num;
                sumSquares += (long) num * num;
            }
        }

        // Calculate the difference between expected and actual sums
        long diffSum = expectedSum - sum;
        long diffSumSquares = expectedSumSquares - sumSquares;

        // Solve for the repeated and missing numbers
        int missing = (int) ((diffSum + diffSumSquares / diffSum) / 2);
        int repeated = (int) (missing - diffSum);

        return new int[]{repeated, missing};
    }
}