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
    public int goodNodes(TreeNode root) {
        List<TreeNode> goodNodes = new ArrayList<TreeNode>();

        goodNodes(root, goodNodes, Integer.MIN_VALUE);
        
        return goodNodes.size();
    }
    private void goodNodes(TreeNode current, List<TreeNode> goodNodes, int currentMax){
        if(current == null) return;
        if(current.val >= currentMax){
            goodNodes.add(current);
        }
        int maxValue = Math.max(currentMax, current.val);
        goodNodes(current.left, goodNodes, maxValue);
        goodNodes(current.right, goodNodes, maxValue);
    }
}
