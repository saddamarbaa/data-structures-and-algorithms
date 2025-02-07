import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AVLTree {
    private static class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int value) {
            this.data = value;
            this.height = 1; // New node is initially added at leaf
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public AVLTree() {
        this.root = null;
    }

    // Get height of a node
    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    // Get balance factor of a node
    private int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotate subtree rooted with y
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a node recursively
    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private Node insertHelper(Node node, int value) {
        // Perform the normal BST insertion
        if (node == null) return new Node(value);

        if (value < node.data) {
            node.left = insertHelper(node.left, value);
        } else if (value > node.data) {
            node.right = insertHelper(node.right, value);
        } else {
            // Duplicate values are not allowed in AVL Tree
            return node;
        }

        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node to check if it became unbalanced
        int balance = getBalance(node);

        // If unbalanced, perform rotations
        // Left Left Case
        if (balance > 1 && value < node.left.data) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && value > node.right.data) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && value > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the unchanged node pointer
        return node;
    }

    // Delete a node recursively
    public void delete(int value) {
        root = deleteHelper(root, value);
    }

    private Node deleteHelper(Node root, int value) {
        // Perform standard BST delete
        if (root == null) return root;

        if (value < root.data) {
            root.left = deleteHelper(root.left, value);
        } else if (value > root.data) {
            root.right = deleteHelper(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null || root.right == null) {
                Node temp = (root.left != null) ? root.left : root.right;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    // One child case
                    root = temp;
                }
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.data = temp.data;

                // Delete the inorder successor
                root.right = deleteHelper(root.right, temp.data);
            }
        }

        // If the tree had only one node, return
        if (root == null) return root;

        // Update height of the current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get the balance factor of this node to check if it became unbalanced
        int balance = getBalance(root);

        // If unbalanced, perform rotations
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Get the node with the smallest value in a subtree
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLTree avl = new AVLTree();
        int option, element;

        do {
            System.out.println("\nAVL Tree Implementation:");
            System.out.println("1: Insert node");
            System.out.println("2: Delete node");
            System.out.println("3: Search for a value");
            System.out.println("4: Display Inorder Traversal");
            System.out.println("5: Display Level Order Traversal");
            System.out.println("6: Print Tree Structure");
            System.out.println("0: Quit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    element = sc.nextInt();
                    avl.insert(element);
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    element = sc.nextInt();
                    avl.delete(element);
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    element = sc.nextInt();
                    boolean found = avl.search(element);
                    System.out.println("Value " + element + (found ? " found in the tree." : " not found in the tree."));
                    break;

                case 4:
                    System.out.print("Inorder traversal: ");
                    avl.inorder();
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Level order traversal: ");
                    avl.levelOrderTraversal();
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Tree structure:");
                    avl.printTree();
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