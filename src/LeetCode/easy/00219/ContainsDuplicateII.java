import java.util.HashMap;

/**
 * 219. Contains Duplicate II
 * Easy
 *
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
 * such that nums[i] == nums[j] and |i - j| <= k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {

        // Test case 1 - Contains duplicates within range k
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        boolean expected1 = true;
        boolean result1 = containsNearbyDuplicate(nums1, k1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2 - Contains duplicates within range k
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        boolean expected2 = true;
        boolean result2 = containsNearbyDuplicate(nums2, k2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);

        // Test case 3 - No duplicates within range k
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        boolean expected3 = false;
        boolean result3 = containsNearbyDuplicate(nums3, k3);
        System.out.println("Test Case 3 - Expected: " + expected3);
        System.out.println("Test Case 3 - Actual: " + result3);
    }

    /**
     * Checks if there are any duplicates within a given range k.
     *
     * @param nums The integer array to check for duplicates.
     * @param k The maximum allowed difference between indices of duplicates.
     * @return True if there are duplicates within range k, false otherwise.
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashMap to store the index of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // If element exists in map and the difference of indices is <= k
            if(map.containsKey(nums[i])  && Math.abs(map.get(nums[i]) - i) <= k){
                return true;
            }
            // Update the index of the current element
            map.put(nums[i], i);
        }

        // No duplicates found within range k
        return false;
    }
}
