/** 
     [AUTHOR]: Saddam Arbaa
     [Email] : <saddamarbaas@gmail.com>

     write C program that do the flowing

    (1)declare Two Dimensional Array  named matrix[3][3]

    (2) ask user to enter all the array element and store
        them in matrix array

    (3) Print the elements stored in the array

     (4) find the sum of  numbers in each row and printed

    (4) find the sum of all numbers which entered by user

    (5) print the sum of all number at last

  */


#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    /* 2D array declaration with 3 rows and 3 columns. */
    int matrix[3][3];

    // variable to store sum of all numbers
    int sum = 0;

    // variable to store sum of each row numbers
    int sum_of_each_row;

    printf("Enter All the numbers :\n");

     // taking input from user and storing it in an array(matrix)

    for(int row = 0; row < 3; row++)
    {
        /*
           make sum_of_eachrow variable to zero after
           calculate and printing sum of each row */

        sum_of_each_row = 0;

        // inner loop to access coulmn
        for(int coulm = 0; coulm <  3; coulm++)
        {
            // asking input from user
            printf("Enter matrix [ %d ][ %d ] : ",row,coulm);

            // The use of '&' before a variable name,mean user input will
            // be store in the address of matrix[row][coulm].

            scanf("%d",& matrix[row][coulm]);

            // calculation the sum of each row
             sum_of_each_row = sum_of_each_row + matrix[row][coulm];

            // calculation the sum of all number
             // sum = sum + matrix[row][coulm];
            // also we can calculate outside like blow

        }

        printf ("the sum of row number [ %d ] : %d \n",(row + 1),sum_of_each_row);

        // calculation the sum of all number
        sum = sum + sum_of_each_row;
    }

    printf("\n");

    printf("--------------------------------------\n");

    // printing elements of an array
    // outer loop to access rows
    for(int row = 0; row < 3; row++)
    {
        // inner loop to access coulm
        for(int coulm = 0; coulm < 3; coulm++)
        {
            printf("matrix [ %d [ %d ] : %d\n",row,coulm,matrix[row][coulm]);

        }
    }

    // printing the sum of numbers
    printf("The sum of all elements is : %d\n",sum);

     return 0;// signal to operating system everything works fine

}/** End of main function */

