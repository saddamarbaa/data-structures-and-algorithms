/***
 993. Cousins in Binary Tree

 Easy

 Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

 Two nodes of a binary tree are cousins if they have the same depth with different parents.

 Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.


 Example 1:

 Input: root = [1,2,3,4], x = 4, y = 3
 Output: false
 Example 2:


 Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 Output: true
 Example 3:


 Input: root = [1,2,3,null,4], x = 2, y = 3
 Output: false


 Constraints:

 The number of nodes in the tree is in the range [2, 100].
 1 <= Node.val <= 100
 Each node has a unique value.
 x != y
 x and y are exist in the tree.
 */

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {

    public static void main(String[] args) {
        // Test case 1: Creating a binary tree
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        // Test case 2: Checking if nodes 4 and 3 are cousins
        System.out.println("Are 4 and 3 cousins? " + isCousins(root1, 4, 3)); // Output: false

        // Test case 3: Creating another tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.right = new Node(4);
        root2.right.right = new Node(5);

        // Test case 4: Checking if nodes 5 and 4 are cousins
        System.out.println("Are 5 and 4 cousins? " + isCousins(root2, 5, 4)); // Output: true
    }

    /**
     * Main function to check if two nodes x and y are cousins.
     *
     * @param root Root of the binary tree.
     * @param x    Value of the first node.
     * @param y    Value of the second node.
     * @return true if x and y are cousins, otherwise false.
     */
    public static boolean isCousins(Node root, int x, int y) {
        return !isSameParent(root, x, y) && isHaveSameHeight(root, x, y);
    }

    /**
     * Helper function to check if two nodes x and y have the same parent.
     *
     * @param root Root of the binary tree.
     * @param x    Value of the first node.
     * @param y    Value of the second node.
     * @return true if x and y have the same parent, otherwise false.
     */
    public static boolean isSameParent(Node root, int x, int y) {
        Node parent1 = getParent(root, x);
        Node parent2 = getParent(root, y);

        return parent1 != null && parent2 != null && parent1.val == parent2.val;
    }

    /**
     * Helper function to check if two nodes x and y are at the same height.
     *
     * @param root Root of the binary tree.
     * @param x    Value of the first node.
     * @param y    Value of the second node.
     * @return true if x and y are at the same height, otherwise false.
     */
    public static boolean isHaveSameHeight(Node root, int x, int y) {
        int height1 = getHeight(root, x, 0);
        int height2 = getHeight(root, y, 0);

        return height1 == height2;
    }

    /**
     * Helper function to find the height of a given node in the binary tree.
     *
     * @param root  Root of the binary tree.
     * @param key   Value of the node.
     * @param level Current level during traversal.
     * @return The height of the node with the given key.
     */
    public static int getHeight(Node root, int key, int level) {
        if (root == null) {
            return level;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node parent = queue.poll();

                if (parent.left != null) {
                    if (parent.left.val == key) {
                        return level;
                    }
                    queue.add(parent.left);
                }

                if (parent.right != null) {
                    if (parent.right.val == key) {
                        return level;
                    }
                    queue.add(parent.right);
                }
            }
        }

        return level;
    }

    /**
     * Helper function to find the parent of a given node in the binary tree.
     *
     * @param root Root of the binary tree.
     * @param key  Value of the node.
     * @return The parent node of the node with the given key, or null if not found.
     */
    public static Node getParent(Node root, int key) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node parent = queue.poll();

                if (parent.left != null) {
                    if (parent.left.val == key) {
                        return parent;
                    }
                    queue.add(parent.left);
                }

                if (parent.right != null) {
                    if (parent.right.val == key) {
                        return parent;
                    }
                    queue.add(parent.right);
                }
            }
        }

        return null;  // Return null if the parent is not found
    }

    // Definition for a binary tree node.
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
