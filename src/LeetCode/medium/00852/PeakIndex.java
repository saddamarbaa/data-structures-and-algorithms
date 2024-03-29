/*
852. Peak Index in a Mountain Array
Medium
An array arr a mountain if the following properties hold:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > .
.. > arr[arr.length - 1].
You must solve it in O(log(arr.length)) time complexity.
 */


import java.util.*;

public class PeakIndex {
    public static void main(String[] args) {

        // Test Case 3 - Peak at the end
        int[] arr3 = {1, 3, 5, 9, 7, 4, 2};
        int expected3 = 4;
        printTestResult(arr3, expected3);

        // Test Case 2 - Peak in the middle
        int[] arr2 = {0, 10, 5, 2};
        int expected2 = 1;
        printTestResult(arr2, expected2);

        // Test Case 4 - Peak at the beginning
        int[] arr4 = {1, 2, 5, 7, 9,5,4,3,2};
        int expected4 = 5;
        printTestResult(arr4, expected4);

        
    }

    public static void printTestResult(int[] arr, int expected) {
        int result = peakIndexInMountainArray(arr);
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        System.out.println("Result matches expected: " + (result == expected));
        System.out.println();
    }


   /*
   Algorithm Steps:
   1. Initialize left = 0 and right = length - 1, where length is the length of the input array.
    2. Iterate while left <= right:
    a. Calculate mid as the average of left and right: mid = left + (right - left) / 2.
    b. Retrieve the elements at mid, mid-1, and mid+1 positions: midNumber = arr[mid], previousNumber = arr[mid - 1],
     nextNumber = arr[mid + 1].
    c. If midNumber is greater than both previousNumber and nextNumber, return mid (peak found).
    d. If midNumber is less than previousNumber, update right = mid, as the peak might be on the left side.
    e. Otherwise, update left = mid + 1, as the peak might be on the right side.
    3. Return left (peak not found).

   Space Complexity: O(1) - The algorithm uses a constant amount of extra space.
   Time Complexity: O(log n) - The algorithm performs binary search on the array, reducing the search space by half in
  each iteration. Hence, it has a logarithmic time complexity.
*/

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midNumber = arr[mid];
            int previousNumber = arr[mid - 1];
            int nextNumber = arr[mid + 1];
            if (midNumber > previousNumber && midNumber > nextNumber) {
                return mid;  // Peak found
            } else if (midNumber < previousNumber) {
                right = mid;  // Peak might be on the left side
            } else {
                left = mid + 1;  // Peak might be on the right side
            }
        }

        return left;  // Peak not found
    }

    public static int peakIndexInMountainArray2(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return i - 1;
            }
        }
        return 0;
    }
}