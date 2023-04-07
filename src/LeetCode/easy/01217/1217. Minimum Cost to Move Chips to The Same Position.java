/*
1217. Minimum Cost to Move Chips to The Same Position
Easy
We have n chips, where the position of the ith chip is position[i].
We need to move all the chips to the same position. In one step, we can change the position of the ith chip from
position[i] to:
position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.
 */


import java.util.Arrays;

public class MinCostToMoveChips {
    public static void main(String[] args) {
        // Test Case 1: Normal case with odd and even numbered chips
        int[] chips1 = {1, 2, 3};
        int cost1 = minCostToMoveChips(chips1);
        System.out.println("Test Case 1 - Minimum cost to move chips: " + cost1); // Output: 1

        // Test Case 2: Normal case with all chips at the same position
        int[] chips2 = {2, 2, 2, 2, 2};
        int cost2 = minCostToMoveChips(chips2);
        System.out.println("Test Case 2 - Minimum cost to move chips: " + cost2); // Output: 0

        // Test Case 3: Normal case with only two chips
        int[] chips3 = {1, 100000};
        int cost3 = minCostToMoveChips(chips3);
        System.out.println("Test Case 3 - Minimum cost to move chips: " + cost3); // Output: 1

        // Test Case 4: Edge case with one chip
        int[] chips4 = {5};
        int cost4 = minCostToMoveChips(chips4);
        System.out.println("Test Case 4 - Minimum cost to move chips: " + cost4); // Output: 0

        // Test Case 5: Normal case with multiple chips at the same odd position
        int[] chips5 = {1, 1, 3, 3, 5, 5};
        int cost5 = minCostToMoveChips(chips5);
        System.out.println("Test Case 5 - Minimum cost to move chips: " + cost5); // Output: 2

        // Test Case 6: Normal case with multiple chips at the same even position
        int[] chips6 = {2, 2, 4, 4, 6, 6};
        int cost6 = minCostToMoveChips(chips6);
        System.out.println("Test Case 6 - Minimum cost to move chips: " + cost6); // Output: 2

        // Test Case 7: Edge case with large array size
        int[] chips7 = new int[1000000];
        for (int i = 0; i < chips7.length; i++) {
            chips7[i] = i % 2 == 0 ? 1 : 2;
        }
        int cost7 = minCostToMoveChips(chips7);
        System.out.println("Test Case 7 - Minimum cost to move chips: " + cost7); // Output: 500000

        // Test Case 8: Edge case with large array size and all chips at the same position
        int[] chips8 = new int[1000000];
        Arrays.fill(chips8, 5);
        int cost8 = minCostToMoveChips(chips8);
        System.out.println("Test Case 8 - Minimum cost to move chips: " + cost8); // Output: 0

        // Test Case 9: Normal case with multiple chips at different positions
        int[] chips9 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int cost9 = minCostToMoveChips(chips9);
        System.out.println("Test Case 9 - Minimum cost to move chips: " + cost9); // Output: 5

        // Test Case 10: Normal case with multiple chips at different positions
        int[] chips10 = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
        int cost10 = minCostToMoveChips(chips10);
        System.out.println("Test Case 10 - Minimum cost to move chips: " + cost10); // Output: 5
    }

    /**
     * Minimum Cost to Move Chips to The Same Position
     * Given an array of integers chips where chips[i] represents the position of the ith chip on a 2D plane.
     * We can move any chip to an adjacent position on the plane, or to any position with the same x or y coordinate.
     * In a single move, we can change the position of the ith chip from position chips[i] to:
     * chips[i] + 2 or chips[i] - 2 with a cost of 0.
     * chips[i] + 1 or chips[i] - 1 with a cost of 1.
     * Return the minimum cost needed to move all the chips to the same position.
     * Algorithm Steps:
     * Initialize two variables, evenCount and oddCount, to 0.
     * Iterate over the chips array and for each chip:
     * If the chip is located at an even position (i.e., chips[i] % 2 == 0), increment evenCount by 1.
     * Otherwise, increment oddCount by 1.
     * Return the minimum of evenCount and oddCount.
     * Time Complexity:
     * The algorithm iterates over the chips array once. Therefore, the time complexity is O(n), where n is the
     * length of the chips array.
     * Space Complexity:
     * The algorithm only uses two constant extra variables, evenCount and oddCount. Therefore, the space complexity
     * is O(1).
     */

    public static int minCostToMoveChips(int[] position) {
        int oddCount = 0, eventCount = 0;
        int n = position.length;
        for (int i = 0; i < n; i++) {
            if (position[i] % 2 == 0) {
                eventCount++;
            } else {
                oddCount++;
            }
        }

        return eventCount < oddCount ? eventCount : oddCount;
    }
}

