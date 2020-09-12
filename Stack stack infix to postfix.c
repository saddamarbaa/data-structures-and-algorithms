
/** 
    [PROGRAM] : Infix to Postfix Expression using STACK
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Convert Infix to Postfix Expression using STACK Data Structure.



     Reference in future :---->



      */

#include <stdio.h>
#include "stdlib.h"
#include <cs50.h>  //<cs50.h>  this because am now using Cs50 Ide
#include <string.h> // include string.h

#define CAPCITY 100 // define size of stack

/* function to Check if the given character is Operator or not */
int is_Operator(char);

/* function to determine Associativity Operator precedence */
int precedence(char);

/*  declare stack (Array of character) globally
    so that it can be access from all function */
int stack[CAPCITY];

/* top of stack variable global declaration
   and initializations to -1 */
int TOP = -1;

// Function to push(add)character into stack
void push(char);

//Function to pop(remove)top character from stack
void pop(void);

// function to get the top character from without deleting it
char top(void);

// function to Check if the Stack is full or not
int isFull(void);

//function to Check if the stack is empty or not
int isEmpty(void);

//function to Reverse a string
char* InfixToPostfix(char* s);

int main(int argc, char* argv[]) // the  Driver Code
{
    printf("Convert Infix to Postfix Expression using STACK Data Structure\n");

    //char* infix_Expression; // variable declarations
    char *infix_Expression = get_string("Enter a Infix Expression  :");


    // get user input
    //printf("Enter a Infix Expression  : ");
    //scanf("%s",infix_Expression);
    //InfixToPostfix(infix_Expression);

    // print the string Before Reverse
    printf("Before Convert infix expression is : %s\n",infix_Expression);

    char* postfix_Expression = InfixToPostfix(infix_Expression);
    printf("After Convert postfix expression is : %s\n",postfix_Expression);

    return 0;// signal to operating system everything works fine

}/** End of main function */


/** function to Reverse a string */

char* InfixToPostfix(char* infix)
{
    // allocate memory dynamically for postfix using malloc C function
    char* postfix = malloc(strlen(infix) + 1);

    if(postfix == NULL) /* error handling */
      printf("Error in allocating memory\n");

    // counter variable K declarations  and initializations to zero
    int k = 0;

    // Scan Expression from Left to Right
    for (int i = 0, size = strlen(infix); i < size; i++)
    {
        /* case 1
         IF the incoming charter is OPERANDs then Print OPERANDs as the arrive */
        if( (infix[i] >= 'A' && infix[i] <= 'Z')
           || (infix[i] >= 'a' && infix[i] <= 'z'))
        {
            postfix[k++] = infix[i]; // add OPERAND to postfix as its
        }
        /* case 2
        IF the incoming charter SYMBOL is ‘(‘ PUSH it onto Stack. */
        else if (infix[i] == '(')
        {
            push(infix[i]); // Push character at index i '(' to stack
        }
        /*
         case 3
         IF the incoming charter SYMBOL is ‘)’ POP the stack and print
         OPERATORs till ‘(‘ is found. POP that ‘(‘ */
        else if (infix[i] == ')')
        {
            while((top() != '(') && (!isEmpty()))
            {
                postfix[k++] = top(); // add top to postfix Expression
                pop();              // pop the top out
            }

            // after while loop if top == '(' then pop out '('
            if(top() == '(')
               pop();      // pop '(' out

        }
         /*
         IF the incoming charter SYMBOL is Operator( +,*,/,-,^)
         (since this is the last case we dont even need to call
         Operator function we can just go with simple else block) */
         else if (is_Operator(infix[i]))
         {
              if(isEmpty()) // if stack is Empty
              {
                  push(infix[i]); // Push the Operator to stack
              }
              else  /* in else case we have 3 cases */
              {
                  /*
                  IF the incoming Operator has high precedence than top of stack
                  then push incoming Operator to stack */
                  if(precedence(infix[i]) > precedence(top()))
                  {
                      push(infix[i]); // Push the Operator to stack
                  }
                  /*
                  (this one is special case)
                  this is mean incoming Operator is '^' */
                  else if((precedence(infix[i]) == precedence(top())) && (precedence(infix[i] == '^')))
                  {
                      push(infix[i]); // Push the Operator ('^') to stack
                  }
                  else
                  {
                      while((!isEmpty()) && (precedence(infix[i]) <= precedence(top())))
                      {
                          postfix[k++] = top(); // add top Operator to postfix Expression
                          pop();         // pop the top Operator out
                      }
                      // after while loop
                      push(infix[i]); // Push the new  Operator to stack
                  }
              }
         }

    } /** END of for loop */

    /* after for loop
     while stack is not empty pop out the remaining element*/
    while(!isEmpty())
    {
        postfix[k++] = top(); // add the remaining element to postfix Expression
        pop();                // pop the top element out
    }

    postfix[k] = '\0';  // add '\0' at the end of postfix Expression

    return postfix;  // postfix Expression after been converted

} /** End of InfixToPostfix() */


/**
   Utility function to Check if the
   given character is Operator or not */

int is_Operator(char c)
{
    if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
       return 1; // is Operator
    else
      return 0; // is not Operator

} /** End of is_Operator() */


/** function to determine Associativity Operator precedence */

int precedence(char c)
{
    if(c == '^')
        return 3;
    else if(c == '*' || c == '/')
        return 2;
    else if(c == '+' || c == '-')
        return 1;

    return -1; // in all else cases

} /** End of precedence() */


/** A utility function to push new given element to stack
   If there is no place for new item, stack is in overflow state*/

void push(char element)
{
    if(isFull()) // stack is full condition
       printf("Stack is Full!!(stack is in overflow)\n");

    /*
    now we are sure stack is not full so let first increment
    top by one after that add given element at top position */

    else
    {
        TOP++; // increment top by one
        stack[TOP] = element; // add the given element to stack
        printf("%c  been push to Stack\n",element); // inform  user the element is been added
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
         printf("%c  been popped out \n",stack[TOP]);
         TOP--; // decrement top by one
    }

}/** End of pop() */


/**
   Utility function to Check if the stack is full or not here
   Am saying that stack is full if and only if (top == CAPCITY - 1) */

int isFull()
{
    if(TOP == CAPCITY - 1) // is empty full
        return 1;

    else // is not full
       return 0;

} /** End of isFull() */


/**
   Utility function to Check if the stack is empty or not here
   Am saying that stack is empty if and only if (top == -1) */

int isEmpty()
{
    if (TOP == -1) /* empty case */
        return 1;
    else               /* else case */
        return 0;

}/** End of isEmpty() */


/**
   function return the top element in stack without deleting it */

char top()
{
    if (isEmpty()) // if stack is  empty
    {
        printf ("Stack Underflow \n");
    }

    return stack[TOP]; // return top element

} /** End of peek() */

