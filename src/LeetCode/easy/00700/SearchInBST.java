import java.util.LinkedList;
import java.util.Queue;

/***
 700. Search in a Binary Search Tree

 Easy

 You are given the root of a binary search tree (BST) and an integer val.

 You need to find the node in the BST that the node's value equals val and return the subtree rooted at that node. If such a node does not exist, return null.

 Example 1:
 Input: root = [4,2,7,1,3], val = 2
 Output: [2,1,3]

 Example 2:
 Input: root = [4,2,7,1,3], val = 5
 Output: []

 Constraints:
 - The number of nodes in the tree is in the range [1, 5000].
 - 1 <= Node.val <= 10^7
 - root is a valid binary search tree.
 - 1 <= val <= 10^7
 */

public class SearchInBST {

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
    // Solution 1: Recursive approach
    // ==================================================
    public TreeNode searchBST(TreeNode root, int val) {
        // Base case: if the tree is empty or the value is found
        if (root == null || root.val == val) {
            return root;
        }

        // If the value is less than the root's value, search in the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // If the value is greater than the root's value, search in the right subtree
        return searchBST(root.right, val);
    }

    // ==================================================
    // Solution 2: Iterative approach
    // ==================================================
    public TreeNode searchBSTIterative(TreeNode root, int val) {
        // Traverse the tree until the node is found or the tree is exhausted
        while (root != null && root.val != val) {
            if (val < root.val) {
                root = root.left; // Move to the left subtree
            } else {
                root = root.right; // Move to the right subtree
            }
        }
        return root; // Return the node or null if not found
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        SearchInBST solution = new SearchInBST();

        // Test case 1:
        // Tree structure:
        //      4
        //     / \
        //    2   7
        //   / \
        //  1   3
        // Search for value: 2
        // Expected output: [2,1,3]
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7));
        TreeNode result1 = solution.searchBST(root1, 2);
        System.out.println("Test case 1 (Recursive): " + treeToString(result1)); // Output: [2,1,3]
        TreeNode result1Iterative = solution.searchBSTIterative(root1, 2);
        System.out.println("Test case 1 (Iterative): " + treeToString(result1Iterative)); // Output: [2,1,3]

        // Test case 2:
        // Tree structure:
        //      4
        //     / \
        //    2   7
        //   / \
        //  1   3
        // Search for value: 5
        // Expected output: []
        TreeNode root2 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7));
        TreeNode result2 = solution.searchBST(root2, 5);
        System.out.println("Test case 2 (Recursive): " + treeToString(result2)); // Output: []
        TreeNode result2Iterative = solution.searchBSTIterative(root2, 5);
        System.out.println("Test case 2 (Iterative): " + treeToString(result2Iterative)); // Output: []

        // Test case 3:
        // Tree structure: []
        // Search for value: 1
        // Expected output: []
        TreeNode root3 = null;
        TreeNode result3 = solution.searchBST(root3, 1);
        System.out.println("Test case 3 (Recursive): " + treeToString(result3)); // Output: []
        TreeNode result3Iterative = solution.searchBSTIterative(root3, 1);
        System.out.println("Test case 3 (Iterative): " + treeToString(result3Iterative)); // Output: []
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