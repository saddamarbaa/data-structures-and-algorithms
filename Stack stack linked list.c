/**
    [PROGRAM] : Stack Data Structure Implementation Using linked list
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Implement Stack data structure using linked list
    Stack is a linear data structure which flow LIFO rule
    (Last In First Out) or FILO(First In Last Out)rule.
    always push () and pop() operation will be in in order big O(1)

     Reference in future :---->
     1.  https://youtu.be/T_UXDTy23DQ
     2.  https://youtu.be/6dZW31Kf5Es
     3.  https://youtu.be/q3LA4-JxlcM
     4.  https://youtu.be/TTg-AM6HEG4
     5.  https://youtu.be/OkkMub7pPBI
     6.  https://youtu.be/aSnOCwWl56o  */

#include <stdio.h>
#include <stdlib.h>

/* declare A linked list node  */
struct Node
{
    int data;  /* data filed */

    struct Node *next; /*address of next node */
};

/* top of stack variable global declaration
   and initializations to NULL */
struct Node* top = NULL; /*  pointer to first node(head node) */

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

// function to Get the number of items in the stack.
int count();

// function to get the top element without deleting it
int peek();

int main(int argc, char* argv[]) // the  Driver Code
{
    int option, position, element; /* variable declarations */
    do
    {
        printf("Stack data structure Implementation Using linked list : \n");
        printf("1 : push                                              :\n");
        printf("2 : pop                                               :\n");
        printf("3 : peek(top element)                                 :\n");
        printf("4 : print all element in Stack                        :\n");
        printf("5 : isEmpty()                                         :\n");
        printf("6 : count()                                           :\n");
        printf("7 : clear Stack                                       :\n");
        printf("0 : Enter 0 to exit (quit)                            :\n");

        // asking user to enter choice
        printf("input your choice                                     :");
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
                 if(isEmpty())
                    printf("Stack Underflow \n");
                else
                {
                    element = peek(); // call peek top function
                    printf("top element is  : %d\n", element);
                }
             break;

             // case 4 traverse stack
             case 4 :
                 print_Stack(); // call  print_Stack function
             break;

             // case 5 Check if the Stack is empty or not
             case 5:
                if (isEmpty())    // call isEmpty function
                     printf("Stack is Empty\n");
                else
                     printf("Stack is not empty with %d elements\n",count());
             break;

             // case 6 Get the number of items in the stack
             case 6:
                 element = count(); // call  count function
             if (element == 0) // if stack is  empty
                 printf ("Stack Underflow \n");
             else
                 printf("number of element in stack are : %d \n", element);
             break;

             // case 7 clear all the element in stack
             case 7 :
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


/** A utility function to push new given element to stack */

void push(int element)
{
    struct Node* newNode; /* first step I create node that I want push to stack */

    // allocate memory dynamically for node using malloc C function
    newNode = (struct Node*) malloc(sizeof (struct Node));

    if(newNode == NULL) /* error handling */
       printf("Error in allocating memory\n");

    /* adding information to node */
    newNode -> data = element; // given value to push
    newNode -> next = top;   //  mean point to node just before top as top will move to new node
    top = newNode;           //  top is always point to the new node (top of stack)

    printf("Node --> %d  been push to Stack\n",element); // inform  user the element is been added

    /** Time complexity of push() is : O(1) */

} /** END of push() */


/**
 utility function to pop(remove)top element
 from stack(last in first out)  */

void pop()
{
    struct Node *temp; // local variables of type struct node declaration */
    temp = top;      // temp is now point to head node(top)
    if(isEmpty()) // Stack is empty condition
    {
        printf("Stack Underflow!!!\n");
        return; // we are done
    }
    else
    {
        /** link changes */

        // inform user that the top element is been remove
        printf("Node --> %d  been popped out \n", temp -> data);

        // move top one step back
        top = top -> next;     // also can be (top = temp -> next);
        temp -> next = NULL;  // connect temp -> next to NULL
        free(temp);          // now Delete temp using free() C function
    }

    /** Time complexity of pop() is : O(1) */

}/** End of pop() */


/**
   Utility function to Check if the stack is empty or not here
   Am saying that stack is empty if and only if (top == NULL) */

int isEmpty()
{
    if (top == NULL) /* empty case */
        return 1;
    else               /* else case */
        return 0;

}/** End of isEmpty() */


/** Utility function to traverse the Stack(linked list)
  and print all the element (Iterative method)*/

void print_Stack()
{
    struct Node* temp; // local variable of type struct node declaration */
    temp = top;       // temp is now point to head node(top)

    if(isEmpty()) // stack is empty condition
    {
        printf ("Stack Underflow \n");
        return; // we are done
    }

     /* else case
     by now we are sure stack (list) is not empty
     so while we not yet reach NULL print the value
     of node first and set temp to point to the next node */
     printf("stack contain the flowing element :-->\n");
     while(temp != NULL)
     {
         printf("%d --> ", temp -> data);  // print the value
         temp = temp -> next;              // move temp to next node
     }
     printf("\n");

     /** Time complexity of print_Stack() is O(n) */

} /**END of print_Stack()*/


// function to get the top element with out deleting it
int peek()
{
    return  top -> data;  // return top element

    /** Time complexity of peek() is O(n) */

} /** END of  peek()*/


/** function to Get the number of items in the stack. */
int count()
{
    int count = 0;     // local counter variable declaration and initializations to zero
    struct Node* temp; // local variable of type struct node declaration */
    temp = top;      //  temp is now point to head node(top)

    /* while not yet reach NULL count the number of nodes in list */
    while(temp != NULL)
    {
        count++;              // increment count
        temp = temp -> next;  // move temp to next node
    }
    return count; // return the number of node in list

    /** Time complexity of count() is O(n) */

} /** End of count() */


/**
  Utility function to clear the stack (Destroy entire stack ) */

void clear_Stack()
{
    struct Node* temp; // local variable of type struct node declaration */
    temp = top;      //  temp is now point to head node(top)

    if (isEmpty()) // if stack is already empty
    {
        printf ("Stack Underflow!!! \n");
        return; // we are done
    }
    else
    {
        /** link changes */

        // move temp one step back
        temp = temp -> next;  // connect temp to  temp -> next
        free(top);          // Delete top node using C function free()

        // now move top one step back
        top = temp;  //  top is now point to temp (top node
    }
    // after loop now free temp (last node ) and set top to NULL
    free(temp);          // Delete top node using C function free()
    top = NULL;        // top is now point to NULL

    printf("All stack elements destroyed\n");  // inform user the job is done

} /** End of clear_Stack() */


