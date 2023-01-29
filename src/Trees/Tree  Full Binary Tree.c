/**
    [PROGRAM] :  Full Binary Tree
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>
    C Program to Check if a binary tree is a full binary tree */

#include <stdio.h>
#include <stdlib.h>
#include "stdbool.h"

// Binary Tree node Representation
struct Node
{
    int data;  /* data filed */
    struct Node * right; /* right child */
    struct Node * left;  /* left child */
};

/* Pointer to ROOT node // (root of tree) */
struct Node *root = NULL; // root is null now have created empty tree

/*  Function to create binary tree node */
struct Node *CreateNewNode(int);

// Function to add new value to binary tree on the left of the node
struct Node* insert_Left(struct Node* rootNode, int);

// Function to add new value to binary tree on the Right of the node
struct Node* insert_Right(struct Node* rootNode, int);

// Function to print nodes in Inorder traversal
void Inorder_traversal(struct Node* rootNode);

// Function to print nodes in Preorder traversal
void Preorder_traversal(struct Node *rootNode);

// Function to print nodes in Postorder traversal
void Postorder_traversal(struct Node *rootNode);

// return true if  Full Binary, return false in otherwise
bool is_Full_Binary_Tree(struct Node *rootNode);

int main()  /* the river Code */
{
    printf("C Program to Check if the Binary Tree is Full Binary Tree Or Not");
    printf("Binary Tree Linked List Representation \n");

    // create root node(insert node at Root)
    root = CreateNewNode(11); // call CreateNewNode() function

    // insert nodes at left
    insert_Left(root, 12);          // call insert_Left()

    // insert nodes at right
    insert_Right(root, 14);           // call insert_Right()

    printf("Inorder traversal of Binary Tree : \n");
    Inorder_traversal(root);  // call Inorder_traversal()

    printf("\nPreorder traversal of Binary Tree : \n");
    Preorder_traversal(root); // call Preorder_traversal()

    printf("\nPostorder traversal of Binary Tree : \n");
    Postorder_traversal(root); // call Postorder_traversal()

    /* NOW Check if the Tree is Full Binary Tree */
    if (is_Full_Binary_Tree(root)) /* call is_Full_Binary_Tree() */
        printf("\nYES this Binary tree is a full binary tree\n");
    else
        printf("\nNO NO this Binary tree is not a full binary full!!!\n");

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
 * function to Check if a Binary Tree is Full Binary Tree
 * Given a Binary Tree,the task is to check whether the given binary tree
 * is Full Binary Tree or not.
 * Full Binary Tree is a binary in which all nodes have either 0 or 2 children
   return true if BST, return false in otherwise */

bool is_Full_Binary_Tree(struct Node *rootNode)
{
    if (rootNode == NULL) // case when tree is Empty
      return true;

  // case when  Both right tree are Not Empty
  if (rootNode -> left == NULL && rootNode -> right == NULL)
      return true;

   /*now let check */  // Recursive Call
  if ((rootNode -> left) && (rootNode -> right))
       return (is_Full_Binary_Tree(rootNode -> left) &&
               is_Full_Binary_Tree(rootNode -> right));


  // if reach this line return false
  return false;

} /** End of is_Full_Binary_Tree()*/


/** A utility function to create new Binary Tree Node */

struct Node* CreateNewNode(int value )
{
    // local variable of type struct Node declaration */
    struct Node  *newNode;

    // allocate memory dynamically for node using malloc C function
    newNode = (struct Node *)malloc (sizeof(struct Node));
    if(newNode == NULL) /* error handling */
    {
        printf("Error in allocating memory\n");
    }

    // adding information to node
    newNode -> data = value;
    newNode -> right = NULL;
    newNode -> left = NULL;

    return newNode;  // return newly created node to place where it been be called

} /** END of CreateNewNode() */


// Function to add new value to binary tree on the left of the node */

struct Node *insert_Left(struct Node* rootNode, int value)
{
    struct Node  *newNode;
    newNode =  CreateNewNode(value); // call function to create new nod  now node is ready to add
    rootNode -> left = newNode;    // insert the node at left
    return rootNode -> left;      // return root -> left to be updated

} /** END of insert_Left() */


// Function to add new value to binary tree on the Right of the node

struct Node* insert_Right(struct Node* rootNode, int value)
{
    struct Node  *newNode;
    newNode =  CreateNewNode(value); // call function to create new nod  now node is ready to add
    rootNode -> right = newNode;   // insert the node at right
    return rootNode -> right;      // return root -> left to be updated

} /** END of insert_Right() */


/**
 *  Preorder traversal   : [root]  [left] [right]
 *  Given a binary tree, print its nodes in  Preorder
 *
 * in  Preorder traversal  we start  from root of tree
 * first  print data of root   then second step visit left subtree and print all the element
 * and thirdly visit right sub tree and print all the element
 *
 *   Algorithm  Preorder  traversal
       * 3  step blow
       *  Visit root node
       *  Visit all the nodes in the left subtree
       * Visit all the nodes in the right subtree */

void  Preorder_traversal(struct Node *rootNode)
{
    // base condition for recursion
	// if tree/sub-tree is empty, return and exit
    if (rootNode == NULL)
        return;

    printf("%d -> ", rootNode ->data);           /* first print the data from root  */

    Preorder_traversal(rootNode -> left);   /* Visit left subtree  */

    Preorder_traversal(rootNode -> right);    /* Visit right subtree */

} /** End of Preorder_traversal() */


/**
 * Inorder traversal   : [left]  [root] [right]
 *   Algorithm  Inorder traversal
       * First, visit all the nodes in the left subtree
       *  Then the root node
       *   Visit all the nodes in the right subtree
       *   all of this visiting happen recursively */

void Inorder_traversal(struct Node *rootNode)
{
	// base condition for recursion
	// if tree/sub-tree is empty, return and exit
    if (rootNode == NULL)
        return;

    Inorder_traversal(rootNode -> left);   /* first Visit left subtree  */
    printf("%d -> ",rootNode -> data);           /* then print the data  */
    Inorder_traversal(rootNode -> right);    /* Visit right subtree */

} /** END OF Inorder_traversal() */


/**
 *   Postorder traversal   : [left] [right] [root]

 *   Algorithm Postorder  traversal
       * 3  step blow
       *  Visit all the nodes in the left subtree
       * Visit all the nodes in the right subtree
       *  Visit root node (so root node will print as last element) */

void Postorder_traversal(struct Node *rootNode)
{
	// base condition for recursion
	// if tree/sub-tree is empty, return and exit
    if (rootNode == NULL)
       return;

    Postorder_traversal(rootNode -> left);   /* Visit left subtree  */
    Postorder_traversal(rootNode -> right);    /* Visit right subtree */
    printf("%d -> ",rootNode -> data);           /*  print the data from root  */

} /** END OF Postorder_traversal() */
