/* Minimum Waiting Time
 Topic: Greedy Algorithm; Difficulty: Easy

 Prompt: 
 You're given a non-empty array of positive integers representing the amounts of time that specifies 'queries' take to execute. Only one  'query' can be executed at a time, but the queries can be executed in any order.

 A query's 'waiting time' is defined as: the amount of time that it must wait before its execution starts. In other words, if a query is executed second, then its waiting time is the duration of the first query; if a query is executed third, then its waiting time is the sum of the durations of the first two queries.

 Write a function that returns the minimum amount of total waiting time for all of the queries.
 For example, if you are given the queries of durations [ 1, 4, 5], then the total waiting time if the queries were executed in the order of [5, 1, 4] would be: (0) + (5) + (5+1) =11.

 The first query of duration: 5 would be executed immediately, so its waiting time would be 0.
 
 The second query of duration: 1 would have to wait 5 secs (the duration of the first query) to be executed, and the last query would have to wait the duration of the first two queries before being executed.

 Note: you're allowed to 'mutate' the input array. 


 Sample Input:
 queries = [3, 2, 1, 2, 6]


 
 sample output: 17

*/

// Solution#1:
function minimumWaitingTime(queries) {
  // Write your code here...
  // step#1: sort the array in asc order
  // => how to sort the given array?
  queries.sort((a, b) => a-b );
  //=>  if sort array in dec order: 
  //=> array.sort((a,b) => b-a);

  //step#2: instinatiate/declare a cumulative variable 
  let totalWaitingTime = 0;

  //step#3:Iteration using for...loop
  for (let i=0; i< queries.length; i++) {
    // step#3.1] create two variables
    let duration = queries[i];
    let queriesLeft = queries.length - (i + 1); // e.g. 5 - (3 + 1) = 1 queries
    //e.g. 5 - (0 + 1) = 4 queries remaining
    //e.g. for 2nd person ele: 5 -(1 +1) = 3
    // step#3.2] calculate the totalWaitingTime
    totalWaitingTime += duration * queriesLeft;
  }

  // step#4: totalWaitingTime
  return totalWaitingTime;

}




/*
explainations for array.sort() function:
a represent: 1st value
b represent: 2nd value

*/


/* Big O Notation Explainations
Time Complexity:  
Time Complexity= O(nlog(n))

line#33: array.sort() is: 
O(nlog(n))

line#38: variable assignment is constant = O(1)

line#41: iteration: 
loop thru the every element of the array => O(n) linear time 

line#43 && line#44: assignment operator is constant time => O(1)

line#48: calculation operation is constant time => O(1)

line#52: return a number => O(1)

So, Time Complexity: always the worst
O(1) + O(n) + O(nlog(n)) => 
best, average, worst
ignore/eliminate + ignore/ eliminate + O(nlog(n))

Space Complexity:
Space Complexity =  O(1)
--> not using extra data structure to use extra space.

--> constant space

*/

// Solution#2:
function minimumWaitingTime( queries ) {
  let totalWaitingTime = 0;
  let prevTotalArr = [0];
  let iterTotal = 0;

  const sortedQueries = queries.sort( ( a, b ) => a - b );

  for (let i = 0; i <= sortedQueries.length -1; i++ ) {
    
    if ( i !== 0 ) {
      iterTotal += sortedQueries[i - 1]
      console.log( `iterTotal = ${ iterTotal }` )
      prevTotalArr.push( iterTotal )
      totalWaitingTime += prevTotalArr[i]
    }
  }

  return totalWaitingTime;
}

console.log( minimumWaitingTime( [ 3, 2, 1, 2, 6 ]))

/*
//console.log( minimumWaitingTime( [  3, 2, 6, 1, ]))
//[ 1,       2,           3,                 6 ]
//  0 + [(0) + 1] + [(0 + 1) + 2] + [(0 + 1  + 2) +  3]  = 9
//  0 +     a0          (a0+a1)   +     (a 0+ a1 + a2)

//[ 3, 2, 1, 2, 6 ]
//[ 1, 2, 2, 3, 6 ]
// 0 + 1 + (1 + 2) + (1 + 2 + 2) + (1 + 2 + 2 + 3)
// 0 + 1 +    3    +      5      +        8        = 17
*/


/* Big O Explainations for Solution#2 by Ray

// Time Complexity = O(nLog(n))

// Space Complexity = O(n) 
The pevToatalArray is used to store the cumulative values of the previous elements.

*/
