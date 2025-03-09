/***
 3206. Alternating Groups I
 Solved
 Easy
 Topics
 Companies
 Hint
 There is a circle of red and blue tiles. You are given an array of integers colors. The color of tile i is represented by colors[i]:

 colors[i] == 0 means that tile i is red.
 colors[i] == 1 means that tile i is blue.
 Every 3 contiguous tiles in the circle with alternating colors (the middle tile has a different color from its left and right tiles) is called an alternating group.

 Return the number of alternating groups.

 Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.



 Example 1:

 Input: colors = [1,1,1]

 Output: 0

 Explanation:
 */

import java.util.Arrays;

public class AlternatingGroupsI {

    public static void main(String[] args) {
        // Test Case 1
        int[] colors1 = {0, 1, 0, 1};
        int expected1 = 2;
        runTestCase(colors1, expected1);

        // Test Case 2
        int[] colors2 = {0, 1, 0, 0};
        int expected2 = 1;
        runTestCase(colors2, expected2);

        // Additional Test Case
        int[] colors3 = {1, 0, 1, 0, 1};
        int expected3 = 3;
        runTestCase(colors3, expected3);
    }

    private static void runTestCase(int[] colors, int expected) {
        int result = countAlternatingGroups(colors);
        System.out.println("Input: colors = " + Arrays.toString(colors));
        System.out.println("Expected result: " + expected);
        System.out.println("Result: " + result);
        System.out.println("All results match expected: " + (result == expected));
        System.out.println();
    }

    /**
     * Approach: Sliding Window of size 3
     *
     * Algorithm Steps:
     * 1. Use a sliding window of size 3 to check every group of 3 contiguous elements in the array.
     * 2. Verify if the middle element is different from its left and right neighbors.
     * 3. Handle the circular nature of the array using modulo arithmetic.
     * 4. Count the number of valid alternating groups.
     *
     * Time Complexity: O(n), where n is the length of the `colors` array.
     * Space Complexity: O(1), for constant space usage.
     */
    public static int countAlternatingGroups(int[] colors) {
        int n = colors.length;
        int alternatingGroups = 0;

        for (int i = 0; i < n; i++) {
            // Get the 3 contiguous elements using modulo for circular indexing
            int left = colors[i % n];
            int middle = colors[(i + 1) % n];
            int right = colors[(i + 2) % n];

            // Check if the middle element is different from both left and right
            if (middle != left && middle != right) {
                alternatingGroups++;
            }
        }

        return alternatingGroups;
    }
}
