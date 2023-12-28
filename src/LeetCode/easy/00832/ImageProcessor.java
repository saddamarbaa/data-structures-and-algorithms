/**
 832. Flipping an Image
 Easy

 Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

 To flip an image horizontally means that each row of the image is reversed.

 For example, flipping [1,1,0] horizontally results in [0,1,1].
 To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

 For example, inverting [0,1,1] results in [1,0,0].

 Example 1:

 Input: image = [[1,1,0],[1,0,1],[0,0,0]]
 Output: [[1,0,0],[0,1,0],[1,1,1]]
 Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 Example 2:

 Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

 Constraints:

 n == image.length
 n == image[i].length
 1 <= n <= 20
 images[i][j] is either 0 or 1.
 */

import java.util.Arrays;

public class ImageProcessor {

    // Test cases
    public static void main(String[] args) {

            // Test Case 1
            int[][] image1 = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
            printResult(image1, flipAndInvertImage(image1), new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}});

            // Test Case 2
            int[][] image2 = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
            printResult(image2, flipAndInvertImage(image2),
                    new int[][]{{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}});
    }


    /**
     * Algorithm Steps:
     * 1. Flip the Image Horizontally:
     *    - Iterate over each row of the image.
     *    - For each row, iterate up to half of the columns (columns / 2).
     *    - Swap the elements symmetrically around the center column (columns / 2).
     *    - This effectively flips the row horizontally.
     *
     * 2. Invert the Image:
     *    - Iterate over each row and each column of the image.
     *    - For each element, check if it is equal to 0.
     *    - If it is 0, change it to 1; if it is 1, change it to 0.
     *    - This effectively inverts the entire image.
     *
     * 3. Return the Modified Image:
     *    - Return the modified image after both flipping and inverting operations.
     *
     * Time Complexity:
     *    - The time complexity is O(rows * columns) as both flipping and inverting operations
     *      require iterating over all elements of the matrix.
     *
     * Space Complexity:
     *    - The space complexity is O(1) as no additional space is used except for temporary variables.
     */

    public static int[][] flipAndInvertImage(int[][] image) {

        // Flip the image horizontally
        int rows = image.length;
        int columns = image[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][columns - j - 1];
                image[i][columns - j - 1] = temp;
            }
        }

        // Invert the image
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (image[i][j] == 0) {
                    image[i][j] = 1;
                } else {
                    image[i][j] = 0;
                }
            }
        }

        return image;
    }


    // Helper method to print test results
    private static void printResult(int[][] input, int[][] result, int[][] expected) {
        System.out.println("Input: " + Arrays.deepToString(input));
        System.out.println("Expected result: " + Arrays.deepToString(expected));
        System.out.println("Actual result: " + Arrays.deepToString(result));
        System.out.println("Result matches expected: " + Arrays.deepEquals(result, expected));
        System.out.println();
    }
}
