/***
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Medium
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * Example:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Constraints:
 * - All node values are unique.
 * - p and q are different and both exist in the BST.
 */

public class LowestCommonAncestorBST {

    // ==================================================
    // Solution 1: Recursive Approach
    // ==================================================
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If both p and q are smaller than root, LCA lies in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If both p and q are greater than root, LCA lies in the right subtree
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // If one is in the left and the other is in the right, root is the LCA
        else {
            return root;
        }
    }

    // ==================================================
    // Solution 2: Iterative Approach
    // ==================================================
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // If both p and q are smaller than root, move to the left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // If both p and q are greater than root, move to the right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // If one is in the left and the other is in the right, root is the LCA
            else {
                break;
            }
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
        LowestCommonAncestorBST solution = new LowestCommonAncestorBST();

        // Test case 1:
        // Construct the BST: [6,2,8,0,4,7,9,null,null,3,5]
        TreeNode root = solution.new TreeNode(6);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(8);
        root.left.left = solution.new TreeNode(0);
        root.left.right = solution.new TreeNode(4);
        root.right.left = solution.new TreeNode(7);
        root.right.right = solution.new TreeNode(9);
        root.left.right.left = solution.new TreeNode(3);
        root.left.right.right = solution.new TreeNode(5);

        TreeNode p = root.left;  // Node with value 2
        TreeNode q = root.right; // Node with value 8
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Test case 1: " + lca.val); // Output: 6

        // Test case 2:
        p = root.left.right.left;  // Node with value 3
        q = root.left.right.right; // Node with value 5
        lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Test case 2: " + lca.val); // Output: 4
    }
}