/**
       Binary Search Recursive Method

   [AUTHOR] :  Saddam Arbaa
   [Email]  :  <saddamarbaas@gmail.com>

    Recursive implementation of Binary Search using  C  */

#include <stdio.h>
#include <stdlib.h>

// Recursive implementation of Binary Search
int Binary_Search_Recursive_Method(int vector[],int low, int high, int key);

int main()
{
    printf("Binary Search implementation Recursive Method :\n\n");

    //declare 4 variable key to be search,low,hight,size
    int key, low, high, size;

    // Sorted Array Vector (for binary search Array have to be sorted first)
    int vector[20] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

    // calculate size of array
    size = sizeof(vector)/(sizeof(int));
    low = 0;// start
    high = size - 1;//end

    // printing the size of the vector array
    printf("the size of Vector[] is %d\n",size);

    printf("Vector contain the flowing values  : \n");
     // printing elements of an array
     for (int i = 0; i <= size - 1; i++)
     {
         printf("%d\t",vector[i]);
     }

     // asking user to input element for searching
     printf("\nEnter key to be search : ");
     scanf("%d",&key);

    // call Binary_Search_Recursive_Method()function and pass
    // the Array vector,low,high,and key
    int index = Binary_Search_Recursive_Method(vector, low, high, key);

    // if calling function return -1 mean not found
    if(index == -1)
    {
        printf("\n%d is not found!\n",key);
    }
    else // if calling function return the index of the key element
         // in vector Array then inform user the element is found
    {
        printf("\n%d is found at index %d\n",key, index);
    }

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
      Recursive implementation of Binary Search Algorithm to return
	  the index of target Key in the sorted array vector of size N
	  the function take 3 parameters
	  (1) array vector[]
      (2) low (start index)
      (3) hight (size -1)
	  (3) target element named key

	  if the key been found in array return the index of the key in vector array
	  if is not found  then return -1 indicate the given key is not present in the Vector array

       flowing are the steps
      (1)  Compare given low(start index)with high(last index)
      (2)  If low is greater than high,we return -1.(first base case)
           to indicate key is not found
      (3)  Compare given key (key) with the middle element.
      (4)  If key is equal to value at middle element index, we return the mid index.
      (5)  Else If key is greater than the mid element
           then key can only lie in right half subarray after the mid element.
           so discard all elements in the left search space including the mid
           element and make Recursive call to search in right space
     (6)   Else(key is smaller) so discard all elements in the right search
           space including the mid element and make Recursive call to search in left space
    */


int Binary_Search_Recursive_Method(int vector[],int low, int high, int key)
{
    // declare mid variable
    int  mid;

    /*
    first base case when the key is not found return -1 indicate that
    the key is not found because we have searched recursively until
    low become bigger than the high and they is not found
    */
    if(low > high)
    {
        //key is not found
        return -1;// return -1 to place where is been called
    }

    // calculate mid index
    mid = (low + high)/2; //(low + high) may lead to overflow condition

    // to avoid integer overflow is better to use one of this conditions flowing blow
    //  mid = low + (high - low)/2;
    //  mid = high - (high - low)/2;

    /*
     Check if the key is present at mid index if so then key is found
     just return the index in which the key is been found and we are done */

    if(key == vector[mid]) //second base case when the key is found
    {
        // return the index
        return mid;
    }

    /*
     if reach this line mean is not found  at mid let
     check if the key smaller or bigger than mind */

    /*
    if key is smaller than mid then discard all elements in the right
    search space including the mid element and make Recursive call to
    search in left space
    */
    else if(key < vector[mid])
    {
        // Recursive call to search in left space
       return  Binary_Search_Recursive_Method(vector, low, mid - 1, key);

    }
    /*
    if key is bigger than mid then discard all elements in the left
    search space including the mid element and make Recursive call to
    search in right space */
    else
    {
        // Recursive call to search in right space
       return  Binary_Search_Recursive_Method(vector, mid + 1, high, key);
    }

    /**
    Time Complexity:
    from the above steps, binary search algorithm break the break
    into half in each recursive call.So,,the time complexity is log(n)
    */

   }/** End of Binary_Search_Recursive_Method() */
