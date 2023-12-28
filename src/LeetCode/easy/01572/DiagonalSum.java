/*
1572. Matrix Diagonal Sum
Easy

Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

 
Example 1:


Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
Example 2:

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8
Example 3:

Input: mat = [[5]]
Output: 5
 

Constraints:

n == mat.length == mat[i].length
1 <= n <= 100
1 <= mat[i][j] <= 100
*/


import java.util.Arrays;

public class DiagonalSum {

    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] mat2 = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        int[][] mat3 = {
                {5}
        };

        printResult(mat1.length, mat1[0].length, mat1, diagonalSum(mat1), 25);
        printResult(mat2.length, mat2[0].length, mat2, diagonalSum(mat2), 8);
        printResult(mat3.length, mat3[0].length, mat3, diagonalSum(mat3), 5);
    }

    public static int diagonalSum(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int primaryValue = matrix[i][i];
            int secondaryValue = matrix[i][n - i - 1];

            if (n - i - 1 == i) {
                // If we're at the intersection of the diagonals, add only the primary value.
                sum += primaryValue;
            } else {
                // Otherwise, add both the primary and secondary values.
                sum += primaryValue + secondaryValue;
            }
        }

        return sum;
    }


    public int diagonalSum2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Check if the element is on either diagonal
                if (i + j == rows - 1 || i == j) {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }

    // Helper method to print test results
    private static void printResult(int m, int n, int[][] indices, int result, int expected) {
        System.out.println("Matrix Dimensions: " + m + " x " + n);
        System.out.println("Indices: " + Arrays.deepToString(indices));
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        System.out.println("Result matches expected: " + (result == expected));
        System.out.println();
    }
}
