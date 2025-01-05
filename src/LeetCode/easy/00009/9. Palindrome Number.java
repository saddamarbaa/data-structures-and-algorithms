/*
9. Palindrome Number

Easy

Given an integer x, return true if x is a
palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

-231 <= x <= 231 - 1


Follow up: Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        // Test case 1 - Palindrome number
        int num1 = 121;
        boolean expected1 = true;
        boolean result1 = isPalindrome(num1);
        System.out.println("Test Case 1 - Input: " + num1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2 - Negative number, not a palindrome
        int num2 = -121;
        boolean expected2 = false;
        boolean result2 = isPalindrome(num2);
        System.out.println("Test Case 2 - Input: " + num2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3 - Single-digit number, always a palindrome
        int num3 = 7;
        boolean expected3 = true;
        boolean result3 = isPalindrome(num3);
        System.out.println("Test Case 3 - Input: " + num3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case 4 - Number ending with zero
        int num4 = 10;
        boolean expected4 = false;
        boolean result4 = isPalindrome(num4);
        System.out.println("Test Case 4 - Input: " + num4);
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));
    }

    /**
     * Algorithm to determine if a number is a palindrome:
     * 1. If the number is negative, return false since negative numbers are not palindromes.
     * 2. If the number is a single digit, return true since all single-digit numbers are palindromes.
     * 3. Reverse the number and compare it to the original number:
     *   - If they are the same, the number is a palindrome.
     *   - If not, the number is not a palindrome.
     *
     * Time Complexity: O(log(x)) - We process roughly half the digits of the number.
     * Space Complexity: O(1) - Constant space used for variables.
     */
    public static boolean isPalindrome(int x) {
        // If the number is negative or ends with 0 (but is not 0 itself), it's not a palindrome.
        if (x < 0 ) {
            return false;
        }

        int reversed = 0;
        int original = x;

        // Reverse the number
        while (x > 0) {
            int lastDigit = x % 10;
            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }

        // Compare the reversed number with the original
        return original == reversed;
    }

    public static boolean isPalindrome2(int x) {
        // Convert the number to a string
        String str = Integer.toString(x);

        // Use two pointers to check if the string is a palindrome
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
