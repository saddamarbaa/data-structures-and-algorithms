/*
240. Search a 2D Matrix II
Mmedium
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the
following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.


Example 1:

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109
 */


import java.util.Arrays;

public class SearchMatrix {
    public static void main(String[] args) {
        // Test case 1
        int[][] grid1 = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}};
        int target1 = 3;
        boolean expected1 = true;
        boolean result1 = searchMatrix(grid1, target1);
        System.out.println("Test Case 1 - Input: " + Arrays.deepToString(grid1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));


        // Test case 2
        int[][] grid2 = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23,
                26, 30}};
        int target2 = 20;
        boolean expected2 = false;
        boolean result2 = searchMatrix(grid2, target2);
        System.out.println("Test Case 2 - Input: " + Arrays.deepToString(grid2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

    }


    /**
     * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix
     * has the following properties::
     * <p>
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     * <p>
     * 1:  Start at the top right corner of the matrix
     * 2: Compare the value at this position with the target value
     * 3: If the value at this position is equal to the target value, return true
     * 4: If the value at this position is greater than the target value, move one position to the left
     * 5: If the value at this position is less than the target value, move one position down
     * 6:  Repeat steps 2-5 until either the target value is found or all positions have been checked
     * <p>
     * Time Complexity: The correct time complexity for this algorithm is O(m * log(n)), where m is the number of
     * rows and n is the number of columns in the matrix.
     * The reason for this is that at each step, we are eliminating either a row or a column, so we are effectively
     * dividing the search space in half. This is similar to a binary search, which has a time complexity of O(log(n)
     * However, unlike a typical binary search where we are searching within a single sorted array, in this
     * algorithm we are performing binary searches within each row or column of the matrix.
     * Therefore, the worst-case scenario occurs when the target value is located in the bottom-left corner of the
     * matrix. In this case, we would need to perform binary searches on all m rows, each with a length of log(n),
     * giving us a total time complexity of O(m * log(n)).
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


        int left = 0, right = n - 1;
        while (left < m && right >= 0) {
            int currentElement = matrix[left][right];

            if (currentElement == target) {
                return true;
            } else if (target < currentElement) {
                right--;
            } else {
                left++;
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