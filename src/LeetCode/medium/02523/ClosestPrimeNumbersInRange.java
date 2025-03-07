/*
2523. Closest Prime Numbers in Range
Medium

Given two integers left and right that represent the range [left, right], find the two closest prime numbers in that range. A prime number is a number greater than 1 with no divisors other than 1 and itself.

Return the two closest prime numbers as a sorted array, [p1, p2]. If there are multiple pairs, return the pair with the smallest p1. If there are no prime numbers in the range, return [-1, -1].

Example 1:

Input: left = 10, right = 19
Output: [11, 13]
Explanation: The prime numbers between 10 and 19 are 11, 13, and 17. The closest pair of primes is [11, 13].

Example 2:

Input: left = 4, right = 6
Output: [-1, -1]
Explanation: There are no prime numbers in the range [4, 6].

Constraints:

- 1 <= left <= right <= 10^6
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPrimeNumbersInRange {
    public static void main(String[] args) {
        int left1 = 10;
        int right1 = 19;
        int[] expected1 = {11, 13};
        int[] result1 = closestPrimes(left1, right1);
        System.out.println("Test Case 1 - Input: " + left1 + ", " + right1);
        System.out.println("Test Case 1 - Expected result: " + Arrays.toString(expected1));
        System.out.println("Test Case 1 - Actual result: " + Arrays.toString(result1));
        System.out.println("Test Case 1 - Result matches expected: " + Arrays.equals(result1, expected1));

        int left2 = 4;
        int right2 = 6;
        int[] expected2 = {-1, -1};
        int[] result2 = closestPrimes(left2, right2);
        System.out.println("Test Case 2 - Input: " + left2 + ", " + right2);
        System.out.println("Test Case 2 - Expected result: " + Arrays.toString(expected2));
        System.out.println("Test Case 2 - Actual result: " + Arrays.toString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + Arrays.equals(result2, expected2));
    }


    // Function to find the closest prime numbers in the range [left, right]
    public static int[] closestPrimes4(int left, int right) {
        // Step 1: Generate all prime numbers in the range [left, right]
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                primes.add(i); // Add prime number to the list
            }
        }

        // Step 2: If there are fewer than 2 primes, return [-1, -1]
        if (primes.size() < 2) {
            return new int[] {-1, -1};
        }

        // Step 3: Find the closest pair of primes
        int closest1 = -1, closest2 = -1, minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                closest1 = primes.get(i - 1);
                closest2 = primes.get(i);
            }
        }

        // Return the closest pair of primes
        return new int[] {closest1, closest2};
    }

    // Helper function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false; // Not prime if divisible by any number other than 1 and itself
            }
        }
        return true; // Prime number
    }

    /**
     * Find the two closest prime numbers in the range [left, right].
     *
     * Time Complexity: O(n log log n) for generating primes, where n = right.
     * Space Complexity: O(n) for the boolean array.
     */
    public static int[] closestPrimes(int left, int right) {
        // Step 1: Generate primes using the Sieve of Eratosthenes.
        boolean[] isPrime = sieveOfEratosthenes(right);

        // Step 2: Collect all prime numbers in the range [left, right].
        List<Integer> primesInRange = new ArrayList<>();
        for (int i = Math.max(left, 2); i <= right; i++) {
            if (isPrime[i]) {
                primesInRange.add(i);
            }
        }

        // Step 3: If no primes are found, return [-1, -1].
        if (primesInRange.size() < 2) {
            return new int[]{-1, -1};
        }

        // Step 4: Find the closest pair of primes.
        int closestP1 = primesInRange.get(0);
        int closestP2 = primesInRange.get(1);
        int minDiff = closestP2 - closestP1;

        for (int i = 1; i < primesInRange.size() - 1; i++) {
            int p1 = primesInRange.get(i);
            int p2 = primesInRange.get(i + 1);
            int diff = p2 - p1;
            if (diff < minDiff) {
                minDiff = diff;
                closestP1 = p1;
                closestP2 = p2;
            }
        }

        // Step 5: Return the closest pair of primes.
        return new int[]{closestP1, closestP2};
    }

    /**
     * Helper function to generate prime numbers up to a given limit using the Sieve of Eratosthenes.
     *
     * Time Complexity: O(n log log n), where n is the limit.
     * Space Complexity: O(n), for the boolean array.
     */
    public static boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }
}
