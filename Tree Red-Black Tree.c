/**
    [PROGRAM] :  Red Black Tree data structure Implementation
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C Program to Implement Red Black Tree
    Red Black Tree is a self balancing Binary Search Tree(BST)
    where every node follows following rules.
    Red Black Tree properties :-
   (1) Every node has a color either red or black.
   (2) The color of root node is always black.
   (3) There are no two adjacent red nodes
      (A red node cannot have a red parent or red child)
       or can say if node is red then the children are black.
   (4) Every path from a node (including root) to any of its
      descendant NILL node has the same number of black nodes).
   (5) The longest path from the root node to any leaf node
     is no more than twice as long as the shortest path from
     the root to any other leaf in that tree.
   (6) All NILL leaf nodes are of black color.

     for Reference I will check links blow in future
      https://youtu.be/kVAFaGBSc-Q
      https://youtu.be/o9pz0F3YSX8
      https://youtu.be/gNtnFamj5Fo
      https://youtu.be/3RQtq7PDHog
      https://youtu.be/qA02XWRTBdw
      https://youtu.be/w5cvkTXY0vQ
      https://youtu.be/PhY56LpCtP4
      https://youtu.be/fNZ6nroKr5A
      https://www.codesdope.com/course/data-structures-red-black-trees-insertion/
      https://www.geeksforgeeks.org/red-black-tree-set-1-introduction-2/
      https://www.javatpoint.com/red-black-tree

     Why Red-Black Trees?
     Most of the BST operations(e.g., search, max, min, insert, delete.. etc)
     take O(h) time where h is the height of the BST. The cost of these operations
     may become O(n) for a skewed Binary tree. If we make sure that height of the
     tree remains O(Logn) after every insertion and deletion, then we can guarantee
     an upper bound of O(Logn) for all these operations. The height of a Red-Black
     tree is always O(Logn) where n is the number of nodes in the tree

      Comparison with AVL Tree
      The AVL trees are more balanced compared to Red-Black Trees,
      but they may cause more rotations during insertion and deletion.
      So if your application involves many frequent insertions and deletions,
      then Red Black trees should be preferred.if the insertions and deletions
      are less frequent and search is a more frequent operation,
      then AVL tree should be preferred over Red-Black Tree. */

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

/* I define 2 user define Red and  black I will need them in
    insert and deletions process latter for coloring the node */
#define RED 0
#define BLACK 1

/* A Red-Black tree node structure */
struct node
{
    int key;    // data of node
    int color;  // for color property
    struct node *parent;   // links for parent
    struct node *left;      //links for left child
    struct node *right;   //links for right child
};

/* Global, since all function will access them */
struct node *ROOT; // Root of Red black tree
struct node *NILL; // leaf in Red black tree

/*  Function to create node */
struct node *CreateNewNode(int);

/* Function to insert node into Red black tree */
void red_black_insert(int);

/* function to fix any validation
 that happen during insertion new node */
void insertFixUp(struct node *z);

 /* left Rotations function */
void left_rotate(struct node *x);

/* right Rotations function */
void right_rotate(struct node *x);

/* function to search and delete a value from Red black tree */
void red_black_delete(struct node *z);

 /*
 function to fix any validation that
 happen during deleting node from Red black tree */
void red_black_delete_fixup(struct node *x);

/* Function to find address of minimum value in a tree. */
struct node *tree_minimum(struct node *x);

/*  function to replace node u with node v */
void red_black_transplant(struct node *u, struct node *v);

/* function to search node in red black tree */
struct node *tree_search(int key);

/* function to traverse Red Black tree in Preorder */
void  Preorder_traversal(struct node *root);

/* function to traverse Red Black tree in Inorder */
void Inorder_traversal(struct node *root);

/* function to traverse Red Black tree in Postorder */
void  Postorder_traversal(struct node *root);

int main(int argc, char* argv[])    /* the river Code */
{  
   /*
    allocate memory dynamically for NILL node using malloc C function
    (NILL are leaf node are always in black color) */
    NILL = malloc(sizeof(struct node));
    NILL -> color = BLACK;
    ROOT = NILL;  // root is NILL in the begging is empty tree
    while(1)
    {
        printf("\nRed Black tree Implementation \n");
        printf("Red Black tree Operation       \n");
        int ch;    // for switch  to choose choice
        int element; // element
        struct node *SearchValue; // use for search process latter
        printf("1 : append (insert) node Red Black tree : \n");
        printf("2 : Search value in Red Black tree      : \n");
        printf("3 : Deleting a Node from Red Black tree : \n");
        printf("4 : Preorder traversal of the Red Black : \n");
        printf("5 : Inorder traversal of the Red Black  : \n");
        printf("6 : Postorder traversal of the Red Black: \n");
        printf("0 : quit :\n");
        // asking user for choice first
        printf("input your choice :");
        scanf("%d",&ch);
         //ch = get_int("input your choice :");// this for CS50 ide
         switch (ch)
         {
            // case 1  insert value
            case 1: // case 1 insert node to Red Black tree
               // asking user to the value to be inserted
               printf("Enter value to inserted in Red Black tree : ");
               scanf ("%d",&element);
               red_black_insert(element);  // call insert function
                // for testing
                //red_black_insert(10);
                //   red_black_insert(20);
                //   red_black_insert(30);
                //   red_black_insert(100);
                //   red_black_insert(90);
                //   red_black_insert(40);
                //   red_black_insert(50);
                //   red_black_insert(60);
                //   red_black_insert(70);
                 //   red_black_insert(80);
                 //   red_black_insert(150);
                  //   red_black_insert(110);
                   //   red_black_insert(120);
             break;

             case 2: // case 2 search for node in Red Black tree
                 // Ask user to enter a number.
                 printf("Enter value to be searched in Red Black tree : ");
                 scanf("%d",&element);
                 //If number is found, print "FOUND"
                 SearchValue = tree_search(element); // calll search function
                 if (SearchValue == NILL)
                    printf("%d is not found in Red Black",element);
                 else
                    printf("%d is found in Red Black",element);
              break;

             case 3: // Case 3 Deleting a Node in Red Black
                // asking user for the value to be inserted
                printf("Enter value to be deleted from Red Black tree:");
                scanf("%d",&element);
                /*
                to delete node search function will be called first
                and search function will search for the value given to delete
                if the value found then the address of that node will be pass to
                red_black_delete() so can be deleted */
                struct node *deletedNode = tree_search(element);
                if (deletedNode == NILL)
                   printf("%d Not found in Red Black tree \n",element);
                else
                {
                    red_black_delete(deletedNode);
                    printf("Preorder traversal of the Red Black tree after deleting  %d  is :\n",(element));
                    Preorder_traversal(ROOT);// to see the node after deletion
               }
            break;

            case 4: // case 4 print all the nodes in Preorder
                printf("Preorder traversal of the Red Black tree is :\n");
                Preorder_traversal(ROOT); // call Preorder_traversal() function
            break;

            case 5: // print all the nodes in Inorder
                printf("Inorder traversal of the Red Black tree is :\n");
                Inorder_traversal(ROOT); // call Inorder_traversal() function
            break;

            case 6: // print nodes in Postorder
                printf("Postorder traversal of the Red Black tree is :\n");
                Postorder_traversal(ROOT); // call Postorder_traversal()Function
            break;

            // case 0 is exit case
            case 0:
                printf("time to exit thanks\n");
            _Exit(0);

             default: // default case
             printf("\n invalid input\n");
             break; // no need break after default case I use it only for readability

         } /** END of switch */

    } /** END OF WHILE LOOP */

    return 0;// signal to operating system everything works fine

}/** End of main function */


/**
    A utility function to create new AVLNode in heap so I can called
    it each time I need new node take the value to be inserted
    in the new node as argument  */

struct node* CreateNewNode(int value)
{
    /* local variable of type struct Node declaration */
    struct node *newNode;

    /* allocate memory dynamically for node using malloc C function */
    newNode =(struct node *)malloc(sizeof(struct node));
    if(newNode == NULL) /* Error handling */
    {
        printf("Error in allocating memory\n");
    }

    /* adding information to node */
    newNode ->  key =  value;
    newNode ->  right = NILL;
    newNode ->  left = NILL;
    newNode ->  parent = NILL;
    newNode ->  color = RED;

    return newNode;  // return newly created node to place where it been be called

} /** END of CreateNewNode() */


/**
   Utility function to insert new node into RedBlack tree
    In AVL tree insertion, we used rotation as a tool to do
    balancing after insertion caused imbalance. In Red-Black tree,
    we use two tools to do balancing.
   (1) Recoloring
   (2) Rotation
  We try recoloring first,if recoloring doesn’t work,then we go for rotation.
  Following are the algorithm steps. The algorithms has mainly
  two cases depending upon the color of uncle.
  If uncle is red, we do recoloring.
  If uncle is black, we do rotations and/or recoloring.
(1) if tree is empty create new node as root node with color black
(2) create new node as leaf node with color red
(3) if parent of new node is black then exit.
(4) if parent of new node is red ,then check the
   color of parents sibling(uncle node)

  A- if new node x’s uncle node color is red then recolor
     and also check if the parents parent of new node is not root
     node then recolor and recheck.
     blow are the steps
      (i) Change color of parent and uncle as BLACK.
      (ii) if (grand parent = not root) Change color of grand parent as RED .
      (iii) Change x = x’s grandparent, repeat steps 2 and 3 for new x
            (x is the new node).

    B - if new node x’s uncle node color is black
     or Null do suitable rotations and recolor

    then there can be four configurations for x, x’s parent (p)
    and x’s grandparent (g) (This is similar to AVL Tree)

     blow are the  steps
    (i)   Left Left Case (p is left child of g and x is left child of p)
    (ii)  Left Right Case (p is left child of g and x is right child of p)
    (iii) Right Right Case ()
    (iv) Right Left Case () */

void red_black_insert(int key)
{
    /*
    Follow standard BST insert steps to first insert the node
    first create the node to insert for that call CreateNewNode( );
    which return new created node */

	struct node *z, *x, *y;
	z = CreateNewNode(key); //get new node
	x = ROOT;
	y = NILL;

    /*
    Go through the tree until a leaf(NILL) is reached.
    y is used for keeping track of the last non-NILL node
    which will be z's parent. later after added*/

   while(x != NILL)
    {
        y = x; // keep track of the last non-NILL node

        if(z -> key < x -> key)  /* if key is lesser go to left subtree */
        {
	     x = x -> left;
        }
	else   /* if key is grater go to right subtree */
        {
            x =  x -> right;
        }
    }
	// now we  have reached leaf(NILL) we are ready to add

    //  if Y is NILL that is mean this is first node added as the root
   if(y == NILL) // y is parent of z
    {
        ROOT = z; // updating global ROOT newly added node is root now
    }

    /* if data of child is less than its parent,*/
   else if(z -> key < y -> key)
    {
		y -> left = z;  /* insert as left child */
    }

    /* if data of child is greater than its parent,*/
    else if(z -> key > y -> key)
    {
        y -> right = z;  /* insert as right child */
    }
    // update  z parent
    z -> parent = y;

   /**
    until here insertion part is done, We have inserted the new node
    to a red-black tree in a similar way as we do in a normal binary
    search tree, now we need to call insertFixUp(z) function
    and pass (z) the node which newly added as argument
    to fix if there is any kind of violations that could have
    occurred in the process of insertion. */

    insertFixUp(z); /*  call insertFixUp to fix reb-black tree's property if it is violated due to insertion. */

} /** END  of red_black_insert() */


/**
 Utility function to fix up the Red-Black tree
 after standard BST insertion */

void insertFixUp(struct node *z)
{
    // (z's parent is RED color) loop will continue we need to fix
    while(z -> parent -> color == RED)
    {
        if (z -> parent == z -> parent -> parent  -> left)//z.parent is the left child
        {
            struct node *y; // for uncle node

            // Find uncle and store uncle in y
            y = z -> parent -> parent -> right;

            /*  If uncle is RED, its case 1 do following
            (i)  Change color of parent and uncle as BLACK
            (ii) Change color of grandparent as RED
            (iii) Move z to grandparent  */
            if (y -> color == RED) //case 1
            {
                y -> color = BLACK;              // recolor uncle
                z -> parent -> color = BLACK;   // recolor parent node
                z -> parent -> parent -> color = RED;   // recolor grandparent node
                z = z -> parent -> parent;                // move z to grandparent and loop will continue until no violation
            }
            else     //case 2 or case 3
            {
                /* z is z's parent's right child */
                if(z == z ->  parent -> right) { //case 2

                 /*
                 We can transform the second case into
                 the third one by performing left rotation
                 on the parent of the node z. Since both z
                 and its parent are red, so rotation won't affect
                 the black height. */
                 z = z -> parent; //marked z.parent as new z
                 left_rotate(z); // left Rotate Z
                }

            //case 3
            z -> parent -> color = BLACK; // made parent black
            z -> parent -> parent -> color = RED; // made parent red
            right_rotate(z -> parent -> parent); // Right Rotate Grandparent
            }
        }

        else {  // z.parent is the right child

         // Find uncle and store uncle in y
         struct node *y = z -> parent -> parent -> left;
         /*  If uncle is RED, its case 1 do following
         (i)  Change color of parent and uncle as BLACK
         (ii) Change color of grandparent as RED
         (iii) Move z to grandparent  */

          if (y -> color == RED){ //case 1
           y -> color = BLACK;                    // recolor uncle
           z -> parent -> color = BLACK;           //recolor parent node
           z -> parent -> parent -> color = RED;   // recolor grandparent node
           z = z -> parent -> parent;                // move z to grandparent and loop will continue until no violation
           }
	   // case 4 or case 5

	  else{ /* z's left uncle is not RED */

             /* z is z's parents left child */
             if(z == z -> parent -> left) // case 4
             {
                 /*
                 We can transform the case 4 into  case 5 by performing
                 right rotation on the parent of the node z.  */
                 z = z ->  parent;       // marked z.parent as new z
                 right_rotate(z);         // right Rotate Z
             }

             //case 5
             z -> parent -> color = BLACK;  // made parent black
             z -> parent -> parent -> color = RED; //made parent red
             left_rotate(z -> parent -> parent);    // left Rotate Grandparent
	      }
	  }
	}
	// At this point only property of color can be violated so make root BLACK
	ROOT -> color = BLACK;  //keep root always black

} /** END of insertFixUp() */


/**
 *  Preorder traversal   : [root]  [left] [right]
 *  Given Red black tree, print its nodes in  Preorder
 *  in Preorder traversal we start from root of tree
 *  first print data of root then second step visit left subtree
 *  and print all the element and thirdly visit right sub tree
 *  and print all the element
 *   Algorithm  Preorder traversal
       * 3  step blow
       *  Visit root node
       *  Visit all the nodes in the left subtree
       *  Visit all the nodes in the right subtree
 *   for Reference
     https://youtu.be/gm8DUJJhmY4
 *   https://youtu.be/O8pI0TeXUR4 */

void  Preorder_traversal(struct node *rootNode)
{
    /*
    base condition for recursion
    if tree/sub-tree is empty, return and exit */
    if (rootNode == NILL)
        return;

    printf("%d ",rootNode -> key);        /* first print the data from root  */
    Preorder_traversal(rootNode -> left);  /* Visit left subtree  */
    Preorder_traversal(rootNode -> right);   /* Visit right subtree */
    // this goes on until root node== null which is base condition

} /** End of Preorder_traversal() */


/**
 * Inorder traversal : [left]  [root] [right]
 * Given Red Black tree, print its nodes in inorder traversal
 * in indorder traversal we start from root of tree
 * first visit left subtree and print all the element
 * then second print data of root and thirdly visit right
 * sub tree and print all the element
 *   Algorithm  Inorder traversal
       * First, visit all the nodes in the left subtree
       *  Then the root node
       *   Visit all the nodes in the right subtree
       *   all of this visiting happen recursively

 *   for Reference
     https://youtu.be/gm8DUJJhmY4
 *   https://youtu.be/O8pI0TeXUR4 */

void Inorder_traversal(struct node* rootNode)
{
    /*
    base condition for recursion
    if tree/sub-tree is empty, return and exit */
    if (rootNode == NILL)
        return;

    Inorder_traversal(rootNode -> left);   /* first Visit left subtree  */
    printf("%d ",rootNode ->key);           /* then print the ROOT data  */
    Inorder_traversal(rootNode -> right);    /* Visit right subtree */
   // this goes on until root node == null which is base condition
} /** END OF Inorder_traversal() */


/**
 *   Postorder traversal : [left] [right] [root]
 *   Given a Red black tree, print its nodes in Postorder
 *   in Postorder traversal we starting from the root of tree
 *   which is given by user as argument then
      visit left subtree print all the element
      then second step visit right sub tree print all the element
      last step print data of root
 *   Algorithm  Postorder traversal
      *  Visit all the nodes in the left subtree
      *  Visit all the nodes in the right subtree
      * Visit root node (so root node will print as last element)
*/

void  Postorder_traversal(struct node* rootNode)
{
    /*
    base condition for recursion
    if tree/sub-tree is empty, return and exit */
    if (rootNode == NILL)
        return;

    Postorder_traversal(rootNode -> left);    /* Visit left subtree  */
    Postorder_traversal(rootNode -> right);    /* Visit right subtree */
    printf("%d ",rootNode -> key);           /*  print the data from root  */

   // this goes on until root node == null which is base condition
} /** END of Postorder_traversal() */


/**
*  Left Rotation function
*  Lets say y is x's right child. Left rotate x by making y, x's parent
*  and x, y's left child. y's left child becomes x's right child.

 *
 * 		x									y
 *	   / \                                 / \
 *  STA   y			----------->		  x   STC
 *		 / \							 / \
 *	  STB   STC						  STA   STB
  The left grandchild of x (left child of the right child x) will become
  the right child of it after rotation. We will do this but before doing
  this, let's mark the right child of x as y.
  left_rotate(struct node *x)
  y = x.right
  x.right = y.left
  The left child of y is going to be the right child of x - x.right = y.left.
  We also need to change the parent of y.left to x. We will do this if the left
  child of y is not NULL.
  if y.left != NULL
  y.left.parent = x
  then we need to put y to the position of x.We will first change the
  parent of y to the parent of x - y.parent = x.parent.
  After this, we will make the node x the child of y's parent instead of y.
  We will do so by checking if y is the right or left child of its parent.
  We will also check if y is the root of the tree.

  y.parent = x.parent
  if x.parent == NULL //x is root
  Root = y
  else if x == x.parent.left // x is left child
  x.parent.left = y
  else // x is right child
  x.parent.right = y

  At last, we need to make x the left child of y.
  y.left  = x
  x.parent = y
 */

void left_rotate(struct node *x)
{
    struct node *y;
     y = x -> right;   // let's mark the right child of x as y.
     x -> right = y -> left; // The left child of y is going to be the right child of x

    /*
    The left child of y is going to be the right child of x - x.right = y.left.
    We also need to change the parent of y.left to x.
    We will do this if the left child of y is not NULL. */
   if(y -> left != NILL)
    {
        y -> left -> parent = x;
     }

	/*
	Then we need to put y to the position of x. We will first change
       the parent of y to the parent of x - y.parent = x.parent.
      After this, we will make the node x the child of y's parent instead of y.
      We will do so by checking if y is the right or left child of its parent.
       We will also check if y is the root of the tree.  */

	y -> parent = x -> parent;
	if(y -> parent == NILL)  //if was x root y will be the root now as y will move to place of x
         {
		ROOT = y;
	  }
	 else if(x == x -> parent -> left) // if x was is left child y will be the left child now
	{
	    x -> parent -> left = y;
	}
	else    // if x was is the right child y will be the right child now
	{
		x -> parent -> right = y;
	}

	/* At last, we need to make x the left child of y and y, x's parent */
	y -> left = x;
	x -> parent = y;

} /** END of left_rotate() */


/**
 * Right Rotation function
 * Lets say y is x's left child. Right rotate x by making x, y's right child
 * and y x's parent. y's right child becomes x's left child.
 *
 *			|											|
 *			x											y
 *		   / \										   / \
 *		  y   STA		---------------->			STB	  x
 *		 / \											 / \
 *	  STB   STC										  STC   STA
 */

void right_rotate(struct node *x)
{
    struct node *y;
	y = x -> left;        // let's mark the left child of x as y.
	x -> left = y -> right; // The right child of y is going to be the left child of x

    if(y -> right != NILL)
     {
       y -> right -> parent = x;
     }
	/* Make x's parent y's parent and y, x's parent's child */
	y -> parent = x -> parent;
	if(y -> parent == NILL) //if was x root y will be the root now as y will move to place of x
        {
		ROOT = y;
	}
	else if(x == x -> parent -> left) // if x was is left child y will be the left child now
       {
		x -> parent -> left = y;
	}
	else // if x was is the right child y will be the right child now
        {
		x -> parent -> right = y;
	}

     /* At last, we need to make x the right child of y and y, x's parent */
      y -> right = x;
      x -> parent = y;

} /** END of right_rotate() */


/**
 * function to delete node in Red Black tree
 * The deletion process in a red-black tree is also similar
 * to the deletion process of a normal binary search tree.
 * Similar to the insertion process, we will make a separate
 * function to fix any violations of the properties of the red-black tree.
 * Deletion process steps.
 * If z has no child, z is removed.
 * If z has single child, z is replaced by its child.
 * Else z is replaced by its successor (smallest element in the right subtree of node z ) .
 * If successor is not z's own child, successor is replaced by its own child first.
   then z is replaced by the successor.

 * A pointer y is used to keep track. In first two case y is z.
   3rd case y is z's successor. So in first two case y is removed.
   In 3rd case y is moved.

 * Another pointer x is used to keep track of the node which replace y.
 * As removing or moving y can harm red-black tree properties a variable
 * yOriginalColor is used to keep track of the original color. If its BLACK then
 * removing or moving y harm red-black tree properties. In that case an auxiliary
 * procedure red_black_delete_fixup(x) is called to recover this.

 (1) Reference
    You-tube channel (Jenny's lectures CS/IT NET&JRF)
 (2) https://www.codesdope.com/course/data-structures-red-black-trees-deletion/
 (3) https://www.youtube.com/watch?v=eO3GzpCCUSg
*/

void red_black_delete(struct node *z)
{
    struct node *y, *x;
    int yOriginalColor;  // variable to keep trake original color of y

    /*
    we are going to store the original color of y in our process.
    Initially, we will mark z as y and if we deal with the case where
    the node z has two children, we will change the node y. */
    y = z;

   yOriginalColor = y -> color; // node y OriginalColor

     if(z -> left == NILL) // node to be deleted has no children or only right
      {
		x = z -> right; // x is used to keep track of the node which replace y.
		red_black_transplant(z, z -> right); // TRANSPLANT z node with it right child
	}
	else if(z -> right == NILL)
        {
		x = z -> left;     // only left child
		red_black_transplant(z, z -> left); // TRANSPLANT z node with it left child
	}
	else // node to be deleted has both children
	{
		y = tree_minimum( z -> right);  // find the minimum element in right subtree
		yOriginalColor = y -> color;  // keep Original Color of that node
		x = y -> right;
		if(y -> parent == z) // y is direct child of z
                {
			x -> parent = y;
		}
		else    // y is not direct child of z
		{
		    /*
		    If y is not the direct child of z, we will first transplant
                   the right subtree of y to y - RB-TRANSPLANT(T, y, y.right).
                   After this, we will change the right of y to right of z -
                   y.right = z.right
                   y.right.parent = y
                    After that we can transplant y to z in both cases
                   (whether y is direct child or not).
                                                  */

		   red_black_transplant(y, y -> right);
		    y -> right = z -> right;
		    y -> right -> parent = y;
		}
		red_black_transplant(z, y);

        /*
        Next,we will put the left of z to left of y and color y as z. */
        y -> left = z -> left;
	y -> left -> parent = y;
	y -> color = z -> color;
	}

	 /*
	 At last, we will call the function to fix the violation
         if the original color of y was black .
        until here deletion process is done now let check if original
         color was black we will call fix up function
        else if  original color  was red no need to fix  */
	if(yOriginalColor == BLACK)
        {
		red_black_delete_fixup(x);  // call fix up function
	}
} /** END of red_black_delete() */


/**
 * fix up function to fix if there any validation happen
  in Red Black tree while deletion node
 * As y was black and removed x gains y's extra blackness.
 *  Move the extra blackness of x until
 *		1. x becomes root. In that case just remove extra blackness
 *		2. x becomes a RED and BLACK node. in that case just make x BLACK
 *
 *  First check if x is x's parents left or right child. Say x is left child
 *
 * There are 4 cases.
 * Case 1: x's sibling w is red. transform case 1 into case 2 by recoloring
 * w and x's parent. Then left rotate x's parent.
 * Case 2: x's sibling w is black, w's both children is black. Move x and w's
 * blackness to x's parent by coloring w to RED and x's parent to BLACK.
 * Make x's parent new x.Notice if case 2 come through case 1 x's parent becomes
 * RED and BLACK as it became RED in case 1. So loop will stop in next iteration.
 * Case 3: w is black, w's left child is red and right child is black. Transform
 * case 3 into case 4 by recoloring w and w's left child, then right rotate w.
 * Case 4: w is black, w's right child is red. recolor w with x's parent's color.
 * make x's parent BLACK, w's right child black. Now left rotate x's parent. Make x
 * point to root. So loop will be stopped in next iteration.
 * If x is right child of it's parent do exact same thing swapping left<->right
 */

void red_black_delete_fixup(struct node *x)
{
    while(x != ROOT && x -> color == BLACK)
    {
        if(x == x -> parent -> left)
	{
		 // marked the sibling of x as w  ,  w = x.parent.right.
	    	 struct node *w  = x -> parent -> right;  // now we have the sibling let check the sibling color

            // case 1 w is red.
			if(w -> color == RED)
            {
                /* we switch the colors of w and its parent and then left rotate
                  the parent of x. In this way, we will enter either case 2, 3 or 4 */
				w -> color = BLACK;
				x -> parent -> color = RED;
				left_rotate(x -> parent);
				w = x -> parent -> right; // position of w have change
		}
		// case 2  w is black and its both children are black.
		if(w -> left -> color == BLACK && w -> right -> color == BLACK)
               {
                /*
                Move x and w's blackness to x's parent by coloring w to RED and x's parent to BLACK.
                Make x's parent new x.Notice if case 2 come through case 1 x's parent becomes
                RED and BLACK as it became RED in case 1. So loop will stop in next iteration. */

			w -> color = RED;
			x -> parent -> color = BLACK;
			x = x -> parent;
		}
		else  // case 3 or 4
                {
			//case 3 w is black and its right child is black and left child is red.
			if(w -> right -> color == BLACK)
                        {
                            /*
                            We will transform case 3 to case 4 by switching the colors
                             of w and its left child and then rotating right w.*/
				 w -> color = RED;
				w -> left -> color = BLACK;
				right_rotate(w);
				w = x -> parent -> right; // position of w have change
				}

				/*
			     case 4 w is black and its right child is red.
                              We first colored w same as the parent of x
                              and then colored the parent of x black.
                              After this, we colored the right child of w black
                              and then left rotated the parent of x.
                               Make x point to root. So loop will be stopped in next iteration. */

				w -> color = x -> parent -> color;
				x -> parent -> color = BLACK;
				w -> right -> color = BLACK;
				left_rotate(x -> parent);
				x = ROOT;

			   	/*
			   	we have moved x to the root of the tree  x = Root because
                              all the violations will be fixed in this case and  we need to
                                 terminate the loop. So, making the root of the tree as x will
                               terminate the loop. */
                                }
		}

	     else   // x == x -> parent -> right  code will be symmetric
               {
		     // marked the sibling of x as w - w = x.parent.left.  and check the 4 cases again

	    	      struct node *w = x -> parent -> left;

			//case 1 w is red.
			if(w -> color == RED)
                         {
				w -> color = BLACK;
				x -> parent -> color = RED;
				right_rotate(x -> parent); //only different is now right rotate
				w = x -> parent -> left;
			 }
			 // case 2 w is black and its both children are black.
			if(w -> left -> color == BLACK && w -> right -> color == BLACK)
                         {
                            // same Idea above
				w -> color = RED;
				x -> parent -> color = BLACK;
				x = x -> parent;
			    }

			else  //case 3 or 4
                        {
                             // case 3 w is black and its right child is black and left child is red.

				if(w -> left -> color == BLACK)
                                  {
                                        w -> color = RED;
                                        w -> right -> color = BLACK;
					left_rotate(w); // only different rotate left not right
					w = x -> parent -> left;
				}
				/* case 4 w is black and its right child is red.*/
				w -> color = x -> parent -> color;
				x -> parent -> color = BLACK;
				w -> left -> color = BLACK;
				right_rotate(x -> parent);  // only different right rotate not left
				x = ROOT;
        }
        }
    }

    // lastly change x color to black
	x -> color = BLACK;

}/** END of red_black_delete_fixup() */


/**
  function to replace node u with node v
  Now, we want to place the subtree rooted at node v
  in place of the subtree rooted at node u. It means
  that we need to make v the child of the parent of u i.e.,
  if u is the left child, then v will become the left child
  of u's parent. Similarly, if u is the right child, then v
  will become the right child of u's parent
  It is also possible that u doesn't have any parent i.e.,
  u is the root of the tree . In that case, we will simply
  make v as the root of the tree.
  if u.parent == NULL //u is root
  T.root = v
  Now, we will check if u is the left child or the right child.
  Accordingly, we will place v.
  If u is the left child, then the left of u's parent will be u i.e.,
  u == u.parent.left will be true and we will make v
  as its left child i.e., u.parent.left = v.

  if u.parent == NULL
  ...
  else if u == u.parent.left //u is left child
  u.parent.left = v
 else //u is right child
 u.parent.right = v
 Lastly, we also need to point the parent of v to the parent of u.

 if v != NULL
  v.parent = u.parent

 So, the overall code would be */

void red_black_transplant(struct node *u, struct node *v)
{
     if(u -> parent == NILL)//u is root
     {
	     ROOT = v;
	}
	else if(u == u -> parent -> left)  //u is left child
	{
		u -> parent -> left = v;
	}
	else //u is right child
	{
		u -> parent -> right = v;
	}
         // Lastly, we also need to point the parent of v to the parent of u.
	v -> parent = u -> parent;

} /**  END of red_black_transplant() */


 /**
 *
 * Function to find minimum value value in Red Black tree
 * return address of Node with minimum value
 *  for reference (mycodeschool)
 */

struct node *tree_minimum(struct node *x)
{
	while(x -> left != NILL)
	{
		x = x->left;
	}
	return x; // return the address of node that the have minimum value

} /** END of tree_minimum() */


 /** function to search node in Red Black tree
   and return the node if found */

struct node *tree_search(int key)
{
	struct node *x;
	x = ROOT;  // x is root
	while(x != NILL && x -> key != key) // while x is not NILL loop and  search for node
	{
	    /*
	    If the key to be search is smaller than the root's key,
             then it lies in left subtree  search in left subtree */
		if(key < x -> key)
		{
			x = x -> left;
		}
		else
		{
		    /*
		    If the key to be search is greater than the root's key,
		    then it lies in right subtree search in right subtree */
			x = x -> right;
		}
	}

   // if reach here found the node just return it to the caller
   return x;

} /** END of tree_search() */
