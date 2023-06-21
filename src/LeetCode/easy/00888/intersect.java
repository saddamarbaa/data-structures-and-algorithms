/*
888. Fair Candy Swap
Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes
where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of
candies of the jth box of candy that Bob has.

Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the
 same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box
 they have.

Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and
answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return
any one of them. It is guaranteed that at least one answer exists.

Example 1:

Input: aliceSizes = [1,1], bobSizes = [2,2]
Output: [1,2]
Example 2:

Input: aliceSizes = [1,2], bobSizes = [2,3]
Output: [1,2]
Example 3:

Input: aliceSizes = [2], bobSizes = [1,3]
Output: [2,3]


Constraints:

1 <= aliceSizes.length, bobSizes.length <= 104
1 <= aliceSizes[i], bobSizes[j] <= 105
Alice and Bob have a different total number of candies.
There will be at least one valid answer for the given input.
 */


import java.util.*;

public class FairCandySwap {
    public static void main(String[] args) {
        // Test Case 1
        int[] aliceCandies1 = {1, 2};
        int[] bobCandies1 = {2, 3};
        int[] expected1 = {1, 2};
        int[] result1 = fairCandySwap(aliceCandies1, bobCandies1);
        System.out.println("Test Case 1 - aliceCandies: " + Arrays.toString(aliceCandies1));
        System.out.println("Test Case 1 - bobCandies: " + Arrays.toString(bobCandies1));
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.toString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.equals(result1, expected1));

        // Test Case 2
        int[] aliceCandies2 = {1, 1};
        int[] bobCandies2 = {2, 2};
        int[] expected2 = {1, 2};
        int[] result2 = fairCandySwap(aliceCandies2, bobCandies2);
        System.out.println("Test Case 2 - aliceCandies: " + Arrays.toString(aliceCandies2));
        System.out.println("Test Case 2 - bobCandies: " + Arrays.toString(bobCandies2));
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.toString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.equals(result2, expected2));

        // Test Case 3
        int[] aliceCandies3 = {2};
        int[] bobCandies3 = {1, 3};
        int[] expected3 = {2, 3};
        int[] result3 = fairCandySwap(aliceCandies3, bobCandies3);
        System.out.println("Test Case 3 - aliceCandies: " + Arrays.toString(aliceCandies3));
        System.out.println("Test Case 3 - bobCandies: " + Arrays.toString(bobCandies3));
        System.out.println("Test Case 3 - Expected result: " + Arrays.toString(expected3));
        System.out.println("Test Case 3 - Actual result: " + Arrays.toString(result3));
        System.out.println("Test Case 3 - Result matches expected: " + Arrays.equals(result3, expected3));
    }


    /*
       Algorithm Steps:
       1. Sort both nums1 and nums2 arrays.
       2. Create an ArrayList to store the common elements.
       3. Initialize two pointers, pointer1 for nums1 and pointer2 for nums2, both starting at index 0.
       4. Iterate while both pointers are within the bounds of their respective arrays:
           a. Get the current elements num1 = nums1[pointer1] and num2 = nums2[pointer2].
           b. If num1 is equal to num2, add the element to the intersection list, increment both pointers.
           c. If num1 is less than num2, increment pointer1.
           d. If num1 is greater than num2, increment pointer2.
       5. Convert the intersection list to an array.
       6. Return the array.

       Time Complexity: O(n log n + m log m), where n and m are the lengths of nums1 and nums2 respectively
                       (due to sorting the arrays).
       Space Complexity: O(min(n, m)), where n and m are the lengths of nums1 and nums2 respectively
                         (to store the intersection list).
   */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> intersection = new ArrayList<>();

        int pointer1 = 0;  // Pointer for nums1
        int pointer2 = 0;  // Pointer for nums2

        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            int num1 = nums1[pointer1];
            int num2 = nums2[pointer2];

            if (num1 == num2) {
                intersection.add(num1);  // Add common element to the intersection list
                pointer1++;  // Move both pointers forward
                pointer2++;
            } else if (num1 < num2) {
                pointer1++;  // Move pointer for nums1 forward
            } else {
                pointer2++;  // Move pointer for nums2 forward
            }
        }

        // Convert the intersection list to an array
        int[] result = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            result[index] = num;
            index++;
        }

        return result;
    }


    /*
     Algorithm Steps:
     1. Calculate the total number of candies owned by Alice and Bob.
     2. Iterate through each candy in Alice's possession:
         - Assign the current candy to `chosenCandyAlice`.
         - Iterate through each candy in Bob's possession:
             - Assign the current candy to `chosenCandyBob`.
             - Check if swapping `chosenCandyAlice` from Alice with `chosenCandyBob` from Bob results in equal
             distributions of candies.
     3. If a fair swap is found, return the pair of candies.
     4. If no fair swap is found after iterating through all candies, return `[-1, -1]` to indicate that no fair swap
      is possible.

     Time Complexity: O(n^2), where n is the length of aliceCandies or bobCandies. We iterate through each candy in
     both Alice's and Bob's possession.
     Space Complexity: O(1), as we only use a constant amount of extra space to store variables.
 */
    public static int[] fairCandySwap(int[] aliceCandies, int[] bobCandies) {
        int totalAlice = 0, totalBob = 0;

        // Calculate the total number of candies owned by Alice and Bob
        for (int candy : aliceCandies) {
            totalAlice += candy;
        }
        for (int candy : bobCandies) {
            totalBob += candy;
        }

        // Iterate through each candy in Alice's possession
        for (int i = 0; i < aliceCandies.length; i++) {
            int chosenCandyAlice = aliceCandies[i];

            // Iterate through each candy in Bob's possession
            for (int j = 0; j < bobCandies.length; j++) {
                int chosenCandyBob = bobCandies[j];

                // Check if swapping the candies results in equal distributions
                int aliceCandyDiff = totalAlice - chosenCandyAlice + chosenCandyBob;
                int bobCandyDiff = totalBob - chosenCandyBob + chosenCandyAlice;

                if (aliceCandyDiff == bobCandyDiff) {
                    return new int[]{chosenCandyAlice, chosenCandyBob};
                }
            }
        }

        // No fair swap found
        return new int[]{-1, -1};
    }
}