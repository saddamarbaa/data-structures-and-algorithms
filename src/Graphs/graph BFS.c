/*
                :  Graph Data Stucture
 * [PROG]		: C Program for Adjacency list representation
                  implementation CS50 IDE
 * [AUTHOR]		: Saddam Arbaa <saddamarbaas@gmail.com>

     Breadth first search traversal (BFS) adjacency list
     representation of graphs implementation

  Graph traversal means visiting every vertex and edge exactly
  once in a well-defined order.While using certain graph algorithms,
  we must ensure that each vertex of the graph is visited exactly once.
  The order in which the vertices are visited are important and may
  depend upon the algorithm or problem that we are solving.
  During a traversal, it is important that we track which vertices
  have been visited.

  The most common way of tracking vertices is to mark them then here
  Breadth First BFS algorithms can help

  Breadth First Search (BFS)

  There are many ways to traverse graphs.
  BFS is the most commonly used approach.

  Breadth-first search or BFS is a searching technique(algorithm)
  for graphs where you should start traversing from a selected node
  (source or starting node)and traverse the graph layerwise thus
   exploring the neighbour nodes(nodes which are directly connected
  to source node). You must then move towards the next-level neighbour
  nodes.is mean we first visit all the nodes at the same depth first
  and then proceed visiting nodes at a deeper depth

 for reference  in future i will check links blow

    https://youtu.be/9zpSs845wf8 
    https://youtu.be/hk5rQs7TQ7E
    https://youtu.be/r1-8p11fSPw
    https://youtu.be/mrCmB8XtEsE
    https://youtu.be/UVDU887zmfs
    https://youtu.be/5hPfm_uqXmw
    https://youtu.be/k1wraWzqtvQ
    https://www.sanfoundry.com/
    https://youtu.be/X-filsfR_S8
    programiz.com/dsa/graph-bfs
*/

#include <stdio.h>
#include <stdlib.h>

// define size of queue
//(queue will be use in DFS function)
#define SIZE 50

// blow I define 3 color for DFS function
// white mean unvisited
#define White   0

// gray mean discovered
#define Gray    1

// black mean complete
#define Black   2

// A structure to represent an adjacency list node
struct AdjListNode
{
    // index of element of array which contain all vertex
     int vertex_index;

    //a pointer for next node
    struct AdjListNode* next;
};


/* A structure to represent an adjacency list
   contain pointer to the first element(head)
   of the adjacency list(each vertices). */

struct AdjList
{
    /* pointer to the first element
     (head) of the adjacency list. */

    struct AdjListNode *head;
};

/*
   A structure to represent a graph,will contain number of
   vertices and an array of adjacency lists,Size of array
   will be V(number of vertices in graph) with that
   (we can say A graph is an array of adjacency lists).
*/

struct Graph
{
    // number of vertices
    int V;

    //array containing all the nodes (V)
    struct AdjList* array;

    //array containing color all the nodes (V)
    int* color;
};

/*
   A structure to represent queue,will contain the flowing

    int items[SIZE]; // array of element that the queue can hold

    int = first; // is front of queue

    int = last; // is rear of queue.
*/

struct queue
{
    // array of max element that the queue can hold
    int items[SIZE];

    //front of queue
    int first;

    // rear of queue
    int last;
};

//Function to create a new adjacency list node
struct AdjListNode* CreateNewNode(int dest);

//Function to ceate creates a graph of V vertices
struct Graph* createGraph(int V);

//function to Adds an edge to un directed graph

void addEdge(struct Graph* graph, int destination, int source);

//Function to print the adjacenncy list representation of graph
void printGraph(struct Graph* graph);

// Breadth first search Graph traversal (BFS) algorithm
void BFS(struct Graph* graph, int source);

// blow are queue functions

//Function to Create a queue
struct queue* createQueue();

//Function to push(add) elements into queue
void enqueue(struct queue* queueNode, int value);

//Function to dequeue(remove)elements from queue
int dequeue(struct queue* q);

//function to Check if the queue is empty or not
int isEmpty(struct queue* q);

//function to traverse  queue and Print the queue element
void printQueue(struct queue* q);

// Driver program to test code
int main()
{
    int V = 5; // number of verticx

    // create the graph given in  fugure
    struct Graph* graph = createGraph(V);

    addEdge(graph, 0, 1);

    addEdge(graph, 0, 2);

    addEdge(graph, 0, 3);
    addEdge(graph, 0, 4);

    addEdge(graph, 1, 2);

    addEdge(graph, 1, 3);

    addEdge(graph, 1, 4);

    addEdge(graph, 2, 3);

    addEdge(graph, 3, 4);

    while(1)
    {
        int ch;    //for switch  to choose choice
        printf("\nBreadth first search Graph traversal (BFS) Implementation   : \n\n");

        printf("1 : Breadth first search Graph traversal (BFS)              : \n");

        printf("2 : print the adjacency list representation                 : \n");

        printf("0 : quit                                                    :\n");

        // asking user for choice first
        printf("input your choice                                           :");
        scanf("%d",&ch);

        switch (ch)
        {
             // case 1  Breadth first search Graph traversal(BFS)
            case 1 :

                BFS(graph, 0); // call BFS function
            break;

            // case 2  print the adjacency list representation
            // of the above graph
            case 2 :
                printGraph(graph); // call traverse( printGraph(graph)) function
            break;

            // case 0 is exit case
            case 0 :
               printf("time to exit thanks\n");
              _Exit(0);

            // default case
            default:
                printf("\n invalid input\n");

            break; // no need break after default case but I used only for readability
        }
    }

    return 0; // main is done here delete at posstion

} /* END MAIN */


 /* utility function to create a new adjacency list node in
   heap so I can called it each time I need new node take the
   destination vertices which need to be inserted in graph as argument
*/

struct AdjListNode* CreateNewNode(int dest)
{
    //first create node
    struct AdjListNode *newNode;

     // allocate memory dynamically for node
     // using malloc C function

    newNode = (struct AdjListNode*) malloc(sizeof(struct AdjListNode));

    if(newNode == NULL)
    {
        printf("error in allocating memory\n");
    }

    //adding information to node

    newNode ->  vertex_index = dest;

    newNode ->  next =  NULL;

    /*return newly created node to
     place where it been be called */
    return   newNode;

} /* END AdjListNode* CreateNewNode */


/*
   utility function to create a graph of  vertices (v) where V is the
   number of vertices take the number of vertices v as parameter
   and set graph -> v as (v) ( graph -> v = v;)

   and for graph -> array will create array of linked list size of array
   is equal to number of vertices and Initialize each adjacency in array to NULL
*/

struct Graph* createGraph(int V)
{
     //first create Graph
     struct Graph* graph;

     // allocate memory dynamically for graph using malloc C function
     graph = (struct Graph*) malloc(sizeof(struct Graph));

     // set graph -> v = v;
    graph -> V = V;


    /* for graph ->array  member we need to Create an array
       of adjacency lists,size of array will be equal to number
       of vertices(v) which have been passed to graph */

    // Create an array of adjacency lists.  Size of array will be V

    graph -> array = (struct AdjList*) malloc(V * sizeof(struct AdjList));

    if(graph -> array == NULL) // error handling
    {
        printf("error in allocating memory\n");
    }

    // Create an array to store color lists. Size of array will be V

    graph -> color =  malloc(V * sizeof(int));

    if(graph -> color == NULL) // error handling
    {
        printf("error in allocating memory\n");
    }

    /*
     let Initialize each adjacency list in newly created array
     by null and give color white for each one which mean is
     unvisited we can access each adjacency list through head
     pinter let make head NULL for that we need for loop to first so we can
    set all to NULL (graph -> array -> head = NULL)*/

    for (int i = 0; i < V; i++)
   {
      // making elements of all head null
       graph -> array[i].head = NULL; // now all are null

       // node are not yet discovered(not visited)
       graph -> color[i] = White;
   }
   return graph; // return graph to place where it been be called

} /* END Graph* createGraph */


/*
 utility function to add Edge from destination to source
 and if the graph is undirected,then again there will also
 be edge from from source back to destination(connect vertices)
 function take 3 parameter graph,destination and source
 (struct Graph, int destination, int  source) */

void addEdge(struct Graph* graph, int destination, int source)
{
    // first create tempery node for that I call create node function
    struct AdjListNode* newNode = CreateNewNode(destination);

    /* Add an edge from destination to source by going to
       source index in Adj array List and attach it(I mean connected)
       the node is added to the beginning */

    newNode -> next = graph -> array[source].head;

    // update head  now head not NULL
    // head contain the address of new node
    graph -> array[source].head  = newNode;


   /* if the graph was directed we are done here but
     Since the graph is undirected then we have to add
     an edge from destination to source also as blow */

     newNode = CreateNewNode(source);//create new node again

     newNode -> next = graph -> array[destination].head;

     graph -> array[destination].head = newNode;

     //we are done

} /* END addEdg */


/*
  A utility function traverse graph and print the adjacenncy
  list representation of graph */

void printGraph(struct Graph* graph)
{
    int v;
    for(v = 0; v < graph -> V; v++)
    {
        /*
         we need temperly variable of type struct AdjListNode
         I named traverse at first traverse will start point to
         AdjLis of first index[v index] print all the element in
         that index then counter v will increment and our friend
         traverse will move to next index of AdjLis array and print
         all the element and so on

        */
        struct AdjListNode *traverse;

        traverse = graph -> array[v].head;

        printf("\n Adjacency list of vertex %d\n head ", v);

        while(traverse != NULL)
        {
            // print Adjacency list of vertex in each row
            printf(" --> %d", traverse->vertex_index);

            // move traverse to point to next pointer
            traverse = traverse -> next;
        }

        // new line after each index
        printf("\n");
    }

}/* END printGraph */


 /*
   utility function to create in heap so I
   can called it each time I need new queue
*/

struct queue* createQueue()
{
    //first create node
    struct queue* queueNode;

    // allocate memory dynamically for queue

    queueNode = (struct queue*) malloc(sizeof(struct queue));

    if(queueNode == NULL)
    {
        printf("error in allocating memory for queue\n");
    }

    //adding information to queue node

    queueNode -> first = -1;

    queueNode ->  last =  -1;

    /*return newly created queue to
     place where it been be called */
    return   queueNode;

} /* END queue* createQueue */


/*
  A utility function to push new given  vertices to queue
  take two parameter which will passed from DFS function
  one is node of type queue and second is (value)
  vertices of graph which will push to queue
  void enqueue(struct queue* queueNode, int value )

*/

void enqueue(struct queue* queueNode, int value)
{
    // queue is full condition
    if (queueNode -> last == SIZE - 1)
    {
        printf("\nQueue is Full!!\n");
    }
    else
    {   // if its the first element in queue
        if (queueNode -> first == -1)
        {
            queueNode -> first = 0;
        }

        /* now we are sure queue is not empty so let
          increment(queueNode -> last)  then add at rear
         */

        queueNode -> last = queueNode -> last + 1;

        // add the given vertices to queue
        queueNode -> items[ queueNode -> last] = value;
    }
} /* END enqueue */


/*
   utility function to Check if the given queue is
   empty or not here we Am saying  that queue is empty
   if and only rear of queue is = -1
   as we are always adding throw rear */

int isEmpty(struct queue* q)
{
    // is empty
    if (q -> last == -1)
        return 1;

    else // is not empty
        return 0;

} /* END isEmpty */


/*

  utility function to dequeue(remove) first vertices
  in  queue (first in first  out )  function take queue
  as parameter and return the first element in the queue
  in case if queue is empty  return -1 indicate that queue
  is empty and front = -1 now */

int dequeue(struct queue* q)
{
    // variable to store front of queue
    int front;

    //if queue is empty then we dont have any element to dequeue
    if(isEmpty(q))
    {
            printf ("Queue is empty \n");

            // -1 will return because that is the condition of empty queue
            front = -1;
    }
    else
    {
        // return queue front
        front = q -> items [q -> first];

        // then increment q -> first by one
        q -> first = q -> first + 1; // q -> first++


        /* if that was only one element on queue after we
           returned it and increment front now (front > rear)
            in this case we need rest the queue
            */

           if (q -> first > q -> last)
           {
               //printf("\nnow is time for Resetting the queue \n");

               q -> first = q -> last = -1; //Resetting queue
           }
     }

        // return front of queue BFS function
        return front;
} /* END dequeue */


/*  utility function to traverse the given
    Queue and Print all queue element */

void printQueue(struct queue* q)
{
    // counter store front of queue(will use in loop)
    int i = q -> first;

    //if queue is empty then we dont have any element to print we are done
    if(isEmpty(q))
    {
        printf ("Queue is empty \n");
    }

    // now we are sue queue is not empty lets print
    else
    {
        printf("\nQueue contains the flowing element \n");
        for(i = q -> first; i <= q -> last; i++)
        {
            // printing queue
            printf("%d \t",q -> items [i]);
        }

    }// else done here

} // function done here


/*
 Breadth First Search (BFS)

There are many ways to traverse graphs.
BFS is the most commonly used approach.

Breadth-first search or BFS is a searching technique(algorithm)
for graphs where you should start traversing from a selected node
(source or starting node)and traverse the graph layerwise thus
exploring the neighbour nodes(nodes which are directly
connected to source node). You must then move towards the
next-level neighbour nodes.is mean we first visit all the nodes at
the same depth first and then proceed visiting nodes at a deeper depth

A node can be reached from different nodes using different paths
but we need to visit each node only once. So, we mark each node
differently into 3 categories - unvisited, discovered and complete.

Initially, all nodes are unvisited. After visiting a node for the
first time, it becomes discovered.

A node is complete if all of its adjacent nodes have been visited
in Generally,we use three different colors i.e., white, gray and black
are used to represent unvisited, discovered and complete respectively

 We are going to use queue for the implementation of the BFS.
 function take the graph (G) and the source node (s) as its input - BFS(G, s).


 BFS(G, s)

(1) next step make all of its nodes unvisited i.e., white

  for i in G.V
    i.color = white

(2) We are going to start from the source, so let's make
   the source node discovered i.e., gray - s.color = gray

  s.color = gray

(3) create queue putt the source node in the queue first.

  queue.enqueue(s)

(4) We will iterate until the queue becomes empty
    and dequeue element in front of the queue

  in loop  Now, we need to enqueue all of the adjacent
   nodes of the node we got by dequeuing the queue.

  all the adjacent nodes of a node are store in an array 'Adj'.
  So, Adj[u] is the
  list of all the adjacent nodes of the node u.

 while !q.is_empty
  u = queue.dequeue()
  for i in Adj[u]
    if i.color == white // only if the node is not yet discovered
      i.color = gray //mark it discovered
      queue.enqueue(i)
  u.color = black // all adjacent nodes of this node are discovered

   BFS Algorithm Complexity

   The time complexity of the BFS algorithm is represented in the form
   of O(V + E), where V is the number of nodes and E is the number of edges.

   The space complexity of the algorithm is O(V).

    BFS Algorithm Applications

   (1) To build index by search index
   (2)  For GPS navigation
   (3)  Path finding algorithms
   (4)  In Ford-Fulkerson algorithm to find maximum
       flow in a network
   (5)  Cycle detection in an undirected graph
   (6)  In minimum spanning tree

 */

void BFS(struct Graph* graph, int source)
{
    // create queue first
    struct queue* q = createQueue();

  /*  we start from the source, so let's make the source
       node discovered by changing it color to gray */

    graph -> color [source] = Gray; //visited(discovered)

    //after visited push the source to queue
    enqueue(q, source);

    /*  while the queue is not empty dequeue(remove)it first
       vertices in the queue(Take the front item of the queue
       and enqueue all of its adjacent nodes into  queue) */
    while (!isEmpty(q))
    {
         // print the queue
         printQueue(q);

        // dequeue front of the queue
        int currentVertex = dequeue(q);

         //print clear message that this is one is completely done
         printf("\n%d : is Visited so is been marked as complete Vertex  \n", currentVertex);


        /*
           store in temp adjacent nodes of this currentVertex and Repeat
           the step above until temp become NULL which will mean that we
           have visited all in this level before moving to next level
        */

        struct AdjListNode* temp = graph -> array[currentVertex].head;

        while (temp != NULL)
        {
            int adjVertex = temp -> vertex_index;

            // only if the node is not yet discovered visited
             //and push to queue

            if (graph->color[adjVertex] == White) // unvisited
            {
                //mark it discovered
                graph->color[adjVertex] = Gray; // now discovered (visited)

                enqueue(q, adjVertex); // push it to queue
            }

            // move temp to point to next adjacent vertices
            temp = temp -> next;
        }

        // all adjacent nodes of this node are discovered
        graph -> color[currentVertex] = Black;
    }

} /* END BFS */


