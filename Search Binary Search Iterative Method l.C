
/**
       Binary Search Iterative Method loop approach

   [AUTHOR] :  Saddam Arbaa
   [Email]  :  <saddamarbaas@gmail.com>

     C program accept an array of N elements and a key to search.
      then search for the key in array If the search is successful,
      it displays "SUCCESSFUL SEARCH and print the index of key ".
      if the key is not found print "UNSUCCESSFUL SEARCH"
  */



#include <stdio.h>

#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 25

// the  Driver Code
int main()
{
    printf("Binary Search Iterative Method implementation loop approach :\n\n");

   // array declaration
    int array[MAXSIZE];

    // variables declaration
    int i, low, mid, high, key, size;

    // get valid size first
    do
    {
        // asking  the length of array from user
        printf("Enter the size of an array :\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d", &size);
    } while(size <= 0 || size > MAXSIZE);

     // traverse Array and insert All the values at once
     printf("Enter the array elements in sorted order :\n");
     // taking input from user and storing it in an array
     for (i = 0; i < size; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.
          printf("Enter Array[ %d ]: ",(i+1));
          scanf("%d", &array[i]);

     } /** End of for loop */



    // ask user to enter value to be search and store in key
    printf("Enter the key to be search : ");
    scanf("%d",&key);

    /** searching process begins from here */
    low = 0;
    high =(size - 1);

    // iterate till search base case (low <= high)
    while(low <= high)
    {
        // calculate mid index
        mid = (low + high)/2; //(low + high) may lead to overflow condition

        // to avoid integer overflow is better to use on of this conditions flowing blow
		//  mid = low + (high - low)/2;
		//mid = high - (high - low)/2;

         /*
           Check if the key is present at mid if so then key is found
           just return the index in which the key is been found and
           we are done */
        if (key == array[mid])  // base case also
        {
            printf("SUCCESSFUL SEARCH %d IS FOUND AT INDEX : %d\n",key,(mid + 1));

            return 0;// signal to operating system everything
                     // works fine and search was successful
        }

        // if key is smaller than mid then discard all elements
        // in the right search space including the mid element
        else if(key < array[mid])
        {
            // search in left
            high = mid - 1;
        }
        // if key is bigger than mid then discard all elements
        //  in the left search space including the mid element
        else
        {
            //search in right
            low = mid + 1;
        }

    }/** End of while loop */

      /*
       if reach this line that mean all the array been searched
       and the key is not found */
       printf("UNSUCCESSFUL SEARCH %d IS NOT FOUND\n",key);

      return 0;// signal to operating system everything works fine

}/** End of main function */
