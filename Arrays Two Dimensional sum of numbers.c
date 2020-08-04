
/**
     [AUTHOR]: Saddam Arbaa
     [Email] : <saddamarbaas@gmail.com>

     write C program that do the flowing

    (1) declare Two Dimensional Array  named matrix[3][3]

    (2) ask user to enter all the array element and store
        them in matrix array

    (3) Print the elements stored in the array

    (4) find the sum of n numbers which entered by user

    (5) print the sum

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

    printf("Enter All the numbers :\n");

    // taking input from user and storing it in an array(matrix)
    for(int row = 0; row < 3; row++)
    {
        // inner loop to access coulmn
        for(int coulm = 0; coulm <  3; coulm++)
        {
            // asking input from user
            printf("Enter matrix [ %d ][ %d ] : ",row,coulm);

            // The use of '&' before a variable name,mean user input will
            // be store in the address of matrix[row][coulm].

            scanf("%d",& matrix[row][coulm]);

            // calculation the sum of all numbers
            sum = sum + matrix[row][coulm];
        }
    }

    printf("-----------------------------\n");

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



