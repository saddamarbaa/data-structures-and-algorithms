/***
 116. Populating Next Right Pointers in Each Node
Solved
Medium
Topics
Companies
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example 1:


Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 212 - 1].
-1000 <= Node.val <= 1000
 

Follow-up:

You may only use constant extra space.
The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 
*/ 
 
 import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
    public static void main(String[] args) {
        // Test case 1: Creating a binary tree
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        // Test case 2: Solving the problem using both solutions
        connect(root1); // Solution 1 (Using BFS)
        connectOptimized(root1); // Solution 2 (Using constant space)

        // Printing the tree level by level (with next pointers)
        printTree(root1);
    }

    // Solution 1: Using BFS (Level order traversal with a queue)
    // Algorithm Steps:
    // 1. Perform a level-order traversal using a queue.
    // 2. For each level, connect the nodes to their next right node.
    // 3. At the end of the level, set the next pointer of the last node to null.
    // Time Complexity: O(n) where n is the number of nodes in the tree.
    // Space Complexity: O(n) due to the space used by the queue.
    public static void connect(Node root) {
        if (root == null) return;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                
                // Connect the current node to the next node at the same level
                if (i < levelSize - 1) {
                    current.next = queue.peek();
                }
                
                // Add left and right children to the queue
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
    }

    // Solution 2: Using constant space (without a queue)
    // Algorithm Steps:
    // 1. Use a pointer (next) to traverse nodes at each level.
    // 2. At each level, connect the left child to the right child, and the right child to the next left child.
    // 3. Move the pointer down to the next level.
    // Time Complexity: O(n) where n is the number of nodes in the tree.
    // Space Complexity: O(1) due to no extra space used.
    public static void connectOptimized(Node root) {
        if (root == null) return;

        Node levelStart = root;

        while (levelStart != null) {
            Node current = levelStart;
            levelStart = null;
            Node prev = null;

            while (current != null) {
                if (current.left != null) {
                    if (prev != null) {
                        prev.next = current.left;
                    } else {
                        levelStart = current.left;
                    }
                    prev = current.left;
                }

                if (current.right != null) {
                    if (prev != null) {
                        prev.next = current.right;
                    } else {
                        levelStart = current.right;
                    }
                    prev = current.right;
                }

                current = current.next;
            }
        }
    }

    // Helper method to print the tree level by level, including next pointers
    public static void printTree(Node root) {
        Node current = root;
        while (current != null) {
            Node levelNode = current;
            while (levelNode != null) {
                System.out.print(levelNode.val + " -> ");
                levelNode = levelNode.next;
            }
            System.out.println("null");
            current = current.left;
        }
    }

    // Definition for a binary tree node.
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.next = null;
        }
    }
}
