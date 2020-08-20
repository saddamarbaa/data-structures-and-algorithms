/**
    [PROGRAM] :  A Max-Heap Data Structure
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    Heap is Tree-based data structure in which the tree is a complete
    binary tree so A Max-Heap is a complete binary tree that satisfies the
    heap property. It is also called as a binary heap.
 
    A complete binary tree is a binary tree in which every level,
    except possibly the last level,is completely filled, and all nodes
    are as far left as possible.

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
#define MAX_HEAP_SIZE 50

/* define Global A Max-Heap size start by zero */
// the number of element are currently in A Max-Heap
int SIZE = 0;

// Function to find the Max-Heap size
void find_Size();

// function to search if the given element
// is present in Max-Heap or not
int Contain(int [] , int);

//Function to push(add) element into A Max-Heap
void insert(int [], int );

// Function to MaxHeapify the tree
void Max_Heapify(int [], int, int );

// Function to delete(remove)the maximum element
// from A Max-Heap
void Delete_Max(int []);

// function to Remove the given element from A Max-Heap
void Remove(int [], int);

// Function to find the maximum element in A Max-Heap
int find_Max();

//function to traverse A Max-Heap and Print it the elements
void print_heap(int [], int);

// function to swap values of two variables
void swap(int *a, int *b);

// function to Check if the A Max-Heap is empty or not
int isEmpty();

// function to clear the A Max-Heap
void clearHeap();

// the  Driver Code
int main()
{
    int array[MAX_HEAP_SIZE]; // array declaration

    while(1)
    {
        int ch; //for switch  to  choice
        int element; // element
        printf("A Max-Heap data structure Implementation      : \n");
        printf("1 : insert New element to A Max-Heap          : \n");
        printf("2 : Search for element in A Max-Heap          : \n");
        printf("3 : find the maximum element in A Max-Heap    : \n"); // return max
        printf("4 : Delete the maximum element in A Max-Heap  : \n"); //delete the max
        printf("5 : Remove given element from A Max-Heap      : \n"); //delete the given element
        printf("6 : clear A Max-Heap                          : \n"); //delete all the element in heap
        printf("7 : Print all the element of the A Max-Heap   : \n");
        printf("8 : find the Max-Heap size                    : \n");
        printf("0 : quit                                      : \n");
        // asking user to enter choice
        printf("input your choice                             : ");
        scanf("%d",&ch);
         switch(ch)
         {
            // case 1 insert new element to A Max-Heap
            case 1:
                printf("Enter element to insert in A Max-Heap : ");
                scanf("%d",&element);
                insert(array, element); // call insert function
            break;

            // case 2 traverse A Max-Heap and search for element
            case 2:
               printf("Enter element to searched in A Max-Heap : ");
               scanf("%d",&element);
               int index =  Contain(array, element); // call  Contain() function
               if(index != -1)
               printf("Yes %d is found at index : %d\n",element, index + 1);
               else
               printf("NO %d is not found !\n",element);
            break;

            // case 3 find the maximum element in A Max-Heap
            case 3:
              element = find_Max(array); // call find_Max()
              if(element)
                 printf("the maximum element in A Max-Heap is -->  %d\n",element);
              else
                printf("A Max-Heap is EMPTY!! \n");
            break;

            // case 4 delete the maximum element from A Max-Heap
            case 4:
                Delete_Max(array); // call Delete_Max function
            break;

            // case 5 Remove the given element from A Max-Heap
            case 5:
                printf("Enter element to removed  from A Max-Heap : ");
                scanf("%d",&element);
                Remove(array,element); // / call Remove function
            break;

            // case 6 clear all the element of A Max-Heap
            case 6:
                clearHeap(); // call clearHeap function
            break;

            // case 7 traverse A Max-Heap and print it value
            case 7 :
               print_heap(array, SIZE); // call print_heap function
            break;

            // case 8 find the Max-Heap size
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
    utility function to Insert Element into A Max-Heap

   Algorithm for insertion in A Max-Heap
   insert(A, value)
   2. if A Max-Heap is empty add the newNode as first node in beginning
   3. else (A Max-Heap is not empty)
      insert the newNode at the end (last node from left to right.)
     End If
   4. Max-Heapify the tree(so that the maximum node always be at the root)
    End insert
**/

void insert(int array[], int newValue)
{
    int i; // counter i declaration
    if(!newValue)   /* case when the given value is NULL */
       return;

    if(isEmpty())             /* case when the given value is the first element */
    {
        array[0] = newValue;   /* insert at start (first index) */
        SIZE = SIZE + 1;        /* increment the Max-Heap size by one */
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
    printf("%d is been inserted to A Max-Heap \n", newValue);

} /** End of insert()*/


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

} /** END OF Max_Heapify() */


/** Utility function to find the maximum element in A Max-Heap  */

int find_Max(int array[])
{
    if(isEmpty())    // A Max-Heap is empty condition
      return 0;

    return array[0];  // else case return the maximum
} /** End of find_Max() */


/**
    function to search if the given element is present
    in A Max-Heap or not
    the function take 2 parameters
    (1) array Heap[]
    (2) target element named key  */

int Contain(int Heap[] , int key)
{
    if (isEmpty()) // underflow condition
         printf("A Max-Heap IS EMPTY!\n");
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
    if reach this line mean been searching until last index
    and the key is not found so let just return -1 to indicate
    that the key is not found */
    return -1;

}/** End of Contain() */


/**
    utility function to delete the maximum element in A Max-Heap .
    in A Max-Heap the maximum element is always present at root
    also we always delete the root node here
    there are two steps need to flow for deleting maximum --->
      1. Replace root element with last element in heap
      2. Max_Heapify(A, root) do Max_Heapify on new root

    Pseudo code for Delete_Max(A)
      FOR i --> Size - 1 down to  zero
      dO
      Max_Heapify(A[], 0) */

void Delete_Max(int array[])
{
    int i, deleted; // variables declaration
    if (isEmpty()) // underflow condition
    {
        printf("A Max-Heap is empty!!!\n");
        return;
    }
     deleted =  array[0]; // please keep me the element here before delete

     swap(&array[0], &array[SIZE - 1]); /* swap root node with  the last element of array */

     SIZE = SIZE - 1; /* decrement heap size */

   /*
    After swapping maybe the tree is not A Max-Heap any more so let
    call MaxHeapify() to make sure that everything is ok */

    for (i = SIZE - 1; i >= 0; i--)
         Max_Heapify(array, SIZE, 0); /* call Max_Heapify */

    // inform user the job is done
    printf("%d is been deleted from A Max-Heap \n",deleted);

} /** END OF Delete_Max()*/


/**
    utility function to Remove the given element from A Max-Heap
      here are the steps --->
      1. first search for the nodeToBeDeleted
      2. if is not found then we are done just return
      3. if found  then
      4. swap nodeToBeDeleted with the lastLeafNode
      5. decrement Max-Heap size
      2. Max_Heapify the array  */

void Remove(int array[], int key)
{
    int i, deleted, index; // variables declaration

    if (isEmpty()) // underflow condition
    {
        printf("A Max-Heap is empty!!! \n");
        return;
    }

    // search for element first if its found then removed
    index = Contain(array, key); // call Contain function

    if(index != -1)
    {
        // please keep me the element here before delete
        deleted =  array[index];

        /* swap the given element with  the last element of array */
        swap(&array[index], &array[SIZE - 1]);

        SIZE = SIZE - 1; /* decrement Max-Heap size */

       /*
        After removing element maybe the tree is not A Max-Heap
        any more so let call MaxHeapify() to make sure that everything*/

        for (i = SIZE - 1; i >= 0; i--)
             Max_Heapify(array, SIZE, 0); /* call Max_Heapify */

        // inform user the job is done
        printf("%d is been deleted from A Max-Heap \n",deleted);
    }

} /** END OF Remove()*/


/**
   Utility function to clear the A Max-Heap
   clearing heap meaning deleting all the heap element */

void clearHeap()
{
    SIZE = 0; /* clear A Max-Heap  by setting heap size back to zero */
    printf("A Max-Heap is been cleared \n"); // inform user the job is done

} /* END of clearHeap() */


/** Utility function to find the  Max-Heap size */

void find_Size()
{
    if(isEmpty())    //  is empty condition
       printf("A Max-Heap is EMPTY NOW!! \n");
    else
    printf(" A Max Heap size is ---> %d\n",SIZE);

} /** End of find_Size() */


/** Utility function to Check if the Max-Heap is empty or not here */

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
    if (isEmpty()) // underflow condition
    {
        printf("Max Heap is empty !!!\n") ;
        return;
    }

     /* printing elements of an array(A Max-Heap) */
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
