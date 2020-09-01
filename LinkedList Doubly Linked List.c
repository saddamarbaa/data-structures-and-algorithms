/**
    [PROGRAM] : Doubly linkedlist Data Structure Complete Implementation

    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program for Complete implementation of Doubly linked list data structure.

    A linked list is a linear data structure, in which the elements
    are not stored at contiguous memory locations.
    The elements in a linked list are linked using pointers
    (entity that point to the next element)

    Doubly Linked list is a type of Linked List Data structure
    in which a node contain of three parts(filed)
    (1) node data,
    (2) pointer to the next node (next pointer)
    (3) pointer to the previous node(previous pointer).

     Reference in future :---->
     1. https://youtu.be/JdQeNxWCguQ
     2. https://youtu.be/VOQNf1VxU3Q
     3. https://youtu.be/nquQ_fYGGA4
     4. https://youtu.be/H8-IuKKiQeo
     5. https://youtu.be/v4szCPs9yEY
     6. https://youtu.be/7yNUXcOcHwE
     7. https://youtu.be/_6JI9XdO8nM
     8. https://youtu.be/wfdpJELzln4
     9. https://youtu.be/ILIjoAsF-zI*/

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
                print_using_recursion(Head); // call  print_using_recursion function
            break;

            // case 14 traverse linked list and Print all element
            // in reverse order using recursion(Recursive method)
            case 14 :
                Reverse_print_using_recursion(Head); // call  Reverse_print_using_recursion function
                printf("\n");
            break;

            // case 15 traverse linked list and Print all element
            // in reverse order using loop(Iterative method)
            case 15 :
                Reverse_print_using_loop(); // call  Reverse_print_using_loop function
                printf("\n");
            break;

            // case 16 Reverse linked list(Iterative method)
            case 16 :
                Reverse(); // call Reverse function
            break;

            // case 17 Reverse linked list(Iterative method)
            case 17 :
                Reverse_using_recursion(Head); // callReverse_using_recursion function
            break;

            // case 18 length of the  linked list
            case 18 :
                len = length();  // call length function
                if(len == 0)
                   printf("Doubly linked list is Empty!!!\n");
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

    /**
    Time complexity of Append() is : O(N)
    but if we have maintain one more variable tail pointer
    to point to last nod while creating linked list then time
    complexity of insert node at end will be O(1) */

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
        printf("Doubly linked list is Empty!!!\n");
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
        printf("Doubly linked list is Empty!!!\n");
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


/** A utility function to Delete node from the Beginning of linked list */

void Delete_from_Beginning()
{
    struct Node* temp;  // local variable of type struct node declaration */
    temp = Head;       // temp is now point to head node

    if(Head == NULL) /* linked is empty Case */
    {
        printf("Doubly linked list is Empty!!!\n");
        return; // we are done
    }
    // if having only one node in linked list delete that node and assign head to NULL
    else if(temp -> next == NULL && temp -> prev == NULL)
    {
        printf("node --> %d is Will be Deleted\n",temp -> data); // inform user the job is about to done
        Head = NULL; // assign head to NULL
        free(temp);  // now Delete temp using free() C function
    }
    else  // by now we are sure list have more than one node
    {
        /** link changes */

        printf("node --> %d is Will be Deleted\n",temp -> data); // inform user the job is about to done
        Head = Head -> next;  // right side connection first
        Head -> prev = NULL;  // left side connection second
        temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
        free(temp);          // now Delete temp using free() C function
    }

    /** Time complexity of Delete_from_Beginning() is : O(1) */

} /** End of Delete_from_Beginning() */


/** A utility function to Delete node from the end of linked list */

void Delete_from_End()
{
    struct Node *temp; // local variables of type struct node declaration */
    temp  = Head;      // temp is now point to head node

    if (Head == NULL) /*linked is empty Case*/
    {
        printf("Doubly linked list is Empty!!!\n");
        return; // we are done
    }
    // if having only one node in linked list delete that node
    // and assign head to NULL is mean delete from beginning
    else if(temp -> next == NULL && temp -> prev == NULL)
        Delete_from_Beginning(); // call Delete_from_Beginning() for help
    else
    {
         /*
         by now we are sure list is not empty and have more than one node
         let loop ( while we not yet reach NULL just go head and loop )*/
        while(temp -> next != NULL)
        {
            // temp is only to uses in free memory process
            temp = temp -> next;    // move temp to next node
        }

        /** link changes */

        printf("node --> %d is Will be Deleted\n",temp -> data);
        temp -> prev -> next =  NULL;  // right side connection first
        temp -> prev = NULL;  // assign temp -> prev to NULL(this not have to)
        free(temp);           // now Delete temp using free() C function
    }

    /**
    Time complexity of Delete_from_End() is : O(N)
    but if we have maintain one more variable tail pointer
    to point to last nod while creating linked list then time
    complexity of deleting node at end will be O(1) */

} /** End of Delete_from_End() */


/**
   A utility function to Delete node from a specific
   given position in linked list.(delete node in the middle
    or last or even in first of the linked list */

void Delete_node_at_position(int position)
{
    int i, len;          // local variable declaration
    struct Node *temp;   // local variables of type struct node declaration */
    temp  = Head;      // temp is now point to head node
    len = length();    // call length() to get length of list
    i = 1;            // initialize counter i to one

    if (Head == NULL)  /* linked is empty Case*/
    {
        printf("Doubly linked list is Empty!!!\n");
        return; // we are done
    }
    else if(position > len || position < 1) // invalid position case
    {
        printf("invalid position!!!\n");
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

    /*
    by now we are sure node to be deleted is not at the
    beginning and not at end of list its somewhere in the
    middle so let loop first to find then is easy to delete */
    while(i < position)
    {
        // temp is only to uses in free memory process
        temp = temp -> next;   // move temp to next node
        i++;                   // increment counter i by one
    }

    /** link changes */

    printf("node --> %d is Will be Deleted\n",temp -> data);
    temp -> prev -> next = temp -> next;  // right side connection first
    temp -> next -> prev = temp -> prev;  // left side connection first
    temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
    temp -> prev = NULL;  // assign temp -> prev to NULL(this not have to)
    free(temp);          // now Delete temp using free() C function

    /** Time complexity of Delete_node_at_possition() is : O(N) */

} /** End of Delete_node_at_possition() */


/**
   A utility function to Delete node which just Before a specific
   given position in linked list.(delete node in the middle
    or last or even in first of the linked list */

void Delete_node_Before_position(int position)
{
    int i, len;          // local variable declaration
    struct Node *temp;  //  local variables of type struct node declaration */
    temp  = Head;       //  temp is now point to head node
    len = length();     //  call length() to get length of list
    i = 1;               // initialize counter i to one

    if (Head == NULL)  /* linked is empty Case*/
    {
        printf("Doubly linked list is Empty!!!\n");
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
    if(position == 2)
    {
        Delete_from_Beginning(); // call Delete_from_Beginning() function for help
        return; // we are done
    }
    /*
    if given position is equal to length + 1 this mean at deleting
    node at last position so we call Delete_from_End() function
    for help which always delete at end node  */
    else if(position  == len + 1)
    {
        Delete_from_End(); // call  Delete_from_End() function for help
        return; // we are done
    }

    /*
    by now we are sure node to be deleted is not at the
    beginning and not at end of list its somewhere in the
    middle so let loop first to find then is easy to delete */
    while(i < position - 1)
    {
        // temp is only to uses in free memory process
        temp = temp -> next;   // move temp to next node
        i++;                   // increment counter i by one
    }

    /** link changes */

    printf("node --> %d is Will be Deleted\n",temp -> data);
    temp -> prev -> next = temp -> next;  // right side connection first
    temp -> next -> prev = temp -> prev;  // left side connection first
    temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
    temp -> prev = NULL;  // assign temp -> prev to NULL(this not have to)
    free(temp);          // now Delete temp using free() C function

    /** Time complexity of Delete_Before_possition() is : O(N) */

} /** End of Delete_node_Before_possition() */


/**
   A utility function to Delete node which just After a specific
   given position in linked list.(delete node in the middle
    or last or even in first of the linked list */

void Delete_node_After_position(int position)
{
    int i, len;          // local variable declaration
    struct Node *temp;  //  local variables of type struct node declaration */
    temp  = Head;       //  temp is now point to head node
    len = length();     //  call length() to get length of list
    i = 1;               // initialize counter i to one

    if (Head == NULL)  /* linked is empty Case*/
    {
        printf("Doubly linked list is Empty!!!\n");
        return; // we are done
    }
    else if(position  > len - 1 || position < 0) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }
    /*
    if given position is equal to zero this mean at deleting node
    at first position so we call Delete_from_Beginning() function
    for help which always delete beginning node  */
    if(position == 0)
    {
        Delete_from_Beginning(); // call Delete_from_Beginning() function for help
        return; // we are done
    }
    /*
    if given position is equal to length - 1 this mean at deleting
    node at last position so we call Delete_from_End() function
    for help which always delete at end node  */
    else if(position  == len - 1)
    {
        Delete_from_End(); // call  Delete_from_End() function for help
        return; // we are done
    }

    /*
    by now we are sure node to be deleted is not at the
    beginning and not at end of list its somewhere in the
    middle so let loop first to find then is easy to delete */
    while(i < position + 1)
    {
        // temp is only to uses in free memory process
        temp = temp -> next;   // move temp to next node
        i++;                   // increment counter i by one
    }

    /** link changes */

    printf("node --> %d is Will be Deleted\n",temp -> data);
    temp -> prev -> next = temp -> next;  // right side connection first
    temp -> next -> prev = temp -> prev;  // left side connection first
    temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
    temp -> prev = NULL;  // assign temp -> prev to NULL(this not have to)
    free(temp);          // now Delete temp using free() C function

    /** Time complexity of Delete_node_After_position() is : O(N) */

} /** End of Delete_node_After_position() */


/**
 A utility function to remove node with the given value from list */

void Remove(int value)
{
    struct Node *temp;  // local variable of type struct node declaration */
    temp =  Head;       //temp is now pointing to head node

    if (Head == NULL)  /* linked is empty Case*/
    {
        printf("Doubly linked list is Empty!!!\n");
        return; // we are done
    }
    else if(temp -> data == value)  // case when the given value its at first position */
    {
        Delete_from_Beginning();   // call Delete_from_Beginning function
        return; // we are done
    }

    /*
    by now we are sure node to be deleted is not at the
    beginning  maybe its somewhere so let search it*/
    while(temp != NULL && temp -> data != value )  // loop until find the value
    {
        // temp is only to uses in free memory process
        temp = temp -> next;   // move temp to next node
    }

    // after search if temp is NULL mean node is not found
    if(temp == NULL)
       printf("node --> %d not found\n", value);

    // case when the given value is last node */
    else if(temp -> next == NULL && temp -> data == value)
          Delete_from_End(); // call Delete_from_End() function
    else
    {
        /** link changes */

        printf("node --> %d is Will be Deleted\n",temp -> data);
        temp -> prev -> next = temp -> next;  // right side connection first
        temp -> next -> prev = temp -> prev;  // left side connection first
        temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
        temp -> prev = NULL;  // assign temp -> prev to NULL(this not have to)
        free(temp);          // now Delete temp using free() C function
    }

    /** Time complexity of Removee is : O(N) */

} /** End of Removee() */


/** A utility function to Reverse a linked list (Iterative method)
    Reference in Future
   1. https://youtu.be/_6JI9XdO8nM
   2. https://youtu.be/sYcOK51hl-A
   3. https://youtu.be/Tk_fi5l8cag
   4. https://youtu.be/wfdpJELzln4 */

void Reverse()
{
    // local variables of type struct node declaration */
    struct  Node *current, *Previous, *nextNode;

    Previous = NULL;  // for Previous node(only to keep address of last node)
    current = Head;   // for current node
    nextNode = NULL;  // for next node

    if(Head == NULL) /* linked is empty Case */
    {
        printf("Doubly linked list is Empty!!!\n");
        return; // we are done
    }
    while(current != NULL)
    {
        /** link changes */
        nextNode = current -> next;    // move nextNode point to next node
        current -> next = current -> prev; //swap between current -> next and current -> prev
        current -> prev = nextNode;        ////swap between current -> next and current -> prev
        Previous = current;      // I use Previous only to get address of last node and assgin to head pointer
        current = nextNode;   // move current to next until you reach null which is end of list

        // after that go back and loop again
    }
    // after while loop now let head) point to last node

    Head = Previous;  // Reverse (head pointer) to point to last node

    printf("Doubly linked list is been Reversed\n"); // inform user the work is done

   /** Time complexity of Reverse() is O(n) */

} /** End of Reverse */


/** A utility function to Reverse a linked list using Recursion
   (Recursive method)
    Reference in Future
   1. https://youtu.be/KYH83T4q6Vs */

void Reverse_using_recursion(struct Node* curentNode)
{
    if (Head == NULL)  /* linked is empty Case*/
    {
        printf("Doubly linked list is Empty!!!\n");
        return; // we are done
    }

    struct  Node *nextNode;         /* local variables of type struct node declaration */
    nextNode = curentNode -> next; // nextNode is now pointing to nextNode

    /** link changes */

    curentNode -> next = curentNode -> prev; //swap between current -> next and current -> prev
    curentNode -> prev = nextNode;          //swap between current -> next and current -> prev
    // this node is been Reverse now move to next node

    if (curentNode -> prev == NULL) // first Exit condition(case when list have only node)
    {
        printf("Doubly linked list is have only one Node\n");
        return;
    }
    else if(nextNode -> next == NULL)// second Exit condition(last node)
    {
        /**
        now we are in last node and  all the other node are been Reverse
        so let Reverse this one also after move head to point to this last node */

        /* link changes */
        nextNode -> next = nextNode -> prev; // swap between lastNode -> next and lastNode -> prev
        nextNode ->prev = NULL;              // swap between lastNode -> next and lastNode -> prev
        Head = nextNode;                     // Reverse (head pointer) to point to last node
        printf("Doubly linked list is been Reversed\n"); // inform user the work is done
        return;  // we are done
    }

    // else cases
    Reverse_using_recursion(curentNode -> prev); //Recursive call to move to next node  first


} /** End of Reverse_using_recursion */


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


/** Utility function to traverse the linked list
    and print all the element(Iterative method)*/

void Traverse()
{
    struct Node* temp; // local variable of type struct node declaration */
    temp = Head;      // temp is now point to head node

    if(Head == NULL) /* linked is empty Case */
    {
        printf("Doubly linked list is Empty!!!\n");
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


/**
    Utility function to traverse the linked list and print all the
    element in reverse order using loop((Iterative method)) */

void Reverse_print_using_loop()
{
    struct Node* temp; // local variable of type struct node declaration */
    temp = Head;      // temp is now point to head node

    if(Head == NULL) /* linked is empty Case */
    {
        printf("Doubly linked list is Empty!!!\n");
        return; // we are done
    }
    /*
    by now we are sure list is not empty
    so while we not yet reach NULL move temp to temp -> next */
    while(temp -> next != NULL)
         temp = temp -> next;   // move temp to next node

    /*
    by now we are at last node , the idea is to go back until reach
    head pointer so while we not yet reach head pointer
    first print the node and move temp to temp -> prev */
     while(temp != NULL)
     {
         printf("%d --> ", temp -> data);  // print the value
         temp = temp -> prev;              // move temp to prev node
     }
     printf("\n");

} /**End of Reverse_print_using_loop */
