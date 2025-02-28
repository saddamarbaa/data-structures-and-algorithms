/**
 1749. Maximum Absolute Sum of Any Subarray

 Medium

 You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

 Return the maximum absolute sum of any (possibly empty) subarray of nums.

 Note that abs(x) is defined as follows:

 If x is a negative integer, then abs(x) = -x.
 If x is a non-negative integer, then abs(x) = x.

 Example 1:

 Input: nums = [1,-3,2,3,-4]
 Output: 5
 Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
 Example 2:

 Input: nums = [2,-5,1,-4,3,-2]
 Output: 8
 Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.


 Constraints:

 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 */
public class MaximumAbsoluteSumSubarray {

    public static void main(String[] args) {
        int[] nums1 = {1, -3, 2, 3, -4};
        int[] nums2 = {2, -5, 1, -4, 3, -2};

        // Test Case 1
        System.out.println("Test Case 1:");
        System.out.println("Maximum Absolute Sum of Subarray (Solution 1): " + maxAbsoluteSum(nums1)); // Output: 5
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2:");
        System.out.println("Maximum Absolute Sum of Subarray (Solution 1): " + maxAbsoluteSum(nums2)); // Output: 8
    }

    /**
     * Solution: Kadane's Algorithm for Maximum and Minimum Subarray Sum
     * Algorithm:
     * 1. Traverse the array and keep track of two variables: `maxSum` and `minSum`.
     * 2. `maxSum` represents the largest sum of any subarray.
     * 3. `minSum` represents the smallest (most negative) sum of any subarray.
     * 4. The maximum absolute sum will be the maximum of the absolute values of `maxSum` and `minSum`.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1), as we only use a constant amount of space.
     */
    public static int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0;
        int currentMax = 0, currentMin = 0;

        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num); // Kadane's for max subarray
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(currentMin + num, num); // Kadane's for min subarray
            minSum = Math.min(minSum, currentMin);
        }

        return Math.max(Math.abs(maxSum), Math.abs(minSum)); // Maximum absolute sum
    }
}
