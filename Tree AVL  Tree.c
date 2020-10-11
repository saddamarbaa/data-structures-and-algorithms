/**
    [PROGRAM] :  AVL tree - Implementation
    [AUTHOR]  :  Saddam Arba
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Implement AVL tree
    AVL tree is a self-balancing Binary Search Tree(BST)
    in which each node maintains extra information called
    a balance factor whose value is either -1, 0 or +1.
    calculate Balance factor of a node in an AVL tree using formula blow
    Balance Factor = height(left subtree) - height(right subtree)
    or height(right subtree) - height(left subtree)
    For an AVL tree,the absolute value of balance factor for any node
    can't be greater than 1 i.e., each node must have a balance factor
    of either -1, 0 or 1.
    Instead of calculating heights of nodes, again and again
    we store the current heights in each node.
    AVL tree got its name after its inventor (Adelson-Velskii and Landis).

   Reference in future :---->
   https://youtu.be/TBadaja07R0
   https://youtu.be/NA43jWj5Fpg
   https://youtu.be/jlMYJz4Qchw
   https://youtu.be/UkOfaKI9vvY
   https://youtu.be/mRGQylRWAsI
   https://youtu.be/TbvhGcf6UJU
   https://youtu.be/NLAguPJgh_c
   https://youtu.be/YWqla0UX-38
   https://youtu.be/_8qqlVH5NC0
   https://youtu.be/LXdi_4kSd1o
   https://www.geeksforgeeks.org/avl-tree-set-2-deletion/
   https://www.youtube.com/watch?v=faJ9frWwoUY  */

#include <stdio.h>
#include <string.h>
#include "stdlib.h"
#include "stdbool.h"

// AVL tree  node
struct AVLNode
{
    int data;               /* data filed */
    struct AVLNode * right; /* right child */
    struct AVLNode * left;  /* left child */
    int  height;            /* height of each node */
};

/* Pointer to ROOT node // (root of tree) */
struct AVLNode * ROOT = NULL;  // root is null now have created empty AVL

/* function to update the height of nodes */
struct AVLNode* updateHeight(struct AVLNode* node);

/*  Function to create AVLNode node */
struct AVLNode* CreateNewNode(int);

/* Function to add new value to binary tree recursive method */
void Insert(void);

/* helper function to Insert(void) function */
struct AVLNode *Insert_Helper(struct AVLNode *root, int);

/* Function to return the Balance  Factor */
int getBalanceFactor(struct AVLNode *node);

/* function to get the Height of tree(MAX Depth of tree) */
int Height(struct AVLNode *temp);

/* A utility function to get maximum of two integers */
int Max(int, int);

/* left Rotations function */
struct AVLNode* leftRotate(struct AVLNode *root);

/* right rotation function */
struct AVLNode* rightRotate(struct AVLNode *root);

/* Function to print nodes in Preorder */
void Preorder_traversal(struct AVLNode *root);

/* Function to print nodes in Inorder */
void Inorder_traversal(struct AVLNode *root);

/* Function to print nodes in Postorder */
void Postorder_traversal(struct AVLNode *root);

/*
function to search for an element in AVL tree,
returns true if element is found else return false */
bool Search(int);

/* helper function to search () function */
bool Helper_Search_recursive(struct AVLNode *temp, int);

/* function to search and delete a value from AVL tree. */
void Delete();

/* helper function to Delete()function */
struct AVLNode *DeleteHelper(struct AVLNode *rootNode, int);

/* find the address of Node with maximum value in tree. */
struct AVLNode * FindMax(struct AVLNode *rootNode);

/* find the address of Node with minimum value tree. */
struct AVLNode * FindMin(struct AVLNode *rootNode);

int main(int argc, char* argv[])    /* the river Code */
{
    /* variable declarations */
    int option,element;
    do
    {
        printf("\nAVL tree Implementation                  \n");
        printf("AVL tree operation                         \n");
        printf("1 : Append :(Insert) Node Into AVL tree   : \n");
        printf("2 : Search : Search for value in AVL tree : \n");
        printf("3 : Deleting a Node from AVL tree         : \n");
        printf("4 : Preorder traversal of the AVL tree    : \n");
        printf("5 : Inorder traversal of the AVL tree     : \n");
        printf("6 : Postorder traversal of the AVL tree   : \n");
        printf("0 : quit                                  :\n");
        // asking user for the choice first
        printf("input your choice                         :");
        scanf("%d", &option);
        switch(option)
        {
            case 1:    // case 1 insert node to AVL tree recursive method
            Insert();  // calling insert function
            break;

            case 2: // case 2 search for value in AVL tree
                // Ask user to enter a number.
                printf("Enter value to be searched in AVL tree : ");
                scanf("%d", &element);
                // If number is found, print "FOUND"
                bool found = Search(element);
                if(ROOT == NULL)
                    printf("AVL tree is Empty");
                else if (found)
                    printf("%d is found in AVL tree", element);
                else
                    printf(" the value %d is not found in AVL tree",element);
             break;

            case 3 :       // case 3 Deleting a Node from AVL tree
                Delete(); // calling Delete() function
            break;

            case 4: // print all the nodes in Preorder
                 printf("Preorder traversal of the AVL tree is : \n");
                 Preorder_traversal(ROOT); // call Preorder_traversal() function
            break;

            case 5: // print all the nodes in Inorder
                 printf("Inorder traversal of the AVL tree is : \n");
                 Inorder_traversal(ROOT); // call Inorder_traversal() function
            break;

            case 6: // print nodes in Postorder
                 printf("Postorder traversal of the AVL tree is : \n");
                 Postorder_traversal(ROOT); // call Postorder_traversal()Function
            break;

            case 0 :  /* case 0 Exit case */
                printf("time to exit thanks\n");
            _Exit(0);

            default : /* default case */
                 printf("invalid input\n");
            break; // no need break after default case I use it only for readability

        } /** END of switch */

    }while(1);  /** END OF DO WHILE LOOP */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
    A utility function to create new AVLNode in heap so I can called
    it each time I need new node take the value to be inserted
    in the new node as argument  */

struct AVLNode* CreateNewNode(int value)
{
    /* local variable of type struct AVLNode declaration */
    struct AVLNode *newNode;
    // allocate memory dynamically for node using malloc C function
    newNode = (struct AVLNode *)malloc(sizeof(struct AVLNode));
    if(newNode == NULL) /* Error handling */
    {
        printf("Error in allocating memory\n");
    }
    //adding information to node
    newNode -> data = value;
    newNode -> right = NULL;
    newNode -> left  = NULL;
    newNode -> height = 1;   // new node is initially added at leaf
    /**
     * why newNode -> left and newNode -> right = null
     * because M sure this node will be at the end of tree
     * will be the leaf node
     */
    return newNode;  // return newly created node to place where it been be called

} /** END of CreateNewNode() */


 /**
 *   function to insert node in AVL tree Recursive methods
 *   first ask user for value to be inserted
 *   then call helper function and pass root
 *   and value to be inserted as argument why I make new
 *   helper function because in insert process I need root
 *   each time make recursive, and user may not know root only
 *   want insert the value for that we asked user only for value
 *   and  the helper  function will take care of the rest
 *   (can say this happen behind the scene )
 *
 *  Reference ->
 *  https://youtu.be/COZK7NATh4k
 *  https://youtu.be/hWokyBoo0aI
 *  https://youtu.be/kCFPcWdqxmQ
*/

void Insert( )
{
    int value; /* local variable */
    // asking user to the value to be inserted
    printf("enter value to insert in AVL tree : ");
    scanf("%d",&value);

     ROOT = Insert_Helper(ROOT,value);  /* call helper function then update root
                                         by value return from helper function */
     // for testing only
    //  ROOT = Insert_Helper(ROOT, 9);
    //  ROOT = Insert_Helper(ROOT, 5);
    //  ROOT = Insert_Helper(ROOT, 10);
    //  ROOT = Insert_Helper(ROOT, 0);
    //  ROOT = Insert_Helper(ROOT, 6);
    //  ROOT = Insert_Helper(ROOT, 11);
    //  ROOT = Insert_Helper(ROOT, -1);
    //  ROOT = Insert_Helper(ROOT, 1);
    //  ROOT = Insert_Helper(ROOT, 2);
    //  ROOT = Insert_Helper(ROOT, 2);

/* The constructed AVL Tree would be
            9
           /  \
          1    10
        /  \     \
       0    5     11
      /    /  \
     -1   2    6
    */

} /** END OF Insert()*/

/**
 *  helper to insert() function will add the new node recursively
 *  Steps to follow for insertion in AVL Tree are blow
 *  Insert the element in the AVL tree is in the same way
 *  the insertion in BST.
 *  the current node must be anccestor to the newly inserted node
 *  Update the height of the current node
 *  get the Balance Factor(difference of height between left subtree
 *  and right subtree)
 *  if the Balance Factor is grater than 1 then its left-left rotation
 *  case or left-right case rotation
 *  if the Balance Factor is lesser than -1 then its right-right case
 *  rotation or  right-left case rotation
 */

struct AVLNode *Insert_Helper(struct AVLNode *root, int value)
{
    // 1. Perform the normal BST insertion

    /*
    first check if tree is empty if so call CreateNewNode(value ) function
    which create newnode then set this node as root */
    if (root ==  NULL) //Exit condition
    {
        struct AVLNode *newNode;
        newNode =  CreateNewNode(value); // call function to create new nod  now node is ready to add
        root = newNode;
        return root; // return root to be updated

        // this condition can be written only in one line as line like blow
        //return CreateNewNode(value);
    }

    /* if the data to be inserted is lesser, insert in left subtree  */
    if (value < root -> data)
    {
        root -> left = Insert_Helper(root -> left,value); //Recursive call to Insert_Helper(root -> left,value)
    }
    /* if the data to be inserted is grater than root value , insert in right subtree */
    else if (value > root -> data)
    {
        root -> right = Insert_Helper(root ->  right, value); //Recursive call to Insert_Helper(root -> right,value)
    }

    /*
    if data to be inserted is equal to root value , inform the
    user that duplicate element are not allowed in AVL tree
    (Equal keys not allowed )  */
    else if (value == root -> data)
    {
        printf("%d is already in tree duplicate value not Allowed in AVL Tree\n",value);
        return  root; // return the root no changes in tree
    }

    /**
    *  until here normal BST insertion is done now
    * lets continue for AVL logic
    *  Let’s just take it step by step
    * (1) Insert the node as BST tree.( this one is done)
    * (2) Update the height value of the visited node.
    * (3) Balance the tree through the rotations (with balance factor).
    **/

    /* 2.
    Second step update the height of nod
    call updateHeight(root) to update height of root node  */
     root = updateHeight(root);

     /* 3.
    third step check Get the balance factor of this ancestor
    node to check whether this node became unbalanced
    for that I call getBalanceFactor function */
    int balance_factor = getBalanceFactor(root);

    // if this node becomes unbalanced, then there are 4 cases

    //(1) Left Left Case
    if (balance_factor > 1 && value < root -> left -> data)
    {
        return rightRotate(root); // call rightRotate() function
     }

     // (2) Left Right Case
     else if (balance_factor > 1 && value > root -> left -> data)
     {
        root -> left = leftRotate(root-> left); // call leftRotate(root-> left)
        return  rightRotate(root);      // always back to reference above for this case
     }

     // (3)  Right Right Case
    else if (balance_factor < -1 && value > root -> right -> data)
    {
         return leftRotate(root); // call leftRotate(root)
    }

    // (4) Right Left Case
    else if (balance_factor < -1 && value < root -> right -> data)
    {
        root -> right = rightRotate(root -> right); // call rightRotate(root -> right)
        return leftRotate(root);        // I always back to reference above for this case
    }

     /* return the(unchanged) node pointer */
     return  root;  // return root back to caller

} /** END of Insert_Helper() */


/**
*   function to get the Balance Factor for AVLNode node
*   Balance Factor = The height of the left subtree -
    The height of the right subtree
*/

int getBalanceFactor(struct AVLNode *node)
{
    //if the node passed is Null
    if(node == NULL)
    {
      return 0;
    }

   // else return the balance factor for that we will call height function
    return Height(node -> left) - Height(node -> right);

} /** END of getBalanceFactor() */


/**
   A utility function to left rotate subtree rooted with given root
*/

struct AVLNode* leftRotate(struct AVLNode  *root)
{

	// need some  variables to store nodes before link changes
    struct AVLNode *A = root -> right;
    struct AVLNode *B = A -> left;

    // link changes(Perform rotation )
    A -> left  = root;
    root -> right = B;

    // update height for Both nodes A and root
    root = updateHeight(root);  // call updateHeight(root) to update height of root node

    A  = updateHeight(A);    // call updateHeight(A) to update height of node A

    return A; // Return the new root which is  A now after link changes

} /** END of leftRotate() */


/**
*   right rotation
*   A utility function to right rotate subtree rooted with given root
**/

struct AVLNode* rightRotate(struct AVLNode *root)
{
	// need some variables to store nodes before link changes
    struct AVLNode *A = root -> left;
    struct AVLNode *B = A -> right;

    // link changes(Perform rotation )
    A ->  right  = root;
    root -> left = B;

    // update the height for Both nodes A and root
    root = updateHeight(root); // call updateHeight(root) to update height of root node
    A  = updateHeight(A);   // call updateHeight(A) to update height of node A

   return A; // Return  the new root which is  A  now after link changes

} /** END of rightRotate() */


/**
*
* function to return height of tree
* in AVL tree we don need to count height of node
* height is already there and will be update it
* after ever node insertion so just return height
*/

int Height(struct AVLNode *temp)
{
     if (temp ==  NULL)
        return 1;

    return  temp -> height;

} /** END of Height() */


/** function To update the Height of given Node */

struct AVLNode *updateHeight(struct AVLNode *node)
{
    node -> height = 1 + Max(Height(node -> left), Height(node -> right));
    return node;

}/** END of updateHeight() */


/** A utility function to get maximum of two integers */

int Max(int firstNumber,int secondNumber)
{
    // return the bigger one
    return(firstNumber > secondNumber) ? firstNumber : secondNumber;
} /** END OF Max()*/


/**
 *  Preorder traversal   : [root]  [left] [right]
 *  Given AVL tree, print its nodes in  Preorder
 *  in Preorder traversal  we start  from root of tree
 *  first print data of root then second step visit left subtree
 *  and print all the element and thirdly visit right sub tree
 *  and print all the element
 *
 *   Algorithm  Preorder traversal
       * 3  step blow
       *  Visit root node
       *  Visit all the nodes in the left subtree
       * Visit all the nodes in the right subtree

 *   for Reference
     https://youtu.be/gm8DUJJhmY4
 *   https://youtu.be/O8pI0TeXUR4 */

void  Preorder_traversal(struct AVLNode *rootNode)
{
    // base condition for recursion
	// if tree/sub-tree is empty, return and exit
    if (rootNode == NULL)
        return;

    printf("%d  ",rootNode -> data);  /* first print the data from root */

    Preorder_traversal(rootNode -> left);  /* Visit left subtree */

    Preorder_traversal(rootNode -> right);  /* Visit right subtree */
    // this goes on until root node == null which is base condition

} /** End of Preorder_traversal() */


/**
 * Inorder traversal : [left]  [root] [right]
 * Given AVL tree, print its nodes in inorder
 * in indorder traversal we start from root of tree
 * first visit left subtree and print all the element
 * then second print data of root and thirdly visit right
 * sub tree and print all the element

 *   Algorithm  Inorder traversal
       * First, visit all the nodes in the left subtree
       *  Then the root node
       *   Visit all the nodes in the right subtree
       *   all of this visiting happen recursively
 *
 *   if we Apply inorder traversal to AVL tree all the element
 *   will be display in acceding sorted order
 *   for Reference
     https://youtu.be/gm8DUJJhmY4
 *   https://youtu.be/O8pI0TeXUR4 */

void Inorder_traversal(struct AVLNode* rootNode)
{
	/* base condition for recursion
	 if tree/sub-tree is empty, return and exit */
    if (rootNode == NULL)
        return;

    Inorder_traversal(rootNode -> left);  /* first Visit left subtree  */

    printf("%d  ", rootNode -> data);  /* then print the data  */

   Inorder_traversal(rootNode -> right);  /* Visit right subtree */

   // this goes on until root node == null which is base condition
} /** END OF Inorder_traversal() */


/**
 *   Postorder traversal : [left] [right] [root]
 *   Given AVL tree, print its nodes in Postorder
 *  in Postorder traversal we starting from root of tree
 *  which will be given to function as argument visit left
 *  subtree and print all the element then second step visit
 *  right sub tree and print all the element
 *  last step print data of root
 *
 *   Algorithm  Postorder  traversal
       *  Visit all the nodes in the left subtree
       *  Visit all the nodes in the right subtree
       *  Visit root node (so root node will print as last element)

*    for Reference
     https://youtu.be/gm8DUJJhmY4
 *   https://youtu.be/O8pI0TeXUR4 */

void  Postorder_traversal(struct AVLNode* rootNode)
{
	// base condition for recursion
	// if tree/sub-tree is empty, return and exit
    if (rootNode == NULL)
        return;

    Postorder_traversal(rootNode -> left); /* Visit left subtree  */
    Postorder_traversal(rootNode -> right); /* Visit right subtree */
    printf("%d  ", rootNode -> data);    /*  print the data from root  */

   // this goes on until root node == null which is base condition

} /** END of Postorder_traversal() */


/**
*   function To search for an element in AVL Tree, returns true if element is found
*   function take one value as parameter and search it in the tree */
bool Search(int value)
{
    /**
     * I call helper function which take the root of tree and the
     * value given by user to search as argument Helper_Search_recursive(ROOT,value
     * then search recursively and return true if the value found in tree else return false
     * the only reason I make Helper_Search_recursive(ROOT,value) function because i want make it
     * ease for user yes user may not know the root of tree she ,he only want search
     * with that just give the value you want search and i will take care of the rest
     */
      return Helper_Search_recursive(ROOT,value); // return true or false back to user

} /** END OF Search() */

/**
*  helper function to search function search recursive
*  why I send temp which is root as parameter because when we
*  call Helper_Search_recursive(struct AVLNode* temp, int value)
*  function next time we need to give what we have reach with temp
   in previous time and this goes recursively

   for Reference ->
*  https://youtu.be/1BfVu4hmSmE  */

bool  Helper_Search_recursive(struct AVLNode* temp, int value)
{
    // if tree is empty so simply not fount
    if (temp ==  NULL)
    {
        return false;
    }
    else if (temp -> data == value)
    {
         return true; // found in the root
    }

    // if the value to be search is smaller than root value search in left subtree
    else if (value <= temp -> data)
    {
        return Helper_Search_recursive(temp -> left, value);  //Recursive call to recursiveAddHelper(temp -> left,value)
    }
    // if the value to be search is grater than root value search in right subtree
    else
    {
        return  Helper_Search_recursive(temp -> right, value); //Recursive call to recursiveAddHelper(temp -> right,value)
    }
} /** End of Helper_Search_recursive()*/


/**
    function to Delete a node from Avl tree
    for Reference -->
    https://www.codesdope.com/blog/article/binary-search-tree-in-c */

void Delete()
{
    int data; // local variable

    //asking user for the value to be deleted
    printf("Enter value to be deleted from AVL tree : ");
    scanf("%d",&data);

    /**
    I call helper function which take the root of tree
    and the value given by user to be deleted as argument
    the Helper function first search for the value in AVL tree
    if fount in the tree that node will be remove from tree
    the search process happen recursively.
    the function will return new root of the tree which will store
    in root variable
    if node not found return the value of current root to be overwritten again
    the only reason i make DeleteHelper(root,value); function because I want make it
    ease for user yes user may not know the root of tree only want remove value
    with that been said just give the value you want delete and helper function
    will take care of the rest behind the scene */

    ROOT =  DeleteHelper(ROOT, data);  // new root

    // printf("Preorder traversal of the AVL tree after deleting  %d  is :\n",data);
    Preorder_traversal(ROOT);

} /** END of  Delete() */


/**
     Deleting a Node in AVL
    1) Perform the normal BST deletion.
    2) The current node must be one of the ancestors of the deleted node.
       Update the height of the current node.
    3) Get the balance factor(left subtree height – right subtree height)
       of the current node.
    4) If balance factor is greater than 1, then the current node is unbalanced
       and we are either in Left Left case or Left Right case.
       To check whether it is Left Left case or Left Right case,
       get the balance factor of left subtree.
       If balance factor of the left subtree is greater than
       or equal to 0, then it is Left Left case, else Left Right case.
    5) If balance factor is less than -1, then the current node
       is unbalanced and we are either in Right Right case or Right Left case.
       To check whether it is Right Right case or Right Left case,
       get the balance factor of right subtree. If the balance factor of the right
       subtree is smaller than or equal to 0, then it is Right Right case,
       else Right Left case.

       for reference
       https://www.youtube.com/watch?v=faJ9frWwoUY
       https://www.geeksforgeeks.org/avl-tree-set-2-deletion/ */

struct AVLNode *DeleteHelper(struct AVLNode *rootNode, int value)
{
    // STEP 1: PERFORM STANDARD BST DELETE
   // if tree is empty return the Null to root
    if(rootNode == NULL)
    {
        return NULL;
    }
    /*
     If the key to be deleted is greater than the
     root's key, then it lies in right subtree  */
    if (value > rootNode -> data)  // search in right subtree
    {
    	rootNode -> right = DeleteHelper(rootNode -> right, value); //recursive call
    }
    /*
    If the key to be deleted is smaller than the
    root's key, then it lies in left subtree  */
    else if(value < rootNode -> data)   // search in left subtree
    {
    	rootNode -> left = DeleteHelper(rootNode -> left, value);   //recursive call
    }
    /* if key is same as root's key, then This is the node to be deleted */

    else // Wohoo... I found you, Get ready to be deleted
    {
        // Case 1:  No child (leaf node)
        if(rootNode -> right == NULL && rootNode -> left == NULL)
        {
            free(rootNode);   //delete node
            return NULL;    // return 0 to root
        }
        //Case 2: One child  (Node to be deleted have one child node)
        else if(rootNode -> left == NULL) // if left child is Null because have only one child
        {
            // I keep target node in temp variable so i can deleted
            struct AVLNode *target_Node_To_Delete = rootNode;
            free(target_Node_To_Delete);      // delete the node
            rootNode  = rootNode -> right;  // return to parent node
        }
        else if(rootNode -> right == NULL)  // if right child = Null
        {
            // I keep target node in temp variable so i can deleted
            struct AVLNode *target_Node_To_Delete = rootNode ;
            free(target_Node_To_Delete);      // delete the node
            rootNode  = rootNode -> left;     //return to parent node
        }
        /* case 3: 2 children (Node have 2 children):
        Get the inorder successor (smallest in the right subtree) */
        else
        {
            struct AVLNode *replecement_Node = FindMin(rootNode -> right);    // Find the minimum element of the right subtree  first

            // Replace the data of the node to be deleted(inorder successor's data)with the data of this node
            rootNode -> data = replecement_Node -> data;
            rootNode -> right = DeleteHelper(rootNode -> right, replecement_Node -> data);   //recursive call        // Delete node found by the minimum function
        }
    }

    /**  until here normal BST deleting is done now lets continue for AVL logic */

     /** 2. second step update the height of nod */

     rootNode = updateHeight(rootNode);  // call updateHeight(root) to update height of  root node A

    /**
    3.third step Get the balance factor of this ancestor
    node to check whether this node became unbalanced
    for that I call getBalanceFactor function */

    int balance_factor = getBalanceFactor(rootNode);

    // if this node becomes unbalanced, then there are 4 cases

      //(1) Left Left Case
     if (balance_factor > 1 && getBalanceFactor(rootNode -> left) >= 0)
     {
         return rightRotate(rootNode);
     }
     // (2) Left Right Case
     if (balance_factor > 1 && getBalanceFactor(rootNode -> left) < 0)
     {
        rootNode -> left = leftRotate(rootNode -> left);
        return  rightRotate(rootNode);  // always back to reference above for this case
     }
    // (3)  Right Right Case
    else if (balance_factor < -1 &&  getBalanceFactor(rootNode -> right) <= 0)
    {
         return leftRotate(rootNode);
    }
    // (4) Right Left Case
    else if (balance_factor < -1 && getBalanceFactor(rootNode -> right) > 0)
    {
        rootNode -> right = rightRotate(rootNode -> right);
        return leftRotate(rootNode);        // always back to reference above for this case
    }
    return rootNode; /* rootNode address will be return to root of tree in(Delete) function
                       to update root with new value or overwritten */

   /*
     Time Complexity:
     The rotation operations (left and right rotate) take
     constant time as only few pointers are being changed there.
     Updating the height and getting the balance factor also take
     constant time.
     So the time complexity of AVL delete remains same as BST delete which is O(h) where h is height of the tree.
     Since AVL tree is balanced, the height is O(Logn).
     So time complexity of AVL delete is O(Log n).
   */

}  /** END of DeleteHelper() */


/**
 *
 * Function to find minimum value in AVL tree.
 * return address of Node with minimum value in AVL because
 * i need this address in my delete helper function
 *  for reference (mycodeschool)
 */

struct AVLNode * FindMin(struct AVLNode *rootNode)
{
	while(rootNode -> left != NULL)
        rootNode = rootNode -> left;

	return rootNode; // return the address of node that the have minimum value

} /** END of FindMin() */


/**
*
* Function to find  the maximum value in AVL tree
* return address of node with maximum value
* for reference (mycodeschool)
*/

struct AVLNode * FindMax(struct AVLNode *rootNode)
{
	while(rootNode -> right !=  NULL)
        rootNode = rootNode -> right;

	return rootNode; // return the address of node that the have maximum  value

} /** END of FindMax() */
