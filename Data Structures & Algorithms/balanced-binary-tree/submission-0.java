/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private final int INBALANCED_TREE = -1;

    public boolean isBalanced(TreeNode root) {
        return heightOrInbalancedTree(root) != INBALANCED_TREE;
    }

    private int heightOrInbalancedTree(TreeNode node){
        if(node == null) return 0;

        // Calculate height on left
        int leftHeight = heightOrInbalancedTree(node.left);
        // If result = - 1 on some side then its not balanced
        if (leftHeight == INBALANCED_TREE) return INBALANCED_TREE;

        // Calculate height on right
        int rightHeight = heightOrInbalancedTree(node.right);
        if(rightHeight == INBALANCED_TREE) return INBALANCED_TREE;

        // Tree is inbalanced if the height between left and right > 1
        if(Math.abs(rightHeight - leftHeight) > 1) return INBALANCED_TREE;

        return 1 + Math.max(rightHeight, leftHeight);
    }
    
}
