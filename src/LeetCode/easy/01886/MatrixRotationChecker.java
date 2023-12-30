/*
1886. Determine Whether Matrix Can Be Obtained By Rotation
Easy
Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

Example 1:

Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
Example 2:


Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.
Example 3:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
 

Constraints:

n == mat.length == target.length
n == mat[i].length == target[i].length
1 <= n <= 10
mat[i][j] and target[i][j] are either 0 or 1.
*/


public class MatrixRotationChecker {

    public static void main2(String[] args) {
        int[][] matrix1 = {{0, 1}, {1, 0}};
        int[][] target1 = {{1, 0}, {0, 1}};
        System.out.println(findRotation(matrix1, target1)); // Expected output: true

        int[][] matrix2 = {{0, 1}, {1, 1}};
        int[][] target2 = {{1, 0}, {0, 1}};
        System.out.println(findRotation(matrix2, target2)); // Expected output: false

        int[][] matrix3 = {{0}};
        int[][] target3 = {{0}};
        System.out.println(findRotation(matrix3, target3)); // Expected output: true


        int[][] matrix4 = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] target4 = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(findRotation(matrix4, target4)); // Expected output: true
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{0, 1}, {1, 0}};
        int[][] target1 = {{1, 0}, {0, 1}};
        System.out.println(findRotation(matrix1, target1)); // Expected output: true
    }


    /**
     * Checks whether the target matrix can be obtained from the given matrix by rotating it in 90-degree increments.
     *
     * @param matrix The starting matrix
     * @param target The target matrix
     * @return True if the target matrix can be obtained by rotating the starting matrix, false otherwise
     */
    public static boolean findRotation(int[][] matrix, int[][] target) {
        int n = matrix.length;

        // Step 1: Check if the matrices are equal before rotation
        if (isEqual(matrix, target)) {
            return true;
        }

        // Step 2: Rotate the matrix 3 times and check for equality
        for (int i = 0; i < 3; i++) {
            rotateMatrixBy90Degrees(matrix);
            if (isEqual(matrix, target)) {
                return true;
            }
        }

        // Step 3: If no rotation is equal to the target matrix, return false
        return false;
    }

    /**
     * Checks whether two matrices are equal.
     *
     * @param matrix1 The first matrix
     * @param matrix2 The second matrix
     * @return True if the matrices are equal, false otherwise
     */
    private static boolean isEqual(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;

        // Handle the corner case of matrices with different sizes
        if (n != matrix2.length || matrix1[0].length != matrix2[0].length) {
            return false;
        }

        // Compare each element of the matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Rotates a square matrix by 90 degrees clockwise.
     *
     * @param matrix The matrix to be rotated
     */
    private static void rotateMatrixBy90Degrees(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            // Iterate over each element in the row up to the middle element
            for (int j = 0; j < n / 2; j++) {
                // Swap the element at the current position with the element at the opposite end of the row
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
