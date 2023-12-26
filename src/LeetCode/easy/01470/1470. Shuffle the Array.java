/**
 1470. Shuffle the Array
 Easy

 Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 
 Example 1:

 Input: nums = [2,5,1,3,4,7], n = 3
 Output: [2,3,5,4,1,7]
 Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 Example 2:

 Input: nums = [1,2,3,4,4,3,2,1], n = 4
 Output: [1,4,2,3,3,2,4,1]
 Example 3:

 Input: nums = [1,1,2,2], n = 2
 Output: [1,2,1,2]


 Constraints:

 1 <= n <= 500
 nums.length == 2n
 1 <= nums[i] <= 10^3
 */
import java.util.Arrays;

public class ShuffleArray {

    public static void main(String[] args) {
        // Test Case 1
        int[] input1 = {2, 5, 1, 3, 4, 7};
        int n1 = 3;
        int[] expected1 = {2, 3, 5, 4, 1, 7};
        int[] result1 = shuffle(input1, n1);

        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1) + ", n: " + n1);
        System.out.println("Expected result: " + Arrays.toString(expected1));
        System.out.println("Actual result: " + Arrays.toString(result1));
        System.out.println("Result matches expected: " + Arrays.equals(result1, expected1));
        System.out.println();

        // Test Case 2
        int[] input2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int n2 = 4;
        int[] expected2 = {1, 4, 2, 3, 3, 2, 4, 1};
        int[] result2 = shuffle(input2, n2);

        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2) + ", n: " + n2);
        System.out.println("Expected result: " + Arrays.toString(expected2));
        System.out.println("Actual result: " + Arrays.toString(result2));
        System.out.println("Result matches expected: " + Arrays.equals(result2, expected2));
        System.out.println();

        // Test Case 3
        int[] input3 = {1, 1, 2, 2};
        int n3 = 2;
        int[] expected3 = {1, 2, 1, 2};
        int[] result3 = shuffle(input3, n3);

        System.out.println("Test Case 3 - Input: " + Arrays.toString(input3) + ", n: " + n3);
        System.out.println("Expected result: " + Arrays.toString(expected3));
        System.out.println("Actual result: " + Arrays.toString(result3));
        System.out.println("Result matches expected: " + Arrays.equals(result3, expected3));
    }

    /**
     * Algorithm Steps:
     * 1. Create an array shuffledNums to store the shuffled result with the same length as the input array nums.
     * 2. Initialize two indices, evenIndex and oddIndex, to 1 and 0, respectively.
     * 3. Iterate over the first n elements of the input array nums:
     * - Set shuffledNums[oddIndex] to nums[i].
     * - Set shuffledNums[evenIndex] to nums[n + i].
     * - Increment both evenIndex and oddIndex by 2.
     * 4. Return the shuffled array shuffledNums.
     * <p>
     * Time Complexity: O(n) - The algorithm iterates over the input array once.
     * Space Complexity: O(n) - Additional space is used to store the shuffled array.
     */
    public static int[] shuffle2(int[] nums, int n) {
        int[] shuffledNums = new int[nums.length];
        int evenIndex = 1;
        int oddIndex = 0;

        for (int i = 0; i < n; i++) {
            shuffledNums[oddIndex] = nums[i];
            shuffledNums[evenIndex] = nums[n + i];
            evenIndex += 2;
            oddIndex += 2;
        }

        return shuffledNums;
    }

    /**
     * Algorithm Steps:
     * 1. Create an array shuffledNums to store the shuffled result with the length of 2n.
     * 2. Initialize two pointers, pointer1 starting at 0 and pointer2 starting at n.
     * 3. Iterate over the input array nums with a step size of 2:
     * - Set shuffledNums[k] to nums[pointer1] (element at the first pointer).
     * - Set shuffledNums[k+1] to nums[pointer2] (element at the second pointer).
     * - Increment both pointers (pointer1 and pointer2).
     * 4. Return the shuffled array shuffledNums.
     * <p>
     * Time Complexity: O(n) - The algorithm iterates over the input array once.
     * Space Complexity: O(n) - Additional space is used to store the shuffled array.
     */
    public static int[] shuffle(int[] nums, int n) {
        int[] shuffledNums = new int[2 * n];
        int pointer1 = 0;
        int pointer2 = n;

        for (int k = 0; k < shuffledNums.length; k += 2) {
            shuffledNums[k] = nums[pointer1];
            shuffledNums[k + 1] = nums[pointer2];
            pointer1++;
            pointer2++;
        }

        return shuffledNums;
    }
}
