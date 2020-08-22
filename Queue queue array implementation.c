/**
    [PROGRAM] :  Queue Data structure(FIFO)
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to implementation Queue data structure using array 
    Queue flow FIFO rule first in first out
     Reference in future :---->
     1. https://youtu.be/PGWZUgzDMYI
     2. https://youtu.be/PgSrOtEay04
     3. https://youtu.be/AeokgRec3GE
     4. https://youtu.be/N9ztp76dwp8
     5. https://youtu.be/gnYM_G1ILm0
     6. https://youtu.be/EXsR7HXlGLw
     7. https://youtu.be/9nEcSGdX5vY  */

#include <stdio.h>
#include <stdlib.h>

#define CAPCITY 6  // define size of queue

/*declare queue of Array globally so it can be use in all function */
int queue[CAPCITY];

int first = 0; //front of queue

int last = 0; // real or tail of queue

//Function to push(add) elements into queue
void enqueue(int element);

//Function to dequeue(remove)elements from queue
void dequeue();

//function to Check if the queue is empty or not
int isEmpty();

//function to traverse queue and Print the queue element
void printQueue();

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
        printf("Queue data structure implementation     : \n");
        printf("1 : enqueue                             :\n");
        printf("2 : dequeue                             :\n"); //delete
        printf("3 : print all the element of the queue  :\n");
        printf("4 : clear queue                         :\n"); //delete all the element in queue
        printf("0 : quit                                :\n");

        // asking user to enter choice
        printf("input your choice                       :");
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
                printQueue(); // call printQueue function
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
       printf("Queue is Full!!\n");

       /*
       now we are sure queue is not full so let add at rear then
       increment last by one so can be ready for next coming element */

    else
    {
        queue[last] = element; // add the given element to queue

        last++; // increment last by one

        printf("%d  been push to queue\n",element); // inform  user the element is been added
    }
} /** End of enqueue() */


/**
     utility function to dequeue(remove)first
     element in queue (first in first out)  */

void dequeue()
{
    // queue is empty condition
    //if queue is empty then we dont have any element to dequeue
    if(isEmpty())
       printf ("Queue is empty \n");
    else
    {
        // inform user that  the front queue element is been remove
         printf("%d  been dequeue \n",queue[first]);

         /*
         now we have an empty place left in Zero index of Array
          so lets start from  zero index until last - 1 we shift
          the element(queue[i] = queue[i+1]) so that no empty index
          will be left in queue and lastly decrement rear of queue
          by one (last--) */

            for(int i = first; i < last -1 ; i++)
            {
                queue[i] = queue[i+1]; //shfiting
            }
            last--; // decrement rear
        }

}/** End of dequeue() */


/**
   Utility function to Check if the queue is empty or not here
   Am saying that queue is empty if and only if (first == last) */

int isEmpty()
{
    if (first == last) /* empty case */
        return 1;
    else               /* else case */
        return 0;

}/** End of isEmpty() */


/**
   Utility function to Check if the queue is full or not here
   Am saying that queue is full if and only if (last == CAPCITY) */

int isFull()
{
    if(last == CAPCITY) // is empty full
        return 1;

    else // is not full
       return 0;
} /** End of isFull() */


/** Utility function to traverse the queue and print all the element */

void printQueue()
{
    if(isEmpty()) // queue is empty condition
    {
        printf("Queue is empty so no element print\n");
    }
    else
    {
        printf("queue contain the flowing element :-->\n");
        // now we can print
        for (int i = first; i < last; i++)
        {
            printf(" %d \t",queue[i]);
        }
        printf("\n");
    }

} /**END of printQueue()*/


/**
  Utility function to clear the queue by deleting all the element */

void clearQueue()
{

    if (isEmpty()) // if queue is already empty
        printf ("Queue is empty so no element to clear\n");
    else
     first = last; // deleting all the element

} /** End of clearQueue() */
