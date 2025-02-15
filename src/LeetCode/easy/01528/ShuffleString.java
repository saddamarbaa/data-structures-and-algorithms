import java.util.*;

/**
 * 1528. Shuffle String
 *
 * Easy
 *
 * You are given a string s and an integer array indices of the same length. The string s will be shuffled such that
 * the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Return the shuffled string.
 *
 * Example 1:
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * Output: "leetcode"
 * Explanation: As per indices, the characters are rearranged as follows:
 * 'c' moves to index 4, 'o' moves to index 5, and so on.
 *
 * Example 2:
 * Input: s = "abc", indices = [0,1,2]
 * Output: "abc"
 * Explanation: Since the indices array matches the original positions, the string remains unchanged.
 *
 * Constraints:
 * - s.length == indices.length
 * - 1 <= s.length <= 100
 * - s consists of only lowercase English letters.
 * - 0 <= indices[i] < s.length
 * - All values of indices are unique.
 */

public class ShuffleString {

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "codeleet";
        int[] indices1 = {4, 5, 6, 7, 0, 2, 1, 3};
        String result1 = restoreString(s1, indices1);
        System.out.println("Test Case 1 - Output: " + result1);  // Expected output: "leetcode"

        // Test Case 2
        String s2 = "abc";
        int[] indices2 = {0, 1, 2};
        String result2 = restoreString(s2, indices2);
        System.out.println("Test Case 2 - Output: " + result2);  // Expected output: "abc"

        // Test Case 3
        String s3 = "aiohn";
        int[] indices3 = {3, 1, 4, 2, 0};
        String result3 = restoreString(s3, indices3);
        System.out.println("Test Case 3 - Output: " + result3);  // Expected output: "nihao"
    }

    /**
     * Restores the shuffled string to its original order based on the given indices.
     *
     * Algorithm:
     * 1. Create a character array of the same length as the input string.
     * 2. Use the indices array to place each character from the original string at the correct position.
     * 3. Convert the character array back to a string and return the result.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(n), for storing the result array.
     *
     * @param s - The shuffled string.
     * @param indices - The array of indices indicating the new positions of characters.
     * @return The restored string in the correct order.
     */
    public static String restoreString(String s, int[] indices) {
        // Create a character array to store the shuffled characters in the correct order
        char[] result = new char[s.length()];

        // Loop through each character and place it in the correct position as per indices array
        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }

        // Convert the character array to a string and return it
        return new String(result);
    }
}
