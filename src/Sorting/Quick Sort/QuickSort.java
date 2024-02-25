import java.util.Random;

/**
 Java implementation QuickSort Algorithm

 [AUTHOR] :  Saddam Arbaa
 [Email]  :  <saddamarbaas@gmail.com>


 Reference in future :->

 (1) https://youtu.be/gtWw_8VvHjk
 (2) https://youtu.be/QN9hnmAgmOc
 (3) https://youtu.be/COk73cpQbFQ
 (4) https://youtu.be/3Bbm3Prd5Fo
 (5) https://youtu.be/h_9kAXFKJwY
 (6) https://youtu.be/O5V5JTa3O20
 (7) https://youtu.be/0Ds3KqYeXzA
 (8) https://youtu.be/EdVKzzlInFI */
public class QuickSort {
    public static void main(String[] args) {
        int[] array1 = {64, 25, 12, 22, 11};
        int[] array2 = {38, 27, 43, 3, 9, 82, 10};
        int[] array3 = {5, 12, 8, 3, 17, 6, 2, 14, 10, 1};
        int[] array4 = {30, 20, 10, 40, 90, 50, 80, 70, 60, 100};
        int[] array5 = {48, 75, 32, 19, 60, 91, 26, 15, 70, 43};
        int[] array6 = {10, 5, 2, 8, 7, 1, 3, 6, 4, 9};
        int[] array7 = {55, 18, 36, 81, 92, 10, 29, 45, 63, 77};
        int[] array8 = {12, 40, 7, 23, 51, 68, 35, 59, 44, 16};

        System.out.println("Original Array 1:");
        printArray(array1);
        quickSort(array1, 0, array1.length - 1);
        System.out.println("Sorted Array 1 (Ascending):");
        printArray(array1);

        System.out.println("\nOriginal Array 2:");
        printArray(array2);
        quickSort(array2, 0, array2.length - 1, false);
        System.out.println("Sorted Array 2 (Descending):");
        printArray(array2);

        System.out.println("\nOriginal Array 3:");
        printArray(array3);
        quickSort(array3, 0, array3.length - 1);
        System.out.println("Sorted Array 3 (Ascending):");
        printArray(array3);

        System.out.println("\nOriginal Array 4:");
        printArray(array4);
        quickSort(array4, 0, array4.length - 1, false);
        System.out.println("Sorted Array 4 (Descending):");
        printArray(array4);

        System.out.println("\nOriginal Array 5:");
        printArray(array5);
        quickSort(array5, 0, array5.length - 1);
        System.out.println("Sorted Array 5 (Ascending):");
        printArray(array5);

        System.out.println("\nOriginal Array 6:");
        printArray(array6);
        randomizedQuickSort(array6, 0, array6.length - 1, false);
        System.out.println("Randomized Sorted Array 6 (Descending):");
        printArray(array6);

        System.out.println("\nOriginal Array 7:");
        printArray(array7);
        randomizedQuickSort(array7, 0, array7.length - 1);
        System.out.println("Randomized Sorted Array 7 (Ascending):");
        printArray(array7);

        System.out.println("\nOriginal Array 8:");
        printArray(array8);
        randomizedQuickSort(array8, 0, array8.length - 1, false);
        System.out.println("Randomized Sorted Array 8 (Descending):");
        printArray(array8);
    }

    /**
     * Quick sort Algorithm:
     * QuickSort is a Divide and Conquer algorithm.
     * It picks an element as a pivot and partitions the array around the pivot.
     * The pivot element is placed in its correct position in the sorted array,
     * and the array is divided into two sub-arrays, on the left and right of the pivot.
     * These sub-arrays are then sorted recursively.
     *
     * Algorithm:
     * quickSort(array A, int low, int high)
     * 1. if low < high
     * 2.     pivotIndex = partition(A, low, high)
     * 3.     quickSort(A, low, pivotIndex - 1)
     * 4.     quickSort(A, pivotIndex + 1, high)
     *
     * partition(array A, int low, int high)
     * 1. pivot = A[high]
     * 2. i = low - 1
     * 3. for j = low to high - 1
     * 4.     if A[j] <= pivot
     * 5.         i = i + 1
     * 6.         swap A[i] with A[j]
     * 7. swap A[i + 1] with A[high]
     * 8. return i + 1
     *
     * Time Complexity:
     *   - Best Case: O(n log n) - Best case occurs when the pivot element is always
     *     the middle element or near to the middle element.
     *   - Average Case: O(n log n) - Expected time when the elements are randomly ordered.
     *   - Worst Case: O(n^2) - The worst case occurs when the partition process always
     *     picks either the greatest or the smallest element as pivot
     *     (the worst case can be avoided)..
     *
     * Space Complexity:
     *   - The space complexity of quick sort is O(log n).
     *     also quick sort is in place algorithm space.
     */
    public static void quickSort(int[] array, int low, int high, boolean... ascending) {
        if (low < high) {

            //  Select pivot position and put all the elements smaller
            //  than pivot on left and all the element greater than pivot
            //  on right(array[pivot_index] is now at right place)
            int pivotIndex = partition(array, low, high, ascending);


            // Sort the elements on the left of pivot
            quickSort(array, low, pivotIndex - 1, ascending);

            // Sort the elements on the right of pivot
            quickSort(array, pivotIndex + 1, high, ascending);
        }
    }


    /**
     * Randomized QuickSort algorithm
     *
     * The idea is the same as quicksort. The only difference here is that we call
     * the randomizedPartition function first, and from there, the original
     * partition function will be called.
     *
     * Pseudo code for randomized Quick sort:
     * randomized_quicksort(A[], low, high)
     *   If (low < high) Then
     *     PivotPosition = randomized_Partition(A, low, high);
     *     randomized_quicksort(A, low, PivotPosition - 1);  // Before Pivot
     *     randomized_quicksort(A, PivotPosition + 1, high); // After Pivot
     *   End If
     */

    public static void randomizedQuickSort(int[] array, int low, int high, boolean... ascending) {
        if (low < high) {
            int pivotIndex = randomizedPartition(array, low, high);
            randomizedQuickSort(array, low, pivotIndex - 1, ascending);
            randomizedQuickSort(array, pivotIndex + 1, high, ascending);
        }
    }

    /**

     Function to partition the array on the basis of pivot element
     such that all the element less than  pivot would be on left it
     and all the element bigger than pivot would be on right .and if
     their is any element which is equal to pivot can go to left or right
     of pivot(in my implementation would be on left)

     Pseudo code for partition()
     partition (arr[], low, high)

     int  start, end, pivot;

     // pivot here I select pivot element from start
     pivot = arr[low]

     start = low // set start at low
     end  = high // set end at high

     While(start <  end)

     While(array[start] <= pivot)  start++ // start = start + 1
     End while

     While(array[end] > pivot)  end-- // end = end - 1
     End While

     If(start < end ) swap(&array[start], &array[end])

     End If
     End While

     End partition
     */
    private static int partition(int[] array, int startIndex, int endIndex, boolean... ascending) {
        boolean isAscending = ascending.length == 0 || ascending[0];

        // Select pivot as last element (end index value)
        int pivotElement = array[endIndex];
        int pivotIndex = startIndex; // Pivot index initialized to starting index

        for (int current = startIndex; current <= endIndex - 1; current++) {
            if ((isAscending && array[current] <= pivotElement) || (!isAscending && array[current] >= pivotElement)) {
                // Swap elements and move pivot index
                swap(array, pivotIndex, current);
                pivotIndex++;
            }
        }

        // Swap pivot to its correct position
        swap(array, pivotIndex, endIndex);

        return pivotIndex;
    }

    /**
     * Randomized Partition Function to Generate a Random Pivot in the range
     * between [low, high], and swaps the Random pivot element with the low element.
     * Then, it calls the original partition function.
     *
     * Pseudo code for randomized_Partition():
     * randomized_Partition(A[], low, high)
     *   srand(time(NULL))
     *   random = low + rand() % (high - low)
     *   swap(A[random], A[low])
     *   return partition(A[], low, high)
     * End randomized_Partition
     */

    public static int randomizedPartition(int[] array, int low, int high) {
        // Use current time as seed for the random generator
        Random random = new Random();

        // Generate a random number in between low .. high
        int randomIndex = low + random.nextInt(high - low + 1);

        // Swap A[randomIndex] with A[low]
        swap(array, randomIndex, low);

        // call the original partition function and return the sorted pivot place to randomized_quicksort function
        return partition(array, low, high);
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
