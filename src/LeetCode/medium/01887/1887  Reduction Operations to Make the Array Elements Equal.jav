/*
 1887. Reduction Operations to Make the Array Elements Equal
Medium
Companies
Given an integer array nums, your goal is to make all elements in nums equal. To complete one operation, follow these steps:

Find the largest value in nums. Let its index be i (0-indexed) and its value be largest. If there are multiple elements with the largest value, pick the smallest i.
Find the next largest value in nums strictly smaller than largest. Let its value be nextLargest.
Reduce nums[i] to nextLargest.
Return the number of operations to make all elements in nums equal.

 

Example 1:

Input: nums = [5,1,3]
Output: 3
Explanation: It takes 3 operations to make all elements in nums equal:
1. largest = 5 at index 0. nextLargest = 3. Reduce nums[0] to 3. nums = [3,1,3].
2. largest = 3 at index 0. nextLargest = 1. Reduce nums[0] to 1. nums = [1,1,3].
3. largest = 3 at index 2. nextLargest = 1. Reduce nums[2] to 1. nums = [1,1,1].
Example 2:

Input: nums = [1,1,1]
Output: 0
Explanation: All elements in nums are already equal.
Example 3:

Input: nums = [1,1,2,2,3]
Output: 4
Explanation: It takes 4 operations to make all elements in nums equal:
1. largest = 3 at index 4. nextLargest = 2. Reduce nums[4] to 2. nums = [1,1,2,2,2].
2. largest = 2 at index 2. nextLargest = 1. Reduce nums[2] to 1. nums = [1,1,1,2,2].
3. largest = 2 at index 3. nextLargest = 1. Reduce nums[3] to 1. nums = [1,1,1,1,2].
4. largest = 2 at index 4. nextLargest = 1. Reduce nums[4] to 1. nums = [1,1,1,1,1].
 

Constraints:

1 <= nums.length <= 5 * 104
1 <= nums[i] <= 5 * 104
 */

import java.util.Arrays;

public class ArrayOperations{
    public static int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int movesNeeded = 0;
        for (int i = 0; i < n - 1; i++) {
            // Count the number of different elements
            if (nums[i] != nums[i + 1]) {
                // Add the difference to the total number of moves needed
                movesNeeded += n - i - 1;
            }
        }
        return movesNeeded;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 1, 3};
        int[] arr2 = {1, 1, 1};
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {2, 5, 3, 2, 3, 5, 5, 3, 5};
        int[] arr5 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        int[] arr6 = {100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81,
                80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60,
                59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39,
                38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18,
                17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};


        System.out.println("reductionOperations(arr1): " + reductionOperations(arr1)); // Expected output: 3


        System.out.println("reductionOperations(arr2): " + reductionOperations(arr2)); // Expected output: 0


        System.out.println("reductionOperations(arr3): " + reductionOperations(arr3)); // Expected output: 10

        System.out.println("reductionOperations(arr4): " + reductionOperations(arr4)); // Expected output: 11

        System.out.println("reductionOperations(arr5): " + reductionOperations(arr5)); // Expected output: 190


        System.out.println("reductionOperations(arr6): " + reductionOperations(arr6)); // Expected output: 4950

    }


    // un optimal solution
    public static int reductionOperations2(int[] arr1) {
        // If all elements are already equal, no operations are required
        if ((arr1.length > 1 && Arrays.stream(arr1).distinct().count() == 1)) {
            return 0;
        }

        int n = arr1.length;
        int count = 0;

        // Repeatedly find the largest element and replace it with the second largest element
        while (!(Arrays.stream(arr1).distinct().count() == 1)) {
            for (int j = 0; j < n; j++) {
                // Find the indexes of the largest and second largest elements in the array
                int[] indexesArray = findLargestIndices(arr1);
                int largestIndex = indexesArray[0];
                int secondLargestIndex = indexesArray[1];

                // If the largest element and second largest element are the same, break out of the loop
                if (largestIndex == secondLargestIndex) break;
                ;
                // Increment the count of operations and replace the largest element with the second largest element
                count++;
                arr1[largestIndex] = arr1[secondLargestIndex];
            }
        }

        return count;
    }

    // Part of the un optimal solution
    public static int[] findLargestIndices(int[] arr) {
        // We start by assuming that the largest element is at index 0, and the second largest is undefined
        int maxIndex = 0;
        int secondMaxIndex = -1;

        // If all elements in the array are the same, then there is no second largest element, so we return {0, 0}
        if (arr.length > 1 && Arrays.stream(arr).distinct().count() == 1) {
            return new int[]{0, 0};
        }

        // We loop through all the elements in the array, updating maxIndex and secondMaxIndex as needed
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                // If the current element is greater than the current maximum, then the previous maximum becomes the 
                // second maximum,
                // and the current element becomes the new maximum
                secondMaxIndex = maxIndex;
                maxIndex = i;
            } else if (secondMaxIndex == -1 || arr[i] > arr[secondMaxIndex]) {
                // If the current element is greater than the current second maximum, but less than the maximum,
                // then it becomes the new second maximum
                if (arr[i] < arr[maxIndex]) {
                    secondMaxIndex = i;
                }
            }
        }

        // We return the indices of the two largest elements in an array
        int[] result = {maxIndex, secondMaxIndex};
        return result;
    }
}
