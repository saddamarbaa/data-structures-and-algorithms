/**
    [PROGRAM] : Reverse a string using stack
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Reverse a string using stack.
    to Reverse a string using stack the idea is to loop throw the string
    and push each character to stack until we reach end of string
    then just easily pop all of them again from stack and printed

    as stack flow first in last out so if we pop out the string will be
    already  Reverse .

     Reference in future :---->
     https://youtu.be/hNP72JdOIgY */

#include <stdio.h>
#include "stdlib.h"
#include <cs50.h>  //<cs50.h>  this because am now using Cs50 Ide
#include <string.h> // include string.h

#define CAPCITY 100 // define size of stack

/*  declare stack (Array of character) globally
    so that it can be access from all function */
int stack[CAPCITY];

/* top of stack variable global declaration
   and initializations to -1 */
int top = -1;

// Function to push(add)character into stack
void push(char);

//Function to pop(remove)top character from stack
void pop(void);

// function to get the top character from without deleting it
char peek(void);

// function to Check if the Stack is full or not
int isFull(void);

//function to Check if the stack is empty or not
int isEmpty(void);

//function to Reverse a string
void Reverse(string s);

int main(int argc, char* argv[]) // the  Driver Code
{
    printf("Reverse a string using stack\n");

    string given_string; // variable declarations

    // get user input (here Am using CS50 IDE)
    given_string = get_string("Enter string to push in stack and Rvesed : ");

    // print the string Before Reverse
    printf("Before Reverse string is : %s\n",given_string);

     /* traverse the string and Reversed using stack  */
    Reverse(given_string); // call Reverse() function

    // print the string After Reverse
    printf("After Revers string is : %s\n",given_string);

    return 0;// signal to operating system everything works fine

}/** End of main function */


/** function to Reverse a string */

void Reverse(string s)
{
    int i, size;      // variable declarations
    size = strlen(s); // calculate the string size

    for (i = 0; i < size; i++)  // loop for Push
          push(s[i]); // Push character at index i to stack

    // pop each char from stack first in last so char will come in revres order

    for (i = 0; i < size; i++)  // loop for pop
    {
        s[i] = peek(); // peek top character and stored at index i
        pop();   // pop the top character out
    }

    /**
    Time complexity :  O(n)
    Space Comlexity : O(n) */

} /** End of Reverse() */


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
        top++; // increment top by one
        stack[top] = element; // add the given element to stack
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
         printf("%c  been popped out \n",stack[top]);
         top--; // decrement top by one
    }

}/** End of pop() */


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
   function return the top element in stack without deleting it */

char peek()
{
    if (isEmpty()) // if stack is  empty
    {
        printf ("Stack Underflow \n");
    }

    return stack[top]; // return top element

} /** End of peek() */

