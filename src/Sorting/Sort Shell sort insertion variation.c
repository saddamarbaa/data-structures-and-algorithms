/**
    [PROGRAM] :  Shell Sort Algorithm(Insertion Sort Variation)
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Implement Shell Sort Algorithm
    (sort an array of N numbers in ascending order)

    Shell Sort : ->
    ShellSort is an in-place comparison sort.It is mainly a variation
    of sorting by exchange(bubble sort) or sorting by insertion
    (insertion sort).In insertion sort, we move elements only one
    position ahead.When an element has to be moved far ahead, many
    movements are involved. so The main idea of shellSort is to allow
    exchange of far items.

    Time complexity:
    1. Best Case – Ω((n*log n)
    2. Worst Case – O(n^2)
    3. Average Case – θ(n log(n)2)
     Space Complexity :
     The space complexity for shell sort is O(1).

     Reference in future :->
     1.  https://youtu.be/408TQi6MWmI
     2.  https://youtu.be/zXyEZQY9nKY
     3.  https://youtu.be/9crZRd8GPWM
     4.  https://youtu.be/SHcPqUe2GZM
     5.  https://youtu.be/PQvJAAWF0HE
     6.  https://youtu.be/S1dAQk1JeRA */

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

/* Shell Sort Algorithm  */
void Shell_Sort(int[], int);

/* function to swap values of two variables */
void swap(int *a, int *b);

// the  Driver Code
int main()
{
    printf("Shell Sort Algorithm implementation \n\n");

    int array[MAXSIZE]; // input array declaration

   /* traverse Array and insert All the values at once */
    traverse(array);   /* call traverse()*/

   /* traverse Array and display all element before Sort */
    printf("\nElements in array Before Sorting are :\n");
    print_Array(array);  /* call print_Array() */

    /* traverse Array and Sorted in ascending order using Shell Sort */
     Shell_Sort(array, SIZE); /* call  Shell_Sort()*/

    /* traverse Array and display all element after Sort */
    printf("Elements in array after Shell Sort are :\n");
    print_Array(array);  /* call printArray() */

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
    Shell Sort function (Insertion Sort Variation)
    How Shell Sort Works?
    Step 1 − Initialize the value of gap/interval here we take n/2 iteratively)
    Step 2 − Compare 2 elements at the distance of gap at every iteration
    Step 3 − if element at the left is smaller than element at the right,
             perform swap or shift(depending on Insertion sort)
    Step 4 − Repeat until complete array is sorted */

void Shell_Sort(int array[], int size)
{
    int i, j, gap; // counter variables declarations

    /*
    Start loop with gap equal to size /2
    and reduce the gap each Iteration by gap /2 */
    for(gap = size / 2; gap > 0; gap /= 2)
    {
        for (j = gap; j < size; j++)
        {
            for (i = j - gap; i >= 0 ;  i-= gap)
            {
                if (array[i + gap] > array[i]) /* if condition is true they are in right order */
                    break;
                else /* in else case element are in wrong order let swap them */

                 swap(&array[i + gap] , &array[i]); /* call swap function */
            }
        }

    } /** end of gap for loop */

    printf("\nArray is been sorted in ascending order\n"); // inform the user the job is done

   /**
    Time complexity:
    1. Best Case – Ω((n*log n)
    2. Worst Case – O(n^2)
    3. Average Case – θ(n log(n)2)
    Space Complexity :
    space Complexity – O(1). */

    // very well explained on Insertion Sort Variation
   // https://youtu.be/9crZRd8GPWM

} /** END of Shell_Sort() */


/**
  function to swap values of two variables
 (user should pass address of two as parameter)*/

void swap(int *a, int *b)
{
    int temp;  /*  declare temp variable */

    temp = *a; // store in temp value of a
    *a = *b; // store in a value of b

    // store in b value of a(we have value of variable a stored in temp)
    *b = temp;

}/** End of swap () */
