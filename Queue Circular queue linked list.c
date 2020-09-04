/**
    [PROGRAM] : Circular Queue Data Structure Implementation Using linked list
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Implement Circular Queue Using linked list

     Reference in future :---->
     1.  https://youtu.be/HsJc7a6NoTE
     2.  https://youtu.be/-wKhZqEI-vM
     3.  https://youtu.be/0KeFUi8IqEY
     4.  https://youtu.be/a5k5dLk-650
     5.  https://youtu.be/PGWZUgzDMYI
     6.  https://youtu.be/PgSrOtEay04
     7.  https://youtu.be/AeokgRec3GE
     8.  https://youtu.be/N9ztp76dwp8
     9.  https://youtu.be/gnYM_G1ILm0
     10. https://youtu.be/EXsR7HXlGLw
     11. https://youtu.be/9nEcSGdX5vY  */

#include <stdio.h>
#include <stdlib.h>

/* Circular Linked List  node */
struct Node
{
    int data;  /* data filed */

    struct Node *next; /* address of next node */
};

/* front of queue variable global declaration
   and initializations to NULL */
struct Node* Front = NULL; /*  pointer to first node(head node) */

/* Rear or tail of queue variable global declaration
   and initializations to NULL */
struct Node* Tail = NULL; /* pointer to tail node (last node)  */

//Function to push(add) Node into queue
void enqueue(int);

//Function to dequeue(remove)Node from queue
void dequeue(void);

/* function to get the Front element with out deleting it */
int Get_Front(void);

//function to Check if the queue is empty or not
int isEmpty(void);

// function to Get the number of items in queue.
int count(void);

//function to traverse queue and Print the queue element
void printQueue(void);

//function to traverse queue and clear all it element
void clearQueue(void);

int main(int argc, char* argv[]) // the  Driver Code
{
    int option, element; /* variable declarations */
    do
    {
        printf("Circular Queue Implementation Using linked list : \n");
        printf("1 : Enqueue                                     :\n");
        printf("2 : Dequeue                                     :\n");
        printf("3 : Front(front Node)                           :\n");
        printf("4 : Print all element in queue                  :\n");
        printf("5 : IsEmpty()                                   :\n");
        printf("6 : Count()                                     :\n");
        printf("7 : Clear queue                                 :\n");
        printf("0 : Enter 0 to exit (quit)                      :\n");
        // asking user to enter choice
        printf("Input your choice                               :");
        scanf("%d",&option);

        switch(option)
        {
            // case 1 enqueue new element to queue
            case 1 :
                printf("Enter an item to enqueue to queue       : ");
                scanf("%d",&element);
                enqueue(element); // call enqueue function
            break;

            // case 2 dequeue element from queue
            case 2 :
                dequeue(); // call dequeue function
            break;

            // case 3 Get front element from queue
            case 3 :
                if(isEmpty())
                    printf("Queue is Empty!!!\n");
                else
                {
                    element = Get_Front(); // call Get_Front() function
                    printf("Front Node is ---> %d\n", element);
                }
             break;

            // case 4 traverse queue
            case 4 :
                printQueue(); // call printQueue function
            break;

            // case 5 Check if the Queue is empty or not
            case 5 :
                if (isEmpty())    // call isEmpty function
                    printf("Queue is Empty!!!\n");
               else
                   printf("Queue is not Empty with %d Nodes\n",count());
            break;

            // case 6 Get the number of items in the Queue
            case 6 :
               if (isEmpty()) // if Queue is empty
                   printf("Queue Underflow!!!\n");
               else
                   printf("number of element in Queue are : %d \n", count());
            break;

            // case 7 clear all the element in Queue
            case 7 :
                clearQueue(); // call clear_Queue function
            break;

           case 0:  // case 0 Exit case
              printf("time to exit thanks\n");
           _Exit(0);

           default: // default case
              printf("invalid input\n");
            break; // no need break after default case I use it only for readability

         } /** END of switch */

    } while(1); /** END OF DO WHILE LOOP */

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

    return   newNode;  // return newly created node to place where it been be called

} /** END of CreateNewNode() */


/** A utility function to push new given element to queue */

void enqueue(int element)
{
    struct Node *newNode;  /* local variable of type struct node declaration */

    // first step let create node to enqueue
    newNode = CreateNewNode(element); // call function to create new nod (now node is ready to add)

    if(isEmpty())  /* check if queue is empty then this node is the first node */
       Front = Tail = newNode;  // insert first node in list
    else
    {
        /*
        if already some element are in the linked(queue) list we have
        add the new node at the end after that make it Circular List */

        /** link changes */

        Tail -> next = newNode;  // link tail -> next  to newNode
        Tail = newNode;          // now Tail point the new nod
        Tail -> next = Front;   // make it Circular queue now last nod is now point to first node

       // tail node next alway have the address of head(first) so is a circular linked list
    }

    printf("Node --> %d  been Enqueued\n",element); // inform  user the element is been added

   /** Time complexity of enqueue() is : O(1) */

} /** End of enqueue() */


/**
     utility function to dequeue(remove)first Node in queue (first in first out)  */

void dequeue()
{
    struct Node* temp; // local variable of type struct node declaration */
    temp = Front;      // temp is now point to head node

    if (isEmpty()) // queue(linked list) is empty Case
    {
        printf ("Queue Underflow!!! \n");
        return; // we are done
    }
    /* if having only one node in queue (linked list) dequeue
       that node and assign Front and Tail to NULL */
    else if(Front == Tail)
    {
        printf("Node --> %d been Dequeued\n",temp -> data); // inform user the job is about to done
        Front = Tail = NULL; // assign front and Tail to NULL
        temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
        free(temp);  // now Delete temp using free() C function
        return; // we are done
    }
    /*
     * by now we are sure that Queue(linked list) have more than one node
     * in this case we first dequeue the Front node and move Front variable
     * point to second node  so the second node will be the Front after we
     * delete the first one for that we need to update 3 nodes
     * Front
     * Front -> next
     * Tail -> next*/
    else
    {
        /** link changes */

        printf("Node --> %d been Dequeued\n",temp -> data); // inform user the job is about to done
        Front = Front -> next; // move first one step Ahead
        Tail -> next = Front;  // connect last node to first node
        temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
        free(temp);          // now Delete temp using free() C function
    }

    /** Time complexity of dequeue() is : O(1) */

}/** End of dequeue() */


/**
   Utility function to Check if the queue is empty or not */

int isEmpty()
{
    if (Front == NULL && Tail == NULL) /* empty case */
        return 1;
    else               /* else case */
        return 0;

}/** End of isEmpty() */


/** Utility function to traverse the Queue(linked list)
  and print all the element (Iterative method)*/

void printQueue()
{
    struct Node* temp; // local variable of type struct node declaration */
    temp = Front;      // temp is now point to head node

    if (isEmpty()) // queue(linked list) is empty Case
    {
        printf("Queue Underflow!!!\n");
        return; // we are done
    }

    /* else case
    by now we are sure list(queue) is not empty
    so while we not yet reach tail node print the value
    of node first and set temp to point to the next node */

    printf("Queue Contain the flowing Element :-->\n");
    while(temp != Tail)
    {
        printf("%d --> ", temp -> data);  // print the value
        temp = temp -> next;              // move temp to next node
    }
    printf("%d --> ", temp -> data);  // print the last element
    printf("\n");

    /** Time complexity of printQueue() is O(n) */

} /**END of printQueue()*/


/**
  Utility function to clear the queue (Destroy entire Queue) */

void clearQueue()
{
    struct Node* temp; // local variable of type struct node declaration */
    temp = Front;      // temp is now point to head node

    if (isEmpty()) // queue(linked list) is already empty
    {
        printf("Queue Underflow!!!\n");
        return; // we are done
    }
    /*
    if having only one node in queue (linked list) dequeue
    that node and assign Front and Tail to NULL */
    else if(Front == Tail)
    {
        Front = Tail = NULL; // assign front and Tail to NULL
        temp -> next = NULL;  // assign temp -> next to NULL(this not have to)
        free(temp);  // now Delete temp using free() C function

        printf("Queue Have only one Node and been destroyed\n");  // inform user the job is done
        return; // we are done
    }
    // else cases
    
    /* while not yet reach tail node go Ahead and Destroy the queue) */
    while(temp != Tail)
    {
        /** link changes */
        // move temp one step back
        temp = temp -> next;  // connect temp to  temp -> next
        free(Front);          // Delete front node using C function free()

        // now move top one step back
        Front = temp;  //  front is now point to temp
    }

    // after loop now free temp (last node) and set front and Tail to NULL
    free(temp);             // Delete top node using C function free()
    Front = Tail =  NULL;   // front and tail are now point to NULL

    printf("All Queue Elements Been Destroyed\n");  // inform user the job is done

    /** Time complexity of clearQueue() is O(n) */

} /** End of clearQueue() */


/** function to Get the number of items in the Queue */
int count()
{
    int count = 0;     // local counter variable declaration and initializations to zero
    struct Node* temp; // local variable of type struct node declaration */
    temp = Front;      //  temp is now point to head node

    /* while not yet reach tail node count the number of nodes in list(queue) */
    while(temp != Tail)
    {
        count++;              // increment count
        temp = temp -> next;  // move temp to next node
    }
    count = count + 1 ; // just to include the last node so have to add one to count before return
    return count; // return the number of node in queue

    /** Time complexity of count() is O(n) */

} /** End of count() */


/** function to get the Front element with out deleting it */

int Get_Front()
{
    return  Front -> data;  // return top element

    /** Time complexity of front() is O(1) */

} /** END of  front()*/
