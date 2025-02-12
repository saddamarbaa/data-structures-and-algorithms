/***
 303. Range Sum Query - Immutable

 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Implement the NumArray class:

 NumArray(int[] nums) Initializes the object with the integer array nums.
 int sumRange(int i, int j) Returns the sum of the elements of nums between indices i and j (i ≤ j), inclusive.

 Example 1:
 Input:
 ["NumArray", "sumRange", "sumRange", "sumRange"]
 [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 Output:
 [null, 1, 1, -3]

 Explanation:
 NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 numArray.sumRange(0, 2); // return 1 (i.e sum of the elements nums[0] + nums[1] + nums[2] = -2 + 0 + 3 = 1)
 numArray.sumRange(2, 5); // return 1 (i.e sum of the elements nums[2] + nums[3] + nums[4] + nums[5] = 3 + -5 + 2 + -1 = 1)
 numArray.sumRange(0, 5); // return -3 (i.e sum of the elements nums[0] + nums[1] + nums[2] + nums[3] + nums[4] + nums[5] = -2 + 0 + 3 + -5 + 2 + -1 = -3)

 Constraints:

 1 <= nums.length <= 10^4
 -10^9 <= nums[i] <= 10^9
 0 <= i <= j < nums.length
 At most 10^4 calls will be made to sumRange.
 */

public class NumArray {
    private int[] prefixSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n + 1];

        // Precompute the prefix sum array
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        // Return the sum using the prefix sum array
        return prefixSum[j + 1] - prefixSum[i];
    }

    public static void main(String[] args) {
        // Test case 1:
        // Array: [-2, 0, 3, -5, 2, -1]
        // sumRange(0, 2) = 1
        int[] nums1 = {-2, 0, 3, -5, 2, -1};
        NumArray numArray1 = new NumArray(nums1);
        System.out.println("Test case 1: " + numArray1.sumRange(0, 2)); // Output: 1

        // Test case 2:
        // Array: [1, 2, 3, 4, 5]
        // sumRange(1, 3) = 9
        int[] nums2 = {1, 2, 3, 4, 5};
        NumArray numArray2 = new NumArray(nums2);
        System.out.println("Test case 2: " + numArray2.sumRange(1, 3)); // Output: 9
    }
}
