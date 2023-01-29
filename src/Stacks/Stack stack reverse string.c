/**
    [PROGRAM] :  Reverse a string using stack
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Reverse a string using stack.

     Reference in future :-->
     https://youtu.be/hNP72JdOIgY */

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

// Function to push(add)character into stack
void push(struct Stack* stack, char);

// Function to pop(remove)top character from stack
char pop(struct Stack* stack);

// function to get the top character from without deleting it
char top(struct Stack* stack);

// function to Check if the stack is empty or not
int isEmpty(struct Stack* stack);

//function to Reverse a string
char* Reverse(struct Stack* stack, char*);

int main(int argc, char* argv[]) // the  Driver Code
{
    printf("Reverse a string using stack\n");

    // variable declarations
    char*given_string = "ABCDEFG";  // output Expression must be   " GFEDCBA "

    // print the string Before Reverse
    printf("Before Reverse string is :%s\n",given_string);

    // Create a stack of capacity equal to expression size
    struct Stack* stack = create_Stack(strlen(given_string));
    if(stack == NULL) /* error handling */
    {
        printf("Error in allocating memory\n");
        return 1;
    }

    /* traverse the string and Reversed using stack  */
    given_string = Reverse(stack, given_string); // call Reverse() function

    // print the string After Reverse
    printf("After Revers string is : %s\n",given_string); // output Expression must be  " GFEDCBA "

    return 0;// signal to operating system everything works fine

}/** End of main function */


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
    function to Reverse a string  using stack.
    to Reverse a string using stack the idea is to loop throw
    the string and push each character to stack until we reach end of string
    then just easily pop all of them again from stack and printed
    as stack flow first in last out so if we pop out the string will be
    already  Reverse . */

char* Reverse(struct Stack* stack, char* s)
{
    int i, size;      // variable declarations
    size = strlen(s); // calculate the string size

    // allocate memory dynamically for Reversed Expression using malloc
    char* reverse = malloc(strlen(s) + 1);
    if(reverse == NULL) /* Error handling */
    {
        printf("Error in allocating memory\n");
        return "\0";
    }
    // Scan the  Expression from Left to Right
    for (i = 0; i < size; i++)  // loop for Push
         push(stack, s[i]); // Push character at index i to stack

    // pop char from  top of stack stack (first in last so char will come in revrese order)
    for (i = 0; i < size; i++)  // loop for pop
    {
        reverse[i] = top(stack);  // peek top character and stored at index i
        pop(stack);              // pop the top character out
    }
    reverse[i] = '\0'; // add '\0' at the end of reversed Expression

    return reverse;   // return  the reversed Expression

    /**
    Time complexity :  O(n)
    Space Comlexity : O(n) */

} /** End of Reverse() */


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
