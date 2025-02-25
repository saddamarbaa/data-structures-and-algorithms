/***
 1768. Merge Strings Alternately
 Easy
 You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

 Return the merged string.

 Example 1:

 Input: word1 = "abc", word2 = "pqr"
 Output: "apbqcr"
 Explanation: The merged string will be merged as so:
 word1:  a   b   c
 word2:    p   q   r
 merged: a p b q c r
 Example 2:

 Input: word1 = "ab", word2 = "pqrs"
 Output: "apbqrs"
 Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 word1:  a   b
 word2:    p   q   r   s
 merged: a p b q   r   s
 Example 3:

 Input: word1 = "abcd", word2 = "pq"
 Output: "apbqcd"
 Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 word1:  a   b   c   d
 word2:    p   q
 merged: a p b q c   d


 Constraints:

 1 <= word1.length, word2.length <= 100
 word1 and word2 consist of lowercase English letters.
 */
public class MergeStringsAlternately {

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        String word3 = "ab";
        String word4 = "pqrs";
        String word5 = "abcd";
        String word6 = "pq";

        // Test Case 1
        System.out.println("Test Case 1:");
        System.out.println("Merge Alternately: " + mergeStrings1(word1, word2)); // Output: "apbqcr"
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2:");
        System.out.println("Merge Alternately: " + mergeStrings1(word3, word4)); // Output: "apbqrs"
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3:");
        System.out.println("Merge Alternately: " + mergeStrings1(word5, word6)); // Output: "apbqcd"
    }

    /**
     * Solution 1: Merge Strings Alternately
     * Algorithm:
     * 1. Use two pointers to iterate over both strings.
     * 2. Alternate between the strings to merge them.
     * 3. Append any remaining characters from the longer string at the end.
     *
     * Time Complexity: O(max(n, m)), where n and m are the lengths of word1 and word2 respectively.
     * Space Complexity: O(n + m), where n and m are the lengths of word1 and word2 respectively.
     */
    public static String mergeStrings1(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0, j = 0;

        // Merge the characters alternately
        while (i < word1.length() && j < word2.length()) {
            merged.append(word1.charAt(i++));
            merged.append(word2.charAt(j++));
        }

        // Append any remaining characters from word1
        while (i < word1.length()) {
            merged.append(word1.charAt(i++));
        }

        // Append any remaining characters from word2
        while (j < word2.length()) {
            merged.append(word2.charAt(j++));
        }

        return merged.toString();
    }

}
