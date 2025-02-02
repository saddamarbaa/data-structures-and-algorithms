/***
 501. Find Mode in Binary Search Tree

 Easy

 Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

 If the tree has more than one mode, return them in any order.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.


 Example 1:


 Input: root = [1,null,2,2]
 Output: [2]
 Example 2:

 Input: root = [0]
 Output: [0]


 Constraints:

 The number of nodes in the tree is in the range [1, 104].
 -105 <= Node.val <= 105


 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */

import java.util.*;

public class FindModeInBinarySearchTree {

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
    // Solution 1: In-order traversal (optimal for BST)
    // ==================================================
    private int currentVal;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        // Traverse the BST in-order to count occurrences of each value
        inOrderTraversal(root);

        // Convert the list of modes to an array
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(node.left);

        // Process the current node
        if (node.val == currentVal) {
            currentCount++;
        } else {
            currentVal = node.val;
            currentCount = 1;
        }

        // Update the mode(s) if necessary
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(currentVal);
        } else if (currentCount == maxCount) {
            modes.add(currentVal);
        }

        // Traverse the right subtree
        inOrderTraversal(node.right);
    }

    // ==================================================
    // Solution 2: Using a frequency map (works for any binary tree)
    // ==================================================
    private int count = 1;  // To track the maximum frequency

    public int[] findMode1(TreeNode root) {
        if (root == null) return new int[0];  // Edge case: empty tree

        // Step 1: Create a map to store frequencies of each value
        HashMap<Integer, Integer> map = new HashMap<>();
        helper(root, map);  // Populate the frequency map

        // Step 2: Find all values with the maximum frequency
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == count) {
                result.add(entry.getKey());
            }
        }

        // Step 3: Convert the result list to an array
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;  // Return the result array
    }

    public void helper(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) {
            return;
        }

        // Update the frequency of the current node's value in the map
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);

        // Get the updated frequency of the current node's value
        int currentFrequency = map.get(node.val);

        // Update the global count to track the maximum frequency
        count = Math.max(count, currentFrequency);

        // Recursively process the left and right subtrees
        helper(node.left, map);
        helper(node.right, map);
    }

    // ==================================================
    // Main method to test both solutions
    // ==================================================
    public static void main(String[] args) {
        FindModeInBinarySearchTree solution = new FindModeInBinarySearchTree();

        // Test case 1:
        // Tree structure:
        //     1
        //      \
        //       2
        //      /
        //     2
        // Expected output: [2] (2 occurs twice, 1 occurs once)
        TreeNode root1 = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(2),
                        null));
        System.out.println("Test case 1 (Solution 1): " + Arrays.toString(solution.findMode(root1))); // Output: [2]
        System.out.println("Test case 1 (Solution 2): " + Arrays.toString(solution.findMode1(root1))); // Output: [2]

        // Test case 2:
        // Tree structure:
        //     0
        // Expected output: [0] (0 occurs once)
        TreeNode root2 = new TreeNode(0);
        System.out.println("Test case 2 (Solution 1): " + Arrays.toString(solution.findMode(root2))); // Output: [0]
        System.out.println("Test case 2 (Solution 2): " + Arrays.toString(solution.findMode1(root2))); // Output: [0]

        // Test case 3:
        // Tree structure:
        //     1
        //    / \
        //   1   2
        //  / \   \
        // 1   2   2
        // Expected output: [1, 2] (1 and 2 both occur three times)
        TreeNode root3 = new TreeNode(1,
                new TreeNode(1,
                        new TreeNode(1),
                        new TreeNode(2)),
                new TreeNode(2,
                        null,
                        new TreeNode(2)));
        System.out.println("Test case 3 (Solution 1): " + Arrays.toString(solution.findMode(root3))); // Output: [1, 2]
        System.out.println("Test case 3 (Solution 2): " + Arrays.toString(solution.findMode1(root3))); // Output: [1, 2]

        // Test case 4:
        // Tree structure:
        //     2
        //    / \
        //   1   3
        // Expected output: [1, 2, 3] (all values occur once)
        TreeNode root4 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));
        System.out.println("Test case 4 (Solution 1): " + Arrays.toString(solution.findMode(root4))); // Output: [1, 2, 3]
        System.out.println("Test case 4 (Solution 2): " + Arrays.toString(solution.findMode1(root4))); // Output: [1, 2, 3]
    }
}