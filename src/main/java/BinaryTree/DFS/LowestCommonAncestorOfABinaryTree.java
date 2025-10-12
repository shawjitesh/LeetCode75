package BinaryTree.DFS;

import BinaryTree.TreeNode;

/**
 * Solution for LeetCode 236: Lowest Common Ancestor of a Binary Tree
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes.
 * The LCA is defined as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).
 * 
 * Time Complexity: O(n) where n is the number of nodes in the tree
 * Space Complexity: O(h) where h is the height of the tree (recursion stack)
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * Finds the lowest common ancestor of two nodes in a binary tree.
     * 
     * @param root the root of the binary tree
     * @param p the first target node
     * @param q the second target node
     * @return the lowest common ancestor of p and q, or null if not found
     */
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or if we found one of the target nodes
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Recursively search in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right are not null, current root is the LCA
        if (left != null && right != null) {
            return root;
        }
        
        // If one of them is null, return the non-null one
        // This handles the case where one node is descendant of the other
        return left != null ? left : right;
    } 

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree solution = new LowestCommonAncestorOfABinaryTree();
        
        // Example 1: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        
        System.out.println("Example 1 - LCA of 5 and 1: " + 
            solution.lowestCommonAncestor(root, root.left, root.right).val);
    }
}
