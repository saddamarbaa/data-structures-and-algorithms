public class BinarySearch2D {

    public static void main(String[] args) {
        // Test Case 1 - Search for an existing element
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int key1 = 7; // Key to be searched
        testSearch(matrix1, key1, new int[]{1, 2}); // Expected index [1, 2]

        // Test Case 2 - Search for a non-existing element
        int key2 = 13; // Key to be searched
        testSearch(matrix1, key2, new int[]{-1, -1}); // Expected index [-1, -1]

        // Test Case 3 - Search for the smallest element
        int key3 = 1; // Key to be searched
        testSearch(matrix1, key3, new int[]{0, 0}); // Expected index [0, 0]

        // Test Case 4 - Search for the largest element
        int key4 = 12; // Key to be searched
        testSearch(matrix1, key4, new int[]{2, 3}); // Expected index [2, 3]

        // Test Case 5 - Search in an empty matrix
        int[][] emptyMatrix = {};
        int key5 = 5; // Key to be searched
        testSearch(emptyMatrix, key5, new int[]{-1, -1}); // Expected index [-1, -1]

        // Test Case 6 - Search in a single element matrix
        int[][] singleElementMatrix = {{42}};
        int key6 = 42; // Key to be searched
        testSearch(singleElementMatrix, key6, new int[]{0, 0}); // Expected index [0, 0]
    }



    /**
     * This function performs a binary search on a 2D matrix where:
     * - Each row is sorted in ascending order.
     * - Each column is sorted in ascending order.
     *
     * The search starts from the top-right corner of the matrix:
     * 1. If the current element is equal to the target, return its coordinates (row, column).
     * 2. If the current element is greater than the target, move left to a smaller element.
     * 3. If the current element is smaller than the target, move down to a larger element.
     *
     * The process continues until the target is found or the search space is exhausted.
     *
     * @param matrix A 2D array of integers (sorted).
     * @param target The integer value to search for.
     * @return An array of two integers representing the row and column indices of the target, or [-1, -1] if not found.
     */
    public static int[] searchIn2DMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1}; // Handle empty matrix
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1; // Start from the top-right corner

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col}; // Found the target
            } else if (matrix[row][col] > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }
        return new int[]{-1, -1}; // Target not found
    }

    public static void testSearch(int[][] matrix, int key, int[] expectedIndex) {
        int[] actualIndex = searchIn2DMatrix(matrix, key);
        if (expectedIndex[0] == actualIndex[0] && expectedIndex[1] == actualIndex[1]) {
            System.out.println("Test for key " + key + ": Passed");
        } else {
            System.out.println("Test for key " + key + ": Failed");
            System.out.println("Expected: [" + expectedIndex[0] + ", " + expectedIndex[1] + "], Actual: [" + actualIndex[0] + ", " + actualIndex[1] + "]");
        }
    }
}
