/*
1304. Find N Unique Integers Sum up to Zero
Easy
Given an integer n, return any array containing n unique integers such that they add up to 0.

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]
 

Constraints:

1 <= n <= 1000
*/


import java.util.Arrays;

class SumZero {
    public static void main(String[] args) {
        int[] result1 = sumZero(5);
        System.out.println(Arrays.toString(result1)); // should print [1, 2, 0, -2, -1]

        int[] result2 = sumZero(4);
        System.out.println(Arrays.toString(result2)); // should print [1, 2, -2, -1]

        int[] result3 = sumZero(1);
        System.out.println(Arrays.toString(result3)); // should print [0]

        int[] result4 = sumZero(10);
        System.out.println(Arrays.toString(result4)); // should print [1, 2, 3, 4, 5, -5, -4, -3, -2, -1]
    }


    // time complexity O(N) and space complexity O(N)
    public static int[] sumZero(int n) {
        int[] result = new int[n];
        int lastIndex = n - 1;

        for (int i = 0; i < n / 2; i++) {
            result[i] = i + 1;
            result[lastIndex] = -(i + 1);
            lastIndex--;
        }

        return result;
    }
}
