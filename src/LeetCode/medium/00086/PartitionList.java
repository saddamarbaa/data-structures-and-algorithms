/*
86. Partition List
Medium

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Explanation:
- Nodes less than 3: [1,2,2]
- Nodes greater than or equal to 3: [4,3,5]
The relative order of the nodes is preserved.

Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
Explanation:
- Nodes less than 2: [1]
- Nodes greater than or equal to 2: [2]
The relative order of the nodes is preserved.

Constraints:
- The number of nodes in the list is in the range [0, 200].
- -100 <= Node.val <= 100
- -200 <= x <= 200
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class PartitionList {
    public static void main(String[] args) {
        // Test Case 1
//        ListNode head1 = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))));
//        int x1 = 3;
//        ListNode expected1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(5)))));
//        ListNode result1 = partition(head1, x1);
//        System.out.println("Test Case 1 - Input: [1,4,3,2,5,2], x = 3");
//        System.out.println("Test Case 1 - Expected result: " + listToString(expected1));
//        System.out.println("Test Case 1 - Actual result: " + listToString(result1));
//        System.out.println("Test Case 1 - Result matches expected: " + areListsEqual(result1, expected1));

        // Test Case 2
        ListNode head2 = new ListNode(2, new ListNode(1));
        int x2 = 2;
        ListNode expected2 = new ListNode(1, new ListNode(2));
        ListNode result2 = partition(head2, x2);
        System.out.println("Test Case 2 - Input: [2,1], x = 2");
        System.out.println("Test Case 2 - Expected result: " + listToString(expected2));
        System.out.println("Test Case 2 - Actual result: " + listToString(result2));
        System.out.println("Test Case 2 - Result matches expected: " + areListsEqual(result2, expected2));
    }

    /**
     * Solution 1: Using Two Separate Lists
     *
     * Algorithm Steps:
     * 1. Create two dummy nodes: one for nodes less than x (lessHead) and one for nodes greater than or equal to x (greaterHead).
     * 2. Traverse the original list and separate the nodes into the two lists based on their value compared to x.
     * 3. Connect the end of the "less" list to the beginning of the "greater" list.
     * 4. Return the merged list.
     *
     * Time Complexity: O(n), where n is the number of nodes in the list.
     * Space Complexity: O(1), as we are only using a constant amount of extra space.
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null; // Terminate the greater list
        less.next = greaterHead.next; // Connect the two lists

        return lessHead.next;
    }

    /**
     * Solution 2: In-Place Partitioning (Using Pointers)
     *
     * Algorithm Steps:
     * 1. Use two pointers: one for the start of the "less" list and one for the start of the "greater" list.
     * 2. Traverse the list and move nodes to the appropriate list based on their value compared to x.
     * 3. Connect the end of the "less" list to the beginning of the "greater" list.
     *
     * Time Complexity: O(n), where n is the number of nodes in the list.
     * Space Complexity: O(1), as we are only using a constant amount of extra space.
     */
    public static ListNode partition2(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode lessPtr = less;
        ListNode greaterPtr = greater;

        while (head != null) {
            if (head.val < x) {
                lessPtr.next = head;
                lessPtr = lessPtr.next;
            } else {
                greaterPtr.next = head;
                greaterPtr = greaterPtr.next;
            }
            head = head.next;
        }

        greaterPtr.next = null; // Terminate the greater list
        lessPtr.next = greater.next; // Connect the two lists

        return less.next;
    }

    /**
     * Solution 3: Using Recursion
     *
     * Algorithm Steps:
     * 1. Recursively partition the list by separating nodes less than x and nodes greater than or equal to x.
     * 2. Combine the two partitions while preserving the relative order.
     *
     * Time Complexity: O(n), where n is the number of nodes in the list.
     * Space Complexity: O(n), due to the recursion stack.
     */
    public static ListNode partition3(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = partition3(head.next, x);

        if (head.val < x) {
            head.next = next;
            return head;
        } else {
            ListNode temp = next;
            while (temp != null && temp.next != null && temp.next.val < x) {
                temp = temp.next;
            }
            head.next = temp != null ? temp.next : null;
            if (temp != null) {
                temp.next = head;
            }
            return next;
        }
    }

    // Helper method to convert a linked list to a string for printing
    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(",");
            }
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Helper method to check if two linked lists are equal
    public static boolean areListsEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}