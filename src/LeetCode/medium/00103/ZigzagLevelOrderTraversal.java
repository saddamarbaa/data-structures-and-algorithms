/**
 103. Binary Tree Zigzag Level Order Traversal
Solved
Medium
Topics
Companies
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).


Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 */

import java.util.*;

public class ZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        // Test case 1: Root = [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        
        List<List<Integer>> result1_1 = zigzagLevelOrder1(root1);
        List<List<Integer>> result1_2 = zigzagLevelOrder2(root1);
        List<List<Integer>> result1_3 = zigzagLevelOrder3(root1);
        List<List<Integer>> result1_4 = zigzagLevelOrder4(root1);
        
        System.out.println("Test Case 1 - zigzagLevelOrder1: " + result1_1);
        System.out.println("Test Case 1 - zigzagLevelOrder2: " + result1_2);
        System.out.println("Test Case 1 - zigzagLevelOrder3: " + result1_3);
        System.out.println("Test Case 1 - zigzagLevelOrder4: " + result1_4);

        // Test case 2: Root = [1]
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> result2_1 = zigzagLevelOrder1(root2);
        List<List<Integer>> result2_2 = zigzagLevelOrder2(root2);
        List<List<Integer>> result2_3 = zigzagLevelOrder3(root2);
        List<List<Integer>> result2_4 = zigzagLevelOrder4(root2);
        
        System.out.println("Test Case 2 - zigzagLevelOrder1: " + result2_1);
        System.out.println("Test Case 2 - zigzagLevelOrder2: " + result2_2);
        System.out.println("Test Case 2 - zigzagLevelOrder3: " + result2_3);
        System.out.println("Test Case 2 - zigzagLevelOrder4: " + result2_4);

        // Test case 3: Root = []
        TreeNode root3 = null;
        List<List<Integer>> result3_1 = zigzagLevelOrder1(root3);
        List<List<Integer>> result3_2 = zigzagLevelOrder2(root3);
        List<List<Integer>> result3_3 = zigzagLevelOrder3(root3);
        List<List<Integer>> result3_4 = zigzagLevelOrder4(root3);
        
        System.out.println("Test Case 3 - zigzagLevelOrder1: " + result3_1);
        System.out.println("Test Case 3 - zigzagLevelOrder2: " + result3_2);
        System.out.println("Test Case 3 - zigzagLevelOrder3: " + result3_3);
        System.out.println("Test Case 3 - zigzagLevelOrder4: " + result3_4);
    }

    /**
     * Solution 1: Using BFS with Queue and reversing the list every alternate level.
     */
    public static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Reverse current level if we are going right to left
            if (!leftToRight) {
                Collections.reverse(currentLevel);
            }
            result.add(currentLevel);
            leftToRight = !leftToRight; // Toggle the direction
        }

        return result;
    }

    /**
     * Solution 2: Using BFS with a Deque to add elements either to the front or back based on the level direction.
     */
    public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    currentLevel.addLast(node.val);
                } else {
                    currentLevel.addFirst(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(new ArrayList<>(currentLevel));
            leftToRight = !leftToRight; // Toggle the direction
        }

        return result;
    }

    /**
     * Solution 3: Using DFS (Depth-First Search) with a recursive approach to traverse the tree level by level.
     */
    public static List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagDFS(root, 0, result);
        return result;
    }

    /**
     * Helper method for DFS traversal with alternating level order.
     */
    private static void zigzagDFS(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;

        if (level >= result.size()) {
            result.add(new LinkedList<>());
        }

        // Add nodes at odd levels to the front and even levels to the back
        if (level % 2 == 0) {
            result.get(level).add(node.val);
        } else {
            result.get(level).add(0, node.val);
        }

        zigzagDFS(node.left, level + 1, result);
        zigzagDFS(node.right, level + 1, result);
    }

    /**
     * Solution 4: Optimized BFS using Deque to handle zigzag pattern by pushing elements based on the direction in a single loop.
     */
    public static List<List<Integer>> zigzagLevelOrder4(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    TreeNode node = deque.pollFirst();
                    currentLevel.add(node.val);
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                } else {
                    TreeNode node = deque.pollLast();
                    currentLevel.add(node.val);
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
            }
            result.add(currentLevel);
            leftToRight = !leftToRight; // Toggle the direction
        }

        return result;
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
