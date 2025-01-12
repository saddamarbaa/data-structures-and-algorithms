/**
 56. Merge Intervals

 Medium

 Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



 Example 1:

 Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 Example 2:

 Input: intervals = [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.


 Constraints:

 1 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 104
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected1 = {{1, 6}, {8, 10}, {15, 18}};
        int[][] result1 = merge(intervals1);
        System.out.println("Test Case 1 - Input: " + Arrays.deepToString(intervals1));
        System.out.println("Test Case 1 - Expected result: " + Arrays.deepToString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.deepToString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.deepToString(result1).equals(Arrays.deepToString(expected1)));

        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] expected2 = {{1, 5}};
        int[][] result2 = merge(intervals2);
        System.out.println("Test Case 2 - Input: " + Arrays.deepToString(intervals2));
        System.out.println("Test Case 2 - Expected result: " + Arrays.deepToString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.deepToString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.deepToString(result2).equals(Arrays.deepToString(expected2)));

        // Additional Solution Testing
        System.out.println("Testing Solution 2:");
        result1 = mergeWithCustomSort(intervals1);
        result2 = mergeWithCustomSort(intervals2);
        System.out.println("Custom Sort - Test Case 1 result: " + Arrays.deepToString(result1));
        System.out.println("Custom Sort - Test Case 2 result: " + Arrays.deepToString(result2));
    }

    /**
     * Merges overlapping intervals using sorting and a single pass approach.
     * Algorithm:
     * 1. Sort intervals by starting points.
     * 2. Iterate through intervals and merge overlapping ones.
     * 3. Add the non-overlapping intervals to the result.
     *
     * Time Complexity: O(n log n) due to sorting.
     * Space Complexity: O(n) for storing the result.
     *
     * @param intervals - The input array of intervals.
     * @return The merged intervals.
     */
    public static int[][] merge(int[][] intervals) {
        // Check if the input array is empty, return an empty array if so
        if (intervals.length == 0) return new int[0][];

        // Sort the intervals based on the starting times of each interval
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>(); // To store the merged intervals
        int[] current = intervals[0]; // Start with the first interval

        // Iterate through the remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval overlaps with the next one, merge them
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]); // Update the end time
            } else {
                // If no overlap, add the current interval to the list and move to the next
                merged.add(current);
                current = intervals[i]; // Set the next interval as the current one
            }
        }

        // Add the last processed interval to the list
        merged.add(current);

        // Convert the list of merged intervals back into an array
        return merged.toArray(new int[merged.size()][]);
    }


    /**
     * Alternative solution using a custom sort and stack-like approach.
     * Steps:
     * 1. Sort intervals by both start and end times.
     * 2. Iterate through intervals and merge if they overlap.
     * 3. Return the merged intervals.
     *
     * Time Complexity: O(n log n) - Sorting the intervals.
     * Space Complexity: O(n) - Extra space for the result list.
     *
     * @param intervals - The input array of intervals.
     * @return The merged intervals.
     */
    public static int[][] mergeWithCustomSort(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];

        // Sort by starting point, and in case of tie, by the ending point
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // Check if the current interval overlaps with the next one
            if (currentInterval[1] >= nextInterval[0]) {
                // Merge by updating the end of the current interval
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // If no overlap, add the current interval to the list
                merged.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        merged.add(currentInterval);

        return merged.toArray(new int[merged.size()][]);
    }


}
