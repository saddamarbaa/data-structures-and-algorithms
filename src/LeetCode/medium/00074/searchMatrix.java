/*
74. Search a 2D Matrix
Medium
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 */


import java.util.Arrays;

public class SearchMatrix {
    public static void main(String[] args) {


        // Test case 1
        int[][] grid1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target1 = 3;
        boolean expected1 = true;
        boolean result1 = searchMatrix(grid1, 3);
        System.out.println("Test Case 1 - Input: " + Arrays.deepToString(grid1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));


        // Test case 2
        int[][] grid2 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target2 = 13;
        boolean expected2 = false;
        boolean result2 = searchMatrix(grid2, target2);
        System.out.println("Test Case 2 - Input: " + Arrays.deepToString(grid2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));


        // Test case 3
        int[][] grid3 = {{}};
        int target3 = 1;
        boolean expected3 = false;
        boolean result3 = searchMatrix(grid3, target3);
        System.out.println("Test Case 3 - Input: " + Arrays.deepToString(grid3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case 4
        int[][] grid4 = {{1, 3, 5}};
        int target4 = 1;
        boolean expected4 = true;
        boolean result4 = searchMatrix(grid4, target4);
        System.out.println("Test Case 4 - Input: " + Arrays.deepToString(grid4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));

        // Test case 5
        int[][] grid5 = {{1, 3, 5}};
        int target5 = 5;
        boolean expected5 = true;
        boolean result5 = searchMatrix(grid5, target5);
        System.out.println("Test Case 5 - Input: " + Arrays.deepToString(grid5));
        System.out.println("Test Case 5 - Expected result: " + expected5);
        System.out.println("Test Case 5 - Actual result: " + result5);
        System.out.println("Test Case 5 - Result matches expected: " + (result5 == expected5));
    }


    /**
     * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix
     * has the following properties:
     * <p>
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     * <p>
     * Algorithm Steps:
     * 1. Initialize the result variable to false.
     * 2. If the matrix is empty, return false.
     * 3. Get the number of rows m and columns n in the matrix.
     * 4. If m = 1 or n = 0, perform binary search on the first row of the matrix and return true if target is found.
     * 5. Perform binary search to find the row that may contain the target:
     * a. Initialize left to 0 and right to m - 1.
     * b. While left <= right:
     * i. Calculate the midIndex as the average of left and right (to avoid integer overflow, use the expression
     * midIndex = left + Math.floor((right - left) / 2) instead of midIndex = Math.floor((left + right) / 2)).
     * ii. If matrix[midIndex][0] <= target and matrix[midIndex][n - 1] >= target:
     * 1. Perform binary search on this row:
     * a. Initialize startIndex to 0 and endIndex to n - 1.
     * b. While startIndex <= endIndex:
     * i. Calculate the midIndex as the average of startIndex and endIndex.
     * ii. If matrix[midIndex][midIndex] === target, return true.
     * iii. If matrix[midIndex][midIndex] < target, set startIndex to midIndex + 1.
     * iv. If matrix[midIndex][midIndex] > target, set endIndex to midIndex - 1.
     * c. If the target is not found in this row, return false.
     * 2. If the target is found in this row, return true.
     * iii. If matrix[midIndex][n - 1] < target, set left to midIndex + 1.
     * iv. If matrix[midIndex][0] > target, set right to midIndex - 1.
     * 6. If the target is not found in any row, return false.
     * <p>
     * Time Complexity: O(log(mn)).
     * Space Complexity: O(1).
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        // Check if the matrix is empty
        if (matrix.length == 0) {
            return false;
        }

        // Get the number of rows and columns in the matrix
        int m = matrix.length;
        int n = matrix[0].length;


        // If the matrix has only one row or no columns, perform binary search on that row
        if (m == 1 || n == 0) {
            int index = binarySearch(matrix[0], target, 0);
            return index != -1;
        }


        // Perform binary search to find the row that may contain the target
        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                // If the target may be in this row, perform binary search on this row
                int[] currentRow = matrix[mid];
                int isFound = binarySearch(currentRow, target, 0);
                return isFound != -1;
            } else if (matrix[mid][n - 1] < target) {
                // If the last element of this row is smaller than the target, search in the rows below
                left = mid + 1;
            } else {
                // If the first element of this row is greater than the target, search in the rows above
                right = mid - 1;
            }
        }

        // If we reach here, we haven't found the target in any row
        return false;
    }


    /**
     * Initialize numRows and numCols as the number of rows and columns in the matrix, respectively.
     * If numRows is 0, return false.
     * Initialize startIndex as 0 and endIndex as numRows * numCols - 1.
     * Repeat until startIndex is less than or equal to endIndex:
     * a. Calculate midIndex as startIndex + (endIndex - startIndex) / 2.
     * b. Calculate midRowIndex as midIndex / numCols and midColIndex as midIndex % numCols.
     * c. Retrieve the midElement in the matrix using matrix[midRowIndex][midColIndex].
     * d. If midElement is equal to the target, return true.
     * e. If midElement is less than the target, update startIndex to midIndex + 1.
     * f. If midElement is greater than the target, update endIndex to midIndex - 1.
     * If the loop completes without returning true, return false.
     * Time complexity: O(log(m * n)), where m and n are the number of rows and columns in the matrix, respectively.
     * This is because we use binary search to search for the target element in the matrix, which has a time
     * complexity of O(log(m * n))
     * Space complexity: O(1). The space used by the algorithm is constant, as we only use a few integer variables to
     * keep track of indices and values in the matrix.
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        if (numRows == 1 || numCols == 0) {
            int index = binarySearch(matrix[0], target, 0);
            return index != -1;
        }


        int startIndex = 0;
        int endIndex = numRows * numCols - 1;

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            int midRowIndex = midIndex / numCols;
            int midColIndex = midIndex % numCols;
            int midElement = matrix[midRowIndex][midColIndex];
            if (midElement == target) {
                return true;
            } else if (midElement < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return false;
    }


    /**
     * Write a function that implements the binary search algorithm to search for a given key in a sorted array of
     * integers. The function should return the index of the key if it is present in the array, otherwise it should
     * return -1.
     * The function should take three arguments:
     * nums: A sorted array of integers.
     * target: An integer value to search for in the array.
     * occurrence: An integer value indicating which occurrence of the target to find. A value of -1 indicates the first
     * occurrence, a value of 0 indicates any occurrence, and a value of 1 indicates the last occurrence.
     * <p>
     * Algorithm Steps:
     * 1. Initialize the result variable to -1.
     * 2. Initialize the startIndex and endIndex variables to the first and last indices of the array, respectively.
     * 3. While the startIndex is less than or equal to the endIndex:
     * a. Calculate the midIndex as the average of the startIndex and endIndex (to avoid integer overflow, use the
     * expression midIndex = startIndex + (endIndex - startIndex) / 2 instead of midIndex = (startIndex + endIndex) /
     * 2).
     * b. If the value at the midIndex is equal to the target:
     * i. Set the result to the midIndex.
     * ii. If occurrence is less than or equal to 0, set the endIndex to midIndex - 1 to find the first occurrence
     * of the target. If occurrence is greater than or equal to 1, set the startIndex to midIndex + 1 to find the
     * last occurrence of the target.
     * iii. If occurrence is equal to 0 and result is not -1, return the result immediately.
     * c. If the value at the midIndex is less than the target, set the startIndex to midIndex + 1.
     * d. If the value at the midIndex is greater than the target, set the endIndex to midIndex - 1.
     * 4. Return the result.
     * <p>
     * Time Complexity:
     * The algorithm visits each element in the search space (i.e., the portion of the array between the startIndex and
     * endIndex indices) at most three times.
     * Therefore, the time complexity is O(log n), where n is the length of the input array.
     * <p>
     * Space Complexity:
     * The algorithm uses a constant amount of additional space.
     * Therefore, the space complexity is O(1).
     */

    public static int binarySearch(int[] nums, int target, int occurrence) {
        int result = -1;
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (nums[midIndex] == target) {
                result = midIndex;
                // Find the first occurrence of the target
                if (occurrence <= 0) {
                    endIndex = midIndex - 1;
                } else {
                    // Find the last occurrence of the target
                    startIndex = midIndex + 1;
                }
                // If not looking for first or last occurrence, return immediately when target found
                if (occurrence == 0 && result != -1) {
                    return result;
                }
            } else if (nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return result;
    }
}