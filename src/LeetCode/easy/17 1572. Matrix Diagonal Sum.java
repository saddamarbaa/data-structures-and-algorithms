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


public class DiagonalSum {
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

    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix2 = {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
        int[][] matrix3 = {{3,3}, {3,3}};

        System.out.println(diagonalSum(matrix1)); // Expected output: 25
        System.out.println(diagonalSum(matrix2)); // Expected output: 4
        System.out.println(diagonalSum(matrix3)); // Expected output: 12
    }
}
