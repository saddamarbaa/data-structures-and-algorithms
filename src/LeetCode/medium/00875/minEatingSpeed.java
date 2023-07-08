/*
875. Koko Eating Bananas
Medium
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and
will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k
bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more
bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23


Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
 */


import java.util.Arrays;

public class MinEatingSpeed {
    public static void main(String[] args) {
        // Test case 1 - Basic scenario
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        int expected1 = 4;
        int result1 = minEatingSpeed(piles1, h1);
        System.out.println("Test Case 1 - Piles: " + Arrays.toString(piles1));
        System.out.println("Test Case 1 - Maximum hours: " + h1);
        System.out.println("Test Case 1 - Expected result: " + expected1);
        System.out.println("Test Case 1 - Actual result: " + result1);
        System.out.println("Test Case 1 - Result matches expected: " + (result1 == expected1));

        // Test case 2 - Larger pile sizes
        int[] piles2 = {20, 30, 40, 50, 60};
        int h2 = 6;
        int expected2 = 100;
        int result2 = minEatingSpeed(piles2, h2);
        System.out.println("Test Case 2 - Piles: " + Arrays.toString(piles2));
        System.out.println("Test Case 2 - Maximum hours: " + h2);
        System.out.println("Test Case 2 - Expected result: " + expected2);
        System.out.println("Test Case 2 - Actual result: " + result2);
        System.out.println("Test Case 2 - Result matches expected: " + (result2 == expected2));

        // Test case 3 - Single pile with multiple hours
        int[] piles3 = {5};
        int h3 = 3;
        int expected3 = 2;
        int result3 = minEatingSpeed(piles3, h3);
        System.out.println("Test Case 3 - Piles: " + Arrays.toString(piles3));
        System.out.println("Test Case 3 - Maximum hours: " + h3);
        System.out.println("Test Case 3 - Expected result: " + expected3);
        System.out.println("Test Case 3 - Actual result: " + result3);
        System.out.println("Test Case 3 - Result matches expected: " + (result3 == expected3));
    }


    /**
     * Algorithm Steps:
     * 1. Set the minimum speed to 1 and the maximum speed to the maximum element in the piles array.
     * 2. Use binary search to find the minimum speed required.
     * - While the minimum speed is less than the maximum speed:
     * - Calculate the midpoint speed.
     * - Initialize the total hours to 0.
     * - Iterate through each pile of bananas:
     * - Calculate the number of hours required to eat the bananas in the current pile using integer division
     * and rounding up.
     * - Add the calculated hours to the total hours.
     * - Compare the total hours with the given hours:
     * - If the total hours is greater, update the minimum speed to the midpoint + 1.
     * - If the total hours is less than or equal, update the maximum speed to the midpoint.
     * 3. Return the minimum speed.
     * <p>
     * Time Complexity: O(n log m), where n is the number of piles and m is the maximum number of bananas in a pile.
     * - The binary search takes O(log m) iterations.
     * - In each iteration, we iterate through all the piles, taking O(n) time.
     * Space Complexity: O(1).
     */
    public static int minEatingSpeed(int[] piles, int hours) {
        int minSpeed = 1;
        int maxSpeed = getMaxElement(piles);

        while (minSpeed < maxSpeed) {
            int currentSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
            int totalHours = 0;

            for (int bananas : piles) {
                totalHours += (int) Math.ceil((double) bananas / currentSpeed);
            }

            if (totalHours > hours) {
                minSpeed = currentSpeed + 1;
            } else {
                maxSpeed = currentSpeed;
            }
        }

        return minSpeed;
    }

    public static int getMaxElement(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > maxElement) {
                maxElement = num;
            }
        }
        return maxElement;
    }
}