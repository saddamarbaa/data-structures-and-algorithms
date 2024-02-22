/**
   [PROG]   : Search for smallest number in Array

   [AUTHOR] :  Saddam Arbaa

   [Email]  :  <saddamarbaas@gmail.com>

     C program to read N elements into an array and find the
     smallest number in a given array. */

#include <stdio.h>
#include <stdlib.h>

int MAXSIZE = 10; // maximum Array size

int size ; // array size which will be entered by user

//traverse Array and insert All the values at once
void traverse(int vector[]);

// traverse Array and display all element
void Display(int vector[]);

//traverse Array get me the smallest number
int smallest(int vector[]);

// the  Driver Code
int main()
{
    // variable to store the smallest number
    int smallestNumber;

    // Array declaration
    int vector[MAXSIZE];

    // traverse Array and insert All the values at once
    traverse(vector); // call traverse function

    // traverse Array and print All values
    Display(vector); // call display function

    //traverse the vector array and get me the smallest number
    smallestNumber = smallest(vector);

    // print the smallest number to user
    printf("the smallest number is %d\n",smallestNumber);

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
    // get valid size first
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
    function to search for smallest number in the given
    vector array and returned

    here are the steps
(1)  save the value of the first element of array in the variable ‘smallest’
(3)  Now run the loop from the second element of the array to the last element.
(4)  Scan element of the array, comparing array elements with the smallest
    and change smallest value if its required.
(5)  In the end, after  the for loop,  return  smallest
*/

int smallest(int vector[])
{
    // variable for smallest
    int smallest;

     // set in smallest the first element of array
     smallest = vector[0];

     // search loop start from the second value until size -1
     for (int i = 1; i <= size - 1; i++)
     {
         // if the value at vector[i] index smaller than smallest
         if (vector[i] < smallest)
         {
             // update the smallest value
             smallest = vector[i];
         }
    }/** End of for loop */

    // return the smallest number to place where is been called
    return smallest;

}/** End smallest() */

