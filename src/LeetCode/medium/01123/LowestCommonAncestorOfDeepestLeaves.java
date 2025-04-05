import java.util.*;

/**
 * 1123. Lowest Common Ancestor of Deepest Leaves
 *
 * Given the root of a binary tree, return the lowest common ancestor (LCA) of its deepest leaves.
 */
public class LowestCommonAncestorOfDeepestLeaves {

    public static void main(String[] args) {
        // Test Cases
        runTestCase(new Integer[]{3,5,1,6,2,0,8,null,null,7,4}, new Integer[]{2,7,4});
        runTestCase(new Integer[]{1}, new Integer[]{1});
        runTestCase(new Integer[]{0,1,3,null,2}, new Integer[]{2});
    }

    // Method to run each test case
    public static void runTestCase(Integer[] tree, Integer[] expected) {
        TreeNode root = buildTree(tree);

        long startTime1 = System.nanoTime();
        TreeNode result1 = lcaDeepestLeavesBasic(root);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        long startTime2 = System.nanoTime();
        TreeNode result2 = lcaDeepestLeavesOptimized(root);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        List<Integer> resultList1 = result1 != null ? treeToArray(result1) : new ArrayList<>();
        List<Integer> resultList2 = result2 != null ? treeToArray(result2) : new ArrayList<>();
        List<Integer> expectedList = Arrays.asList(expected);

        System.out.println("Test Case - Input: root = " + Arrays.toString(tree));
        System.out.println("Expected result: " + expectedList);
        System.out.println("Result (Basic Approach): " + resultList1 + " (Time: " + duration1 + " ns)");
        System.out.println("Result (Optimized Approach): " + resultList2 + " (Time: " + duration2 + " ns)");
        System.out.println("All results match expected: " +
                (resultList1.equals(expectedList) && resultList2.equals(expectedList)));
        System.out.println();
    }

    // Helper method to build a tree from an array
    private static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            TreeNode current = queue.poll();
            if (i < array.length && array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.add(current.left);
            }
            i++;
            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    // Helper method to convert a tree to a list (BFS)
    private static List<Integer> treeToArray(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        // Remove trailing nulls
        int i = result.size() - 1;
        while (i >= 0 && result.get(i) == null) {
            result.remove(i);
            i--;
        }
        return result;
    }

    /**
     * Approach 1: Basic Recursive Approach with Depth Calculation
     *
     * Algorithm Steps:
     * 1. Calculate the maximum depth of the tree.
     * 2. Find all nodes at the maximum depth.
     * 3. Find the LCA of these nodes.
     *
     * Time Complexity: O(n^2) in the worst case (for skewed trees).
     * Space Complexity: O(n) for recursion stack and storing nodes.
     */
    public static TreeNode lcaDeepestLeavesBasic(TreeNode root) {
        if (root == null) return null;
        int maxDepth = getMaxDepth(root);
        List<TreeNode> deepestLeaves = new ArrayList<>();
        getDeepestLeaves(root, 1, maxDepth, deepestLeaves);
        return findLCA(root, deepestLeaves);
    }

    private static int getMaxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getMaxDepth(node.left), getMaxDepth(node.right));
    }

    private static void getDeepestLeaves(TreeNode node, int currentDepth, int maxDepth, List<TreeNode> deepestLeaves) {
        if (node == null) return;
        if (currentDepth == maxDepth) {
            deepestLeaves.add(node);
            return;
        }
        getDeepestLeaves(node.left, currentDepth + 1, maxDepth, deepestLeaves);
        getDeepestLeaves(node.right, currentDepth + 1, maxDepth, deepestLeaves);
    }

    private static TreeNode findLCA(TreeNode root, List<TreeNode> nodes) {
        if (nodes.size() == 1) return nodes.get(0);
        TreeNode lca = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            lca = findLCA(root, lca, nodes.get(i));
        }
        return lca;
    }

    private static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    /**
     * Approach 2: Optimized Post-Order Traversal
     *
     * Algorithm Steps:
     * 1. Traverse the tree and keep track of the depth of each node.
     * 2. For each node, if left and right subtrees have the same maximum depth, the node is the LCA.
     * 3. Otherwise, the LCA is in the subtree with the greater depth.
     *
     * Time Complexity: O(n), where n is the number of nodes.
     * Space Complexity: O(h), where h is the height of the tree (recursion stack).
     */
    public static TreeNode lcaDeepestLeavesOptimized(TreeNode root) {
        return dfs(root).node;
    }

    private static Pair dfs(TreeNode node) {
        if (node == null) return new Pair(null, 0);
        Pair left = dfs(node.left);
        Pair right = dfs(node.right);
        if (left.depth == right.depth) {
            return new Pair(node, left.depth + 1);
        } else if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        } else {
            return new Pair(right.node, right.depth + 1);
        }
    }

    static class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}