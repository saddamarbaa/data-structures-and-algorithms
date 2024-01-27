public class InsertionSort {
    public static void main(String[] args) {
        int[] array1 = {64, 25, 12, 22, 11};
        int[] array2 = {38, 27, 43, 3, 9, 82, 10};
        int[] array3 = {5, 12, 8, 3, 17, 6, 2, 14, 10, 1};
        int[] array4 = {30, 20, 10, 40, 90, 50, 80, 70, 60, 100};

        System.out.println("Original Array 1:");
        printArray(array1);
        insertionSort(array1);
        System.out.println("Sorted Array 1 (Ascending):");
        printArray(array1);

        System.out.println("\nOriginal Array 2:");
        printArray(array2);
        insertionSort(array2, false);
        System.out.println("Sorted Array 2 (Descending):");
        printArray(array2);

        System.out.println("\nOriginal Array 3:");
        printArray(array3);
        insertionSort(array3);
        System.out.println("Sorted Array 3 (Ascending):");
        printArray(array3);

        System.out.println("\nOriginal Array 4:");
        printArray(array4);
        insertionSort(array4, false);
        System.out.println("Sorted Array 4 (Descending):");
        printArray(array4);
    }


    /**
     * Insertion sort Algorithm:
     * Insertion sort algorithm is very a simple sorting that works
     * similar to the way we play card game. We split the array into 2 parts:
     * a sorted part and an unsorted part. We pick a value from the unsorted part
     * and place it in the right place in the sorted part.
     *
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
     *
     * Algorithm:
     * InsertionSort(array A)
     * 1. For i = 1 to length(A) - 1
     * 2.     key = A[i]
     * 3.     j = i - 1
     * 4.     while j >= 0 and A[j] > key
     * 5.         A[j + 1] = A[j]
     * 6.         j = j - 1
     * 7.     A[j + 1] = key
     *
     * Time Complexity:
     *   - Best Case: O(n^2) - Occurs when the array is already sorted in the desired order.
     *   - Average Case: O(n^2) - Expected time when the elements are randomly ordered.
     *   - Worst Case: O(n^2) - Occurs when the array is sorted in reverse order.
     *
     * Space Complexity:
     *   - O(1) - The algorithm sorts the array in-place, using only a constant amount of extra space.
     *
     * Note: Insertion sort is more efficient on small datasets and nearly sorted arrays.
     */
    public static void insertionSort(int[] array, boolean... ascending) {
        boolean isAscending = ascending.length == 0 || ascending[0];
        int size = array.length;

        for (int i = 1; i <= size - 1; i++) {
            // save value of i in temp and create a hole there
            int temp = array[i];
            int hole = i; // hole is i

            while (hole > 0 && (isAscending ? array[hole - 1] < temp : array[hole - 1] > temp)) {
                // shifting the element
                array[hole] = array[hole - 1];

                // move the hole as well by decrementing the hole by one
                hole = hole - 1;
            }

            // Element has been shifted, now insert the value at its right place (place where we have an empty hole)
            array[hole] = temp;
        }
    }


    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
