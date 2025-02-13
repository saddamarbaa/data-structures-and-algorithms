/***
 1662. Check If Two String Arrays are Equivalent

 Easy

 Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

 A string is represented by an array if the array elements concatenated in order forms the string.

 Example 1:

 Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 Output: true
 Explanation:
 word1 represents string "ab" + "c" -> "abc"
 word2 represents string "a" + "bc" -> "abc"
 The strings are the same, so return true.
 Example 2:

 Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 Output: false
 Example 3:

 Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 Output: true


 Constraints:

 1 <= word1.length, word2.length <= 103
 1 <= word1[i].length, word2[i].length <= 103
 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 word1[i] and word2[i] consist of lowercase letters.
 */

public class CheckIfStringArraysAreEquivalent {

    public static void main(String[] args) {
        // Test Case 1
        /*
         * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
         * Expected Output: true
         */
        String[] word1_1 = {"ab", "c"};
        String[] word2_1 = {"a", "bc"};
        boolean result1 = arrayStringsAreEqual(word1_1, word2_1);
        System.out.println("Test Case 1 - Result: " + result1);  // true

        // Test Case 2
        /*
         * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
         * Expected Output: false
         */
        String[] word1_2 = {"a", "cb"};
        String[] word2_2 = {"ab", "c"};
        boolean result2 = arrayStringsAreEqual(word1_2, word2_2);
        System.out.println("Test Case 2 - Result: " + result2);  // false

        // Test Case 3
        /*
         * Input: word1 = ["abc", "d", "defg"], word2 = ["abcddefg"]
         * Expected Output: true
         */
        String[] word1_3 = {"abc", "d", "defg"};
        String[] word2_3 = {"abcddefg"};
        boolean result3 = arrayStringsAreEqual(word1_3, word2_3);
        System.out.println("Test Case 3 - Result: " + result3);  // true
    }

    /**
     * This method checks if two string arrays are equivalent by concatenating them
     * and comparing the final strings.
     *
     * Time Complexity: O(n), where n is the total number of characters in word1 and word2.
     * Space Complexity: O(n), where n is the combined length of the strings.
     *
     * @param word1 - The first string array.
     * @param word2 - The second string array.
     * @return true if the concatenated strings from word1 and word2 are equal, false otherwise.
     */
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return concatenate(word1).equals(concatenate(word2));
    }

    /**
     * Helper method to concatenate the elements of a string array into a single string.
     *
     * @param words - The string array.
     * @return The concatenated string.
     */
    private static String concatenate(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }
        return sb.toString();
    }
}
