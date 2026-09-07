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
    public int diameterOfBinaryTree(TreeNode root) {
        int [] maxValue = new int[1];        

        diameterOfBinaryTree(root, maxValue);
        return maxValue[0];
    }

    public int diameterOfBinaryTree(TreeNode root, int[] maxValue){
        if(root == null) return 0;

        int leftHeight = diameterOfBinaryTree(root.left, maxValue);
        int rightHeight = diameterOfBinaryTree(root.right, maxValue);
        int diameter = leftHeight + rightHeight;

        if(diameter > maxValue[0]){
            maxValue[0] = diameter;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
