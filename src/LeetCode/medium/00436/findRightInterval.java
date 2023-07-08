/*
436. Find Right Interval

You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i
may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put
-1 at index i.

Example 1:

Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:

Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
Example 3:

Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.


Constraints:

1 <= intervals.length <= 2 * 104
intervals[i].length == 2
-106 <= starti <= endi <= 106
The start point of each interval is unique.
 */


import java.util.Arrays;

public class FindRightInterval{
    public static void main(String[] args) {
        // Test Case 1: Single interval, no right interval available
        int[][] input1 = {{1, 2}};
        int[] expected1 = {-1};
        int[] result1 = findRightInterval(input1);
        System.out.println("Test Case 1 - Input: " + Arrays.deepToString(input1));
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.toString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.equals(result1, expected1));

        // Test Case 2: Multiple intervals, right intervals available for some intervals
        int[][] input2 = {{3, 4}, {2, 3}, {1, 2}};
        int[] expected2 = {-1, 0, 1};
        int[] result2 = findRightInterval(input2);
        System.out.println("Test Case 2 - Input: " + Arrays.deepToString(input2));
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.toString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.equals(result2, expected2));

        // Test Case 3: Multiple intervals, no right intervals available for some intervals
        int[][] input3 = {{1, 4}, {2, 3}, {3, 4}};
        int[] expected3 = {-1, 2, -1};
        int[] result3 = findRightInterval(input3);
        System.out.println("Test Case 3 - Input: " + Arrays.deepToString(input3));
        System.out.println("Test Case 3 - Expected result: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Actual result: " + Arrays.toString(result3));
        System.out.println("Test Case 3 - Result matches expected: " + Arrays.equals(result3, expected3));

        // Test Case 4: Multiple intervals, right intervals available for some intervals, including duplicates
        int[][] input4 = {{2, 3}, {1, 2}, {3, 4}};
        int[] expected4 = {2, -1, -1};
        int[] result4 = findRightInterval(input4);
        System.out.println("Test Case 4 - Input: " + Arrays.deepToString(input4));
        System.out.println("Test Case 4 - Expected result: " + Arrays.toString(expected4));
        System.out.println("Test Case 4 - Actual result: " + Arrays.toString(result4));
        System.out.println("Test Case 4 - Result matches expected: " + Arrays.equals(result4, expected4));
    }


    /**
     * Algorithm:
     * 1. Create an array 'result' to store the right interval indices.
     * 2. Iterate through each interval using a for loop with index 'i':
     * - Get the current end value of the interval.
     * - Initialize 'rightIntervalIndex' to -1 and 'minStart' to Integer.MAX_VALUE.
     * - Iterate through each interval using a nested for loop with index 'j':
     * - Get the start value of the current interval being compared.
     * - If the start value is greater than or equal to the current end value
     * and less than the current minimum start value, update 'minStart' and 'rightIntervalIndex'.
     * - Assign the 'rightIntervalIndex' to the 'result' array at index 'i'.
     * 3. Return the 'result' array containing the right interval indices.
     * <p>
     * Time Complexity: O(N^2), where N is the number of intervals. The nested loop runs N * N times.
     * Space Complexity: O(N), where N is the number of intervals. The 'result' array requires N space.
     */
    public static int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int currentEnd = intervals[i][1];
            int rightIntervalIndex = -1;
            int minStart = Integer.MAX_VALUE;

            for (int j = 0; j < intervals.length; j++) {
                int comparisonStart = intervals[j][0];

                if (comparisonStart >= currentEnd && comparisonStart < minStart) {
                    minStart = comparisonStart;
                    rightIntervalIndex = j;
                }
            }

            result[i] = rightIntervalIndex;
        }

        return result;
    }
}