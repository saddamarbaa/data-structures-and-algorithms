/**
     [AUTHOR]: Saddam Arbaa
     [Email] : <saddamarbaas@gmail.com>

     Program of  Two Dimensional Array in C
     declaration  and initialization */


#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    /* 2D array declaration with 4 rows and 5 columns. */
    int matrix[3][5];

    // accessing 2 D array element
    //we have change value in first row and first column to 6
    matrix[0][0] = 6;

    //we have change value in second row and third column to 3
    matrix[1][2] = -3;

    //we have change value in third row and fifth column to 3
    matrix[2][4] = 100;

    //let update values for all first row element
    matrix[0][0] = 1;
    matrix[0][1] = 2;
    matrix[0][2] = 3;
    matrix[0][3] = 4;
    matrix[0][4] = 5;

    //let update values for all second row element
    matrix[1][0] = 6;
    matrix[1][1] = 7;
    matrix[1][2] = 8;
    matrix[1][3] = 8;
    matrix[1][4] = 10;

    //let update values for all third row element
    matrix[2][0] = 11;
    matrix[2][1] = 12;
    matrix[2][2] = 13;
    matrix[2][3] = 14;
    matrix[2][4] = 15;

    // print all the element in first row
    printf("matrix[0][0] : %d\n",matrix[0][0]);

    printf("matrix[0][1] : %d\n",matrix[0][1]);

    printf("matrix[0][2] : %d\n",matrix[0][2]);

    printf("matrix[0][3] : %d\n",matrix[0][3]);

    printf("matrix[0][4] : %d\n",matrix[0][4]);

    // print all the element in second row
    printf("matrix[1][0] : %d\n",matrix[1][0]);

    printf("matrix[1][1] : %d\n",matrix[1][1]);

    printf("matrix[1][2] : %d\n",matrix[1][2]);

    printf("matrix[1][3] : %d\n",matrix[1][3]);

    printf("matrix[1][4] : %d\n",matrix[1][4]);

    // print all the element in third row
    printf("matrix[2][0] : %d\n",matrix[2][0]);

    printf("matrix[2][1] : %d\n",matrix[2][1]);

    printf("matrix[2][2] : %d\n",matrix[2][2]);

    printf("matrix[2][3] : %d\n",matrix[2][3]);

    printf("matrix[2][4] : %d\n",matrix[2][4]);

    /* at last now we can ask user to enter new value */
    //  we use  nested for loop for that

    // taking input from user and storing it in an array(matrix)
    // outer loop to access rows
    for(int row = 0; row < 3; row++)
    {
          // inner loop to access coulm
        for(int coulm = 0; coulm <  5; coulm++)
        {
            // asking input from user
            printf("Enter matrix [ %d ][ %d ] : ",row,coulm);

            // The use of '&' before a variable name,mean user input will
            // be store in the address of matrix[row][coulm].

            scanf("%d",& matrix[row][coulm]);
        }
    }


    printf("--------------------------------------\n");

    printf("All the new value entered by user are : \n");

     // printing elements of an array
    // outer loop to access rows
    for(int row = 0; row < 3; row++)
    {
        // inner loop to access coulm
        for(int coulm = 0; coulm < 5; coulm++)
        {

            printf("matrix [ %d [ %d ] : %d\n",row,coulm,matrix[row][coulm]);
        }

    }

     return 0;// signal to operating system everything works fine

}/** End of main function */




