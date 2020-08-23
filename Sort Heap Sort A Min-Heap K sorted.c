/**
    [PROGRAM] :  Sort a nearly sorted (or K sorted) array
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    Given an array of n elements, where each element is at most k
    away from its target position, devise an algorithm that sorts
     in O(n log k) time.

     Examples:
     Input : array[] = {6, 5, 3, 2, 8, 10, 9}
     k = 3
     Output : array[] = {2, 3, 5, 6, 8, 9, 10}

    Input : array[] = {10, 9, 8, 7, 4, 70, 60, 50}
    k = 4
    Output : array[] = {4, 7, 8, 9, 10, 50, 60, 70} */

#include <stdio.h>
#include <stdlib.h>

/* define Global Priority Queue size initialize by zero */
int SIZE = 0;

// Function to Sort a nearly sorted array
void sortK(int array[], int, int k);

//Function to push(add) element into Priority Queue
void enqueue(int [], int );

//function to traverse A Min-Heap and Print it the elements
void print_heap(int [], int);

// Function to Min-Heapify the array
void Min_Heapify(int [], int, int );

// Function to delete(remove)the minimum element
// from Priority Queue
void Delete_Min(int []);

// Function to find the minimum element in Priority Queue
int find_Min();

// function to swap values of two variables
void swap(int *a, int *b);

// function to Check if the queue is empty or not
int isEmpty();


// the  Driver Code
int main()
{
    // K declaration and initialization
    int k = 4;

    // array declaration and initializations
    int array[] = {10, 9, 8, 7, 4, 70, 60, 50};

    // calculate array size
    int n = sizeof(array) / sizeof(array[0]);

    /* traverse Array and display all element before Sort */
    printf("\nElements in array before sorted are :\n");
    print_heap(array, n); /* call print_heap() */

    /* traverse a nearly sorted Array and Sorted in ascending order
       using A Min-Heap Sort*/
    sortK(array, n, k); // call sortK()

    /* traverse Array and display all element after Sort */
    printf("Elements in array after A Min-Heap Sort are :\n");
    print_heap(array, n); /* call print_heap() * */

   return 0;// signal to operating system everything works fine

}/** End of main function */


/**

  utility function to Insert Element into a priority queue(Min-Heap)

   Algorithm for insertion in a priority queue(Min-Heap)
   insert(A, value)
   1. if queue is empty add the newNode as first node in beginning
   2. else(queue is not empty)
      insert the newNode at the end (last node from left to right.)
      End If
   3.  Max-Heapify the tree(so that the maximum node always be at the root)
  End insert()
**/

void enqueue(int array[], int newValue)
{
    int i;              // counter i declaration
    if(!newValue)     /* case when the given value is NULL */
       return;

    if(isEmpty())             /* case when the given value is the first element */
    {
        array[0] = newValue;   /* insert at start (first index) */
        SIZE = SIZE + 1;        /* increment the queue size by one */
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

    } /** End of else */

    // inform user the job is done
    printf("%d  been push to queue \n",newValue);

    /** Time complexity of of inserting is O(Logn). */

} /** End of enqueue()*/


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
   6. if smallest != i  then
   7. Swap smallest with currentElement
   8. Repeat steps 3-8 until the subtrees are also Min heapified.
   Pseudo code for Min_Heapify
   Min_Heapify(A[], size,  i)
    set i as smallest
    leftChild   = 2 * i + 1
    rightChild = 2 * i + 2
    if leftChild < size && A[leftChild] < A[smallest])
       set leftChildIndex as smallest
    END IF
   if rightChild < size && A[rightChild] < A[smallest])
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
    if (leftChild < size && array[leftChild] < array[smallest])
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

    /** Time complexity of Min_Heapify is O(Logn). */

} /** END OF Min_Heapify() */


/**
   utility function to sort a K-Sorted Array
    TO sort k-sorted array we flow two steps

    1  first step :--->  Create a Min Heap of size k+ 1 with
        first k+1 elements. this step will take O(k) time
    2. second step :--->  One by one remove min element from heap,
        put it in result array, and add a new element to heap from
        remaining elements.
    Removing an element and adding a new element to min heap will take Log k time. */

void sortK(int array[], int n, int k)
{
    int i; // counter i declaration

     // now let flow the steps above

    /** first step Create a Min Heap of first (k+1) */
    int MinHeap[k + 1]; // queue(MinHeap)array declaration

    // insert first k+1 elements in the heap(a priority queue)
    for(i = 0; i < k + 1; i++)
    {  enqueue(MinHeap, array[i]);
    }

    int index = 0; //  index start from  zero as we will add from first index

    for ( i = k + 1; i < n; i++)
    {
       /*
       add top element(smallest number)in min-heap to our array at index
       index after that increment index to be ready for next number */

        array[index++] = find_Min(MinHeap);

        // we are done we smallest number now removed from queue
        Delete_Min(MinHeap);

        // add the remaining element from next k + 1 to queue
        enqueue(MinHeap, array[i]); // push next array element into min-heap
    }

    /*
    second step --> while queue is not empty
    One by one remove min element from heap,put it in result array,
    and add a new element to heap from remaining elements */
    while(!isEmpty())
    {
        array[index++] = find_Min(MinHeap);// take next min add to array at it right place
        Delete_Min(MinHeap); // we are done we smallest number now removed from queue
    }

    /**  Time complexity of sortK() is O(nLog k). */

} /** End of sortK() */


/** Utility function to find the minimum element in Priority Queue */

int find_Min(int array[])
{
     if(isEmpty())    // A Priority Queue is empty condition
      return 0;
    return array[0];  // else case return the minimum

} /** End of find_Min() */


/**
    utility function to delete the minimum element
    in Priority Queue(Min-Heap).
    in Min-heap the minimum element is always present at root
    also we always delete the root node here.
    there are three steps need to flow for deleting minimum --->
      1. Replace root element with the last element in queue
      2. decrement A Min-heap size
      2. Min_Heapify(A, root) do Min_Heapify on new root
*/

void Delete_Min(int queue[])
{
    int i, deleted; // variables declaration

    if (isEmpty()) // underflow condition
    {
        printf("Priority Queue is empty!!!!!!\n");
        return;
    }

     deleted =  queue[0]; // please keep me the element here before delete

     swap(&queue[0], &queue[SIZE - 1]); /* swap root node with  the last element of queue */

     SIZE = SIZE - 1; /* decrement A Min-Heap size */

   /*
    After swapping maybe the tree is not A min-heap any more so lets
    call Min-Heapify() to make sure that everything is ok */

    for (i = SIZE - 1; i >= 0; i--)
         Min_Heapify(queue, SIZE, 0); /* call Min_Heapify */

    // inform user the job is done
    printf("%d is been been dequeued from Priority Queue \n",deleted);

} /** END OF Delete_Min()*/


/** Utility function to Check if the Priority
    Queue(Min-Heap) is empty or not  */

int isEmpty()
{
    if(SIZE == 0)      /* empty case */
        return 1;
    return 0;          /* else case */
}


/**
    utility function to traverse the given array
     and print all the element */

void print_heap(int array [], int size)
{
    int i; // counter i declaration

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

    temp = *a; // store in temp value of a
    *a = *b; // store in a value of b

    // store in b value of a(we have value of variable a stored in temp)
    *b = temp;

}/** End of swap () */
