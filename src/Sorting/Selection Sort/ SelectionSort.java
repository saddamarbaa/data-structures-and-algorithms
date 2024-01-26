public class SelectionSort {
    public static void main(String[] args) {
        int[] array1 = {64, 25, 12, 22, 11};
        int[] array2 = {38, 27, 43, 3, 9, 82, 10};
        int[] array3 = {5, 12, 8, 3, 17, 6, 2, 14, 10, 1};
        int[] array4 = {30, 20, 10, 40, 90, 50, 80, 70, 60, 100};

        System.out.println("Original Array 1:");
        printArray(array1);
        selectionSort(array1);
        System.out.println("Sorted Array 1 (Ascending):");
        printArray(array1);

        System.out.println("\nOriginal Array 2:");
        printArray(array2);
        selectionSort(array2, false);
        System.out.println("Sorted Array 2 (Descending):");
        printArray(array2);

        System.out.println("\nOriginal Array 3:");
        printArray(array3);
        selectionSort(array3);
        System.out.println("Sorted Array 3 (Ascending):");
        printArray(array3);

        System.out.println("\nOriginal Array 4:");
        printArray(array4);
        selectionSort(array4, false);
        System.out.println("Sorted Array 4 (Descending):");
        printArray(array4);
    }

    /**
     * selection sort algorithm
     *     Selection sort is very simple an algorithm that selects
     *     the smallest element from an unsorted list in each iteration
     *     and places that element at the beginning of the sorted list.
     *     (the idea of the algorithm is to find the smallest unsorted
     *      element and add it to the sorted list)
     * <p>
     * How Insertion Sort Works?
     * (1) We assume the first element in the array is sorted.
     * (2) Start iterating over the array to be sorted from the second element
     * until the end of the array.
     * (3) Take the second element and store it separately in a temp variable.
     * (3) Compare temp with the first element. If the first element is greater than temp,
     * then temp is placed in front of the first element.
     * (4) Now, the first two elements are sorted.
     * (5) Take the third element and compare it with the elements on the left of it.
     * Place it just behind the element smaller than it.
     * If there is no element smaller than it,
     * then place it at the beginning of the array.
     * (6) Repeat step number 5 until the entire array is sorted.
     * <p>
     * Algorithm:
     * InsertionSort(array A)
     * 1. For i = 1 to length(A) - 1
     * 2.     key = A[i]
     * 3.     j = i - 1
     * 4.     while j >= 0 and A[j] > key
     * 5.         A[j + 1] = A[j]
     * 6.         j = j - 1
     * 7.     A[j + 1] = key
     * <p>
     * Time Complexity:
     *   - Best Case: O(n^2) - Occurs when the array is already sorted in the desired order.
     *   - Average Case: O(n^2) - Expected time when the elements are randomly ordered.
     *   - Worst Case: O(n^2) - Occurs when the array is sorted in reverse order.
     *
     * Space Complexity:
     *   - O(1) - The algorithm sorts the array in-place, using only a constant amount of extra space.
     *
     * Note: Selection sort is not suitable for large datasets due to its quadratic time complexity.
     */



    /**
     * Selection Sort Algorithm:
     *     Selection sort is very simple an algorithm that selects
     *     the smallest element from an unsorted list in each iteration
     *     and places that element at the beginning of the sorted list.
     *     (the idea of the algorithm is to find the smallest unsorted
     *      element and add it to the sorted list)
     *  * Algorithm:
     * 1. Iterate through the entire array.
     * 2. For each iteration, find the minimum element in the unsorted part of the array.
     * 3. After each iteration swap the smallest value found with the first element of the unsorted part.
     * 4. Move the boundary between the sorted and unsorted parts to the right.
     * 5. Repeat steps 2-4 until the entire array is sorted.
     *
     *   algorithm
     *     selection-SO0T(A)
     *       for i in 0 to A.length - 2
     *        imin <---- i
     *        for j in i + 1 to A.length -1
     *
     *            if (a[j] > min)
     *            imin <---- j
     *
     *           after inner loop swap
     *           temp <---- a[i]
     *           a[i] <---- a[imin]
     *           a[imin] <---- temp
     *
     * Time Complexity:
     *   -  Best Case: O(n^2) - quadratic - Occurs when the array is already sorted in the desired order.
     *   - Average Case: O(n^2) - quadratic - Expected time when the elements are randomly ordered.
     *   - Worst Case: O(n^2) - quadratic - Occurs when the array is sorted in reverse order.
     *
     * Space Complexity:
     *   - O(1) - constant (in-place sorting algorithm, uses only a constant amount of extra space)
     *
     *   Note: Selection sort is not suitable for large datasets due to its quadratic time complexity.
     */

    private static void selectionSort(int[] array, boolean... ascending) {
        boolean isAscending = ascending.length == 0 || ascending[0];
        int n =array.length;

        for (int i = 0; i < n - 1; i++) {

            // Find the minimum element in the unsorted part of the array
            int comparisonIndex = i;
            for (int j = i + 1; j < n; j++) {
                boolean shouldSwap = isAscending ? array[j] < array[comparisonIndex] : array[j] > array[comparisonIndex];
                if (shouldSwap) {
                    comparisonIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            if(i != comparisonIndex) {
                swap(array, i, comparisonIndex);
            }
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

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
