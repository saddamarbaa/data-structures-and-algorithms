package Recursion;
/*
Print all subsets of an array using recursion
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintSubsets {

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
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        printSubsetsHelper(arr, 0, subset, res);
        System.out.println(res);
    }

    private static void printSubsetsHelper(int[] arr, int index, List<Integer> subset,List<List<Integer>> res) {
        // Base case: If index equals the length of the array, we've reached the end and can print the subset
        if (index == arr.length) {
            System.out.println(subset);
            res.add(new ArrayList<>(subset));
//            System.out.println(res);
            return;
        }

        // Recursive case 1: Include the current element in the subset and move to the next index
        subset.add(arr[index]);
        printSubsetsHelper(arr, index + 1, subset,res);

        // Recursive case 2: Exclude the current element from the subset and move to the next index
        subset.remove(subset.size() - 1);
        printSubsetsHelper(arr, index + 1, subset,res);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, res);
        return res;
    }

    private static void helper(int[] arr, int index, List<Integer> subset,List<List<Integer>> res) {

        if (index == arr.length) {
            // System.out.println(subset);
            res.add(new ArrayList<>(subset));
            return;
        }


        subset.add(arr[index]);
        helper(arr, index + 1, subset,res);

        subset.remove(subset.size() - 1);
        helper(arr, index + 1, subset,res);
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
        sum = sum + arr[index];
        printSubsequencesWithSumKHelper(arr, index + 1, subset, k, sum);

        // Recursive case 2: Exclude the current element from the subset and move to the next index
        subset.remove(subset.size() - 1);
        sum = sum - arr[index];
        printSubsequencesWithSumKHelper(arr, index + 1, subset, k, sum);
    }
    private static ArrayList<String> subsequencesList(String unprocess, String process) {
        if(process.isEmpty()){
            ArrayList<String>list = new ArrayList<>();
            list.add(unprocess);
            return  list;
        }

        char ch = process.charAt(0);

        ArrayList<String> left = subsequencesList((unprocess+ch), process.substring(1));
        ArrayList<String> right= subsequencesList(unprocess, process.substring(1));
        left.addAll(right);
        return  left;
    }


    private static void printSubsequences(String unprocess, String process) {
        if(process.isEmpty()){
            System.out.println(unprocess);
            return;
        }
        char ch = process.charAt(0);

        printSubsequences((unprocess+ch), process.substring(1));
        printSubsequences(unprocess, process.substring(1));
    }



    // Method to count the total number of subsequences using recursive approach
    static int countSubsequences(String str) {
        return countSubsequencesHelper(str, 0);
    }

    // Helper method to count subsequences recursively
    static int countSubsequencesHelper(String str, int index) {
        // Base case: if we have reached the end of the string, return 1 (the empty subsequence)
        if (index == str.length()) {
            return 1;
        }

        // Recursive case: for each character, we have two choices - include or exclude
        int exclude = countSubsequencesHelper(str, index + 1);    // Exclude the current character
        int include = countSubsequencesHelper(str, index + 1);    // Include the current character

        // Total subsequences = subsequences excluding current character + subsequences including current character
        return exclude + include;
    }


    public static void func(int ind, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> sumSubset) {
        if(ind == N) {
            sumSubset.add(sum);
            return;
        }

        // pick the element
        func(ind + 1, sum + arr.get(ind), arr, N, sumSubset);

        // Do-not pick the element
        func(ind + 1, sum, arr, N, sumSubset);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> sumSubset = new ArrayList<>();
        func(0, 0, arr, N, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

}