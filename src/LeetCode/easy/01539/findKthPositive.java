/*
1539. Kth Missing Positive Number
Easy

Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length

Follow up:
Could you solve this problem in less than O(n) complexity?
 */


import java.util.*;

public class FindKthPositive {
    public static void main(String[] args) {

        // Test Case 1 - Missing value in the middle
        int[] arr1 = {2, 3, 4, 7, 11};
        int k1 = 5;
        int expected1 = 9;
        int result1 = findKthPositive(arr1, k1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(arr1) + ", k = " + k1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test Case 2 - Missing value at the beginning
        int[] arr2 = {3, 4, 5, 7, 11};
        int k2 = 1;
        int expected2 = 1;
        int result2 = findKthPositive(arr2, k2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(arr2) + ", k = " + k2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test Case 3 - Missing value at the end
        int[] arr3 = {2, 3, 4, 5, 7};
        int k3 = 3;
        int expected3 = 8;
        int result3 = findKthPositive(arr3, k3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(arr3) + ", k = " + k3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test Case 4 - All missing values
        int[] arr4 = {1, 2, 3, 4, 5};
        int k4 = 5;
        int expected4 = 10;
        int result4 = findKthPositive(arr4, k4);
        System.out.println("Test Case 4 - Input: " + Arrays.toString(arr4) + ", k = " + k4);
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));
    }




    /*
    Algorithm Steps:
    1. Initialize missingCount and currentNumber variables to 0.
    2. Create a set called existingNumbers to store unique elements from the nums array.
    3. Iterate over the nums array and add each element to the existingNumbers set.
    4. Iterate from 1 to the last element of the nums array.
        - If the current number is not present in the existingNumbers set, increment missingCount.
        - If missingCount becomes equal to k, set currentNumber to the current number and break the loop.
    5. If missingCount is equal to k, return currentNumber.
    6. Otherwise, calculate the missing value by adding k to the last element of the nums array and subtracting
    missingCount.
    7. Return the calculated missing value.

    Time Complexity: O(n + k), where n is the length of the nums array.
      - The first loop takes O(n) time to iterate over the nums array and add elements to the set.
      - The second loop iterates up to the last element of the nums array or until the kth missing value is found.
        In the worst case, it takes O(n) time.
      - Overall, the time complexity is dominated by the larger of the two loops.

    Space Complexity: O(n), where n is the length of the nums array.
      - The space used by the set is proportional to the number of unique elements in the nums array, which can be at
       most n.
      - Therefore, the space complexity is O(n).
    */

    public static int findKthPositive(int[] nums, int k) {
        int missingCount = 0;
        int currentNumber = 0;
        HashSet<Integer> existingNumbers = new HashSet<>();

        for (int num : nums) {
            existingNumbers.add(num);
        }

        for (int i = 1; i <= nums[nums.length - 1]; i++) {
            if (!existingNumbers.contains(i)) {
                missingCount++;
            }

            if (missingCount == k) {
                currentNumber = i;
                break;
            }
        }

        if (missingCount == k) {
            return currentNumber;
        } else {
            return nums[nums.length - 1] + k - missingCount;
        }
    }
}