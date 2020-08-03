/**
   Bubble Sort Algorithm

  [AUTHOR] :  Saddam Arbaa
  [Email]  :  <saddamarbaas@gmail.com>

   C program to sort an array of N numbers in ascending order
   using Bubble Sort Algorithm  */

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

// A function to implement bubble sort
void bubble_Sort(int array[]);

// function to swap values of two variables
void swap(int *a, int *b);

// the  Driver Code
int main()
{
    printf("Bubble Sort Algorithm implementation \n\n");

    // array declaration
    int array[MAXSIZE];

   /*  traverse Array and insert All the values at once */
    traverse(array); // call traverse() function

   /* traverse Array and display all element before Sort */
    printf("\nElements in array before sorted are :\n");
    printArray(array); // call printArray() function

    /* traverse Array and Sorted in ascending order using Bubble Sort*/
    bubble_Sort(array); // call bubble_Sort function

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

          Bubble Sort Algorithm
          bubbleSort(int [], size)
          for i in 1 to A.length
            for j in 1 to A.length-i
              if A[j] > A[j+1]
                swap(A[j], A[j+1])
    ( user should pass the array as parameter) */


void bubble_Sort(int array[])
{
    // i,j are counters
    int i, j;

    // run two  loops  : one for walking through the array
    // and the other for comparison
    for (i = 0; i < size - 1; i++)
    {
        //inner loop for comparison
        for (j = 0; j < (size - i - 1); j++)
        {
            // swap then let call  swap function
            // To sort in descending order, change">" to "<".
            if (array[j] > array[j + 1])
            {
                //call swap function and pass addresses
                swap(&array[j], &array[j + 1]);
                //swap is done
            }
        }/** End of inner loop */

    }/** End outer loop */
    printf("\nArray is been sorted in ascending order\n");

}/** Bubble sorting End */



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

