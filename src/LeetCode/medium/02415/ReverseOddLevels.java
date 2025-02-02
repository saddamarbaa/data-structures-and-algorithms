import java.util.LinkedList;
import java.util.Queue;

/***
 2415. Reverse Odd Levels of Binary Tree

 Medium

 Given the root of a binary tree, reverse the nodes at each odd level of the tree.

 For example, if the tree is:
 1
 /   \
 2     3
 / \   / \
 4   5 6   7

 After reversing the odd levels, it becomes:
 1
 /   \
 3     2
 / \   / \
 4   5 6   7

 Constraints:
 - The number of nodes in the tree is in the range [1, 10^4].
 - 0 <= Node.val <= 10^5
 */

public class ReverseOddLevels {

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
    // Solution 1: BFS approach to reverse odd levels
    // ==================================================
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode[] nodes = new TreeNode[size];

            // Store nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nodes[i] = node;

                // Add children to the queue for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Reverse the nodes at odd levels
            if (level % 2 == 1) {
                int left = 0, right = size - 1;
                while (left < right) {
                    int temp = nodes[left].val;
                    nodes[left].val = nodes[right].val;
                    nodes[right].val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }

    // ==================================================
    // Solution 2: DFS approach to reverse odd levels
    // ==================================================
    public TreeNode reverseOddLevels2(TreeNode root) {
        dfs(root.left, root.right, 1); // Start DFS from level 1 (odd level)
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) {
            return;
        }

        // Swap values at odd levels
        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        // Recursively process children
        dfs(left.left, right.right, level + 1); // Left subtree's left child and right subtree's right child
        dfs(left.right, right.left, level + 1); // Left subtree's right child and right subtree's left child
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        ReverseOddLevels solution = new ReverseOddLevels();

        // Test case 1:
        // Tree structure:
        //      1
        //     / \
        //    2   3
        //   / \ / \
        //  4  5 6  7
        // After reversing odd levels:
        //      1
        //     / \
        //    3   2
        //   / \ / \
        //  4  5 6  7
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        TreeNode result1 = solution.reverseOddLevels(root1);
        System.out.println("Test case 1: " + treeToString(result1)); // Output: [1,3,2,4,5,6,7]

        // Test case 2:
        // Tree structure:
        //      5
        //     / \
        //    3   8
        //   / \   \
        //  1   4   9
        // After reversing odd levels:
        //      5
        //     / \
        //    8   3
        //   / \   \
        //  1   4   9
        TreeNode root2 = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(1),
                        new TreeNode(4)),
                new TreeNode(8,
                        null,
                        new TreeNode(9)));
        TreeNode result2 = solution.reverseOddLevels(root2);
        System.out.println("Test case 2: " + treeToString(result2)); // Output: [5,8,3,1,4,9]

        // Test case 3:
        // Tree structure: [1]
        // After reversing odd levels: [1]
        TreeNode root3 = new TreeNode(1);
        TreeNode result3 = solution.reverseOddLevels(root3);
        System.out.println("Test case 3: " + treeToString(result3)); // Output: [1]
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