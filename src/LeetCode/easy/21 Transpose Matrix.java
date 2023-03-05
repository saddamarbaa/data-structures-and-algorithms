/*
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

class MatrixTranspose {
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

    public static void main(String[] args) {
        // Test case 1: expected output is [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result1 = transpose(matrix1);
        System.out.println("Test case 1 result: " + Arrays.deepToString(result1));

        // Test case 2: expected output is [[1, 3, 5], [2, 4, 6]]
        int[][] matrix2 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result2 = transpose(matrix2);
        System.out.println("Test case 2 result: " + Arrays.deepToString(result2));

        // Test case 3: expected output is [[1]]
        int[][] matrix3 = {{1}};
        int[][] result3 = transpose(matrix3);
        System.out.println("Test case 3 result: " + Arrays.deepToString(result3));

        // Test case 4: expected output is [[1, 4], [2, 5], [3, 6]]
        int[][] matrix4 = {{1, 2, 3}, {4, 5, 6}};
        int[][] result4 = transpose(matrix4);
        System.out.println("Test case 4 result: " + Arrays.deepToString(result4));

        // Test case 5 (should fail): expected output is [[1, 4], [2, 5], [6, 3]]
        int[][] matrix5 = {{1, 2, 3}, {4, 5, 6}};
        int[][] result5 = transpose(matrix5);
        System.out.println("Test case 5 result: " + Arrays.deepToString(result5));
    }
}
