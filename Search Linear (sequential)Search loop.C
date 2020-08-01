/**
   [PROG]   : Linear Search Algorithm with example( loop approach)

   [AUTHOR] :  Saddam Arbaa

   [Email]  :  <saddamarbaas@gmail.com>

    Linear Search(sequential search) Algorithm implementation using  C */

#include <stdio.h>

#include <stdlib.h>

int MAXSIZE = 10; // maximum Array size

// the  Driver Code
int main()
{
     printf("Linear Search implementation loop Method :\n\n");

    // key to store the key element and index for index of
    // the key in array and size for array size(will be entered by user)
    int key = 0, index, size ;

    // Array declaration
    int vector[MAXSIZE];

    // get valid size first
    do
    {
        // asking  the length of array from user
        printf("Enter the length of the vector :\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d",&size);

    } while(size <= 0 || size > MAXSIZE);

    // traverse Array and insert All the values at once
    printf("----------------\n");
    printf("Enter %d values : \n",size);

     // taking input from user and storing it in an array
     for (int i = 0; i <= size - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.
          printf("Enter vector[ %d ]: ",(i+1));
          scanf("%d",&vector[i]);

     } /** End of for loop */

    // traverse Array and print All values
     printf("Elements in Array are :\n");
     for (int i = 0; i <= size - 1; i++)
     {
         // printing elements of an array
         printf(" %d\t", vector[i]);
        // printf("vector[ %d ] :  %d\n", i + 1, vector[i]);
    } /** End of for loop */
   printf("\n");

    // ask user to enter value to be search and store in key
    printf("Enter a value to be search : ");
    scanf("%d",&key);

    /*
     I use flag variable and give value zero after search for given
     key if flag value is still 0 then mean number is not found else
    if flag value is change to 1 then number is found */

     int flag = 0;

    /*
      for loop start from zero index until size - 1 index
      in array compare if the value of index[i] is equal to given
      key to search as soon we we have the key change flag
      variable to 1 and break(out from loop) */

     for (int i = 0; i <= size - 1; i++)
     {
         if (vector[i] == key)
         {
             flag = 1; // change flag to one and break
             // inform the user the key is found
             printf("Yes %d is found at index : %d\n",key, i + 1);
             break; // we are done no need to continue
         }
     }/** End of for loop */

     // if reach this line and flag still zero key is not found
    if(flag == 0)
    // inform the user the key is not found
    printf("NO %d is not found!\n",key);

  return 0;// signal to operating system everything works fine

}/** End of main function */
