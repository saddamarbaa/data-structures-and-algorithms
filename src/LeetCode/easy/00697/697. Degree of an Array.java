/*
697. Degree of an Array
Easy

Companies
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency
of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation:
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.


Constraints:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ShortestSubArray {
    public static void main(String[] args) {
        // Test case 1: array with all elements equal
        int[] array1 = {1, 1, 1, 1, 1, 1};
// Expected output: 6 (the entire array is the shortest subarray with the maximum degree of elements)
        int shortestSubArrayLength1 = findShortestSubArray(array1);
        System.out.println("Shortest subarray length for array 1: " + shortestSubArrayLength1);

// Test case 2: array with all distinct elements
        int[] array2 = {1, 2, 3, 4, 5, 6};
// Expected output: 1 (each element occurs only once, so the shortest subarray with the maximum degree of elements
// has length 1)
        int shortestSubArrayLength2 = findShortestSubArray(array2);
        System.out.println("Shortest subarray length for array 2: " + shortestSubArrayLength2);

// Test case 3: array with no repeated elements
        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
// Expected output: 1 (each element occurs only once, so the shortest subarray with the maximum degree of elements
// has length 1)
        int shortestSubArrayLength3 = findShortestSubArray(array3);
        System.out.println("Shortest subarray length for array 3: " + shortestSubArrayLength3);

// Test case 4: array with all elements except one repeated twice
        int[] array4 = {1, 2, 2, 3, 3, 4, 4, 5, 5};
// Expected output: 2 (the subarray [2,2] and [3,3] each have a degree of 2 and are the shortest subarrays with
// maximum degree)
        int shortestSubArrayLength4 = findShortestSubArray(array4);
        System.out.println("Shortest subarray length for array 4: " + shortestSubArrayLength4);

// Test case 5: array with one element repeated multiple times
        int[] array5 = {1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6};
// Expected output: 6 (the subarray [1,1,1,1,1,1] has a degree of 6 and is the shortest subarray with maximum degree)
        int shortestSubArrayLength5 = findShortestSubArray(array5);
        System.out.println("Shortest subarray length for array 5: " + shortestSubArrayLength5);

// Test case 6: array with no repeated elements and length 1
        int[] array6 = {1};
// Expected output: 1 (the only element has a degree of 1 and is the shortest subarray with maximum degree)
        int shortestSubArrayLength6 = findShortestSubArray(array6);
        System.out.println("Shortest subarray length for array 6: " + shortestSubArrayLength6);

// Test case 7: empty array
        int[] array7 = {};
// Expected output: 0 (the array is empty so there are no subarrays)
        int shortestSubArrayLength7 = findShortestSubArray(array7);
        System.out.println("Shortest subarray length for array 7: " + shortestSubArrayLength7);
    }


    /**
     * Optimal solution
     * This method finds the length of the shortest subarray with the highest frequency of any element in the input
     * array.
     * <p>
     * Algorithm steps:
     * Check if the input array is null or empty, return 0 if true.
     * Use three HashMaps to store the frequency, left index, and right index of each number in the array.
     * Find the frequency, left index, and right index of each number in the array by iterating through it.
     * Keep track of the maximum frequency found in the array.
     * Find the length of the shortest subarray with frequency equal to maxFreq by iterating through the array again,
     * checking for each element if its frequency is equal to maxFreq, and calculating the length of its subarray by
     * subtracting its left index from its right index and adding 1.
     * Return the length of the shortest subarray with frequency equal to maxFreq.
     * <p>
     * Time Complexity: O(n), where n is the length of the input array.
     *
     * @param nums an integer array
     * @return the length of the shortest subarray with the highest frequency of any element in the input array.
     */
    public static int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Use HashMap to store the frequency, left index, and right index of each number
        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> leftIndex = new HashMap<>();
        Map<Integer, Integer> rightIndex = new HashMap<>();

        // Find the frequency, left index, and right index of each number in the array
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Increment the frequency of the current element in the Map
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }

            // Update maxFreq if the current element has a higher frequency
            if (frequency.get(num) > maxFreq) {
                maxFreq = frequency.get(num);
            }

            // Update the left index and right index of the current element in the Map
            if (!leftIndex.containsKey(num)) {
                leftIndex.put(num, i);
            }
            rightIndex.put(num, i);
        }

        int shortestSubArrayLength = Integer.MAX_VALUE;
        // Find the length of the shortest subarray with frequency equal to maxFreq
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (frequency.get(num) == maxFreq) {
                int len = rightIndex.get(num) - leftIndex.get(num) + 1;
                shortestSubArrayLength = Math.min(shortestSubArrayLength, len);
            }
        }

        return shortestSubArrayLength;
    }


    //  un optimal solution
    public int findShortestSubArray2(int[] nums) {
        int maxFrequency = findMaxFrequency(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        // Iterate over all possible subarrays
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Get the subarray from index i to index j
                int[] subarray = Arrays.copyOfRange(nums, i, j + 1);
                int subarrayMaxFrequency = findMaxFrequency(subarray);

                if (subarrayMaxFrequency == maxFrequency) {
                    min = Math.min(min, subarray.length);
//                    // Print the subarray to the console
//                    System.out.println(Arrays.toString(subarray));
                }

            }
        }

        // System.out.println(min);
        return min;
    }

    // un ptimal solution
    public static int findMaxFrequency(int[] arr) {
        // Use a Map to store the frequency of each number in the array
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            // Increment the frequency of the current element in the Map
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }

            // Update maxFreq if the current element has a higher frequency
            if (freq.get(num) > maxFreq) {
                maxFreq = freq.get(num);
            }
        }

        // Return the maximum frequency of any one of its elements
        return maxFreq;
    }
}
