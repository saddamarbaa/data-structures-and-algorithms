/**
    [AUTHOR]: Saddam Arbaa

    [Email] : <saddamarbaas@gmail.com>

   C Arrays Examples
   Program to take array size from user and create array with
   the size given by user and ask user to enter all the array
   element and store them in an array.
   Print the elements stored in the array(size must be bigger than 0)
   find the  sum and average of n numbers which entered by user
   print the sum and  and average
*/

#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    // size of the array
    int N;

    // variables  sum and average
    float sum = 0.0;
    double  average;

    // get valid size first
    do
    {
        // asking the length of array from user
        printf("Enter number of elements(size must be bigger than zero): ");

        scanf("%d",&N);

    } while (N <= 0);

    // Array declaration
    int vector [N];

    printf("-----------------------------------------\n");
    printf("Enter the elements one by one %d numbers \n",N);

     // taking input from user and storing it in an array
     for (int i = 0; i <= N - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.

          printf("Enter vector[ %d ]: ",(i+1) );
          scanf("%d",&vector[i]);

          /*  Summation starts */
          // adding number entered by the user to the sum variable
          sum += vector[i]; /*this means sum = sum + vector[i] */
           printf("\nsum   = %.1f \n", sum);
     }

     // calculation average
     average = (double)sum/(double)N;

    printf(" -----------------\n");

    printf("Elements in array are : \n");

     // printing elements of an array
     for (int i = 0; i <= N - 1; i++)
     {
         printf("vector[ %d ] :  %d\n", i +1 ,vector[i]);
     }

     // printing the average and sum
    printf("\n Sum of all numbers =  %.2f\n", sum);

    printf("\n Average of all input numbers =  %.2f\n",average);

    return 0;// signal to operating system everything works fine
}
