/***
 643. Maximum Average Subarray I

 Given an integer array nums and an integer k, find the maximum average of a subarray of size k.

 Implement the solution using a sliding window approach:

 1. Initialize a variable to store the sum of the first k elements.
 2. Slide the window by adding the next element and removing the first element from the window.
 3. Track the maximum sum during each window slide, and divide by k to get the average.

 Example 1:
 Input:
 [1,12,-5,-6,50,3], k = 4
 Output:
 12.75
 Explanation:
 When k = 4, the subarray with the maximum average is [12,-5,-6,50], which has an average of 12.75.

 Constraints:
 1 <= nums.length <= 10^5
 -10^4 <= nums[i] <= 10^4
 1 <= k <= nums.length
 */

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        // Calculate the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Use the sliding window technique to find the maximum sum of any subarray of size 'k'
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];  // Slide the window by adding the new element and removing the old one
            maxSum = Math.max(maxSum, sum); // Track the maximum sum
        }

        // Return the maximum average by dividing the sum by 'k'
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        // Test case 1:
        // Array: [1,12,-5,-6,50,3], k = 4
        // The maximum average is 12.75
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        Solution solution1 = new Solution();
        System.out.println("Test case 1: " + solution1.findMaxAverage(nums1, 4)); // Output: 12.75

        // Test case 2:
        // Array: [5, -2, 3, 7], k = 2
        // The maximum average is 5
        int[] nums2 = {5, -2, 3, 7};
        Solution solution2 = new Solution();
        System.out.println("Test case 2: " + solution2.findMaxAverage(nums2, 2)); // Output: 5.0
    }
}
