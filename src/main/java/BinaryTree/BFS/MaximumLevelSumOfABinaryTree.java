package BinaryTree.BFS;

import java.util.LinkedList;
import java.util.Queue;

import BinaryTree.TreeNode;

/**
 * LeetCode 1161: Maximum Level Sum of a Binary Tree
 * 
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */
public class MaximumLevelSumOfABinaryTree {

    /**
     * Finds the level with maximum sum using BFS level-order traversal.
     * 
     * @param root the root of the binary tree
     * @return the smallest level number (1-indexed) with maximum sum
     */
    private int maxLevelSum(TreeNode root) {
        int maxSumLevel = 0;
        if (root == null) {
            return maxSumLevel;
        }

        // Track maximum sum and corresponding level
        int maxLevelSum = Integer.MIN_VALUE, level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // BFS level-order traversal
        while (!queue.isEmpty()) {
            level++;
            int levelSize = queue.size();
            int currentLevelSum = 0;

            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevelSum += node.val;

                // Add children for next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Update maximum sum level if current level has higher sum
            if (currentLevelSum > maxLevelSum) {
                maxLevelSum = currentLevelSum;
                maxSumLevel = level;
            }
        }

        return maxSumLevel;
    }

    public static void main(String[] args) {
        MaximumLevelSumOfABinaryTree solution = new MaximumLevelSumOfABinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(solution.maxLevelSum(root));
    }
    
}
