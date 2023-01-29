/**
   [PROG]   : Search for second largest and second Smallest 
              number in Array

   [AUTHOR] :  Saddam Arbaa

   [Email]  :  <saddamarbaas@gmail.com>

    implemente C program  using a one dimentional array and sort
    the array in ascending order.Then it find the second largest
    and second smallest number in the array  also find the average of
    these two numbers. after that checks if the resultant
    average number is present in a given array or not.

    here are the steps
    1. Create one D array .
    2. sort the array in the ascending order.
    3. now after sort The second smallest number would be at second index
       and second largest number would would be the last second element of array.
    4. calculate the  average of these two numbers.
    5. lastly search for this average value in the array
    6 . if found inform user is found  and if not found inform user is not found
*/

#include <stdio.h>
#include <stdlib.h>

int MAXSIZE = 10; // maximum Array size

int size ; // array size which will be entered by user

//traverse Array and insert All the values at once
void traverse(int vector[]);

// traverse Array and display all element
void Display(int vector[]);

// function to swap values of two variables
void swap(int *a, int *b);


// the  Driver Code
int main()
{
    // declare variables
    int i, j, second_smallest, second_largest, average, flag;

    // Array declaration
    int vector[MAXSIZE];

    // traverse Array and insert All the values at once
    traverse(vector); // call traverse function

    // traverse Array and print All values
    Display(vector); // call display function

    /**  Insertion Sort in ascending order start here */
    // run two  loops
    //outer loop
    for (i = 0; i < size; ++i)
        {
            //inner loop for comparison
            for (j = i + 1; j < size; ++j)
            {
                // if so swap them for that call swap() function
                // To sort in descending order, change">" to "<"
                if (vector[i] > vector[j])
                {
                    //call swap function and pass addresses
                    swap(&vector[i], &vector[j]);
                }

            } /** End of inner loop */
        }/** End of outer loop */

    printf("\nArray is been sorted in ascending order\n");

    // traverse Array and print All values
    Display(vector); // call display function

    // save second smallest number on second_smallest
    second_smallest = vector[1];
    // save second biggest number on second_largest
    second_largest = vector[size - 2];

    // print the second largest number and the second smallest number
    printf("The second largest number is  = %d\n",second_largest);
    printf("The second smallest number is = %d\n", second_smallest);

    // Calculate the Average
    average = (second_smallest + second_largest) /2;

    // print the average
    printf("The average number is  %d\n",average);

    /** search for average in vector array start here */

    /*
     I use flag variable and give it value zero after search for average
     if flag value is still 0 then mean number is  average not found else
     if flag value is change to 1 then number is found  */

     flag = 0;

    /*
      for loop start from zero index until size - 1 index
      in array compare if the value of index[i] is equal to given
      key(average)  as soon we we have found the average change flag
      variable to 1 and break(out from loop) */

     for (i = 0; i <= size - 1; i++)
     {
         if (vector[i] == average)
         {
             flag = 1; // change flag to one and break

             // inform the user the key is found

             printf("Yes The average  %d is found at index : %d\n",average, i + 1);
             break; // we are done no need to continue
         }
     }/** End of for loop */

     // if reach this line and flag still zero key is not found
    if(flag == 0)
    // inform the user the key is not found
    printf("NO the average %d is not found!\n",average);

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
