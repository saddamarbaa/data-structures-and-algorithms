/*
  Given an integer x, return true if x is a palindrome, and false otherwise
  link
  https://leetcode.com/problems/palindrome-number/
  
   Example 1:
   Input: x = 121
   Output: true
   Explanation: 121 reads as 121 from left to right and from right to left.
   
   
   Example 2:
   Input: x = -121
   Output: false
   Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome
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
