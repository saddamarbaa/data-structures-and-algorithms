/**
 1004. Max Consecutive Ones III

 Medium
 Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.


 Example 1:

 Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 Output: 6
 Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 Example 2:

 Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 Output: 10
 Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


 Constraints:

 1 <= nums.length <= 105
 nums[i] is either 0 or 1.
 0 <= k <= nums.length
 */

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        testMaxConsecutiveOnesFunction();
    }

    public static void testMaxConsecutiveOnesFunction() {
        // Test case 1
        int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        int expected1 = 6;
        int result1 = longestOnes(nums1, k1);
        int result2 = longestOnes2(nums1, k1);
        System.out.println("Test Case 1 - Input: [1,1,1,0,0,0,1,1,1,1,0], k = 2");
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Method 1 Result: " + result1);
        System.out.println("Test Case 1 - Method 2 Result: " + result2);
        System.out.println();

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 0, 0};
        int k2 = 0;
        int expected2 = 3;
        int result3 = longestOnes(nums2, k2);
        int result4 = longestOnes2(nums2, k2);
        System.out.println("Test Case 2 - Input: [0,0,1,1,1,0,0], k = 0");
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Method 1 Result: " + result3);
        System.out.println("Test Case 2 - Method 2 Result: " + result4);
        System.out.println();

        // Test case 3: All 1s with large k
        int[] nums3 = {1, 1, 1, 1};
        int k3 = 2;
        int expected3 = 4;
        int result5 = longestOnes(nums3, k3);
        int result6 = longestOnes2(nums3, k3);
        System.out.println("Test Case 3 - Input: [1,1,1,1], k = 2");
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Method 1 Result: " + result5);
        System.out.println("Test Case 3 - Method 2 Result: " + result6);
        System.out.println();

        // Test case 4: All 0s with large k
        int[] nums4 = {0, 0, 0, 0};
        int k4 = 3;
        int expected4 = 3;
        int result7 = longestOnes(nums4, k4);
        int result8 = longestOnes2(nums4, k4);
        System.out.println("Test Case 4 - Input: [0,0,0,0], k = 3");
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Method 1 Result: " + result7);
        System.out.println("Test Case 4 - Method 2 Result: " + result8);
    }

    // Method 1: Sliding Window Approach
    public static int longestOnes(int[] nums, int k) {
        int l = 0;
        int zeroCount = 0;
        int maxCount = 0;
        int n = nums.length;

        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[l] == 0) {
                    zeroCount--;
                }
                l++;
            }

            maxCount = Math.max(maxCount, r - l + 1);
        }

        return maxCount;
    }

    // Method 2: Brute Force Approach
    public static int longestOnes2(int[] nums, int k) {
        int l = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int maxCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    maxCount++;
                }
                if (maxCount <= k) {
                    l = Math.max(j - i + 1, l);
                } else {
                    break;
                }
            }
        }

        return l;
    }
}
