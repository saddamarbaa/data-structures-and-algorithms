/**
 229. Majority Element II

 Medium

 Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 Example 1:

 Input: nums = [3,2,3]
 Output: [3]
 Example 2:

 Input: nums = [1]
 Output: [1]
 Example 3:

 Input: nums = [1,2]
 Output: [1,2]

 Constraints:

 1 <= nums.length <= 5 * 104
 -109 <= nums[i] <= 109


 Follow up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.*;

public  class MajorityElementII {
    public static void main(String[] args) {
        // Test case 1 - Two majority elements
        int[] nums1 = {3, 2, 3};
        List<Integer> expected1 = Arrays.asList(3);
        List<Integer> result1 = majorityElement(nums1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2 - No majority elements
        int[] nums2 = {1};
        List<Integer> expected2 = Arrays.asList(1);
        List<Integer> result2 = majorityElement(nums2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);

        // Test case 3 - Two majority elements
        int[] nums3 = {1, 2, 2, 3, 2, 1, 1, 3};
        List<Integer> expected3 = Arrays.asList(1, 2);
        List<Integer> result3 = majorityElement(nums3);
        System.out.println("Test Case 3 - Expected: " + expected3);
        System.out.println("Test Case 3 - Actual: " + result3);
    }

    /**
     * Find all majority elements that appear more than n / 3 times by sorting and checking counts.
     *
     * @param nums The input array of integers.
     * @return A list of all majority elements.
     */

    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Iterate through the array and count the frequency of each element
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Add elements that appear more than n/3 times to the result list
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }

        return result;
    }


    public static List<Integer> majorityElement2(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int count = 1;

        // Traverse through the sorted array and count occurrences
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (count > n / 3) {
                    result.add(nums[i - 1]);
                }
                count = 1; // Reset the count for the next distinct element
            }
        }

        // Check the last element count
        if (count > n / 3) {
            result.add(nums[n - 1]);
        }

        return result;
    }
}
