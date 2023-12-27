/**
 1389. Create Target Array in the Given Order
 Easy
 Given two arrays of integers nums and index. Your task is to create target array under the following rules:

 Initially target array is empty.
 From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 Repeat the previous step until there are no elements to read in nums and index.
 Return the target array.

 It is guaranteed that the insertion operations will be valid.
 
 Example 1:

 Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 Output: [0,4,1,3,2]
 Explanation:
 nums       index     target
 0            0        [0]
 1            1        [0,1]
 2            2        [0,1,2]
 3            2        [0,1,3,2]
 4            1        [0,4,1,3,2]
 Example 2:

 Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
 Output: [0,1,2,3,4]
 Explanation:
 nums       index     target
 1            0        [1]
 2            1        [1,2]
 3            2        [1,2,3]
 4            3        [1,2,3,4]
 0            0        [0,1,2,3,4]
 Example 3:

 Input: nums = [1], index = [0]
 Output: [1]


 Constraints:

 1 <= nums.length, index.length <= 100
 nums.length == index.length
 0 <= nums[i] <= 100
 0 <= index[i] <= i

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOperations {

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {0, 1, 2, 3, 4};
        int[] index1 = {0, 1, 2, 2, 1};
        int[] result1 =createTargetArray(nums1, index1);
        printResult(nums1, index1, result1);

        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 0};
        int[] index2 = {0, 1, 2, 3, 0};
        int[] result2 = createTargetArray(nums2, index2);
        printResult(nums2, index2, result2);

        // Test case 3
        int[] nums3 = {1};
        int[] index3 = {0};
        int[] result3 = createTargetArray(nums3, index3);
        printResult(nums3, index3, result3);
    }


    /**
     * Algorithm Steps:
     * 1. Initialize an ArrayList named target to represent the target array.
     * 2. Iterate over each element in nums and index arrays.
     *    - Insert the nums[i] value at the specified index index[i] in the target ArrayList.
     * 3. Convert the ArrayList target to an array named result.
     * 4. Return the result array.
     *
     * Time Complexity: O(n^2) - The ArrayList insertion operation takes O(n) time, and there are n elements.
     * Space Complexity: O(n) - Additional space is used to store the target ArrayList and the result array.
     */
    public static int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> target = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Insert the nums[i] value at the specified index
            target.add(index[i], nums[i]);
        }

        // Convert the List to an array
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = target.get(i);
        }

        return result;
    }


    /**
     * Algorithm Steps:
     * 1. Initialize an array target of the same length as nums to store the result.
     * 2. Iterate over each element in nums and its corresponding index in index.
     *    - For each element in nums and its corresponding index in index:
     *      - Shift elements to the right to make space for the new element at the specified index.
     *      - Insert the current element from nums at the specified index in the target array.
     * 3. Return the final target array.
     *
     * Time Complexity: O(n^2) - For each element, we may need to shift elements to the right.
     * Space Complexity: O(n) - We use an additional array target to store the result.
     */
    public static int[] createTargetArray2(int[] nums, int[] index) {
        int n = nums.length;
        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            int indexValue = index[i];
            int numValue = nums[i];

            // Shift elements to the right to make space for the new element at the specified index.
            for (int k = n - 1; k > indexValue; k--) {
                target[k] = target[k - 1];
            }

            // Insert the current element from nums at the specified index in the target array.
            target[indexValue] = numValue;
        }

        return target;
    }

    /**
     * Print the result of a test case.
     */
    public static void printResult(int[] nums, int[] index, int[] result) {
        System.out.println("Input nums: " + Arrays.toString(nums));
        System.out.println("Input index: " + Arrays.toString(index));
        System.out.println("Output: " + Arrays.toString(result));
        System.out.println();
    }
}
