/**
    [PROGRAM] :  Binary Tree Linked List Representation
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com> */

#include <stdio.h>
#include <stdlib.h>

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

int main() /* the river Code */
{
    printf("Binary Tree Linked List Representation \n");

    // create root node(insert node at Root)
    root = CreateNewNode(11); // call CreateNewNode() function

    // insert nodes at left
    insert_Left(root, 12);          // call insert_Left()
    insert_Left(root -> left, 13);  // call insert_Left()

    // insert nodes at right
    insert_Right(root, 14);           // call insert_Right()
    insert_Right(root -> right, 15);  // call insert_Right()

    printf("Inorder traversal of Binary Tree : \n");
    Inorder_traversal(root);  // call Inorder_traversal()

    printf("\nPreorder traversal of Binary Tree : \n");
    Preorder_traversal(root); // call Preorder_traversal()

    printf("\nPostorder traversal of Binary Tree : \n");
    Postorder_traversal(root); // call Postorder_traversal()

    return 0;// signal to operating system everything works fine

}/** End of main function */


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


// Function to add new value to binary tree on the left of the node

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
