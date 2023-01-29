/**
    [PROGRAM] :  C / (Exercise) Merge Arrays
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Merge the Elements of Two Arrays

   write C Program that to take sizes of an array A ,B from user and
   create 2 arrays A,B with the size given by user and create third
   Array C with the size that can store array A and B
  (C size = size of A + size of B)

   then do the flowing
   (1)  ask user to enter all the array A and array B element
        in and store them in an array A , B
   (2)  Merge the Elements of A,,B in Array C
   (3)  Print the elements stored in the array A
   (5)  Print the elements stored in the array B
   (6)  Print the elements stored in the array C
     (size must be bigger than 0)   */

#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 50

/* function to Valid size for array */
int get_Valid_Size(int);

/* traverse Arrays A,B, and insert All the values at once */
void traverse(int A[], int B[], int m, int n);

/* Merge the elements of 2 Arrays A,B in Array C */
void Merge(int A[], int B[], int C[], int m, int n);

/* traverse Arrays A,B,C and display all element */
void print_Array(int A[], int B[], int C[], int m, int n);

int main() // the  Driver Code
{
    printf("C Program to Merge the Elements of Two Arrays :\n\n");

    /*
    variables declaration,m is the size of array A
    and n is size of array B  */
    int i, m ,n;

    // declaration of 3 Arrays A,B,C
    int A [MAXSIZE / 2];
    int B [MAXSIZE / 2];
    int C [MAXSIZE];

    /* get valid size for Array A  */
    m = get_Valid_Size('A');   /* call get_Valid_Size() */

    /* get valid size for Array B */
    n = get_Valid_Size('B');   /* call get_Valid_Size() */

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
    int i, j; // counter variables declaration

    printf("Enter %d elements of array A : \n",m);
    // taking input from user and storing it in an array A
    for (i = 0; i <= m - 1; i++)
     {
         /* The use of '&' before a variable name,mean user
           input will be store in the address of variable. */

          // taking input from user and storing it in an array A
          printf("Enter A[ %d ]: ",(i + 1));
          scanf("%d",&A[i]);

     } /** End of for loop */

    printf("Enter %d  elements of array B : \n",n);
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

    int i, j, k;  // counter variables declaration

    /* initialize k = 0 */
    k = 0;    /*  k is the counter for Array C */

    /** Merge process start from here */

    /* continue loop Until we reach end of array A */
    for (i = 0; i <= m - 1; i++)
    {
        C[k] = A[i]; /* filling the array C with array A element */
        k++; //increment k
        //also can written just like this C[k++] = A[i];
    }

    /* continue loop Until we reach end of array B */
    for (i = 0; i <= n - 1; i++)
    {
        C[k] = B[i]; /* filling the array C with array B element */
        k++; //increment i
        //also can written just like this C[k++] = B[j];
    }

} /** end of Merge() */


/**
    function to print elements of an array Accept one parameters
   ( user should pass the array as parameter) */

void print_Array(int A[], int B[], int C[], int m, int n)
{
    int i, j, k; // counters variables declaration

    printf("\nElement in Array A  Are : \n");
    for (i = 0; i <= m - 1; i++) // printing elements of an array A
         printf("%d\t",A[i]);

    printf("\nElement in Array B  Are : \n");
    for (j = 0; j <= n - 1; j++) // printing elements of an array B
         printf("%d\t",B[j]);

    printf("\nAfter merging element in array C are: \n");
    for (k = 0; k < (m + n); k++) // printing elements of an array C
         printf("%d\t",C[k]);

    printf("\n");

 } /** End of printArray() */


 /**
  function to get valid size for given array, the valid  size here
  is positive number bigger than zero and less than maximum array size
*/

int get_Valid_Size(int A)
 {
    int size; // variable declaration

    do // get valid size for Array
    {
        // asking the length of array from user
        printf("Enter size for Array -->  %c "
               ":\n(size must be bigger than zero and las than or equal to %d): ",A, MAXSIZE);
        scanf("%d", &size);

    } while(size <= 0 || size > MAXSIZE);

    /* if its reach this line already got the valid size just return */
    return size;

 } /** END of get_Valid_Size */
