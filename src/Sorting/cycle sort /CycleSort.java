public class CycleSort {
    public static void main(String[] args) {
        // Example 1: Sorting in ascending order
        int[] array1 = {3, 2, 1, 5, 9, 7, 8, 4, 6};
        System.out.println("Original Array 1:");
       printArray(array1);
        cycleSort(array1, true);
        System.out.println("Sorted Array 1 (Ascending):");
       printArray(array1);

        // Example 2: Sorting in descending order
        int[] array2 = {10, 5, 8, 2, 7, 1, 3, 6, 4, 9};
        System.out.println("\nOriginal Array 2:");
       printArray(array2);
       cycleSort(array2, false);
        System.out.println("Sorted Array 2 (Descending):");
        printArray(array2);
    }

    
    /**
     * Cycle Sort Algorithm
     * Algorithm Steps:
     * 1. Traverse the array from the start.
     * 2. For each element, find its correct position (index) in the sorted array.
     * 3. Swap the current element with the element at its correct position.
     * 4. Continue this process until the entire array is sorted.
     *
     * Time Complexity:
     * - Worst Case Time Complexity: O(n).
     * - Best Case Time Complexity: O(n).
     * - Average Case Time Complexity: O(n).
     *
     * Space Complexity:
     * - Space Complexity: O(1) - constant space is used for variables.
     *
     * @param array The array to be sorted.
     */
    public static void cycleSort(int[] array, boolean... ascending) {
        int size = array.length;
        int currentIndex = 0;
        boolean isAscending = ascending.length == 0 || ascending[0];


        while (currentIndex < size) {
            // Find the correct index for the current element in the sorted array
            int correctIndex = array[currentIndex] - 1;

            // Perform cyclic swapping until the current element is at its correct position
            if (currentIndex !=  correctIndex) {
                swap(array, currentIndex, correctIndex);
            } else {
                currentIndex++;
            }
        }

        if(!isAscending) {
            // Reverse the array for descending order
            for (int i = 0; i < size / 2; i++) {
                swap(array, i, size - 1 - i);
            }
        }
    }




    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Function to swap values of two variables (user should pass the array and
     * indices as parameters)
     */
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}