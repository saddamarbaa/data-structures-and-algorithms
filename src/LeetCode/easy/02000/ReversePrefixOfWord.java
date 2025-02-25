/***
 2000. Reverse Prefix of Word

 Easy
 Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

 For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
 Return the resulting string.

 Example 1:

 Input: word = "abcdefd", ch = "d"
 Output: "dcbaefd"
 Explanation: The first occurrence of "d" is at index 3.
 Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
 Example 2:

 Input: word = "xyxzxe", ch = "z"
 Output: "zxyxxe"
 Explanation: The first and only occurrence of "z" is at index 3.
 Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
 Example 3:

 Input: word = "abcd", ch = "z"
 Output: "abcd"
 Explanation: "z" does not exist in word.
 You should not do any reverse operation, the resulting string is "abcd".


 Constraints:

 1 <= word.length <= 250
 word consists of lowercase English letters.
 ch is a lowercase English letter.
 */
public class ReversePrefixOfWord {

    public static void main(String[] args) {
        String word1 = "abcdefd";
        char ch1 = 'd';
        String word2 = "xyxzxe";
        char ch2 = 'z';
        String word3 = "abcd";
        char ch3 = 'z';

        // Test Case 1
        System.out.println("Test Case 1:");
        System.out.println("Reverse Prefix (Solution 1): " + reversePrefix(word1, ch1)); // Output: "dcbaefd"
        System.out.println("Reverse Prefix (Solution 2): " + reversePrefix2(word1, ch1)); // Output: "dcbaefd"
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2:");
        System.out.println("Reverse Prefix (Solution 1): " + reversePrefix(word2, ch2)); // Output: "zxyxxe"
        System.out.println("Reverse Prefix (Solution 2): " + reversePrefix2(word2, ch2)); // Output: "zxyxxe"
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3:");
        System.out.println("Reverse Prefix (Solution 1): " + reversePrefix(word3, ch3)); // Output: "abcd"
        System.out.println("Reverse Prefix (Solution 2): " + reversePrefix2(word3, ch3)); // Output: "abcd"
    }

    /**
     * Solution 1: Reverse Prefix of Word using StringBuilder
     * Algorithm:
     * 1. Find the index of the first occurrence of the character ch.
     * 2. Reverse the substring from 0 to that index (inclusive).
     * 3. Append the remaining part of the word after the reversed substring.
     *
     * Time Complexity: O(n), where n is the length of the word.
     * Space Complexity: O(n), for creating the resulting string.
     */
    public static String reversePrefix(String word, char ch) {
        // Find the first occurrence of 'ch'
        int idx = word.indexOf(ch);

        // If 'ch' is not found, return the original word
        if (idx == -1) {
            return word;
        }

        // Reverse the prefix from 0 to idx
        StringBuilder reversed = new StringBuilder(word.substring(0, idx + 1));
        reversed.reverse();

        // Append the rest of the word after the reversed part
        return reversed.append(word.substring(idx + 1)).toString();
    }

    /**
     * Solution 2: Reverse Prefix of Word using char array
     * Algorithm:
     * 1. Find the index of the first occurrence of the character ch.
     * 2. Reverse the characters between index 0 and the first occurrence of ch (inclusive).
     * 3. Convert the array back to a string and return.
     *
     * Time Complexity: O(n), where n is the length of the word.
     * Space Complexity: O(n), for the character array.
     */
    public static String reversePrefix2(String word, char ch) {
        char[] str = word.toCharArray();

        // Find the first occurrence of 'ch' and reverse the prefix
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                reverse(str, 0, i);
                break;
            }
        }

        return new String(str);
    }

    // Helper method to reverse a section of a char array
    public static void reverse(char[] str, int left, int right) {
        while (left <= right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
}
