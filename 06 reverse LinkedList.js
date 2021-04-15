/** @format */

class Node {
	constructor(data, next = null) {
		this.data = data; // data filed
		this.next = next; // address of next node
	}
}

class linkedList {
	constructor() {
		// pointer to first node // (head)
		this.head = null;
	}

	// A utility function to insert new node to the Beginning of list
	insertAtBeginning(value) {
		// first step create the node
		let newNode = new Node(value);

		if (this.head === null) {
			// insert first node in list
			this.head = newNode;
		} else {
			/* if already some element are in the linked list we
        have to add the new node at the Beginning of the list */

			/** link changes */
			newNode.next = this.head; // right side connection first
			this.head = newNode; // left side connection second
		}
		console.log(`${value} is been inserted as first node in lis`);
		/** Time complexity of insertAtBeginning() is  : O(1) */
	}

	// A utility function to(Append) insert new node to the end of list

	append(value) {
		// local variables  declaration
		let newNode, temp;

		// first step create the node
		// (now node is ready to add)
		newNode = new Node(value);

		if (this.head == null) {
			//  check if list is empty then this node is the first node
			// insert as the first node in list
			// call insertAtBeginning to added as first node
			this.insertAtBeginning(value);
		} else {
			/* if already some element are in the linked list we have to first
         loop throw the linked list then add the new element at end */

			// temp is now point to head node
			temp = this.head;

			while (temp.next != null) {
				/* while we not yet reach to NULL move temp ahead*/
				temp = temp.next; // move temp to next node
			}
			temp.next = newNode; // add at end of list

			console.log(`${value} is been inserted at end of list`);
		}

		/** Time complexity of Append() is : O(N) */
	}

	/** Utility function to traverse the linked list
    and print all the element(Iterative method)*/
	traverse() {
		// local variable( temp is now point to head node)
		let temp = this.head;

		if (this.head == null) {
			//  linked is empty Case
			console.log("linked list is Empty");
			return; // we are done
		}
		/*
     by now we are sure list is not empty
     so while we not yet reach NULL print the value
     of node first and set temp to point to the next node */
		while (temp != null) {
			console.log(`${temp.data}  --> `); // print the value
			temp = temp.next; // move temp to next node
		}

		/** Time complexity of Traverse() is O(n) */
	}

	/**
    Utility function to traverse the linked list and print
    all the element recursion(Recursive method)
    */
	traverseUsingRecursion(currentHeadPointer) {
		if (currentHeadPointer == null) {
			//Exit condition
			return;
		}

		// else cases
		// first print the in the node which is first node
		console.log(currentHeadPointer.data);

		// Recursive call to move to next node
		this.traverseUsingRecursion(currentHeadPointer.next);
	}

	/*
    Utility function to traverse the linked list and print all the
    element in reverse order using recursion(Recursive method)
        */
	reversePrintUsingRecursion(currentHeadPointer) {
		if (currentHeadPointer == null) {
			//Exit condition
			return;
		} else {
			// Recursive call to move to next node first
			this.reversePrintUsingRecursion(currentHeadPointer);

			// after reach to last node and temp == NULL
			// will start printing from last to first in reverse order
			// console.log(currentHeadPointer.data);
		}
	}

	// Utility function to Head Pointer
	get getHeadPointer() {
		return this.head;
	}

	// A utility function to Reverse a linked list (Iterative method)
	reverse() {
		// local variables of type struct node declaration */
		let current, Previous, nextNode;

		Previous = null; // for Previous node
		current = this.head; // for current node
		nextNode = null; // for next node

		if (this.head == null) {
			// linked is empty Case
			console.log("linked list is Empty");
			return;
		}

		while (current != null) {
			/** link changes */
			nextNode = current.next; // move nextNode point to next node
			current.next = Previous; // Reverse current node
			Previous = current; // move Previous point to current node
			current = nextNode; // now move current point to next node

			// after that go back and loop again
		}
		// after while loop now let first(head) point to last node

		this.head = Previous; // Reverse first(head pointer) to point to last node

		console.log("linked list is been Reversed\n");

		/** Time complexity of Reverse() is O(n) */
	}

	// Utility function to Head Pointer
	getHead() {
		return this.head;
	}
}

const object1 = new linkedList();

for (let i = 1; i <= 5; i++) {
	object1.append(i);
}

object1.traverse();
object1.reverse();
object1.traverse();

let headPointer = object1.getHeadPointer;
console.log(headPointer);

// call traverseUsingRecursion() function
// object1.traverseUsingRecursion(head);

// call traverseUsingRecursion() function
// object1.reversePrintUsingRecursion(headPointer);
