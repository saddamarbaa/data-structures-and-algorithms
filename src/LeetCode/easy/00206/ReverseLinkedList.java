/**
 206. Reverse Linked List
 Easy
 Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        // Test case 1:
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        ListNode result1 = reverseList(list1);
        System.out.println("Test Case 1 - Input list: " + listToString(list1));
        System.out.println("Test Case 1 - Reversed list: " + listToString(result1));

        // Test case 2: empty list
        ListNode result2 = reverseList(null);
        System.out.println("Test Case 2 - Input list: NULL");
        System.out.println("Test Case 2 - Reversed list: " + listToString(result2));

        // Test case 3: one node list
        ListNode list3 = new ListNode(1);
        ListNode result3 = reverseList(list3);
        System.out.println("Test Case 3 - Input list: " + listToString(list3));
        System.out.println("Test Case 3 - Reversed list: " + listToString(result3));
    }

    /**
     * Reverse Linked List
     * Given the head of a singly linked list, reverse the list and return its head.
     * Algorithm Steps:
     * 1. Initialize three pointers: previous (null), current (head), next (null).
     * 2. Traverse through the list, updating the pointers.
     * 3. At each step, change the current node's next pointer to point to the previous node.
     * 4. Move the previous and current pointers one step forward.
     * 5. Once all nodes are reversed, return the new head (previous node).
     * Time Complexity: O(n) where n is the length of the list.
     * Space Complexity: O(1) since we only use a constant amount of extra space.
     */

    public static ListNode reverseList(ListNode head) {
        // Pointers for previous, current, and next node
        ListNode previous = null;
        ListNode current = head;

        // Traverse through the list and reverse the pointers
        while (current != null) {
            ListNode nextNode = current.next;  // Save the next node
            current.next = previous;           // Reverse the current node's pointer
            previous = current;                // Move previous to the current node
            current = nextNode;                // Move current to the next node
        }

        // Return the new head of the reversed list (previous pointer)
        return previous;
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
