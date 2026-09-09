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
        record TreeNodeWithHeight(TreeNode node, int height){}

        List<List<Integer>> levelOrder = new ArrayList<>();
        Deque<TreeNodeWithHeight> treeNode = new ArrayDeque<TreeNodeWithHeight>();
        if(root != null) treeNode.offer(new TreeNodeWithHeight(root, 0));

        while(!treeNode.isEmpty()){
            TreeNodeWithHeight current = treeNode.poll();
            var currentHeight = current.height;
            var currentNode = current.node;

            if(currentHeight== levelOrder.size()){
                levelOrder.add(new ArrayList());
            }
            levelOrder.get(currentHeight).add(currentNode.val);

            if(currentNode.left != null) treeNode.offer(new TreeNodeWithHeight(currentNode.left, currentHeight + 1));
            if(currentNode.right != null) treeNode.offer(new TreeNodeWithHeight(currentNode.right, currentHeight + 1));

        }

        return levelOrder;
    }

}
