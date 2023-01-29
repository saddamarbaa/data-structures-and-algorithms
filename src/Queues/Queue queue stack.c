/**
    [PROGRAM] :  Queue Data Structure Implementation Using Stack
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

   C Program to Implemented Queue data structure using Stack
   Queue flow FIFO rule first in first

   to implement queue using stack and flow all queue data structure
   rules(FIFO)first in first out we need two stack for that because
   stack flow different rule Last In First Out (LIFO,FILO) one things
   to remember we are implementing queue here so we use two stack first
   stack for enqueue operation but when we want dequeue stack one give us
   the first element but we need the last element so for that we first pop
   all element from stack one to stack two by now element which was last in
   stack one its on top(first) in stack two then is easy to dequeue .
   with that been said enqueue operation will be done from stack one
   and dequeue operation will be done from stack 2.
   in this case enqueue operation take Big(O1)and dequeue operation big(On)

   for reference i will back to (Jenny's lectures CS/IT NET&JRF) channel
   very well explained
   1. https://youtu.be/9crZRd8GPWM
   Reference in future :---->
   1. https://youtu.be/9crZRd8GPWM   */

#include <stdio.h>
#include <stdlib.h>
#define CAPCITY 6  // define size of queue
int stack1[CAPCITY];  // first stack for enqueue declarations

int stack2[CAPCITY];   // second stack for dequeue declarations

/* top of stack1 variable global declaration and initializations to -1 */
int top1 = -1;

/* top of stack2 variable global declaration and initializations to -1 */
int top2 = -1;

int count = 0; // i will count later as counter

// Function to push(add) elements into queue
void enqueue(int);

// Function to push(add) elements into stack1
void push1(int);

// Function to push(add) elements into stack2
void push2(int);

// Function to pop(remove)top elements from stack1
int pop1();

// Function to pop(remove)top elements from stack 2
int pop2();

//Function to dequeue(remove)elements from queue
void dequeue();

//function to traverse queue and Print the queue element
void printQueue();

//function to traverse queue and clear all it element
void clearQueue();

// function to Check if the Stack1(queue)is full or not
int isFull1();

// function to Check if the Stack2 is full or not
int isFull2();

//function to Check if the queue is empty or not
int isEmpty();


// the  Driver Code
int main(int argc, char* argv[])
{
    int option, element; /* variable declarations */
    do
    {
        printf("Queue Implementation Using Stack        : \n");
        printf("1 : enqueue                             :\n");
        printf("2 : dequeue                             :\n");
        printf("3 : print all element in queue          :\n");
        printf("4 : isEmpty()                           :\n");
        printf("5 : isFull()                            :\n");
        printf("6 : count()                             :\n");
        printf("7 : clear queue                         :\n");
        printf("0 : Enter 0 to exit (quit)              :\n");
        // asking user to enter choice
        printf("input your choice                       :");
        scanf("%d",&option);

        switch(option)
        {
            // case 1 enqueue new element to queue
            case 1:
                printf("Enter an item to enqueue to queue : ");
                scanf("%d",&element);
                enqueue(element); // call enqueue function
            break;
            // case 2 dequeue element from queue
            case 2:
                dequeue(); // call dequeue function
            break;             // case 3 traverse queue
            case 3:
                printQueue(); // call printQueue function
            break;
            // case 4 Check if the Queue is empty or not
            case 4:
                if (isEmpty())    // call isEmpty function
                    printf("Queue is Empty\n");
               else
                   printf("Queue is not Empty\n");
            break;
            // case 5 Check if the Queue is full or not
            case 5 :
              if (isFull1())    // call isFull function
                  printf("Queue is Full\n");
              else
                  printf("Queue is not Full\n");
            break;
            // case 6 Get the number of items in the Queue
            case 6 :
               if (isEmpty()) // if Queue is empty
                   printf ("Queue Underflow \n");
               else
                  printf("number of element in Queue are : %d \n", count);
            break;
            // case 7 clear all the element in Queue
            case 7 :
                clearQueue(); // call clear_Queue function
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
   A utility function to push new given element to queue
   push the element into stack1  */

void enqueue(int element)
{
    // queue is full condition
    // is stack one is full then queue is full
    if (isFull1()) // queue is full condition
       printf("Queue is Full!!(Queue is in overflow)\n");

    else /* now we are sure queue is not full so let call push1 and given the element to add */
    {
        push1(element); // push element to satck1
        count++;  // i will use count in dequeue operation in loop latter
    }
} /** END OF enqueue() */

/**
 utility function to dequeue(remove) first element in queue
 (first in first out).
  first pop all the element from stack1 and push  to stack2 until
  stack1 became empty.
  hen pop the first element from stack2 to be dequeue after that push
  the remaining element back to satck1  */

void dequeue()
{
    int temp, dequeue_element, i;  // variables declarations

    if (isEmpty()) // if queue is  empty
        printf ("Queue Underflow \n");
    else
    {
        for(i = 0; i < count; i++)
        {
            //  pop1 element from stack1 and push2 to stack2
            // until stack1 become empty
            temp = pop1();              // pop from stack1
            push2(temp);                // push to satck2
        }

        // pop from the stac2 only one element which last element to be dequeue
        dequeue_element =  pop2();
        printf("%d  been dequeue out \n", dequeue_element);//inform user the job is done

        // after pop element now count should be decremented be by one
        count = count - 1;

        // after you dequeued one element push the reaming element back to stack 1
        for(i = 0; i < count; i++)
        {
            temp = pop2();              // pop from stack2
            push1(temp);                // push back to satck1 again
        }
    }

}/** End of dequeue() */


/** Utility function to traverse the queue and print all the element
    printing should be done from stack1  because after
    dequeue all the element are already added back to satck1
*/

void printQueue()
{
    int i ; // counter variable i declarations
    if (isEmpty()) // queue is empty condition
        printf ("Queue Underflow\n");
    else
    {
        printf("queue contain the flowing element :-->\n");
        for (i = 0; i <= top1; i++)
             printf(" %d \t",stack1[i]);
        printf("\n"); // go new line after printing all the queue element
    }

} /** End of printQueue */


/**
  Utility function to clear the queue by deleting all the element */

void clearQueue()
{
    if (isEmpty()) // if queue is empty
        printf ("Queue Underflow \n");
    else
    {
        top1 = top2 = -1; // deleting all the element
        printf("Queue is been cleared\n"); /* inform user the job is done*/
    }

} /** End of clearQueue() */


/** A utility function to push the given element to stack1(queue)
   If there is no place for new item, stack is in overflow state */

void push1(int element)
{
    if (isFull1()) // stack1 is full condition
        printf("Stack1 is Full!!(Queue is in overflow)\n");
    else
    {
        top1++; // increment top1 by one
        stack1[top1] = element; // add the given element to stack1
        printf("%d  been push to Queue\n", element); // inform  user the element is been added
    }

} /** End of push1() */


/** A utility function to push the given element to stack2
   If there is no place for new item, stack is in overflow state */

void push2(int element)
{
    if (isFull2()) // stack2 is full condition
        printf("Stack2 is Full!!(stack is in overflow)\n");
    else
    {
        top2++; // increment top2 by one
        stack2[top2] = element; // add the given element to stack2
        printf("%d  been push to stack2\n", element);
    }

} /** End of push2() */


/**
 utility function to pop(remove)top1 element from stack1(last in first out)*/

int pop1()
{
    // no need to check for if queue is empty
    // because if queue is empty this function will not be called
   // error is already be handle in dequeue function
   return stack1[top1--]; //return the top element then decrement top2 by 1 this called post decrement

} /** End of pop1() */


/**
 utility function to pop(remove)top element from stack2(last in first out)*/

int pop2()
{
    // no need to check for if queue is empty
    // because if queue is empty this function will not be called
   // error is already be handle in dequeue function
   return stack2[top2--]; //return the top element then decrement top2 by 1 this called post decrement

} /** End of pop2() */


/**
   Utility function to Check if the stack1 is full or not here
   Am saying that stack1 is full if and only if (top1 == CAPCITY - 1)*/

int isFull1()
{
    if(top1 == CAPCITY - 1) // queue is full condition
       return 1;
    else
      return 0;

}/** End of isFull() */


/**
   Utility function to Check if the stack2 is full or not here
   Am saying that stack2 is full if and only if (top2 == CAPCITY - 1)*/

int isFull2()
{
    if(top2 == CAPCITY - 1) // stack2 is full condition
       return 1;
    else
      return 0;

}/** End of isFull2() */


/**
   Utility function to Check if the queue is empty or not here
   Am saying that queue is empty if and only if(top1 == - 1 && top2 == -1) */

int isEmpty()
{
    if (top1 == - 1 && top2 == -1) // queue is empty condition
        return 1;
    else
     return 0;

}/** End of isEmpty() */
