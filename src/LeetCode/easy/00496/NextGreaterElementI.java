
/**
 496. Next Greater Element I
 Easy
 
 The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

 You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

 For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

 Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 Example 1:

 Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 Output: [-1,3,-1]
 Explanation: The next greater element for each value of nums1 is as follows:
 - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 Example 2:

 Input: nums1 = [2,4], nums2 = [1,2,3,4]
 Output: [3,-1]
 Explanation: The next greater element for each value of nums1 is as follows:
 - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
 - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.


 Constraints:

 1 <= nums1.length <= nums2.length <= 1000
 0 <= nums1[i], nums2[i] <= 104
 All integers in nums1 and nums2 are unique.
 All the integers of nums1 also appear in nums2.


 Follow up: Could you find an O(nums1.length + nums2.length) solution?
 */

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public static void main(String[] args) {
        NextGreaterElementI solver = new NextGreaterElementI();

        System.out.println("Test Case 1");
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = solver.nextGreaterElement(nums1, nums2);

        // Expected Output: [-1, 3, -1]
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Test Case 2");
        nums1 = new int[]{2, 4};
        nums2 = new int[]{1, 2, 3, 4};
        result = solver.nextGreaterElement(nums1, nums2);

        // Expected Output: [3, -1]
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }



    // Method to find the next greater element
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each number in nums2
        HashMap<Integer, Integer> map = new HashMap<>();
        // Stack to help find the next greater element
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 and populate the map with the next greater elements
        for (int num : nums2) {
            // As long as the current number is greater than the number on the stack, it's the next greater
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            // Push the current number onto the stack
            stack.push(num);
        }

        // If any element in nums2 has no greater element, map will store -1
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Array to store results for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]); // Get the next greater element from the map
        }

        return result;
    }


    // Brute force approach with a nested loop (O(n * m) time complexity)
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];

        // Initialize the map for nums1 and set default value of -1 for all elements
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
            ans[i] = -1;
        }

        // Traverse nums2 to find the next greater element for each element in nums1
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                for (int j = i + 1; j < nums2.length; j++) {
                    if (nums2[j] > nums2[i]) {
                        int index = map.get(nums2[i]);
                        ans[index] = nums2[j];
                        break;
                    }
                }
            }
        }
        return ans;
    }

    // Another brute force approach with more explicit conditions (O(n * m) time complexity)
    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int m = 0;

        for (int i = 0; i < nums1.length; i++) {
            int nextGreater = -1;
            boolean isFound = false;

            // Traverse nums2 to find the corresponding element in nums1 and then check for the next greater
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    isFound = true;  // Mark when the corresponding element in nums2 is found
                }

                // If the element is found and a greater element is encountered
                if (isFound && nums2[j] > nums1[i]) {
                    nextGreater = nums2[j];
                    break;
                }
            }
            ans[m++] = nextGreater;
        }

        return ans;
    }

}
