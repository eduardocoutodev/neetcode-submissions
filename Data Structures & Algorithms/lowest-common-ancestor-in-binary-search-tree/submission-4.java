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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Create method to check if an element is on a sub tree
        // The method can return true for an equal element
        Stack<TreeNode> stack = new Stack<TreeNode>();

        // Find a way to iterate the lowest common ancestor in binary tree
        // Perhaps a queue that will hold the common ancestor and will push to it every time
        if (isElementOnSubTree(root, p) && isElementOnSubTree(root, q)) {
            stack.add(root);
            lowestCommonAncestor(root, stack, p, q);
        }

        return stack.pop();
    }

    private void lowestCommonAncestor(
        TreeNode node, Stack<TreeNode> stack, TreeNode p, TreeNode q) {
        if (node == null)
            return;

        if (isElementOnSubTree(node.left, p) && isElementOnSubTree(node.left, q)) {
            stack.add(node.left);
            lowestCommonAncestor(node.left, stack, p, q);
        }

        if (isElementOnSubTree(node.right, p) && isElementOnSubTree(node.right, q)) {
            stack.add(node.right);
            lowestCommonAncestor(node.right, stack, p, q);
        }
    }

    private boolean isElementOnSubTree(TreeNode root, TreeNode target) {
        if (root == null)
            return false;
        if (root.val == target.val)
            return true;

        if (root.val > target.val) {
            return isElementOnSubTree(root.left, target);
        } else {
            return isElementOnSubTree(root.right, target);
        }
    }
}
