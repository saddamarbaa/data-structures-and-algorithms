/***
 13. Roman to Integer

 Easy
 Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given a roman numeral, convert it to an integer.


 Example 1:

 Input: s = "III"
 Output: 3
 Explanation: III = 3.
 Example 2:

 Input: s = "LVIII"
 Output: 58
 Explanation: L = 50, V= 5, III = 3.
 Example 3:

 Input: s = "MCMXCIV"
 Output: 1994
 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


 Constraints:

 1 <= s.length <= 15
 s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */

public class RomanToInteger {

    public static void main(String[] args) {
        String s1 = "III";
        String s2 = "IV";
        String s3 = "IX";
        String s4 = "LVIII";
        String s5 = "MCMXCIV";

        // Test Case 1
        System.out.println("Test Case 1:");
        System.out.println("Roman to Integer (Solution 1): " + romanToInt(s1)); // Output: 3
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2:");
        System.out.println("Roman to Integer (Solution 1): " + romanToInt(s2)); // Output: 4
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3:");
        System.out.println("Roman to Integer (Solution 1): " + romanToInt(s3)); // Output: 9
        System.out.println();

        // Test Case 4
        System.out.println("Test Case 4:");
        System.out.println("Roman to Integer (Solution 1): " + romanToInt(s4)); // Output: 58
        System.out.println();

        // Test Case 5
        System.out.println("Test Case 5:");
        System.out.println("Roman to Integer (Solution 1): " + romanToInt(s5)); // Output: 1994
    }

    /**
     * Solution 1: Using a HashMap for Roman Numerals
     * Algorithm:
     * 1. Create a map for Roman numeral characters and their corresponding integer values.
     * 2. Traverse the string from left to right.
     * 3. If a smaller numeral appears before a larger numeral (subtractive notation), subtract it, otherwise add it.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), as we use a fixed-size map.
     */
    public static int romanToInt(String s) {
        // Map for Roman numeral characters and their corresponding integer values
        java.util.Map<Character, Integer> romanMap = new java.util.HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = romanMap.get(s.charAt(i));

            // If current numeral is smaller than the next one, subtract it
            if (i + 1 < s.length() && current < romanMap.get(s.charAt(i + 1))) {
                total -= current;
            } else {
                total += current;
            }
        }
        return total;
    }

    /**
     * Solution 2: Optimized Version using only simple loop and conditions
     * Algorithm:
     * 1. Traverse the string from left to right.
     * 2. Add the value of the current character.
     * 3. If a smaller numeral is found before a larger numeral, subtract the smaller value from the result.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), as we do not use any extra space.
     */
    public static int romanToInt2(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = getRomanValue(s.charAt(i));
            if (i + 1 < s.length() && current < getRomanValue(s.charAt(i + 1))) {
                total -= current;
            } else {
                total += current;
            }
        }
        return total;
    }

    // Helper function to return the value of Roman character
    private static int getRomanValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
