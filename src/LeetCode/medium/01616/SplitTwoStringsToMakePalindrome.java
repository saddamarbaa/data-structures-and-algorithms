/***
 1616. Split Two Strings to Make Palindrome

 Medium

 You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.

 When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.

 Return true if it is possible to form a palindrome string, otherwise return false.

 Notice that x + y denotes the concatenation of strings x and y.

 Example 1:

 Input: a = "x", b = "y"
 Output: true
 Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
 aprefix = "", asuffix = "x"
 bprefix = "", bsuffix = "y"
 Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
 Example 2:

 Input: a = "xbdef", b = "xecab"
 Output: false
 Example 3:

 Input: a = "ulacfd", b = "jizalu"
 Output: true
 Explaination: Split them at index 3:
 aprefix = "ula", asuffix = "cfd"
 bprefix = "jiz", bsuffix = "alu"
 Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.


 Constraints:

 1 <= a.length, b.length <= 105
 a.length == b.length
 a and b consist of lowercase English letters
 */
public class SplitTwoStringsToMakePalindrome {

    public static void main(String[] args) {
        String a1 = "x";
        String b1 = "y";
        String a2 = "abdef";
        String b2 = "fecab";

        // Test Case 1
        System.out.println("Test Case 1:");
        System.out.println("Can Split to Make Palindrome: " + checkPalindromeFormation(a1, b1)); // Output: true
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2:");
        System.out.println("Can Split to Make Palindrome: " + checkPalindromeFormation(a2, b2)); // Output: true
    }

    /**
     * Solution: Two Pointers Approach
     * Algorithm:
     * 1. Check if the entire string `a` or `b` is a palindrome.
     * 2. If not, try to find a split point where the first part of `a` matches the reverse of the second part of `b` or vice versa.
     * 3. Use two pointers to check for the palindrome condition.
     *
     * Time Complexity: O(n), where n is the length of the strings.
     * Space Complexity: O(1), as we only use a constant amount of extra space.
     */
    public static boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private static boolean check(String a, String b) {
        int left = 0, right = a.length() - 1;

        while (left < right) {
            if (a.charAt(left) != b.charAt(right)) {
                // If the characters don't match, try to see if the remaining part of `a` or `b` is a palindrome
                return isPalindrome(a, left, right) || isPalindrome(b, left, right);
            }
            left++;
            right--;
        }

        // If we reach here, the strings can be split to form a palindrome
        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}