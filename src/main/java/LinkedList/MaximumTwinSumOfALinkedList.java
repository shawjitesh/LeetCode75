package LinkedList;

/**
 * Solution for Maximum Twin Sum of a Linked List problem.
 * Time: O(n), Space: O(1)
 */
public class MaximumTwinSumOfALinkedList {

    /**
     * Finds the maximum sum of twin pairs in a linked list.
     * Twin pairs are: (0th, n-1th), (1st, n-2nd), etc.
     * 
     * @param head the head of the linked list
     * @return the maximum sum of twin pairs
     */
    public int pairSum(ListNode head) {
        // Find middle using tortoise and hare algorithm
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode prev = null, current = slow;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        // Compare twin pairs and find maximum sum
        ListNode first = head, second = prev;
        int maxTwinSum = 0;
        while (second != null) {
            maxTwinSum = Math.max(maxTwinSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        
        return maxTwinSum;
    }

    public static void main(String[] args) {
        MaximumTwinSumOfALinkedList maximumTwinSumOfALinkedList = new MaximumTwinSumOfALinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        int result = maximumTwinSumOfALinkedList.pairSum(head);
        System.out.println(result);
    }
    
}
