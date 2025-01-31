/***
 230. Kth Smallest Element in a BST
 Medium
 Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElementInBST {

    // TreeNode class representing a node in the binary search tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Iterative in-order traversal using a stack to find the kth smallest element
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;

        // In-order traversal (left-root-right) using stack
        while (current != null || !stack.isEmpty()) {
            // Go to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit the node
            current = stack.pop();
            count++;

            // If this is the kth visited node, return its value
            if (count == k) {
                return current.val;
            }

            // Move to the right subtree
            current = current.right;
        }

        return -1; // This should never happen if the input is valid and k is within bounds
    }

    // Recursive in-order traversal by storing the node values in an ArrayList
    public int kthSmallest2(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list); // Populate list with in-order traversal

        // Check if the list contains at least k elements
        if (list.size() >= k) {
            return list.get(k - 1); // Return the kth element (1-indexed)
        }

        return -1; // Return -1 in case of an invalid k value
    }

    // Helper method for recursive in-order traversal
    public void helper(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        helper(node.left, list);

        // Visit the current node
        list.add(node.val);

        // Traverse the right subtree
        helper(node.right, list);
    }

    public static void main(String[] args) {
        KthSmallestElementInBST solution = new KthSmallestElementInBST();

        // Test case 1:
        TreeNode root1 = new TreeNode(3,
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(4));
        System.out.println("Test case 1: " + solution.kthSmallest(root1, 1)); // Output: 1

        // Test case 2:
        TreeNode root2 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                new TreeNode(6));
        System.out.println("Test case 2: " + solution.kthSmallest(root2, 3)); // Output: 3
    }
}
