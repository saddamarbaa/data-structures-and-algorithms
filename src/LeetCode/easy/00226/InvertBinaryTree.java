/**
 226. Invert Binary Tree

Easy

Given the root of a binary tree, invert the tree, and return its root.

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        // Test case 1: Root = [4,2,7,1,3,6,9]
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        // Recursive Inversion
        TreeNode result1_recursive = invertTreeRecursive(root1);
        System.out.println("Test Case 1 - Recursive Inversion Root: " + result1_recursive.val);

        // Iterative Inversion
        TreeNode result1_iterative = invertTreeIterative(root1);
        System.out.println("Test Case 1 - Iterative Inversion Root: " + result1_iterative.val);

        // Test case 2: Root = [2,1,3]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        // Recursive Inversion
        TreeNode result2_recursive = invertTreeRecursive(root2);
        System.out.println("Test Case 2 - Recursive Inversion Root: " + result2_recursive.val);

        // Iterative Inversion
        TreeNode result2_iterative = invertTreeIterative(root2);
        System.out.println("Test Case 2 - Iterative Inversion Root: " + result2_iterative.val);

        // Test case 3: Root = []
        TreeNode root3 = null;
        TreeNode result3_recursive = invertTreeRecursive(root3);
        System.out.println("Test Case 3 - Recursive Inversion Root: " + (result3_recursive == null ? "null" : result3_recursive.val));
        TreeNode result3_iterative = invertTreeIterative(root3);
        System.out.println("Test Case 3 - Iterative Inversion Root: " + (result3_iterative == null ? "null" : result3_iterative.val));
    }

    /**
     * Recursive approach to invert a binary tree by swapping the left and right children.
     * 
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
     */
    public static TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) {
            return null; // Base case: return null if the tree is empty
        }

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);

        return root; // Return the root of the inverted tree
    }

    /**
     * Iterative approach to invert a binary tree using a queue for BFS (Breadth-First Search).
     * 
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(n), where n is the number of nodes (due to the queue used in BFS).
     */
    public static TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return null; // Return null if the tree is empty
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Initialize the queue for BFS
        queue.add(root); // Start with the root node

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll(); // Dequeue the front node

            // Swap the left and right children
            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;

            // Add the left and right children to the queue for further processing
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return root; // Return the root of the inverted tree
    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
}
