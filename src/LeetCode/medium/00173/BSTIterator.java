import java.util.ArrayList;
import java.util.List;

/***
 * 173. Binary Search Tree Iterator
 *
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 *
 * - BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
 * The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number
 * smaller than any element in the BST.
 *
 * - boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer,
 * otherwise returns false.
 *
 * - int next() Moves the pointer to the right, then returns the number at the pointer.
 *
 * The next() and hasNext() functions should run in average O(1) time and use O(h) memory, where h is the height
 * of the tree.
 *
 * You may assume that next() calls will always be valid.
 */

public class BSTIterator {

    // ==================================================
    // Solution 1: Using an Inorder Traversal (DFS) + List
    // ==================================================
    private List<Integer> inorderList;
    private int currentIndex;

    // Constructor to initialize the iterator with the in-order traversal
    public BSTIterator(TreeNode root) {
        this.inorderList = new ArrayList<>();
        this.currentIndex = 0;
        inorderTraversal(root);
    }

    // Return the next smallest number
    public int next() {
        return inorderList.get(currentIndex++);
    }

    // Return true if there is a next element in the traversal
    public boolean hasNext() {
        return currentIndex < inorderList.size();
    }

    // Helper method to perform in-order traversal and store values
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        inorderList.add(node.val);
        inorderTraversal(node.right);
    }

    // ==================================================
    // Solution 2: Direct ArrayList Approach
    // ==================================================
    private ArrayList<Integer> values;
    private int pos;

    // Constructor initializes the ArrayList and populates with in-order traversal
    public BSTIterator(TreeNode root, boolean useArrayList) {
        this.values = new ArrayList<>();
        this.pos = 0;
        inorderToArrayList(root);
    }

    // Return true if the iterator has more elements
    public boolean hasNextArrayList() {
        return pos < values.size();
    }

    // Return the next smallest element from ArrayList
    public int nextArrayList() {
        return values.get(pos++);
    }

    // Helper method to store in-order traversal to ArrayList
    private void inorderToArrayList(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderToArrayList(node.left);
        values.add(node.val);
        inorderToArrayList(node.right);
    }

    // ==================================================
    // Main method to test the solution
    // ==================================================
    public static void main(String[] args) {
        // Test case 1 for Solution 1:
        TreeNode root1 = new TreeNode(7);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(15);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root1);

        System.out.println(iterator.next());    // Output: 3
        System.out.println(iterator.next());    // Output: 7
        System.out.println(iterator.hasNext()); // Output: true
        System.out.println(iterator.next());    // Output: 9
        System.out.println(iterator.hasNext()); // Output: true
        System.out.println(iterator.next());    // Output: 15
        System.out.println(iterator.hasNext()); // Output: true
        System.out.println(iterator.next());    // Output: 20
        System.out.println(iterator.hasNext()); // Output: false

        // Test case 2 for Solution 2 (using ArrayList):
        TreeNode root2 = new TreeNode(7);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(15);
        root2.right.left = new TreeNode(9);
        root2.right.right = new TreeNode(20);

        BSTIterator iterator2 = new BSTIterator(root2, true);

        System.out.println(iterator2.nextArrayList());    // Output: 3
        System.out.println(iterator2.nextArrayList());    // Output: 7
        System.out.println(iterator2.hasNextArrayList()); // Output: true
        System.out.println(iterator2.nextArrayList());    // Output: 9
        System.out.println(iterator2.hasNextArrayList()); // Output: true
        System.out.println(iterator2.nextArrayList());    // Output: 15
        System.out.println(iterator2.hasNextArrayList()); // Output: true
        System.out.println(iterator2.nextArrayList());    // Output: 20
        System.out.println(iterator2.hasNextArrayList()); // Output: false
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
