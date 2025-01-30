/**
 108. Convert Sorted Array to Binary Search Tree

 Easy

 Given an integer array nums where the elements are sorted in ascending order, convert it to a
 height-balanced
 binary search tree.

 Example 1:

 Input: nums = [-10,-3,0,5,9]
 Output: [0,-3,9,-10,null,5]
 Explanation: [0,-10,5,null,-3,null,9] is also accepted:

 Example 2:


 Input: nums = [1,3]
 Output: [3,1]
 Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.


 Constraints:

 1 <= nums.length <= 104
 -104 <= nums[i] <= 104
 nums is sorted in a strictly increasing order.
 */

public class SortedArrayToBST {

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
     * Converts a sorted array into a height-balanced binary search tree.
     *
     * @param nums the sorted array of integers
     * @return the root node of the constructed BST
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    /**
     * Helper method to build the BST recursively from the sorted array.
     *
     * @param nums  the sorted array
     * @param start the starting index of the current subarray
     * @param end   the ending index of the current subarray
     * @return the root node of the subtree constructed from the subarray
     */
    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // Find the middle index to ensure the tree is height-balanced
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        // Recursively build left and right subtrees
        node.left = buildBST(nums, start, mid - 1);
        node.right = buildBST(nums, mid + 1, end);
        return node;
    }

    // Main method for testing
    public static void main(String[] args) {
        SortedArrayToBST solution = new SortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);
        // The root should be the middle element of the array, which is 0
        System.out.println("Root value: " + root.val); // Output: 0
    }
}