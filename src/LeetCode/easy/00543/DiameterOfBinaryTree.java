/***
 543. Diameter of Binary Tree
 Easy
 Given the root of a binary tree, return the length of the diameter of the tree.

 The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 The length of a path between two nodes is represented by the number of edges between them.

 Example 1:

 Input: root = [1,2,3,4,5]
 Output: 3
 Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 Example 2:

 Input: root = [1,2]
 Output: 1


 Constraints:

 The number of nodes in the tree is in the range [1, 104].
 -100 <= Node.val <= 100
 */

public class DiameterOfBinaryTree {

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

    private int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return -1; // Height of null is -1 (no edges)
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        // Update the maximum diameter found so far
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight + 2);
        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

        // Test case 1:
        // Tree structure:
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5
        // Expected diameter: 3 (path 4-2-1-3 or 5-2-1-3)
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));
        System.out.println("Test case 1: " + solution.diameterOfBinaryTree(root1)); // Output: 3

        // Test case 2:
        // Tree structure:
        //     1
        //      \
        //       2
        //      / \
        //     3   4
        //    /     \
        //   5       6
        //  /         \
        // 7           8
        // Expected diameter: 6 (path 7-5-3-2-4-6-8)
        TreeNode root2 = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(5,
                                        new TreeNode(7),
                                        null),
                                null),
                        new TreeNode(4,
                                null,
                                new TreeNode(6,
                                        null,
                                        new TreeNode(8)))));
        System.out.println("Test case 2: " + solution.diameterOfBinaryTree(root2)); // Output: 6
    }
}