/**
    [PROGRAM] :  Merging two Singly Linked List
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program for Merging two Singly Linked List

    A linked list is a linear data structure, in which the elements
    are not stored at contiguous memory locations.
    The elements in a linked list are linked using pointers
    (entity that point to the next element)

     Reference in future :---->
     1. https://youtu.be/dgRSvgW3wnM
     2. https://youtu.be/PGWZUgzDMYI
     3. https://youtu.be/HdFG8L1sajw
     4. https://youtu.be/NobHlGUjV3g
     4. https://youtu.be/lC-yYCOnN8Q
     5. https://youtu.be/vcQIFT79_50
     6. https://youtu.be/IJrQCCmuaqc
     7. https://youtu.be/dmb1i4oN5oE
     8. https://youtu.be/DWpVGpNfDmM
     9. https://youtu.be/qauEA64G1Ds
     10. https://youtu.be/6wXZ_m3SbEs
     11. https://youtu.be/dq3F3e9o2DM
     12. https://youtu.be/ClvYytk5Rlg
     13. https://youtu.be/SbGRuk38MvI
     14. https://youtu.be/Tk_fi5l8cag  */

#include <stdio.h>
#include <stdlib.h>

/* A linked list node  */
struct node
{
    int data;  /* data filed */

    struct node *next; /*address of next node */
};

/* head pointer to first node of First linked list*/
struct node* Head1 = NULL;

/* head pointer to first node of second linked list*/
struct node* Head2 = NULL;

/*  Function to create new node */
struct node* CreateNewNode(int);

/* Function to add new node to the end of list2 */
void Append1(int);

/* Function to add new node to the end of list2 */
void Append2(int);

/* Function to Merge the two Singly Linked List */
void Merge_Linked_List();

// function to traverse linked list and Print
// all element (Iterative method) */
void Traverse(struct node* temp);

int main(int argc, char* argv[])    /* the river Code */
{
    int option, element;  /* variable declarations */

    do
    {
        printf("Merging two Singly Linked List                   :\n");
        printf("1 : Append1   : insert node to First Linked List :\n");
        printf("2 : Append2   : insert to second Linked List     :\n");
        printf("3 : Merge     : Merge the two List               :\n");
        printf("4 : Traverse  : Print the Final Linked List      :\n");
        printf("0 : Enter 0 to exit (quit)                       :\n");
        // asking user to enter choice
        printf("input your choice                                :");
        scanf("%d",&option);
        switch(option)
        {
            // case 1 insert new node to the first linked list
            case 1 :
                printf("Enter element to be inserted to First Linked List :");
                scanf("%d",&element);
                Append1(element); // call append1 function
            break;

            // case 2 insert new node to the second linked list
            case 2 :
                printf("Enter element to be inserted to second Linked List :");
                scanf("%d",&element);
                Append2(element); // call append2 function
            break;

            // case 3 Merging the two linked list
            case 3 :
                 Merge_Linked_List(); // call Merg_Linked_List function
            break;

            // case 4 traverse the Final linked list
            case 4 :
                 Traverse(Head1); // call  Traverse function
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
    insert new node to the end of first linked list */

void Append1(int value)
{
    // local variables of type struct node declaration */
    struct node *newNode, *temp;

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if (Head1 == NULL) /* check if list is empty then this node is the first node */
        Head1 = newNode;  // insert first node in list
    else
    {
        /*
        if already some element are in the linked list we have to first
        loop throw the linked list then add the new element at end */

        temp = Head1;     // temp is now point to head node

        while(temp -> next != NULL) /* while we not yet reach to NULL move temp ahead*/
        {
             temp = temp -> next; // move temp to next node
        }
        temp -> next = newNode; // add at end of list
    }

    printf("--> %d : inserted in list_1\n",value); // inform user the element is been inserted

    /** Time complexity of Append1() is : O(N) */

} /** End of Append1() */


/** A utility function to(Append)
    insert new node to the end of second linked list */

void Append2(int value)
{
    // local variables of type struct node declaration */
    struct node *newNode, *temp;

    // first step create the node
    newNode = CreateNewNode(value); // call function to create new nod (now node is ready to add)

    if (Head2 == NULL) /* check if list is empty then this node is the first node */
       Head2 = newNode;  // insert first node in list
    else
    {
        /*
        if already some element are in the linked list we have to first
        loop throw the linked list then add the new element at end */

        temp = Head2;     // temp is now point to head node

        while(temp -> next != NULL) /* while we not yet reach to NULL move temp ahead*/
        {
            temp = temp -> next; // move temp to next node
        }
        temp -> next = newNode; // add at end of list
    }
    printf("--> %d : inserted in list_1\n",value); // inform user the element is been inserted

    /** Time complexity of Append2() is : O(N) */

} /** End of Append2() */


/** Utility function to traverse the linked list
    and print all the element(Iterative method)*/

void Traverse(struct node* temp)
{
    if(temp == NULL) /* linked is empty Case */
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

/**
   Utility function to Merge two Singly Linked List in one list */

void Merge_Linked_List()
{
    struct node* temp; // local variable of type struct node declaration */
    temp = Head1;     // temp is now point to head node of first linked list

    if(Head2 == NULL && Head1 == NULL) /* both linked is empty Case */
    {
        printf("Both linked list are Empty!!!\n");
        return; // we are done
    }
    else if(Head1 == NULL) /* first list is empty Case */
    {
        printf("First linked list is Empty!!!\n");
        return; // we are done
    }
    else if(Head2 == NULL) /* second list is empty Case */
    {
        printf("second linked list is Empty!!!\n");
        return; // we are done
    }


     /*
     by now we are sure  both list are not empty
     so let traverse and merge*/
     while(temp -> next != NULL)
     {
         temp = temp -> next;              // move temp to next node
     }
     // by now we are at the end of list one

     temp -> next = Head2; //connect list 2 to the end of list one
     printf("Merging is DONE\n"); // inform user the element is been inserted
}
