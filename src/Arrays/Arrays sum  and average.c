/**
    [AUTHOR]: Saddam Arbaa

    [Email] : <saddamarbaas@gmail.com>

   C Arrays Examples
   Program to take array size from user and create array with
   the size given by user and ask user to enter all the array
   element and store them in an array.
   Print the elements stored in the array(size must be bigger than 0)
   find the  sum and average of n numbers which entered by user
   print the sum and  and average */

#include <stdio.h>
#include <stdlib.h>

/* function to Valid size for array */
int get_Valid_Size(int);

int main() // the  Driver Code
{
    int N; // size of the array
    float sum = 0.0; // variables  sum and average
    double  average;

    /* get valid size first  */
    N = get_Valid_Size('V');   /* call get_Valid_Size() */

    int vector [N]; // Array declaration

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

    average = (double)sum/(double)N;  // calculation average

    printf(" -----------------\n");

    printf("Elements in array are : \n");

    // printing elements of an array
    for (int i = 0; i <= N - 1; i++)
          printf("vector[ %d ] :  %d\n", i +1 ,vector[i]);

    // printing the average and sum
    printf("\n Sum of all numbers =  %.2f\n", sum);

    printf("\n Average of all input numbers =  %.2f\n",average);

    return 0;// signal to operating system everything works fine

} /** End of main function */


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
        printf("Enter size for Array : size must be bigger than zero : ");
        scanf("%d", &size);
    } while(size <= 0);

    /* if its reach this line already got the valid size just return */
    return size;

 } /** END of get_Valid_Size */
