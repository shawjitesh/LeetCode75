package BinaryTree.DFS;

import BinaryTree.TreeNode;

/**
 * Solution for Longest ZigZag Path in a Binary Tree problem.
 * Time: O(n), Space: O(h) where h is the height of the tree
 */
public class LongestZigZagPathInABinaryTree {

    private int pathLength = 0; // Track the maximum zigzag path length found

    /**
     * Finds the longest zigzag path in a binary tree.
     * A zigzag path is defined as alternating left and right directions.
     * 
     * @param root the root of the binary tree
     * @return the length of the longest zigzag path
     */
    private int longestZigZag(TreeNode root) {
        dfs(root, true, 0);  // Start with direction = left (true)
        dfs(root, false, 0); // Start with direction = right (false)
        return pathLength; 
    }

    /**
     * DFS traversal to find zigzag paths.
     * 
     * @param node the current node being processed
     * @param goLeft true if we came from right (should go left), false if we came from left (should go right)
     * @param currentLength the current zigzag path length
     */
    private void dfs(TreeNode node, boolean goLeft, int currentLength) {
        if (node == null) return;
        
        // Update maximum path length found
        this.pathLength = Math.max(this.pathLength, currentLength);
        
        if (goLeft) {
            // If we should go left, continue the zigzag path to the left
            dfs(node.left, false, currentLength + 1);
            // Start a new zigzag path to the right
            dfs(node.right, true, 1);
        } else {
            // If we should go right, continue the zigzag path to the right
            dfs(node.right, true, currentLength + 1);
            // Start a new zigzag path to the left
            dfs(node.left, false, 1);
        }
    }

    public static void main(String[] args) {
        LongestZigZagPathInABinaryTree solution = new LongestZigZagPathInABinaryTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);
        System.out.println(solution.longestZigZag(root));
    }
    
}
