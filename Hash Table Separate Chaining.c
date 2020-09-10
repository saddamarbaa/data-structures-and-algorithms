/**
    [PROGRAM] : Hash Tables and Hash Functions Implementation
                Separate Chaining with Singly Linked Lists
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

     C Program to Implement Hash Table Separate Chaining with Singly Linked Lists.

     Hash table is a data structure that represents data
     in the form of key-value pairs.
     Each key is mapped to a value in the hash table.
    (keys must be unique, but the value can be repeated)
    
    Separate Chaining deals with hash collisions by maintaining
    a data structure(usually linked list) to hold all the different
    values which hashed to particular value.

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

/* Global declaration of Hash Table maximum
  capacity and initialization to 10(array size) */
int max_Capacity = 10;

/* Global declaration Hash Table size Global size and initialization
  to zero (number of elements present in Hash Table */
int SIZE = 0;

/* Load Factor variable is to keeping track of load factor,
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

// function to Rehash the hash table
void rehash(void);

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
int size_of_hashtable(void);

// function to test if the given number is prime
int isPrime(int);

// function to get prime number
int getPrime(int);


int main(int argc, char* argv[])    /* the river Code */
{
    int option, key, value, n;     /* variable declarations */

    /* first step :  update size of array(Hash Table) to prime number */
    max_Capacity = getPrime(max_Capacity); // call getPrime function

    /*  second step
    Allocate memory dynamically for array(hash table)
    using malloc C function(memory size same as max_Capacity)*/
    hashArray = (struct arrayItem*) malloc(max_Capacity * sizeof (struct arrayItem));

    if(hashArray == NULL) /* error handling */
       printf("Error in allocating memory\n");

    /* next step initialize hash table(Head and Tail )to NULL */
    initialize_Array();  // call initialize_Array() function

    do
    {
        printf("Hash Table Separate Chaining With Singly Linked Lists :\n");
        printf("1 : Insert item in the Hash Table                     :\n");
        printf("2 : Remove item from the Hash Table                   :\n");
        printf("3 : Search For item in the Hash Table                 :\n");
        printf("4 : Display a Hash Table                              :\n");
        printf("5 : Check the size of Hash Table                      :\n");
        printf("0 : Enter 0 to exit (quit)                            :\n");

        // asking user to enter choice
        printf("  : Input your choice                                 :");
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
                search_Item(key); // call search_Item_Item function
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
                    printf("Size of Hash Table is  : %d\n", n);
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


/** function To  initialize the Array(hash tables)
    Head and tail to NULL */

void initialize_Array()
{
    int i; // counter variable declaration

    /* loop and initialize hash table Head and tail to NULL */
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

} /** End of hashFunction */


/**
    A utility function to create a new Node in heap so I can called
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

	if(list == NULL) /* check if list at hashIndex is Empty then this node is the first node at that index  */
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

            struct Node* update = get_Node(list, find_index); // call get_Node() function
            update -> value = data; // update the node value
            printf("\n the value at Key (%d) has been updated to value (%d) \n", key, data);
        }
    }

    /*
    inserting the key process is done
    so now let check load factor to make sure everything is ok */

    // Calculate Load factor
    load_Factor = (1.0 * SIZE) / max_Capacity;

    /* if Load factor is bigger than  0.75 we need rehash*/

    if (load_Factor >= 0.75)
    {
        printf("its time to rehash the table \n");
       rehash(); // call rehash function
    }

} /** End of insert() */


/**
   Utility function to traverse array(hash table)
    and display all the elements of a hash table */

void display()
{
    int i; /* counter variable declaration */

    struct Node* temp;  // local variable of type struct node declaration */

    for (i = 0; i < max_Capacity; i++)
    {
        temp = hashArray[i].Head;  // temp point to the head node at index i

        if (temp == NULL)
        {
            printf("\n hash table [%d] has no elements \n", i);
        }
        else
        {
            printf("\n hash table [%d] has elements --> : ",i);
            while (temp != NULL)
            {
                printf("key  = %d  value  =  %d\t", temp -> key, temp -> value);
                temp = temp -> next; // move temp to the next node
            }
        }
    }
    printf("\n");

} /** End of display */


/** Utility function to Remove(delete) given a key from hash table */

void remove_Item(int key)
{
    // get the hash code
	int hashIndex = hashFunction(key); // call hashFunction() function

    /* Extract Linked List at a given index by hashFunction */
	struct Node *list = (struct Node*) hashArray[hashIndex].Head;

	/** Handle all the corner cases */

	if(list == NULL) /* check if list at hashIndex is Empty*/
    {
        printf("\nThis key does not exist in the hash table!!\n");
        return; // we are done
    }
    else // list at hashIndex is not Empty
    {
        /* search for the node in list at hashIndex maybe is not there  */
        int find_index = search(list, key);  // call search function

		if (find_index == -1)  /* case when the key not present in table */
        {
            /*
            by now we are sure again the given key is not present in the
            hash table */
            printf("\nThis key does not exist in the hash table\n");
            return; // we are done
        }
        else /* case when the key is present in table */
        {
          /*
            by now we are sure the given key is present in the hash
            table so let get it first then is easy to delete*/

            struct Node *temp, *prves;   // local variable of type struct node declaration */
            temp = prves = list;        //temp and prves are now pointing to head node

            if (temp -> key == key)  // case when the given value its at first position */
            {
                /** link changes */

                hashArray[hashIndex].Head = temp -> next;  // right side connection first
                temp -> next = NULL;        // connect temp -> next to NULL
                free(temp);                 // now Delete temp using free() C function
                printf("\nKey (%d) has been Removed \n", key); // inform user the element is been Removed
                SIZE--; /* decrement hash size by one */
                return; // we are done
            }
            /*
            by now we are sure node to be deleted is not at the
            beginning  maybe its somewhere in middle or last so let search it*/
            while (temp != NULL && temp -> key != key)  // loop until find the key
            {
                prves = temp;          // save temp in prves
                temp = temp -> next;  // move temp to next node
            }
            if (temp == NULL) // after search if temp is NULL mean
            {                 // the key is found at the last node
                /** link changes */
                prves -> next = NULL;        // right side connection first
                hashArray[hashIndex].Tail = prves; // move tail one step back
                free(temp);                    // now Delete temp using free() C functi
            }
            else // the key is not the last node and not first node
            {    // its somewhere in middle and now we are at the key position

                /** link changes */

                prves -> next = temp -> next;  // right side connection first
                temp -> next = NULL;           // connect temp -> next to NULL
                free(temp);                    // now Delete temp using free() C function
            }
            SIZE--; /* decrement hash size by one */
            printf("\nKey (%d) has been Removed \n", key); // inform user the element is been Removed

        }
    }

} /** End of remove_Item() */


/** function to get size of hash table(number of element in table) */

int size_of_hashtable()
{
    return SIZE;

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
 A utility function to Rehash the hash table by creating new hash
 table of size double the previews one then copy all the item from
 old hash to the new hash table and lastly delete the old hash */

void rehash()
{
    struct arrayItem* temp;  // local variable of type struct arrayItem declaration */

    temp = hashArray;  /* temp pointing to the current Hash Table array */

    int i = 0, n =  max_Capacity;

	SIZE = 0; // set size back to zero

	max_Capacity = 2 * max_Capacity;  // double the maximum hash table size

    /* update max_Capacity of array(Hash Table) to prime number */
    max_Capacity = getPrime(max_Capacity); // call getPrime function

    /*
    allocate new memory dynamically for array(hash table)
    using malloc C function(new array size is double of previous array size) */
    hashArray = (struct arrayItem*) malloc(max_Capacity * sizeof (struct arrayItem));

    if(hashArray == NULL) /* error handling */
       printf("error in allocating memory\n");

    /* now initialize the hash table (Head and Tail )to NULL */
    initialize_Array();  // call initialize_Array() function

    for (i = 0; i < n; i++)
    {
        /* Extract Linked List at position i of Hash Table array */

 		struct Node* list = (struct Node*) temp[i].Head;

 		if (list == NULL) /* check if list at hashIndex is Empty */
 		{
 		    continue; // continue to next index
 		}
 		else // else cases
        {
           // loop copy all the item and add to new table
            while (list != NULL)
            {
                // Get one key and value at a time and add it
                // to new Hash Table array.
                insert(list -> key, list -> value);
                // move list next node
                list = list -> next;
            }
        }
    }
    temp = NULL; // temp is now point to Null

 } /** End of rehash() */


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


/**
    function to test if the given number is prime number or not
     (Trial division method )*/

int isPrime(int num)
{
    if(num == 1 || num == 0) /* handle corner case */
       return 0; // zero and one are not prime so return zero false

    /* start loop from 2 and run until sqrt Root of num */
    for(int i = 2, N = sqrt(num); i <= N; i++)
    {
        // if there is any number that can divide our number(num)
        // that mean the number is not prime
        if(num % i == 0)
          return 0; // return zero

    } /** End for loop */

    return 1; //if you reach here number is prime

    /* Time complexity of isPrime() : sqrt(N) */

}/** End isPrime */


/**
    function to get prime number which is just bigger
    than the given  number num (first prime number after num) */

int getPrime(int num)
{
    if(num % 2 == 0)   /* check if num is not prime */
      num++;           // increase num by one

    while(!isPrime(num)) // while num is not yet prime
        num += 2;           //increase num by 2 and back check again

    return num; // by now num is prime

}/** End of getPrime */


/**  Utility function to Search For item with given key from hash table */

void search_Item(int key)
{
    // get the hash code
	int hashIndex = hashFunction(key); // call hashFunction() function

    /* Extract Linked List at a given index by hashFunction */
	struct Node *list = (struct Node*) hashArray[hashIndex].Head;

	if(list == NULL) /* check if list at hashIndex is Empty */
    {
        printf("This key does not exist in the hash table!!\n");
        return; // we are done
    }
    else // list at hashIndex is not Empty
    {
        /* search for the node in list at hashIndex */
        int find_index = search(list, key);  // call search function

		if (find_index == -1)  /* case when the key not present in table */
        {
            /*
            by now we are sure again the given key is not present in the
            hash table */
            printf("This key does not exist in the hash table\n");
            return; // we are done
        }

        else /* case when the key is already present in table */
        {
            /*
            by now we are sure the given key is present in the
            hash table so let inform  the user */
            printf("the key is present in hash table\n");
        }
    }

} /** End of search_Item() */
