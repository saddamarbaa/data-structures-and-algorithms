// Linked list implementation in Java

class SinglyLinkedList<T> {
    // Linked list Node.
    // Node is a private static nested class so main() can't access it directly
    static class Node<T> {
        T data;
        int key;
        Node<T> next;
        static int nextKey = 1;

        // Constructor
        Node(T data, Integer key) {
            this.data = data;
            if (key != null) {
                this.key = key;
            } else {
                this.key = generateUniqueKey();
            }
            this.next = null;
        }


        // Generate a unique key based on current time in milliseconds
        private int generateUniqueKey() {
            return (int) System.currentTimeMillis() + nextKey++;
        }
    }

    // Creating a node
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Method to create a new node with data and key
    public  Node<T>createNewNode(T data, Integer key) {
        return new Node<>(data, key);
    }



    // Method to insert a node with both data and key
    public void insert(T data, Integer key) {
        Node<T> newNode = new Node<>(data, key);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    // Recursive method to insert a node at a given index
    public void insertAtIndex(int index, T data, Integer key) {
        // Start the recursion from the head
        head = insertAtIndexRecursive(head, index, data, key, 0);
    }

    // Helper recursive function
    private Node<T> insertAtIndexRecursive(Node<T> current, int index, T data, Integer key, int currentIndex) {
        // If we have reached the index where the new node should be inserted
        if (currentIndex == index) {
            Node<T> newNode = new Node<>(data, key);
            newNode.next = current;
            size++;
            return newNode;
        }

        // If we reached the end of the list and haven't inserted yet, return current node (index out of bounds)
        if (current == null) {
            System.out.println("Index out of bounds.");
            return current;
        }

        // Recursively call the function to move through the list
        current.next = insertAtIndexRecursive(current.next, index, data, key, currentIndex + 1);

        return current;
    }


    // Method to node a node  with a specified key
    public void deleteNodeByKey(int key) {

        // Check if the list is empty
        if (head == null) {
            System.out.println("The list is empty. Cannot insert node.");
            return;
        }

        // Check if the node with the specified key exists
        Node<T> current = isNodeExists( key);

        if (current == null) {
            System.out.println("Node with key " +  key + " not found. Cannot insert node.");
            return;
        }


        // decrease the size of the list
        size--;
    }



    // Method to insert a node after a node with a specified key
    public void insertNodeAtKey(int keyToFind, Node<T> newNode) {
        // Check if the node with the specified key exists
        Node<T> current = isNodeExists(keyToFind);

        if (current == null) {
            System.out.println("Node with key " + keyToFind + " not found. Cannot insert node.");
            return;
        }

        // Check if the new node already exists in the list
        if (isNodeExists(newNode.key) != null) {
            System.out.println("Node with key " + newNode.key + " already exists. Cannot insert duplicate keys.");
            return;
        }

        // Insert the new node after the current node
        newNode.next = current.next;
        current.next = newNode;

        // If the new node is inserted at the end, update the tail pointer
        if (current == tail) {
            tail = newNode;
        }

        // Increase the size of the list
        size++;
    }


    // Method to insert a node before a node with a specified key
    public void insertNodeBeforeKey(int keyToFind, Node<T> newNode) {
        // Check if the node with the specified key exists
        Node<T> current = isNodeExists(keyToFind);

        if (current == null) {
            System.out.println("Node with key " + keyToFind + " not found. Cannot insert node.");
            return;
        }

        // Check if the new node already exists in the list
        if (isNodeExists(newNode.key) != null) {
            System.out.println("Node with key " + newNode.key + " already exists. Cannot insert duplicate keys.");
            return;
        }

        // If the current node is the head, prepend the new node
        if (current == head) {
            prepend(newNode);
            return;
        }

        // Traverse the list to find the node before the node with the specified key
        Node<T> prev = head;
        while (prev.next != current) {
            prev = prev.next;
        }

        // Insert the new node before the current node
        prev.next = newNode;
        newNode.next = current;

        // If the current node is the tail, update the tail pointer
        if (current == tail) {
            tail = newNode;
        }

        // Increase the size of the list
        size++;
    }


    // Method to insert a node after a node with a specified key
    public void insertNodeAfterKey(int keyToFind, Node<T> newNode) {
        // Check if the node with the specified key exists
        Node<T> current = isNodeExists(keyToFind);

        if (current == null) {
            System.out.println("Node with key " + keyToFind + " not found. Cannot insert node.");
            return;
        }

        // Check if the new node already exists in the list
        if (isNodeExists(newNode.key) != null) {
            System.out.println("Node with key " + newNode.key + " already exists. Cannot insert duplicate keys.");
            return;
        }

        // Insert the new node after the current node
        newNode.next = current.next;
        current.next = newNode;

        // If the new node is inserted at the end, update the tail pointer
        if (current == tail) {
            tail = newNode;
        }

        // Increase the size of the list
        size++;
    }



    // Method to insert a node at a specified position with both data and key
    public void insertNodeAtPosition(int position, Node<T> newNode) {
        // If the position is invalid, do nothing
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position. Cannot insert node.");
            return;
        }

        // Check if the node with the given key already exists
        if (isNodeExists(newNode.key) != null) {
            System.out.println("Node with key " + newNode.key + " already exists. Cannot append duplicate keys.");
            return;
        }

        // If the list is empty or position is 1, prepend the node instead
        if (head == null || position == 1) {
            prepend(newNode);
            return;
        }

        // If position is at the end of the list, append the node instead
        if (position == size + 1) {
            append(newNode);
            return;
        }

        // Traverse the list to find the node before the specified position
        Node<T> current = head;
        int i = 1;
        while (i < position - 1) {
            current = current.next;
            i++;
        }

        // Insert the new node after the current node
        newNode.next = current.next;
        current.next = newNode;

        // Increase the size of the list
        size++;
    }



    // Method to insert a node after a specified position with both data and key
    public void insertNodeAfterPosition(int position, Node<T> newNode) {

        // Check if the list is empty
        if (head == null) {
            System.out.println("The list is empty. Cannot insert node.");
            return;
        }

        // If the position is invalid, do nothing
        if (position < 0 || position > size) {
            System.out.println("Invalid position. Cannot insert node.");
            return;
        }



        // Check if the node with the given key already exists
        if (isNodeExists(newNode.key) != null) {
            System.out.println("Node with key " + newNode.key + " already exists. Cannot append duplicate keys.");
            return;
        }


        // Traverse the list to find the node at the specified position
        Node<T> current = head;
        int i =1;
        while(i < position)
        {
            current = current.next;
            i++;
        }

        // Insert the new node after the current node
        newNode.next = current.next;
        current.next = newNode;

        System.out.println(size==position);

        // If the new node is inserted at the end, update the tail pointer
        if (current == tail) {
            tail = newNode;
        }

        // Increase the size of the list
        size++;
    }


    // Method to insert a node before a specified position with both data and key
    public void insertNodeBeforePosition(int position, Node<T> newNode) {


        // If the position is invalid, do nothing
        if (position <= 1 || position > size) {
            System.out.println("Invalid position. Cannot insert node.");
            return;
        }


        // Check if the node with the given key already exists
        if (isNodeExists(newNode.key) != null) {
            System.out.println("Node with key " + newNode.key + " already exists. Cannot append duplicate keys.");
            return;
        }

        // If the list is empty or position is 1, prepend the node instead
        if (head == null) {
            prepend(newNode);
            return;
        }

        // Traverse the list to find the node at the specified position
        Node<T> current = head;
        int i = 1;
        while (i < position - 1) {
            current = current.next;
            i++;
        }

        // Insert the new node before the current node
        newNode.next = current.next;
        current.next = newNode;

        // If the new node is inserted at the end, update the tail pointer
        if (current == tail) {
            tail = newNode;
        }

        // Increase the size of the list
        size++;
    }


    // Method to prepend a node with both data and key
    public void prepend(Node<T> newNode) {
        // Check if the node with the given key already exists
        if (isNodeExists(newNode.key) != null) {
            System.out.println("Node with key " + newNode.key + " already exists. Cannot append duplicate keys.");
            return;
        }

        // If the list is empty, set both head and tail to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // Otherwise, update the next reference of the new node to point to the current head,
            // and then set the head to the new node
            newNode.next = head;
            head = newNode;
        }
        size++;
    }


    // Method to append a node with both data and key
    public void append(Node<T> newNode) {
        // If the list is empty, prepend the node instead
        if (head == null) {
            prepend(newNode);
            return;
        }

        // Check if the node with the given key already exists
        if (isNodeExists(newNode.key) != null) {
            System.out.println("Node with key " + newNode.key + " already exists. Cannot append duplicate keys.");
            return;
        }

        // Append the new node after the last node
        tail.next = newNode;

        // Update the tail pointer to point to the new node
        tail = newNode;

        // Increase the size of the list
        size++;
    }


    // Method to reverse the linked list
    public void reverse() {
        Node<T> previous = null;
        Node<T> current = head;
        Node<T> nextNode = null;

        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        while (current != null) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        head = previous;

        System.out.println("Linked list has been reversed.");

    }



    // Method to recursively reverse the linked list
    public void reverseUsingRecursionHelper(Node<T> current) {
        if (head == null) {
            System.out.println("linked list is empty");
            return;
        }

        if (current.next == null) { // Exit condition: last node reached
            // Update the tail to point to the original head before reversing
            tail = head;

            // Update the head to point to the last node (which will become the new head)
            head = current;
            return;
        }

        reverseUsingRecursionHelper(current.next); // Recursive call to move to next node  first
        // until you reach last node


        // link changes
        Node<T> q = current.next;  // Reverse process
        q.next = current;                // Reverse process
        current.next = null;            // Reverse process

    }
    // Wrapper method to start printing from the head of the list
    public void reverseRecursively() {
        Node<T> current = head;
        reverseUsingRecursionHelper(current);
    }


    // Method to traverse and print the linked list
    public void traverse() {
        Node<T> current = head;

        if (current == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print("[" + current.data + ":" + current.key + "]");

            if (current.next != null) {
                System.out.print(" -> ");
            } else {
                System.out.print(" -> TAIL -> NULL");
            }

            current = current.next;
        }
        System.out.println();
    }

    public  void  reverseTraverse(){
        Node<T> current = head;

        if (current == null) {
            System.out.println("The list is empty.");
            return;
        }
    }


    // Method to get the size of the linked list
    public  Node<T> isNodeExists(Integer key) {
        Node<T> current = head;

        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }

        // If the loop finishes without finding a matching node, return null
        return null;
    }

    // Method to get the size of the linked list
    public int getSize() {
        return size;
    }


    // Method to recursively print the linked list in normal order
    public void printUsingRecursion(Node<T> current) {
        if (current == null) {  // Base case: if the node is null, we have reached the end of the list
            System.out.print(" -> TAIL -> NULL");
            return;
        }

        // Print the current node's data
        System.out.print(" -> [" + current.data + ":" + current.key + "]");

        // Recursive call to move to the next node
        printUsingRecursion(current.next);
    }

    // Wrapper method to start printing from the head of the list
    public void printRecursively() {
        Node<T> current = head;
        System.out.print("HEAD");
        printUsingRecursion(current);  // Start the recursion from the head node
        System.out.println();  // Print a newline at the end
    }


    // Method to recursively print the linked list in reverse order
    public void reversePrintUsingRecursion(Node<T> current) {
        if (current == null) {  // Base case: if the node is null, we've reached the end of the list
            return;
        }

        // Recursive call to go to the next node
        reversePrintUsingRecursion(current.next);

        // Print the current node data after the recursive call returns (prints in reverse order)
        System.out.print(" -> [" + current.data + ":" + current.key + "]");
    }

    // Wrapper method to start reverse printing from the head of the list
    public void reversePrint() {
        Node<T> current = head;
        System.out.print("HEAD -> ");
        reversePrintUsingRecursion(current);  // Start the recursion from the head node
        System.out.print(" -> TAIL -> NULL");  // After recursion, print the tail part
        System.out.println();  // Print a newline at the end
    }
}

public class LinkedList {
    public static void main(String[] args) {

        // Create a new singly linked list
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        SinglyLinkedList.Node<Integer> node1 = list.createNewNode(1, 1);
        SinglyLinkedList.Node<Integer> node2 = list.createNewNode(2, 2);
        SinglyLinkedList.Node<Integer> node3 = list.createNewNode(3, 3);
        SinglyLinkedList.Node<Integer> node4 = list.createNewNode(4, 4);
        SinglyLinkedList.Node<Integer> node5 = list.createNewNode(5, 5);
        SinglyLinkedList.Node<Integer> node6 = list.createNewNode(6, 6);
        SinglyLinkedList.Node<Integer> node7 = list.createNewNode(7, 7);
        SinglyLinkedList.Node<Integer> node8 = list.createNewNode(8, 8);
        SinglyLinkedList.Node<Integer> node9 = list.createNewNode(9, 9);
        SinglyLinkedList.Node<Integer> node10 = list.createNewNode(10, 10);
        SinglyLinkedList.Node<Integer> node11 = list.createNewNode(11, 11);
        SinglyLinkedList.Node<Integer> node12= list.createNewNode(12, 12);
        SinglyLinkedList.Node<Integer> node13= list.createNewNode(13, 13);
        SinglyLinkedList.Node<Integer> node14= list.createNewNode(14, 14);
        SinglyLinkedList.Node<Integer> node15 = list.createNewNode(15, 15);

        // Add elements to the list
        list.prepend(node3);
        list.append(node4);
        list.append(node5);
        list.append(node6);
        System.out.println("Initial Size of the List: " + list.getSize());

        // Display the original linked list
        System.out.println("\nOriginal Linked List:");
        list.traverse();

        // Try appending 4 again
        list.append(node4);

        // Display the linked list after attempting to append a duplicate key
        System.out.println("\nAfter Attempting to Append 4 Again:");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());

        // Prepend elements 2 and 1
        list.prepend(node2);
        list.prepend(node1);

        // Display the linked list after prepending 2 and 1
        System.out.println("\nAfter Prepending 2 and 1:");
        list.traverse();

        // Display the linked list after reversing
        list.reverse();
        System.out.println("\nAfter Reversing the Linked List:");
        list.traverse();

        // Reverse the list again
        list.reverse();
        System.out.println("\nAfter Reversing Again:");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());

        // Insert node after position
        list.insertNodeAfterPosition(6, node7);
        list.insertNodeAfterPosition(3, node8);
        System.out.println("\nAfter Inserting Nodes After Positions:");
        list.traverse();

        // Try to insert after an invalid position
        System.out.println("\nTry Inserting After an Invalid Position:");
        list.insertNodeAfterPosition(10, node7);
        System.out.println("Current Size of the List: " + list.getSize());

        // Try to insert after an invalid key
        System.out.println("\nTry Inserting After an Invalid Key:");
        list.insertNodeAfterKey(69, node7);

        // Try to insert a node with a key that already exists
        System.out.println("\nTry Inserting a Node with a Duplicate Key:");
        list.insertNodeAfterKey(6, node7);

        // Insert node after key
        list.insertNodeAfterKey(2, node9);
        System.out.println("\nAfter Inserting Node After Key:");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());



        // Console output and comments for deleteNodeByKey method
        System.out.println("\nDeleting Nodes by Key:");
        System.out.println("Before Deletion:");
        list.traverse();
        list.deleteNodeByKey(4);
        System.out.println("After Deleting Node with Key 4:");
        list.traverse();
        list.deleteNodeByKey(1);
        System.out.println("After Deleting Node with Key 1:");
        list.traverse();



        // Insert node before position
        list.insertNodeBeforePosition(5, node10);
        System.out.println("\nAfter Inserting Node Before Position 5:");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());

        // Insert node before position 1
        list.insertNodeBeforePosition(1, node10);
        System.out.println("\nAfter Inserting Node Before Position 1:");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());

        // Try to insert before an invalid position
        System.out.println("\nTry Inserting Before an Invalid Position:");
        list.insertNodeBeforePosition(15, node10);
        System.out.println("Current Size of the List: " + list.getSize());


        // Insert node at position
        list.insertNodeAtPosition(5, node11);
        System.out.println("\nAfter Inserting Node at Position 5:");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());

        // Insert node at position 1
        list.insertNodeAtPosition(1, node12);
        System.out.println("\nAfter Inserting Node at Position 1:");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());

        // Try to insert at an invalid position
        System.out.println("\nTry Inserting at an Invalid Position:");
        list.insertNodeAtPosition(15, node10);
        System.out.println("Current Size of the List: " + list.getSize());



        // Insert node before key
        list.insertNodeBeforeKey(5, node13);
        System.out.println("\nAfter Inserting Node Before Key 5:");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());

        // Insert node before key that doesn't exist
        list.insertNodeBeforeKey(15, node13);
        System.out.println("\nAfter Inserting Node Before Key 15 (which doesn't exist):");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());

        // Try to insert a node with a key that already exists
        list.insertNodeBeforeKey(6, node13);
        System.out.println("\nTry Inserting Node Before Key 6 (which already exists):");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());



        // Insert node at key
        list.insertNodeAtKey(2, node14);
        System.out.println("\nAfter Inserting Node At Key 2:");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());

        // Insert node at key that doesn't exist
        list.insertNodeAtKey(15, node14);
        System.out.println("\nAfter Inserting Node At Key 15 (which doesn't exist):");
        list.traverse();
        System.out.println("Current Size of the List: " + list.getSize());

        // Try to insert a node with a key that already exists
        list.insertNodeAtKey(6, node14);
        System.out.println("\nTry Inserting Node At Key 6 (which already exists):");
        list.traverse();
        list.reversePrint();
        list.printRecursively();
        System.out.println("Current Size of the List: " + list.getSize());

        list.insertAtIndex(2, 33, 100);
        list.traverse();
        list.reverseRecursively();
        System.out.println("After recursive reverse");
        list.traverse();
    }
}