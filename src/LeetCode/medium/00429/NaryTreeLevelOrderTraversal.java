import java.util.*;

/***
 429. N-ary Tree Level Order Traversal

 Medium

 Given an n-ary tree, return the level order traversal of its nodes' values.

 Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).



 Example 1:



 Input: root = [1,null,3,2,4,null,5,6]
 Output: [[1],[3,2,4],[5,6]]
 Example 2:



 Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]


 Constraints:

 The height of the n-ary tree is less than or equal to 1000
 The total number of nodes is between [0, 104]
 */
public class NaryTreeLevelOrderTraversal {

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result; // Return an empty list if the tree is empty
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); // Start with the root node

        // Perform BFS (level order traversal)
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                // Add children of the current node to the queue
                for (Node child : currentNode.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }

            // Add the current level to the result
            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        NaryTreeLevelOrderTraversal solution = new NaryTreeLevelOrderTraversal();

        // Test case 1:
        // Tree structure:
        //       1
        //     / | \
        //    3  2  4
        //   / \
        //  5   6
        // Expected output: [[1], [3, 2, 4], [5, 6]]
        Node root1 = new Node(1, Arrays.asList(
                new Node(3, Arrays.asList(
                        new Node(5),
                        new Node(6))),
                new Node(2),
                new Node(4)));
        System.out.println("Test case 1: " + solution.levelOrder(root1)); // Output: [[1], [3, 2, 4], [5, 6]]

        // Test case 2:
        // Tree structure:
        //       1
        // Expected output: [[1]]
        Node root2 = new Node(1);
        System.out.println("Test case 2: " + solution.levelOrder(root2)); // Output: [[1]]

        // Test case 3:
        // Tree structure:
        // null tree (empty)
        // Expected output: []
        Node root3 = null;
        System.out.println("Test case 3: " + solution.levelOrder(root3)); // Output: []

        // Test case 4:
        // Tree structure:
        //       1
        //      / \
        //     2   3
        //    /
        //   4
        // Expected output: [[1], [2, 3], [4]]
        Node root4 = new Node(1, Arrays.asList(
                new Node(2, Arrays.asList(new Node(4))),
                new Node(3)));
        System.out.println("Test case 4: " + solution.levelOrder(root4)); // Output: [[1], [2, 3], [4]]
    }
}
