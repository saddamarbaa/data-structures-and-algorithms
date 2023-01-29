/**
    [PROGRAM] :  Splay Tree data structure implementation
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

  C Program to Implement Splay Tree
  The worst case time complexity of Binary Search Tree (BST) operations
  like search, delete, insert is O(n). The worst case occurs when the tree
  is skewed. We can get the worst case time complexity as O(Logn) with AVL
  and Red-Black Trees.
  Can we do better than AVL or Red-Black trees in practical situations?
  Like AVL and Red-Black Trees, Splay tree is also self-balancing BST.
  Splay trees are self-adjusting balancing binary search trees (BST)
  they adjust their nodes after accessing them. So, after searching,
  inserting or deleting a node, the tree will get adjusted. by
  put that node in root. (The main idea of splay tree is to bring the recently
  accessed item to root of the tree, this makes the recently searched item to be
  accessible in O(1) time if accessed again.(fast ACCES TO ELEMENT ACCESSED RECENTLY!!!) .
  for example: caches(memory caches)  )

  Splay trees put the most recently accessed items near the root based on the
  principle of locality  90-10 "rule" which states that 10% of the data is
  accessed 90% of the time, other 90% of data is only accessed only 10% of the time .
  Imagine a situation where we have millions or billions of keys and only few of them
  are accessed frequently, which is very  likely in many practical applications.

  unlike AVL tree Splay Tree not strict balanced !!! that,s why its faster
  its easy to implement
  Splay Tree are kept balanced with the help of rotations.

  Splay Tree are the most popular data structure in the industry .
  Reference:
  https://www.youtube.com/watch?v=qMmqOHr75b8
  https://www.youtube.com/watch?v=1HeIZNP3w4A
  https://www.codesdope.com/course/data-structures-splay-trees/
  https://www.geeksforgeeks.org/splay-tree-set-1-insert/ */

#include <stdio.h>
#include <stdlib.h>

/* A Red-Black tree node structure */
struct node
{
    int key;                // data of node
	struct node *parent;   //links for parent
	struct node *left;      //links for left child
	struct node *right;   //links for right child
};

/*
ROOT is Global, since all function will access them
Root of Splay Tree NULL we have create empty splay tree */
struct node *ROOT = NULL;

/*  Function to create node */
struct node* CreateNewNode(int);

/* Function to insert node into Splay tree */
void insert(int);

/* function to Splay given node to root */
void splay(struct node *n);

 /* left Rotations function */
void left_rotate(struct node *x);

/* right Rotations function */
void right_rotate(struct node *x);

/* function to delete  node from splay tree using Top_Down approcah */
void  Top_Down_Splaying_Delete(int);

/* function to delete  node from splay tree using Bottom_up */
void  Bottom_up_Delete(int);

/*  function to replace node u with node v */
void  Splay_transplant(struct node *u, struct node *v);

/* Function to find address of maximum value in a tree. */
struct node *tree_maximum(struct node *x);

/* Function to find address of minimum value in a tree. */
struct node *tree_minimum(struct node *x);

/* function to replace node u with node v */
void red_black_transplant(struct node *u, struct node *v);

 /* function to search node in Splay Tree */
struct node *tree_search(int);

/* function to traverse Splay tree in Preorder */
void  Preorder_traversal(struct node *root);

/* function to traverse Splay tree in Inorder traversal */
void Inorder_traversal(struct node *root);

/* function to traverse Splay tree in  Postorder traversal */
void  Postorder_traversal(struct node *root);

int main() /* the river Code */
{
    while(1)
    {
        printf("\n  : Splay Tree Implementation (Operations)               : \n");

        int ch;//for switch  to choose choice
        int element; // element
        struct node *SearchValue; //  use for search process latter
        printf("1 : append (insert) node in Splay Tree                   :\n");
        printf("2 : Search value  or node in Splay Tree                  :\n");
        printf("3 : Deleting a Node from Splay Tree(Top Down approach)   :\n");
        printf("4 : Preorder traversal of the Splay tree                 :\n");
        printf("5 : Inorder traversal of the Splay tree                  :\n");
        printf("6 : Postorder traversal of the Splay tree                :\n");
        printf("0 : quit                                                 :\n");
        // asking user for choice first
        printf("input your choice   : ");
        scanf("%d",&ch);

         //ch = get_int("input your choice :");// this for CS50 ide
         switch (ch)
         {
             // case 1  insert new node
             case 1:
                // asking user to the value to be inserted
                printf("Enter value to Inserted in Splay tree  : ");
                scanf ("%d",&element);
                insert(element);  // call insert function
                printf("Preorder traversal of the Splay tree after inserting  %d  is :\n",(element));
                Preorder_traversal(ROOT); //Function to print nodes in Preorder
             break;

             // case 2 search for  node in Splay Tree
             case 2:
               printf("Enter value to be searched in Splay Tree  : ");
               scanf("%d",&element);
              //If number is found, print "FOUND"
               SearchValue = tree_search(element); // call search function
               if (SearchValue ->key == element )
               {
                   printf("%d is found in Splay Tree :\n",element);
               }
               else
               {
                    printf("%d is not found in Splay Tree\n ",element);
               }
               printf("Preorder traversal of the Splay tree after searching  %d  is :\n",(element));
               Preorder_traversal(ROOT); //Function to print nodes in Preorder
               break;
              // Case 3 Deleting a Node (Top_Down)
              case 3:
                 // if root = NULL we are done
                 if (ROOT == NULL)
                 printf("tree is empty no need to call delete function\n");
                 else
                 {
                     //asking user to Enter the value to be deleted
                     printf("Enter value to be deleted from Splay Tree:");
                     scanf ("%d",&element);
                     Top_Down_Splaying_Delete(element); //Top_Down_Splaying_Delete function
                     printf("Preorder traversal Splay Tree :\n");
                     Preorder_traversal(ROOT); // call Preorder_traversal function
                    }
                break;

                // print all the nodes in Preorder
                case 4:
                   printf("Preorder traversal of the Splay Tree is :\n");
                   Preorder_traversal(ROOT); //Function to print nodes in Preorder
                break;

                // print all the nodes in Inorder
                case 5:
                  printf("Inorder traversal of the Splay Tree is :\n");
                  Inorder_traversal(ROOT); //Function to print nodes in Inorder
                break;

                //print nodes in Postorder
                case 6:
                  printf("Postorder traversal of the Splay  tree is :\n");
                  Postorder_traversal(ROOT) ; //Function to print nodes in Postorder
                break;

                // exit case
                case 0:
                   printf("time to exit thanks\n");
                   _Exit(0);

            // default case
            default:
              printf("\n invalid input\n");
           break; // no need break after default case I use it only for readability
         }
    } /** END OF WHILE LOOP */

     return 0;// signal to operating system everything works fine

} /** End of main function */


/**
    A utility function to create new Node in heap so I can called
    it each time I need new node take the value to be inserted
    in the new node as argument  */

struct node* CreateNewNode(int value )
{
    /* local variable of type struct Node declaration */
    struct node  *newNode;

    /* allocate memory dynamically for node using malloc C function */
    newNode = (struct node *)malloc (sizeof(struct node));

    /* Error handling */
    if(newNode == NULL)
    {
        printf("error in allocating memory\n");
    }

     /* adding information to node */
    newNode ->  key  =   value;
    newNode ->  right =  NULL;
    newNode ->  left =   NULL;
    newNode ->  parent = NULL;

    return   newNode;  // return newly created node to place where it been be called

}  /** END of CreateNewNode() */


/*
   Utility function to insert new node in a splay tree

   In AVL tree insertion, we used rotation as a tool to do balancing after
   insertion . In a splay tree we use splaying, tools to set newly inserted
   nod as root.
   We normally insert a node in a splay tree and splay it to the root.
   Here is pseudocode for insert
   INSERT(n)
    temp = root
    y = NULL
    while temp != NULL
        y = temp
        if n.data < temp.data
            temp = temp.left
        else
            temp = temp.right
    n.parent = y
    if y==NULL
        T.root = n
    else if n.data < y.data
        y.left = n
    else
        y.right = n

    SPLAY( n)

 for reference i will check links blow

 (1) (Jenny's lectures CS/IT NET&JRF) youtube
    very well explained
    https://www.youtube.com/watch?v=qMmqOHr75b8
    https://www.youtube.com/watch?v=1HeIZNP3w4A
(2) very well explained
    https://www.codesdope.com/course/data-structures-splay-trees/
(3) https://www.youtube.com/watch?v=IBY4NtxmGg8 */

void insert(int key)
{
    /*
       Follow standard BST insert steps to first insert the node
       first create the node to insert for that call CreateNewNode( );
       which return new created node.
       I need 3 variable of type struct node n for get new node X to keep
       value of and y is used for keeping track of the last non-NULL node
       which will be n's parent. later after added */

	struct node *n, *x, *y;
	n = CreateNewNode(key); //get new node
	x = ROOT;
	y = NULL;

    /* Go through the tree and loop until a leaf(NULL) is reached. */
	while(x != NULL)
    {
        y = x; // keep track of the last non-NULL node

        if(n -> key < x -> key)  /* if key is lesser go to left subtree */
        {
			x = x -> left;
        }
		else   /*  if key is grater go to right subtree */
        {
            x =  x -> right;
        }
    }

	// now we  have reached leaf(NULL) we are ready to add

  // update  n parent
  n -> parent = y;

    /*
       if Y is NULL that is mean this is first node added
        as the root because its root no need to call splay function */

	if(y == NULL) // y is parent of n
    {
		ROOT = n; // updating global ROOT ( newly added node is the root now)
	}

	/* if not NULL let see which side we can add
	   if data of child is less than its parent,*/
	else if(n -> key < y -> key)
    {
		y -> left = n;   /* insert as left child */
	}

  /* else if data of child is greater than its parent,*/
  else if(n -> key > y -> key)
  {
		y -> right = n;  /* insert as right child */
  }
  else{return;}    /* only for handling duplicate cases i can also write clear
	                   massages to user that duplicate not allowed here */

  /*
    until here insertion part is done, We have inserted the new node
    to splay tree in a similar way as we do in a normal binary
    search tree, now we need to call splay(n) function and pass (n)
    the node which newly added as argument to splay it to the root.
     */

	splay(n); //call splay(n) to set n as the new root */

} /* END OF insert */


/*
   function to Splay given node to root

   Splaying:--?
   "Splaying" is a process in which a node is transferred to the root by
   performing suitable rotations. In a splay tree, whenever we access any
   node, it is splayed to the root.  We will start by passing the tree (T)
   and the node which is going to be splayed (n). SPLAY(T, n) We have to splay
   the node n to the root. we will use a loop and perform suitable rotations
   and stop it when the node n reaches to the root.

   Here is pseudocode

   while n.parent != NULL //node is not root

   Now, if the node n is the direct child of the root,
   we will just do one rotation, otherwise, we will do
   two rotations in one iteration.

    if n.parent == T.root //node is child of root, one rotation

      if n == n.parent.left //left child
        RIGHT_ROTATE(T, n.parent)
      else //right child
        LEFT_ROTATE(T, n.parent)

    else //two rotations

    To perform two rotations, we will first set a variable p as
    the parent of n and a variable g as grandparent of n.

     p = n.parent
     g = p.parent

    Now, we just have to do the rotations.

   if  n == n.parent.left and p ==  p.parent.left  //both are left children

        RIGHT_ROTATE(T, g)
        RIGHT_ROTATE(T, p)

      else if   n ==  n.parent.right and  p ==  p.parent.right  //both are right children

        LEFT_ROTATE(T, g)
        LEFT_ROTATE(T, p)

      else if n ==  n.parent.right and p == p.parent.left

        LEFT_ROTATE(T, p)
        RIGHT_ROTATE(T, g)

      else
        RIGHT_ROTATE(T, p)
        LEFT_ROTATE(T, g)

 for reference
 Same  reference  above */

void splay(struct node *n)
{
     /*
     to splay the node n to the root., we will use a loop and perform
    suitable rotations and stop it when the node n reaches to the root
    because  after if n is root we haveonly one node in tree no need to splay */

     while(n -> parent != NULL) //node is not root also while(n  != root)
     {
         /* Zig: node n is the direct child of the root (the node has no grandparent)
    	       one rotation */

         if(n -> parent == ROOT)
         {
             // node is a left child of its parent (we do a right rotation to parent)
             if(n == n -> parent -> left)
             {
                 right_rotate(n -> parent);  // right rotate the parent
             }
             else // node is a right child of its parent (we do a left rotation to parent).
             {
                 left_rotate(n -> parent); // left rotate the parent
             }
         }

        //two rotations
         else
         {
           /* Node has both parent and grandparent. There can be following subcases.
    	     Zig-Zig and Zag-Zag Node is left child of parent and parent is also left
    	       child of grand parent (Two right rotations) OR node is right child of its
    	       parent and parent is also right child of grand parent (Two Left Rotations).
               To perform two rotations, we will first set a variable p as the parent of n
               and  a variable g as grandparent of n. */

                 struct node *p = n -> parent; //node n parent
                 struct node *g = p -> parent; //node n grandparent

                 // Now, we just have to do the rotations.

                 if(n == n -> parent -> left && p == p -> parent -> left) { //both are left children

                  right_rotate(g);  // right rotate the grandparent
                  right_rotate(p);  // right rotate the parent
                 }
                 else if(n == n -> parent -> right && p == p -> parent -> right) { //both are right children

                 left_rotate(g); // left rotate the grandparent
                 left_rotate(p); // left rotate the parent
                 }
                 else if(n == n -> parent -> right && p ==  p -> parent -> left) {

                 left_rotate(p);  // left rotate the parent first
                 right_rotate(g); // right rotate the grand parent
                 }

                 else if(n == n -> parent -> left && p ==  p -> parent -> right) {

                 right_rotate(p); // right rotate the parent first
                 left_rotate(g);  // left rotate the grandparent
                 }
         }
     }
} /* END of splay */


/*
 function to delete node in Splay tree using (Top Down Splaying approach)
 in Top Down approach to delete a node  we do the flowing  steps :-

 (1)  we first splay that node to the root
 (2)  after this we delete the root which give us two subtree
      mean (split the tree int two part left subtree and right subtree)
(3)  we find the the maximum node in left subtree and splay it to the root
    (splay the node have the maximum value in left subtree)
(4) last step we attach the right subtree as the right child of the left subtree

for reference in future i will check the same reference above
*/

void  Top_Down_Splaying_Delete(int data)
{
    /*
        step (1) we slpay the node to the root for that I call
         search function and pass data for node to be deleted
         tree_search(data); search function will search for the
         node if the node been found will first splay it to root
         and return  me the address of new root if the node is not
         found in that case will splay the last not null node and
         return the address of that node */

     struct node  *node_to_delet = tree_search(data);

      /* now let check if node return by search function key == data
         is mean the node is found we can go a head and delete */

      if (node_to_delet -> key != data)
       {
           // printing clear message to user that the node is not found
           printf("\nthe node with value %d is NOT nod found is Splay tree\n",data);
           return ; // then return no need continue
       }

    /*  step (1) we store the right subtree and left subtree in
        different variable of type node then delete the root */

    struct node *left_Subtree, *right_Subtree;

    left_Subtree = ROOT -> left;  // keep left sub tree before deleteion root

    right_Subtree = ROOT -> right; // keep left sub tree before deleteion root

    free(ROOT); // delete root mean the node is deleted now

    if (left_Subtree != NULL)   /* have to be NULL because its root now
                                   and parent of root is always NULL */
    left_Subtree ->  parent = NULL;

     if (right_Subtree != NULL) /* have to be NULL also because its root now
                                   and parent of root is always NULL */
     right_Subtree ->  parent = NULL;

    /* step (2)let find the maximum node of the left subtree and
      splay it to the root. but what if left sub tree is NULL in
      that case the right subtree will be root of tree */

       if (left_Subtree != NULL)
       {
           struct node *max = tree_maximum(left_Subtree); // maximum node in left sub tree;

           //no we have the maximum let splay it to root

           splay(max);  // call splay function

           /* last step is to attach the right subtree as the right child
              of the left subtree  we case easily do that because now
              max -> right is NULL now */

           max -> right  = right_Subtree; //link connect

          ROOT  =  max ; // left subtree is the  new root now
       }

       else //if left sub tree is NULL in this case set root as right subtree
       {
           ROOT = right_Subtree ; // right subtree is the new root now
       }

} /* Top_Down_Splaying_Delete */


/**
  Function to find maximum value in splay tree
  return  address of maiximum value splay tree
  for refrence (mycodeschool)
*/

struct node *tree_maximum(struct node *x)
{
	while(x -> right != NULL)
	{
		x = x -> right;
	}
	return x; // return the address of node that the have maximum  value in BST

} /* END tree_maximum */



/**
  Function to find minimum value in splay tree
  return  address of maininimum value splay tree
  for refrence (mycodeschool)
*/

struct node *tree_minimum(struct node *x)
{
	while(x -> left != NULL)
	{
		x = x -> left;
	}
	return x; // return the address of node that the have minimum  value in BST

} /* END ree_minimum */


 /*

   function to search node in splay tree If the node is present in tree
   (that is mean search is successful done, it will call splay function
    so the node that is found is splayed and becomes the new root of tree)
   after that this function returns the new root of Splay Tree to place been called.
   else is not mean the node is not found in tree so will return NULL to place been called.

   There are following cases for the node being accessed

   (1) Node is root We simply return the root, we don’t even search it because
    we search only while root is not null

   (2) Zig: Node is child of root (the node has no grandparent). Node is either a
    left child of root (we do a right rotation) or node is a right child of its parent
    (we do a left rotation).

   (3) Node has both parent and grandparent. There can be following subcases.

    (.3.a) Zig-Zig and Zag-Zag Node is left child of parent and parent is also left
     child of grand parent (Two right rotations) OR node is right child of its parent
     and parent is also right child of grand parent (Two Left Rotations).

   (.3.b) Zig-Zag and Zag-Zig Node is left child of parent and parent is right child
    of grand parent (Left Rotation followed by right rotation) OR node is right child
    of its parent and parent is left child of grand parent (Right Rotation followed by
    left rotation).*/

struct node *tree_search(int key)
{
    /*  first Follow standard BST search operation
        I need 2 variables of type struct node.
        node * n to keep value of root and node * y
        is used for keeping track of the last non-NULL
        node which will be the new root if the node which
        we are searching not found in the tree. */

    struct node *n ,*y;
	n = ROOT;  // n is root
	y = NULL; // y is NULL first time

	/*  while n is not NULL loop and search
	    for the node until we reach leaf node */

	while(n != NULL && n -> key != key)
	{
	    y = n; //  keep track of the last non-NULL node

	  /* If the key to be search is smaller than the root's key,
	     then it lies in left subtree search in left subtree */

		if(key < n -> key)
		{
			n = n -> left;
		}
		else
		{

           /* If the key to be search is greater than the root's key,
              then it lies in right subtree search in right subtree */

			n = n -> right;
		}

	}

	/*
	 now we have reach leaf node which is null so let see
	  if root is NULL mean the node is not found in tree in
      that case we splay last non-NULL node(mean the node
      which just before leaf node )splay(last non-NULL node);
      else node is found in the tree we call splay function and
       pass the node splay(n); to splayed to the root  .
       lastly in both cases  we return the new root
	 */

	if (n == NULL) //  not  found let pass last non-NULL node
	{
        splay(y);  // call splay function
        return y;  // return the new root
	}

   //  well done is found let call spaly function and pass the node
   splay(n);  // call splay function
   return n;  // return the new root

} /* END tree_search */


/*
*   A utility function for Left Rotation
 * Lets say y is x's right child. Left rotate x by making y, x's parent
 * and x, y's left child. y's left child becomes x's right child.

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
   then we need to put y to the position of x. We will first change the
   parent of y to the parent of x - y.parent = x.parent.
   After this, we will make the node x the child of y's parent instead of y.
   We will do so by checking if y is the right or left child of its parent. We will also check if y is the root of the tree.

   y.parent = x.parent
   if x.parent == NULL //x is root
   Root = y
  else if x == x.parent.left // x is left child
  x.parent.left = y
  else // x is right child
  x.parent.right = y

  At last, we need to make x the left child of y.

  y.left = x
  x.parent = y
 */

void left_rotate(struct node *x)
{
	struct node *y;

	y = x -> right;   //let's mark the right child of x as y.

	x -> right = y -> left; //The left child of y is going to be the right child of x

    /*
      The left child of y is going to be the right child of x - x.right = y.left.
	   We also need to change the parent  of y.left to x.
	   We will do this if the left child of y is not NULL. */

	if(y -> left != NULL)
    {
		y -> left -> parent = x;
	}

	/* Then we need to put y to the position of x. We will first change
	   the parent of y to the parent of x - y.parent = x.parent.
	   After this, we will make the node x the child of y's parent instead of y.
       We will do so by checking if y is the right or left child of its parent.
       We will also check if y is the root of the tree.  */

	y -> parent = x -> parent;

	if(y -> parent == NULL)  //if was x root y will be the root now as y will move to place of x
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

} /* END left_rotate */


/*
 * A utility function for right Rotation
 *
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

	y = x -> left;      // let's mark the left child of x as y.

	x -> left = y -> right; //The right child of y is going to be the left child of x

	if(y -> right != NULL)
    {
		y -> right -> parent = x;
	}

	/* Make x's parent y's parent and y, x's parent's child */

	y -> parent = x -> parent;

	if(y -> parent == NULL) //if was x root y will be the root now as y will move to place of x
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

} /* END right_rotate */



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
    if (rootNode == NULL)
        return;

      printf("%d ",rootNode -> key);           /* first print the data from root  */

     Preorder_traversal(rootNode -> left);   /* Visit left subtree  */

     Preorder_traversal(rootNode -> right);    /* Visit right subtree */

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
	/* base condition for recursion  if tree/sub-tree is empty, return and exit */
    if (rootNode == NULL)
        return;

   Inorder_traversal(rootNode -> left);   /* first Visit left subtree  */

    printf("%d ",rootNode ->key);           /* then print the data  */

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
      * Visit root node (so root node will print as last element) */

void  Postorder_traversal(struct node* rootNode)
{
	/*
    base condition for recursion
    if tree/sub-tree is empty, return and exit */
   if (rootNode == NULL)
       return;

  Postorder_traversal(rootNode -> left);   /* Visit left subtree  */

  Postorder_traversal(rootNode -> right);    /* Visit right subtree */

  printf("%d ",rootNode -> key);           /*  print the data from root  */


   // this goes on until root node == null which is base condition
} /** END of Postorder_traversal() */

/*
  function to replace node u with node v
  Now, we want to place the subtree rooted at node v
  in place of the subtree rooted at node u. It means
  that we need to make v the child of the parent of u i.e.,
  if u is the left child, then v will become the left child
  of u's parent. Similarly, if u is the right child, then v
  will become the right child of u's parent
  It is also possible that u does n't have any parent i.e.,
  u is the root of the tree . In that case, we will simply
  make v as the root of the tree.
  if u.parent == NULL //u is root
  T.root = v
  Now, we will check if u is the left child or the right child. Accordingly, we will place v.

 If u is the left child, then the left of u's parent will be u i.e.,
 u == u.parent.left will be true and we will make v as its left child i.e., u.parent.left = v.

 if u.parent == NULL
  ...
  else if u == u.parent.left //u is left child
  u.parent.left = v
 else //u is right child
  u.parent.right = v

 Lastly, we also need to point the parent of v to the parent of u.

 if v != NULL
  v.parent = u.parent

 So, the overall code would be*/

void  Splay_transplant(struct node *u, struct node *v)
{
	if(u -> parent == NULL)//u is root
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

     //Lastly, we also need to point the parent of v to the parent of u.

	v -> parent = u -> parent;

} /* END OF Splay_transplant */


/*
     function to delete node in Splay tree using (Bottom-up Splaying approach)
     in Bottom-up approach to delete node in splay tree we do the flowing :-

     preform standard BST deletions by first searching for node in tree if is
     found then search is successful now delete that node using  BST deletions
     step and splay on the parent of the node which is just deleted
     splay(on the parent of node which is just deleted).

     else if node is not found in the tree then nothing to delete just splay
     last non-NULL node. splay(last node before we reach NULL while searching)

     for Reference
     http://lcm.csa.iisc.ernet.in/dsa/node94.html */

void  Bottom_up_Delete(int data)
{
    printf(" this function is not 100%% complate");

    /* z to store node to be deleted after search it, nodParent to
       sore z parent which will be splay it to root after z been
       deleted  y to store the minimum value in the right sub tree
       node x is to keep track of the node which replace y */

    struct node *z, *nodParent, *y, *x;

    /*
     preform standard BST deletion so first let search
     for node in splay tree first and for that i call
     search function and pass the key
    */

    z = tree_search(data);  // search for node

    nodParent  = z -> parent; // store parent


     /* now let check if node return by search function
        key == data if so is mean the node is found in
        the tree we can go a head and delete it */

        if (z -> key != data)
       {
           printf("the  node with value %d is NOT found is Splay tree ::\n",data);
           return ; // we are done
       }


     /*  node to be deleted has no children its was only the node in
	    the tree just simply set the root to null and delete the node */

    if(z -> left == NULL && z -> right == NULL)
    {
        ROOT = NULL; // set root to null
        free(z);  // delete the node
        return;  // we are done
    }

	else if(z -> left == NULL) // node to be deleted has no children or only right
    {
		x = z -> right; // x is used to keep track of the node which replace y.
        nodParent = z -> right -> parent;
        Splay_transplant(z, z -> right); // TRANSPLANT z node with it right child
	   splay(nodParent);
	   return;
	}

	else if(z -> right == NULL)
    {
		x = z -> left;     // only left child
        nodParent = z -> left -> parent;
		Splay_transplant(z, z -> left); // TRANSPLANT z node with it left child
	   splay(nodParent);
	   return;
	}

	else // node to be deleted has both children
	{

		y = tree_minimum( z -> right);  // find the minimum element in right subtree

		x = y -> right;

		if(y -> parent == z) // y is direct child of z
        {
			x -> parent = y;
		}
		else    // y is not direct child of z
		{

		     /*
               If y is not the direct child of z, we will first transplant
		        the right subtree of y to y TRANSPLANT( y, y.right).
                After this, we will change the right of y to right of z
                y.right = z.right
                y.right.parent = y
                After that we can transplant y to z
                in both cases (whether y is direct child or not). */


			Splay_transplant(y, y -> right);

			y -> right = z -> right;

			y -> right -> parent = y;
		}


		Splay_transplant(z, y);

		 /* Next, we will put the left of z to left of y */

        y -> left = z -> left;

		y -> left -> parent = y;

	}

	 /*  At last, we will call splay function and
	      pass node z parent  splay(nodParent) */

	      splay(nodParent); // splay the parent of been deleted to the root

} /* END OF  Bottom_up_Delete () */

