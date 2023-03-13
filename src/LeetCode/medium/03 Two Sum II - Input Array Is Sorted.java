/*
67. Two Sum II - Input Array Is Sorted
Medium
Companies
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
*/

import java.util.Arrays;

class TwoSum {
    public static void main(String[] args) {
        // Short input array
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(numbers1, target1);
        System.out.println(Arrays.toString(result1)); // should print [1, 2]

        // Long input array
        int[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int target2 = 27;
        int[] result2 = twoSum(numbers2, target2);
        System.out.println(Arrays.toString(result2)); // should print [7, 11]

        // Input array with negative numbers
        int[] numbers3 = {-3, -1, 0, 2, 4, 7, 9};
        int target3 = 6;
        int[] result3 = twoSum(numbers3, target3);
        System.out.println(Arrays.toString(result3)); // should print [3, 6]

        // Input array with duplicates
        int[] numbers4 = {2, 2, 3, 4, 5, 6, 7};
        int target4 = 8;
        int[] result4 = twoSum(numbers4, target4);
        System.out.println(Arrays.toString(result4)); // should print [1, 2]

        // Input array with all zeroes
        int[] numbers5 = {0, 0, 0, 0, 0};
        int target5 = 0;
        int[] result5 = twoSum(numbers5, target5);
        System.out.println(Arrays.toString(result5)); // should print [1, 2]

        // Input array with no solution
        int[] numbers6 = {2, 3, 4, 6, 7, 8, 10};
        int target6 = 5;
        int[] result6 = twoSum(numbers6, target6);
        System.out.println(Arrays.toString(result6)); // should print null

        // Input array with one solution
        int[] numbers7 = {2, 3, 4, 5, 6};
        int target7 = 8;
        int[] result7 = twoSum(numbers7, target7);
        System.out.println(Arrays.toString(result7)); // should print [2, 4]

        // Input array with all negative numbers
        int[] numbers8 = {-5, -3, -2, -1};
        int target8 = -6;
        int[] result8 = twoSum(numbers8, target8);
        System.out.println(Arrays.toString(result8)); // should print [1, 3]

        // Input array with large target value
        int[] numbers9 = {1, 2, 3, 4, 5, 6};
        int target9 = 100;
        int[] result9 = twoSum(numbers9, target9);
        System.out.println(Arrays.toString(result9)); // should print null

        // Input array with large negative target value
        int[] numbers10 = {1, 2, 3, 4, 5, 6};
        int target10 = -10;
        int[] result10 = twoSum(numbers10, target10);
        System.out.println(Arrays.toString(result10));
    }


    // optimal solution time complexity O(log n) and space complexity O(n)
    public static int[] twoSum(int[] numbers, int target) {
        // Use two pointers to find the pair of elements that add up to the target
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // We should never reach this point if there is a valid solution.
        // However, if we do, we can return null or throw an exception.
        return null;
    }


}
