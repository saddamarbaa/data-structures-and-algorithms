/**
 199. Binary Tree Right Side View
Solved
Medium
Topics
Companies
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:


Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:



Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []

 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        // Test case 1: Creating a binary tree
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.right = new Node(5);
        root1.right.right = new Node(4);

        // Test case 2: Solving the problem using BFS (Level order traversal)
        System.out.println("Right Side View: " + rightSideView(root1));
    }

    // Problem 199: Binary Tree Right Side View
    // Algorithm Steps:
    // 1. Perform a level-order traversal using a queue.
    // 2. For each level, keep track of the rightmost node.
    // 3. Add the rightmost node of each level to the result list.
    // 4. Return the result list containing the rightmost node at each level.
    // Time Complexity: O(n) where n is the number of nodes in the tree.
    // Space Complexity: O(n) due to the space used by the queue.
    public static LinkedList<Integer> rightSideView(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            // Process all nodes at the current level
            Node current = null;
            for (int i = 0; i < levelSize; i++) {
                current = queue.poll();
                
                // Add left and right children to the queue
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            
            // The last node processed at the current level is the rightmost node
            result.add(current.val);
        }
        
        return result;
    }

    // Helper method to print the tree (level by level) for debugging purposes
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
