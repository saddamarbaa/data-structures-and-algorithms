/**
[AUTHOR]: Saddam Arbaa
[Email] : <saddamarbaas@gmail.com>

   C Arrays Examples
   Program to take array size from user and
   create 2 arrays A,B with the size given by user
   and create third Array C with the size that can store
   array A and B(size of A + size of B)

   then do the flowing

   (1) ask user to enter all the array A and array B element
      and store them in an array  A and an array B
   (2) and store in Array C all the elements of Array A and Array B
   (3)  Print the elements stored in the array A
   (5)  Print the elements stored in the array B
   (6)  Print the elements stored in the array C

    (size must be bigger than 0)

*/


#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
   // size of the array N and counter i
    int N ,i;
    // get valid size first
    do
    {
        // asking the length of array from user
        printf("Enter the length for vectors ( A ) and ( B ): \n(size must be bigger than zero) : ");
        scanf("%d",&N);

    } while (N <= 0);

    // declaration of 3 Arrays A,B,C
    int A [N];
    int B [N];
    int C [N * 2];//also can C[N + N] because we will
                  // store both A  and B in c
    /*
     C سنستخدم هذا المتغير كعداد للوصول لعناصر المصفوفة
     k will be use as counter to Access Array C element later
     in storing process */
    int k = 0;
     printf("Enter %d element to Array A: \n",N);

     /*
       one for loop for taking input from user and storing it
       in an array A and an array B at the same time
     */

     for (i = 0; i <= N - 1; i++)
     {
         /* The use of '&' before a variable name,mean user
           input will be store in the address of variable. */

          // taking input from user and storing it in an array A
          printf("Enter A[ %d ]: ",(i+1) );
          scanf("%d",&A[i]);

          // taking input from user and storing it in an array B
          printf("Enter B[ %d ]: ",(i+1) );
          scanf("%d",&B[i]);
     }

     /*
        taking element from array A and Array B and storing
        it in an array C here we use k as counter
     */

     for (i = 0; i <= N - 1; i++)
     {
         C[ k ] = A[ i ];  // store A[ i ] on C[ i ]

         C[k + 1] = B[i];   // store B[ i ] on C[ i +1 ]

         /*
          increment the k by 2  k = k+ 2; so we can skip those two
          index in Array C which already been stored in them A[i] and B[i]
         */

         k = k + 2;
     }

    printf("--------------------------------------\n");

    printf("Element in Array A  Are : \n");

     // printing elements of an array A
     for (i = 0; i <= N - 1; i++)
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

    printf("--------------------------------------\n");

    printf("Element in Array C  Are : \n");

     // printing elements of an array A
     for (i = 0; i <= (N * 2 - 1); i++)
     {
         printf("C[ %d ] :  %d\n", i + 1 ,C[i]);
     }

  return 0;// signal to operating system everything works fine

}/** End of main function */
