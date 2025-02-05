import java.util.HashSet;
import java.util.Set;

/***
 859. Buddy Strings

 Easy

 Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

 Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

 For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

 Example 1:

 Input: s = "ab", goal = "ba"
 Output: true
 Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
 Example 2:

 Input: s = "ab", goal = "ab"
 Output: false
 Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
 Example 3:

 Input: s = "aa", goal = "aa"
 Output: true
 Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
 */

public class BuddyStrings {

    // ==================================================
    // Solution: Compare characters and handle edge cases
    // ==================================================
    public boolean buddyStrings(String s, String goal) {
        // If lengths are different, they cannot be made equal with one swap
        if (s.length() != goal.length()) {
            return false;
        }

        // If s and goal are the same, check if there are duplicate characters to swap
        if (s.equals(goal)) {
            // Use a set to check for duplicate characters
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
                if (count[c - 'a'] > 1) {
                    return true; // Duplicate characters exist, so swapping is possible
                }
            }
            return false; // No duplicates, cannot swap
        }

        // Find the indices where the characters differ
        int firstMismatch = -1;
        int secondMismatch = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (firstMismatch == -1) {
                    firstMismatch = i; // Record the first mismatch
                } else if (secondMismatch == -1) {
                    secondMismatch = i; // Record the second mismatch
                } else {
                    // If there are more than two mismatches, one swap is not enough
                    return false;
                }
            }
        }

        // If there is only one mismatch, one swap cannot fix it
        if (secondMismatch == -1) {
            return false;
        }

        // Check if swapping the two mismatched characters makes the strings equal
        return s.charAt(firstMismatch) == goal.charAt(secondMismatch) &&
                s.charAt(secondMismatch) == goal.charAt(firstMismatch);
    }


    public  static  boolean buddyStrings2(String s1, String s2) {
        // If the lengths are different, they cannot be made equal with one swap
        if (s1.length() != s2.length()) {
            return false;
        }

        if(s1.equals(s2)){
            Set<Character> set = new HashSet<>();
            for(char ch: s1.toCharArray()){
                set.add(ch);
            }

            if(set.size() == s1.length()){
                return false;
            }else{
                return true;
            }
        }

        // Find the indices where the characters differ
        int firstMismatch = -1;
        int secondMismatch = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (firstMismatch == -1) {
                    firstMismatch = i; // Record the first mismatch
                } else if (secondMismatch == -1) {
                    secondMismatch = i; // Record the second mismatch
                } else {
                    // If there are more than two mismatches, one swap is not enough
                    return false;
                }
            }
        }

        // If there are no mismatches, the strings are already equal
        if (firstMismatch == -1 && secondMismatch == -1) {
            return true;
        }

        // If there is only one mismatch, one swap cannot fix it
        if (secondMismatch == -1) {
            return false;
        }

        // Check if swapping the two mismatched characters makes the strings equal
        return s1.charAt(firstMismatch) == s2.charAt(secondMismatch) &&
                s1.charAt(secondMismatch) == s2.charAt(firstMismatch);
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        BuddyStrings solution = new BuddyStrings();

        // Test case 1:
        // Input: s = "ab", goal = "ba"
        // Expected output: true
        String s1 = "ab";
        String goal1 = "ba";
        boolean result1 = solution.buddyStrings(s1, goal1);
        System.out.println("Test case 1: " + result1); // Output: true

        // Test case 2:
        // Input: s = "ab", goal = "ab"
        // Expected output: false
        String s2 = "ab";
        String goal2 = "ab";
        boolean result2 = solution.buddyStrings(s2, goal2);
        System.out.println("Test case 2: " + result2); // Output: false

        // Test case 3:
        // Input: s = "aa", goal = "aa"
        // Expected output: true
        String s3 = "aa";
        String goal3 = "aa";
        boolean result3 = solution.buddyStrings(s3, goal3);
        System.out.println("Test case 3: " + result3); // Output: true

        // Test case 4:
        // Input: s = "aaaaaaabc", goal = "aaaaaaacb"
        // Expected output: true
        String s4 = "aaaaaaabc";
        String goal4 = "aaaaaaacb";
        boolean result4 = solution.buddyStrings(s4, goal4);
        System.out.println("Test case 4: " + result4); // Output: true

        // Test case 5:
        // Input: s = "abcd", goal = "badc"
        // Expected output: false
        String s5 = "abcd";
        String goal5 = "badc";
        boolean result5 = solution.buddyStrings(s5, goal5);
        System.out.println("Test case 5: " + result5); // Output: false
    }
}