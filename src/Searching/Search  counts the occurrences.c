/**
       Count occurrences of a number in a sorted array with
       duplicates using Binary Search

   [AUTHOR] :  Saddam Arbaa
   [Email]  :  <saddamarbaas@gmail.com>

   Given a sorted array vector[] and a number key,write a function
   that counts the occurrences of key in arr[](Frequency of a Number in a Sorted Array)
   Expected time complexity is O(Logn)  */

#include <stdio.h>
#include <stdlib.h>

//  Function to Count occurrences of a number in a sorted
//  array with duplicates using Binary Search
int modified_Binary_Search(int [], int , int , int );

//  Function to Count occurrences of a number in a sorted
//  array with duplicates using Linear_Search
int Linear_Search(int [], int, int );

// the  Driver Code
int main()
{
    printf("Count Occurrences/Frequency of a Number in a Sorted Array:\n");

    //  declare variables
    int key, first_Occurrence, last_Occurrence, count, n ;

    // Sorted Array Vector (for binary search Array have to be sorted first)
    int vector[] = {1,1,1,2,3,4,5,5,6,7,8,8,8,8,9,10,10,10,10,11,12,13,14,15,16,18,19,20};

    // calculate size of array
    n = sizeof(vector)/(sizeof(int));

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

    // find the first Occurrence
    first_Occurrence = modified_Binary_Search(vector,n,key,1);
    // find the last Occurrence
    last_Occurrence = modified_Binary_Search(vector,n,key,0);

    // calculate count number of occurrences from BST function
    count = last_Occurrence - first_Occurrence + 1;

    //print the result
    printf("the result from Binary Search function ");
    if(first_Occurrence == -1)
    {
        printf("\nthe count occurrences of number %d   is =  %d\n",key,0);
    }
    else
    {
        printf("\nthe count occurrences of number %d   is =  %d\n\n",key,count);
    }

    // calculate count number of occurrences from BST function
    count = Linear_Search(vector, n, key);

    //print the result from Linear_Search function
    printf("the result from Linear Search function\n");
    printf("the count occurrences of number %d   is =  %d\n",key,count);

    return 0;// signal to operating system everything works fine

}/** End of main function */


 /**
     Function to Count occurrences of a number in a sorted
     array with duplicates using Binary Search

	  the function take 4 parameters
	  (1) array vector[]
	  (2) target element named key
	  (3) size of array N
	  (4) flag variable (flag_Search_First)

    the idea is to modify binary function in such way that as soon
    it found the target key will not return  but continue search for
    first occurrence and last occurrence Depending on flag variable
    if flag is one(true) then find first occurrence and if user pass
    flag equal to zero(false) find last occurrence

   after that(numbers of occurrences will be first occurrence - last occurrence + 1)

        flowing are the steps

      (1) create and initialize the result variable by -1
      (2)  Compare given key (key) with the middle element.
      (3)  If key is equal to value at middle element index,
           update the result by mid index.
            and check if flag variable is true
             go on searching towards left for  first occurrence
             else if flag variable is false
             go on searching towards the right for last occurrence
      (4)  Else If key is greater than the mid element,
           then key can only lie in right half subarray after the mid element. So we recur for right half.
      (5)  Else (key is smaller)search in the left.
      (6)  at last after for loop return the result */


int modified_Binary_Search(int vector[], int N, int key, int flag_Search_First)
{
    // declare 3 variable
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
        first update the result and go on searching towards the
        ]left or  right  Depending on flag variable */

        if(key == vector[mid])
        {
            result = mid;   /* update the result first */
            // if so
            if(flag_Search_First == 1)
            {
                high = mid - 1;// go on  and searching towards the left
            }
            else
            {
                low = mid + 1;; // go on  and searching towards right
            }
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

   }/** modified_Binary_Search() */


/**
    Function to search Linear Search  and Count occurrences
    of a number in a sorted array with duplicates

     the function take 3 parameters
    (1) array vector[]
    (2) target element named key
    (3) size of array N

    the idea is to scan whole array and Count occurrences of a number
    in each time number is been found  however this is not the efficient
    as give us time complexity O(n) because the array is sorted the efficient
    way is to use binary search in time complexity O log(n) but let try first
    after that we go for BST*/

int Linear_Search(int vector[], int n, int key)
{
    int count = 0;
    //underflow condition if array is empty
     if (n == 0)
     {
         printf("Array is empty!\n");
         exit(0);
     }
     // search until size -1
     for (int i = 0; i <= n - 1; i++)
     {
         // if so increment the count by one
         if (vector[i] == key)
         {
             count += 1; // count = count + 1
             //as array is sorted we can add condition blow

             if(vector[i] > key) break; // still O(n)
         }

     }/** End of for loop */

    return count; // return count to where is been called

    /** Time Complexity : O(n)  */

}/** End of Linear_Search() */

