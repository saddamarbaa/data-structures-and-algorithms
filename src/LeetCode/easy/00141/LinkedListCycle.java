/**
 141. Linked List Cycle
 Easy
 Topics
 Companies
 Given head, the head of a linked list, determine if the linked list has a cycle in it.

 There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

 Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        // Test case 1: No cycle
        ListNode list1 = new ListNode(3);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(0);
        list1.next.next.next = new ListNode(-4);

        System.out.println("Test Case 1 - Input list: " + listToString(list1));
        System.out.println("Test Case 1 - Has cycle: " + hasCycle(list1));

        // Test case 2: With cycle
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = list2;  // Creating a cycle

        System.out.println("Test Case 2 - Input list: 1 -> 2 -> cycle");
        System.out.println("Test Case 2 - Has cycle: " + hasCycle(list2));

        // Test case 3: Single node, no cycle
        ListNode list3 = new ListNode(1);
        System.out.println("Test Case 3 - Input list: " + listToString(list3));
        System.out.println("Test Case 3 - Has cycle: " + hasCycle(list3));
    }

    /**
     * Detect a cycle in a linked list using the fast and slow pointer approach.
     * Time Complexity: O(n), where n is the number of nodes in the list.
     * Space Complexity: O(1), using constant space for the two pointers.
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize two pointers: slow (moves 1 step) and fast (moves 2 steps)
        ListNode slow = head;
        ListNode fast = head.next;

        // Traverse the list with the fast and slow pointers
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;  // No cycle if fast pointer reaches the end
            }
            slow = slow.next;       // Move slow pointer by 1 step
            fast = fast.next.next;  // Move fast pointer by 2 steps
        }

        // If slow equals fast, there is a cycle
        return true;
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
