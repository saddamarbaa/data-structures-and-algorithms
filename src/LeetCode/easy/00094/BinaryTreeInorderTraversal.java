import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * Easy
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Explanation:
 * The tree is:     1
 *                    \
 *                     2
 *                    /
 *                   3
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 100].
 * - -100 <= Node.val <= 100
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

/**
 * Solution to Binary Tree Inorder Traversal using both Recursive and Iterative approaches.
 */
public class BinaryTreeInorderTraversal {

    // TreeNode class definition
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

    /**
     * Recursive solution to inorder traversal.
     *
     * @param root the root of the binary tree
     * @return a list containing the inorder traversal of the tree nodes
     */
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    // Helper method for recursive inorder traversal
    private void helper(TreeNode node, List<Integer> result) {
        if (node != null) {
            helper(node.left, result);   // Traverse left subtree
            result.add(node.val);        // Visit the root (current node)
            helper(node.right, result);  // Traverse right subtree
        }
    }

    /**
     * Iterative solution to inorder traversal without using recursion.
     *
     * @param root the root of the binary tree
     * @return a list containing the inorder traversal of the tree nodes
     */
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse the left subtree
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Visit the node
            current = stack.pop();
            result.add(current.val);

            // Traverse the right subtree
            current = current.right;
        }

        return result;
    }

    // Main method to test both solutions
    public static void main(String[] args) {
        // Test case 1
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);

        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();

        // Recursive Inorder Traversal
        System.out.println("Recursive Inorder Traversal of Tree 1: " + solution.inorderTraversalRecursive(root1));

        // Iterative Inorder Traversal
        System.out.println("Iterative Inorder Traversal of Tree 1: " + solution.inorderTraversalIterative(root1));

        // Test case 2 (Empty tree)
        TreeNode root2 = null;
        System.out.println("Recursive Inorder Traversal of Tree 2: " + solution.inorderTraversalRecursive(root2));
        System.out.println("Iterative Inorder Traversal of Tree 2: " + solution.inorderTraversalIterative(root2));
    }
}
