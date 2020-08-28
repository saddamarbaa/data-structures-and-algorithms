/**
    [PROGRAM] :  DEQUE Data Structure Implementation Using Circular Array
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

 *
*  deque - Double Ended Queue
*
*  Implementation of DEQUE( Double Ended Queue) using circular array | Data structures

* Deque or Double Ended Queue is a generalized version of Queue data structure
* that allows insert and delete at both ends.
*
* also can say its linner queue which inserting or deleting opeariton are  from both Ends
*
* while Implementation using circular array there are alot of croner caess we must tacke care
*
*
* for reference back to (Jenny's lectures CS/IT NET&JRF) channel only and  GeeksforGeeks
*
* deque or (Double Ended Queue) have property of both stack and queue
*
* Operations on Deque:
*
* Mainly the following four basic operations are performed on queue:
*
*insertFront(): Adds an item at the front of Deque.
*insertLast(): Adds an item at the rear of Deque.
*deleteFront(): Deletes an item from front of Deque.
*deleteLast(): Deletes an item from rear of Deque.
*
* In addition to above operations, following operations are also supported
* getFront(): Gets the front item from queue.
* getRear(): Gets the last item from queue.
* isEmpty(): Checks whether Deque is empty or not.
* isFull(): Checks whether Deque is full or not.
*
* Applications of Deque:
* Since Deque supports both stack and queue operations, it can be used as both.
* The Deque data structure supports clockwise and anticlockwise rotations in O(1)
* time which can be useful in certain applications.
* Also, the problems where elements need to be removed and or added both ends can be
* efficiently solved using Deque
*
* See wiki page for another example of A-Steal job scheduling algorithm where Deque is used as deletions operation is required at both ends.
*/

#include <stdio.h>
#include "stdlib.h"
#include <cs50.h>

 #define CAPCITY 6  // define size of queue

 int queue[CAPCITY]; // queue shoud global becuse i will uese in all function
 int front = -1;      // front varible
 int rear =  -1;      // real or tail varible

 void enqueueFront(int element); // Adds an item at the front of Deque.

void enqueueRrear(int element); // also call insertLast(): Adds an item at the rear of Deque.

void dequeueFront() ;    //  Deletes an item from front of Deque.

void dequeueRear() ;    // also call *deleteLast(): Deletes an item from rear of Deque.

void getFront();      //    : Gets the front item from queue.

void getRear()  ;      //: Gets the last item from queue.

int isEmpty() ;     //: Checks whether Deque is empty or not.


int  isFull() ;       //: Checks whether Deque is full or not.

void  trevers();   // to display the element in dequeue

 void clearQueue();    //  delete all the element in queue

int main(int argc, char* argv[])
{
     while(1)
    {
        int ch;//for swtich  to chooce choice
         int element; // element
         printf("1 : enqueueFront : (push from front) :\n");  // push from front
         printf("2 : enqueueRear : (push from rear) :\n");    // push from rear
         printf("3 : dequeueFront : (dequeue from front) :\n");     // dequeue from front
         printf("4 : dequeueRear  : ( dequeue from rear) :\n");     // dequeue from rear
         printf("5 : print all the element  of the queue:\n");
         printf("6 : getFront  : (Gets the front item from queue.) :\n");       //Gets the front item from queue.
         printf("7 : getRear  :(Gets the last item from queue):\n");       // Gets the last item from queue.
         printf("8 : clear qeue: (delete all the element in queue) :\n"); //delete all the element in queue
         printf("0 : quit :\n");

         ch =get_int("input your choice :");

         switch (ch)
         {
            case 1:
            element = get_int("enter elemt to enqueue : ");
           enqueueFront(element);
             break;

            case 2:
            element = get_int("enter elemt to enqueue : ");
            enqueueRrear(element);
             break;

             case 3:
             dequeueFront() ;
             break;

              case 4:
              dequeueRear();
              break;

              case 0:
              printf("time to exit thanks\n");
              _Exit(0);

             case 5:
             trevers();
             break;

             case 6:
             getFront();
             break;


             case 7:
             getRear();
             break;


             case 8:
             clearQueue();  //delete all the element in queue
             break;

             default:
             printf("invalied input\n");
             break;
         }

    }


    return 0;

}


/**
 * to push new value to queue using front
 *
 * for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
 *  and  GeeksforGeeks
 */

void enqueueFront(int  element)
{

    // check if queue is full as queue will be full only in 2 causes below
    //  if( (front == 0 && rear ==  CAPCITY - 1 ) ||( front == rear +1 ) )

     if ( isFull() )
     {
       printf("sorry  the queue is full");
       printf("\n");
       return;

     }

     // secod cause if both front and rear == -1
     //  is mean queue is empty  move both of them to zero then add from front

     else if ( front == -1 && rear == -1)
     {
         front = rear = 0; // move both to = 0

         queue[front] =  element; // now add from front

        printf("%d  been push to dequeue from front side\n",element);

     }

     /* if front == 0 and you are calling  enqueueFront ()
     * in this cause you first set front  to CAPCITY - 1( front = CAPCITY - 1;)
     *  to make it circular queue then you can add
     */

     else if(front == 0)
     {
          front = CAPCITY - 1;    // now is circular

          queue[front] = element;   // now add from front

          printf("%d  been push to dequeue from front side\n",element);
     }


    // part then above condition  just decrement front then enqueue the new value from front

    else
    {
        front = front - 1;   //decrement front

        queue[front] = element;  // now add from front

       printf("%d  been push to dequeue from front side\n",element);
    }

}

/**
* to push new value to queue using rear
* or can say Adds an item at the rear of Deque.
*
*  for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
*  and  GeeksforGeeks
*/

void enqueueRrear(int element)
{
    // check if queue is full as queue will be full only in 2 causes below
    //  if( (front == 0 && rear ==  CAPCITY - 1 ) ||( front == rear +1 ) )

     if(isFull())
     {
       printf("sorry  the queue is full");
       printf("\n");
       return;
     }

     // secod cause if both front and rear == -1
     //  is mean queue is empty  move both of them to zero then add from rear

     else if ( front == -1 && rear == -1)
     {
         front = rear = 0; // move both to = 0

         queue[rear] =  element; // now add from rear

         printf("%d  been push to dequeue from rear\n",element);

     }

     // if rear = CAPCITY - 1  and you are calling  enqueueRrear ()
     // in this cause you first set rear to zero(rear = 0;)  to make it circular queue then you can add

     else if(rear == CAPCITY - 1 )
     {
          rear = 0; // now is circular

        queue[rear] =  element; // now add from rear

         printf("%d  been push to dequeue from rear\n",element);
     }

    // part then above condition  just inrement rear then enqueue the new value from rear

    else
    {
        rear = rear + 1;      // increment rear

        queue[rear] = element;   // enqueue the new element from rear

        printf("%d  been push to dequeue from rear\n",element);
    }
}


/**
 * Deletes an item from front of Deque.
 *
 * for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
 *
 */

void  dequeueFront()
{

   if (isEmpty())  //check first if queue is empty then there is no dequeue from fron
   {

      printf ("DeQueue is empty so no element to dequeue from fron \n");
      return;
   }

   /**
    * if (front ==  rear)  both front and rear are poting to same element
   *  that mean there is only one element on queue now after delete that one queue is empty
   *  so set both  front and rear to -1(front = rear = -1)
   */

     else if ( front ==  rear)
     {
         printf("%d  been dequeue it from front or rear same because both poting to same element \n",queue[front]);
         front = rear = -1; // delete first then  move both to = -1

     }

     /**
      * if front = CAPCITY - 1   so front is in the  last index now  and you are calling
      * dequeueFront () in this case after deleteing the front element set front back
      * to zero (front == 0) to make it circular queue
     */

     else if(front == CAPCITY - 1 )
     {
         printf("%d  been dequeue it from front \n",queue[front]);

         front = 0; // to make circular
     }

    /* part then above condition  in all other causes just delete (queue[front])) first
    * then increment front by one( front = front + 1;)
    */

    else
    {
        printf("%d  been dequeue it from front \n",queue[front]); // print first

        front = front + 1;      //  then increment front

    }

}


/**
*  also call * deleteLast():
*  Deletes an item from rear of Deque.
*
* for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
*/


void dequeueRear()
{
  if (isEmpty())  //check first if queue is empty then ther is no element to dequeue
   {
      printf ("DeQueue is empty so no element to dequeue from Rear\n");
      return;
   }


   /**
    * if (front ==  rear)  both front and rear are poting to same element
   *  that mean there is only one element on queue now after delete that one queue is empty
   *  so set both  front and rear to -1(front = rear = -1)
   */

     else if ( front ==  rear)
     {
         printf("%d  been dequeue it from front or rear same because both poting to same element \n",queue[rear]);
         front = rear = -1; // delete first then  move both to = -1

     }

     /**
     *  if rear == 0 and you are calling  dequeuerear()
     *  in this cause you first printf the value or we can say dequeue first
     *  then after that set rear  to CAPCITY - 1( rear = CAPCITY - 1;)  to make it circular queue
     *
     */

     else if(rear == 0)
     {
          printf("%d  been dequeue it from Rear \n",queue[rear]); // print first

          rear  = CAPCITY - 1;    // now is circular

     }


     /**
    *  part then above condition  in all other causes just first
    *  dequeue (queue[front])) then decrement rear ( rear  =  rear  -1 )
    */

    else
    {
        printf("%d  been dequeue it from Rear \n",queue[rear]); // print first

          rear  = rear - 1;    // decrement rear

    }

}



/**
 * Gets the front item from queue.
 *
 * for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
 */

void getFront()
{
   if (isEmpty())  //check first if queue is empty then ther is no element to get on front
   {
      printf ("DeQueue is empty so no element on front to get it\n");
      return;
   }
   else
   {
       // now we are sure dequeue is not empty so let return front elemt (queue[front])

       printf(" the front element is %d \n", queue[front]);
   }
}


/**
 *  Gets the last item from queue.
 *
 * for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
 * */


void getRear()
{
   if ( isEmpty() )  //check first if queue is empty then ther is no element to get
   {
      printf ("DeQueue is empty so no element on rear to get it\n");

   }
   else
   {
       // now we are sure dequeue is not empty so let return rear element (queue[rear])

       printf(" the rear element is %d \n", queue[rear]);
   }

}


/**
 * : Checks whether Deque is empty or not.
*   deuue will be empty only in one cause if ( front == -1 && rear == -1)
*/


int isEmpty()
{
    if ( front == -1 && rear == -1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}



/** Checks whether Deque is full or not.
*  deuue will be full only in 2 causes if (front == 0 && rear ==  CAPCITY - 1 )
*  or  if( front == rear +1 ) and can be writen like blow in one condition

*  go if( (front == 0 && rear ==  CAPCITY - 1 ) ||( front == rear +1 ) )
*  back to vedio for reference
*
*   for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
*/

int  isFull()
{
    if( (front == 0 && rear ==  CAPCITY - 1 ) ||( front == rear +1 ) )
    {
          return 1;
    }
       else
       {
           return 0;
       }
}


/** to display the element in dequeue
* dis print all the element between front and rear
* for this we need loop
*
* for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
*/


void trevers()
{
   if (isEmpty())  //check first if queue is empty then ther is no element to print
   {

      printf ("DeQueue is empty so no element print\n");
      return;
   }


    int i = front;  // i is on front now


    /* while we dont reach rear print all elemet  but this not include rear value
    * so after while loop we need to print last element which is queue[rear]
    */

    while (i !=  rear )
    {
        printf("%d\t ",queue[i]);

        i = (i + 1) %  CAPCITY;    // to make it circulr we cant do i = i+1 we must set i = (i + 1) %  CAPCITY;
    }

    printf("%d\t ",queue[rear]); // printing last element

    printf("\n");

 }





/**
*  delete all the element in queue
*/

void clearQueue()
{
    if ( isEmpty() )  //check first if queue is empty then there is no element to clear
     {
      printf ("DeQueue is allready  empty so no element clear\n");
      return;
     }

   // clear dequeue by seting both front and rear back to -1(front = rear = -1;)

   else
   {
       front = rear = -1;  // now dequeue become empty is been cleared

   }
   }


