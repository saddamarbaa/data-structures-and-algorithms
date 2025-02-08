import java.util.LinkedList;

/**
 109. Convert Sorted List to Binary Search Tree

 Medium

 Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 Example 1:
 Input: head = [-10,-3,0,5,9]
 Output: [0,-3,9,-10,null,5]

 Example 2:
 Input: head = []
 Output: []

 Constraints:
 - The number of nodes in the linked list is in the range [0, 10^4].
 - -10^5 <= Node.val <= 10^5
 */

public class ConvertSortedListToBST {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Definition for a binary tree node.
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
    // Solution 1: Convert Sorted List to Balanced BST (Recursive)
    // ==================================================
    public TreeNode sortedListToBST(ListNode head) {
        // Base case: if head is null, return null
        if (head == null) {
            return null;
        }

        // Find the middle of the linked list
        ListNode mid = findMiddle(head);

        // The middle element becomes the root
        TreeNode root = new TreeNode(mid.val);

        // If the middle is the same as the head, it means there is only one element, so return the root
        if (head == mid) {
            return root;
        }

        // Recursively form the left and right subtrees
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    // Helper method to find the middle node of the linked list
    private ListNode findMiddle(ListNode head) {
        // Use two pointers: slow and fast
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move fast by 2 steps and slow by 1 step
        // When fast reaches the end, slow will be at the middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the left half from the middle
        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }

    // ==================================================
    // Solution 2: Convert Sorted List to Balanced BST (Iterative with AVL Insertion)
    // ==================================================
    public TreeNode sortedListToBST2(ListNode head) {
        ListNode temp = head;
        TreeNode root = null;
        while (temp != null) {
            root = insertHelper(root, temp.val);
            temp = temp.next;
        }

        return root;
    }

    public TreeNode insertHelper(TreeNode node, int value) {
        // Perform the normal BST insertion
        if (node == null) return new TreeNode(value);

        if (value < node.val) {
            node.left = insertHelper(node.left, value);
        } else if (value > node.val) {
            node.right = insertHelper(node.right, value);
        } else {
            return node; // Duplicate values are not allowed
        }

        // Get the balance factor of this node
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && value < node.left.val) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && value > node.right.val) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && value > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // Return the (unchanged) node pointer
    }

    // Get the height of the tree
    public int height(TreeNode node) {
        return (node == null) ? 0 : 1 + Math.max(height(node.left), height(node.right));
    }

    // Get balance factor of a node
    private int getBalance(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotate subtree rooted with y
    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    private TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Return new root
        return y;
    }

    // ==================================================
    // Main method to test both solutions
    // ==================================================
    public static void main(String[] args) {
        ConvertSortedListToBST solution = new ConvertSortedListToBST();

        // Test case: Linked list [-10, -3, 0, 5, 9]
        ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        TreeNode root = solution.sortedListToBST(head);  // Solution 1
        System.out.println("Solution 1: " + treeToString(root)); // Output: [0,-3,9,-10,null,5]

        TreeNode root2 = solution.sortedListToBST2(head);  // Solution 2
        System.out.println("Solution 2: " + treeToString(root2)); // Output: balanced BST with rotations

        // Test case 2: Empty list
        ListNode head2 = null;
        TreeNode root3 = solution.sortedListToBST(head2);  // Solution 1
        System.out.println("Solution 1: " + treeToString(root3)); // Output: []

        TreeNode root4 = solution.sortedListToBST2(head2);  // Solution 2
        System.out.println("Solution 2: " + treeToString(root4)); // Output: []
    }

    // Helper method to convert a tree to a string (for testing purposes)
    private static String treeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return "[" + sb.substring(0, sb.length() - 1) + "]";
    }
}
