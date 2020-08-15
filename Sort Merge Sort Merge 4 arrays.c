/**
    [PROGRAM] :  Merge 4 Sorted Arrays
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Merge the Elements of 4 Sorted Array

   	Write C Program that to take sizes of 4 arrays, A ,B ,C, D
   	from user and create 4 arrays A ,B ,C,D with the size given
   	by user for each array (size must be bigger than 0 for all
    and less than maximum size which is 50)

    then do the flowing

   (1)  Create fifth array named "ABCD" with enough size
        that can store arrays A ,B ,C, D
        (ABCD size = size of A + size of B + size of C + size of D)
   (2)  create 2 temp arrays AB and CD
   (3)  ask user to enter elements in sorted order for arrays( A ,B ,C, D )
        and store them in an array A , B, C, D
   (4)  Merge the Elements of A,B, in Array AB in sorted order
   (5)  Merge the Elements of C,D, in Array CD in sorted order
   (6)  lastly Merge the Elements of AB,CD,in final Array ABCD in sorted order
   (4)  Print the elements stored in the array A
   (5)  Print the elements stored in the array B
   (6)  Print the elements stored in the array C
   (7)  Print the elements stored in the array D
   (8)  Print the elements stored in the array AB
   (9)  Print the elements stored in the array CD
   (10) Print the elements stored in the array ABCD */

#include <stdio.h>
#include <stdlib.h>

// define the maximum Array size
#define MAXSIZE 50

/* function to Valid size for array */
int get_Valid_Size(int);

/* function to traverse Array and insert it values */
void traverse(int[], int, char );

/* function to traverse Array and display all it element */
void print_Array(int[], int , char* );

/* function to Merge 2 Sorted Arrays in one sorted Array */
void Merge(int [], int [], int [], int , int );

// the  Driver Code
int main()
{
    printf("C Program to Merge 4 Sorted Arrays in one sorted array :\n\n");

    /*
    variables declaration */
    int i, A_Size, B_Size, C_Size, D_Size, ABCD_Size ;

    // declaration of 5 Arrays A,B,C,D,Merge-Array
    int A [MAXSIZE / 4];
    int B [MAXSIZE / 4];
    int C [MAXSIZE / 4];
    int D [MAXSIZE / 4];
    int ABCD [MAXSIZE];

    /* get valid size for Array A  */
    A_Size = get_Valid_Size('A');   /* call get_Valid_Size() */

    /* get valid size for Array B */
    B_Size = get_Valid_Size('B');   /* call get_Valid_Size() */

    /* get valid size for Array C*/
    C_Size = get_Valid_Size('C');   /* call get_Valid_Size() */

    /* get valid size for Array D */
    D_Size = get_Valid_Size('D');   /* call get_Valid_Size() */

    // Calculate size for ABCD
    ABCD_Size = A_Size + B_Size + C_Size + D_Size;

    /* traverse Array A and insert All the values at once */
    traverse(A, A_Size, 'A');  /*call traverse()*/

    /* traverse Array B and insert All the values at once */
    traverse(B, B_Size,'B'); /* call traverse() */

    /* traverse Array C and insert All the values at once */
    traverse(C, C_Size,'C'); /* call traverse() */

    /* traverse Array D and insert All the values at once */
    traverse(D, D_Size,'D');  /* call traverse() */

    // create 2 temp arrays
    int AB[A_Size + B_Size]; // this to merge A and B
    int CD[C_Size + D_Size]; // this to merge C and C

    /* first let Merge Array A,B in new array name AB[] */
    Merge(A, B, AB, A_Size, B_Size); // call merge() function*/

    /*then Merge Array C,D in new array name CD[] */
    Merge(C, D, CD, C_Size, D_Size); // call merge() function*/

    /* now let merge four of them A,B,C,D in final array ABCD */
    Merge(AB, CD, ABCD,(A_Size + B_Size),(C_Size + D_Size)); // call merge() function*/

    /* traverse Array A and display it element */
    print_Array(A, A_Size, "A");   /* call print_Array() */

    /* traverse Array B and display it element */
    print_Array(B, B_Size, "B");  /*call print_Array()*/

    /* traverse Array C and display it element */
    print_Array(C, C_Size,"C");   /* call print_Array()*/

    /* traverse Array D and display it element */
    print_Array(D, D_Size, "D");   /*call print_Array()*/

    /* traverse Array AB and display it element */
    printf("After Merging A and B :");
    print_Array(AB, (A_Size + B_Size), "AB");

    /* traverse array CD and display it element */
    printf("After Merging C and D : ");
    print_Array(CD, (C_Size + D_Size), "CD");

    /* traverse ABCD and display element for fianl array */
    printf("After Final Merging ABCD : ");
    print_Array(ABCD, (ABCD_Size), "Final ABCD");

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
  function to traverse array and initialize it value by the value
  inserted by user(take input from user and storing it in an array)
  traversing mean visiting every element in the array exactly once
*/

void traverse(int array [], int size, char C)
{
    // counter variable declaration
    int i;

    printf("Enter %d sorted elements for array %c : \n", size, C);
    // taking input from user and storing it in given array
    for (i = 0; i <= size - 1; i++)
     {
         /* The use of '&' before a variable name,mean user
           input will be store in the address of variable. */

          // taking input from user and storing it in an array
          printf("Enter %c[ %d ]: ",C, (i + 1));
          scanf("%d",&array[i]);

     } /** End of for loop */


} /** End of traverse()  */

/**
  function to get valid size for given array, the valid  size here
  is positive number bigger than zero and less than maximum array size
*/

int get_Valid_Size(int A)
 {
     // variable declaration
     int size;

    // get valid size for Array
    do
    {
        // asking the length of array from user
        printf("Enter size for Array -->  %c "
               ":\n(size must be bigger than zero and las than or equal to %d): ",A, MAXSIZE);
        scanf("%d", &size);

    } while(size <= 0 || size > MAXSIZE);

    /* if its reach this line already got the valid size just return */
    return size;

 } /** END of get_Valid_Size */


/**
  function to traverse the Sorted Arrays A, B and
  Merge them in Array C in sorted order
*/

void Merge(int A[], int B[], int C[], int m, int n)
{
    /* m is the size of array A */
    /* n is the size of array B */

    // counter variables declaration
    int i, j, k;

    /* initialize all the counters by zero(start from zero index) */

    i = 0;     /*  i is the counter for Array A */
    j = 0;     /*  j is the counter for Array B */
    k = 0;    /*   k is the counter for Array C */

    /** Merge process start from here */

   /*continue loop Until we reach end of either arrays A or B  */
    while (i < m  && j < n)
    {
        /*
        Compare their element first then them merge them
        in array C[] in sorted order */

        if ( A[i] < B[j])
        {
            C[k] = A[i]; /* filling the array C with the smaller element */

            i++; //increment i

            //also can written just like this C[k++] = A[i++];
        }
        else
        {
            C[k] = B[j];  /* filling the array  C with the smaller element */

            j++; //increment j

            //also can written just like this C[k++] = B[j++];
        }

        k++; /* increment counter k here as it will be incremented in both cases */

    } /** End of while loop */

    /*  Copy the remaining elements if there are any */
    for ( ; i < m ; i++) /* case when array[A] have remaining element */
    {
        C[k++] = A[i];
    }

    /*  Copy the remaining elements if there are any */
    for ( ; j < n; j++) /* case when array[B] have remaining element */
    {
        C[k++] = B[j];
    }

} /** end of Merge() */




/**
    function to print elements of an array
   (user should pass the array and size as parameter) */

void print_Array(int array[], int size, char* C)
{
    // counter variable declaration
    int i;

    // printing elements of an array B
    printf("\nArray %s   : \n",C);
    for (i = 0; i <= size - 1; i++)
    {
        printf("%d\t",array[i]);
    } /** End of for loop */
    printf("\n");

} /** End of printArray() */
