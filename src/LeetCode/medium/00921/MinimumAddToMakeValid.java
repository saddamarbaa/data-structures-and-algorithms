/**
 921. Minimum Add to Make Parentheses Valid
 Medium

 A parentheses string is valid if and only if:

 It is the empty string,
 It can be written as AB (A concatenated with B), where A and B are valid strings, or
 It can be written as (A), where A is a valid string.
 You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

 For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 Return the minimum number of moves required to make s valid.



 Example 1:

 Input: s = "())"
 Output: 1
 Example 2:

 Input: s = "((("
 Output: 3


 Constraints:

 1 <= s.length <= 1000
 s[i] is either '(' or ')'.
 */

import java.util.Arrays;
import java.util.Stack;

public class MinimumAddToMakeValid {
    public static void main(String[] args) {
        String input1 = "())";
        int expected1 = 1;
        int result1 = minAddToMakeValid(input1);
        System.out.println("Test Case 1 - Input: " + input1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        String input2 = "(((";
        int expected2 = 3;
        int result2 = minAddToMakeValid(input2);
        System.out.println("Test Case 2 - Input: " + input2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        String input3 = "()";
        int expected3 = 0;
        int result3 = minAddToMakeValid(input3);
        System.out.println("Test Case 3 - Input: " + input3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));
    }


    public  static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the input string
        for (char c : s.toCharArray()) {
            // If the current character is a closing parenthesis ')'
            if (c == ')') {
                // Check if the top of the stack is an opening parenthesis '('
                if (!stack.isEmpty() && stack.peek() == '(') {
                    // If there is a match, pop the opening parenthesis from the stack
                    stack.pop();
                } else {
                    // Otherwise, push the closing parenthesis onto the stack
                    stack.push(c);
                }
            } else {
                // For an opening parenthesis '(', just push it onto the stack
                stack.push(c);
            }
        }

        // The size of the stack represents the number of unmatched parentheses
        return stack.size();
    }


    /**
     * Given a string containing only parentheses, return the minimum number of
     * parentheses we must add to make the string valid.
     *
     * Algorithm Steps:
     * 1. Traverse the string and track unbalanced parentheses.
     * 2. Count how many open parentheses '(' need closing.
     * 3. Count how many closing parentheses ')' need an open one.
     *
     * @param s - The input string containing parentheses.
     * @returns The minimum number of parentheses needed to make the string valid.
     *
     * Time Complexity: O(n) - We only traverse the string once.
     * Space Complexity: O(1) - We use constant extra space.
     */
    public static int minAddToMakeValid2(String s) {
        int open = 0; // Track unbalanced '('
        int closeNeeded = 0; // Track unmatched ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++; // Track unbalanced open parentheses
            } else {
                if (open > 0) {
                    open--; // Match a previously opened '('
                } else {
                    closeNeeded++; // No open parenthesis to match ')', so we need to add one
                }
            }
        }

        return open + closeNeeded; // Total parentheses needed to balance
    }
}
