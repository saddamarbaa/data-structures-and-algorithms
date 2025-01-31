/***
 98. Validate Binary Search Tree

 Medium
 Given the root of a binary tree, determine if it is a valid binary search tree (BST).

 A valid BST is defined as follows:

 The left
 subtree
 of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */

import java.util.Stack;

public class ValidateBinarySearchTree {

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

    /*** Solution 1: Recursive Range Validation
     *
     * Algorithm Steps:
     * 1. Start with the root node and initialize the valid range as (-∞, +∞).
     * 2. For each node, check if its value is within the valid range (min, max).
     * 3. If not, return false.
     * 4. Recursively validate the left subtree with the range (min, current node's value).
     * 5. Recursively validate the right subtree with the range (current node's value, max).
     * 6. If all nodes satisfy the BST property, return true.
     *
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     *   - We visit each node once.
     *
     * Space Complexity: O(H), where H is the height of the tree.
     *   - The recursion stack can grow up to the height of the tree.
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    /*** Solution 2: Inorder Traversal (Iterative)
     *
     * Algorithm Steps:
     * 1. Perform an inorder traversal of the tree using a stack.
     * 2. Keep track of the previously visited node's value.
     * 3. During traversal, ensure that the current node's value is greater than the previous node's value.
     * 4. If not, return false.
     * 5. If the traversal completes without violations, return true.
     *
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     *   - We visit each node once.
     *
     * Space Complexity: O(H), where H is the height of the tree.
     *   - The stack can grow up to the height of the tree.
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Process the current node
            current = stack.pop();
            if (prev != null && current.val <= prev.val) {
                return false;
            }
            prev = current;
            // Move to the right subtree
            current = current.right;
        }
        return true;
    }

    /*** Solution 3: Inorder Traversal (Recursive)
     *
     * Algorithm Steps:
     * 1. Perform an inorder traversal of the tree recursively.
     * 2. Keep track of the previously visited node's value.
     * 3. During traversal, ensure that the current node's value is greater than the previous node's value.
     * 4. If not, return false.
     * 5. If the traversal completes without violations, return true.
     *
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     *   - We visit each node once.
     *
     * Space Complexity: O(H), where H is the height of the tree.
     *   - The recursion stack can grow up to the height of the tree.
     */
    private TreeNode prev;

    public boolean isValidBST3(TreeNode root) {
        prev = null;
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode node) {
        if (node == null) return true;
        // Traverse the left subtree
        if (!inorderTraversal(node.left)) return false;
        // Check the current node
        if (prev != null && node.val <= prev.val) return false;
        prev = node;
        // Traverse the right subtree
        return inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        // Test case 1:
        // Tree structure:
        //     2
        //    / \
        //   1   3
        // Expected: true
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Test case 1 (Solution 1): " + solution.isValidBST(root1)); // Output: true
        System.out.println("Test case 1 (Solution 2): " + solution.isValidBST2(root1)); // Output: true
        System.out.println("Test case 1 (Solution 3): " + solution.isValidBST3(root1)); // Output: true

        // Test case 2:
        // Tree structure:
        //     5
        //    / \
        //   1   4
        //      / \
        //     3   6
        // Expected: false (4 is greater than 5 in the right subtree)
        TreeNode root2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("Test case 2 (Solution 1): " + solution.isValidBST(root2)); // Output: false
        System.out.println("Test case 2 (Solution 2): " + solution.isValidBST2(root2)); // Output: false
        System.out.println("Test case 2 (Solution 3): " + solution.isValidBST3(root2)); // Output: false
    }
}