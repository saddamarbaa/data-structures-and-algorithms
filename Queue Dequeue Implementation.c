/**
    [PROGRAM] :  DEQUE (Double Ended Queue)Implementation Using Circular Array
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

   C Program to Implemented Double ended Queue using Circular Array

  Double Ended Queue is a generalized version of Queue data structure
  in which the insertion and deletion operations are allowed from both
  the ends (front and rear). That means, we can insert at both front and
  rear positions and can delete from both front and rear positions.
  also can say its liner queue in which inserting or deleting are performed
  at both the ends are from both Ends
  while Implementation DEQUE using circular array there are allot of corner
  cases we must take care of
  (Double Ended Queue) have property of both stack and queue

  types of Double Ended Queue
  Input Restricted Double Ended Queue
  Output Restricted Double Ended Queue

  In input restricted double-ended queue, the insertion operation is performed
  at only one end and deletion operation is performed at both the ends.

  In output restricted double ended queue, the deletion operation is performed
  at only one end and insertion operation is performed at both the ends.

   for reference i will back to (Jenny's lectures CS/IT NET&JRF) channel
   very well explained
   1. https://youtu.be/pqg0SOPRlJ4
   2. https://youtu.be/WJres9mgiAk   */

#include <stdio.h>
#include <stdlib.h>

#define CAPCITY 6  // define size of queue

/* declare dequeue of Array globally so it
    can be use in all function */
int dequeue[CAPCITY];

int front = -1;  //front of queue

int rear = -1;  // real or tail of queue

//Function to push(add) elements into Front of queue
void enqueueFront(int element);

//Function to push(add) elements into rear of queue
void enqueueRear(int element);

//Function to dequeue(Delete an item from front of dequeue)
void dequeueFront();

//Function to dequeue(Delete an item from rear of dequeue)
void dequeueRear();

//function to Gets the front item from queue
int getFront();

//function to Gets the last item from queue
int getRear();

//function to traverse queue and Print the queue element
void printQueue();

//function to traverse queue and clear all it element
void clearQueue();

//function to Check if the queue is empty or not
int isEmpty();

// function to Check if the queue is full or not
int isFull();

// the  Driver Code
int main(int argc, char* argv[])
{
    int option, element; /* variable declarations */
    do
    {
        printf("Double ended Queue Implementation             :\n"); // push from front
        printf("1 : enqueueFront : (push from front)          :\n");  // push from rear
        printf("2 : enqueueRear  : (push from Rear)           :\n");
        printf("3 : dequeueFront : (delete from front)        :\n");  // dequeue from front
        printf("4 : dequeueRear  : (ddelete from rear)        :\n");   // dequeue from rear
        printf("5 : print all element in queue                :\n");
        printf("6 : getFront : (Gets front item in queue)     :\n");      //Gets the front item from queue.
        printf("7 : getRear  : (Gets last item in queue)      :\n");      // Gets the last item from queue.
        printf("8 : clear queue:(delete all item in queue)    :\n");      //delete all the element in queue
        printf("0 : Enter 0 to exit (quit)                    :\n");

        // asking user to enter choice
        printf("input your choice                             :");
        scanf("%d",&option);

        switch(option)
        {
            // case 1 insert new element to Queue from front
            case 1:
                printf("Enter element to enqueue from front : ");
                scanf("%d",&element);
                enqueueFront(element); // call enqueueFront function
             break;

             // case 2 insert new element to Queue from Rear
             case 2:
                printf("Enter element to enqueue from Rear : ");
                scanf("%d",&element);
                enqueueRear(element); // call enqueueRear function
             break;

             // case 3 dequeue element from front of queue
             case 3:
                 dequeueFront(); // call dequeueFront function
             break;

             // case 4 dequeue element from Rear of queue
             case 4:
                 dequeueRear(); // call dequeueRear function
             break;

             // case 5 traverse Queue and print it value
             case 5:
                printQueue(); // call printQueue function
             break;

             // case 6 Gets the front item in queue
             case 6 :
                if (isEmpty()) // if queue is empty
                     printf ("Queue Underflow!!!  \n");
                else
                {
                    element = getFront(); // call getFront()
                    printf("front element in is -->  %d\n",element);
                }
              break;

              // case 7 Gets the Rear item in queue
              case 7 :
                if (isEmpty()) // if queue  empty
                     printf ("Queue Underflow!!! \n");
                else
                {
                    element = getRear(); // call getRear()
                    printf("Rear element in is -->  %d\n",element);
                }
               break;

              // case 8 clear all the element in queue
              case 8:
                clearQueue(); // call clearQueue() function
              break;

             case 0:  // case 0 Exit case
              printf("time to exit thanks\n");
             _Exit(0);

             default: // default case
              printf("invalid input\n");
             break; // no need break after default case I use it only for readability

         }/** END of switch */

    } while(1); /** END OF DO WHILE LOOP */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  A utility function to push new given element to queue using front */

void enqueueFront(int  element)
{
    // check if queue is full as queue will be full only in 2 causes below
    //  if( (front == 0 && rear ==  CAPCITY - 1 ) ||( front == rear +1 ) )
    if(isFull()) // queue is full condition
    {
        printf("Queue Overflow!!!\n");
        return;
    }
    // second cause if both front and rear == -1 is mean queue
    // is empty  move both of them to zero then add from front
    else if(isEmpty()) // queue is is empty condition
    {
        front = rear = 0;  // move both to = 0
        // now add from front
        dequeue[front] = element;  // first element in queue
    }
    /*
    if front == 0 and you are calling  enqueueFront ()
    in this cause you first set front to CAPCITY - 1( front = CAPCITY - 1)
    to make it circular queue then you can add */
    else if(front == 0)
    {
        front = CAPCITY - 1;      // now is circular
        dequeue[front] = element;   // now add from front
    }
    // part then above condition just decrement front then enqueue the new value from front
    else
    {
        front = front - 1;    //decrement front
        dequeue[front] = element;  // now add from front
    }

    printf("%d  been push to queue\n", element); // inform  user the element is been added

} /** End of enqueueFront() */


/**
  A utility function to push new given element to queue using Rear */

void enqueueRear(int element)
{
    // check if queue is full as queue will be full only in 2 causes below
    //  if( (front == 0 && rear ==  CAPCITY - 1 ) ||( front == rear +1 ) )
    if(isFull()) // queue is full condition
    {
        printf("Queue Overflow!!!\n");
        return;
    }
    // second cause if both front and rear == -1 is mean queue
    // is empty  move both of them to zero then add from Rear
    else if(isEmpty()) // queue is is empty condition
    {
        front = rear = 0;  // move both to = 0
        // now add from Rear
        dequeue[rear] = element;  // first element in queue
    }
    /*
    if rear = CAPCITY - 1 and you are calling enqueueRrear()
    in this cause first set rear to zero(rear == 0)
    to make it circular queue then you can add  from rear*/
    else if(rear == CAPCITY - 1 )
    {
        rear = 0;                   // now is circular
        dequeue[rear] = element;   // now add from rear
    }
    // part then above condition  just increment rear then enqueue the new value from rear
    else
    {
        rear = rear + 1;      // increment rear
        dequeue[rear] = element;   // enqueue the new element from rear
    }
    printf("%d  been push to queue\n", element); // inform  user the element is been added

} /** End of enqueueRear() */


/**
 utility function to dequeue(remove) an item from front of queue. */

void dequeueFront()
{
    int deleted;  // variable declaration to keep the element before deleted

    //if queue is empty then we dont have any element to dequeue
    if(isEmpty()) // queue is empty condition
    {
       printf ("Queue Underflow!!!  \n");
       return;
    }

    deleted = dequeue[front];  // keep the element first

    /*
     if (front ==  rear) both front and rear are pointing to the same
     element that mean there is only one element on queue now after delete
     that one queue is empty so set both  front and rear to -1(front = rear = -1)
   */
    if (front ==  rear)   // case when queue have only one element on list
        front = rear = -1;   // delete first then  move both to = -1

    /*
    if front = CAPCITY - 1  so front is in the last index now and you are
    calling dequeueFront() in this case after deleting the front element
    set front back to zero (front == 0) to make it circular queue*/
    else if(front == CAPCITY - 1)
          front = 0; // to make circular

     /*
     part then above condition in all other causes just delete(queue[front]))
     first then increment front by one( front = front + 1) */
    else
      front = front + 1;      //  then increment front

    printf ("%d been dequeued  \n", deleted);  // inform user the job is done

}/** End of dequeueFront() */

/**
 utility function to dequeue(remove) an item from Rear of queue. */

void dequeueRear()
{
    int deleted;  // variable declaration to keep the element before deleted

    //if queue is empty then we dont have any element to dequeue
    if(isEmpty()) // queue is empty condition
    {
       printf ("Queue Underflow!!! \n");
       return;
    }

    deleted = dequeue[rear];  // keep the element first

    /*
     if (front ==  rear) both front and rear are pointing to the same
     element that mean there is only one element on queue now after delete
     that one queue is empty so set both  front and rear to -1(front = rear = -1)
   */
    if (front ==  rear)   // case when queue have only one element on list
        front = rear = -1;   // delete first then  move both to = -1

    /*
    if rear == 0 and you are calling dequeueRear()
    in this cause you first printf the value or we can say dequeue first
    then after that set rear to CAPCITY - 1( rear = CAPCITY - 1;)  to make it circular queue */
    else if(rear == 0)
          rear  = CAPCITY - 1; // to make circular

     /*
     part then above condition in all other causes just dequeue
     (queue[rear])) then decrement rear by one ( rear  =  rear  -1 ) */
    else
       rear  = rear - 1;    // decrement rear

    printf ("%d been dequeued  \n", deleted);  // inform user the job is done

}/** End of dequeueRear() */


/**
   Utility function to Check if the queue is empty or not here */

int isEmpty()
{
    if(front == -1 && rear == -1) /* empty case */
       return 1;
    else               /* else case */
      return 0;

}/** End of isEmpty() */


/**
   Utility function to Check if the queue is full or not
   dequeue will be full only in 2 causes if (front == 0 && rear ==  CAPCITY - 1 )
   or if( front == rear + 1 )
   and  this can be written like blow in one condition
  ((front == 0 && rear ==  CAPCITY - 1 ) ||( front == rear +1 ) )

  also there is anther  way  which we can write short condition like blow

 ((last + 1 ) % CAPCITY == first)

 Reference in future :---->
 https://youtu.be/dn01XST9-bI
 https://youtu.be/WJres9mgiAk  */

int isFull()
{
    if((front == 0 && rear ==  CAPCITY - 1 ) ||( front == rear + 1 ))
    //if ((rear + 1 ) % CAPCITY == front) // Circular Queue full case
        return 1;
    else // is not full
       return 0;

} /** End of isFull() */


/** Utility function to traverse the queue and print all the element */

void printQueue()
{
    if (isEmpty()) // if queue is already empty
    {
        printf ("Queue Underflow!!!  \n");
        return;
    }

    int i = front; // declare counter i at let start from front

    /*
     while we dont reach rear print all element but this not include rear
     value so after while loop we need to print last element which is queue[rear]
    */
    while(i != rear) // while condition is true go in loop and print
    {
        printf("%d\t", dequeue[i]);

        // to make it circular we cant just do i = i + 1
        // we must set i = (i + 1) %  CAPCITY;
         i = (i + 1) % CAPCITY;
    }

    /* after while loop now i == rear but we have one
       element left at last index let printed */
     printf("%d\n",dequeue[rear]);  // also can be queue[front]

} /**END of printQueue()*/


/**
  Utility function to clear the queue by deleting all the element */

void clearQueue()
{
    if (isEmpty()) // if queue is already empty
    {
        printf ("Queue Underflow!!!  \n");
        return;
    }
    else
     front = rear = -1; // deleting all the element

     printf("DeQueue is been cleared \n"); // inform user the job is done

} /** End of clearQueue() */


/** Utility function to return the front item from queue. */

int getFront()
{
    // now we are sure dequeue is not empty
    return dequeue[front]; // return front element in queue

} /** End of fron()() */


/** Utility function to return the Rear item from queue. */

int getRear()
{
    return dequeue[rear]; // return Rear element in queue

} /** End of rear()() */
