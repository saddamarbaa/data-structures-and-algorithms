
/** @format */

class Node {
	constructor(data, next = null, prev = null) {
		this.data = data; // data filed
		this.next = next; // address of next node
		this.prev = prev; // address of previous node
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

		// check if list is empty then this node is the first nod
		if (this.head == null) {
			this.head = newNode;
		} else {
			/* if already some element are in the linked list we
        have to add the new node at the Beginning of the list */

			/** link changes */
			newNode.next = this.head; // right side connection first
			this.head.prev = newNode; // left side connection second
			this.head = newNode; // let Head point to the new node
		}

		console.log(`${value} is been inserted as first node in lis`);
		/** Time complexity of insertAtBeginning() is  : O(1) */
	}

	/** Utility function to traverse the linked list
    and print all the element(Iterative method)*/

	traverse() {
		// local variable(temp is now point to head node)
		let temp = this.head;

		if (this.head === null) {
			//  linked is empty Case
			console.log("linked list is Empty");
			return; // we are done
		}

		/*
     by now we are sure list is not empty
     so while we not yet reach NULL print the value
     of node first and set temp to point to the next node */

		while (temp !== null) {
			console.log(`${temp.data}  --> `);
			temp = temp.next; // move temp to next node
		}

		/** Time complexity of Traverse() is O(n) */
	}

	/**
	  A utility function to(Append)
    insert new node to the end of list */
	append(value) {
		// first step create the node
		let newNode = new Node(value);

		// check if list is empty then this node is the first node
		if (this.head === null) {
			// insert as the first node in list
			this.insertAtBeginning(value);
		} else {
			/* if already some element are in the linked list we have to first
				 loop throw the linked list then add the new element at end */

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

		/**
		Time complexity of Append() is : O(N)
		but if we have maintain one more variable tail pointer
		to point to last nod while creating linked list then time
		complexity of insert node at end will be O(1) */
	}
}

let t = new linkedList();

for (let i = 1; i < 10; i++) {
	t.append(i);
}

console.log(t.traverse());
