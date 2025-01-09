/**
 2149. Rearrange Array Elements by Sign

 Medium
 You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
 You should rearrange the elements of nums such that the modified array follows these conditions:
 1. Every consecutive pair of integers have opposite signs.
 2. For all integers with the same sign, the order in which they were present in nums is preserved.
 Return the rearranged array.

 Example 1:
 Input: nums = [3,1,-2,-5,2,-4]
 Output: [3,-2,1,-5,2,-4]
 Explanation: The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
 The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].

 Example 2:
 Input: nums = [-1,1]
 Output: [1,-1]
 Explanation: 1 and -1 are the only possible way to rearrange nums.

 Constraints:
 - 2 <= nums.length <= 2 * 105
 - nums.length is even
 - 1 <= |nums[i]| <= 105
 - nums consists of equal number of positive and negative integers.
 */

public class RearrangeArrayBySign {

    public static void main(String[] args) {
        testRearrangeArrayFunction();
    }

    public static void testRearrangeArrayFunction() {
        // Test case 1
        int[] nums1 = {3, 1, -2, -5, 2, -4};
        int[] expected1 = {3, -2, 1, -5, 2, -4};
        int[] result1 = rearrangeArray(nums1);
        System.out.println("Test Case 1 - Input: [3,1,-2,-5,2,-4]");
        System.out.println("Test Case 1 - Expected result: " + arrayToString(expected1));
        System.out.println("Test Case 1 - Result: " + arrayToString(result1));
        System.out.println();

        // Test case 2
        int[] nums2 = {-1, 1};
        int[] expected2 = {1, -1};
        int[] result2 = rearrangeArray(nums2);
        System.out.println("Test Case 2 - Input: [-1,1]");
        System.out.println("Test Case 2 - Expected result: " + arrayToString(expected2));
        System.out.println("Test Case 2 - Result: " + arrayToString(result2));
        System.out.println();

        // Test case 3
        int[] nums3 = {5, -6, 3, -4, 1, -2};
        int[] expected3 = {5, -6, 3, -4, 1, -2};
        int[] result3 = rearrangeArray(nums3);
        System.out.println("Test Case 3 - Input: [5,-6,3,-4,1,-2]");
        System.out.println("Test Case 3 - Expected result: " + arrayToString(expected3));
        System.out.println("Test Case 3 - Result: " + arrayToString(result3));
    }

    // Method 1: Two Pointer Approach
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int posIndex = 0, negIndex = 1;

        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }

        return result;
    }

    // Method 2: Brute Force Approach
    public static int[] rearrangeArray2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[posIndex] = nums[i];
                posIndex += 2;
            } else {
                result[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return result;
    }

    // Method 3: In-place Rearrangement Using Temp Array
    public static int[] rearrangeArray3(int[] nums) {
        int n = nums.length;
        int l = 0;
        int k = n / 2;

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                temp[l++] = nums[i];
            } else {
                temp[k++] = nums[i];
            }
        }

        l = 0;
        k = n / 2;

        for (int i = 0; i < n; i += 2) {
            nums[i] = temp[l++];
            nums[i + 1] = temp[k++];
        }

        return nums;
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
