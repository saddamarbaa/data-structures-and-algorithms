/***
 129. Sum Root to Leaf Numbers

 Medium

 You are given the root of a binary tree containing digits from 0 to 9 only.

 Each root-to-leaf path in the tree represents a number.

 For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

 A leaf node is a node with no children.

 Example 1:

 Input: root = [1,2,3]
 Output: 25
 Explanation:
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.
 Therefore, sum = 12 + 13 = 25.
 Example 2:


 Input: root = [4,9,0,5,1]
 Output: 1026
 Explanation:
 The root-to-leaf path 4->9->5 represents the number 495.
 The root-to-leaf path 4->9->1 represents the number 491.
 The root-to-leaf path 4->0 represents the number 40.
 Therefore, sum = 495 + 491 + 40 = 1026.


 Constraints:

 The number of nodes in the tree is in the range [1, 1000].
 0 <= Node.val <= 9
 The depth of the tree will not exceed 10.
 */

public class SumRootToLeafNumbers {

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

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        // Base case: if the node is null, return 0
        if (node == null) {
            return 0;
        }

        // Update the current sum by appending the current node's value
        currentSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the current sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recursively calculate the sum for the left and right subtrees
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers solution = new SumRootToLeafNumbers();

        // Test case 1:
        // Tree structure:
        //     1
        //    / \
        //   2   3
        // Expected output: 25 (12 + 13)
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        System.out.println("Test case 1: " + solution.sumNumbers(root1)); // Output: 25

        // Test case 2:
        // Tree structure:
        //     4
        //    / \
        //   9   0
        //  / \
        // 5   1
        // Expected output: 1026 (495 + 491 + 40)
        TreeNode root2 = new TreeNode(4,
                new TreeNode(9,
                        new TreeNode(5),
                        new TreeNode(1)),
                new TreeNode(0));
        System.out.println("Test case 2: " + solution.sumNumbers(root2)); // Output: 1026

        // Test case 3:
        // Tree structure:
        //   1
        //  /
        // 2
        // Expected output: 12 (12)
        TreeNode root3 = new TreeNode(1,
                new TreeNode(2),
                null);
        System.out.println("Test case 3: " + solution.sumNumbers(root3)); // Output: 12

        // Test case 4:
        // Tree structure:
        //   0
        //  / \
        // 1   2
        // Expected output: 3 (01 + 02)
        TreeNode root4 = new TreeNode(0,
                new TreeNode(1),
                new TreeNode(2));
        System.out.println("Test case 4: " + solution.sumNumbers(root4)); // Output: 3
    }
}