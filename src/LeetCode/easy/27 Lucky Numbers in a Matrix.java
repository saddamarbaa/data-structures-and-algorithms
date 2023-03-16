/*
1380. Lucky Numbers in a Matrix
Easy
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.


Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.
*/

import java.util.ArrayList;
import java.util.List;

class LuckyNumbers {
    public static void main(String[] args) {
        // Test case 1: 3x3 array with one lucky number
        int[][] matrix1 = {
                {3, 7, 8},
                {9, 15, 19},
                {22, 26, 30}
        };
        List<Integer> luckyNumbers1 = luckyNumbers(matrix1);
        System.out.println("Lucky numbers for matrix1: " + luckyNumbers1); // prints Lucky numbers for matrix1: [15]

// Test case 2: 3x3 array with no lucky numbers
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> luckyNumbers2 = luckyNumbers(matrix2);
        System.out.println("Lucky numbers for matrix2: " + luckyNumbers2); // prints Lucky numbers for matrix2: []

// Test case 3: 4x4 array with multiple lucky numbers
        int[][] matrix3 = {
                {1, 10, 4, 2},
                {9, 3, 8, 7},
                {15, 16, 17, 12},
                {11, 18, 14, 13}
        };
        List<Integer> luckyNumbers3 = luckyNumbers(matrix3);
        System.out.println("Lucky numbers for matrix3: " + luckyNumbers3); // prints Lucky numbers for matrix3: [2,
        // 3, 4, 8]

// Test case 4: 4x4 array with all the same values
        int[][] matrix4 = {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2}
        };
        List<Integer> luckyNumbers4 = luckyNumbers(matrix4);
        System.out.println("Lucky numbers for matrix4: " + luckyNumbers4); // prints Lucky numbers for matrix4: [2]

// Test case 5: 5x5 array with one lucky number
        int[][] matrix5 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        List<Integer> luckyNumbers5 = luckyNumbers(matrix5);
        System.out.println("Lucky numbers for matrix5: " + luckyNumbers5); // prints Lucky numbers for matrix5: [1]

        // Test case 6: 5x5 array with no lucky numbers
        int[][] matrix6 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 18, 19, 20, 21},
                {22, 23, 24, 25, 26}
        };
        List<Integer> luckyNumbers6 = luckyNumbers(matrix6);
        System.out.println("Lucky numbers for matrix6: " + luckyNumbers6); // prints Lucky numbers for matrix6: []
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> rowMinValues = new ArrayList<Integer>();
        ArrayList<Integer> colMaxValues = new ArrayList<Integer>();

        // Find the minimum value in each row
        for (int i = 0; i < m; i++) {
            int rowMinValue = matrix[i][0];
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < rowMinValue) {
                    rowMinValue = matrix[i][j];
                }
            }
            rowMinValues.add(rowMinValue);
        }

        // Find the maximum value in each column
        for (int j = 0; j < n; j++) {
            int colMaxValue = matrix[0][j];
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] > colMaxValue) {
                    colMaxValue = matrix[i][j];
                }
            }
            colMaxValues.add(colMaxValue);
        }

        // Find the lucky numbers (i.e., the values that appear both in the rowMinValues and the colMaxValues lists)
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < rowMinValues.size(); i++) {
            int currentRowMinValue = rowMinValues.get(i);
            if (colMaxValues.contains(currentRowMinValue)) {
                luckyNumbers.add(currentRowMinValue);
            }
        }
        return luckyNumbers;
    }
}
