/**
[AUTHOR]: Saddam Arbaa
[Email] : <saddamarbaas@gmail.com>

   C Arrays Examples
   Program to take array size from user and create array with
   the size given by user and then ask user to enter all the array
   element and store them in an array.
   the lastly do the flowing
   (1) Print all the  element in array
   (2) change all the number bigger than zero to one and all the smaller than zero to -1
   (3) Print all the element in array again
   the array(size must be bigger than 0)
*/


#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    // size of the array and counter i
    int N ,i;

    // get valid size first
    do
    {
        // asking the length of array from user
        printf("Enter number of elements(size must be bigger than zero): ");
        scanf("%d",&N);

    } while (N <= 0);

    // Array declaration
    int vector [N];

    printf("-----------------\n");

    printf("Enter %d numbers: \n",N);

     // taking input from user and storing it in an array
     for (i = 0; i <= N - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.

          printf("Enter vector[ %d ]: ",(i+1) );
          scanf("%d",&vector[i]);
     }

    printf("-------------------------\n");

    printf("element in Array are : \n");

     // printing elements of an array
     for (i = 0; i <= N - 1; i++)
     {
         printf("vector[ %d ] :  %d\n", i +1 ,vector[i]);
     }

     // change number bigger than zero to 1 and smaller to -1
     for (i = 0; i <= N - 1; i++)
     {
          if (vector[i] > 0)
          {
             vector[i] = 1; //change to 1
          }
          else if (vector[i] < 0)
          {
              vector[i] = -1; //change to -1
          }
     }

    printf("---------------------------\n");
    printf("element in Array are: \n");

     // printing elements of an array again
     for (i = 0; i <= N - 1; i++)
     {
         printf("vector[ %d ] :  %d\n", i +1 ,vector[i]);
     }

    return 0;// signal to operating system everything works fine

}/** End of main function */
