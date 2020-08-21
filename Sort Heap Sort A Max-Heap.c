 
/**
    [PROGRAM] :  Heap Sort Algorithm
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    Heapsort is implemented using A Max-Heap.
    Heap is Tree-based data structure in which the tree is a complete
    binary tree so Heap is a complete binary tree that satisfies the
    heap property. It is also called as a binary heap.

    A complete binary tree is a binary tree in which every level,
    except possibly the last level,is completely filled, and all
    nodes are as far left as possible.

   Heap Property is the property of a node in which :-->

  (1) For A Max-Heap the property is that for every node i the value
      of node is less than or equal to the value of its parent ,
      Except the root node because root node does not have parent
      A[Parent[i]] ≥ A[i] for all nodes i>1.
  (2) For A Min-Heap the property is that for every node i the value
      of node is greater than or equal to the value of its parent.
      Except the root node that is also because root does not have parent
      A[Parent[i]] ≤A [i] for all nodes i>1.

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

/* define Global A Max-Heap size initializ by zero */
// zero is number of element currently in A Max-Heap
int SIZE = 0;

/* traverse Array and insert All the values at once */
void traverse(int []);

//function to traverse A Max-Heap and Print it the elements
void print_heap(int [], int);

/*  Heap Sort Algorithm  */
void heap_Sort(int [], int);

/* Max_Heapify Algorithm */
void Max_Heapify(int [], int, int);

// function to swap values of two variables
void swap(int *a, int *b);

// the  Driver Code
int main()
{
    printf("A Max-Heap Sort Algorithm Implementation \n\n");

    int heap[MAXSIZE]; /*  heap array declaration */

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
   utility function to Max_Heapify the tree

    Heapify is the process of creating a heap data structure from
    a binary tree. here we used to create Max-Heap so whenever we call
    this function it will Rearrange a heap to maintain the Max-Heap property,
    A Max-Heap property → The value of a node is greater than or equal to
    the value of its children i.e., A[Parent[i]] ≥ A[i] for all nodes i>1.

    here are the creating A Max-Heap  steps --->
    1. get array input from user(we are done with this in traverse() function)
    2. Create a complete binary tree from the array
    3. Start from the first index of non-leaf node whose
       index is given by  size/2 - 1.
    4. Set current element i as largest.
    5. The index of left child is given by 2 * i + 1 and the
       right child is given by 2 * i + 2.
      If leftChild is greater than currentElement(i.e. element at ith index)
       then set leftChildIndex as largest.
      If rightChild is greater than element in largest
      then set rightChildIndex as largest
   6. Swap largest with currentElement
   7. Repeat steps 3-7 until the subtrees are also Max heapified.

   Pseudo code for Max_Heapify
   Max_Heapify(A[], size,  i)
    set i as largest
    leftChild = 2 * i + 1
    rightChild = 2 * i + 2
    if leftChild <= size && A[leftChild] > A[largest])
       set leftChildIndex as largest
    END IF
   if rightChild <=  size && A[rightChild] > A[largest])
      set rightChildIndex as largest
  END IF
  if largest != i)
     swap A[i] and A[largest]
    CALL Max_Heapify(A, size, largest)
   END IF
  End Max_Heapify   */

void Max_Heapify(int array[], int size, int i)
{
    if (size == 1) /* case when have have only one element */
    {
        printf("only Single element in the Max-Heap  !!\n");
       return; /* A Max-Heap have only one element so no need to continue */
    }

    int largest = i;                 /* Initialize largest*/
    int leftChild   = 2 * i + 1;      /* calculate left Child = 2*i + 1*/
    int rightChild  = 2 * i + 2;       /* calculate right Child = 2*i + 2*/

    /*  If left child is larger than the largest */
    if (leftChild < size && array[leftChild] > array[largest])
         largest = leftChild;  /* set leftChildIndex as largest */

    /* If right child is bigger than left child which the largest right now  */
    if (rightChild < size && array[rightChild] > array[largest])
         largest = rightChild;  /* set rightChild as largest */

    // If largest is not equal to i(mean root is not the largest)
    if (largest != i)
    {
        swap(&array[i], &array[largest]);  /* swap array[i] and array[largest] */

        /*
        after swapping maybe the tree is not max heap any more so let
        Recursively call MaxHeapify() to make sure that everything is ok */

        Max_Heapify(array, size, largest); /* Recursively call Max_Heapify */
    }

    /** Time complexity of heapify is O(Logn). */

} /** END OF Max_Heapify() */


/**
   Heap Sort Function

   Heap Sort Algorithm for sorting element in increasing order:
    1.  Build a max heap from the input data.
         and since we are implementation A Max-Heap then we will
         always have the largest element at the root node.
    2.  Swap  : Swap between the root element and element at the last
         index element (last node in array)
    3.  Remove : decrement the Max-Heap size by one
    4.  Heapify : Max-Heapify on the new root to make sure that
       the largest element it on the root again
    5. Repeat steps above until the list is sorted.

   Pseudo code for HEAPSORT(A)
   FOR i --> SIZE / 2 - 1 down to  zero
    dO
    Max_Heapify(A, SIZE, i)
    END FOR
    FOR i --> Size - 1 down to  zero
    dO
    swap(A[0], A[i]);
    Max_Heapify(A, i, 0)
    END FOR
    END HEAPSORT
*/

void heap_Sort(int heap[], int size)
{
    int i; // counter i declaration

    /*
    first step Build A Max-Heap(rearrange the array) to put the
    maximum element at root but the question here is why we start
    looping from SIZE / 2 - 1 down to zero?
    this is because the tree is complete tree and in complete tree
    the half of the nodes are leave node */

    for(i = size / 2 - 1; i >= 0; i--)
        Max_Heapify(heap, size, i); // call Max_Heapify()
   /*
    second step start loop again but this time from
    SIZE - 1 down to zero Swap between current root and
    element at the last index  swap(&array[0], &array[i])
    after that Max-Heapify the new root, Max_Heapify(array, i, 0)
    and decrement last index by one (i--) */

    for (i = size - 1; i >= 0; i--)
    {
        swap(&heap[0], &heap[i]); /* Move current root to end so it can set at its right place */

        Max_Heapify(heap, i, 0); // call Max_Heapify()
    }

    printf("\nArray is been sorted in ascending order\n"); // inform user the job is done

    /**
      Heap Sort Time Complexity
     1. Time complexity of Max_Heapify is O(Logn).
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
