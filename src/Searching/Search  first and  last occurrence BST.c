/**
       Binary Search Iterative Method


   [AUTHOR] :  Saddam Arbaa
   [Email]  :  <saddamarbaas@gmail.com>

  C program to find the first and the last occurrence of a given
  number in sorted array of integers  using Binary Search  */

#include <stdio.h>
#include <stdlib.h>

//  Function to find first occurrence of a given number
// in sorted array of integers
int findFirstOccurrence(int vector[], int N, int key);

//  Function to find last occurrence of a given number
// in sorted array of integers
int findLastOccurrence(int vector[], int N, int key);

// the  Driver Code
int main()
{
    printf("Binary search - find first oand last occurrence of a number :\n");
    // key to be search
    int key;

    // Sorted Array Vector (for binary search Array have to be sorted first)
    int vector[] = {1,1,1,2,3,4,5,6,7,8,8,8,8,9,10,11,12,13,14,15,16,18,19,20};

    // calculate size of array
    int n = sizeof(vector)/(sizeof(int));

    // printing the size of array
    printf("the size of Vector[] is %d\n",n);

    printf("Vector contain the flowing values  : \n");
     // printing elements of an array
     for (int i = 0; i <= n - 1; i++)
     {
         printf("%d\t",vector[i]);
     }

     // asking user to input element for searching
     printf("\nEnter key to be search : ");
     scanf("%d",&key);

    // call findFirstOccurrence() function
    int first_Occurrence = findFirstOccurrence(vector,n,key);
    if(first_Occurrence == -1)
    {
        printf("\n%d is not found!\n",key);
    }
    else
    {
        printf("\nThe first occurrence of number %d  is found at index %d\n",key, first_Occurrence + 1);
    }

    // call findLastOccurrence() function
    int last_Occurrence = findLastOccurrence(vector,n,key);
    if(last_Occurrence == -1)
    {
        printf("\n%d is not found!\n",key);
    }
    else
    {
        printf("\nThe last occurrence of number %d  is found at index %d\n",key, last_Occurrence + 1);
    }

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
 Iterative implementation of Binary Search Algorithm to find first
 occurrence of a given number in sorted array of integers

	  the function take 3 parameters
	  (1) array vector[]
	  (2) target element named key
	  (3) size of array N

    the idea is to modify binary function in such way that as soon
    it found the target key will not return  but continue search
    in left space for first
     occurrence

         flowing are the steps

      (1) create and initialize the result varaible by -1
      (2)  Compare given key (key) with the middle element.
      (3)  If key is equal to value at middle element index,
           update the result by mid index. and go on searching towards left
      (4)  Else If key is greater than the mid element,
           then key can only lie in right half subarray after the mid element. So we recur for right half.
      (5)  Else (key is smaller)search in the left.  */


int findFirstOccurrence(int vector[], int N, int key)
{
    // declare 4 variable
    int low, high, mid;
    low  = 0;
    high = N - 1 ;

    /*  initialize the result by -1 for now
        at the end of loop return the result to main function
        if result still -1 mean the key is not found at all */
	int result = -1;

    // iterate till search base case (low <= high)
    do
    {
        // calculate mid index
        mid = (low + high)/2; //(low + high) may lead to overflow condition

        // to avoid integer overflow is better to use on of this conditions flowing blow
		//  mid = low + (high - low)/2;
		// mid = high - (high - low)/2;

        /*
        Check if the target key is present at mid if so then key is found
        but we are not done
        first update the result and go on searching towards left
        for first occurrence of a number(first duplicate)
        which could be only in left side if its there */
        if(key == vector[mid])
        {
            result = mid;  /* update the result */

            high = mid - 1; // go on searching towards left
        }

        /*
          if reach this line mean is not found  at mid let
          check if the key smaller or bigger than mind */

        // if key is smaller than mid then discard all elements
        // in the right search space including the mid element
        else if(key < vector[mid])
        {
            high = mid - 1; // search in left
        }
        // if key is bigger than mid then discard all elements
        //  in the left search space including the mid element
        else
        {
            low = mid + 1; //search in right
        }

     // iterate till search base case (low <= high)
    }while(low <= high);
    /** End of while loop */

    /*
     if we reach this line that we already have the final
     result in result variable let just return it to user */
     return result;

       /** Time Complexity : log(n)  */

   }/** End of findFirstOccurrence() */



 /**
  Function to find last occurrence of a given number in sorted array of integers
  using Binary Search Algorithm

	  the function take 3 parameters
	  (1) array vector[]
	  (2) target element named key
	  (3) size of array N

    the idea is to modify binary function in such way that as soon
    it found the target key will not return  but continue search
    in right space for last occurrence

         flowing are the steps

      (1) create and initialize the result varaible by -1
      (2)  Compare given key (key) with the middle element.
      (3)  If key is equal to value at middle element index,
           update the result by mid index. and go on searching towards right
      (4)  Else If key is greater than the mid element,
           then key can only lie in right half subarray after the mid element. So we recur for right half.
      (5)  Else (key is smaller)search in the left.  */


int findLastOccurrence(int vector[], int N, int key)
{
    // declare 4 variable
    int low, high, mid;
    low = 0;
    high = N - 1 ;

    /*  initialize the result by -1 for now
        at the end of loop return the result to main function
        if result still -1 mean the key is not found at all */
	int result = -1;

    // iterate till search base case (low <= high)
    do
    {
        // calculate mid index
        mid = (low + high)/2; //(low + high) may lead to overflow condition

        // to avoid integer overflow is better to use on of this conditions flowing blow
		//  mid = low + (high - low)/2;
		//mid = high - (high - low)/2;

        /*
        Check if the target key is present at mid if so then key is found
        but we are not done
        first update the result and go on searching towards the right
        for last occurrence of a number(last duplicate)
        which could be only in right side if its there */
        if(key == vector[mid])
        {
            result = mid;   /* update the result */
            low = mid + 1;; // go on  and searching towards right
        }


        /*
          if reach this line mean is not found  at mid let
          check if the key smaller or bigger than mind */

        // if key is smaller than mid then discard all elements
        // in the right search space including the mid element
        else if(key < vector[mid])
        {
            high = mid - 1;  // search in left
        }
        // if key is bigger than mid then discard all elements
        //  in the left search space including the mid element
        else
        {
            low = mid + 1; //search in right
        }

     // iterate till search base case (low <= high)
    }while(low <= high);
    /** End of do while loop */

    /*
     if we reach this line that we already have the final
     result in result variable let just return it to user */
     return result;

       /** Time Complexity : log(n)  */

   }/** End of findLastOccurrence() */

