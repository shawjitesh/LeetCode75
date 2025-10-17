package BinarySearchTree;

/**
 * Solution for deleting a node in a Binary Search Tree using iterative approach.
 * 
 * This class provides an implementation to delete a node with a given key from a BST
 * while maintaining the BST property. The solution handles all four deletion cases:
 * 1. Leaf node (no children)
 * 2. Node with only right child
 * 3. Node with only left child  
 * 4. Node with both children
 * 
 * Time Complexity: O(h) where h is the height of the tree
 * Space Complexity: O(1) - uses constant extra space
 */
public class DeleteNodeInABST {

    /**
     * Deletes a node with the given key from the BST while maintaining BST property.
     * 
     * @param root the root of the BST
     * @param key the value of the node to delete
     * @return the root of the modified BST
     */
    private TreeNode deleteNode(TreeNode root, int key) {
        // Handle empty tree case
        if (root == null) {
            return null;
        }
        
        // Find the node to delete and its parent
        TreeNode parent = null;
        TreeNode current = root;
        
        // Search for the node to delete using BST property
        while (current != null && current.val != key) {
            parent = current;
            if (key < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        
        // Node not found
        if (current == null) {
            return root;
        }
        
        // Case 1: Node to delete has no children (leaf node)
        if (current.left == null && current.right == null) {
            if (parent == null) {
                // Deleting the root node (tree has only one node)
                return null;
            }
            if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2: Node to delete has only right child
        else if (current.left == null) {
            if (parent == null) {
                // Deleting the root node
                return current.right;
            }
            if (parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        // Case 3: Node to delete has only left child
        else if (current.right == null) {
            if (parent == null) {
                // Deleting the root node
                return current.left;
            }
            if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        // Case 4: Node to delete has both children
        else {
            // Find inorder successor (smallest node in right subtree)
            TreeNode successorParent = current;
            TreeNode successor = current.right;
            
            // Go to leftmost node in right subtree
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            
            // Replace current node's value with successor's value
            current.val = successor.val;
            
            // Remove successor node
            if (successorParent == current) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
        }
        
        return root;
    }

    public static void main(String[] args) {
        DeleteNodeInABST solution = new DeleteNodeInABST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        TreeNode result = solution.deleteNode(root, 3);
        System.out.println(result.val);
    }
    
}
