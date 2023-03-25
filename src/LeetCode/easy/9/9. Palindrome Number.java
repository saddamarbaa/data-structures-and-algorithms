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

public class PalindromeCheck {
  public static boolean isPalindrome(int number) {
    int originalNumber = number;
    int reverse = 0;
    while (number != 0) {
      int lastDigit = number % 10;
      reverse = reverse * 10 + lastDigit;
      number /= 10;
    }
    return originalNumber == reverse;
  }

  public static void main(String[] args) {
    int number = 121;
    if (isPalindrome(number)) {
      System.out.println(number + " is a palindrome");
    } else {
      System.out.println(number + " is not a palindrome");
    }
  }
}
