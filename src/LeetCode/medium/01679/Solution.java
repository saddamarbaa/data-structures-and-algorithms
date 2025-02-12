/***
 1679. Max Number of K-Sum Pairs

 You are given an integer array nums and an integer k.

 In one operation, you can pick two numbers from the array whose sum is equal to k, and remove them from the array.

 Return the maximum number of operations you can perform on the array.

 Example 1:
 Input: nums = [1,2,3,4], k = 5
 Output: 2
 Explanation: (1, 4) and (2, 3) are valid pairs, so the maximum number of operations is 2.

 Example 2:
 Input: nums = [3,1,3,4,3], k = 6
 Output: 1
 Explanation: (3, 3) is the only valid pair, so the maximum number of operations is 1.

 Constraints:
 1 <= nums.length <= 105
 1 <= nums[i] <= 1000
 1 <= k <= 1000
 */

import java.util.HashMap;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int operations = 0;

        // Count the occurrences of each number in the array
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // For each number, try to find its complement that sums up to k
        for (int num : nums) {
            int complement = k - num;

            // If the complement exists and there are remaining numbers to form a pair
            if (countMap.getOrDefault(num, 0) > 0 && countMap.getOrDefault(complement, 0) > 0) {
                // Handle the case where the number and its complement are the same
                if (num == complement && countMap.get(num) > 1) {
                    operations++;
                    countMap.put(num, countMap.get(num) - 2); // Decrease count by 2 (pair found)
                }
                // Handle the case where the number and complement are different
                else if (num != complement) {
                    operations++;
                    countMap.put(num, countMap.get(num) - 1); // Decrease count of the number
                    countMap.put(complement, countMap.get(complement) - 1); // Decrease count of the complement
                }
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        // Test case 1:
        // Array: [1,2,3,4], k = 5
        // Pairs (1,4) and (2,3) can be selected, so the maximum number of operations is 2.
        int[] nums1 = {1, 2, 3, 4};
        Solution solution1 = new Solution();
        System.out.println("Test case 1: " + solution1.maxOperations(nums1, 5)); // Output: 2

        // Test case 2:
        // Array: [3,1,3,4,3], k = 6
        // Only the pair (3,3) can be selected, so the maximum number of operations is 1.
        int[] nums2 = {3, 1, 3, 4, 3};
        Solution solution2 = new Solution();
        System.out.println("Test case 2: " + solution2.maxOperations(nums2, 6)); // Output: 1
    }
}
