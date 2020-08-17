
/**
    [PROGRAM] : Sort names in an alphabetical order
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C program to read N names from user,store them  in name array
    and sort them in alphabetical order.
    (1) : print the names before sort
    (2) : print the given names and the sorted
          names in two columns side by side. */

#include <stdio.h>
#include <stdlib.h>
// include string.h
#include <string.h>

// define the maximum Array size
#define MAXSIZE 50

// the  Driver Code
int main()
{
    printf("C program to sort an array of N names in an alphabetical order :\n\n");

   /* variables declaration */
    int i, j,  n;

    // 3 Array declaration
    char name[MAXSIZE][18],
         copy_name[MAXSIZE][18],
         temp[18];

    // get valid size for Array
    do
    {
        // asking the length of array from user
        printf("Enter size for Array -->  name "
               ":\n(size must be bigger than zero and las than or equal to %d): ", MAXSIZE);
        scanf("%d",&n);

    }while(n <= 0 || n > MAXSIZE);

    //taking input from user and storing it in name array
    printf("Enter %d names n \n", n);
    for (i = 0; i < n; i++)
    {
        printf("Enter name %d : ",i + 1);
        scanf("%s", name[i]);
        strcpy(copy_name[i], name[i]); // copy  all the names in copy array

    } /* End of for loop */

    /** sorting start from here*/

    // outer loop
    for( i = 0; i <= n - 2; i++)
    {
        // inner loop
        for(j = i + 1; j <= n - 1; j++)
        {
            /*
            using string function strcmp() to compare the names
            by their ASCII value and sorted in an alphabetical order
            */
            if(strcmp(name[i], name[j]) > 0) // if condition true
            {
                /*  swap between name[j] and name[i] by using
                    string function  strcpy() */
                strcpy(temp, name[i]);
                strcpy(name[i], name[j]);
                strcpy(name[j], temp);
            }
        } /** End of inner loop */

    } /** End of outer loop */

    // print the names befor sort
    printf("the names before sort are \n");
    for (i = 0; i < n; i++)
    {
        printf("%s\t", copy_name[i]);

    } /* End of for loop */
    printf("\n");

    // print the names after sort
    printf("the names after sorted in alphabetical order are \n");
    for (i = 0; i < n; i++)
    {
        printf("%s\t\t%s\n", copy_name[i], name[i]);

    }/* End of for loop */

    return 0;// signal to operating system everything works fine

}/** End of main function */
