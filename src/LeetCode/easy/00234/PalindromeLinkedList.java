import java.util.ArrayList;

/**
 * 234. Palindrome Linked List
 * Easy
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * A palindrome is a sequence that reads the same forward and backward.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        // Test case 1: Palindrome list
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(1);

        boolean result1 = isPalindrome(list1);
        System.out.println("Test Case 1 - Input list: " + listToString(list1));
        System.out.println("Test Case 1 - Is palindrome: " + result1);

        // Test case 2: Not a palindrome list
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);

        boolean result2 = isPalindrome(list2);
        System.out.println("Test Case 2 - Input list: " + listToString(list2));
        System.out.println("Test Case 2 - Is palindrome: " + result2);

        // Test case 3: Single node list (palindrome by default)
        ListNode list3 = new ListNode(1);

        boolean result3 = isPalindrome(list3);
        System.out.println("Test Case 3 - Input list: " + listToString(list3));
        System.out.println("Test Case 3 - Is palindrome: " + result3);
    }

    /**
     * Check if a linked list is a palindrome.
     * Steps:
     * 1. Find the middle of the list using slow and fast pointers.
     * 2. Reverse the second half of the list.
     * 3. Compare the first and second halves of the list.
     * 4. Return true if both halves are identical, otherwise return false.
     *
     * Time Complexity: O(n), where n is the length of the list.
     * Space Complexity: O(1) since we use constant extra space.
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Find the middle of the list
        ListNode middle = middleNode(head);

        // Reverse the second half of the list
        ListNode secondHalfHead = reverseList(middle);

        // Compare the first and second halves
        ListNode firstHalfHead = head;
        while (secondHalfHead != null) {
            if (firstHalfHead.val != secondHalfHead.val) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }

        return true;
    }

    /**
     * Check if a linked list is a palindrome by converting it to an array and then checking the array.
     *
     * Time Complexity: O(n), where n is the length of the list (since we traverse the list once).
     * Space Complexity: O(n) because we store the elements in an array.
     */
    public static boolean isPalindrome2(ListNode head) {
        if (head == null) return true;

        // Step 1: Convert the linked list to an ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        // Step 2: Convert the ArrayList to an Integer array
        Integer[] num = list.toArray(new Integer[list.size()]);

        // Step 3: Use two pointers to check if the array is a palindrome
        int l = 0;            // Left pointer
        int r = num.length - 1;  // Right pointer

        while (l < r) {
            // Compare values from both ends
            if (!num[l].equals(num[r])) {
                return false;  // If any mismatch, it's not a palindrome
            }
            l++;  // Move left pointer forward
            r--;  // Move right pointer backward
        }

        // If we pass through the loop without returning false, it's a palindrome
        System.out.println(list);  // Optional: print the list
        return true;
    }

    // Helper method to reverse a linked list
    public  static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        head = previous;

        return head;
    }

    public static ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Initialize two pointers: slow (moves 1 step) and fast (moves 2 steps)
        ListNode slow = head;
        ListNode fast = head;


        // Traverse the list with the fast and slow pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer by 1 step
            fast = fast.next.next;  // Move fast pointer by 2 steps
        }

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
