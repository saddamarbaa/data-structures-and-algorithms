
/**
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
import java.util.Arrays;
import java.util.List;

public class LuckyNumbersInMatrix {

    public static void main(String[] args) {
        // Test Case 1
        int[][] matrix1 = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        testAndPrint(matrix1);

        // Test Case 2
        int[][] matrix2 = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        testAndPrint(matrix2);

        // Test Case 3
        int[][] matrix3 = {{7, 8}, {1, 2}};
        testAndPrint(matrix3);
    }

    private static void testAndPrint(int[][] matrix) {
        List<Integer> result = luckyNumbers(matrix);
        System.out.println("Matrix: " + Arrays.deepToString(matrix));
        System.out.println("Lucky Numbers: " + result);
        System.out.println();
    }

    /**
    * Algorithm Steps:
    * 1. Create ArrayLists to store the minimum values in each row (rowMinValues)
    *    and the maximum values in each column (colMaxValues).
    * 2. Iterate through each row of the matrix and find the minimum value in that row,
    *    then add it to rowMinValues.
    * 3. Iterate through each column of the matrix and find the maximum value in that column,
    *    then add it to colMaxValues.
    * 4. Initialize an empty list called luckyNumbers to store the lucky numbers.
    * 5. Iterate through each element in the matrix. If an element is equal to both the minimum
    *    value in its row (from rowMinValues) and the maximum value in its column
    *    (from colMaxValues), add it to luckyNumbers.
    * 6. Return the luckyNumbers list.
    *
    * Time Complexity:
    *    - The time complexity is O(m * n), where m is the number of rows and n is the number of columns
    *      in the matrix. This is because we iterate through each element in the matrix.
    *
    * Space Complexity:
    *    - The space complexity is O(m + n), where m is the number of rows and n is the number of columns
    *      in the matrix. This is because we use two ArrayLists (rowMinValues and colMaxValues) to store
    *      the minimum values in each row and the maximum values in each column, respectively.
    */

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
