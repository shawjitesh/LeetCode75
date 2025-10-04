package LinkedList;

/**
 * Definition for singly-linked list node.
 * This is a shared ListNode class for all LinkedList problems.
 */
public class ListNode {
    
    public int val;
    public ListNode next;

    /**
     * Default constructor
     */
    public ListNode() {}
    
    /**
     * Constructor with value
     * @param val the value of the node
     */
    public ListNode(int val) {
        this.val = val;
    }

    /**
     * Constructor with value and next node
     * @param val the value of the node
     * @param next the next node in the list
     */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
