/**
    Divide and Conquer algorithms Implementation

   [AUTHOR] :  Saddam Arbaa
   [Email]  :  <saddamarbaas@gmail.com>

    C program to breaks an array into smaller arrays and
      when the size of smaller array reaches to 1, it increases
      their value by 5 using Divide and Conquer Algorithm so let
      write function for that */

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

/* Divide and Conquer algorithms Implementation   */
void Divide_And_Conquer(int array[], int start, int end);

/* Driver program to Divide and Conquer */
int main()
{
    printf("Divide and Conquer algorithms Implementation \n\n");

   // declare variable start and end
    int start, end;

    // array declaration
    int array[MAXSIZE];

   /* traverse Array and insert All the values at once */
    traverse(array); /* call traverse() function */

   /* traverse Array and display all element before Divide and Conquer */
    printf("\nElements in array before Divide and Conquer :\n");
    printArray(array); /* call printArray() function */

    /* traverse Array and Divide and Conquer*/
    /*set start by 0( first index)*/
    start = 0;
    /*set end by size -1( last index)*/
     end = size -1;

     Divide_And_Conquer(array, start, end); /* call Divide_And_Conquer() function */

    /* traverse Array and display all element after Divide and Conquer */
    printf("Elements in array after Divide and Conquer are :\n");

    // print the array
    printArray(array); // call printArray() function

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
    in Divide and Conquer we divide the problems into smaller
    subproblems and then conquer (or solve) the smaller subproblems first.
    After this,we combine the solution of the smaller subproblems
    to get the solution for the original problem.

    Divide and Conquer is a three-step process:__>

    (1) Divide → The first step is to break the problem
         into smaller subproblems.
    (2) Conquer → This is basically solving of the smaller subproblems
    (3) Combine → In the last step, we combine the solutions
       of the smaller subproblems to get the solution of the bigger problem.

    Divide_And_Conquer(A, start, end)
    if start < right
    middle = floor((start+end)/2)
    Divide_And_Conquer(A, start, middle)
    Divide_And_Conquer(A, middle+1, end)
   else
    A[start] = A[start]+5

(user should pass the array ,start, end as parameter)*/

void Divide_And_Conquer(int array[], int start, int end)
{
    // declare mid variable
    int  mid;

    if(start < end)
    {
        // calculate mid
        mid = (start + end)/2;

        // break the array from to 2 part

        Divide_And_Conquer(array, start, mid); //recursive call

        Divide_And_Conquer(array,mid + 1, end); //recursive call
    }
    /*
    if we reach this line mean we have already reach base case
    and condition became false start is not less than end
    they both point to same place that mean we have only one element
    so let do the conquer part and increase it value by 5 */

    else
    {
        array[start] = array[start] + 5; // increases value by 5
    }
} /** End of Divide_And_Conquer() */



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

