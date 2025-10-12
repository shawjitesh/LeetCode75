package BinaryTree.DFS;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.TreeNode;

/**
 * LeetCode 872: Leaf-Similar Trees
 * Two binary trees are considered leaf-similar if they have the same leaf value sequence.
 */
public class LeafSimilarTrees {

    /**
     * Determines if two binary trees are leaf-similar.
     * @param root1 the root of the first binary tree
     * @param root2 the root of the second binary tree
     * @return true if both trees have the same leaf value sequence, false otherwise
     */
    private boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Get leaf sequences for both trees
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        // Traverse both trees to collect leaves
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        
        // Compare the sequences
        return leaves1.equals(leaves2);
    }
    
    /**
     * Helper method to collect leaf values using DFS traversal.
     * @param node the current node being processed
     * @param leaves the list to store leaf values
     */
    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        
        // If it's a leaf node (no children)
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        
        // Recursively traverse left and right subtrees
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }

    public static void main(String[] args) {
        LeafSimilarTrees solution = new LeafSimilarTrees();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(solution.leafSimilar(root1, root2));
    }
}
