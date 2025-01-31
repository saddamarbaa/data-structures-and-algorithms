/***
 114. Flatten Binary Tree to Linked List

 Medium

 Given the root of a binary tree, flatten the tree into a "linked list":

 The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 The "linked list" should be in the same order as a pre-order traversal of the binary tree.

 Example 1:

 Input: root = [1,2,5,3,4,null,6]
 Output: [1,null,2,null,3,null,4,null,5,null,6]
 Example 2:

 Input: root = []
 Output: []
 Example 3:

 Input: root = [0]
 Output: [0]

 Constraints:

 The number of nodes in the tree is in the range [0, 2000].
 -100 <= Node.val <= 100

 */

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

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

    /*** Solution 1: Recursive Approach (Post-Order Traversal)
     *
     * Algorithm Steps:
     * 1. Perform a post-order traversal (right, left, root).
     * 2. During traversal, keep track of the previously visited node (`prev`).
     * 3. Set the current node's right pointer to `prev` and left pointer to `null`.
     * 4. Update `prev` to the current node.
     *
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     *   - We visit each node once.
     *
     * Space Complexity: O(H), where H is the height of the tree.
     *   - The recursion stack can grow up to the height of the tree.
     */
    private TreeNode prev;

    public void flatten(TreeNode root) {
        if (root == null) return;
        // Traverse right subtree first
        flatten(root.right);
        // Traverse left subtree
        flatten(root.left);
        // Set the current node's right pointer to `prev` and left pointer to `null`
        root.right = prev;
        root.left = null;
        // Update `prev` to the current node
        prev = root;
    }

    /*** Solution 2: Iterative Approach (Using a Stack)
     *
     * Algorithm Steps:
     * 1. Use a stack to perform a pre-order traversal.
     * 2. Keep track of the previously visited node (`prev`).
     * 3. For each node, set its right pointer to the next node in the stack and left pointer to `null`.
     * 4. Update `prev` to the current node.
     *
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     *   - We visit each node once.
     *
     * Space Complexity: O(H), where H is the height of the tree.
     *   - The stack can grow up to the height of the tree.
     */
    public void flatten2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            // Push right child first (so left is processed first)
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
            // Set the current node's right pointer to `prev` and left pointer to `null`
            if (prev != null) {
                prev.right = current;
                prev.left = null;
            }
            // Update `prev` to the current node
            prev = current;
        }
    }

    /*** Solution 3: Morris Traversal (Space-Optimized)
     *
     * Algorithm Steps:
     * 1. Use the Morris traversal technique to flatten the tree.
     * 2. For each node, find its rightmost node in the left subtree.
     * 3. Set the rightmost node's right pointer to the current node's right child.
     * 4. Move the current node's left subtree to the right.
     * 5. Repeat until all nodes are processed.
     *
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     *   - We visit each node once.
     *
     * Space Complexity: O(1).
     *   - No additional space is used apart from a few pointers.
     */
    public void flatten3(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node in the left subtree
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                // Set the rightmost node's right pointer to the current node's right child
                rightmost.right = current.right;
                // Move the left subtree to the right
                current.right = current.left;
                current.left = null;
            }
            // Move to the next node
            current = current.right;
        }
    }

    // Helper method to print the flattened tree (linked list)
    public void printFlattenedTree(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();

        // Test case 1:
        // Tree structure:
        //     1
        //    / \
        //   2   5
        //  / \   \
        // 3   4   6
        // Expected flattened tree: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));
        solution.flatten(root1);
        System.out.println("Test case 1 (Solution 1): ");
        solution.printFlattenedTree(root1);

        // Test case 2:
        // Tree structure:
        //     1
        //    / \
        //   2   3
        // Expected flattened tree: 1 -> 2 -> 3 -> null
        TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        solution.flatten2(root2);
        System.out.println("Test case 2 (Solution 2): ");
        solution.printFlattenedTree(root2);

        // Test case 3:
        // Tree structure:
        //     1
        //      \
        //       2
        //      /
        //     3
        // Expected flattened tree: 1 -> 2 -> 3 -> null
        TreeNode root3 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        solution.flatten3(root3);
        System.out.println("Test case 3 (Solution 3): ");
        solution.printFlattenedTree(root3);
    }
}