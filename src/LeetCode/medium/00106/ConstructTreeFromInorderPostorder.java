import java.util.HashMap;
import java.util.LinkedList;

/**
 106. Construct Binary Tree from Inorder and Postorder Traversal

 Medium

 Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 Example 1:
 Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 Output: [3,9,20,null,null,15,7]

 Example 2:
 Input: inorder = [-1], postorder = [-1]
 Output: [-1]

 Constraints:
 - 1 <= inorder.length <= 3000
 - postorder.length == inorder.length
 - -3000 <= inorder[i], postorder[i] <= 3000
 - inorder and postorder consist of unique values.
 - Each value of postorder also appears in inorder.
 - inorder is guaranteed to be the inorder traversal of the tree.
 - postorder is guaranteed to be the postorder traversal of the tree.
 */

public class ConstructTreeFromInorderPostorder {

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
    // Solution: Construct Tree using Inorder and Postorder Traversal
    // ==================================================
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Map to store the index of values in inorder array for quick lookup
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Call the recursive helper function
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1, inorderMap);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd, HashMap<Integer, Integer> inorderMap) {
        // Base case: if there are no elements to construct the tree
        if (inStart > inEnd) return null;

        // The last element of postorder is the root of the current subtree
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // Get the index of the root in the inorder array
        int rootIndex = inorderMap.get(rootVal);

        // Calculate the number of elements in the right subtree
        int rightSubtreeSize = inEnd - rootIndex;

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(inorder, postorder, inStart, rootIndex - 1, postEnd - rightSubtreeSize - 1, inorderMap);
        root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inEnd, postEnd - 1, inorderMap);

        return root;
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        ConstructTreeFromInorderPostorder solution = new ConstructTreeFromInorderPostorder();

        // Test case: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = solution.buildTree(inorder, postorder);
        System.out.println("Tree: " + treeToString(root)); // Output: [3,9,20,null,null,15,7]

        // Test case: inorder = [-1], postorder = [-1]
        int[] inorder2 = {-1};
        int[] postorder2 = {-1};
        TreeNode root2 = solution.buildTree(inorder2, postorder2);
        System.out.println("Tree: " + treeToString(root2)); // Output: [-1]
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
