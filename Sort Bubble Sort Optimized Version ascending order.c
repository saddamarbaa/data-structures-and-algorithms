/**
   Optimized Version of Bubble Sort Algorithm implementation


  [AUTHOR] :  Saddam Arbaa
  [Email]  :  <saddamarbaas@gmail.com>

    C program to sort an array of N numbers in ascending order
    using Bubble Sort Algorithm(Optimized verstion)  */

#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 25

// global array size which will be entered by user
int size;

//traverse Array and insert All the values at once
void traverse(int array[]);

/* Function to traverse Array print an array */
void printArray(int array[]);

/* An optimized version of Bubble Sort  */
void optimizedBubbleSort(int array[]);

// function to swap values of two variables
void swap(int *a, int *b);

// the  Driver Code
int main()
{
    printf("Optimized Version of Bubble Sort Algorithm implementation \n\n");

    // array declaration
    int array[MAXSIZE];

   /*  traverse Array and insert All the values at once */
    traverse(array); // call traverse() function

   /* traverse Array and display all element before Sort */
    printf("\nElements in array before sorted are :\n");
    printArray(array); // call printArray() function

    /* traverse Array and Sorted in ascending order using Bubble Sort*/
    optimizedBubbleSort(array); // call optimizedBubbleSort() function

    /* traverse Array and display all element after Sort */
    printf("Elements in array after sorted are :\n");
    printArray(array); // call printArray() function

    return 0;// signal to operating system everything works fine

}/** End of main function */


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


/**
    Bubble Sort Algorithm

 Bubble sort is an algorithm that compares the adjacent elements
 and swaps their positions if they are not in the intended order.
 The order can be ascending or descending.

 start with iterating over an array and compare the first element
 to the second one and swap them if they are in the wrong order
 and then compare the second and the third one and so on.
 After this iteration, the largest element goes to the last of the array

How Bubble Sort Works?

(1) Starting iterating over an array from the first index,
(2) Compare the adjacent elements.For example compare the first and the second elements.
(3) Swap them if they are not in order. (mean If the first element
    is greater than the second element, Swap them.and continue,compare
    the second and the third elements. Swap them if they are not in order.

(4) The above process goes on until the last element.
   (so Repeat these steps except for the elements which are placed at their correct positions.)

 we can optimized Sort Bubble by adding an extra flag variable  named swapped.
 After each iteration, we check if there is no swapping taking place ,
 that is meaning Array is already sorted. there no need to continue just break

        Bubble-SORT-OPTIMIZED(A)
          for i in 1 to A.length
            swapped = FALSE
            for j in 1 to A.length-i
              if A[j] > A[j+1]
                swap(A[j], A[j+1])
                swapped = TRUE
            if not(swapped)
              break
    (user should pass the array as parameter) */

void optimizedBubbleSort(int array[])
{
    // i,j are counters
    int i, j;

    // Swapped to keeps track of swapping
    int swapped;

    // run two  loops  : one for walking through the array
    // and the other for comparison
    for (i = 0; i < size - 1; i++)
    {
        swapped = 0;

        //inner loop for comparison
        for (j = 0; j < (size - i - 1); j++)
        {
            // if so swap them for that call swap() function
            // To sort in descending order, change">" to "<".
            if (array[j] > array[j + 1])
            {
                //call swap function and pass addresses
                swap(&array[j], &array[j + 1]);

                // there is swapping happened in this iteration
                swapped = 1;
            }
        }/** End of inner loop */

    /* If there is not swapping in the last swap,
    then the array is already sorted. */
    if (swapped == 0) //if(!swapped)
      break;

    }/** End outer loop */

    printf("\nArray is been sorted in ascending order\n");

    /*
    Time Complexities:

    Worst and Average Case Time Complexity: O(n2)
    Worst case occurs If we want to sort in ascending order
    and the array is in descending order
    Best Case Complexity:O(n)
    Best case occurs when array is already sorted.
    becauseIf the array is already sorted, then there is no need for sorting.

    Space Complexity:
    Space complexity is O(1) because an extra variable temp is used for swapping in swap function.

    In the optimized algorithm, the variable swapped adds to the space complexity
    so we can say Space complexity is O(2). */

}/** End of optimizedBubbleSort() */


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

