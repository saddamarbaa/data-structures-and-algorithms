import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {
    private static class Node {
        int data;
        Node left;
        Node right;


        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        Node(int value) {
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public Node createNode(int data) {
        return new Node(data);
    }


    public Node createNode() {
        return new Node();
    }

    public  boolean isEmpty(){
        return root == null;
    }
    public void clearTree() {
        root = null;
        System.out.println("Tree has been cleared.");
    }

    // Preorder traversal
    public void display() {
        displayHelper(root);
    }

    // Preorder traversal
    public void preorder() {
        preorderHelper(root);
    }

    private void displayHelper(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderHelper(node.left);
            preorderHelper(node.right);
        }
    }

    private void preorderHelper(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderHelper(node.left);
            preorderHelper(node.right);
        }
    }


    // Inorder traversal
    public void inorder() {
        inorderHelper(root);
    }

    private void inorderHelper(Node node) {
        if (node != null) {
            inorderHelper(node.left);
            System.out.print(node.data + " ");
            inorderHelper(node.right);
        }
    }

    // Postorder traversal
    public void postorder() {
        postorderHelper(root);
    }

    private void postorderHelper(Node node) {
        if (node != null) {
            postorderHelper(node.left);
            postorderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Level order traversal (BFS)
    public void levelOrderTraversal() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) queue.add(tempNode.left);
            if (tempNode.right != null) queue.add(tempNode.right);
        }
    }

    // Level order second implementation
    public void levelOrderTraversalHelper(){
        int height = getHeight();
        for(int i = 0; i < height; i++){
            levelOrderTraversal(root, i);
        }
    }
    // Recursive Method for breadth first search
    public void levelOrderTraversal(Node node, int level){
        if(node == null){
            return;
        }
        if(level == 0){
            System.out.print(node.data + " ");
        }else{
            levelOrderTraversal(node.left, level-1);
            levelOrderTraversal(node.right, level-1);
        }
    }

    // Print tree structure
    public void printTree() {
        printTreeHelper(root, 0);
    }

    private void printTreeHelper(Node node, int level) {
        if (node != null) {
            printTreeHelper(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(node.data);
            printTreeHelper(node.left, level + 1);
        }
    }


    // Search for a node
    public boolean search(int value) {
        return searchHelper(root, value);
    }

    private boolean searchHelper(Node root, int value) {
        if (root == null) return false;
        if (root.data == value) return true;
        if (value < root.data) return searchHelper(root.left, value);
        else return searchHelper(root.right, value);
    }



    public Node searchIterative(int value) {
        if(root== null){
            return root;
        }

        Node temp = root;
        while (temp != null){
            if (temp.data == value){
                return  temp;
            }else if(value < temp.data){
                temp = temp.left;
            }else {
                temp = temp.right;
            }
        }
        return  null;
    }

    // Recursive method to insert a node
    public void insertRecursive(int value) {
        root = insertRecursiveHelper(root, value);
    }

    private Node insertRecursiveHelper(Node root, int value) {
        if (root == null) {
            root = createNode (value);
            return root;
        }
        if (value <= root.data) {
            root.left = insertRecursiveHelper(root.left, value);
        } else {
            root.right = insertRecursiveHelper(root.right, value);
        }
        return root;
    }

    // Add a node to the tree using recursion
    public void add(int data) {
        Node newNode = createNode(data);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        recursiveAddHelper(root, data);
        size++;  // Increment the size after adding a node
    }

    // Helper method to add nodes recursively
    public void recursiveAddHelper(Node temp, int data) {
        if (data <= temp.data) {
            if (temp.left == null) {
                temp.left = createNode(data);
            } else {
                recursiveAddHelper(temp.left, data);
            }
        } else {
            if (temp.right == null) {
                temp.right = createNode(data);
            } else {
                recursiveAddHelper(temp.right, data);  // Corrected this line
            }
        }
    }



    // Insert a new node with the given value iteratively
    public void insertIterative(int value) {

        // Create a new node with the value (without specifying the key)
        Node newNode = createNode(value);

        // If the tree is empty, the new node becomes the root
        if (root == null) {
            root = newNode;
            size++;  // Increment size for new node
            return;
        } else {
            Node parent = root;
            Node temp = root;

            // Traverse the tree to find the correct position
            while (temp != null) {
                parent = temp;

                if (value <= temp.data) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }

            // Attach the new node to the correct position (left or right)
            if (value <= parent.data) {
                parent.left = newNode;  // Add to left
            } else {
                parent.right = newNode;  // Add to right
            }

            size++;  // Increment size for new node
        }
    }



    // Get the height of the tree
    public int getHeight() {
        return getHeightHelper(root);
    }

    private int getHeightHelper(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(getHeightHelper(node.left), getHeightHelper(node.right));
    }


    // Get the maximum value using an iterative method
    public int getMaxIterative() {
        if (root == null) return Integer.MIN_VALUE;
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    // Get the maximum value using a recursive method
    public int getMaxRecursive() {
        return getMaxRecursiveHelper(root);
    }

    private int getMaxRecursiveHelper(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        if (node.right == null) return node.data;
        return getMaxRecursiveHelper(node.right);
    }

    // Get the minimum value using an iterative method
    public int getMinIterative() {
        if (root == null) return Integer.MAX_VALUE;
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    // Get the minimum value using a recursive method
    public int getMinRecursive() {
        return getMinRecursiveHelper(root);
    }

    private int getMinRecursiveHelper(Node node) {
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null) return node.data;
        return getMinRecursiveHelper(node.left);
    }


    // Method to delete a node
    public void delete(int value) {
        root = deleteHelper(root, value);
    }

    private Node deleteHelper(Node root, int value) {
        if (root == null) {
            return null;
        }

        // Recur down the tree
        if (value < root.data) {
            root.left = deleteHelper(root.left, value);
        } else if (value > root.data) {
            root.right = deleteHelper(root.right, value);
        } else {
            // Node to be deleted found

            // Case 1: No child (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            // Get inorder successor (smallest in the right subtree)
            root.data = getMinRecursiveHelper(root.right);
            // Delete the inorder successor
            root.right = deleteHelper(root.right, root.data);
        }

        return root;
    }


    // Inorder Successor
    public int getInorderSuccessor(int value) {
        Node current = searchNode(root, value);
        if (current == null) return Integer.MIN_VALUE;

        if (current.right != null) {
            return getMinRecursiveHelper(current.right);
        } else {
            Node successor = null;
            Node ancestor = root;
            while (ancestor != current) {
                if (value < ancestor.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return (successor != null) ? successor.data : Integer.MIN_VALUE;
        }
    }

    // Inorder Predecessor
    public int getInorderPredecessor(int value) {
        Node current = searchNode(root, value);
        if (current == null) return Integer.MAX_VALUE;

        if (current.left != null) {
            return getMaxRecursiveHelper(current.left);
        } else {
            Node predecessor = null;
            Node ancestor = root;
            while (ancestor != current) {
                if (value > ancestor.data) {
                    predecessor = ancestor;
                    ancestor = ancestor.right;
                } else {
                    ancestor = ancestor.left;
                }
            }
            return (predecessor != null) ? predecessor.data : Integer.MAX_VALUE;
        }
    }

    private Node searchNode(Node root, int value) {
        if (root == null || root.data == value) return root;
        if (value < root.data) return searchNode(root.left, value);
        return searchNode(root.right, value);
    }






    // Check if the tree is balanced
    public boolean isBalanced() {
        return isBalancedHelper(root) != -1;
    }

    private int isBalancedHelper(Node node) {
        if (node == null) return 0;

        int leftHeight = isBalancedHelper(node.left);
        int rightHeight = isBalancedHelper(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count total number of nodes
    public int countNodes() {
        return countNodesHelper(root);
    }

    private int countNodesHelper(Node node) {
        if (node == null) return 0;
        return 1 + countNodesHelper(node.left) + countNodesHelper(node.right);
    }

    // Check if the tree is a valid BST
    public boolean isBST() {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTHelper(Node node, int min, int max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return isBSTHelper(node.left, min, node.data) && isBSTHelper(node.right, node.data, max);
    }



    // Override toString method to print tree details
//    @Override
//    public String toString() {
//        return "BinarySearchTree [root=" + (root != null ? root.data : "null") + ", size=" + size + "]";
//    }

    // Override toString method to print tree details
    @Override
    public String toString() {
        if (root == null) {
            return "Tree is empty";
        } else {
            return getTreeString(root, "", true);
        }
    }



    private String getTreeString(Node node, String indent, boolean isLeft) {
        StringBuilder treeString = new StringBuilder();
        if (node != null) {
            treeString.append(indent).append(isLeft ? "└── " : "┌── ").append(node.data).append("\n");
            treeString.append(getTreeString(node.left, indent + (isLeft ? "    " : "│   "), true));
            treeString.append(getTreeString(node.right, indent + (isLeft ? "    " : "│   "), false));
        }
        return treeString.toString();
    }



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            BinarySearchTree bst = new BinarySearchTree();
            int option, element;

            do {
                System.out.println("\nBinary Search Tree Implementation:");
                System.out.println("1: Insert node (Recursive)");
                System.out.println("2: Insert node (Iterative)");
                System.out.println("3: Search for a value");
                System.out.println("4: Get the height of the tree");
                System.out.println("5: Get the maximum value (Iterative & Recursive)");
                System.out.println("6: Get the minimum value (Iterative & Recursive)");
                System.out.println("7: Display Traversals (Preorder, Inorder, Postorder, Level Order)");
                System.out.println("8: Delete a node");
                System.out.println("9: Find the inorder successor of a node");
                System.out.println("10: Find the inorder predecessor of a node");
                System.out.println("11: Check if the tree is balanced");
                System.out.println("12: Count total nodes");
                System.out.println("13: Check if the tree is a valid BST");
                System.out.println("14: Clear the tree");
                System.out.println("0: Quit");
                System.out.print("Enter your choice: ");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter value to insert (Recursive): ");
                        element = sc.nextInt();
                        bst.insertRecursive(element);
                        break;

                    case 2:
                        System.out.print("Enter value to insert (Iterative): ");
                        element = sc.nextInt();
                        bst.insertIterative(element);
                        break;

                    case 3:
                        System.out.print("Enter value to search: ");
                        element = sc.nextInt();
                        boolean found = bst.search(element);
                        System.out.println("Value " + element + (found ? " found in the tree." : " not found in the tree."));
                        break;

                    case 4:
                        System.out.println("Height of the tree: " + bst.getHeight());
                        break;

                    case 5:
                        // Maximum value (Iterative and Recursive in one place)
                        System.out.println("Maximum value (Iterative): " + bst.getMaxIterative());
                        System.out.println("Maximum value (Recursive): " + bst.getMaxRecursive());
                        break;

                    case 6:
                        // Minimum value (Iterative and Recursive in one place)
                        System.out.println("Minimum value (Iterative): " + bst.getMinIterative());
                        System.out.println("Minimum value (Recursive): " + bst.getMinRecursive());
                        break;

                    case 7:
                        // Display tree structure and all traversals
                        System.out.println("Displaying tree structure and traversal orders:");
                        bst.printTree();
                        System.out.print("Preorder traversal: ");
                        bst.preorder();
                        System.out.println();

                        System.out.print("Inorder traversal: ");
                        bst.inorder();
                        System.out.println();

                        System.out.print("Postorder traversal: ");
                        bst.postorder();
                        System.out.println();

                        System.out.print("Level order traversal: ");
                        bst.levelOrderTraversal();
                        System.out.println();
                        break;

                    case 8:
                        System.out.print("Enter value to delete: ");
                        element = sc.nextInt();
                        bst.delete(element);
                        System.out.println("Value " + element + " deleted (if it existed).");
                        break;

                    case 9:
                        System.out.print("Enter value to find inorder successor: ");
                        element = sc.nextInt();
                        int successor = bst.getInorderSuccessor(element);
                        System.out.println("Inorder successor of " + element + " is " + (successor != Integer.MIN_VALUE ? successor : "not found."));
                        break;

                    case 10:
                        System.out.print("Enter value to find inorder predecessor: ");
                        element = sc.nextInt();
                        int predecessor = bst.getInorderPredecessor(element);
                        System.out.println("Inorder predecessor of " + element + " is " + (predecessor != Integer.MAX_VALUE ? predecessor : "not found."));
                        break;

                    case 11:
                        boolean balanced = bst.isBalanced();
                        System.out.println("The tree is " + (balanced ? "balanced." : "not balanced."));
                        break;

                    case 12:
                        System.out.println("Total number of nodes: " + bst.countNodes());
                        break;

                    case 13:
                        boolean validBST = bst.isBST();
                        System.out.println("The tree is " + (validBST ? "a valid BST." : "not a valid BST."));
                        break;

                    case 14:
                        bst.clearTree();
                        System.out.println("Tree cleared.");
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid option! Please try again.");
                        break;
                }
            } while (option != 0);
            sc.close();
    }
}
