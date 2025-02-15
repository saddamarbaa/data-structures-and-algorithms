/**
 * 5. Longest Palindromic Substring
 *
 * Medium
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * A string is called a palindrome if it reads the same backward as forward.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * - 1 <= s.length <= 1000
 * - s consist of only digits and English letters.
 */

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        // Test Case 1
        /*
         * Input: "babad"
         * Expected Output: "bab" or "aba"
         */
        String input1 = "babad";
        String result1 = longestPalindrome(input1);
        System.out.println("Test Case 1 - Longest Palindromic Substring: " + result1);

        // Test Case 2
        /*
         * Input: "cbbd"
         * Expected Output: "bb"
         */
        String input2 = "cbbd";
        String result2 = longestPalindrome(input2);
        System.out.println("Test Case 2 - Longest Palindromic Substring: " + result2);

        // Test Case 3
        /*
         * Input: "a"
         * Expected Output: "a"
         */
        String input3 = "a";
        String result3 = longestPalindrome(input3);
        System.out.println("Test Case 3 - Longest Palindromic Substring: " + result3);

        // Test Case 4
        /*
         * Input: "ac"
         * Expected Output: "a" or "c"
         */
        String input4 = "ac";
        String result4 = longestPalindrome(input4);
        System.out.println("Test Case 4 - Longest Palindromic Substring: " + result4);
    }


    // This method will expand around the given center (left, right) and return the longest palindrome substring.
    private static String expandAroundCenter(String s, int left, int right) {
        // Expand while the characters on the left and right are the same (it’s a palindrome).
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;   // Move the left pointer to the left.
            right++;  // Move the right pointer to the right.
        }
        // Return the palindrome substring (adjusting for the last non-palindromic expansion).
        return s.substring(left + 1, right);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return ""; // Base case: if string is empty or null, return empty string.

        String longest = "";  // This will store the longest palindrome found so far.

        // Loop through each character in the string.
        for (int i = 0; i < s.length(); i++) {
            // Expand around the character at index i (odd-length palindrome).
            String oddPalindrome = expandAroundCenter(s, i, i);
            // If the palindrome we just found is longer than the current longest, update it.
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }

            // Expand around the gap between i and i+1 (even-length palindrome).
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            // If the even palindrome is longer, update the longest palindrome.
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }

        // Return the longest palindrome found.
        return longest;
    }

    /**
     * Finds the longest palindromic substring in the given string.
     *
     * Algorithm:
     * 1. Expand around the center: Iterate through each character and treat it as the center of a potential palindrome.
     * 2. Expand around both single character centers (odd length palindromes) and between two characters (even length palindromes).
     * 3. Return the longest palindrome found.
     *
     * Time Complexity: O(n^2), where n is the length of the string.
     * Space Complexity: O(1), no extra space used except for variables.
     *
     * @param s - The input string.
     * @return The longest palindromic substring.
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter2(s, i, i); // Odd length palindrome
            int len2 = expandAroundCenter2(s, i, i + 1); // Even length palindrome
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * Expands around the given center indices and returns the length of the longest palindrome.
     *
     * Time Complexity: O(n) for each center expansion.
     *
     * @param s - The input string.
     * @param left - The starting left index.
     * @param right - The starting right index.
     * @return The length of the palindrome.
     */
    private static int expandAroundCenter2(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
