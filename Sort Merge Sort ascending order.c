
/**
    [PROGRAM] :  Merge Sort Algorithm
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Implement Merge Sort Algorithm
    (sort an array of N numbers in ascending order)

     Reference in future :->

    (1) https://youtu.be/Pow9VYIWfOg
    (2) https://youtu.be/jlHkDBEumP0
    (3) https://youtu.be/4OxBvBXon5w
    (4) https://youtu.be/6pV2IF0fgKY
    (5) https://youtu.be/mB5HXBb_HY8
    (6) https://youtu.be/ak-pz7tS5DE
    (7) https://youtu.be/TzeBrDU-JaY
    (8) https://youtu.be/0nlPxaC2lTw  */

#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 50

/* global array size which will be entered by user */
int size;

/* traverse Array and insert All the values at once */
void traverse(int array[]);

/* Function to traverse Array and print all element */
void print_Array(int array[]);

/* Merge Sort Algorithm  */
void MergeSort(int array[], int low, int high);

/* Merge the elements of two sorted sub arrays*/
void Merge(int array[], int start, int middle, int end);


// the  Driver Code
int main()
{
    printf("Merge Sort Algorithm implementation \n\n");

    // variables declaration
    int low, high;

    // array declaration
    int array[MAXSIZE];

   /* traverse Array and insert All the values at once */
    traverse(array); /* call traverse()*/

    low = 0;          // initialize low as Starting index
    high = size - 1;  // initialize last as Ending index

   /* traverse Array and display all element before Sort */
    printf("\nElements in array before sorted are :\n");
    print_Array(array); /* call print_Array() */

    /* traverse Array and Sorted in ascending order using Merge Sort*/
    MergeSort(array, low, high); /* MergeSort()*/

    /* traverse Array and display all element after Sort */
    printf("Elements in array after Merge Sort are :\n");
    print_Array(array); /* call printArray() */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to traverse array and initialize it value by the value
  inserted by user(take input from user and storing it in an array)
  traversing mean visiting every element in the array exactly once
*/

void traverse(int array[])
{
    // counter i declaration
    int i;

    // get valid size first
    do
    {
        // asking  the length of array from user
        printf("Enter size of Array []   :"
               ":\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d", &size);
    } while(size <= 0 || size > MAXSIZE);

     // taking input from user and storing it in an array
    printf("Enter the elements one by one %d numbers \n",size);

    for (i = 0; i <= size - 1; i++)
    {
        // The use of '&' before a variable name,mean user input will
        // be store in the address of variable.
        printf("Enter Array[ %d ]: ",(i+1));
        scanf("%d",&array[i]);

     } /** End of for loop */

} /** End of traverse()  */


/**
    function to traverse the given array and print all elements
    Accept one parameters
   ( user should pass the array as parameter) */

void print_Array(int array [])
{
    // counter i declaration
    int i;

    if (size == 0) // underflow condition
    {
        printf("Array is empty(no elements to print) !\n");
        return;
    }
     /* printing elements of an array */
     for (i = 0; i <= size - 1; i++)
     {
         printf("%d\t", array[i]);

     } /** End of for loop */
    printf("\n"); // insert new line after printing all element

 } /** End of print_Array() */


/**
     Merge Sort function
 (A) Merge Sort is a kind of Divide and Conquer approach algorithm
     in Divide and Conquer we divide the problems into smaller
     subproblems and then conquer(or solve) this smaller subproblems
     first,After that,we combine the solution of the smaller subproblems
     to get the solution for the original problem.

    Divide and Conquer is a three-step process:-->

    (1) Divide → The first step is to break the problem
         into smaller subproblems.
    (2) Conquer → This is basically solving of the smaller subproblems
    (3) Combine → In the last step, we combine the solutions
       of the smaller subproblems to get the solution of the bigger problem

 (B) very fast
 (C) Divide and Conquer algorithm
 (D) recursive algorithm

    Pseudo code for Merge Sort

    MERGE-SORT(A[], low, high)
    If (low < high)
    Then
    1. Find the middle point to divide the array into two halves:
      middle = floor((low + high) / 2)
    2. Call MERGE-SORT for first half:
     Call MERGE-SORT(A, low, middle)
    3. Call mergeSort for second half:
     Call MERGE-SORT(A, middle + 1, high)
    4. Merge the two halves sorted in step 2 and 3:
      Call MERGE(A, low, middle, high)
    End If
    End MERGE-SORT */

void MergeSort(int array[], int low, int high)
{
    /*
    array[] --> Array to be sorted,
    low    -->  Starting index,
    high  -->  Ending index */

    // middle variable declaration
    int  mid;

    /*
    We have to sort only when low < high its mean that the array
    have at less 2 element or more because when low = hight
    we have one element only in list and that is sorted*/
    if(low < high)
    {
        // calculate mid index
        mid = (low + high)/2; //(low + high) may lead to overflow condition
        // to avoid integer overflow is better to use one of this conditions flowing blow
        //  mid = low + (high - low)/2;
        //  mid = high - (high - low)/2;

        /* Sort the left part */
        MergeSort(array, low , mid); //recursive call to sort left

        /* Sort the right part */
        MergeSort(array, mid + 1, high); //recursive call to sort right

        /* Merge the two sorted parts */
        Merge(array, low, mid, high);  /* Recursive call to Combine the two sorted halves */
    }

    /**
    Merge Sort Complexities:

    Time Complexity
    Best Case Complexity: O(n*log n)
    Worst Case Complexity: O(n*log n)
    Average Case Complexity: O(n*log n)

    Space Complexity
    The space complexity of merge sort is O(n)
    */

} /** End of MergeSort() */


/**
    Merge functions merges the two sorted parts of array[]
    First subarray is array[start to middle]
    Second subarray is array[middle + 1 to end]

   MERGE(A[], start, middle, end)
  1. create temporary array to store the sorted list
   int  t = end - start + 1
    int temp[t]
 2. Maintain current index of sub-arrays and temp array
    and initialize all the counters
    int i, j, k
     i =  start
     j =  middle + 1
     k = 0
 3. Merge process stared from here
    WHILE(i <= middle && j <= end)
    IF(A[i] < A[j])
    temp[k++] = A[i++]
    ELSE
    temp[k++] = A[j++]
    END IF
    END WHILE
 (4) Copy the remaining elements if there are any
     if(i > middle)
     while(j <= end)
     temp[k++] = A[j++]
      END WHILE
      END IF
     if(j > end)
     while(i <= middle)
     temp[k++] = A[i++]
      END WHILE
      END IF
(5) Copy back the sorted array to the original array A
    for  x = 0 ,x < k , x++
    aA[x + start] = temp[x]
    END FOR LOOP
    End MERGE*/

void Merge(int array[], int start, int middle, int end)
{
    /* to store the sorted array let first create temporary array */

    int temp_Size = end - start + 1; /* temporary array size */

    int temp[temp_Size];  /* temporary array declaration */

    int i, j, k;   /* counters variables declaration */

   /* Maintain current index of sub-arrays and
     temp array and initialize all the counters */

    i =  start;          /* i counter for sub array[start to middle]*/
    j =  middle + 1;     /* j counter for sub array[middle + 1 to end]*/
    k = 0;               /* k counter for temporary Array temp[] */

    /** Merge process start from here */

    /*  Until we reach end of either sub arrays continue loop */
    while (i <= middle && j <= end)
    {
        /*
        Compare their element first then them merge them
        in array temp[] in sorted order */

        if (array[i] < array[j])
        {
            // filling the copy array with the smaller element
            temp[k] = array[i];

            i++; //increment i
            //also can written just like this C[k++] = A[i++];
        }
        else
        {
            // filling the copy array with the smaller element
            temp[k] = array[j];

            j++; //increment i
            //also can written just like this C[k++] = B[j++];
        }
        k++; /*increment counter k here as will be incremented in both cases */

    } /** End of while loop */

    /*  Copy the remaining elements if there are any */
    if(i > middle)   /* case when array[start to middle] reach to end first */
    {
        while(j <= end) /* while array[middle + 1 to end] to reached to end yet */
        {
            //add the remaining element and increment both counters
            temp[k++] = array[j++];
        }
    }

    /*  Copy the remaining elements if there are any */
    if(j > end) /* case when array[middle + 1 to end] reached to end first */
    {
        while(i <= middle) /* while array[start to middle] to reached to end yet */
        {
            //add the remaining element and increment both counters
            temp[k++] = array[i++];
        }
    }

    /** Merge process is done*/

    /* now Copy back the sorted array  from temp to the original array */
    int x;
    for (x = 0; x < k; x++)
    {
        array[x + start] = temp[x]; // coping back
    }
     return;

    // one more  Reference
    // https://youtu.be/jlHkDBEumP0

} /** end of Merge() */

