/**
    [PROGRAM] :  Circular Queue Data Structure Implementation
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program for Circular Queue Data Structure
     Array Implementation */

#include <stdio.h>
#include <stdlib.h>

#define CAPCITY 6  // define size of queue

/*declare queue of Array globally so it
  can be use in all function */
int queue[CAPCITY];

int first = -1;  //front of queue

int last = -1;  // real or tail of queue

//Function to push(add) elements into queue
void enqueue(int element);

//Function to dequeue(remove)elements from queue
void dequeue();

//function to Check if the queue is empty or not
int isEmpty();

int fron ();

//function to traverse queue and Print the queue element
 void trevers();

//function to traverse queue and clear all it element
void clearQueue();

// function to Check if the queue is full or not
int isFull();

// the  Driver Code
int main(int argc, char* argv[])
{
    while(1)
    {
        int ch;//for switch  to  choice
        int element; // element
        printf("Circular Queue data structure implementation : \n");
        printf("1 : enqueue                                  :\n");
        printf("2 : dequeue                                  :\n"); //delete
        printf("3 : print all the element of the queue       :\n");
        printf("4 : clear queue                              :\n"); //delete all the element in queue
        printf("0 : quit                                     :\n");

        // asking user to enter choice
        printf("input your choice                            :");
        scanf("%d",&ch);

         switch(ch)
         {
            // case 1 enqueue new element
            case 1:
                printf("Enter element to enqueue : ");
                scanf("%d",&element);
                enqueue(element); // call enqueue function
            break;

            // case 2 dequeue element from queue
            case 2:
                dequeue(); // call dequeue function
            break;

            // case 3 traverse queue
            case 3:
                trevers(); // call printQueue function
            break;

            // case 4 clear all the element in queue
            case 4:
                clearQueue(); // call clearQueue() function
            break;

            case 0:  // case 0 Exit case
            printf("time to exit thanks\n");
            _Exit(0);

             default: // default case
             printf("invalid input\n");
             break; // no need break after default case I use it only for readability

         }/** END of switch */

    } /** END of while loop */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/** A utility function to push new given element to queue */

void enqueue(int element)
{
    if(isFull()) // queue is full condition
    {
        printf("Queue is Full!!\n");
    }
    else if(isEmpty()) // queue is isempty condition
    {
        first = last = 0;
        queue[last] = element;  // first element in queue
    }
    else
    {
        last =  (last + 1 ) %  CAPCITY ;  // make sure to make crricle queue
        queue[last] = element; // add at last as ususal
    }
    printf("%d  been push to queue\n", element); // inform  user the element is been added

} /** End of enqueue() */


/**
     utility function to dequeue(remove)first
     element in queue (first in first out)  */

void dequeue()
{
    // queue is empty condition
    //if queue is empty then we dont have any element to dequeue
    if(!isEmpty())
       printf ("Queue is empty \n");

    else if (first == last)  // if only one element on list
    {
        //printf (" %d been dequeue",queue[first]);

        first = last = -1;   // reset first and last back to -1

        // mean if queue have only one element after
        // removing that one queue will be empty
    }
    else
    {
        // printf (" %d been dequeue",queue[first]);

        first  = (first + 1 ) %  CAPCITY ;  // make sure to make Circular queue
    }

}/** End of dequeue() */


/**
   Utility function to Check if the queue is empty or not here
   Am saying that queue is empty if and only if (first == last) */

int isEmpty()
{
    if(first == -1 && last == -1) /* empty case */
       return 1;
    else               /* else case */
      return 0;

}/** End of isEmpty() */


/**
   Utility function to Check if the queue is full or not here
   Am saying that queue is full if and only if
   ((last + 1 ) % CAPCITY == first) */

int isFull()
{
    if ((last + 1 ) % CAPCITY == first) // Circular Queue full case
        return 1;

    else // is not full
       return 0;

} /** End of isFull() */


/** Utility function to traverse the queue and print all the element */

void trevers()
{
    /** while queue is not empty dequeue
       print the front element and dequeued */
    while(!isEmpty())
    {
        printf("\n%d \n",fron()); // print the element first
        dequeue();               // now  dequeue that one out
    }

} /**END of trevers()*/


/**
  Utility function to clear the queue by deleting all the element */

void clearQueue()
{
    if (isEmpty()) // if queue is already empty
        printf ("Queue is empty so no element to clear\n");
    else
     first = last; // deleting all the element

} /** End of clearQueue() */


/**

  Utility function return front of the queue
  first element enter in the queue  */


int fron()
{
    if(isEmpty()) // queue is empty condition
    {
        printf ("Queue is empty \n");
        return  1;
    }
    return queue[first]; // return first element in queue

} /** End of fron()() */



