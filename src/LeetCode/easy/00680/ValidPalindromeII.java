/***
 680. Valid Palindrome II
 Easy
 Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 Example 1:

 Input: s = "aba"
 Output: true
 Example 2:

 Input: s = "abca"
 Output: true
 Explanation: You could delete the character 'c'.
 Example 3:

 Input: s = "abc"
 Output: false

 Constraints:

 1 <= s.length <= 105
 s consists of lowercase English letters.
 */
public class ValidPalindromeII {

    public static void main(String[] args) {
        // Test Case 1
        /*
         * Input: "aba"
         * Expected Output: true
         * Explanation: The string is already a palindrome.
         */
        String input1 = "aba";
        boolean result1 = validPalindrome(input1);
        System.out.println("Test Case 1 - Result: " + result1);

        // Test Case 2
        /*
         * Input: "abca"
         * Expected Output: true
         * Explanation: You could delete the character 'c' to make it a palindrome.
         */
        String input2 = "abca";
        boolean result2 = validPalindrome(input2);
        System.out.println("Test Case 2 - Result: " + result2);

        // Test Case 3
        /*
         * Input: "abc"
         * Expected Output: false
         * Explanation: You cannot make it a palindrome by deleting at most one character.
         */
        String input3 = "abc";
        boolean result3 = validPalindrome(input3);
        System.out.println("Test Case 3 - Result: " + result3);

        // Test Case 4
        /*
         * Input: "deeee"
         * Expected Output: true
         * Explanation: You could delete the character 'd' to make it a palindrome.
         */
        String input4 = "deeee";
        boolean result4 = validPalindrome(input4);
        System.out.println("Test Case 4 - Result: " + result4);
    }

    /**
     * Checks if a string can be a palindrome by deleting at most one character.
     * Algorithm:
     * 1. Use two pointers, one at the start (left) and one at the end (right) of the string.
     * 2. Move the pointers towards each other while checking if the characters match.
     * 3. If a mismatch is found, try skipping either the left or right character and check if the remaining string is a palindrome.
     * 4. If at most one character is skipped and the string becomes a palindrome, return true; otherwise, return false.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), as no additional space is used.
     *
     * @param s - The input string.
     * @return true if the string can be a palindrome by deleting at most one character; otherwise, false.
     */
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Try skipping the left character or the right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Helper method to check if a substring is a palindrome.
     *
     * @param s - The input string.
     * @param left - The starting index of the substring.
     * @param right - The ending index of the substring.
     * @return true if the substring is a palindrome; otherwise, false.
     */
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}