/***
 450. Delete Node in a BST

 Medium

 Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

 Assume a BST is defined as follows:
 - The left subtree of a node contains only nodes with keys less than the node's key.
 - The right subtree of a node contains only nodes with keys greater than the node's key.
 - Both the left and right subtrees must also be binary search trees.

 Example 1:
 Input: root = [5,3,6,2,4,null,7], key = 3
 Output: [5,4,6,2,null,null,7]
 Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

 Example 2:
 Input: root = [5,3,6,2,4,null,7], key = 0
 Output: [5,3,6,2,4,null,7]
 Explanation: The tree does not contain a node with value 0.

 Example 3:
 Input: root = [], key = 0
 Output: []

 Constraints:
 - The number of nodes in the tree is in the range [0, 10^4].
 - -10^5 <= Node.val <= 10^5
 - Each node has a unique value.
 - root is a valid binary search tree.
 - -10^5 <= key <= 10^5

 Follow up: Could you solve it with time complexity O(height of tree)?
 */

import java.util.*;

public class DeleteNodeInBST {

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

    // ==================================================
    // Solution: Recursive approach to delete a node in BST
    // ==================================================
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null; // Base case: tree is empty or key not found
        }

        // Search for the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key); // Recur on the left subtree
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // Recur on the right subtree
        } else {
            // Node to delete found

            // Case 1: Node has no children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node has only one child
            if (root.left == null) {
                return root.right; // Replace with right child
            }
            if (root.right == null) {
                return root.left; // Replace with left child
            }

            // Case 3: Node has two children
            // Find the in-order successor (smallest in the right subtree)
            TreeNode successor = findMin(root.right);
            root.val = successor.val; // Replace node's value with successor's value
            root.right = deleteNode(root.right, successor.val); // Delete the successor
        }

        return root; // Return the updated tree
    }

    // Helper method to find the smallest node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        DeleteNodeInBST solution = new DeleteNodeInBST();

        // Test case 1:
        // Tree structure:
        //     5
        //    / \
        //   3   6
        //  / \   \
        // 2   4   7
        // Key to delete: 3
        // Expected output: [5,4,6,2,null,null,7] or [5,2,6,null,4,null,7]
        TreeNode root1 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4)),
                new TreeNode(6,
                        null,
                        new TreeNode(7)));
        TreeNode result1 = solution.deleteNode(root1, 3);
        System.out.println("Test case 1: " + treeToString(result1));

        // Test case 2:
        // Tree structure:
        //     5
        //    / \
        //   3   6
        //  / \   \
        // 2   4   7
        // Key to delete: 0 (not in the tree)
        // Expected output: [5,3,6,2,4,null,7]
        TreeNode root2 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4)),
                new TreeNode(6,
                        null,
                        new TreeNode(7)));
        TreeNode result2 = solution.deleteNode(root2, 0);
        System.out.println("Test case 2: " + treeToString(result2));

        // Test case 3:
        // Tree structure: []
        // Key to delete: 0
        // Expected output: []
        TreeNode root3 = null;
        TreeNode result3 = solution.deleteNode(root3, 0);
        System.out.println("Test case 3: " + treeToString(result3));
    }

    // Helper method to convert a tree to a string (for testing purposes)
    private static String treeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return "[" + sb.substring(0, sb.length() - 1) + "]";
    }
}