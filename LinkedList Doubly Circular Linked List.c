/**
    [PROGRAM] :  Doubly Circular linked list Data Structure
                 Complete Implementation

    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program for Complete implementation of Doubly Circular linked list data structure.

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
struct Node* First = NULL;

/*  global variable pointer to tail(last) node  */
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

/* function to find the length of linked list*/
int length(void);

// function to traverse linked list and Print
// all element (Iterative method) */
void Traverse(void);

int main(int argc, char* argv[])    /* the river Code */
{
    int option, len, position, element;  /* variable declarations */

    do
    {
        printf("Doubly Circular linked list Implementation(All Operations)      :\n");
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

            break;

            // case 11 Remove node with the given value from list
            case 11 :

            break;

            // case 12 traverse linked list and Print all element(Iterative method)
            case 12 :
                 Traverse(); // call  Traverse function
            break;

            // case 13 traverse linked list and Print all element(Recursive method)
            case 13 :

            break;

            // case 14 traverse linked list and Print all element
            // in reverse order using recursion(Recursive method)
            case 14 :

            break;

            // case 15 traverse linked list and Print all element
            // in reverse order using loop(Iterative method)
            case 15 :

            break;

            // case 16 Reverse linked list(Iterative method)
            case 16 :

            break;

            // case 17 Reverse linked list(Iterative method)
            case 17 :

            break;

            // case 18 length of the  linked list
            case 18 :
                len = length();  // call length function
                if(len == 0)
                   printf("Doubly circular linked list is Empty!!!\n");
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
      printf("Error in allocating memory\n");

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
    // local variable of type struct node declaration */
    struct Node *newNode;

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if(First == NULL) /* check if list is empty then this node is the first node */
    {
        First =  last = newNode;  // insert first node in list
        First -> next = newNode;  // this condition can be written in different way since note it is  pointing to it self
        First -> prev = newNode;  // this condition can be written in different way since note it is  pointing to it self

        printf("%d : is been inserted as first node in list\n",value); // inform user the element is been inserted
    }
    else
    {
        /*
        if already some element are in the linked list we
        have to add the new node at the end of the list
        for that we have to update 5 nodes
        last -> next
        newNode -> prev
        newNode -> next
        First -> prev
        last */

        /** link changes */

        last -> next = newNode;   // right side connection first
        newNode -> prev = last;   // left side connection second
        newNode -> next = First;  // connect last node to first node
        First -> prev = newNode;  // connect first node to last node
        last = newNode;          // move last one step ahead to point to the node newNode

        printf("%d : is been inserted at end of list\n",value); // inform user the element is been inserted
    }

    /*
    before closing function to make sure that we create everything
    let right print (last -> next -> data)always should contain first element
    in list and (First -> prev -> data) always should  print last element in list*/
    printf("Confirm First Node Now : %d \n", last -> next -> data);
    printf("Confirm Last Node Now  : %d \n", First -> prev -> data);

    /** Time complexity of Append()() is : O(1) */

} /** End of Append() */


/** A utility function to insert new node to the Beginning of list */

void insert_At_Beginning(int value)
{
    // local variable of type struct node declaration */
    struct Node *newNode;

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if(First == NULL) /* check if list is empty then this node is the first node */
    {
        First =  last = newNode;  // insert first node in list
        First -> next = newNode;  // this condition can be written in different way since note it is  pointing to it self
        First -> prev = newNode;  // this condition can be written in different way since note it is  pointing to it self

        printf("%d : is been inserted as first node in list\n",value); // inform user the element is been inserted

      /*
       * the above 2 line can be written in difference way since node is point to it self
       * newNode ->  prev = newNode;
       * newNode ->  next = newNode;
       * First  ->   prev =  First;
       * First  ->   next =  First;
       * last  ->   prev  = last;
       * last ->    next = last;
       * and so on
       */
    }
    else
    {
        /*
        if already some element are in the linked list we
        have to add the new node at the Beginning of the list
        for that we have to update 5 nodes
        last -> next
        newNode -> prev
        newNode -> next
        First -> prev
        last */

        /** link changes */

        last -> next = newNode;  // connect last node to first node
        newNode -> prev = last;  //  connect first node to last node
        newNode -> next = First;  // left  side connection
        First -> prev = newNode;  // right side connection
        First = newNode;         // move first one step back to point to the node newNode

        printf("%d : is been inserted at the Beginning of list\n",value); // inform user the element is been inserted
    }

    /*
    before closing function to make sure that we create everything
    let right print (last -> next -> data)always should contain first element
    in list and (First -> prev -> data) always should  print last element in list*/
    printf("Confirm First Node Now : %d \n", last -> next -> data);
    printf("Confirm Last Node Now  : %d \n", First -> prev -> data);

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
    temp = First;     // temp is now point to head node
    len = length();   // call length() to get length of list

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if(First == NULL && position != 1) /* linked is empty Case */
    {
        printf("Doubly circular linked list is Empty!!!\n");
        return; // we are done
    }
    else if(position > len + 1 || position < 1) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }
    /* case when given position == 1 */
    if( position == 1)
    {
        insert_At_Beginning(value);  // call Insert_At_Begining for help
        return; // we are done
    }
    else if(position == len + 1) // case when the given position is equal to len + 1
    {
        // insert at last position
        Append(value); // call Append() for help
        return; // we are done
    }

    /* else cases
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
    temp = First;     // temp is now point to head node
    len = length();   // call length() to get length of list
    i = 1;            // initialize counter i to one

    if(First == NULL) /* linked is empty Case */
    {
        printf("Doubly circular linked list is Empty!!!\n");
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
        return; // we are done
    }
    /* else cases
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
    temp = First;     // temp is now point to head node
    len = length();   // call length() to get length of list
    i = 1;            // initialize counter i to one

    /* handling corner cases */

    if(First == NULL) /* linked is empty Case */
    {
        printf("Doubly circular linked list is Empty!!!\n");
        return; // we are done
    }
    else if(position == 2)  /* case if list is not empty and position == 2 */
    {
        // insert at beginning in list in first position
        insert_At_Beginning(value);  // call Insert_At_Begining
        return; // we are done
    }
    else if(position > len || position < 2) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }

    /* else cases
    if already some element are in the linked list and given position
    is not two we have to first loop throw the linked list until position - 2
    then add the new node at just before given position */
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
    temp = First;       // temp is now point to head node

    if(First == NULL) /* linked is empty Case */
    {
        printf("Doubly circular linked list is Empty!!!\n");
        return; // we are done
    }
    // if having only one node in linked list delete that node and assign head and last to NULL
    else if(First -> next == First)
    {
        printf("node --> %d is Will be Deleted\n",temp -> data); // inform user the job is about to done
        First = last = NULL; // assign head and last to NULL
        temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
        temp -> prev = NULL;  // assign temp -> prev to NULL(this not have to)
        free(temp);  // now Delete temp using free() C function
        return; // we are done
    }
     /*
     * by now we are sure that list have more than one node in this case we
     * delete first node and move first variable point to second one
     * so the second node will be the first after we delete the first one
     * for that we need to update 3 nodes and can be written in many ways also
     * First = First -> next
     * First -> prev = last
     * last -> next = First
     */
    else
    {
        /** link changes */

        printf("node --> %d is Will be Deleted\n",temp -> data); // inform user the job is about to done
        First = First -> next; // move first one step Ahead
        First -> prev = last;  // connect  first node to last node
        last -> next = First;  // connect  last node to first node
        temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
        temp -> prev = NULL;  // assign temp -> prev to NULL(this not have to)
        free(temp);          // now Delete temp using free() C function
    }

    /** Time complexity of Delete_from_Beginning() is : O(1) */

} /** End of Delete_from_Beginning() */


/** A utility function to Delete node from the end of linked list */

void Delete_from_End()
{
    struct Node* temp;  // local variable of type struct node declaration */
    temp = last;       // temp is now point to last node
    if(last == NULL) /* linked is empty Case */
    {
        printf("Doubly circular linked list is Empty!!!\n");
        return; // we are done
    }
    // if having only one node in linked list delete that node and assign head and last to NULL
    else if(last -> next == last) // this condition can written in many different ways
    {
        printf("node --> %d is Will be Deleted\n",temp -> data); // inform user the job is about to done
        First = last = NULL; // assign head and last to NULL
        temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
        temp -> prev = NULL;  // assign temp -> prev to NULL(this not have to)
        free(temp);  // now Delete temp using free() C function
        return; // we are done
    }
     /*
     * by now we are sure that list have more than one node in this
     * case we will delete last node and move last variable one step
     * back to point last -1  so the last -1 node will be the last after
     * we delete the last one
     * for that we need to update 3 nodes and this can be written in many ways also
     * last = last -> prev
     * last -> next = First
     * First -> prev = last
     */
    else
    {
        /** link changes */

        printf("node --> %d is Will be Deleted\n",temp -> data); // inform user the job is about to done
        last = last -> prev;   // move last one step back
        last -> next = First;  // connect last node to first node
        First -> prev = last;  // connect  first node to last node
        temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
        temp -> prev = NULL;  // assign temp -> prev to NULL(this not have to)
        free(temp);          // now Delete temp using free() C function
    }

    /** Time complexity of Delete_from_End() is : O(1) */

} /** End of Delete_from_End() */


/**
   A utility function to Delete node from a specific
   position in linked list.(delete node in the middle
   or last or even in first of the linked list */

void Delete_node_at_position(int position)
{
    int i, len;          // local variable declaration
    struct Node *temp;   // local variables of type struct node declaration */
    temp = First;       // temp is now point to head node
    len = length();     // call length() to get length of list
    i = 1;             // initialize counter i to one

    if (First == NULL)  /* linked is empty Case*/
    {
        printf("Doubly circular linked list is Empty!!!\n");
        return; // we are done
    }
    else if(position > len || position < 1) // invalid position case
    {
        printf("invalid position!!!\n");
        return; // we are done
    }
    /*
    if given position is equal to one this mean deleting node
    at first position so we call Delete_from_Beginning() function
    for help which always delete beginning node  */
    else if(position == 1)
    {
        Delete_from_Beginning(); // call Delete_from_Beginning() function for help
        return; // we are done
    }
    /*
    if given position is equal to length this mean deleting
    node at last position so we call Delete_from_End() function
    for help which always delete at end node  */
    else if(position == len)
    {
        Delete_from_End(); // call  Delete_from_End() function for help
        return; // we are done
    }

    /* else cases
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
   position in linked list.(delete node in the middle
    or last or even in first of the linked list */

void Delete_node_Before_position(int position)
{
    int i, len;          // local variable declaration
    struct Node *temp;  //  local variables of type struct node declaration */
    temp  = First;       //  temp is now point to head node
    len = length();     //  call length() to get length of list
    i = 1;               // initialize counter i to one

    if (First == NULL)  /* linked is empty Case*/
    {
        printf("Doubly circular linked list is Empty!!!\n");
        return; // we are done
    }
    else if(position > len + 1 || position < 2) // invalid position case
    {
        printf("invalid location!!!\n");
        return; // we are done
    }
    /*
    if given position is equal to two this mean deleting node
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

    /* else cases
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


/** A utility function to find the length of linked list */

int length()
{
    int count = 0;     // local counter variable declaration and initializations to zero
    struct Node* temp; // local variable of type struct node declaration */
    temp = First;      // temp is now point to head node

    if(First == NULL) /* linked is empty Case */
       return 0; // we are done

   /* else  case now  we are sure list is not empty so while not
     yet reach last node count the number of nodes in list */
    while(temp != last)
    {
        count++;              // increment count
        temp = temp -> next;  // move temp to next node
    }
    count = count + 1 ; // just to include the last node so have to add one to count before return
    return count; // return the number of node in list

    /** Time complexity of length() is O(n) */

} /** End of length */


/** Utility function to traverse the linked list
    and print all the element(Iterative method)*/

void Traverse()
{
    struct Node* temp; // local variable of type struct node declaration */
    temp = First;      // temp is now point to head node

    if(First == NULL) /* linked is empty Case */
    {
        printf("Doubly circular linked list is Empty!!!\n");
        return; // we are done
    }
     /*
     by now we are sure list is not empty
     so while we not yet reach last node print the value
     of node first and set temp to point to the next node */
     while(temp != last)
     {
         printf("%d --> ", temp -> data);  // print the value
         temp = temp -> next;              // move temp to next node
     }
     printf("%d --> ", temp -> data);  // print the last element
     printf("\n");

     /* also this can be written  as blow
     do
     {
         printf("%d --> ", temp -> data);  // print the value
         temp = temp -> next;              // move temp to next node
     } while(First != last)  */

    /** Time complexity of Traverse() is O(n) */

} /** End of Traverse */
