/*
989. Add to Array-Form of Integer
Easy
Companies
The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.


Example 1:

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
 

Constraints:

1 <= num.length <= 104
0 <= num[i] <= 9
num does not contain any leading zeros except for the zero itself.
1 <= k <= 104
*/


import java.util.ArrayList;
import java.util.List;

public class AddToArrayForm {
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int n = num.length;

        // Iterate through num from right to left, adding corresponding digit of k to each digit of num
        for (int i = n - 1; i >= 0 || k > 0 || carry > 0; i--) {
            int sum = carry;

            if (i >= 0) {
                sum += num[i];
            }

            if (k > 0) {
                sum += k % 10;
                k /= 10;
            }

            // Calculate carry-over digit and add current sum to result list
            carry = sum / 10;
            result.add(0, sum % 10);
        }

        // Return result list as the array-form of the sum of num and k
        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] num1 = {1, 2, 0, 0};
        int k1 = 34;
        List<Integer> result1 = addToArrayForm(num1, k1);
        System.out.println("Result 1: " + result1); // Expected output: [1, 2, 3, 4]

        // Test case 2
        int[] num2 = {2, 7, 4};
        int k2 = 181;
        List<Integer> result2 = addToArrayForm(num2, k2);
        System.out.println("Result 2: " + result2); // Expected output: [4, 5, 5]

        // Test case 3
        int[] num3 = {9, 9, 9, 9};
        int k3 = 1;
        List<Integer> result3 = addToArrayForm(num3, k3);
        System.out.println("Result 3: " + result3); // Expected output: [1, 0, 0, 0, 0]
    }
}
