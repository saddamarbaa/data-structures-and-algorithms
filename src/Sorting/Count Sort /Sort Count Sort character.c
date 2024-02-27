/**
    [PROGRAM] :  Count Sort Algorithm
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Implement Count Sort  Algorithm
    (sort an array of character in ascending order)

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
    (3) https://youtu.be/lZ1HAbRgbz4 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>   /* include string.h header file */
#define RANGE 255     /* Define Global character  RANGE */

/* count Sort Algorithm  */
void count_Sort(char [], int);

// the  Driver Code
int main()
{
    printf("Counting Sort Algorithm implementation \n");

    // character array declaration and initializations
    char input_array[] = "Counting Sort Algorithm implementation";

    int size =  strlen(input_array); /*  calculate array size */

   /* display array element before Sort */
    printf("character array before sort :\n");
    printf("%s:\n", input_array);

    /* traverse Array and Sorted in ascending order using Count Sort*/
    count_Sort(input_array, size); /* call count_Sort()*/

   /* display array element after Sort */
    printf("Sorted character array \n");
    printf("%s:\n", input_array);


    return 0;// signal to operating system everything works fine

}/** End of main function */


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
End COUNT _SORT */

void count_Sort(char input_array[], int size)
{
    int i; // counter i declaration

    int output_array[size];   // the output_array declarations
    int count_array[RANGE + 1];   // the count_array declarations

   // initialize all elements of count array to zeros
   for (i = 0; i <= RANGE - 1; i++)
        count_array[i] = 0;

  // Store the count of each element
   for (i = 0; i <= size - 1; i++)
        ++count_array[input_array[i]];

   /*
    Store the cumulative count of each array, by this we will get
    the positions of elements to be stored in the output array */
   for (i = 1; i < RANGE; i++)
        count_array[i] = count_array[i] + count_array[i - 1];

    /*
    place input array elements into output array in proper
    positions such that the result is a sorted array in ASC order
    I start loop from last down to zero just For Stable algorithm  */
    for (i = size - 1; i >= 0 ; i--)
         output_array[--count_array[input_array[i]]] = input_array[i];
    /*
    now sorting is done in output array
    so Copy the sorted characters back into original array (input array) */
   for (i = 0; i <= size - 1; i++)
        input_array[i] = output_array[i];

    printf("\nArray is been sorted in ascending order\n"); // inform the user the job is done

    /**
    Counting Sort Complexities:

    Time Complexity
    Worst Case Complexity   : O(n + k)
    Best Case Complexity    : O(n + k)
    Average Case Complexity : O(n + k)

    Space Complexity
    The space complexity of Counting Sort is : O(n + k) */

} /** END of countSort() */
