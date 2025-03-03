/*
2161. Partition Array According to Given Pivot
Medium

You are given a 0-indexed integer array nums and an integer pivot.
Rearrange nums such that the following conditions are satisfied:

1. Every element less than pivot appears before every element greater than pivot.
2. Every element equal to pivot appears in between the elements less than and greater than pivot.
3. The relative order of the elements less than pivot and the elements greater than pivot is maintained.

Return the rearranged array.

Example 1:

Input: nums = [9,12,5,10,14,3,10], pivot = 10
Output: [9,5,3,10,10,12,14]
Explanation:
- Elements less than 10: [9,5,3]
- Elements equal to 10: [10,10]
- Elements greater than 10: [12,14]
The relative order of the elements less than 10 and greater than 10 is maintained.

Example 2:

Input: nums = [-3,4,3,2], pivot = 2
Output: [-3,2,4,3]
Explanation:
- Elements less than 2: [-3]
- Elements equal to 2: [2]
- Elements greater than 2: [4,3]
The relative order of the elements less than 2 and greater than 2 is maintained.

Constraints:

1 <= nums.length <= 10^5
-10^6 <= nums[i] <= 10^6
pivot is an element in nums.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        int[] input1 = {9, 12, 5, 10, 14, 3, 10};
        int pivot1 = 10;
        int[] expected1 = {9, 5, 3, 10, 10, 12, 14};
        int[] result1 = pivotArray(input1, pivot1);
        System.out.println("Test Case 1 - Input: " + Arrays.toString(input1));
        System.out.println("Test Case 1 - Pivot: " + pivot1);
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.toString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.equals(result1, expected1));

        int[] input2 = {-3, 4, 3, 2};
        int pivot2 = 2;
        int[] expected2 = {-3, 2, 4, 3};
        int[] result2 = pivotArray(input2, pivot2);
        System.out.println("Test Case 2 - Input: " + Arrays.toString(input2));
        System.out.println("Test Case 2 - Pivot: " + pivot2);
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.toString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.equals(result2, expected2));
    }

    /**
     * Solution 1: Using Three Lists
     *
     * Algorithm Steps:
     * 1. Create three lists: one for elements less than pivot, one for elements equal to pivot,
     *    and one for elements greater than pivot.
     * 2. Iterate through the input array and populate the three lists based on the pivot.
     * 3. Combine the three lists in the required order.
     *
     * Time Complexity: O(n), where n is the size of the input array.
     * Space Complexity: O(n), as we are using three additional lists to store the elements.
     */
    public static int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        int[] result = new int[nums.length];
        int index = 0;

        for (int num : less) {
            result[index++] = num;
        }
        for (int num : equal) {
            result[index++] = num;
        }
        for (int num : greater) {
            result[index++] = num;
        }

        return result;
    }

    /**
     * Solution 2: In-Place Partitioning (Using Two Pointers)
     *
     * Algorithm Steps:
     * 1. Create a new array of the same size as the input array.
     * 2. Use two pointers: one for the start (less than pivot) and one for the end (greater than pivot).
     * 3. Iterate through the input array and place elements less than pivot at the start,
     *    elements equal to pivot in the middle, and elements greater than pivot at the end.
     *
     * Time Complexity: O(n), where n is the size of the input array.
     * Space Complexity: O(n), as we are using an additional array to store the result.
     */
    public static int[] pivotArray2(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        // First pass: Place elements less than pivot at the start
        for (int num : nums) {
            if (num < pivot) {
                result[left++] = num;
            }
        }

        // Second pass: Place elements equal to pivot in the middle
        for (int num : nums) {
            if (num == pivot) {
                result[left++] = num;
            }
        }

        // Third pass: Place elements greater than pivot at the end
        for (int num : nums) {
            if (num > pivot) {
                result[left++] = num;
            }
        }

        return result;
    }

    /**
     * Solution 3: Using Streams (Functional Programming Approach)
     *
     * Algorithm Steps:
     * 1. Use Java Streams to filter elements less than, equal to, and greater than the pivot.
     * 2. Concatenate the three streams in the required order.
     * 3. Convert the stream back to an array.
     *
     * Time Complexity: O(n), where n is the size of the input array.
     * Space Complexity: O(n), as we are using additional space for the streams.
     */
    public static int[] pivotArray3(int[] nums, int pivot) {
        List<Integer> less = Arrays.stream(nums).filter(num -> num < pivot).boxed().collect(Collectors.toList());
        List<Integer> equal = Arrays.stream(nums).filter(num -> num == pivot).boxed().collect(Collectors.toList());
        List<Integer> greater = Arrays.stream(nums).filter(num -> num > pivot).boxed().collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        result.addAll(less);
        result.addAll(equal);
        result.addAll(greater);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] pivotArray4(int[] nums, int pivot) {

        int [] res = new int [nums.length];
        int s = 0;
        int count = 0;
        for(int num : nums){
            if(num == pivot){
                count++;
            }else if(num < pivot){
                s++;
            }
        }
        int smallIndex = 0;
        int bigIndex = s + count;
        int pivotIndex = s;
        for(int index = 0; index < nums.length; index++){
            if(nums[index]< pivot){
                res[smallIndex++] = nums[index];
            }else if(nums[index] > pivot){
                res[bigIndex++] = nums[index];
            }else{
                res[pivotIndex++] = nums[index];
            }
        }

        return res;
    }


    public int[] pivotArray5(int[] nums, int pivot) {
        List<Integer> list1= new ArrayList();
        List<Integer> list2 = new ArrayList();

        int count = 0;

        for(int num : nums){
            if(num < pivot){
                list1.add(num);
            }
            if(num > pivot){
                list2.add(num);
            }
            if(num == pivot){
                count++;
            }

        }

        int[] result = new int[list1.size() + list2.size() + count];
        int index = 0;
        while(index < list1.size()){
            result[index]= list1.get(index);
            index++;
        }

        while(index < list1.size() + count){
            result[index]= pivot;
            index++;
        }
        int j = 0;
        while(index < result.length){
            result[index]= list2.get(j);
            index++;
            j++;
        }


        return result;
    }
}