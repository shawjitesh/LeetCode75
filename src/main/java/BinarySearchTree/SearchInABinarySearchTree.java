package BinarySearchTree;

public class SearchInABinarySearchTree {

    /**
     * Searches for a node with the given value in a Binary Search Tree.
     * Uses iterative approach for efficient memory usage.
     * 
     * @param root the root node of the BST
     * @param val the value to search for
     * @return the node containing the value, or null if not found
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode currentNode = root;
        while (currentNode != null) {
            if(val == currentNode.val) {
                return currentNode; // Found the target
            } else if (val < currentNode.val) {
                currentNode = currentNode.left; // Search left subtree
            } else {
                currentNode = currentNode.right; // Search right subtree
            }
        }

        return null; // Value not found
    }

    public static void main(String[] args) {
        SearchInABinarySearchTree solution = new SearchInABinarySearchTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode result = solution.searchBST(root, 2);
        System.out.println(result.val);
    }
    
}
