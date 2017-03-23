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
    
    public int rob(TreeNode root) {
        int[] ans = robHelper(root);
        return Math.max(ans[0], ans[1]);
    }
    
    private int[] robHelper(TreeNode root){
        // return[0] = max money if root is robbed
        // return[1] = max money if root is NOT robbed
        if(root == null) {return new int[2];} // boundary condition
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        int[] ans = new int[2];
        ans[0] = root.val + left[1] + right[1];
        ans[1] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        return ans;
    }
}