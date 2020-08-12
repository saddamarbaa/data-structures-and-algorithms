
/**
   C implementation QuickSort Algorithm

  [AUTHOR] :  Saddam Arbaa
  [Email]  :  <saddamarbaas@gmail.com>

    C program to sort an array of N numbers in ascending order
    QuickSort Algorithm

    Quick sort is an algorithm based on divide and conquer approach
    in which the array is split into subarrays and these sub-arrays
    are recursively called to sort the elements.

     Reference in future :->

    (1) https://youtu.be/gtWw_8VvHjk
    (2) https://youtu.be/QN9hnmAgmOc
    (3) https://youtu.be/COk73cpQbFQ
    (4) https://youtu.be/3Bbm3Prd5Fo
    (5) https://youtu.be/h_9kAXFKJwY
    (6) https://youtu.be/O5V5JTa3O20
    (7) https://youtu.be/0Ds3KqYeXzA
    (8) https://youtu.be/EdVKzzlInFI */

#include <stdio.h>
#include <stdlib.h>

/* define the maximum Array size */
#define MAXSIZE 25

/* global array size which will be entered by user */
int size;

/* traverse Array and insert All the values at once */
void traverse(int array[]);

/* Function to traverse Array and printed */
void printArray(int array[]);

/* Quick Sort Algorithm  */
void quickSort(int array[],int low, int high);

// Function to partition the array int sub arrays
int partition(int array[], int low, int high);

// function to swap values of two variables
void swap(int *a, int *b);

/* Driver program to test Quick sort */
int main()
{
    printf("Quick Sort Algorithm implementation \n\n");

    // declare 2 variable
    int low, high;

    // array declaration
    int array[MAXSIZE];

   /* traverse Array and insert All the values at once */
    traverse(array); /* call traverse() function */

    low = 0;          // set low as Starting index
    high = size - 1;  // set last as Ending index

   /* traverse Array and display all element before Sort */
    printf("\nElements in array before sorted are :\n");
    printArray(array); /* call printArray() function */

    /* traverse Array and Sorted in ascending order using Quick Sort*/
    quickSort(array, low, high); /* call quickSort() function */

    /* traverse Array and display all element after Sort */
    printf("Elements in array after sorted are :\n");
    // print the array
    printArray(array); // call printArray() function

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
    QuickSort algorithm

    Pseudo code for Quick sort
    quickSort(A[], low, high)

        If (low < high) Then

           PivotPosition = partition(A, low, high);

            quickSort(A, low, PivotPosition - 1);  // Before Pivot
            quickSort(A, PivotPosition + 1, high); // After Pivot

            End If
            End quickSort
*/

void quickSort(int array[], int low, int high)
{
    /*
    array[] --> Array to be sorted,
    low  --> Starting index,
    high  --> Ending index */


    /*
    EEPEAT for each partition with > 1 item
    Partition the list
    UNTIL all the partitions contain only 1 one item */

    if(low < high)
    {
        /*
        Select pivot position and put all the elements smaller
        than pivot on left and all the elment greater than pivot
        on right(array[pivot_index] is now at right place)*/

        int pivot_index = partition(array, low, high); // calling partition function

        // Sort the elements on the left of pivot
        quickSort(array, low, pivot_index - 1); //recursive call to sort left

        // Sort the elements on the right of pivot
        quickSort(array, pivot_index + 1, high); // recursive call to sort right

    }

    /**
    Time Complexities:
    Worst Case Time Complexities of quickSort is [Big-O]: O(n2).
    The worst case occurs when the partition process always
    picks either the greatest or the smallest element as pivot
    (the worst case can be avoided).

    Best Case Complexity [Big-omega]: O(n*log n)
    Best case occurs when the pivot element is always
    the middle element or near to the middle element.

    Space Complexity
    The space complexity of quick sort is O(log n).
    also quick sort is in place algorithm*/

} /** End of quickSort() */


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

int partition(int array[], int low, int high)
{
    // declare 3 variables
    int  start, end, pivot;

    /* select pivot as first element(low index value) */
    pivot = array[low];

    start = low; // set start at low
    end  = high; // set end at high

    //do the flowing until pivot  set at it right place
    while(start <  end) // base case
    {
        while(array[start] <= pivot) //incrementing start condition
            start++; // start = start + 1

        while(array[end] > pivot) //decrementing end condition
            end--; // end = end - 1

        /*
        if both conditions of while loop above not true
        and array start less than array[end]
        then exchange their values(swap them) */

        if(start < end)
          swap(&array[start], &array[end]); // call swap function

    }  /** End of outer while loop */

    /*
     after outer while loop
     now we know the position of pivot just swap the array[low]
     with array[end] and return end which is pivot correct index
     so we can use it for next function call */

    swap(&array[low], &array[end]); // call swap function

    return end;// return pivot index

    // one more  Reference
    // https://youtu.be/QN9hnmAgmOc

} /** end of partition()*/


/**
  function to swap values of two variables
 (user should pass address of two as parameter)*/

void swap(int *a, int *b)
{
    // declare temp variable
    int temp;
    // store in temp value of a
    temp = *a;
    // store in a value of b
    *a = *b;
    // store in b value of a(we have value of variable a stored in temp)
    *b = temp;

    // swap is done
}/** End of swap () */


/**
  function to traverse array and initialize it value by the value
  inserted by user(take input from user and storing it in an array)
  traversing mean visiting every element in the array exactly once
  ( user should pass the array as parameter)
*/

void traverse(int array[])
{
    // counter i
    int i;

    // get valid size first
    do
    {
        // asking the length of array from user
        printf("Enter the size of an array :\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d", &size);
    } while(size <= 0 || size > MAXSIZE);

    printf("Enter the elements one by one %d numbers \n",size);

     // taking input from user and storing it in an array
     for (i = 0; i <= size - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.

          printf("Enter Array[ %d ]: ",(i+1));
          scanf("%d",&array[i]);

     } /** End of for loop */

} /** End of traverse()  */


/**
    function to print elements of an array Accept one parameters
   ( user should pass the array as parameter) */

void printArray(int array[])
{
    // counter i
    int i;

     if (size == 0) // underflow condition
     {
         printf("Array is empty(no elements to print) !\n");
         return;
     }
    // printf("elements in array are :\n");
     // printing elements of an array
     for (i = 0; i <= size - 1; i++)
     {
         printf("%d\t", array[i]);
       // printf("array[ %d ] :  %d\n", i + 1,array[i]);

     } /** End of for loop */
    printf("\n");

 } /** End of printArray() */
