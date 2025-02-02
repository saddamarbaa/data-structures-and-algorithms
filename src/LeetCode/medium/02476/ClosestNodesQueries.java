/***
 2476. Closest Nodes Queries in a Binary Search Tree

 Medium

 You are given the root of a binary search tree and an array queries of size n consisting of positive integers.

 Find a 2D array answer of size n where answer[i] = [mini, maxi]:

 mini is the largest value in the tree that is smaller than or equal to queries[i]. If a such value does not exist, add -1 instead.
 maxi is the smallest value in the tree that is greater than or equal to queries[i]. If a such value does not exist, add -1 instead.
 Return the array answer.

 Example 1:

 Input: root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
 Output: [[2,2],[4,6],[15,-1]]
 Explanation: We answer the queries in the following way:
 - The largest number that is smaller or equal than 2 in the tree is 2, and the smallest number that is greater or equal than 2 is still 2. So the answer for the first query is [2,2].
 - The largest number that is smaller or equal than 5 in the tree is 4, and the smallest number that is greater or equal than 5 is 6. So the answer for the second query is [4,6].
 - The largest number that is smaller or equal than 16 in the tree is 15, and the smallest number that is greater or equal than 16 does not exist. So the answer for the third query is [15,-1].
 Example 2:


 Input: root = [4,null,9], queries = [3]
 Output: [[-1,4]]
 Explanation: The largest number that is smaller or equal to 3 in the tree does not exist, and the smallest number that is greater or equal to 3 is 4. So the answer for the query is [-1,4].


 Constraints:

 The number of nodes in the tree is in the range [2, 105].
 1 <= Node.val <= 106
 n == queries.length
 1 <= n <= 105
 1 <= queries[i] <= 106
 */

import java.util.ArrayList;
import java.util.List;

public class ClosestNodesQueries {

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
    // Solution 1: In-order traversal to get sorted list, then binary search for each query
    // ==================================================
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        // Step 1: Perform in-order traversal to get a sorted list of node values
        List<Integer> sortedValues = new ArrayList<>();
        inOrderTraversal(root, sortedValues);

        // Step 2: For each query, perform binary search to find the closest nodes
        List<List<Integer>> result = new ArrayList<>();
        for (int query : queries) {
            List<Integer> closest = new ArrayList<>();
            int index = binarySearch(sortedValues, query);

            if (index == -1) {
                // All values are greater than the query
                closest.add(-1);
                closest.add(sortedValues.get(0));
            } else if (index == sortedValues.size() - 1 && sortedValues.get(index) < query) {
                // All values are smaller than the query
                closest.add(sortedValues.get(index));
                closest.add(-1);
            } else {
                // Find the closest value
                int val1 = sortedValues.get(index);
                int val2 = sortedValues.get(index + 1);
                if (Math.abs(query - val1) <= Math.abs(query - val2)) {
                    closest.add(val1);
                    closest.add(val1);
                } else {
                    closest.add(val1);
                    closest.add(val2);
                }
            }
            result.add(closest);
        }

        return result;
    }

    // In-order traversal to get sorted values
    private void inOrderTraversal(TreeNode root, List<Integer> sortedValues) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, sortedValues);
        sortedValues.add(root.val);
        inOrderTraversal(root.right, sortedValues);
    }

    // Binary search to find the index of the largest value <= query
    private int binarySearch(List<Integer> sortedValues, int query) {
        int left = 0;
        int right = sortedValues.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedValues.get(mid) <= query) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // ==================================================
    // Solution 2: Recursive approach with binary search
    // ==================================================
    public List<List<Integer>> closestNodes2(TreeNode root, List<Integer> queries) {
        List<Integer> sortedValues = new ArrayList<>();
        inOrderTraversal(root, sortedValues);

        List<List<Integer>> result = new ArrayList<>();
        for (int query : queries) {
            List<Integer> closest = new ArrayList<>();
            int max = getMax(sortedValues, query, 0, sortedValues.size() - 1);
            int min = getMin(sortedValues, query, 0, sortedValues.size() - 1);
            closest.add(max);
            closest.add(min);
            result.add(closest);
        }

        return result;
    }

    // Binary search to find the largest value <= key
    private int getMax(List<Integer> nums, int key, int low, int high) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) <= key) {
                result = nums.get(mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Binary search to find the smallest value >= key
    private int getMin(List<Integer> nums, int key, int low, int high) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) >= key) {
                result = nums.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    // ==================================================
    // Solution 3: BFS (in-order traversal) and binary search
    // ==================================================
    public List<List<Integer>> closestNodes3(TreeNode root, List<Integer> queries) {
        ArrayList<Integer> sortedTree = new ArrayList<>();
        BFS(root, sortedTree);

        List<List<Integer>> list = new ArrayList<>();
        for (int key : queries) {
            int min = getMax(sortedTree, key, 0, sortedTree.size() - 1);
            int max = getMin(sortedTree, key, 0, sortedTree.size() - 1);
            List<Integer> nums = new ArrayList<>();
            nums.add(min);
            nums.add(max);
            list.add(nums);
        }

        return list;
    }

    // BFS (in-order traversal) to get sorted values
    public void BFS(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        BFS(node.left, list);
        list.add(node.val);
        BFS(node.right, list);
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        ClosestNodesQueries solution = new ClosestNodesQueries();

        // Test case 1:
        // Tree structure:
        //      4
        //     / \
        //    2   6
        //   / \ / \
        //  1  3 5  7
        // Queries: [1, 4, 8]
        // Expected output: [[1, 1], [4, 4], [7, -1]]
        TreeNode root1 = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7)));
        List<Integer> queries1 = List.of(1, 4, 8);
        List<List<Integer>> result1 = solution.closestNodes3(root1, queries1);
        System.out.println("Test case 1: " + result1); // Output: [[1, 1], [4, 4], [7, -1]]

        // Test case 2:
        // Tree structure: [1]
        // Queries: [1, 2]
        // Expected output: [[1, 1], [1, -1]]
        TreeNode root2 = new TreeNode(1);
        List<Integer> queries2 = List.of(1, 2);
        List<List<Integer>> result2 = solution.closestNodes3(root2, queries2);
        System.out.println("Test case 2: " + result2); // Output: [[1, 1], [1, -1]]

        // Test case 3:
        // Tree structure:
        //      10
        //     /  \
        //    5    15
        //   / \  / \
        //  2  7 12 20
        // Queries: [3, 8, 13]
        // Expected output: [[2, 5], [7, 10], [12, 15]]
        TreeNode root3 = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(2),
                        new TreeNode(7)),
                new TreeNode(15,
                        new TreeNode(12),
                        new TreeNode(20)));
        List<Integer> queries3 = List.of(3, 8, 13);
        List<List<Integer>> result3 = solution.closestNodes3(root3, queries3);
        System.out.println("Test case 3: " + result3); // Output: [[2, 5], [7, 10], [12, 15]]
    }
}