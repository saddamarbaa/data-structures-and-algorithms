/***
 * 1008. Construct Binary Search Tree from Preorder Traversal
 *
 * Medium
 *
 * Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the BST and return its root.
 *
 * Example:
 * Input: preorder = [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 * Constraints:
 * 1 <= preorder.length <= 100
 * 1 <= preorder[i] <= 10^8
 * All values in preorder are unique.
 */

public class ConstructBSTFromPreorder {

    // ==================================================
    // Solution 1: Recursive Approach
    // ==================================================
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildBST(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // The first element in the current range is the root
        TreeNode root = new TreeNode(preorder[start]);

        // Find the index where the right subtree starts
        int splitIndex = start + 1;
        while (splitIndex <= end && preorder[splitIndex] < root.val) {
            splitIndex++;
        }

        // Recursively build the left and right subtrees
        root.left = buildBST(preorder, start + 1, splitIndex - 1);
        root.right = buildBST(preorder, splitIndex, end);

        return root;
    }

    // ==================================================
    // Solution 2: Iterative Approach using Stack
    // ==================================================
    public TreeNode bstFromPreorder2(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] < stack.peek().val) {
                // If the current value is less than the top of the stack, it's the left child
                stack.peek().left = node;
            } else {
                // Otherwise, pop elements from the stack until we find the correct parent
                TreeNode parent = stack.peek();
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }

        return root;
    }

    // ==================================================
    // TreeNode Definition
    // ==================================================
    public class TreeNode {
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
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        ConstructBSTFromPreorder solution = new ConstructBSTFromPreorder();

        // Test case 1:
        int[] preorder1 = {8, 5, 1, 7, 10, 12};
        TreeNode root1 = solution.bstFromPreorder(preorder1);
        printTree(root1); // Output: [8,5,10,1,7,null,12]

        // Test case 2:
        int[] preorder2 = {1, 3};
        TreeNode root2 = solution.bstFromPreorder(preorder2);
        printTree(root2); // Output: [1,null,3]
    }

    // Helper method to print the tree (in-order traversal)
    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}