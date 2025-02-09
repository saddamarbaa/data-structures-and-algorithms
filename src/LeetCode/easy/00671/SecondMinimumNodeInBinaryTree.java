/***
 671. Second Minimum Node In a Binary Tree

 Easy

 Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

 Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

 If no such second minimum value exists, output -1 instead.

 Example 1:

 Input: root = [2,2,5,null,null,5,7]
 Output: 5
 Explanation: The smallest value is 2, the second smallest value is 5.
 Example 2:

 Input: root = [2,2,2]
 Output: -1
 Explanation: The smallest value is 2, but there isn't any second smallest value.

 Constraints:

 The number of nodes in the tree is in the range [1, 25].
 1 <= Node.val <= 231 - 1
 root.val == min(root.left.val, root.right.val) for each internal node of the tree.
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SecondMinimumNodeInBinaryTree {

    // ==================================================
    // Solution 1: Iterative Approach (Using BFS)
    // ==================================================
    public int findSecondMinimumValueIterative(TreeNode root) {
        if (root == null) return -1;

        int min1 = root.val; // First minimum value
        long min2 = Long.MAX_VALUE; // Second minimum value (initialize to a large value)

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // If the current node's value is greater than min1 but less than min2, update min2
            if (node.val > min1 && node.val < min2) {
                min2 = node.val;
            }

            // Add children to the queue if they exist
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        // If min2 was not updated, return -1
        return min2 == Long.MAX_VALUE ? -1 : (int) min2;
    }

    // ==================================================
    // Solution 2: Recursive Approach (DFS)
    // ==================================================
    public int findSecondMinimumValueRecursive(TreeNode root) {
        if (root == null) return -1;

        // Use a helper function to traverse the tree and find the second minimum
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int min1) {
        if (node == null) return -1;

        // If the current node's value is greater than min1, return it as a candidate for min2
        if (node.val > min1) {
            return node.val;
        }

        // Otherwise, recurse on the left and right subtrees
        int left = dfs(node.left, min1);
        int right = dfs(node.right, min1);

        // If both left and right return valid values, return the smaller one
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }

    // ==================================================
    // Solution 3: Using HashSet to Collect Unique Values
    // ==================================================
    public int findSecondMinimumValueHashSet(TreeNode root) {
        if (root == null) return -1;

        // Use a HashSet to store all unique values in the tree
        Set<Integer> set = new HashSet<>();
        collectValues(root, set);

        // If there are less than 2 unique values, return -1
        if (set.size() < 2) return -1;

        // Convert the set to a list and sort it
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        // Return the second smallest value
        return list.get(1);
    }

    // Helper function to collect all unique values in the tree
    private void collectValues(TreeNode node, Set<Integer> set) {
        if (node == null) return;

        // Add the current node's value to the set
        set.add(node.val);

        // Recurse on the left and right subtrees
        collectValues(node.left, set);
        collectValues(node.right, set);
    }

    // ==================================================
    // Main method to test all solutions
    // ==================================================
    public static void main(String[] args) {
        SecondMinimumNodeInBinaryTree solution = new SecondMinimumNodeInBinaryTree();

        // Test case 1:
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println("Test case 1 (Iterative): " + solution.findSecondMinimumValueIterative(root1)); // Output: 5
        System.out.println("Test case 1 (Recursive): " + solution.findSecondMinimumValueRecursive(root1)); // Output: 5
        System.out.println("Test case 1 (HashSet): " + solution.findSecondMinimumValueHashSet(root1)); // Output: 5

        // Test case 2:
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println("Test case 2 (Iterative): " + solution.findSecondMinimumValueIterative(root2)); // Output: -1
        System.out.println("Test case 2 (Recursive): " + solution.findSecondMinimumValueRecursive(root2)); // Output: -1
        System.out.println("Test case 2 (HashSet): " + solution.findSecondMinimumValueHashSet(root2)); // Output: -1

        // Test case 3:
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(1);
        root3.right.left = new TreeNode(3);
        root3.right.right = new TreeNode(4);
        System.out.println("Test case 3 (Iterative): " + solution.findSecondMinimumValueIterative(root3)); // Output: 3
        System.out.println("Test case 3 (Recursive): " + solution.findSecondMinimumValueRecursive(root3)); // Output: 3
        System.out.println("Test case 3 (HashSet): " + solution.findSecondMinimumValueHashSet(root3)); // Output: 3
    }
}