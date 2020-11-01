/**
   [PROG]	    :(Disjoint Data Stucture in C) Union by Rank implementation
   [AUTHOR]		: Saddam Arbaa <saddamarbaas@gmail.com>
  Reference
  (1) https://youtu.be/ryNJby_n3hs
  (2) https://youtu.be/wU6udHRIkcc
  (3) https://youtu.be/WBLsaH26XXQ
  (4) https://youtu.be/14yCWubaXMk
  (5) https://youtu.be/kajZRdXi6fA
  (6) https://cp-algorithms.com/data_structures/disjoint_set_union.html
*/

#include <stdio.h>
#include <stdlib.h>

/*  declare global variable N
    (N is the number of vertice's in graph) *
    let say we have 10 */
# define N  10

/* declare global parent of size(N)  */
int parent[N];

/* declare global Rank Array of size(N)  */
int Rank[N];

// function to Initialize all vertex parent
void make_set();

// Finds set of given item v
int find_set(int v);

// join two subsets into a single subset
void union_sets(int a, int b);

// the  Driver Code
int main()
{
    // create single set
    make_set();

    // call union on(0,2)
    union_sets(1,2);

    // call union on(4,2)
    union_sets(4, 1);

    if(find_set(5) == find_set(1))
    printf("Are in same set\n");
    else
    printf("no are not in same set\n");

    // call union on(0,5)
    union_sets(1,5);
    if(find_set(5) == find_set(1))
    printf("Are in same set\n");
    else
    printf("no are not in same set\n");

    return 0;

}/* End of main*/


/**
  function to Creates N single item sets and initialize
  each vertex is parent itself and Rank size of each one is 1
 (In the beginning,every element starts as a single set and have
  Rank 1) */

void make_set()
{
    // counter
    int i;
    for (i = 1; i <= N; i++)
    {
        // in the beginning each vertex is parent its self
        parent[i] = i;

        // in the beginning Rank size of each vertex is 1
        Rank[i] = 1;
    }

}/* End of make_set */


/**
  Recursive function take one parameter V(vertex)
  and find which set vertex v belong to
  find set function work as flowing  :
  first check if given vertex (V) is parent of itself if so then return V
  else traverse parent array recursively until
  Finds vertex who is parent of itself and return it

   Pseudocode
   function Find(x)
   if x.parent ≠ x
     x.parent := Find(x.parent)
   return x.parent*/

int find_set(int v)
{
    // If v is the parent of itself
    if(parent[v] == v )
    {
        // Then v is the representative of this set
        return v;
    }
    else
    {
          /*
           Else if V is not the parent of itself,
           then recursively call Find on its parent until
           you hit vertex who is parent of itself and return it
           return find(parent[v]);   */

        // find_set(parent[v]) // recursively call

       /* as we can see if given vertex(V) is not is parent of itself
          then this take more time(liner time) as we make recursive
          call until we get vertex who is parent of itself and return it.

           so to improve this we can use what is call Path compression
           mean that after we have found vertex who is parent of itself
           from recursively call we make that vertex as direct parent of
           every vertex on way(Path compression) while returning including
           given vertex(v) before we return that so next time we call its
           will be fast constant time in @(1) */

          // recursively call
          parent[v] = find_set(parent[v]); // make direct parent

          return parent[v] ;

    }

} /* End of find_set*/


/**
    join two subsets into a single subset
    (merges the two specified sets).
    the function take 2 parameter A and B first call
    find set function to get parent of each one if and only if
    they are not in same set then check which one have size of
    higher Rank that one will be the  parent while merging
     them into a single subset */

void union_sets(int a, int b)
{
    // find parent of(a)
    a = find_set(a);

    // find parent of(b)
    b = find_set(b);

    if(a == b)
    {
        // A and B are already in the same set no need to merges just come back
        return;
    }

    // If A’s rank is bigger than B’s rank
    // A would be the parent
    if (Rank [a] > Rank[b])
    {
        parent[b] = a; //  move B under A

        Rank[a] += Rank[b]; // update Rank of A
    }
    else
    {
          // else which mean B’s rank is bigger than A’s rank
          // B would be the parent

          parent[a] = b; //  move A under B

         Rank[b] += Rank[a]; // update Rank of B
    }

    //Time complexity of the union operation is Theta(1)Θ(1).

} /* End of union_sets*/
