package Recursion;
/*
Print all subsets of an array using recursion
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        System.out.println("Subsets of " + Arrays.toString(arr1) + ":");
        printSubsets(arr1);

        int[] arr2 = {4, 5, 6};
        System.out.println("Subsets of " + Arrays.toString(arr2) + ":");
        printSubsets(arr2);


        int[] arr3 = {2, 4, 6, 10};
        int k1 = 16;
        System.out.println("Subsequences of arr1 with sum " + k1 + ":");
        printSubsequencesWithSumK(arr3, k1);

        int[] arr4 = {1, 2, 3, 4, 5};
        int k2 = 9;
        System.out.println("Subsequences of arr2 with sum " + k2 + ":");
        printSubsequencesWithSumK(arr4, k2);
    }


    /**
     * Print all subsets of an array using recursion
     * Algorithm Steps:
     * 1. Create a helper method printSubsetsHelper(arr, index, subset) to recursively generate all subsets of the
     * array.
     * 2. In the helper method
     * If the index is equal to the length of the array, print the current subset and return.
     * Add the current element to the subset, and call the helper method with the next index.
     * Remove the current element from the subset, and call the helper method with the next index.
     * Time Complexity: The time complexity of this algorithm is O(2^n), where n is the length of the input array.
     * This is because there are 2^n possible subsets of the array, and we need to generate all of them.
     * Space Complexity: The space complexity of this algorithm is O(n), where n is the length of the input array.
     * This is because we are using a list to store each subset, and the maximum size of the list is n when we are
     * generating the subset with all the elements in the array. Additionally, the recursive call stack has a maximum
     * depth of n, as we are calling the helper method n times recursively..
     */
    public static void printSubsets(int[] arr) {
        List<Integer> subset = new ArrayList<>();
        printSubsetsHelper(arr, 0, subset);
    }

    private static void printSubsetsHelper(int[] arr, int index, List<Integer> subset) {
        // Base case: If index equals the length of the array, we've reached the end and can print the subset
        if (index == arr.length) {
            System.out.println(subset);
            return;
        }

        // Recursive case 1: Include the current element in the subset and move to the next index
        subset.add(arr[index]);
        printSubsetsHelper(arr, index + 1, subset);

        // Recursive case 2: Exclude the current element from the subset and move to the next index
        subset.remove(subset.size() - 1);
        printSubsetsHelper(arr, index + 1, subset);
    }


    public static void printSubsequencesWithSumK(int[] arr, int k) {
        List<Integer> subset = new ArrayList<>();
        printSubsequencesWithSumKHelper(arr, 0, subset, k, 0);
    }

    private static void printSubsequencesWithSumKHelper(int[] arr, int index, List<Integer> subset, int k, int sum) {
        // Base case: If index equals the length of the array, we've reached the end and can check if the subset sum
        // is k
        if (index == arr.length) {
            if (sum == k) {
                System.out.println(subset);
            }
            return;
        }

        // Recursive case 1: Include the current element in the subset and move to the next index
        subset.add(arr[index]);
        printSubsequencesWithSumKHelper(arr, index + 1, subset, k, sum + arr[index]);

        // Recursive case 2: Exclude the current element from the subset and move to the next index
        subset.remove(subset.size() - 1);
        printSubsequencesWithSumKHelper(arr, index + 1, subset, k, sum);
    }
}





