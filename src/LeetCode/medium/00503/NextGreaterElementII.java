/**
 503. Next Greater Element II

 Medium

 Given a circular integer array `nums` (i.e., the next element of nums[nums.length - 1] is nums[0]),
 for each element in `nums`, return the next greater number. The next greater number of a number x is
 the first greater number to its traversing-order next in the array, which means you could search
 circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 Example 1:

 Input: nums = [1,2,1]
 Output: [2,-1,2]
 Explanation: The first 1's next greater number is 2;
 The number 2 can't find next greater number.
 The second 1's next greater number needs to search circularly, which is also 2.

 Example 2:

 Input: nums = [1,2,3,4,3]
 Output: [2,3,4,-1,4]

 Constraints:
 - 1 <= nums.length <= 104
 - -109 <= nums[i] <= 109
 */

import java.util.*;

public class NextGreaterElementII {
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 1};
        int[] expected1 = {2, -1, 2};
        int[] result1 = nextGreaterElements(nums1);
        System.out.println("Test Case 1 - Expected: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual: " + Arrays.toString(result1));

        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 3};
        int[] expected2 = {2, 3, 4, -1, 4};
        int[] result2 = nextGreaterElements(nums2);
        System.out.println("Test Case 2 - Expected: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual: " + Arrays.toString(result2));
    }

    /**
     * Function to find the next greater element in a circular array.
     *
     * @param nums The input array.
     * @return An array of next greater elements.
     */
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize the result array with -1 for all elements
        Arrays.fill(result, -1);

        // Traverse the array twice to simulate circular behavior
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Initialize result array with -1
        Arrays.fill(ans, -1);

        // Iterate over the array
        for (int i = 0; i < n; i++) {
            // First pass: Look for the next greater element from i+1 to the end
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break; // Break since we found the next greater element
                }
            }

            // If no greater element was found, look from the start to i
            if (ans[i] == -1) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        ans[i] = nums[j];
                        break; // Break since we found the next greater element
                    }
                }
            }
        }

        return ans;
    }

}
