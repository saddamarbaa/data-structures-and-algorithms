/*
2319. Check if Matrix Is X-Matrix
Easy
A square matrix is said to be an X-Matrix if both of the following conditions hold:

All the elements in the diagonals of the matrix are non-zero.
All other elements are 0.
Given a 2D integer array grid of size n x n representing a square matrix, return true if grid is an X-Matrix. Otherwise, return false.

Example 1:

Input: grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
Output: true
Explanation: Refer to the diagram above. 
An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
Thus, grid is an X-Matrix.
Example 2:


Input: grid = [[5,7,0],[0,3,1],[0,5,0]]
Output: false
Explanation: Refer to the diagram above.
An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
Thus, grid is not an X-Matrix.
 

Constraints:

n == grid.length == grid[i].length
3 <= n <= 100
0 <= grid[i][j] <= 105
*/


import java.util.Arrays;

public class XMatrixChecker  {
    public static void main(String[] args) {
         // Test Case 1 - Valid X-Matrix
        int[][] matrix1 = {
                {5, 0, 0, 1},
                {0, 4, 2, 0},
                {0, 3, 3, 0},
                {2, 0, 0, 4}
        };
        boolean expected1 = true;
        boolean result1 = checkXMatrix(matrix1);
        System.out.println("Test Case 1 - Input: " + Arrays.deepToString(matrix1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test Case 2 - Invalid X-Matrix (non-diagonal element is non-zero)
        int[][] matrix2 = {
                {5, 0, 1},
                {0, 4, 0},
                {1, 0, 3}
        };
        boolean expected2 = false;
        boolean result2 = checkXMatrix(matrix2);
        System.out.println("Test Case 2 - Input: " + Arrays.deepToString(matrix2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test Case 3 - Valid X-Matrix (single element)
        int[][] matrix3 = {
                {1}
        };
        boolean expected3 = true;
        boolean result3 = checkXMatrix(matrix3);
        System.out.println("Test Case 3 - Input: " + Arrays.deepToString(matrix3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test Case 4 - Invalid X-Matrix (diagonal element is zero)
        int[][] matrix4 = {
                {5, 0, 0},
                {0, 0, 0},
                {0, 0, 5}
        };
        boolean expected4 = false;
        boolean result4 = checkXMatrix(matrix4);
        System.out.println("Test Case 4 - Input: " + Arrays.deepToString(matrix4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));
    }


    /**
     * Algorithm:
     * 1. Traverse the matrix, check each element for its position.
     * 2. If the element is on the primary diagonal (i == j) or secondary diagonal (i + j == n - 1),
     *    ensure it's non-zero.
     * 3. If the element is not on a diagonal, ensure it is zero.
     * 4. If all conditions hold, return true; otherwise, return false.
     *
     * Time Complexity: O(n^2)
     * - We check every element in an n x n matrix, so the time complexity is O(n^2).
     *
     * Space Complexity: O(1)
     * - We use only constant space to store variables like `n` and the loop indices `i` and `j`.
     * - No additional space is required except for the input matrix.
     *
     * @param grid The input square matrix.
     * @return true if the matrix is an X-Matrix, otherwise false.
     */

    public static boolean checkXMatrix(int[][] grid) {
        int n = grid.length;

        // Check the diagonals of the matrix
        for (int i = 0; i < n; i++) {
            int primaryValue = grid[i][i];
            int secondaryValue = grid[i][n - i - 1];

            // If either diagonal value is 0, it's not an X-Matrix
            if (primaryValue == 0 || secondaryValue == 0) {
                return false;
            } else {
                // Replace diagonal values with 0
                grid[i][i] = 0;
                grid[i][n - i - 1] = 0;
            }
        }

        // Check if all other elements are 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    return false;  // Not an X-Matrix
                }
            }
        }


        return true;  // All conditions passed, it's an X-Matrix
    }
}
