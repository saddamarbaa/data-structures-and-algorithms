/*
1512. Number of Good Pairs
Easy
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
*/

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        int numGoodPairs = numIdenticalPairs(nums);
        System.out.println("The number of good pairs in the array is: " + numGoodPairs);
    }
    
    public static int numIdenticalPairs(int[] nums) {
        int numPairs = 0;
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            
            numPairs += count;
        }
        
        return numPairs;
    }
}
