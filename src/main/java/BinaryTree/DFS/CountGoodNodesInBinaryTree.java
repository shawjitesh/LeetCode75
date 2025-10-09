package BinaryTree.DFS;

import BinaryTree.TreeNode;

/**
 * LeetCode 1448: Count Good Nodes in Binary Tree
 * A node is "good" if the path from root to that node contains no nodes with value greater than the current node.
 */
public class CountGoodNodesInBinaryTree {

    /**
     * Counts the number of good nodes in the binary tree.
     * @param root the root of the binary tree
     * @return the number of good nodes
     */
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    
    /**
     * Helper method to recursively count good nodes using DFS.
     * @param node the current node being processed
     * @param maxSoFar the maximum value seen in the path from root to current node
     * @return the number of good nodes in the subtree rooted at current node
     */
    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        
        int count = 0;
        
        // If current node is good (value >= maxSoFar)
        if (node.val >= maxSoFar) {
            count = 1;
            maxSoFar = node.val; // Update max for children
        }
        
        // Recursively count good nodes in left and right subtrees
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);
        
        return count;
    }

    public static void main(String[] args) {
        CountGoodNodesInBinaryTree solution = new CountGoodNodesInBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(solution.goodNodes(root));
    }
}
