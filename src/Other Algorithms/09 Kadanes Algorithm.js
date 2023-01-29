/* Kadane's Algorithm

 Topic: Dynamic Programming; Difficulty: Intermediate

 Prompt: 
 Write a function that takes in a non-empty array of integers and returns the maxmium 
 sum that can be obtained by summing up all of the integers in a non-empty subarray of the input array. 
 A subarray must only contain 'adjacent numbers'.(numbers next to each other in the input array).

 Sample Input:
 array = [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]

 
 Sample Output:
 19 // [1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1]

*/
// ready
// Solution #1:
function kadanesAlgorithm(array) {
  // pick the greatest value of the maxSum
  // Goal: Find the maxSum ending at the index

  // STEP#1: init variables
  // TWO Variables
  let maxEndingHere = array[0];
  let maxSum = array[0]; // array[i]

  // calculate the value of the maxSum
  // STEP#2:  for loop
  for ( let i=1; i< array.length; i++) {
    const currentNum = array[i]; // we do not reassign the variable so, we using const
    // 2.a] in each iteration, we choose the maxValue 
    // reassign the maxEndingHere and maxSum
    maxEndingHere = Math.max(currentNum, maxEndingHere + currentNum);

    maxSum = Math.max(maxSum, maxEndingHere) // reassign the larger value 
  }
  return maxSum; // maxSum is a Value not an array
}

/* Big O Notation Explainations:

Time Complexity: O(n)

line#25 & line#26: Assignment Opeator: O(1) --> constant time

line#30: O(n)
for ...loop: as the number grows, we go through the argument input once for each interation. 

line#34: compare two numbers, it is constant time : O(1)

line#36: compare two numbers, it is constant time : O(1)

line#38: return assignment is constant, O(1)


Space Complexity: O(1)
line#25, line#26: assign two variables, it is constant

line#30: for each iteration of the loop, use a variable to store each number, we did not use extra array or other data strutures to create extra memory.

line#34 && line#36: varaible assignment it is constant. store 1 number 

line#38: return the number we saved in the previous variables.
*/

// Solution#2: by Ray: using same method
function kadanesAlgorithm(array) {
  // Write your code here.
	let currMax =array[0], accMax = array[0]
     
    for ( let i = 1; i < array.length; i++ ) {
      accMax = Math.max( array[i], accMax + array[i] )
      currMax = Math.max(currMax, accMax)
}
 return currMax;
 }


 // Solution#3: by Ray: using Conditional Statement
 function kadanesAlgorithm(array) {
  // Write your code here.
	let currMax = array[0], accMax = array[0];
    
  for ( let i = 1; i < array.length; i++ ) {
    accMax += array[i];
    
    if ( currMax < accMax ) currMax = accMax

    if ( accMax < 0 ) accMax = 0;
  }
  return currMax;
}


// Complete Walk-through 

/**
# AlgoBUS Meeting #26

Date: 04/10/2021 Saturday

Question: Kadanes Algorithm
Topic: Dynamic Programming| Difficulty: Intermediate

# PART.A: Prompt Understanding and Analysis

Prompt Understanding

What info we got from the prompt?

Question to think:

Goal:

# PART.B: Related Concept Overview

Logic: && thought process
STEP#1: calculate or generate maxSum
STEP#2: pick the greatest Value of the maxSum

Goal:to find the maxValue ending at the particular index.

using: => Dynamic Programming Approach:

# PART.C: Demo: Problem Walkthrough

array = [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
index:
[0, 1, 2, | 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
array =
[3, 5, -9, | 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]

UpdatedAccuSumArr =
[3, 8, -1, | 0, 4,]

since currentNum > AccumSum, we keep the currentNum as the maxAccSum

maxEndingHere =
[3, 8, -1, | 1, 4, 2, 5, 9, 16, 18, 9, 15, 18, 19, 14, 18]

// we did not create an extra array to store the updated value
maxSum =
[3, 8, 8, 8, 8, 8, 8, 9, 16, 18, 18, 18, 18, 19, 19, 19]

Round#1:
when i =0; ele = 3
AccuSum = 3

2nd iteration
when i =1; ele = 5
AccuSum = 3 + 5 = 8

3rd iteration:
when i =2; ele = (-9)
AccuSum = 8+ (-9) = -1

4th iteration:
when i =3, ele = (1)
AccuSum= (-1) + 1 = 0

Formula:
STEP#1: plug numbers in the Formula:
maxEndingHere ={ TWO Possibilities: }
1.] maxEndingHere + currentNum
OR
2.] currentNum

STEP#2: Compare two numbers to choose the greatest Value
Qta: maxEndingHere >? currentNum

5th iteration:
when i =4, ele =3
AccuSum= (1) + 3 =4

6th iteration:
when i =5, ele = -2
UpdateSum = 4 + (-2) =2
compare with UpdateSum with currentNum
2 > (-2) ?
yes,
keep UpdateSum to be: 2

7th iteration:
when i =6, elem = 3
UpdatedSum =2 + (3) = 5
currentNum = 3
QtaL is 5 > 3 ?
yes,
keep the UpdateSum to be: 5

8th iteration:
when i =7, elem = 4
UpdatedSum =5 + (4) =9
currentNum = 4
QtaL is 9> 4 ?
yes,
keep the UpdateSum to be: 9

9th iteration:
when i =8, elem = 7
UpdatedSum =9 + (7) =16
currentNum = 7
QtaL is 16> 7 ?
yes,
keep the UpdateSum to be:16

10th iteration:
when i =9, elem = 2
UpdatedSum =16 + (2) =18
currentNum = 2
QtaL is 18> 2 ?
yes,
keep the UpdateSum to be:18

11th iteration:
when i =10, elem = -9
UpdatedSum =18 + (-9) =9
currentNum = -9
QtaL is 9> -9 ?
yes,
keep the UpdateSum to be:9

12th iteration:
when i =11, elem = 6
UpdatedSum = 9+ (6) =15
currentNum = 6
QtaL is 15> 6?
yes,
keep the UpdateSum to be: 15

13th iteration:
when i =12, elem = 3
UpdatedSum = 15+ (3) = 18
currentNum = 3
QtaL is 18 > 3?
yes,
keep the UpdateSum to be: 18

14th iteration:
when i =13, elem = 1
UpdatedSum = 18 + (1) = 19
currentNum = 1
Qta: is 19> 1?
yes,
keep the UpdateSum to be: 19

15th iteration:
when i =14, elem = -5
UpdatedSum = 19 + (-5) =14
currentNum =-5
Qta: is 14 > (-5) ?
yes,
keep the UpdateSum to be: 14

16th iteration:
when i =15, elem = 4
UpdatedSum = 14 + (4) = 18
currentNum =4
Qta: is 18> 4?
yes,
keep the UpdateSum to be:18

# PART.E: Puseudo Code:

# PART.F: Alternative Solutions and Approaches

# PART. G: CheatSheet if any
 */
