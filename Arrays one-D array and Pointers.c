/**
[AUTHOR]: Saddam Arbaa
[Email] : <saddamarbaas@gmail.com>

   C Arrays and Pointers Examples
  Examples show different idea Relationship Between
  Arrays and Pointers */


#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    //  N size of the array and counter i
    int N ,i;

    // get valid size first
    do
    {
        // asking the length of array from user
        printf("Enter the length of the vector(size must be bigger than zero): ");
        scanf("%d",&N);

    } while (N <= 0);

    // Array declaration
    int vector [N];

    // Pointer to an integer
    int *p;

    // Pointer to an array of N integers
    int (*ptr)[N];

    // Points to 0th element of the array vector
    p = vector;

    // Points to 0th element of the array vector
    int *q = vector;

    // both give same address
    //printf("%p\t%p\t",p,vector );

    printf("-----------------------------------\n");

    printf("Enter %d number for vector Array: \n",N);

     // taking input from user and storing it in an array
     for (i = 0; i <= N - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.
          // all blow give same result
          //printf("Enter vector[ %d ]: ",(i+1) );
          //scanf("%d",&vector[i]);

           //printf("Enter vector[ %d ]: ",(i+1) );
           //scanf("%d",(q+i) );

          printf("Enter vector[ %d ]: ",(i+1) );
          scanf("%d",&vector[i]);
     }

    printf("-----------------------------------\n");

    printf("Displaying value in vector Array: \n");

     // printing elements of an array
     for (i = 0; i <= N - 1; i++)
     {
         // all blow give same result
         //printf("vector[ %d ] :  %d\n", i +1 ,vector[i]);

         printf("vector[ %d ] :  %d\n", i +1 ,( *q + i));
        // *q + i  = vector[i]

     }
     // Array of 5 integer
     int array[5] = {10, 20, 30, 40, 50};

     // Pointer to an integer
     int * ptrr;

     // ptr is assigned the address of the third element
      ptrr = & array[3];
      printf("\n*ptrr = %d \n",*ptrr);// 40
      printf("\n*(ptrr + 1) = %d \n",*(ptrr + 1 ));// 50
      printf("\n*(ptrr - 1) = %d \n",*(ptrr - 1));// 30

     return 0;// signal to operating system everything works fine

}/** End of main function */
