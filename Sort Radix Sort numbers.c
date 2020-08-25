/**
    [PROGRAM] :  Radix Sort Algorithm
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Implement Radix Sort Algorithm
    (sort an array of N numbers in ascending order)

    Radix Sort : -–>

    Radix sort is a sorting technique that sorts the elements
    by first grouping the individual digits of the same place value.
    Then,sort the elements according to their increasing/decreasing order.
    Radix sort is a non-comparative sorting algorithm.(It avoids comparison
    by creating and distributing elements into buckets according to their radix.)
    that why radix sort has also been called bucket sort and digital sort.
    Radix sort uses counting sort as a subroutine to sort.
    Radix sort has linear time complexity which is better
    than O(nlog n) of comparative sorting algorithms.

    Time complexity: O(d(n+k))
    Space complexity: O(n+k)
    Where d is the no of max digits of the largest no in the digit,
    n is the no of elements in the list and k is the range of unique elements

    Reference in future :->
     1. https://youtu.be/9crZRd8GPWM
     2. https://youtu.be/Il45xNUHGp0
     3. https://youtu.be/5n8KZnQvf4k
     4. https://youtu.be/nnd0XtYG7eg
     5. https://youtu.be/jDL5lRPX6yI
     6. https://youtu.be/Nz1KZXbghj8 */

#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 50

/* global array size which will be entered by user */
int SIZE;

/* traverse Array and insert All the values at once */
void traverse(int []);

/* Function to traverse Array and print all element */
void print_Array(int[]);

/* Radix Sort Algorithm  */
void Radix_Sort(int[], int);

/* count Sort Algorithm  */
void count_Sort(int [], int, int);

/* function to get the  maximum value in array */
int getMax(int [], int);

// the  Driver Code
int main()
{
    printf("Radix Sort Algorithm implementation \n\n");

    int input_array[MAXSIZE]; // input array declaration

   /* traverse Array and insert All the values at once */
    traverse(input_array);   /* call traverse()*/

   /* traverse Array and display all element before Sort */
    printf("\nElements in array Before Sorting are :\n");
    print_Array(input_array);  /* call print_Array() */

    /* traverse Array and Sorted in ascending order using  Radix Sort */
     Radix_Sort(input_array, SIZE); /* call  Radix_Sort()*/

    /* traverse Array and display all element after Sort */
    printf("Elements in array after Radix Sort are :\n");
    print_Array(input_array);  /* call printArray() */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to traverse array and initialize it value by the value
  inserted by user(take input from user and storing it in an array)
  traversing mean visiting every element in the array exactly once
*/

void traverse(int array[])
{
    int i; // counter i declaration
    // get valid size first
    do
    {
        // asking  the length of array from user
        printf("Enter the size of the array []  :"
               ":\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d", &SIZE);
    } while(SIZE <= 0 || SIZE > MAXSIZE);

     // taking input from user and storing it in an array
    printf("Enter the elements one by one %d numbers \n", SIZE);

    for (i = 0; i <= SIZE - 1; i++)
    {
        // The use of '&' before a variable name,mean user input will
        // be store in the address of variable.
        printf("Enter Array[ %d ]: ",(i + 1));
        scanf("%d",&array[i]);

     } /** End of for loop */

} /** End of traverse()  */


/**
    function to traverse the given array and print all elements
    Accept one parameters (user should pass the array as parameter) */

void print_Array(int array [])
{
    int i; // counter i declaration
    if (SIZE == 0) // underflow condition
    {
        printf("Array is empty(no elements to print) !\n");
        return;
    }
     /* printing elements of an array */
     for (i = 0; i <= SIZE - 1; i++)
          printf("%d\t", array[i]);

    printf("\n"); // insert new line after printing all element

 } /** End of print_Array() */


/**
    Radix Sort function
    How Radix Sort Works?
    Step 1 – Take input array and find MAX number in the array
    Step 2 – Define 10 queues each representing a bucket for each digit from 0 to 9.
    Step 3 – Consider the least significant digit of each number in the list which is to be sorted.
    Step 4 – Insert each number into their respective queue based on the least significant digit.
    Step 5 – Group all the numbers from queue 0 to queue 9 in the order they have inserted into
            their respective queues.
    Step 6 – Repeat from step 3 based on the next least significant digit.
    Step 7 – Repeat from step 2 until all the numbers are grouped based on the most significant digit.

    Pseudo code for Radix Sort Algorithm
    RADIX _SORT(arr[], size)
    Get max element from this array
    m = GetMax(arr, size)
    Call counting sort d times based on the no of digits in the max number m.
    for (int div = 1; m/div > 0; div *= 10)
    CountingSort(arr, size, div)
    END OF RADIX _SORT() */

void Radix_Sort(int array[], int size)
{
    int div, max;          /* variables declarations */

    // Find the maximum number to know number of digits
    max = getMax(array, size); // call getMax function

    //Apply counting sort to sort elements based on place value.
     for(div = 1; max / div > 0; div *= 10)
         count_Sort(array, size, div);  // call  count sort function

    printf("\nArray is been sorted in ascending order\n"); // inform the user the job is done

    /**
    Radix Sort Complexities:
    Time complexity      :  O(d(n+k))
    Space complexity     :  O(n+k)  */

} /** END of Radix_Sort() */


/** A utility function to get maximum value in array[] */
int getMax(int array[], int siz)
{
    int i, max;                  /* variables declarations */
    max = array[0];              /*let assume first value is the max */
    for(i = 1; i < siz; i++)    /* start from second index and search for new max */
    {
        if (array[i] > max)        /*  if new max has found */
            max = array[i];        /*  max is now that new maximum value*/
    }
    return max; /* return the maximum value in array */

} /** end of getMax()*/


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
            ++count_array[(input_array[i] / div ) % 10]
  6.  Modify count_array[] to store previous counts (cumulative)
        for(int i = 1 to i < range)
            count_array[i]= count_array[i]+ count_array[i-1]
  7.  Place elements from input_array[] to output_array[] using this
      count_array[] that has the actual positions of elements
        for(int i= size - 1 to i>= 0)
            output_array[--count_array[(input_array[i] / div ) % 10 ]]  = input_array[i]
  8. copy sorted element from output_array[] to input_array[]
        for(i=0 to i<size)
            input_array[i]=output_array[i]

End COUNT _SORT */

void count_Sort(int input_array[], int size, int div)
{
    int i, range; // variables declarations
    range = 10;          /* 10 is the number of numbers in decimal system*/
    int output_array[size];   // the output_array declarations
    int count_array[range];   // the count_array declarations

    // initialize all elements of count array to zeros
    for (i = 0; i <= range - 1; i++)
        count_array[i] = 0;

    // Store the count of each element
    for (i = 0; i <= size - 1; i++)
         count_array[( input_array[i] / div ) % 10 ]++;


   /*
    Store the cumulative count of each array, by this we will get
    the positions of elements to be stored in the output array */
   for (i = 1; i < range; i++)
        count_array[i] = count_array[i] + count_array[i - 1];

    /*
    place input array elements into output array in proper
    positions such that the result is a sorted array in ASC order
    I start loop from last down to zero just For Stable algorithm  */
    for (i = size - 1; i >= 0 ; i--)
         output_array[ --count_array[(input_array[i] / div ) % 10 ]]  = input_array[i];

    /*
    now sorting is done in output array
    so Copy the sorted elements back into original array (input array) */
    for (i = 0; i <= size - 1; i++)
         input_array[i] = output_array[i];

    /**
    Counting Sort Complexities:
    Time Complexity
    Worst Case Complexity   : O(n + k)
    Best Case Complexity    : O(n + k)
    Average Case Complexity : O(n + k)
    Space Complexity
    The space complexity of Counting Sort is : O(n + k) */

} /** END of countSort() */
