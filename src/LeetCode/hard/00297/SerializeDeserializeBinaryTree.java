import java.util.*;

/**
 * 297. Serialize and Deserialize Binary Tree
 *
 * Hard
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 10^4].
 * - -1000 <= Node.val <= 1000
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SerializeDeserializeBinaryTree {

    public static void main(String[] args) {
        // Test Case 1
        /*
         * Input Tree:
         *     1
         *    / \
         *   2   3
         *      / \
         *     4   5
         *
         * Expected Serialized Output: "1,2,null,null,3,4,null,null,5,null,null,"
         * Expected Deserialized Tree: Same as the input tree structure.
         */
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        String serialized1 = serialize(root1);
        System.out.println("Test Case 1 - Serialized: " + serialized1);

        TreeNode deserialized1 = deserialize(serialized1);
        System.out.println("Test Case 1 - Deserialized Tree: " + serialize(deserialized1));

        // Test Case 2
        /*
         * Input Tree: null (empty tree)
         *
         * Expected Serialized Output: "null,"
         * Expected Deserialized Tree: null (empty tree)
         */
        TreeNode root2 = null;
        String serialized2 = serialize(root2);
        System.out.println("Test Case 2 - Serialized: " + serialized2);

        TreeNode deserialized2 = deserialize(serialized2);
        System.out.println("Test Case 2 - Deserialized Tree: " + serialize(deserialized2));

        // Test Case 3
        /*
         * Input Tree:
         *     10
         *    /  \
         *   5    15
         *  / \     \
         * 2   7     20
         *
         * Expected Serialized Output: "10,5,2,null,null,7,null,null,15,null,20,null,null,"
         * Expected Deserialized Tree: Same as the input tree structure.
         */
        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.left.left = new TreeNode(2);
        root3.left.right = new TreeNode(7);
        root3.right = new TreeNode(15);
        root3.right.right = new TreeNode(20);

        String serialized3 = serialize(root3);
        System.out.println("Test Case 3 - Serialized: " + serialized3);

        TreeNode deserialized3 = deserialize(serialized3);
        System.out.println("Test Case 3 - Deserialized Tree: " + serialize(deserialized3));
    }

    /**
     * Serializes a binary tree to a string.
     * Algorithm:
     * 1. Use a pre-order traversal (root, left, right) to serialize the tree.
     * 2. Represent null nodes with a special marker (e.g., "null").
     * 3. Separate values with commas.
     *
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(n), for the recursion stack and the serialized string.
     *
     * @param root - The root of the binary tree.
     * @return A serialized string representation of the tree.
     */
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private static void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    /**
     * Deserializes a binary tree from a string.
     * Algorithm:
     * 1. Split the serialized string into tokens.
     * 2. Use a pre-order traversal to reconstruct the tree.
     * 3. Use a queue or iterator to process the tokens.
     *
     * Time Complexity: O(n), where n is the number of nodes in the tree.
     * Space Complexity: O(n), for the recursion stack and the queue.
     *
     * @param data - The serialized string representation of the tree.
     * @return The root of the reconstructed binary tree.
     */
    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private static TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }
}