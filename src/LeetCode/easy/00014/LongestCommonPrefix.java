/***
 14. Longest Common Prefix

 Easy

 Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".


 Example 1:

 Input: strs = ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: strs = ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.

 Constraints:

 1 <= strs.length <= 200
 0 <= strs[i].length <= 200
 strs[i] consists of only lowercase English letters if it is non-empty.
 */


public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String[] strs3 = {"interspecies", "interstellar", "interstate"};

        // Test Case 1
        System.out.println("Test Case 1:");
        System.out.println("Horizontal Scanning: " + longestCommonPrefix1(strs1)); // Output: "fl"
        System.out.println("Vertical Scanning: " + longestCommonPrefix2(strs1)); // Output: "fl"
        System.out.println("Divide and Conquer: " + longestCommonPrefix3(strs1)); // Output: "fl"
        System.out.println("Binary Search: " + longestCommonPrefix4(strs1)); // Output: "fl"
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2:");
        System.out.println("Horizontal Scanning: " + longestCommonPrefix1(strs2)); // Output: ""
        System.out.println("Vertical Scanning: " + longestCommonPrefix2(strs2)); // Output: ""
        System.out.println("Divide and Conquer: " + longestCommonPrefix3(strs2)); // Output: ""
        System.out.println("Binary Search: " + longestCommonPrefix4(strs2)); // Output: ""
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3:");
        System.out.println("Horizontal Scanning: " + longestCommonPrefix1(strs3)); // Output: "inters"
        System.out.println("Vertical Scanning: " + longestCommonPrefix2(strs3)); // Output: "inters"
        System.out.println("Divide and Conquer: " + longestCommonPrefix3(strs3)); // Output: "inters"
        System.out.println("Binary Search: " + longestCommonPrefix4(strs3)); // Output: "inters"
    }

    /**
     * Solution 1: Horizontal Scanning
     * Algorithm:
     * 1. Start with the first string as the initial prefix.
     * 2. Compare the prefix with each string in the array, updating the prefix to the common part.
     * 3. If the prefix becomes empty, return "".
     *
     * Time Complexity: O(S), where S is the sum of all characters in all strings.
     * Space Complexity: O(1), constant space.
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * Solution 2: Vertical Scanning
     * Algorithm:
     * 1. Iterate through each character of the first string.
     * 2. Compare the character with the corresponding character in the other strings.
     * 3. If a mismatch is found, return the prefix up to that point.
     *
     * Time Complexity: O(S), where S is the sum of all characters in all strings.
     * Space Complexity: O(1), constant space.
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    /**
     * Solution 3: Divide and Conquer
     * Algorithm:
     * 1. Divide the array of strings into two halves.
     * 2. Recursively find the common prefix in each half.
     * 3. Merge the results by finding the common prefix between the two halves.
     *
     * Time Complexity: O(S), where S is the sum of all characters in all strings.
     * Space Complexity: O(m * log n), where m is the length of the longest string and n is the number of strings.
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefixHelper(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefixHelper(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = (left + right) / 2;
        String leftPrefix = longestCommonPrefixHelper(strs, left, mid);
        String rightPrefix = longestCommonPrefixHelper(strs, mid + 1, right);
        return commonPrefix(leftPrefix, rightPrefix);
    }

    private static String commonPrefix(String left, String right) {
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, minLength);
    }


    /**
     * Solution 4: Binary Search
     * Algorithm:
     * 1. Find the shortest string in the array.
     * 2. Use binary search to check if a prefix of a certain length is common to all strings.
     * 3. Adjust the search range based on the result.
     *
     * Time Complexity: O(S * log m), where S is the sum of all characters and m is the length of the shortest string.
     * Space Complexity: O(1), constant space.
     */
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int low = 0, high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}