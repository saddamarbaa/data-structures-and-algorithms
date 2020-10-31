/*
                  :  Graph Data Stucture
 * [PROG]		  :  Adjacency matrix representation implementation  in c using cs50 IDE
 * [AUTHOR]		 : Saddam Arbaa <saddamarbaas@gmail.com>

        An adjacency matrix is a way of representing a graph G = {V, E}
        as a matrix of booleans.
        we create a square Matrix of size(VxV) where V is the number
        of verticex in the graph and the value of an entry Array([i][j])
        is either 1 or 0 depending on whether there is an edge from
        vertex i to vertex j.
        we create Adjacency Matrix using  the steps Below  :

        (1) Create a 2D array of size V x V and initialize all value of this matrix to zero.
        (2) For each edge in arr[][](say i and j), Update value at Adj[i][j] and Adj[j][i] to 1,
           to show that there is a edge between i and j.

         (3) print the Adjacency Matrix after the above operation for all the pairs in arr[i][j].

         time complexity for adjacency matrix for operations like finding
         adjacent node or finding if the node are connected is Big O(v) where
         v is number of vertex which very efficient however space complexity
         for adjacency matrix is so big BIG o(V*V) which v square.
         so for that adjacency lists are the better choice for most tasks.
*/

#include <stdio.h>

#include <stdlib.h>

// define number of vertices's
#define V 4

//Initialize all value in adjacency Matrix to zero
void initialize(int adjacencyMatrix[V][V]);

// traverses adjacency Matrix  and Print it values
void printAdjMatrix(int adjacencyMatrix[V][V]);

// connect the Edges of vertex and update their value to 1 from zero
void addEdge(int adjacencyMatrix[][V], int startVertex, int endVertex);

// the  Driver Code
int main()
{
    // declare adjacency Matrix  size (v*v)
    int adjacencyMatrix[V][V];

    // call function to Initialize the matrix to zero
    initialize(adjacencyMatrix);

    // connect the Edges of vertex
    addEdge(adjacencyMatrix, 0, 1);
    addEdge(adjacencyMatrix, 0, 2);
    addEdge(adjacencyMatrix, 1, 2);
    addEdge(adjacencyMatrix, 2, 0);
    addEdge(adjacencyMatrix, 2, 3);
    addEdge(adjacencyMatrix, 3, 0);

    // call function to Print adjacency Matrix
    printAdjMatrix(adjacencyMatrix);

    return 0;
}

// function to Initialize all value in adjacency Matrix to zero
void initialize(int adjacencyMatrix[V][V])
{
    // create two variable i and j  I will use them then as counter
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
}


/*
  function to Traverse(Print) all the  value in adjacency Matrix */

void printAdjMatrix(int adjacencyMatrix[V][V])
{
    // create two variable i and j  I will use them then as counter
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
}


/*
   function to Traverse the Adjacency Matrix[V][V]of vertex
   and connect the Edges from given startVertex  to endVertex
   the function take 3 parameters  blow
   (int adjacencyMatrix[V][V] , int startVertex; int endVertex)

*/

void addEdge(int adjacencyMatrix[][V], int startVertex, int endVertex)
{
    /* conned the Edges in adjacencyMatrix[startVertex][endVertex ] =1
      startVertex = i;
      endVertex = j;
      Update value to 1
    */

    adjacencyMatrix[startVertex][endVertex] = 1; // Update value to 1
    adjacencyMatrix[endVertex][startVertex] = 1; // Update value to 1
}

