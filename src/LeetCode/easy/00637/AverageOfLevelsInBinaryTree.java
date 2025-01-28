/***
 637. Average of Levels in Binary Tree

Easy

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 
Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
Example 2:


Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 **/

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        // Test case 1: Root = [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        
        List<Double> result1 = averageOfLevels(root1);
        System.out.println("Test Case 1 - Average of Levels: " + result1);

        // Test case 2: Root = [1]
        TreeNode root2 = new TreeNode(1);
        List<Double> result2 = averageOfLevels(root2);
        System.out.println("Test Case 2 - Average of Levels: " + result2);

        // Test case 3: Root = []
        TreeNode root3 = null;
        List<Double> result3 = averageOfLevels(root3);
        System.out.println("Test Case 3 - Average of Levels: " + result3);
    }

    /**
     * This method returns the average value of the nodes at each level of a binary tree.
     * 
     * Algorithm Steps:
     * 1. Use a queue to perform a breadth-first search (BFS).
     * 2. At each level, sum up the values of the nodes and calculate the average.
     * 3. Add the average to the result list.
     * 
     * Time Complexity: O(n) where n is the number of nodes in the tree.
     * Space Complexity: O(n) for the queue used in BFS and the result list.
     */
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>(); // To store average of each level
        if (root == null) {
            return result; // Return empty list if root is null
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Queue for BFS
        queue.add(root); // Start with the root node

        // Perform BFS level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Get the number of nodes at the current level
            double sum = 0; // Variable to store the sum of the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Dequeue the front node
                sum += currentNode.val; // Add its value to the sum

                // Enqueue left and right children of the current node
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Calculate the average for the current level and add to the result
            result.add(sum / levelSize);
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
