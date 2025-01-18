import java.util.*;

/**
 * 2260. Minimum Consecutive Cards to Pick Up
 * Medium
 *
 * Given an array of integers `cards` representing card values, find the minimum
 * number of consecutive cards to pick up that contain a duplicate card.
 * If no such group exists, return -1.
 *
 */
public class MinCardsToPickUp {
    public static void main(String[] args) {
        // Test case 1
        int[] cards1 = {3, 4, 2, 3, 4, 7};
        int expected1 = 4;
        int result1 = minimumCardPickup(cards1);
        runTestCase(cards1, result1, expected1);

        // Test case 2
        int[] cards2 = {1, 0, 5, 3};
        int expected2 = -1;
        int result2 = minimumCardPickup(cards2);
        runTestCase(cards2, result2, expected2);
    }

    /**
     * Helper function to execute a test case, compare expected vs actual, and print the results.
     *
     * @param cards The input array of card values.
     * @param result The actual result returned by the function.
     * @param expected The expected output.
     */
    private static void runTestCase(int[] cards, int result, int expected) {
        System.out.println("Input: " + Arrays.toString(cards));
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + result);

        // Check if the result matches the expected output
        if (result == expected) {
            System.out.println("Test Result: PASS");
        } else {
            System.out.println("Test Result: FAIL");
        }
        System.out.println();
    }

    /**
     * Function to find the minimum number of consecutive cards to pick up.
     * @param cards The input array of card values.
     * @return The minimum number of consecutive cards to pick up with a duplicate or -1 if no such group exists.
     */
    public static int minimumCardPickup(int[] cards) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            int val = cards[i];
            if (map.containsKey(val)) {
                int res = (i - map.get(cards[i])) + 1;
                min = Math.min(min, res);
            }
            map.put(cards[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * Another method for solving the same problem but using a brute force approach.
     * @param cards The input array of card values.
     * @return The minimum number of consecutive cards to pick up with a duplicate or -1 if no such group exists.
     */
    public static int minimumCardPickupBruteForce(int[] cards) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[i] == cards[j]) {
                    int length = j - i + 1;
                    min = Math.min(min, length);
                    System.out.println("Duplicate found at indices " + i + " and " + j + " with length: " + length);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * An additional method using the same hashmap-based approach but with a different loop structure.
     * @param cards The input array of card values.
     * @return The minimum number of consecutive cards to pick up with a duplicate or -1 if no such group exists.
     */
    public static int minimumCardPickup2(int[] cards) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];
            if (lastSeen.containsKey(card)) {
                int prevIndex = lastSeen.get(card);
                min = Math.min(min, i - prevIndex + 1);
                System.out.println("Card: " + card + ", Last Seen: " + prevIndex + ", Current: " + i);
            }
            lastSeen.put(card, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
