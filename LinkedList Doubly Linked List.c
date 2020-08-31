/**
    [PROGRAM] : Doubly linkedlist Data Structure Complete Implementation

    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program for Complete implementation of Doubly linkedlist data structure.

    A linked list is a linear data structure, in which the elements
    are not stored at contiguous memory locations.
    The elements in a linked list are linked using pointers
    (entity that point to the next element)

     Reference in future :---->
     1. https://youtu.be/JdQeNxWCguQ
     2. https://youtu.be/VOQNf1VxU3Q
     3. https://youtu.be/nquQ_fYGGA4
     4. https://youtu.be/H8-IuKKiQeo
     5. https://youtu.be/v4szCPs9yEY
     6. https://youtu.be/7yNUXcOcHwE
     7. https://youtu.be/_6JI9XdO8nM



 */

#include <stdio.h>
#include <stdlib.h>

/* A Doubly linked list node */
struct Node
{
    int data;            /* data filed */
    struct Node* next;  /* address of next node */
	struct Node* prev; /* address of previous node */
};

/*  global variable pointer to head node  */
struct Node* Head = NULL;

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
//void Delete_from_Beginning(void);

/* Function to Delete node from the end of linked list */
//void Delete_from_End(void);

/* Function to Delete node from a specific in linked list */
//void Delete_node_at_position(int);

/* Function to Delete node Before a specific in linked list */
//void Delete_node_Before_position(int);

/* Function to Delete node After a specific in linked list */
//void Delete_node_After_position(int);

/* Function to Remove node with the given value from list */
//void Remove(int);

// function to traverse linked list and Print
// all element (Iterative method) */
void Traverse(void);

//  function to traverse linked list and Print
//  all element (Recursive method) */
void print_using_recursion(struct Node* temp);

//  function to traverse linked list and Print
//  all element (Recursive method) */
void print_using_recursion(struct Node* temp);

//  function to traverse linked list and Print all element
//  in reverse order using recursion(Recursive method) */
//void Reverse_print_using_recursion(struct node* temp);

/* function to find the length of linked list*/
int length(void);

/* function to Reverse a linked list(Iterative method)*/
//void Reverse(void);

/* function to Reverse a linked list(Recursive method)*/
//void Reverse_using_recursion(struct node* p);

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
        printf("15: Reverse  : Reverse linked list(Iterative method)            :\n");
        printf("16: Reverse : Reverse linked list(Recursive method)             :\n");
        printf("17: length   : find length of the linked list                   :\n");
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
                Append(element); // call append function
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
               insert_At_Position(element, position); // call insert_at_Possition function
            break;

            // case 4 insert node After a specific position
            case 4 :
                printf("Enter element to be inserted :");
                scanf("%d",&element);
                printf("Enter the position :");
                scanf("%d",&position);
                insert_After_Position(element, position); // call insert_after_Possition function
            break;

            // case 5 insert node Before a specific position
            case 5 :
                printf("Enter element to be inserted :");
                scanf("%d",&element);
                printf("Enter the position :");
                scanf("%d",&position);
                insert_Before_Position(element, position);  // call insert_Before_Possition function
            break;

            // case 6 Delete node from the Beginning of linked list
            case 6 :
               // Delete_from_Beginning(); // call Delete_from_Beginning function
            break;

            // case 7 Delete node from the end of linked list
            case 7 :
               // Delete_from_End(); // call Delete_from_End function
            break;

            // case 8 Delete node from specific position in list
            case 8 :
                printf("Enter the position to be deleted :");
                scanf("%d",&position);
                //Delete_node_at_position(position); // call Delete_node_at_possition function
            break;

            // case 9 Delete node Before specific position in list
            case 9 :
                printf("Enter the position to be deleted :");
                scanf("%d",&position);
                //Delete_node_Before_position(position); // call Delete_Before_possition function
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
                print_using_recursion(Head); // call  print_using_recursion function
            break;

            // case 14 traverse linked list and Print all element
            // in reverse order using recursion(Recursive method)
            case 14 :
                Reverse_print_using_recursion(Head); // call  Reverse_print_using_recursion function
                printf("\n");
            break;

            // case 15 Reverse linked list(Iterative method)
            case 15 :
                // Reverse(); // call Reverse function
            break;

            // case 16 Reverse linked list(Iterative method)
            case 16 :
                // Reverse_using_recursion(first); // callReverse_using_recursion function
            break;

            // case 17 length of the  linked list
            case 17 :
                len = length();  // call length function
                if(len == 0)
                   printf("linked list is empty \n");
                else
                  printf("length is  : %d\n", len);
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
    newNode -> prev = NULL;  // prev is NULL for now

     return   newNode;  // return newly created node to place where it been be called

} /** END of CreateNewNode() */


/** A utility function to(Append)
    insert new node to the end of list */

void Append(int value)
{
    // local variables of type struct node declaration */
    struct Node *newNode, *temp;

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if (Head == NULL) /* check if list is empty then this node is the first node */
    {
        // insert as the first node in list
        insert_At_Beginning(value);  // call Insert_At_Begining to added as first node
    }
    else
    {
         /*
         if already some element are in the linked list we have to first
         loop throw the linked list then add the new element at end */

         temp = Head;     // temp is now point to head node

         while(temp -> next != NULL) /* while we not yet reach to NULL move temp ahead*/
         {
             temp = temp -> next; // move temp to next node
         }

        /** link changes */
        newNode -> prev = temp;   // right side connection first
        temp -> next = newNode; //// left side connection second
        printf("%d : is been inserted at end of list\n",value); // inform user the element is been inserted
    }

    /** Time complexity of Append() is : O(N) */

} /** End of Append() */


/** A utility function to insert new node to the Beginning of list */

void insert_At_Beginning(int value)
{
    // local variable of type struct node declaration */
    struct Node *newNode;

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if(Head == NULL) /* check if list is empty then this node is the first node */
    {
        Head = newNode;  // insert first node in list
        printf("%d : is been inserted as first node in list\n",value); // inform user the element is been inserted
    }
    else
    {
        /* if already some element are in the linked list we
           have to add the new node at the Beginning of the list */

         /** link changes */

        newNode -> next = Head;   // right side connection first
        Head -> prev = newNode;   // left side connection second
        Head = newNode;           // let Head point to the new node

        printf("%d : is been inserted at the Beginning of list\n",value); // inform user the element is been inserted
    }
    /** Time complexity of insert_at_Begining() is  : O(1) */

} /** End of insert_at_Begining() */


/**
   A utility function to insert the given value at the given position
   (adding node in the middle)  */

void insert_At_Position(int value, int position)
{
    int i, len;       // local variable declaration
    struct Node *newNode, *temp; // local variables of type struct node declaration */
    i = 1;            // initialize counter i to one
    temp = Head;     // temp is now point to head node
    len = length();   // call length() to get length of list

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    /* this condition handle all the corner case when given position == 1 */
    if((Head == NULL && position == 1) || (Head != NULL && position == 1))
    {
        // in both cases inserted as the first node in list
        insert_At_Beginning(value);  // call Insert_At_Begining to added as first node
    }
    else if(position > len || position < 1) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }
    else
    {
        /*
        if already some element are in the linked list and given position
        is not number one then we have to first loop throw the linked list
        until position - 1 then add the new element at given position */
        while(i < position - 1)
        {
            temp = temp -> next; // move temp to next node
            i++; // increment counter i by one
        }

        /** link changes */
        newNode -> next = temp -> next;  // right side connection first
        temp -> next -> prev = newNode;     // right side connection first
        newNode -> prev = temp;          // left side connection second
        temp -> next = newNode;           // left side connection second
        printf("%d : is been inserted at %d position \n",value, position); // inform user the element is been inserted
    }

    /** Time complexity of insert_At_Position() is O(n) */

} /** END of insert_at_Possition() */


/**
   A utility function to insert the given value After the given position
   (adding node in the middle)  */

void insert_After_Position(int value, int position)
{
    int i, len;                  // local variable declaration
    struct Node *newNode, *temp; // local variables of type struct node declaration */

    // create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)
    temp = Head;     // temp is now point to head node
    len = length();   // call length() to get length of list
    i = 1;            // initialize counter i to one

    if(Head == NULL) /* linked is empty Case */
    {
        printf("linked list is Empty!!!\n");
        return; // we are done
    }
    else if(position  > len || position < 1) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }

    else if(position == len) /* handling corner cases */
    {
        // insert at the end of list
        Append(value); // call Append  function for help
        return;
    }
    /*
    if already some element are in the linked list we have to first
    loop throw the linked list until position then add the new node
    at just after given position */
    while(i < position)
    {
        temp = temp -> next;   // move temp to next node
        i++;                   // increment counter i by one
    }

    /** link changes */
    newNode -> next = temp -> next;  // right side connection first
    temp -> next -> prev = newNode;   // right side connection first
    newNode -> prev = temp;          //  left side connection second
    temp -> next = newNode;           // left side connection second
    printf("%d : is been inserted at %d position \n",value, position + 1); // inform user the element is been inserted

    /** Time complexity of insert_After_Position() is O(n) */

} /** END of insert_after_Possition() */


/**
   A utility function to insert the given value Before the given position
   (adding node in the middle)  */

void insert_Before_Position(int value, int position)
{
    int i, len;                  // local variable declaration
    struct Node *newNode, *temp; // local variables of type struct node declaration */

    // create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)
    temp = Head;     // temp is now point to head node
    len = length();   // call length() to get length of list
    i = 1;            // initialize counter i to one

    /* handling corner cases */

    if(Head == NULL) /* linked is empty Case */
    {
        printf("linked list is Empty!!!\n");
        return; // we are done
    }
    else if(position > len || position < 2) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }
    else if(position == 2)  /* case if list is not empty and position == 2 */
    {
        // insert at beginning in list in first position
        insert_At_Beginning(value);  // call Insert_At_Begining
        return; // we are done
    }
    /*
    if already some element are in the linked list and given position
    is not two we have to first loop throw the linked list until position - 2
    then add the new node at just after given position */
    while(i < position - 2)
    {
        temp = temp -> next;   // move temp to next node
        i++;                   // increment counter i by one
    }

    /** link changes */
    newNode -> next = temp -> next;  // right side connection first
    temp -> next -> prev = newNode;   // right side connection first
    newNode -> prev = temp;          //  left side connection second
    temp -> next = newNode;           // left side connection second
    printf("%d : is been inserted at %d position \n",value, position - 1); // inform user the element is been inserted

    /** Time complexity of insert_Before_Position() is O(n) */

} /** END of insert_Before_Position() */


/** Utility function to traverse the linked list
    and print all the element(Iterative method)*/

void Traverse()
{
    struct Node* temp; // local variable of type struct node declaration */
    temp = Head;      // temp is now point to head node

    if(Head == NULL) /* linked is empty Case */
    {
        printf("linked list is Empty!!!\n");
        return; // we are done
    }
     /*
     by now we are sure list is not empty
     so while we not yet reach NULL print the value
     of node first and set temp to point to the next node */
     while(temp != NULL)
     {
         printf("%d --> ", temp -> data);  // print the value
         temp = temp -> next;              // move temp to next node
     }
     printf("\n");

    /** Time complexity of Traverse() is O(n) */

} /** End of Traverse */


/** A utility function to find the length of linked list */

int length()
{
    int count = 0;     // local counter variable declaration and initializations to zero
    struct Node* temp; // local variable of type struct node declaration */
    temp = Head;      // temp is now point to head node

    /* while not yet reach NULL count the number of nodes in list */
    while(temp != NULL)
    {
        count++;              // increment count
        temp = temp -> next;  // move temp to next node
    }
    return count; // return the number of node in list

    /** Time complexity of length() is O(n) */

} /** End of length */


/**
    Utility function to traverse the linked list and print
    all the element recursion(Recursive method)
    Reference in Future
   1. https://youtu.be/K7J3nCeRC80  */

void print_using_recursion(struct Node* temp)
{
    if(temp == NULL) //Exit condition
    {
        printf("\n");
         return;
    }

    // else cases
    printf("%d --> ", temp -> data);      // first print the in the node which is first node
    print_using_recursion(temp -> next); // Recursive call to move to next node

} /** End of print_using_recursion */


/**
    Utility function to traverse the linked list and print all the
    element in reverse order using recursion(Recursive method)
    Reference in Future
   1. https://youtu.be/K7J3nCeRC80  */

void Reverse_print_using_recursion(struct Node* temp)
{
    if(temp == NULL) //Exit condition
        return;

    // else cases
    Reverse_print_using_recursion(temp-> next); // Recursive call to move to next node first

    printf("%d --> ", temp -> data);  // after reach to last node and temp == NULL
                                     // will start printing from last to first in reverse order

} /** End of Reverse_print_using_recursion */
