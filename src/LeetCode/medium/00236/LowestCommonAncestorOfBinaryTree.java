/**
 236. Lowest Common Ancestor of a Binary Tree
 Medium

 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 Example 1:

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 Output: 3
 Explanation: The LCA of nodes 5 and 1 is 3.

 Example 2:

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 Output: 5
 Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

 Example 3:

 Input: root = [1,2], p = 1, q = 2
 Output: 1

 Constraints:

 The number of nodes in the tree is in the range [2, 105].
 -109 <= Node.val <= 109
 All Node.val are unique.
 p != q
 p and q will exist in the tree.
 */

public class LowestCommonAncestorOfBinaryTree {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null, or the root is one of p or q, return the root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, it means p and q are found in different subtrees
        if (left != null && right != null) {
            return root; // root is the LCA
        }

        // Otherwise, return the non-null node (either left or right)
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfBinaryTree solution = new LowestCommonAncestorOfBinaryTree();

        // Test case 1:
        // Tree structure:
        //       3
        //      / \
        //     5   1
        //    / \ / \
        //   6  2 0  8
        //     / \
        //    7   4
        // p = 5, q = 1
        // Expected LCA: 3
        TreeNode root1 = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)));
        TreeNode p1 = root1.left; // Node with value 5
        TreeNode q1 = root1.right; // Node with value 1
        System.out.println("Test case 1: " + solution.lowestCommonAncestor(root1, p1, q1).val); // Output: 3

        // Test case 2:
        // Tree structure:
        //       3
        //      / \
        //     5   1
        //    / \ / \
        //   6  2 0  8
        //     / \
        //    7   4
        // p = 5, q = 4
        // Expected LCA: 5
        TreeNode p2 = root1.left; // Node with value 5
        TreeNode q2 = root1.left.right.right; // Node with value 4
        System.out.println("Test case 2: " + solution.lowestCommonAncestor(root1, p2, q2).val); // Output: 5

        // Test case 3:
        // Tree structure:
        //    1
        //   /
        //  2
        // p = 1, q = 2
        // Expected LCA: 1
        TreeNode root3 = new TreeNode(1,
                new TreeNode(2),
                null);
        TreeNode p3 = root3; // Node with value 1
        TreeNode q3 = root3.left; // Node with value 2
        System.out.println("Test case 3: " + solution.lowestCommonAncestor(root3, p3, q3).val); // Output: 1
    }
}
