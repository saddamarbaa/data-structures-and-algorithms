/** 
     [AUTHOR]: Saddam Arbaa
     [Email] : <saddamarbaas@gmail.com>

     write C program that do the flowing

    (1)declare Two Dimensional Array  named matrix[3][3]

    (2) ask user to enter all the array element and store
        them in matrix array

    (3) Print the elements stored in the array

    (4) find the sum of numbers in each columns and printed

  */

#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    /* 2D array declaration with 3 rows and 3 columns. */
    int matrix[3][3];

    /* variable to store sum of numbers in each column
      i don,t give any value because in each loop start
       i will make it value to zero */

    int sum = 0;

    printf("Enter All the numbers :\n");

     // taking input from user and storing it in an array(matrix)

    for(int row = 0; row < 3; row++)
    {
        // inner loop to access column
        for(int coulm = 0; coulm <  3; coulm++)
        {
            // asking input from user
            printf("Enter matrix [ %d ][ %d ] : ",row,coulm);

            // The use of '&' before a variable name,mean user input will
            // be store in the address of matrix[row][coulm].

            scanf("%d",& matrix[row][coulm]);
        }
    }

    printf("--------------------------------------\n");
    printf("Element in Array are  :\n");

    // printing elements of an array
    // outer loop to access rows
    for(int row = 0; row < 3; row++)
    {
        // inner loop to access column
        for(int coulm = 0; coulm < 3; coulm++)
        {
            printf("%d\t",matrix[row][coulm]);
        }

        // new new after printing element in each row
        printf("\n");
    }

    // loop to calculate the sum of number in each
    // column and printed

    // outer loop to access rows
    for(int row = 0; row < 3; row++)
    {

        /*
           make sum variable to zero after calculate and
           printing sum of numbers each in column */

         sum = 0;

         // inner loop to access column
         for(int coulm = 0; coulm < 3; coulm++)
         {
            // calculation the sum of each row
            sum = sum + matrix[coulm][row];
         }

        printf ("the sum of  number in column [ %d ] : %d \n",(row + 1),sum);

    }
     return 0;// signal to operating system everything works fine

}/** End of main function */




