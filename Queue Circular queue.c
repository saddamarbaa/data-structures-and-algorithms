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

//function to  find the front element in queue
int find_front();

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
        printf("2 : dequeue                                  :\n"); //delete front
        printf("3 : find front                               : \n");
        printf("4 : print all the element of the queue       :\n");
        printf("5 : clear queue                              :\n"); //delete all the element in queue
        printf("0 : quit                                     :\n");

        // asking user to enter choice
        printf("input your choice                            :");
        scanf("%d",&ch);

         switch(ch)
         {
            // case 1 insert new element to Circular Queue
            case 1:
                printf("Enter element to enqueue : ");
                scanf("%d",&element);
                enqueue(element); // call enqueue function
            break;

            // case 2 dequeue element from Circular Queue
            case 2:
                dequeue(); // call dequeue function
            break;

            // case 3 find the front element in Circular Queue
            case 3:
              element = find_front(); // call find_front()
              if(element != -990)
                 printf("the front element in Circular Queue is -->  %d\n",element);

            break;

            // case 4 traverse Circular Queue and print it value
            case 4:
                trevers(); // call printQueue function
            break;

            // case 5 clear all the element in queue
            case 5:
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


/**
  A utility function to push new given element to queue
  Reference in future :---->
 https://youtu.be/dn01XST9-bI  */

void enqueue(int element)
{
    if(isFull()) // queue is full condition
    {
        printf("Queue is Full!!\n");
        return;
    }

    else if(isEmpty()) // queue is is empty condition
    {
        first = last = 0;
        queue[last] = element;  // first element in queue
    }
    else // queue is not full or empty we can add at last
    {
        last  = (last + 1 ) %  CAPCITY ;  // make sure to Circular queue
        queue[last] = element; // add at last as usual
    }
    printf("%d  been push to queue\n", element); // inform  user the element is been added

} /** End of enqueue() */


/**
     utility function to dequeue(remove)first
     element in queue (first in first out)
     Reference in future :---->
     https://youtu.be/dn01XST9-bI*/

void dequeue()
{
    int deleted;  // variable declaration to keep the element before deleted

    //if queue is empty then we dont have any element to dequeue
    if(isEmpty()) // queue is empty condition
    {
       printf ("Queue is empty \n");
       return;
    }

    else if (first == last)  // case when queue have only one element on list
    {
        deleted = queue[first]; // keep the elmenet

        first = last = -1;   // reset first and last back to -1

        // mean if queue have only one element after
        // removing that one queue will be empty
    }
    else// queue is not empty and have more than one element we can remove from start
    {
        deleted = queue[first]; // keep the elmenet
        first  = (first + 1 ) %  CAPCITY ;  // make sure to make Circular queue
    }

     printf ("%d been dequeued  \n", deleted);  // inform user the job is done

}/** End of dequeue() */


/**
   Utility function to Check if the queue is empty or not here */

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
   ((last + 1 ) % CAPCITY == first)

   Reference in future :---->
 https://youtu.be/dn01XST9-bI*/

int isFull()
{
    if ((last + 1 ) % CAPCITY == first) // Circular Queue full case
        return 1;

    else // is not full
       return 0;

} /** End of isFull() */


/** Utility function to traverse the queue and print
  all the element
  Reference in future :---->
 https://youtu.be/dn01XST9-bI*/

void trevers()
{
    /** while queue is not empty dequeue
       print the front element and dequeued */
    //while(!isEmpty())
    //{
        //printf("\n%d \n",find_front()); // print the element first
        //dequeue();               // now  dequeue that one out
    //}

    /** also  we can write in different way as blow */

    if (isEmpty()) // if queue is already empty
    {
        printf ("Queue is empty \n");
        return;
    }
    int  i = first; // declare counter i at let start from first
    while(i != last) // while condition is true go in loop and print
    {
        printf("%d\t", queue[i]);

        i = i + 1  % CAPCITY; // Circularly increment i
    }

    /* after while loop now i == last but we have one
       element left at last index let printed */

    printf("%d\t\n", queue[last]);  // also can be queue[last]

} /**END of trevers()*/


/**
  Utility function to clear the queue by deleting all the element */

void clearQueue()
{
    if (isEmpty()) // if queue is already empty
    {
        printf ("Queue is empty \n");
        return;
    }
    else
     first = last = -1; // deleting all the element

     printf("Circular Queue is been cleared \n"); // inform user the job is done

} /** End of clearQueue() */


/**

  Utility function return front of the queue
  first element enter in the queue  */

int find_front()
{
    if(isEmpty()) // queue is empty condition
    {
        printf ("Queue is empty \n");
        return  -990;
    }
    return queue[first]; // return first element in queue

} /** End of fron()() */

