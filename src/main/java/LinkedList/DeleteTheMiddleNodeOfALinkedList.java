package LinkedList;

/**
 * Solution for LeetCode 75 - Delete the Middle Node of a Linked List
 * Deletes the middle node of a linked list using the tortoise and hare (two-pointer) technique.
 */
public class DeleteTheMiddleNodeOfALinkedList {

    /**
     * Deletes the middle node of a linked list using two-pointer technique.
     * 
     * @param head the head of the linked list
     * @return the head of the modified linked list, or null if list has 0 or 1 nodes
     */
    private ListNode deleteMiddle(ListNode head) {
        // Edge case: empty list or single node
        if (head == null || head.next == null) {
            return null;
        }

        // Two pointer approach (tortoise and hare)
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // to keep track of node before middle

        // Move fast pointer 2 steps and slow pointer 1 step
        // When fast reaches end, slow will be at middle
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        prev.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        DeleteTheMiddleNodeOfALinkedList deleteTheMiddleNodeOfALinkedList = new DeleteTheMiddleNodeOfALinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = deleteTheMiddleNodeOfALinkedList.deleteMiddle(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println(); // Add newline at the end
    }
}
