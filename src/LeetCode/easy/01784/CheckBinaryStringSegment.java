/***
 1784. Check if Binary String Has at Most One Segment of Ones
 Easy
 Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains at most one contiguous segment of ones. Otherwise, return false.


 Example 1:

 Input: s = "1001"
 Output: false
 Explanation: The ones do not form a contiguous segment.
 Example 2:

 Input: s = "110"
 Output: true


 Constraints:

 1 <= s.length <= 100
 s[i]​​​​ is either '0' or '1'.
 s[0] is '1'.
 */

public class CheckBinaryStringSegment {

    public static void main(String[] args) {
        String s1 = "1001";
        String s2 = "110";
        String s3 = "1";
        String s4 = "0000";

        // Test Case 1
        System.out.println("Test Case 1:");
        System.out.println("Brute Force: " + hasOneSegment1(s1)); // Output: false
        System.out.println("Optimized: " + hasOneSegment2(s1)); // Output: false
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2:");
        System.out.println("Brute Force: " + hasOneSegment1(s2)); // Output: true
        System.out.println("Optimized: " + hasOneSegment2(s2)); // Output: true
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3:");
        System.out.println("Brute Force: " + hasOneSegment1(s3)); // Output: true
        System.out.println("Optimized: " + hasOneSegment2(s3)); // Output: true
        System.out.println();

        // Test Case 4
        System.out.println("Test Case 4:");
        System.out.println("Brute Force: " + hasOneSegment1(s4)); // Output: true
        System.out.println("Optimized: " + hasOneSegment2(s4)); // Output: true
    }

    /**
     * Solution 1: Brute Force
     * Algorithm:
     * 1. Traverse the string, counting the number of segments of 1s.
     * 2. If there is more than one segment, return false, else return true.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), constant space.
     */
    public static boolean hasOneSegment1(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                // If it's the first 1 in the segment, count the segment
                if (i == 0 || s.charAt(i - 1) == '0') {
                    count++;
                }
            }
        }
        return count <= 1; // Return true if there's only 1 or 0 segment of 1s
    }

    /**
     * Solution 2: Optimized
     * Algorithm:
     * 1. Use a single pass to detect the start of a segment of 1s.
     * 2. If a second segment is found, return false, otherwise true.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(1), constant space.
     */
    public static boolean hasOneSegment2(String s) {
        int n = s.length();
        boolean foundSegment = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                // Check for the start of a new segment of 1s
                if (!foundSegment) {
                    foundSegment = true;
                } else {
                    // If a second segment is found, return false
                    if (i > 0 && s.charAt(i - 1) == '0') {
                        return false;
                    }
                }
            }
        }
        return true; // Return true if there was at most one segment of 1s
    }
}
