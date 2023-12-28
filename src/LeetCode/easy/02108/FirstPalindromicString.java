/**
 2108. Find First Palindromic String in the Array
 Easy

 Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".

 A string is palindromic if it reads the same forward and backward.

 Example 1:

 Input: words = ["abc","car","ada","racecar","cool"]
 Output: "ada"
 Explanation: The first string that is palindromic is "ada".
 Note that "racecar" is also palindromic, but it is not the first.
 Example 2:

 Input: words = ["notapalindrome","racecar"]
 Output: "racecar"
 Explanation: The first and only string that is palindromic is "racecar".
 Example 3:

 Input: words = ["def","ghi"]
 Output: ""
 Explanation: There are no palindromic strings, so the empty string is returned.

 Constraints:

 1 <= words.length <= 100
 1 <= words[i].length <= 100
 words[i] consists only of lowercase English letters.
 */

import java.util.Arrays;

public class FirstPalindromicString {
    public static void main(String[] args) {
        String[] words1 = {"abc", "car", "ada", "racecar", "cool"};
        String result1 = firstPalindrome(words1);
        String expected1 = "ada";
        printResult(words1, result1, expected1);

        String[] words2 = {"notapalindrome", "racecar"};
        String result2 = firstPalindrome(words2);
        String expected2 = "racecar";
        printResult(words2, result2, expected2);

        String[] words3 = {"def", "ghi"};
        String result3 = firstPalindrome(words3);
        String expected3 = "";
        printResult(words3, result3, expected3);
    }


    /**
     * Algorithm Steps:
     * 1. Iterate Over Each Word:
     *    - For each word in the given array, check if it is a palindrome.
     *    - Use a helper method `isPalindrome` to determine if a word is a palindrome.
     *    - If a palindrome is found, return that word as the first palindromic string.
     *
     * 2. Return Empty String if No Palindrome Found:
     *    - If no palindromic string is found during the iteration, return an empty string.
     *
     * 3. Helper Method isPalindrome:
     *    - Check if a given word is a palindrome.
     *    - Use two pointers, one starting from the beginning and the other from the end of the word.
     *    - Compare characters at both pointers and move towards each other until they meet.
     *    - If all characters match, the word is a palindrome.
     *
     * Time Complexity:
     *    - The time complexity is O(N * M), where N is the number of words and M is the maximum length
     *      of a word. This is because we iterate over each word and check if it is a palindrome.
     *
     * Space Complexity:
     *    - The space complexity is O(1) as no additional space is used except for temporary variables.
     */
    public static String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Helper method to print test results
    private static void printResult(String[] input, String result, String expected) {
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        System.out.println("Result matches expected: " + result.equals(expected));
        System.out.println();
    }
}
