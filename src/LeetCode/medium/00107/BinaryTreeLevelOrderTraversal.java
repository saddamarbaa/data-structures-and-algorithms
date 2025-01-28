/**
 107. Binary Tree Level Order Traversal II

Medium

Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        // Test case 1: Root = [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        
        List<List<Integer>> result1 = levelOrder(root1);
        System.out.println("Test Case 1 - Level Order Traversal: " + result1);
        
        List<List<Integer>> result2 = levelOrderBottom(root1);
        System.out.println("Test Case 1 - Level Order Traversal II: " + result2);

        // Test case 2: Root = [1]
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> result3 = levelOrder(root2);
        System.out.println("Test Case 2 - Level Order Traversal: " + result3);
        
        List<List<Integer>> result4 = levelOrderBottom(root2);
        System.out.println("Test Case 2 - Level Order Traversal II: " + result4);

        // Test case 3: Root = []
        TreeNode root3 = null;
        List<List<Integer>> result5 = levelOrder(root3);
        System.out.println("Test Case 3 - Level Order Traversal: " + result5);
        
        List<List<Integer>> result6 = levelOrderBottom(root3);
        System.out.println("Test Case 3 - Level Order Traversal II: " + result6);
    }

    // Binary Tree Level Order Traversal (Top to Bottom)
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // To store level order traversal result
        if (root == null) {
            return result; // Return empty list if root is null
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Queue for BFS
        queue.add(root); // Start with the root node

        // Perform BFS level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Get the number of nodes at the current level
            List<Integer> level = new ArrayList<>(); // List to store values of the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Dequeue the front node
                level.add(currentNode.val); // Add its value to the current level list

                // Enqueue left and right children of the current node
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(level); // Add the current level to the result
        }

        return result;
    }

    // Binary Tree Level Order Traversal II (Bottom to Top)
    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return list; // Return empty list if root is null
        }

        queue.add(root);

        // Perform BFS level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Get the number of nodes at the current level
            List<Integer> tempList = new ArrayList<>(); // List to store values of the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // Dequeue the front node
                tempList.add(node.val); // Add its value to the current level list

                // Enqueue left and right children of the current node
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // Add the current level to the front of the list to get bottom-up order
            list.add(0, tempList);
        }

        return list;
    }


     /**
     * This method returns the bottom-up level order traversal of a binary tree.
     * The nodes are traversed level by level from left to right, but the order is reversed.
     * 
     * Algorithm Steps:
     * 1. Use a queue to perform a breadth-first search (BFS) starting from the root.
     * 2. At each level, dequeue all nodes of the current level and enqueue their children.
     * 3. Collect values of nodes level by level.
     * 4. Reverse the collected levels and return them as a list of lists.
     * 
     * Time Complexity: O(n) where n is the number of nodes in the tree.
     * Space Complexity: O(n) for the queue used in BFS.
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // To store level order traversal result
        if (root == null) {
            return result; // Return empty list if root is null
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Queue for BFS
        queue.add(root); // Start with the root node

        // Perform BFS level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Get the number of nodes at the current level
            List<Integer> level = new ArrayList<>(); // List to store values of the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Dequeue the front node
                level.add(currentNode.val); // Add its value to the current level list

                // Enqueue left and right children of the current node
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(level); // Add the current level to the result
        }

        // Reverse the result to get bottom-up level order
        List<List<Integer>> reversedResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            reversedResult.add(result.get(i));
        }

        return reversedResult;
    }
    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
}
