import java.util.Arrays;
/**
 88. Merge Sorted Array
 Easy

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109


Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */

public class MergeSortedArray {
    public static void main(String[] args) {

        // Test case 1 - Standard merge of two sorted arrays
        int[] nums1_1 = {1, 2, 3, 0, 0, 0};
        int[] nums2_1 = {2, 5, 6};
        int m1 = 3;
        int n1 = 3;
        int[] expected1 = {1, 2, 2, 3, 5, 6};
        merge(nums1_1, m1, nums2_1, n1);
        System.out.println("Test Case 1 - Expected: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual: " + Arrays.toString(nums1_1));

        // Test case 2 - nums1 is already sorted and nums2 is empty
        int[] nums1_2 = {1};
        int[] nums2_2 = {};
        int m2 = 1;
        int n2 = 0;
        int[] expected2 = {1};
        merge(nums1_2, m2, nums2_2, n2);
        System.out.println("Test Case 2 - Expected: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual: " + Arrays.toString(nums1_2));

        // Test case 3 - nums1 is empty and nums2 has elements
        int[] nums1_3 = {0};
        int[] nums2_3 = {1};
        int m3 = 0;
        int n3 = 1;
        int[] expected3 = {1};
        merge(nums1_3, m3, nums2_3, n3);
        System.out.println("Test Case 3 - Expected: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Actual: " + Arrays.toString(nums1_3));

        // Test case 4 - nums1 has only zeros initially and all elements from nums2 need to be merged
        int[] nums1_4 = {0, 0, 0, 0, 0};
        int[] nums2_4 = {1, 2, 3, 4, 5};
        int m4 = 0;
        int n4 = 5;
        int[] expected4 = {1, 2, 3, 4, 5};
        merge(nums1_4, m4, nums2_4, n4);
        System.out.println("Test Case 4 - Expected: " + Arrays.toString(expected4));
        System.out.println("Test Case 4 - Actual: " + Arrays.toString(nums1_4));
    }

    /**
     * Merge nums2 into nums1 as one sorted array.
     *
     * @param nums1 The first array, which has enough space to hold both nums1 and nums2.
     * @param m     The number of elements in nums1.
     * @param nums2 The second array.
     * @param n     The number of elements in nums2.
     */

   /**  Algorithm Steps:
    1. Set three pointers:
       i - pointing to the last element of the effective part of nums1 (m-1).
       j - pointing to the last element of nums2 (n-1).
       k - pointing to the last position in nums1 (m + n - 1).
    2. Compare the elements from the end of both arrays:
       a. If nums1[i] > nums2[j], place nums1[i] in the last position (nums1[k]) and move i and k backward.
       b. Otherwise, place nums2[j] in the last position (nums1[k]) and move j and k backward.
    3. Continue step 2 until one of the arrays is exhausted.
    4. If nums2 still has remaining elements, copy them into the remaining positions of nums1.
   
    Time Complexity: O(m + n)
    We process each element of nums1 and nums2 exactly once.
   
    Space Complexity: O(1)
    We do not use any extra space, just modifying the input array nums1 in place.
   */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start filling nums1 from the back (m + n - 1)
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for final position in nums1

        // Merge in reverse order
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are any remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
