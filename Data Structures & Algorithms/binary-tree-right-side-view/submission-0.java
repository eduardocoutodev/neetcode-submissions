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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightValuesList = new ArrayList<Integer>();

        // if node == null return
        hasAndAddRightView(root, rightValuesList, 1);
        return rightValuesList;
    }

    private void hasAndAddRightView(TreeNode node, List<Integer> rightValuesList, int level){
        if(node == null) return;

        if(rightValuesList.size() < level){
            // Add since it was not processed
            rightValuesList.add(node.val);
        }
        // prioritize right side
        hasAndAddRightView(node.right, rightValuesList, level + 1);
        hasAndAddRightView(node.left, rightValuesList, level + 1);
    }
}
