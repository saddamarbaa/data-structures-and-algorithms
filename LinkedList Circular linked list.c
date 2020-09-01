/**
    [PROGRAM] : Circular Linked List Data Structure Complete Implementation

    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program for Complete implementation of Circular Linked List.

    A linked list is a linear data structure, in which the elements
    are not stored at contiguous memory locations.
    The elements in a linked list are linked using pointers
    (entity that point to the next element)

    Circular Linked List is a type of Linked List Data structure
    in which the last element is linked to the first element.
    This forms a circular loop.

     Reference in future :---->
     1.*/

#include <stdio.h>
#include <stdlib.h>

/* Circular Linked List  node */
struct Node
{
    int data;            /* data filed */
    struct Node* next;  /* address of next node */
};

/*  global variable pointer to tail node(last node)*/
struct Node* last = NULL;

/*  Function to create new node */
struct Node* CreateNewNode(int);

/* Function to add new node to the end of list */
void Append(int);

/* Function to add new node to the Beginning of list */
void insert_At_Beginning(int);

/* Function to add new node at the given position in list */
void insert_At_Position(int, int);

/* Function to add new node just after the given position */
void insert_After_Position(int, int);

/* Function to add new node just before the given position */
void insert_Before_Position(int, int);

/* Function to Delete node from the Beginning of linked list */
void Delete_from_Beginning(void);

/* Function to Delete node from the end of linked list */
void Delete_from_End(void);

/* Function to Delete node from a specific in linked list */
void Delete_node_at_position(int);

/* Function to Delete node Before a specific in linked list */
void Delete_node_Before_position(int);

/* Function to Delete node After a specific in linked list */
void Delete_node_After_position(int);

/* Function to Remove node with the given value from list */
void Remove(int);

// function to traverse linked list and Print
// all element (Iterative method) */
void Traverse(void);

//  function to traverse linked list and Print
//  all element (Recursive method) */
void print_using_recursion(struct Node* temp);

//  function to traverse linked list and Print all element
//  in reverse order using recursion(Recursive method) */
void Reverse_print_using_recursion(struct Node* temp);

//  function to traverse linked list and Print all element
//  in reverse order using loop(Iterative method)  */
void Reverse_print_using_loop();

/* function to find the length of linked list*/
int length(void);

/* function to Reverse a linked list(Iterative method)*/
void Reverse(void);

/* function to Reverse a linked list(Recursive method)*/
void Reverse_using_recursion(struct Node* p);

int main(int argc, char* argv[])    /* the river Code */
{
    int option, len, position, element;  /* variable declarations */

    do
    {
        printf("Doubly linkedlist Implementation(All Linked List Operations)   :\n");
        printf("1 : Append  : insert new node to the end of list                :\n");
        printf("2 : Prepend : insert new node to the beginning of list          :\n");
        printf("3 : Insert at position : insert new node to a specific position :\n");
        printf("4 : Insert after position : insert after a specific position    :\n");
        printf("5 : Insert Before position : insert Before a specific position  :\n");
        printf("6 : Delete node from the Beginning of linked list               :\n");
        printf("7 : Delete node from the End of linked list                     :\n");
        printf("8 : Delete node from a specific position                        :\n");
        printf("9 : Delete node Before a specific position                      :\n");
        printf("10: Delete node after a specific position                       :\n");
        printf("11: Remove   : remove node with the given value from list       :\n");
        printf("12: Traverse : Print all the element in list (Iterative method) :\n");
        printf("13: Traverse : Print all the element in list (Recursive method) :\n");
        printf("14: Traverse : Print element in Reverse order(Recursive method) :\n");
        printf("15: Traverse : Print element in Reverse order(Iterative method) :\n");
        printf("16: Reverse  : Reverse linked list(Iterative method)            :\n");
        printf("17: Reverse : Reverse linked list(Recursive method)             :\n");
        printf("18: length   : find length of the linked list                   :\n");
        printf("0 : Enter 0 to exit (quit)                                      :\n");
        // asking user to enter choice
        printf("input your choice                                               :");
        scanf("%d",&option);
        switch(option)
        {
            // case 1 insert new node to the end of list
            case 1 :
                printf("Enter element to be inserted at the end  :");
                scanf("%d",&element);
               // Append(element); // call append function
            break;

            // case 2 insert new node to the the beginning of list
            case 2 :
                printf("Enter element to be inserted at the beginning  :");
                scanf("%d",&element);
                insert_At_Beginning(element); // call Insert_At_Begining function
            break;

            // case 3 insert node at a specific position
            case 3 :
                printf("Enter element to be inserted :");
                scanf("%d",&element);
                printf("Enter the position :");
                scanf("%d",&position);
              // insert_At_Position(element, position); // call insert_at_Possition function
            break;

            // case 4 insert node After a specific position
            case 4 :
                printf("Enter element to be inserted :");
                scanf("%d",&element);
                printf("Enter the position :");
                scanf("%d",&position);
               // insert_After_Position(element, position); // call insert_after_Possition function
            break;

            // case 5 insert node Before a specific position
            case 5 :
                printf("Enter element to be inserted :");
                scanf("%d",&element);
                printf("Enter the position :");
                scanf("%d",&position);
                //insert_Before_Position(element, position);  // call insert_Before_Possition function
            break;

            // case 6 Delete node from the Beginning of linked list
            case 6 :
              // Delete_from_Beginning(); // call Delete_from_Beginning function
            break;

            // case 7 Delete node from the end of linked list
            case 7 :
               //Delete_from_End(); // call Delete_from_End function
            break;

            // case 8 Delete node from specific position in list
            case 8 :
                printf("Enter the position to be deleted :");
                scanf("%d",&position);
               // Delete_node_at_position(position); // call Delete_node_at_possition function
            break;

            // case 9 Delete node Before specific position in list
            case 9 :
                printf("Enter the position to be deleted :");
                scanf("%d",&position);
               // Delete_node_Before_position(position); // call Delete_Before_possition function
            break;

            // case 10 Delete node After specific position in list
            case 10 :
                printf("Enter the position to be deleted :");
                scanf("%d",&position);
               // Delete_node_After_position(position); // call Delete_node_After_possition function
            break;

            // case 11 Remove node with the given value from list
            case 11 :
                printf("Enter Value to be deleted :");
                scanf("%d",&element);
               // Remove(element);   // call  Removee function
            break;

            // case 12 traverse linked list and Print all element(Iterative method)
            case 12 :
                 Traverse(); // call  Traverse function
            break;

            // case 13 traverse linked list and Print all element(Recursive method)
            case 13 :
               // print_using_recursion(Head); // call  print_using_recursion function
            break;

            // case 14 traverse linked list and Print all element
            // in reverse order using recursion(Recursive method)
            case 14 :
               // Reverse_print_using_recursion(Head); // call  Reverse_print_using_recursion function
                printf("\n");
            break;

            // case 15 traverse linked list and Print all element
            // in reverse order using loop(Iterative method)
            case 15 :
                //Reverse_print_using_loop(); // call  Reverse_print_using_loop function
                printf("\n");
            break;

            // case 16 Reverse linked list(Iterative method)
            case 16 :
               // Reverse(); // call Reverse function
            break;

            // case 17 Reverse linked list(Iterative method)
            case 17 :
               // Reverse_using_recursion(Head); // callReverse_using_recursion function
            break;

            // case 18 length of the  linked list
            case 18 :
                len = length();  // call length function
                if(len == 0)
                   printf("Doubly linked list is Empty!!!\n");
                else
                   printf("length is  : %d\n",len);
            break;

            case 0 :  /* case 0 Exit case */
                printf("time to exit thanks\n");
            _Exit(0);

            default : /* default case */
                 printf("invalid input\n");
            break; // no need break after default case I use it only for readability

        } /** END of switch */

    }while(1);  /** END OF DO WHILE LOOP */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
    A utility function create a new Node in heap so I can called
    it each time I need new node take the value to be inserted
    in the new node as argument  */

struct Node* CreateNewNode(int value)
{
    struct Node* newNode; /* first create node */

    // allocate memory dynamically for node using malloc C function
    newNode = (struct Node*) malloc(sizeof (struct Node));

    if(newNode == NULL) /* error handling */
      printf("error in allocating memory\n");

    /* adding information to node */
    newNode -> data = value; // set value at data filed
    newNode -> next = NULL;  // next is NULL for now

     return   newNode;  // return newly created node to place where it been be called

} /** END of CreateNewNode() */


/** A utility function to insert new node to the Beginning of list */

void insert_At_Beginning(int value)
{
    // local variable of type struct node declaration */
    struct Node *newNode;

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if(last == NULL) /* check if list is empty then this node is the first node */
    {
        /** link changes */
        last = newNode;  // insert first node in list
        last -> next = newNode; // make it Circular Linked List
        printf("%d : is been inserted as first node in list\n",value); // inform user the element is been inserted
    }
    else
    {
       /* if already some element are in the linked list we
          have to add the new node at the Beginning of the list */

         /** link changes */

         newNode -> next = last -> next;    // right side connection first
         last -> next = newNode;           // make it Circular List last nod is now point to first node
         printf("%d : is been inserted at the Beginning of list\n",value); // inform user the element is been inserted
         printf("%d : is last -> next -> data\n", last -> next -> data); // inform user everything is ok
    }

    /** Time complexity of insert_at_Begining() is  : O(1) */

} /** End of insert_at_Begining() */


/** A utility function to find the length of linked list */

int length()
{
    int count = 0;     // local counter variable declaration and initializations to zero
    struct Node* temp; // local variable of type struct node declaration */
    // last -> next mean the first node
    temp = last -> next;     // temp is now point to first node

    if(last == NULL) /* linked is empty Case */
    {
        printf("Circular Linked List is Empty!!!\n");
        return 0;
    }

    /* count first node and move temp to second node and
       count again in loop until we reach to last node */
    while(temp != last)
    {
        count++;              // increment count
        temp = temp -> next;  // move temp to next node
    }
    count = count + 1 ; // just to include the last node so have to add one to count before return
    return count; // // after done counting return number of node

    /** Time complexity of length() is O(n) */

} /** End of length */


/** Utility function to traverse the linked list
    and print all the element(Iterative method)*/

void Traverse()
{
    struct Node* temp;       // local variable of type struct node declaration */

    if(last == NULL) /* linked is empty Case */
    {
        printf("Circular Linked List is Empty!!!\n");
        return; // we are done
    }

    // last -> next mean the first node
    temp = last -> next;     // temp is now point to first node

    /*
    by now we are sure list is not empty so while we not yet reach
    last node print the value of node first and set temp ton point
    to the next node */
    while(temp != last)
    {
        printf("%d --> ", temp -> data);  // print the value
        temp = temp -> next;              // move temp to next node
    }
    // by now we are at last node but the value of last itself not yet been printed
    printf("%d --> ", temp -> data); // print the last element
    printf("\n");

    /** Time complexity of Traverse() is O(n) */

} /** End of Traverse */
