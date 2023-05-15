/*
1351. Count Negative Numbers in a Sorted Matrix
Easy
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of
 negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
 */


import java.util.Arrays;

public class CountNegatives {
    public static void main(String[] args) {


        // Test case 1
        int[][] grid1 = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        int expected1 = 8;
        int result1 = countNegatives(grid1);
        System.out.println("Test Case 1 - Input: " + Arrays.deepToString(grid1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2
        int[][] grid2 = {{3, 2}, {1, 0}};
        int expected2 = 0;
        int result2 = countNegatives(grid2);
        System.out.println("Test Case 2 - Input: " + Arrays.deepToString(grid2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));
    }


    /**
     * 1. Initialize a count variable to 0.
     * 2. Loop through each row of the input matrix.
     * 3. For each row, perform a binary search to find the index of the first negative number in the row.
     * 4. If the binary search returns a non-negative index, increment the count by the number of negative numbers in
     * the row (which is the number of elements in the row minus the index of the first negative number).
     * 5. Return the count.
     * Time Complexity: The time complexity of your function is O(m log n), where m is the number of rows and n is
     * the number of columns in the input matrix. This is because for each row, you perform a binary search that
     * takes O(log n) time, and you do this for all m rows.
     * Space Complexity: The space complexity of your function is O(1), because you only use a constant amount of
     * additional space (the count variable and the loop counters).
     */
    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int index = binarySearch(grid[i]);
            if (index >= 0) {
                count += grid[i].length - index;
            }
        }
        return count;
    }

    public static int binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}