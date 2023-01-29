/**
    [PROGRAM] :  Binary Tree Array Representation
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

  Implementing Binary Trees Linear or Array Representation
  This method is easy to understand and implement.
  It's very useful for certain kinds of tree applications, such as heaps,
  and fairly useless for others. It's typically used on dense binary trees.
  The idea is simple: there are two ways I will flow the first way below
    * take a complete binary tree and number its nodes from top to bottom, left to right.
    * The root is 0, the left child 1, the right child 2, the left child of the left child 3, etc.
    * Put the data for node i of this tree in the ith element of an Array.
    * If you have a partial(incomplete) binary tree, and node i is absent,
       put some value that represents "no data" in the ith position of the array.

 * Three simple formula allow you to go from the index of the parent to the index of its children and vice versa:

    * if index(parent) = N, index(left child) = 2 * N + 1
    * if index(parent) = N, index(right child) = 2 * N + 2
    * if index(child) = N, index(parent) = (N - 1)/2 (integer division then we take flower value)

* The advantage of the linear representation is this easy traversal up and down, and efficient use of space
* if the tree is complete. The disadvantage is inefficient use of space if the tree is sparse.
*
* first way is done
*    now the second way is almost same only small different its below
    *  take a complete binary tree and number its nodes from top to bottom, left to right.
    * The root is 1, the left child 2, the right child 4,  etc.
    * Put the data for node i of this tree in the ith element of an Array.
    * If you have a partial (incomplete) binary tree, and node i is absent, put some value that represents
    *  "no data" in the Ith position of the array.

    * Three formula are there for this also:
    * if index(parent) = i, index(left child) = ( 2 * i )
    * if index(parent) = i, index(right child) = ( 2 * i ) + 1
    * if index(child) = i, index(parent) = (i)/2 (integer division then we take flower value)

    * however for this program i will flow the first way

    * for reference  link blow (Jenny's lectures CS/IT NET&JRF) very well explain of both ways
     https://youtu.be/zDlTxrEwxvg */

#include <stdio.h>
#include <string.h>
#include "stdlib.h"

// char array of 10 declarations
char tree[10];

// Function to insert root node
void root_Node(char key);

// Function to insert left child node
void left_Child(char key, int parent);

// Function to insert right child node
void right_Child(char key, int parent);

// Function to traverse the tree
void traverse_Tree(void);

int main()  /* the river Code */
{
    printf("Binary Tree Array Representation \n");

    //(insert node at Root)
    root_Node('A');

    // insert nodes
    right_Child('C', 2);
    left_Child('D', 0);
    right_Child('E', 1);
    right_Child('F', 2);

    // traverse the tree
    traverse_Tree();

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
 * insert root node at  first index of array if array is empty
*/

void root_Node(char key)
{
   if(tree[0] != '\0')

    printf("Tree already had root\n");
     else
      tree[0] = key;

} /** end of rootnode() */


/**
 * leftchild node
 * insert (left child) =  at  [(parent * 2) + 1] of array
 **/

void left_Child(char key, int parent)
{
   if(tree[parent] == '\0')
      printf("Can't set  left child at  %d  no parent found\n",(parent * 2) + 1);
   else
      tree[(parent * 2) + 1] = key;

} /** END of leftchild() */


/**
 * Right child node
 * insert (right child) =  at  [(parent * 2) + 2] of array
 **/

void right_Child(char key, int parent)
{
   if(tree[parent] == '\0')

   printf("Can't set right child at  %d  no parent found\n",(parent * 2) + 2);

   else
      tree[(parent * 2) + 2] = key;

} /** END OF right_Child() */


/** function to traverse Binary tree  */

void traverse_Tree()
{
   printf("\n");

   for(int i = 0; i < 10; i++)
   {
       if(tree[i] != '\0')
         printf("%c\t",tree[i]);

      else
          printf("-\t");
   }
   printf("\n");

} /** END of traverse_Tree()  */
