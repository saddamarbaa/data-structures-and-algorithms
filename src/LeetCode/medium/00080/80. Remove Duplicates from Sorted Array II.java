/*
80. Remove Duplicates from Sorted Array II
Medium

Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique
element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be
placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k
elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra
 memory.

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

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3
respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3
respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 */

import java.util.Arrays;

public class  RemoveDuplicates {
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
        System.out.println("Number of unique elements in Test case 4: " + k4);

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

        // Test case 6:
        int[] nums6 = {1, 1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 5};
        int[] expectedNums6 = {1, 2, 3, 4, 5};
        int k6 = removeDuplicates(nums6);
        assert k6 == expectedNums6.length;
        for (int i = 0; i < k6; i++) {
            assert nums6[i] == expectedNums6[i];
        }
        System.out.println("Input array: " + Arrays.toString(nums6));
        System.out.println("Number of unique elements in Test case 6: " + k6);

        // Test case 7:
        int[] nums7 = {1, 2, 3, 4, 5};
        int[] expectedNums7 = {1, 2, 3, 4, 5};
        int k7 = removeDuplicates(nums7);
        assert k7 == expectedNums7.length;
        for (int i = 0; i < k7; i++) {
            assert nums7[i] == expectedNums7[i];
        }
        System.out.println("Input array: " + Arrays.toString(nums7));
        System.out.println("Number of unique elements in Test case 7: " + k7);

        // Test case 8:
        int[] nums8 = {1, 1, 1};
        int[] expectedNums8 = {1};
        int k8 = removeDuplicates(nums8);
        assert k8 == expectedNums8.length;
        for (int i = 0; i < k8; i++) {
            assert nums8[i] == expectedNums8[i];
        }
        System.out.println("Input array: " + Arrays.toString(nums8));
        System.out.println("Number of unique elements in Test case 8: " + k8);

        // Test case 9:
        int[] nums9 = {1};
        int[] expectedNums9 = {1};
        int k9 = removeDuplicates(nums9);
        assert k9 == expectedNums9.length;
        for (int i = 0; i < k9; i++) {
            assert nums9[i] == expectedNums9[i];
        }
        System.out.println("Input array: " + Arrays.toString(nums9));
        System.out.println("Number of unique elements in Test case 9: " + k9);

        // Test case 10:
        int[] nums10 = {1, 1, 2, 2, 3, 3, 4, 4};
        int[] expectedNums10 = {1, 2, 3, 4};
        int k10 = removeDuplicates(nums10);
        assert k10 == expectedNums10.length;
        for (int i = 0; i < k10; i++) {
            assert nums10[i] == expectedNums10[i];
        }
        System.out.println("Input array: " + Arrays.toString(nums10));
        System.out.println("Number of unique elements in Test case 10: " + k10);


        // Test case 11:
        int[] nums11 = {2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 12, 12, 14, 14, 14, 14};
        int[] expectedNums11 = {2, 3, 4, 5, 6, 7, 12, 14};
        int k11 = removeDuplicates(nums11);
        assert k11 == expectedNums11.length;
        for (int i = 0; i < k11; i++) {
            assert nums11[i] == expectedNums11[i];
        }
        System.out.println("Input array: " + Arrays.toString(nums11));
        System.out.println("Number of unique elements in Test case 11: " + k11);


    }


    /**
     * Remove Duplicates from Sorted Array II
     * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique
     * element appears at most twice. The relative order of the elements should be kept the same. Then return the
     * number of
     * unique elements in nums after removal of duplicates.
     * Algorithm steps:
     * - Initialize leftPointer to 1 and rightPointer to 2.
     * - Iterate over the elements of the input array nums from rightPointer to n.
     * - If the current element at rightPointer is different from the previous two elements (nums[leftPointer-1] and
     * nums[leftPointer]),
     * increment leftPointer and update nums[leftPointer] to nums[rightPointer].
     * - Otherwise, skip to the next iteration.
     * - After the loop, return leftPointer + 1 as the number of unique elements.
     * To ensure the solution is correct, we will use a custom judge to test it.
     * Time complexity:
     * The method iterates over all the elements of the input array once. Therefore, the time complexity is O(n),
     * where n is the length of the input array.
     * Space complexity:
     * The method only uses constant extra space, therefore the space complexity is O(1).
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int leftPointer = 1;
        int rightPointer = 2;
        while (rightPointer < n) {
            if (nums[rightPointer] != nums[leftPointer - 1]) {
                leftPointer = leftPointer + 1;
                nums[leftPointer] = nums[rightPointer];
            }
            rightPointer++;
        }
        return leftPointer + 1;
    }
}