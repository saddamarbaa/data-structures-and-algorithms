import java.util.LinkedList;
import java.util.Queue;

/***
 701. Insert into a Binary Search Tree

 Medium

 You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 Return the root node of the BST after the insertion. It is guaranteed that the new value does
 not exist in the original BST.

 Notice that there may exist multiple valid ways for the insertion, as long as the tree remains
 a BST after insertion. You can return any of them.

 Constraints:
 - The number of nodes in the tree will be in the range [0, 10^4].
 - -10^8 <= Node.val <= 10^8
 - All the values Node.val are unique.
 - -10^8 <= val <= 10^8
 - It's guaranteed that val does not exist in the original BST.
 */

public class InsertIntoBST {

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
    // Solution 1: Iterative approach to insert into BST
    // ==================================================
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                } else {
                    current = current.right;
                }
            }
        }

        return root;
    }

    // ==================================================
    // Solution 2: Recursive approach to insert into BST
    // ==================================================
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST2(root.left, val);
        } else {
            root.right = insertIntoBST2(root.right, val);
        }

        return root;
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        InsertIntoBST solution = new InsertIntoBST();

        // Test case 1:
        // Tree structure:
        //      4
        //     / \
        //    2   7
        //   / \
        //  1   3
        // Insert value: 5
        // Expected output:
        //      4
        //     / \
        //    2   7
        //   / \  /
        //  1   3 5
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7));
        TreeNode result1 = solution.insertIntoBST(root1, 5);
        System.out.println("Test case 1: " + treeToString(result1)); // Output: [4,2,7,1,3,5]

        // Test case 2:
        // Tree structure: []
        // Insert value: 5
        // Expected output: [5]
        TreeNode root2 = null;
        TreeNode result2 = solution.insertIntoBST(root2, 5);
        System.out.println("Test case 2: " + treeToString(result2)); // Output: [5]

        // Test case 3:
        // Tree structure:
        //      40
        //     /  \
        //    20   60
        //   / \   / \
        // 10  30 50 70
        // Insert value: 25
        // Expected output:
        //      40
        //     /  \
        //    20   60
        //   / \   / \
        // 10  30 50 70
        //     /
        //    25
        TreeNode root3 = new TreeNode(40,
                new TreeNode(20,
                        new TreeNode(10),
                        new TreeNode(30)),
                new TreeNode(60,
                        new TreeNode(50),
                        new TreeNode(70)));
        TreeNode result3 = solution.insertIntoBST(root3, 25);
        System.out.println("Test case 3: " + treeToString(result3)); // Output: [40,20,60,10,30,50,70,null,null,25]
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