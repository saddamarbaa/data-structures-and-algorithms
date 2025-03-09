import java.util.Arrays;

/**
 * 3208. Alternating Groups II
 * Medium
 *
 * There is a circle of red and blue tiles. You are given an array of integers colors and an integer k.
 * The color of tile i is represented by colors[i]:
 *
 * - colors[i] == 0 means that tile i is red.
 * - colors[i] == 1 means that tile i is blue.
 *
 * An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except
 * the first and last one has a different color from its left and right tiles).
 *
 * Return the number of alternating groups.
 *
 * Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
 *
 * Example 1:
 * Input: colors = [0,1,0,1,0], k = 3
 * Output: 3
 * Explanation:
 * There are 3 alternating groups: [0,1,0], [1,0,1], and [0,1,0].
 *
 * Example 2:
 * Input: colors = [1,1,0,0,1], k = 2
 * Output: 1
 * Explanation:
 * There is only 1 alternating group: [1,0].
 *
 * Constraints:
 * 1 <= colors.length <= 10^5
 * colors[i] is either 0 or 1.
 * 1 <= k <= colors.length
 */
public class AlternatingGroupsII {
    public static void main(String[] args) {
        // Test Case 1
        int[] colors1 = {0, 1, 0, 1, 0};
        int k1 = 3;
        int expected1 = 3;
        runTestCase(colors1, k1, expected1);

        // Test Case 2
        int[] colors2 = {1, 1, 0, 0, 1};
        int k2 = 2;
        int expected2 = 1;
        runTestCase(colors2, k2, expected2);
    }

    private static void runTestCase(int[] colors, int k, int expected) {
        int result1 = alternatingGroups(colors, k);
        int result2 = alternatingGroups2(colors, k);
        System.out.println("Input: colors = " + Arrays.toString(colors) + ", k = " + k);
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Sliding Window): " + result1);
        System.out.println("Result (Brute Force): " + result2);
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected));
        System.out.println();
    }


    public int numberOfAlternatingGroups(int[] colors, int k) {

        // silding window problem
        int n = colors.length;
        int exteraSteps = k - 1;
        int ans = 0;
        int leftWindow = 0;

        for(int rightWindow = 1; rightWindow < n + exteraSteps; rightWindow++){
            // keep in mind its circle arrray
            int currentNum = colors[rightWindow % n];
            int prevNum = colors[(rightWindow -1) % n];



            if(currentNum == prevNum ){
                // shit left window
                leftWindow = rightWindow;
                continue;
            }

            if(rightWindow - leftWindow + 1 > k){
                leftWindow = leftWindow + 1;
            }

            if(rightWindow - leftWindow + 1 == k){
                ans = ans + 1;
            }
        }

        return ans;

    }

    /**
     * Approach 1: Sliding Window Approach (Optimized)
     *
     * Algorithm Steps:
     * 1. Traverse the array in a circular manner using the sliding window of size k.
     * 2. For each window, check if it forms an alternating group.
     * 3. Return the count of valid alternating groups.
     *
     * Time Complexity: O(n), where n is the length of the colors array.
     * Space Complexity: O(1).
     */
    public static int alternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean isAlternating = true;
            for (int j = 0; j < k - 1; j++) {
                if (colors[(i + j) % n] == colors[(i + j + 1) % n]) {
                    isAlternating = false;
                    break;
                }
            }
            if (isAlternating) {
                count++;
            }
        }

        return count;
    }

    /**
     * Approach 2: Brute Force Approach
     *
     * Algorithm Steps:
     * 1. Iterate over all possible starting positions in the circular array.
     * 2. For each starting position, check if the next k elements form an alternating group.
     * 3. Return the count of valid alternating groups.
     *
     * Time Complexity: O(n * k), where n is the length of the colors array.
     * Space Complexity: O(1).
     */
    public static int alternatingGroups2(int[] colors, int k) {
        int n = colors.length;
        int count = 0;

        // Brute-force solution checks every possible k-sized group in the circular array
        for (int i = 0; i < n; i++) {
            boolean isAlternating = true;
            for (int j = 0; j < k - 1; j++) {
                if (colors[(i + j) % n] == colors[(i + j + 1) % n]) {
                    isAlternating = false;
                    break;
                }
            }
            if (isAlternating) {
                count++;
            }
        }

        return count;
    }
}
