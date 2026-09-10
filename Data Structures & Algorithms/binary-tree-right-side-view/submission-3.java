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
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if(root == null) return List.of(); 

        queue.offer(root);
        while(!queue.isEmpty()){
            var currentSize = queue.size();
            for(int i=0; i < currentSize; i++){
                TreeNode current = queue.poll();
                if(i==0) rightValuesList.add(current.val);

                if(current.right != null)queue.offer(current.right);
                if(current.left != null)queue.offer(current.left);
            }
        }

        return rightValuesList;
    }

    
}
