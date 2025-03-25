import java.util.Arrays;

/**
 * 424. Longest Repeating Character Replacement
 *
 * You are given a string s and an integer k. You can choose any character of the string and change it
 * to any other uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing
 * the above operations.
 *
 * Example:
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        // Test Cases
        runTestCase("ABAB", 2, 4);
        runTestCase("AABABBA", 1, 4);
        runTestCase("AAAA", 2, 4);
        runTestCase("ABCDE", 1, 2);
        runTestCase("AAABBC", 3, 6);
    }

    // Method to run each test case
    public static void runTestCase(String s, int k, int expected) {
        int result1 = characterReplacement(s, k);
        int result2 = characterReplacement2(s, k);

        System.out.println("Test Case - Input: s = " + s + ", k = " + k);
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Sliding Window Approach): " + result1);
        System.out.println("Result (Optimized Sliding Window Approach): " + result2);
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected));
        System.out.println();
    }

    /**
     * Approach 1: Sliding Window Approach
     *
     * Algorithm Steps:
     * 1. Use a sliding window to track the current substring.
     * 2. Maintain a frequency count of characters in the current window.
     * 3. For each window, calculate the number of replacements needed (window length - max frequency).
     * 4. Adjust the window based on whether replacements needed exceed k.
     * 5. Keep track of the maximum valid window length.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), as we use a fixed-size array for character counts.
     */
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            maxCount = Math.max(maxCount, count[c - 'A']);

            while (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Approach 2: Optimized Sliding Window Approach
     *
     * Algorithm Steps:
     * 1. Similar to the first approach but optimized by not shrinking the window.
     * 2. The window only grows or moves right, maintaining the maximum possible size.
     * 3. We track the maximum frequency encountered so far.
     * 4. The window is valid if (window length - max frequency <= k).
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), as we use a fixed-size array for character counts.
     */
    public static int characterReplacement2(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            maxCount = Math.max(maxCount, count[c - 'A']);

            if (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}