/*
1929. Concatenation of Array
Easy

Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

 
Example 1:

Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]
Example 2:

Input: nums = [1,3,2,1]
Output: [1,3,2,1,1,3,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
- ans = [1,3,2,1,1,3,2,1]
 

Constraints:

n == nums.length
1 <= n <= 1000
1 <= nums[i] <= 1000

*/


public class ConcatenateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] concatenatedArray = getConcatenation(nums);
        
        // Print the concatenated array
        for (int num : concatenatedArray) {
            System.out.print(num + " ");
        }
        // Output: 1 2 3 1 2 3
    }
    
    public static int[] getConcatenation(int[] nums) {
        int originalLength = nums.length;
        int[] concatenatedArray = new int[2 * originalLength];
        
        // Iterate through the first half of the concatenated array
        for (int i = 0; i < originalLength; i++) {
            int currentNum = nums[i];
            // Set the corresponding values in the second half of the concatenated array
            concatenatedArray[i] = currentNum;
            concatenatedArray[i + originalLength] = currentNum;
        }
        
        return concatenatedArray;
    }
}
