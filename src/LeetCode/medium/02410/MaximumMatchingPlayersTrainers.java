/**
 * 2410. Maximum Matching of Players With Trainers
 * Medium
 *
 * You are given two integer arrays players and trainers, where players[i] represents the skill level of the ith player
 * and trainers[j] represents the skill level of the jth trainer.
 *
 * Each player can be assigned to at most one trainer having a skill level greater than or equal to the player's skill level.
 * Return the maximum number of matchings between players and trainers that satisfy these conditions.
 *
 * Example 1:
 * Input: players = [4,7,9], trainers = [8,2,5,8]
 * Output: 2
 * Explanation: The two players with skill levels 4 and 7 can be assigned to trainers with skill levels 5 and 8 respectively.
 *
 * Example 2:
 * Input: players = [1,1,1], trainers = [10]
 * Output: 1
 * Explanation: The only trainer can be assigned to any one of the players.
 */


 import java.util.Arrays;

 
public class MaximumMatchingPlayersTrainers {
    public static void main(String[] args) {

        // Test case 1 - Maximum matching is 2
        int[] players1 = {4, 7, 9};
        int[] trainers1 = {8, 2, 5, 8};
        int expected1 = 2;
        int result1 = matchPlayersAndTrainers(players1, trainers1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2 - Maximum matching is 1
        int[] players2 = {1, 1, 1};
        int[] trainers2 = {10};
        int expected2 = 1;
        int result2 = matchPlayersAndTrainers(players2, trainers2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);

        // Test case 3 - No matching possible
        int[] players3 = {3, 4, 5};
        int[] trainers3 = {1, 2};
        int expected3 = 0;
        int result3 = matchPlayersAndTrainers(players3, trainers3);
        System.out.println("Test Case 3 - Expected: " + expected3);
        System.out.println("Test Case 3 - Actual: " + result3);
    }

    /**
     * Finds the maximum matching between players and trainers.
     *
     * @param players The integer array representing players' skill levels.
     * @param trainers The integer array representing trainers' skill levels.
     * @return The maximum number of matched players with trainers.
     */
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // Sort both arrays to allow matching players to trainers in a greedy manner
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0;
        int matches = 0;

        // Try to match each player with a trainer
        while (i < players.length && j < trainers.length) {
            // If the trainer can accommodate the player's skill level
            if (players[i] <= trainers[j]) {
                matches++; // Match found
                i++; // Move to the next player
            }
            j++; // Move to the next trainer
        }

        return matches;
    }
}
