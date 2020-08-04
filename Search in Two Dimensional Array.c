
 /**
    [AUTHOR]: Saddam Arbaa
    [Email] : <saddamarbaas@gmail.com>

   C  search in two dimensional Array

    write c Program  that ask user to enter 2 number one
     for number of rows and one for number of columns
    ( both must be bigger than zero) then do the flowing

   (1) create 2 dimensional array with number of rows and
     columns given

   (2) ask user to enter all the 2 D array element and store
      them in an array.

  (3) Print the elements stored in the array

  (4)  ask user to enter number to be search in the Array
       then store user given number in variable name key and
       preform search operations( user want to know if the key
       exist in  matrix  or not so as soon as we found the key
       first time break don to continue)

 (5)  Print message to user and inform if the given key is found
     in the array or not  */



#include <stdio.h>
#include <stdlib.h>

// the  Driver Code
int main()
{

    // variable for Rows and columns will be entered by user
    int row, colum;

    // variable i,j I will use them in loop as counter
    int i, j;

    // variable key to store user entered value
    int key = 0;

    int flag = 0; // if flag value is 0 then number is not found
                // if flag value is change to 1 then number is found

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

    /* 2D array declaration with size of(row) rows and (column)columns
       the array within which number to be search */

    int matrix [row][colum] ;

    printf("-------------------------------\n");

    // taking input from user and storing it in an array(matrix)

    // outer loop to access rows
    for(i = 0; i < row; i++)
    {
          // inner loop to access coulmn
        for(j = 0; j < colum; j++)
        {
            // asking input from user
            printf("Enter matrix [ %d ][ %d ] : ",i,j);

            // The use of '&' before a variable name,mean user input will
            // be store in the address of matrix[i][j].

            scanf("%d",& matrix[i][j]);
        }
    }

    printf("-------------------------------\n");

    printf("element in matrix  Array are : \n");

    // printing elements of an array
    // outer loop to access rows
    for(i = 0; i < row; i++)
    {
        // inner loop to access coulmn
        for(j = 0; j < colum; j++)
        {
            printf("%d\t", matrix[i][j]);
        }

        // print new line after every row
        printf("\n");
    }

    // asking user to enter  the value to be searched
    printf("Enter a value to be search : ");
    scanf("%d", &key);

    // searching for key in the  an array

    // make i = 0  in the beginning
     i = 0 ;

    // outer loop to access rows
    while(i < row && flag == 0)
    {
        // make j = 0 each time start loop
        j = 0;

        // inner loop to access column
        while(j < colum && flag == 0)
        {
            if(matrix[i][j] == key) // is found
            {
                flag = 1; // change flag to one and break
                break; // we are done no need to continue
            }

            // increment j
            j = j + 1;// j++
        }

        // increment i
        i = i + 1; // i++

    }

    // printing the search result

    if(flag == 1)
    printf("Yes number %d is found in array",key);

    else
    printf("NO number %d is not found",key);


        /*
          the search loop  above can written in different way
          using for loop also
        */

    return 0;// signal to operating system everything works fine

}/** End of main function */
