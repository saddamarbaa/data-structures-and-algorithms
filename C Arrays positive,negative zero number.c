/**
[AUTHOR]: Saddam Arbaa
[Email] : <saddamarbaas@gmail.com>

   C Arrays Examples
   Program to take array size from user and create array with
   the size given by user and ask user to enter all the array
   element and store them in an array.
   the lastly
   Print the  number of element bigger than zero (positive number)
   Print the  number of element bigger smaller than zero(negative number)
   Print the  number of element equal to zero
   the array(size must be bigger than 0)
*/

#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    // size of the array N and counter i
    int N ,i;

     /* I need 3 variables  one to store  numbers of positive number
        one to store numbers of negative number  and one to store
        zero numbers  */

      int positive_number = 0;
      int negative_number = 0;
      int zero_numbers    = 0;

    // get valid size first
    do
    {
        // asking the length of array from user
        printf("Enter number of elements(size must be bigger than zero): ");
        scanf("%d",&N);
    } while (N <= 0);

    // Array declaration
    int vector [N];

    printf("-----------------------------\n");

     printf("Enter %d numbers: \n",N);

     // taking input from user and storing it in an array
     for (i = 0; i <= N - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.

          printf("Enter vector[ %d ]: ",(i+1) );
          scanf("%d",&vector[i]);

          if (vector[i] > 0)
          {
              positive_number++;// update positive numbers
          }
          else if (vector[i] < 0)
          {
              negative_number++;  // update negative_number
          }
          else
          {
              zero_numbers++; // update zero_numbers
          }

     }

    printf("--------------------------\n");

    printf("element in Array are: \n");

     // printing elements of an array
     for (i = 0; i <= N - 1; i++)
     {
         printf("vector[ %d ] :  %d\n", i +1 ,vector[i]);
     }

     // printing the number of positive numbers
     printf("\nThe number of positive numbers is : %d \n", positive_number);

     // printing the number of negative numbers
     printf("The number of negative numbers is :  %d \n", negative_number);

     // printing the number zero negative numbers
     printf("The number of zero numbers is:   %d \n", zero_numbers);

    return 0;// signal to operating system everything works fine

}/** End of main function */
