/**
    [PROGRAM] :  Sum of two Arrays
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

   C Arrays Examples
   C Program to take array size from user and
   create 3 arrays A,B,C with the size given by user
   then do the flowing
   (1) ask user to enter all the array A element and store them in an array  A
   (2) ask user to enter all the array B element and store them in an array  B
   (3) and store in Array C sum of Array A and Array B
       (C[i] =   A[i] + B[i])
   (4)  Print the elements stored in the array A
   (5)  Print the elements stored in the array B
   (6)  Print the elements stored in the array C
       (size must be bigger than 0) */

#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 100

/* global array size which will be entered by user */
int SIZE;

/* function to Valid size for array */
int get_Valid_Size(void);

/* Function to traverse Array and insert All the values at once */
void traverse(int []);

/* Function to traverse Array and print all element */
void print_Array(int[]);

int main()  // the  Driver Code
{
    /* get valid size for Arrays*/
    SIZE = get_Valid_Size();   /* call get_Valid_Size()*/

    // declaration of 3 Arrays A,B,C
    int A [SIZE];
    int B [SIZE];
    int C [SIZE];

    /* traverse Array  A and insert All the values*/
    printf("Enter element for Array A :\n");
    traverse(A);   /* call traverse()*/

    /* traverse Array B and insert All the values*/
    printf("Enter element for Array B :\n");
    traverse(B);   /* call traverse()*/

    // taking element from array A + B
    // and storing it in an array C
     for (int i = 0; i <= SIZE - 1; i++)
          C[i] = A[i] + B[i];// sum of A[i] + B[i]; will be store in c[i]

    /* traverse Array A and display all element */
    printf("Element in Array A  Are : \n");
    print_Array(A);  /* call print_Array() */

    /* traverse Array B and display all element */
    printf("Element in Array B  Are : \n");
    print_Array(B);  /* call print_Array() */

    /* traverse Array C and display all element */
    printf("Element in Array C Are : \n");
    print_Array(C);  /* call print_Array() */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to traverse array and initialize it value by the value
  inserted by user(take input from user and storing it in an array)
  traversing mean visiting every element in the array exactly once */

void traverse(int array[])
{
    int i; // counter i declaration

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
  function to get valid size for given array, the valid  size here
  is positive number bigger than zero and less than maximum array size
*/

int get_Valid_Size()
{
    int siz;
    // get valid size for Array
    do
    {
        // asking the length of array from user
        printf("Enter size for Arrays"
               ":\n(size must be bigger than zero and las than or equal to %d): ", MAXSIZE);
        scanf("%d", &siz);

    } while(siz <= 0 || siz > MAXSIZE);

    /* if its reach this line already got the valid size just return */
    return siz;

 } /** END of get_Valid_Size */
