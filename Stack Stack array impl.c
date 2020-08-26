
/* stack  implementation  using array  */

#include <stdio.h>
#include "stdlib.h"
#include <cs50.h>

 #define CAPCITY 6
 int stack[CAPCITY];
 int top = -1;

 void push(int element);
 void pop();
 int isFull();
 int  isEmpty();
 void trevers();
 void clearStack();
 void peek();



int main(int argc, char* argv[])
{
     while(1)
    {
        int ch;//for swtich  to chooce choice
         int element; // element
         printf("1 : push :\n");
         printf("2 : pop  :\n"); //delete
         printf("3 : peek(top element)  :\n"); // top elemt
         printf("4 : print all the element :\n");
         printf("5 : clear stack:\n"); //delete all the element in stack
         printf("0 : quit :\n");

         ch =get_int("input your choice :");

         switch (ch)
         {
            case 1:
            element = get_int("enter elemt to push : ");
             push(element);
              break;

              case 2:
              pop();
              break;

              case 3:
              peek();
             break;

              case 0:
              printf("time to exit thanks\n");
              _Exit(0);

             case 4:
             trevers();
             break;

             case 5:
             clearStack();
             break;

             default:
             printf("invalied input\n");
             break;
         }

    }


    return 0;

}


/**
 * to push new value to stack
 */

void push(int element)
{
     if(isFull())
     {
       printf("sorry  the stack is full");
       printf("\n");
     }

    else
    {
        top++;
        stack[top] = element;
        printf("%d  been push to stack\n",element);
    }
}

/**
 * to pop the top elemnt
* mean remove the top element in stack
*/
void pop()
{
    if (isEmpty())
        {
            printf ("stack is empty nothing to pop for now\n");
        }
        else
        {
             printf("%d  been pop out \n",stack[top]);
            top--;

        }
}



/** check if the stack is full or not    */

int isFull()
{
    if (top == CAPCITY - 1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}


 /**
  * check if stack is empty
  */

int isEmpty()
{
    if (top ==  - 1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}


    /**
     * to print all the element in the stack
     */
    void trevers()
    {
        if (isEmpty())
        {
            printf ("stack is empty so no element print\n");

        }

        else
        {

        for (int i = top; i >= 0; i--)
        {
            printf(" %d \n",stack[i]);
        }

    }
    }

/**
 * to clear the stack by deleting all the element
 */

void clearStack()
{
    if (isEmpty())
        {
            printf ("stack is allready empty to element to clear\n");
        }
        else
        {
            top = -1;
        }
}

/**
  * return the top elemt in stack
  */
void peek()
{
    if (isEmpty())
        {
            printf ("stack is allready empty no element on  top \n");
        }


           printf("%d is the element on the stack\n ",stack[top]);

}



