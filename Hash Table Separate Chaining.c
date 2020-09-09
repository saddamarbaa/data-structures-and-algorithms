
/**
    [PROGRAM] : Hash Tables and Hash Functions Implementation
                Separate Chaining with Singly Linked Lists
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

     C Program to Implement Hash Table Separate Chaining with Singly Linked Lists.

     Hash table is a data structure that represents data
     in the form of key-value pairs.
     Each key is mapped to a value in the hash table.
    (keys must be unique , but the value can be repeated)

     Reference in future :---->
      1.  https://youtu.be/KTO__3AVVCU
      2   https://youtu.be/F-WGJoLOLrk
      3.  https://youtu.be/nvzVHwrrub0
      4.  https://youtu.be/yXwaPBSMT-o
      5.  https://youtu.be/ivnthLgZymk
      6.  https://youtu.be/BmayUdDaDYM
      7.  https://youtu.be/KW0UvOW0XIo
      8.  https://youtu.be/z0lJ2k0sl1g
      9.  https://youtu.be/z0lJ2k0sl1g
      10. https://youtu.be/rvdJDijO2Ro
      11. https://youtu.be/KqqOXndnvic
      12. https://youtu.be/Rp3KxUdV09Y
      13. https://youtu.be/zeMa9sg-VJM
      14. https://youtu.be/ncHmEUmJZf4   */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>// include cmath.h function

/*
  linked list Node Structure to store
   data (key ,value, next node address)*/
struct Node
{
    int key;             /* key filed */
    int value;           /* data(value) filed */
    struct Node *next;  /* address of the next node */
};

/*
  array Item structure to store
  a Linked List at each index of Hash Table  */
struct arrayItem
{
    /*
    head pointer point to the first element
    of Linked List at an index of Hash Table
    (head node,also called first node) */
    struct Node* Head;

    /*
    tail pointer point to the last element
    of Linked List at an index of Hash Table
    (last node, also called tail node) */
    struct Node* Tail;
};

/* Global array(hash table) declaration*/
struct arrayItem* hashArray;

/*Global declaration of Hash Table maximum
  capacity and initialization to 10(array size) */
int max_Capacity = 10;

/*Global declaration Hash Table size Global size and initialization
  to zero (number of elements present in Hash Table */
int SIZE = 0;

/*Load Factor variable is to keeping track of load factor,
 and know weather rehashing is required or not so far each
 time new item is been inserted to the hash table */
float load_Factor = 0.0;

/*  Function to create new node */
struct Node* CreateNewNode(int, int);

// function to create hash table and initialize to zero
void initialize_Array(void);

// function to search for key in Linked List
int search(struct Node *list, int);

// function to get Node at given index
struct Node* get_Node(struct Node* list, int);

/* function to insert a key in the hash table */
void insert(int, int);

/* function to Search For item in the Hash Table */
void search_Item(int);

// function to Remove(delete)key from hash table
void remove_Item(int);

// function to traverse Hash Table and Print
// all element(Iterative method)
void display(void);

/* Function to return a unique hash code to the given key */
int hashFunction(int);

/* function to get size of hash table */
int size_of_hashtable();

int main(int argc, char* argv[])    /* the river Code */
{
    int option, key, value, n;     /* variable declarations */

    /*
    Create Array(hash table)and initialize Head and Tail to NULL */
    initialize_Array();  // call initialize_Array() function

    do
    {
        printf("Hash Table Separate Chaining with Singly Linked Lists :\n");
        printf("1 : Insert item in the Hash Table           :\n");
        printf("2 : Remove item from the Hash Table         :\n");
        printf("3 : Search For item in the Hash Table       :\n");
        printf("4 : Display a Hash Table                    :\n");
        printf("5 : Check the size of Hash Table            :\n");
        printf("0 : Enter 0 to exit (quit)                  :\n");

        // asking user to enter choice
        printf("  : Input your choice                       :");
        scanf("%d",&option);
        switch(option)
        {
            // case 1 insert an item to Hash Table
            case 1 :
                printf("Enter the key to be inserted : ");
                scanf("%d",&key);
                printf("Enter the value(data) to be inserted  : ");
                scanf("%d",&value);
                insert(key, value); // call insert function
            break;

            // case 2 Remove(delete)key from hash table
            case 2 :
                printf("Enter the key to be deleted : ");
                scanf("%d",&key);
                remove_Item(key); // call remove_Item function
            break;

            // case 3 Search For item in the Hash Table
            case 3 :
                printf("Enter the key to Search For item : ");
                scanf("%d",&key);
                //search_Item(key); // call search_Item_Item function
            break;

            // case 4 traverse Hash Table and Print all element(Iterative method)
            case 4 :
                display(); // call display() function
            break;

            // case 5 get size of hash table (number of element in hash table)
            case 5 :
                n = size_of_hashtable(); // call size_of_hashtable function
                if(n == 0)
                    printf("Hash Table is Empty!!!\n");
                else
                    printf("Size of Hash Table is  --: %d\n", n);
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


/** function To create Array(hash table) and
  initialize Head and tail to NULL */

void initialize_Array()
{
    int i; // counter variable declaration

    /* allocate memory dynamically for array(hash table)
       using malloc C function(memory same as max_Capacity)  */
    hashArray = (struct arrayItem*) malloc(max_Capacity * sizeof (struct arrayItem));

    if(hashArray == NULL) /* error handling */
       printf("error in allocating memory\n");

    /* initialize hash table to NULL */
	for (i = 0; i < max_Capacity; i++)
    {
        hashArray[i].Head = NULL;
        hashArray[i].Tail = NULL;
    }

} /** End of initialize_Array */


/** Hash function take one value(key) as argument
    and return a unique hash code to the given key */

int hashFunction(int key)
{
    return (key % max_Capacity); // return unique hash code

    /* Time complexity of hashFunction() : O(1) */

} /**End of hashFunction */


/** A utility function to insert a key in the hash table */

void insert(int key, int data)
{
	// get the hash code
	int hashIndex = hashFunction(key); // call hashFunction() function

    /* Extract Linked List at a given index by hashFunction */
	struct Node *list = (struct Node*) hashArray[hashIndex].Head;

	/* list is now point the hashIndex so let create node to add */

	// create the node
    struct Node *newNode = CreateNewNode(key, data); // call function to create new(now node is ready to add)

	/** Handle all the corner cases */

	if(list == NULL) /* check if list is empty then this node is the first node at that index */
    {
        hashArray[hashIndex].Head = newNode;
        hashArray[hashIndex].Tail = newNode;
        SIZE++; /* increment hash size by one */

        // inform user the element is been inserted
        printf("Key :(%d) and value :(%d) been inserted \n",key, data);
    }
    else // else cases
    {
        /*
        search for the node in list first before adding
        maybe the is already in the  hash table */
        int find_index = search(list, key);  // call search function

		if (find_index == -1)  /* case when the key not present in table */
        {
            /*
            by now we are sure the given key is not present in the
            hash table so let insert the node at end of linked list */

            hashArray[hashIndex].Tail-> next = newNode;  // connect Tail -> next to newnode
            hashArray[hashIndex].Tail = newNode;        // tail is now point to the new node
            SIZE++; /* increment hash size by one */

            // inform user the element is been inserted
            printf("Key :(%d) and value :(%d) been inserted \n",key, data);

        }
        else /* case when the key is already present in table */
        {
            /*
            by now we are sure the given key is already
            present in the hash table so let updated */

            struct Node* update = get_Node(list, find_index);
            update -> value = data;
            printf("\n the value at Key (%d) has been updated to value (%d) \n", key, data);
        }
    }

    /*
    inserting node process is done
    so now let check load factor to make sure everything is ok */

    // Calculate Load factor
    load_Factor = (1.0 * SIZE) / max_Capacity;

    /* if Load factor is bigger than  0.75 we need rehash*/

    if (load_Factor >= 0.75)
    {
        printf("going to rehash\n");
       // rehash(); // call rehash function
    }

} /** End of insert() */


/**
    A utility function create a new Node in heap so I can called
    it each time I need new node */

struct Node* CreateNewNode(int key, int value)
{
    struct Node* newNode; /* first create node */

    // allocate memory dynamically for node using malloc C function
    newNode = (struct Node*) malloc(sizeof (struct Node));

    if(newNode == NULL) /* error handling */
      printf("Error in allocating memory\n");

    /* adding information to node */
    newNode -> key = key;       // set key at key filed
    newNode -> value = value;   // set value at value filed
    newNode -> next = NULL;  // next is NULL for now

     return   newNode;  // return newly created node to place where it been be called

} /** END of CreateNewNode() */


/** Utility function to Remove(delete) given a key from hash table*/

void remove_Item(int key)
{

} /** End of search_Item() */


/**
   Utility function to traverse array(hash table)
    and display all the elements of a hash table */

void display()
{

} /** End of display */


/* function to get size of hash table(number of element in table) */

int size_of_hashtable()
{
    return SIZE;

    /* Time complexity of size_of_hashtable() : O(1) */

} /** End of size_of_hashtable() */


/**
   A utility function to search for the given key in the Linked List
    Returns it's index is found
    Returns -1 in case key is not present */

int search(struct Node *list, int key)
{
    int index = 0; // index is now zero
    struct Node* temp;  // local variable of type struct node declaration */
    temp = list;       // temp is now point to the given node

    // while temp is not null GO and search for key
	while (temp != NULL)
    {
        if (temp -> key == key) // if temp -> key == key mean is found it index
        {
            return index;  // return index
		}
        temp = temp -> next;   // move temp to next node
        index++;    // increment index by one
    }

    // if search here the key is not found in list return -1
	return -1;

}/** END of search() */


/**
   A utility function to search for node from the Linked List
    at given index and Returns that node
    (before calling this function we are already the given index have node */

struct Node* get_Node(struct Node* list, int find_index)
{
    int i = 0;
    struct Node* temp;  // local variable of type struct node declaration */
    temp = list;       // temp is now point to the list

    // search for node
	while (i != find_index)
    {
        temp = temp -> next;   // move temp to next node
        i++;                  // increment i by one
    }

   // by now we found the node
	return temp;

}/** END of get_Node() */
