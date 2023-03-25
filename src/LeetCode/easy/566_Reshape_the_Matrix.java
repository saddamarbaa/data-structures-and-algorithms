/*
566. Reshape the Matrix
Easy

In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:

Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
Example 2:


Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
-1000 <= mat[i][j] <= 1000
1 <= r, c <= 300
*/

import java.util.Arrays;

public class MatrixReshape{
    public static void main(String[] args) {
        // Test case 1: 2x2 matrix to 1x4 matrix
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] expected1 = {{1, 2, 3, 4}};
        int[][] result1 = matrixReshape(matrix1, 1, 4);
        System.out.println("Test case 1: " + Arrays.deepEquals(result1, expected1)); // prints true

        // Test case 2: 2x2 matrix to 4x1 matrix
        int[][] matrix2 = {{1, 2}, {3, 4}};
        int[][] expected2 = {{1}, {2}, {3}, {4}};
        int[][] result2 = matrixReshape(matrix2, 4, 1);
        System.out.println("Test case 2: " + Arrays.deepEquals(result2, expected2)); // prints true

        // Test case 3: 3x3 matrix to 9x1 matrix
        int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected3 = {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}};
        int[][] result3 = matrixReshape(matrix3, 9, 1);
        System.out.println("Test case 3: " + Arrays.deepEquals(result3, expected3)); // prints true

        // Test case 4: 3x3 matrix to 1x9 matrix
        int[][] matrix4 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected4 = {{1, 2, 3, 4, 5, 6, 7, 8, 9}};
        int[][] result4 = matrixReshape(matrix4, 1, 9);
        System.out.println("Test case 4: " + Arrays.deepEquals(result4, expected4)); // prints true

        // Test case 5: 2x2 matrix to 2x2 matrix
        int[][] matrix5 = {{1, 2}, {3, 4}};
        int[][] expected5 = {{1, 2}, {3, 4}};
        int[][] result5 = matrixReshape(matrix5, 2, 2);
        System.out.println("Test case 5: " + Arrays.deepEquals(result5, expected5)); // prints true

        // Test case 6: 3x3 matrix to 3x3 matrix
        int[][] matrix6 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected6 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result6 = matrixReshape(matrix6, 3, 3);
        System.out.println("Test case 6: " + Arrays.deepEquals(result6, expected6)); // prints true

        // Test case 7: 2x3 matrix to 3x2 matrix
        int[][] matrix7 = {{1, 2, 3}, {4, 5, 6}};
        int[][] expected7 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result7 = matrixReshape(matrix7, 3, 2);
        System.out.println("Test case 7: " + Arrays.deepEquals(result7, expected7)); // prints true


        // Test case 8: reshape 5x5 matrix to 1x25 matrix
        int[][] matrix8 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] expected8 = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}
        };
        int[][] result8 = matrixReshape(matrix8, 1, 25);
        System.out.println("Test case 8: " + Arrays.deepEquals(expected8, result8)); // expected true


// Test case 9: reshape 6x6 matrix to 3x12 matrix
        int[][] matrix9 = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };
        int[][] expected9 = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36}
        };
        int[][] result9 = matrixReshape(matrix9, 3, 12);
        System.out.println("Test case 9: " + Arrays.deepEquals(expected9, result9)); // expected true


// Test case 10: reshape 10x10 matrix to 50x2 matrix
        int[][] matrix10 = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix10[i][j] = i * 10 + j;
            }
        }
        int[][] expected10 = new int[50][2];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 2; j++) {
                expected10[i][j] = i * 2 + j;
            }
        }
        int[][] result10 = matrixReshape(matrix10, 50, 2);
        System.out.println("Test case 10: " + Arrays.deepEquals(expected10, result10)); // expected true


    }


    /**
     * Reshapes the input matrix into a matrix of desired number of rows and columns
     * <p>
     * Algorithm steps:
     * 1. Get the current number of rows and columns in the matrix.
     * 2. If the number of elements in the matrix does not match the new shape, return the original matrix.
     * 3. Create a new empty matrix with the desired shape.
     * 4. Iterate over the elements of the new matrix and fill them with values from the original matrix.
     * 5. Return the new matrix.
     * <p>
     * Time Complexity: O(m*n), where m is the number of rows and n is the number of columns of the matrix.
     * Space Complexity: O(m*n).
     *
     * @param matrix  2D integer array to be reshaped
     * @param newRows number of rows in the new matrix
     * @param newCols number of columns in the new matrix
     * @return reshaped matrix with the desired number of rows and columns
     */
    public static int[][] matrixReshape(int[][] matrix, int newRows, int newCols) {
        // Get the current number of rows and columns in the matrix
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        // If the number of elements in the matrix does not match the new shape, return the original matrix
        if ((newRows == rowLength && newCols == colLength) || (rowLength * colLength != newRows * newCols)) {
            return matrix;
        }

        // Create a new empty matrix with the desired shape
        int[][] newMatrix = new int[newRows][newCols];

        // Iterate over the elements of the original matrix and assign them to the new matrix
        int rowIdx = 0;
        int colIdx = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                // Assign the current element of the original matrix to the corresponding index in the new matrix
                newMatrix[rowIdx][colIdx] = matrix[i][j];
                colIdx++;

                // Check if we have reached the end of the current row in the new matrix
                if (colIdx == newCols) {
                    colIdx = 0;
                    rowIdx++;
                }
            }
        }

        return newMatrix;
    }


    /**
     * Reshapes the input matrix into a matrix of desired number of rows and columns
     * <p>
     * Algorithm steps:
     * 1. Get the current number of rows and columns in the matrix.
     * 2. If the number of elements in the matrix does not match the new shape, return the original matrix.
     * 3. Create a new empty matrix with the desired shape.
     * 4. Flatten the original matrix into a one-dimensional array.
     * 5. Iterate over the elements of the new matrix and fill them with values from the flattened matrix.
     * 6. Return the new matrix.
     * <p>
     * Time Complexity: O(m*n), where m is the number of rows and n is the number of columns of the matrix.
     * Space Complexity: O(m*n).
     *
     * @param matrix  2D integer array to be reshaped
     * @param newRows number of rows in the new matrix
     * @param newCols number of columns in the new matrix
     * @return reshaped matrix with the desired number of rows and columns
     */
    public static int[][] matrixReshape2(int[][] matrix, int newRows, int newCols) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        // If the number of elements in the matrix does not match the new shape, return the original matrix
        if ((newRows == rowLength && newCols == colLength) || (rowLength * colLength != newRows * newCols)) {
            return matrix;
        }

        // Create a new empty matrix with the desired shape
        int[][] newMatrix = new int[newRows][newCols];

        // Flatten the original matrix into a one-dimensional array
        int[] flattenedMatrix = new int[rowLength * colLength];
        int index = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                flattenedMatrix[index++] = matrix[i][j];
            }
        }

        // Iterate over the elements of the new matrix and fill them with values from the flattened matrix
        index = 0;
        for (int i = 0; i < newRows; i++) {
            for (int j = 0; j < newCols; j++) {
                newMatrix[i][j] = flattenedMatrix[index++];
            }
        }

        return newMatrix;
    }
}
