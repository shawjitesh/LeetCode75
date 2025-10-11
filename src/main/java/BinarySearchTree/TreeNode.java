package BinarySearchTree;

/**
 * Definition for a binary tree node.
 * Used for binary tree problems in LeetCode solutions.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    /**
     * Default constructor - creates a node with val = 0, left = null, right = null
     */
    public TreeNode() {}

    /**
     * Constructor with value only
     * @param val the value of the node
     */
    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * Full constructor with value and children
     * @param val the value of the node
     * @param left the left child node
     * @param right the right child node
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
