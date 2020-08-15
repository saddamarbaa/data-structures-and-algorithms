
/**
    [PROGRAM] :  Merge two Sorted Array
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Merge the Elements of 2 Sorted Array

   write C Program that to take sizes of an array A ,B from user and
   create 2 arrays A,B with the size given by user and create third
   Array C with the size that can store array A and B
  (C size = size of A + size of B)

   then do the flowing
   (1)  ask user to enter all the array A and array B element
        in sorted order and store them in an array A , B
   (2)  Merge the Elements of A,,B in Array C in sorted order
   (3)  Print the elements stored in the array A
   (5)  Print the elements stored in the array B
   (6)  Print the elements stored in the array C
     (size must be bigger than 0)   */

#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 50

/* traverse Arrays A,B, and insert All the values at once */
void traverse(int A[], int B[], int m, int n);

/* Merge the elements of 2 Sorted Array A,B in Array C */
void Merge(int A[], int B[], int C[], int m, int n);

/* traverse Arrays A,B,C and display all element */
void print_Array(int A[], int B[], int C[], int m, int n);

// the  Driver Code
int main()
{
    printf("C Program to Merge the Elements of 2 Sorted Array :\n\n");

    /*
    variables declaration,m is the size of array A
    and n is size of array B  */
    int i, m ,n;

    // declaration of 3 Arrays A,B,C
    int A [MAXSIZE / 2];
    int B [MAXSIZE / 2];
    int C [MAXSIZE];

    // get valid size for Array A
    do
    {
        // asking  the length of array from user
        printf("Enter size of Array A:"
               ":\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d", &m);
    } while(m <= 0 || m > MAXSIZE);

    // get valid size for Array B
    do
    {
        // asking  the length of array from user
        printf("Enter size of Array B:"
               ":\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d", &n);
    } while(n <= 0 || n > MAXSIZE);

    /* traverse the Arrays A,B and insert All the values at once */
    traverse(A, B, m, n); /* call traverse()*/

    /* traverse the Arrays A,B and Merge them in Array C */
    Merge(A, B, C, m, n); // call merge() function

    /*traverse the Arrays A,B,C and display all their element*/
    print_Array(A, B, C, m, n); /* call printArray() function */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to traverse array and initialize it value by the value
  inserted by user(take input from user and storing it in an array)
  traversing mean visiting every element in the array exactly once
*/

void traverse(int A[], int B[], int m, int n)
{
    // counter variables declaration
    int i, j;

    printf("Enter %d sorted elements of array A : \n",m);
    // taking input from user and storing it in an array A
    for (i = 0; i <= m - 1; i++)
     {
         /* The use of '&' before a variable name,mean user
           input will be store in the address of variable. */

          // taking input from user and storing it in an array A
          printf("Enter A[ %d ]: ",(i + 1));
          scanf("%d",&A[i]);

     } /** End of for loop */

    printf("Enter %d sorted elements of array B : \n",n);
     // taking input from user and storing it in an array B
    for (j = 0; j <= n - 1; j++)
    {
        /* The use of '&' before a variable name,mean user
           input will be store in the address of variable. */

          // taking input from user and storing it in an array B
          printf("Enter B[ %d ]: ",(j + 1));
          scanf("%d",&B[j]);

     } /** End of for loop */
} /** End of traverse()  */


/**
  function to traverse the Sorted Arrays A, B and
  Merge them in Array C in sorted order
*/

void Merge(int A[], int B[], int C[], int m, int n)
{

    /* m is the size of array A */
    /* n is the size of array B */

    // counter variables declaration
    int i, j, k;

    /* initialize all the counters by zero(start from zero index) */

    i = 0;     /*  i is the counter for Array A */
    j = 0;     /*  j is the counter for Array B */
    k = 0;    /*   k is the counter for Array C */

    /** Merge process start from here */

   /*continue loop Until we reach end of either arrays A or B  */
    while (i < m  && j < n)
    {
        /*
        Compare their element first then them merge them
        in array C[] in sorted order */

        if ( A[i] < B[j])
        {
            C[k] = A[i]; /* filling the array C with the smaller element */

            i++; //increment i

            //also can written just like this C[k++] = A[i++];
        }
        else
        {
            C[k] = B[j];  /* filling the array  C with the smaller element */

            j++; //increment j

            //also can written just like this C[k++] = B[j++];
        }

        k++; /* increment counter k here as it will be incremented in both cases */

    } /** End of while loop */

    /*  Copy the remaining elements if there are any */
    for ( ; i < m ; i++) /* case when array[A] have remaining element */
    {
        C[k++] = A[i];
    }

    /*  Copy the remaining elements if there are any */
    for ( ; j < n; j++) /* case when array[B] have remaining element */
    {
        C[k++] = B[j];
    }

} /** end of Merge() */


/**
    function to print elements of an array Accept one parameters
   ( user should pass the array as parameter) */

void print_Array(int A[], int B[], int C[], int m, int n)
{
    // counters variables declaration
    int i, j, k;

    printf("\nElement in Array A  Are : \n");
    // printing elements of an array A
     for (i = 0; i <= m - 1; i++)
     {
         printf("%d\t",A[i]);

     } /** End of for loop */

    printf("\nElement in Array B  Are : \n");
    // printing elements of an array B
    for (j = 0; j <= n - 1; j++)
    {
        printf("%d\t",B[j]);

    } /** End of for loop */

    printf("\nAfter merging element in array C are: \n");
    // printing elements of an array C
    for (k = 0; k < (m + n); k++)
    {
        printf("%d\t",C[k]);

    } /** End of for loop */
    printf("\n");

 } /** End of printArray() */
