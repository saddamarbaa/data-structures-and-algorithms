/**
 2239. Find Closest Number to Zero
Easy

Example 1:

Input: nums = [-4,-2,1,4,8]
Output: 1
Explanation:
The distance from -4 to 0 is |-4| = 4.
The distance from -2 to 0 is |-2| = 2.
The distance from 1 to 0 is |1| = 1.
The distance from 4 to 0 is |4| = 4.
The distance from 8 to 0 is |8| = 8.
Thus, the closest number to 0 in the array is 1.
Example 2:

Input: nums = [2,-1,1]
Output: 1
Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.
 

Constraints:

1 <= n <= 1000
-105 <= nums[i] <= 105
 */


public class FindclosestNumber {


    public  static boolean isContain(int [] nums, int toFind){
        boolean found = false;
        for (int n : nums) {
            if (n == toFind) {
                found = true;
                break;
            }
        }

        return found;

    }

    public  static int findClosestNumber(int[] nums) {

        int closest = nums[0];
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(closest)) {
                closest = num;
            }
        }

        if (closest < 0 && isContain(nums, Math.abs(closest))) {
            return Math.abs(closest);
        } else {
            return closest;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = { -4, -2, 1, 4, 8 };
       System.out.println(findClosestNumber(nums));
       
    }
}