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


public class ArrangeCoins {
    public static void main(String[] args) {
        int num1 = 5;
        int result1 = arrangeCoins(num1);
        System.out.println(num1 + " Answer " + result1);
    }


    public static int arrangeCoins(int n) {
        int i;
        for (i = 1; i <= n; i++) {
            if (n < i) {
                break;
            }
            n -= i;
        }
        return i - 1;
    }
}