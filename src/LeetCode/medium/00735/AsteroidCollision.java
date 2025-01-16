import java.util.*;

/**
 735. Asteroid Collision

 Medium

 We are given an array asteroids of integers representing asteroids in a row.

 For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

 Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 Example 1:

 Input: asteroids = [5, 10, -5]
 Output: [5, 10]
 Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

 Example 2:

 Input: asteroids = [8, -8]
 Output: []
 Explanation: The 8 and -8 collide exploding both.

 Example 3:

 Input: asteroids = [10, 2, -5]
 Output: [10]
 Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

 Constraints:

 2 <= asteroids.length <= 104
 -1000 <= asteroids[i] <= 1000
 asteroids[i] != 0
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        // Test case 1
        int[] asteroids1 = {5, 10, -5};
        int[] expected1 = {5, 10};
        int[] result1 = asteroidCollision(asteroids1);
        runTestCase(asteroids1, result1, expected1);

        // Test case 2
        int[] asteroids2 = {8, -8};
        int[] expected2 = {};
        int[] result2 = asteroidCollision(asteroids2);
        runTestCase(asteroids2, result2, expected2);

        // Test case 3
        int[] asteroids3 = {10, 2, -5};
        int[] expected3 = {10};
        int[] result3 = asteroidCollision(asteroids3);
        runTestCase(asteroids3, result3, expected3);
    }

    /**
     * Helper function to execute a test case, compare expected vs actual, and print the results.
     *
     * @param asteroids The input array of asteroids.
     * @param result The actual result array returned by the function.
     * @param expected The expected output array.
     */
    private static void runTestCase(int[] asteroids, int[] result, int[] expected) {
        System.out.println("Input: " + Arrays.toString(asteroids));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(result));

        // Check if the result matches the expected output
        if (Arrays.equals(result, expected)) {
            System.out.println("Test Result: PASS");
        } else {
            System.out.println("Test Result: FAIL");
        }
        System.out.println();
    }

    /**
     * Function to simulate asteroid collisions.
     *
     * @param asteroids The input array of asteroids.
     * @return The final state of the asteroids after collisions.
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean alive = true;
            while (alive && !stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();
                if (Math.abs(top) < Math.abs(asteroid)) {
                    stack.pop(); // The stack top explodes
                } else if (Math.abs(top) == Math.abs(asteroid)) {
                    stack.pop(); // Both asteroids explode
                    alive = false; // No asteroid survives
                } else {
                    alive = false; // The current asteroid explodes
                }
            }
            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }


    public int[] asteroidCollision2(int[] arr) {
        Stack<Integer> s = new Stack<>();

        for (int asteroid : arr) {
            if (asteroid > 0 || s.isEmpty()) {
                // Push positive asteroid or if stack is empty
                s.push(asteroid);
            } else {
                // Handle negative asteroid collisions
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(asteroid)) {
                    // Pop smaller positive asteroids
                    s.pop();
                }
                if (!s.isEmpty() && s.peek() == Math.abs(asteroid)) {
                    // Both asteroids explode
                    s.pop();
                } else if (s.isEmpty() || s.peek() < 0) {
                    // Push the negative asteroid if no collisions occur
                    s.push(asteroid);
                }
            }
        }

        // Convert stack to array
        int[] result = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            result[i] = s.pop();
        }

        return result;
    }

}
