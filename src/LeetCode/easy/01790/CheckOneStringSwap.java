/***
 1790. Check if One String Swap Can Make Strings Equal

 Easy
 given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

 Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

 Example 1:

 Input: s1 = "bank", s2 = "kanb"
 Output: true
 Explanation: For example, swap the first character with the last character of s2 to make "bank".
 Example 2:

 Input: s1 = "attack", s2 = "defend"
 Output: false
 Explanation: It is impossible to make them equal with one string swap.
 Example 3:

 Input: s1 = "kelb", s2 = "kelb"
 Output: true
 Explanation: The two strings are already equal, so no string swap operation is required.


 Constraints:

 1 <= s1.length, s2.length <= 100
 s1.length == s2.length
 s1 and s2 consist of only lowercase English letters.
 */
public class CheckOneStringSwap {

    // ==================================================
    // Solution: Compare characters and count mismatches
    // ==================================================
    public boolean areAlmostEqual(String s1, String s2) {
        // If the lengths are different, they cannot be made equal with one swap
        if (s1.length() != s2.length()) {
            return false;
        }

        // Find the indices where the characters differ
        int firstMismatch = -1;
        int secondMismatch = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (firstMismatch == -1) {
                    firstMismatch = i; // Record the first mismatch
                } else if (secondMismatch == -1) {
                    secondMismatch = i; // Record the second mismatch
                } else {
                    // If there are more than two mismatches, one swap is not enough
                    return false;
                }
            }
        }

        // If there are no mismatches, the strings are already equal
        if (firstMismatch == -1 && secondMismatch == -1) {
            return true;
        }

        // If there is only one mismatch, one swap cannot fix it
        if (secondMismatch == -1) {
            return false;
        }

        // Check if swapping the two mismatched characters makes the strings equal
        return s1.charAt(firstMismatch) == s2.charAt(secondMismatch) &&
                s1.charAt(secondMismatch) == s2.charAt(firstMismatch);
    }

    public boolean areAlmostEqualWithSwap(String originalString, String targetString) {

        // If both strings are already equal, no swap is needed
        if (originalString.equals(targetString)) {
            return true;
        }

        // Try swapping every possible pair of characters in targetString
        for (int i = 0; i < targetString.length(); i++) {
            for (int j = i + 1; j < targetString.length(); j++) {
                // Swap characters at positions i and j and check if strings become equal
                String swappedString = swapCharacters(targetString, i, j);
                if (originalString.equals(swappedString)) {
                    return true;
                }
                // Debug log to track swap attempts (can be removed for production)
                System.out.println("Swapped string: " + swappedString + " | Matches original: " + originalString.equals(swappedString));
            }
        }

        // Return false if no swap can make the strings equal
        return false;
    }

    public String swapCharacters(String inputString, int firstIndex, int secondIndex) {
        char[] charArray = inputString.toCharArray();

        // Swap the characters at the specified indices
        char temp = charArray[firstIndex];
        charArray[firstIndex] = charArray[secondIndex];
        charArray[secondIndex] = temp;

        // Return the new string after swapping
        return new String(charArray);
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        CheckOneStringSwap solution = new CheckOneStringSwap();

        // Test case 1:
        // Input: s1 = "bank", s2 = "kanb"
        // Expected output: true
        String s1 = "bank";
        String s2 = "kanb";
        boolean result1 = solution.areAlmostEqual(s1, s2);
        System.out.println("Test case 1: " + result1); // Output: true

        // Test case 2:
        // Input: s1 = "attack", s2 = "defend"
        // Expected output: false
        String s3 = "attack";
        String s4 = "defend";
        boolean result2 = solution.areAlmostEqual(s3, s4);
        System.out.println("Test case 2: " + result2); // Output: false

        // Test case 3:
        // Input: s1 = "abcd", s2 = "dcba"
        // Expected output: false
        String s5 = "abcd";
        String s6 = "dcba";
        boolean result3 = solution.areAlmostEqual(s5, s6);
        System.out.println("Test case 3: " + result3); // Output: false

        // Test case 4:
        // Input: s1 = "kelb", s2 = "kelb"
        // Expected output: true
        String s7 = "kelb";
        String s8 = "kelb";
        boolean result4 = solution.areAlmostEqual(s7, s8);
        System.out.println("Test case 4: " + result4); // Output: true
    }
}