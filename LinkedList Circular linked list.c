

/**
*  Doubly Circular linkedlist data structure implementation
*
* for reference only india mum (Jenny's letures cs) and geeks for geeks data strcture
*/

#include <stdio.h>
#include <string.h>
#include "stdlib.h"
#include <cs50.h>

// A linked list node

struct node
{
    int data;

    struct node * right;
    struct node * left;
};


struct node * first = NULL;  //first node //or  head

struct node * last = NULL;  //last node //or  tail

void append(int new_elemet);               // add new element at the end

void insert_in_Begining( int new_elemet);  //add new element at the begining

void insert_at_possition(int value , int possition); //add new element at thegiving possition

int length(void);                          // find length

void trevers(void);                       //print all the element

void print_Reverse();                      //print all the element in Reverse ordere using loop


void removee(int value) ;                   //remove the given value from the list if found

int len; // to store length of the linked list latter

void Delete_node_at_possition(int possition);  //delete node at the given posstion

void Delete_node_at_beging(); //delete node at beging(always remove first node)

void Delete_node_at_end();   ////delete node at the end (always remove last node)

void Reverse();   // Reverse the linked list using loop

void Reverse_using_recursion( struct  node * p); // Reverse the linked list using recursion

void print_using_recursion( struct  node * first);  // print all the element using recursion

void Reverse_print_using_recursion( struct  node * temp);  //print element in reverse order using recursion



int main(int argc, char* argv[])
{
    while(1)
    {
        printf("\nsingle linked list opeartion \n");
        int ch;//for swtich  to chooce choice
        int element; // element
        int possition; //possition

         printf("1 : append insert node at end :\n");
         printf("2 : insert node at the begining of the list :\n");
         printf("3 : insert at possition :\n");
         printf("4 : Delete node_at_beging (first node) :\n");
         printf("5 : Delete node_at_possition :\n");
         printf("6 : Delete node_at_end (last node) :\n");
         printf("7 : remove value :\n");
         printf("8 : print all the element in linked list using loop\n");
         printf("9 : print all the element in linked list using recursion(function is not complete for now) :\n");
         printf("10 : print all the element in reverse order using loop :(function is not complete for now) :\n");
         printf("11 : print all the element in reverse order using recursion (function is not complete for now) :\n");
         printf("12 : Reverse the linked list using loop (function is not complete for now) :\n");
         printf("13 : Reverse the linked list using recursion(function is not complete for now) :\n");
         printf("14 : length of the linked list  :\n");

         printf("0 : quit :\n");

         ch = get_int("input your choice :");

         switch (ch)
         {
            case 1:
            element = get_int("enter elemt to insert  at the end: ");
            append(element);
            break;

            case 2:
             element = get_int("enter elemt to insert at the beging : ");
             insert_in_Begining(element);
             break;

              case 0:
              printf("time to exit thanks\n");
              _Exit(0);

              case 3:
              element = get_int("enter value to insert  :");
              possition = get_int("enter the possition : ");
             insert_at_possition(element , possition);
              break;


             case 4:
             Delete_node_at_beging();  //delete first node
             break;

             case 5:
             possition = get_int("enter the possition which you want to delete : ");
             Delete_node_at_possition(possition); // dele element at posstion
             break;

             case 6:
             Delete_node_at_end(); //delete the last node
             break;

             case 7:
             element = get_int("inser value to remove from the linked list: ");
             removee(element);
             break;

              case 8:
              trevers(); //print or display function using loop
              break;

              case 9:
             // print_using_recursion(first); //print or display function using recursion method
              break;

              case 10:
             // print_Reverse(); //print or display node in reverse order using loop using loop
              break;


              case 11:
             // Reverse_print_using_recursion(first); //print element in reverse order using recursion
              break;

              case 12:
             // Reverse(); //revese element in the linked list using loop
              break;

              case 13:
             // Reverse_using_recursion(first);//revese element in the linked list using recurssion
              break;

              case 14:
              len = length();
              if (len == 0)
              {
                  printf("linked list is empty no node to count at all\n");

              }
              else
              {
               printf("length is  : %d\n",len);
              }
              break;





             default:
             printf("\ninvalied input\n");
             break;
         }
    }
}


/**
*  insert element at the end of doubly linked list
*
* for reference only india mum (Jenny's letures cs) and geeks for geeks data strcture
*/

void append( int new_elemet)
{
    //first I create node that I want add to linked
    struct node  * newNode;

 // allocate memeory
    newNode = (struct node *)malloc (sizeof(struct node));

    if(newNode == NULL)
    {
        printf("eror in ellocting memory\n");
        return;
    }

    //adding information to node

    newNode -> data = new_elemet;
    newNode -> right = NULL;
    newNode -> left = NULL;

    // now after create my node i check first if list is empty  this will be first node update first and last to be point to new node
    if (first == NULL)
    {

        first =  last = newNode;  // insert first node in list

        first -> left = newNode;  // this condtion can be writen in difrren way since note is point to it self

        last ->  right = newNode; //// this condtion can be writen in difrren way since note is point to it self
    }


    else
    {

          /* if node is not  empty  then allready  linked list have some element we have to update 5 nodes
          *  last -> right
          *  newNode -> left
          *  newNode -> right
          *  first ->  left
          *  last
          */

          last -> right   = newNode;  // right side contection

          newNode -> left = last;    // left side contection

          newNode -> right = first;  // connect last node to first node

          first -> left = newNode;  // connect first node to last node

          last = newNode;          // move last one step ahead to point to the node newNode
}

            /*before closing function to make sure that we create everything right print
            *   (last -> right -> data )always should first element in list
            *   and (first _> left -> data) always should  print last element in list
            */

            printf(" just to confirm  this point to first element %d \n",last -> right-> data);

            printf(" just to confirm  this point to last element %d \n",first -> left-> data);



}


/**
* insert new element at the beginning of the linked list
*
* for reference only india mum (Jenny's letures cs) and geeks for geeks data strcture
*/

 void insert_in_Begining( int new_elemet)
 {
    //first I create node that I want add to linked

    struct node  * newNode;

    // allocate memeory daynamicly

    newNode = (struct node *)malloc (sizeof(struct node));

    if(newNode == NULL)
    {
        printf("eror in ellocting memory\n");
        return;
    }

    //adding information to node

    newNode -> data = new_elemet;
    newNode -> right = NULL;
    newNode -> left = NULL;

    // now after create my node i check first if list is empty  this will be first node update first and last to be point to new node
    if (first == NULL)
    {
        first =  last = newNode; // insert first node in list

        newNode -> left = newNode;
        newNode ->  right = newNode;

      /***
       * the above 2 line can be writen in difrren way since note is point to it self
       * newNode -> left = newNode;
       * newNode ->  right = newNode;
       * first-> left = first;
       * first -> right = first;
       * last -> left = last;
       * last-> right = last;
       * and so on
       *
       **/
    }

    else
    {

          /*  now we are sure node is  not empty allready  linked list have some element
          *  so we have to update 5 nodes and add this new node in the beging
          *  newNode -> right
          *  newNode -> right
          *  first ->  left
          *  last -> right
          *  update first as well
          */

          newNode -> right = first;  // connect last node to first node

           newNode -> left = last;  // right side connection

          first -> left = newNode;  // connect first node to last node

          last -> right   = newNode; // left side connection

          first = newNode;          // move first one step back to point to the node newNode
}

            /*before closing function to make sure that we create everything right print
            *   (last -> right -> data )always should first element in list
            *   and (first _> left -> data) always should  print last element in list
            */

            printf(" just to confirm  this point to first element %d \n",last -> right-> data);

            printf(" just to confirm  this point to last element %d \n",first -> left-> data);


}


/**
* insert the given value at the given position
* adding node in the middle
*
* only in given possition not after
*
* for reference only india mum (Jenny's letures cs)
*/

void insert_at_possition(int value , int possition)
 {
     // for this function first I go and write code to leng() function so i can uese here

    struct node * newNode ,*temp;  // I will uese temp variable to loop until i reach the possition then i add the newnode

    temp = first;

    int i =1; // counter

    len = length(); // lengh of linked list

     //if  pssotion is biger than length  or less than 1 not valied

     if(possition > len + 1 || possition  < 1)
     {
         printf("invalied location\n");

         return ;
     }

    else if (possition == 1) // if posstion is 1 I call insert_in_Begining(value); function which alwys insert at first possition
    {

           insert_in_Begining(value);
    }
    else if (possition == len) // if posstion is  ==  len  is mean want add at end of list so I call append(value); function which alwys insert at last possition
    {
           append(value);

    }
    else
    {

     //now I create node that I want add to linked and allocate memeory daynamicly for it

      newNode = (struct node *)malloc (sizeof(struct node));

      if(newNode == NULL)
      {

         printf("eror in ellocting memory\n");
         return;
      }

        //adding information to node

        newNode -> data = value;
        newNode -> right = NULL;
        newNode -> left = NULL;

        // move temp until possition -1 so you can add in the possion

         while(i < possition - 1 )    //send control to the posstion -1
         {
            temp = temp -> right;

            i++;
         }

          /**
           * we are now in posstion-1 but this posstion is not the last possition  so last varible will not upadte also first variable will not update
           * we only need to update 4 node but we have to be careful in this point
           *  upate newnode first always for more understanding draw node and for refress mind back to india mum vedio
           */

          newNode -> left = temp;

          newNode -> right =  temp -> right;

          temp -> right -> left = newNode;

          temp -> right = newNode;
}

}



/**
* to find linked list length
*
* return number of node in linkedlist
*
*/

int length()
{
    struct  node *temp ;   //we need temp variable to move in loop while counting the node

    temp = first;   //temp  is on first node now

    int count = 0; // counter

    if(first == NULL)  // if list empty then we dont have to count
    {
    //   printf("linked list is empty no node to count at all\n");
      return 0;
    }

    /**
     * else now  we are sure list is not empty so we count node  and move temp
     * to second node and count agin  as well in loop until we reach to last node
     *
     **/

     while (temp != last)
      {
         count++;

         temp = temp -> right; // move control to nex element
     }

      count = count +1 ; // just to include the last node so have to add one to count befor return


     return count;  // after done counting return number of node

}

/**
 * remove the given value from list
 *  check from arbic channel Hard Code
*/

 void removee(int value)
 {
    struct node *temp;  // I will uese temp variable to loop until i reach the possition then remove node

      temp = first; // temp point to first node

     if(first == NULL) //list is empty
     {
         printf(" linked lis is empty no node to remove\n");
         return ;
     }

     // if only one value in the linked but that  value is not value given so I have to handle the error  in this caes

     if (first -> left == first && first -> data != value)
     {
         printf(" %d not found in the linked list \n",value);
         return;
     }


      /* if the given value given  is in the  first node but the linkedlist have more than one node
      *   or the value given is in the first node and the linked lis have only one
      *   code blow will handle the both cases  after writing the condition only call
      *   Delete_node_at_beging(); function which remove first node
      *  also can writen in difrrent way also
      */

     else if (first -> left == last && first -> data == value)  //if the value in the first index
     {
          Delete_node_at_beging();

     }


      /** if the given value is the last node but the linkedlist have more than one node
       * so I called  Delete_node_at_end() function which remove last node
      */

     else if (last -> right == first && last -> data == value)  //if the value the last index
     {
          Delete_node_at_end();

     }

     else
     {
              //loop unitl find the value

               do
               {

                     temp = temp -> right; // move temp one step ahead
               }
               while( temp != first && temp -> data != value );

          //  reach the end of list but value is not found

          if (temp == first)
          {
             printf(" %d not found in the linked list \n",value);
             return ;
          }


    /**
     * now we have found the value and  temp is  on node which we want remove
     * so befor free or delete temp we must first connect node bfore the value to node after the value then delete temp
     * for that we need to update 2  nodes
     * can be writen in many ways also
     *  temp -> left -> right = temp -> right;
     * temp -> right -> left = temp -> left;
     **/

        temp -> left -> right = temp -> right;  // left side connection

        temp -> right -> left = temp -> left;  // // right side connection

        temp -> right = NULL;

        temp -> left = NULL;

      free(temp);

}
}



/**
* delete the given value at the given position
* delete node in the middle or last or even in first of the node
*
* for reference only india mum (Jenny's letures cs) and geeks for geeks data strcture
*/

void Delete_node_at_possition(int possition)
 {

   // for this function first I go and write code to leng() function so i can uese here

    struct node *temp;  // I will uese temp variable to loop until i reach the possition then i delete that node

    temp = first; // temp point to first node

    int i =1; // counter

    len = length(); // lengh of linked list

     //if  pssotion is biger than length  or less than 1 not valied

     if(possition > len  || possition  < 1)
     {
         printf("invalied location\n");

         return ;
     }

    else if (possition == 1) // if posstion is 1 I call Delete_node_at_beging(); function which alwys delete node at first possition
    {

           Delete_node_at_beging();
    }
    else if (possition == len) // if posstion is  ==  len  is mean want delete at end of list so I call Delete_node_at_end(); function which alwys delete node at last possition
    {
           Delete_node_at_end();

    }
    else
    {

        // move temp until possition  so you can delete node in the given  possion

         while(i < possition )    //send control to the posstion
         {
            temp = temp -> right;

            i++;
         }

    /**
     * now we are in posstion temp = node which in posstion  so befor free or delete temp we must first connect  node bfore which possition to node after the posstion then free temp
     *
     * for that we need to update 2  nodes
     * can be writen in many ways also
     *  temp -> left -> right = temp -> right;
     * temp -> right -> left = temp -> left;
     **/

        temp -> left -> right = temp -> right;  // left side connection

        temp -> right -> left = temp -> left;  // // right side connection

        temp -> right = NULL;

        temp -> left = NULL;

      free(temp);
    }
}


/**
*
* delete the  first  node in linkedlist
*
* for reference only india mum (Jenny's letures cs)
*/

void Delete_node_at_beging()
{

    struct node * temp; // use temp to free node latter

      temp = first;// temp point to first node

    //if list empty
    if( first == NULL)
    {
       printf("list is empty no node at the beging to delete");
       return;
    }

    /** if we have only one node in list we free the node in this case first = last = NULL
    * this condtion can writen in many diffrent ways first ->  right ==  first // last ->  right ==  last and so on
    * but the point is that first and last are poting to the same place
    */

    if( first ->  right ==  first )
    {
       first =  last = NULL;
       temp -> right = NULL;
       temp -> left = NULL;
       free(temp);
    }
    else
    {
    /**
     * now we are sure that list have more than one node in this case we delete first node
     * and move first varible point to second one so the secode node will be the first after we delete the first one
     *  for that we nedd to update 3  nodes
     * can be writen in many ways also
     * first = first -> right;
     * first -> left = last;
     * last -> right = first;
     **/

        first = first -> right;

        first -> left = last;

        last -> right = first;

       temp -> right = NULL;

       temp -> left = NULL;
       free(temp);
    }
}


/**
*
* delete the  last  node in linkedlist
*
* for reference only india mum (Jenny's letures cs)
*/


void Delete_node_at_end()
{
    struct node * temp; // use temp to free node latter

      temp = last;// temp point to the last node

    //if list empty

    if( last == NULL)
    {
       printf("list is empty no node at the end to delete");
       return;
    }

    /** if we have only one node in list we free the node in this case first = last = NULL
    * this condtion can writen in many diffrent ways first ->  right ==  first // last ->  right ==  last and so on
    * but the point is that first and last are poting to the same place
    */

    if( last ->  right ==  last )
    {
       first =  last = NULL;
       temp -> right = NULL;
       temp -> left = NULL;
       free(temp);
    }
    else
    {

    /**
     * now we are sure that list have more than one node in this case we will delete last node
     * and move last varible  one step back to point last -1  so the last -1 node will be the last after we delete the last one
     *  for that we nedd to update 3  nodes
     * can be writen in many ways also
     *
     * last = last -> left;
     * last -> right = first;
     * first -> left = last;
     **/

        last = last -> left;       // move last one step back

        last -> right = first;     // connect  last node to first node

        first -> left = last;      // connect  first node to last node

        temp -> right = NULL;

        temp -> left = NULL;

       free(temp);
    }
}



/**
* to print all the element in the linked list
*
* for reference only india mum (Jenny's letures cs)
*
*/


void trevers()
{
    //we need temp variable to move in loop
    struct  node *temp ;

     temp = first;   //temp  is on first node now

    if(first == NULL)  // if last empty then we dont have any node print
    {
      printf("linked list is empty no node to print\n");
      return;
    }


    /**
     * else now list is not empty so print data on first node and move list
     * to second node print data  as well in loop until we reach end of list
     *
     **/

      while (temp != last)
      {
         printf("%d---> ",temp -> data);

         temp = temp -> right; // move control to nex element
     }
      printf("%d--->",temp -> data); // print the last element
     printf("\n");

     /**
      *  also this can be writen  as blow
      *
      * do
      *{
      *     printf("%d---> ",temp -> data);
       *    temp = temp -> right;
       * }
       * while (first != last);
       **/

}



/**
* reverse order all the element in the linked list  in reverse order
*
* for reference   india channel (mycodeschool) also arab channel( Hard code)
*/

void print_Reverse()
{
    struct  node *temp ;

     temp = first;

    if(first == NULL) //emlpty lsit exit
    {
      printf("linked list is empty no node to reverse \n");
      return;
    }
    // go to the last node
      while (temp ->right != NULL)
      {
         temp = temp -> right;
     }
     //traversing back using left pointer
     printf("Reverse  : " );
      while (temp  != NULL)
      {
         printf("%d --->",temp -> data);
         temp = temp -> left;
     }
     printf("\n");

}



/**
* to print all the element in the linked list using recursion
*
* reference india channel (mycodeschool)
*/
void print_using_recursion( struct  node * temp)
{
    if(temp == NULL)//Exit codition
    {
      return;
    }
    else
    {
        printf("%d -->", temp -> data);  // first print the in the node which is first node
        print_using_recursion(temp -> right); //Recursive call to move to next node

    }
}



/**
* to print all the element in the linked list  in reverse order using recursion
*
* reference india channel (mycodeschool) i got the idea from single linked lis letture
*/

void Reverse_print_using_recursion( struct  node * temp)
{
    if(temp == NULL)//Exit codition
    {
      return;
    }
    else
    {
        Reverse_print_using_recursion(temp-> right); //Recursive call to move to next node  first

        printf("%d -->", temp -> data);  // after reach to last node and first == NULL
                                          // will start printing from last to first in reverse order

    }
}



/**
* reverse order all the element in the linked list  in reverse order using loop
*
* for reference arab channel india mum (Jenny's leturess) Reverse a doubl linked lsit( Hard code )  also  india channel (mycodeschool)
*/

void Reverse()
{
    struct  node * prves = NULL ; //only to keep address of last node and assgin it to first at end of loop later
    struct  node * cuent = first ;  //curnent
    struct  node * nextNode = NULL ;    //next

    if(cuent == NULL)
    {
    printf("linked list is empty no element to Reverse\n");
    }

      while (cuent != NULL)
      {
          nextNode = cuent -> right;

          cuent -> right = cuent -> left; //swap betwen crent -> right and crent ->left

          cuent -> left  = nextNode;      //swap betwen crent -> right and crent ->left

          prves = cuent;  // I uese prevs only  to get address of last node and assgient to first
          cuent =  nextNode;  // move curent to next unitl you reach null which is end of list
     }

     first = prves;  // first now have address of last node

}




/**
*  Reverse all the element in the linked list using recursion method
*
* reference india channel (mycodeschool)
*/

void Reverse_using_recursion( struct  node *curentNode)
{


    if(curentNode == NULL)
    {
      printf("linked list is empty no element to Reverse\n");
      return ;
    }

     struct node * nextNode = curentNode -> right;
     curentNode -> right  =  curentNode -> left;
     curentNode -> left  =  nextNode;

     if(curentNode -> left == NULL) //Exit codition
     {
         return;
     }


    Reverse_using_recursion(curentNode -> left); //Recursive call to move to next node  first



}
