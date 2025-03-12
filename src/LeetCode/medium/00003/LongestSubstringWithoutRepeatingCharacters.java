import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols, and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        // Test Cases
        runTestCase("abcabcbb", 3);
        runTestCase("bbbbb", 1);
        runTestCase("pwwkew", 3);
        runTestCase("abcdef", 6);
        runTestCase("dvdf", 3);
        runTestCase("", 0); // Empty string edge case
        runTestCase("a", 1); // Single character edge case
    }

    // Method to run each test case
    public static void runTestCase(String s, int expected) {
        int result1 = lengthOfLongestSubstring(s);
        int result2 = lengthOfLongestSubstring2(s);
        int result3 = lengthOfLongestSubstring3(s);

        System.out.println("Test Case - Input: s = \"" + s + "\"");
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Sliding Window): " + result1);
        System.out.println("Result (HashMap): " + result2);
        System.out.println("Result (Brute Force): " + result3);
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected && result3 == expected));
        System.out.println();
    }



    public int lengthOfLongestSubstring5(String s) {
        // siding window

        HashSet<Character> charSet = new HashSet();
        int ans = 0;
        int left= 0;

        for(int right = 0; right < s.length(); right++){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    /**
     * Approach 1: Sliding Window (Optimized)
     *
     * Algorithm Steps:
     * 1. Use two pointers (`start` and `end`) to create a sliding window.
     * 2. Use a boolean array `seen` to track the characters in the current window.
     * 3. For each character, check if it's already seen, adjust the start pointer if necessary.
     * 4. Update the maximum length of the substring.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        boolean[] seen = new boolean[128]; // Assuming ASCII
        int start = 0, maxLength = 0;

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            while (seen[currentChar]) {
                seen[s.charAt(start)] = false;
                start++;
            }
            seen[currentChar] = true;
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    /**
     * Approach 2: HashMap (Track Last Seen Position)
     *
     * Algorithm Steps:
     * 1. Use a HashMap to store the last seen position of each character.
     * 2. Iterate through the string, and for each character, update the start pointer if the character was seen before.
     * 3. Calculate the length of the current window and update the maximum length.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(n), for the HashMap storing character indices.
     */
    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int start = 0, maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }
            charIndexMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    /**
     * Approach 3: Brute Force
     *
     * Algorithm Steps:
     * 1. Generate all substrings and check if each one contains unique characters.
     * 2. Track the maximum length of substrings with unique characters.
     *
     * Time Complexity: O(n^3), where n is the length of the string.
     * Space Complexity: O(1), as we use constant extra space.
     */
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (areAllUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    // Helper function to check if all characters in the substring are unique
    private static boolean areAllUnique(String s, int start, int end) {
        boolean[] seen = new boolean[128]; // Assuming ASCII
        for (int i = start; i <= end; i++) {
            char currentChar = s.charAt(i);
            if (seen[currentChar]) {
                return false;
            }
            seen[currentChar] = true;
        }
        return true;
    }
}
