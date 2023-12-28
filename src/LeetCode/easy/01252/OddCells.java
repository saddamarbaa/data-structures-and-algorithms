/**
 1252. Cells with Odd Values in a Matrix
 Easy
 
 There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.

 For each location indices[i], do both of the following:

 Increment all the cells on row ri.
 Increment all the cells on column ci.
 Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.
 
 Example 1:

 Input: m = 2, n = 3, indices = [[0,1],[1,1]]
 Output: 6
 Explanation: Initial matrix = [[0,0,0],[0,0,0]].
 After applying first increment it becomes [[1,2,1],[0,1,0]].
 The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
 Example 2:
 
 Input: m = 2, n = 2, indices = [[1,1],[0,0]]
 Output: 0
 Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.


 Constraints:

 1 <= m, n <= 50
 1 <= indices.length <= 100
 0 <= ri < m
 0 <= ci < n


 Follow up: Could you solve this in O(n + m + indices.length) time with only O(n + m) extra space?
 */

import java.util.Arrays;

public class OddCells {

    public static void main(String[] args) {
        // Test case 1
        int m1 = 2, n1 = 3;
        int[][] indices1 = {{0, 1}, {1, 1}};
        int result1 = oddCells(m1, n1, indices1);
        int expected1 = 6;
        printResult(m1, n1, indices1, result1, expected1);

        // Test case 2
        int m2 = 2, n2 = 2;
        int[][] indices2 = {{1, 1}, {0, 0}};
        int result2 = oddCells(m2, n2, indices2);
        int expected2 = 0;
        printResult(m2, n2, indices2, result2, expected2);
    }

    public static int oddCells(int m, int n, int[][] indices) {
        // Create a 2D array to represent the matrix with dimensions m x n
        int[][] matrix = new int[m][n];
        // Initialize the number of odd elements to zero
        int odd = 0;

        // Iterate through the indices array and update the corresponding rows and columns in the matrix
        for (int[] index : indices) {
            int row = index[0];
            int col = index[1];

            // Update the row by incrementing each element in the specified row
            for (int j = 0; j < n; j++) {
                matrix[row][j]++;
                // Increment odd count if the element becomes odd
                if (matrix[row][j] % 2 != 0) {
                    odd++;
                }
                // Decrement odd count if the element becomes even
                else {
                    odd--;
                }
            }

            // Update the column by incrementing each element in the specified column
            for (int j = 0; j < m; j++) {
                matrix[j][col]++;
                // Increment odd count if the element becomes odd
                if (matrix[j][col] % 2 != 0) {
                    odd++;
                }
                // Decrement odd count if the element becomes even
                else {
                    odd--;
                }
            }
        }

        // Return the number of odd elements in the matrix
        return odd;
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
