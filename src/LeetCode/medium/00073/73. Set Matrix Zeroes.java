/*
73. Set Matrix Zeroes
Medium
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    public static void main(String[] args) {
        // Test case 1 - empty matrix
        int[][] input1 = {{}};
        int[][] expected1 = {{}};
        setZeroes(input1);
        System.out.println("Test Case 1 - Input: " + Arrays.deepToString(input1));
        System.out.println("Test Case 1 - Expected result: " + Arrays.deepToString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.deepToString(input1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.deepEquals(expected1, input1));

        // Test case 2 - 1x1 matrix with 0
        int[][] input2 = {{0}};
        int[][] expected2 = {{0}};
        setZeroes(input2);
        System.out.println("Test Case 2 - Input: " + Arrays.deepToString(input2));
        System.out.println("Test Case 2 - Expected result: " + Arrays.deepToString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.deepToString(input2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.deepEquals(expected2, input2));

        // Test case 3 - 2x2 matrix with no 0s
        int[][] input3 = {{1, 2}, {3, 4}};
        int[][] expected3 = {{1, 2}, {3, 4}};
        setZeroes(input3);
        System.out.println("Test Case 3 - Input: " + Arrays.deepToString(input3));
        System.out.println("Test Case 3 - Expected result: " + Arrays.deepToString(expected3));
        System.out.println("Test Case 3 - Actual result: " + Arrays.deepToString(input3));
        System.out.println("Test Case 3 - Result matches expected: " + Arrays.deepEquals(expected3, input3));

        // Test case 4 - 2x2 matrix with 1 zero
        int[][] input4 = {{1, 0}, {3, 4}};
        int[][] expected4 = {{0, 0}, {3, 0}};
        setZeroes(input4);
        System.out.println("Test Case 4 - Input: " + Arrays.deepToString(input4));
        System.out.println("Test Case 4 - Expected result: " + Arrays.deepToString(expected4));
        System.out.println("Test Case 4 - Actual result: " + Arrays.deepToString(input4));
        System.out.println("Test Case 4 - Result matches expected: " + Arrays.deepEquals(expected4, input4));

        // Test case 5 - 3x3 matrix with 2 zeros
        int[][] input5 = {{1, 2, 3}, {4, 0, 6}, {7, 8, 0}};
        int[][] expected5 = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        setZeroes(input5);
        System.out.println("Test Case 5 - Input: " + Arrays.deepToString(input5));
        System.out.println("Test Case 5 - Expected result: " + Arrays.deepToString(expected5));
        System.out.println("Test Case 5 - Actual result: " + Arrays.deepToString(input5));
        System.out.println("Test Case 5 - Result matches expected: " + Arrays.deepEquals(expected5, input5));


        // Test case 6 - matrix with all zeros
        int[][] matrix6 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] expected6 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        setZeroes(matrix6);
        System.out.println("Test Case 6 - Input matrix: " + Arrays.deepToString(matrix6));
        System.out.println("Test Case 6 - Expected result: " + Arrays.deepToString(expected6));
        System.out.println("Test Case 6 - Result matches expected: " + Arrays.deepEquals(expected6, matrix6));

        // Test case 7 - matrix with no zeros
        int[][] matrix7 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected7 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        setZeroes(matrix7);
        System.out.println("Test Case 7 - Input matrix: " + Arrays.deepToString(matrix7));
        System.out.println("Test Case 7 - Expected result: " + Arrays.deepToString(expected7));
        System.out.println("Test Case 7 - Result matches expected: " + Arrays.deepEquals(expected7, matrix7));

        // Test case 8 - matrix with multiple zeros
        int[][] matrix8 = {{1, 0, 1, 1, 0}, {1, 1, 1, 1, 1}, {0, 1, 1, 0, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        int[][] expected8 = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}};
        setZeroes(matrix8);
        System.out.println("Test Case 8 - Input matrix: " + Arrays.deepToString(matrix8));
        System.out.println("Test Case 8 - Expected result: " + Arrays.deepToString(expected8));
        System.out.println("Test Case 8 - Result matches expected: " + Arrays.deepEquals(expected8, matrix8));
    }

    /**
     * Set Matrix Zeroes
     * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
     * Algorithm Steps:
     * Create a copy of the original matrix to preserve the original values.
     * Traverse through the copy of the matrix and set all rows and columns that contain a 0 to 0 in the original
     * matrix.
     * Time Complexity:
     * The algorithm traverses through the entire matrix twice. Therefore, the time complexity is O(m*n),
     * where m is the number of rows and n is the number of columns in the matrix.
     * Space Complexity:
     * The algorithm creates a copy of the original matrix, which has a space complexity of O(m*n).
     */
    public static void setZeroes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int[][] tempMatrix = new int[numRows][numCols];

        // Store the original matrix values in tempMatrix
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                tempMatrix[row][col] = matrix[row][col];
            }
        }

        // Iterate through the matrix and if an element is 0, set the corresponding row and column to 0
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (tempMatrix[row][col] == 0) {
                    // Set the row to 0
                    for (int i = 0; i < numCols; i++) {
                        matrix[row][i] = 0;
                    }

                    // Set the column to 0
                    for (int i = 0; i < numRows; i++) {
                        matrix[i][col] = 0;
                    }
                }
            }
        }

    }


    /**
     * Set Matrix Zeroes
     * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
     * Algorithm Steps:
     * Check if the first row and column contain 0's, and set flags accordingly.
     * Traverse the matrix except for the first row and column and use the first row and column to mark which rows
     * and columns need to be zeroed out.
     * Traverse the matrix again except for the first row and column and zero out the appropriate rows and columns.
     * Zero out the first row and column if necessary using the flags set earlier.
     * Time Complexity:
     * The algorithm visits every element in the matrix exactly twice except for the first row and column which are
     * visited once.
     * Therefore, the time complexity is O(mn), where m and n are the dimensions of the matrix.
     * Space Complexity:
     * The algorithm uses two boolean variables and constant extra space for indices. Therefore, the space complexity
     * is O(1).
     */
    public static void setZeroes2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Check if first row has a zero
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Check if first column has a zero
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Find which rows and columns need to be zeroed out
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Zero out the appropriate rows and columns
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out first row and first column if necessary
        if (firstRowHasZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColHasZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    /**
     * Set Matrix Zeroes
     * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
     * Algorithm Steps:
     * Use two sets to keep track of rows and columns that contain 0s.
     * Traverse the matrix and add the row and column indices to the sets when a 0 is encountered.
     * Traverse the matrix again and set the corresponding row and column to 0 if it appears in the sets.
     * Time Complexity:
     * The algorithm visits every element in the matrix exactly twice. Therefore, the time complexity is O(mn),
     * where m and n are the dimensions of the matrix.
     * Space Complexity:
     * The algorithm uses two sets of size m + n to store the row and column indices. Therefore, the space complexity
     * is O(m + n).
     */
    public static void setZeroes3(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        Set<Integer> rowsWithZero = new HashSet<>();
        Set<Integer> colsWithZero = new HashSet<>();

        // mark the rows and columns that contain 0s
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (matrix[row][col] == 0) {
                    rowsWithZero.add(row);
                    colsWithZero.add(col);
                }
            }
        }

        // set corresponding rows and columns to 0s
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (rowsWithZero.contains(row) || colsWithZero.contains(col)) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}

