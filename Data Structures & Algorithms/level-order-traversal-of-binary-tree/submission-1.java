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
    public List<List<Integer>> levelOrder(TreeNode root) {
        int maxHeight = maxHeight(root);

        List<List<Integer>> levelOrder = new ArrayList<>();
        for(int i = 0; i < maxHeight; i++){
            var newList = new ArrayList<Integer>();
            levelOrder.add(i, newList);
        }

        levelOrder(root, levelOrder, 0);
        return levelOrder;
    }

    public void levelOrder(TreeNode root, List<List<Integer>> levelOrder, int level) {
        if (root == null) return;

        levelOrder.get(level).add(root.val);

        levelOrder(root.left, levelOrder, level + 1);
        levelOrder(root.right, levelOrder, level + 1);
    }

    public int maxHeight(TreeNode root){
        if(root == null) return 0;

        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
