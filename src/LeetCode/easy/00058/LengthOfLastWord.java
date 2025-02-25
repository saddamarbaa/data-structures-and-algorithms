/***
 58. Length of Last Word

 Easy
 Given a string s consisting of words and spaces, return the length of the last word in the string.

 A word is a maximal substring consisting of non-space characters only.

 Example 1:

 Input: s = "Hello World"
 Output: 5
 Explanation: The last word is "World" with length 5.
 Example 2:

 Input: s = "   fly me   to   the moon  "
 Output: 4
 Explanation: The last word is "moon" with length 4.
 Example 3:

 Input: s = "luffy is still joyboy"
 Output: 6
 Explanation: The last word is "joyboy" with length 6.


 Constraints:

 1 <= s.length <= 104
 s consists of only English letters and spaces ' '.
 There will be at least one word in s.
 */

public class LengthOfLastWord {

    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "   fly me   to   the moon  ";
        String s3 = "luffy is still joyboy";

        // Test Case 1
        System.out.println("Test Case 1:");
        System.out.println("Length of Last Word (Solution 1): " + lengthOfLastWord(s1)); // Output: 5
        System.out.println("Length of Last Word (Solution 2): " + lengthOfLastWord2(s1)); // Output: 5
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2:");
        System.out.println("Length of Last Word (Solution 1): " + lengthOfLastWord(s2)); // Output: 4
        System.out.println("Length of Last Word (Solution 2): " + lengthOfLastWord2(s2)); // Output: 4
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3:");
        System.out.println("Length of Last Word (Solution 1): " + lengthOfLastWord(s3)); // Output: 6
        System.out.println("Length of Last Word (Solution 2): " + lengthOfLastWord2(s3)); // Output: 6
    }

    /**
     * Solution 1: Using split and trim
     * Algorithm:
     * 1. Trim the input string to remove leading and trailing spaces.
     * 2. Split the string by spaces into an array of words.
     * 3. Return the length of the last word in the array.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(n), for the array created by splitting the string.
     */
    public static int lengthOfLastWord(String s) {
        s = s.trim(); // Remove leading/trailing spaces
        String[] words = s.split(" "); // Split the string by spaces
        return words[words.length - 1].length(); // Return length of last word
    }

    /**
     * Solution 2: Traversing from the end
     * Algorithm:
     * 1. Start from the end of the string and skip any trailing spaces.
     * 2. Count the characters of the last word until a space is encountered.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), as we use only a few variables.
     */
    public static int lengthOfLastWord2(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count characters in the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public int lengthOfLastWord3(String s) {
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' ' && count > 0){
                return count;
            }else if(s.charAt(i) != ' '){
                count++;
            }
        }
        return count;
    }
}
