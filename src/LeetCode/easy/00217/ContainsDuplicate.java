/**
 217. Contains Duplicate

 Easy
 Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 Example 1:

 Input: nums = [1,2,3,1]

 Output: true

 Explanation:

 The element 1 occurs at the indices 0 and 3.

 Example 2:

 Input: nums = [1,2,3,4]

 Output: false

 Explanation:

 All elements are distinct.

 Example 3:

 Input: nums = [1,1,1,3,3,4,3,2,4,2]

 Output: true

 Constraints:

 1 <= nums.length <= 105
 -109 <= nums[i] <= 109
 */


import java.util.HashSet;
import java.util.Arrays;

/**
 * 217. Contains Duplicate
 * Easy
 *
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        
        // Test case 1 - Contains duplicates
        int[] nums1 = {1, 2, 3, 1};
        boolean expected1 = true;
        boolean result1 = containsDuplicate(nums1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2 - No duplicates
        int[] nums2 = {1, 2, 3, 4};
        boolean expected2 = false;
        boolean result2 = containsDuplicate(nums2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);

        // Test case 3 - Multiple duplicates
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean expected3 = true;
        boolean result3 = containsDuplicate(nums3);
        System.out.println("Test Case 3 - Expected: " + expected3);
        System.out.println("Test Case 3 - Actual: " + result3);
    }

    /**
     * Checks if the given array contains any duplicates.
     *
     * @param nums The integer array to check for duplicates.
     * @return True if any value appears at least twice, false if all elements are distinct.
     */
    public static boolean containsDuplicate(int[] nums) {
        // Use a HashSet to track the elements we have seen
        HashSet<Integer> set = new HashSet<>();
        
        // Iterate through the array
        for (int num : nums) {
            // If the element already exists in the set, it's a duplicate
            if (set.contains(num)) {
                return true;
            }
            // Otherwise, add the element to the set
            set.add(num);
        }
        
        // No duplicates found
        return false;
    }


    /**
     * Checks if the given array contains any duplicates.
     *
     * @param nums The integer array to check for duplicates.
     * @return True if any value appears at least twice, false if all elements are distinct.
     */
    public static boolean containsDuplicate2(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Check for adjacent duplicates
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true; // Found a duplicate
            }
        }

        // No duplicates found
        return false;
    }
}
