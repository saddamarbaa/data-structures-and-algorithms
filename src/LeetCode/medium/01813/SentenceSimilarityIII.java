import java.util.*;

/**
 * 1813. Sentence Similarity III
 *
 * Medium
 *
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
 *
 * You are given two sentences, sentence1 and sentence2. You need to determine if sentence2 can be formed
 * by inserting, deleting, or replacing words in sentence1, or vice versa.
 *
 * Example 1:
 * Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
 * Output: true
 * Explanation: sentence2 can be formed by deleting "name is" from sentence1.
 *
 * Example 2:
 * Input: sentence1 = "Hello world", sentence2 = "Hello"
 * Output: true
 * Explanation: sentence2 can be formed by deleting "world" from sentence1.
 *
 * Example 3:
 * Input: sentence1 = "Hello world", sentence2 = "world Hello"
 * Output: false
 * Explanation: The words in sentence2 are not a rearrangement of the words in sentence1.
 *
 * Constraints:
 * - 1 <= sentence1.length, sentence2.length <= 100
 * - sentence1 and sentence2 consist of lowercase and uppercase English letters and spaces.
 * - The words in sentence1 and sentence2 are separated by a single space.
 */

public class SentenceSimilarityIII {

    public static void main(String[] args) {
        // Test Case 1
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        System.out.println("Test Case 1 - Are sentences similar? " + areSentencesSimilar(sentence1, sentence2)); // Expected: true

        // Test Case 2
        sentence1 = "Hello world";
        sentence2 = "Hello";
        System.out.println("Test Case 2 - Are sentences similar? " + areSentencesSimilar(sentence1, sentence2)); // Expected: true

        // Test Case 3
        sentence1 = "Hello world";
        sentence2 = "world Hello";
        System.out.println("Test Case 3 - Are sentences similar? " + areSentencesSimilar(sentence1, sentence2)); // Expected: false

        // Test Case 4
        sentence1 = "Hello world";
        sentence2 = "Hello world";
        System.out.println("Test Case 4 - Are sentences similar? " + areSentencesSimilar(sentence1, sentence2)); // Expected: true

        // Test Case 5
        sentence1 = "Hello world";
        sentence2 = "Hello there world";
        System.out.println("Test Case 5 - Are sentences similar? " + areSentencesSimilar(sentence1, sentence2)); // Expected: true
    }




        public static boolean areSentencesSimilar(String sentence1, String sentence2) {
            // Split both sentences into arrays of words
            String[] words1 = sentence1.split(" ");
            String[] words2 = sentence2.split(" ");

            int startIndex = 0;
            int endIndex = 0;

            // Compare words from the start
            while (startIndex < words1.length && startIndex < words2.length &&
                    words1[startIndex].equals(words2[startIndex])) {
                startIndex++;
            }

            // Compare words from the end
            while (endIndex < words1.length - startIndex && endIndex < words2.length - startIndex &&
                    words1[words1.length - 1 - endIndex].equals(words2[words2.length - 1 - endIndex])) {
                endIndex++;
            }

            // Check if all remaining words match
            return startIndex + endIndex == Math.min(words1.length, words2.length);
        }


    /**
     * Determines if two sentences are similar by checking if one can be formed by inserting, deleting, or replacing words in the other.
     *
     * Algorithm:
     * 1. Split both sentences into arrays of words.
     * 2. Use two pointers to compare the words from the beginning and end of both sentences.
     * 3. If the words match, move the pointers inward.
     * 4. If they don't match, check if the remaining words can form a subsequence of the other sentence.
     *
     * Time Complexity: O(n), where n is the number of words in the longer sentence.
     * Space Complexity: O(n), for storing the split words.
     *
     * @param sentence1 - The first sentence.
     * @param sentence2 - The second sentence.
     * @return true if the sentences are similar, false otherwise.
     */
    public static boolean areSentencesSimilar2(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        // Ensure words1 is the longer array
        if (words1.length < words2.length) {
            String[] temp = words1;
            words1 = words2;
            words2 = temp;
        }

        int n1 = words1.length;
        int n2 = words2.length;
        int left = 0, right1 = n1 - 1, right2 = n2 - 1;

        // Compare from the left
        while (left < n2 && words1[left].equals(words2[left])) {
            left++;
        }

        // Compare from the right
        while (right2 >= left && words1[right1].equals(words2[right2])) {
            right1--;
            right2--;
        }

        // If all words in the shorter sentence are matched, return true
        return left > right2;
    }
}