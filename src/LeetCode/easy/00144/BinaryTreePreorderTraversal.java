import java.util.List;
import java.util.ArrayList;

/**
 * 144. Binary Tree Preorder Traversal
 *
 * Easy
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
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
 * Solution to Binary Tree Preorder Traversal using both Recursive and Iterative approaches.
 */
public class BinaryTreePreorderTraversal {

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
     * Recursive solution to preorder traversal.
     *
     * @param root the root of the binary tree
     * @return a list containing the preorder traversal of the tree nodes
     */
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    // Helper method for recursive preorder traversal
    private void helper(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);        // Visit the root (current node)
            helper(node.left, result);   // Traverse left subtree
            helper(node.right, result);  // Traverse right subtree
        }
    }

    /**
     * Iterative solution to preorder traversal without using recursion.
     *
     * @param root the root of the binary tree
     * @return a list containing the preorder traversal of the tree nodes
     */
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> temp = new ArrayList<>();
        TreeNode current = root;

        // Perform preorder traversal (root -> left -> right)
        while (current != null || !temp.isEmpty()) {
            if (current != null) {
                result.add(current.val);  // Visit root
                if (current.right != null) {
                    temp.add(current.right);  // Save right nodes for later
                }
                current = current.left;  // Move to left
            } else {
                current = temp.remove(temp.size() - 1); // Get the last saved right node
            }
        }

        return result;
    }

    // Main method to test both solutions
    public static void main(String[] args) {
        // Test case 1
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);

        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();

        // Recursive Preorder Traversal
        System.out.println("Recursive Preorder Traversal of Tree 1: " + solution.preorderTraversalRecursive(root1));

        // Iterative Preorder Traversal
        System.out.println("Iterative Preorder Traversal of Tree 1: " + solution.preorderTraversalIterative(root1));

        // Test case 2 (Empty tree)
        TreeNode root2 = null;
        System.out.println("Recursive Preorder Traversal of Tree 2: " + solution.preorderTraversalRecursive(root2));
        System.out.println("Iterative Preorder Traversal of Tree 2: " + solution.preorderTraversalIterative(root2));
    }
}
