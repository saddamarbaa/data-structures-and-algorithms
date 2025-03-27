import java.util.HashMap;
import java.util.Map;

/**
 * 2780. Minimum Index of a Valid Split
 *
 * An element x of an integer array arr of length m is dominant if freq(x) * 2 > m,
 * where freq(x) is the number of occurrences of x in arr. Note that this definition
 * implies that arr can have at most one dominant element.
 *
 * You may split the array at index i into two arrays arr[0..i] and arr[i + 1..n - 1],
 * but the split is only valid if the dominant element in the two resulting arrays is the same
 * as the dominant element in the original array.
 *
 * Return the minimum index of a valid split. If no valid split exists, return -1.
 *
 * Example:
 * Input: arr = [1,2,2,2]
 * Output: 2
 * Explanation: The dominant element in the array is 2.
 * We can split the array at index 2 to obtain [1,2,2] and [2], where 2 is dominant in both.
 * Another valid split is at index 1, but 2 is the minimum index.
 *
 * Input: arr = [2,1,3,1,1,1,7,1,2,1]
 * Output: 4
 * Explanation: The dominant element is 1. The valid splits are at indices 4 and 5.
 *
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 */
public class MinimumIndexOfValidSplit {
    public static void main(String[] args) {
        // Test Cases
        runTestCase(new int[]{1, 2, 2, 2}, 2);
        runTestCase(new int[]{2, 1, 3, 1, 1, 1, 7, 1, 2, 1}, 4);
        runTestCase(new int[]{3, 3, 3, 3, 3, 3}, 0);
        runTestCase(new int[]{1, 1, 2, 2, 2}, -1);
        runTestCase(new int[]{1, 2, 3, 4, 5}, -1);
    }

    // Method to run each test case
    public static void runTestCase(int[] arr, int expected) {
        int result1 = minimumIndex(arr);
        int result2 = minimumIndexOptimized(arr);

        System.out.println("Test Case - Input: arr = " + Arrays.toString(arr));
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Basic Approach): " + result1);
        System.out.println("Result (Optimized Approach): " + result2);
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected));
        System.out.println();
    }

    /**
     * Approach 1: Basic Approach
     *
     * Algorithm Steps:
     * 1. Find the dominant element of the entire array.
     * 2. For each possible split index, check if the dominant element in both subarrays
     *    matches the original dominant element.
     * 3. Return the smallest valid index.
     *
     * Time Complexity: O(n^2), where n is the length of the array.
     * Space Complexity: O(n), for storing frequency maps.
     */
    public static int minimumIndex(int[] arr) {
        int dominant = findDominantElement(arr);
        if (dominant == -1) {
            return -1;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (isValidSplit(arr, dominant, i)) {
                return i;
            }
        }

        return -1;
    }

    // Helper method to find the dominant element
    private static int findDominantElement(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() * 2 > arr.length) {
                return entry.getKey();
            }
        }

        return -1;
    }

    // Helper method to check if a split is valid
    private static boolean isValidSplit(int[] arr, int dominant, int splitIndex) {
        int leftLen = splitIndex + 1;
        int rightLen = arr.length - leftLen;

        int leftCount = 0;
        for (int i = 0; i <= splitIndex; i++) {
            if (arr[i] == dominant) {
                leftCount++;
            }
        }

        int rightCount = 0;
        for (int i = splitIndex + 1; i < arr.length; i++) {
            if (arr[i] == dominant) {
                rightCount++;
            }
        }

        return (leftCount * 2 > leftLen) && (rightCount * 2 > rightLen);
    }

    /**
     * Approach 2: Optimized Approach
     *
     * Algorithm Steps:
     * 1. Find the dominant element of the entire array.
     * 2. Precompute prefix counts of the dominant element.
     * 3. For each possible split index, use the prefix counts to check validity in O(1) time.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(n), for storing prefix counts.
     */
    public static int minimumIndexOptimized(int[] arr) {
        int dominant = findDominantElement(arr);
        if (dominant == -1) {
            return -1;
        }

        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + (arr[i] == dominant ? 1 : 0);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int leftCount = prefix[i + 1];
            int leftLen = i + 1;
            int rightCount = prefix[arr.length] - prefix[i + 1];
            int rightLen = arr.length - leftLen;

            if (leftCount * 2 > leftLen && rightCount * 2 > rightLen) {
                return i;
            }
        }

        return -1;
    }
}