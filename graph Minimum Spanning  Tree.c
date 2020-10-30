/**
    [PROGRAM] :  Minimum Spanning Tree Implementation using | Kruskal’s Algorithm
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    C program for Kruskal's algorithm to find Minimum Spanning Tree
    of a given connected, undirected and weighted graph

     A minimum spanning tree or MST is a spanning tree of
     an undirected and weighted graph such that the total
     weight of all the edges in the tree is minimum.
     (can say In a weighted graph, a minimum spanning tree
      is a spanning tree that has minimum weight than all other
       spanning trees of the same graph.)

 Kruskal's Algorithm

 In Kruskal's algorithm, we greedily choose the edge with minimum
 weight(greedy technique) such that no cycle is formed

    Code for Kruskal's Algorithm
 1. Sort all the edges from low weight to high weight.
 2. pick the edge with the lowest(smallest) weight and
   add it to the spanning tree.If adding the edge created
    a cycle, then reject this edge.
 3.  Keep adding edges until there are(V-1) edges in the spanning tree.
          (mean until we reach all vertices.)

 KRUSKAL(G)
  MST = NULL

  sort the edges acc. to their weights

  for edge in G.E
    if end of edge disconnected in MST // checking for cycle
      Include edge in MST

  return MST

   reference
  (1) https://youtu.be/k9jemw3SZe0
  (2) https://youtu.be/kajZRdXi6fA
  (3) https://youtu.be/WBLsaH26XXQ
  (4) https://youtu.be/4ZlRH0eK-qQ
  (5) https://youtu.be/14yCWubaXMk
  (6) https://youtu.be/FmKRdwYBkrY
  (7) https://youtu.be/wU6udHRIkcc
  (8) https://cp-algorithms.com/data_structures/disjoint_set_union.html
  (9) https://www.programiz.com/dsa/kruskal-algorithm */

#include <stdio.h>

#include <stdlib.h>

// define maximum number of vertice's to 100
#define MAX 100

// a structure to represent a weighted edge in graph
typedef struct edge
{
     /* U,V represent an Edge from vertex U to vertex V
        and W represent the weight of the edge */
    int u, v, w;

} edge;


/*
  a structure to represent Array of edge I will use
   the Edge Array list to sort the edge by their weight
    while applying Kruskal's Algorithm */

typedef struct edge_list
{
    //array of edges
    edge edge_Array[MAX];

    // to use as size
    int size;

} edge_list;

// declare global variable of edge_list
edge_list elist;

/* declare global Graph represented as 2 D Array
   and n is number of vertices's  */
int Graph[MAX][MAX], n;

// declare global edge list spanlist
edge_list spanlist;

/*
  declare global array belongs(set)of size max to store
  which sets each vertex belong to while applying
 Kruskal's Algorithm */
int belongs[MAX];

// Kruskal_Algorithm
void Kruskal_Algorithm();

// function join two subsets into a single subset
void union_sets(int a, int b);

// function to find which set given vertex (v)belong to
int find_set(int v);

// function to sort the Edges by their weight
void edgeSort();

// function to print the Minimum Spanning Tree
void print();


// the  Driver Code
int main()
{
    //number of vertices's
    n = 6;


    /* connect the Edges from vertex u to v and from v to u
       with the given weight in Graph(2D array) */

    Graph[0][0] = 6;
    Graph[0][1] = 4;
    Graph[0][2] = 4;
    Graph[0][3] = 6;
    Graph[0][4] = 6;
    Graph[0][5] = 10;
    Graph[0][6] = 50;

    Graph[1][0] = 4;
    Graph[1][1] = 0;
    Graph[1][2] = 2;
    Graph[1][3] = 0;
    Graph[1][4] = 0;
    Graph[1][5] = 0;
    Graph[1][6] = 0;

    Graph[2][0] = 4;
    Graph[2][1] = 2;
    Graph[2][2] = 0;
    Graph[2][3] = 3;
    Graph[2][4] = 4;
    Graph[2][5] = 0;
    Graph[2][6] = 0;

    Graph[3][0] = 0;
    Graph[3][1] = 0;
    Graph[3][2] = 3;
    Graph[3][3] = 0;
    Graph[3][4] = 3;
    Graph[3][5] = 0;
    Graph[3][6] = 0;

    Graph[4][0] = 0;
    Graph[4][1] = 0;
    Graph[4][2] = 4;
    Graph[4][3] = 3;
    Graph[4][4] = 0;
    Graph[4][5] = 0;
    Graph[4][6] = 0;

    Graph[5][0] = 0;
    Graph[5][1] = 0;
    Graph[5][2] = 2;
    Graph[5][3] = 0;
    Graph[5][4] = 3;
    Graph[5][5] = 60;
    Graph[5][6] = 0;

    //calling Kruskal Algorithm() function
    Kruskal_Algorithm();

    //calling print() function
    print();
}


/**
   Kruskal's algorithm to find Minimum Spanning Tree
  KRUSKAL(G):
  A = ∅
  For each vertex v ∈ G.V:
    MAKE-SET(v)
  For each edge (u, v) ∈ G.E ordered by increasing order by weight(u, v):
    if FIND-SET(u) ≠ FIND-SET(v):
    A = A ∪ {(u, v)}
    UNION(u, v)
   return A
*/


void Kruskal_Algorithm()
{
    // i and j are counter and a,b to store vertexes
    int i, j ,a,b;

    // set size of Edge list to zero
    elist.size = 0;

    // outer loop
    for (i = 1; i < n; i++)
    {
        // inner loop
        for (j = 0; j < i; j++)
        {
            //if we have Edge then do the flowing
            if (Graph[i][j] != 0)
            {
                // set i as vertex u
                elist.edge_Array[elist.size].u = i;

                // set j as vertex v
                elist.edge_Array[elist.size].v = j;

                /*
                 set value at Graph[i][j] as w
                 because is not zero is mean that is weight */

                elist.edge_Array[elist.size].w = Graph[i][j];

                //update the size
                elist.size++;
            }
        }
    }


    // now we need sort the Edge for that i call sort function
    edgeSort();

    /*
      grouping vertex in sets
      in the beginning each vertex itself is a set
      (mean is each vertex belong to itself) */

    for(i = 0; i < n; i++)
    {
       // each vertex belong to itself
        belongs[i] = i;
    }

    // set size of spanlist to zero
    spanlist.size = 0;

    // let loop in list
    for(i = 0; i < elist.size; i++)
    {
        // call find_set function to check if a and b are in same set
        a = find_set(elist.edge_Array[i].u);

        b = find_set(elist.edge_Array[i].v);

        /*
           if and only if are not in same set then join them
            for that we need to call union_sets()function */
            if(a != b)
            {
                spanlist.edge_Array[spanlist.size] =  elist.edge_Array[i];
                spanlist.size = spanlist.size + 1; // update the size
                union_sets(a,b); // join them in one set
            }
    }

}/* End of Kruskal_Algorithm() */



/**
    function to sort the Edges by their weight
     from smaller to bigger   */

void edgeSort()
{
    // declare counter i and j
    int i, j;

    //temp variable of type adge
    edge temp;

    for (i = 1; i < elist.size; i++)
    {
        for (j = 0; j < elist.size - 1; j++)
        {
            // if condition is true then go and swap
            if (elist.edge_Array[j].w > elist.edge_Array[j + 1].w)
            {
                // swap process
                 temp = elist.edge_Array[j];

                elist.edge_Array[j] = elist.edge_Array[j + 1];

                elist.edge_Array[j + 1] = temp;
            }

        } // end of inner loop

    } // end of outer loop

}/* end of edgeSort() */


/**
   join two subsets into a single subset
   (merges the two specified sets).*/

void union_sets(int a, int b)
{
    int i;
    for (i = 0; i < n; i++)
    {
        if(belongs[i] == b)
         belongs[i] = a;
    }

 /* a and b are now in same set
    loop make sure to join very vertex  belong to set B into set a

 */

}/* end of union_sets() */


/** function to find which set given vertex belong to */

int find_set(int v)
{
    // return the sub set this vertex belong to
    return (belongs[v]);

}/* end of find_set() */


/** function to Print the result of spanning tree */

void print()
{
    int i, minCost = 0;

    // traverse the spanning tree and calculate the the minimum cost
    for (i = 0; i < spanlist.size; i++)
    {
        printf("\n%d - %d : %d", spanlist.edge_Array[i].u, spanlist.edge_Array[i].v, spanlist.edge_Array[i].w);
        minCost = minCost + spanlist.edge_Array[i].w;
    }

    printf("\nSpanning tree cost: %d\n", minCost);
}
