/*
1499. Max Value of Equation
Hard

You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where
points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.

Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.

It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.


Example 1:

Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
Output: 4
Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 + 0
+ |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
No other pairs satisfy the condition, so we return the max of 4 and 1.
Example 2:

Input: points = [[0,0],[3,0],[9,2]], k = 3
Output: 3
Explanation: Only the first two points have an absolute difference of 3 or less in the x-values, and give the value
of 0 + 0 + |0 - 3| = 3.


Constraints:

2 <= points.length <= 105
points[i].length == 2
-108 <= xi, yi <= 108
0 <= k <= 2 * 108
xi < xj for all 1 <= i < j <= points.length
xi form a strictly increasing sequence.
 */


import java.util.Arrays;

public class FindMaxValueOfEquation{
    public static void main(String[] args) {

        // Test case 1 - input contains only one point
        int[][] input1 = {{1, 2}};
        int k1 = 1;
        int expected1 = -1;
        int result1 = findMaxValueOfEquation(input1, k1);
        System.out.println("Test Case 1 - Input: " + Arrays.deepToString(input1) + ", k = " + k1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2 - input contains two points
        int[][] input2 = {{1, 2}, {2, 3}};
        int k2 = 1;
        int expected2 = 5;
        int result2 = findMaxValueOfEquation(input2, k2);
        System.out.println("Test Case 2 - Input: " + Arrays.deepToString(input2) + ", k = " + k2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3 - input contains three points, but no pairs have a distance less than or equal to k
        int[][] input3 = {{1, 2}, {2, 3}, {4, 5}};
        int k3 = 1;
        int expected3 = -1;
        int result3 = findMaxValueOfEquation(input3, k3);
        System.out.println("Test Case 3 - Input: " + Arrays.deepToString(input3) + ", k = " + k3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case 4 - input contains three points, only one pair has a distance less than or equal to k
        int[][] input4 = {{1, 2}, {3, 4}, {5, 6}};
        int k4 = 2;
        int expected4 = 13;
        int result4 = findMaxValueOfEquation(input4, k4);
        System.out.println("Test Case 4 - Input: " + Arrays.deepToString(input4) + ", k = " + k4);
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));

        // Test case 5 - input contains four points, all pairs have a distance less than or equal to k
        int[][] input5 = {{0, 0}, {1, 1}, {2, 2}, {3, 3}};
        int k5 = 2;
        int expected5 = 8;
        int result5 = findMaxValueOfEquation(input5, k5);
        System.out.println("Test Case 5 - Input: " + Arrays.deepToString(input5) + ", k = " + k5);
        System.out.println("Test Case 5 - Expected result: " + expected5);
        System.out.println("Test Case 5 - Actual result: " + result5);
        System.out.println("Test Case 5 - Result matches expected: " + (result5 == expected5));

    }


    public static int findMaxValueOfEquation(int[][] points, int k) {

      // TODO  (not passed all the test case (got time limt out))
        int numPoints = points.length;  // number of points in the array
        int maxValue = Integer.MIN_VALUE;  // current maximum value of the equation

        // iterate over all possible pairs of points
        for (int i = 0; i < numPoints - 1; i++) {
            for (int j = i + 1; j < numPoints; j++) {
                int xDiff = points[j][0] - points[i][0];  // difference in x-coordinates of the two points

                // check if the difference in x-coordinates is at most k
                if (xDiff <= k) {
                    int ySum = points[i][1] + points[j][1];  // sum of the y-coordinates of the two points
                    int value = ySum + xDiff;  // compute the value of the equation for this pair of points

                    // update the maximum value if the computed value is greater than the current maximum value
                    if (value > maxValue) {
                        maxValue = value;
                    }
                }
            }
        }

        // return the maximum value of the equation for all pairs of points that satisfy the condition |xi - xj| <= k
        return maxValue;
    }
}





