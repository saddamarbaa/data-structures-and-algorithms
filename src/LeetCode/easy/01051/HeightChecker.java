/**
 1051. Height Checker
 Easy
 A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

 You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

 Return the number of indices where heights[i] != expected[i].



 Example 1:

 Input: heights = [1,1,4,2,1,3]
 Output: 3
 Explanation:
 heights:  [1,1,4,2,1,3]
 expected: [1,1,1,2,3,4]
 Indices 2, 4, and 5 do not match.
 Example 2:

 Input: heights = [5,1,2,3,4]
 Output: 5
 Explanation:
 heights:  [5,1,2,3,4]
 expected: [1,2,3,4,5]
 All indices do not match.
 Example 3:

 Input: heights = [1,2,3,4,5]
 Output: 0
 Explanation:
 heights:  [1,2,3,4,5]
 expected: [1,2,3,4,5]
 All indices match.


 Constraints:

 1 <= heights.length <= 100
 1 <= heights[i] <= 100
 */

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {

        // Test case 1 - Expected 3 students need to move
        int[] heights1 = {1, 1, 4, 2, 1, 3};
        int expected1 = 3;
        int result1 = heightChecker(heights1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2 - Expected 5 students need to move
        int[] heights2 = {5, 1, 2, 3, 4};
        int expected2 = 5;
        int result2 = heightChecker(heights2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);

        // Test case 3 - No students need to move
        int[] heights3 = {1, 2, 3, 4, 5};
        int expected3 = 0;
        int result3 = heightChecker(heights3);
        System.out.println("Test Case 3 - Expected: " + expected3);
        System.out.println("Test Case 3 - Actual: " + result3);
    }

    /**
     * Finds the number of students that are not in their correct positions
     * when sorted in non-decreasing order by height.
     *
     * @param heights The integer array representing students' heights.
     * @return The number of students in the wrong position.
     */
    public static int heightChecker(int[] heights) {
        // Make a copy of the original heights array
        int[] expected = heights.clone();
        
        // Sort the expected array to find the correct order
        Arrays.sort(expected);

        int count = 0;
        // Count how many students are in the wrong position
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        return count;
    }
}
