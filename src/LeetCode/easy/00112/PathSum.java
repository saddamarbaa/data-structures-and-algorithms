/**
 112. Path Sum

 Easy

 Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

 A leaf is a node with no children.

 Example 1:

 Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 Output: true
 Explanation: The root-to-leaf path with the target sum is shown.
 Example 2:

 Input: root = [1,2,3], targetSum = 5
 Output: false
 Explanation: There are two root-to-leaf paths in the tree:
 (1 --> 2): The sum is 3.
 (1 --> 3): The sum is 4.
 There is no root-to-leaf path with sum = 5.
 Example 3:

 Input: root = [], targetSum = 0
 Output: false
 Explanation: Since the tree is empty, there are no root-to-leaf paths.


 Constraints:

 The number of nodes in the tree is in the range [0, 5000].
 -1000 <= Node.val <= 1000
 -1000 <= targetSum <= 1000
 */
public class PathSum {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if the root is null, there is no path
        if (root == null) {
            return false;
        }

        // Check if it's a leaf node and if the remaining targetSum equals the node's value
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        // Recursively check the left and right subtrees with the updated targetSum
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        PathSum solution = new PathSum();

        // Test case 1:
        // Tree structure:
        //       5
        //      / \
        //     4   8
        //    /   / \
        //   11  13  4
        //  /  \      \
        // 7    2      1
        // targetSum = 22
        // Expected output: true (Path: 5 -> 4 -> 11 -> 2)
        TreeNode root1 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                null,
                                new TreeNode(1))));
        int targetSum1 = 22;
        System.out.println("Test case 1: " + solution.hasPathSum(root1, targetSum1)); // Output: true

        // Test case 2:
        // Tree structure:
        //   1
        //  / \
        // 2   3
        // targetSum = 5
        // Expected output: false (No path sums to 5)
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        int targetSum2 = 5;
        System.out.println("Test case 2: " + solution.hasPathSum(root2, targetSum2)); // Output: false

        // Test case 3:
        // Tree structure:
        //   1
        //  /
        // 2
        // targetSum = 1
        // Expected output: false (No path sums to 1)
        TreeNode root3 = new TreeNode(1,
                new TreeNode(2),
                null);
        int targetSum3 = 1;
        System.out.println("Test case 3: " + solution.hasPathSum(root3, targetSum3)); // Output: false

        // Test case 4:
        // Tree structure:
        //   1
        // targetSum = 1
        // Expected output: true (Path: 1)
        TreeNode root4 = new TreeNode(1);
        int targetSum4 = 1;
        System.out.println("Test case 4: " + solution.hasPathSum(root4, targetSum4)); // Output: true
    }
}