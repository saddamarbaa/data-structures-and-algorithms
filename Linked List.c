
/**
  single linkedlist implementation
*/

#include <stdio.h>
#include <string.h>
#include "stdlib.h"
#include <cs50.h>

// A linked list node
struct node
{
    int data;

    struct node * next;
};

//first node //or  head
struct node * first = NULL;

void append(int new_elemet);               // add new element at the end

void insert_in_Begining( int new_elemet);  //add new element at the begining

int insert_at_possition(int value , int possition); //add new element at thegiving possition

int length(void);                          // find length

void trevers(void);                       //print all the element


int removee(int value) ;                   //remove the given value from the list if found

int len; // to store length of the linked list latter

int Delete_node_at_possition(int possition);  //delete node at the given posstion

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
         printf("4 : remove value :\n"); //delete all the element in stack
         printf("5 : Delete node_at_possition :\n");
         printf("6 : print all the element in linked list using loop\n");
         printf("7 : print all the element in linked list using recursion\n");
         printf("8 : print all the element in reverse order using recursion :\n");
         printf("9 : Reverse the linked list using loop :\n");
         printf("10 : Reverse the linked list using recursion :\n");
         printf("11 : length of the linked list  :\n");
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
             element = get_int("inser value to remove from the linked list: ");
             removee(element);
             break;

             case 5:
             possition = get_int("enter the possition which you want to delete : ");
             Delete_node_at_possition(possition);
             break;

              case 6:
              trevers(); //print or display function using loop
              break;

              case 7:
              print_using_recursion(first); //print or display function using recursion method
              break;

              case 8:
              Reverse_print_using_recursion(first); //print element in reverse order using recursion
              break;

              case 9:
              Reverse(); //revese element in the linked list using loop
              break;

               case 10:
              Reverse_using_recursion(first);//revese element in the linked list using recurssion
              break;

              case 11:
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
*  insert element at the end
*/

void append( int new_elemet)
{
    //create
    struct node * temp;

 // allocate memeory
    temp = (struct node *)malloc (sizeof(struct node));

    if(temp == NULL)
    {
        printf("eror in ellocting memory\n");
    }

    //adding information to node
    temp -> data = new_elemet;
    temp-> next = NULL;

    // cheak first
    if (first == NULL) // list is empty
    {
        // insert first node in list
        first = temp;
    }

     // if already some element are in the linked list we have first loop
     //throw the linked linkedlist then add the  new  element at end
    else
    {

        struct node *p; // local varivale

        p = first;

        while(p -> next != NULL)
        {
            p = p -> next;

        }
        //  add on the last
       p -> next = temp;

    }
}

/**
 * insert new element at the beginning of the linked list
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
    temp-> next = NULL;

    if (first == NULL)
    {
        first = temp;
    }
     // if already some element are in the linked list we have new element at beging of the list
    else
    {
        temp -> next = first;
        first = temp ;
    }
 }

/**
* to find linked list length
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
         temp = temp -> next;
     }

     return count;
}

/**
 * remove the given value from list
 *  check from arbic channel Hard Code
*/

 int removee(int value)
 {

     if(first == NULL) //list is empty
     {
         printf(" linked lis is empty\n");
         return 1;
     }
     struct node *temp, *prevs;

     prevs = temp = first;

     if ( temp -> data == value)  //if the value the first index
     {
         first = temp -> next ;
         free(temp);
     }

     //loop unitl find the value
     while( temp != NULL && temp -> data != value )
     {
         prevs = temp;
         temp = temp -> next;
     }

     if(temp == NULL)
     {
         //printf("not found\n");
         return 1;
     }
     else
     {
     prevs -> next = temp -> next;
     temp -> next = NULL;
     free(temp);
     }
     return 0;

 }

/**
* insert the given value at the given position
* adding node in the middle
*/

int insert_at_possition(int value , int possition)
 {
    //crate node to add
    struct node * temp ,*temp1;

    int i =1; // counter

    len = length();

     // pssotion is biger than length is not valied
     if(possition > len)
     {
         printf("invalied location\n");
         printf("list is curently having  %d node\n",len);
         return 1;
     }
     else
     {
         temp1 = first;

         //send control to the posstion
         while(i < possition)
         {
            temp1 = temp1 -> next;
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
          temp-> next = NULL;

          temp -> next = temp1 -> next ; //right side conection first
          temp1 -> next = temp;      //left side conection  secode
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
         printf("list is curently having  %d node\n",len);
         return 1;
     }

     else if(possition == 1)
     {
         first = tmp -> next;
         tmp -> next = NULL;
         free(tmp);
     }

     else
     {
        struct node * temp ,*p;
          temp = first;

          //send control to the posstion befor the one which want delete
         while(i < possition - 1)
         {
            temp = temp -> next;
            i++;
         }
         p = temp -> next;
         temp -> next =  p -> next;  //right side conection first
        p -> next = NULL;

         free(p);

     }

        return 0;
 }

/**
* to print all the element in the linked list
*/
void trevers()
{
    struct  node *temp ;

     temp = first;

    if(first == NULL)
    {
    printf("linked list is empty\n");
    }
      while (temp != NULL)
      {
         printf("%d---> ",temp -> data);

         temp = temp -> next;
     }
     printf("\n");

    }


/**
* reverse order all the element in the linked list  in reverse order
*
* for reference arab channel( Hard code) also  india channel (mycodeschool)
*/
void Reverse()
{
    struct  node * prves = NULL ; //for previs
    struct  node * cuent = first ;  //curnent
    struct  node * Next = NULL ;    //next

    if(cuent == NULL)
    {
    printf("linked list is empty\n");
    }

      while (cuent != NULL)
      {
          Next = cuent -> next;

          cuent -> next = prves;

          prves = cuent;
          cuent =  Next;
     }

     first = prves;

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
        print_using_recursion(temp -> next); //Recursive call to move to next node

    }
    }


/**
* to print all the element in the linked list  in reverse order using recursion
*
* reference india channel (mycodeschool)
*/
void Reverse_print_using_recursion( struct  node * temp)
{
    if(temp == NULL)//Exit codition
    {
      return;
    }
    else
    {
        Reverse_print_using_recursion(temp-> next); //Recursive call to move to next node  first

        printf("%d -->", temp -> data);  // after reach to last node and first == NULL
                                          // will start printing from last to first in reverse order

    }
    }

/**
*  Reverse all the element in the linked list using recursion method
*
* reference india channel (mycodeschool)
*/

void Reverse_using_recursion( struct  node * p)
{
    if(first == NULL)
    {
    printf("linked list is empty\n");
    return ;
    }
    if(p -> next == NULL)//Exit codition
    {
        first = p;
        return ;
    }

    Reverse_using_recursion(p-> next); //Recursive call to move to next node  first

    struct  node * q = p-> next;
    q -> next = p;
    p -> next = NULL;




    }
