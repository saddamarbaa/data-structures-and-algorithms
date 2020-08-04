
/*
[AUTHOR]: Saddam Arbaa
[Email] : <saddamarbaas@gmail.com>

  Two Dimensional Array in C
  in C we can create an array of arrays
  (defined as an array of arrays).
  These arrays are known as multidimensional arrays
  because A two-dimensional array is an array in which
  each element is itself a 1-D array

  The syntax to declare the 2D array
  data_type array_name[rows][columns]; */


#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    /* 2D array declaration with 4 rows and 4 columns. */
    int AA[4][4];

    // Different ways to initialize two-dimensional array in c
    int c[2][3] = {{4, 12, 6}, {0, 15, 8}};

     int u[][3] = {{1, 3, 2}, {-11, 15, 19}};

     int p[2][3] = {{1, 2, 0, },{-1, 5, 9}};

      /* 2D array declaration with 3 rows and 4 columns. */
      int B[3][4] = {

         {10, 1, 2, 33} ,   /*  initializers for row indexe 0 */

         {43, 5, 6, 17} ,   /*  initializers for row indexed  1 */

         {6, 9, 0, 21}   /*  initializers for row indexed  2 */
         };

     //traversing 2D array
      // access rows of the array
     for(int i = 0; i < 4; i++)
     {
         // access columns of the array
         for(int j = 0; j < 3; j++)
         {
             printf("array B[ %d] [%d] = %d \n",i,j,B[i][j]);
         } //end of j
     } //end of i

     return 0;// signal to operating system everything works fine

}/** End of main function */
