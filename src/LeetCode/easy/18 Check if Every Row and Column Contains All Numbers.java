/*
2133. Check if Every Row and Column Contains All Numbers
Easy

Companies
An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.

Example 1:

Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.
Example 2:


Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
Output: false
Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
Hence, we return false.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
1 <= matrix[i][j] <= n
*/

public class MatrixChecker {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {2, 3, 1},
            {3, 1, 2}
        };

        boolean isValid = checkValid(matrix);

        if (isValid) {
            System.out.println("The matrix is valid.");
        } else {
            System.out.println("The matrix is not valid.");
        }
    }

    public static boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // check rows
            int[] row = matrix[i];
            if (!containsAllNumbers(row, n)) {
                return false;
            }

            // check columns
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = matrix[j][i];
            }
            if (!containsAllNumbers(col, n)) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsAllNumbers(int[] arr, int n) {
        boolean[] found = new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num < 1 || num > n || found[num-1]) {
                return false;
            }
            found[num-1] = true;
        }
        return true;
    }
}
