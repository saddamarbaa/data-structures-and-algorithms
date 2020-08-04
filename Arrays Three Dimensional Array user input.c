/** 
     Three Dimensional Array
     [AUTHOR]: Saddam Arbaa
     [Email] : <saddamarbaas@gmail.com>

     Three Dimensional Array declaration and initializing user input taking input from user
  */

#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{
    //declaration 3 variables to be use as counter in loop
    int i,j,k;

    /* 3D array declaration  */
    int matrix[2][3][3];

    // taking input from user and storing it in an array(matrix)
    printf("enter the values in the array: \n");

    // first loop represents block
	for(i = 0; i < 2; i++)
	{
	    // second loop represents rows
		for(j = 0; j < 3; j++)
		{
		    // third loop represents columns
			for(k = 0; k < 3; k++)
			{

                // The use of '&' before a variable name,mean user input will
                // be store in the address of matrix[i][j][k].

                // asking input from user
				printf("Enter matrix[ %d ][ %d ][ %d ]: ",i,j,k);
				scanf("%d",&matrix[i][j][k]);

			} /** End of third loop */
		} /** End of second loop */

	} /** End of first loop */

	printf("--------------------------\n");

    printf("element in matrix  Array are : \n");

    // first loop represents block
    for(i = 0; i < 2; i++)
    {
        // second loop represents rows
        for(j = 0; j < 3; j++)
        {
            // third loop represents columns
            for(k = 0; k < 3; k++)
            {
                printf("%d\t",matrix[i][j][k]);

            } /** End of third loop */

            printf("\n");

        }/** End of second loop */
        printf("\n");

    }/** End of first loop */

      return 0;// signal to operating system everything works fine

}/** End of main function */
