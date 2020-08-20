/** 
    [PROGRAM] :  A Min-Heap Data Structure
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    Heap is Tree-based data structure in which the tree is a complete
    binary tree so Heap is a complete binary tree that satisfies the
    heap property. It is also called as a binary heap.

    A complete binary tree is a binary tree in which every level,
    except possibly the last level,is completely filled, and all nodes
    are as far left as possible.

   Heap Property is the property of a node in which :-->

  (1) For a min heap the property is that for every node i the value
      of node is greater than or equal to the value of its parent.
      Except the root node because root does not have parent
      A[Parent[i]] ≤ A[i] for all nodes i>1.

  (2) For a max heap the property is that for every node i the value
      of node is less than or equal to the value of its parent ,
      Except the root node also  because root node does not have parent
      A[Parent[i]] ≥ A[i] for all nodes i>1.

    Reference in future :--->
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

/* global heap size start by zero */
int SIZE = 0;

//Function to push(add)element into heap
void insert(int [], int );

// Function to Min-Heapify the tree
void Min_Heapify(int [], int, int );

// Function to delete(remove)the minimum element from A Min-Heap
void Delete_Min(int []);

// Function to find the minimum element A Min-Heap
int find_Min();

//function to traverse A Min-Heap and Print the element
void print_heap(int [], int);

// function to swap values of two variables
void swap(int *a, int *b);

// function to Check if the A Min-Heap is empty or not
int isEmpty();

// function to clear the A Min-Heap
void clearHeap();

// the  Driver Code
int main()
{
    // array declaration
    int array[MAXSIZE];

    while(1)
    {
        int ch; //for switch  to  choice
        int element; // element
        printf("A Min-Heap data structure implementation      : \n");
        printf("1 : insert New element to A Min-Heap          : \n");
        printf("2 : Delete the minimum element in A Min-Heap  : \n"); //delete the max
        printf("3 : Print all the element of the A Min-Heap   : \n");
        printf("4 : find the minimum element in A Min-Heap    : \n"); // return max
        printf("5 : clear the A Min-Heap                      : \n"); //delete all the element in heap
        printf("0 : quit                                      : \n");
        // asking user to enter chice
        printf("input your choice                             : ");
        scanf("%d",&ch);
         switch(ch)
         {
            // case 1 insert new element to A Min-Heap
            case 1:
                printf("Enter element to insert in A Min-Heap  : ");
                scanf("%d",&element);
                insert(array, element); // call insert function
            break;

            // case 2 delete the minimum element from A Min-Heap
            case 2:
                Delete_Min(array); // call Delete_Min function
            break;

            // case 3 traverse A Min-Heap and print it value
            case 3:
               print_heap(array, SIZE); // call print_heap function
            break;

            // case 4 find the minimum element in A Min-Heap
            case 4:
              element = find_Min(array); // call find_Min() function
              if(element == -111)
                 printf("A Min-Heap is EMPTY!! --->  \n");
              else
                 printf("the minimum element in Min-Heap is --->  %d\n",element);
            break;

            // case 5 clear all the element in Min-Heap
            case 5:
                clearHeap(); // call clearHeap() function
            break;

             // case 0 Exit case
            case 0:
            printf("time to exit thanks\n");
            _Exit(0);

             // default case
             default:
             printf("invalid input\n");
             break; // no need break after default case I use it only for readability
         }

    } /** END of while loop */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
    utility function to Insert Element into A Min-Heap

   Algorithm for insertion in A Min-Heap
   insert(A, value)
   2. if heap is empty add the newNode as first node in beginning
   3. else (heap is not empty)
      insert the newNode at the end (last node from left to right.)
     End If
   4. A Min_Heapify the tree(so that the minimum node always be at the root)
    End insert
**/

void insert(int array[], int newValue)
{
    // counter i declaration
    int i;

    if(isEmpty())             /* case when this node is the first node */
    {
        array[0] = newValue;   /* insert at start (first index) */
        SIZE = SIZE + 1;        /* increment the heap size by one */
    }
    else
    {
        array[SIZE] = newValue;  /* insert at the end(last index) */
        SIZE = SIZE + 1;         /* increment the heap size by one */

       /*
       after adding new node maybe the tree is not A Min-Heap any more
       so let call Min_Heapify() to make sure that everything is ok so far
       but the question here is why we start looping from
       SIZE / 2 - 1 down to zero? that is because the tree is complete
       tree and in complete tree the half of the nodes are leave node */

        for(i = SIZE / 2 - 1; i >= 0; i--)
        {
            Min_Heapify(array, SIZE, i); // call Min_Heapify()

        } /** End of for loop */

    } /** End of else */

    // inform user the job is done
    printf("%d is been inserted to A Min-Heap \n", newValue);

} /** End of insert()*/


/**
    utility function to traverse the given array
    and print all elements Accept */

void print_heap(int array [], int size)
{
    // counter i declaration
    int i;
    if (isEmpty()) // underflow condition
    {
        printf("A Min-Heap is empty !!!\n") ;
        return;
    }

     /* printing elements of an array(A Min-Heap) */
     for(i = 0; i < size; ++i)
     {
         printf("%d\t", array[i]);

     } /** End of for loop */

    printf("\n"); // insert new line after printing all element

 } /** End of print_heap() */


/**
   utility function to Min_Heapify the tree

    Heapify is the process of creating a heap data structure from a binary tree.
    here we used to create A Min-Heap so whenever we call this function
    it will Rearrange a heap to maintain the A Min-Heap property,
    A Min-Heap property → The value of a node is smaller than or equal to
    the value of its children i.e., A[Parent[i]] ≤ A[i] for all nodes i > 1.

    here are the creating a heap steps --->
    1. get array input from user(we are done with this step in insert function)
    2. Create a complete binary tree from the array
      (we are also done with this step in  insert function)
    3. Start from the first index of non-leaf node whose index is
       given by  size/2 - 1.
    4. Set current element i as smallest.
    5. The index of left child is given by 2 * i + 1 and the right
       child is given by 2 * i + 2.
      If leftChild is smaller than currentElement(i.e. element at ith index)
       then set leftChildIndex as smallest.
      If rightChild is smaller than element in smallest variable
      then set rightChildIndex as smallest
   6. Swap smallest with currentElement
   7. Repeat steps 3-7 until the subtrees are also Min heapified.

   Pseudo code for Min_Heapify
   Min_Heapify(A[], size,  i)
    set i as smallest
    leftChild = 2 * i + 1
    rightChild = 2 * i + 2
    if leftChild <= size && A[leftChild] < A[smallest])
       set leftChildIndex as smallest
    END IF
   if rightChild <=  size && A[rightChild] < A[smallest])
      set rightChildIndex as smallest
  END IF
  if smallest != i)
     swap A[i] and A[smallest]
    call Min_Heapify(A, size, smallest)
   END IF
  End Min_Heapify   */

void Min_Heapify(int array[], int size, int i)
{
    if (size == 1) /* case when have have only one element */
    {
        printf("Single element in the heap !!\n");
        return; /* heap have only one element so no need to continue */
    }

    int smallest = i;                 /* Initialize smallest*/
    int leftChild   = 2 * i + 1;      /* calculate left Child = 2*i + 1*/
    int rightChild  = 2 * i + 2;      /* calculate right Child = 2*i + 2*/

    /*  If left child is smaller than the smallest */
    if (leftChild <= size && array[leftChild] < array[smallest])
         smallest = leftChild;  /* set leftChildIndex as smallest */

    /* If right child is smaller than left child which the smallest right now  */
    if (rightChild < size && array[rightChild] < array[smallest])
         smallest = rightChild;  /* set rightChild as smallest */

    // If smallest is not equal to i(mean root is not the smallest)
    if (smallest != i)
    {
        swap(&array[i], &array[smallest]);    /* swap array[i] and array[smallest] */

        /*
        after swapping maybe the tree is not A min-heap any more so let
        Recursively call Min_Heapify()to make sure that everything is ok */

        Min_Heapify(array, size, smallest); /* Recursively  Min_Heapify  call*/
    }

} /** END OF Min_Heapify() */


/**

    utility function to delete the minimum element in A Min-heap.
    in  Min-heap the minimum element is always present at root
    also we always delete the root node here.
    there are two steps need to flow for deleting minimum --->
      1. Replace root element with last element in heap
      2. Min_Heapify(A, root) do Min_Heapify on new root

    Pseudo code for Delete_Min(A)
      FOR i --> Size - 1 down to  zero
      dO
      Min_Heapify(A[], 0)
*/

void Delete_Min(int array[])
{
    // variables declaration
    int i, deleted;

    if (isEmpty()) // underflow condition
    {
        printf("A Min-Heap is empty!!!\n");
        return;
    }
     // please keep me the element before you delete
     deleted =  array[0];

    /* swap root node with  the last element of array */
     swap(&array[0], &array[SIZE - 1]);

     SIZE = SIZE - 1; /* decrement heap size */

   /*
    After swapping maybe the tree is not A min-heap any more so lets
    call Min-Heapify() to make sure that everything is ok */

    for (i = SIZE - 1; i >= 0; i--)
    {
        Min_Heapify(array, SIZE, 0); /* call Min_Heapify */
    }
    // inform user the job is done
    printf("%d is been deleted from A Min-Heap \n",deleted);

} /** END OF Delete_Min()*/

/** Utility function to Check if the heap is empty or not here */

int isEmpty()
{
    if(SIZE == 0)      /* empty case */
        return 1;
    return 0;          /* else case */
}

/** Utility function to find the minimum element in A Min-Heap */

int find_Min(int array[])
{
    if(isEmpty())    // heap is empty condition
      return -111;

    return array[0];  // else case return the minimum
} /** End of find_Min() */


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

    // swap is done
}/** End of swap () */

/**
   Utility function to clear the heap
   clearing heap meaning deleting all the heap element */
void clearHeap()
{
    SIZE = 0; /* clear heap by setting heap size back to zero */
    printf("A Min-Heap is been cleared \n"); // inform user the job is done

} /* END of clearHeap() */

