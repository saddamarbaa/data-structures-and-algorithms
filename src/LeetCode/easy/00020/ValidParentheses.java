/**
 20. Valid Parentheses
 Easy
 Topics
 Companies
 Hint
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Every close bracket has a corresponding open bracket of the same type.


 Example 1:

 Input: s = "()"

 Output: true

 Example 2:

 Input: s = "()[]{}"

 Output: true

 Example 3:

 Input: s = "(]"

 Output: false

 Example 4:

 Input: s = "([])"

 Output: true
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String input1 = "()[]{}";
        boolean expected1 = true;
        boolean result1 = isValid(input1);
        System.out.println("Test Case 1 - Input: " + input1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        String input2 = "(]";
        boolean expected2 = false;
        boolean result2 = isValid(input2);
        System.out.println("Test Case 2 - Input: " + input2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        String input3 = "([)]";
        boolean expected3 = false;
        boolean result3 = isValid(input3);
        System.out.println("Test Case 3 - Input: " + input3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));
    }

    /**
     * Checks if the given string of parentheses is valid.
     *
     * Algorithm:
     * 1. Use a stack to store opening parentheses.
     * 2. For each closing parenthesis, check if it matches the last opened one.
     * 3. The string is valid if the stack is empty at the end.
     *
     * @param s - The input string containing parentheses.
     * @returns True if the parentheses are valid, false otherwise.
     *
     * Time Complexity: O(n) - Linear time complexity as we iterate through the string once.
     * Space Complexity: O(n) - Space is used by the stack in the worst case.
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // Map to store matching parentheses pairs
        HashMap<Character, Character> matchingParentheses = new HashMap<>();
        matchingParentheses.put(')', '(');
        matchingParentheses.put('}', '{');
        matchingParentheses.put(']', '[');

        for (char c : s.toCharArray()) {
            // If it's a closing bracket
            if (matchingParentheses.containsKey(c)) {
                // Pop the top of the stack if it's not empty, otherwise use a dummy value '#'
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                // If the top doesn't match the corresponding opening bracket, return false
                if (topElement != matchingParentheses.get(c)) {
                    return false;
                }
            } else {
                // If it's an opening bracket, push it to the stack
                stack.push(c);
            }
        }
        // Stack should be empty if the parentheses are valid
        return stack.isEmpty();
    }

    /**
     * Validates if the string of parentheses is balanced and correctly nested using a stack.
     * Steps:
     * 1. Use a stack to track opening brackets.
     * 2. When encountering a closing bracket, check if the top of the stack matches the corresponding opening bracket.
     * 3. If all brackets are matched and the stack is empty at the end, return true.
     * 4. If there's any mismatch or the stack is not empty at the end, return false.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(n), as a stack is used to store opening brackets.
     */
    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Checks the validity of parentheses using an iterative approach.
     * Algorithm:
     * 1. Initialize a HashMap with pairs of parentheses.
     * 2. Use a stack to match open and close parentheses.
     * 3. If the stack is empty at the end, return true, otherwise return false.
     *
     * Time Complexity: O(n) - Iterates through the string once.
     * Space Complexity: O(n) - The stack uses extra space.
     */
    public static boolean isValid3(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();

                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
