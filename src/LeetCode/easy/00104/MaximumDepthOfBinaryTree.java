import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * Easy
 *
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Explanation: The tree is:
 *      3
 *    /   \
 *   9    20
 *       /   \
 *     15     7
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 10^4].
 * - -100 <= Node.val <= 100
 *
 * Follow-up: Could you implement both recursive and iterative solutions?
 */

/**
 * Solution to Maximum Depth of Binary Tree using both Recursive and Iterative approaches.
 */
public class MaximumDepthOfBinaryTree {

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
     * Recursive solution to find the maximum depth of the binary tree.
     *
     * @param root the root of the binary tree
     * @return the maximum depth of the binary tree
     */
    public int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthRecursive(root.left);
        int rightDepth = maxDepthRecursive(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * Iterative solution to find the maximum depth of the binary tree using level-order traversal (BFS).
     *
     * @param root the root of the binary tree
     * @return the maximum depth of the binary tree
     */
    public int maxDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        // Perform level-order traversal and calculate depth
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // Main method to test both solutions
    public static void main(String[] args) {
        // Test case 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

        // Recursive Maximum Depth
        System.out.println("Recursive Maximum Depth of Tree 1: " + solution.maxDepthRecursive(root1));

        // Iterative Maximum Depth
        System.out.println("Iterative Maximum Depth of Tree 1: " + solution.maxDepthIterative(root1));

        // Test case 2 (Empty tree)
        TreeNode root2 = null;
        System.out.println("Recursive Maximum Depth of Tree 2: " + solution.maxDepthRecursive(root2));
        System.out.println("Iterative Maximum Depth of Tree 2: " + solution.maxDepthIterative(root2));
    }
}
