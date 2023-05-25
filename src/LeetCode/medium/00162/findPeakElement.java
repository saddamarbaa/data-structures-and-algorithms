/*
162. Find Peak Element
Medium

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple
peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater
than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the
peak element is 6.


Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
 */


import java.util.*;

public class PeakElement {
    public static void main(String[] args) {

        // Test Case 3 - Peak at the end
        int[] arr3 = {1, 2, 1, 3, 5, 6, 4};
        int expected3 = 5;
        int result3 = indPeakElement(arr3);
        System.out.println("Test Case 3 - Input: " + Arrays.toString(arr3));
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));
    }


  

   public static int indPeakElement(int[] arr) {
     int start = 0;
     int end = arr.length - 1;

     while (start < end) {
       int mid = start + (end - start) / 2;

       if (arr[mid] > arr[mid + 1]) {
         /*
          * If arr[mid] is greater than arr[mid+1],
          * we are in the descending part of the array.
          * This means that the peak, if it exists, is in the range from start to mid.
          * Therefore, we update the end index to mid.
          */
         end = mid;
       } else {
         /*
          * If arr[mid] is less than or equal to arr[mid+1],
          * we are in the ascending part of the array.
          * Since we know that arr[mid+1] is greater than arr[mid],
          * the peak index, if it exists, must be in the range from mid+1 to end.
          * Therefore, we update the start index to mid+1.
          */
         start = mid + 1;
       }
     }
   }
}