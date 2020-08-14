/**  
   Insertion Sort Algorithm implementation

  [AUTHOR] :  Saddam Arbaa
  [Email]  :  <saddamarbaas@gmail.com>

    C program to sort an array of N numbers in descending order
    using Insertion Sort Algorithm

    for reference in future :->
    (1) https://youtu.be/i-SKeOcBwko
    (2) https://youtu.be/UIq4ihA4WEY
    (3) https://youtu.be/yCxV0kBpA6M
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

/* Insertion Sort Algorithm  */
void insertion_Sort(int array[]);

/* Driver program to test insertion sort  */
int main()
{
    printf("Insertion Sort Algorithm implementation \n\n");

    // array declaration
    int array[MAXSIZE];

   /*  traverse Array and insert All the values at once */
    traverse(array); /* call traverse() function */

   /* traverse Array and display all element before Sort */
    printf("\nElements in array before sorted are :\n");
    printArray(array); /* call printArray() function */

    /* traverse Array and Sorted in descending order using insertion Sort*/
    insertion_Sort(array); /* call insertion_Sort() function */

    /* traverse Array and display all element after Sort */
    printf("Elements in array after sorted are :\n");
    // print the array
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
  Insertion sort algorithm to sort array descending order

    INSERTION-SO0T(A)
      for i in 1 to A.length
        k = a[i]
        j = i
        while j> 0 and a[j -1] < k
          a[j] = a[j -1]
          j = j-1
          after while loop
          a[j] = k

(user should pass the array as parameter),size of array is global */

void insertion_Sort(int array[])
{
    // declare variable
    int i, temp, hole;

    // run two  loops  : one for walking through the array
    // and the other for comparison
    for (i = 1; i <= size - 1; i++)
    {
        // save value of i in temp and create hole there
        temp = array[i];
        hole = i; // hole is i

        /*
          inner loop for comparison take value and added to sorted array
          in other way Compare temp with each element on the left of it until
          an element smaller than it is found or hole become zero. */

      /* For ascending order, change
        array[hole - 1] < temp to array[hole - 1] > temp */
        while(hole > 0 && array[hole - 1] < temp)
        {
            // shifting the element
            array[hole] = array[hole - 1];

            // move hole as well by decremented hole by one
            hole = hole - 1;

        } /** End of inner loop */

        /*
          Element have been shifted now insert the value at
          it right pace (place where we have empty hole)
        */
        array[hole] = temp; // insert in right place

    }/** End outer loop */

    printf("\nArray is been sorted in descending order\n");

    /*
    Time Complexities:
    Worst Case Time Complexities of Insertion Sort is O(n2)

    Worst and Average Case Time Complexity: O(n2)
    Worst case occurs If we want to sort in descending order
    and the array is in ascending order(reverse array)

    Best Case Complexity:O(n)
    Best case occurs when array is already sorted in descending order.
    because If the array is already in descending order
    never enter to the inner loop

    Average Case Complexity: O(n2)

    Space Complexity:
    Space complexity is O(2) because an extra 2
    variable temp  and hole are been used.
 */

}/** End of insertion_Sort() */

