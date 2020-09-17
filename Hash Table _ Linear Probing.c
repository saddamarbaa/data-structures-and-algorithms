/**
    [PROGRAM] : Hash Tables and Hash Functions Implementation Using Linear Probing (Collision Resolution Technique)
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

     C Program to Implement Hash Tables with Linear Probing.
     Hash table is a data structure that represents data
     in the form of key-value pairs.
     Each key is mapped to a value in the hash table.
    (keys must be unique, but the value can be repeated)

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

/* A structure to represent hash table item which are a flag(status)
   and data (consisting of key and value */
struct hashtable_Item
{
    /*
     * flag = 0 : data does not exist
     * flag = 1 : data exists
     * flag = 2 : data existed at least once
    */
    int flag;  // flag

    struct Data_Set* data; // data(key and value)
};

/* Global array(hash table) declaration*/
struct hashtable_Item* hashArray;

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

    /* first step : update size of array(Hash Table) to prime number */
    capacity = getPrime(capacity); // call getPrime function

    /*
    second step : allocate memory dynamically for array(hash table)
    using malloc C function( memory same as capacity)  */
    hashArray = (struct hashtable_Item*) malloc(capacity * sizeof (struct hashtable_Item));

    /*
    next step
    initialize hash table element(key,values) to zero */
    initialize_Array();  // call initialize_Array() function

    do
    {
        printf("Hash Table Implementation with Linear Probing  :\n");
        printf("1 : Insert item in the Hash Table              :\n");
        printf("2 : Remove item from the Hash Table            :\n");
        printf("3 : Search For item in the Hash Table          :\n");
        printf("4 : Display a Hash Table                       :\n");
        printf("5 : Check the size of Hash Table               :\n");
        printf("0 : Enter 0 to exit (quit)                     :\n");

        // asking user to enter choice
        printf("  : Input your choice                          :");
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


/** function to initialize hash table array */

void initialize_Array()
{
    int i; // counter variable declaration

    /* initialize hash table to zero */
	for (i = 0; i < capacity; i++)
    {
        hashArray[i].flag = 0;  //(flag = 0) mean data does not exist
        hashArray[i].data = NULL;
    }

} /** End of initialize_Array */


/** Hash function take one value(key) as argument
    and return a unique hash code to the given key */

int hashFunction(int key)
{
    return (key % capacity); // return unique hash code

} /**End of hashFunction */


/** A utility function to insert an element in the hash table(key , value */

void insert(int key, int value)
{
	// first step : get the hash code
	int hashIndex = hashFunction(key); // call hashFunction()
	int i = hashIndex; //counter i is equal to  hashIndex

    /*
    second step create new item to insert in the hash table array
    allocate memory dynamically for new_item using malloc C */
    struct Data_Set* new_item = (struct Data_Set*) malloc (sizeof(struct Data_Set));

    if(new_item == NULL) /* Error handling */
    {
       printf("Error in allocating memory\n");
       return;
    }
    new_item -> key  = key;    // set key at key filed
    new_item -> value = value; // set value at value filed

    /* probing through the array until we reach an empty space */
    while (hashArray[i].flag == 1)
    {
       /* case when the key is Already at ith index in table */
       if(hashArray[i].data -> key == key)
       {
           /*
           by now we are sure the given key is already present
           in the hash table so let updated */
           hashArray[i].data -> value = value;   /* update already existing value */
           printf("\nkey --> (%d) Value is been updated to (%d)\n",key, value);
           return; // we are done
       }
        i = (i + 1) % capacity; /* calculate the next index */

       	if (i == hashIndex) /* case when the hash table is full */
        {
            printf("\n Hash table is full!!\n");
		    return; // we are done
        }
    }
    /*
    by now we are sure the given key is not present in the hash
    table and hash table is not full so let insert it the new item */

    hashArray[i].flag = 1;          // update flag to be 1
    hashArray[i].data = new_item;   // insert the item
    size++;                         /* increment size by one */
    // inform user the element is been inserted
    printf("\nKey (%d) has been inserted \n", key);

} /** End of insert() */


/**
   Utility function to Remove(delete) given a key from hash table
   (To remove a key from hash table, we will first calculate its index
    and delete it if key matches,else probe through elements until we
    find key or an empty space where not a single data has been entered
    (means data does not exist in the hash table).*/

void remove_Item(int key)
{
    int hashIndex;  /* local variables declaration */

    // first step : get the hash code
	 hashIndex = hashFunction(key); // call hashFunction()
	 int i = hashIndex; // counter i is equal to  hashIndex

	 if (size_of_hashtable() == 0) /* case when the hash table is Empty */
    {
        printf("Hash Table is Empty!!!\n");
        return;
    }
    /* in else case iterate throw the hash table */

    /*
    next step probing through hash array until we reach an empty space
    where not even once an element had been present until then search for the key */
    while (hashArray[i].flag != 0)
    {
        if (hashArray[i].flag == 1 && hashArray[i].data -> key == key)
        {
            // case when data key matches the given key
            hashArray[i].flag =  2;  // update flag to 2 ( mean data existed at least once)
            hashArray[i].data = NULL;// delete the data
            size--;                  // decrement size by one
            printf("\n Key (%d) has been removed \n", key); // inform user the element is been Removed
            return;
        }

        i = (i + 1) % capacity; /* calculate the next index */

       	if (i == hashIndex) /* case when we are in forever loop*/
        {
            printf("This key does not exist in the hash table!!!\n");
            printf("\n All the  has table been searched now we are in forever loop!!\n");
		    return; // we are done
        }
    }

    /* case when the key not present in table */
    printf("This key does not exist in the hash table!!!\n");

} /** End of remove_Item() */


/**  Utility function to Search For item with given key from hash table */

void search_Item(int key)
{
    int hashIndex;  /* local variables declaration */

    // first step : get the hash code
    hashIndex = hashFunction(key); // call hashFunction()
    int i = hashIndex; // counter i is equal to  hashIndex

    if (size_of_hashtable() == 0) /* case when the hash table is Empty */
    {
        printf("Hash Table is Empty!!!\n");
        return;
    }
    /* in else case iterate throw the hash table */

    /*
     probing through hash array until we reach an empty space
    where not even once an element had been present until then search for the key */
    while (hashArray[i].flag != 0)
    {
        if (hashArray[i].flag == 1 && hashArray[i].data -> key == key)
        {
            /* case when the key present in table */
            printf("\nan Item with Key (%d) is  : (%d) \n", key , hashArray[i].data -> value);
            return ;
        }

        i = (i + 1) % capacity; /* calculate the next index */

       	if (i == hashIndex) /* case when we are in forever loop*/
        {
            printf("\nThis key does not exist in the hash table\n");
            printf("\n All the  has table been searched now we are in forever loop!!\n");
		    return; // we are done
        }
    }

    /* case when the key not present in table */
    printf("This key does not exist in the hash table!!!\n");


} /** End of search_Item() */


/**
   Utility function to traverse array(hash table)
    and display all the elements of a hash table */

void display()
{
    int i; /* counter variable declaration */
    struct Data_Set *current; /* local variable of type Data_Set*/

    if (size_of_hashtable() == 0) /* case when the hash table is Empty */
    {
        printf("Hash Table is Empty!!!\n");
        return;
    }
    // else case iterate throw the hash table
    for (i = 0; i < capacity; i++)
    {
        // current is now point to hashArray[i].data
        current = (struct Data_Set*)hashArray[i].data;
        if (current == NULL) // empty idex
        {
            printf("\n hash table [%d] has no elements \n", i);
        }
        else
        {
            printf("\n hash table [%d] has elements --> :"
                   "key (%d) and value (%d) \t\n", i, current ->key, current -> value);
        }
    }

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
