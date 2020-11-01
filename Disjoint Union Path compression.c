/**
   [PROG]	    :(Disjoint Set Union Data Stucture in C) Union Path compression implementation
   [AUTHOR]		: Saddam Arbaa <saddamarbaas@gmail.com>

  Disjoint Set Union or DSU. Often it is also called Union Find
  because of its two main operations, is a data structure that
  keeps track of a universe of elements .
  We are given several elements, each of which is a separate set
  A DSU will have an operation to combine any two sets,
  and it will be able to tell in which set a specific element is.
  Disjoint sets Operations :
 Find : determine which set a particular element is in.

 Union: join two subsets into a single subset( merges the two specified sets).
  Reference
  (1) https://youtu.be/wU6udHRIkcc
  (2)https://youtu.be/WBLsaH26XXQ
  (3) https://youtu.be/14yCWubaXMk
  (4)https://youtu.be/kajZRdXi6fA
  (5) https://cp-algorithms.com/data_structures/disjoint_set_union.html

*/

#include <stdio.h>
#include <stdlib.h>

/*  declare global variable N
    (N is the number of vertice's in graph) *
    let say we have 10 */
# define N  10

/* declare  globally parent of size(N)  */
int parent[N];

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
    union_sets(0,2);

    // call union on(4,2)
    union_sets(4, 2);

    if(find_set(5) == find_set(0))
    printf("Are in same set\n");
    else
    printf("no are not in same set\n");

    // call union on(0,5)
    union_sets(0,5);
    if(find_set(5) == find_set(0))
    printf("Are in same set\n");
    else
    printf("no are not in same set\n");

    return 0;

}/* End of main*/


/**
 function to Creates N single item sets
 and initialize each vertex is parent itself
 (In the beginning, every element starts as a single set) */

void make_set()
{
    // counter
    int i;
    for (i = 1; i <= N; i++)
    {
        // in the beginning each vertex is parent its self
        parent[i] = i;
    }

}/* End of make_set */

/**
  Recursive function take one parameter V(vertex)
  and find which set vertex v belong
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
    find set function to get parent of each one if and only
    if they are not in same set then
    merge them into a single subset */

void union_sets(int a, int b)
{
    // find parent of(a)
    a = find_set(a);

    // find parent of(b)
    b = find_set(b);

    if(a == b)
    {
        return ;// they are equal do nothing just return
    }
    else // if are not equal
    {
        // join them
        parent[b] = a; //set parent of (A) as (B)
        // note here we can join A to be Or B to A are same
    }

    //Time complexity of the union operation is Theta(1)Θ(1).


} /* End of union_sets*/

