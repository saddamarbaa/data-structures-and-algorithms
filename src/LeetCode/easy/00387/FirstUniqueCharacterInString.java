import java.util.HashMap;

/**
 * 387. First Unique Character in a String
 * Easy
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Explanation: The first non-repeating character is 'l' at index 0.
 *
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * Explanation: The first non-repeating character is 'v' at index 2.
 *
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * Explanation: There is no non-repeating character, so return -1.
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 */
public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        // Test Cases
        runTestCase("leetcode", 0);
        runTestCase("loveleetcode", 2);
        runTestCase("aabb", -1);
        runTestCase("abcabc", -1); // No unique character
        runTestCase("z", 0); // Single character
    }

    // Method to run each test case
    public static void runTestCase(String s, int expected) {
        int result1 = firstUniqChar(s);
        int result2 = firstUniqCharUsingMap(s);
        int result3 = firstUniqCharBruteForce(s);

        System.out.println("Test Case - Input: s = \"" + s + "\"");
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Optimized using Array): " + result1);
        System.out.println("Result (Using HashMap): " + result2);
        System.out.println("Result (Brute Force): " + result3);
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected && result3 == expected));
        System.out.println();
    }

    /**
     * Approach 1: Optimized using Array (Counting occurrences of characters)
     *
     * Algorithm Steps:
     * 1. Count the occurrences of each character in the string.
     * 2. Iterate through the string again, and return the index of the first character that appears exactly once.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), since the array is of fixed size (26 letters).
     */
    public static int firstUniqChar(String s) {
        int[] charCount = new int[26]; // For lowercase letters 'a' to 'z'

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i; // Return the index of the first unique character
            }
        }

        return -1; // Return -1 if no unique character is found
    }

    /**
     * Approach 2: Using HashMap (Generalized approach)
     *
     * Algorithm Steps:
     * 1. Use a HashMap to store the frequency of each character.
     * 2. Iterate through the string again, and return the index of the first character that appears exactly once.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(n), for the HashMap storing character frequencies.
     */
    public static int firstUniqCharUsingMap(String s) {
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        // Find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (charFrequencyMap.get(s.charAt(i)) == 1) {
                return i; // Return the index of the first unique character
            }
        }

        return -1; // Return -1 if no unique character is found
    }

    /**
     * Approach 3: Brute Force
     *
     * Algorithm Steps:
     * 1. For each character, check if it repeats in the rest of the string.
     * 2. If a character does not repeat, return its index.
     *
     * Time Complexity: O(n^2), where n is the length of the string.
     * Space Complexity: O(1), since we use no extra space besides the input string.
     */
    public static int firstUniqCharBruteForce(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            boolean isUnique = true;
            for (int j = 0; j < n; j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                return i; // Return the index of the first unique character
            }
        }

        return -1; // Return -1 if no unique character is found
    }
}
