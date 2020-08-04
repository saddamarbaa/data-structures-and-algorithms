/**
    Pointers and 2-D Array Examples

    [AUTHOR]: Saddam Arbaa
    [Email] : <saddamarbaas@gmail.com>

     program to access two dimensional array using pointer.
     Examples show  Relationship Between 2 D Arrays and Pointers */


#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    /* 2D array declaration (3) rows and (3) columns. */
    int array[3][3] = {  {1,2,3},
                         {4,5,6},
                         {7,8,9}  };

    // pointer to an array of 3 integers
    int (*ptr)[3];

    // now ptr have the base address of array
    ptr = array;

    /*
    array       =>    Points to base address of two-dimensional array.
                        Since array decays to pointer.
    *(array)      =>    Points to first row of two-dimensional array.

    *(array + 0)   =>    Points to first row of two-dimensional array.
    *(array + 1)   =>    Points to second row of two-dimensional array.

    **array      =>    Points to array[0][0]

    *(*(array + 0))       =>       Points to array[0][0]
    *(*(array + 0) + 0)   =>       Points to array[0][0]
    *(*array + 1)         =>       Points to array[0][1]
    *(*(array + 0) + 1)   =>       Points to array[0][1]
    *(*(array + 2) + 2)   =>       Points to array[2][2]

    and so on */

    printf("----------------------------------\n");

    // taking input from user and storing it in an array using pointers)

    // outer loop to access rows
    for(int i = 0; i < 3; i++)
    {
        // inner loop to access column
        for(int j = 0; j < 3; j++)
        {
            // asking input from user
            printf("Enter Array [ %d ][ %d ] : ",i,j);

             //  *(array + i) + j = equivalent to &array[i][j]

            scanf("%d",*(array + i) + j);

        }
    }

    printf("---------------------------------\n");

    printf("Element in matrix  Array are : \n");

    // printing elements of an array
    // outer loop to access rows
    for(int i = 0; i < 3; i++)
    {
        // inner loop to access column
        for(int j = 0; j < 3; j++)
        {
            //  *( *(ptr + i) + j) = equivalent to array[i][j]
            printf("Array[ %d ][ %d ] = %d\n", i, j, *( *(ptr + i) + j) );
        }

        // print new line after every row
        printf("\n");
    }

     return 0;// signal to operating system everything works fine

}/** End of main function */
