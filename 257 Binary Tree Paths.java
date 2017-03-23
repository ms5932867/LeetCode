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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if(root != null)
            binaryTreePaths(root, new String(""), result);
        return result;
    }
    
    private void binaryTreePaths(TreeNode root, String str, List<String> res){
        if(root.left == null && root.right == null) res.add(str + root.val);
        if(root.left != null) binaryTreePaths(root.left, new String(str + root.val + "->"), res);
        if(root.right != null) binaryTreePaths(root.right, new String(str + root.val + "->"), res);
    }
}