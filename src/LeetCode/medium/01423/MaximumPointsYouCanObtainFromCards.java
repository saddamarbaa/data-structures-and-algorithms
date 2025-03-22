import java.util.Arrays;

/**
 * 1423. Maximum Points You Can Obtain from Cards
 *
 * There are several cards arranged in a row, and each card has an associated number of points.
 * You can take exactly k cards from the beginning or the end of the row. Your score is the sum of the points of the cards you have taken.
 * Return the maximum score you can obtain.
 *
 * Example:
 * Input: cardPoints = [1, 2, 3, 4, 5, 6, 1], k = 3
 * Output: 12
 * Explanation:
 * - Take the first 3 cards (1, 2, 3) to get a score of 6.
 * - Take the last 3 cards (4, 5, 6) to get a score of 15.
 * - Take the first 2 cards (1, 2) and the last card (1) to get a score of 4.
 * The maximum score is obtained by taking the last 3 cards, which is 15.
 *
 * Constraints:
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 */
public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        // Test Cases
        runTestCase(new int[]{1, 2, 3, 4, 5, 6, 1}, 3, 12);
        runTestCase(new int[]{2, 2, 2}, 2, 4);
        runTestCase(new int[]{9, 7, 7, 9, 7, 7, 9}, 7, 55);
        runTestCase(new int[]{1, 1000, 1}, 1, 1);
        runTestCase(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3, 202);
    }

    // Method to run each test case
    public static void runTestCase(int[] cardPoints, int k, int expected) {
        int result1 = maxScore(cardPoints, k);
        int result2 = maxScore2(cardPoints, k);

        System.out.println("Test Case - Input: cardPoints = " + Arrays.toString(cardPoints) + ", k = " + k);
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Sliding Window Approach): " + result1);
        System.out.println("Result (Prefix Sum Approach): " + result2);
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected));
        System.out.println();
    }

    /**
     * Approach 1: Sliding Window Approach
     *
     * Algorithm Steps:
     * 1. Calculate the total sum of the first k cards.
     * 2. Use a sliding window to subtract the leftmost card and add the rightmost card.
     * 3. Keep track of the maximum sum obtained.
     *
     * Time Complexity: O(n), where n is the length of the cardPoints array.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int maxScore(int[] cardPoints, int k) {
        int total = 0;
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        int maxSum = total;
        int left = k - 1;
        int right = cardPoints.length - 1;

        while (left >= 0) {
            total += cardPoints[right] - cardPoints[left];
            maxSum = Math.max(maxSum, total);
            left--;
            right--;
        }

        return maxSum;
    }

    /**
     * Approach 2: Prefix Sum Approach
     *
     * Algorithm Steps:
     * 1. Calculate the prefix sum of the cardPoints array.
     * 2. For each possible split point (i), calculate the sum of the first i cards and the last k - i cards.
     * 3. Keep track of the maximum sum obtained.
     *
     * Time Complexity: O(n), where n is the length of the cardPoints array.
     * Space Complexity: O(n), as we use an additional array to store the prefix sums.
     */
    public static int maxScore2(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + cardPoints[i];
        }

        int maxSum = 0;
        for (int i = 0; i <= k; i++) {
            int currentSum = prefixSum[i] + prefixSum[n] - prefixSum[n - (k - i)];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}