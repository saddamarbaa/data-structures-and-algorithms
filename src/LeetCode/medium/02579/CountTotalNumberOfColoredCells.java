/***
 2579. Count Total Number of Colored Cells

 Medium

 There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:

 At the first minute, color any arbitrary unit cell blue.
 Every minute thereafter, color blue every uncolored cell that touches a blue cell.
 Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.

 Return the number of colored cells at the end of n minutes.

 Example 1:

 Input: n = 1
 Output: 1
 Explanation: After 1 minute, there is only 1 blue cell, so we return 1.
 Example 2:

 Input: n = 2
 Output: 5
 Explanation: After 2 minutes, there are 4 colored cells on the boundary and 1 in the center, so we return 5.


 Constraints:

 1 <= n <= 105
 */
public class CountTotalNumberOfColoredCells {
    public static void main(String[] args) {
        int input1 = 2;
        int expected1 = 13;
        int result1 = coloredCells(input1);
        System.out.println("Test Case 1 - Input: " + input1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        int input2 = 3;
        int expected2 = 25;
        int result2 = coloredCells(input2);
        System.out.println("Test Case 2 - Input: " + input2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        int input3 = 1;
        int expected3 = 1;
        int result3 = coloredCells(input3);
        System.out.println("Test Case 3 - Input: " + input3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));
    }

    /**
     * Solution 1: Mathematical Formula
     *
     * The number of colored cells after `n` moves can be calculated using the formula:
     * coloredCells(n) = 2 * n^2 + 2 * n + 1
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static int coloredCells(int n) {
        return 2 * n * n - 2 * n + 1;
    }

    /**
     * Solution 2: Iterative Approach
     *
     * Algorithm Steps:
     * 1. Initialize the count of colored cells to 1 (the origin).
     * 2. For each move from 1 to n, add the number of new cells colored in that move.
     * 3. The number of new cells colored in the k-th move is 4 * (k - 1).
     * 4. Return the total count after n moves.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int coloredCells2(int n) {
        int count = 1;
        for (int k = 1; k <= n; k++) {
            count += 4 * (k - 1);
        }
        return count;
    }

    /**
     * Solution 3: Recursive Approach
     *
     * Algorithm Steps:
     * 1. Base case: If n == 0, return 1 (only the origin is colored).
     * 2. Recursive case: The number of colored cells after n moves is equal to
     *    the number of colored cells after (n-1) moves plus 4 * (n - 1).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) due to recursion stack
     */
    public static int coloredCells3(int n) {
        if (n == 0) {
            return 1;
        }
        return coloredCells3(n - 1) + 4 * (n - 1);
    }
}