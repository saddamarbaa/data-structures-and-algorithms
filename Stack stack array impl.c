/**
    [PROGRAM] : Stack Data Structure(LIFO,FILO)
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Implement Stack data structure using array
    Stack is a linear data structure which flow LIFO rule
    (Last In First Out) or FILO(First In Last Out)rule.

     Reference in future :---->
     1.   https://youtu.be/g1USSZVWDsY
     2.   https://youtu.be/Rrc1D4E7mTQ
     3.   https://youtu.be/dIpf5TKcr88
     4.   https://youtu.be/rubrZmIg5cc
     5.   https://youtu.be/F1F2imiOJfk
     6.   https://youtu.be/sFVxsglODoo
     7.   https://youtu.be/bxRVz8zklWM
     8.   https://youtu.be/VmsTAVpz0xo
     9.   https://youtu.be/r7P9sy5Rar8
     10.  https://youtu.be/08QSylWv6jM  */

#include <stdio.h>
#include <stdlib.h>

#define CAPCITY 6  // define size of stack

/* declare stack of Array globally so that
    it can be access from all function */
int stack[CAPCITY];

/* top of stack variable global declaration
   and initializations to -1 */
int top = -1;

// Function to push(add)elements into stack
void push(int);

//Function to pop(remove)top elements from stack
void pop();

//function to Check if the stack is empty or not
int isEmpty();

//function to traverse Stack and Print the Stack element
void print_Stack();

//function to traverse Stack and clear all it element
void clear_Stack();

// function to Check if the Stack is full or not
int isFull();

// function to Change the item at the i position
void change(int, int);

// function to Get the number of items in the stack.
int count();

// function to get the top element without deleting it
int peek_top();

// function to get the element at the i position
int peek_position();

// the  Driver Code
int main(int argc, char* argv[])
{
    int option, position, element; /* variable declarations */
    do
    {
        printf("Stack data structure implementation     : \n");
        printf("1 : push                                :\n");
        printf("2 : pop                                 :\n");
        printf("3 : peek(top element)                   :\n");
        printf("4 : peek(element at position)           :\n");
        printf("5 : print all element in Stack          :\n");
        printf("6 : isEmpty()                           :\n");
        printf("7 : isFull()                            :\n");
        printf("8 : change()                            :\n");
        printf("9 : count()                             :\n");
        printf("10 : clear Stack                        :\n");
        printf("0 : Enter 0 to exit (quit)              :\n");

        // asking user to enter choice
        printf("input your choice                       :");
        scanf("%d",&option);

         switch(option)
         {
            // case 1 add new element to stack
            case 1:
                printf("Enter an item to push in the stack : ");
                scanf("%d",&element);
                push(element); // call push function
            break;

            // case 2 pop the top element from stack
            case 2:
                pop(); // call pop function
            break;

             // case 3 peek top element from
            case 3:
                element = peek_top(); // call peek top function
                if(element != -1)
                    printf("top element is  : %d\n", element);
            break;

             // case 4 peek element at given position
            case 4:

                printf("Enter position of item you want to peek :");
                scanf("%d", &position);
                if (isEmpty()) // if stack is  empty
                     printf ("Stack Underflow \n");
                else if (position > top)
                     printf("invalid position\n"); // Handle corner case
                else
                {
                    element = peek_position(position); // call peek position function
                    printf("Element at position %d  is  : %d\n", position, element);
                }
            break;

            // case 5 traverse stack
            case 5:
                print_Stack(); // call  print_Stack function
            break;

             // case 6 Check if the Stack is empty or not
            case 6:
                if (isEmpty())    // call isEmpty function
                    printf("Stack is Empty\n");
              else
                   printf("Stack is not Empty\n");
            break;

            // case 7 Check if the Stack is full or not
            case 7 :
              if (isFull())    // call isFull function
                  printf("Stack is Full\n");
              else
                  printf("Stack is not Full\n");
            break;

            // case 8 peek element at given position
            case 8:
                // get position from user
                printf("Enter position of item you want to change :");
                scanf("%d", &position);

                // get the new emenet from user
                printf("Enter the new item :");
                scanf("%d", &element);
                change(position, element); // call change function
            break;

            // case 9 Get the number of items in the stack
            case 9:

            if (isEmpty()) // if stack is  empty
                printf ("Stack Underflow \n");
            else
            {
                element = count(); // call  count function
                printf("number of element in stack are : %d \n", element);
            }
            break;

            // case 10 clear all the element in stack
            case 10:
                clear_Stack(); // call  clear_Stack function
            break;

            case 0:  // case 0 Exit case
            printf("time to exit thanks\n");
            _Exit(0);

             default: // default case
             printf("invalid input\n");
             break; // no need break after default case I use it only for readability

         }/** END of switch */

    } while(1); /** END of  do while loop */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/** A utility function to push new given element to stack
   If there is no place for new item, stack is in overflow state*/

void push(int element)
{
    if(isFull()) // stack is full condition
       printf("Stack is Full!!(stack is in overflow)\n");

    /*
    now we are sure stack is not full so let first increment
    top by one after that add given element at top position */

    else
    {
        top++; // increment top by one
        stack[top] = element; // add the given element to stack
        printf("%d  been push to Stack\n",element); // inform  user the element is been added
    }

} /** End of push() */


/**
 utility function to pop(remove)top element
 from stack(last in first out)  */

void pop()
{
    //if Stack is empty then we dont have any element to pop
    if(isEmpty()) // Stack is empty condition
       printf ("Stack Underflow \n");
    else
    {
        // inform user that the top element is been remove
         printf("%d  been popped out \n",stack[top]);
         top--; // decrement top by one
    }

}/** End of pop() */


/**
   Utility function to Check if the stack is empty or not here
   Am saying that stack is empty if and only if (top == -1) */

int isEmpty()
{
    if (top == -1) /* empty case */
        return 1;
    else               /* else case */
        return 0;

}/** End of isEmpty() */


/**
   Utility function to Check if the stack is full or not here
   Am saying that stack is full if and only if (top == CAPCITY - 1) */

int isFull()
{
    if(top == CAPCITY - 1) // is empty full
        return 1;

    else // is not full
       return 0;
} /** End of isFull() */


/** Utility function to traverse the Stack and print all the element */

void print_Stack()
{
    if(isEmpty()) // stack is empty condition
    {
        printf ("Stack Underflow \n");
    }
    else
    {
        printf("stack contain the flowing element :-->\n");
        // now we can print
        for (int i =  top; i >= 0; i--)
              printf(" %d \n",stack[i]);

        printf("\n"); // print new line after printing all stack element
    }

} /**END of print_Stack()*/


/**
  Utility function to clear the stack by deleting all the element */

void clear_Stack()
{
    if (isEmpty()) // if stack is already empty
        printf ("Stack Underflow \n");
    else
    {
        top = -1; // deleting all the element by setting top by top -1
        printf(" Stack is been cleared\n");
    }

} /** End of clear_Stack() */


/** function to get the element at the i position */
int peek_position(int position)
{
    return  stack[position]; // return element at position position

} /** END of  peek_postion()*/


// function to get the top element with out deleting it
int peek_top()
{
    if (isEmpty()) // if stack is  empty
    {
        printf ("Stack Underflow \n");
        return -1;
    }
    else
     return  stack[top];  // return top element

} /** END of  peek_top()*/


/** function to Get the number of items in the stack. */
int count()
{
    return top + 1; // return number of element in stack

} /** End of count() */


/** function to Change the item at the i position to given new element */
void change(int position, int  element)
{
    if (isEmpty()) // if stack is  empty
         printf ("Stack Underflow \n");
    else if (position > top)// Handle corner case
         printf("invalid position\n");
    else   // now go ahead  and Change
    {
        stack[position] = element; // change the element
        // inform user the work is done
        printf("the value at position %d is been change to %d\n", position, element);
    }

} /** End of change()*/
