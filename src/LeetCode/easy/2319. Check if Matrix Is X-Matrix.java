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
        // Test cases
        int[][] grid1 = {{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
        int[][] grid2 = {{2, 0, 0}, {0, 2, 0}, {0, 0, 2}};
        int[][] grid3 = {{1, 0, 0, 0}, {0, 2, 0, 0}, {0, 0, 3, 0}, {0, 0, 0, 4}};

        // Check if Grid 1 is an X-Matrix
        boolean isGrid1XMatrix = checkXMatrix(grid1);
        System.out.println("Grid 1 is X-Matrix: " + isGrid1XMatrix); // Expect true

        // Check if Grid 2 is an X-Matrix
        boolean isGrid2XMatrix = checkXMatrix(grid2);
        System.out.println("Grid 2 is X-Matrix: " + isGrid2XMatrix); // Expect false

        // Check if Grid 3 is an X-Matrix
        boolean isGrid3XMatrix = checkXMatrix(grid3);
        System.out.println("Grid 3 is X-Matrix: " + isGrid3XMatrix); // Expect false
    }

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
