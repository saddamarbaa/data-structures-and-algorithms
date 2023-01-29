/**
    [PROGRAM] :  Check for balanced parentheses Using Stack
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program for Checking balanced parentheses Using Stack Data Structure.
    Given an expression as string comprising of opening and closing characters
    of parentheses - (), curly braces - {} and square brackets - [], we need to
    check whether symbols are balanced or not.

     Reference in future :-->
     1. https://youtu.be/71V60ZpH-8M
     2. https://youtu.be/QZOLb0xHB_Q */

#include <stdio.h>
#include "stdlib.h"
#include <string.h> // include string.h

/* Structure to represent stack */
struct Stack
{
    int top;            /* top of stack filed */
    unsigned capacity; /* size of stack filed */
    int* array;       /* stack array filed (dynamic array) */
};

/*  Function to create Stack */
struct Stack* create_Stack(unsigned capacity);

/* function to Check if the two given character are Pair or not */
int ArePair(char, char);

/* function to Check if the given character is open Parentheses or not */
int is_Opening_Parentheses(char);

/* function to Check if the given character is closing Parentheses or not */
int is_Closing_Parentheses(char C);

// Function to push(add)character into stack
void push(struct Stack* stack, char);

// Function to pop(remove)top character from stack
char pop(struct Stack* stack);

// function to get the top character from without deleting it
char top(struct Stack* stack);

// function to Check if the stack is empty or not
int isEmpty(struct Stack* stack);

/* the main function to Check for balanced parentheses */
int Are_Parentheses_Balanced(char* expression);

int main(int argc, char* argv[]) // the  Driver Code
{
    printf("Check for balanced parentheses Using Stack\n");

    // variable declarations
    char* expression = "((A+B-C)*D^E^F)/G"; /* Output of this Expression must be Balanced */

    // print the expression first
    printf("the Expression is : %s\n",expression);

    // call Are_Parentheses_Balanced function
    if(Are_Parentheses_Balanced(expression))
       printf("Parentheses are Balanced\n");
    else
       printf("Parentheses are Not Balanced!!\n");

    return 0;// signal to operating system everything works fine

}/** End of main function */


/** Main function to Check for balanced parentheses using stack */

int Are_Parentheses_Balanced(char* expression)
{
    // Create a stack of capacity equal to expression size
    struct Stack* stack = create_Stack(strlen(expression));
    if(stack == NULL) /* error handling */
    {
        printf("Error in allocating memory\n");
        return 1;
    }
    // Scan the  Expression from Left to Right
    for (int i = 0, size = strlen(expression); i < size; i++)
    {
       /*
        IF the incoming charter SYMBOL is opening parentheses
        ‘(‘, '{' or '[' PUSH it onto Stack. */
        if(is_Opening_Parentheses(expression[i]))
        {
            push(stack, expression[i]); // Push to stack
        }
        /*
        IF the incoming charter SYMBOL is closing parentheses
        ']', '}' or ')' */
        else if(is_Closing_Parentheses(expression[i]))
        {
            if(isEmpty(stack) || !ArePair(top(stack),expression[i]))
				return 0;
            else
               pop(stack);    // pop the top out
        }

    } /** END of for loop */

    /* after the for loop  if stack is not empty return false*/
    if(!isEmpty(stack))
       return 0;

    return 1;// if reach this line mean are Balanced just return 1

} /** End of Are_Parentheses_Balanced() */


/** A utility function to create stack */

struct Stack* create_Stack(unsigned capacity)
{
    struct Stack* stack;  /* first create stack node */

    // allocate memory dynamically for Stack using malloc
    stack = (struct Stack*) malloc(sizeof (struct Stack));

    if(stack == NULL) /* Error handling */
      printf("Error in allocating memory\n");

    /* adding information to Stack */
    stack -> top = -1;            // set  top to -1
    stack -> capacity = capacity; // set capacity at capacity filed

    /* allocate memory dynamically for Stack array using malloc  */
    stack -> array = (int*) malloc(stack -> capacity * sizeof(int));

    if(stack -> array == NULL) /* Error handling */
      printf("Error in allocating memory\n");

    return stack;  // return newly created stack to place where it been be called

} /** END of Create_Stack() */


/**
   Utility function to Check if the given two characters
   are opening and closing of same type. */

int ArePair(char opening, char closing)
{
    if (opening == '(' && closing == ')')       return 1;
    else if (opening == '{' && closing == '}')  return 1;
    else if (opening == '[' && closing == ']')  return 1;
    return 0; // Are not Pair

} /** End of ArePair() */


/** Utility function to Check if the given character is open Parantheses or not */

int is_Opening_Parentheses(char C)
{
    if(C == '(' || C == '[' || C == '{')  return 1; // is Open Parentheses

    else return 0; // is not Open Parentheses

} /** End of is_Open_Parantheses() */


/** Utility function to Check if the given character is closing Parentheses or not */

int is_Closing_Parentheses(char C)
{
    if(C == '}' || C == ']' || C == ')')  return 1; // is Closing Parentheses

    else return 0; // is not Closing Parentheses

} /** End of is_Closing_Parentheses() */


/** A utility function to push new given character to stack */

void push(struct Stack* stack, char c)
{
    // increment top by one first
    stack -> array[++stack -> top] = c;  // add the given character to stack

    printf("%c  been push to Stack\n",c); // inform  user the character is been added

} /** End of push() */


/**
 utility function to pop(remove) top character
 from stack(last in first out)  */

char pop(struct Stack* stack)
{
    if(isEmpty(stack)) // Stack is empty condition
    {
       printf ("Stack Underflow \n");
       return '$';
    }
    /* else cases */
    // inform user that the top element is been remove
    printf("%c  been popped out \n", stack -> top);
    return stack -> array[stack -> top--];  // decrement top by one


}/** End of pop() */


/** Utility function to Check if the stack is empty or not here */

int isEmpty(struct Stack* stack)
{
    if (stack -> top == -1) /* empty case */
        return 1;
    else               /* else case */
       return 0;

}/** End of isEmpty() */


/**
   function return the top element in stack without deleting it */

char top(struct Stack* stack)
{
    return stack -> array[stack -> top]; // return top of stack

} /** End of peek() */
