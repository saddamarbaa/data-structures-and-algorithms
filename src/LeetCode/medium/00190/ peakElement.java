/*
1901. Find a Peak Element II
Medium
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left,
right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return
the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

Example 1:

Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
Example 2:

Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 105
No two adjacent cells are equal.
 */


import java.util.Arrays;

public class PeakElement {
    public static void main(String[] args) {
        // Test case 1 - Basic scenario
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] expected1 = {2, 2};
        int[] result1 = findPeakGrid(matrix1);
        System.out.println("Test Case 1 - matrix:");
        printMatrix(matrix1);
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.toString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.equals(result1, expected1));
        System.out.println();

        // Test case 2 - Matrix with a single peak
        int[][] matrix2 = {
                {1, 2, 1},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] expected2 = {1, 2};
        int[] result2 = findPeakGrid(matrix2);
        System.out.println("Test Case 2 - matrix:");
        printMatrix(matrix2);
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.toString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.equals(result2, expected2));
        System.out.println();

        // Test case 3 - Matrix with multiple peaks
        int[][] matrix3 = {
                {1, 4, 3},
                {2, 5, 6},
                {7, 8, 9}
        };
        int[] expected3 = {1, 2};
        int[] result3 = findPeakGrid(matrix3);
        System.out.println("Test Case 3 - matrix:");
        printMatrix(matrix3);
        System.out.println("Test Case 3 - Expected result: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Actual result: " + Arrays.toString(result3));
        System.out.println("Test Case 3 - Result matches expected: " + Arrays.equals(result3, expected3));
        System.out.println();
    }


    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    /**
     * Algorithm Steps:
     * 1. Initialize the startRow as 0 and endRow as numRows - 1.
     * 2. Iterate while startRow is less than or equal to endRow.
     * 3. Calculate the middleRow as the average of startRow and endRow.
     * 4. Find the maximum element in the middleRow and get its column index (maxColIndex).
     * 5. Check if the current cell is a peak element:
     * - If middleRow is greater than 0 and maxElement is less than the element above it, update endRow to middleRow
     * - 1.
     * - Else if middleRow is less than numRows - 1 and maxElement is less than the element below it, update startRow to
     * middleRow + 1.
     * - Otherwise, return the coordinates [middleRow, maxColIndex] as a peak element.
     * 6. If no peak element is found, return [-1, -1].
     * <p>
     * Time Complexity: O(log(m)), where m is the number of rows in the matrix.
     * - The binary search algorithm reduces the search space by half in each iteration.
     * <p>
     * Space Complexity: O(1).
     * - The algorithm uses a constant amount of extra space for variables.
     */
    public static int[] findPeakGrid(int[][] matrix) {
        int numRows = matrix.length;

        int startRow = 0;
        int endRow = numRows - 1;

        while (startRow <= endRow) {
            int middleRow = startRow + (endRow - startRow) / 2;

            // Get the position of the maximum element in the current row
            int maxColIndex = findMaxRowIndexInColumn(matrix, middleRow);
            int maxElement = matrix[middleRow][maxColIndex];

            // Check if the current cell is a peak element
            if (middleRow > 0 && maxElement < matrix[middleRow - 1][maxColIndex]) {
                endRow = middleRow - 1; // Search in the upper half
            } else if (middleRow < numRows - 1 && maxElement < matrix[middleRow + 1][maxColIndex]) {
                startRow = middleRow + 1; // Search in the lower half
            } else {
                return new int[]{middleRow, maxColIndex}; // Found a peak element
            }
        }

        return new int[]{-1, -1}; // No peak element found
    }


    public static int findMaxRowIndexInColumn(int[][] matrix, int row) {
        int maxColumnIndex = 0;
        int maxElement = matrix[row][0];

        for (int column = 1; column < matrix[row].length; column++) {
            if (matrix[row][column] > maxElement) {
                maxElement = matrix[row][column];
                maxColumnIndex = column;
            }
        }

        return maxColumnIndex;
    }
}