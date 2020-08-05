/**
   [PROG]   : Linear Search Algorithm with example (functions approach) 

   [AUTHOR] :  Saddam Arbaa

   [Email]  :  <saddamarbaas@gmail.com>

     C program to read elements into an array and find the
     largest two elements in a given array. */

 
#include <stdio.h>
#include <stdlib.h>

int MAXSIZE = 10; // maximum Array size

int size ; // array size which will be entered by user

//traverse Array and insert All the values at once
void traverse(int vector[]);

// traverse Array and display all element
void Display(int vector[]);

//traverse Array get me largest and second largest element
void  two_largest_element(int vector[]);

// the  Driver Code
int main()
{
    // Array declaration
    int vector[MAXSIZE];

    // traverse Array and insert All the values at once
    traverse(vector); // call traverse function

    // traverse Array and print All values
    Display(vector); // call display function

   // traverse Array get me largest
   // and second largest element
    two_largest_element(vector);

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
    function to search in the given vector array
    and get largest and second number in the array

    here are the steps

(1)  save the values of the first element of array in the variable ‘largest’
     and second element in the variable ‘second-largest
(2)  swap between ‘largest’ and second-largest if  its required.
(3)  Now run the loop from the third element of the array to the last element.
(4)  Scan element of the array, comparing array elements with the first
     largest and second-largest numbers, changing both or one if its required.
(5)  In the end, after for loop, print largest and second-largest numbers

*/

void two_largest_element(int vector[])
{
    // variable for largest and second largest number
    int largest = 0, second_largest = 0;

    //underflow condition if array is less than 2
     if (size < 2)
     {
         printf("Array have less than two number!\n");
         return;
     }

     // set in largest the first element of array
     largest = vector[0];

     // set in second-largest the second element of array
     second_largest = vector[1];

     /* if second-largest value is bigger than largest value swap them */
     if (second_largest > largest)
     {
         swap(&largest, &second_largest); //swap them
     }

     // search loop start from third value until size -1
     for (int i = 2; i <= size - 1; i++)
     {
         // if so do the flowing
         if (vector[i] > largest)
         {
             // set in second-largest value of largest first
             second_largest = largest;

             // then set in largest value of vector[i]
             largest = vector[i];
         }
         // if so update secondLargest only
         else if (vector[i] > second_largest && vector[i] != largest)
         {
             // update value of secondLargest
             second_largest = vector[i];
         }

     }/** End of for loop */

    printf ("The FIRST LARGEST ELEMENT IN ARRAY IS = %d\n", largest);
    printf ("THE SECOND LARGEST ELEMENT IN ARRAY IS = %d\n", second_largest);


}/** End two_largest_element() */


/**
  function to swap values of two variables
 (user should pass address of two as parameter)*/

void swap(int *a, int *b)
{
    // declare temp variable
    int temp;
    // store in temp value of a
    temp = *a;
    // store in a value of b
    *a = *b;
    // store in b value of a(we have value of variable a stored in temp)
    *b = temp;

    // swap is done
}/** End of swap () */
