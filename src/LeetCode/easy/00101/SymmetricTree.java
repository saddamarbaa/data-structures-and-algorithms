/***
 101. Symmetric Tree
Solved
Easy
Topics
Companies
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 **/
 
 import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        // Test case 1: Root = [1,2,2,3,4,4,3]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        // Recursive Symmetry Check
        boolean result1_recursive = isSymmetricRecursive(root1);
        System.out.println("Test Case 1 - Recursive Symmetry: " + result1_recursive);

        // Iterative Symmetry Check
        boolean result1_iterative = isSymmetricIterative(root1);
        System.out.println("Test Case 1 - Iterative Symmetry: " + result1_iterative);

        // Test case 2: Root = [1,2,2,null,3,null,3]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        // Recursive Symmetry Check
        boolean result2_recursive = isSymmetricRecursive(root2);
        System.out.println("Test Case 2 - Recursive Symmetry: " + result2_recursive);

        // Iterative Symmetry Check
        boolean result2_iterative = isSymmetricIterative(root2);
        System.out.println("Test Case 2 - Iterative Symmetry: " + result2_iterative);

        // Test case 3: Root = []
        TreeNode root3 = null;
        boolean result3_recursive = isSymmetricRecursive(root3);
        System.out.println("Test Case 3 - Recursive Symmetry: " + result3_recursive);
        boolean result3_iterative = isSymmetricIterative(root3);
        System.out.println("Test Case 3 - Iterative Symmetry: " + result3_iterative);
    }

    /**
     * Recursive approach to check if a binary tree is symmetric.
     * 
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
     */
    public static boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }
        return isMirror(root.left, root.right); // Check if left and right subtrees are mirrors
    }

    // Helper method to check if two trees are mirrors of each other
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true; // Both are null, symmetric
        }
        if (t1 == null || t2 == null) {
            return false; // One is null, not symmetric
        }
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    /**
     * Iterative approach to check if a binary tree is symmetric using a queue.
     * 
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(n), where n is the number of nodes in the queue.
     */
    public static boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is symmetric
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Queue to store nodes to compare
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            // If both are null, continue to next pair
            if (t1 == null && t2 == null) {
                continue;
            }
            // If one is null or values are not equal, tree is not symmetric
            if (t1 == null || t2 == null || t1.val != t2.val) {
                return false;
            }

            // Add children of t1 and t2 in mirror order
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }

        return true; // If all nodes matched, the tree is symmetric
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
