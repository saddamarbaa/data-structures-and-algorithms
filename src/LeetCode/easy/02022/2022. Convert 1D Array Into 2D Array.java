/*
2022. Convert 1D Array Into 2D Array
Easy
You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n. You are tasked with
creating a 2-dimensional (2D) array with  m rows and n columns using all the elements from original.
The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D array,
the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D array, and so on.
Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.

Example 1:

Input: original = [1,2,3,4], m = 2, n = 2
Output: [[1,2],[3,4]]
Explanation: The constructed 2D array should contain 2 rows and 2 columns.
The first group of n=2 elements in original, [1,2], becomes the first row in the constructed 2D array.
The second group of n=2 elements in original, [3,4], becomes the second row in the constructed 2D array.
Example 2:

Input: original = [1,2,3], m = 1, n = 3
Output: [[1,2,3]]
Explanation: The constructed 2D array should contain 1 row and 3 columns.
Put all three elements in original into the first row of the constructed 2D array.
Example 3:

Input: original = [1,2], m = 1, n = 1
Output: []
Explanation: There are 2 elements in original.
It is impossible to fit 2 elements in a 1x1 2D array, so return an empty 2D array.


Constraints:

1 <= original.length <= 5 * 104
1 <= original[i] <= 105
1 <= m, n <= 4 * 104
*/

import java.util.Arrays;

public class Construct2DArray {
    public static void main(String[] args) {
        int[] original1 = {1, 2, 3, 4, 5, 6};
        int[][] expected1 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result1 = construct2DArray(original1, 3, 2);
        System.out.println("Test case 1: " + Arrays.deepEquals(result1, expected1)); // prints true

        int[] original2 = {1, 2, 3, 4, 5, 6};
        int[][] expected2 = {{1, 2, 3}, {4, 5, 6}};
        int[][] result2 = construct2DArray(original2, 2, 3);
        System.out.println("Test case 2: " + Arrays.deepEquals(result2, expected2)); // prints true

        int[] original3 = {1, 2, 3, 4, 5, 6};
        int[][] expected3 = {{1, 2, 3, 4, 5, 6}};
        int[][] result3 = construct2DArray(original3, 1, 6);
        System.out.println("Test case 3: " + Arrays.deepEquals(result3, expected3)); // prints true

        int[] original4 = {1, 2, 3, 4, 5, 6};
        int[][] expected4 = new int[0][0];
        int[][] result4 = construct2DArray(original4, 3, 3);
        System.out.println("Test case 4: " + Arrays.deepEquals(result4, expected4)); // prints true

        int[] original5 = {1, 2, 3, 4, 5, 6};
        int[][] expected5 = {{1}, {2}, {3}, {4}, {5}, {6}};
        int[][] result5 = construct2DArray(original5, 6, 1);
        System.out.println("Test case 5: " + Arrays.deepEquals(result5, expected5)); // prints true

        int[] original6 = {1, 2, 3, 4};
        int[][] expected6 = {{1, 2}, {3, 4}, {0, 0}};
        int[][] result6 = construct2DArray(original6, 3, 2);
        System.out.println("Test case 6: " + Arrays.deepEquals(result6, expected6)); // prints true

        int[] original7 = {1, 2, 3, 4};
        int[][] expected7 = {{1, 2, 3, 4}};
        int[][] result7 = construct2DArray(original7, 1, 4);
        System.out.println("Test case 7: " + Arrays.deepEquals(result7, expected7)); // prints true

        int[] original8 = {1, 2, 3, 4};
        int[][] expected8 = {{1, 2}, {3, 4}};
        int[][] result8 = construct2DArray(original8, 2, 2);
        System.out.println("Test case 8: " + Arrays.deepEquals(result8, expected8)); // prints true
    }


    /**
     * Convert 1D Array Into 2D Array
     * <p>
     * Inputs:
     * original: 1D integer array
     * newRows: integer representing the desired number of rows in the new matrix
     * newCols: integer representing the desired number of columns in the new matrix
     * <p>
     * Outputs:
     * 2D integer array representing the original array reshaped into a matrix with the desired number of rows and
     * columns
     * <p>
     * Algorithm steps:
     * 1. Initialize a new 2D integer array with dimensions newRows x newCols.
     * 2. Calculate the total number of elements in the original array by taking the length of the array.
     * 3. If the total number of elements in the original array does not equal newRows x newCols, return an empty 2D
     * array.
     * 4. Iterate over the elements in the original array and insert them into the new 2D array row by row, filling
     * each row before moving to the next row.
     * 5. Return the new 2D array.
     * <p>
     * Time complexity:
     * The method iterates over all the elements of the original matrix once to flatten it, and then
     * iterates over all the elements of the new matrix once to fill it. Therefore, the time complexity is O(m*n),
     * where m is the number of rows and n is the number of columns of the matrix.
     * <p>
     * Space complexity:
     * The method creates a new empty matrix with the desired shape and a new array to hold the
     * flattened original matrix. Therefore, the space complexity is O(m*n), where m is the number of rows and n is
     * the number of columns of the matrix.
     */
    public static int[][] construct2DArray(int[] original, int newRows, int newCols) {
        int[][] matrix = new int[newRows][newCols];
        int rowIndex = 0, colIndex = 0;
        int N = original.length;

        if ((newRows * newCols) != N) {
            return new int[0][0];
        }

        for (int i = 0; i < N; i++) {
            matrix[rowIndex][colIndex] = original[i];
            colIndex++;

            if (colIndex >= newCols) {
                colIndex = 0;
                rowIndex++;
            }
        }

        return matrix;
    }
}
