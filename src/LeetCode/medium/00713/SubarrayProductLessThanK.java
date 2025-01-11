/**
 713. Subarray Product Less Than K

 Medium
 Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 Example 1:

 Input: nums = [10,5,2,6], k = 100
 Output: 8
 Explanation: The 8 subarrays that have product less than 100 are:
 [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 Example 2:

 Input: nums = [1,2,3], k = 0
 Output: 0


 Constraints:

 1 <= nums.length <= 3 * 104
 1 <= nums[i] <= 1000
 0 <= k <= 106
 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        // Test case 1:
        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        int result1 = numSubarrayProductLessThanK(nums1, k1);
        System.out.println("Test Case 1 - Input: " + arrayToString(nums1) + ", k = " + k1);
        System.out.println("Test Case 1 - Result: " + result1);

        // Test case 2:
        int[] nums2 = {1, 2, 3};
        int k2 = 0;
        int result2 = numSubarrayProductLessThanK(nums2, k2);
        System.out.println("Test Case 2 - Input: " + arrayToString(nums2) + ", k = " + k2);
        System.out.println("Test Case 2 - Result: " + result2);

        // Test case 3: single element
        int[] nums3 = {10};
        int k3 = 5;
        int result3 = numSubarrayProductLessThanK(nums3, k3);
        System.out.println("Test Case 3 - Input: " + arrayToString(nums3) + ", k = " + k3);
        System.out.println("Test Case 3 - Result: " + result3);
    }

    /**
     * Subarray Product Less Than K
     * Given an array of integers nums and an integer k, find the number of contiguous subarrays where the product of all the elements is strictly less than k.
     *
     * Algorithm Steps:
     * 1. Initialize the product to 1 and two pointers (left, right).
     * 2. Expand the right pointer by multiplying the current element to the product.
     * 3. Shrink the window from the left until the product is less than k.
     * 4. Count all subarrays ending at the current position (right).
     * 5. Return the total count of valid subarrays.
     *
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1) because we are using constant extra space.
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;  // If k <= 1, no product can be strictly less than k.

        int count = 0;        // To store the count of valid subarrays.
        int prod = 1;         // Initialize the product to 1.
        int left = 0;         // Left pointer of the sliding window.

        // Traverse the array using the right pointer.
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];  // Multiply the current element to the product.

            // Shrink the window until the product is less than k.
            while (prod >= k && left <= right) {
                prod /= nums[left];  // Divide out the left element.
                left++;  // Move the left pointer to the right.
            }

            // Add the number of subarrays ending at 'right'.
            count += right - left + 1;
        }

        return count;
    }

    /**
     * O(n²) Solution: Brute force approach
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public static int numSubarrayProductLessThanK_On2(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int prod = 1;  // Reset product for every new starting point (i)
            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                if (prod < k) {
                    count++;  // Valid subarray found
                } else {
                    break;  // Stop when product exceeds or equals k
                }
            }
        }

        return count;
    }


    // Helper method to convert an array to a string for easy display.
    public static String arrayToString(int[] arr) {
        if (arr == null || arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
