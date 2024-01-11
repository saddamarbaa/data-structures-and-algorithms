/*
441. Arranging Coins
Easy
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith
row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:

Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
Example 2:

Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.

Constraints:

1 <= n <= 231 - 1
 */


class ArrangeCoins {
    public static void main(String[] args) {
        // Test cases
        testArrangeCoins(5, 2);
        testArrangeCoins(8, 3);
        testArrangeCoins(0, 0);
        testArrangeCoins(15, 4);
    }

    public static void testArrangeCoins(int n, int expected) {
        int result = arrangeCoins(n);
        System.out.println("Input: " + n + ", Expected: " + expected + ", Result: " + result);
        System.out.println("Test passed: " + (result == expected));
        System.out.println();
    }


    /**
     * Algorithm:
     * 1. Initialize remainingCoins with the given value n and rows to 0.
     * 2. Iterate through rows using a for loop:
     *    a. Check if remainingCoins is greater than or equal to the current row index i.
     *    b. If true, subtract i from remainingCoins, and increment rows.
     *    c. Continue the loop until remainingCoins is no longer greater than or equal to i.
     * 3. Return the total number of complete rows formed, which is the value of rows.
     *
     * Time Complexity: O(sqrt(n))
     *   - The loop iterates until remainingCoins is less than the current row index i.
     *   - In the worst case, it takes approximately sqrt(n) iterations to reach this condition.
     *
     * Space Complexity: O(1)
     *   - Constant space is used since only a few variables (remainingCoins and rows) are used.
     */
    public static int arrangeCoins(int n) {
        int remainingCoins = n;
        int rows = 0;

        // Iterate through rows
        for (int i = 1; remainingCoins >= i; i++) {
            remainingCoins -= i;
            rows++;
        }

        return rows;
    }
}
