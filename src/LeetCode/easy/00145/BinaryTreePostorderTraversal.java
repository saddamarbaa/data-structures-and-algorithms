/**
 145. Binary Tree Postorder Traversal

 Easy

 Given the root of a binary tree, return the postorder traversal of its nodes' values.

 Example 1:

 Input: root = [1,null,2,3]

 Output: [3,2,1]

 Explanation:

 Example 2:

 Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

 Output: [4,6,7,5,2,9,8,3,1]

 Explanation:



 Example 3:

 Input: root = []

 Output: []

 Example 4:

 Input: root = [1]

 Output: [1]



 Constraints:

 The number of the nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100


 Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Solution to Binary Tree Postorder Traversal using both Recursive and Iterative approaches.
 */
public class BinaryTreePostorderTraversal {

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

    // Recursive solution to postorder traversal
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    // Helper method for recursive postorder traversal
    private void helper(TreeNode node, List<Integer> result) {
        if (node != null) {
            helper(node.left, result);   // Traverse left subtree
            helper(node.right, result);  // Traverse right subtree
            result.add(node.val);        // Visit the root (current node)
        }
    }

    // Iterative solution to postorder traversal without using recursion
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;  // Traverse left
            } else {
                TreeNode peekNode = stack.peek();
                // Traverse right if it exists and hasn't been visited yet
                if (peekNode.right != null && peekNode.right != prev) {
                    root = peekNode.right;
                } else {
                    // If no right child or right subtree is already visited
                    result.add(peekNode.val);
                    prev = stack.pop();
                }
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

        BinaryTreePostorderTraversal solution = new BinaryTreePostorderTraversal();

        // Recursive Postorder Traversal
        System.out.println("Recursive Postorder Traversal of Tree 1: " + solution.postorderTraversalRecursive(root1));

        // Iterative Postorder Traversal
        System.out.println("Iterative Postorder Traversal of Tree 1: " + solution.postorderTraversalIterative(root1));

        // Test case 2 (Empty tree)
        TreeNode root2 = null;
        System.out.println("Recursive Postorder Traversal of Tree 2: " + solution.postorderTraversalRecursive(root2));
        System.out.println("Iterative Postorder Traversal of Tree 2: " + solution.postorderTraversalIterative(root2));
    }
}
