/**
 572. Subtree of Another Tree
 Easy

 Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

 A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

 Example 1:


 Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 Output: true
 Example 2:


 Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 Output: false


 Constraints:

 The number of nodes in the root tree is in the range [1, 2000].
 The number of nodes in the subRoot tree is in the range [1, 1000].
 -104 <= root.val <= 104
 -104 <= subRoot.val <= 104
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution to check if two binary trees are the same using both Recursive and Iterative approaches.
 */
public class SameTree {

    // TreeNode class definition
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

    /**
     * Recursive solution to check if two binary trees are the same.
     *
     * @param p the root of the first binary tree
     * @param q the root of the second binary tree
     * @return true if both trees are the same, false otherwise
     */
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        // Both trees are null, they are the same
        if (p == null && q == null) {
            return true;
        }
        // One of the trees is null or values are different
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // Recursively check left and right subtrees
        return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
    }

    /**
     * Iterative solution to check if two binary trees are the same using level-order traversal (BFS).
     *
     * @param p the root of the first binary tree
     * @param q the root of the second binary tree
     * @return true if both trees are the same, false otherwise
     */
    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        // Use two queues to compare both trees
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        queueP.add(p);
        queueQ.add(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();

            // If one is null and the other is not, they are not the same
            if (nodeP == null && nodeQ != null || nodeP != null && nodeQ == null) {
                return false;
            }
            // If both are non-null but have different values
            if (nodeP != null && nodeQ != null && nodeP.val != nodeQ.val) {
                return false;
            }
            if (nodeP != null) {
                // Add the left and right children to the queue
                queueP.add(nodeP.left);
                queueP.add(nodeP.right);
            }
            if (nodeQ != null) {
                // Add the left and right children to the queue
                queueQ.add(nodeQ.left);
                queueQ.add(nodeQ.right);
            }
        }

        return queueP.isEmpty() && queueQ.isEmpty(); // Both queues should be empty at the same time
    }

    // Main method to test both solutions
    public static void main(String[] args) {
        SameTree solution = new SameTree();

        // Test case 1: Both trees are the same
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Recursive Solution for Test 1: " + solution.isSameTreeRecursive(p1, q1)); // true
        System.out.println("Iterative Solution for Test 1: " + solution.isSameTreeIterative(p1, q1)); // true

        // Test case 2: Trees are different
        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Recursive Solution for Test 2: " + solution.isSameTreeRecursive(p2, q2)); // false
        System.out.println("Iterative Solution for Test 2: " + solution.isSameTreeIterative(p2, q2)); // false
    }
}
