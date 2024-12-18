/*
83. Remove Duplicates from Sorted List
Easy
Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
*/

public class RemoveDuplicatesSortedList {
    public static void main(String[] args) {
        // Test case 1:
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        ListNode result1 = deleteDuplicates(head1);
        System.out.println("Test Case 1 - Input list: " + listToString(head1));
        System.out.println("Test Case 1 - Result list: " + listToString(result1));

        // Test case 2:
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        ListNode result2 = deleteDuplicates(head2);
        System.out.println("Test Case 2 - Input list: " + listToString(head2));
        System.out.println("Test Case 2 - Result list: " + listToString(result2));

        // Test case 3:
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        ListNode result3 = deleteDuplicates(head3);
        System.out.println("Test Case 3 - Input list: " + listToString(head3));
        System.out.println("Test Case 3 - Result list: " + listToString(result3));

        // Test case 4: Single element list
        ListNode head4 = new ListNode(1);
        ListNode result4 = deleteDuplicates(head4);
        System.out.println("Test Case 4 - Input list: " + listToString(head4));
        System.out.println("Test Case 4 - Result list: " + listToString(result4));
    }

    /**
     * Remove Duplicates from Sorted List
     * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     * Algorithm Steps:
     * 1. Initialize a pointer `current` starting from the head of the linked list.
     * 2. Traverse the list and for each node, check if the next node has the same value.
     * 3. If a duplicate is found, skip the next node by setting the current node's next pointer to the node after it.
     * 4. Continue until all duplicates are removed.
     * 5. Return the modified linked list.
     * Time Complexity:
     * The algorithm visits each node exactly once. Therefore, the time complexity is O(n), where n is the number of nodes in the list.
     * Space Complexity:
     * The algorithm uses constant space, so the space complexity is O(1).
     */

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;  // Skip the duplicate node
            } else {
                current = current.next;  // Move to the next node
            }
        }

        return head;
    }

    // Helper method to convert a linked list to a string for easy display
    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val).append(" -> ");
            current = current.next;
        }
        return sb.append("NULL").toString();
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
