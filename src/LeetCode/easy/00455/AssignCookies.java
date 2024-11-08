import java.util.Arrays;

/**
 * 455. Assign Cookies
 * Easy
 *
 * You are given two integer arrays `g` and `s` representing the greed factor of children and the size of cookies respectively.
 *
 * Your goal is to assign cookies to children such that each child gets exactly one cookie, and the cookie size is greater than or equal
 * to the child's greed factor. Return the maximum number of children that can be content with the cookies.
 *
 * Example 1:
 * Input: g = [1,2,3], s = [1,1]
 * Output: 1
 * Explanation: You have 2 cookies, and you can only content 1 child.
 *
 * Example 2:
 * Input: g = [1,2], s = [1,2,3]
 * Output: 2
 * Explanation: You have 3 cookies, and you can content both children.
 */
public class AssignCookies {
    public static void main(String[] args) {

        // Test case 1 - Only 1 child can be content
        int[] greed1 = {1, 2, 3};
        int[] cookies1 = {1, 1};
        int expected1 = 1;
        int result1 = findContentChildren(greed1, cookies1);
        System.out.println("Test Case 1 - Expected: " + expected1);
        System.out.println("Test Case 1 - Actual: " + result1);

        // Test case 2 - All children can be content
        int[] greed2 = {1, 2};
        int[] cookies2 = {1, 2, 3};
        int expected2 = 2;
        int result2 = findContentChildren(greed2, cookies2);
        System.out.println("Test Case 2 - Expected: " + expected2);
        System.out.println("Test Case 2 - Actual: " + result2);

        // Test case 3 - No child can be content
        int[] greed3 = {2, 3, 4};
        int[] cookies3 = {1};
        int expected3 = 0;
        int result3 = findContentChildren(greed3, cookies3);
        System.out.println("Test Case 3 - Expected: " + expected3);
        System.out.println("Test Case 3 - Actual: " + result3);
    }

    /**
     * Finds the maximum number of children that can be content with the available cookies.
     *
     * @param g The integer array representing the greed factors of the children.
     * @param s The integer array representing the sizes of the cookies.
     * @return The maximum number of children that can be content.
     */
    public static int findContentChildren(int[] g, int[] s) {
        // Sort the greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        int count = 0;

       
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++; 
                i++;      
            }
            j++; 
        }

        return count; 
    }
}
