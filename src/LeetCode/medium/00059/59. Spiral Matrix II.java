/*
59. Spiral Matrix II
Medium
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 */

import java.util.Arrays;

public class GenerateMatrix {
    public static void main(String[] args) {
        // Test case 1 - n = 1
        int[][] expected1 = {{1}};
        int[][] result1 = generateMatrix(1);
        System.out.println("Test Case 1 - Input n: 1");
        System.out.println("Test Case 1 - Expected result: " + Arrays.deepToString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.deepToString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.deepEquals(expected1, result1));

        // Test case 2 - n = 2
        int[][] expected2 = {{1, 2}, {4, 3}};
        int[][] result2 = generateMatrix(2);
        System.out.println("Test Case 2 - Input n: 2");
        System.out.println("Test Case 2 - Expected result: " + Arrays.deepToString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.deepToString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.deepEquals(expected2, result2));

        // Test case 3 - n = 3
        int[][] expected3 = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        int[][] result3 = generateMatrix(3);
        System.out.println("Test Case 3 - Input n: 3");
        System.out.println("Test Case 3 - Expected result: " + Arrays.deepToString(expected3));
        System.out.println("Test Case 3 - Actual result: " + Arrays.deepToString(result3));
        System.out.println("Test Case 3 - Result matches expected: " + Arrays.deepEquals(expected3, result3));

        // Test case 4 - n = 3 x 4
        int[][] expected4 = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        int[][] result4 = generateMatrix(3 * 4);
        System.out.println("Test Case 4 - Input n: 12");
        System.out.println("Test Case 4 - Expected result: " + Arrays.deepToString(expected4));
        System.out.println("Test Case 4 - Actual result: " + Arrays.deepToString(result4));
        System.out.println("Test Case 4 - Result matches expected: " + Arrays.deepEquals(expected4, result4));

        // Test case 5 - n = 4
        int[][] expected5 = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        int[][] result5 = generateMatrix(4);
        System.out.println("Test Case 5 - Input n: 4");
        System.out.println("Test Case 5 - Expected result: " + Arrays.deepToString(expected5));
        System.out.println("Test Case 5 - Actual result: " + Arrays.deepToString(result5));
        System.out.println("Test Case 5 - Result matches expected: " + Arrays.deepEquals(expected5, result5));


        // Test case 6 - n = 5
        int[][] expected6 = {{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12,
                11, 10, 9}};
        int[][] result6 = generateMatrix(5);
        System.out.println("Test Case 6 - Input n: 5");
        System.out.println("Test Case 6 - Expected result: " + Arrays.deepToString(expected6));
        System.out.println("Test Case 6 - Actual result: " + Arrays.deepToString(result6));
        System.out.println("Test Case 6 - Result matches expected: " + Arrays.deepEquals(expected6, result6));


        // Test case 7 - n = 6 x 5
        int[][] expected7 = new int[6][5];
        int value7 = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                expected7[i][j] = value7++;
            }
        }
        int[][] result7 = generateMatrix(6 * 5);
        System.out.println("Test Case 7 - Input n: 30");
        System.out.println("Test Case 7 - Expected result: " + Arrays.deepToString(expected7));
        System.out.println("Test Case 7 - Actual result: " + Arrays.deepToString(result7));
        System.out.println("Test Case 7 - Result matches expected: " + Arrays.deepEquals(expected7, result7));


        // Test case 8 - n = 6
        int[][] expected8 = {{1, 2, 3, 4, 5, 6}, {20, 21, 22, 23, 24, 7}, {19, 32, 33, 34, 25, 8}, {18, 31, 36, 35,
                26, 9}, {17, 30, 29, 28, 27, 10}, {16, 15, 14, 13, 12, 11}};
        int[][] result8 = generateMatrix(6);
        System.out.println("Test Case 8 - Input n: 6");
        System.out.println("Test Case 8 - Expected result: " + Arrays.deepToString(expected8));
        System.out.println("Test Case 8 - Actual result: " + Arrays.deepToString(result8));
        System.out.println("Test Case 8 - Result matches expected: " + Arrays.deepEquals(expected8, result8));


    }

    /**
     * Spiral Matrix II
     * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
     * Algorithm Steps:
     * Initialize four variables: top, bottom, left, and right, representing the boundaries of the matrix.
     * Initialize a 2D matrix of size n x n, filled with 0s.
     * Initialize a counter variable to 1.
     * While the top is less than or equal to the bottom and the left is less than or equal to the right:
     * a. Traverse from left to right along the top row, filling each element with the counter value, and then
     * increment top by 1.
     * b. Traverse from top to bottom along the right column, filling each element with the counter value, and then
     * decrement right by 1.
     * c. If the top is less than or equal to the bottom, traverse from right to left along the bottom row, filling
     * each element with the counter value, and then decrement bottom by 1.
     * d. If the left is less than or equal to the right, traverse from bottom to top along the left column, filling
     * each element with the counter value, and then increment left by 1.
     * Increment the counter value by 1.
     * Return the 2D matrix.
     * Time Complexity:
     * The algorithm visits every element in the matrix exactly once. Therefore, the time complexity is O(n^2), where
     * n is the dimension of the matrix.
     * Space Complexity:
     * The algorithm creates a 2D matrix of size n x n to store the result. Therefore, the space complexity is O(n^2).
     */
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int leftPointer = 0, rightPointer = n, topPointer = 0, bottomPointer = n;

        while (leftPointer < rightPointer && topPointer < bottomPointer) {
            // Traverse from left to right along the top row
            for (int i = leftPointer; i < rightPointer; i++) {
                matrix[topPointer][i] = num++;
            }
            topPointer++;

            // Traverse from top to bottom along the right column
            for (int i = topPointer; i < bottomPointer; i++) {
                matrix[i][rightPointer - 1] = num++;
            }
            rightPointer--;

            if (leftPointer < rightPointer && topPointer < bottomPointer) {
                // Traverse from bottom to top along the left column
                for (int i = rightPointer - 1; i >= leftPointer; i--) {
                    matrix[bottomPointer - 1][i] = num++;
                }
                bottomPointer--;

                // Traverse from bottom to top along the left column
                for (int i = bottomPointer - 1; i >= topPointer; i--) {
                    matrix[i][leftPointer] = num++;
                }
                leftPointer++;
            }
        }

        return matrix;
    }
}

