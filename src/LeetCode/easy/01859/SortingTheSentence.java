import java.util.*;

/**
 * 1859. Sorting the Sentence
 *
 * Easy
 *
 * A **sentence** is a list of words that are separated by a single space with no leading or trailing spaces.
 * Each word consists of lowercase and uppercase English letters. A sentence can be shuffled by appending the
 * 1-indexed word position to each word then rearranging the words in the sentence.
 *
 * Given a shuffled sentence s containing no leading or trailing spaces, and a single space separating each word,
 * return the original sentence.
 *
 * Example 1:
 * Input: s = "is2 sentence4 This1 a3"
 * Output: "This is a sentence"
 * Explanation: The words in "This1 is2 a3 sentence4" are rearranged to form the sentence "This is a sentence".
 *
 * Example 2:
 * Input: s = "Myself2 Me1 I4 and3"
 * Output: "Me Myself and I"
 *
 * Constraints:
 * - 2 <= s.length <= 200
 * - s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
 * - The number of words in s is between 1 and 9.
 * - The words in s are separated by a single space.
 * - s contains no leading or trailing spaces.
 */

public class SortingTheSentence {

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "is2 sentence4 This1 a3";
        String result1 = sortSentence(s1);
        System.out.println("Test Case 1 - Output: " + result1);  // Expected output: "This is a sentence"

        // Test Case 2
        String s2 = "Myself2 Me1 I4 and3";
        String result2 = sortSentence(s2);
        System.out.println("Test Case 2 - Output: " + result2);  // Expected output: "Me Myself and I"

        // Test Case 3
        String s3 = "Coding4 Fun1 is2 really3";
        String result3 = sortSentence(s3);
        System.out.println("Test Case 3 - Output: " + result3);  // Expected output: "Fun is really Coding"
    }


    public static String sortSentence2(String s) {
        String[] str = s.split(" ");                // Since the String contains only whitespaces, it's safe to split the String at them
        String[] res = new String[str.length];      // This String array will hold the rearranged words
        StringBuilder sb = new StringBuilder();     // Instead of using '+' operator to concat repeatedly, I have created a StringBuilder object which is more efficient
        int i = 0;
        for (String elem : str) {
            i = (int) (elem.charAt(elem.length() - 1) - '0');  // This  will extract the digit present at the end of each String and store it in i (i = index of the word in res[])
            res[i - 1] = elem.substring(0, elem.length() - 1); // This gives the substring of each String except for the digit in the end and stores the word at an appropriate index (i - 1) in res[]
        }
        //append the words from res[] to StringBuilder object to form a sentence
        for (i = 0; i < res.length - 1; i++)
            sb.append(res[i]).append(" ");
        sb.append(res[i]);
        return sb.toString();
    }

    /**
     * Sorts the shuffled sentence and returns the original sentence.
     *
     * Algorithm:
     * 1. Split the sentence into words.
     * 2. Extract the numerical index from each word and place the word in the corresponding position.
     * 3. Rebuild the sentence in the correct order.
     *
     * Time Complexity: O(n), where n is the number of characters in the input sentence.
     * Space Complexity: O(n), for storing the result and the split words.
     *
     * @param s - The shuffled sentence.
     * @return The original sentence in correct order.
     */
    public static String sortSentence(String s) {
        // Split the input string into words
        String[] words = s.split(" ");
        // Create an array to hold the words in the correct order
        String[] result = new String[words.length];

        // Process each word
        for (String word : words) {
            // Extract the position from the last character
            int position = Character.getNumericValue(word.charAt(word.length() - 1)) - 1;
            // Remove the last character (the position number) and store the word at the correct index
            result[position] = word.substring(0, word.length() - 1);
        }

        // Join the words to form the original sentence and return
        return String.join(" ", result);
    }
}
