import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2140. Solving Questions With Brainpower
 *
 * You are given a 0-indexed 2D integer array questions where questions[i] = [points_i, brainpower_i].
 * The array describes the questions of an exam, where you have to decide the order to solve the questions.
 * You can solve question i if you haven't skipped any of the previous questions.
 * When you solve question i, you will gain points_i points but must skip the next brainpower_i questions.
 * If you skip question i, you can move on to the next question immediately.
 *
 * Return the maximum points you can earn for the exam.
 *
 * Example:
 * Input: questions = [[3,2],[4,3],[4,4],[2,5]]
 * Output: 5
 * Explanation: The optimal order is to solve questions 0 and 3.
 * - Solve question 0: Earn 3 points, skip next 2 questions
 * - Skip questions 1 and 2
 * - Solve question 3: Earn 2 points
 * Total points = 3 + 2 = 5
 *
 * Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
 * Output: 7
 * Explanation: The optimal order is to solve questions 1 and 4.
 * - Skip question 0
 * - Solve question 1: Earn 2 points, skip next 2 questions
 * - Skip questions 2 and 3
 * - Solve question 4: Earn 5 points
 * Total points = 2 + 5 = 7
 *
 * Constraints:
 * 1 <= questions.length <= 10^5
 * questions[i].length == 2
 * 1 <= points_i, brainpower_i <= 10^5
 */
public class SolvingQuestionsWithBrainpower {
    public static void main(String[] args) {
        // Test Cases
        runTestCase(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}, 5);
        runTestCase(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}, 7);
        runTestCase(new int[][]{{5, 1}, {5, 2}, {5, 3}, {5, 4}, {5, 5}}, 15);
        runTestCase(new int[][]{{1, 5}, {2, 4}, {3, 3}, {4, 2}, {5, 1}}, 7);
        runTestCase(new int[][]{{1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}}, 3);
    }

    // Method to run each test case
    public static void runTestCase(int[][] questions, int expected) {
        long startTime1 = System.nanoTime();
        long result1 = mostPointsBasic(questions);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        long startTime2 = System.nanoTime();
        long result2 = mostPointsOptimized(questions);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        System.out.println("Test Case - Input: questions = " + Arrays.deepToString(questions));
        System.out.println("Expected result: " + expected);
        System.out.println("Result (Basic Approach): " + result1 + " (Time: " + duration1 + " ns)");
        System.out.println("Result (Optimized Approach): " + result2 + " (Time: " + duration2 + " ns)");
        System.out.println("All results match expected: " + (result1 == expected && result2 == expected));
        System.out.println();
    }

    /**
     * Approach 1: Basic Recursive Approach with Memoization
     *
     * Algorithm Steps:
     * 1. For each question, decide whether to solve it or skip it.
     * 2. If solved, add the points and skip the next brainpower_i questions.
     * 3. If skipped, move to the next question.
     * 4. Use memoization to store already computed results.
     *
     * Time Complexity: O(n), where n is the number of questions.
     * Space Complexity: O(n), for the memoization array.
     */
    public static long mostPointsBasic(int[][] questions) {
        long[] memo = new long[questions.length];
        Arrays.fill(memo, -1);
        return dfs(questions, 0, memo);

//        return helper(questions, 0, new HashMap<>());

    }

    private static long helper(int[][] questions, int i, Map<Integer, Long> memo) {
        if (i >= questions.length) return 0;  // Base case

        if (memo.containsKey(i)) return memo.get(i);

        // Solve the question
        long solve = questions[i][0] + helper(questions, i + questions[i][1] + 1, memo);

        // Skip the question
        long skip = helper(questions, i + 1, memo);

        long maxPoints = Math.max(solve, skip);
        memo.put(i, maxPoints);

        return maxPoints;
    }

    private static long dfs(int[][] questions, int index, long[] memo) {
        if (index >= questions.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        // Option 1: Skip the current question
        long skip = dfs(questions, index + 1, memo);
        // Option 2: Solve the current question
        long solve = questions[index][0] + dfs(questions, index + questions[index][1] + 1, memo);
        memo[index] = Math.max(skip, solve);
        return memo[index];
    }

    /**
     * Approach 2: Optimized Dynamic Programming Approach
     *
     * Algorithm Steps:
     * 1. Create a DP array where dp[i] represents the maximum points from question i to the end.
     * 2. Iterate from the end to the beginning.
     * 3. For each question, dp[i] = max(skip it (dp[i+1]), solve it (points + dp[i + brainpower + 1]))
     *
     * Time Complexity: O(n), where n is the number of questions.
     * Space Complexity: O(n), for the DP array.
     */
    public static long mostPointsOptimized(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int next = i + questions[i][1] + 1;
            long solve = questions[i][0] + (next < n ? dp[next] : 0);
            long skip = dp[i + 1];
            dp[i] = Math.max(solve, skip);
        }

        return dp[0];
    }
}