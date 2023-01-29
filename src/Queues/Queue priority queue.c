/**
    [PROGRAM] :  Priority Queue(A Max-Heap)
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

     A priority Queue Implementation using A Max-Heap data structure
     A priority queue is a special type of queue in which element are
     store according to their priority and not on Particular order .

     the difference between Priority Queue and Normal Queue is that
     In a queue we flow FIFO the first-in-first-out rule however
     in a priority queue, we remove element according to their priority
     The element with the highest priority is removed first.

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
    (10)https://youtu.be/HqPJF2L5h9U*/

#include <stdio.h>
#include <stdlib.h>

// define the maximum queue size
#define Max_Queue_Size 50

/* define Global Priority Queue size initialize by zero */
int SIZE = 0;

// Function to find the Priority Queue size
void find_Size();

// function to search if the given element
// is present in Priority Queue or not
int Contain(int [] , int);

//Function to push(add) element into Priority Queue
void enqueue(int [], int );

// Function to MaxHeapify the tree
void Max_Heapify(int [], int, int );

// Function to delete(remove)the maximum element
// from Priority Queue
void Delete_Max(int []);

// function to Remove the given element
// from Priority Queue
void Remove(int [], int);

// Function to find the maximum element in Priority Queue
int find_Max();

//function to traverse queue and Print it the elements
void print_Queue(int [], int);

// function to swap values of two variables
void swap(int *a, int *b);

// function to Check if the queue is empty or not
int isEmpty();

// function to clear the Priority Queue
void clear_Queue();

// the  Driver Code
int main()
{
    int queue[Max_Queue_Size]; // queue array declaration

    while(1)
    {
        int ch; //for switch  to  choice
        int element; // element
        printf("A priority Queue Implementation using A Max-Heap  : \n");
        printf("1 : insert New element to priority Queue          : \n");
        printf("2 : Search for element in priority Queue          : \n");
        printf("3 : find the maximum element in priority Queue    : \n"); // return max
        printf("4 : Delete the maximum element in priority Queue  : \n"); //delete the max
        printf("5 : Remove given element from priority Queue      : \n"); //delete the given element
        printf("6 : clear priority Queue                          : \n"); //delete all the element in heap
        printf("7 : Print all the element of the priority Queue   : \n");
        printf("8 : find the priority Queue size                  : \n");
        printf("0 : quit                                          : \n");
        // asking user to enter choice
        printf("input your choice                                 : ");
        scanf("%d",&ch);
         switch(ch)
         {
            // case 1 insert new element to priority Queue
            case 1:
                printf("Enter element to insert in priority Queue : ");
                scanf("%d",&element);
                enqueue(queue, element); // call insert function
            break;

            // case 2 traverse priority Queue and search for element
            case 2:
               printf("Enter element to searched in priority Queue : ");
               scanf("%d",&element);
               int index =  Contain(queue, element); // call  Contain() function
               if(index != -1)
               printf("Yes %d is found at index : %d\n",element, index + 1);
               else
               printf("NO %d is not found !\n",element);
            break;

            // case 3 find the maximum element in priority Queue
            case 3:
              element = find_Max(queue); // call find_Max()
              if(element)
                 printf("the maximum element in priority Queue is -->  %d\n",element);
              else
                printf("Priority Queue is EMPTY!! \n");
            break;

            // case 4 delete the maximum element from Priority Queue
            case 4:
                Delete_Max(queue); // call Delete_Max function
            break;

            // case 5 Remove the given element from A Max-Heap
            case 5:
                printf("Enter element to removed  from Priority Queue : ");
                scanf("%d",&element);
                Remove(queue,element); // / call Remove function
            break;

            // case 6 clear all the element of Priority Queue
            case 6:
                clear_Queue(); // call clear_Queue function
            break;

            // case 7 traverse Priority Queue and print it value
            case 7 :
               print_Queue(queue, SIZE); // call print_Queue function
            break;

            // case 8 find the Priority Queue size
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

    utility function to Insert Element into a priority queue (max-heap)

   Algorithm for insertion in a priority queue (max-heap)
   insert(A, value)
   1. if queue is empty add the newNode as first node in beginning
   2. else (queue is not empty)
      insert the newNode at the end (last node from left to right.)
     End If
   3. Max-Heapify the tree(so that the maximum node always be at the root)
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
        SIZE = SIZE + 1;         /* increment the Max-Heap size by one */

        /*
        after adding new node maybe the tree is not A Max-Heap any more
        so let call MaxHeapify() to make sure that everything is ok
        so far but the question here is why we start looping from
        SIZE / 2 - 1 down to zero? that is because the tree is complete
        tree and in complete tree the half of the nodes are leave node */

        for(i = SIZE / 2 - 1; i >= 0; i--)
            Max_Heapify(array, SIZE, i); // call Max_Heapify()

    } /** End of else */

    // inform user the job is done
    printf("%d  been push to queue \n",newValue);

    /** Time complexity of of inserting is O(Logn). */

} /** End of enqueue()*/



/**
   utility function to Max_Heapify the tree

    Heapify is the process of creating a heap data structure from
    a binary tree. here we used to create Max-Heap so whenever we call
    this function it will Rearrange a heap to maintain the Max-Heap property,
    A Max-Heap property → The value of a node is greater than or equal to
    the value of its children i.e., A[Parent[i]] ≥ A[i] for all nodes i>1.

    here are the creating A Max-Heap  steps --->
    1. get array input from user(we are done with this in insert function)
    2. Create a complete binary tree from the array
      (we are done with this also in  insert function)
    3. Start from the first index of non-leaf node whose
       index is given by  size/2 - 1.
    4. Set current element i as largest.
    5. The index of left child is given by 2 * i + 1 and the
       right child is given by 2 * i + 2.
      If leftChild is greater than currentElement(i.e. element at ith index)
       then set leftChildIndex as largest.
      If rightChild is greater than element in largest
      then set rightChildIndex as largest
   6. if  largest != i  then
   7. Swap largest with currentElement
   8. Repeat steps 3-7 until the subtrees are also Max heapified.

   Pseudo code for Max_Heapify
   Max_Heapify(A[], size,  i)
    set i as largest
    leftChild = 2 * i + 1
    rightChild = 2 * i + 2
    if leftChild < size && A[leftChild] > A[largest])
       set leftChildIndex as largest
    END IF
   if rightChild <  size && A[rightChild] > A[largest])
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
        printf("only Single element in Priority Queue  !!\n");
        return; /* Priority Queue have only one element so no need to continue */
    }

    int largest = i;                 /* Initialize largest*/
    int leftChild   = 2 * i + 1;      /* calculate left Child = 2*i + 1*/
    int rightChild  = 2 * i + 2;       /* calculate right Child = 2*i + 2*/

    /*  If left child is larger than the largest */
    if (leftChild <= size && array[leftChild] > array[largest])
         largest = leftChild;  /*set leftChildIndex as largest */

    /* If right child is bigger than left child which the largest right now  */
    if (rightChild < size && array[rightChild] > array[largest])
         largest = rightChild;  /*set rightChild as largest */

    // If largest is not equal to i(mean root is not the largest)
    if (largest != i)
    {
        swap(&array[i], &array[largest]);  /* swap array[i] and array[largest] */

        /*
        after swapping maybe the tree is not max heap any more so let
        Recursively call MaxHeapify() to make sure that everything is ok */

        Max_Heapify(array, size, largest); /* Recursively call Max_Heapify */
    }

    /** Time complexity of Max_Heapify is O(Logn). */

} /** END OF Max_Heapify() */


/** Utility function to find the maximum element in Priority Queue  */

int find_Max(int array[])
{
    if(isEmpty())    // Queue is empty condition
      return 0;

    return array[0];  // else case return the maximum

} /** End of find_Max() */


/**
    function to search if the given element is present in Queue or not
    the function take 2 parameters
    (1) array  queue[]
    (2) target element named key  */

int Contain(int queue[] , int key)
{
    if (isEmpty()) // underflow condition
         printf("Priority Queue IS EMPTY!\n");
     else
     {
         // linear search until size -1
         for (int i = 0; i <= SIZE - 1; i++)
         {
             if (queue[i] == key) // base case
                return i; // we are done no need to continue return the index

         }/** End of for loop */

     } /** End of else */

    /*
    if reach this line mean been searching until last index
    and the key is not found so let just return -1 to indicate
    that the key is not found */
    return -1;

}/** End of Contain() */


/**
    utility function to delete the maximum element
    in Priority Queue(Max-Heap).
    in A Max-Heap the maximum element is always present at root
    also we always delete the root node here
    there are two steps need to flow for deleting maximum --->
      1. Replace root element with last element in Queue
      2. Max_Heapify(A, root) do Max_Heapify on new root

    Pseudo code for Delete_Max(A)
      FOR i --> Size - 1 down to  zero
      dO
      Max_Heapify(A[], 0) */

void Delete_Max(int queue[])
{
    int i, deleted;     // variables declaration
    if (isEmpty())    // underflow condition
    {
        printf("Priority Queue is empty!!!\n");
        return;
    }
     deleted =  queue[0]; // please keep me the element here before delete

     swap(&queue[0], &queue[SIZE - 1]); /* swap root node with  the last element in queue */

     SIZE = SIZE - 1; /* decrement queue size by one */

   /*
    After swapping maybe the tree is not A Max-Heap any more so let
    call MaxHeapify() to make sure that everything is ok */

    for (i = SIZE - 1; i >= 0; i--)
         Max_Heapify(queue, SIZE, 0); /* call Max_Heapify */

    // inform user the job is done
    printf("%d is been been dequeued from Priority Queue \n",deleted);

} /** END OF Delete_Max()*/


/**
    utility function to Remove the given element
    from Priority Queue(Max-Heap).
      here are the steps --->
      1. first search for the nodeToBeDeleted
      2. if is not found then we are done just return
      3. if found  then
      4. swap nodeToBeDeleted with the lastLeafNode
      5. decrement Max-Heap size
      2. Max_Heapify the queue  */

void Remove(int queue[], int key)
{
    int i, deleted, index; // variables declaration

    if (isEmpty()) // underflow condition
    {
        printf("Queue is empty(underflow condition) !!!!! \n");
        return;
    }

    // search for element first if its found then removed
    index = Contain(queue, key); // call Contain function

    if(index != -1)
    {
        // please keep me the element here before delete
        deleted =  queue[index];

        /* swap the given element with  the last element of array */
        swap(&queue[index], &queue[SIZE - 1]);

        SIZE = SIZE - 1; /* decrement Max-Heap(queue) size */

       /*
        After removing element maybe the tree is not A Max-Heap
        any more so let call MaxHeapify() to make sure that everything*/

        for (i = SIZE - 1; i >= 0; i--)
             Max_Heapify(queue, SIZE, 0); /* call Max_Heapify */

        // inform user the job is done
        printf("%d is been been dequeued from Priority Queue \n",deleted);
    }

} /** END OF Remove()*/


/**
   Utility function to clear Priority Queue(Max-Heap)
   clearing  meaning deleting all the element in queue */

void clear_Queue()
{
    SIZE = 0; /* clear Priority Queue (max-Heap)by setting heap size back to zero */
    printf("Priority Queue is been cleared \n"); // inform user the job is done

} /* END of clearHeap() */


/** Utility function to find size of the Priority Queue(Max-Heap) */

void find_Size()
{
    if(isEmpty())    //  is empty condition
       printf("Queue is empty(underflow condition) !!!!!!! \n");
    else
    printf("Queue size is ---> %d\n",SIZE);

} /** End of find_Size() */


/** Utility function to Check if the Priority
    Queue(Max-Heap) is empty or not here */

int isEmpty()
{
    if(SIZE == 0)      /* empty case */
        return 1;
    return 0;          /* else case */
}

/**
    utility function to traverse the given Queue
     and print all the element */

void print_Queue(int queue[], int size)
{
    int i; // counter i declaration
    if (isEmpty()) // underflow condition
    {
        printf("Queue is empty !!!\n") ;
        return;
    }

     /* printing elements of queue(A Max-Heap) */
     for(i = 0; i < size; ++i)
         printf("%d\t", queue[i]);

     printf("\n"); // insert new line after printing all element

 } /** End of print_Queue() */


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
