/*
1491. Average Salary Excluding the Minimum and Maximum Salary

Easy

You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.



Example 1:

Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500
Example 2:

Input: salary = [1000,2000,3000]
Output: 2000.00000
Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
Average salary excluding minimum and maximum salary is (2000) / 1 = 2000


Constraints:

3 <= salary.length <= 100
1000 <= salary[i] <= 106
All the integers of salary are unique.
*/

import java.util.*;

public class AverageSalaryExcludingMinMax {
    public static void main(String[] args) {
        // Test cases
        testAverageSalary(new int[]{4000, 3000, 1000, 2000}, 2500.0);
        testAverageSalary(new int[]{1000, 2000, 3000}, 2000.0);
        testAverageSalary(new int[]{5000, 1000, 6000, 3000}, 4000.0);
        testAverageSalary(new int[]{1500, 2500, 3500}, 2500.0);
    }

    public static void testAverageSalary(int[] salary, double expected) {
        double result = average(salary);
        System.out.println("Input: " + Arrays.toString(salary) + ", Expected: " + expected + ", Result: " + result);
        System.out.println("Test passed: " + (Math.abs(result - expected) < 0.00001)); // Handle floating-point precision
        System.out.println();
    }

    /**
     * Algorithm:
     * 1. Initialize min and max to Integer.MAX_VALUE and Integer.MIN_VALUE respectively.
     * 2. Calculate the total sum of salaries while finding the min and max salary.
     * 3. Subtract min and max from the sum and divide the result by (n - 2) to get the average.
     * 
     * Time Complexity: O(n) where n is the length of the salary array.
     * Space Complexity: O(1) - We only use a few variables (sum, min, max).
     */
    public static double average(int[] salary) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
       int n = salary.length;
        // Calculate sum, and find min and max values
        for (int num : salary) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // We are excluding the min and max values, so there must be at least 3 salaries
        if (n >= 3) {
            // Subtract min and max from the total sum
            sum = sum - min - max;

            // Cast to double before division to avoid integer division
            return (double) sum / (n - 2);
        }

        return 0.0; // This is a fallback in case n < 3, although this constraint shouldn't happen
    }
}
