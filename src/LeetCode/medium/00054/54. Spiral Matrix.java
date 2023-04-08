/*
54. Spiral Matrix
Medium
Given an m x n matrix, return all elements of the matrix in spiral order.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        // Test case 1:
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> expected1 = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        List<Integer> result1 = spiralOrder(matrix1);
        System.out.println("Test Case 1 - Input matrix: " + Arrays.deepToString(matrix1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + expected1.equals(result1));

        // Test case 2:
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> expected2 = Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        List<Integer> result2 = spiralOrder(matrix2);
        System.out.println("Test Case 2 - Input matrix: " + Arrays.deepToString(matrix2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + expected2.equals(result2));

        // Test case 3:
        int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        List<Integer> expected3 = Arrays.asList(1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8);
        List<Integer> result3 = spiralOrder(matrix3);
        System.out.println("Test Case 3 - Input matrix: " + Arrays.deepToString(matrix3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + expected3.equals(result3));

        // Test case 4:
        int[][] matrix4 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        List<Integer> expected4 = Arrays.asList(1, 2, 4, 6, 8, 7, 5, 3);
        List<Integer> result4 = spiralOrder(matrix4);
        System.out.println("Test Case 4 - Input matrix: " + Arrays.deepToString(matrix4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + expected4.equals(result4));


        int[][] matrix5 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> expected5 = Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);
        List<Integer> result5 = spiralOrder(matrix5);
        System.out.println("Input matrix: " + Arrays.deepToString(matrix5));
        System.out.println("Expected result: " + expected5);
        System.out.println("Actual result: " + result5);
        System.out.println("Result matches expected: " + expected5.equals(result5));


        // Test Case 6 - 5x5 matrix
        int[][] matrix6 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23
                , 24, 25}};
        List<Integer> expected6 = Arrays.asList(1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14
                , 19, 18, 17, 12, 13);
        List<Integer> result6 = spiralOrder(matrix6);
        System.out.println("Test Case 6 - Input matrix: " + Arrays.deepToString(matrix6));
        System.out.println("Test Case 6 - Expected result: " + expected6);
        System.out.println("Test Case 6 - Actual result: " + result6);
        System.out.println("Test Case 6 - Result matches expected: " + expected6.equals(result6));


        // Test Case 8 - 6x6 matrix
        int[][] matrix8 = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23,
                24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
        List<Integer> expected8 = Arrays.asList(1, 2, 3, 4, 5, 6, 12, 18, 24, 30, 36, 35, 34, 33, 32, 31, 25, 19, 13,
                7, 8, 9, 10, 11, 17, 23, 29, 28, 27, 26, 20, 14, 15, 16, 22, 21);
        List<Integer> result8 = spiralOrder(matrix8);
        System.out.println("Test Case 8 - Input matrix: " + Arrays.deepToString(matrix8));
        System.out.println("Test Case 8 - Expected result: " + expected8);
        System.out.println("Test Case 8 - Actual result: " + result8);
        System.out.println("Test Case 8 - Result matches expected: " + expected8.equals(result8));
    }

    /**
     * Spiral Matrix
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     * Algorithm Steps:
     * Initialize four variables: top, bottom, left, and right, representing the boundaries of the matrix.
     * Initialize an empty result array.
     * While the top is less than or equal to the bottom and the left is less than or equal to the right:
     * a. Traverse from left to right along the top row, adding each element to the result array, and then increment
     * top by 1.
     * b. Traverse from top to bottom along the right column, adding each element to the result array, and then
     * decrement right by 1.
     * c. If the top is less than or equal to the bottom, traverse from right to left along the bottom row, adding
     * each element to the result array, and then decrement bottom by 1.
     * d. If the left is less than or equal to the right, traverse from bottom to top along the left column, adding
     * each element to the result array, and then increment left by 1.
     * Return the result array.
     * Time Complexity:
     * The algorithm visits every element in the matrix exactly once. Therefore, the time complexity is O(mn), where
     * m and n are the dimensions of the matrix.
     * Space Complexity:
     * The algorithm creates an output array of size m x n to store the result. Therefore, the space complexity is O
     * (mn).
     */

    public static List<Integer> spiralOrder(int[][] matrix) {

        int numRows = matrix.length;
        if (numRows == 0) return new ArrayList<>();
        int numCols = matrix[0].length;
        int leftPointer = 0, rightPointer = numCols, topPointer = 0, bottomPointer = numRows;
        List<Integer> spiralOrder = new ArrayList<>();

        while (leftPointer < rightPointer && topPointer < bottomPointer) {
            // Traverse from left to right along the top row
            for (int i = leftPointer; i < rightPointer; i++) {
                spiralOrder.add(matrix[topPointer][i]);
            }
            topPointer++;

            // Traverse from top to bottom along the right column
            for (int i = topPointer; i < bottomPointer; i++) {
                spiralOrder.add(matrix[i][rightPointer - 1]);
            }
            rightPointer--;

            // Traverse from right to left along the bottom row
            if (topPointer < bottomPointer) {
                for (int i = rightPointer - 1; i >= leftPointer; i--) {
                    spiralOrder.add(matrix[bottomPointer - 1][i]);
                }
                bottomPointer--;
            }

            // Traverse from bottom to top along the left column
            if (leftPointer < rightPointer) {
                for (int i = bottomPointer - 1; i >= topPointer; i--) {
                    spiralOrder.add(matrix[i][leftPointer]);
                }
                leftPointer++;
            }
        }

        return spiralOrder;
    }
}

