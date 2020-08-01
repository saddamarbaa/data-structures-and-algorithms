
/**
    Binary Search Iterative Method

   [AUTHOR] :  Saddam Arbaa

   [Email]  :  <saddamarbaas@gmail.com>

    Iterative implementation of Binary Search using  C  */

#include <stdio.h>

#include <stdlib.h>

int main()
{
    printf("Binary Search implementation Iterative Method :\n");
    // key to be search
    int key;

    // Sorted Array Vector (for binary search Array have to be sorted first)
    int vector[20] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

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

    //call Binary_Search_Iterative_Method() function
    int index = Binary_Search_Iterative_Method(vector,n,key);
    if(index == -1)
    {
        printf("\n%d is not found!\n",key);
    }
    else
    {
        printf("\n%d is found at index %d\n",key, index);
    }

    return 0;// signal to operating system everything works fine

}/** End of main function */

/**
      Iterative implementation of Binary Search Algorithm to return
	  the index of target Key in the sorted array vector of size N
	  the function take 3 parameters
	  (1) array vector[]
	  (2) target element named key
	  (3) size of array N
	  if the key been found in array return the index of the key in vector array
	  if is not found  then return -1 indicate the given key is not present in the Vector array

         flowing are the steps

      (1)  Compare given key (key) with the middle element.
      (2)  If key is equal to value at middle element index, we return the mid index.
      (3)  Else If key is greater than the mid element,
           then key can only lie in right half subarray after the mid element. So we recur for right half.
      (4)  Else (key is smaller)search in the left.

*/

int Binary_Search_Iterative_Method(int vector[], int N, int key)
{
    // declare 3 variable
    int low, high, mid;
    low = 0;
    high = N - 1 ;
    // iterate till search base case (low <= high)
    while(low <= high)
    {
        // calculate mid index
        mid = (low + high)/2; //(low + high) may lead to overflow cindition
        int mid = (low + high)/2;

        // to avoid integer overflow is better to use on of this conditions flowing blow
		//  mid = low + (high - low)/2;
		//mid = high - (high - low)/2;

         /*
           Check if the key is present at mid if so then key is found
           just return the index in which the key is been found and
           we are done */
        if(key == vector[mid]) // base case also
        {
            // return the index
            return mid;
        }

        /*
          if reach this line mean is not found  at mid let
          check if the key smaller or bigger than mind */

        // if key is smaller than mid then discard all elements
        // in the right search space including the mid element
        else if(key < vector[mid])
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
       if reach this line mean been searching until low variable
        become bigger than high varaible and condition become true
        so let just return -1 mean that the key is not found */

       return -1;//key is not found in the array


    /**
       Time Complexity:
       from the above steps, binary search algorithm break the break
       into half in each iteration.So,in the average and worst case
       there  is log(n) comparison ,the time complexity is log(n)
       and in the best case there  is only one comparison O(1)

       so all in all Time Complexity of binary
       search algorithm is Big O of log(n)        */

   }/** End of Binary_Search_Iterative_Method() */
