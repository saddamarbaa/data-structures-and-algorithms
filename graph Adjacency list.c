 
/*
                         Graph Data Stucture
 * [PROG]		 C Program for Adjacency list repres implementation CS50 IDE
 * [AUTHOR]		 Saddam Arbaa <saddamarbaas@gmail.com>

  adjacency list representation of graphs implementation

 for reference  in future i will check links blow
 https://youtu.be/k1wraWzqtvQ
 https://youtu.be/mrCmB8XtEsE
 https://youtu.be/5hPfm_uqXmw
 https://www.sanfoundry.com/
 https://youtu.be/X-filsfR_S8 */

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
   (we can say A graph is an array of adjacency lists).*/

struct Graph
{
    // number of vertices
    int V;

    //array containing all the nodes (V)
    struct AdjList* array;
};

//Function to create a new adjacency list node
struct AdjListNode* CreateNewNode(int dest);

//Function to ceate creates a graph of V vertices
struct Graph* createGraph(int V);

//function to Adds an edge to un directed graph
void addEdge(struct Graph* graph, int destination, int source);

//Function to print the adjacenncy list representation of graph
void printGraph(struct Graph* graph);

// Driver program to test code
int main()
{
    // create the graph given in above fugure
    int V = 5;

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

    // print the adjacency list representation of the above graph
    printGraph(graph);
    return 0;

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
}

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

    /*
    let Initialize each adjacency list in newly created array
    by null we can access each adjacency list through head pinter
    let make head NULL for that we need for loop to first so we can
    set all to NULL (graph -> array -> head = NULL)*/

    for (int i = 0; i < V; i++)
   {
      // making elements of all head null
       graph -> array[i].head = NULL; // now all are null
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
}
