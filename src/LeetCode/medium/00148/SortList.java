/**
 148. Sort List
 Medium
 Given the head of a linked list, return the list after sorting it in ascending order.
 */
public class SortList {
    public static void main(String[] args) {
        // Test case 1: Unsorted list
        ListNode list1 = new ListNode(4);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(1);
        list1.next.next.next = new ListNode(3);

        System.out.println("Test Case 1 - Input list: " + listToString(list1));
        ListNode sortedList1 = sortList(list1);
        System.out.println("Test Case 1 - Sorted list: " + listToString(sortedList1));

        // Test case 2: Already sorted list
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);

        System.out.println("Test Case 2 - Input list: " + listToString(list2));
        ListNode sortedList2 = sortList(list2);
        System.out.println("Test Case 2 - Sorted list: " + listToString(sortedList2));
    }

    /**
     * Sort the linked list using Merge Sort.
     * Time Complexity: O(n log n), where n is the number of nodes in the list.
     * Space Complexity: O(log n), due to recursion stack for merge sort.
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Find the middle of the list using the findMiddle method
        ListNode mid = findMiddle(head);

        // Split the list into two halves
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // Merge the two sorted halves
        return mergeTwoLists(left, right);
    }

    // Method to find the middle node of the list
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        // Traverse the list to find the middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // The slow pointer is now at the middle of the list
        ListNode mid = slow.next;
        slow.next = null;  // Split the list into two halves
        return mid;
    }

    // Helper method to merge two sorted lists
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Pointers for traversing the lists
        ListNode current1 = list1;
        ListNode current2 = list2;

        // A dummy node to help with list construction
        ListNode dummyNode = new ListNode();
        ListNode answer = dummyNode;  // This will keep track of the head of the merged list

        // Merge the two lists by comparing current nodes
        while (current1 != null && current2 != null) {
            if (current1.val < current2.val) {
                dummyNode.next = current1;  // Attach current1 node to the merged list
                current1 = current1.next;   // Move to the next node in list1
            } else {
                dummyNode.next = current2;  // Attach current2 node to the merged list
                current2 = current2.next;   // Move to the next node in list2
            }
            dummyNode = dummyNode.next;     // Move forward in the merged list
        }

        // Append any remaining nodes from list1
        while (current1 != null) {
            dummyNode.next = current1;
            current1 = current1.next;
            dummyNode = dummyNode.next;
        }

        // Append any remaining nodes from list2
        while (current2 != null) {
            dummyNode.next = current2;
            current2 = current2.next;
            dummyNode = dummyNode.next;
        }

        // Return the merged list, skipping the dummy node
        return answer.next;
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
