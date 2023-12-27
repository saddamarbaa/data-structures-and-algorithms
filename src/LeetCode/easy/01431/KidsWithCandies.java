/*
1431. Kids With the Greatest Number of Candies
Easy
There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.

Example 1:

Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true]
Explanation: If you give all extraCandies to:
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
Example 2:

Input: candies = [4,2,1,1,2], extraCandies = 1
Output: [true,false,false,false,false]
Explanation: There is only 1 extra candy.
Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
Example 3:

Input: candies = [12,1,12], extraCandies = 10
Output: [true,false,true]


Constraints:

n == candies.length
2 <= n <= 100
1 <= candies[i] <= 100
1 <= extraCandies <= 50
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class KidsWithCandies {

    public static void main(String[] args) {
        // Test case 1
        int[] candies1 = {2, 3, 5, 1, 3};
        int extraCandies1 = 3;
        List<Boolean> expected1 = Arrays.asList(true, true, true, false, true);
        printResult(candies1, extraCandies1, kidsWithCandies(candies1, extraCandies1), expected1);

        // Test case 2
        int[] candies2 = {4, 2, 1, 1, 2};
        int extraCandies2 = 1;
        List<Boolean> expected2 = Arrays.asList(true, false, false, false, false);
        printResult(candies2, extraCandies2, kidsWithCandies(candies2, extraCandies2), expected2);

        // Test case 3
        int[] candies3 = {12, 1, 12};
        int extraCandies3 = 10;
        List<Boolean> expected3 = Arrays.asList(true, false, true);
        printResult(candies3, extraCandies3, kidsWithCandies(candies3, extraCandies3), expected3);
    }

    /**
     * Algorithm Steps:
     * 1. Initialize an empty ArrayList called `result` to store the boolean values.
     * 2. Find the maximum number of candies in the given array using a helper function `getMaxCandies`.
     * 3. Iterate through each kid's candies in the array.
     *    a. Calculate the total candies the kid would have after adding `extraCandies`.
     *    b. Compare if the total candies are greater than or equal to the maximum candies.
     *       - If true, add `true` to the `result`; otherwise, add `false`.
     * 4. Return the `result` ArrayList.
     *
     * Helper Function: getMaxCandies
     * - Finds the maximum value in the array by iterating through each element and updating the maximum value.
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = getMaxCandies(candies);

        for (int i = 0; i < candies.length; i++) {
            int totalCandies = candies[i] + extraCandies;
            result.add(totalCandies >= maxCandies);
        }

        return result;
    }

    private static int getMaxCandies(int[] candies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        return max;
    }


    /**
     * Algorithm Steps:
     * 1. Initialize an empty list 'result' to store the boolean results.
     * 2. Iterate through each kid's initial candies.
     * 3. For each kid, calculate the total candies after adding extra candies.
     * 4. Check if the current kid will have the greatest number of candies.
     * 5. Add the boolean result to the 'result' list.
     * 6. Return the 'result' list.
     */
    public static List<Boolean> kidsWithCandies2(int[] initialCandies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < initialCandies.length; i++) {
            int totalCandies = initialCandies[i] + extraCandies;
            boolean hasGreatestCandies = hasGreatestCandies(initialCandies, totalCandies);
            result.add(hasGreatestCandies);
        }
        return result;
    }

    /**
     * Check if the current kid will have the greatest number of candies.
     */
    public static boolean hasGreatestCandies(int[] initialCandies, int totalCandies) {
        for (int otherKidCandies : initialCandies) {
            if (otherKidCandies > totalCandies) {
                return false;
            }
        }
        return true;
    }


    /**
     * Print the result of a test case.
     */
    public static void printResult(int[] nums, int extraCandies, List<Boolean> result, List<Boolean> expected) {
        System.out.println("Input: " + Arrays.toString(nums) + ", Extra Candies: " + extraCandies);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        System.out.println("Result matches expected: " + result.equals(expected));
        System.out.println();
    }
}
