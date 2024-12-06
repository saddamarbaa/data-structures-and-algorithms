import java.util.Arrays;

/**
 * 344. Reverse String
 * Easy
 *
 * Write a function that reverses a string using recursion.
 *
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */

public class ReverseString {

    public static void main(String[] args) {
        // Test cases for checking Reverse String using recursion
        testReverseString(new char[]{'h','e','l','l','o'}, new char[]{'o','l','l','e','h'});
        testReverseString(new char[]{'H','a','n','n','a','h'}, new char[]{'h','a','n','n','a','H'});
        testReverseString(new char[]{'a', 'b', 'c', 'd', 'e'}, new char[]{'e', 'd', 'c', 'b', 'a'});
    }

    /**
     * Method to test the Reverse String function.
     *
     * @param s         The input character array.
     * @param expected  The expected reversed character array.
     */
    public static void testReverseString(char[] s, char[] expected) {
        reverseString(s, 0, s.length - 1);
        System.out.println("Input: " + String.valueOf(s));
        System.out.println("Expected: " + String.valueOf(expected));
        System.out.println("Result: " + String.valueOf(s));
        System.out.println("Test passed: " + (Arrays.equals(s, expected)));
        System.out.println();
    }

    /**
     * Method to reverse the string in place using recursion.
     *
     * @param s The character array to reverse.
     * @param left The left pointer.
     * @param right The right pointer.
     */
    public static void reverseString(char[] s, int left, int right) {
        // Base case: if left is greater than or equal to right, stop recursion
        if (left >= right) {
            return;
        }

        // Swap characters at left and right pointers
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // Recur with the next pair of positions
        reverseString(s, left + 1, right - 1);
    }
}
