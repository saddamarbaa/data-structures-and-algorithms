/**
 867. Transpose Matrix
 Easy
 Given a 2D integer array matrix, return the transpose of matrix.

 The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 

 Example 1:

 Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 Output: [[1,4,7],[2,5,8],[3,6,9]]
 Example 2:

 Input: matrix = [[1,2,3],[4,5,6]]
 Output: [[1,4],[2,5],[3,6]]


 Constraints:

 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 1000
 1 <= m * n <= 105
 -109 <= matrix[i][j] <= 109
 */

import java.util.Arrays;

public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}};

        // Test cases
        int[][] result1 = transpose(matrix1);
        int[][] result2 = transpose(matrix2);

        // Print results
        printMatrix(matrix1,result1); // Output: [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
        printMatrix(matrix2, result2); // Output: [[1, 4], [2, 5], [3, 6]]
    }


    /**
     * Algorithm Steps:
     * 1. Initialize variables for the number of rows (m) and columns (n) in the input matrix.
     * 2. Create a new matrix 'result' with dimensions n x m to store the transpose.
     * 3. Iterate over each element in the input matrix using nested loops.
     *    a. Place the element at matrix[i][j] in the result matrix at result[j][i].
     * 4. Return the transposed matrix 'result'.
     *
     * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns.
     *   - We visit each element once while iterating over the input matrix.
     * Space Complexity: O(m * n), as we create a new matrix to store the transposed result.
     *   - The space required is proportional to the number of elements in the input matrix.
     */
    public static int[][] transpose(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[][] transposedMatrix = new int[numCols][numRows];

        // Iterate through each element in the matrix and place it in the correct position in the transposed matrix
        for (int row = 0; row < numCols; row++) {
            for (int col = 0; col < numRows; col++) {
                transposedMatrix[row][col] = matrix[col][row];
            }
        }

        return transposedMatrix;
    }

    /**
     * Helper method to print test results for the transposeMatrix function.
     */
    public static void  printMatrix(int[][] matrix, int[][] result) {
        System.out.println("Input Matrix: " + Arrays.deepToString(matrix));
        System.out.println("Transposed Matrix: " + Arrays.deepToString(result));
        System.out.println();
    }
}
