/** 	102	Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // LinkedList extends Queue interface
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode top = queue.poll();
                cur.add(new Integer(top.val));
                if(top.left != null) queue.add(top.left);
                if(top.right != null) queue.add(top.right);
            }
            res.add(cur);
        }
        return res;
    }
}