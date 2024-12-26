/**
 * 82. Remove Duplicates from Sorted List II
 * Medium
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        // Test case 1: List with duplicates
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next.next = new ListNode(5);

        ListNode result1 = deleteDuplicates(list1);
        System.out.println("Test Case 1 - Input list: " + listToString(list1));
        System.out.println("Test Case 1 - List after removing duplicates: " + listToString(result1));

        // Test case 2: List with no duplicates
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);

        ListNode result2 = deleteDuplicates(list2);
        System.out.println("Test Case 2 - Input list: " + listToString(list2));
        System.out.println("Test Case 2 - List after removing duplicates: " + listToString(result2));

        // Test case 3: Empty list
        ListNode result3 = deleteDuplicates(null);
        System.out.println("Test Case 3 - Input list: NULL");
        System.out.println("Test Case 3 - List after removing duplicates: " + listToString(result3));
    }

    /**
     * Remove duplicates from a sorted linked list II.
     * Given the head of a sorted linked list, delete all nodes that have duplicate numbers.
     * Algorithm Steps:
     * 1. Use a dummy node to handle edge cases where the head might be removed.
     * 2. Traverse the list with previous (prev) and current pointers.
     * 3. Skip over duplicate nodes and adjust the pointers to skip any nodes with duplicate values.
     * 4. Return the new head of the list.
     *
     * Time Complexity: O(n), where n is the length of the list.
     * Space Complexity: O(1) since we only use a constant amount of extra space.
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // Create a dummy node that helps in managing the edge cases
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;   // Previous pointer starts from dummy
        ListNode current = head;     // Current pointer starts from head

        // Traverse through the list
        while (current != null) {
            // If we detect duplicates
            if (current.next != null && current.val == current.next.val) {
                // Move current until the end of duplicates
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Skip all duplicates
                prev.next = current.next;
            } else {
                // If no duplicates, move previous pointer forward
                prev = prev.next;
            }
            // Move current pointer forward
            current = current.next;
        }

        // Return the new head of the modified list
        return dummyNode.next;
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
