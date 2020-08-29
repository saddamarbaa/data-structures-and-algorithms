#include <stdio.h>
#include <stdlib.h>

/* A linked list node */
struct node
{
    int data;  /* data filed */

    struct node *next; /*address of next node */
};

/* pointer to first node // (head) */
struct node* first = NULL;

/*  Function to create new node */
struct node* CreateNewNode(int);

/* Function to add new node to the end of list */
void Append(int);

/* Function to add new node to the Beginning of list */
void insert_At_Beginning(int);

/* Function to add new node at the given position in list */
void insert_At_Position(int, int);

/* Function to add new node just before the given position */
void insert_Before_Position(int, int);

/* Function to add new node just aftere the given position */
void insert_After_Position(int, int);

/* function to traverse linked list and Print all element */
void Traverse(void);

/* function to find the length of linked list*/
int length();

int main(int argc, char* argv[])    /* the river Code */
{
    int option, len, position, element;  /* variable declarations */

    do
    {
        printf("Single linked list Implementation(All Linked List Operations)   :\n");
        printf("1 : Append  : insert new node to the end of list                :\n");
        printf("2 : Prepend : insert new node to the beginning of list          :\n");
        printf("3 : Insert at position : insert new node to a specific position :\n");
        printf("4 : Insert after position : insert after a specific position    :\n");
        printf("5 : Insert Before position : insert Before a specific position  :\n");
        printf("6 : Print all the element in linked list using loop             :\n");
        printf("11 : length of the linked list                                  :\n");
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

            // case 6 traverse linked list and print it value using loop
            case 6 :
                 Traverse(); // call  Traverse function
            break;

            case 7 :

            break;

            case 8 :

            break;

            // case 11 length of the  linked list
            case 11 :
                len = length();
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

struct node* CreateNewNode(int value)
{
    struct node* newNode; /* first create node */

    // allocate memory dynamically for node using malloc C function
    newNode = (struct node*) malloc(sizeof (struct node));

    if(newNode == NULL) /* error handling */
      printf("error in allocating memory\n");

    /* adding information to node */
    newNode -> data = value;
    newNode -> next = NULL;

     return   newNode;  // return newly created node to place where it been be called

} /** END of CreateNewNode() */


/** A utility function to(Append)
    insert new node to the end of list */

void Append(int value)
{
    // local variables of type struct node declaration */
    struct node *newNode, *temp;
    
    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)
    
    if (first == NULL) /* check if list is empty then this node is the first node */
    {
        // insert as the first node in list
        insert_At_Beginning(value);  // call Insert_At_Begining to added as first node
    }
    else
    {
         /*
         if already some element are in the linked list we have to first
         loop throw the linked list then add the new element at end */

         temp = first;     // temp is now point to head node

         while(temp -> next != NULL) /* while we not yet reach to NULL move temp ahead*/
         {
             temp = temp -> next; // move temp to next node
         }
         temp -> next = newNode; // add at end of list
         printf("%d : is been inserted at end of list\n",value); // inform user the element is been inserted
    }
    
    /** Time complexity of Append() is : O(N) */
    
} /** End of Append() */


/** A utility function to insert new node to the Beginning of list */

void insert_At_Beginning(int value)
{
    // local variable of type struct node declaration */
    struct node *newNode;

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if (first == NULL) /* check if list is empty then this node is the first node */
    {
        first = newNode;  // insert first node in list
        printf("%d : is been inserted as first node in list\n",value); // inform user the element is been inserted
    }
    else
    {
        /* if already some element are in the linked list we 
           have to add the new node at the Beginning of the list */
         
         /** link changes */
         newNode -> next = first;   // right side connection first
         first = newNode;           // left side connection second
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
    struct node *newNode, *temp; // local variables of type struct node declaration */
    i = 1;            // initialize counter i to one
    temp = first;     // temp is now point to head node
    len = length();   // call length() to get length of list

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if(first == NULL && position == 1)  /* case if list is empty and position == 1 */
        // insert as the first node in list in first position
        insert_At_Beginning(value);  // call Insert_At_Begining to added as first node

    else if(position > len || position <= 0) // invalid position case
    {
        printf("invalid location\n");
        return; // we are done
    }
    else if(first != NULL && position == 1) /* case if list is not empty and position == 1 */
    {
        /** link changes*/
        newNode -> next = first;       // right side connection first
        first = newNode;               // left side connection  second
        printf("%d : is been inserted at %d position \n",value, position); // inform user the element is been inserted
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
         newNode -> next = temp -> next; // right side connection first
         temp -> next = newNode;         // left side connection  second
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
    struct node *newNode, *temp; // local variables of type struct node declaration */

    // create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)
    temp = first;     // temp is now point to head node
    len = length();   // call length() to get length of list
    i = 1;            // initialize counter i to one

    if(position > len || position < 0) // invalid position case
    {
        printf("invalid location\n");
        return; // we are done
    }
    else if(first == NULL) /* linked is empty Case */
    {
        printf("linked list is empty\n");
        return; // we are done
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
    struct node *newNode, *temp; // local variables of type struct node declaration */

    // create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)
    temp = first;     // temp is now point to head node
    len = length();   // call length() to get length of list
    i = 1;            // initialize counter i to one

    if(position > len || position < 2) // invalid position case
    {
        printf("invalid location\n");
        return; // we are done
    }
    
    /*
    if already some element are in the linked list we have to first
    loop throw the linked list until position - 2 then add the new
    node at just abefore given position */
    while(i < position - 2)
    {
        temp = temp -> next;   // move temp to next node
        i++;                   // increment counter i by one
    }
    /** link changes*/
    newNode -> next = temp -> next; // right side connection first
    temp -> next = newNode;         // left side connection  second
    printf("%d : is been inserted at %d position \n",value, position - 1); // inform user the element is been inserted

    /** Time complexity of insert_Before_Possition() is O(n) */

} /** END of insert_Before_Possition() */


/** Utility function to traverse the linked list and print all the element */

void Traverse()
{
    struct node* temp; // local variable of type struct node declaration */
    temp = first;      // temp is now point to head node
    if(first == NULL) /* linked is empty Case */
    {
        printf("linked list is empty\n");
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
    struct node* temp; // local variable of type struct node declaration */
    temp = first;      // temp is now point to head node

    /* while not yet reach NULL count the number of nodes in list */
    while(temp != NULL)
    {
        count++;              // increment count
        temp = temp -> next;  // move temp to next node
    }
    return count; // return the number of node in list
    
    /** Time complexity of length() is O(n) */

} /** End of length */
