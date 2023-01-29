/**
    [PROGRAM] :  Iterative Heap Sort Implementation
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C program to sort an array of N numbers in ascending order
    based on heap sort algorithm(MAX heap) (Iterative HeapSort) */

#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 50

/* define Global A Max-Heap size initialize by zero */
// zero is number of element currently in A Max-Heap
int  SIZE = 0;

/* traverse Array and insert All the values at once */
void traverse(int []);

//function to traverse A Max-Heap and Print it the elements
void print_heap(int [], int);

/* Iterative Heap Sort Algorithm  */
void heap_Sort(int [], int );

// function  to build Max Heap
void buildMaxHeap(int [], int n);

// function to swap values of two variables
void swap(int *a, int *b);

// the  Driver Code
int main()
{
    printf("A Max-Heap Sort Algorithm Implementation(Iterative) \n\n");

    int heap[MAXSIZE];  /*  heap array declaration */

    /* traverse Array and insert All the values at once */
    traverse(heap); /* call traverse()*/

    /* traverse Array and display all element before Sort */
    printf("\nElements in array before sorted are :\n");
    print_heap(heap, SIZE); /* call print_heap() */

    /* traverse Array and Sorted in ascending order
       using A Max-Heap Sort*/
    heap_Sort(heap, SIZE); /* call heap_Sort*/

   /* traverse Array and display all element after Sort */
    printf("Elements in array after A Max-Heap Sort are :\n");

    print_heap(heap, SIZE); /* call print_heap() */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to traverse array and initialize it value by the value
  inserted by user(take input from user and storing it in an array)
  traversing mean visiting every element in the array exactly once
*/

void traverse(int heap[])
{
    int i; // counter i declaration

    // get valid size first
    do
    {
        // asking  the length of array from user
        printf("Enter size of Heap Array []  :"
               ":\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d", &SIZE);

    } while(SIZE <= 0 || SIZE > MAXSIZE);

     // taking input from user and storing it in heap array
    printf("Enter the elements one by one %d numbers \n", SIZE);

    for (i = 0; i <= SIZE - 1; i++)
    {
        // The use of '&' before a variable name,mean user input will
        // be store in the address of variable.
        printf("Enter heap[ %d ]: ",(i+1));
        scanf("%d",&heap[i]);

     } /** End of for loop */

} /** End of traverse()  */


/**
    utility function to traverse the given heap array
    and print all the element */

void print_heap(int heap [], int size)
{
    int i; // counter i declaration
    if (size == 0) // underflow condition
    {
        printf("Max Heap is empty !!!\n") ;
        return;
    }

     /* printing elements of an array(A Max-Heap) */
     for(i = 0; i < size; ++i)
         printf("%d\t", heap[i]);

     printf("\n"); // insert new line after printing all element

 } /** End of print_heap() */


/**
   utility function to build Max Heap from given array

    the property of A Max-Heap  is that for every node i the value
    of node is less than or equal to the value of its parent ,
    Except the root node because root node does not have parent
    A[Parent[i]] ≥ A[i] for all nodes i > 1. */

void buildMaxHeap(int heap[], int heapSize)
{
    int i, c, root; // variable declarations

    for(i = 1; i < heapSize; i++)
    {
        c = i; /* initialize c by i */

        do
        {
            root = (c - 1) / 2;      /* calculate root */
            if (heap[root] < heap[c])   /* to create MAX heap array */
            {
                /* swap heap[root] with  heap[c] */
                swap(&heap[root], &heap[c]);    /* call swap  function */
            }
            c = root; /* initialize c by the new root */

        } while(c != 0);

    } /** End of for loop */

} /** End of buildMaxHeap() */


/**
    Iterative Heap Sort Function

   Heap Sort Algorithm for sorting element in increasing order:
    1.  Build a max heap from the input data.
         and since we are implementation A Max-Heap then we will
         always have the largest element at the root node.
    2.  Swap  : Swap between the root element and element at the last
         index element (last node in array)
    3.  Remove : decrement the Max-Heap size by one
    4.  Heapify : Max-Heapify on the new root to make sure that
       the largest element it on the root again
    5. Repeat steps above until the list is sorted. */

void heap_Sort(int heap[], int size)
{
   int i, c, root; // variable declarations

    /*
    first step Build A Max-Heap(rearrange the array) to put the
    maximum element at root for that lets call buildMaxHeap()
    function for help  */

    buildMaxHeap(heap, SIZE);  // call  buildMaxHeap() function */

    /*
    second step start loop  from SIZE - 1 down to zero
    Swap between current root and element at the last index
    swap(&array[0], &array[i]) after that Max-Heapify() the array
    and decrement last index by one (i--) */

    for (i = size - 1; i >= 0; i--)
    {
        swap(&heap[0], &heap[i]);  /* swap value of first index with value of last index
                                    by doing that we set the biggest element at its right place*/

        /* maintain heap property after each swapping  */

        root = 0; /* initialize root by 0 (root is the first index) */

        do
        {

            c = 2 * root + 1;    /* left node of root element */

            /* if left child is smaller than right child point
               variable(c)to right the child by incrementing c by one */

            if ((heap[c] < heap[c + 1]) && c < i - 1)
                c++; // now c point to right child

            /*
            if parent(root)is smaller than child (c) swap
            parent with child which have largest value */

            if (heap[root] < heap[c] && c < i)
            {
                swap(&heap[root], &heap[c]);    /* call swap  function */
            }

            root = c; /* initialize root by the new c */

        } while(c < i);

    } /** End of for loop */

    printf("\nArray is been sorted in ascending order\n"); // inform user the job is done

} /** END of heapSort() */


/**
  function to swap values of two variables
 (user should pass address of two as parameter)*/

void swap(int *a, int *b)
{
    int temp;  /*  declare temp variable */

    temp = *a; // store in temp value of a
    *a = *b; // store in a value of b

    // store in b value of a(we have value of variable a stored in temp)
    *b = temp;

}/** End of swap () */
