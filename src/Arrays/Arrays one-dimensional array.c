
/**
[AUTHOR]: Saddam Arbaa
[Email] : <saddamarbaas@gmail.com>

 C Arrays

 Arrays are used to store multiple values in a single variable,
 instead of declaring separate variables for each value.

 so An array is defined as the collection of similar type of data items
 stored at contiguous memory locations. Arrays are the derived data type
 in C programming language which can store the primitive type of data such
 as int, char, double, float, etc. It also has the capability to store
 the collection of derived data types, such as pointers, structure, etc.
 The array is the simplest data structure where each data element can be
 randomly accessed by using its index number.

By using the array, we can access the elements easily.

To declare an array, define the variable type, specify the
name of the array followed by square brackets and specify the
number of elements it should store:

*/

#include <stdio.h>
#include <stdlib.h>

int main()
{

    // Array declaration by initializing elements
     int fullmark[] = {5, 10, 20, 30, 40, 50, 60};

    // declare an array of user specified size
     int m = 100;
     int array[m];

     // Array declaration by specifying size and initializing elements
     int arr[7] = { 1, 2, 3, 4, 5};

   // Compiler creates an array of size 7, initializes first
   // 5 elements as specified by user and rest two elements as 0.
   // above is same as  "int arr[] = {1, 2, 3, 4, 5, 0,0}"

     int grde[5] = {100, 200, 300, 400, 500};

    /*You can also initialize an array like this.
      int grade[] = {100, 200, 300, 400, 500};
      Here, we haven't specified the size. However,
      the compiler knows its size is 5 as we are
      initializing it with 5 elements

     grde[0] is equal to 100
     grde[1] is equal to 200
     grde[2] is equal to 300
     grde[3] is equal to 400
     grde[4] is equal to 500

     */

     //Change Value of Array elements

     int grade[5] = {100, 200, 300, 400, 500};

      // make the value of the third element to 11
       grade[2] = 11;

      // make the value of the fifth element to 50
      grade[4] = 50;

      //Input and Output Array Elements

      // print the first element of the array
      printf("%d\n", grade[0]);

      // print the third element of the array
      printf("%d\n", grade[2]);

      // print ith element of the array
      //printf("%d", grade[i -1]);
 
   return 0;// signal to operating system everything works fine

}/** End of main function */
