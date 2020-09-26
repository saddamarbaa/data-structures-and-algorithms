/**
    [PROGRAM] :  Postfix To Infix Expression Conversion Using Stack 
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Convert Postfix To Infix Expression Using STACK Data Structure.

     Reference in future :---->
     1. https://youtu.be/rs3yFyq_Kds
     2. https://youtu.be/b6miFHYFaVI
     3. https://youtu.be/riKPj1d16PI
     4. https://youtu.be/OKdMY9oYkTg
     5. https://youtu.be/0itJnkeq6XY
     6. https://youtu.be/QZOLb0xHB_Q
     7. https://youtu.be/MeRb_1bddWg  */

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

/* function to Check if the given character is Operator or not */
int is_Operator(char);

/* function to Check if the given character is Operand or not */
int is_Operand(char);

/* function to determine Associativity Operator precedence */
int precedence(char);

// Function to push(add)character into stack
void push(struct Stack* stack, char);

// Function to pop(remove)top character from stack
char pop(struct Stack* stack);

// function to get the top character from without deleting it
char top(struct Stack* stack);

// function to Check if the stack is empty or not
int isEmpty(struct Stack* stack);

// function to Convert Postfix Expression to Infix Expression
void Postfix_To_Infix(char*);

int main(int argc, char* argv[]) // the  Driver Code
{
    printf("Convert Postfix To Infix Expression using STACK Data Structure\n");

    // variable declarations
    char* Postfix_Expression = "AB+C-DEF^^*G/";

    // print the expression Before Convention
    printf("Before Convert infix Expression is : %s\n",Postfix_Expression);

    // call InfixToPostfix() function
    Postfix_To_Infix(Postfix_Expression);

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
    function to Convert Postfix Expression to Infix Expression

    Algorithm Convert Postfix To Infix
    1. Scan the Postfix expression from left to right.
    2. If the scanned character is a OPERAND, PUSH it onto the Stack
    3. If the scanned character is a OPERATOR, POP 2 OPERANDs from the Stack,
       ADD this incoming OPERATOR in between the 2 OPERANDs
      , ADD ‘(‘ & ‘)’ to the whole expression & PUSH this whole new
       expression string back into the Stack.

    4. At the end of Expression, POP & print the full INFIX expression from the Stack. */

void Postfix_To_Infix(char* postfix)
{
    /** TO DO CODE IS NOT COMPLETE **/

    // counter variable K declarations and initializations to -1
    int k = -1;

    // allocate memory dynamically for infix Expression using malloc
    char* infix = malloc(strlen(postfix) + 1);
    if(infix == NULL) /* error handling */
    {
        printf("Error in allocating memory\n");
        return;
    }
    // Create a stack of capacity equal to expression size
    struct Stack* stack = create_Stack(strlen(postfix));
    if(stack == NULL) /* error handling */
    {
        printf("Error in allocating memory\n");
        return;
    }

    // Scan the postfix Expression from Left to Right
    for (int i = 0, size = strlen(postfix); i < size; i++)
    {
        /* case 1
        IF the incoming charter SYMBOL is Operand PUSH it onto Stack. */

        if (is_Operand(postfix[i]))
        {
            push(stack, postfix[i]); // Push Operand to stack
        }
         /*
         IF the incoming charter is Operator( +,*,/,-,^)
         (since this is the last case we dont even need to call
         Operator function we can just go with simple else block) */
         else if (is_Operator(postfix[i]))
         {
             // TO DO

            /* POP 2 OPERANDs from the Stack,
             ADD this incoming OPERATOR in between the 2 OPERANDs
            , ADD ‘(‘ & ‘)’ to the whole expression & PUSH this whole new
            expression string back into the Stack. */
            // TO do COde is not complete

         }

    } /** END of for loop */


    infix[++k] = '\0';  // add '\0' at the end of infix Expression

    // print the expression after Convention
    printf("After Convert infix Expression is : %s\n",infix); /* output must be " AB+C-DEF^^*G/ " */

} /** End of Postfix_To_Infix() */


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
   Utility function to Check if the given character is Operand or not
   here am assuming that operand will be a single character*/

int is_Operand(char C)
{
    if((C >=  'A' && C <= 'Z')  ||
      (C  >=  'a' && C <= 'z')  ||
      (C  >=  '0' && C <= '9'))
       return 1; // is Operand
    else
      return 0; // is not Operator

} /** End of is_is_Operand() */


/**
    Utility function to Check if the given character
    is operator symbol or not */

int is_Operator(char c)
{
    if(c == '+' || c == '-' || c== '*' || c == '/' || c =='^')
       return 1; // is Operator
    else
      return 0; // is not Operator

} /** End of is_Operator() */


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
