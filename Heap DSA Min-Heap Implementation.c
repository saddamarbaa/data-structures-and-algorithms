/**
    [PROGRAM] :  A Min-Heap Data Structure
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    Heap is Tree-based data structure in which the tree is a complete
    binary tree so A Min-Heap is a complete binary tree that satisfies the
    heap property. It is also called as a binary heap.

    A complete binary tree is a binary tree in which every level,
    except possibly the last level,is completely filled, and all nodes
    are as far left as possible.

   Heap Property is the property of a node in which :-->

  (1) For A Min-Heap the property is that for every node i the value
      of node is greater than or equal to the value of its parent.
      Except the root node because root does not have parent
      A[Parent[i]] ≤ A[i] for all nodes i>1.

  (2) For A Max-Heap the property is that for every node i the value
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

// define the maximum Min-Heap size
#define MIN_HEAP_SIZE 50

/* define Global A Min-Heap size start by zero */
int SIZE = 0; /* the number of element are currently in A Min-Heap */

// Function to find the A Min-Heap size
void find_Size();

// function to search if the given element
// is present in A Min-Heap or not
int Contain(int [], int);

// Function to push(add) element into A Min-Heap
void insert(int [], int );

// Function to Min-Heapify the tree
void Min_Heapify(int [], int, int );

// Function to delete(remove)the minimum element
// from A Min-Heap
void Delete_Min(int []);

// function to Remove the given element
// from A Min-Heap
void Remove(int [], int);

// Function to find the minimum element in A Min-Heap
int find_Min();

//function to traverse A Min-Heap and Print it the elements
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
    int array[MIN_HEAP_SIZE]; // array declaration
    while(1)
    {
        int ch; //for switch  to  choice
        int element; // element
        printf("A Min-Heap data structure Implementation      : \n");
        printf("1 : Insert New element to A Min-Heap          : \n");
        printf("2 : Search for element in A Min-Heap          : \n");
        printf("3 : Find the minimum element in A Min-Heap    : \n"); // return min
        printf("4 : Delete the minimum element in A Min-Heap  : \n"); //delete the minimum
        printf("5 : Remove given element from A Min-Heap      : \n"); //delete the given element
        printf("6 : Clear A Min-Heap                          : \n"); //delete all the element in heap
        printf("7 : Print all the element of the A Min-Heap   : \n");
        printf("8 : find the A Min-Heap size                  : \n");
        printf("0 : quit                                      : \n");
        // asking user to enter choice
        printf("input your choice                             : ");
        scanf("%d",&ch);

        switch(ch)
        {
            // case 1 insert new element to A Min-Heap
            case 1:
                printf("Enter element to insert in A Min-Heap : ");
                scanf("%d",&element);
                insert(array, element); // call insert function
            break;

            // case 2 traverse A Min-Heap and search for element
            case 2:
               printf("Enter element to searched in A Min-Heap : ");
               scanf("%d",&element);
               int index =  Contain(array, element); // call  Contain() function
               if(index != -1)
               printf("Yes %d is found at index : %d\n", element, index + 1);
               else
               printf("NO %d is not found !\n", element);
            break;

            // case 3 find the minimum element in A Min-Heap
            case 3:
              element = find_Min(array); // call find_Min()
              if(element)
                 printf("the minimum element in A Min-Heap is -->  %d\n",element);
              else
                printf("A Min-Heap is EMPTY!! \n");
            break;

            // case 4 delete the minimum element from A Min-Heap
            case 4:
                Delete_Min(array); // call Delete_Min function
            break;

            // case 5 Remove the given element from A Min-Heap
            case 5:
                printf("Enter element to removed  from A Min-Heap : ");
                scanf("%d",&element);
                Remove(array,element); // / call Remove function
            break;

             // case 6 clear all the element of A Min-Heap
            case 6:
                clearHeap(); // call clearHeap function
            break;

            // case 7 traverse A Min-Heap and print it value
            case 7 :
               print_heap(array, SIZE); // call print_heap function
            break;

            // case 8 find the A Min-Heap size
            case 8 :
              find_Size(); // call find_Size function
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
    int i; // counter i declaration

    if(!newValue)   /* case when the given value is NULL */
       return;

    if(isEmpty())             /* case when this node is the first node */
    {
        array[0] = newValue;   /* insert at start (first index) */
        SIZE = SIZE + 1;        /* increment the Min-Heap size by one */
    }
    else
    {
        array[SIZE] = newValue;  /* insert at the end(last index) */
        SIZE = SIZE + 1;         /* increment the Min-Heap size by one */

       /*
       after adding new node maybe the tree is not A Min-Heap any more
       so let call Min_Heapify() to make sure that everything is ok
       so far but the question here is why we start looping from
       SIZE / 2 - 1 down to zero? that is because the tree is complete
       tree and in complete tree the half of the nodes are leave node */

        for(i = SIZE / 2 - 1; i >= 0; i--)
            Min_Heapify(array, SIZE, i); // call Min_Heapify()

    }/** End of else */

    // inform user the job is done
    printf("%d is been inserted to A Min-Heap \n", newValue);

} /** End of insert()*/


/**
   utility function to Min_Heapify the tree

    Heapify is the process of creating a heap data structure from
    binary tree.here we used to create A Min-Heap so whenever we call
    this function it will Rearrange a heap to maintain the A Min-Heap property,
    A Min-Heap property → The value of a node is smaller than or equal to
    the value of its children i.e., A[Parent[i]] ≤ A [i] for all nodes i > 1.

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
  if smallest != i
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


/** Utility function to find the minimum element in A Min-Heap */

int find_Min(int array[])
{
     if(isEmpty())    // A Min-Heap is empty condition
      return 0;
    return array[0];  // else case return the maximum

} /** End of find_Min() */


/**
    function to search if the given element is present
    in A Min-Heap or not
    the function take 2 parameters
    (1) array Heap[]
    (2) target element named key  */

int Contain(int Heap[] , int key)
{
    if (isEmpty()) // underflow condition
        printf("A Min-Heap IS EMPTY!!!\n");
     else
     {
         // linear search until size -1
         for (int i = 0; i <= SIZE - 1; i++)
         {
             if (Heap[i] == key) // base case
                return i; // we are done no need to continue return the index

         }/** End of for loop */

     } /** End of else */

    /*
    if reach this line mean been searching until the last index
    and the key is not found so let just return -1 to indicate
    that the key is not found */
    return -1;

}/** End of Contain() */


/**
    utility function to delete the minimum element in A Min-heap.
    in Min-heap the minimum element is always present at root
    also we always delete the root node here.
    there are three steps need to flow for deleting minimum --->
      1. Replace root element with last element in heap
      2. decrement A Min-heap size
      2. Min_Heapify(A, root) do Min_Heapify on new root

    Pseudo code for Delete_Min(A)
      FOR i --> Size - 1 down to  zero
      dO
      Min_Heapify(A[], 0)
*/

void Delete_Min(int array[])
{
    int i, deleted; // variables declaration

    if (isEmpty()) // underflow condition
    {
        printf("A Min-Heap is empty!!!\n");
        return;
    }

     deleted =  array[0]; // please keep me the element here before delete

     swap(&array[0], &array[SIZE - 1]); /* swap root node with  the last element of array */

     SIZE = SIZE - 1; /* decrement A Min-Heap size */

   /*
    After swapping maybe the tree is not A min-heap any more so lets
    call Min-Heapify() to make sure that everything is ok */

    for (i = SIZE - 1; i >= 0; i--)
         Min_Heapify(array, SIZE, 0); /* call Min_Heapify */

    // inform user the job is done
    printf("%d is been deleted from A Min-Heap \n",deleted);

} /** END OF Delete_Min()*/


/**
    utility function to Remove the given element from A Min-Heap

      here are the steps --->
      1. first search for the nodeToBeDeleted
      2. if is not found then we are done just return
      3. if found  then
      4. swap nodeToBeDeleted with the lastLeafNode
      5. decrement Min-Heap size
      2. Min_Heapify the array  */

void Remove(int array[], int key)
{
    int i, deleted, index; // variables declaration

    if (isEmpty()) // underflow condition
    {
        printf("A Min-Heap is empty!!! \n");
        return;
    }

    // search for element first if its found then removed
    index = Contain(array, key); // call Contain function

    if(index != -1)
    {
        deleted =  array[index]; // please keep me the element here before delete

        swap(&array[index], &array[SIZE - 1]); /* swap the given element with  the last element of array */

        SIZE = SIZE - 1; /* decrement Min-Heap size */

       /*
        After removing element maybe the tree is not A Min-Heap
        any more so let call MinHeapify() to make sure that everything is ok */

        for (i = SIZE - 1; i >= 0; i--)
             Min_Heapify(array, SIZE, 0); /* call Min_Heapify */

        // inform user the job is done
        printf("%d is been deleted from A Min-Heap \n",deleted);
    }

} /** END OF Remove()*/


/**
   Utility function to clear the Min-Heap
   clearing heap mean deleting all the heap element */

void clearHeap()
{
    SIZE = 0; /* clear A Min-Heap  by setting heap size back to zero */
    printf("A Min-Heap is been cleared \n"); // inform user the job is done

} /** END of clearHeap() */


/** Utility function to find A Min-Heap size */

void find_Size()
{
    if(isEmpty())    //  is empty condition
       printf("A Min-Heap is EMPTY NOW!! \n");
    else
       printf("A Min-Heap size is ---> %d\n",SIZE);

} /** End of find_Size() */


/** Utility function to Check if the Min-Heap is empty or not here */

int isEmpty()
{
    if(SIZE == 0)      /* empty case */
        return 1;
    return 0;          /* else case */
} /** End of isEmpty() */


/**
    utility function to traverse the given array
    and print all elements Accept */

void print_heap(int array [], int size)
{
    int i; // counter i declaration
    if (isEmpty()) // underflow condition
    {
        printf("A Min-Heap is empty !!!\n") ;
        return;
    }

    /* printing elements of an array(A Min-Heap) */
    for(i = 0; i < size; ++i)
        printf("%d\t", array[i]);

    printf("\n"); // insert new line after printing all element

 } /** End of print_heap() */


/**
  function to swap values of two variables
 (user should pass address of two as parameter)*/

void swap(int *a, int *b)
{
    int temp;  /*  declare temp variable */
    temp = *a;  // store in temp value of a
    *a = *b;    // store in a value of b

    // store in b value of a(we have value of variable a stored in temp)
    *b = temp;

}/** End of swap () */
