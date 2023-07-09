/*
1482. Minimum Number of Days to Make m Bouquets
Medium
You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one
bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible
 to make m bouquets return -1.

Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not
bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
Example 2:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is
impossible to get the needed bouquets and we return -1.
Example 3:

Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation: We need 2 bouquets each should have 3 flowers.
Here is the garden after the 7 and 12 days:
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three
flowers that bloomed because they are not adjacent.
After day 12: [x, x, x, x, x, x, x]
It is obvious that we can make two bouquets in different ways.


Constraints:

bloomDay.length == n
1 <= n <= 105
1 <= bloomDay[i] <= 109
1 <= m <= 106
1 <= k <= n
 */


import java.util.Arrays;

public class MinDays {
    public static void main(String[] args) {
        // Test case 1 - Basic scenario
        int[] bloomDay1 = {1, 10, 3, 10, 2};
        int bouquets1 = 3;
        int flowers1 = 1;
        int expected1 = 3;
        int result1 = minDays(bloomDay1, bouquets1, flowers1);
        System.out.println("Test Case 1 - Bloom Days: " + Arrays.toString(bloomDay1));
        System.out.println("Test Case 1 - Bouquets: " + bouquets1);
        System.out.println("Test Case 1 - Flowers: " + flowers1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2 - Large bloom days with multiple bouquets and flowers
        int[] bloomDay2 = {1, 10, 3, 10, 2};
        int bouquets2 = 4;
        int flowers2 = 2;
        int expected2 = -1;
        int result2 = minDays(bloomDay2, bouquets2, flowers2);
        System.out.println("Test Case 2 - Bloom Days: " + Arrays.toString(bloomDay2));
        System.out.println("Test Case 2 - Bouquets: " + bouquets2);
        System.out.println("Test Case 2 - Flowers: " + flowers2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3 - All flowers bloom on the same day
        int[] bloomDay3 = {5, 5, 5, 5, 5};
        int bouquets3 = 2;
        int flowers3 = 3;
        int expected3 = 5;
        int result3 = minDays(bloomDay3, bouquets3, flowers3);
        System.out.println("Test Case 3 - Bloom Days: " + Arrays.toString(bloomDay3));
        System.out.println("Test Case 3 - Bouquets: " + bouquets3);
        System.out.println("Test Case 3 - Flowers: " + flowers3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));

    }


    /**
     * Algorithm:
     * 1. Calculate the minimum and maximum bloom days from the given array.
     * 2. Set the left pointer as the minimum bloom day and the right pointer as the maximum bloom day.
     * 3. Initialize the result variable as -1 to track the minimum number of days.
     * 4. Perform a binary search on the search space of bloom days.
     * 5. In each iteration, calculate the mid value as the average of the left and right pointers.
     * 6. Check if it is possible to make m bouquets within the given number of days (mid).
     * - To do this, iterate through the bloom days and count the adjacent flowers that bloom within mid days.
     * - If the count reaches the required number of bouquets (m), update the result with the current mid value
     * and move the right pointer to mid - 1 to search for a smaller minimum number of days.
     * - Otherwise, move the left pointer to mid + 1 to search for a larger minimum number of days.
     * 7. Repeat steps 5-6 until the left and right pointers cross each other.
     * 8. Return the result, which represents the minimum number of days required to make m bouquets.
     * <p>
     * Time Complexity: O(log n), where n is the number of bloom days. The binary search reduces the search space in
     * half at each step.
     * Space Complexity: O(1), as the algorithm uses a constant amount of extra space.
     */
    public static int minDays(int[] bloomDay, int bouquets, int flowers) {
        if (bloomDay.length < bouquets * flowers) return -1;

        int[] minMaxElements = getMinMaxElements(bloomDay);

        int minDay = minMaxElements[0];
        int maxDay = minMaxElements[1];

        int left = minDay;
        int right = maxDay;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean isFeasible = canMakeBouquets(bloomDay, bouquets, flowers, mid);

            if (isFeasible == true) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static boolean canMakeBouquets(int[] bloomDay, int bouquets, int flowers, int day) {
        int bouquetCount = 0;
        int adjacentCount = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                adjacentCount++;
                if (adjacentCount == flowers) {
                    bouquetCount++;
                    if (bouquetCount == bouquets) {
                        return true;
                    } else {
                        adjacentCount = 0;
                    }
                }
            } else {
                adjacentCount = 0;
            }
        }
        return false;
    }


    public static int[] getMinMaxElements(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;

        for (int i : arr) {
            maxElement = Math.max(maxElement, i);
            minElement = Math.min(minElement, i);
        }
        return new int[]{minElement, maxElement};
    }
}