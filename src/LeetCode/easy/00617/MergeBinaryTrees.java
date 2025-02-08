/**
 617. Merge Two Binary Trees

 Easy

 You are given two binary trees root1 and root2.

 Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

 Return the merged tree.

 Note: The merging process must start from the root nodes of both trees.

 Example 1:

 Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 Output: [3,4,5,5,4,null,7]
 Example 2:

 Input: root1 = [1], root2 = [1,2]
 Output: [2,2]


 Constraints:

 The number of nodes in both trees is in the range [0, 2000].
 -104 <= Node.val <= 104
 */

import java.util.LinkedList;
import java.util.Queue;

public class MergeBinaryTrees {

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
    // Solution 1: Recursive approach to merge two trees
    // ==================================================
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Base case: if both nodes are null, return null
        if (root1 == null && root2 == null) {
            return null;
        }

        // Get the values of the nodes, defaulting to 0 if the node is null
        int val1 = (root1 != null) ? root1.val : 0;
        int val2 = (root2 != null) ? root2.val : 0;

        // Create a new node with the sum of the two values
        TreeNode mergedNode = new TreeNode(val1 + val2);

        // Recursively merge the left and right children
        mergedNode.left = mergeTrees(
                (root1 != null) ? root1.left : null,
                (root2 != null) ? root2.left : null
        );
        mergedNode.right = mergeTrees(
                (root1 != null) ? root1.right : null,
                (root2 != null) ? root2.right : null
        );

        return mergedNode;
    }

    // ==================================================
    // Solution 2: Iterative approach to merge two trees using BFS
    // ==================================================
    public TreeNode mergeTreesIterative(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{root1, root2});

        while (!queue.isEmpty()) {
            TreeNode[] current = queue.poll();
            TreeNode t1 = current[0];
            TreeNode t2 = current[1];

            // Merge t2 into t1
            t1.val += t2.val;

            // If both left children exist, push them into the queue
            if (t1.left != null && t2.left != null) {
                queue.offer(new TreeNode[]{t1.left, t2.left});
            } else if (t1.left == null) {
                t1.left = t2.left; // If t1's left child is null, use t2's
            }

            // If both right children exist, push them into the queue
            if (t1.right != null && t2.right != null) {
                queue.offer(new TreeNode[]{t1.right, t2.right});
            } else if (t1.right == null) {
                t1.right = t2.right; // If t1's right child is null, use t2's
            }
        }

        return root1;
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        MergeBinaryTrees solution = new MergeBinaryTrees();

        // Test case 1:
        // Tree 1:      1
        //             / \
        //            3   2
        //           /
        //          5
        // Tree 2:      2
        //             / \
        //            1   3
        //             \   \
        //              4   7
        TreeNode root1 = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), null),
                new TreeNode(2));
        TreeNode root2 = new TreeNode(2,
                new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7)));

        TreeNode result1 = solution.mergeTrees(root1, root2);
        System.out.println("Test case 1 (Recursive): " + treeToString(result1)); // Output: [3,4,5,5,4,null,7]

        // Test case 2:
        TreeNode result2 = solution.mergeTreesIterative(root1, root2);
        System.out.println("Test case 2 (Iterative): " + treeToString(result2)); // Output: [3,4,5,5,4,null,7]
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


