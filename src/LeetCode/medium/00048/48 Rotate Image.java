/*
 48. Rotate Image
Medium
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */

public class RotateMatrix {
    
    public static void main(String[] args) {
        // Test case 1: Rotate a 2x2 matrix
        int[][] matrix1 = {{1, 2}, {3, 4}};
        rotate(matrix1);
        printMatrix(matrix1);
        // Expected output: {{3, 1}, {4, 2}}

        // Test case 2: Rotate a 3x3 matrix
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix2);
        printMatrix(matrix2);
        // Expected output: {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}

        // Test case 3: Rotate a 4x4 matrix
        int[][] matrix3 = {{ 5,  1,  9, 11},
                           { 2,  4,  8, 10},
                           {13,  3,  6,  7},
                           {15, 14, 12, 16}};
        rotate(matrix3);
        printMatrix(matrix3);
        // Expected output: {{15, 13,  2,  5}, {14,  3,  4,  1},
        //                   {12,  6,  8,  9}, {16,  7, 10, 11}}
    }
    
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap element at position (i, j) with (j, i)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row of the transposed matrix
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                // Swap element at position (i, left) with (i, right)
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
