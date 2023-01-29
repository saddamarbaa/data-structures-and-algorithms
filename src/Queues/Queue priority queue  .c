/**
    [PROGRAM] :  Priority Queue(A Min-Heap)
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

     A priority Queue Implementation using A Min-Heap data structure
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

// Function to Min-Heapify the tree
void Min_Heapify(int [], int, int );

// Function to delete(remove)the minimum element
// from Priority Queue
void Delete_Min(int []);

// function to Remove the given element
// from Priority Queue
void Remove(int [], int);

// Function to find the minimum element in Priority Queue
int find_Min();

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
        printf("A priority Queue Implementation using A Min-Heap  : \n");
        printf("1 : insert New element to priority Queue          : \n");
        printf("2 : Search for element in priority Queue          : \n");
        printf("3 : find the minimum element in priority Queue    : \n"); // return min
        printf("4 : Delete the minimum element in priority Queue  : \n"); //delete the  minimum
        printf("5 : Remove given element from priority Queue      : \n"); //delete the given element
        printf("6 : clear priority Queue                          : \n"); //delete all the element in queue
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
                enqueue(queue, element); // call enqueue function
            break;

            // case 2 traverse priority Queue and search for element
            case 2:
               printf("Enter element to searched in priority Queue : ");
               scanf("%d", &element);
               int index =  Contain(queue, element); // call  Contain() function
               if(index != -1)
               printf("Yes %d is found at index : %d\n",element, index + 1);
               else
               printf("NO %d is not found !\n",element);
            break;

            // case 3 find the minimum element in priority Queue
            case 3:
              element = find_Min(queue); // call find_Min()
              if(element)
                 printf("the minimum element in priority Queue is -->  %d\n",element);
              else
                printf("Priority Queue is EMPTY!! \n");
            break;

            // case 4 delete the minimum element from Priority Queue
            case 4:
                Delete_Min(queue); // call Delete_Min function
            break;

            // case 5 Remove the given element from Priority Queue
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


/** Utility function to find the minimum element in Priority Queue */

int find_Min(int array[])
{
     if(isEmpty())    // A Priority Queue is empty condition
      return 0;
    return array[0];  // else case return the minimum

} /** End of find_Min() */


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


/**
    utility function to Remove the given element
    from Priority Queue(Min-Heap).
      here are the steps --->
      1. first search for the nodeToBeDeleted
      2. if is not found then we are done just return
      3. if found  then
      4. swap nodeToBeDeleted with the lastLeafNode
      5. decrement Min-Heap size
      2. Min_Heapify the queue  */

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

        SIZE = SIZE - 1; /* decrement Min-Heap(queue) size */

       /*
        After removing element maybe the tree is not A Min-Heap
        any more so let call Min_Heapify() to make sure that everything is ok*/

        for (i = SIZE - 1; i >= 0; i--)
             Min_Heapify(queue, SIZE, 0); /* call Min_Heapify */

        // inform user the job is done
        printf("%d is been been dequeued from Priority Queue \n",deleted);
    }

} /** END OF Remove()*/


/**
   Utility function to clear Priority Queue(Min-Heap)
   clearing  meaning deleting all the element in queue */

void clear_Queue()
{
    SIZE = 0; /* clear Priority Queue (Min-Heap)by setting heap size back to zero */
    printf("Priority Queue is been cleared \n"); // inform user the job is done

} /* END of clearHeap() */


/** Utility function to find size of the Priority Queue(Min-Heap) */

void find_Size()
{
    if(isEmpty())    //  is empty condition
       printf("Queue is empty(underflow condition) !!!!!!! \n");
    else
    printf("Queue size is ---> %d\n",SIZE);

} /** End of find_Size() */


/** Utility function to Check if the Priority
    Queue(Min-Heap) is empty or not  */

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

     /* printing elements of queue(Min-Heap) */
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
