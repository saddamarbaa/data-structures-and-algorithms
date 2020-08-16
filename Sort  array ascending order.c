/** 
[AUTHOR]: Saddam Arbaa
[Email] : <saddamarbaas@gmail.com> 

   C Arrays Examples
   write Program that take array size from user and create array with
   the size given by user and ask user to enter all the array
   element and store them in an array.
   the lastly
   (1)Print all the element of array before sorting
   (2) sort array from smaller to bigger
   (1)Print all the element of array after sorting

   (the array(size must be bigger than 0)

*/

#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    // N size of the array , i,j are counters
    // temp for swapping element in sorting process
    int N , temp ,i,j;

     // get valid size first
    do
    {
        // asking the length of array from user
        printf("Enter number of elements(size must be bigger than zero): ");
        scanf("%d",&N);

    } while (N <= 0);

    // Array declaration
    int vector [N];

    printf("------------------------------\n");
    printf("Enter %d numbers: \n",N);

     // taking input from user and storing it in an array
     for (i = 0; i <= N - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.

          printf("Enter vector[ %d ]: ",(i+1) );
          scanf("%d",&vector[i]);
     }

    printf("---------------------------\n");
    printf("element of Array Before arrangement are : \n");

     // printing elements of an array before sorting
     for (i = 0; i <= N - 1; i++)
     {
         printf("vector[ %d ] :  %d\n", i +1 ,vector[i]);
     }

      // sorting the array
      // outer loop
     for ( i = 0; i <= N - 1; i++)
     {
         // inner loop
         for (j = i + 1; j <= N - 1; j++)
         {
             // if condition true
             if(vector[i] > vector[j])
             {
                temp = vector[i];  // keep vector[i] in temp

               // swap between vector[j] and vector[i]
                vector[i] = vector[j]; // store vector[j] on vector[i]

                vector[j] = temp; // store vector[i] on vector[j]
             }
         }
     }

    printf("element of Array after arrangement are : \n");

     // printing elements of an array after sorting
     for (i = 0; i <= N - 1; i++)
     {
         printf("vector[ %d ] :  %d\n", i +1 ,vector[i]);
     }
   
   return 0;// signal to operating system everything works fine

}/** End of main function */
