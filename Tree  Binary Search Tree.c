/**
    [PROGRAM] :  Binary Search Tree - Implementation(BST)
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Implement Binary Search Tree (BST)

    Binary search tree(BST) is a binary tree in which for each
    node, value of the nodes in left subtree is lesser and value
    of all the nodes in right subtree is grater.

     Reference in future :---->
     https://youtu.be/qH6yxkw0u78
     https://youtu.be/H5JubkIy_p8
     https://youtu.be/pYT9F8_LFTM
     https://youtu.be/COZK7NATh4k
     https://youtu.be/hWokyBoo0aI
     https://youtu.be/7Gg8bbshTIw
     https://youtu.be/oNJfm5Gnb_I
     https://youtu.be/1BfVu4hmSmE
     https://youtu.be/kCFPcWdqxmQ
     https://youtu.be/qfUk9KULGZU
     https://youtu.be/tORLeHHtazM
     https://youtu.be/eWeqqVpgNPg
     https://youtu.be/bvOYfDpk940
     https://youtu.be/KyMiqaA0ijM
     https://www.codesdope.com/blog/article/binary-search-tree-in-c/
*/

#include <stdio.h>
#include <string.h>
#include "stdlib.h"
#include "stdbool.h"

 // A BST tree node
struct BstNode
{
    int data;  /* data filed */
    struct BstNode * right; /* right child */
    struct BstNode * left;  /* left child */

    struct BstNode * next;   /* address of next node
                                this one I need only for queue  latter */
};

/* Pointer to ROOT node // (root of tree) */
struct BstNode * root = NULL; // root is null now have created empty BST

// head //top //front i will use this latter for queue
struct BstNode * first = NULL;

// last// tail // rear i will use this latter for queue
struct BstNode * last = NULL;

// Function to add new value to binary tree recursive method
void Insert(void);

// Function to add new value to binary tree iterative method
void inser_Iterative_Method(int);

/*  Function to create BstNode node */
struct BstNode *CreateNewNode(int);

// helper function to insert function
struct BstNode* recursiveAddHelper(struct BstNode *ROOT, int);

// function to search an element in BST, returns true if element is found
bool Search(int);

// helper to search function
bool Helper_Search_recursive(struct BstNode *temp, int);

// return the maximum number in Binary tree using iterative method
int getMax_Iterative_Method( void);

// return the minimum number in Binary tree using iterative method
int getMin_Iterative_Method( void);

// return the minimum number in Binary tree using recursive method
int getMin_Recursive_Method( void);

// Helper function to getMin_Recursive_methods( ); function
int getMin_Helper(struct BstNode *temp);

// return the maximum number in Binary tree using recursive method
int getMax_Recursive_Method(void );

// Helper function to getMax_Recursive_methods( ); function
int getMax_Helper(struct BstNode *temp);

// function to get Height of tree(MAX Depth of tree)
int get_Height_BST_Tree_Recursive_Method(void);

// Helper function to get_Height_BST_tree_Recursive_methods (); function
int get_Height_BST_Tree_Helper(struct BstNode *temp);

// return max number of two int
int MaxNumber(int ,int );

// print all the element in  Breath First(level oder)(BFS)
void BreathFirtst_traversal_LevelOrder(void);

// Function to print nodes in Inorder
void Inorder_traversal(struct BstNode *rootNode);

// Function to print nodes in Preorder
void Preorder_traversal(struct BstNode *rootNode);

// Function to print nodes in Postorder
void Postorder_traversal(struct BstNode *rootNode);

// search and delete a value from tree.
void Delete_Value(void);

// helper function to (Delete_value) function
struct BstNode *Delete_Helper(struct BstNode *rootNode, int);

// Function to find address of minimum value in a tree.
struct BstNode *FindMin(struct BstNode *rootNode);

// return true if BST, return false in otherwise
bool Is_Binary_Search_Tree(struct BstNode *rootNode);

//return true if all the element in right subtree are  bigger than root
bool IsSubTreeGreater(struct BstNode *rootNode, int);

//return true if all the element in left subtree are  smaller than root
bool IsSubTreeLesser(struct BstNode *rootNode, int);

// find Inorder Suceessor of Node in BST
struct BstNode* Getsuccessor(struct BstNode *rootNode, int);

// find some data in the tree and return the address of that node
struct BstNode* Find(struct BstNode *rootNode, int);

// find Inorder predecessor of Node in BST
struct BstNode* GetPredecessor(struct BstNode *rootNode, int);

//find the address maximum value node in a tree.
struct BstNode * FindMax(struct BstNode *rootNode);

// all 5 blow are queue function

// push new node node to queue of pointer to node
void enqueue(struct BstNode *newNode);

void dequeue(void);  //remove first node of queue

struct BstNode * front(void);  // return the front node in queue

 bool isempty(void);       // return true  if queue is empty else return flase

int main(int argc, char* argv[])    /* the river Code */
{
    /* variable declarations */
    int option, element, max, min, height;
    /*
    option for switch  to choice choice
    element //for element
    max // for max value
    min // for min value
    height // for height of tree */
    do
    {
        printf("\nBinary Search tree Implementation(BST) \n");
        printf("Binary tree operation \n");
        printf("1 : Append :(insert) node at end of BST using Recursive method               :\n");
        printf("2 : append (insert) node at end  of BST using iterative method               :\n");
        printf("3 : Search : Search for value in Binary tree                                 :\n");
        printf("4 : Height of Binary tree(Max Depth)                                         :\n");
        printf("5 : get Maximum value of BST iterative method                                :\n");
        printf("6 : get Maximum value of BST Recursive method                                :\n");
        printf("7 : get Minimum value of BST using iterative method                          :\n");
        printf("8 : get Minimum value of BST Recursive method                                :\n");
        printf("9 : print all the Element in BST in Preorder order using Depth First Traversals method                :\n");
        printf("10: print all the Element in BST in Inorder order using Depth First Traversals method                 :\n");
        printf("11: print all the Element in BST in  Postorder order using Depth First Traversals method              :\n");
        printf("12: print all the Element in BST using level order(BFS) method(remove comment from which block first) :\n");
        printf("13 : Deleting a Node in BST:\n");
        printf("14 : find Inorder successor in a BST                                          :\n");
        printf("15 : find Inorder Predecessor in a BST                                        :\n");
        printf("16 : Is Binary SearchTree ? (Correct but Efficient methods)                   :\n");
        printf("0 : quit :\n");

        // asking user for choice first
        printf("input your choice :");
        scanf("%d",&option);
        switch(option)
        {
            case 1:   // case 1 insert node to BST recursive method
            Insert(); // calling insert function
            break;

            case 2: // case 2 insert node to BST recursive method
                 // asking user to the value to be inserted
                 printf("Enter value to be inserted in Binary tree :");
                 scanf("%d",&element);
                 inser_Iterative_Method(element);// call inser_Iterative_Method()
            break;

            case 3: // case 1 search for node in BST
                // Ask user to enter a number.
                printf("Enter number to be searched : ");
                scanf("%d",&element);
                // If number is found, print "FOUND"
                bool fount = Search(element);
                if (fount)
                    printf(" the value : %d is found in BST",element);
                else
                    printf(" the value %d is not found in BST",element);
             break;

             case 4: // case 4 find Height of BST
             height = get_Height_BST_Tree_Recursive_Method ();// height of tree
             if (height == -1)
                 printf(" Height of BST : %d \n",0);
             else
                 printf(" Height of BST is : %d\n",height);
             break;

             case 5: // case 5 Maximum value in BST iterative method
                 max = getMax_Iterative_Method( );
                 if (max)
                    printf(" the maximum value in BST is  :  %d \n",max);
                 else
                    printf("tree is empty so have %d  max\n",max);
             break;

             case 6: // case 6 Maximum value in BST Recursive method
             max = getMax_Recursive_Method( );
                if (max)
                    printf(" the maximum value in BST is  :  %d \n",max);
                else
                    printf("tree is empty so have %d  max\n",max);
             break;

             case 7:  // case 7 minimum value in BST iterative method
                 min = getMin_Iterative_Method( );
                 if (min)
                     printf(" the minimum value in BST is  :  %d \n",min);
                 else
                     printf("tree is empty so have %d  min\n",min);
             break;

             case 8: // case 8 minimum value in BST Recursive method
             min = getMin_Recursive_Method( );
                 if (min)
                     printf(" the minimum value in BST is  :  %d \n",min);
                 else
                     printf("tree is empty so have %d  min\n",min);
             break;

             case 9: // print all the nodes in Preorder
                 printf("Preorder traversal of the BST tree is :\n");
                 Preorder_traversal(root);
             break;

             case 10: // print all the nodes in Inorder
                 printf("Inorder traversal of the BST tree is :\n");
                 Inorder_traversal(root);
             break;

             case 11: // print nodes in Postorder
                 printf(" Postorder traversal of the BST tree is :\n");
                 Postorder_traversal(root) ; //Function to print nodes in Postorder
             break;

             /**
            *  level order(BFS) Traversal
             *
             *  because this function ues queue and work with address  directly
             *  as we have queue of pointer  to poiner  for that if you print this first and  then print other inoder
             *  postorder or even preorder may give untited result
              *  for that while testing program  test first with those others display function
              * like Postorder_traversal, Inorder_traversal ,Preorder_traversal
              *
              * and test this one last

              */

             case 12: // level order(BFS) Traversal
               //BreathFirtst_traversal_LevelOrder();
               printf("remove comment from which block first\n");
             break;

             case 13: // cases 13 Deleting a Node in BST
                 Delete_Value(); // Deleting a Node in BST
            break;

            case 14: // case 14 Find Inorder successor of node.
                // Ask user to enter a number.
                printf("Enter element to find Inorder successor for it : ");
                scanf("%d",&element);
                struct BstNode* successor = Getsuccessor(root, element); // Getsuccessor()
	            if(successor == NULL)
	                printf("No successor Found\n");
	            else
                    printf("Successor is %d \n", successor -> data);
             break;

           case 15: // case 15 Find Inorder predecessor of node.
                // Ask user to enter a number.
                printf("Enter element to find Inorder predecessor for it : ");
                scanf("%d",&element);
                struct BstNode* predecessor = GetPredecessor(root, element); // call GetPredecessor()
                if(predecessor == NULL)
                    printf("No predecessor Found\n");
                else
                    printf("predecessor is %d \n",predecessor -> data);
             break;

            case 16: // case 16 check if given tree is binary tree or not
            if (root == NULL)
                printf("tree is empty no need to call function to check :\n");
              else
              {
                  //return true if BST, return false in otherwise
                  if (Is_Binary_Search_Tree(root) == true)
                      printf("true is BST:\n");
                   else
                      printf("false is Not BST:\n");
              }

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
    A utility function to create new BSTNode in heap so I can called
    it each time I need new node take the value to be inserted
    in the new node as argument  */

struct BstNode* CreateNewNode(int value )
{
    // local variable of type struct BstNode declaration */
    struct BstNode  *newNode;
    //first create node

    // allocate memory dynamically for node using malloc C function
    newNode = (struct BstNode *)malloc (sizeof(struct BstNode));
    if(newNode == NULL) /* error handling */
    {
        printf("Error in allocating memory\n");
    }

    // adding information to node
    newNode -> data = value;
    newNode -> right = NULL;
    newNode -> left = NULL;

    /**
     * why newNode ->left and newNode-> right = null
     * becauese iam sure this node will be at the end of tree
     * will be the leaf node
     */

    return newNode;  // return newly created node to place where it been be called

} /** END of CreateNewNode() */


/**
 *   function to insert node in BST Recursive methods
 *   first ask user for value to be inserted
 *   then call helper function and pass root
 *   and value to be inserted as argument why I make new
 *   helper function because in insert process I need root
 *   each time make recursive, and user may not know root only
 *   want insert the value for that we asked user only for value
 *   and  the helper  function will take care of the rest
 *   (can say this happen behind the scene )
 *
* Reference ->
* https://www.youtube.com/watch?v=COZK7NATh4k&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=28
*
* https://www.youtube.com/watch?v=hWokyBoo0aI&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=29

* https://www.youtube.com/watch?v=kCFPcWdqxmQ&list=PLwCMLs3sjOY4UQq4vXgGPwGLVX1Y5faaS&index=25
*/

void Insert()
{
    int value; /* local variable */

    // asking user to the value to be inserted
    printf("enter value to insert  in Binary tree:");
    scanf  ("%d",&value);
   root = recursiveAddHelper(root,value);  // call helper function then update root
                                        //  by value return from helper function
} /** END OF Insert()*/


/**
* helper to insert() function will add the new node recursively
* why I send rootnode which is root of BST as parameter because
* when recursiveAddHelper() function been called recursively next time
* we need to give it what we have reach  with rootNode in previous time
* and this goes recursively until we root become NULL
*
                   20
                 /    \
                /      \
               5       30
             /   \     /\
            /     \   /  \
           1      15 25  40
                /          \
               /            \
              9             45
            /   \          /
           /     \        /
          7      12      42

* Reference ->
* https://www.youtube.com/watch?v=COZK7NATh4k&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=28
*
* https://www.youtube.com/watch?v=hWokyBoo0aI&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=29

* https://www.youtube.com/watch?v=kCFPcWdqxmQ&list=PLwCMLs3sjOY4UQq4vXgGPwGLVX1Y5faaS&index=25 */

struct BstNode* recursiveAddHelper(struct BstNode *rootNode, int value)
{
    /*
    first check if tree is empty if so call CreateNewNode(value ) function
    which create newnode then set this node as root */
    if (rootNode ==  NULL) //Exit condition
    {
        struct BstNode  *newNode;
        newNode =  CreateNewNode(value); // call function to create new nod  now node is ready to add
        rootNode = newNode  ;
        return rootNode; // return root to be updated

         // this condition can be written only in one line as line like blow
         //return CreateNewNode(value);
    }

    // if data to be inserted is grater than root value , insert in right subtree
    if (value > rootNode -> data)
        rootNode -> right =  recursiveAddHelper(rootNode ->  right,value); //Recursive call to recursiveAddHelper(rootNode -> right,value)

    /*
     *  if data to be inserted is lesser or equal to root value , insert in left subtree
     *  also note is that according to my function in this case duplicate element
     *  are allowed and will be inserted in left subtree
     *  if we don want that just simply add  condition blow
     *  if (value == rootNode -> data)
     *  printf("%d  is already in tree  duplicate are  not allowed in BST\n ",value);
     */
    else if (value <= rootNode -> data)
        rootNode -> left =  recursiveAddHelper(rootNode -> left,value); //Recursive call to recursiveAddHelper(rootNode -> left,value)

    return rootNode; // root will be return in all cases so i return it  at end of function

} /* End of recursiveAddHelper() */


/**
*  function To search for an element in BST, returns true if element is found
*   function take one value as pramtar and search it in the tree */

bool Search(int value)
{
    /**
     * I call helper function which take the root of tree and the
     * value given by user to search  as argument Helper_Search_recursive(root,value);
     * then search recursively and return true if the value found in tree else return false
     * the only reason I make Helper_Search_recursive(root,value) function because i want make it
     * ease for user yes user may not know the root of tree he only want search
     * with that just give the value you want search and i will take care of the rest
     */
    return  Helper_Search_recursive(root,value); // return true or false back to user

} /** End of Search() */


/**
*  helper function to search function search recursive
*  why I send temp which is root as parameter because when we
*  call Helper_Search_recursive(struct BstNode *temp, int value)
*  function  next time we need to give what we have reach  with temp in perevs
*  time and this goes recursively
   Reference ->
* https://www.youtube.com/watch?v=1BfVu4hmSmE&list=PLwCMLs3sjOY4UQq4vXgGPwGLVX1Y5faaS&index=24  */

bool  Helper_Search_recursive(struct BstNode *temp, int value)
{
   // if tree is empty so simply not fount
    if (temp ==  NULL) // temp is root
    {
        printf("tree is empty no value to search for now \n");
        return false;
    }
    else if (temp -> data == value)
        return true; // found in the root

    // if the value to be search is smaller than root value search in left subtree
    else if (value <= temp -> data)
        return Helper_Search_recursive(temp -> left,value);     //Recursive call to recursiveAddHelper(temp -> left,value)

   // if the value to be search is grater than root value search in right subtree
    else
        return    Helper_Search_recursive(temp -> right ,value);     //Recursive call to recursiveAddHelper(temp -> right,value)

} /** End of Helper_Search_recursive()*/


 /**
  insert element at the end of BST using iterative method
  add new node to binray search tree Recursively */

void inser_Iterative_Method( int value)
{
    struct BstNode  *newNode; //first create node to add
    newNode = CreateNewNode(value); // call function to create new nod  now node is ready to add

    /**
    after creating node and ready to add first check if (root == NULL)
    if so the tree is empty then set this node as the root */
    if (root == NULL) // tree is empty
    {
        root = newNode ;   // insert first node in tree (root node)
        return; // we are done
    }
    else
    {
        /*
        by now we are sure tree is not empty
        first i need variable temp to use in loop until i reach
        right place to add */
        struct BstNode  *temp = root;  // local variable temp = root of tree
        struct BstNode *parent;      // i need it later after i reach to position to add because temp only for looping

        /**
        * now i go in loop and compare the given value to add with the value of temp
        * if its smaller i go left of tree if its bigger i go right of tree
        * until I reach end of tree then add in the right place */
        while(temp  != NULL)
        {
            parent = temp; // need it for last node before become null

            if (value <= temp -> data)
                temp = temp -> left;
            else
                temp  = temp -> right;
        }
        /** now temp is null i reach end of tree
        and the last node value of tree is in the parent variable
        let me check where to add left or right */
        if (value <= parent-> data)
            parent -> left =  newNode;  // add to left
        else
            parent -> right = newNode;  // add to right
    }

} /** End of inser_Iterative_Method() */


/**
 *  function to return the maximum number in Binary tree using iterative method
 *  for reference
    https://youtu.be/9uF63PUeZmM */

int getMax_Iterative_Method( )
{
    if (root == NULL) // first check if (root == NULL) if so the tree is empty
        return 0;

    /**
     now we are sure tree is not empty so let search and get the max
     first i need variable temp to use in loop until I reach max value also the maximum
     will always be at right child so as long ( temp _> right != NULL) we not yet
     reach to max .as soon as we reach temp right Child is NULL we just simply
     return temp _> data  that is the max*/

    struct BstNode  *temp = root;  // local variable temp = root of tree
    while(temp -> right  != NULL)  // as long as not reach last node
        temp  = temp -> right;

    return  temp -> data; // now temp on the maximum node just return the value

} /** END OF getMax_Iterative_Methods() */


/**
*  function to return the minimum number in Binary tree using iterative method
*  for reference
  https://youtu.be/9uF63PUeZmM */

int getMin_Iterative_Method( )
{
    if (root == NULL) // first check if (root == NULL) if so the tree is empty
        return 0;

    /**
    by now we are sure tree is not empty so let search and get the min value
    first i need variable temp to use in loop until I reach min value also the minimum
    will alway be at left child so as long as ( temp _> left != NULL) we not yet
    reach to min . as soon as we reach temp leftChild is NULL we just simply
    return temp _> data  that is the min*/

    struct BstNode  *temp = root;  // local variable temp = root of tree
    while(temp -> left  != NULL)  // as long as not reach last node
    temp  = temp -> left;

    return  temp -> data; // now temp on the minimum node just return the value
} /** END of getMin_Iterative_Method */


/**
 *  function to return the minimum number in Binary tree using recursive method
 *  for reference
 * https://youtu.be/9uF63PUeZmM */


int getMin_Recursive_Method( )
{
    if (root == NULL) // first check if (root == NULL) if so the tree is empty
        return 0;

    /**
    * now for sure tree not empty so i call helper function getMin_Helper(root)
    * and give root as argument  the only reason i call this function because we need
    * root in each recursive call and the user may not  know about root of tree user only wan
    * to know the minimum value so i have to handle this behind the scenes
    */

    return getMin_Helper(root); //return back to min

} /** END OF getMin_Recursive_Method() */


/**
*
* helper function to help  getMin_Recursive_methods(root ) function
* for getting minimum value will be called only if tree is not empty
* getMin_Recursive_methods(root ) send root of tree so need variable of type struct BstNode to recive that
* I called temp and later after  search  will  return to getMin_Recursive_methods () function the minimum value
* why I send temp which is root as parameter because when we call  getMin_Helper(struct BstNode *temp); function
* next time we need to give what we have reach  with temp in previous time and this goes recursively until
* we temp became NULL
* for reference
* https://youtu.be/9uF63PUeZmM */

int getMin_Helper(struct BstNode *temp)
{
    if(temp -> left  == NULL) //Exit codition
	    // now temp on the minimum node just return the value back return back to  getMin_Recursive_methods()
        return  temp-> data;
	else
	return getMin_Helper(temp -> left); //Recursive call to getMin_Helper(temp -> left)

    /**
    * will call it self with temp -> left recursively each time
    * until reach last node in left child in that time temp -> left = NULL
    * that is the minimum value will return the minimum value back to getMin_Recursive_methods() function
    * and getMin_Recursive_methods () function return  it back  to main function for user
    * you can say all this happen behind the scenes */

} /** END of getMin_Helper() */


/**
 *   function to return the maximum number in Binary tree using recursive method
 *   for reference
 *   https://youtu.be/9uF63PUeZmM */

int getMax_Recursive_Method( )
{
    if (root == NULL) // first check if (root == NULL) if so the tree is empty
        return 0;

    /**
    * by now for sure tree not empty so i call helper function getMax_Helper(root)
    * and give root as argument  the only reason i call this function because we need
    * root in each recursive call and the user may not  know about root of tree user only wan
    * to know the maximum value so i have to handle this behind the scenes */

    return getMax_Helper(root); //return back to min

} /** END of getMax_Recursive_Method() */


/**
*
* helper function to help  getMax_Recursive_methods(root ) function
* for getting maximum value this function will be called only if tree is not empty
* getMax_Recursive_Method(root )send root of tree so need variable of type struct BstNode to recive that
* I called temp and later after  search  will  return to getMax_Recursive_methods () function the minimum value
* why I send temp which is root as parameter because when we call getMax_Helper(struct BstNode *temp); function
* next time we need to give what we have reach  with temp in previous time and this goes recursively until
* we temp became NULL
*  for reference
*  https://youtu.be/9uF63PUeZmM */

int getMax_Helper(struct BstNode *temp)
{
    if(temp -> right  == NULL) //Exit codition
	    // now temp on the maximum node just return the value back return back to  getMax_Recursive_methods()
        return  temp-> data;

    return getMax_Helper(temp -> right); //Recursive call to  getMax_Helper(temp -> right);

} /** END of getMax_Helper() */


/**
*  function to find height of  binary search tree or any binary Recursively
*  also call (max Depth of tree)
*
*  Height of tree is Number of edges in longest path from root of tree node.
*  (Height of tree = height of root)
*  (Height of tree = max depth)
*
*  Height of each node in binary tree is Number of edges in longest path from
*  that node to leaf node.
*  Height leaf = 0.
*  Height of tree with one node is 0.
*
*  Depth of node is Number of edges in path from root to that nod
*
* for reference
  https://youtu.be/IAVj3OThMnY
  https://youtu.be/_pnqMz5nrRs */

int  get_Height_BST_Tree_Recursive_Method()
{
    /**
     * first check if tree is empty
     * return -1
     * height for empty node is -1
     */

    if (root == NULL) // tree is empty
        return -1; //return back to min

    /**
    * else
    * by now for sure tree not empty so i call helper function get_Height_BST_tree-Helper(root)
    * and give root as argument the only reason i call this function because we need
    * root in each recursive call and the user may not  know about root of tree user only wan
    * to know the height of tree so i have to handle this behind the scenes */

    return get_Height_BST_Tree_Helper(root);

} /** ENF OF get_Height_BST_tree_Recursive_Method() */


/**
*
*  helper function to help get_Height_BST_tree_Recursive_methods () function
* for getting height of BST it will be called only if tree is not empty
* get_Height_BST_tree_Recursive_method() send root of tree so need variable
* of type struct BstNode to recive that I called temp and later after
* i get height will  return back to get_Height_BST_tree_Recursive_methods () function
* the height of tree
* for reference
  https://youtu.be/IAVj3OThMnY
  https://youtu.be/_pnqMz5nrRs */

int get_Height_BST_Tree_Helper(struct BstNode *temp)
{
   /**
	*  Algorithm to find the height of a binary tree using recursion
    *  If the binary tree is empty, then return -1.
    *  Else
    *  Get the maximum height of the left subtree recursively. get_Height_BST_tree-Helper(temp -> left)
    *  Get the maximum height of the right subtree recursively. get_Height_BST_tree-Helper(temp-> right);
    *  Get the max of maximum heights of left and right subtrees. Add 1 to it for the current node.
    *  height_of_tree = max(max_height of left subtree, maximum_height of right subtree) + 1
    *  Return height_of_tree */

    if (temp ==  NULL)
        return -1;  //Exit condition return left-subtree or right-subtree place where it call

    int left_subtree  =   get_Height_BST_Tree_Helper(temp -> left); //Recursive call to get_Height_BST_tree-Helper(temp -> left);

    int right_subtree =   get_Height_BST_Tree_Helper(temp-> right); //Recursive call to get_Height_BST_tree-Helper(temp -> right);

    int height_of_tree = MaxNumber(left_subtree, right_subtree) + 1 ;  // i have called MaxNumber(int ,int) function which return the bigest number of two integer

    return  height_of_tree ; //return back to get_Height_BST_tree_Recursive_methods () function

} /** End of get_Height_BST_Tree_Helper() */


// return the  max number of two int

int MaxNumber(int x,int y)
{
    if (x > y) return x;
    else return y;

} /** End of  MaxNumber() */


/**
 *  Function to print Nodes in a binary tree in Level order
 *
 * Binary tree traversal :: traversal tree is the process of visiting
 * all the node in tree  data structure inly once
 * in this function I use Breath first level -( order level) (BFS) method
 * starting from the  root print all the element in each level from left to right
 * before move next level
 *
 *    for tree blow
 *                  25
                  /    \
                 27     19
                / \     / \
              17  91   13 55

 *   Output: 25 27 19 17 91 13 55
 *
 * we need to keep trake of left child and right child for each node so for that we
 *  need to create queue data structure (queue of address mean queue of pointer to node)
 *
 * (1) push root of tree to queue enqueue(root);
 *  then i need variable name current  to keep address of curent node on it before i lose it
 *   i get the current node from front of queue
 *
 * (2) struct BstNode *current =  front();
 * (3)  dequeue(); delete  fornt of queue
 *  print the current data  first then check if left child not empty push to queue
 *  and if right child not empty also push it to queue
 * (4)  if(current->left != NULL) enqueue(current->left);
 * (5)  if(current->right != NULL) enqueue(current->right);
 *
 * all of the this step happen in side loop while(!isempty())
 *
 * if using java or c++ you dont  need to create queue you can use the ready bulid queue
 * but c langugue dont have ready bulid queue so i have created mine
 *  for reference
 *  https://youtu.be/sdmOFkllNEw
    https://youtu.be/9RHO6jU--GU
    https://youtu.be/86g8jAQug04
 */

void BreathFirtst_traversal_LevelOrder()
{
	if(root == NULL) /* tree is empty cases */
	{
	    printf("tree is empty no node to print\n");
	    return;
	}
	enqueue(root); // push root to queue
   // while queue is not empty
	while(!isempty())
	{
	    struct BstNode *current =  front();

        printf("%i ",current -> data );
	    dequeue(); // removing the element at front

        if(current->left != NULL) enqueue(current->left); //if  left child not empty push to queue

		if(current->right != NULL) enqueue(current->right); //if  right child not empty push to queue

	}
} /** END of BreathFirtst_traversal_LevelOrder(_) */


/**
 *  Preorder traversal   : [root]  [left] [right]
 * Given a binary tree, print its nodes in  Preorder
 *
 * in  Preorder traversal  we start  from root of tree
 * first  print data of root   then second step visit left subtree and print all the element
 * and thirdly visit right sub tree and print all the element
 *
 *   Algorithm  Preorder  traversal
       * 3  step blow
       *  Visit root node
       *  Visit all the nodes in the left subtree
       * Visit all the nodes in the right subtree
 *   Time Complexity: O(n)
 *   space complexity  O(n) in worst case
 *
 *   in Best/average case O(log N)
 *
 *   for Refernce
     https://youtu.be/gm8DUJJhmY4
 *   https://youtu.be/O8pI0TeXUR4 */

void  Preorder_traversal(struct BstNode *rootNode)
{
    // base condition for recursion
	// if tree/sub-tree is empty, return and exit
    if (rootNode == NULL)
        return;

    printf("%d ",rootNode ->data);           /* first print the data from root  */

    Preorder_traversal(rootNode -> left);   /* Visit left subtree  */

    Preorder_traversal(rootNode -> right);    /* Visit right subtree */

   // this goes on until root node== null which is base condition
} /** End of Preorder_traversal() */


/**
 * Inorder traversal   : [left]  [root] [right]
 * Given a binary tree, print its nodes in inorder
 * in indorder traversal  we start from starting from root of tree
 * first visit left subtree and print all the element then second print
 * data of root and thirdly visit right sub tree and print all the element
 *   Algorithm  Inorder traversal
       * First, visit all the nodes in the left subtree
       *  Then the root node
       *   Visit all the nodes in the right subtree
       *   all of this visiting happen recursively
 *
 *   if we Applay inorder traversal to binary search tree all the element
 *   will be display in acceding sorted order
 *
 *   Time Complexity: O(n)
 *   space complexity  O(n) in worst case
 *
 *   in Best/average case O(log N)
 *   for Refernce
     https://youtu.be/gm8DUJJhmY4
 *   https://youtu.be/O8pI0TeXUR4 */

void Inorder_traversal(struct BstNode *rootNode)
{
	// base condition for recursion
	// if tree/sub-tree is empty, return and exit

    if (rootNode == NULL)
        return;

    Inorder_traversal(rootNode -> left);   /* first Visit left subtree  */

    printf("%d ",rootNode ->data);           /* then print the data  */

   Inorder_traversal(rootNode -> right);    /* Visit right subtree */

   // this goes on until root node== null which is base condition
} /** END OF Inorder_traversal() */


/**
 *   Postorder traversal   : [left] [right] [root]
 *
 *    Given a binary tree, print its nodes in   Postorder
 *
 *  in  Postorder traversal  we starting  from root of tree which will be given
 *  to function as arugment visit left subtree and print all the element
 *  then second step visit right sub tree and print all the element
 *   last step print data of root
 *
 *   Algorithm  Postorder  traversal
 *
       * 3  step blow
       *  Visit all the nodes in the left subtree
       * Visit all the nodes in the right subtree
       *  Visit root node (so root node will print as last element)

 *   Time Complexity: O(n)
 *   space complexity  O(n) in worst case
 *   in Best/average case O(log N)
  *   for Refernce
     https://youtu.be/gm8DUJJhmY4
 *   https://youtu.be/O8pI0TeXUR4 */

void  Postorder_traversal(struct BstNode *rootNode)
{
	// base condition for recursion
	// if tree/sub-tree is empty, return and exit
    if (rootNode == NULL)
       return;

    Postorder_traversal(rootNode -> left);   /* Visit left subtree  */
    Postorder_traversal(rootNode -> right);    /* Visit right subtree */
    printf("%d ",rootNode->data);           /*  print the data from root  */

   // this goes on until root node == null which is base condition
} /** END OF Postorder_traversal() */


/** function to Delete a node from Binary search tree */

void Delete_Value()
{
    int value; // local variable
    // Ask user to enter a number
    printf("Enter value  to be deleted from BST :");
    scanf  ("%d",&value);

   /**
    I call helper function which take the root of tree and the value given
    by user to be deleted as argument the Helper function first search for
    the value in BST if fount in the tree that node will be remove from tree
    the search process happen recursively.
    the function will return new root of the tree which will store in root variable
    if node not found return the value of current root to be overwritten again
    the only reason i make DeleteHelper(root,value); function because i want make it
    ease for user yes user may not know the root of tree only want remove value
     with that been said just give the value you want delete and helper function
     will take care of the rest behind the scene */

    root =  Delete_Helper(root, value);  // new root

} /** END of Delete_Value() */


/**
*  Helper function to (delete_value) function which delete given value from BST
* Deleting a Node in BST
* The deletion part is also easy but most complex among the above-mentioned
* tasks. When we delete a node, we have to take care of the children of the node
* and also that the property of a BST is maintained.
* There can be three cases in deletion of a node which are explained below:
*
* (1) The node is a leaf - This is the most simple case and here we can delete
* the node immediately without giving a second thought.

* (2) The node has one child
 * When the node to be deleted has only one child then just replacing the node with its
 * child will maintain the property of the search tree. So, we just replace the node
 * with its child i.e., link the parent of the node to be deleted to its child.
 * Since both the node to be deleted and its child are on the same side and there
 * are no further children, so the property of a search tree will be maintained.

* (3) The node has 2 children
  *  When the node to be deleted has 2 children, we need to choose a node to be replaced
  *  with the node to be deleted such that the property of the binary tree remains intact.
  *  When you look at the tree,you will find that either choosing the maximum element of
  *  the left subtree or the minimum element of the right subtree will satisfy this condition.
  * We will proceed with choosing the minimum element of the right subtree and then we will
  * delete the node. Now, the smallest element on the right subtree must have a single child
  * or no child at all so, we can delete this node using either the first or the second case.

  *   Always back to link blow for reference
    (1) https://youtu.be/gcULXE7ViZw
    (2) https://youtu.be/vzkSM0G657k
    (3) https://www.codesdope.com/blog/article/binary-search-tree/ */

struct BstNode *Delete_Helper(struct BstNode *rootNode , int data)
{
    if(rootNode == NULL)   // if tree is empty return the Null to root
       return NULL; // or case say return root

    if (data > rootNode -> data)  // search in right subtree
        rootNode -> right = Delete_Helper(rootNode -> right, data); //recursive call

    else if(data < rootNode -> data)   // search in left subtree
        rootNode -> left = Delete_Helper(rootNode -> left, data);   //recursive call

    // Wohoo... I found you, Get ready to be deleted
    else
    {
        // Case 1:  No child (leaf node)
        if(rootNode -> right == NULL && rootNode -> left == NULL)
        {
            free(rootNode);   //delete node
            return NULL;    // return 0 to root
        }

        //Case 2: One child  (Node to be deleted have one child node)
        else if(rootNode -> left == NULL)      // if left child is Null because have only one child
        {
            struct BstNode *Traget_Node_To_Delete = rootNode;    // I keep traget node in temp variable so i can deleted
            free(Traget_Node_To_Delete);      // delete the node
            rootNode  = rootNode -> right;     // return to parent node
        }
        else if(rootNode -> right == NULL)      // if right child = Null
        {
            struct BstNode *Traget_Node_To_Delete = rootNode;   // I keep traget node in temp variable so i can deleted
            free(Traget_Node_To_Delete);       // delete the node
            rootNode  = rootNode -> left;     //return to parent node
        }
        // case 3: 2 children (Node have 2 children)
        else
        {
            struct BstNode *replecement_Node = FindMin(rootNode -> right);    // Find the minimum element of the right subtree  first
            rootNode -> data = replecement_Node -> data;                     // Replace the data of the node to be deleted with the data of this node
            rootNode -> right = Delete_Helper(rootNode -> right, replecement_Node -> data);   //recursive call        // Delete node found by the minimum function
        }
    }

    return rootNode; // rootNode address will be return to root of tree in(Delete_value) function in all the 3 causes so I return in last

} /** END of BstNode *Delete_Helper() */


/**
 *
 * Function to find Inorder Successor of given key in a BST
 * Indorder Successor is the Node that would come immediately
 * after the given node in inorder traversal of the binary tree
 * we will pass data of current node and function return back address of
 * the successor back
 * first we need to search for the current node in BST
 *  for reference check link blow
 *  https://www.youtube.com/watch?v=yEwSGhSsT0U
 */

struct BstNode* Getsuccessor(struct BstNode *rootNode, int data)
{
    /**
	 * first we need to search for the current node in BST
	 * for that we call find () function and pass the address of root
	 * and if the value we pass found in BST  find function will the
	 * the address of current node
	 */
	struct BstNode* current = Find(rootNode,data);  // Search the Node - O(h)

	if(current == NULL)
        return NULL; // data not fount in tree

	/**
	 * by now we have got the node let get it successor for that there is two case :
	 * Case 1: if the Node has right subtree then find the least(smallest) value
	 * node from that right subtree and that node will be the answer
	 *  also we can say Go deep to left most node in right subtree
	 */

	if(current -> right != NULL)  // Node has right subtree
        return FindMin(current -> right); // time complexity O(h) where h is height of tree

	/**
	 *  Case 2 : if the node not have right subtree Go to the nearest
	 *  anccestor from which the given  node would be in left subtree
	 *   we will start from the the root of tree and  go until the given node
	 *   by  doing this we will go throw all the anccesstor of given node now
	 *    Inorder Successor will  be the best anccesstor in this path in which
	 *   the given node would be in left subtree
	 */

	else
	{
		// Case 2: No right subtree  - O(h) where h is height of tree

		struct BstNode* successor = NULL;
		struct BstNode* ancestor = rootNode; // start from root

		while(ancestor != current)      // go until node
		{
			if(current -> data < ancestor -> data)
			{
				successor = ancestor;  // so far this is the deepest node for which current node is in left
				ancestor = ancestor -> left;
			}
			else
				ancestor = ancestor -> right;
		}
		return successor;  // return successor
	}
} /** END  of Getsuccessor() */


/**
 *
 * Function to find Inorder predecessor of given key in a BST
 * Given a BST and a key. The task is to find the inorder predecessor of
 * the given key. In case, of predecessor is not present, then print(No predecessor Found)
 * Indorder predecessor is the Node that would be the previous node
 * of the given node in inorder traversal of the binary tree
 *  we will pass data of current node and function return back address of
 *  the Inorder predecessor back
 * first we need to search for the current node in BST
 *  for reference check link blow
 *  https://www.youtube.com/watch?v=rukYFD8cYBY
 */

struct BstNode* GetPredecessor(struct BstNode *rootNode, int data)
{
    /**
	 * first we need to search for the current node in BST
	 * for that we call find () function and pass the address of root
	 * and if the value we pass found in BST  find function will the
	 * the address of current node */

	struct BstNode* current = Find(rootNode, data);  // Search the Node - O(h)

	if(current == NULL)
        return NULL; //  node not found in BST

	/**
	 * by now we have got the node let get it predecessor for this  there is two case :
	 *  Case 1: if the Node given has left subtree then  find the largest(biggest) value
	 *  node from that left subtree and that node will be the answer
	 *  also we can say if node has left subtree jump to that left child and
	 *  go to the rightmost node (max value in left subtree)that is predecessor
	 */

	if(current -> left != NULL)  //Node has left subtree
	    return FindMax(current -> left); // O(h)  where h is height of tree

	/**
	 *  Case 2 : if the node  does not has left subtree Go to the nearest
	 *  anccestor from which the given  node would be in right subtree
	 *   we will start from the the root of tree and  go until the given node
	 *   by doing this we will go throw all the anccesstor of given node now
	 *    Inorder predecessor will  be  the best anccesstor in this path in which
	 *   the given node would be in right subtree
	 */

	else
	{
		//Case 2: No left subtree  - O(h) where h is height of tree

		struct BstNode* successor = NULL;
		struct BstNode* ancestor = rootNode; // start from root

		while(ancestor != current)      // go until the given node
		{
			if(current -> data > ancestor -> data)
			{
				successor = ancestor;  // so far this is the deepest node for which current node is in right
				ancestor = ancestor -> right;
			}
			else
				ancestor = ancestor -> left;
		}
		return successor;  // return  predecessor
	}
} /** END of GetPredecessor() */


/** Function to find some data in the tree and return the address of that node */

struct BstNode* Find(struct BstNode *rootNode , int data)
{
    if(rootNode == NULL) // case when root is Null
	    return NULL;

	else if(rootNode -> data == data)
        return rootNode; // case when data found at root node

	else if(rootNode -> data < data)
	    return Find(rootNode -> right, data); // go  search on right

	else return Find(rootNode -> left,data); // go search on left

} /** END OF  Find() */


/**
 *
 * Function to find minimum value in a tree.
 * return address of minimum value in BST because i need this
 * address in my delete helper function
 * however i have another different function to fine the min data
 * which return number  this one return pointer to Node
 * for refrence (mycodeschool)
 */

struct BstNode * FindMin(struct BstNode *rootNode)
{
	while(rootNode -> left != NULL)

	rootNode = rootNode -> left;

	return rootNode; // return the address of node that the have minum  value in BST

} /** END of FindMin() */


/**
*
* Function to find maximum value in a tree.
* return  address of maximum value in BST because i need this
* address in my Getpredecessor() function
* however i have another different function to fine the max data
* which return number this one return pointer to Node
* for refrence (mycodeschool)
*/

struct BstNode * FindMax(struct BstNode *rootNode)
{
	while(rootNode -> right !=  NULL)
	rootNode = rootNode -> right;
	return rootNode; // return the address of node that the have maximum  value

} /** END of FindMax() */


/**
 * function to Check if a Binary Tree is BST
 * Given a Binary Tree, the task is to check whether the given binary tree
 * is Binary Search Tree or not.
 *  Assume a BST is defined as follows:
    * The left subtree of a node contains only nodes with keys less than the node's key.
    * The right subtree of a node contains only nodes with keys greater than the node's key.
    * Both the left and right subtrees must also be binary search trees.

*  A binary search tree (BST) is a node-based binary tree data structure
*  which has the following properties.
    * The left subtree of a node contains only nodes with keys less than the node’s key.
    * The right subtree of a node contains only nodes with keys greater than the node’s key.
    * Both the left and right subtrees must also be binary search trees.
this function take root of given Binary tree as argument and return true if tree is binary
else return false

this is yet very famous interview question and the function can written in 3 waysso for
other different ways always return to (mycodeschool channel in youtube for reference)
https://youtu.be/yEwSGhSsT0U */

// return true if BST, return false in otherwise
bool Is_Binary_Search_Tree(struct BstNode *rootNode)
{
	if(rootNode == NULL)
        return true;

	// if all the 4 condition blow are true then is binary tree return true

   if( IsSubTreeLesser(rootNode -> left , rootNode -> data)    // is all the element in left subtree are smaller than root
       &&  IsSubTreeGreater(rootNode -> right , rootNode -> data)  // is all element in right subtree are bigger than root
       &&  Is_Binary_Search_Tree(rootNode -> left)      // is left subtree is binary tree
       &&  Is_Binary_Search_Tree(rootNode -> right))  // is right subtree is binary tree
	   return true;

    else
        return false;

 /**
 *  we could also just find maximum element in left subtree
 *  then compared with root of tree and also find minimum element
 *  in right subtree and compared with root in that case we don't to write
 *  this 2 function IsSubTreeLesser() and IsSubTreeGreater and result will be same
 *  however this two approach Correct but not efficient so are not the best one
 *  there is last last approach METHOD 3 which (Correct and Efficient)
 *  let see (IsBst_Efficient_Approach) function while be blow
 *
 *  for  more reference check link blow
 *  https://www.youtube.com/watch?v=yEwSGhSsT0U
 *
 */

} /** END of Is_Binary_Search_Tree() */


/**
*  return true if all the element in left subtree are
*  smaller than root
   https://youtu.be/yEwSGhSsT0U
*/

bool IsSubTreeLesser(struct BstNode *rootNode, int value)
{
	if(rootNode == NULL) return true; // bases case

	// Recursive case
	if (  rootNode -> data <= value
		&&  IsSubTreeLesser(rootNode -> left,value)
		&&  IsSubTreeLesser(rootNode -> right,value))
	    return true;

	    else
        return false;

} /** END of IsSubTreeLesser */


/**
*  return true if all the element in right subtree are bigger than root
   https://youtu.be/yEwSGhSsT0U
*/

bool IsSubTreeGreater(struct BstNode *rootNode, int value)
{
	if(rootNode == NULL) // base case
        return true;

	if (rootNode -> data > value // Recursive case
		&& IsSubTreeGreater(rootNode -> left ,  value)
		&& IsSubTreeGreater(rootNode -> right,  value)  )
	    return true;
	else
	  return false;

} /** END of IsSubTreeGreater()*/


/**
 * queue of pointer to node i need for  Level Order Traversal of binary tree funtion
 * to push new node to queue
 */

void enqueue(struct  BstNode *newNode)
{
    if(isempty())  // if queue is empty
        first = last =  newNode;
     else
     {
         /**
         now we are sure queue is not empty already have some node
         so you have to update (last-> next = root) variable to point
         to new node then move last one step ahead to
          point to new node so now new node is the last node(last = newnode)
          */
         last -> next = newNode; // right side conection
         last = newNode;         // move last one step ahead
     }
} /** end of enqueue() */


/**
 *  check if queue is empty or not
 */

bool isempty()
{
     if(first == NULL && last == NULL)
         //printf(" queue is empty\n");
         return true;
     return false;

} /** END OF isempty()*/


/**
*
*  dequeue first node in the queue( first in first out)
*/

void dequeue()
{
    struct  BstNode * temp ; //we need temp to use in free process

    temp = first;  //temp is on first node now always dequeue processs will be done using first

    if(isempty())   //if queue is empty then we dont have any node to delete
       printf ("queue is empty nothing to dequeue for now\n");

    else if (first == last) // if only one element on list
        first = last = NULL;
    else
      // now we are sure queue is not empty  so move first to point to next node
      // then free first node which is allready in temp (free (temp))
        first = first -> next;

        free(temp);
} /** END of dequeue()*/


/** return the front address */

struct BstNode * front()
{
   if(isempty())
      return 0;
   return first;
} /** END of front() */
