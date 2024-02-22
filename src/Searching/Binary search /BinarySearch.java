import java.util.Arrays;

public class BinarySearch{

    public static void main(String[] args) {
        // Test Case 1 - Search for first occurrence
        int[] vector1 = {1, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int low1 = 0;
        int high1 = vector1.length - 1;
        int key1 = 2; // Key to be searched
        int expectedIndex1 = binarySearchRecursive(vector1, low1, high1, key1, -1);
        int actualIndex1 = 1;
        testBinarySearch(vector1, expectedIndex1, actualIndex1, key1, 1);

        // Test Case 2 - Search for last occurrence
        int[] vector2 = {1, 2, 2, 2, 2, 2, 3};
        int low2 = 0;
        int high2 = vector2.length - 1;
        int key2 = 2; // Key to be searched
        int expectedIndex2 = binarySearchRecursive(vector2, low2, high2, key2, 1);
        int actualIndex2 = 5;
        testBinarySearch(vector2, expectedIndex2, actualIndex2, key2, 2);

        // Test Case 3 - Search for any occurrence
        int[] vector3 = {1, 2, 3, 4, 5};
        int low3 = 0;
        int high3 = vector3.length - 1;
        int key3 = 3; // Key to be searched
        int expectedIndex3 = binarySearchRecursive(vector3, low3, high3, key3, 0);
        int actualIndex3 = 2;
        testBinarySearch(vector3, expectedIndex3, actualIndex3, key3, 3);

        // Test Case 4 - Search for a non-existing element
        int[] vector4 = {1, 2, 3, 4, 5};
        int low4 = 0;
        int high4 = vector4.length - 1;
        int key4 = 6; // Key to be searched
        int expectedIndex4 = binarySearchRecursive(vector4, low4, high4, key4, -1);
        int actualIndex4 = -1;
        testBinarySearch(vector4, expectedIndex4, actualIndex4, key4, 4);

        // Test Case 5 - Search in an empty array
        int[] vector5 = {};
        int low5 = 0;
        int high5 = vector5.length - 1;
        int key5 = 2; // Key to be searched
        int expectedIndex5 = binarySearchRecursive(vector5, low5, high5, key5, -1);
        int actualIndex5 = -1;
        testBinarySearch(vector5, expectedIndex5, actualIndex5, key5, 5);
    }

    public static int binarySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0);
    }


    /**
     * Recursive implementation of Binary Search algorithm to search for a given key in a sorted array of integers.
     * The function returns the index of the key if present in the array, otherwise, it returns -1.
     * The function takes five parameters:
     * - nums: A sorted array of integers.
     * - target: An integer value to search for in the array.
     * - startIndex: The starting index of the search range.
     * - endIndex: The ending index of the search range.
     * - occurrenceType: An integer value indicating which occurrence of the target to find.
     *   - A value of -1 indicates the first occurrence.
     *   - A value of 0 indicates any occurrence.
     *   - A value of 1 indicates the last occurrence.
     *
     * Algorithm Steps:
     * 1. If startIndex is greater than endIndex, return -1 (base case: element not found).
     * 2. Calculate midIndex as the average of startIndex and endIndex.
     * 3. If the value at midIndex is equal to the target:
     *    a. Set result to midIndex.
     *    b. If occurrenceType is -1, recursively search the first occurrence in the left subarray.
     *    c. If occurrenceType is 1, recursively search the last occurrence in the right subarray.
     *    d. If occurrenceType is 0 and result is not -1, return result immediately.
     * 4. If the value at midIndex is less than the target, recursively search in the right subarray.
     * 5. If the value at midIndex is greater than the target, recursively search in the left subarray.
     * 6. Return the result.
     *
     * Time Complexity:
     *   The algorithm visits each element in the search space at most three times.
     *   Therefore, the time complexity is O(log n), where n is the length of the input array.
     *
     * Space Complexity:
     *   The algorithm uses O(log n) space for the recursive call stack, as the maximum depth of the recursion
     *   is logarithmic with respect to the size of the input array.
     */

    public static int binarySearchRecursive(int[] nums, int startIndex, int endIndex, int target, int... occurrenceType) {
        // Base case: search space is empty (element not found)
        if (startIndex > endIndex) {
            return -1;
        }

        // Set the occurrenceType to the first element if provided; otherwise, use the default value (0)
        int occurrence = (occurrenceType.length > 0) ? occurrenceType[0] : 0;

        // Calculate mid index
        int midIndex = startIndex + (endIndex - startIndex) / 2;

        // Check if target is found
        if (nums[midIndex] == target) {

            if (occurrence == -1) {
                // Find the first occurrence in the left subarray
                int leftResult = binarySearchRecursive(nums, startIndex, midIndex - 1, target, occurrence);
                return (leftResult != -1) ? leftResult : midIndex;
            } else if (occurrence == 1) {
                // Find the last occurrence in the right subarray
                int rightResult = binarySearchRecursive(nums, midIndex + 1, endIndex, target, occurrence);
                return (rightResult != -1) ? rightResult : midIndex;
            }

            // If occurrence is 0 and result is not -1, return immediately
            if (occurrence == 0) {
                return midIndex;
            }
        } else if (nums[midIndex] < target) {
            return binarySearchRecursive(nums, midIndex + 1, endIndex, target, occurrence);
        } else {
            return binarySearchRecursive(nums, startIndex, midIndex - 1, target, occurrence);
        }

        // This line should not be reached, but added to satisfy the compiler
        return -1;
    }



    // Recursive implementation of Binary Search Algorithm
    public static int binarySearchRecursivePure(int[] array, int low, int high, int key) {
        // Base case: key is not found
        if (low > high) {
            return -1;
        }

        // Calculate mid index
        int mid = low + (high - low) / 2;

        // Check if the key is present at mid-index
        if (key == array[mid]) {
            return mid; // Key found
        } else if (key < array[mid]) {
            // If key is smaller than mid, search in the left space
            return binarySearchRecursivePure(array, low, mid - 1, key);
        } else {
            // If key is larger than mid, search in the right space
            return binarySearchRecursive(array, mid + 1, high, key);
        }
    }



    /**
     * Write a function that implements the binary search algorithm to search for a given key in a sorted array of
     * integers. The function should return the index of the key if it is present in the array, otherwise it should
     * return -1.
     * The function should take three arguments:
     * nums: A sorted array of integers.
     * target: An integer value to search for in the array.
     * occurrence: An integer value indicating which occurrence of the target to find. A value of -1 indicates the first
     * occurrence, a value of 0 indicates any occurrence, and a value of 1 indicates the last occurrence.
     * <p>
     * Algorithm Steps:
     * 1. Initialize the result variable to -1.
     * 2. Initialize the startIndex and endIndex variables to the first and last indices of the array, respectively.
     * 3. While the startIndex is less than or equal to the endIndex:
     * a. Calculate the midIndex as the average of the startIndex and endIndex (to avoid integer overflow, use the
     * expression midIndex = startIndex + (endIndex - startIndex) / 2 instead of midIndex = (startIndex + endIndex) /
     * 2).
     * b. If the value at the midIndex is equal to the target:
     * i. Set the result to the midIndex.
     * ii. If occurrence is less than or equal to 0, set the endIndex to midIndex - 1 to find the first occurrence
     * of the target. If occurrence is greater than or equal to 1, set the startIndex to midIndex + 1 to find the
     * last occurrence of the target.
     * iii. If occurrence is equal to 0 and result is not -1, return the result immediately.
     * c. If the value at the midIndex is less than the target, set the startIndex to midIndex + 1.
     * d. If the value at the midIndex is greater than the target, set the endIndex to midIndex - 1.
     * 4. Return the result.
     * <p>
     * Time Complexity:
     * The algorithm visits each element in the search space (i.e., the portion of the array between the startIndex and
     * endIndex indices) at most three times.
     * Therefore, the time complexity is O(log n), where n is the length of the input array.
     * <p>
     * Space Complexity:
     * The algorithm uses a constant amount of additional space.
     * Therefore, the space complexity is O(1).
     */
    public static int binarySearch(int[] nums, int target, int occurrence) {
        int result = -1;
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (nums[midIndex] == target) {
                result = midIndex;
                // Find the first occurrence of the target
                if (occurrence <= 0) {
                    endIndex = midIndex - 1;
                } else {
                    // Find the last occurrence of the target
                    startIndex = midIndex + 1;
                }
                // If not looking for first or last occurrence, return immediately when target found
                if (occurrence == 0 && result != -1) {
                    return result;
                }
            } else if (nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return result;
    }


    /**
     * Write a function that implements the binary search algorithm to search for a given key in a sorted array of
     * integers. The function should return the index of the key if it is present in the array, otherwise it should
     * return -1.
     * The function should take two arguments:
     * nums: A sorted array of integers.
     * key: An integer value to search for in the array.
     * Algorithm Steps:
     * Initialize the low and high variables to the first and last indices of the array respectively.
     * While the low index is less than or equal to the high index:
     * Calculate the mid index as the average of the low and high indices (to avoid integer overflow, use the
     * expression mid = low + (high - low) / 2 instead of mid = (low + high) / 2).
     * If the value at the mid index is equal to the key, return the mid index.
     * If the value at the mid index is greater than the key, update the high index to be the index immediately to
     * the left of the mid index.
     * If the value at the mid index is less than the key, update the low index to be the index immediately to the
     * right of the mid index.
     * If the key is not found in the array, return -1.
     * Time Complexity:
     * The algorithm visits each element in the search space (i.e., the portion of the array between the low and high
     * indices) at most three times.
     * Therefore, the time complexity is O(log n), where n is the length of the input array.
     * Space Complexity:
     * The algorithm uses a constant amount of additional space.
     * Therefore, the space complexity is O(1).
     */
    public static int binarySearchPure(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            // mid = (low + high)/2; //(low + high) may lead to overflow condition

            // to avoid integer overflow is better to use on of this conditions flowing blow
            int mid = low + (high - low) / 2;
            //mid = high - (high - low)/2;


             /*
           Check if the key is present at mid if so then key is found
           just return the index in which the key is been found and
           we are done */
            // base case also
            if (key == nums[mid]) {
                return mid;
            }
            /*
            if reach this line mean is not found  at mid let
          check if the key smaller or bigger than mind
           */
            // if key is smaller than mid then discard all elements
            // in the right search space including the mid element
            else if (key < nums[mid]) {
                // search in left
                high = mid - 1;
            }// if key is bigger than mid then discard all elements
            //  in the left search space including the mid element
            else {
                //search in right
                low = mid + 1;
            }
        }
        return -1;
    }


    private static void testBinarySearch(int[] input, int expectedIndex, int actualIndex, int key, int testCaseNumber) {
        System.out.println("Test Case " + testCaseNumber + " - Input: " + Arrays.toString(input));
        System.out.println("Test Case " + testCaseNumber + " - Key: " + key);
        System.out.println("Test Case " + testCaseNumber + " - Expected index: " + expectedIndex);
        System.out.println("Test Case " + testCaseNumber + " - Actual index: " + actualIndex);
        System.out.println("Test Case " + testCaseNumber + " - Result matches expected: " + (expectedIndex == actualIndex));
        System.out.println();
    }
}
