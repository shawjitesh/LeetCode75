package BinaryTree.DFS;

import java.util.*;

import BinaryTree.TreeNode;

/**
 * Solution for Maximum Depth of Binary Tree problem.
 * Time: O(n), Space: O(h) where h is the height of the tree
 */
public class MaximumDepthOfBinaryTree {

    /**
     * Iterative solution using stack-based DFS approach.
     * Finds the maximum depth of a binary tree.
     * 
     * @param root the root of the binary tree
     * @return the maximum depth of the tree
     */
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        // Use two stacks to track nodes and their depths
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        
        nodeStack.push(root);
        depthStack.push(1);
        
        int maxDepth = 0;
        
        while (!nodeStack.isEmpty()) {
            TreeNode current = nodeStack.pop();
            int currentDepth = depthStack.pop();
            
            maxDepth = Math.max(maxDepth, currentDepth);
            
            // Add right child first (LIFO - left will be processed first)
            if (current.right != null) {
                nodeStack.push(current.right);
                depthStack.push(currentDepth + 1);
            }
            
            if (current.left != null) {
                nodeStack.push(current.left);
                depthStack.push(currentDepth + 1);
            }
        }
        
        return maxDepth;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        int result = maximumDepthOfBinaryTree.maxDepth(root);
        System.out.println(result);
    }
}
