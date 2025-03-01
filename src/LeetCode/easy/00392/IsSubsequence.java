/***
 392. Is Subsequence

 Easy
 Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

 A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).


 Example 1:

 Input: s = "abc", t = "ahbgdc"
 Output: true
 Example 2:

 Input: s = "axc", t = "ahbgdc"
 Output: false

 Constraints:

 0 <= s.length <= 100
 0 <= t.length <= 104
 s and t consist only of lowercase English letters.


 Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */

public class IsSubsequence {

    public static void main(String[] args) {
        String s1 = "abc";
        String t1 = "ahbgdc";
        String s2 = "axc";
        String t2 = "ahbgdc";

        // Test Case 1
        System.out.println("Test Case 1:");
        System.out.println("Is Subsequence (Solution): " + isSubsequence(s1, t1)); // Output: true
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2:");
        System.out.println("Is Subsequence (Solution): " + isSubsequence(s2, t2)); // Output: false
    }

    /**
     * Solution: Two Pointers Approach
     * Algorithm:
     * 1. Use two pointers, one for the string `s` and one for the string `t`.
     * 2. Traverse through `t` and try to match each character in `s`.
     * 3. If all characters of `s` are matched in order, return true.
     * 4. If we reach the end of `t` without matching all characters of `s`, return false.
     *
     * Time Complexity: O(n + m), where n is the length of `s` and m is the length of `t`.
     * Space Complexity: O(1), as we only use a constant amount of extra space.
     */
    public static boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;  // Move the pointer on s if we have a match
            }
            tPointer++;  // Always move the pointer on t
        }

        // If we have gone through all characters in s, then s is a subsequence of t
        return sPointer == s.length();
    }
}
