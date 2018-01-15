/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        Helper(root);
        return root;
    }
    
    private void Helper(TreeNode root){
        if(root == null) return;
        Helper(root.left);
        Helper(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
    }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll(),
                     tmp = current.left;
            current.left = current.right;
            current.right = tmp;
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return root;
    }
}