/**
    [AUTHOR]: Saddam Arbaa
    [Email] : <saddamarbaas@gmail.com>

   C two dimensional Arrays Examples

   write c Program that do the flowing

  (1) create 2 dimensional array size of (4) rows and (4)columns (called matrix)

  (2)  ask user to enter all the 2 D array element and store them in matrix array.

  (3)  Print the elements stored in the matrix array

  (4) create one D array (named vector) and store in newly created
      vector the sum of number in each row of 2D matrix Array

 (5)  Print the elements stored in the vector array */


#include <stdio.h>

#include <stdlib.h>

// the  Driver Code
int main()
{

    /* 2D array declaration with 4 rows and 4 columns. */
    int matrix[4][4];

    /* one D array declaration with size(4) I will use to store
       the sum of numbers in each row of 2 D Array  */
    int vector[4];

    /*  variable k I will use it as counter while taking sum of
        each row from matrix array and store to vector array */
    int k = 0;

    // variable i,j I will use them in loop as counter
    int i, j;

    // variable to store sum of each row numbers
    int sum_of_each_row;

    printf("-----------------------\n");

    printf("Enter All the numbers :\n");

     // taking input from user and storing it in an array(matrix)

    // outer loop to access rows
    for(i = 0; i < 4; i++)
    {
        /*
           make sum_of_eachrow variable to zero after
           calculate and printing sum of each row */

        sum_of_each_row = 0;

        // inner loop to access column
        for(j = 0; j < 4; j++)
        {
            // asking input from user
            printf("Enter matrix [ %d ][ %d ] : ",i,j);

            // The use of '&' before a variable name,mean user input will
            // be store in the address of matrix[i][j].

            scanf("%d",& matrix[i][j]);

            // calculation the sum of each row
             sum_of_each_row = sum_of_each_row + matrix[i][j];

        }

        // we are done with this row let store
        vector[k] = sum_of_each_row;

        // after storing sum of each row increment vector counter

        k = k + 1; // k++
    }

    printf("---------------------------\n");

    printf("matrix Array contain these values : \n");

    // printing elements of an array
    // outer loop to access rows
    for(i = 0; i < 4; i++)
    {
        // inner loop to access coulm
        for(j = 0; j < 4; j++)
        {

            printf("%d\t", matrix[i][j]);
        }

        // print new line after every row
        printf("\n");
    }

    printf("----------------------\n");

    printf("vector Array contain these values :  \n");

     // printing elements of vector array

    for(i = 0; i < 4; i++)
    {
       printf("%d\t",vector[i]);
    }
    printf("\n");

    return 0;// signal to operating system everything works fine

}/** End of main function */
