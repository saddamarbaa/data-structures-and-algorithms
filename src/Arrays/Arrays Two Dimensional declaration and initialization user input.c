/**
    [AUTHOR]: Saddam Arbaa
    [Email] : <saddamarbaas@gmail.com>

   C two dimensional  Arrays Examples
   Program  that ask user to enter 2 number one for number
   of rows and one for number of columns( both must be bigger
   than zero) then do the flowing

   (1) create 2 dimensional array with number of rows and
     columns given

   (2) ask user to enter all the 2 D array element and store
    them in an array.

  (3) Print the elements stored in the array
     (size must be bigger than 0)

*/

#include <stdio.h>

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

    /* 2D array declaration with (row) rows and (colum) columns. */
    int matrix [row][colum] ;

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

    printf("----------------------------\n");

    printf("element in matrix  Array are : \n");

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

    return 0;// signal to operating system everything works fine

}/** End of main function */





