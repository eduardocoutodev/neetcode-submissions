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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int [] currentSum = new int [1];
        
        return dfsHasPathSum(root, targetSum, currentSum);
    }

    private boolean dfsHasPathSum(TreeNode node, int targetSum, int[] currentSum){
        if(node == null){
            return false;
        }

        currentSum[0]+=node.val;

        if(dfsHasPathSum(node.left, targetSum, currentSum)){
            return true;
        }

        if(dfsHasPathSum(node.right, targetSum, currentSum)){
            return true;
        }

        if(node.left == null && node.right == null && currentSum[0] == targetSum){
            return true;
        }

        currentSum[0]-=node.val;
        return false;
    }
}