/**
 2269. Find the K-Beauty of a Number

Easy
The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:

It has a length of k.
It is a divisor of num.
Given integers num and k, return the k-beauty of num.

Note:

Leading zeros are allowed.
0 is not a divisor of any value.
A substring is a contiguous sequence of characters in a string.

Example 1:

Input: num = 240, k = 2
Output: 2
Explanation: The following are the substrings of num of length k:
- "24" from "240": 24 is a divisor of 240.
- "40" from "240": 40 is a divisor of 240.
Therefore, the k-beauty is 2.
Example 2:

Input: num = 430043, k = 2
Output: 2
Explanation: The following are the substrings of num of length k:
- "43" from "430043": 43 is a divisor of 430043.
- "30" from "430043": 30 is not a divisor of 430043.
- "00" from "430043": 0 is not a divisor of 430043.
- "04" from "430043": 4 is not a divisor of 430043.
- "43" from "430043": 43 is a divisor of 430043.
Therefore, the k-beauty is 2.
 */

public class KBeautyOfNumber {
    public static void main(String[] args) {
        // Test case 1:
        int num1 = 240;
        int k1 = 2;
        int result1 = findKBeauty(num1, k1);
        System.out.println("Test Case 1 - Input num: " + num1);
        System.out.println("Test Case 1 - K: " + k1);
        System.out.println("Test Case 1 - K-Beauty Count: " + result1);

        // Test case 2:
        int num2 = 430043;
        int k2 = 2;
        int result2 = findKBeauty(num2, k2);
        System.out.println("Test Case 2 - Input num: " + num2);
        System.out.println("Test Case 2 - K: " + k2);
        System.out.println("Test Case 2 - K-Beauty Count: " + result2);

        // Test case 3:
        int num3 = 123456;
        int k3 = 3;
        int result3 = findKBeauty(num3, k3);
        System.out.println("Test Case 3 - Input num: " + num3);
        System.out.println("Test Case 3 - K: " + k3);
        System.out.println("Test Case 3 - K-Beauty Count: " + result3);
    }

    /**
     * Find the K-Beauty of the number.
     * A K-beauty is defined as a substring of length k from num that divides the number itself.
     * Algorithm Steps:
     * 1. Convert num to a string to extract substrings.
     * 2. Iterate through each substring of length k.
     * 3. Check if the substring is a divisor of the original number.
     * 4. Return the count of such K-beauty divisors.
     * 
     * Time Complexity: O(n * k) where n is the length of the number and k is the length of substrings.
     * Space Complexity: O(1) extra space (not counting input/output storage).
     */
    public static int findKBeauty(int num, int k) {
        String numStr = String.valueOf(num); // Convert num to string
        int count = 0; // Initialize the count of K-beauties

        // Iterate through substrings of length k
        for (int i = 0; i <= numStr.length() - k; i++) {
            // Extract the substring of length k
            String subStr = numStr.substring(i, i + k);
            int subNum = Integer.parseInt(subStr); // Convert substring back to an integer

            // Avoid division by zero and check if the substring divides the original number
            if (subNum != 0 && num % subNum == 0) {
                count++; // Increment count if it's a K-beauty
            }
        }

        return count;
    }
}
