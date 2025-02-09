import java.util.HashMap;
import java.util.LinkedList;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Medium
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 * - 1 <= preorder.length <= 3000
 * - inorder.length == preorder.length
 * - -3000 <= preorder[i], inorder[i] <= 3000
 * - preorder and inorder consist of unique values.
 * - Each value of inorder also appears in preorder.
 * - preorder is guaranteed to be the preorder traversal of the tree.
 * - inorder is guaranteed to be the inorder traversal of the tree.
 */

public class ConstructBinaryTreeFromPreorderInorder {

    // Definition for a binary tree node.
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
    // Solution: Construct Binary Tree from Preorder and Inorder Traversal
    // ==================================================
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a HashMap to store inorder value -> index mappings for quick access
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Call the recursive helper function
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    // Helper method to recursively build the binary tree
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap) {
        // Base case: if there are no elements to construct the tree, return null
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // Get the root value from preorder traversal (preStart index)
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of the root in the inorder traversal
        int inRoot = inorderMap.get(rootValue);
        int numsLeft = inRoot - inStart;

        // Recursively build the left subtree and right subtree
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inorderMap);
        root.right = buildTreeHelper(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inorderMap);

        return root;
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderInorder solution = new ConstructBinaryTreeFromPreorderInorder();

        // Test case 1: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        System.out.println("Test Case 1: " + treeToString(root1)); // Output: [3,9,20,null,null,15,7]

        // Test case 2: preorder = [-1], inorder = [-1]
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode root2 = solution.buildTree(preorder2, inorder2);
        System.out.println("Test Case 2: " + treeToString(root2)); // Output: [-1]
    }

    // Helper method to convert a tree to a string (for testing purposes)
    private static String treeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
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
