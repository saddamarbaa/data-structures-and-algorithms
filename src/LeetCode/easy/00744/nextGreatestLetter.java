/*
744. Find Smallest Letter Greater Than Target
Easy
You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There
are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not
exist, return the first character in letters.

Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
Example 3:

Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].


Constraints:

2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.
 */


public class NextGreatestLetter {
    public static void main(String[] args) {
        // Test case 1
        char[] letters1 = {'c', 'f', 'j'};
        char target1 = 'd';
        char result1 = nextGreatestLetter(letters1, target1);
        System.out.println("The smallest letter greater than " + target1 + " is: " + result1);
        // Expected output: The smallest letter greater than d is: f

        // Test case 2
        char[] letters2 = {'a', 'b', 'c'};
        char target2 = 'z';
        char result2 = nextGreatestLetter(letters2, target2);
        System.out.println("The smallest letter greater than " + target2 + " is: " + result2);
        // Expected output: The smallest letter greater than z is: a

        // Test case 3
        char[] letters3 = {'a', 'b', 'c', 'd', 'e'};
        char target3 = 'e';
        char result3 = nextGreatestLetter(letters3, target3);
        System.out.println("The smallest letter greater than " + target3 + " is: " + result3);
        // Expected output: The smallest letter greater than e is: a (wrapping around to the first letter)

        // Test case 4
        char[] letters4 = {'a', 'a', 'a', 'a', 'a'};
        char target4 = 'a';
        char result4 = nextGreatestLetter(letters4, target4);
        System.out.println("The smallest letter greater than " + target4 + " is: " + result4);
        // Expected output: The smallest letter greater than a is: a (all letters are the same)

        // Test case 5
        char[] letters5 = {'a', 'b', 'c', 'd', 'e'};
        char target5 = 'f';
        char result5 = nextGreatestLetter(letters5, target5);
        System.out.println("The smallest letter greater than " + target5 + " is: " + result5);
        // Expected output: The smallest letter greater than f is: a (wrapping around to the first letter)
    }

      /**
       Algorithm:
       1. Initialize variables left to 0 and right to n - 1, where n is the length of the letters array.
       2. Perform a binary search while left is less than or equal to right.
       a. Calculate mid as (left + right) / 2.
       b. If letters[mid] is less than or equal to the target, update left to mid + 1.
       c. Otherwise, update right to mid - 1.
       3. After the binary search, if left is less than n, return letters[left]; otherwise, return letters[0].

     Time Complexity: O(log n) - Binary search takes logarithmic time.
     Space Complexity: O(1) - Constant space is used for variables.
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

         // Binary search to find the smallest character greater than target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }

          // If the search goes beyond the last element, return the first element
        return left < letters.length ? letters[left] : letters[0];
    }
}