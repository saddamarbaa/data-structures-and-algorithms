/*
                 Graph Data Stucture
 * [PROG]		:  Implementation of Depth First Search (DFS) using adjacency matrix representation
 * [AUTHOR]		: Saddam Arbaa <saddamarbaas@gmail.com> */

#include <stdio.h>
#include <stdlib.h>

// define number of vertices's
#define V 4

 // declare global adjacency Matrix of size (v*v)
 // so graph is store in adjacencyMatrix[V][V]
 int adjacencyMatrix[V][V];

 // declare global visited array of size(v)
 // to store the visited vertex
 int visited[V];

//Initialize all value in adjacency Matrix to zero
void initialize();

// traverses adjacency Matrix  and Print it values
void printAdjMatrix();

// connect the Edges of vertex and update their
// value to 1 from zero
void addEdge(int startVertex, int endVertex);

//Initialize all value in visited array to zero
void  visited_initialize();

// DFS Function to traverses adjacency
// Matrix (graph) and Print it values
void DFS(int start);

// the  Driver Code
int main()
{
    // call function to Initialize the matrix to zero
    initialize();

    // call function to Initialize the visited array to zero
    visited_initialize();

    // connect the Edges of vertex
    addEdge(0, 1);
    addEdge(0, 2);
    addEdge(1, 2);
    addEdge(2, 0);
    addEdge(2, 3);
    addEdge(3, 0);

    // call function to Print adjacency Matrix
    printAdjMatrix(adjacencyMatrix);

    // call DFS function to Print adjacency Matrix
    printAdjMatrix(adjacencyMatrix);

     /*
     call DFS function to Perform DFS (DFS start from 0)
        but it can start from any vertex  */
    DFS(0);

    return 0;// signal to operating system everything works fine

} /** End of main function */


// function to Initialize all value
// in adjacency Matrix to zero

void initialize()
{
    // create two variable i and j
    // I will use them then as counter
    int i, j;

    // outer loop
    for (i = 0; i < V; i++)
    {
        // inner loop
        for (j = 0; j < V; j++)
        {
            // Initialize the matrix to zero
            adjacencyMatrix[i][j] = 0;
        }
    }

} /* END  initialize */



/* function to Traverse(Print) all the value in adjacency Matrix */

void printAdjMatrix()
{
    // create two variable i and j
    // I will use them then as counter
    int i, j;

    // outer loop
    for (i = 0; i < V; i++)
    {
        // print row adjacencyMatrix[i]
        printf("%d : ", i);

        // inner loop
        for (j = 0; j < V; j++)
        {
            // Print the value at AdjacencyMatrix[i][j]
            printf("%d\t", adjacencyMatrix[i][j]);
        }
        // print new line after printing every row
        printf("\n");
    }

} /* END printAdjMatrix */


/*
   function to Traverse the Adjacency Matrix[V][V]of vertex
   and connect the Edges from given startVertex  to endVertex
   the function take 2 parameters  blow
   (int startVertex; int endVertex)*/

void addEdge( int startVertex, int endVertex)
{
    /* conned the Edges in adjacencyMatrix[startVertex][endVertex ] =1
      startVertex = i;
      endVertex = j;
      Update value to 1
    */

    adjacencyMatrix[startVertex][endVertex] = 1; // Update value to 1
    adjacencyMatrix[endVertex][startVertex] = 1; // Update value to 1

} /* END addEdge */


/*
 function to Initialize all value in Visited array
 to zero indicate that no vertex is been visited yet

 */

void  visited_initialize()
{
    // create variable i to use it as counter
    int i;

   // loop in visited array
    for (i = 0; i < V; i++)
    {
        //visited is initialized to zero
        visited[i] = 0;
    }

} /* END visited_initialize */


/*
   in Breadth first search Traversal using adjacency matrix
   we can can start traverse from any vertex, say Vi .
   Vi is visited and then all vertices adjacent to Vi are traversed
   recursively using DFS. Since, a graph can have cycles. We must
   avoid revisiting a node more than one .

   To do this, when we visit a vertex V, we mark it visited.
   A node that has already been marked as visited should not be
   selected for traversal.
   Marking of visited vertices can be done with the help of a global
   array visited[ ]. Array visited[ ] is initialized to false (0).

   Depth First Search (DFS) Algorithm blow

   m ← number of vertex

   Initialize visited[ ] to false (0)
   for(i = 0;i<m;i++)
	visited[i] = 0;

  void DFS(vertex i) [DFS starting from i]
  {
	 visited[i] = 1;
	 for each w adjacent to i
		if(!visited[w])
			DFS(w);
  }

*/


void DFS(int start)
{
    // create variable k to use it as counter
    int k;

    // Print the visited vertex to user
    printf("%d : is been Visited\n",start);

    // Set current vertex as visited (will not be visit again)
    visited[start] = 1;

    /*
       If any adjacent vertex  to the current vertex
       not  been visited  call DFS on that vertex
       recursively by doing this we make sure that
       each vertex in graph will visited only once    */


   // loop in visited array
    for (k = 0; k < V; k++)
    {
        if(visited[k] == 0 && adjacencyMatrix[start][k] == 1)
        {
            DFS(k); // if so call DFS recursively on this vertex
        }
    }

} /* END DFS */
