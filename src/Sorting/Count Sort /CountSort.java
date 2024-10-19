import java.util.ArrayList;
import java.util.Arrays;

/**
 [PROGRAM] :  Count Sort Algorithm
 [AUTHOR]  :  Saddam Arbaa
 [Email]   :  <saddamarbaas@gmail.com>

 C Program to Implement Count Sort  Algorithm
 (sort an array of N numbers in ascending order)

 Count/Counting Sort –
 Counting sort is a sorting algorithm that sorts the elements of an array
 by counting the number of occurrences of each unique element in the array.

 The count is stored in an auxiliary array and the sorting is done by mapping
 the count as an index of the auxiliary array.
 This mapping is done by performing arithmetic calculations on those counts to determine
 the positions of each key value(unique element) in the output sequence.
 Time Complexity: O( n + k) where n is the number of elements in input array and k is the range of input.
 Auxiliary Space: O(n + k)
 count sort  it is not a comparison  base sorting algorithm.

 Reference in future :->
 (1) https://youtu.be/Rl2Ok_H-Qms
 (2) https://youtu.be/pEJiGC-ObQE
 (3) https://youtu.be/lZ1HAbRgbz4
 */


public class CountSort {

    /**
     Couting Sort function
     How Counting Sort Works?

     Counting Sort Works according to flowing steps :-->

     Step 1 – Take input array & range(no of unique integer values involved)
     and if range is not give search for biggest number in the array
     and that is erange
     Step 2 – Create the output array of size same as input array.
     Create count array with size equal to the range & initialize values to 0.
     Step 3 – Count each element in the input array and place the count at
     the appropriate index of the count array
     Step 4 – Modify the count array by adding the previous counts(cumulative).
     The modified count array indicates the position of each element in the output array.
     Step 5 – Output each element from the input array into the sorted output array followed
     by decreasing its count by 1.
     Step 6 –  copy the sorted element from output array back to input array
     Step 7 - we are done

     Pseudo code for  Couting Sort Algorithm

     COUNT _SORT(input_array[], size, range)
     1.   take input_array[size]
     2.   create output_array[size]
     3.   take range (or no of unique elements)
     4.   create count_array[range] & initialize all values to 0
     for(int i = 0 to i<range)
     count_array[i] = 0
     5.  Count each element & place it in the count_array
     for(int i = 0 to i<size)
     ++count_array[input_array[i]]
     6.  Modify count_array[] to store previous counts (cumulative)
     for(int i = 1 to i < range)
     count_array[i]= count_array[i]+ count_array[i-1]
     7.  Place elements from input_array[] to output_array[] using this
     count_array[] that has the actual positions of elements
     for(int i= size - 1 to i>= 0)
     output_array[–count_array[input_array[i]]] = input_array[i]
     8. copy sorted element from output_array[] to input_array[]
     for(i=0 to i<size)
     input_array[i]=output_array[i]
     End COUNT _SORT
     */

    // Overloaded function to perform Counting Sort with ascending/descending option
    public static void countSort(int[] inputArray, boolean ascending) {
        int size = inputArray.length;
        int max = findMax(inputArray);

        // Step 2: Create output array of the same size as input array
        int[] outputArray = new int[size];

        // Step 3: Create count array with size equal to the range (max+1), and initialize to 0
        int[] countArray = new int[max + 1];


        // Step 4: Count occurrences of each element in input array
        for (int i = 0; i < size; i++) {
            countArray[inputArray[i]]++;
        }


        // Step 5: Modify count array to store cumulative counts
        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];  // Add previous counts
        }


        // Step 6: Build the output array by placing elements in correct positions
        for (int i = size - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;  // Decrement count
        }


        // Step 7: Copy sorted elements from output array to input array
        for (int i = 0; i < size; i++) {
            inputArray[i] = outputArray[i];
        }

    }





    // Helper function to find the maximum value in the input array
    private static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array1 = {64, 25, 12, 22, 11};
        int[] array2 = {38, 27, 43, 3, 9, 82, 10};
        int[] array3 = {5, 12, 8, 3, 17, 6, 2, 14, 10, 1};
        int[] array4 = {30, 20, 10, 40, 90, 50, 80, 70, 60, 100};

        System.out.println("Original Array 1:");
        printArray(array1);
        countSort(array1, true);  // Sort in ascending order
        System.out.println("Sorted Array 1 (Ascending):");
        printArray(array1);



        System.out.println("\nOriginal Array 3:");
        printArray(array3);
        countSort(array3, true);  // Sort in ascending order
        System.out.println("Sorted Array 3 (Ascending):");
        printArray(array3);


    }


    public  static int searchRange(int[] nums, int target, int occ) {
        int asn = -1;
        int startIndex = 0;


        int endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (nums[midIndex] == target) {
                asn =midIndex;
                if (occ == 1) {
                    startIndex = midIndex + 1;
                } else if (occ == -1) {
                    endIndex = midIndex - 1;
                } else {
                    return midIndex;
                }
            } else if (nums[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }
        return asn;
    }

}
