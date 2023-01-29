/**
    [PROGRAM] :  Infix to Prefix Conversion Using Stack
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Convert Infix to Prefix Expression Using STACK Data Structure.

     Reference in future :---->
     1. https://youtu.be/rs3yFyq_Kds
     2. https://youtu.be/g1Zwz2kSKEU
     3. https://youtu.be/b6miFHYFaVI
     4. https://youtu.be/lT4-mJAF5UA
     5. https://youtu.be/gmlVZ68KRD8
     6. https://youtu.be/-vZA4qdDxAg
     7. https://youtu.be/jos1Flt21is
     8. https://youtu.be/MeRb_1bddWg */

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

// function to Convert Infix Expression to Postfix Expression
void Infix_To_Prefix(char*);

//function to Reverse a string
char* Reverse(struct Stack* stack, char*);

int main(int argc, char* argv[]) // the  Driver Code
{
    printf("Convert Infix to Prefix Expression using Stack Data Structure\n");

    // variable declarations
    char* infix_Expression = "((A+B-C)*D^E^F)/G";  // output Expression must be   " /*-+ABC^D^EFG "

    // print the expression Before Convention
    printf("Before Convert infix Expression is : %s\n",infix_Expression);

    // call Infix_To_Prefix() function
    Infix_To_Prefix(infix_Expression);

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
    function to Convert Infix Expression to Prefix Expression

    Algorithm Convert Infix to Prefix
    1. Reverse infix expression & swap ‘(‘ to ”)’ & ‘)’ to ”(‘
    2. Scan the infix expression from left to right.
    3. If the scanned character is an operand,output it.
    4. If the scanned character is operator and Stack is empty,
        push this operator onto the stack
    5.  IF incoming SYMBOL is ‘(‘ PUSH it onto Stack.
    6.  IF incoming SYMBOL is ‘)’ POP the stack and print OPERATORs
         till ‘(‘ is found. POP that ‘(‘
    7. IF incoming OPERATOR has HIGHER precedence than the TOP of
       the Stack, push it on stack
    8. IF incoming OPERATOR has EQUAL precedence with TOP of Stack
       && incoming OPERATOR is ‘^’,  POP & PRINT TOP of Stack.
       Then test the incoming OPERATOR against the NEW TOP of stack.
    9. IF incoming OPERATOR has EQUAL precedence with TOP of Stack, PUSH it on Stack.
    10. IF incoming OPERATOR has LOWER precedence than the TOP of the Stack,
        then POP and PRINT the TOP.
        Then test the incoming OPERATOR against the NEW TOP of stack.
    11. At the end of Expression, POP & print all  OPERATORS from the stack
    12 . Reverse the Prefix expression */

void Infix_To_Prefix(char* infix)
{
    // counter variable K declarations and initializations to -1
    int k = -1;

    // allocate memory dynamically for Prefix Expression using malloc
    char* Prefix = malloc(strlen(infix) + 1);

    if(Prefix == NULL) /* error handling */
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

    /*
     first step
     Reverse the given Expression */
    infix = Reverse(stack ,infix); // call Reverse() function

    /*
     second step
     swap ‘(‘ to ”)’ & ‘)’ to ”(‘ */
    // Scan the Reverse Expression from Left to Right
    for (int i = 0, size = strlen(infix); i < size; i++)
    {
         if (infix[i] == '(')
             infix[i] = ')'; // swap
         else if (infix[i] == ')')
            infix[i] = '('; //  swap
    }

    /*
    next step
    Scan the Reverse Expression from Left to Right */
    for (int i = 0, size = strlen(infix); i < size; i++)
    {
        /* case 1
        IF the incoming charter is an operand then Print
        operand as the arrive( add it to output) */
        if(is_Operand(infix[i]))
        {
            Prefix[++k] = infix[i]; // add OPERAND to Prefix as its
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
                Prefix[++k] = top(stack); // add top to Prefix Expression
                pop(stack);              // pop the top out
            }
            // after while loop if top == '(' then pop out '('
            if(top(stack) == '(')
                pop(stack);      // pop '(' out
        }
         /*
         IF the incoming charter is Operator(+,*,/,-,^)
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
                  (this one is special case about '^' as '^' have Right to Left Associativity)
                  this is mean incoming Operator is '^' */
                  else if((precedence(infix[i]) == precedence(top(stack))) && ((infix[i] == '^')))
                  {
                      // this  mean infix[i] is ^
                      while ((precedence(infix[i]) == precedence(top(stack))) && ((infix[i] == '^')))
                      {
                          Prefix[++k] = top(stack); // add top Operator '^' to Prefix Expression
                          pop(stack);         // pop '^' out
                      }
                      push(stack, infix[i]); // Push the new  ('^') to stack
                  }
                  // this mean infix[i] is is not ^
                 else if((precedence(infix[i]) == precedence(top(stack))))
                 {
                     push(stack, infix[i]); // Push the Operator to stack
                 }
                  /*
                   else case
                  else if((precedence(infix[i]) < precedence(top(stack)))) */
                  else
                  {
                      while((!isEmpty(stack)) && (precedence(infix[i]) < precedence(top(stack))))
                      {
                          Prefix[++k] = top(stack); // add top Operator to Prefix Expression
                          pop(stack);         // pop the top Operator out
                      }
                      // after while loop
                      push(stack, infix[i]); // Push the new Operator to stack ('^')
                  }
              }
         }

    } /** END of for loop */

    /*
    after the for loop
    while stack is not empty pop out the remaining operators */
    while(!isEmpty(stack))
    {
        Prefix[++k] = top(stack); // add the remaining operators to Prefix Expression
        pop(stack);                // pop the top the operators Expression
    }

    Prefix[++k] = '\0';  // add '\0' at the end of Prefix Expression

    /* last step
    Reverse the Prefix Expression */
    Prefix = Reverse(stack ,Prefix); // call Reverse() function

    // print the expression after Convention
    printf("After Convert Prefix Expression is : %s\n",Prefix); /* output must be " AB+C-DEF^^*G/ " */

} /** End of Infix_To_Prefix() */


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


/**
    function to determine Associativity Operator precedence
    An operator with higher weight will have higher precedence.
    (return precedence of a given operator) */

int precedence(char op)
{
    if(op == '^')  /* Highest precedence */
    return 3;
    else if(op == '*' || op == '/')  /* second Highest precedence */
    return 2;
    else if(op == '+' || op == '-')  /* third Highest precedence */
    return 1;
    return -1; // in all else cases

} /** End of precedence() */


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
