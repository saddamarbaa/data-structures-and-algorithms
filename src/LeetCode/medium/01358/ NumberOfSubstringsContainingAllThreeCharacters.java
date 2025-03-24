import java.util.Arrays;

/**
 * 1358. Number of Substrings Containing All Three Characters
 *
 * Given a string s consisting only of characters a, b, and c.
 * Return the number of substrings containing at least one occurrence of all three characters a, b, and c.
 *
 * Example:
 * Input: s = "abcabc"
 * Output: 10
 * Explanation:
 * - The substrings containing at least one occurrence of all three characters are:
 *   - "abc", "abca", "abcab", "abcabc",
 *   - "bca", "bcab", "bcabc",
 *   - "cab", "cabc",
 *   - "abc"
 *   Total of 10 substrings.
 *
 * Constraints:
 * 3 <= s.length <= 5 * 10^4
 * s consists only of a, b, and c.
 */
public class NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        // Test Cases
        runTestCase("abcabc", 10);
        runTestCase("aaacb", 3);
        runTestCase("abc", 1);
        runTestCase("aababc", 7);
    }

    // Method to run each test case
    public static void runTestCase(String s, int expected) {
        int result1 = numberOfSubstrings(s);
        int result2 = numberOfSubstrings2(s);

        System.out.println("Test Case - Input: s = " + s);
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Sliding Window Approach): " + result1);
        System.out.println("Result (Three Pointers Approach): " + result2);
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected));
        System.out.println();
    }

    /**
     * Approach 1: Sliding Window Approach
     *
     * Algorithm Steps:
     * 1. Use a sliding window to track the count of 'a', 'b', and 'c' within the window.
     * 2. Expand the window by moving the right pointer and update the counts.
     * 3. When all three characters are present, move the left pointer to find the smallest valid window.
     * 4. For each valid window, all substrings ending at the right pointer and starting at or after the left pointer are valid.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int numberOfSubstrings(String s) {
        int[] count = new int[3]; // To count occurrences of 'a', 'b', 'c'
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            // Increment the count for the current character
            count[s.charAt(right) - 'a']++;

            // Shrink the window from the left while the current window contains all 'a', 'b', 'c'
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // If valid, add the number of valid substrings ending at 'right'
                result += s.length() - right;

                // Move the left pointer and decrease the count of the left character
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return result;
}

    /**
     * Approach 2: Three Pointers Approach
     *
     * Algorithm Steps:
     * 1. Track the last occurrence of 'a', 'b', and 'c' using three pointers.
     * 2. For each character in the string, update the corresponding last occurrence pointer.
     * 3. The number of valid substrings ending at the current index is determined by the minimum of the last occurrence pointers.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int numberOfSubstrings2(String s) {
        int lastA = -1, lastB = -1, lastC = -1;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                lastA = i;
            } else if (c == 'b') {
                lastB = i;
            } else if (c == 'c') {
                lastC = i;
            }

            if (lastA != -1 && lastB != -1 && lastC != -1) {
                result += Math.min(lastA, Math.min(lastB, lastC)) + 1;
            }
        }

        return result;
    }
}