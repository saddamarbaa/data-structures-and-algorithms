
/**
   [PROG]   : Search for largest number in Array

   [AUTHOR] :  Saddam Arbaa

   [Email]  :  <saddamarbaas@gmail.com>

     C program to read N elements into an array and find the
     largest number in a given array. */


#include <stdio.h>
#include <stdlib.h>

int MAXSIZE = 10; // maximum Array size

int size ; // array size which will be entered by user

//traverse Array and insert All the values at once
void traverse(int vector[]);

// traverse Array and display all element
void Display(int vector[]);

//traverse Array get me the largest number
int largest(int vector[]);

// the  Driver Code
int main()
{
    // variable to store the largest number
    int largestNumber;

    // Array declaration
    int vector[MAXSIZE];

    // traverse Array and insert All the values at once
    traverse(vector); // call traverse function

    // traverse Array and print All values
    Display(vector); // call display function

    //traverse  vector array and get me the largest number
    largestNumber = largest(vector);

    // print the largest number to user
    printf("largest number is %d\n",largestNumber);

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
    function to search for largest number in the given
    vector array and returned

    here are the steps
(1)  save the value of the first element of array in the variable ‘largest’
(3)  Now run the loop from the second element of the array to the last element.
(4)  Scan element of the array, comparing array elements with the largest
    and change largest value if its required.
(5)  In the end, after for loop,  return  largest

*/

int largest(int vector[])
{
    // variable for largest
    int largest;

     // set in largest the first element of array
     largest = vector[0];

     // search loop start from the second value until size -1
     for (int i = 2; i <= size - 1; i++)
     {
         // if the value at vector[i] index  bigger than largest
         if (vector[i] > largest)
         {
             // update
             largest = vector[i];
         }
    }/** End of for loop */

    // return the largest number to place where is been called
    return largest;

}/** End largest() */

