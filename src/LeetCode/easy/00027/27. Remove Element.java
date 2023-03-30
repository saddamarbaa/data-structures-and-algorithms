/*
27. Remove Element
Easy
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the
elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the
following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The
remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.


Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
 */

import java.util.Arrays;

public class Arra {
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int[] expectedNums1 = {2, 2};
        int k1 = removeElement(nums1, val1);

        System.out.println("Input array in test case 1: " + Arrays.toString(nums1));
        System.out.println("Expected array in test case 1: " + Arrays.toString(expectedNums1));
        System.out.println("Number of elements not equal to " + val1 + " in test case 1: " + k1);

        for (int i = 0; i < k1; i++) {
            if (nums1[i] != expectedNums1[i]) {
                System.out.println("Test case 1 failed: Mismatch at index " + i);
                break;
            }
        }

      // Test case 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int[] expectedNums2 = {0, 1, 3, 0, 4};
        int k2 = removeElement(nums2, val2);

        System.out.println("Input array in test case 2: " + Arrays.toString(nums2));
        System.out.println("Expected array in test case 2: " + Arrays.toString(expectedNums2));
        System.out.println("Number of elements not equal to " + val2 + " in test case 2: " + k2);

        for (int i = 0; i < k2; i++) {
            if (nums2[i] != expectedNums2[i]) {
                System.out.println("Test case 2 failed: Mismatch at index " + i);
                break;
            }
        }

       // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int val3 = 6;
        int[] expectedNums3 = {1, 2, 3, 4, 5};
        int k3 = removeElement(nums3, val3);

        System.out.println("Input array in test case 3: " + Arrays.toString(nums3));
        System.out.println("Expected array in test case 3: " + Arrays.toString(expectedNums3));
        System.out.println("Number of elements not equal to " + val3 + " in test case 3: " + k3);

        for (int i = 0; i < k3; i++) {
            if (nums3[i] != expectedNums3[i]) {
                System.out.println("Test case 3 failed: Mismatch at index " + i);
                break;
            }
        }

       // Test case 4
        int[] nums4 = {1};
        int val4 = 1;
        int[] expectedNums4 = {};
        int k4 = removeElement(nums4, val4);

        System.out.println("Input array in test case 4: " + Arrays.toString(nums4));
        System.out.println("Expected array in test case 4: " + Arrays.toString(expectedNums4));
        System.out.println("Number of elements not equal to " + val4 + " in test case 4: " + k4);

        for (int i = 0; i < k4; i++) {
            if (nums4[i] != expectedNums4[i]) {
                System.out.println("Test case 4 failed: Mismatch at index " + i);
                break;
            }
        }
    }


    /**
     * Remove Element
     * Given an array nums and a value val, remove all instances of that value in-place and return the new length of
     * the array.
     * The order of the elements can be changed. It doesn't matter what you leave beyond the new length.
     * <p>
     * Algorithm steps:
     * 1. Initialize two pointers, i and j, where i is initially set to 0 and j is initially set to the last index of
     * the array.
     * 2. While i is less than j, do the following:
     * a. If nums[i] is equal to val, swap the value of nums[i] with the value at the end of the array (nums[j]),
     * decrement j, and continue with the next iteration of the loop.
     * b. If nums[i] is not equal to val, increment i and continue with the next iteration of the loop.
     * 3. Return i as the new length of the array.
     * <p>
     * To ensure the solution is correct, we will use a custom judge to test it.
     * <p>
     * Time complexity:
     * The method iterates over all the elements of the input array once. Therefore, the time complexity is O(n),
     * where n is the length of the input array.
     * <p>
     * Space complexity:
     * The method uses constant extra space.  Therefore, the space complexity is O(1).
     */
    public static int removeElement(int[] nums, int val) {
        int leftPointer = 0, rightPointer = nums.length - 1;

        while (leftPointer <= rightPointer) {
            if (nums[leftPointer] != val) {
                leftPointer++;
            } else {
                int temp = nums[rightPointer];
                nums[rightPointer] = nums[leftPointer];
                nums[leftPointer] = temp;
                rightPointer--;
            }
        }

        return leftPointer;
    }
}