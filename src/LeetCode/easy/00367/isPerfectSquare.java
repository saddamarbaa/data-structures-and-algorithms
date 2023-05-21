/*
367. Valid Perfect Square
Easy
Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer
with itself.

You must not use any built-in library function, such as sqrt.

Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
Example 2:

Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.

Constraints:

1 <= num <= 231 - 1
 */


public class PerfectSquare {
    public static void main(String[] args) {
        int num1 = 16;
        boolean isSquare1 = isPerfectSquare(num1);
        System.out.println(num1 + " is a perfect square: " + isSquare1);

        int num2 = 14;
        boolean isSquare2 = isPerfectSquare(num2);
        System.out.println(num2 + " is a perfect square: " + isSquare2);
    }


    /**
     * Given a positive integer num, return true if num is a perfect square or false otherwise.
     * A perfect square is an integer that is the square of an integer. In other words, it is the product of some
     * integer with itself.
     * <p>
     * Algorithm Steps:
     * 1. If the input number num is less than 2, return true (as 0 and 1 are perfect squares).
     * 2. Initialize the range boundaries: left as 2 and right as num / 2.
     * 3. Perform binary search within the range [left, right] to find the square root of num.
     * 4. In each iteration, calculate the square of the middle value mid.
     * 5. If the square is equal to num, return true (as we found a perfect square).
     * 6. If the square is less than num, update left to mid + 1 to search in the right half of the range.
     * 7. If the square is greater than num, update right to mid - 1 to search in the left half of the range.
     * 8. If we exhaust the search range without finding a perfect square, return false.
     * <p>
     * Time Complexity: The binary search algorithm reduces the search space by half in each iteration,
     * resulting in a logarithmic time complexity of O(log n), where n is the input number.
     * <p>
     * Space Complexity: The space complexity is O(1) as we only use a constant amount of extra space
     * for variables left, right, mid, and square.
     */

    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long leftBoundary = 2;
        long rightBoundary = num / 2;

        while (leftBoundary <= rightBoundary) {
            long middle = leftBoundary + (rightBoundary - leftBoundary) / 2;
            long square = middle * middle;

            if (square == num) {
                return true;
            } else if (square < num) {
                leftBoundary = middle + 1;
            } else {
                rightBoundary = middle - 1;
            }
        }

        return false;
    }
}