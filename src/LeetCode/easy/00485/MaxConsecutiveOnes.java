/**
 485. Max Consecutive Ones
 Easy

 Given a binary array nums, return the maximum number of consecutive 1's in the array.

 Example 1:
 Input: nums = [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

 Example 2:
 Input: nums = [1,0,1,1,0,1]
 Output: 2
 */

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        testMaxConsecutiveOnesFunction();
    }

    public static void testMaxConsecutiveOnesFunction() {
        // Test case 1: General case with multiple consecutive ones
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int expected1 = 3;
        int result1 = findMaxConsecutiveOnes(nums1);
        System.out.println("Test Case 1 - Input: [1, 1, 0, 1, 1, 1]");
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2: Single 1 and 0s
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        int expected2 = 2;
        int result2 = findMaxConsecutiveOnes(nums2);
        System.out.println("Test Case 2 - Input: [1, 0, 1, 1, 0, 1]");
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3: All 1s
        int[] nums3 = {1, 1, 1, 1};
        int expected3 = 4;
        int result3 = findMaxConsecutiveOnes(nums3);
        System.out.println("Test Case 3 - Input: [1, 1, 1, 1]");
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

        // Test case 4: No 1s
        int[] nums4 = {0, 0, 0, 0};
        int expected4 = 0;
        int result4 = findMaxConsecutiveOnes(nums4);
        System.out.println("Test Case 4 - Input: [0, 0, 0, 0]");
        System.out.println("Test Case 4 - Expected result: " + expected4);
        System.out.println("Test Case 4 - Actual result: " + result4);
        System.out.println("Test Case 4 - Result matches expected: " + (result4 == expected4));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }
}
