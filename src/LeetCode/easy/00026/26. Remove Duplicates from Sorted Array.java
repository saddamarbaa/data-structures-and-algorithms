/*
26. Remove Duplicates from Sorted Array
Easy
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
element appears only once. The relative order of the elements should be kept the same. Then return the number of
unique elements in nums.

Consider the number of unique elements of nums be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were
present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.


Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4
respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.h
nums[i] is 0 or 1
 */

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {

        // Test case 1:
        int[] nums1 = {1, 1, 2};
        int[] expectedNums1 = {1, 2};
        int k1 = removeDuplicates(nums1);
        assert k1 == expectedNums1.length;
        for (int i = 0; i < k1; i++) {
            assert nums1[i] == expectedNums1[i];
        }
        System.out.println("Input array: " + Arrays.toString(nums1));
        System.out.println("Number of unique elements in Test case 1: " + k1);

        // Test case 2:
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedNums2 = {0, 1, 2, 3, 4};
        int k2 = removeDuplicates(nums2);
        assert k2 == expectedNums2.length;
        for (int i = 0; i < k2; i++) {
            assert nums2[i] == expectedNums2[i];
        }
        System.out.println("Input array: " + Arrays.toString(nums2));
        System.out.println("Number of unique elements in Test case 2: " + k2);

        // Test case 3:
        int[] nums3 = {1, 1, 1, 1, 1, 1};
        int[] expectedNums3 = {1};
        int k3 = removeDuplicates(nums3);
        assert k3 == expectedNums3.length;
        for (int i = 0; i < k3; i++) {
            assert nums3[i] == expectedNums3[i];
        }
        System.out.println("Input array: " + Arrays.toString(nums3));
        System.out.println("Number of unique elements in Test case 3: " + k3);

        // Test case 4:
        int[] nums4 = {1, 2, 3, 4, 5};
        int[] expectedNums4 = {1, 2, 3, 4, 5};
        int k4 = removeDuplicates(nums4);
        assert k4 == expectedNums4.length;
        for (int i = 0; i < k4; i++) {
            assert nums4[i] == expectedNums4[i];
        }
        System.out.println("Input array: " + Arrays.toString(nums4));
        System.out.println("Number of unique elements in Test case 4:  " + k4);

        // Test case 5:
        int[] nums5 = {};
        int[] expectedNums5 = {};
        int k5 = removeDuplicates(nums5);
        assert k5 == expectedNums5.length;
        for (int i = 0; i < k5; i++) {
            assert nums5[i] == expectedNums5[i];
        }
        System.out.println("Input array: " + Arrays.toString(nums5));
        System.out.println("Number of unique elements in Test case 5: " + k5);

    }


    /**
     * Remove Duplicates from Sorted Array from a sorted integer array in-place, such that each unique element
     * appears only once.
     * The relative order of the elements is kept the same. The method returns the number of unique elements in the
     * modified array.
     * Algorithm steps:
     * Check if the input array nums is null. If it is null, an IllegalArgumentException is thrown.
     * Initialize two pointers: current and next. Both start at the beginning of the array.
     * Iterate over the elements of the input array nums while the next pointer is less than the length of the array.
     * If the current element is equal to the next element, move the next pointer to the next element.
     * Otherwise, update the current element to the next unique element by copying the element at next pointer to the
     * position after current, then move both pointers to the next element.
     * Once the iteration is complete, the method returns the number of unique elements, which is the current pointer
     * plus one.
     * Time complexity: The method iterates over all the elements of the input array once. Therefore, the time
     * complexity is O(n), where n is the length of the input array.
     * Space complexity: The algorithm modifies the input array in-place, so it has a space complexity of O(1).
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int n = nums.length;
        int leftPointer = 0;
        int rightPointer = 1;
        while (rightPointer < n) {
            if (nums[rightPointer] != nums[leftPointer]) {
                leftPointer = leftPointer + 1;
                nums[leftPointer] = nums[rightPointer];
            }
            rightPointer++;
        }
        return leftPointer + 1;
    }


    /**
     * Remove Duplicates from Sorted Array
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
     * element appears only once. The relative order of the elements should be kept the same. Then return the number of
     * unique elements in nums.
     * Algorithm steps:
     * Iterate over the elements of the input array nums.
     * If the current element is equal to the next element, skip to the next iteration.
     * Otherwise, update the current element to the next unique element and increment the counter.
     * To ensure the solution is correct, we will use a custom judge to test it.
     * Time complexity:
     * The method iterates over all the elements of the input array once. Therefore, the time complexity is O(n),
     * where n is the length of the input array.
     * Space complexity:
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int n = nums.length;

        // Handle edge case of empty array
        if (n == 0) {
            return 0;
        }

        int uniqueCount = 0; // count of unique elements seen so far
        int nextAvailablePosition = 0; // next available position in the output array

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                // skip duplicate elements
            } else {
                // copy the current element to the next available position
                nums[nextAvailablePosition] = nums[i];
                nextAvailablePosition++;
                uniqueCount++;
            }
        }

        // copy the last element of the input array to the next available position
        nums[nextAvailablePosition] = nums[n - 1];
        uniqueCount++;

        // Handle edge case of all elements being duplicates
        if (uniqueCount == 1) {
            return 1;
        }

        return uniqueCount;
    }

}