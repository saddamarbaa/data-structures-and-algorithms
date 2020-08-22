
/**
 * circlurQueue : array List Implementation
 *
 * for refence to this function india channel  (Naresh i Ttechnilgies)
 */


#include <stdio.h>
#include "stdlib.h"
#include <cs50.h>

 #define CAPCITY 6

 int queue[CAPCITY]; //create queue
 int first = -1;
 int last = -1;

 void enqueue(int element);

 int fron ();
 bool isempty();
 bool isfull();
 void dequeue();

 void trevers();

int main(int argc, char* argv[])
{
     while(1)
    {
        int ch;//for swtich  to chooce choice
         int element; // element
         printf("1 : enqueue :\n");
         printf("2 : dequeue  :\n"); //delete
         printf("3 : print all the element  of the queue:\n");

         printf("0 : quit :\n");

         ch = get_int("input your choice :");

         switch (ch)
         {
            case 1:

            element = get_int("enter elemt to enqueue : ");
             enqueue(element);
              break;

              case 2:
              dequeue();
              break;

              case 0:
              printf("time to exit thanks\n");
              _Exit(0);

             case 3:
             trevers();
             break;


             default:
             printf("invalied input\n");
             break;
         }

    }

    return 0;

}



/**
 * to push new value to queue
 */

void enqueue(int element)
{
     if(isfull())
     {
       printf("sorry  the queue is full");
       printf("\n");
     }

      else if (isempty())
        {

          first = last = 0;
          queue[last] = element;

     }

    else
    {

        last =  (last +1 ) %  CAPCITY ;  // make sure to make criclur queue
         queue[last] = element;

    }

        printf("%d  been push to queue\n",element);
    }





/**
* dequeue first elemt in the queue
* first in first out
*/
void dequeue()
{
    if (isempty())
        {
            printf ("queue is empty nothing to dequeue for now\n");
        }

       else if ( first == last)  // if only one element on list
     {
       //printf (" %d been dequeue",queue[first]);

      first = last = -1;

      // mean if queue have  only one element after removting that one queue will be empty
     }


     else
{
     // printf (" %d been dequeue",queue[first]);

       first  = (first +1 ) %  CAPCITY ;  // make sure to make criclur queue
}

}

/**
 * check if queue is empty
**/


bool isempty()
{
 if ( first  == -1 && last ==-1)
 {
  return true;

 }

 else  return false;
}

/**
 * check if queue is full
**/


bool isfull()
{
     if ( (last +1 ) %  CAPCITY == first)
     {
        return true;
     }

      else
      {
       return false;
      }
}


/**
* to print all the element in the queue
*/
void trevers()
{


        while(!isempty())
        {
            printf("\n%d\n",fron());
            dequeue();
        }

}

/**
 * return front of the queue
 * first element enter in the queue
**/

int fron ()
{
    if (isempty())
        {
            printf ("queue is empty nothing in fron\n");
            return 1;
        }


        else return queue[first];


}
