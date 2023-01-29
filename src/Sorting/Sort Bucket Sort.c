/**
    [PROGRAM] :  Bucket Sort Algorithm
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Implement Bucket Sort Algorithm
    (sort an array of N numbers in ascending order)

    Bucket Sort : -–>

    Bucket Sort is a sorting technique that sorts the elements
    by first dividing the elements into several groups called buckets
    The elements inside each bucket are sorted using any of the suitable
    sorting algorithms or recursively calling the same algorithm.

    In bucket sort algorithm Several buckets are created.
    Each bucket is filled with a specific range of elements.
    The elements inside the bucket are sorted using any other algorithm.
    Finally, the elements of the bucket are gathered to get the sorted array. */

#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 100

/* global array size which will be entered by user */
int SIZE;

/* traverse Array and insert All the values at once */
void traverse(int []);

/* Function to traverse Array and print all element */
void print_Array(int[]);

/* Bucket Sort Algorithm  */
void Bucket_Sort(int[], int);

int main()  // the  Driver Code
{
    printf("Bucket Sort Algorithm Implementation \n\n");

    int input_array[MAXSIZE]; // input array declaration

   /* traverse Array and insert All the values at once */
    traverse(input_array);   /* call traverse()*/

   /* traverse Array and display all element before Sort */
    printf("\nElements in array Before Sorting are :\n");
    print_Array(input_array);  /* call print_Array() */

    /* traverse Array and Sorted in ascending order using Bucket Sort */
     Bucket_Sort(input_array, SIZE); /* call  Bucket_Sort()*/

    /* traverse Array and display all element after Sort */
    printf("Elements in array after Bucket Sort are :\n");
    print_Array(input_array);  /* call printArray() */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to traverse array and initialize it value by the value
  inserted by user(take input from user and storing it in an array)
  traversing mean visiting every element in the array exactly once */

void traverse(int array[])
{
    int i; // counter i declaration
    do // get valid size first
    {
        // asking  the length of array from user
        printf("Enter the size of the array []  :"
               ":\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d", &SIZE);
    } while(SIZE <= 0 || SIZE > MAXSIZE);

    // taking input from user and storing it in an array
    printf("Enter the elements one by one %d numbers \n", SIZE);

    for (i = 0; i <= SIZE - 1; i++)
    {
        // The use of '&' before a variable name,mean user input will
        // be store in the address of variable.
        printf("Enter Array[ %d ]: ",(i + 1));
        scanf("%d",&array[i]);

     } /** End of for loop */

} /** End of traverse()  */


/**
    function to traverse the given array and print all elements
    Accept one parameters (user should pass the array as parameter) */

void print_Array(int array [])
{
    int i; // counter i declaration
    if (SIZE == 0) // underflow condition
    {
        printf("Array is empty(no elements to print) !\n");
        return;
    }
     /* printing elements of an array */
     for (i = 0; i <= SIZE - 1; i++)
          printf("%d\t", array[i]);

    printf("\n"); // insert new line after printing all element

 } /** End of print_Array() */


/**
    Bucket Sort function

   Pseudo code for Bucket Sort Algorithm
    bucketSort()
      create N buckets each of which can hold a range of values
      for all the buckets
        initialize each bucket with 0 values
      for all the buckets
        put elements into buckets matching the range
      for all the buckets
        sort elements in each bucket
      gather elements from each bucket
    end bucketSort

 Bucket_SORT(input_array[], size)
  1.   take input_array[size]
  2.   create count_array[size] & initialize all values to 0
        for(int i = 0 to i < size)
            count_array[i] = 0
  3.  Count each element & place it in the count_array
        for(int i = 0 to i < size)
            count_array[input_array[i]]++

  4.  Place sorted elements from count_array to input_array[]
        for (i = 0, j = 0; i < size; i++)
            for(; count_array[i] > 0; (count_array[i])--)
             input_array[j++] = i;

End Bucket_Sort */

void Bucket_Sort(int input_array[], int size)
{
    int i, j;           // counter variables declarations
    int count_array[size];   // the count_array declarations

    // initialize all elements of count array to zeros
    for (i = 0; i <= size - 1; i++)
         count_array[i] = 0;

    // Store the count of each element
    for (i = 0; i <= size - 1; i++)
         count_array[input_array[i]]++;

    /*
    sort elements in each bucket and gather elements from each
    bucket and place in input array elements in sorted order */
    for (i = 0, j = 0; i < size; i++)
    {
       for(; count_array[i] > 0; (count_array[i])--)
       {
           input_array[j++] = i; // add sorted element to input_array
       }
   }

   /**
    Time complexity:
    Worst Case Complexity   : O(n2)
    Best Case Complexity    : O(n + k)
    Average Case Complexity : O(n)  */

} /** END of Bucket_Sort() */
