/* 	101	Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root.left);
        que.add(root.right);
        while(!que.isEmpty()){
            TreeNode t1 = que.poll(),
                     t2 = que.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            que.add(t1.left);
            que.add(t2.right);
            que.add(t1.right);
            que.add(t2.left);
        }
        return true;
    }
    
    
}