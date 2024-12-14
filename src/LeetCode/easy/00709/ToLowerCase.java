/**
 * 709. To Lower Case
 * Easy
 *
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 *
 * Example 1:
 * Input: s = "Hello"
 * Output: "hello"
 *
 * Example 2:
 * Input: s = "here"
 * Output: "here"
 *
 * Example 3:
 * Input: s = "LOVELY"
 * Output: "lovely"
 *
 * Constraints:
 * 1 <= s.length <= 100
 * s consists of printable ASCII characters.
 */

public class ToLowerCase {

    public static void main(String[] args) {
        // Test cases for checking ToLowerCase method
        testToLowerCase("Hello", "hello");
        testToLowerCase("here", "here");
        testToLowerCase("LOVELY", "lovely");
        testToLowerCase("JavaIsFun", "javaisfun");
        testToLowerCase("123ABC", "123abc");
    }

    /**
     * Method to test the ToLowerCase function.
     *
     * @param input    The input string.
     * @param expected The expected lowercase string.
     */
    public static void testToLowerCase(String input, String expected) {
        String result = toLowerCase(input);
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Result: " + result);
        System.out.println("Test passed: " + result.equals(expected));
        System.out.println();
    }

    /**
     * Method to convert the input string to lowercase.
     *
     * @param s The input string.
     * @return The lowercase version of the string.
     */
    public static String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If the character is uppercase, convert it to lowercase
            if (c >= 'A' && c <= 'Z') {
                result.append((char)(c + 32)); // Convert to lowercase by adding 32 to ASCII value
            } else {
                result.append(c); // Append the character as is if it's not uppercase
            }
        }

        return result.toString(); // Return the result as a string
    }
}
