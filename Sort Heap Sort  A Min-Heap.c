
/**
    [PROGRAM] :  Heap Sort Algorithm
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    Heapsort is implemented using A Min-Heap.
    Heap is Tree-based data structure in which the tree is a complete
    binary tree so Heap is a complete binary tree that satisfies the
    heap property. It is also called as a binary heap.

    A complete binary tree is a binary tree in which every level,
    except possibly the last level,is completely filled, and all
    nodes are as far left as possible.

   Heap Property is the property of a node in which :-->

  (1) For A Min-Heap the property is that for every node i the value
      of node is greater than or equal to the value of its parent.
      Except the root node that is because root does not have parent
      A[Parent[i]] ≤ A[i] for all nodes i> 1.

  (2) For A Max-Heap the property is that for every node i the value
      of node is less than or equal to the value of its parent ,
      Except the root node its also because root node does not have parent
      A[Parent[i]] ≥  A[i] for all nodes i > 1.

     Reference in future :---->
    (1) https://youtu.be/hfFxxC30jKc
    (2) https://youtu.be/WfbCZ7RTSyM
    (3) https://youtu.be/B7hVxCmfPtM
    (4) https://youtu.be/ATwwr2fKz8Q
    (5) https://youtu.be/P4toxusBX9M
    (6) https://youtu.be/HjPmZuOXkHQ
    (7) https://youtu.be/zDlTxrEwxvg
    (8) https://youtu.be/NEtwJASLU8Q
    (9) https://youtu.be/Q_eia3jC9Ts
    (10)https://youtu.be/HqPJF2L5h9U */

#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 50

/* define Global A Min-Heap size initialize by zero */
// zero is number of element currently in A Min-Heap
int SIZE = 0;

/* traverse Array and insert All the values at once */
void traverse(int []);

//function to traverse A Min-Heap and Print its elements
void print_heap(int [], int);

/*  Heap Sort Algorithm  */
void heap_Sort(int [], int);

/*  Min-Heapify Algorithm  */
void Min_Heapify(int [], int, int );

// function to swap values of two variables
void swap(int *a, int *b);

// the  Driver Code
int main()
{
    printf("A Min-Heap Sort Algorithm Implementation \n\n");

    int heap[MAXSIZE];      /* heap array declaration */

    /* traverse Array and insert All the values at once */
    traverse(heap);      /* call traverse()*/

    /* traverse Array and display all element before Sort */
    printf("\nElements in array before sorted are :\n");
    print_heap(heap, SIZE);  /* call print_heap() */

    /* traverse Array and Sorted in descending
       order using A Min-Heap Sort*/
    heap_Sort(heap, SIZE);     /* call heap_Sort*/

   /* traverse Array and display all element after Sort */
    printf("Elements in array after A Min-Heap Sort are :\n");
    print_heap(heap, SIZE);        /* call print_heap() */

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

     /* printing elements of an array(A Min-Heap) */
     for(i = 0; i < size; ++i)
         printf("%d\t", heap[i]);

     printf("\n"); // insert new line after printing all element

 } /** End of print_heap() */


/**
   utility function to Min_Heapify the tree
    Heapify is the process of creating a heap data structure from
    binary tree.here we used to create A Min-Heap so whenever we call
    this function it will Rearrange a heap to maintain the A Min-Heap property,
    A Min-Heap property → The value of a node is smaller than or equal to
    the value of its children i.e., A[Parent[i]] ≤ A [i] for all nodes i > 1.
    here are the creating a heap steps --->
    1. get array input from user(we are done with this in traverse() function)
    2. Create a complete binary tree from the array
    3. Start from the first index of non-leaf node whose index is
       given by  size/2 - 1.
    4. Set current element i as smallest.
    5. The index of left child is given by 2 * i + 1 and the right
       child is given by 2 * i + 2.
      If leftChild is smaller than currentElement(i.e. element at ith index)
       then set leftChildIndex as smallest.
      If rightChild is smaller than element in smallest variable
      then set rightChildIndex as smallest
   6. if smallest != i  then
   7. Swap smallest with currentElement
   8. Repeat steps 3-8 until the subtrees are also Min heapified.

   Pseudo code for Min_Heapify
   Min_Heapify(A[], size,  i)
    set i as smallest
    leftChild = 2 * i + 1
    rightChild = 2 * i + 2
    if leftChild < size && A[leftChild] < A[smallest])
       set leftChildIndex as smallest
    END IF
   if rightChild <  size && A[rightChild] < A[smallest])
      set rightChildIndex as smallest
  END IF
  if smallest != i
     swap A[i] and A[smallest]
    call Min_Heapify(A, size, smallest)
   END IF
  End Min_Heapify   */


void Min_Heapify(int array[], int size, int i)
{
    if (size == 1)    /* case when have have only one element */
    {
        printf("Single element in the heap !!\n");
        return; /*  heap have only one element so no need to continue */
    }

    int smallest = i;                 /* Initialize smallest*/
    int leftChild   = 2 * i + 1;      /* calculate left Child = 2*i + 1*/
    int rightChild  = 2 * i + 2;      /* calculate right Child = 2*i + 2*/

    /*  If left child is smaller than the smallest */
    if (leftChild < size && array[leftChild] < array[smallest])
        smallest = leftChild;       /* set leftChildIndex as smallest */

    /* If right child is smaller than left child which si the smallest right now  */
    if (rightChild < size && array[rightChild] < array[smallest])
        smallest = rightChild;     /* set rightChild as smallest */

    // If smallest is not equal to i(mean root is not the smallest)
    if (smallest != i)
    {
        swap(&array[i], &array[smallest]);    /* swap array[i] and array[smallest] */

        /*
        after swapping maybe the tree is not A min-heap any more so lets
        Recursively call Min_Heapify() to make sure that everything is ok */

        Min_Heapify(array, size, smallest); /* Recursively  Min_Heapify  call*/
    }
    /** Time complexity of Min_Heapify is O(Logn). */

} /** END OF Min_Heapify() */


/**
   Heap Sort Function

   Heap Sort Algorithm for sorting element in descending order:
    1.  Build A Min-Heap from the given array.
        and since we are implementation A Min-Heap then we will
         always have the smallest element at the root node.
    2.  Swap :  Swap between the root element and the element at the
        last index element(last node in array)
    3.  Remove : decrement the Min-Heap size by one
    4.  Heapify : Min-Heapify on the new root to make sure that
       the smallest element it is on the root again
   5.  Repeat steps above until the list is sorted.

   Pseudo code for HEAPSORT(A)
   FOR i --> SIZE / 2 - 1 down to  zero
    dO
    Min_Heapify(A, SIZE, i)
    END of FOR
    FOR i --> Size - 1 down to  zero
    dO
    swap(A[0], A[i]);
    Min_Heapify(A, i, 0)
    END  of FOR
    END HEAPSORT
*/

void heap_Sort(int heap[], int size)
{
    int i; // counter i declaration

    /*
    first step Build A Min-Heap(rearrange the array) to put the
    minimum element at root but the question here is why we start
    looping from SIZE / 2 - 1 down to zero?
    this is because the tree is complete tree and in complete tree
    the half of the nodes are leave node */

    for(i = size / 2 - 1; i >= 0; i--)
        Min_Heapify(heap, size, i);   // call Min_Heapify()
   /*
    second step start loop again but this time from
    SIZE - 1 down to zero Swap between current root and
    element at the last index  swap(&heap[0], &heap[i])
    after that Min-Heapify the new root, Min_Heapify(heap, i, 0)
    and decrement last index by one (i--) */

    for (i = size - 1; i >= 0; i--)
    {
        swap(&heap[0], &heap[i]); /* Move current root to end so it can set at its right place */

        Min_Heapify(heap, i, 0); // call Min_Heapify()
    }

    printf("\nArray is been sorted in descending order\n"); // inform user the job is done

    /**
      Heap Sort Time Complexity
     1. Time complexity of Min_Heapify is O(Logn).
     2. Time complexity of BuildHeap() is O(n)

     so Heap Sort has O(nlog n) time complexities for all the cases
    ( best case, average case, and worst case).  */

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
