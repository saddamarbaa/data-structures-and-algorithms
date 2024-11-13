/*
1460. Make Two Arrays Equal by Reversing Subarrays
Easy
You are given two integer arrays of equal length `target` and `arr`. In one step, you can select any non-empty subarray of arr and reverse it. You are allowed to make any number of steps.

Return true if you can make arr equal to target, or false otherwise.

Example 1:

Input: target = [1,2,3,4], arr = [2,4,1,3]
Output: true
Explanation: You can reverse subarrays in arr to match target.

Example 2:

Input: target = [7], arr = [7]
Output: true
Explanation: arr is already equal to target, no need to reverse any subarrays.

Example 3:

Input: target = [3,7,9], arr = [3,7,11]
Output: false
Explanation: arr does not have the same elements as target, so we cannot make them equal.

Constraints:

- target.length == arr.length
- 1 <= target.length <= 1000
- 1 <= target[i] <= 1000
- 1 <= arr[i] <= 1000
*/

import java.util.*;

public class MakeTwoArraysEqual {
    public static void main(String[] args) {
        // Test cases
        testMakeTwoArraysEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}, true);
        testMakeTwoArraysEqual(new int[]{7}, new int[]{7}, true);
        testMakeTwoArraysEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11}, false);
        testMakeTwoArraysEqual(new int[]{1, 1, 1, 2}, new int[]{2, 1, 1, 1}, true);
    }

    public static void testMakeTwoArraysEqual(int[] target, int[] arr, boolean expected) {
        boolean result = canBeEqual(target, arr);
        System.out.println("Target: " + Arrays.toString(target) + ", Arr: " + Arrays.toString(arr) + ", Expected: " + expected + ", Result: " + result);
        System.out.println("Test passed: " + (result == expected));
        System.out.println();
    }

    /**
     * Algorithm:
     * 1. Sort both `target` and `arr`.
     * 2. Check if the sorted arrays are equal. If they are, return true; otherwise, return false.
     * 
     * The logic behind this is that reversing a subarray will not change the multiset of elements in the array.
     * Therefore, if two arrays have the same elements in the same frequency, they can be made equal.
     *
     * Time Complexity: O(n log n) due to sorting.
     * Space Complexity: O(n) - Space used to store the sorted arrays.
     */
    public static boolean canBeEqual(int[] target, int[] arr) {
        // Sort both arrays
        Arrays.sort(target);
        Arrays.sort(arr);


         //    for(int i = 0; i < arr.length; i++){
    //     if(arr[i] != target[i]){
    //         return false;
    //     }
    //    }

    //     return true;


        // Check if sorted arrays are equal
        return Arrays.equals(target, arr);
    }
}
