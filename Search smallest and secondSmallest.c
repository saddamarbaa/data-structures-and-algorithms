/**
   [PROG]   : Search for smallest and second-smallest number in Array

   [AUTHOR] :  Saddam Arbaa

   [Email]  :  <saddamarbaas@gmail.com>

     C program to read elements into an array and find the
     smallest two elements in a given array. */


#include <stdio.h>
#include <stdlib.h>

int MAXSIZE = 10; // maximum Array size

int size ; // array size which will be entered by user

//traverse Array and insert All the values at once
void traverse(int vector[]);

// traverse Array and display all element
void Display(int vector[]);

//traverse Array get me smallest and second smallest number
void  two_smallest_element(int vector[]);

// function to swap values of two variables
void swap(int *a, int *b);

// the  Driver Code
int main()
{
    // Array declaration
    int vector[MAXSIZE];

    // traverse Array and insert All the values at once
    traverse(vector); // call traverse function

    // traverse Array and print All values
    Display(vector); // call display function

   // traverse Array get me smallest
   // and second smallest numbers
    two_smallest_element(vector);

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
    and get the smallest and second smallest number in the array

    here are the steps

(1)  first save the values of the first element of array in the variable smallest
     and second element in the variable ‘second-smallest
(2)  swap between ‘smallest’ and second-smallest if  its required.
(3)  Now run the loop from the third element of the array to the last element.
(4)  Scan element of the array, comparing array elements with the first
     smallest and second-smallest numbers, changing both or one if its required.
(5)  In the end, after for loop, print smallest and second-smallest numbers

*/

void two_smallest_element(int vector[])
{
    // variable for smallest and second smallest number
    int smallest = 0, second_smallest = 0;

    //underflow condition if array is less than 2
     if (size < 2)
     {
         printf("Array have less than two number!\n");
         return;
     }

     // set in smallest the first element of array
     smallest = vector[0];

     // set in second-smallest the second element of array
     second_smallest = vector[1];

     /* if second_smallest value is smaller than smallest value swap them */
     if (second_smallest < smallest)
     {
         swap(&smallest, &second_smallest); //swap them
     }

     // search loop start from third value until size -1
     for (int i = 2; i <= size - 1; i++)
     {
         // if so do the flowing
         if (vector[i] < smallest)
         {
             // set in second_smallest value of smallest first
             second_smallest = smallest;

             // then set in smallest value of vector[i]
             smallest = vector[i];
         }
         // if so update second_smallest only
         else if (vector[i] < second_smallest && vector[i] != smallest)
         {
             // update value of secondLargest
             second_smallest = vector[i];
         }

     }/** End of for loop */

    printf ("The FIRST SMALLEST ELEMENT IN ARRAY IS = %d\n", smallest);
    printf ("THE SECOND SMALLEST ELEMENT IN ARRAY IS = %d\n", second_smallest);


}/** End two_smallest_element() */


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
