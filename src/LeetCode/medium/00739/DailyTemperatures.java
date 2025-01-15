import java.util.*;

/**
 739. Daily Temperatures

 Medium

 Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 Example 1:

 Input: temperatures = [73,74,75,71,69,72,76,73]
 Output: [1,1,4,2,1,1,0,0]
 Example 2:

 Input: temperatures = [30,40,50,60]
 Output: [1,1,1,0]
 Example 3:

 Input: temperatures = [30,60,90]
 Output: [1,1,0]

 Constraints:

 1 <= temperatures.length <= 105
 30 <= temperatures[i] <= 100
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        // Test case 1
        int[] T1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected1 = {1, 1, 4, 2, 1, 1, 0, 0};
        int[] result1 = dailyTemperatures(T1);
        runTestCase(T1, result1, expected1);

        // Test case 2
        int[] T2 = {30, 40, 50, 60};
        int[] expected2 = {1, 1, 1, 0};
        int[] result2 = dailyTemperatures(T2);
        runTestCase(T2, result2, expected2);

        // Test case 3
        int[] T3 = {30, 20, 10};
        int[] expected3 = {0, 0, 0};
        int[] result3 = dailyTemperatures(T3);
        runTestCase(T3, result3, expected3);
    }

    /**
     * Helper function to execute a test case, compare expected vs actual, and print the results.
     *
     * @param T The input array of daily temperatures.
     * @param result The actual result array returned by the function.
     * @param expected The expected output array.
     */
    private static void runTestCase(int[] T, int[] result, int[] expected) {
        System.out.println("Input: " + Arrays.toString(T));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(result));

        // Check if the result matches the expected output
        if (Arrays.equals(result, expected)) {
            System.out.println("Test Result: PASS");
        } else {
            System.out.println("Test Result: FAIL");
        }
        System.out.println();
    }

    /**
     * Function to find the number of days until a warmer temperature.
     *
     * @param T The input array of daily temperatures.
     * @return An array with the number of days until a warmer temperature.
     */
    public static int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array and use a stack to store indices
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index; // Calculate the number of days until a warmer day
            }
            stack.push(i);
        }

        return result;
    }

    /**
     * Brute-force solution for Daily Temperatures problem.
     *
     * @param T The input array of daily temperatures.
     * @return An array with the number of days until a warmer temperature.
     */
    public int[] dailyTemperatures2(int[] T) {
        int n = T.length;
        int[] ans = new int[n];

        // Iterate over each day's temperature
        for (int i = 0; i < n; i++) {
            // Look for the next warmer temperature in the upcoming days
            for (int j = i + 1; j < n; j++) {
                if (T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }

        return ans;
    }
}
