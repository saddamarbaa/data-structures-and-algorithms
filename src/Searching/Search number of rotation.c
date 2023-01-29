/**
       How many times is a sorted array rotated?

   [AUTHOR] :  Saddam Arbaa
   [Email]  :  <saddamarbaas@gmail.com>

   C program to find number of rotation in a circular sorted
   array using Binary search of Binary Search  
   
   for Reference
   https://youtu.be/4qjprDkJrjY  */

#include <stdio.h>
#include <stdlib.h>

// Function to find the number of times the array is rotated
int find_Rotation_Count(int vector[], int N);

// the  Driver Code
int main()
{
    printf("How many times is a sorted array rotated? :\n");

    // a curricular sorted array
    int vector[] = {15, 22, 23, 28, 31, 38, 5, 6, 8, 10, 12};

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

    // call find_Rotation_Count function
    int count = find_Rotation_Count(vector,n);
    if(count == -1)
    {
        printf("\n invalid case!\n");
    }
    else
    {
        printf("\nthe array is rotated  %d  times\n",count);
    }

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to find How many times a curricular sorted array
  is rotated using Binary search

  as we know array is sorted then if we can find where is the
  smallest Element(pivot)in the array then we know how many time
  the array is been rotated because number rotation = number of
  element in array before the pivot or we can number rotation = is
  index of minimum element in the array(pivot)
  so let find where is pivot and returned */


int find_Rotation_Count(int vector[], int N)
{
    // declare  variables
    int low, high, mid, next, previous;
    low = 0;
    high = N - 1 ;

    // iterate till search base case (low <= high)
    do
    {
        // calculate mid index
        mid = (low + high)/2; //(low + high) may lead to overflow condition

        // to avoid integer overflow is better to use on of this conditions flowing blow
		//  mid = low + (high - low)/2;
		//mid = high - (high - low)/2;

		//calculate next the element just after pivot
		next =( mid + 1) % N;

		//calculate previous the element just before pivot
		previous = ( mid + N - 1) % N;

		/**
         to find pivot we have 4 cases
		 also main pivot spacal proerty is that both previous
         element and next element are greater than pivot */

        /* now let check if our mid is the pivot */

        /*
          case 1
          array is sorted and pivot is first element just return low */
        if(vector[low] <= vector[high])
        {
            return low;
        }
        /*
          case 2
          array is not sorted let see if the mid is equal to pivot we return mid */
        else if(vector[mid] <= vector[next] && vector[mid] <= vector[previous])
        {
            //  property is true value  at mid index is the pivot so  just return the mid index
            return mid;
        }
        /*
         case 3
         right of mid is sorted so pivot cant be in the right
         let search in left side */
        else if(vector[mid] <= vector[high])
        {
            // search in left
            high = mid - 1;
        }

         /*
         case 4
         left of mid is sorted so pivot cant be in the left
         let search in right side */

       else if(vector[mid] >= vector[high])
        {

            //search in right
            low = mid + 1;
        }

    }while(low <= high); /** End of do while loop */

      /*
       if reach this line just return -1 to indicate invalid array
        or array was not curricular and sorted */

       return -1;//invalid input

    /**  Time Complexity: is Big O of log(n)        */

   }/** End of find_Rotation_Count() */
