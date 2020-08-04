/**
[AUTHOR]: Saddam Arbaa
[Email] : <saddamarbaas@gmail.com>

   C Arrays Examples
   Program to take array size from user and create array with
   the size given user and ask user to enter all the array
   element and store them in an array and lastly Print the
   elements stored in the array(size must be bigger than 0)
*/


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

    printf("---------------------------------\n");

     printf("Enter %d integers: \n",N);

     // taking input from user and storing it in an array
     for (i = 0; i <= N - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.

          printf("Enter vector[ %d ]: ",(i+1) );
          scanf("%d",&vector[i]);
     }

    printf("--------------------------------\n");

    printf("Displaying integers: \n");

     // printing elements of an array
     for (i = 0; i <= N - 1; i++)
     {
         printf("vector[ %d ] :  %d\n", i +1 ,vector[i]);

     }

   return 0;// signal to operating system everything works fine

}/** End of main function */
