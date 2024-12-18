/*
21. Merge Two Sorted Lists
Easy
You are given the heads of two sorted linked lists list1 and list2. Merge the two lists into one sorted list, which should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
*/

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        // Test case 1:
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result1 = mergeTwoLists(list1, list2);
        System.out.println("Test Case 1 - Input list 1: " + listToString(list1));
        System.out.println("Test Case 1 - Input list 2: " + listToString(list2));
        System.out.println("Test Case 1 - Merged list: " + listToString(result1));

        // Test case 2: one empty list
        ListNode list3 = new ListNode(0);
        ListNode result2 = mergeTwoLists(null, list3);
        System.out.println("Test Case 2 - Input list 1: NULL");
        System.out.println("Test Case 2 - Input list 2: " + listToString(list3));
        System.out.println("Test Case 2 - Merged list: " + listToString(result2));

        // Test case 3: both lists empty
        ListNode result3 = mergeTwoLists(null, null);
        System.out.println("Test Case 3 - Input list 1: NULL");
        System.out.println("Test Case 3 - Input list 2: NULL");
        System.out.println("Test Case 3 - Merged list: " + listToString(result3));
    }

    /**
     * Merge Two Sorted Lists
     * Given two sorted linked lists, merge them into one sorted list by splicing together the nodes.
     * Algorithm Steps:
     * 1. Create a dummy node to help build the merged list.
     * 2. Use two pointers, one for each list, and compare the nodes.
     * 3. Append the smaller node to the merged list and move the pointer of that list.
     * 4. Continue until one of the lists is empty, then append the remaining nodes of the other list.
     * 5. Return the merged list starting from the dummy node's next.
     * Time Complexity: O(n + m) where n and m are the lengths of list1 and list2.
     * Space Complexity: O(1) since we only use constant extra space.
     */

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Pointers for traversing the lists
        ListNode current1 = list1;
        ListNode current2 = list2;

        // A dummy node to help with list construction
        ListNode dummyNode = new ListNode();
        ListNode answer = dummyNode;

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
