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
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        transverseTree(root, nodes);

        return nodes.get(k - 1).val;
    }

    private void transverseTree(TreeNode current, List<TreeNode> nodes){
        if(current == null) return;

        transverseTree(current.left, nodes);
        nodes.add(current);
        transverseTree(current.right, nodes);
    }
}
