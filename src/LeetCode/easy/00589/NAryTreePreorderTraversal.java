import java.util.ArrayList;
import java.util.List;

/**
 589. N-ary Tree Preorder Traversal

 Easy

 Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

 Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples).

 Example 1:
 Input: root = [1,null,3,2,4,null,5,6]
 Output: [1,3,5,6,2,4]

 Example 2:
 Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 Output: [1,2,3,6,7,4,8,9,10,5,11,12,13,14]

 Constraints:
 - The number of nodes in the tree is in the range [0, 10^4].
 - 0 <= Node.val <= 10^4
 - The height of the n-ary tree is less than or equal to 1000.

 Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class NAryTreePreorderTraversal {

    // Definition for a Node in N-ary tree
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

    // ==================================================
    // Solution: Recursive Preorder Traversal
    // ==================================================
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        // Call the helper function for recursive preorder traversal
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(Node node, List<Integer> result) {
        if (node == null) {
            return; // Base case: if node is null, return
        }

        // Visit the root node (preorder step)
        result.add(node.val);

        // Visit each child recursively
        for (Node child : node.children) {
            preorderHelper(child, result);
        }
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        NAryTreePreorderTraversal solution = new NAryTreePreorderTraversal();

        // Test case 1: root = [1,null,3,2,4,null,5,6]
        Node root1 = new Node(1, List.of(
                new Node(3, List.of(new Node(5), new Node(6))),
                new Node(2),
                new Node(4)
        ));
        List<Integer> result1 = solution.preorder(root1);
        System.out.println("Preorder traversal: " + result1); // Output: [1, 3, 5, 6, 2, 4]

        // Test case 2: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        Node root2 = new Node(1, List.of(
                new Node(2),
                new Node(3, List.of(new Node(6), new Node(7))),
                new Node(4, List.of(new Node(8, List.of(new Node(9), new Node(10))))),
                new Node(5, List.of(new Node(11), new Node(12), new Node(13))),
                new Node(14)
        ));
        List<Integer> result2 = solution.preorder(root2);
        System.out.println("Preorder traversal: " + result2); // Output: [1, 2, 3, 6, 7, 4, 8, 9, 10, 5, 11, 12, 13, 14]
    }
}
