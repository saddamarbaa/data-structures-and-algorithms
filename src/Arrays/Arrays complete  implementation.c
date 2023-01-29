/**

[PROG]	   :  Array  implementation

[AUTHOR]   :   Saddam Arbaa

[Email]    :  <saddamarbaas@gmail.com>

        C program for Array Implementation

*/


#include <stdio.h>

#include <stdlib.h>


/*  define the maximum Array size */
#define MAXSIZE 25

/* global declaration  of array size which will be entered by user */
int size;

/* traverse Array and insert All the values at once */
void traverse(int vector[]);

/* traverse Array search for given key */
void search(int vector[]);

/* traverse Array and insert element at specific position */
void insert_at_position(int vector[]);

/* traverse Array and insert element at beginning */
void insert_at_beginning(int vector[]);

/* insert element at end of array */
void insert_at_end(int vector[]);

/*  traverse Array and display all element */
void Display(int vector[]);

/* traverse Array and delete element at specific position */
void delete_at_position(int vector[]);

/* delete  element at end of array */
void delete_at_end(int vector[]);

/* traverse Array and delete element at beginning */
void delete_at_beginning(int vector[]);


// the  Driver Code
int main()
{

    // Array declaration
    int vector[MAXSIZE];

    while(1)
    {
        printf("\nArray Implementation (Array Operation in C)          : \n");
        int ch;    //for switch  to choose choice
        int element; // element
        printf("1 : traverse Array and insert All the elements once  : \n");
        printf("2 : Search value in Array                            : \n");
        printf("3 : insert element at specific position in array     : \n");
        printf("4 : insert element at the beginning of array         : \n");
        printf("5 : insert element at the end of array               : \n");
        printf("6 : Array traverse (print all the element):\n");
        printf("7 : delete element at the specific position in array : \n");
        printf("8 : delete element at the beginning of array         : \n");
        printf("9 : delete element at the end of array               : \n");
        printf("0 : quit                                             :\n");
        // asking user for choice first
        printf("input your choice                                    :");
        scanf("%d",&ch);

        switch (ch)
        {
           // case 1  traverse Array and insert All the values at once
            case 1 :
                traverse(vector); // call traverse function
            break;

            // case 2   traverse Array and search for given key
            case 2:
                search(vector);// call search(vector) function
            break;

            // case 3   traverse Array and insert element at specific position
            case 3  :
                insert_at_position(vector); // call insert_at_position function
            break;

            // case 4   traverse Array and insert element at beginning(in zero index)
            case 4  :
                insert_at_beginning(vector); // call insert_at_beginning(); function
            break;

            // case 5   traverse Array and insert element at end(in size index)
            case 5  :
                insert_at_end(vector); // call insert_at_end(vector); function
            break;

            // case 6  traverse Array and display all element
            case 6 :
                Display(vector); // call display function
            break;

            // case 7   traverse Array and delete element at specific position
            case 7 :
               delete_at_position(vector); // call delete_at_position(vector) function
            break;

            // case 8   traverse Array and delete element at beginning
            case 8  :
                delete_at_beginning(vector); // call delete_at_beginning(vector) function
            break;

            // case 9 delete element at end of array
            case 9  :
                delete_at_end(vector); // call  delete_at_end(vector) function
            break;

             // case 0 is exit case
            case 0 :
               printf("time to exit thanks\n");
              _Exit(0);

            // default case
            default:
                printf("\n invalid input\n");

            break; // no need break after default case but I used only for readability

     } /* End of switch */
    }// End while loop */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to traverse vector array and initialize it value
  by the value inserted by user
  (take input from user and storing it in an array)
  traversing mean vsiting every element in the array exactly once
*/

void  traverse(int vector[])
{
    // counter
    int i;
    do
    {
        // asking  the length of array from user
        printf("Enter the length of the vector :\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d",&size);

    } while (size <= 0 || size > MAXSIZE);

    printf("--------------------------------------\n");
    printf("Enter the elements one by one %d numbers \n",size);

     // taking input from user and storing it in an array
     for (i = 0; i <= size - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.

          printf("Enter vector[ %d ]: ",(i+1) );
          scanf("%d",&vector[i]);
     }

     Display(vector); //call print function
 } /** End of traverse() */



 /**
    function to print elements of an array Accept one parameters
   ( user should pass the array as parameter) */

void Display(int vector[])
{
    // counter
    int i;

     if (size == 0) // underflow condition
     {
         printf("Array is empty(no elements to print) !\n");
         return;
     }
     printf("elements in Array are :\n");

     // printing elements of an array
     for (i = 0; i <= size - 1; i++)
     {
         printf(" %d\t", vector[i]);
         // printf("vector[ %d ] :  %d\n", i + 1, vector[i]);

     }
     printf("\n");

 } /** Display() function */



/**
  function to insert element at specific position in array
  take array as parameter then ask user to enter the position
  and value first check if the position is valid (p < 0 || p > size +1 )
   then the value will be inserted
   time complexity for this function as we shifting element

   best case O(1)
   wrest case O(n)
   or can say O(n - p) where p is the position

   because this array is unsorted we can also simple
   write like this
   vector[size] = vector[]
   vector[position - 1] = value;
   no shifting or for loop need it
   just this two line and we are done  in time complexity of
   constant time O(1)
   (in general is O(n))
*/

void insert_at_position(int vector[])
{
    // declare two variable for position and value
    int position,value;

    // asking user to enter the value
    printf("enter the value you want insert : ");
    scanf("%d",&value);

    // asking user to enter the position
    printf("enter the position at which you want insert the value %d  : ", value);
    scanf("%d",&position);

     //overflow condition array is full
     if(size > MAXSIZE)
     {
         printf("overflow condition  Array is full the maximum size is  %d  : ",MAXSIZE);
         return;
     }
     // check if the position is valid or not
     if (position < 0 || position > size + 1) // user flow condition
     {
         printf("invalid position) ?\n");
         return;
     }

    /*
      for loop start from size - 1 until given position - 1
      shift vector[i] to vector[i + 1](vector[i + 1] = vector[i];)
      after all element are shifted now position is empty we can
      add the given value (vector[position - 1] = value)by now new
      element been added to array so need increment the size of array (size++;)
    */

     for (int i = size - 1; i >= position -1; i--)
     {
         vector[i + 1] = vector[i]; // shift the elements
     }

     vector[position - 1] = value; // add the value at the position
     size++; // increment the size by one

     //call print function
     printf("after insertion value %d ",value);
     Display(vector);

}/**  End insert_at_position() function  */


/**
  function to insert element at beginning of the  array
  take array as parameter insert_at_beginning(int vector[])
  to insert value at the beginning we have shift all the element
   first after that zero index will be empty then we can add
*/

void insert_at_beginning(int vector[])
{
    // declare variable for  value
    int value;

    // asking user to enter the value
    printf("enter the value you want insert in the beginning  :  ");
    scanf("%d",&value);

    // check if the Array is full or not
    if ( size > MAXSIZE)
     {
         printf("the Array  is full cant insert new element) !\n");
         return;
     }

    /*
      for loop start from size - 1 until firs index in array
      shift all the value in array first vector[i] to vector[i + 1]
      (vector[i + 1] = vector[i];)
      after all element are shifted now zero index is empty we can
      add the given value (vector[0] = value)by now new element been
      added to array so we need increment the size of array by one (size++;)
    */

     for (int i = size - 1; i >= 0; i--)
     {
         vector[i + 1] = vector[i]; // shift all the elements
     }

     vector[0] = value; // add the value at zero inex
     size++; // increment the size by one

    //call print function
     printf("after insertion value %d  at beginning ",value);
     Display(vector);

} /** End of  insert_at_beginning()  function*/



/**
  function to insert element at end of the  array
  take array as parameter insert_at_end(int vector[])
   to insert value at end very easy no need for loop
   or shifting we can directly add the element and increment
   size of array by one
*/

void insert_at_end(int vector[])
{
    // declare variable for  value
    int value;

    // asking user to enter the value
    printf("enter the value you want insert at the end  :  ");
    scanf("%d",&value);

    // check if the Array is full or not
    if ( size > MAXSIZE)
     {
         printf("the Array  is full cant insert new element) !\n");
         return;
     }

     // no for loop need it just direct inserting
      vector[size] = value; // add the value at last index

     size++; // increment the size by one

    //call print function
     printf("after insertion value %d  at end ",value);
     Display(vector);

}/** End insert_at_end() function */




/**
   function to delete element from specific position in array
   take array[] as parameter then ask user to enter the position

   first check if the position is valid then the value at the
   position will be delete and the decrement size of array by one

   time complexity for this function as we shifting element

   best case O(1)
   wrest case O(n)
   or can say O(n - p) where p is the position

   because this array is unsorted we can also simple
   write like this
   vector[position - 1] = vector[size];
   move the last element to place of element been delete
   just over write it
   and decrement size by one
   no shifting or for loop need it
   just this one line and we are done  in this case time complexity of
   constant time O(1)
   (in general is O(n))
*/


void delete_at_position(int vector[])
{
    /*
      declare two variable for position and temp I need to
      keep the element to be deleted in temp variable before
       deleting it so  can print later */

    int position,temp;

    // asking user to enter the position
    printf("enter the position from which you wan delete data : ");
    scanf("%d",&position);

     //underflow condition array is empty
     if (size == 0)
     {
         printf("Array is empty(no elements to to delete) !\n");
         return;
     }

    // check if the position is valid or not
    if (position <= 0 || position > size) // user flow condition
     {
         printf("invalid position) ! \n");
         return;
     }

     temp = vector[position - 1]; // keep data in temp before been deleted

    /*
      for loop start from given position - 1 until < size - 1
      shift vector[i + 1] to vector[i](vector[i] = vector[i + 1])
      after all element are shifted now the given position  allrday
      been overwritten

        so we just need decrement the size of array by (size--;)
    */

     for (int i = position - 1; i < size - 1; i++)
     {
         vector[i] = vector[i + 1]; // shift the elements( overwrite the given position)
     }

     size--; // decrement the size by one

     //call print function
     printf("after deleting value %d ",temp);
     Display(vector);

} /** End of delete_at_position() */



/**
  function to delete element at beginning of the  array
  take array as parameter delete_at_beginning(int vector[])
   to delete value at the beginning of array we have shift
   all the element from zero index  until lats index then the
   which to be deleted will be over written
   at last decrement the size by one

*/

void delete_at_beginning(int vector[])
{
    /* temp variable to keep the element to be deleted
       before deleting it so  can print later */

    int temp ;

    //underflow condition if  array is empty
     if (size == 0)
     {
         printf("Array is empty(no elements to to delete) !\n");
         return;
     }

     temp = vector[0]; // keep data in temp before been deleted

    /*
      for loop start from zero index until size - 1 index in array
      shift all the value in array vector[i + 1] to vector[i]
      (vector[i + 1] = vector[i];) after all element are shifted
       now zero index is been overwritten  so we need decrement
      the size of array by one (size++;) */

     for (int i = 0; i <= size - 1; i++)
     {
         vector[i] = vector[i + 1]; // shift all the elements(overwrite)
     }

     size--; // decrement the size by one

    //call print function
     printf("after deletion value %d  at beginning ",temp);
     Display(vector);

} /** End of delete_at_beginning() */


/*
   function to delete element at end of the array take array as
   parameter delete_at_end(int vector[]) to delete value at end of
   the array is very easy no need for loop and no shifting need it
   we only need decrement size of array by one and we are done

*/

void delete_at_end(int vector[])
{
    /* temp variable to keep the element to be deleted
       before deleting it so I can print later */

    int temp;

    //underflow condition if  array is empty
     if (size == 0)
     {
         printf("Array is empty(no elements to to delete) !\n");
         return;
     }

     temp = vector[size]; // keep data in temp before been deleted

     size--; // decrement the size by one

    //call print function
     printf("after deletion value %d  at end ",temp);
     Display(vector);

} /** End of delete_at_end() */


/**
    function to search if the given number from user is
    present in array or not
    */

void search(int vector[])
{
    // to store user entered value
    int key = 0;

    //underflow condition if array is empty
     if (size == 0)
     {
         printf("Array is empty!\n");
         return;
     }

     /* I use flag variable and give value zero after search
        for given key if flag value is still 0 then mean number
        is not found else if flag value is change to 1 then number
        is found */

     int flag = 0;

    // asking user to enter value
    printf("Enter a value to be search : ");
    scanf("%d",&key);

    /*
      for loop start from zero index until size - 1 index
      in array compare if the value of index is equal to given
      key to search as soon we we have the key change flag
      variable to 1 and break(out from loop)
       */

     for (int i = 0; i <= size - 1; i++)
     {
         if (vector[i] == key)
         {
             flag = 1; // change flag to one and break
             break; // we are done no need to continue
         }
     }/** End of for loop */

     // now check and inform the user found or not found
    if(flag == 1)
    printf("Yes number %d is found in array\n",key);

    else
    printf("NO   %d is not found in array\n",key);

} /** End of search()*/

