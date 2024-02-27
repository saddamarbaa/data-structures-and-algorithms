/**
 * Java implementation of Merge Sort Algorithm
 *
 * [AUTHOR] :  Saddam Arbaa
 * [Email]  :  <saddamarbaas@gmail.com>
 *
 * Reference in future :->
 *     (1) https://youtu.be/Pow9VYIWfOg
 *     (2) https://youtu.be/jlHkDBEumP0
 *     (3) https://youtu.be/4OxBvBXon5w
 *     (4) https://youtu.be/6pV2IF0fgKY
 *     (5) https://youtu.be/mB5HXBb_HY8
 *     (6) https://youtu.be/ak-pz7tS5DE
 *     (7) https://youtu.be/TzeBrDU-JaY
 *     (8) https://youtu.be/0nlPxaC2lTw
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] array1 = {64, 25, 12, 22, 11};
        int[] array2 = {38, 27, 43, 3, 9, 82, 10};
        int[] array3 = {5, 12, 8, 3, 17, 6, 2, 14, 10, 1};
        int[] array4 = {30, 20, 10, 40, 90, 50, 80, 70, 60, 100};
        int[] array5 = {48, 75, 32, 19, 60, 91, 26, 15, 70, 43};
        int[] array6 = {10, 5, 2, 8, 7, 1, 3, 6, 4, 9};
        int[] array7 = {55, 18, 36, 81, 92, 10, 29, 45, 63, 77};
        int[] array8 = {12, 40, 7, 23, 51, 68, 35, 59, 44, 16};

        // Array 1
        System.out.println("Original Array 1 (Ascending):");
        printArray(array1);
        mergeSort(array1, 0, array1.length - 1, true);
        System.out.println("Sorted Array 1 (Ascending):");
        printArray(array1);
        System.out.println("Original Array 1 (Descending):");
        printArray(array1);
        mergeSort(array1, 0, array1.length - 1, false);
        System.out.println("Sorted Array 1 (Descending):");
        printArray(array1);

        // Array 2
        System.out.println("\nOriginal Array 2 (Ascending):");
        printArray(array2);
        mergeSort(array2, 0, array2.length - 1, true);
        System.out.println("Sorted Array 2 (Ascending):");
        printArray(array2);
        System.out.println("Original Array 2 (Descending):");
        printArray(array2);
        mergeSort(array2, 0, array2.length - 1, false);
        System.out.println("Sorted Array 2 (Descending):");
        printArray(array2);

        // Array 3
        System.out.println("\nOriginal Array 3 (Ascending):");
        printArray(array3);
        mergeSort(array3, 0, array3.length - 1, true);
        System.out.println("Sorted Array 3 (Ascending):");
        printArray(array3);
        System.out.println("Original Array 3 (Descending):");
        printArray(array3);
        mergeSort(array3, 0, array3.length - 1, false);
        System.out.println("Sorted Array 3 (Descending):");
        printArray(array3);

        // Array 4
        System.out.println("\nOriginal Array 4 (Ascending):");
        printArray(array4);
        mergeSort(array4, 0, array4.length - 1, true);
        System.out.println("Sorted Array 4 (Ascending):");
        printArray(array4);
        System.out.println("Original Array 4 (Descending):");
        printArray(array4);
        mergeSort(array4, 0, array4.length - 1, false);
        System.out.println("Sorted Array 4 (Descending):");
        printArray(array4);

        // Array 5
        System.out.println("\nOriginal Array 5 (Ascending):");
        printArray(array5);
        mergeSort(array5, 0, array5.length - 1, true);
        System.out.println("Sorted Array 5 (Ascending):");
        printArray(array5);
        System.out.println("Original Array 5 (Descending):");
        printArray(array5);
        mergeSort(array5, 0, array5.length - 1, false);
        System.out.println("Sorted Array 5 (Descending):");
        printArray(array5);

        // Array 6
        System.out.println("\nOriginal Array 6 (Ascending):");
        printArray(array6);
        mergeSort(array6, 0, array6.length - 1, true);
        System.out.println("Sorted Array 6 (Ascending):");
        printArray(array6);
        System.out.println("Original Array 6 (Descending):");
        printArray(array6);
        mergeSort(array6, 0, array6.length - 1, false);
        System.out.println("Sorted Array 6 (Descending):");
        printArray(array6);

        // Array 7
        System.out.println("\nOriginal Array 7 (Ascending):");
        printArray(array7);
        mergeSort(array7, 0, array7.length - 1, true);
        System.out.println("Sorted Array 7 (Ascending):");
        printArray(array7);
        System.out.println("Original Array 7 (Descending):");
        printArray(array7);
        mergeSort(array7, 0, array7.length - 1, false);
        System.out.println("Sorted Array 7 (Descending):");
        printArray(array7);

        // Array 8
        System.out.println("\nOriginal Array 8 (Ascending):");
        printArray(array8);
        mergeSort(array8, 0, array8.length - 1, true);
        System.out.println("Sorted Array 8 (Ascending):");
        printArray(array8);
        System.out.println("Original Array 8 (Descending):");
        printArray(array8);
        mergeSort(array8, 0, array8.length - 1, false);
        System.out.println("Sorted Array 8 (Descending):");
        printArray(array8);
    }

    /**
     Merge Sort function
     (A) Merge Sort is a kind of Divide and Conquer approach algorithm
     in Divide and Conquer we divide the problems into smaller
     subproblems and then conquer(or solve) this smaller subproblems
     first,After that,we combine the solution of the smaller subproblems
     to get the solution for the original problem.

     Divide and Conquer is a three-step process:-->

     (1) Divide → The first step is to break the problem
     into smaller subproblems.
     (2) Conquer → This is basically solving of the smaller subproblems
     (3) Combine → In the last step, we combine the solutions
     of the smaller subproblems to get the solution of the bigger problem

     (B) very fast
     (C) Divide and Conquer algorithm
     (D) recursive algorithm

     Pseudo code for Merge Sort

     MERGE-SORT(A[], low, high)
     If (low < high)
     Then
     1. Find the middle point to divide the array into two halves:
     middle = floor((low + high) / 2)
     2. Call MERGE-SORT for first half:
     Call MERGE-SORT(A, low, middle)
     3. Call mergeSort for second half:
     Call MERGE-SORT(A, middle + 1, high)
     4. Merge the two halves sorted in step 2 and 3:
     Call MERGE(A, low, middle, high)
     End If
     End MERGE-SORT
     *
     * Time Complexity:
     *   - Best Case: O(n log n)
     *   - Average Case: O(n log n)
     *   - Worst Case: O(n log n)
     *
     * Space Complexity:
     *   - The space complexity of merge sort is O(n).
     */



    public static void mergeSort(int[] array, int low, int high, boolean... ascending) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            // Sort the left part
            mergeSort(array, low, mid, ascending);

            // Sort the right part
            mergeSort(array, mid + 1, high, ascending);

            // Merge the two sorted parts
            merge(array, low, mid, high, ascending);
        }
    }

    /**
     Merge functions merges the two sorted parts of array[]
     First subarray is array[start to middle]
     Second subarray is array[middle + 1 to end]

     MERGE(A[], start, middle, end)
     1. create temporary array to store the sorted list
     int  t = end - start + 1
     int temp[t]
     2. Maintain current index of sub-arrays and temp array
     and initialize all the counters
     int i, j, k
     i =  start
     j =  middle + 1
     k = 0
     3. Merge process stared from here
     WHILE(i <= middle && j <= end)
     IF(A[i] < A[j])
     temp[k++] = A[i++]
     ELSE
     temp[k++] = A[j++]
     END IF
     END WHILE
     (4) Copy the remaining elements if there are any
     if(i > middle)
     while(j <= end)
     temp[k++] = A[j++]
     END WHILE
     END IF
     if(j > end)
     while(i <= middle)
     temp[k++] = A[i++]
     END WHILE
     END IF
     (5) Copy back the sorted array to the original array A
     for  x = 0 ,x < k , x++
     aA[x + start] = temp[x]
     END FOR LOOP
     End MERGE*/

    public static void merge(int[] array, int start, int middle, int end, boolean... ascending) {
        // Determine the sorting order
        boolean isAscending = ascending.length == 0 || ascending[0];


        int tempSize = end - start + 1;
        int[] temp = new int[tempSize];

        int i = start;
        int j = middle + 1;
        int k = 0;

        // Compare elements from leftArray and rightArray and merge them into result
        while (i <= middle && j <= end) {
            if ((isAscending && array[i] <= array[j]) || (!isAscending && array[i] >= array[j])) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        // Copy remaining elements of leftArray, if any
        while (i <= middle) {
            temp[k++] = array[i++];
        }

        // Copy remaining elements of rightArray, if any
        while (j <= end) {
            temp[k++] = array[j++];
        }


        /** Merge process is done*/

        /* now Copy back the sorted array  from temp to the original array */
        for (int x = 0; x < k; x++) {
            array[x + start] = temp[x];
        }
    }



    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}