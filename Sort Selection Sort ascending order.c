/**
   Selection Sort Sort Algorithm implementation

  [AUTHOR] :  Saddam Arbaa
  [Email]  :  <saddamarbaas@gmail.com>

    C program to sort an array of N numbers in ascending order
    using Selection Sort Sort Algorithm

    for reference in future :->
    (1) https://youtu.be/3hH8kTHFw2A
    (2) https://youtu.be/GUDLRan2DWM
    (3) https://youtu.be/qSRHW32sHow
    */

#include <stdio.h>
#include <stdlib.h>

/* define the maximum Array size */
#define MAXSIZE 25

/* global array size which will be entered by user */
int size;

/* traverse Array and insert All the values at once */
void traverse(int array[]);

/* Function to traverse Array print an array */
void printArray(int array[]);

/* Selection Sort Algorithm  */
void Selection_Sort(int array[]);

// function to swap values of two variables
void swap(int *a, int *b);

/* Driver program to test insertion sort */
int main()
{
    printf("Selection Sort Algorithm implementation \n\n");

    // array declaration
    int array[MAXSIZE];

   /* traverse Array and insert All the values at once */
    traverse(array); /* call traverse() function */

   /* traverse Array and display all element before Sort */
    printf("\nElements in array before sorted are :\n");
    printArray(array); /* call printArray() function */

    /* traverse Array and Sorted in ascending order using Selection Sort*/
    Selection_Sort(array); /* call Selection_Sort() function */

    /* traverse Array and display all element after Sort */
    printf("Elements in array after sorted are :\n");
    // print the array
    printArray(array); // call printArray() function

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
    selection sort algorithm
    Selection sort is very simple an algorithm that selects
    the smallest element from an unsorted list in each iteration
    and places that element at the beginning of the sorted list.
    (the idea of the algorithm is to find the smallest unsorted
     element and add it to the sorted list)
     How Selection sort Works?
    (1) Repeat until no unsorted element is remain in the array
    (2) Set the first element as minimum.
    (3) Compare minimum with the second element.
        If the second element is smaller than minimum,assign the second
       element as minimum.Compare minimum with the third element.
       Again, if the third element is smaller, then assign minimum
       to the third element otherwise do nothing.
       The process goes on until the last element.

  (4) After each iteration swap the smallest value found with the first
      element of the unsorted part

    algorithm
    selection-SO0T(A)
      for i in 0 to A.length - 2
       imin <---- i
       for j in i + 1 to A.length -1

           if (a[j] > min)
           imin <---- j

          after inner loop swap
          temp <---- a[i]
          a[i] <---- a[imin]
          a[imin] <---- temp

(user should pass the array as parameter),size of array is global */

void Selection_Sort(int array[])
{
    // declare variable
    int i, j, imin;

    // run two  loops  : one for walking through the array
    // and the other for comparison
    for (i = 0; i <= size - 2; i++) // we need to size-2 passes
    {
        imin = i; // Find the minimum element in unsorted array

        // inner loop to find the minimum  value and swap with i value
        for (j = i + 1; j <= size - 1; j++)
        {
            // to sort in descending order, change < to > in this line
            // we found new minimum value so far
            if(array[j] < array[imin])
            {
                imin = j; // update the index of minimum element
            }

        } /** End of inner loop */

        /*
        now let swap the minimum value we found  with value
        at i index before we increment i and move to next index*/

        swap(&array[i], &array[imin]); // put min at the correct position

    }/** End outer loop */


    // inform user the job is done
    printf("\nArray is been sorted in ascending order\n");

    /*
    Time Complexities:
    Worst Case Time Complexities of Selection Sort is O(n2)
    Worst case occurs If we want to sort in ascending order
    and the array is in descending order(reverse array)

    Best Case Complexity also: O(n2)
    Best case occurs when array is already sorted but the Selection
    Sort is blind algorithm because even if we give array which is
    already sorted it cant see it all.and start going into inner
    loop and compare in O(n2)

    Space Complexity:
    Space complexity is O(1) because an extra
    variable temp  while swapping  values.
 */

}/** End of Selection_Sort() */


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



