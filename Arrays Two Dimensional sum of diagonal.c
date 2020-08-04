
/**
    [AUTHOR]: Saddam Arbaa
    [Email] : <saddamarbaas@gmail.com>

   C two dimensional  Arrays Examples
   write C program that do the flowing :-

   (1) create 2 dimensional array named matrix with number of(4)rows
      and (4)columns   (int matrix [4][4];)

   (2) ask user to enter all the 2 D array element and store
      them in matrix array ,
      user must enter numbers bigger than zero for all element.

  (3) Print the elements stored in the  matrix array

  (4)  calculate The sum of elements on the diagonal , The sum of elements above the diagonal

  (5) at last Print the results of all sums which been calculated */



#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    /*
       (1)SOD  store The sum of elements on the diagonal
       (2)SAD  store The sum of elements above the diagonal in matrix Array
       (2)SUD to store The sum of elements under the diagonal in matrix Array
    */

    int SOD = 0;          // Diagonal سنخزن فيه قيم العناصر الموجودة على الـ SOD المتغير
    int SAD = 0;          // Diagonal سنخزن فيه قيم العناصر الموجودة فوق الـ SAD المتغير
    int SUD = 0;          // Diagonal سنخزن فيه قيم العناصر الموجودة تحت الـ SUD المتغير

    /* 2D array declaration of(4) rows and (4) columns. */
    int matrix [4][4];

    printf("--------------------------------------\n");
    printf("Enter All matrix Array element:\n");

    // taking input from user and storing it in an array(matrix)

    // outer loop to access rows
    for(int i = 0; i < 4; i++)
    {
          // inner loop to access coulm
        for(int j = 0; j < 4; j++)
        {
            // asking input from user
            printf("Enter matrix [ %d ][ %d ] : ",i,j);

            // The use of '&' before a variable name,mean user input will
            // be store in the address of matrix[i][j].

            scanf("%d",& matrix[i][j]);
        }
    }

    printf("------------------------------------\n");

    printf("matrix Array contain these values : \n");

    // printing elements of an array
    // outer loop to access rows
    for(int i = 0; i < 4; i++)
    {
        // inner loop to access coulm
        for(int j = 0; j < 4; j++)
        {

            printf("%d\t", matrix[i][j]);
        }

        // print new line after every row printed
        printf("\n");
    }

    printf("--------------------------------------\n");

    /*
     calculation the sum of numbers on the diagonal and numbers
     above the diagonal and numbers under the diagonal
     so to get here that in matrix (4 * 4)

     (1) the elements on the diagonal are always in index
         where row index is equal to column index

    (2) the elements above the diagonal are always in index
        where row index is smaller than column index

    (3)  the elements under the diagonal are always in index
         where row index is bigger than column index */

    // outer loop to access rows
    for(int i = 0; i < 4; i++)
    {
        // inner loop to access coulm
        for(int j = 0; j < 4; j++)
        {
            if (i == j)
            {
                //The sum of elements on the diagonal
                SOD = SOD + matrix[i][j];
            }
            else if (i < j)
            {
                //The sum of elements above the diagonal
                SAD = SAD + matrix[i][j];

            }
            else if(i > j)
            {
                 //The sum of elements under the diagonal
                 SUD = SUD + matrix[i][j];
            }
        } // inner for loop finish here

    } // outer for loop finish here


    printf("\n");
    printf("The sum of elements above the diagonal is : %d\n" ,SAD);
    printf("The sum of elements on the diagonal is :  %d\n", SOD);
    printf("The sum of elements under the diagonal is : %d\n",SUD);

    return 0;// signal to operating system everything works fine

}/** End of main function */


