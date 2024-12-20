/**
 876. Middle of the Linked List
 Solved
 Given the head of a singly linked list, return the middle node of the linked list.

 If there are two middle nodes, return the second middle node.
 */

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        // Test case 1:
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        ListNode result1 = middleNode(list1);
        System.out.println("Test Case 1 - Input list: " + listToString(list1));
        System.out.println("Test Case 1 - Middle node: " + result1.val);

        // Test case 2: even number of nodes
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);
        list2.next.next.next = new ListNode(4);

        ListNode result2 = middleNode(list2);
        System.out.println("Test Case 2 - Input list: " + listToString(list2));
        System.out.println("Test Case 2 - Middle node: " + result2.val);
    }

    /**
     * Middle of Linked List
     * Given the head of a singly linked list, return the middle node of the linked list.
     * If there are two middle nodes, return the second one.
     * Algorithm Steps:
     * 1. Use two pointers: slow and fast.
     * 2. The fast pointer moves two steps at a time, while the slow pointer moves one step at a time.
     * 3. When the fast pointer reaches the end of the list, the slow pointer will be at the middle.
     * 4. Return the slow pointer.
     * Time Complexity: O(n) where n is the length of the linked list.
     * Space Complexity: O(1) since we only use two pointers.
     */

    public static ListNode middleNode(ListNode head) {
        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Move slow by 1 step and fast by 2 steps until fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Return the middle node (slow pointer)
        return slow;
    }

    // Helper method to convert a linked list to a string for easy display
    public static String listToString(ListNode head) {
        if (head == null) return "NULL";
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
