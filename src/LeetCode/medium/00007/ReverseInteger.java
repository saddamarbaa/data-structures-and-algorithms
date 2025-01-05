/**
 7. Reverse Integer
 Medium
 Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 Example 1:

 Input: x = 123
 Output: 321
 Example 2:

 Input: x = -123
 Output: -321
 Example 3:

 Input: x = 120
 Output: 21
 */
public class ReverseInteger {

    public static void main(String[] args) {
        testReverseIntegerFunction();
    }

    public static void testReverseIntegerFunction() {
        // Test case 1: Positive number
        int num1 = 123;
        int expected1 = 321;
        int result1 = reverse(num1);
        System.out.println("Test Case 1 - Input: " + num1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2: Negative number
        int num2 = -123;
        int expected2 = -321;
        int result2 = reverse(num2);
        System.out.println("Test Case 2 - Input: " + num2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3: Number with zero at the end
        int num3 = 120;
        int expected3 = 21;
        int result3 = reverse(num3);
        System.out.println("Test Case 3 - Input: " + num3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case 4: Overflow case (reverse exceeds 32-bit range)
        int num4 = 1534236469;
        int expected4 = 0;
        int result4 = reverse(num4);
        System.out.println("Test Case 4 - Input: " + num4);
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));
    }

    public static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check if reversed will overflow
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Overflow for positive numbers
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Overflow for negative numbers
            }

            reversed = reversed * 10 + digit;
        }
        return reversed;
    }
}
