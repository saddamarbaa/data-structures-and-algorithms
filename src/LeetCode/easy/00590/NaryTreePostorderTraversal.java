import java.util.*;

/***
 590. N-ary Tree Postorder Traversal
 Easy
 Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

 Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

 Example 1:


 Input: root = [1,null,3,2,4,null,5,6]
 Output: [5,6,3,2,4,1]
 Example 2:


 Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]

 Constraints:

 The number of nodes in the tree is in the range [0, 104].
 0 <= Node.val <= 104
 The height of the n-ary tree is less than or equal to 1000.


 Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePostorderTraversal {

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

    // Recursive approach for postorder traversal
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; // Return an empty list if the tree is empty
        }

        // Helper function to recursively traverse the tree in postorder
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(Node node, List<Integer> result) {
        // Traverse the children first (postorder)
        for (Node child : node.children) {
            postorderHelper(child, result);
        }
        // Then add the current node's value to the result
        result.add(node.val);
    }

    public static void main(String[] args) {
        NaryTreePostorderTraversal solution = new NaryTreePostorderTraversal();

        // Test case 1:
        // Tree structure:
        //       1
        //     / | \
        //    3  2  4
        //   / \
        //  5   6
        // Expected output: [5, 6, 3, 2, 4, 1]
        Node root1 = new Node(1, Arrays.asList(
                new Node(3, Arrays.asList(
                        new Node(5),
                        new Node(6))),
                new Node(2),
                new Node(4)));
        System.out.println("Test case 1: " + solution.postorder(root1)); // Output: [5, 6, 3, 2, 4, 1]

        // Test case 2:
        // Tree structure:
        //       1
        // Expected output: [1]
        Node root2 = new Node(1);
        System.out.println("Test case 2: " + solution.postorder(root2)); // Output: [1]

        // Test case 3:
        // Tree structure:
        // null tree (empty)
        // Expected output: []
        Node root3 = null;
        System.out.println("Test case 3: " + solution.postorder(root3)); // Output: []

        // Test case 4:
        // Tree structure:
        //       1
        //      / \
        //     2   3
        //    /
        //   4
        // Expected output: [4, 2, 3, 1]
        Node root4 = new Node(1, Arrays.asList(
                new Node(2, Arrays.asList(new Node(4))),
                new Node(3)));
        System.out.println("Test case 4: " + solution.postorder(root4)); // Output: [4, 2, 3, 1]
    }
}
