/**
   [PROG]   : Linear Search Algorithm with example (functions approach)
   
   [AUTHOR] :  Saddam Arbaa
   
   [Email]  :  <saddamarbaas@gmail.com>
   
    Linear Search(sequential search) Algorithm implementation using  C */

#include <stdio.h>

#include <stdlib.h>

int MAXSIZE = 10; // maximum Array size

int size ; // array size which will be entered by user

//traverse Array and insert All the values at once
void traverse(int vector[]);

// traverse Array and display all element
void Display(int vector[]);

//traverse Array search for given key
int  Linear_Search(int vector[], int key);

// the  Driver Code
int main()
{
    printf("Linear Search implementation(functions approach) :\n\n");
    // key to store the key element and
    //index for index of the key in array
    int key = 0, index;

    // Array declaration
    int vector[MAXSIZE];

    // traverse Array and insert All the values at once
    traverse(vector); // call traverse function

    // traverse Array and print All values
    Display(vector); // call display function

    // asking user to enter value to be search
    printf("Enter a value to be search : ");
    scanf("%d",&key);

    // traverse Array and search for given key
    index = Linear_Search(vector, key);// call search(vector) function
    // now check and inform the user found or not found
    if(index != -1)
    printf("Yes %d is found at index : %d\n",key, index + 1);
    else
    printf("NO %d is not found!\n",key);

  return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to traverse vector array and initialize it value
  by the value inserted by user
  (take input from user and storing it in an array)
  traversing mean visiting every element in the array exactly once
*/

void traverse(int vector[])
{
    do
    {
        // asking  the length of array from user
        printf("Enter the length of the vector :\n(size must be bigger than zero and las than or equal to %d): ",MAXSIZE);
        scanf("%d",&size);

    } while(size <= 0 || size > MAXSIZE);

    printf("----------------\n");
    printf("Enter %d values : \n",size);

     // taking input from user and storing it in an array
     for (int i = 0; i <= size - 1; i++)
     {
         // The use of '&' before a variable name,mean user input will
         // be store in the address of variable.
          printf("Enter vector[ %d ]: ",(i+1) );
          scanf("%d",&vector[i]);

     } /** End of for loop */

}/** End of traverse() */


 /**
    function to print elements of an array Accept one parameters
   ( user should pass the array as parameter) */

void Display(int vector[])
{
     if (size == 0) // underflow condition
     {
         printf("Array is empty(no elements to print) !\n");
         return;
     }
     printf("Elements in Array are :\n");

     // printing elements of an array
     for (int i = 0; i <= size - 1; i++)
     {
         printf(" %d\t", vector[i]);
        // printf("vector[ %d ] :  %d\n", i + 1, vector[i]);

   } /** End of for loop */
   printf("\n");

}/** End of traverse() */


/**
    function to search if the given number from user is
    present in array or not
     the function take 2 parameters
    (1) array vector[]
    (2) target element named key
    if the key been found in array return the index of the key in vector array
    if is not found  then return -1 indicate the given key is not present in the Vector array */

int Linear_Search(int vector[] , int key)
{
    //underflow condition if array is empty
     if (size == 0)
     {
         printf("Array is empty!\n");
         exit(0);
     }
     // search until size -1
     for (int i = 0; i <= size - 1; i++)
     {
         // base case
         if (vector[i] == key)
         {
             return i;// we are done no need to continue return the index
         }
     }/** End of for loop */

    /*
    if reach this line mean been searching until last index
    and the key is not found so let just return -1 to indicate
    that the key is not found */
    return -1;//key is not found in the array

}/** End of Linear_Search() */

