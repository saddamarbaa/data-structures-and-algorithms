/*
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

public class FlippingImage {
    public static void main(String[] args) {
        // Example 1:
        int[][] image1 = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] flippedImage1 = flipAndInvertImage(image1);
        System.out.println("Example 1 output:");
        printImage(flippedImage1);

        // Example 2:
        int[][] image2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int[][] flippedImage2 = flipAndInvertImage(image2);
        System.out.println("Example 2 output:");
        printImage(flippedImage2);
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        // Flip the image horizontally
        int rows = image.length;
        int columns = image[0].length;
        for (int i = 0; i < rows; i++) {
            // Swap the values in the left and right halves of the row (reverse the current row)
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

    public static void printImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
        System.out.println();
    }
}
