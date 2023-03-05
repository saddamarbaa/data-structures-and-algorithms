/*
1295. Find Numbers with Even Number of Digits
Easy
Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.
Example 2:

Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits.
 

Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 105

*/

class EvenDigitCounter {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (getNumDigits(num) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    
    private int getNumDigits(int num) {
        if (num == 0) {
            return 1;
        }
        int count = 0;
        while (num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {12, 345, 2, 6, 7896};
        System.out.println(solution.findNumbers(nums1)); // expected output: 2

        int[] nums2 = {555, 901, 482, 1771};
        System.out.println(solution.findNumbers(nums2)); // expected output: 1

        int[] nums3 = {};
        System.out.println(solution.findNumbers(nums3)); // expected output: 0
    }
}
