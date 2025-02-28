/***
 * 873. Length of Longest Fibonacci Subsequence
 * Medium
 *
 * A sequence x1, x2, ..., xn is Fibonacci-like if:
 *
 * 1. n >= 3
 * 2. xi + xi+1 = xi+2 for all i + 2 <= n.
 *
 * Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.
 *
 * A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].
 *
 * Example 1:
 * Input: arr = [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation: The longest subsequence that is Fibonacci-like: [1,2,3,5,8].
 *
 * Example 2:
 * Input: arr = [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation: The longest subsequence that is Fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].
 *
 * Constraints:
 * - 3 <= arr.length <= 1000
 * - 1 <= arr[i] < arr[i + 1] <= 10^9
 */

import java.util.HashMap;
import java.util.Map;

public class LongestFibonacciSubsequence {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {1, 3, 7, 11, 12, 14, 18};

        // Test Case 1
        System.out.println("Test Case 1:");
        System.out.println("Length of Longest Fibonacci Subsequence: " + lenLongestFibSubseq(arr1)); // Output: 5
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2:");
        System.out.println("Length of Longest Fibonacci Subsequence: " + lenLongestFibSubseq(arr2)); // Output: 3
    }


    public int lenLongestFibSubseq3(int[] arr) {
        int n = arr.length;
        if(n < 3) return 0;

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }


        int  ans = 0;
        for(int i  = 0; i < n ; i++){
            for(int j = i + 1; j < n; j++){
                int current = arr[j];
                int prev = arr[i];
                int next = current + prev;
                int len = 2;
                while(map.containsKey(next)){
                    len++;
                    ans = Math.max(ans, len);
                    prev = current;
                    current = next;
                    next = current + prev;
                }
            }


        }
        return ans > 2 ? ans : 0;
    }

    /**
     * Solution 1: Using Dynamic Programming and HashMap
     * Algorithm:
     * 1. Use a HashMap to store indices of elements.
     * 2. Use a 2D dp array to store the length of the Fibonacci subsequence ending at two indices.
     * 3. Traverse the array, and for every pair (i, j), find k such that arr[k] + arr[j] = arr[i], then update the dp.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    public static int lenLongestFibSubseq(int[] arr) {
        // Map to store the index of each number in the array
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }

        // 2D array to store lengths of Fibonacci subsequences
        int[][] dp = new int[arr.length][arr.length];
        int maxLen = 0;

        // Traverse pairs of elements
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = arr[i] - arr[j];
                if (diff < arr[j] && indexMap.containsKey(diff)) {
                    int k = indexMap.get(diff);
                    dp[j][i] = dp[k][j] + 1;
                    maxLen = Math.max(maxLen, dp[j][i] + 2); // +2 because the initial subsequence length is 2
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0; // Must have at least 3 elements to be valid Fibonacci-like subsequence
    }

    /**
     * Solution 2: Brute-force Approach (Less Efficient)
     * Algorithm:
     * 1. Traverse all pairs of elements in the array.
     * 2. For each pair, generate Fibonacci subsequences.
     * 3. Track the longest subsequence found.
     *
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public static int lenLongestFibSubseqBruteForce(int[] arr) {
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i], b = arr[j];
                int len = 2; // Subsequence always starts with length 2

                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[k] == a + b) {
                        len++;
                        a = b;
                        b = arr[k];
                    }
                }

                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen >= 3 ? maxLen : 0;
    }
}
