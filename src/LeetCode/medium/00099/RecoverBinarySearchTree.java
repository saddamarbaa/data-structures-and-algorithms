import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/***
 99. Recover Binary Search Tree

 Medium

 You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

 Example 1:
 Input: root = [1,3,null,null,2]
 Output: [3,1,null,null,2]
 Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

 Example 2:
 Input: root = [3,1,4,null,null,2]
 Output: [2,1,4,null,null,3]
 Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.

 Constraints:
 - The number of nodes in the tree is in the range [2, 1000].
 - -2^31 <= Node.val <= 2^31 - 1
 */

public class RecoverBinarySearchTree {

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
    // Solution 1: Using Stack and In-order Traversal
    // ==================================================
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null, first = null, second = null;

        // In-order traversal to find the two swapped nodes
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            // If the previous node's value is greater than the current node's value,
            // we have found a misplaced node.
            if (prev != null && prev.val > current.val) {
                if (first == null) {
                    first = prev; // First misplaced node
                }
                second = current; // Second misplaced node
            }

            prev = current;
            current = current.right;
        }

        // Swap the values of the two misplaced nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    // ==================================================
    // Solution 2: Using ArrayList and In-order Traversal
    // ==================================================
    public void recoverTreeUsingArrayList(TreeNode root) {
        // Step 1: Perform in-order traversal and store nodes in an ArrayList
        ArrayList<TreeNode> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);

        // Step 2: Identify the two misplaced nodes
        TreeNode first = null, second = null;
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i).val > nodes.get(i + 1).val) {
                if (first == null) {
                    first = nodes.get(i);
                }
                second = nodes.get(i + 1);
            }
        }

        // Step 3: Swap the values of the two misplaced nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    // Helper method to perform in-order traversal and collect nodes in ArrayList
    private void inorderTraversal(TreeNode root, ArrayList<TreeNode> nodes) {
        if (root == null) return;
        inorderTraversal(root.left, nodes);
        nodes.add(root);
        inorderTraversal(root.right, nodes);
    }

    // ==================================================
    // Main method to test both solutions
    // ==================================================
    public static void main(String[] args) {
        RecoverBinarySearchTree solution = new RecoverBinarySearchTree();

        // Test case 1:
        TreeNode root1 = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        solution.recoverTreeUsingArrayList(root1); // Using ArrayList solution
        System.out.println("Test case 1 (ArrayList): " + treeToString(root1)); // Output: [3,1,null,null,2]

        // Test case 2:
        TreeNode root2 = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        solution.recoverTreeUsingArrayList(root2); // Using ArrayList solution
        System.out.println("Test case 2 (ArrayList): " + treeToString(root2)); // Output: [2,1,4,null,null,3]
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
