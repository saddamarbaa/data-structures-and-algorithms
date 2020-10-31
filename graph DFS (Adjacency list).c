/*
            :  Graph Data Stucture
 * [PROG]		: C Program (DFS)  Adjacency list representation implementation CS50 IDE
 * [AUTHOR]		: Saddam Arbaa <saddamarbaas@gmail.com>

     Depth first search traversal (DFS) adjacency list
     representation of graphs implementation

  Graph traversal means visiting every vertex and edge exactly
  once in a well-defined order.While using certain graph algorithms,
  we must ensure that each vertex of the graph is visited exactly once.
  The order in which the vertices are visited are important and may
  depend upon the algorithm or problem that we are solving.
  During a traversal, it is important that we track which vertices
  have been visited.

  Depth First Search (DFS)
  Depth first traversal or Depth first Search (DFS)is a recursive
  algorithm for searching all the vertices of a graph or tree data
  structure  As its name suggests, it first explores the depth of
  the graph before the breadth i.e., it traverses along the increasing
  depth and upon reaching the end, it backtracks to the node from which it
  was started and then do the same with the sibling node.

 for reference  in future i will check links blow
    very well explained
(1)
   https://youtu.be/9zpSs845wf8

(2) https://youtu.be/CIm6RzdoPCI

(3) https://youtu.be/bmyyxNyZKzI

(4) https://youtu.be/6qwBZCaCI1U

(5)https://youtu.be/77jdkukUCbU

(6) https://www.programiz.com/dsa/graph-dfs

(7) https://youtu.be/Y40bRyPQQr0

(8) https://www.codesdope.com/course/algorithms-dfs/
*/

#include <stdio.h>

#include <stdlib.h>

// A structure to represent an adjacency list node

struct AdjListNode
{
    // index of element of array which contain all vertex
     int vertex_index;

    //a pointer for next node
    struct AdjListNode* next;
};


/*
  A structure to represent an adjacency list contain pointer to the
  first element(head) of the adjacency list(each vertices).   */

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
   the graph also contain array of all visited vetrics
*/

struct Graph
{
    // number of vertices
    int V;

    // Pointer to an array containing all the nodes (V) lists
    struct AdjList* array;

    // Pointer to an array containing all the visited nodes (V)lists
    int* visited;
};



//Function to create a new adjacency list node
struct AdjListNode* CreateNewNode(int dest);

//Function to create creates a graph of V vertices
struct Graph* createGraph(int V);

//function to Adds an edge to un directed graph

void addEdge(struct Graph* graph, int destination, int source);

//Function to print the adjacenncy list representation of graph
void printGraph(struct Graph* graph);

// Depth first search Graph traversal (DFS) algorithm
void DFS(struct Graph* graph, int vertex);


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
        printf("\nDepth first search Graph traversal (DFS) Implementation     : \n\n");

        printf("1 : Depth first search Graph traversal (DFS)                : \n");

        printf("2 : print the adjacency list representation                 : \n");

        printf("0 : quit                                                    :\n");

        // asking user for choice first
        printf("input your choice                                           :");
        scanf("%d",&ch);

        switch (ch)
        {
             // case 1  Depth first search Graph traversal(DFS)
            case 1 :

            DFS(graph, 2); // call DFS function

            /*
              We have starts DFS from vertex 2 but we can start
              from any vertex
            */

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

}


 /*
   utility function to create a new adjacency list node in
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
}


/*
   utility function to create a graph of  vertices (v) where V is the
   number of vertices take the number of vertices v as parameter
   and set graph -> v as (v) ( graph -> v = v;)

   and for graph -> array will create array of linked list size of array
   is equal to number of vertices and Initialize each adjacency in array to NULL

   also for for graph -> visited  will create array of pointer size of visited
   array is equal to number of vertices * sizeof(int) and Initialize each
   adjacency in visited array to 0 mean not visited yet
   (graph -> visited[i] = 0;)
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

    // Create an array to store visited lists. Size of array will be V

    graph -> visited =  malloc(V * sizeof(int));

    if(graph -> visited == NULL) // error handling
    {
        printf("error in allocating memory\n");
    }

    /*
     let Initialize each adjacency list in newly created visited
     array by null and give visited zero for each one which mean is
     unvisited we can access each adjacency list through head pinter
     let make head NULL for that we need for loop to first loop so we
     can set all to NULL (graph -> array -> head = NULL)
     ( graph -> visited[i] = 0)*/


    for (int i = 0; i < V; i++)
   {
      // making elements of all head null
       graph -> array[i].head = NULL; // now all are null

       // node are not yet discovered(not visited)
       graph -> visited[i] = 0;
   }

   return graph; // return graph to place where it been be called
}



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
}


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
         all the element and so on */


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
}



/*
 Depth First Search (DFS)
 Depth first traversal or Depth first Search (DFS)is a recursive algorithm
 for searching all the vertices of a graph or tree data structure
 As its name suggests, it first explores the depth of the graph before the
 breadth , it traverses along the increasing depth and upon reaching the end,
 it backtracks to the node from which it was started and then do the same with
 the sibling node.

 DFS algorithm

A standard DFS implementation puts each vertex of the graph
into one of two categories:

    (1)Visited
    (2)Not Visited

 The purpose of the algorithm is to mark each vertex as visited
 while avoiding cycles.

 The DFS algorithm works as follows:

    (1) Start by putting any one of the graph's vertices on top of a stack.

    (2) Take the top item of the stack and add it to the visited list.

    (3) Create a list of that vertex's adjacent nodes. Add the ones
       which aren't in the visited list to the top of the stack.

   (4) Keep repeating steps 2 and 3 until the stack is empty.

   DFS pseudocode (recursive implementation)
   DFS(G, u)
    u.visited = true
    for each v ∈ G.Adj[u]
        if v.visited == false
            DFS(G,v)

     init() {
    For each u ∈ G
        u.visited = false
     For each u ∈ G
       DFS(G, u)
      }


  in above pseudocode  the init() function, run the DFS function on every
  node. This is because the graph might have two different disconnected
  parts so to make sure that we cover every vertex, we can also run the DFS
  algorithm on every node.

  function take graph and any verticx as parameters


  DFS Algorithm Complexity

  The time complexity of the DFS algorithm is represented in the
  form of O(V + E), where V is the number of vertex and E is the number of edges.

   The space complexity of the algorithm is O(V).

   DFS Algorithm Applications

    (1) For finding the path
    (2) To test if the graph is bipartite
    (3) For finding the strongly connected components of a graph
    (4)For detecting cycles in a graph

*/

void DFS(struct Graph* graph, int vertex)
{


    /* store in temp adjacent nodes of this currentVertex
        temp now point to pinter to head of given vertex
       (temp = graph -> array[vertex].head;) */

    struct AdjListNode* temp = graph -> array[vertex].head;


     /* BFD start from the given vertex, so let's visited the
        given vertex  by changing it index in the visited array
        from zero to one(add to visited list)then inform user that
        this one is been visited  */

        // mark as visited
        graph -> visited [vertex] = 1; //visited

        //print clear message that this is one is visited
         printf("\n%d : is been Visited \n",vertex);


        /*
          now while the given vertex has adjacent nodes(temp != NULL)
          visited all its adjacent and for each it adjacent if its
          unvisited call FDS() on it (recursive call) by doing that
          we  make sure all the node in graph visited only onces*/

     while (temp != NULL)
     {

         // store in adjVertex  temp -> vertex;

         int adjVertex = temp -> vertex_index;


         /*
           only if the node is not yet visited then call DFS on
           it recursively then will be visited and move temp to
           next vertex until we reach NULL */

         if (graph -> visited [adjVertex] == 0)
         {
             // A recursive DFS Call
             DFS(graph, adjVertex);
         }

    // move temp to next adjacent  vertex
    temp = temp -> next;


  } // End while loop

}  // End DFS
