
/**
 * Doubly linkedlist implementation
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

//first node //or  head

struct node * first = NULL;

void append(int new_elemet);               // add new element at the end

void insert_in_Begining( int new_elemet);  //add new element at the begining

int insert_at_possition(int value , int possition); //add new element at thegiving possition

int length(void);                          // find length

void trevers(void);                       //print all the element

void print_Reverse();                      //print all the element in Reverse ordere using loop


void removee(int value) ;                   //remove the given value from the list if found

int len; // to store length of the linked list latter

int Delete_node_at_possition(int possition);  //delete node at the given posstion

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
         printf("9 : print all the element in linked list using recursion\n");
         printf("10 : print all the element in reverse order using loop :\n");
         printf("11 : print all the element in reverse order using recursion :\n");
         printf("12 : Reverse the linked list using loop :\n");
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
              print_using_recursion(first); //print or display function using recursion method
              break;

              case 10:
              print_Reverse(); //print or display node in reverse order using loop using loop
              break;


              case 11:
              Reverse_print_using_recursion(first); //print element in reverse order using recursion
              break;

              case 12:
              Reverse(); //revese element in the linked list using loop
              break;

              case 13:
              Reverse_using_recursion(first);//revese element in the linked list using recurssion
              break;

              case 14:
              len = length();
              if (len == 0)
              {
                 printf("linked list is empty \n");
              }
               printf("length is  : %d\n",len);
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
* for refence to this function india channel  (Naresh i Ttechnilgies)
*/

void append( int new_elemet)
{
    //create
    struct node  *temp;

 // allocate memeory
    temp = (struct node *)malloc (sizeof(struct node));

    if(temp == NULL)
    {
        printf("eror in ellocting memory\n");
    }

    //adding information to node
    temp -> data = new_elemet;
    temp -> right = NULL;
    temp -> left = NULL;

    // cheak first
    if (first == NULL) // list is empty
    {
        // insert first node in list
        first = temp  ;
    }

     // if already some element are in the linked list we have first loop
     //throw the linked linkedlist then add the  new  element at end
    else
    {
        struct node *p = first;  // local variable

        while(p -> right != NULL)
        {
            p = p -> right;
        }

        p -> right = temp;
        temp -> left = p;

    }

}

/**
 * insert new element at the beginning of the linked list
 * for refence to this function india channel  (Naresh i Ttechnilgies)
 */

 void insert_in_Begining( int new_elemet)
 {
     //create node
    struct node * temp;

 // allocute momery
    temp = (struct node *)malloc (sizeof(struct node));
    if(temp == NULL)
    {
        printf("eror in ellocting memory\n");
    }

    temp -> data = new_elemet;
    temp-> right = NULL;
    temp -> left = NULL;

    if (first == NULL)
    {
        first = temp;
    }
     // if already some element are in the linked list we have new element at beging of the list
    else
    {
        temp -> right = first;
        first -> left = temp;
        first = temp ;
    }
 }

/**
* to find linked list length
* for refence to this function india channel  (Naresh i Ttechnilgies)
*/

int length()
{
    struct  node *temp ;

    temp = first;

    int count = 0;

    while (temp != NULL)
     {
         count++;
         // move control to nex element
         temp = temp -> right;
     }

     return count;
}

/**
 * remove the given value from list
 *  check from arbic channel Hard Code
*/

 void removee(int value)
  {
      struct node *temp, *p;
      temp = first;

     if(first == NULL) //list is empty
     {
         printf(" linked lis is empty no node to remove\n");
         return ;
     }

     // if only one node is in the linked but that node is not value so I have to handle the error here

     if (temp -> left == NULL && temp -> right == NULL && temp -> data != value)
     {
         printf(" %d not found in the linked list \n",value);
         return;
     }

      // if only one node is in the linked but that node is is the given value
      //so I called  Delete_node_at_beging() function which remove first node

     else if (temp -> left == NULL && temp -> right == NULL && temp -> data == value)  //if the value the first index
     {
          Delete_node_at_beging();

     }

       // if the given value is first node but the linkedlist have more than one node
      //so I called  Delete_node_at_beging() function which remove first node

     else if (temp -> left == NULL && temp -> right != NULL && temp -> data == value)  //if the value the first index
     {
          Delete_node_at_beging();

     }

     else
     {

     //loop unitl find the value

     while( temp != NULL && temp -> data != value )
     {

         temp = temp -> right;
     }

     p = temp ;

           //  reach the end of list but value is not found
           if (temp == NULL)
           {
             printf(" %d not found in the linked list \n",value);
             return ;
           }

           //if the value found in the last node

          if ( temp -> right == NULL && temp -> data == value)
           {

                 Delete_node_at_end(); // we are now sure the given value is the last node in the linked list
                                   //so I called  Delete_node_at_end() function which remove last node
           }


     else
     {
         // the given node is in middle

       temp -> left -> right = temp -> right;  //right side conection first
       temp -> right -> left =  temp -> left;   //left side conection second

     free(p);
     }

}
     return ;

 }

/**
* insert the given value at the given position
* adding node in the middle
*/

int insert_at_possition(int value , int possition)
 {
    //crate node to add
    struct node * temp ,*p;

    int i =1; // counter

    len = length();

     // pssotion is biger than length is not valied
     if(possition > len)
     {
         printf("invalied location\n");
         printf("list is curently having  only %d node\n",len);
         return 1;
     }
     else
     {
         p = first;

         //send control to the posstion
         while(i < possition)
         {
            p = p -> right;
            i++;
         }

           // allocate memeory and creat node which you want add
           temp = (struct node *)malloc (sizeof(struct node));
           if(temp == NULL)
           {
             printf("eror in ellocting memory\n");
           }

          //adding information to node
           temp -> data = value;
           temp -> right = NULL;
           temp -> left = NULL;

          temp -> right =     p -> right ; //right side conection first
          p -> right -> left = temp;  ////right side conection first

          temp -> left = p;            //left side conection  secode
          p -> right  = temp;       //left side conection  secode
     }

          return 0;

 }


/**
* delete the given value at the given position
* delete node in the middle or last or even in first of the node
*/

int Delete_node_at_possition(int possition)
 {
    //
    struct node * tmp;
    tmp = first;

    int i = 1; // counter

    len = length();

     // pssotion is biger than length is not valied
     if(possition > len)
     {
         printf("invalied location to delete \n");
         printf("list is curently only having  %d node\n",len);
         return 1;
     }

     // if having only one node  in linked list delet the node and assign head to NULL

     if(tmp -> right == NULL && tmp -> left == NULL)
     {
         first = NULL;

         free(tmp);
     }

     // if the list have many node but usesr want to delete the first node
     // move the head to point to next node

     else if(possition == 1)
     {

         first = tmp -> right;
         tmp -> right -> left = NULL;
         tmp -> right = NULL;

         free(tmp);

     }

     else // now we are sure is not first one let loop until the location
     {
        struct node * temp ,*p;

         temp = first;

         //send control to the posstion  the one which want delete

         while(i < possition )
         {
            temp = temp -> right;
            i++;
         }

         // cheack if the given posstion to delete is the last node

         if (temp -> right == NULL)
         {
            p = temp; //p only to usese in free memory proccess

           temp -> left -> right = temp -> right;

           p -> right = NULL;
           p -> left = NULL;
           free(p);
         }
         else  // its not the last node and also not the first node  its in between first and last
         {
            p = temp; //p only to usese in free memory proccess

           temp -> left -> right = temp -> right; //right side conection first

           temp -> right -> left =  temp -> left; //right side conection first

           p -> right = NULL;

           p -> left = NULL;

           free(p);

         }

     }

        return 0;
 }


/**
*
* delete the  first  node in linkedlist
*/

void Delete_node_at_beging()
{

    struct node * temp;
    temp = first;


    if( first == NULL)
    {
       printf("list is empty no node at the beging to delete");
       return;
    }

    // if having only one node  in linked list delet the node and assign head to NULL

     else if(temp -> right == NULL && temp -> left == NULL)
     {
         first = NULL;

         free(temp);
     }

    else
    {
         first = first -> right;
         first -> left = NULL;
         temp -> right = NULL;
         free(temp);
    }

 }



/**
*
* delete the  last  node in linkedlist
*/

void Delete_node_at_end()
{
    struct node * temp ,*p;
    temp = first;

    if( first == NULL)
    {
       printf("linkedst is empty no node at the end to delete");
       return;
    }

    // if having only one node  in linked list delet the node and assign head to NULL

     else if(temp -> right == NULL && temp -> left == NULL)
     {
         first = NULL;

         free(temp);
     }

    else // now we are sure is not empty let loop until the las node and delete that last node
     {

         temp = first;

         //send control to the Last node  the one which want delete

         while(temp -> right != NULL )
         {
             temp = temp -> right;

         }

         p = temp; //p only to usese in free memory proccess

        temp -> left -> right = NULL;

         p -> right = NULL;

         p -> left = NULL;

         free(p);
         }

 }


/**
* to print all the element in the linked list
*
*/
void trevers()
{
    struct  node *temp ;

     temp = first;

    if(first == NULL)
    {
    printf("linked list is empty no node to print\n");
    }
      while (temp != NULL)
      {
         printf("%d---> ",temp -> data);

         temp = temp -> right;
     }
     printf("\n");

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
