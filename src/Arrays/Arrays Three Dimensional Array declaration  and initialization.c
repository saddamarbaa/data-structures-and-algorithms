/**
     Three Dimensional Array declaration  and initialization
     [AUTHOR]: Saddam Arbaa
     [Email] : <saddamarbaas@gmail.com>

     Syntax:
     data_type array_name[size1][size2][size3];

     Program of Three Dimensional Array in C
     declaration  and initialization
  */

#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    //declaration 3 variables to be use as counter in loop
    int i,j,k;

    /* 3D array declaration  */
    int array[2][3][3];

    /* 3D array declaration  and initialization */
    int threeD_Array[2][2][4] = {11, 3, 30, 15, 38, 9, -22, 24, 5, 10, 34, 56, 23, -256, 10, 37};

    /* 3D array declaration  and initialization */
     int secondArray[3][3][3]=
         { {{10,20,30},{40,50,60},{70,80,90}},    //elements of block 1
           {{11,22,33},{44,55,66},{77,88,99}},    //elements of block 2
           {{12,23,34},{45,56,67},{78,89,90}}     //elements of block 3
         };

    /* 3D array declaration  and initialization */
    int threeDArray[3][3][3]=
        {
            {//elements of block 1
            {11, 12, 13},
            {14, 15, 16},
            {17, 18, 19}
            },
            {//elements of block 2
            {21, 22, 23},
            {24, 25, 26},
            {27, 28, 29}
            },
            { //elements of block 3
            {31, 32, 33},
            {34, 35, 36},
            {37, 38, 39}
            },
        };

    printf("printing the 3D array element  : \n");

    // we need 3 for loop for this

    // first loop represents block
    for(i = 0; i < 3; i++)
    {
        // second loop represents rows
        for(j = 0; j < 3; j++)
        {
            // third loop represents columns
            for(k = 0; k < 3; k++)
            {
                printf("%d\t",threeDArray[i][j][k]);

            } /** End of third loop */

            printf("\n");

        } /** End of second loop */

        printf("\n");

    }/** End of first loop */


    return 0;// signal to operating system everything works fine

}/** End of main function */
