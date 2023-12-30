/**
 1304. Find N Unique Integers Sum up to Zero
 Easy
 Companies
 Given an integer n, return any array containing n unique integers such that they add up to 0.

 Example 1:

 Input: n = 5
 Output: [-7,-1,1,3,4]
 Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 Example 2:

 Input: n = 3
 Output: [-1,0,1]
 Example 3:

 Input: n = 1
 Output: [0]

 Constraints:

 1 <= n <= 1000
 */

import java.util.Arrays;

public class UniqueIntegersSumZero {

    public static void main(String[] args) {
        int n1 = 5;
        int[] result1 = sumZero(n1);
        printResult(n1, result1);  // Output: [1, 2, 3, 4, 5]

        int n2 = 3;
        int[] result2 = sumZero(n2);
        printResult(n2, result2);  // Output: [1, 2, 3]

        int n3 = 1;
        int[] result3 = sumZero(n3);
        printResult(n3, result3);  // Output: [1]
    }


    /**
     * Algorithm Steps:
     * 1. Create an array of length n to store the unique integers.
     * 2. Fill the first half of the array with positive integers starting from 1.
     * 3. Fill the second half of the array with corresponding negative integers.
     * 4. Return the resulting array with n unique integers that sum up to zero.
     *
     * Time Complexity:
     *    - The time complexity is O(n) as the algorithm iterates through the array once.
     *
     * Space Complexity:
     *    - The space complexity is O(n) as the algorithm uses an array of length n.
     */
    public static int[] sumZero(int n) {
        int[] result = new int[n];

        // Fill the first half of the array with positive integers
        for (int i = 0; i < n / 2; i++) {
            result[i] = i + 1;
        }

        // Fill the second half of the array with negative integers
        for (int i = n / 2, j = -n / 2; i < n; i++, j++) {
            result[i] = j;
        }

        return result;
    }

    // Helper method to print test results
    private static void printResult(int n, int[] result) {
        System.out.println("Input n: " + n);
        System.out.println("Output: " + Arrays.toString(result));
        System.out.println();
    }
}
