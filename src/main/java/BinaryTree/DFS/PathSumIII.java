package BinaryTree.DFS;

import java.util.*;

import BinaryTree.TreeNode;

/**
 * LeetCode 437: Path Sum III
 * 
 * Given the root of a binary tree and an integer targetSum, return the number of paths 
 * where the sum of the values along the path equals targetSum.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go downwards 
 * (i.e., traveling only from parent nodes to child nodes).
 * 
 * This class provides three different approaches:
 * 1. Recursive approach: O(n^2) time, O(h) space
 * 2. Iterative approach: O(n^2) time, O(h) space (using stack)
 * 3. Optimized approach: O(n) time, O(h) space (using prefix sum technique)
 */
public class PathSumIII {

    
    /**
     * Iterative approach using stack to simulate recursive calls.
     * Uses a stack to keep track of nodes to process and their target sums.
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int totalCount = 0;
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            // Count paths starting from current node
            totalCount += countPathsFromNode(node, targetSum);
            
            // Add children to stack for processing
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        return totalCount;
    }
    
    /**
     * Iterative helper method to count paths starting from a specific node.
     * Uses a stack to simulate the recursive calls for exploring downward paths.
     * 
     * @param node Current node to start the path from
     * @param targetSum Target sum to achieve
     * @return Number of paths starting from this node that sum to targetSum
     */
    private int countPathsFromNode(TreeNode node, int targetSum) {
        if (node == null) {
            return 0;
        }
        
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Long> sumStack = new Stack<>();
        
        nodeStack.push(node);
        sumStack.push((long) node.val);
        
        int count = 0;
        
        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            long currentSum = sumStack.pop();
            
            // If current sum equals target sum, we found a path
            if (currentSum == targetSum) {
                count++;
            }
            
            // Add children to stack with updated target sum
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                sumStack.push(currentSum + currentNode.right.val);
            }
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                sumStack.push(currentSum + currentNode.left.val);
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        PathSumIII solution = new PathSumIII();
        int result = solution.pathSum(root, 8);
        System.out.println(result);
    }
}
