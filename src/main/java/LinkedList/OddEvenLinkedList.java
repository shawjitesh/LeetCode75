package LinkedList;

/**
 * Solution for LeetCode 75 - Odd Even Linked List
 * Groups all odd-indexed nodes together followed by even-indexed nodes using node separation technique.
 */
public class OddEvenLinkedList {

    /**
     * Groups all odd-indexed nodes together followed by even-indexed nodes.
     * 
     * @param head the head of the linked list
     * @return the head of the modified linked list with odd nodes followed by even nodes
     */
    public ListNode oddEvenList(ListNode head) {
        // Edge case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers for odd and even positions
        ListNode odd = head;        // Points to odd-indexed nodes (1st, 3rd, 5th...)
        ListNode even = head.next;  // Points to even-indexed nodes (2nd, 4th, 6th...)
        ListNode evenHead = even;   // Store head of even list for later connection

        // Separate odd and even nodes into two lists
        while (even != null && even.next != null) {
            odd.next = even.next;   // Connect odd node to next odd node
            odd = odd.next;         // Move odd pointer forward
            even.next = odd.next;   // Connect even node to next even node
            even = even.next;       // Move even pointer forward
        }

        // Connect end of odd list to beginning of even list
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = oddEvenLinkedList.oddEvenList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println(); // Add newline at the end
    }
}
