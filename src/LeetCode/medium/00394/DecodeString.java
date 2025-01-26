import java.util.Stack;

/**
 394. Decode String
Medium
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 */
public class DecodeString {
    
    public String decodeString(String s) {
        // Stack to hold the current string and current number
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;
        
        // Traverse the input string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the current number (it could be more than one digit)
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current number and string onto their respective stacks
                numStack.push(currentNum);
                stringStack.push(currentString);
                // Reset the current number and string
                currentNum = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                // Pop the number and string from the stack
                int repeatTimes = numStack.pop();
                StringBuilder prevString = stringStack.pop();
                
                // Repeat the current string the appropriate number of times
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentString);
                }
                
                // Append the repeated string to the previous string
                currentString = prevString.append(temp);
            } else {
                // Append the current character to the string
                currentString.append(c);
            }
        }
        
        // Return the decoded string
        return currentString.toString();
    }

    // Main method with test cases
    public static void main(String[] args) {
        DecodeString decoder = new DecodeString();
        
        // Test case 1
        System.out.println("Decoded String: " + decoder.decodeString("3[a]2[bc]")); // Output: "aaabcbc"
        
        // Test case 2
        System.out.println("Decoded String: " + decoder.decodeString("3[a2[c]]")); // Output: "accaccacc"
        
        // Test case 3
        System.out.println("Decoded String: " + decoder.decodeString("2[abc]3[cd]ef")); // Output: "abcabccdcdcdef"
        
        // Test case 4
        System.out.println("Decoded String: " + decoder.decodeString("abc3[cd]xyz")); // Output: "abccdccdcdxyz"
    }
}
