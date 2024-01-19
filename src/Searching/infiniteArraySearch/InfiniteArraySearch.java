package Searching.infiniteArraySearch;

import java.util.Arrays;

/*
 Problem Statement: Infinite Array Search

You are given a sorted array of integers that is conceptually infinite in size. The array is sorted in ascending order, and there are at least two different integers in the array.

Your task is to implement a function searchInInfiniteArray that takes a sorted array and a target integer as input and returns the index of the target integer in the array. If the target integer is not present, return -1.

The array is conceptually infinite, meaning you cannot determine its size explicitly. To address this, you should use an approach that involves exponential growth to dynamically find an appropriate search space.
 */

public class InfiniteArraySearch {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17,19,20,23,24,26,29};
       

        // Test Case 1
        int target1 = 9;
        int expected1 = 4;
        printTestCaseResult(sortedArray, target1, expected1);

        // Test Case 2
        int target2 = 5;
        int expected2 = 2;
        printTestCaseResult(sortedArray, target2, expected2);

        // Test Case 3
        int target3 = 13;
        int expected3 = 6;
        printTestCaseResult(sortedArray, target3, expected3);

        // Test Case 4
        int target4 = 2;
        int expected4 = -1;
        printTestCaseResult(sortedArray, target4, expected4);
    }

    public static void printTestCaseResult(int[] arr, int target, int expected) {
        int result = searchInInfiniteArray(arr, target);
        System.out.println("Input: " + Arrays.toString(arr) + ", Target: " + target);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        System.out.println("Result matches expected: " + (result == expected));
        System.out.println();
    }

    /**
    Algorithm:
    1. Initialize variables low to 0 and high to 1.
    2. Exponentially increase the range by setting low to high and doubling high until arr[high] is greater than or equal to the target.
    3. Perform a binary search in the range [low, high] to find the target element.
    4. If the target is found, return its index; otherwise, return -1.
    
    Time Complexity:
    - The exponential growth step takes O(log n) time, where n is the index of the target element.
    - The binary search step takes O(log n) time.
    - Overall time complexity is O(log n).
    
    Space Complexity:
    - Constant space is used, O(1), as there are no additional data structures that grow with the input.
    
    Note: The assumption is that the array is conceptually infinite, and the target element exists in the array.
    */

    public static int searchInInfiniteArray(int[] arr, int target) {
        int low = 0;
        int high = 1;

        // Exponential growth to find the appropriate range
        while (arr[high] < target) {
            low = high;
            high *= 2;
        }

        // Binary search in the found range
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Element found
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Element not found
    }
}
