/**
1400. Construct K Palindrome Strings
Medium
Hint
Given a string s and an integer k, return true if you can use all the characters in s to construct non-empty k 
palindrome strings
 or false otherwise.

Example 1:

Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
Example 2:

Input: s = "leetcode", k = 3
Output: false
Explanation: It is impossible to construct 3 palindromes using all the characters of s.
Example 3:

Input: s = "true", k = 4
Output: true
Explanation: The only possible solution is to put each character in a separate string.
 */
public class ConstructKPalindromeStrings {

      public boolean canConstruct2(String s, int k) {
        // If k is greater than the length of the string, it's impossible
        if (k > s.length()) {
            return false;
        }

        // Use a HashMap to count the frequency of each character
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Count how many characters have an odd frequency
        int oddCount = 0;
        for (int count : charCountMap.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // To divide into k palindrome strings:
        // - At most k characters can have an odd frequency, because each palindrome string can only
        //   have at most one character with an odd frequency in the center.
        // - The number of odd frequency characters must be less than or equal to k.
        return oddCount <= k;
    }

    
    public boolean canConstruct(String s, int k) {
        // If k is greater than the length of the string, it's impossible
        if (k > s.length()) {
            return false;
        }

        // Count the frequency of each character
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Count how many characters have an odd frequency
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // To divide into k palindrome strings:
        // - At most k characters can have an odd frequency, because each palindrome string can only
        //   have at most one character with an odd frequency in the center.
        // - The number of odd frequency characters must be less than or equal to k.
        return oddCount <= k;
    }

    // Main method with test cases
    public static void main(String[] args) {
        ConstructKPalindromeStrings solver = new ConstructKPalindromeStrings();

        // Test case 1
        System.out.println(solver.canConstruct("aabbcc", 3)); // Output: true

        // Test case 2
        System.out.println(solver.canConstruct("aabbc", 3)); // Output: true

        // Test case 3
        System.out.println(solver.canConstruct("aaa", 2)); // Output: false

        // Test case 4
        System.out.println(solver.canConstruct("abc", 3)); // Output: true

        // Test case 5
        System.out.println(solver.canConstruct("aaabb", 3)); // Output: true
    }
}
