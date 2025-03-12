import java.util.HashMap;
import java.util.HashSet;

/**
 * 2351. First Letter to Appear Twice
 * Easy
 *
 * Given a string s consisting of lowercase English letters, return the first letter to appear twice.
 *
 * Example 1:
 * Input: s = "abccbaacz"
 * Output: "c"
 * Explanation: The letter 'c' is the first letter to appear twice, since it appears at indices 2 and 3.
 *
 * Example 2:
 * Input: s = "abcdd"
 * Output: "d"
 * Explanation: The letter 'd' is the first letter to appear twice, since it appears at indices 3 and 4.
 *
 * Constraints:
 * 1 <= s.length <= 100
 * s consists of lowercase English letters.
 */
public class FirstLetterToAppearTwice {
    public static void main(String[] args) {
        // Test Cases
        runTestCase("abccbaacz", 'c');
        runTestCase("abcdd", 'd');
        runTestCase("abcd", '\0'); // No letter repeats
        runTestCase("aabbcc", 'a'); // Edge case with first repeating letter at the start
    }

    // Method to run each test case
    public static void runTestCase(String s, char expected) {
        char result1 = firstLetterToAppearTwice(s);
        char result2 = firstLetterToAppearTwiceUsingSet(s);
        char result3 = firstLetterToAppearTwiceBruteForce(s);

        System.out.println("Test Case - Input: s = \"" + s + "\"");
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Using Array): " + result1);
        System.out.println("Result (Using HashSet): " + result2);
        System.out.println("Result (Brute Force): " + result3);
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected && result3 == expected));
        System.out.println();
    }

    /**
     * Approach 1: Using Array (Optimized for lowercase letters)
     *
     * Algorithm Steps:
     * 1. Use an array of size 26 to track the count of each letter (since there are 26 lowercase letters).
     * 2. Iterate through the string and check if a letter has been seen before.
     * 3. Return the first letter that appears twice.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), as we use constant extra space (array of size 26).
     */
    public static char firstLetterToAppearTwice(String s) {
        boolean[] seen = new boolean[26]; // For lowercase letters 'a' to 'z'

        for (char c : s.toCharArray()) {
            if (seen[c - 'a']) {
                return c; // Return the first letter that appears twice
            }
            seen[c - 'a'] = true;
        }

        return '\0'; // Return null character if no letter appears twice
    }

    /**
     * Approach 2: Using HashSet (Generalized approach)
     *
     * Algorithm Steps:
     * 1. Use a HashSet to store the characters as we iterate through the string.
     * 2. If a character is already in the HashSet, return that character.
     * 3. If no character repeats, return '\0'.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(n), for the HashSet storing characters.
     */
    public static char firstLetterToAppearTwiceUsingSet(String s) {
        HashSet<Character> seen = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }

        return '\0'; // Return null character if no letter appears twice
    }

    /**
     * Approach 3: Brute Force
     *
     * Algorithm Steps:
     * 1. For each character, iterate through the remaining part of the string to check for duplicates.
     * 2. Return the first character that appears twice.
     *
     * Time Complexity: O(n^2), where n is the length of the string.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static char firstLetterToAppearTwiceBruteForce(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return s.charAt(i);
                }
            }
        }

        return '\0'; // Return null character if no letter appears twice
    }
}
