/** @format */

/*** 
    [PROGRAM] : Doubly linkedlist Data Structure Complete Implementation
    [AUTHOR]  :  Saddam Arbaa
    [Email]   :  <saddamarbaas@gmail.com>

    Javascript Program for Complete implementation of Doubly linked list data structure.

    A linked list is a linear data structure, in which the elements
    are not stored at contiguous memory locations.
    The elements in a linked list are linked using pointers
    (entity that point to the next element)

    Doubly Linked list is a type of Linked List Data structure
    in which a node contain of three parts(filed)
    (1) node data,
    (2) pointer to the next node (next pointer)
    (3) pointer to the previous node(previous pointer).
 */

// stackblitz Testing Link
// https://stackblitz.com/edit/js-zlittw


// Node Class
class Node {
	constructor(data, next = null, prev = null) {
		this.data = data; // data filed
		this.next = next; // address of next node
		this.prev = prev; // address of previous node
	}
}

// Doubly Linked List Class
class DoublyLinkedList {
	constructor() {
		// pointer to first node // (head)
		this.head = null;
	}

	// A utility function to insert new node to the Beginning of list
	insertAtBeginning(value) {
		// first step create the node
		let newNode = new Node(value);

		// check if list is empty then this node is the first nod
		if (this.head == null) {
			this.head = newNode;
		} else {
			// if already some element are in the linked list we
			// have to add the new node at the Beginning of the list

			// link changes
			newNode.next = this.head; // right side connection first
			this.head.prev = newNode; // left side connection second
			this.head = newNode; // let Head point to the new node
		}

		console.log(`${value} is been inserted as first node in lis`);
		// Time complexity of insertAtBeginning() is  : O(1)
	}

	// Utility function to traverse the linked list
	// and print all the element(Iterative method)
	traverse() {
		// local variable(temp is now point to head node)
		let temp = this.head;

		if (this.head === null) {
			//  linked is empty Case
			console.log("linked list is Empty");
			return; // we are done
		}

		// by now we are sure list is not empty
		// so while we not yet reach NULL print the value
		// of node first and set temp to point to the next node
		while (temp !== null) {
			console.log(`${temp.data}  --> `);
			temp = temp.next; // move temp to next node
		}

		// Time complexity of Traverse() is O(n)
	}

	// A utility function to(Append)
	// insert new node to the end of list
	append(value) {
		// first step create the node
		let newNode = new Node(value);

		// check if list is empty then this node is the first node
		if (this.head === null) {
			// insert as the first node in list
			this.insertAtBeginning(value);
		} else {
			// if already some element are in the linked list we have to first
			// loop throw the linked list then add the new element at end

			let temp = this.head; // temp is now point to head node

			// while we not yet reach to NULL move temp ahead
			while (temp.next !== null) {
				temp = temp.next; // move temp to next node
			}

			/** link changes */
			newNode.prev = temp; // right side connection first
			temp.next = newNode; // left side connection second

			console.log(`${value}  is been inserted at end of list`);
		}

		// Time complexity of Append() is : O(N)
		// but if we have maintain one more variable tail pointer
		// to point to last nod while creating linked list then time
		// complexity of insert node at end will be O(1)
	}

	// A utility function to find the length of linked list
	length() {
		// local counter variable declaration and initializations to zero
		let count = 0;
		let temp = ths.head; // temp is now point to head node

		// while not yet reach NULL count the number of nodes in list
		while (temp != NULL) {
			count++; // increment count
			temp = temp.next; // move temp to next node
		}
		return count; // return the number of node in list

		// Time complexity of length() is O(n)
	}

	// A utility function to Reverse a linked list (Iterative method)
	reverse() {
		// local variables declaration
		let current, previous, nextNode;

		previous = null; // for Previous node (only to keep address of last node)
		current = this.head; // for current node
		nextNode = null; // for next node

		if (this.head === null) {
			// linked is empty Case
			console.log("Doubly linked list is Empty!!!");
			return; // we are done
		}

		while (current !== null) {
			// link changes
			nextNode = current.next; // move nextNode point to next node
			current.next = current.prev; // swap between current -> next and current -> prev
			current.prev = nextNode; // swap between current -> next and current -> prev
			previous = current; // I use Previous only to get address of last node and assign to head pointer
			current = nextNode; // move current to next until you reach null which is end of list

			// after that go back and loop again
		}
		// after while loop now let head) point to last node

		this.head = previous; // Reverse (head pointer) to point to last node

		console.log("Doubly linked list is been Reversed");

		// Time complexity of Reverse() is O(n)
	}
}

const object1 = new DoublyLinkedList();
for (let i = 1; i <= 10; i++) {
	// insert nodes from 1 to 10
	object1.append(i);
}

object1.traverse();

object1.reverse();

object1.traverse();
