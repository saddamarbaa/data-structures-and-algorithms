/** 
       Binary Search Iterative Method loop approach

   [AUTHOR] :  Saddam Arbaa

   [Email]  :  <saddamarbaas@gmail.com>

     C program accept an array of N elements and sorted in ascending
     order using Bubble sort after that search for a given number using
     Binary Search.If the search is successful,
      it displays "SUCCESSFUL SEARCH and print the index of key ".
      if the key is not found print "UNSUCCESSFUL SEARCH"
  */


#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 25
void swap(int *a, int *b);
// the  Driver Code
int main()
{
    printf("This is a C Program to implement Binary Search Algorithm. :\n\n");

   // array declaration
    int array[MAXSIZE];

    // variables declaration
    int i, j, size, key;

    int low, mid, high;

    // get valid size first
    do
    {
        // asking  the length of array from user
        printf("Enter the size of an array :\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d", &size);
    } while(size <= 0 || size > MAXSIZE);

     // traverse Array and insert All the values at once
      printf("Enter the elements one by one \n");
     // taking input from user and storing it in an array
     for (i = 0; i < size; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.
          printf("Enter Array[ %d ]: ",(i+1));
          scanf("%d", &array[i]);

     } /** End of for loop */

     // traverse Array and print the element
     printf("Array before sort :\n");
     for (i = 0; i < size; i++)
     {
         printf("%d\t",array[i]);

     } /** End of for loop */

     /** Bubble sorting begins */

     // Swapped to keeps track of swapping
    int swapped;

    // run two  loops  : one for walking through the array
    // and the other for comparison
    for (i = 0; i < size - 1; i++)
    {
        swapped = 0;
        //inner loop for comparison
        for (j = 0; j < (size - i - 1); j++)
        {
            // if so swap them for that call swap() function
            // To sort in descending order, change">" to "<".
            if (array[j] > array[j + 1])
            {
                //call swap function and pass addresses
                swap(&array[j], &array[j + 1]);
                // there is swapping happened in this iteration
                swapped = 1;
            }
        }/** End of inner loop */

    /* If there is not swapping in the last swap,
    then the array is already sorted. */
    if (swapped == 0) //if(!swapped)
      break;

    }/** End outer loop */

    printf("\nArray is been sorted in ascending order\n");

     // traverse Array and print the element after been sort
     for (i = 0; i < size; i++)
     {
         printf("%d\t",array[i]);

     } /** End of for loop */

    /** Binary  searching process begins from here */

    // ask user to enter value to be search and store in key
    printf("\nEnter the key to be search : ");
    scanf("%d",&key);
    low = 0;
    high =(size - 1);

    // iterate till  base case (low <= high)
    do
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

    } while(low <= high); /** End of do while loop */

      /*
       if reach this line that mean all the array been searched
       and the key is not found */
       printf("UNSUCCESSFUL SEARCH %d IS NOT FOUND\n",key);

      return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to swap values of two variables
 (user should pass address of two as parameter)*/

void swap(int *a, int *b)
{
    // declare temp variable
    int temp;
    // store in temp value of a
    temp = *a;
    // store in a value of b
    *a = *b;
    // store in b value of a(we have value of variable a stored in temp)
    *b = temp;

    // swap is done
}/** End of swap () */
