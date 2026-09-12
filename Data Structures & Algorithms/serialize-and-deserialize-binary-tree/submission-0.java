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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDfsTree(root, sb);
        return sb.toString();
    }

    private void serializeDfsTree(TreeNode current, StringBuilder sb){
        if(current == null){
            sb.append("N,");
            return;
        }
        sb.append(String.valueOf(current.val));
        sb.append(",");
        serializeDfsTree(current.left, sb);
        serializeDfsTree(current.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = {0};
        return deserializeDfsTree(data.split(","), index);
    }

    private TreeNode deserializeDfsTree(String[] data, int[] index){
        if(data[index[0]].equals("N")){
            index[0] += 1;
            return null;
        }

        TreeNode current = new TreeNode(Integer.parseInt(data[index[0]]));
        index[0] += 1;
        current.left = deserializeDfsTree(data, index);
        current.right = deserializeDfsTree(data, index);
        return current;
    }

}
