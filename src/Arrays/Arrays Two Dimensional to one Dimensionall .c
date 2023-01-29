/**
    [AUTHOR]: Saddam Arbaa

    [Email] : <saddamarbaas@gmail.com>

   C two dimensional  Arrays Examples
   Program  that ask user to enter 2 numbers one for number
   of rows and one for number of columns( both must be bigger
   than zero) then do the flowing

   (1) create 2 dimensional array with number of rows and
     columns given(called matrix)

  (2)  ask user to enter all the 2 D array element and store
      them in matrix  array.

  (3) create one D array (named vector) and store in newly
      created vector array all the numbers in 2D matrix Array

  (4) Print the elements stored in the array matrix array
     (size must be bigger than 0)

 (5)  Print the elements stored in the vector array */


#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    // variable for Rows and columns will be entered by user
    int row,colum;

    // asking the length of number of rows from user
    do
    {
        // asking the length of number of rows from user
        printf("Enter the number of Rows\n(number of Rows must be bigger than zero): ");

        scanf("%d",&row);

    }while (row <= 0);

    // asking the length of number of rows from user
    do
    {
        // asking the length of number of rows from user
        printf("Enter the number of columns \n(number of columns must be bigger than zero): ");

        scanf("%d",&colum);

    }while (colum <= 0);

    /* 2D array declaration with (row) rows and (column) columns. */
    int matrix [row][colum];

    /* one D array declaration with size of (row * column)
     because i will store all the numbers in 2 D Array in
     this one D array latter */

    int vector[row * colum];

    /* variable k I will use it as counter while taking
        number from matrix array and store to vector array */

    int k = 0;

    printf("--------------------------------------\n");

    // taking input from user and storing it in an array(matrix)

    // outer loop to access rows
    for(int i = 0; i < row; i++)
    {
          // inner loop to access coulm
        for(int j = 0; j < colum; j++)
        {
            // asking input from user
            printf("Enter matrix [ %d ][ %d ] : ",i,j);

            // The use of '&' before a variable name,mean user input will
            // be store in the address of matrix[i][j].

            scanf("%d",& matrix[i][j]);
        }
    }

    // taking numbers from  array(matrix) storing it in array(vector)

    // outer loop to access rows
    for(int i = 0; i < row; i++)
    {
          // inner loop to access column
        for(int j = 0; j < colum; j++)
        {
            // store in vector[k] index the matrix[i][j] index value;
            vector[k] = matrix[i][j];

            // after storing it increment vector counter
            k = k + 1;
        }
    }

    printf("-------------------------\n");

    printf("matrix Array contain these values : \n");

    // printing elements of an array
    // outer loop to access rows
    for(int i = 0; i < row; i++)
    {
        // inner loop to access coulm
        for(int j = 0; j < colum; j++)
        {
            printf("%d\t", matrix[i][j]);
        }
        // print new line after every row
        printf("\n");
    }

    printf("-------------------------\n");

    printf("vector Array contain these values :  \n");

    // printing elements of vector array
    for(int i = 0; i < (row * colum); i++)
    {
       printf("%d\t",vector[i]);
    }
    printf("\n");

    return 0;// signal to operating system everything works fine

}/** End of main function */
