/***
 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
 Easy
 You are given a 0-indexed array of integers nums.

 A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1. In particular, the prefix consisting only of nums[0] is sequential.

 Return the smallest integer x missing from nums such that x is greater than or equal to the sum of the longest sequential prefix.

 Example 1:

 Input: nums = [1,2,3,2,5]
 Output: 6
 Explanation: The longest sequential prefix of nums is [1,2,3] with a sum of 6. 6 is not in the array, therefore 6 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.
 Example 2:

 Input: nums = [3,4,5,1,12,14,13]
 Output: 15
 Explanation: The longest sequential prefix of nums is [3,4,5] with a sum of 12. 12, 13, and 14 belong to the array while 15 does not. Therefore 15 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.


 Constraints:

 1 <= nums.length <= 50
 1 <= nums[i] <= 50
 */
public class MaximumRepeatingSubstring {

    public static void main(String[] args) {
        String sequence1 = "ababc";
        String word1 = "ab";
        String sequence2 = "ababc";
        String word2 = "ba";
        String sequence3 = "aaabaaaabaaabaaaabaaaaba";
        String word3 = "aaaba";

        // Test Case 1
        System.out.println("Test Case 1:");
        System.out.println("Brute Force: " + maxRepeating1(sequence1, word1)); // Output: 2
        System.out.println("Optimized: " + maxRepeating2(sequence1, word1)); // Output: 2
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2:");
        System.out.println("Brute Force: " + maxRepeating1(sequence2, word2)); // Output: 1
        System.out.println("Optimized: " + maxRepeating2(sequence2, word2)); // Output: 1
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3:");
        System.out.println("Brute Force: " + maxRepeating1(sequence3, word3)); // Output: 5
        System.out.println("Optimized: " + maxRepeating2(sequence3, word3)); // Output: 5
    }

    /**
     * Solution 1: Brute Force
     * Algorithm:
     * 1. Start with k = 1 and incrementally check if the word repeated k times is a substring of the sequence.
     * 2. Stop when the word repeated k times is no longer a substring.
     *
     * Time Complexity: O(n^2), where n is the length of the sequence.
     * Space Complexity: O(1), constant space.
     */
    public static int maxRepeating1(String sequence, String word) {
        int k = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb.toString())) {
            k++;
            sb.append(word);
        }
        return k;
    }

    /**
     * Solution 2: Optimized
     * Algorithm:
     * 1. Use a sliding window approach to check for the maximum repeating substring.
     * 2. Iterate through the sequence and count the maximum consecutive occurrences of the word.
     *
     * Time Complexity: O(n * m), where n is the length of the sequence and m is the length of the word.
     * Space Complexity: O(1), constant space.
     */
    public static int maxRepeating2(String sequence, String word) {
        int maxK = 0;
        int n = sequence.length();
        int m = word.length();
        for (int i = 0; i <= n - m; i++) {
            int k = 0;
            while (i + m * (k + 1) <= n && sequence.substring(i + m * k, i + m * (k + 1)).equals(word)) {
                k++;
            }
            maxK = Math.max(maxK, k);
        }
        return maxK;
    }
}