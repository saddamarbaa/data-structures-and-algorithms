/**
    [PROGRAM] : Circular Linked List Data Structure Complete Implementation

    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program for Complete Implementation of Circular Linked List.

    A linked list is a linear data structure, in which the elements
    are not stored at contiguous memory locations.
    The elements in a linked list are linked using pointers
    (entity that point to the next element)

    Circular Linked List is a type of Linked List Data structure
    in which the last element is linked to the first element.
    This forms a circular loop.

     Reference in future :---->
     1. https://youtu.be/fmfx1C4TTxw
     2. https://youtu.be/jsTybZ5qSNE
     3. https://youtu.be/ReGglEXEH08
     4. https://youtu.be/EkE6RHuMx3I
     5. https://youtu.be/xvAoleV706Q */

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
        printf("Circular LinkedList Implementation(All Linked List Operations)   :\n");
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
        printf("16: length   : find length of the linked list                   :\n");
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
               Delete_from_Beginning(); // call Delete_from_Beginning function
            break;

            // case 7 Delete node from the end of linked list
            case 7 :
               Delete_from_End(); // call Delete_from_End function
            break;

            // case 8 Delete node from specific position in list
            case 8 :
                printf("Enter the position to be deleted :");
                scanf("%d",&position);
                Delete_node_at_position(position); // call Delete_node_at_possition function
            break;

            // case 9 Delete node Before specific position in list
            case 9 :
                printf("Enter the position to be deleted :");
                scanf("%d",&position);
                Delete_node_Before_position(position); // call Delete_Before_possition function
            break;

            // case 10 Delete node After specific position in list
            case 10 :
                printf("Enter the position to be deleted :");
                scanf("%d",&position);
                Delete_node_After_position(position); // call Delete_node_After_possition function
            break;

            // case 11 Remove node with the given value from list
            case 11 :
                printf("Enter Value to be deleted :");
                scanf("%d",&element);
                Remove(element);   // call  Removee function
            break;

            // case 12 traverse linked list and Print all element(Iterative method)
            case 12 :
                 Traverse(); // call  Traverse function
            break;

            // case 13 traverse linked list and Print all element(Recursive method)
            case 13 :
                 if(last == NULL) /* linked is empty Case */
                     printf("Circular Linked List is Empty!!!\n");
                 else // pass head node(last -> next)
                     print_using_recursion(last -> next); // call  print_using_recursion function
            break;

            // case 14 traverse linked list and Print all element
            // in reverse order using recursion(Recursive method)
            case 14 :
                if(last == NULL) /* linked is empty Case */
                     printf("Circular Linked List is Empty!!!\n");
                else // pass head node(last -> next)
                {
                    Reverse_print_using_recursion(last -> next); // call  Reverse_print_using_recursion function
                    printf("\n");
                }
            break;

            // case 15 Reverse linked list(Iterative method)
            case 15 :
                Reverse(); // call Reverse function
            break;

            // case 16 length of the  linked list
            case 16 :
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
         // last node next alway have the address of head(first) so is a circular linked list
         printf("%d : is been inserted at the Beginning of list\n",value); // inform user the element is been inserted
         printf("%d : Confirm if the linked list is circular list  \n",last -> next -> data); // inform user everything is ok
    }

    /** Time complexity of insert_at_Begining() is  : O(1) */

} /** End of insert_at_Begining() */


/** A utility function to(Append)
    insert new node to the end of list */

void Append(int value)
{
    struct Node *newNode; // local variable of type struct node declaration */

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if (last == NULL) /* check if list is empty then this node is the first node */
    {
        // insert as the first node in list
        insert_At_Beginning(value);  // call Insert_At_Begining to added as first node
        return;
    }

    /*
    if already some element are in the linked list we have
    add the new node at the end after that make it Circular List */

    /** link changes */

    newNode -> next = last -> next; // make it Circular List last nod is now point to first node
    last -> next = newNode;        // link last -> next  to newNode
    last  = newNode;              // now last point the new nod
    // last node next alway have the address of head(first) so is a circular linked list

    printf("%d : is been inserted at end of list\n",value); // inform user the element is been inserted
    printf("%d : Confirm if the linked list is circular list  \n",last -> next -> data); // inform user everything is ok

    /** Time complexity of Append() is : O(1) */

} /** End of Append() */


/**
   A utility function to insert the given value at the given position
   (adding node in the middle)  */

void insert_At_Position(int value, int position)
{
    int i, len;                 // local variables declaration
    struct Node *newNode, *temp; // local variables of type struct node declaration */

    i = 1;            // initialize counter i to one
    len = length();   // call length() to get length of list

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if(position > len + 1 || position < 1) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }
    else if (position == 1) // case when the given position is one
    {
        // insert at first position
        insert_At_Beginning(value);  // call Insert_At_Begining () for help
        return; // we are done
    }
    else if(position == len + 1) // case when the given position is equal to len + 1
    {
        // insert at last position
        Append(value); // call Append() for help
        return; // we are done
    }
    // else cases

    // last -> next mean the first node
    temp = last -> next;    // temp is now point to first node

    /*
    if already some element are in the linked list and given position
    is not number one and not the last index  then we have to first loop
    throw the linked list until position - 1 then add the new element at given position */
    while(i < position - 1)
    {
        temp = temp -> next; // move temp to next node
        i++;                 // increment counter i by one
    }

    /** link changes */

    newNode -> next = temp -> next;  // right side connection first
    temp -> next = newNode;         // left side connection  second
    printf("%d : is been inserted at %d position \n",value, position); // inform user the element is been inserted


    /** Time complexity of insert_At_Position() is O(n) */

} /** END of insert_at_Possition() */


/**
   A utility function to insert the given value After the given position
   (adding node in the middle)  */

void insert_After_Position(int value, int position)
{
    int i, len;                  // local variable declaration
    struct Node *newNode, *temp; // local variables of type struct node declaration */

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    len = length();   // call length() to get length of list
    i = 1;            // initialize counter i to one

    if(last == NULL) /* linked is empty Case */
    {
        printf("linked list is Empty!!!\n");
        return; // we are done
    }
    else if(position > len || position < 1) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }
    else if(position == len) // case when the given position is equal to len
    {
        // insert at last position
        Append(value); // call Append() for help
        return; // we are done
    }

    // else cases
    // last -> next mean the first node
    temp = last -> next;    // temp is now point to first node

    /*
    if already some element are in the linked list we have to first
    loop throw the linked list until position then add the new node
    at just after given position */
    while(i < position)
    {
        temp = temp -> next;   // move temp to next node
        i++;                   // increment counter i by one
    }

    /** link changes*/

    newNode -> next = temp -> next; // right side connection first
    temp -> next = newNode;         // left side connection  second
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

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    len = length();   // call length() to get length of list
    i = 1;            // initialize counter i to one

    if(last == NULL) /* linked is empty Case */
    {
        printf("linked list is Empty!!!\n");
        return; // we are done
    }
    else if(position > len|| position < 2) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }
    if (position == 2) // case when the given position is two
    {
        // insert at first position
        insert_At_Beginning(value);  // call Insert_At_Begining () for help
        return; // we are done
    }

    // else cases
    // last -> next mean the first node
    temp = last -> next;    // temp is now point to first node

    /*
    if already some element are in the linked list we have to first
    loop throw the linked list until position - 2 then add the new
    node at just before given position */
    while(i < position - 2)
    {
        temp = temp -> next;   // move temp to next node
        i++;                   // increment counter i by one
    }

    /** link changes */

    newNode -> next = temp -> next; // right side connection first
    temp -> next = newNode;         // left side connection  second
    printf("%d : is been inserted at %d position \n",value, position - 1); // inform user the element is been inserted

    /** Time complexity of insert_Before_Possition() is O(n) */

} /** END of insert_Before_Possition() */


/** A utility function to Delete node from the Beginning of linked list */

void Delete_from_Beginning()
{
    struct Node *temp; // local variable of type struct node declaration */

    if(last== NULL) /* linked is empty Case */
    {
        printf("Circular Linked List is Empty!!!\n");
        return; // we are done
    }
    // last -> next mean the first node
    temp = last -> next; // temp is now point to first node

    // if having only one node in linked list delete that node and assign last to NULL
    if(last -> next == last)
    {
        /** link changes */

        printf("node --> %d is Will be Deleted\n",temp -> data); // inform user the job is about to done
        last = NULL; // assign last back to NULL
        temp -> next = NULL; // connect temp -> next to NULL
        free(temp); // now Delete temp using free() C function
        // also it can be if(temp -> next == temp)
    }
    else
    {
        /** link changes */

        printf("node --> %d is Will be Deleted\n",temp -> data); // inform user the job is about to done
        last -> next = temp -> next; // right side connection first
        temp -> next = NULL; // connect temp -> next to NULL
        free(temp); // now Delete temp using free() C function
     }

    /** Time complexity of Delete_from_Beginning() is : O(1) */

} /** End of Delete_from_Beginning() */

/** A utility function to Delete node from the end of linked list */

void Delete_from_End()
{
    struct Node *current, *prves; // local variables of type struct node declaration */

    if(last== NULL) /* linked is empty Case */
    {
        printf("Circular Linked List is Empty!!!\n");
        return; // we are done
    }
    // last -> next mean the first node
    current = last -> next; // current now have address of first node

    /* Case when we have only one node in the list
    if so delete that node and assign last to NULL
    also can be  if(current -> next == current)*/
    if(last -> next == last)
    {
        /** link changes */

        printf("node --> %d is Will be Deleted\n",current -> data); // inform user the job is about to done
        last = NULL;          // assign last back to NULL
        current -> next = NULL; // connect curent -> next to NULL
        free(current);          // now Delete curent using free() C function
        // also it can be if(curent -> next == curent)
        return; // we are done
    }
    // else cases

    /*
    by now we are sure list is not empty
    so while we not yet reach last just go head and loop
    also can be current != last*/
    while(current -> next != last -> next)
    {
        // curent is only to uses in free memory process
        prves = current;          // save curent in prves
        current = current -> next;    // move curent to next node

       /* at end of loop current will be the last node and prevs
         will be the node just before the last */
    }

    /** link changes */

    printf("node --> %d is Will be Deleted\n",current -> data);
    prves -> next = last -> next ;  // right side connection first
    last = prves;             // move last one step back
    current -> next = NULL;    // connect curent -> next to NULL
    free(current);           // now Delete curent using free() C function

    /** Time complexity of Delete_from_End() is : O(N) */

} /** End of Delete_from_End() */

/**
   A utility function to Delete node from a specific
   given position in linked list.(delete node in the middle
    or last or even in first of the linked list */

void Delete_node_at_position(int position)
{
    int i, len;                // local variable declaration
    struct Node *temp, *prves; /* local variables of type struct node declaration */
    len = length();            // call length() to get length of list
    i = 1;                     // initialize counter i to one

    if(last == NULL) /* linked is empty Case */
    {
        printf("Circular Linked List is Empty!!!\n");
        return; // we are done
    }
    else if(position > len || position < 1) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }
    /*
    if given position is equal to one this mean at deleting node
    at first position so we call Delete_from_Beginning() function
    for help which always delete beginning node  */
    else if(position == 1)
    {
        Delete_from_Beginning(); // call Delete_from_Beginning() function for help
        return; // we are done
    }
    /*
    if given position is equal to length this mean at deleting
    node at last position so we call Delete_from_End() function
    for help which always delete at end node  */
    else if(position == len)
    {
        Delete_from_End(); // call  Delete_from_End() function for help
        return; // we are done
    }
    // last -> next mean the first node
    temp = last -> next; // temp is now point to first node

    /*
    else cases
    by now we are sure node to be deleted is not at the
    beginning and not at end of list its somewhere in the
    middle so let loop first to find then is easy to delete */
    while(i < position)
    {
        // temp is only to uses in free memory process
        prves = temp;          // save temp in prves
        temp = temp -> next;   // move temp to next node
        i++;                   // increment counter i by one
    }

    /** link changes */

    printf("node --> %d is Will be Deleted\n",temp -> data);
    prves -> next = temp -> next;   // right side connection first
    temp -> next = NULL;            // connect temp -> next to NULL
    free(temp);                     // now Delete temp using free() C function

    /** Time complexity of Delete_node_at_possition() is : O(N) */

} /** End of Delete_node_at_possition() */


/**
   A utility function to Delete node which just Before a specific
   given position in linked list.(delete node in the middle
    or last or even in first of the linked list */

void Delete_node_Before_position(int position)
{
    int i, len;                // local variable declaration
    struct Node *temp, *prves; /* local variables of type struct node declaration */
    len = length();            // call length() to get length of list
    i = 1;                     // initialize counter i to one

    if(last == NULL) /* linked is empty Case */
    {
        printf("Circular Linked List is Empty!!!\n");
        return; // we are done
    }
    else if(position > len + 1 || position < 2) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }
    /*
    if given position is equal to two this mean at deleting node
    at first position so we call Delete_from_Beginning() function
    for help which always delete beginning node  */
    else if(position == 2)
    {
        Delete_from_Beginning(); // call Delete_from_Beginning() function for help
        return; // we are done
    }
    /*
    if given position is equal to length + 1 this mean at deleting
    node at last position so we call Delete_from_End() function
    for help which always delete at end node  */
    else if(position == len + 1)
    {
        Delete_from_End(); // call  Delete_from_End() function for help
        return; // we are done
    }
    // last -> next mean the first node
    temp = last -> next;     // temp is now point to first node

    /*
    else cases
    by now we are sure node to be deleted is not at the
    beginning and not at end of list its somewhere in the
    middle so let loop first to find then is easy to delete */
    while(i < position - 1)
    {
        // temp is only to uses in free memory process
        prves = temp;          // save temp in prves
        temp = temp -> next;   // move temp to next node
        i++;
    }

    /** link changes */

    printf("node --> %d is Will be Deleted\n",temp -> data);
    prves -> next = temp -> next;   // right side connection first
    temp -> next = NULL;            // connect temp -> next to NULL
    free(temp);                     // now Delete temp using free() C function

    /** Time complexity of Delete_Before_possition() is : O(N) */

} /** End of Delete_node_Before_possition() */


/**
   A utility function to Delete node which just After a specific
    position in linked list.(delete node in the middle
    or last or even in first of the linked list */

void Delete_node_After_position(int position)
{
    int i, len;                // local variable declaration
    struct Node *temp, *prves; /* local variables of type struct node declaration */
    len = length();            // call length() to get length of list
    i = 1;                     // initialize counter i to one

    if(last == NULL) /* linked is empty Case */
    {
        printf("Circular Linked List is Empty!!!\n");
        return; // we are done
    }
    else if(position + 1 > len  || position < 0) // invalid position case // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }
    /*
    if given position is equal to zero this mean at deleting node
    at first position so we call Delete_from_Beginning() function
    for help which always delete beginning node  */
    else if(position == 0)
    {
        Delete_from_Beginning(); // call Delete_from_Beginning() function for help
        return; // we are done
    }
    /*
    if given position is equal to length - 1 this mean at deleting
    node at last position so we call Delete_from_End() function
    for help which always delete at end node  */
    else if(position == len - 1)
    {
        Delete_from_End(); // call  Delete_from_End() function for help
        return; // we are done
    }

    // last -> next mean the first node
    temp = last -> next;     // temp is now point to first node

    /*
    else cases
    by now we are sure node to be deleted is not at the
    beginning and not at end of list its somewhere in the
    middle so let loop first to find then is easy to delete */
    while(i < position + 1)
    {
        // temp is only to uses in free memory process
        prves = temp;          // save temp in prves
        temp = temp -> next;   // move temp to next node
        i++;
    }

    /** link changes */

    printf("node --> %d is Will be Deleted\n",temp -> data);
    prves -> next = temp -> next;   // right side connection first
    temp -> next = NULL;            // connect temp -> next to NULL
    free(temp);                     // now Delete temp using free() C function

    /** Time complexity of Delete_node_After_position() is : O(N) */

} /** End of Delete_node_Before_possition() */


/**
 A utility function to remove node with the given value from list */

void Remove(int value)
{
    struct Node *temp, *prves; /* local variables of type struct node declaration */

    if(last == NULL) /* linked is empty Case */
    {
        printf("Circular Linked List is Empty!!!\n");
        return; // we are done
    }
    // last -> next mean the first node
    temp = last -> next;  // temp and prves are now pointing to head node

    if(temp -> data == value)  // case when the given value its at first position */
    {
        Delete_from_Beginning();   // call Delete_from_Beginning function
        return; // we are done
    }

    /*
    by now we are sure node to be deleted is not at the
    beginning  maybe its somewhere so let search it*/
    while(temp != last && temp -> data != value )  // loop until find the value
    {
        // temp is only to uses in free memory process
        prves = temp;          // save temp in prves
        temp = temp -> next;   // move temp to next node
    }

    if(temp == last && temp -> data == value) // case when the given node is the last node
    {
        Delete_from_End(); // call Delete_from_End() function for help
        return; // we are done
    }
    else if(temp == last && temp -> data != value) // case when the given node is not found in the last node
    {
        printf("node --> %d not found\n", value);
        return; // we are done
    }
    else // case when the given node is in middle
    {
        /** link changes */

        printf("node --> %d is Will be Deleted\n",temp -> data);
        prves -> next = temp -> next;  // right side connection first
        temp -> next = NULL;           // connect temp -> next to NULL
        free(temp);                    // now Delete temp using free() C function
    }

    /** Time complexity of Removee is : O(N) */

} /** End of Removee() */

/** A utility function to Reverse a linked list (Iterative method)
    Reference in Future
   1. https://youtu.be/xvAoleV706Q
   2. https://youtu.be/sYcOK51hl-A
   3. https://youtu.be/Tk_fi5l8cag
   4. https://youtu.be/wfdpJELzln4 */

void Reverse()
{
    // local variables of type struct node declaration */
    struct  Node * current, *Previous, *nextNode;

    if(last== NULL) /* linked is empty Case */
    {
        printf("Circular Linked List is Empty!!!\n");
        return; // we are done
    }
    /* Case when we have only one node in the list
    if so delete that node and assign last to NULL
    also can be  if(current -> next == current)*/
    else if(last -> next == last)
    {
        printf("Circular Linked List have only one Node!!!\n");
        return; // we are done
    }

    /* else cases */

    Previous = NULL;          // for Previous node
    // last -> next mean the first node
    current = last -> next;       // current now have address of first node(for current node)
    nextNode = current -> next;  // for next node

    while(current != last)
    {
        /** link changes */

        Previous = current;         // move Previous point to current node
        current = nextNode;         // now move current point to next node
        nextNode = current -> next; // move nextNode point to next node

        /** Reverse*/

        current -> next = Previous;  // Reverse current node
        // after that go back and loop again
    }

    /*
     after while loop now
    at this point nextNode -> next is point to first node last -> next */

    nextNode -> next = last; // Reverse first node

    last = nextNode;  // Reverse last(tail pointer) to point to first node

    printf("Circular Linked List is been Reversed\n"); // inform user the work is done

   /** Time complexity of Reverse() is O(n) */

} /** End of Reverse */


/** A utility function to find the length of linked list */

int length()
{
    int count = 0;     // local counter variable declaration and initializations to zero
    struct Node* temp; // local variable of type struct node declaration */

    if(last== NULL) /* linked is empty Case */
    {
       // printf("Circular Linked List is Empty!!!\n");
        return 0;
    }

    // last -> next mean the first node
    temp = last -> next;     // temp is now point to first node

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


/**
    Utility function to traverse the linked list and print
    all the element recursion(Recursive method)
    Reference in Future
   1. https://youtu.be/K7J3nCeRC80  */

void print_using_recursion(struct Node* temp)
{
    if(temp == last) //Exit condition
    {
        // by now we are at last node but the value of last itself not yet been printed
        printf("%d --> ", temp -> data); // print the last element
        printf("\n");
        return; // we are done
    }
    // else cases
    printf("%d -->", temp -> data);      // first print the in the node which is first node
    print_using_recursion(temp -> next); // Recursive call to move to next node

} /** End of print_using_recursion */


/**
    Utility function to traverse the linked list and print all the
    element in reverse order using recursion(Recursive method)
    Reference in Future
   1. https://youtu.be/K7J3nCeRC80  */

void Reverse_print_using_recursion(struct Node* temp)
{
    if(temp == last) //Exit condition
    {
        // by now we are at last node
        printf("%d --> ", temp -> data); // print the last element value first
        return; // we are done
    }

    // else cases
    Reverse_print_using_recursion(temp -> next); // Recursive call to move to next node first

    printf("%d -->", temp -> data);  // after reach to last node and temp == last
                                     // will start printing from last to first in reverse order

} /** End of Reverse_print_using_recursion */
