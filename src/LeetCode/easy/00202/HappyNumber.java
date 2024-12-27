/**
 202. Happy Number
 Easy
 Write an algorithm to determine if a number n is happy.

 A happy number is a number defined by the following process:

 Starting with any positive integer, replace the number by the sum of the squares of its digits.
 Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 Those numbers for which this process ends in 1 are happy.
 Return true if n is a happy number, and false if not.



 Example 1:

 Input: n = 19
 Output: true
 Explanation:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 Example 2:

 Input: n = 2
 Output: false
 */
public class HappyNumber {
    public static void main(String[] args) {
        // Test case 1: Happy number
        int num1 = 19;
        boolean result1 = isHappy(num1);
        System.out.println("Test Case 1 - Input number: " + num1);
        System.out.println("Test Case 1 - Is happy number: " + result1);

        // Test case 2: Not a happy number
        int num2 = 2;
        boolean result2 = isHappy(num2);
        System.out.println("Test Case 2 - Input number: " + num2);
        System.out.println("Test Case 2 - Is happy number: " + result2);

        // Test case 3: Single digit number
        int num3 = 1;
        boolean result3 = isHappy(num3);
        System.out.println("Test Case 3 - Input number: " + num3);
        System.out.println("Test Case 3 - Is happy number: " + result3);
    }

    /**
     * Determines if a number is a happy number using the fast and slow pointer approach.
     * A happy number is a number where the sum of the squares of its digits eventually equals 1.
     * If a cycle is detected (i.e., a repeated number), then the number is not happy.
     *
     * Time Complexity: O(log n), where n is the number of digits in the number.
     * Space Complexity: O(1), as no extra space is used apart from the pointers.
     */
    public static boolean isHappy(int n) {
        // Initialize slow and fast pointers
        int slow = n;
        int fast = getNext(n);

        // Loop until the fast pointer reaches 1 (happy) or slow meets fast (cycle detected)
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);         // Move slow pointer by one step
            fast = getNext(getNext(fast)); // Move fast pointer by two steps
        }

        // If fast reaches 1, it's a happy number; otherwise, there's a cycle (not happy)
        return fast == 1;
    }

    /**
     * Helper method to calculate the next number in the sequence (sum of squares of digits)
     */
    private static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;  // Get the last digit
            sum += digit * digit; // Add the square of the digit to the sum
            n = n / 10;          // Remove the last digit
        }
        return sum;
    }
}
