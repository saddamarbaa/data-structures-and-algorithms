#include <stdio.h>
#include "stdlib.h"
//#include <cs50.h>  //<cs50.h>  this because am now using Cs50 IDE
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

//Function to pop(remove)top character from stack
char pop(struct Stack* stack);

// function to get the top character from without deleting it
char top(struct Stack* stack);

// function to Check if the stack is empty or not
int isEmpty(struct Stack* stack);

// function to Convert Infix Expression to Postfix Expression
void InfixToPostfix(char*);

int main(int argc, char* argv[]) // the  Driver Code
{
    printf("Convert Infix to Postfix Expression using STACK Data Structure\n");

    // variable declarations
    char* infix_Expression = "((A+B-C)*D^E^F)/G";  /* output Expression must be " AB+C-DEF^^*G/ " */

    // print the expression Before Convention
    printf("Before Convert infix expression is : %s\n",infix_Expression);

    // call InfixToPostfix() function
    InfixToPostfix(infix_Expression);

    return 0;// signal to operating system everything works fine

}/** End of main function */

/**
    function to Convert Infix Expression to Postfix Expression
    Algorithm
    1. Scan the infix expression from left to right.
    2. If the scanned character is an operand,output it.
    3. If the scanned character is aoperator and Stack is empty,
        push this operator onto the stack
    4.  IF incoming SYMBOL is ‘(‘ PUSH it onto Stack.
    5.  IF incoming SYMBOL is ‘)’ POP the stack and print OPERATORs
         till ‘(‘ is found. POP that ‘(‘
    6. IF incoming OPERATOR has HIGHER precedence than the TOP of
       the Stack, push it on stack
    7. IF incoming OPERATOR has LOWER precedence than the TOP of
       the Stack, then POP and print the TOP. Then test the incoming
       operator against the NEW TOP of stack.
    8. IF incoming OPERATOR has EQUAL precedence with TOP of Stack,
        use ASSOCIATIVITY Rules.
    9. For ASSOCIATIVITY of LEFT to RIGHT –>
        POP and print the TOP of stack, then push the incoming OPERATO
    10. For ASSOCIATIVITY of RIGHT to LEFT –
       PUSH incoming OPERATOR on stack.
    11. IF TOP of stack is ‘(‘ PUSH OPERATOR on Stack
    12. At the end of Expression, POP & print all  OPERATORS from the stack*/

void InfixToPostfix(char* infix)
{
    // counter variable K declarations and initializations to -1
    int k = -1;

    // allocate memory dynamically for postfix Expression using malloc
    char* postfix = malloc(strlen(infix) + 1);
    if(postfix == NULL) /* error handling */
    {
        printf("Error in allocating memory\n");
        return;
    }
    // Create a stack of capacity equal to expression size
    struct Stack* stack = create_Stack(strlen(infix));
    if(stack == NULL) /* error handling */
    {
        printf("Error in allocating memory\n");
        return;
    }

    // Scan the  Expression from Left to Right
    for (int i = 0, size = strlen(infix); i < size; i++)
    {
        /* case 1
        IF the incoming charter is an operand then Print
        operand as the arrive( add it to output) */
        if(is_Operand(infix[i]))
        {
            postfix[++k] = infix[i]; // add OPERAND to postfix as its
        }
        /* case 2
        IF the incoming charter SYMBOL is ‘(‘ PUSH it onto Stack. */
        else if (infix[i] == '(')
        {
            push(stack, infix[i]); // Push '(' to stack
        }
        /*
         case 3
         IF the incoming charter SYMBOL is ‘)’ POP the stack and print
         OPERATORs till ‘(‘ is found. POP that ‘(‘ */
        else if (infix[i] == ')')
        {
            while((top(stack) != '(') && (!isEmpty(stack)))
            {
                postfix[++k] = top(stack); // add top to postfix Expression
                pop(stack);              // pop the top out
            }
            // after while loop if top == '(' then pop out '('
            if(top(stack) == '(')
               pop(stack);      // pop '(' out
        }
         /*
         IF the incoming charter is Operator( +,*,/,-,^)
         (since this is the last case we dont even need to call
         Operator function we can just go with simple else block) */
         else if (is_Operator(infix[i]))
         {
             if(isEmpty(stack)) // if stack is Empty
              {
                  push(stack, infix[i]); // Push the Operator to stack
              }
              else  /* in else case we have 3 cases */
              {
                  /*
                  IF the incoming Operator has high precedence than top of stack
                  then push incoming Operator to stack */
                  if(precedence(infix[i]) > precedence(top(stack)))
                  {
                      push(stack, infix[i]); // Push the Operator to stack
                  }
                  /*
                  (this one is special case about'^')
                  this is mean incoming Operator is '^' */
                  else if((precedence(infix[i]) == precedence(top(stack))) && ((infix[i] == '^')))
                  {
                      push(stack, infix[i]); // Push ('^') to stack
                  }
                  else // else case
                  {
                      while((!isEmpty(stack)) && (precedence(infix[i]) <= precedence(top(stack))))
                      {
                          postfix[++k] = top(stack); // add top Operator to postfix Expression
                          pop(stack);         // pop the top Operator out
                      }
                      // after while loop
                      push(stack, infix[i]); // Push the new Operator to stack
                  }
              }
         }

    } /** END of for loop */

    /*
    after the for loop
    while stack is not empty pop out the remaining operators */
    while(!isEmpty(stack))
    {
        postfix[++k] = top(stack); // add the remaining operators to postfix Expression
        pop(stack);                // pop the top the operators Expression
    }

    postfix[++k] = '\0';  // add '\0' at the end of postfix Expression

    // print the expression after Convention
    printf("After Convert postfix expression is : %s\n",postfix); /* output must be " AB+C-DEF^^*G/ " */

} /** End of InfixToPostfix() */


/** A utility function to create stack */

struct Stack* create_Stack(unsigned capacity)
{
    struct Stack* stack;  /* first create stack node */

    // allocate memory dynamically for Stack using malloc
    stack = (struct Stack*) malloc(sizeof (struct Stack));

    if(stack == NULL) /* Error handling */
      printf("Error in allocating memory\n");

    /* adding information to Stack */
    stack -> top = -1;    // set  top to -1
    stack -> capacity = capacity; // set capacity at capacity filed

    /* allocate memory dynamically for Stack array using malloc  */
    stack -> array = (int*) malloc(stack -> capacity * sizeof(int));

    if(stack -> array == NULL) /* Error handling */
      printf("Error in allocating memory\n");

    return stack;  // return newly created stack to place where it been be called

} /** END of Create_Stack() */

/**
   Utility function to Check if the
   given character is Operand or not */

int is_Operand(char c)
{
    if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
       return 1; // is Operand
    else
      return 0; // is not Operator

} /** End of is_is_Operand() */


/**
   Utility function to Check if the
   given character is Operator or not */

int is_Operator(char c)
{
    if(c == '+' || c == '-' || c== '*' || c == '/' || c =='^')
       return 1; // is Operator
    else
      return 0; // is not Operator

} /** End of is_Operator() */


/** function to determine Associativity Operator precedence
     (return precedence of a given operator) */

int precedence(char c)
{
    if(c == '^')  /* Highest precedence */
    return 3;
    else if(c == '*' || c == '/')  /* second Highest precedence */
    return 2;
    else if(c == '+' || c == '-')  /* third Highest precedence */
    return 1;
    return -1; // in all else cases

} /** End of precedence() */


/** A utility function to push new given character to stack */

void push(struct Stack* stack, char c)
{
    // increment top by one first
    stack -> array[++stack -> top] = c; // add the given character to stack

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
