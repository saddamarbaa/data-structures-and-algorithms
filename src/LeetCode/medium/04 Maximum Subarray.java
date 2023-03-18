/*
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
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

class MaximumSubarray {
    public static void main(String[] args) {
        // Test case 1: simple array with positive numbers
        int[] array1 = {1, 2, 3, 4, 5};
        int maxSum1 = maxSubArray(array1);
        System.out.println("Max subarray sum for array1: " + maxSum1); // prints Max subarray sum for array1: 15

        // Test case 2: simple array with negative numbers
        int[] array2 = {-1, -2, -3, -4, -5};
        int maxSum2 = maxSubArray(array2);
        System.out.println("Max subarray sum for array2: " + maxSum2); // prints Max subarray sum for array2: -1

        // Test case 3: array with both positive and negative numbers
        int[] array3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum3 = maxSubArray(array3);
        System.out.println("Max subarray sum for array3: " + maxSum3); // prints Max subarray sum for array3: 6

        // Test case 4: array with all equal numbers
        int[] array4 = {2, 2, 2, 2, 2};
        int maxSum4 = maxSubArray(array4);
        System.out.println("Max subarray sum for array4: " + maxSum4); // prints Max subarray sum for array4: 10

        // Test case 5: array with only one number
        int[] array5 = {10};
        int maxSum5 = maxSubArray(array5);
        System.out.println("Max subarray sum for array5: " + maxSum5); // prints Max subarray sum for array5: 10

        // Test case 6: array with all negative numbers except one positive number
        int[] array6 = {-10, -5, -20, -30, -15, 5, -25};
        int maxSum6 = maxSubArray(array6);
        System.out.println("Max subarray sum for array6: " + maxSum6); // prints Max subarray sum for array6: 5

        // Test case 7: empty array
        int[] array7 = {};
        int maxSum7 = maxSubArray(array7);
        System.out.println("Max subarray sum for array7: " + maxSum7); // prints Max subarray sum for array7: 0

        // Test case 8: array with alternating positive and negative numbers
        int[] array8 = {1, -2, 3, -4, 5, -6};
        int maxSum8 = maxSubArray(array8);
        System.out.println("Max subarray sum for array8: " + maxSum8); // prints Max subarray sum for array8: 5

        // Test case 9: array with all negative numbers
        int[] array9 = {-5, -10, -15, -20, -25};
        int maxSum9 = maxSubArray(array9);
        System.out.println("Max subarray sum for array9: " + maxSum9); // prints Max subarray sum for array9: -5
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
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);

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


    // un optimal solution O(N3)
    public int maxSubArray3(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        // Loop through all possible subarrays of array
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int subarraySum = 0;

                // Loop through the subarray from index i to j (inclusive) and calculate its sum
                for (int k = i; k <= j; k++) {
                    subarraySum += nums[k];
                }

                // Update max if the sum of this subarray is greater than current max
                max = Math.max(max, subarraySum);
            }
        }

        // Print the maximum sum of all subarrays
        System.out.println("Maximum subarray sum: " + max);

        return max;
    }

}
