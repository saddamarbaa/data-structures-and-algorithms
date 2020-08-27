
  
/**
*  Implement Queue Using Stack

*  to implement queue using  stack and flow all queue data structure rules
*  (FIFO) first in first out you need two stack because stack flow different
*  rule(LFO )LAST IN LAST OUT)  but remember we are implementing queue here so
*  we use two stack  first stack for enqueue  but when we want dequeue stack one
*  give us first element but we need the last element so for that first
*  pop all element from stack one to stack two by now element which was last in
*   stack one its on top(first) now in stack two then is easy to dequeue
*
*   with that been said enqueue  opearition will be done from stack one
*   and dequeue opearition will be done from stack 2
*
*   for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
*
* in this case enqueue opeartion take Big(O1) and dequeue opearition big(On)
*/

#include <stdio.h>
#include "stdlib.h"
#include <cs50.h>
#define CAPCITY 6  // define size of queue

int stack1[CAPCITY];  // first stack for enqueue

int stack2[CAPCITY];   // second stack for deqeue

int top1 = -1; // for stack 1
int top2 = -1; // for stack 2

int count = 0; // i will count later as counter


 void enqueue(int element);

 void push1(int element); // push element to stack1


 void push2(int element);  //  push element to stack2

 int pop1();  //  return top value in stack1

 int pop2();  //return top value in stack2 (pop the top element and return it in same time)

 void dequeue();

 void trevers();

 void clearQueue();

 int isFull1();  //check if the stack1 is full or not

 int isFull2();  // check if the stack2 is full or not

 int isEmpty();   // cheack if queue is Empty or not

int main(int argc, char* argv[])
{
     while(1)
    {
        int ch;//for swtich  to chooce choice
         int element; // element
         printf("1 : enqueue :\n");
         printf("2 : dequeue  :\n"); //delete
         printf("3 : print all the element  of the queue:\n");
         printf("4 : clear qeue:\n"); //delete all the element in queue
         printf("0 : quit :\n");

         ch =get_int("input your choice :");

         switch (ch)
         {
            case 1:
            element = get_int("enter elemt to enqueue : ");
             enqueue(element);
              break;

              case 2:
              dequeue();
              break;

              case 0:
              printf("time to exit thanks\n");
              _Exit(0);

             case 3:
             trevers();
             break;

             case 4:
             clearQueue();
             break;

             default:
             printf("invalied input\n");
             break;
         }

    }


    return 0;

}


/**
 *  push new value to queue
 *  push the element on stack1
 *
 * for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
 *
 */

void enqueue(int element)
{
    /* this if counditon coude be add in push1() then if stack1 is not full
    *  then we push the element however I have handle the eror here beacuse
    * in that case  count will still be add even thought stack is full
    *
    * the orgainal function was like this blow with out if condition
    *   push1(element);
    *   count++;
    *
    * so in that case  call push1(element); first line in push1() the eror handle
    * stack full return back here then continoue add one to count and this will cause
    * problem latter in printing all the element process
    */

   if (isFull1()) // if stack is full
    {
            printf("sorry  the stack is full");

            printf("\n");
            return;
    }
    else
    {

    push1(element); // push element to satck1

    count++;  // i will  use count in dequeue opearition in loop latter
    }
}

/**
* dequeue first elemt in the queue
* first in first out
*
* pop all the element from stack1 and push  to stack2 until stack1 became empty
* then pop the first element from stack2 to be dequee after that push the remaining
* element back to satck1
*
* so this will tack order BIG(O (N))
*
*  for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
*/


void dequeue()
{
    int a ,b;

    if (isEmpty()) // if queue is  empty
        {
            printf ("queue is empty nothing to dequeue for now\n");
            return;
        }

      else
      {
            // now queue is not empty so first pop1 from stack1 and push2 to stack2
            // until stack1 become empty  for this we need loop here


            for(int i = 0; i < count ; i++)
            {
                a = pop1();              // pop from stack1

                push2(a);                 // push to satck2

            }

            printf("%d  been dequeue out \n",pop2()); // pop from the stac2 only one element which last element to be dequeue

            count = count - 1; // after pop element count to shoud be count = count - 1;

            // after you pop one element  push the remaing element back to stack 1 for this we need loop also

            for(int i = 0; i < count ; i++)
            {
                a = pop2();              // pop from stack2

                push1(a);                 // push back to satck1  again

            }

}
}



/**
* to print all the element in the queue
* printing shoud be done from stack1  because after
* dequeue all the element are allready back to satck1
*
*
*  for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
*/

void trevers()
{

       if (isEmpty()) // if queue is empty
        {
            printf ("Queue is empty so no element print\n");

        }

        else
        {

        for (int i = 0; i < count; i++)
        {
            printf(" %d \t",stack1[i]);
        }
        printf("\n");

    }
}



/**
* to clear the queue by deleting all the element
*/

void clearQueue()
{
    if (isEmpty()) // if queue is empty
    {

            printf ("Queue is empty so no element to clear\n");
    }
    else
    {

            top1 = top2 = -1; // queue become empty
    }

}





/**
*  push value to stack1 the value is coming from enqueue function
*
*  for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
*/

void push1(int element)
{
    if (isFull1()) // if stack is full
    {

            printf("sorry  the stack is full");

            printf("\n");
            return;
    }


        else

        {

         top1++; // now top1 is 0

         stack1[top1] = element;

        printf("%d  been push to stack 1\n",element);

        }
}

/**
* to push value to stack2
* the value is coming from enqueue function
*
*  for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
*/

void push2(int element)
{
        if (isFull2()) // if stack2 full
        {
            printf("sorry  the stack is full");
            printf("\n");
            return;
        }
        else
        {
         // stack2 is not full so now we can push

         top2++;  // now top1 is 0

        stack2[top2] = element; //push element to stack2

        printf("%d  been push to stack 2\n",element);

        }
}

/**
 * return  the top elemnt  and remove the top element in stack 1
 *
 *  for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
*/

int  pop1()
{
    // no need to check for if queue is empty
    // because if queue is empty this function will not be called eror allready be handle in dequeue function


       return stack1[top1--]; //return the top element then decrement top2 by 1 this called post decrement




}

/**
 * return  the top elemnt  and remove the top element in stack 2
 *
 *  for reference back to (Jenny's lectures CS/IT NET&JRF) channel only
*/

int  pop2()
{
    // no need to check for if queue is empty
    // because if queue is empty this function will not be called eror allready be handle in dequeue function

            return stack2[top2--]; //return the top element then decrement top2 by 1 this called post decrement

}


/** check if the stack1 is full or not    */

int isFull1()
{
    if (top1 == CAPCITY - 1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

/**
*  check if the stack2 is full or not
*/

int isFull2()
{
    if (top1 == CAPCITY - 1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}


/**
* check if queue is empty
*/

int isEmpty()
{
     if (top1 == - 1 && top2 == -1) // if queue is empty
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

