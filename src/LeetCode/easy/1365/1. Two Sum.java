/*
1. Two Sum
Easy

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.


Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/

import java.util.Arrays;
import java.util.HashMap;

class TwoSum {
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1)); // Output: [0, 1]

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2)); // Output: [1, 2]

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(result3)); // Output: [0, 1]

        int[] nums4 = {1, 2, 3, 4, 5};
        int target4 = 10;
        int[] result4 = twoSum(nums4, target4);
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output: " + Arrays.toString(result4)); // Output: [3, 4]

        int[] nums5 = {-1, -2, -3, -4, -5};
        int target5 = -8;
        int[] result5 = twoSum(nums5, target5);
        System.out.println("Input: nums = " + Arrays.toString(nums5) + ", target = " + target5);
        System.out.println("Output: " + Arrays.toString(result5)); // Output: [2, 4]
    }


    // optimal solution time complexity O(n)
    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the indices of the elements
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array and check if the complement is in the map
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                // If the complement is in the map, return the indices
                int complementIndex = map.get(complement);
                return new int[]{complementIndex, i};
            }
            // Otherwise, add the current element to the map
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array
        return new int[0];
    }

    // optimal solution time complexity O(n log n) and space complexity O(n)
    public static int[] twoSum2(int[] nums, int target) {
        // Sort the array in ascending order
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        // Use two pointers to find the pair of elements that add up to the target
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = sortedNums[left] + sortedNums[right];
            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // Find the indices of the two elements in the original array
        int[] result = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sortedNums[left] || nums[i] == sortedNums[right]) {
                result[index++] = i;
            }
            if (index == 2) {
                break;
            }
        }

        return result;
    }


    // un optimal solution with time complexity  O(n^2) and space complexity O(1)
    public static int[] twoSum3(int[] nums, int target) {
        int[] indices = new int[2];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }

        // If no solution is found, return an empty array
        return new int[0];
    }
}
