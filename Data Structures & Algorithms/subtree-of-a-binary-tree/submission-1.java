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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)){
            return true;
        }

        if(root.val == subRoot.val){
            return analyzeSubTree(root, subRoot);
        }
        
        return false;
    }

    private boolean analyzeSubTree(TreeNode root, TreeNode subRoot){
        // recursive function
        if(root == null || subRoot == null) return root == null && subRoot == null;
        if(root.val != subRoot.val) return false;
        
        boolean leftComparasion = analyzeSubTree(root.left, subRoot.left);
        if(!leftComparasion) return false;

        return analyzeSubTree(root.right, subRoot.right);
    }
}
