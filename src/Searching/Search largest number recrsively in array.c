/**
   [PROG]   : Search for largest number in Array using Recursion

   [AUTHOR] :  Saddam Arbaa

   [Email]  :  <saddamarbaas@gmail.com>

     C Program to find the Biggest Number in an Array of Numbers
     using Recursion*/

#include <stdio.h>
#include <stdlib.h>

int MAXSIZE = 10; // maximum Array size

int size ; // array size which will be entered by user

//traverse Array and insert All the values at once
void traverse(int vector[]);

// traverse Array and display all element
void Display(int vector[]);

//traverse the Array and get the largest number
int largestNumbert(int vector[], int index, int largest);

// the  Driver Code
int main()
{
    // variable to store the largest number
    int largest;

    // Array declaration
    int vector[MAXSIZE];

    // traverse Array and insert All the values at once
    traverse(vector); // call traverse function

    // traverse Array and print All values
    Display(vector); // call display function

    if (size == 0)
    {
        printf("array is empty \n");
    }
    else
    {
        // at first assume first index to be largest value
        largest = vector[0];
        /*
         traverse the array and get me the largest number
          for that call  largestNumbert() function */
         largest = largestNumbert(vector, size - 1, largest);
         // print the largest number to user
         printf("\nThe largest number in the is: %d\n",largest);
    }

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
    array using Recursion and returned */

int largestNumbert(int array[],int position, int largest)
{
    /*
    base case condition when position == 0 indicate that we
    have compared all numbers in array with largest and now
    largest hold the biggest number so just return to where
    is been called */

    if (position == 0)
        return largest;

    /*
    as position is now equal size - 1 (last index) so compare value
    at position index with largest and update largest value if its
    required after that make recursive call and pass position - 1
    and new largest as parameters until position became equal to zero */

    if (array[position] > largest)
    {
        // update largest with new larges number found so far
        largest = array[position];
    }

    return largestNumbert(array, position - 1, largest); //recursive call


}/** End largestNumbert() */

