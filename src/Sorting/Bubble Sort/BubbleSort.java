public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2};
        int n = array.length;


        /* traverse Array and display all elements before Sort */
        System.out.println("\nElements in array before sorted are :");
        printArray(array);

        /* traverse Array and Sorted in ascending order using Bubble Sort*/
        bubbleSort(array);

        // bubbleSort(array,false);
        optimizedBubbleSort(array,false);

        /* traverse Array and display all elements after Sort */
        System.out.println("Elements in array after sorted are :");
        printArray(array);


        // Call the recursive bubble sort function
        recursiveBubbleSort(array, n - 1, 0);
        System.out.println("Elements in array after sorted are with recursive sort :");
        printArray(array);

    }



    /**
     * Function to print elements of an array Accept one parameter (user should pass
     * the array as a parameter)
     */
    private static void printArray(int[] array) {
        int size = array.length;
        if (size == 0) {
            System.out.println("Array is empty(no elements to print) !");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }


    /**
     * Bubble Sort Algorithm
     * Algorithm Steps:
     * 1. Start with the first element (index 0) and compare it with the next element.
     * 2. If the current element is greater than the next element, swap them.
     * 3. Move to the next pair of elements and repeat step 2.
     * 4. Continue this process for each pair of adjacent elements until the entire array is sorted.
     * Time Complexity:
     * - Worst Case: O(n^2) where n is the number of elements in the array.
     * - Best Case: O(n) when the array is already sorted.
     * - Average Case: O(n^2).
     * Space Complexity:
     * - Bubble Sort is an in-place sorting algorithm, meaning it doesn't require additional space
     *   proportional to the size of the input array.
     * - The space complexity is O(1) as it only uses a constant amount of extra space for temporary variables.
     *
     * @param array     The array to be sorted.
     * @param ascending True for ascending order (default), False for descending order.
     */
    private static void bubbleSort(int[] array, boolean... ascending) {
        boolean isAscending = ascending.length == 0 || ascending[0];

        int size =array.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (isAscending) {
                    // To sort in ascending order, use ">".
                    if (array[j] > array[j + 1]) {
                        swap(array, j, j + 1);
                    }
                } else {
                    // To sort in descending order, use "<".
                    if (array[j] < array[j + 1]) {
                        swap(array, j, j + 1);
                    }
                }
            }

        }
        System.out.println("Array is sorted in " + (isAscending ? "ascending" : "descending"));

    }


    /**
     * Algorithm Steps:
     * 1. Initialize variables: size (length of the array), i, j, and swapped.
     * 2. Iterate over the array using an outer loop from i = 0 to size - 1.
     *    a. Set swapped to false.
     *    b. Iterate over the array using an inner loop from j = 0 to size - i - 1.
     *       i. Compare adjacent elements array[j] and array[j + 1].
     *       ii. If array[j] > array[j + 1], swap them using the swap function and set swapped to true.
     *    c. If swapped is false, break out of the outer loop, as the array is already sorted.
     * 3. Print "Array is sorted in ascending order."
     * 4. End.
     *
     * Time Complexity:
     * - Worst and Average Case Time Complexity: O(n^2) - occurs when sorting in ascending order and the array is in descending order.
     * - Best Case Time Complexity: O(n) - occurs when the array is already sorted.
     *
     * Space Complexity:
     * - Space Complexity: O(1) - constant space is used for variables. In the optimized algorithm, an extra variable 'swapped' is used.
     *
     * @param array     The array to be sorted.
     * @param ascending A variable number of booleans indicating whether to sort in ascending order (default) or descending order.
     */
    static void optimizedBubbleSort(int[] array, boolean... ascending) {
        int size = array.length;

        // Determine sorting order (ascending or descending)
        boolean isAscending = ascending.length == 0 || ascending[0];

        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                // Compare elements based on sorting order
                boolean shouldSwap = isAscending ? (array[j] > array[j + 1]) : (array[j] < array[j + 1]);

                // If elements are in the wrong order, swap them
                if (shouldSwap) {
                    swap(array, j, j + 1);

                    swapped = true;
                }
            }

            // If there is no swapping in the last iteration, the array is already sorted
            if (!swapped) {
                break;
            }
        }   System.out.println("Array is sorted in " + (isAscending ? "ascending" : "descending") + " order");
    }



    private static void recursiveBubbleSort(int[] array, int pass, int index) {
        // Base case: If no more passes are needed, the array is sorted
        if (pass == 0) {
            return;
        }

        // Recursive case: Sorting current pass
        if (index < pass) {
            // Compare and swap if elements are out of order
            if (array[index] > array[index + 1]) {
                swap(array, index, index + 1);
            }
            // Recursively process the next element in the current pass
            recursiveBubbleSort(array, pass, index + 1);
        } else {
            // After completing one pass, start a new pass from the beginning
            recursiveBubbleSort(array, pass - 1, 0);
        }
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
