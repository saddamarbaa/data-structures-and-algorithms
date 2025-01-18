import java.util.*;

/**
 2951. Find the Peaks

 Easy

 Given an array of integers, return a list of peaks. A peak is an element that is strictly greater than both its neighbors.

 Example 1:

 Input: arr = [1, 3, 2, 5, 4]
 Output: [3, 5]
 Explanation: 3 is a peak because it is greater than 1 and 2. 5 is a peak because it is greater than 2 and 4.

 Example 2:

 Input: arr = [10, 20, 15, 2, 23, 90, 67]
 Output: [20, 90]
 Explanation: 20 is a peak because it is greater than 10 and 15. 90 is a peak because it is greater than 23 and 67.

 Constraints:

 - The array length will be at least 3.
 - There may be multiple peaks in the array.
 */
public class FindPeaks {
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 3, 2, 5, 4};
        List<Integer> expected1 = Arrays.asList(3, 5);
        List<Integer> result1 = findPeaks(arr1);
        runTestCase(arr1, result1, expected1);

        // Test case 2
        int[] arr2 = {10, 20, 15, 2, 23, 90, 67};
        List<Integer> expected2 = Arrays.asList(20, 90);
        List<Integer> result2 = findPeaks(arr2);
        runTestCase(arr2, result2, expected2);

        // Test case 3 using the third method
        List<Integer> result3 = findPeaks3(arr2);
        runTestCase(arr2, result3, expected2);
    }

    /**
     * Helper function to execute a test case, compare expected vs actual, and print the results.
     *
     * @param arr The input array of integers.
     * @param result The actual result list returned by the function.
     * @param expected The expected output list.
     */
    private static void runTestCase(int[] arr, List<Integer> result, List<Integer> expected) {
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + result);

        // Check if the result matches the expected output
        if (result.equals(expected)) {
            System.out.println("Test Result: PASS");
        } else {
            System.out.println("Test Result: FAIL");
        }
        System.out.println();
    }

    /**
     * Function to find peaks in the array.
     *
     * @param arr The input array of integers.
     * @return A list of peaks.
     */
    public static List<Integer> findPeaks(int[] arr) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                peaks.add(arr[i]);
            }
        }
        return peaks;
    }

    /**
     * Alternative function to find peaks using StringBuilder (example-based logic).
     *
     * @param arr The input array of integers.
     * @return A list of peaks.
     */
    public static List<Integer> findPeaks2(int[] arr) {
        StringBuilder sb = new StringBuilder();
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                sb.append(arr[i]).append(" ");
                peaks.add(arr[i]);
            }
        }
        return peaks;
    }

    /**
     * Third function to find peaks using manual approach (like defangIPaddr3).
     *
     * @param arr The input array of integers.
     * @return A list of peaks.
     */
    public static List<Integer> findPeaks3(int[] arr) {
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                peaks.add(arr[i]);
            }
        }

        return peaks;
    }
}
