import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 653. Two Sum IV - Input is a BST

 Given the root of a binary search tree and an integer k, return true if there exist two distinct nodes
 in the BST such that their sum is equal to k, otherwise return false.

 Example 1:

 Input: root = [5,3,6,2,4,null,7], k = 9
 Output: true
 Explanation: 5 + 4 = 9.

 Example 2:

 Input: root = [5,3,6,2,4,null,7], k = 28
 Output: false
 */

public class TwoSumIV {

    // ==================================================
    // Solution 1: Using DFS + HashSet to find complement
    // ==================================================
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    // Helper method to perform DFS
    private boolean dfs(TreeNode node, Set<Integer> set, int k) {
        if (node == null) {
            return false;
        }

        // Check if the complement (k - node.val) is in the set
        if (set.contains(k - node.val)) {
            return true; // We found two nodes that sum to k
        }

        // Add current node value to the set
        set.add(node.val);

        // Recursively check left and right subtrees
        return dfs(node.left, set, k) || dfs(node.right, set, k);
    }

    // ==================================================
    // Solution 2: Inorder Traversal + Two Pointer Technique
    // ==================================================
    public boolean findTargetInorder(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();
        inorder(root, sortedList);

        // Use two-pointer technique to find two numbers that sum to k
        int left = 0;
        int right = sortedList.size() - 1;

        while (left < right) {
            int sum = sortedList.get(left) + sortedList.get(right);

            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    // Helper method to perform Inorder Traversal and store values
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        TwoSumIV solution = new TwoSumIV();

        // Test case 1:
        // Input: root = [5,3,6,2,4,null,7], k = 9
        // Expected output: true
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(7);
        int k1 = 9;
        boolean result1 = solution.findTarget(root1, k1);
        System.out.println("Test case 1: " + result1); // Output: true

        // Test case 2:
        // Input: root = [5,3,6,2,4,null,7], k = 28
        // Expected output: false
        int k2 = 28;
        boolean result2 = solution.findTarget(root1, k2);
        System.out.println("Test case 2: " + result2); // Output: false

        // Test case 3:
        // Input: root = [2,1,3], k = 4
        // Expected output: true
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        int k3 = 4;
        boolean result3 = solution.findTarget(root2, k3);
        System.out.println("Test case 3: " + result3); // Output: true

        // Test case 4:
        // Input: root = [2,1,3], k = 3
        // Expected output: true
        int k4 = 3;
        boolean result4 = solution.findTarget(root2, k4);
        System.out.println("Test case 4: " + result4); // Output: true

        // Test case 5:
        // Input: root = [1], k = 2
        // Expected output: false
        TreeNode root3 = new TreeNode(1);
        int k5 = 2;
        boolean result5 = solution.findTarget(root3, k5);
        System.out.println("Test case 5: " + result5); // Output: false
    }
}

// ==================================================
// TreeNode class definition for convenience
// ==================================================
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
