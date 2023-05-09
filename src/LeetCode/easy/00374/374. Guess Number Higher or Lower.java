/*
374. Guess Number Higher or Lower
Easy
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1

Constraints:

1 <= n <= 231 - 1
1 <= pick <= n
 */

public class GuessGame{
    public static int target;

    public static void main(String[] args) {
        // Test Case 1: n is 1
        int n1 = 1;
        int expected1 = 1;
        target = 1;
        int result1 = guessNumber(n1);
        System.out.println("Test Case 1 - Input: " + n1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test Case 2: n is even
        int n2 = 6;
        int expected2 = 5;
        target = 5;
        int result2 = guessNumber(n2);
        System.out.println("Test Case 2 - Input: " + n2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test Case 3: n is odd
        int n3 = 9;
        int expected3 = 7;
        target = 7;
        int result3 = guessNumber(n3);
        System.out.println("Test Case 3 - Input: " + n3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test Case 4: n is a large prime number
        int n4 = 997;
        int expected4 = 497;
        target = 497;
        int result4 = guessNumber(n4);
        System.out.println("Test Case 4 - Input: " + n4);
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));

    }


    /**
     * Algorithm Steps:
     * Initialize low as 1 and high as n.
     * While low is less than or equal to high, do the following:
     * a. Calculate the middle value mid as low + (high - low) / 2.
     * b. Call the guess function with mid as the argument and store the result in a variable result.
     * c. If result is 0, return mid as it is the correct guess.
     * d. If result is -1, the actual number is smaller than mid, so set high as mid - 1.
     * e. If result is 1, the actual number is larger than mid, so set low as mid + 1.
     * If the loop completes without finding the correct guess, return -1 to indicate that the number was not found.
     * Time Complexity:
     * The algorithm visits each element in the search space (i.e., the portion of the array between the low and high
     * indices) at most three times.
     * Therefore, the time complexity is O(log n), where n is the length of the input array.
     * Space Complexity:
     * The algorithm uses a constant amount of additional space.
     * Therefore, the space complexity is O(1).
     */
    public static int guessNumber(int n) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int apiGuess = guess(mid);

            if (apiGuess == 0) {
                return mid;
            } else if (apiGuess == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }


        // if the number is not found, return -1 or any other appropriate value
        return n;
    }


    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     * int guess(int num);
     */
    public static int guess(int num) {
        if (num == target) {
            return 0;
        } else if (num < target) {
            return 1;
        } else {
            return -1;
        }
    }
}






