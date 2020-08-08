/**
        Search for element in a circular sorted array

   [AUTHOR] :  Saddam Arbaa
   [Email]  :  <saddamarbaas@gmail.com>

    Search for element in a circular sorted array
    using Binary Search */

#include <stdio.h>
#include <stdlib.h>

// Modified BST Searching for element in a circular sorted array
int Circular_Array_Search(int vector[], int N, int key);

// the  Driver Code
int main()
{
    // key to be search
    int key;

    // a curricular sorted array
    int vector[] = {15, 22, 23, 28, 31, 38, 5, 6, 8, 10, 12};
    // calculate size of array
    int n = sizeof(vector)/(sizeof(int));

    printf("Vector contain the flowing values  : \n");
     // printing elements of an array
     for (int i = 0; i <= n - 1; i++)
     {
         printf("%d\t",vector[i]);
     }

     // asking user to input element for searching
     printf("\nEnter key to be search : ");
     scanf("%d",&key);

    // call Circular_Array_Search() function
    int index = Circular_Array_Search(vector,n,key);
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
  function to Search element in a circular sorted array

  as we know array is sorted  we use Binary search
  and  Modify little bit */


int Circular_Array_Search(int vector[], int N, int key)
{
    //declare variables
    int low, high, mid;
    low = 0;   // set low at first index
    high = N - 1; // set high at last index

    // iterate till base case (low <= high)
    do
    {
        // calculate mid index
        mid = (low + high) / 2; //(low + high) may lead to overflow condition

        //  to avoid integer overflow is better to use on of this conditions flowing blow
		//  mid = low + (high - low)/2;
		//  mid = high - (high - low)/2;


         /*
         Check if the key is present at mid if so then key is found
         just return the index in which the key is been found and
         we are done */

        /*  case 1 found the key at mid we are done*/
        if(key == vector[mid])
        {
            return mid;   // return the index
        }

        /*
        if we reach this line mean is key is not found
        at mid but we can't divided  the array into 2 directly
        because is circular sorted so let check first which side
        is sorted and where the pivot is and Depend on that we
        search left or right */

        // case 2 Right half is sorted
        else if(vector[mid] <= vector[high])
        {
            //we have 2 sub cases

            // case 2.1 if is really sorted
            if(key > vector[mid] && key <= vector[high])
            {
                low = mid + 1;  // go and search in right sorted half
            }
            else // case 2.2 if was not sorted
            {
                high = mid - 1;  // go and search in left array
            }
        } /** End of case 2 */

        // case 3 left half is sorted
        else if(vector[low] <= vector[mid])
        {
            //we have 2 sub cases also

            // case 3.1 if is really sorted
            if(key >= vector[low] && key < vector[mid])
            {
                 high = mid - 1;  // go and search in the left sorted half
            }
            else // case 3.2 if was not sorted
            {
                low = mid + 1;  // go and search in right half
            }
        }

    }while(low <= high);/** End of do while loop */

      /*
       if reach this line mean it been searching until low
        become bigger than high  and condition become true
        but the key is not found
        so let just return -1 to indicate key is not found */

       return -1;

     /**  Time Complexity: is Big O of log(n)  */

   /*
    for this function to work the array have to be sorted
    or circularly sorted and have no duplicate element */

}/** Circular_Array_Search() */


