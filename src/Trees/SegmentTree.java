
/**
 [PROGRAM] :  Segment Tree - Implementation
 [AUTHOR]  :  Saddam Arbaa
 [Email]   :  <saddamarbaas@gmail.com>

 Java Program to Implement Segment Tree (BST)
 
 Reference in future :---->
 https://www.youtube.com/watch?v=ciHThtTVNto
 */

import java.util.Scanner;

public class SegmentTree {
    private Node root;

    // Constructor to build the segment tree
    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    // Recursive function to construct the segment tree
    private Node constructTree(int[] arr, int start, int end) {
        // Base case: Leaf node
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        // Create a new node for the current segment
        Node node = new Node(start, end);
        int mid = (start + end) / 2;

        // Recursively build the left and right subtrees
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        // Store the sum of the left and right children in the current node
        node.data = node.left.data + node.right.data;

        return node;
    }

    // Function to query the sum of a range
    public int queryRangeSum(int queryStart, int queryEnd) {
        return queryRangeSumHelper(root, queryStart, queryEnd);
    }

    // Helper function for range sum query
    private int queryRangeSumHelper(Node node, int queryStart, int queryEnd) {
        // If the current segment is completely outside the query range
        if (node.endInterval < queryStart || node.startInterval > queryEnd) {
            return 0;
        }

        // If the current segment is completely inside the query range
        if (node.startInterval >= queryStart && node.endInterval <= queryEnd) {
            return node.data;
        }

        // If the current segment partially overlaps with the query range
        return queryRangeSumHelper(node.left, queryStart, queryEnd) +
                queryRangeSumHelper(node.right, queryStart, queryEnd);
    }

    // Function to update a value in the input array and the segment tree
    public void updateValue(int index, int newValue) {
        updateValueHelper(root, index, newValue);
    }

    // Helper function to update a value in the segment tree
    private void updateValueHelper(Node node, int index, int newValue) {
        // If the current node is a leaf node and contains the index
        if (node.startInterval == node.endInterval) {
            node.data = newValue;
            return;
        }

        // Determine which child contains the index
        int mid = (node.startInterval + node.endInterval) / 2;
        if (index <= mid) {
            updateValueHelper(node.left, index, newValue);
        } else {
            updateValueHelper(node.right, index, newValue);
        }

        // Update the current node's data with the sum of its children
        node.data = node.left.data + node.right.data;
    }

    // Function to print the segment tree (for debugging purposes)
    public void printSegmentTree() {
        printSegmentTreeHelper(root, 0);
    }

    // Helper function to print the segment tree
    private void printSegmentTreeHelper(Node node, int level) {
        if (node == null) {
            return;
        }

        // Print the current node
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("[" + node.startInterval + ", " + node.endInterval + "] -> " + node.data);

        // Recursively print the left and right subtrees
        printSegmentTreeHelper(node.left, level + 1);
        printSegmentTreeHelper(node.right, level + 1);
    }

    // Node class to represent a segment in the segment tree
    private static class Node {
        int data; // Sum of the segment
        int startInterval; // Start index of the segment
        int endInterval; // End index of the segment
        Node left; // Left child
        Node right; // Right child

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
            this.left = null;
            this.right = null;
        }
    }

    // Main function to test the Segment Tree with detailed logging
    public static void main(String[] args) {
        // Hardcoded array for testing
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr);

        // Test case 1: Query range sum [1, 3]
        int queryStart = 1;
        int queryEnd = 3;
        int expectedSum = 15; // 3 + 5 + 7 = 15
        System.out.println("\n--- Test Case 1: Querying sum for range [" + queryStart + ", " + queryEnd + "] ---");
        int actualSum = segmentTree.queryRangeSum(queryStart, queryEnd);
        if (actualSum == expectedSum) {
            System.out.println("Test 1 PASSED: The sum for range [" + queryStart + ", " + queryEnd + "] is correct: " + actualSum);
        } else {
            System.out.println("Test 1 FAILED: Expected sum: " + expectedSum + ", but got: " + actualSum);
        }

        // Test case 2: Update value at index 2 to 10
        int index = 2;
        int newValue = 10;
        segmentTree.updateValue(index, newValue);
        expectedSum = 20; // 3 + 10 + 7 = 20 after update
        System.out.println("\n--- Test Case 2: After updating index " + index + " to " + newValue + ", Querying sum for range [" + queryStart + ", " + queryEnd + "] ---");
        actualSum = segmentTree.queryRangeSum(queryStart, queryEnd);
        if (actualSum == expectedSum) {
            System.out.println("Test 2 PASSED: The sum for range [" + queryStart + ", " + queryEnd + "] after update is correct: " + actualSum);
        } else {
            System.out.println("Test 2 FAILED: Expected sum after update: " + expectedSum + ", but got: " + actualSum);
        }

        // Test case 3: Query range sum [0, 5]
        queryStart = 0;
        queryEnd = 5;
        expectedSum = 41; // 1 + 3 + 10 + 7 + 9 + 11 = 41 after update
        System.out.println("\n--- Test Case 3: Querying sum for range [" + queryStart + ", " + queryEnd + "] ---");
        actualSum = segmentTree.queryRangeSum(queryStart, queryEnd);
        if (actualSum == expectedSum) {
            System.out.println("Test 3 PASSED: The sum for range [" + queryStart + ", " + queryEnd + "] is correct: " + actualSum);
        } else {
            System.out.println("Test 3 FAILED: Expected sum: " + expectedSum + ", but got: " + actualSum);
        }
    }
}