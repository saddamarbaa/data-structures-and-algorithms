/**
                  Graph Data Stucture in C
 * [PROG]		:  Topological sort Adjacency matrix representation
                   implementation
 * [AUTHOR]		: Saddam Arbaa <saddamarbaas@gmail.com>
   Topological sort
   Topological sorting or Topological ordering of a directed graph
   is a linear  ordering vertices of a directed, acyclic graph(DAG),
   such that for every directed edge (u v) from vertex u to
   vertex v, u comes before v in the ordering.
  The topological sorting is possible only if the graph
  does not have any directed cycle.
  (mean a topological ordering is possible only in acyclic graphs).

  Algorithm For Topological Sorting as flowing blow

   (1) Choose a vertex in a graph without any predecessors.
       In other words, it is a vertex with Zero Indegree.
  (2)  Delete this vertex and all the outgoing edges from it.
  (3)  Repeat the above process till all the vertices are not deleted from the DAG.
  */

#include <stdio.h>

#include <stdlib.h>

//define maximum number of vertice's to 100
#define MAX 100

// declare global adjacency Matrix of size(max * max)
// I declared globally so it can be acceded from all function
int adjacencyMatrix[MAX][MAX];

/*  declare global variable N(N is the number of vertice's in graph)
    will be entered by user latter while creating graph */
int N;

/*
   declare queue of Array globally so it can be use in all function
   ( n array of [max] element that the queue can hold ) */

int queue[MAX];

//front of queue
int first = 0;

// real or tail of queue
int last = 0;

//function to Initialize all value in adjacency Matrix to zero
void initialize();

// function to create graph
void create_graph();

// function to traverses adjacency Matrix and Print it values
void printAdjMatrix();

// function to find indegree of node(vertex)
int indegree(int node);

//Function to push(add) elements into queue
void enqueue(int element);

//Function to dequeue(remove)elements from queue
int dequeue();

//function to Check if the queue is empty or not
int isEmpty();

// function to Check if the queue is empty or not
int isEmpty();

// function to Check if the queue is full or not
int isFull();


// the  Driver Code
int main()
{

    /* declare 2 Arrays of size max  Topological_order[] array
       to store the sorted nodes and indegree array[] to store
       the  indegree of each node */

    int topological_order[MAX],indeg[MAX];

    // declare 3 variable i and count to use as then as counter
    //  and variable k needed latter in dequeue proccess
    int i,count,k;

    count = 0; // count start from zero

    // call function to Initialize the matrix to zero
    initialize(adjacencyMatrix);

    // call function to create graph(adjacency Matrix)
    create_graph();

    // call function to Print the adjacency Matrix
    printAdjMatrix(adjacencyMatrix);


     /* loop to Find the indegree of each node and if
        the degree of node is zero pushed to queue*/

    for (i = 1; i <= N; i++)
    {
        // find in degere of i by calling  indegree(i)function
        indeg[i]=indegree(i);

		if(indeg[i] == 0)
        {
          enqueue(i); // call enqueue function
        }
    }

   /* now we need Loop till queue is not empty we dequeue the front
      of queue store in k and add to our Topological sorted Array
      then remove all the Edges going out from node k,  in every
      iteration if the indgree of the vertex in that iteration is
      equal to zero then we push to queue . and so on
      by doing that when queue became empty we will have Topological sorted Array */

    while(!isEmpty()) /*Loop till queue is not empty */
    {
       /* dequeue front of the queue and store in k */
        k = dequeue();

       /* Add node k to topological order  Array */
        topological_order[++count] = k;

        /*  Delete all edges going out from dequeued node k */
        for (i = 1; i <= N; i++)
        {
            // if there is Edges
            if(adjacencyMatrix[k][i]== 1)
            {
                adjacencyMatrix[k][i] = 0; // delete that edge

                indeg[i] = indeg[i]- 1;   // decrement indegree of i

                /* After decremented if it indegree equal to zero push to queue */
                if(indeg[i] == 0)
                    enqueue(i);
            }


        }/*End of for loop*/

    }/*End of while*/


    // graph contains cycle
    if(count < N)
    {
        printf("Topological sorting Not Possible ,because graph contains cycle\n");
        exit(1);
    }
    else
    {
        /* lastly traverse Topological sorted Array
           and print all the element */
        printf("Nodes after topological sorting are :\n");

        for(i= 1; i<= count; i++)
        {
            printf("%d ",topological_order[i]);
        }
        printf("\n");
    }


    return 0;

} /* End of main*/


/**  function to Initialize all value in adjacency Matrix to zero */

void initialize()
{
    // create two variable i and j  I will use them then as counter
    int i, j;

    // outer loop
    for (i = 1; i <= N; i++)
    {
        // inner loop
        for (j = 1; j <= N; j++)
        {
            // Initialize the matrix to zero
            adjacencyMatrix[i][j] = 0;
        }
    }

} /* End of initialize() */



/**
  utility function to Traverse(Print)
  all the value in adjacency Matrix */

void printAdjMatrix()
{
    // create two variable i and j  I will use them then as counter
    int i, j;

    // outer loop
    for (i = 1; i <= N; i++)
    {
        // print row adjacencyMatrix[i]
        printf("%d  :",i);

        // inner loop
        for (j = 1; j <= N; j++)
        {
            // Print the value at AdjacencyMatrix[i][j]
              printf("\t%d", adjacencyMatrix[i][j]);
        }
        // print new line after printing every row
        printf("\n");

    } /*End of for*/

}/*End of printAdjMatrix()*/


/**
    utility function to create graph
   (Traverse the Adjacency Matrix[N][N]
    of vertex and connect the Edges from
    given startVertex to given  endVertex ) */


void create_graph()
{

   /*
    declaring 4 local variable(i) will be use as counter in loop
    (startVertex, endVertex) will be entered by user(max_Edges)for
     maximum number of Edges in graph this one will be calculated
    */

    int i, startVertex, endVertex, max_Edges;

    // asking user input number of vertices
    printf("Enter number of vertices (nodes) : ");
    scanf("%d",&N);

    // calculating maximum number of Edges
    max_Edges = N *(N - 1);

    // for loop to connect the edges
    for(i = 1; i <= max_Edges; i++)
    {
        // asking user input (source,destination )
        printf("Enter edge %d( 0 0 ) to quit : ", i);
        scanf("%d %d", &startVertex, &endVertex);

        // Exit condtion
        if((startVertex == 0) && (endVertex == 0))
        {
          break; // exit we are done
        }
        //Invalid edge case
        else if(startVertex > N || endVertex > N || startVertex <= 0 || endVertex <= 0)
        {
            printf("Invalid edge\n");

            i--; // decrement the counter(i) because it will
                 // be incremented even though the Edge is invalid
        }
        // we can add now
        else
        {
               /*
                conned the Edges in adjacencyMatrix[startVertex][endVertex ] = 1
                Update value to 1
                */

            adjacencyMatrix[startVertex][endVertex] = 1; // Update value to 1
        }

    }/*End of for loop*/

     // connect the Edges of vertex for testing
    //addEdge(adjacencyMatrix, 0, 1);
    //addEdge(adjacencyMatrix, 0, 2);
    //addEdge(adjacencyMatrix, 1, 2);
    //addEdge(adjacencyMatrix, 2, 0);
    //addEdge(adjacencyMatrix, 2, 3);
    //addEdge(adjacencyMatrix, 3, 0);

}/*End of create_graph()*/



/**
   utility function to find  indegree of node(vertex) */

int indegree(int node)
{
    //  i for counter and indegree for indegree of vertex
    int i, indegree = 0;

    for (i = 1; i <= N; i++)
    {
        /* for each Edges coming to this vertex update indegree
          (so indegree of each node is the number of Edges coming
           to that node) */

        if (adjacencyMatrix[i][node] == 1)

            indegree++; // update indegree
    }

    // return to place where is been called
    return indegree;

} /*End of indegree(int node)*/



/**
    A utility function to push
   new given  element to queue */

void enqueue(int element)
{
    // queue is full condition
     if(isFull())
     {
       printf("Queue is Full (Queue Overflow)!!\n");
     }

      /*
       now we are sure queue is not full so let add at rear then
       increment last by one so can be ready for next coming element */

    else
    {
        // add the given element to queue
        queue[last] = element;

        last++; // increment last by one

        // inform  user the element is been added
        printf("%d  been push to queue\n",element);
    }

} /*End of enqueue() */



/**
      utility function to dequeue(remove)first
       element in queue (first in first out)
       return queue[first] to where is been called  */

int  dequeue()
{
    // variable to store dequeued element before been deleted
    int del_item;

    // queue is empty condition
    //if queue is empty then we dont have any element to dequeue
    if(isEmpty())
        {
            printf("Queue is empty(Queue Underflow) \n");
            exit(1);
        }
        else
        {
            del_item = queue[first];

            // inform user that  the front queue element is been remove
             printf("%d  been dequeue \n",queue[first]);

             /*
                now we have an empty place left in Zero index of Array
                so lets start from  zero index until last - 1 we shift
                the element(queue[i] = queue[i+1]) so that no empty index
                 will be left in queue and lastly decrement rear of queue
                  by one (last--) */

            for(int i = first; i < last -1 ; i++)
            {
                queue[i] = queue[i+1]; //shifting
            }
            last--; // decrement rear
        }
        // return it
        return del_item;

} /* End of dequeue() */


/**
   Utility function to Check if the queue is empty or not here
   Am saying that queue is empty if and only if (first == last) */

int isEmpty()
{
    // is empty
    if (first == last)
        return 1;

    else // is not empty
        return 0;

} /*End of isEmpty() */


/**
   Utility function to Check if the queue is full or not here
   Am saying that queue is empty if and only if (last == max) */

int isFull()
{
    // is empty full
    if(last == MAX)
        return 1;

    else // is not full
       return 0;

} /* End of isFull() */


