/**
 1752. Check if Array Is Sorted and Rotated

 Easy

 Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

 There may be duplicates in the original array.

 Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

 Example 1:

 Input: nums = [3,4,5,1,2]
 Output: true
 Explanation: [1,2,3,4,5] is the original sorted array.
 You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
 Example 2:

 Input: nums = [2,1,3,4]
 Output: false
 Explanation: There is no sorted array once rotated that can make nums.
 Example 3:

 Input: nums = [1,2,3]
 Output: true
 Explanation: [1,2,3] is the original sorted array.
 You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.


 Constraints:

 1 <= nums.length <= 100
 1 <= nums[i] <= 100
 */
public class CheckIfSortedAndRotated {

    public static void main(String[] args) {
        testCheckSortedAndRotatedFunction();
    }

    public static void testCheckSortedAndRotatedFunction() {
        // Test case 1: Rotated sorted array
        int[] nums1 = {3, 4, 5, 1, 2};
        boolean expected1 = true;
        boolean result1 = check(nums1);
        System.out.println("Test Case 1 - Input: " + arrayToString(nums1));
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2: Unsorted array
        int[] nums2 = {2, 1, 3, 4};
        boolean expected2 = false;
        boolean result2 = check(nums2);
        System.out.println("Test Case 2 - Input: " + arrayToString(nums2));
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3: Sorted array, not rotated
        int[] nums3 = {1, 2, 3};
        boolean expected3 = true;
        boolean result3 = check(nums3);
        System.out.println("Test Case 3 - Input: " + arrayToString(nums3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case 4: All elements are the same
        int[] nums4 = {1, 1, 1};
        boolean expected4 = true;
        boolean result4 = check(nums4);
        System.out.println("Test Case 4 - Input: " + arrayToString(nums4));
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));
    }

    public static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;

        // Count the number of places where the array is decreasing
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }

            // If there is more than one decrease, the array is not sorted and rotated
            if (count > 1) {
                return false;
            }
        }

        return true; // The array is sorted and rotated
    }

    // Helper function to convert array to string
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
