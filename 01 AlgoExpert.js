/* Insertion Sort
 Topic: Sorting Algorithm -- Insertion Sort; Difficulty: Easy

 Prompt: 
 Write a function that takes in an array of integers and returns  a SORTed version of that array. Use the Quick Sort Algorithm to sort the array.

 
 Sample Input:
 array = [8, 5, 2, 9, 5, 6, 3]

 -----
 found 1st Perfect Position of 1st PivotNum
 [6, 5, 2, 3, 5, 8, 9]

 ----
 found 2 perfect positon numbers: 8, 9

 ------
 found 3 perfect position numbers: 
 6, 8, 9

 2nd PivotNum
 [5, 5, 2, 3,6,8,9]

 ------
 found 4 perfect position numbers
 3rd pefect position of pivotNum
 5,6,8

 [3,5,2,5,6,8,9]





 Sample Output:
 [2, 3, 5, 5, 6, 8, 9]

*/

//const { right } = require("inquirer/lib/utils/readline");

// Solution#1:
function quickSort(array) {
	// Write your code here...
	// call the helper function
	helper(array, 0, array.length-1 );

	return array;

}

// create a helper function: keep track of recursion
function helper(array, start, end) {
	// start 
	// base case: for recursion
	if(start >= end ) return;
	// init pointers
	let pivotPointer = start;
	let leftPointer = start +1;
	let rightPointer = end;

	// loop thru
	while ( leftPointer <= rightPointer) {
			// conditional check
			// check if 
			if((array[leftPointer] > array[pivotPointer] )&&(array[rightPointer] < array[pivotPointer])) {
					//if both meet, call swap function
					swap(leftPointer, rightPointer, array);
			}
			if(array[leftPointer] <= array[pivotPointer]) {
					// move leftPointer to the right
					leftPointer ++;
			}
			if(array[rightPointer] >= array[pivotPointer]){
					rightPointer --;
			}

	}

	// swap the pivotNum with rightNum
	swap(pivotPointer, rightPointer, array);

	// call the helper function itself
	
		const leftSubarrayIsSmaller = (rightPointer - 1 - start) < (end - (rightPointer + 1));
			
if (leftSubarrayIsSmaller) {
	helper(array, start, rightPointer - 1);
	helper(array, rightPointer + 1, end);
} else {
	helper(array, rightPointer + 1, end);
	helper(array, start, rightPointer - 1);
}


}

function swap(i, j, array) {
	// right side only cares about the left side; left side only cares about the right side.
	[array[i], array[j]] = [array[j], array[i]];
	}

/* BIG O Notation
Note that: Quick Sort 


Time Complexity: 
worst case: O(n^2) Time
every single possible loop

Average Case: Time = O(nlog(n))
we need to loop through the array at least once to make sure it's sorted, but the amount of numbers we check at each pass gets shorter and shorter. 


Space Complexity: 
O(log(n)) because of the recursive calls. Each time we call our function recursively we use space to perform the sort, but the number of stack frames in our recursive call will be less than the number of items in our array.


*/

// Solution#2 by Ray:
function quickSort(array) {
	// Write your code here...
	
	

}
