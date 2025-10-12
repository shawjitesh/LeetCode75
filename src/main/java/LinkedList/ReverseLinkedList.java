package LinkedList;

/**
 * Solution for LeetCode 75 - Reverse Linked List
 * Reverses a singly linked list using iterative approach with three-pointer technique.
 */
public class ReverseLinkedList {

    /**
     * Reverses a singly linked list using iterative approach.
     * 
     * @param head the head of the linked list to reverse
     * @return the head of the reversed linked list
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;    // Previous node (starts as null)
        ListNode current = head; // Current node being processed
        
        // Iterate through the list, reversing links
        while (current != null) {
            ListNode next = current.next; // Store next node before modifying
            current.next = prev;          // Reverse the link
            prev = current;               // Move prev forward
            current = next;               // Move current forward
        }
        
        return prev; // prev becomes the new head
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = reverseLinkedList.reverseList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}
