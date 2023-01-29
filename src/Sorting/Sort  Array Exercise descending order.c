/**
    [PROGRAM] : sort array in descending order
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to sort array in descending order

   write C Program that take array size from user and create array
   with the size given by user and ask user to enter all the array
   element and store them in an array.

   then do the flowing

   (1) Print all the element of array before sorting
   (2) sort array in descending order
   (3) Print all the element of array after sorting
     (the array(size must be bigger than 0) */

#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 50

/* function to get Valid size for array */
int getValidSize(char *);

/* function to traverse Array and insert it values */
void traverse(int[], int);

/* function to traverse Array and display all it element */
void print_Array(int[], int );

/* function to sort array in descending order */
void array_Sort(int [], int );

// function to swap values of two variables
void swap(int *, int *);

// the  Driver Code
int main()
{
    printf("C program to sort an array of N numbers in descending order :\n\n");

   /* variables declaration */
    int  N;

    //Array declaration
    int A [MAXSIZE];

    /* get valid size vector array  */
    N = getValidSize("vector");   /* call getValidSize() */

    // Array declaration
    int vector [N];

    /* traverse Array vector  and insert All the values at once */
    traverse(vector, N);  /* call traverse()*/

    // print elements of an array before sorting
    printf("element of Array Before arrangement are : \n");

    /* traverse Array vector and display it element */
    print_Array(vector, N);   /* call print_Array() */

    /* traverse Array vector and sorted in descending order */
    array_Sort(vector, N);   /* call array_Sort() */

    // print elements of an array after sorting
    printf("element of Array after arrangement are : \n");

    /* traverse Array vector and display it element */
    print_Array(vector, N);   /* call print_Array() */

   return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to traverse array and initialize it value by the value
  inserted by user(take input from user and storing it in an array)
  traversing mean visiting every element in the array exactly once
*/

void traverse(int vector [], int size)
{
    // counter variable declaration
    int i;

    printf("Enter %d sorted elements for array vector [] : \n", size);
    // taking input from user and storing it in given array
    for (i = 0; i <= size - 1; i++)
     {
         /* The use of '&' before a variable name,mean user
           input will be store in the address of variable. */

          // taking input from user and storing it in an array
          printf("Enter vector[ %d ]: ",(i + 1));
          scanf("%d", &vector[i]);

     } /** End of for loop */

} /** End of traverse()  */


/**
    function to print elements of an array
   (user should pass the array and size as parameter) */

void print_Array(int vector[], int size)
{
    // counter variable declaration
    int i;

    // printing elements of an array vector

    for (i = 0; i <= size - 1; i++)
    {
        printf("vector[ %d ] :  %d\n", i +1 ,vector[i]);

    } /** End of for loop */
    printf("\n");

} /** End of printArray() */


/**
  function to get valid size for given array, the valid  size here
  is positive number bigger than zero and less than maximum array size
*/

int getValidSize(char * A)
 {
     // variable declaration
     int size;

    // get valid size for Array
    do
    {
        // asking the length of array from user
        printf("Enter size for Array -->  %s "
               ":\n(size must be bigger than zero and las than or equal to %d): ",A, MAXSIZE);
        scanf("%d", &size);

    } while(size <= 0 || size > MAXSIZE);

    /* if its reach this line already got the valid size just return */
    return size;

 } /** END of getValidSize */

/** function to traverse the given array and sorted in descending order
  (user should pass the array and size as parameter) */

void array_Sort(int vector[], int N)
{
    // counter variable declaration
    int i, j;

    // outer loop
    for ( i = 0; i <= N - 1; i++)
    {
        // inner loop
        for (j = i + 1; j <= N - 1; j++)
        {
            // if condition true
             if(vector[i] > vector[j])

             // swap between vector[j] and vector[i]
             swap(&vector[i], &vector[j]); //call swap()

        } /** End of inner loop */

    } /** End of outer loop */

    printf("the array is been sort in descending order\n");

} /** END of descending_order_Sort() */



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
