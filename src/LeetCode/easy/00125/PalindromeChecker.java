/**
 125. Valid Palindrome
Easy
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */

public class PalindromeChecker {

    public static void main(String[] args) {
        testIsPalindrome("A man, a plan, a canal: Panama", true);
        testIsPalindrome("race a car", false);
        testIsPalindrome("Was it a car or a cat I saw?", true);
        testIsPalindrome("No 'x' in Nixon", true);
        testIsPalindrome(" ", true);
    }




    public static void testIsPalindrome(String input, boolean expected) {
      boolean result = isPalindrome(input);
      System.out.println("Input: \"" + input + "\", Expected: " + expected + ", Result: " + result);
      System.out.println("Test passed: " + (result == expected));
      System.out.println();
    }
    

  /**
 * Algorithm Steps:
 * 1. Create a StringBuilder to store the cleaned string.
 *    - Iterate over each character in the input string.
 *    - Check if the character is a letter or digit using Character.isLetterOrDigit.
 *    - If it is, convert it to lowercase and append it to the StringBuilder.
 *
 * 2. Compare characters from the left and right in the cleaned string.
 *    - Initialize two pointers, left and right, at the start and end of the cleaned string.
 *    - Iterate until left is less than right.
 *    - If characters at positions left and right are not equal, return false.
 *    - Increment left and decrement right in each iteration.
 *
 * 3. If the loop completes without returning false, the string is a palindrome.
 *    - Return true.
 *
 * Time Complexity:
 *    - O(n) where n is the length of the cleaned string. The method iterates over the string once.
 *
 * Space Complexity:
 *    - O(n) where n is the length of the cleaned string. The StringBuilder stores the cleaned string.
 */

    public static boolean isPalindrome(String inputString) {
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                resultBuilder.append(Character.toLowerCase(currentChar));
            }
        }

        String cleanedString = resultBuilder.toString();

        int left = 0;
        int right = cleanedString.length() - 1;

        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
