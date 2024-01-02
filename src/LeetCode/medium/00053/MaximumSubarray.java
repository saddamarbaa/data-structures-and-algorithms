/**
 53. Maximum Subarray
 Medium

 Given an integer array nums, find the
 subarray
 with the largest sum, and return its sum.

 Example 1:

 Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 Output: 6
 Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 Example 2:

 Input: nums = [1]
 Output: 1
 Explanation: The subarray [1] has the largest sum 1.
 Example 3:

 Input: nums = [5,4,-1,7,8]
 Output: 23
 Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


 Constraints:

 1 <= nums.length <= 105
 -104 <= nums[i] <= 104


 Follow up: If you have figured out the O(n) solution,
 try coding another solution using the divide and conquer approach, which is more subtle.
 */

import java.util.Arrays;

public class  MaximumSubarray {

        public static void main(String[] args) {
            // Test Case 1
            int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            int expected1 = 6;
            int result1 = maxSubArray(nums1);
            printResult(nums1, result1, expected1);

            // Test Case 2
            int[] nums2 = {1};
            int expected2 = 1;
            int result2 = maxSubArray(nums2);
            printResult(nums2, result2, expected2);

            // Test Case 3
            int[] nums3 = {5, 4, -1, 7, 8};
            int expected3 = 23;
            int result3 = maxSubArray(nums3);
            printResult(nums3, result3, expected3);
    }


    /**
     * Optimal solution
     * Kadane's Algorithm for Maximum Subarray problem
     * <p>
     * Algorithm steps:
     * 1. Initialize two variables, maxSoFar and maxEndingHere, to the first element of the array.
     * 2. Iterate through the array, starting from the second element.
     * 3. At each iteration, update the maxEndingHere variable by taking the maximum of either the current element
     * or the sum of the current element and the maxEndingHere.
     * 4. If the maxEndingHere is greater than the maxSoFar, update the maxSoFar.
     * 5. After iterating through the entire array, return the maxSoFar.
     * <p>
     * Time Complexity: O(n), where n is the length of the array.
     *
     * @param nums an integer array
     * @return the maximum sum of a contiguous subarray within the input array
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < n; i++) {
            // update maxEndingHere by taking the maximum of either the current element or the sum of the current
            // element
            // and the maxEndingHere

            int sumWithCurrent = maxEndingHere + nums[i];

            maxEndingHere = Math.max(nums[i],sumWithCurrent);


            // update maxSoFar if maxEndingHere is greater than maxSoFar
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }


    // un optimal solution O(N2)
    public static int maxSubArray2(int[] nums) {
        int n = nums.length;
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int currentsum = 0;
            for (int j = i; j < n; j++) {
                currentsum += nums[j];
                maximum = Math.max(maximum, currentsum);
            }
        }
        return maximum;
    }


    /**
     * Algorithm Steps:
     * 1. Initialize maxSum to Integer.MIN_VALUE to keep track of the maximum subarray sum.
     * 2. Iterate over all possible starting indices (start).
     *    - For each starting index, iterate over all possible ending indices (end).
     *    - Calculate the sum of the subarray from start to end.
     *    - Update maxSum if the current subarray sum is greater than the current maxSum.
     *    - Print the subarray and its sum.
     * 3. After the loops, return the maximum subarray sum.

     * Time Complexity:
     *    - The time complexity is O(n^3) due to the three nested loops. For each starting index,
     *      there is a nested loop over all possible ending indices, and within that, another loop
     *      to calculate the sum of the subarray.
     *
     * Space Complexity:
     *    - The space complexity is O(1) as there is no additional space used that grows with the
     *      input size. Only a constant amount of space is used for variables like maxSum, subarraySum,
     *      and loop counters.
     */

    // un optimal solution O(N3)
    public static int maxSubArray3(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        // Outer loop to iterate over all possible starting indices
        for (int start = 0; start < n; start++) {
            // Inner loop to iterate over all possible ending indices
            for (int end = start; end < n; end++) {
                // Calculate the sum of the subarray from start to end
                int subarraySum = 0;
                for (int i = start; i <= end; i++) {
                    subarraySum += nums[i];
                }

                // Update the maximum sum if the current subarray sum is greater
                maxSum = Math.max(maxSum, subarraySum);


                // Print the subarray and its sum
                System.out.print("[");
                for (int i = start; i <= end; i++) {
                    System.out.print(nums[i]);
                    if (i < end) {
                        System.out.print(", ");
                    }
                }
                System.out.println("], Sum: " + subarraySum);
            }
        }

        // Print the maximum subarray sum
        System.out.println("Maximum Subarray Sum: " + maxSum);

        return maxSum;
    }

    /**
     * Print the result of a test case.
     */
    private static void printResult(int[] nums, int result, int expected) {
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        System.out.println("Result matches expected: " + (result == expected));
        System.out.println();
    }
}
