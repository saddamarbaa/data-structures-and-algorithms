/**
    [PROGRAM] : Hash Tables and Hash Functions Implementation
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

     C Program to Implement Hash Tables.
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

/* A structure to represent data set
  (key ,value) to store in hash table */
struct Data_Set
{
    int key;      /* key filed */
    int value;     /* data(value) filed */
};

/* Global array(hash table) declaration*/
struct Data_Set* hashArray;

/*  hash Table capacity Global declaration
    and initialization to 10 */
int capacity = 10;

/*  hash Table size Global declaration
    and initialization to zero */
int size = 0;

// function to create hash table and initialize to zero
void initialize_Array(void);

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

// function to test if the given number is prime
int isPrime(int);

// function to get prime number
int getPrime(int);

int main(int argc, char* argv[])    /* the river Code */
{
    int option, key, value, n;     /* variable declarations */

    /* Create Array(hash table)and initialize
       all it element(key,values) to zero */
    initialize_Array();  // call initialize_Array() function

    do
    {
        printf("Hash Table and Hash Function Implementation :\n");
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
  initialize the (key , values) to zero */

void initialize_Array()
{
    int i; // counter variable declaration

    /* first step :  update size of array(Hash Table) to prime number */
    capacity = getPrime(capacity); // call getPrime function

    /* second step : allocate memory dynamically for array(hash table)
       using malloc C function( memory same as capacity)  */
    hashArray = (struct Data_Set*) malloc(capacity * sizeof (struct Data_Set));

    if(hashArray == NULL) /* error handling */
       printf("error in allocating memory\n");

    /* third step : initialize hash table to zero */
	for (i = 0; i < capacity; i++)
    {
        hashArray[i].key = 0;
        hashArray[i].value = 0;
	}

} /** End of initialize_Array */


/** Hash function take one value(key) as argument
    and return a unique hash code to the given key */

int hashFunction(int key)
{
    return (key % capacity); // return unique hash code

    /* Time complexity of hashFunction() : O(1) */

} /**End of hashFunction */


/** A utility function to insert a key in the hash table */

void insert(int key, int data)
{
	int hashIndex;  /* local variables declaration */

	// first step : get the hash code
	hashIndex = hashFunction(key); // call hashFunction() function

	/** Handle all the corner cases */

	/* case when the key not present in table */
	if(hashArray[hashIndex].value == 0)
    {
       /* by now we are sure the given key is not present
          in the hash table so let insert it */

        hashArray[hashIndex].key = key;      // add key
        hashArray[hashIndex].value = data;   // add value
        size++; /* increment hash size by one */

        // inform user the element is been inserted
        printf("\nKey (%d) has been inserted \n", key);

    }
    /* case when the key is already present in table */
    else if(hashArray[hashIndex].key == key)
    {
        /* by now we are sure the given key is already present
          in the hash table so let updated */

        hashArray[hashIndex].value = data;   /* update already existing value */
        printf("\nkey --> (%d) Value is been updated to (%d)\n",key, data);

    }
    else  /* case when the Collision occurred  */
    {
        printf("\nCollision occurred value cant be inserted \n");
    }

    /* Time complexity of insert() : O(1) */

} /** End of insert() */


/** Utility function to Remove(delete) given a key from hash table*/

void remove_Item(int key)
{
    int hashIndex;  /* local variables declaration */

	// first step : get the hash code
	hashIndex = hashFunction(key); // call hashFunction() function

	if (hashArray[hashIndex].value == 0) /* case when the key not present in table */
        printf("\nThis key does not exist in the hash table\n");

    else  /* case when the key present in table */
    {
        /* by now we are sure the given key is present
          in the hash table so let Removed */

        hashArray[hashIndex].key = 0;      // Remove the key
        hashArray[hashIndex].value = 0;   // Remove the value
        size--; /* decrement hash size by one */

        printf("\nKey (%d) has been Removed \n", key); // inform user the element is been Removed
    }

    /* Time complexity of remove_Item : O(1) */

} /** End of remove_Item() */


/**  Utility function to Search For item with given key from hash table */

void search_Item(int key)
{
    int hashIndex;  /* local variables declaration */

	// first step : get the hash code
	hashIndex = hashFunction(key); // call hashFunction() function

	if (hashArray[hashIndex].key == 0) /* case when the key not present in table */
        printf("\nNot found in the hash table!!\n");

    else  /* case when the key present in table */
        printf("\nan Item with Key (%d) is  : (%d) \n", key , hashArray[hashIndex].value);

    /* Time complexity of search_Item : O(1) */

} /** End of search_Item() */


/**
   Utility function to traverse array(hash table)
    and display all the elements of a hash table */

void display()
{
    int i; /* counter variable declaration */

    for (i = 0; i < capacity; i++)
    {
        if(hashArray[i].value == 0)
            printf("\n hash table [%d] has no elements \n", i);
        else
            printf("\n hash table [%d] has elements --> :"
                   "key(%d)and value(%d) \t\n", i, hashArray[i].key, hashArray[i].value);
    }

    /* Time complexity of display() : O(n) */

} /** End of display */


/* function to get size of hash table(number of element in table) */
int size_of_hashtable()
{
    return size;

    /* Time complexity of size_of_hashtable() : O(1) */

} /** End of size_of_hashtable() */


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
