/**
 1502. Can Make Arithmetic Progression From Sequence

 Easy

 A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

 Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.

 Example 1:

 Input: arr = [3,5,1]
 Output: true
 Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
 Example 2:

 Input: arr = [1,2,4]
 Output: false
 Explanation: There is no way to reorder the elements to obtain an arithmetic progression.


 Constraints:

 2 <= arr.length <= 1000
 -106 <= arr[i] <= 106
 */

import java.util.Arrays;

public class CanMakeArithmeticProgression {
    public static void main(String[] args) {
        // Test cases
        testCanMakeArithmeticProgression(new int[]{3, 5, 1}, true);
        testCanMakeArithmeticProgression(new int[]{1, 2, 4}, false);
        testCanMakeArithmeticProgression(new int[]{7, 7, 7}, true);
        testCanMakeArithmeticProgression(new int[]{-1, -5, -3}, true);
    }

    public static void testCanMakeArithmeticProgression(int[] arr, boolean expected) {
        boolean result = canMakeArithmeticProgression(arr);
        System.out.println("Input: " + Arrays.toString(arr) + ", Expected: " + expected + ", Result: " + result);
        System.out.println("Test passed: " + (result == expected));
        System.out.println();
    }

    /**
     * Check if an array can be rearranged to form an arithmetic progression.
     *
     * An arithmetic progression is a sequence of numbers such that the difference between consecutive elements is the same.
     *
     * @param arr The array of numbers.
     * @return True if the array can be rearranged to form an arithmetic progression, otherwise false.
     */
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);  // Sort the array to check differences between consecutive elements

        int difference = arr[1] - arr[0];  // Calculate the difference of the first two elements

        // Check if the difference remains constant throughout the array
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != difference) {
                return false;
            }
        }

        return true;
    }
}
