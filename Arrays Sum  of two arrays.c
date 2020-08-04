/**
[AUTHOR]: Saddam Arbaa
[Email] : <saddamarbaas@gmail.com>

   C Arrays Examples
   Program to take array size from user and
   create 3 arrays A,B,C with the size given user
   then do the flowing

   (1) ask user to enter all the array A element and store
    them in an array  A
   (2) ask user to enter all the array B element and store
    them in an array  B
   (3) and store in Array C sum of Array A and Array B
    (C[i] =   A[i] + B[i])
   (4)  Print the elements stored in the array A
   (5)  Print the elements stored in the array B
   (6)  Print the elements stored in the array C

    (size must be bigger than 0) */



#include <stdio.h>

#include <stdlib.h>

// the  Driver Code
int main()
{
    // size of the array N and counter i
    int N , i;

    // get valid size first
    do
    {
        // asking the length of array from user
        printf("Enter the length of Arrays(size must be bigger than zero): ");
        scanf("%d",&N);

    } while (N <= 0);

    // declaration of 3 Arrays A,B,C
    int A [N];
    int B [N];
    int C [N];


     printf("Enter %d element to Array A: \n",N);

     // taking input from user and storing it in an array A
     for (i = 0; i <= N - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.

          printf("Enter A[ %d ]: ",(i+1) );
          scanf("%d",&A[i]);
     }

     printf("Enter %d element to Array B: \n",N);

     // taking input from user and storing it in an array B
     for (i = 0; i <= N - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.

          printf("Enter B[ %d ]: ",(i+1) );
          scanf("%d",&B[i]);
     }

     // taking element from array A + Array B
     // and storing it in an array C
     for (i = 0; i <= N - 1; i++)
     {
         C[i] = A[i] + B[i];// sum of A[i] + B[i]; will be store in c[i]
     }

    printf("--------------------------------------\n");

    printf("Element in Array A  Are : \n");

     // printing elements of an array A
     for ( i = 0; i <= N - 1; i++)
     {
         printf("A[ %d ] :  %d\n", i +1 ,A[i]);
     }

     printf("--------------------------------------\n");

     printf("Element in Array B  Are : \n");

     // printing elements of an array B
     for (i = 0; i <= N - 1; i++)
     {
         printf("B[ %d ] :  %d\n", i +1 ,B[i]);
     }

     printf("------------------------------------\n");

     printf("Element in Array C Are : \n");

     // printing elements of an array c
     for (i = 0; i <= N - 1; i++)
     {
         printf("C[ %d ] :  %d\n", i +1 ,C[i]);
     }

     return 0;// signal to operating system everything works fine

    /*
        the code above can be written only one for loop
        for storing element to Array A,B,C,and 3 for loop
        to printing element of each Array but i wrote like this
        for readability to make easy to read
        */


}/** End of main function */
