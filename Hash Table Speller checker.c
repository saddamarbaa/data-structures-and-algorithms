/**
    [PROGRAM] :  Speller(speller checker)
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    CS50X 2020 Problem Set 5 Speller Implementation.
    Speller is the a program that Implements a dictionary's functionality
    speller check for word in dictionary

    Links to the Week 5 lecture
    CS50 2019 - Lecture 5 - Data Structures
    https://youtu.be/4IrUAqYKjIA

    link to the Week 5 Walkthrough : Problem Set 5
    https://youtu.be/BBtMS8G0QbM

    Links to the Problem Set
    https://cs50.harvard.edu/x/2020/psets/5/speller/#:~:text=~cs50/2019/fall/pset5/speller%20texts/lalaland.txt */

#include <stdbool.h>
#include "dictionary.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>  /* include string.h Header file */
#include <strings.h> /* include strings.h Header file */
#include <ctype.h>  /* include ctype.h Header file */

// Represents a node in a hash table
typedef struct node
{
    char word[LENGTH + 1];
    struct node *next;
}
node;

/*
head pointer point to the first element
of Linked List at an index of Hash Table
(head node,also called first node) */
node *Head = NULL;

/* Global define maximum Hash Table
  capacity and initialization to 997(997 is prime number)*/
#define HASHTABLE_SIZE 997

/* Global array(hash table) declaration*/
node *table[HASHTABLE_SIZE];

/* Global declaration of Hash Table size and initialization
  to zero (number of word present in Hash Table */
int word_count = 0;

// Returns true if word is in dictionary else return false

bool check(const char *word)
{
    int len = strlen(word);      // calculate the length
    char copy_word[LENGTH + 1];  // creating char array

    /* iterate over the given word and convert to lower cases */
    for (int i = 0; i < len; i++)
    {
        copy_word[i] = tolower(word[i]);
    }
    // Adds null terminator to end string
    copy_word[len] = '\0';

    // get the hash code
    unsigned int index = hash(copy_word); // call hash() function

    // Initializes cursor to point to given index by hashFunction
    node *cursor = table[index];

    /* while not yet reach NULL search for word in dictionary */
    while (cursor != NULL)
    {
        // compute case-insensitive comparison once
        // If strcasecmp returns true, then word has been found
        if (strcasecmp(cursor -> word, word) == 0)
        {
            return true;
        }
        {
            // Else word has not yet been found, move cursor to next node
            cursor = cursor -> next;
        }
    }
    // if reach this line the word not been found in dictionary so it must be misspelled just return false
    return false;

} /** End of check()*/


// Hashes word to a number
// Hashes the word (hash function posted on reddit by delipity)
// so all the credit to delipity

unsigned int hash(const char *word)
{
    unsigned int hash = 0;
    for (int i = 0, n = strlen(word); i < n; i++)
    {
        hash = (hash << 2) ^ word[i];
    }
    return hash % HASHTABLE_SIZE; // return a unique hash code to the given word

} /** END of hash() */


// Loads dictionary into memory, returning true if successful else return false

bool load(const char *dictionary)
{
    // first step Open dictionary file
    FILE *file = fopen(dictionary, "r");

    // throw error if the file can't be open for any reason
    if (file == NULL)
    {
        printf("Could not open %s.\n", dictionary);
        unload();
        return false; // signal that program not successes
    }
    // creating char array to store data of file
    char word[LENGTH + 1];

    /*
    second step(scan dictionary word by word)
    iterate over the given dictionary file and read one
    word each time until reach the end of file*/
    while (fscanf(file, "%s", word) != EOF)
    {
        // next step is to create new node
        // allocate memory dynamically for node using malloc C function
        node *new_node = malloc(sizeof(node));
        if (new_node == NULL) /* Error handling */
        {
            printf("Error in allocating memory\n");
            unload();
            return false; // signal that program not successes
        }
        /* add information to node */
        strcpy(new_node -> word, word); // Copies word into node if malloc succeeds
        new_node -> next = NULL;        // next is NULL for now

        /* next step is to insert the node into hash table */

        // get the hash code
        unsigned int index = hash(new_node -> word); // call hash() function

        // Initializes head to point to given index by hashFunction
        Head = table[index];

        // Handle the corner cases
        if (Head == NULL) /* check if list is empty then this node is the first node */
        {
            /** link changes */
            table[index] = new_node;  // insert first node in list
            word_count++;              /* increment hash size by one*/
        }
        else
        {
            /* if already some element are in the linked list
               let add the new node at the Beginning of the list*/

            /** link changes */
            new_node -> next = Head;   // right side connection first
            Head = new_node;            // left side connection second
            word_count++;              /* increment hash size by one */
        }
    }

    fclose(file);  // close file
    return true; // signal that program successes

} /** End of load() */


// Returns number of words in dictionary if loaded else 0 if not yet loaded

unsigned int size(void)
{
    return word_count;  // return number of the words in hash table

} /** End of size() */


// Unloads dictionary from memory, returning true if successful else false
bool unload(void)
{
    node *temp; // local variables of type node declaration */

    /* iterate over hash table */
    for (int i = 0; i < HASHTABLE_SIZE; i++)
    {
        // Initializes temp to point to the head node at i index
        temp = Head = table[i];

        /*
        while not yet reach NULL iterate over the linked  list
        and delete word one by one */
        while (Head != NULL)
        {
            // temp is only to uses in free memory process
            temp = Head;         // save Head in temp
            Head = Head -> next; // move Head to next node
            free(temp);         // now Delete temp using free() C function
        }
    }
    // now Delete both temp  and Head
    free(temp);
    free(Head);

    return true; // if reach this line  return true

} /** End of unload() */

